package pckg_serial_deserial;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SerDeserial implements java.io.Serializable {



    /**
     * This method serializes a list of objects into a file
     * @param fileName
     * @param elements
     * @param <E> any class that implements Serializable
     * @see java.io.Serializable
     */
    public static <E> void saveObjects2File(String fileName, List<E> elements, boolean append) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName, append))) {
            for (E element : elements) {
                oos.writeObject(element);
            }
            System.out.println("All elements are stored into the file!");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static <E> void saveElements2File (String fileName, List<E> elements) {
        if (checkBinFile(fileName)) {
            // appending to existing non-empty file
            try (ObjectOutputStream oos = new AppendableObjectOutputStream(new FileOutputStream(fileName, true))) {
                for (E element : elements) {
                    oos.writeObject(element);
                }
                System.out.println("All elements are stored into the file!");
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Elements are appended to the existing file!");
        } else {
            // creating new file
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
                for (E element : elements) {
                    oos.writeObject(element);
                }
                System.out.println("All elements are stored into the file!");
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Elements are stored into the new file!");
        }
    }

    public static boolean checkBinFile(String fileName) {
        boolean status = false;
        if (fileName.endsWith(".bin")) {
            File file = new File(fileName);
            status = file.exists() && file.length() > 0;
        }

        return status;
    }



    public static <E> List<E> readObjectsFromFile(String fileName) {
        List<E> elementsFromFile = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            while (true) {
                E element = (E) ois.readObject();
                elementsFromFile.add(element);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (EOFException e) {
            System.out.println("End of file reached!");
            return elementsFromFile;
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    private static class AppendableObjectOutputStream extends ObjectOutputStream {

        public AppendableObjectOutputStream(OutputStream out) throws IOException {
            super(out);
        }

        @Override
        protected void writeStreamHeader() throws IOException {
            reset();
        }
    }
}
