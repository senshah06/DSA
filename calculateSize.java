// Calculate filesystem size
public interface FileSystemSizeCalculator {
    long calculateSize(String path);
}
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class FileSystemSizeCalculatorImpl implements FileSystemSizeCalculator {
    @Override
    public long calculateSize(String path) {
        Path startPath = Paths.get(path);
        try {
            return Files.walk(startPath)
                        .filter(Files::isRegularFile)
                        .mapToLong(p -> {
                            try {
                                return Files.size(p);
                            } catch (IOException e) {
                                System.err.println("Error reading file size: " + p);
                                return 0;
                            }
                        })
                        .sum();
        } catch (IOException e) {
            System.err.println("Error walking file tree: " + e.getMessage());
            return 0;
        }
    }
}
public class Main {
    public static void main(String[] args) {
        FileSystemSizeCalculator calculator = new FileSystemSizeCalculatorImpl();
        String path = "C:/your/directory/path"; // Replace with your directory path
        long totalSize = calculator.calculateSize(path);
        System.out.println("Total size of the filesystem: " + totalSize + " bytes");
    }
}

//---------------------------------------------------------------------------------------------------------------------------

// without walk
public interface FileSystemSizeCalculator {
    long calculateSize(String path);
}

import java.io.File;

public class FileSystemSizeCalculatorImpl implements FileSystemSizeCalculator {
    @Override
    public long calculateSize(String path) {
        File directory = new File(path);
        return calculateDirectorySize(directory);
    }

    private long calculateDirectorySize(File directory) {
        long totalSize = 0;

        // Get all files and directories in the current directory
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    totalSize += file.length();
                } else if (file.isDirectory()) {
                    totalSize += calculateDirectorySize(file);
                }
            }
        }

        return totalSize;
    }
}

public class Main {
    public static void main(String[] args) {
        FileSystemSizeCalculator calculator = new FileSystemSizeCalculatorImpl();
        String path = "C:/your/directory/path"; // Replace with your directory path
        long totalSize = calculator.calculateSize(path);
        System.out.println("Total size of the filesystem: " + totalSize + " bytes");
    }
}

