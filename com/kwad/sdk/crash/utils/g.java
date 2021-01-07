package com.kwad.sdk.crash.utils;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class g {
    public static final char i;

    /* renamed from: a  reason: collision with root package name */
    public static final Charset f9962a = Charset.forName("US-ASCII");

    /* renamed from: b  reason: collision with root package name */
    public static final Charset f9963b = Charset.forName("UTF-8");
    public static final BigInteger c = BigInteger.valueOf(1024);
    public static final BigInteger d = c.multiply(c);
    public static final BigInteger e = c.multiply(d);
    public static final BigInteger f = c.multiply(e);
    public static final BigInteger g = c.multiply(f);
    public static final BigInteger h = c.multiply(g);
    public static final BigInteger j = BigInteger.valueOf(1024).multiply(BigInteger.valueOf(1152921504606846976L));
    public static final BigInteger k = c.multiply(j);
    public static final File[] l = new File[0];
    public static final String m = Character.toString('.');
    private static final Charset n = Charset.forName("UTF-8");
    private static final char o = File.separatorChar;

    static {
        if (a()) {
            i = '/';
        } else {
            i = '\\';
        }
    }

    public static FileInputStream a(File file) {
        if (file.exists()) {
            if (file.isDirectory()) {
                throw new IOException("File '" + file + "' exists but is a directory");
            }
            if (file.canRead()) {
                return new FileInputStream(file);
            }
            throw new IOException("File '" + file + "' cannot be read");
        }
        throw new FileNotFoundException("File '" + file + "' does not exist");
    }

    public static FileOutputStream a(File file, boolean z) {
        if (!file.exists()) {
            File parentFile = file.getParentFile();
            if (parentFile != null && !parentFile.mkdirs() && !parentFile.isDirectory()) {
                throw new IOException("Directory '" + parentFile + "' could not be created");
            }
        } else if (file.isDirectory()) {
            throw new IOException("File '" + file + "' exists but is a directory");
        } else {
            if (!file.canWrite()) {
                throw new IOException("File '" + file + "' cannot be written to");
            }
        }
        return new FileOutputStream(file, z);
    }

    public static String a(File file, Charset charset) {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = a(file);
            return h.a(fileInputStream, a.a(charset));
        } finally {
            b.a((InputStream) fileInputStream);
        }
    }

    public static void a(File file, File file2) {
        a(file, file2, true);
    }

    public static void a(File file, File file2, FileFilter fileFilter, boolean z) {
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
        a(file, file2, fileFilter, z, arrayList);
    }

    private static void a(File file, File file2, FileFilter fileFilter, boolean z, List<String> list) {
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
                    a(file3, file4, fileFilter, z, list);
                } else {
                    b(file3, file4, z);
                }
            }
        }
        if (z) {
            file2.setLastModified(file.lastModified());
        }
    }

    public static void a(File file, File file2, boolean z) {
        a(file, file2, null, z);
    }

    public static boolean a() {
        return o == '\\';
    }

    public static void b(File file) {
        if (file.exists()) {
            if (!f(file)) {
                c(file);
            }
            if (!file.delete()) {
                throw new IOException("Unable to delete directory " + file + ".");
            }
        }
    }

    private static void b(File file, File file2, boolean z) {
        Throwable th;
        FileChannel fileChannel;
        FileChannel fileChannel2;
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream;
        FileOutputStream fileOutputStream2;
        FileChannel channel;
        if (file2.exists() && file2.isDirectory()) {
            throw new IOException("Destination '" + file2 + "' exists but is a directory");
        }
        try {
            fileInputStream = new FileInputStream(file);
            try {
                fileOutputStream2 = new FileOutputStream(file2);
                try {
                    fileChannel2 = fileInputStream.getChannel();
                    try {
                        channel = fileOutputStream2.getChannel();
                    } catch (Throwable th2) {
                        th = th2;
                        fileChannel = null;
                        fileOutputStream = fileOutputStream2;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    fileChannel = null;
                    fileChannel2 = null;
                    fileOutputStream = fileOutputStream2;
                }
            } catch (Throwable th4) {
                th = th4;
                fileChannel = null;
                fileChannel2 = null;
                fileOutputStream = null;
            }
        } catch (Throwable th5) {
            th = th5;
            fileChannel = null;
            fileChannel2 = null;
            fileOutputStream = null;
            fileInputStream = null;
        }
        try {
            long size = fileChannel2.size();
            for (long j2 = 0; j2 < size; j2 += channel.transferFrom(fileChannel2, j2, size - j2 > 31457280 ? 31457280L : size - j2)) {
            }
            b.a(channel);
            b.a((OutputStream) fileOutputStream2);
            b.a(fileChannel2);
            b.a((InputStream) fileInputStream);
            if (file.length() != file2.length()) {
                throw new IOException("Failed to copy full contents from '" + file + "' to '" + file2 + "'");
            }
            if (z) {
                file2.setLastModified(file.lastModified());
            }
        } catch (Throwable th6) {
            th = th6;
            fileChannel = channel;
            fileOutputStream = fileOutputStream2;
            b.a(fileChannel);
            b.a((OutputStream) fileOutputStream);
            b.a(fileChannel2);
            b.a((InputStream) fileInputStream);
            throw th;
        }
    }

    public static void c(File file) {
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
        IOException e2 = null;
        for (File file2 : listFiles) {
            try {
                e(file2);
            } catch (IOException e3) {
                e2 = e3;
            }
        }
        if (e2 != null) {
            throw e2;
        }
    }

    public static String d(File file) {
        return a(file, Charset.defaultCharset());
    }

    public static void e(File file) {
        if (file.isDirectory()) {
            b(file);
            return;
        }
        boolean exists = file.exists();
        if (file.delete()) {
            return;
        }
        if (!exists) {
            throw new FileNotFoundException("File does not exist: " + file);
        }
        throw new IOException("Unable to delete file: " + file);
    }

    public static boolean f(File file) {
        if (file == null) {
            throw new NullPointerException("File must not be null");
        }
        if (a()) {
            return false;
        }
        if (file.getParent() != null) {
            file = new File(file.getParentFile().getCanonicalFile(), file.getName());
        }
        return !file.getCanonicalFile().equals(file.getAbsoluteFile());
    }
}
