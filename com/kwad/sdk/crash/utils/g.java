package com.kwad.sdk.crash.utils;

import com.baidu.android.common.others.IStringUtil;
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
/* loaded from: classes6.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public static final Charset f34494a = Charset.forName("US-ASCII");

    /* renamed from: b  reason: collision with root package name */
    public static final Charset f34495b = Charset.forName("UTF-8");

    /* renamed from: c  reason: collision with root package name */
    public static final BigInteger f34496c;

    /* renamed from: d  reason: collision with root package name */
    public static final BigInteger f34497d;

    /* renamed from: e  reason: collision with root package name */
    public static final BigInteger f34498e;

    /* renamed from: f  reason: collision with root package name */
    public static final BigInteger f34499f;

    /* renamed from: g  reason: collision with root package name */
    public static final BigInteger f34500g;

    /* renamed from: h  reason: collision with root package name */
    public static final BigInteger f34501h;
    public static final char i;
    public static final BigInteger j;
    public static final BigInteger k;
    public static final File[] l;
    public static final String m;
    public static final Charset n;
    public static final char o;

    static {
        BigInteger valueOf = BigInteger.valueOf(1024L);
        f34496c = valueOf;
        BigInteger multiply = valueOf.multiply(valueOf);
        f34497d = multiply;
        BigInteger multiply2 = f34496c.multiply(multiply);
        f34498e = multiply2;
        BigInteger multiply3 = f34496c.multiply(multiply2);
        f34499f = multiply3;
        BigInteger multiply4 = f34496c.multiply(multiply3);
        f34500g = multiply4;
        f34501h = f34496c.multiply(multiply4);
        BigInteger multiply5 = BigInteger.valueOf(1024L).multiply(BigInteger.valueOf(1152921504606846976L));
        j = multiply5;
        k = f34496c.multiply(multiply5);
        l = new File[0];
        m = Character.toString(IStringUtil.EXTENSION_SEPARATOR);
        n = Charset.forName("UTF-8");
        o = File.separatorChar;
        i = a() ? '/' : '\\';
    }

    public static FileInputStream a(File file) {
        if (!file.exists()) {
            throw new FileNotFoundException("File '" + file + "' does not exist");
        } else if (file.isDirectory()) {
            throw new IOException("File '" + file + "' exists but is a directory");
        } else if (file.canRead()) {
            return new FileInputStream(file);
        } else {
            throw new IOException("File '" + file + "' cannot be read");
        }
    }

    public static FileOutputStream a(File file, boolean z) {
        if (!file.exists()) {
            File parentFile = file.getParentFile();
            if (parentFile != null && !parentFile.mkdirs() && !parentFile.isDirectory()) {
                throw new IOException("Directory '" + parentFile + "' could not be created");
            }
        } else if (file.isDirectory()) {
            throw new IOException("File '" + file + "' exists but is a directory");
        } else if (!file.canWrite()) {
            throw new IOException("File '" + file + "' cannot be written to");
        }
        return new FileOutputStream(file, z);
    }

    public static String a(File file, Charset charset) {
        FileInputStream fileInputStream;
        try {
            fileInputStream = a(file);
            try {
                String a2 = h.a(fileInputStream, a.a(charset));
                b.a((InputStream) fileInputStream);
                return a2;
            } catch (Throwable th) {
                th = th;
                b.a((InputStream) fileInputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
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
        } else if (!file.isDirectory()) {
            throw new IOException("Source '" + file + "' exists but is not a directory");
        } else if (file.getCanonicalPath().equals(file2.getCanonicalPath())) {
            throw new IOException("Source '" + file + "' and destination '" + file2 + "' are the same");
        } else {
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
    }

    public static void a(File file, File file2, FileFilter fileFilter, boolean z, List<String> list) {
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
            if (file.delete()) {
                return;
            }
            throw new IOException("Unable to delete directory " + file + ".");
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:29:0x00a6 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.io.OutputStream, java.io.FileOutputStream] */
    public static void b(File file, File file2, boolean z) {
        FileInputStream fileInputStream;
        ?? r4;
        FileChannel fileChannel;
        if (file2.exists() && file2.isDirectory()) {
            throw new IOException("Destination '" + file2 + "' exists but is a directory");
        }
        FileChannel fileChannel2 = null;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                r4 = new FileOutputStream(file2);
                try {
                    fileChannel = fileInputStream.getChannel();
                    try {
                        fileChannel2 = r4.getChannel();
                        long size = fileChannel.size();
                        long j2 = 0;
                        while (j2 < size) {
                            long j3 = size - j2;
                            j2 += fileChannel2.transferFrom(fileChannel, j2, j3 > 31457280 ? 31457280L : j3);
                        }
                        b.a(fileChannel2);
                        b.a((OutputStream) r4);
                        b.a(fileChannel);
                        b.a((InputStream) fileInputStream);
                        if (file.length() == file2.length()) {
                            if (z) {
                                file2.setLastModified(file.lastModified());
                                return;
                            }
                            return;
                        }
                        throw new IOException("Failed to copy full contents from '" + file + "' to '" + file2 + "'");
                    } catch (Throwable th) {
                        th = th;
                        b.a(fileChannel2);
                        b.a((OutputStream) r4);
                        b.a(fileChannel);
                        b.a((InputStream) fileInputStream);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileChannel = null;
                }
            } catch (Throwable th3) {
                th = th3;
                r4 = 0;
                fileChannel = r4;
                b.a(fileChannel2);
                b.a((OutputStream) r4);
                b.a(fileChannel);
                b.a((InputStream) fileInputStream);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            fileInputStream = null;
            r4 = 0;
        }
    }

    public static void c(File file) {
        if (!file.exists()) {
            throw new IllegalArgumentException(file + " does not exist");
        } else if (!file.isDirectory()) {
            throw new IllegalArgumentException(file + " is not a directory");
        } else {
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
        if (exists) {
            throw new IOException("Unable to delete file: " + file);
        }
        throw new FileNotFoundException("File does not exist: " + file);
    }

    public static boolean f(File file) {
        if (file != null) {
            if (a()) {
                return false;
            }
            if (file.getParent() != null) {
                file = new File(file.getParentFile().getCanonicalFile(), file.getName());
            }
            return !file.getCanonicalFile().equals(file.getAbsoluteFile());
        }
        throw new NullPointerException("File must not be null");
    }
}
