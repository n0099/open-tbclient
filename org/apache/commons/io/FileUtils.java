package org.apache.commons.io;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.math.BigInteger;
import java.net.URL;
import java.net.URLConnection;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.zip.CRC32;
import java.util.zip.CheckedInputStream;
import java.util.zip.Checksum;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.FalseFileFilter;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.IOFileFilter;
import org.apache.commons.io.filefilter.SuffixFileFilter;
import org.apache.commons.io.filefilter.TrueFileFilter;
import org.apache.commons.io.output.NullOutputStream;
/* loaded from: classes.dex */
public class FileUtils {
    private static final long FILE_COPY_BUFFER_SIZE = 31457280;
    public static final long ONE_GB = 1073741824;
    public static final long ONE_MB = 1048576;
    public static final long ONE_PB = 1125899906842624L;
    public static final long ONE_TB = 1099511627776L;
    public static final long ONE_KB = 1024;
    public static final BigInteger ONE_KB_BI = BigInteger.valueOf(ONE_KB);
    public static final BigInteger ONE_MB_BI = ONE_KB_BI.multiply(ONE_KB_BI);
    public static final BigInteger ONE_GB_BI = ONE_KB_BI.multiply(ONE_MB_BI);
    public static final BigInteger ONE_TB_BI = ONE_KB_BI.multiply(ONE_GB_BI);
    public static final BigInteger ONE_PB_BI = ONE_KB_BI.multiply(ONE_TB_BI);
    public static final BigInteger ONE_EB_BI = ONE_KB_BI.multiply(ONE_PB_BI);
    public static final long ONE_EB = 1152921504606846976L;
    public static final BigInteger ONE_ZB = BigInteger.valueOf(ONE_KB).multiply(BigInteger.valueOf(ONE_EB));
    public static final BigInteger ONE_YB = ONE_KB_BI.multiply(ONE_ZB);
    public static final File[] EMPTY_FILE_ARRAY = new File[0];
    private static final Charset UTF8 = Charset.forName("UTF-8");

    public static File getFile(File file, String... strArr) {
        if (file == null) {
            throw new NullPointerException("directorydirectory must not be null");
        }
        if (strArr == null) {
            throw new NullPointerException("names must not be null");
        }
        int length = strArr.length;
        int i = 0;
        while (i < length) {
            i++;
            file = new File(file, strArr[i]);
        }
        return file;
    }

    public static File getFile(String... strArr) {
        File file;
        if (strArr == null) {
            throw new NullPointerException("names must not be null");
        }
        int length = strArr.length;
        File file2 = null;
        int i = 0;
        while (i < length) {
            String str = strArr[i];
            if (file2 == null) {
                file = new File(str);
            } else {
                file = new File(file2, str);
            }
            i++;
            file2 = file;
        }
        return file2;
    }

    public static String getTempDirectoryPath() {
        return System.getProperty("java.io.tmpdir");
    }

    public static File getTempDirectory() {
        return new File(getTempDirectoryPath());
    }

    public static String getUserDirectoryPath() {
        return System.getProperty("user.home");
    }

    public static File getUserDirectory() {
        return new File(getUserDirectoryPath());
    }

    public static FileInputStream openInputStream(File file) {
        if (file.exists()) {
            if (file.isDirectory()) {
                throw new IOException("File '" + file + "' exists but is a directory");
            }
            if (!file.canRead()) {
                throw new IOException("File '" + file + "' cannot be read");
            }
            return new FileInputStream(file);
        }
        throw new FileNotFoundException("File '" + file + "' does not exist");
    }

    public static FileOutputStream openOutputStream(File file) {
        return openOutputStream(file, false);
    }

    public static FileOutputStream openOutputStream(File file, boolean z) {
        if (file.exists()) {
            if (file.isDirectory()) {
                throw new IOException("File '" + file + "' exists but is a directory");
            }
            if (!file.canWrite()) {
                throw new IOException("File '" + file + "' cannot be written to");
            }
        } else {
            File parentFile = file.getParentFile();
            if (parentFile != null && !parentFile.mkdirs() && !parentFile.isDirectory()) {
                throw new IOException("Directory '" + parentFile + "' could not be created");
            }
        }
        return new FileOutputStream(file, z);
    }

    public static String byteCountToDisplaySize(BigInteger bigInteger) {
        if (bigInteger.divide(ONE_EB_BI).compareTo(BigInteger.ZERO) > 0) {
            return String.valueOf(bigInteger.divide(ONE_EB_BI)) + " EB";
        }
        if (bigInteger.divide(ONE_PB_BI).compareTo(BigInteger.ZERO) > 0) {
            return String.valueOf(bigInteger.divide(ONE_PB_BI)) + " PB";
        }
        if (bigInteger.divide(ONE_TB_BI).compareTo(BigInteger.ZERO) > 0) {
            return String.valueOf(bigInteger.divide(ONE_TB_BI)) + " TB";
        }
        if (bigInteger.divide(ONE_GB_BI).compareTo(BigInteger.ZERO) > 0) {
            return String.valueOf(bigInteger.divide(ONE_GB_BI)) + " GB";
        }
        if (bigInteger.divide(ONE_MB_BI).compareTo(BigInteger.ZERO) > 0) {
            return String.valueOf(bigInteger.divide(ONE_MB_BI)) + " MB";
        }
        if (bigInteger.divide(ONE_KB_BI).compareTo(BigInteger.ZERO) > 0) {
            return String.valueOf(bigInteger.divide(ONE_KB_BI)) + " KB";
        }
        return String.valueOf(bigInteger) + " bytes";
    }

    public static String byteCountToDisplaySize(long j) {
        return byteCountToDisplaySize(BigInteger.valueOf(j));
    }

    public static void touch(File file) {
        if (!file.exists()) {
            IOUtils.closeQuietly((OutputStream) openOutputStream(file));
        }
        if (!file.setLastModified(System.currentTimeMillis())) {
            throw new IOException("Unable to set the last modification time for " + file);
        }
    }

    public static File[] convertFileCollectionToFileArray(Collection<File> collection) {
        return (File[]) collection.toArray(new File[collection.size()]);
    }

    private static void innerListFiles(Collection<File> collection, File file, IOFileFilter iOFileFilter, boolean z) {
        File[] listFiles = file.listFiles((FileFilter) iOFileFilter);
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    if (z) {
                        collection.add(file2);
                    }
                    innerListFiles(collection, file2, iOFileFilter, z);
                } else {
                    collection.add(file2);
                }
            }
        }
    }

    public static Collection<File> listFiles(File file, IOFileFilter iOFileFilter, IOFileFilter iOFileFilter2) {
        validateListFilesParameters(file, iOFileFilter);
        IOFileFilter upEffectiveFileFilter = setUpEffectiveFileFilter(iOFileFilter);
        IOFileFilter upEffectiveDirFilter = setUpEffectiveDirFilter(iOFileFilter2);
        LinkedList linkedList = new LinkedList();
        innerListFiles(linkedList, file, FileFilterUtils.or(upEffectiveFileFilter, upEffectiveDirFilter), false);
        return linkedList;
    }

    private static void validateListFilesParameters(File file, IOFileFilter iOFileFilter) {
        if (!file.isDirectory()) {
            throw new IllegalArgumentException("Parameter 'directory' is not a directory");
        }
        if (iOFileFilter == null) {
            throw new NullPointerException("Parameter 'fileFilter' is null");
        }
    }

    private static IOFileFilter setUpEffectiveFileFilter(IOFileFilter iOFileFilter) {
        return FileFilterUtils.and(iOFileFilter, FileFilterUtils.notFileFilter(DirectoryFileFilter.INSTANCE));
    }

    private static IOFileFilter setUpEffectiveDirFilter(IOFileFilter iOFileFilter) {
        return iOFileFilter == null ? FalseFileFilter.INSTANCE : FileFilterUtils.and(iOFileFilter, DirectoryFileFilter.INSTANCE);
    }

    public static Collection<File> listFilesAndDirs(File file, IOFileFilter iOFileFilter, IOFileFilter iOFileFilter2) {
        validateListFilesParameters(file, iOFileFilter);
        IOFileFilter upEffectiveFileFilter = setUpEffectiveFileFilter(iOFileFilter);
        IOFileFilter upEffectiveDirFilter = setUpEffectiveDirFilter(iOFileFilter2);
        LinkedList linkedList = new LinkedList();
        if (file.isDirectory()) {
            linkedList.add(file);
        }
        innerListFiles(linkedList, file, FileFilterUtils.or(upEffectiveFileFilter, upEffectiveDirFilter), true);
        return linkedList;
    }

    public static Iterator<File> iterateFiles(File file, IOFileFilter iOFileFilter, IOFileFilter iOFileFilter2) {
        return listFiles(file, iOFileFilter, iOFileFilter2).iterator();
    }

    public static Iterator<File> iterateFilesAndDirs(File file, IOFileFilter iOFileFilter, IOFileFilter iOFileFilter2) {
        return listFilesAndDirs(file, iOFileFilter, iOFileFilter2).iterator();
    }

    private static String[] toSuffixes(String[] strArr) {
        String[] strArr2 = new String[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            strArr2[i] = "." + strArr[i];
        }
        return strArr2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [org.apache.commons.io.filefilter.IOFileFilter] */
    public static Collection<File> listFiles(File file, String[] strArr, boolean z) {
        SuffixFileFilter suffixFileFilter;
        if (strArr == null) {
            suffixFileFilter = TrueFileFilter.INSTANCE;
        } else {
            suffixFileFilter = new SuffixFileFilter(toSuffixes(strArr));
        }
        return listFiles(file, suffixFileFilter, z ? TrueFileFilter.INSTANCE : FalseFileFilter.INSTANCE);
    }

    public static Iterator<File> iterateFiles(File file, String[] strArr, boolean z) {
        return listFiles(file, strArr, z).iterator();
    }

    public static boolean contentEquals(File file, File file2) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        boolean exists = file.exists();
        if (exists != file2.exists()) {
            return false;
        }
        if (!exists) {
            return true;
        }
        if (file.isDirectory() || file2.isDirectory()) {
            throw new IOException("Can't compare directories, only files");
        }
        if (file.length() != file2.length()) {
            return false;
        }
        if (file.getCanonicalFile().equals(file2.getCanonicalFile())) {
            return true;
        }
        try {
            FileInputStream fileInputStream3 = new FileInputStream(file);
            try {
                fileInputStream = new FileInputStream(file2);
            } catch (Throwable th) {
                th = th;
                fileInputStream = null;
                fileInputStream2 = fileInputStream3;
            }
            try {
                boolean contentEquals = IOUtils.contentEquals(fileInputStream3, fileInputStream);
                IOUtils.closeQuietly((InputStream) fileInputStream3);
                IOUtils.closeQuietly((InputStream) fileInputStream);
                return contentEquals;
            } catch (Throwable th2) {
                th = th2;
                fileInputStream2 = fileInputStream3;
                IOUtils.closeQuietly((InputStream) fileInputStream2);
                IOUtils.closeQuietly((InputStream) fileInputStream);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:27:0x0073 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:29:0x0032 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v4, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.io.Reader] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v9, types: [java.io.Reader] */
    public static boolean contentEqualsIgnoreEOL(File file, File file2, String str) {
        InputStreamReader inputStreamReader = null;
        boolean exists = file.exists();
        if (exists != file2.exists()) {
            return false;
        }
        if (exists) {
            if (file.isDirectory() || file2.isDirectory()) {
                throw new IOException("Can't compare directories, only files");
            }
            InputStreamReader equals = file.getCanonicalFile().equals(file2.getCanonicalFile());
            if (equals == 0) {
                try {
                    try {
                        if (str == null) {
                            InputStreamReader inputStreamReader2 = new InputStreamReader(new FileInputStream(file));
                            inputStreamReader = new InputStreamReader(new FileInputStream(file2));
                            equals = inputStreamReader2;
                        } else {
                            InputStreamReader inputStreamReader3 = new InputStreamReader(new FileInputStream(file), str);
                            inputStreamReader = new InputStreamReader(new FileInputStream(file2), str);
                            equals = inputStreamReader3;
                        }
                        boolean contentEqualsIgnoreEOL = IOUtils.contentEqualsIgnoreEOL(equals, inputStreamReader);
                        IOUtils.closeQuietly((Reader) equals);
                        IOUtils.closeQuietly((Reader) inputStreamReader);
                        return contentEqualsIgnoreEOL;
                    } catch (Throwable th) {
                        th = th;
                        IOUtils.closeQuietly((Reader) equals);
                        IOUtils.closeQuietly((Reader) inputStreamReader);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    equals = inputStreamReader;
                    IOUtils.closeQuietly((Reader) equals);
                    IOUtils.closeQuietly((Reader) inputStreamReader);
                    throw th;
                }
            }
            return true;
        }
        return true;
    }

    public static File toFile(URL url) {
        if (url == null || !"file".equalsIgnoreCase(url.getProtocol())) {
            return null;
        }
        return new File(decodeUrl(url.getFile().replace(IOUtils.DIR_SEPARATOR_UNIX, File.separatorChar)));
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE]}, finally: {[INVOKE, INVOKE, SGET, INVOKE, INVOKE, INVOKE, INVOKE, IF] complete} */
    static String decodeUrl(String str) {
        if (str != null && str.indexOf(37) >= 0) {
            int length = str.length();
            StringBuffer stringBuffer = new StringBuffer();
            ByteBuffer allocate = ByteBuffer.allocate(length);
            int i = 0;
            while (i < length) {
                if (str.charAt(i) == '%') {
                    do {
                        try {
                            allocate.put((byte) Integer.parseInt(str.substring(i + 1, i + 3), 16));
                            i += 3;
                            if (i >= length) {
                                break;
                            }
                        } catch (RuntimeException e) {
                            if (allocate.position() > 0) {
                                allocate.flip();
                                stringBuffer.append(UTF8.decode(allocate).toString());
                                allocate.clear();
                            }
                        } catch (Throwable th) {
                            if (allocate.position() > 0) {
                                allocate.flip();
                                stringBuffer.append(UTF8.decode(allocate).toString());
                                allocate.clear();
                            }
                            throw th;
                        }
                    } while (str.charAt(i) == '%');
                    if (allocate.position() > 0) {
                        allocate.flip();
                        stringBuffer.append(UTF8.decode(allocate).toString());
                        allocate.clear();
                    }
                }
                stringBuffer.append(str.charAt(i));
                i++;
            }
            return stringBuffer.toString();
        }
        return str;
    }

    public static File[] toFiles(URL[] urlArr) {
        if (urlArr == null || urlArr.length == 0) {
            return EMPTY_FILE_ARRAY;
        }
        File[] fileArr = new File[urlArr.length];
        for (int i = 0; i < urlArr.length; i++) {
            URL url = urlArr[i];
            if (url != null) {
                if (!url.getProtocol().equals("file")) {
                    throw new IllegalArgumentException("URL could not be converted to a File: " + url);
                }
                fileArr[i] = toFile(url);
            }
        }
        return fileArr;
    }

    public static URL[] toURLs(File[] fileArr) {
        URL[] urlArr = new URL[fileArr.length];
        for (int i = 0; i < urlArr.length; i++) {
            urlArr[i] = fileArr[i].toURI().toURL();
        }
        return urlArr;
    }

    public static void copyFileToDirectory(File file, File file2) {
        copyFileToDirectory(file, file2, true);
    }

    public static void copyFileToDirectory(File file, File file2, boolean z) {
        if (file2 == null) {
            throw new NullPointerException("Destination must not be null");
        }
        if (file2.exists() && !file2.isDirectory()) {
            throw new IllegalArgumentException("Destination '" + file2 + "' is not a directory");
        }
        copyFile(file, new File(file2, file.getName()), z);
    }

    public static void copyFile(File file, File file2) {
        copyFile(file, file2, true);
    }

    public static void copyFile(File file, File file2, boolean z) {
        if (file == null) {
            throw new NullPointerException("Source must not be null");
        }
        if (file2 == null) {
            throw new NullPointerException("Destination must not be null");
        }
        if (!file.exists()) {
            throw new FileNotFoundException("Source '" + file + "' does not exist");
        }
        if (file.isDirectory()) {
            throw new IOException("Source '" + file + "' exists but is a directory");
        }
        if (file.getCanonicalPath().equals(file2.getCanonicalPath())) {
            throw new IOException("Source '" + file + "' and destination '" + file2 + "' are the same");
        }
        File parentFile = file2.getParentFile();
        if (parentFile != null && !parentFile.mkdirs() && !parentFile.isDirectory()) {
            throw new IOException("Destination '" + parentFile + "' directory cannot be created");
        }
        if (file2.exists() && !file2.canWrite()) {
            throw new IOException("Destination '" + file2 + "' exists but is read-only");
        }
        doCopyFile(file, file2, z);
    }

    public static long copyFile(File file, OutputStream outputStream) {
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            return IOUtils.copyLarge(fileInputStream, outputStream);
        } finally {
            fileInputStream.close();
        }
    }

    private static void doCopyFile(File file, File file2, boolean z) {
        FileChannel fileChannel;
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream;
        FileChannel channel;
        FileChannel fileChannel2 = null;
        if (file2.exists() && file2.isDirectory()) {
            throw new IOException("Destination '" + file2 + "' exists but is a directory");
        }
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file2);
                try {
                    FileChannel channel2 = fileInputStream2.getChannel();
                    try {
                        channel = fileOutputStream2.getChannel();
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream = fileOutputStream2;
                        fileInputStream = fileInputStream2;
                        fileChannel2 = channel2;
                        fileChannel = null;
                    }
                    try {
                        long size = channel2.size();
                        for (long j = 0; j < size; j += channel.transferFrom(channel2, j, size - j > FILE_COPY_BUFFER_SIZE ? 31457280L : size - j)) {
                        }
                        IOUtils.closeQuietly(channel);
                        IOUtils.closeQuietly((OutputStream) fileOutputStream2);
                        IOUtils.closeQuietly(channel2);
                        IOUtils.closeQuietly((InputStream) fileInputStream2);
                        if (file.length() != file2.length()) {
                            throw new IOException("Failed to copy full contents from '" + file + "' to '" + file2 + "'");
                        }
                        if (z) {
                            file2.setLastModified(file.lastModified());
                        }
                    } catch (Throwable th2) {
                        fileOutputStream = fileOutputStream2;
                        fileInputStream = fileInputStream2;
                        fileChannel = channel;
                        th = th2;
                        fileChannel2 = channel2;
                        IOUtils.closeQuietly(fileChannel);
                        IOUtils.closeQuietly((OutputStream) fileOutputStream);
                        IOUtils.closeQuietly(fileChannel2);
                        IOUtils.closeQuietly((InputStream) fileInputStream);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    fileChannel = null;
                    fileOutputStream = fileOutputStream2;
                    fileInputStream = fileInputStream2;
                }
            } catch (Throwable th4) {
                th = th4;
                fileChannel = null;
                fileOutputStream = null;
                fileInputStream = fileInputStream2;
            }
        } catch (Throwable th5) {
            th = th5;
            fileChannel = null;
            fileOutputStream = null;
            fileInputStream = null;
        }
    }

    public static void copyDirectoryToDirectory(File file, File file2) {
        if (file == null) {
            throw new NullPointerException("Source must not be null");
        }
        if (file.exists() && !file.isDirectory()) {
            throw new IllegalArgumentException("Source '" + file2 + "' is not a directory");
        }
        if (file2 == null) {
            throw new NullPointerException("Destination must not be null");
        }
        if (file2.exists() && !file2.isDirectory()) {
            throw new IllegalArgumentException("Destination '" + file2 + "' is not a directory");
        }
        copyDirectory(file, new File(file2, file.getName()), true);
    }

    public static void copyDirectory(File file, File file2) {
        copyDirectory(file, file2, true);
    }

    public static void copyDirectory(File file, File file2, boolean z) {
        copyDirectory(file, file2, null, z);
    }

    public static void copyDirectory(File file, File file2, FileFilter fileFilter) {
        copyDirectory(file, file2, fileFilter, true);
    }

    public static void copyDirectory(File file, File file2, FileFilter fileFilter, boolean z) {
        if (file == null) {
            throw new NullPointerException("Source must not be null");
        }
        if (file2 == null) {
            throw new NullPointerException("Destination must not be null");
        }
        if (!file.exists()) {
            throw new FileNotFoundException("Source '" + file + "' does not exist");
        }
        if (!file.isDirectory()) {
            throw new IOException("Source '" + file + "' exists but is not a directory");
        }
        if (file.getCanonicalPath().equals(file2.getCanonicalPath())) {
            throw new IOException("Source '" + file + "' and destination '" + file2 + "' are the same");
        }
        ArrayList arrayList = null;
        if (file2.getCanonicalPath().startsWith(file.getCanonicalPath())) {
            File[] listFiles = fileFilter == null ? file.listFiles() : file.listFiles(fileFilter);
            if (listFiles != null && listFiles.length > 0) {
                arrayList = new ArrayList(listFiles.length);
                for (File file3 : listFiles) {
                    arrayList.add(new File(file2, file3.getName()).getCanonicalPath());
                }
            }
        }
        doCopyDirectory(file, file2, fileFilter, z, arrayList);
    }

    private static void doCopyDirectory(File file, File file2, FileFilter fileFilter, boolean z, List<String> list) {
        File[] listFiles = fileFilter == null ? file.listFiles() : file.listFiles(fileFilter);
        if (listFiles == null) {
            throw new IOException("Failed to list contents of " + file);
        }
        if (file2.exists()) {
            if (!file2.isDirectory()) {
                throw new IOException("Destination '" + file2 + "' exists but is not a directory");
            }
        } else if (!file2.mkdirs() && !file2.isDirectory()) {
            throw new IOException("Destination '" + file2 + "' directory cannot be created");
        }
        if (!file2.canWrite()) {
            throw new IOException("Destination '" + file2 + "' cannot be written to");
        }
        for (File file3 : listFiles) {
            File file4 = new File(file2, file3.getName());
            if (list == null || !list.contains(file3.getCanonicalPath())) {
                if (file3.isDirectory()) {
                    doCopyDirectory(file3, file4, fileFilter, z, list);
                } else {
                    doCopyFile(file3, file4, z);
                }
            }
        }
        if (z) {
            file2.setLastModified(file.lastModified());
        }
    }

    public static void copyURLToFile(URL url, File file) {
        copyInputStreamToFile(url.openStream(), file);
    }

    public static void copyURLToFile(URL url, File file, int i, int i2) {
        URLConnection openConnection = url.openConnection();
        openConnection.setConnectTimeout(i);
        openConnection.setReadTimeout(i2);
        copyInputStreamToFile(openConnection.getInputStream(), file);
    }

    public static void copyInputStreamToFile(InputStream inputStream, File file) {
        try {
            FileOutputStream openOutputStream = openOutputStream(file);
            IOUtils.copy(inputStream, openOutputStream);
            openOutputStream.close();
            IOUtils.closeQuietly((OutputStream) openOutputStream);
        } finally {
            IOUtils.closeQuietly(inputStream);
        }
    }

    public static void deleteDirectory(File file) {
        if (file.exists()) {
            if (!isSymlink(file)) {
                cleanDirectory(file);
            }
            if (!file.delete()) {
                throw new IOException("Unable to delete directory " + file + ".");
            }
        }
    }

    public static boolean deleteQuietly(File file) {
        if (file == null) {
            return false;
        }
        try {
            if (file.isDirectory()) {
                cleanDirectory(file);
            }
        } catch (Exception e) {
        }
        try {
            return file.delete();
        } catch (Exception e2) {
            return false;
        }
    }

    public static boolean directoryContains(File file, File file2) {
        if (file == null) {
            throw new IllegalArgumentException("Directory must not be null");
        }
        if (!file.isDirectory()) {
            throw new IllegalArgumentException("Not a directory: " + file);
        }
        if (file2 != null && file.exists() && file2.exists()) {
            return FilenameUtils.directoryContains(file.getCanonicalPath(), file2.getCanonicalPath());
        }
        return false;
    }

    public static void cleanDirectory(File file) {
        if (!file.exists()) {
            throw new IllegalArgumentException(file + " does not exist");
        }
        if (!file.isDirectory()) {
            throw new IllegalArgumentException(file + " is not a directory");
        }
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            throw new IOException("Failed to list contents of " + file);
        }
        IOException e = null;
        for (File file2 : listFiles) {
            try {
                forceDelete(file2);
            } catch (IOException e2) {
                e = e2;
            }
        }
        if (e != null) {
            throw e;
        }
    }

    public static boolean waitFor(File file, int i) {
        int i2 = 0;
        int i3 = 0;
        while (!file.exists()) {
            int i4 = i2 + 1;
            if (i2 >= 10) {
                int i5 = i3 + 1;
                if (i3 > i) {
                    return false;
                }
                i3 = i5;
                i2 = 0;
            } else {
                i2 = i4;
            }
            try {
                Thread.sleep(100L);
            } catch (InterruptedException e) {
            } catch (Exception e2) {
            }
        }
        return true;
    }

    public static String readFileToString(File file, Charset charset) {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = openInputStream(file);
            return IOUtils.toString(fileInputStream, Charsets.toCharset(charset));
        } finally {
            IOUtils.closeQuietly((InputStream) fileInputStream);
        }
    }

    public static String readFileToString(File file, String str) {
        return readFileToString(file, Charsets.toCharset(str));
    }

    public static String readFileToString(File file) {
        return readFileToString(file, Charset.defaultCharset());
    }

    public static byte[] readFileToByteArray(File file) {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = openInputStream(file);
            return IOUtils.toByteArray(fileInputStream, file.length());
        } finally {
            IOUtils.closeQuietly((InputStream) fileInputStream);
        }
    }

    public static List<String> readLines(File file, Charset charset) {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = openInputStream(file);
            return IOUtils.readLines(fileInputStream, Charsets.toCharset(charset));
        } finally {
            IOUtils.closeQuietly((InputStream) fileInputStream);
        }
    }

    public static List<String> readLines(File file, String str) {
        return readLines(file, Charsets.toCharset(str));
    }

    public static List<String> readLines(File file) {
        return readLines(file, Charset.defaultCharset());
    }

    public static LineIterator lineIterator(File file, String str) {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = openInputStream(file);
            return IOUtils.lineIterator(fileInputStream, str);
        } catch (IOException e) {
            IOUtils.closeQuietly((InputStream) fileInputStream);
            throw e;
        } catch (RuntimeException e2) {
            IOUtils.closeQuietly((InputStream) fileInputStream);
            throw e2;
        }
    }

    public static LineIterator lineIterator(File file) {
        return lineIterator(file, null);
    }

    public static void writeStringToFile(File file, String str, Charset charset) {
        writeStringToFile(file, str, charset, false);
    }

    public static void writeStringToFile(File file, String str, String str2) {
        writeStringToFile(file, str, str2, false);
    }

    public static void writeStringToFile(File file, String str, Charset charset, boolean z) {
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = openOutputStream(file, z);
            IOUtils.write(str, (OutputStream) fileOutputStream, charset);
            fileOutputStream.close();
        } finally {
            IOUtils.closeQuietly((OutputStream) fileOutputStream);
        }
    }

    public static void writeStringToFile(File file, String str, String str2, boolean z) {
        writeStringToFile(file, str, Charsets.toCharset(str2), z);
    }

    public static void writeStringToFile(File file, String str) {
        writeStringToFile(file, str, Charset.defaultCharset(), false);
    }

    public static void writeStringToFile(File file, String str, boolean z) {
        writeStringToFile(file, str, Charset.defaultCharset(), z);
    }

    public static void write(File file, CharSequence charSequence) {
        write(file, charSequence, Charset.defaultCharset(), false);
    }

    public static void write(File file, CharSequence charSequence, boolean z) {
        write(file, charSequence, Charset.defaultCharset(), z);
    }

    public static void write(File file, CharSequence charSequence, Charset charset) {
        write(file, charSequence, charset, false);
    }

    public static void write(File file, CharSequence charSequence, String str) {
        write(file, charSequence, str, false);
    }

    public static void write(File file, CharSequence charSequence, Charset charset, boolean z) {
        writeStringToFile(file, charSequence == null ? null : charSequence.toString(), charset, z);
    }

    public static void write(File file, CharSequence charSequence, String str, boolean z) {
        write(file, charSequence, Charsets.toCharset(str), z);
    }

    public static void writeByteArrayToFile(File file, byte[] bArr) {
        writeByteArrayToFile(file, bArr, false);
    }

    public static void writeByteArrayToFile(File file, byte[] bArr, boolean z) {
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = openOutputStream(file, z);
            fileOutputStream.write(bArr);
            fileOutputStream.close();
        } finally {
            IOUtils.closeQuietly((OutputStream) fileOutputStream);
        }
    }

    public static void writeLines(File file, String str, Collection<?> collection) {
        writeLines(file, str, collection, null, false);
    }

    public static void writeLines(File file, String str, Collection<?> collection, boolean z) {
        writeLines(file, str, collection, null, z);
    }

    public static void writeLines(File file, Collection<?> collection) {
        writeLines(file, null, collection, null, false);
    }

    public static void writeLines(File file, Collection<?> collection, boolean z) {
        writeLines(file, null, collection, null, z);
    }

    public static void writeLines(File file, String str, Collection<?> collection, String str2) {
        writeLines(file, str, collection, str2, false);
    }

    public static void writeLines(File file, String str, Collection<?> collection, String str2, boolean z) {
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = openOutputStream(file, z);
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            IOUtils.writeLines(collection, str2, bufferedOutputStream, str);
            bufferedOutputStream.flush();
            fileOutputStream.close();
        } finally {
            IOUtils.closeQuietly((OutputStream) fileOutputStream);
        }
    }

    public static void writeLines(File file, Collection<?> collection, String str) {
        writeLines(file, null, collection, str, false);
    }

    public static void writeLines(File file, Collection<?> collection, String str, boolean z) {
        writeLines(file, null, collection, str, z);
    }

    public static void forceDelete(File file) {
        if (file.isDirectory()) {
            deleteDirectory(file);
            return;
        }
        boolean exists = file.exists();
        if (!file.delete()) {
            if (!exists) {
                throw new FileNotFoundException("File does not exist: " + file);
            }
            throw new IOException("Unable to delete file: " + file);
        }
    }

    public static void forceDeleteOnExit(File file) {
        if (file.isDirectory()) {
            deleteDirectoryOnExit(file);
        } else {
            file.deleteOnExit();
        }
    }

    private static void deleteDirectoryOnExit(File file) {
        if (file.exists()) {
            file.deleteOnExit();
            if (!isSymlink(file)) {
                cleanDirectoryOnExit(file);
            }
        }
    }

    private static void cleanDirectoryOnExit(File file) {
        if (!file.exists()) {
            throw new IllegalArgumentException(file + " does not exist");
        }
        if (!file.isDirectory()) {
            throw new IllegalArgumentException(file + " is not a directory");
        }
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            throw new IOException("Failed to list contents of " + file);
        }
        IOException e = null;
        for (File file2 : listFiles) {
            try {
                forceDeleteOnExit(file2);
            } catch (IOException e2) {
                e = e2;
            }
        }
        if (e != null) {
            throw e;
        }
    }

    public static void forceMkdir(File file) {
        if (file.exists()) {
            if (!file.isDirectory()) {
                throw new IOException("File " + file + " exists and is not a directory. Unable to create directory.");
            }
        } else if (!file.mkdirs() && !file.isDirectory()) {
            throw new IOException("Unable to create directory " + file);
        }
    }

    public static long sizeOf(File file) {
        if (file.exists()) {
            return file.isDirectory() ? sizeOfDirectory(file) : file.length();
        }
        throw new IllegalArgumentException(file + " does not exist");
    }

    public static BigInteger sizeOfAsBigInteger(File file) {
        if (file.exists()) {
            return file.isDirectory() ? sizeOfDirectoryAsBigInteger(file) : BigInteger.valueOf(file.length());
        }
        throw new IllegalArgumentException(file + " does not exist");
    }

    public static long sizeOfDirectory(File file) {
        checkDirectory(file);
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return 0L;
        }
        long j = 0;
        for (File file2 : listFiles) {
            try {
                if (isSymlink(file2)) {
                    continue;
                } else {
                    j += sizeOf(file2);
                    if (j < 0) {
                        return j;
                    }
                }
            } catch (IOException e) {
            }
        }
        return j;
    }

    public static BigInteger sizeOfDirectoryAsBigInteger(File file) {
        checkDirectory(file);
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return BigInteger.ZERO;
        }
        BigInteger bigInteger = BigInteger.ZERO;
        for (File file2 : listFiles) {
            try {
                if (!isSymlink(file2)) {
                    bigInteger = bigInteger.add(BigInteger.valueOf(sizeOf(file2)));
                }
            } catch (IOException e) {
            }
        }
        return bigInteger;
    }

    private static void checkDirectory(File file) {
        if (!file.exists()) {
            throw new IllegalArgumentException(file + " does not exist");
        }
        if (!file.isDirectory()) {
            throw new IllegalArgumentException(file + " is not a directory");
        }
    }

    public static boolean isFileNewer(File file, File file2) {
        if (file2 == null) {
            throw new IllegalArgumentException("No specified reference file");
        }
        if (!file2.exists()) {
            throw new IllegalArgumentException("The reference file '" + file2 + "' doesn't exist");
        }
        return isFileNewer(file, file2.lastModified());
    }

    public static boolean isFileNewer(File file, Date date) {
        if (date == null) {
            throw new IllegalArgumentException("No specified date");
        }
        return isFileNewer(file, date.getTime());
    }

    public static boolean isFileNewer(File file, long j) {
        if (file == null) {
            throw new IllegalArgumentException("No specified file");
        }
        return file.exists() && file.lastModified() > j;
    }

    public static boolean isFileOlder(File file, File file2) {
        if (file2 == null) {
            throw new IllegalArgumentException("No specified reference file");
        }
        if (!file2.exists()) {
            throw new IllegalArgumentException("The reference file '" + file2 + "' doesn't exist");
        }
        return isFileOlder(file, file2.lastModified());
    }

    public static boolean isFileOlder(File file, Date date) {
        if (date == null) {
            throw new IllegalArgumentException("No specified date");
        }
        return isFileOlder(file, date.getTime());
    }

    public static boolean isFileOlder(File file, long j) {
        if (file == null) {
            throw new IllegalArgumentException("No specified file");
        }
        return file.exists() && file.lastModified() < j;
    }

    public static long checksumCRC32(File file) {
        CRC32 crc32 = new CRC32();
        checksum(file, crc32);
        return crc32.getValue();
    }

    public static Checksum checksum(File file, Checksum checksum) {
        CheckedInputStream checkedInputStream;
        if (file.isDirectory()) {
            throw new IllegalArgumentException("Checksums can't be computed on directories");
        }
        try {
            checkedInputStream = new CheckedInputStream(new FileInputStream(file), checksum);
        } catch (Throwable th) {
            th = th;
            checkedInputStream = null;
        }
        try {
            IOUtils.copy(checkedInputStream, new NullOutputStream());
            IOUtils.closeQuietly((InputStream) checkedInputStream);
            return checksum;
        } catch (Throwable th2) {
            th = th2;
            IOUtils.closeQuietly((InputStream) checkedInputStream);
            throw th;
        }
    }

    public static void moveDirectory(File file, File file2) {
        if (file == null) {
            throw new NullPointerException("Source must not be null");
        }
        if (file2 == null) {
            throw new NullPointerException("Destination must not be null");
        }
        if (!file.exists()) {
            throw new FileNotFoundException("Source '" + file + "' does not exist");
        }
        if (!file.isDirectory()) {
            throw new IOException("Source '" + file + "' is not a directory");
        }
        if (file2.exists()) {
            throw new FileExistsException("Destination '" + file2 + "' already exists");
        }
        if (!file.renameTo(file2)) {
            if (file2.getCanonicalPath().startsWith(file.getCanonicalPath())) {
                throw new IOException("Cannot move directory: " + file + " to a subdirectory of itself: " + file2);
            }
            copyDirectory(file, file2);
            deleteDirectory(file);
            if (file.exists()) {
                throw new IOException("Failed to delete original directory '" + file + "' after copy to '" + file2 + "'");
            }
        }
    }

    public static void moveDirectoryToDirectory(File file, File file2, boolean z) {
        if (file == null) {
            throw new NullPointerException("Source must not be null");
        }
        if (file2 == null) {
            throw new NullPointerException("Destination directory must not be null");
        }
        if (!file2.exists() && z) {
            file2.mkdirs();
        }
        if (!file2.exists()) {
            throw new FileNotFoundException("Destination directory '" + file2 + "' does not exist [createDestDir=" + z + "]");
        }
        if (!file2.isDirectory()) {
            throw new IOException("Destination '" + file2 + "' is not a directory");
        }
        moveDirectory(file, new File(file2, file.getName()));
    }

    public static void moveFile(File file, File file2) {
        if (file == null) {
            throw new NullPointerException("Source must not be null");
        }
        if (file2 == null) {
            throw new NullPointerException("Destination must not be null");
        }
        if (!file.exists()) {
            throw new FileNotFoundException("Source '" + file + "' does not exist");
        }
        if (file.isDirectory()) {
            throw new IOException("Source '" + file + "' is a directory");
        }
        if (file2.exists()) {
            throw new FileExistsException("Destination '" + file2 + "' already exists");
        }
        if (file2.isDirectory()) {
            throw new IOException("Destination '" + file2 + "' is a directory");
        }
        if (!file.renameTo(file2)) {
            copyFile(file, file2);
            if (!file.delete()) {
                deleteQuietly(file2);
                throw new IOException("Failed to delete original file '" + file + "' after copy to '" + file2 + "'");
            }
        }
    }

    public static void moveFileToDirectory(File file, File file2, boolean z) {
        if (file == null) {
            throw new NullPointerException("Source must not be null");
        }
        if (file2 == null) {
            throw new NullPointerException("Destination directory must not be null");
        }
        if (!file2.exists() && z) {
            file2.mkdirs();
        }
        if (!file2.exists()) {
            throw new FileNotFoundException("Destination directory '" + file2 + "' does not exist [createDestDir=" + z + "]");
        }
        if (!file2.isDirectory()) {
            throw new IOException("Destination '" + file2 + "' is not a directory");
        }
        moveFile(file, new File(file2, file.getName()));
    }

    public static void moveToDirectory(File file, File file2, boolean z) {
        if (file == null) {
            throw new NullPointerException("Source must not be null");
        }
        if (file2 == null) {
            throw new NullPointerException("Destination must not be null");
        }
        if (!file.exists()) {
            throw new FileNotFoundException("Source '" + file + "' does not exist");
        }
        if (file.isDirectory()) {
            moveDirectoryToDirectory(file, file2, z);
        } else {
            moveFileToDirectory(file, file2, z);
        }
    }

    public static boolean isSymlink(File file) {
        if (file == null) {
            throw new NullPointerException("File must not be null");
        }
        if (FilenameUtils.isSystemWindows()) {
            return false;
        }
        if (file.getParent() != null) {
            file = new File(file.getParentFile().getCanonicalFile(), file.getName());
        }
        return !file.getCanonicalFile().equals(file.getAbsoluteFile());
    }
}
