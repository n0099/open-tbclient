package com.kwad.sdk.utils;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.common.others.IStringUtil;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
/* loaded from: classes5.dex */
public final class o {
    public static final BigInteger a;
    public static final BigInteger b;
    public static final BigInteger c;
    public static final BigInteger d;
    public static final BigInteger e;
    public static final BigInteger f;
    public static final char g;
    public static final BigInteger h;
    public static final BigInteger i;
    public static final File[] j;
    public static final String k;
    public static final char l;

    static {
        BigInteger valueOf = BigInteger.valueOf(1024L);
        a = valueOf;
        BigInteger multiply = valueOf.multiply(valueOf);
        b = multiply;
        BigInteger multiply2 = a.multiply(multiply);
        c = multiply2;
        BigInteger multiply3 = a.multiply(multiply2);
        d = multiply3;
        BigInteger multiply4 = a.multiply(multiply3);
        e = multiply4;
        f = a.multiply(multiply4);
        BigInteger multiply5 = BigInteger.valueOf(1024L).multiply(BigInteger.valueOf(LockFreeTaskQueueCore.FROZEN_MASK));
        h = multiply5;
        i = a.multiply(multiply5);
        j = new File[0];
        k = Character.toString(IStringUtil.EXTENSION_SEPARATOR);
        l = File.separatorChar;
        g = a() ? WebvttCueParser.CHAR_SLASH : '\\';
    }

    public static BufferedInputStream a(String str) {
        FileInputStream fileInputStream;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(str);
        if (file.exists() && !file.isDirectory()) {
            try {
                fileInputStream = new FileInputStream(file);
            } catch (Exception unused) {
                fileInputStream = null;
            }
            if (fileInputStream == null) {
                return null;
            }
            return new BufferedInputStream(fileInputStream);
        }
        return null;
    }

    public static FileOutputStream a(File file, boolean z) {
        c(file);
        return new FileOutputStream(file, z);
    }

    public static String a(File file, Charset charset) {
        FileInputStream fileInputStream;
        try {
            fileInputStream = m(file);
            try {
                String a2 = com.kwad.sdk.crash.utils.g.a(fileInputStream, com.kwad.sdk.crash.utils.a.a(charset));
                com.kwad.sdk.crash.utils.b.a(fileInputStream);
                return a2;
            } catch (Throwable th) {
                th = th;
                com.kwad.sdk.crash.utils.b.a(fileInputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
        }
    }

    public static void a(Context context, String str, File file) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Asset path is empty.");
        }
        InputStream inputStream = null;
        try {
            inputStream = context.getAssets().open(str);
            a(inputStream, file);
        } finally {
            com.kwad.sdk.crash.utils.b.a(inputStream);
        }
    }

    public static void a(File file, File file2) {
        a(file, file2, true);
    }

    public static void a(File file, File file2, FileFilter fileFilter, boolean z) {
        ArrayList arrayList;
        File[] listFiles;
        aj.a(file, "Source");
        aj.a(file2, "Destination");
        if (!file.exists()) {
            throw new FileNotFoundException("Source '" + file + "' does not exist");
        } else if (!file.isDirectory()) {
            throw new IOException("Source '" + file + "' exists but is not a directory");
        } else if (file.getCanonicalPath().equals(file2.getCanonicalPath())) {
            throw new IOException("Source '" + file + "' and destination '" + file2 + "' are the same");
        } else {
            if (!file2.getCanonicalPath().startsWith(file.getCanonicalPath()) || (listFiles = file.listFiles()) == null || listFiles.length <= 0) {
                arrayList = null;
            } else {
                arrayList = new ArrayList(listFiles.length);
                for (File file3 : listFiles) {
                    arrayList.add(new File(file2, file3.getName()).getCanonicalPath());
                }
            }
            a(file, file2, null, z, arrayList);
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
        aj.a(file, "Source");
        aj.a(file2, "Destination");
        if (!file.exists()) {
            throw new FileNotFoundException("Source '" + file + "' does not exist");
        } else if (file.isDirectory()) {
            throw new IOException("Source '" + file + "' exists but is a directory");
        } else if (file.getCanonicalPath().equals(file2.getCanonicalPath())) {
            throw new IOException("Source '" + file + "' and destination '" + file2 + "' are the same");
        } else {
            File parentFile = file2.getParentFile();
            if (parentFile != null && !parentFile.mkdirs() && !parentFile.isDirectory()) {
                throw new IOException("Destination '" + parentFile + "' directory cannot be created");
            } else if (!file2.exists() || file2.canWrite()) {
                b(file, file2, true);
            } else {
                throw new IOException("Destination '" + file2 + "' exists but is read-only");
            }
        }
    }

    public static void a(File file, String str, Charset charset, boolean z) {
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = a(file, false);
            try {
                com.kwad.sdk.crash.utils.g.a(str, fileOutputStream, charset);
                com.kwad.sdk.crash.utils.b.a(fileOutputStream);
            } catch (Throwable th) {
                th = th;
                com.kwad.sdk.crash.utils.b.a(fileOutputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = null;
        }
    }

    public static void a(InputStream inputStream, File file) {
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = n(file);
        } catch (Throwable th) {
            th = th;
            fileOutputStream = null;
        }
        try {
            com.kwad.sdk.crash.utils.g.a(inputStream, fileOutputStream);
            com.kwad.sdk.crash.utils.b.a(fileOutputStream);
            com.kwad.sdk.crash.utils.b.a(inputStream);
        } catch (Throwable th2) {
            th = th2;
            com.kwad.sdk.crash.utils.b.a(fileOutputStream);
            com.kwad.sdk.crash.utils.b.a(inputStream);
            throw th;
        }
    }

    public static boolean a() {
        return l == '\\';
    }

    public static boolean a(File file) {
        return file != null && file.exists() && file.length() > 0;
    }

    public static void b(File file, File file2) {
        c(file, file2, true);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:29:0x00a0 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.io.Closeable, java.io.FileOutputStream] */
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
                        com.kwad.sdk.crash.utils.b.a(fileChannel2);
                        com.kwad.sdk.crash.utils.b.a((Closeable) r4);
                        com.kwad.sdk.crash.utils.b.a(fileChannel);
                        com.kwad.sdk.crash.utils.b.a(fileInputStream);
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
                        com.kwad.sdk.crash.utils.b.a(fileChannel2);
                        com.kwad.sdk.crash.utils.b.a((Closeable) r4);
                        com.kwad.sdk.crash.utils.b.a(fileChannel);
                        com.kwad.sdk.crash.utils.b.a(fileInputStream);
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
                com.kwad.sdk.crash.utils.b.a(fileChannel2);
                com.kwad.sdk.crash.utils.b.a((Closeable) r4);
                com.kwad.sdk.crash.utils.b.a(fileChannel);
                com.kwad.sdk.crash.utils.b.a(fileInputStream);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            fileInputStream = null;
            r4 = 0;
        }
    }

    public static boolean b(File file) {
        return file.exists();
    }

    public static boolean b(String str) {
        return !TextUtils.isEmpty(str) && new File(str).exists();
    }

    public static void c(File file) {
        if (file.exists()) {
            if (file.isDirectory()) {
                throw new IOException("File '" + file + "' exists but is a directory");
            }
            return;
        }
        File parentFile = file.getParentFile();
        if (parentFile == null) {
            throw new IOException("Could not find parent directory");
        }
        if (parentFile.mkdirs() || parentFile.isDirectory()) {
            file.createNewFile();
            return;
        }
        throw new IOException("Directory '" + parentFile + "' could not be created");
    }

    public static void c(File file, File file2, boolean z) {
        a(file, file2, (FileFilter) null, true);
    }

    public static boolean c(File file, File file2) {
        if (file.renameTo(file2)) {
            return true;
        }
        try {
            a(file, file2);
            try {
                file.delete();
            } catch (Exception e2) {
                com.kwad.sdk.core.d.b.b(e2);
            }
            return true;
        } catch (Exception e3) {
            com.kwad.sdk.core.d.b.b(e3);
            return false;
        }
    }

    public static boolean c(String str) {
        return !TextUtils.isEmpty(str) && a(new File(str));
    }

    public static boolean d(File file) {
        if (file == null) {
            return false;
        }
        try {
            if (file.isDirectory()) {
                f(file);
            }
        } catch (Exception unused) {
        }
        try {
            return file.delete();
        } catch (Exception unused2) {
            return false;
        }
    }

    public static boolean d(String str) {
        return d(new File(str));
    }

    public static String e(String str) {
        if (str == null) {
            return null;
        }
        int g2 = g(str);
        return g2 == -1 ? "" : str.substring(g2 + 1);
    }

    public static boolean e(File file) {
        return d(file);
    }

    public static int f(String str) {
        if (str == null) {
            return -1;
        }
        return Math.max(str.lastIndexOf(47), str.lastIndexOf(92));
    }

    public static void f(File file) {
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
                    q(file2);
                } catch (IOException e3) {
                    e2 = e3;
                }
            }
            if (e2 != null) {
                throw e2;
            }
        }
    }

    public static int g(String str) {
        int lastIndexOf;
        if (str != null && f(str) <= (lastIndexOf = str.lastIndexOf(46))) {
            return lastIndexOf;
        }
        return -1;
    }

    public static byte[] g(File file) {
        return h(file).getBytes();
    }

    public static String h(File file) {
        return a(file, Charset.defaultCharset());
    }

    public static void i(File file) {
        if (file == null) {
            throw new IOException("Dir is null.");
        }
        if (!file.exists()) {
            file.mkdirs();
        } else if (file.isDirectory()) {
            return;
        } else {
            if (!d(file)) {
                throw new IOException("Fail to delete existing file, file = " + file.getAbsolutePath());
            }
            file.mkdir();
        }
        if (file.exists() && file.isDirectory()) {
            return;
        }
        throw new IOException("Fail to create dir, dir = " + file.getAbsolutePath());
    }

    public static void j(File file) {
        d(file);
        o(file);
        if (!file.exists()) {
            throw new IOException("Create file fail");
        }
    }

    public static void k(@NonNull File file) {
        File[] listFiles;
        if (file.exists() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    k(file2);
                }
                file2.delete();
            }
        }
    }

    public static boolean l(File file) {
        File file2 = new File(file.getAbsolutePath() + System.currentTimeMillis());
        c(file, file2);
        return d(file2);
    }

    public static FileInputStream m(File file) {
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

    public static FileOutputStream n(File file) {
        return a(file, false);
    }

    public static void o(File file) {
        if (!file.exists()) {
            com.kwad.sdk.crash.utils.b.a(n(file));
        }
        if (file.setLastModified(System.currentTimeMillis())) {
            return;
        }
        throw new IOException("Unable to set the last modification time for " + file);
    }

    public static void p(File file) {
        if (file.exists()) {
            if (!r(file)) {
                f(file);
            }
            if (file.delete()) {
                return;
            }
            throw new IOException("Unable to delete directory " + file + ".");
        }
    }

    public static void q(File file) {
        if (file.isDirectory()) {
            p(file);
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

    public static boolean r(File file) {
        aj.a(file);
        if (a()) {
            return false;
        }
        if (file.getParent() != null) {
            file = new File(file.getParentFile().getCanonicalFile(), file.getName());
        }
        return !file.getCanonicalFile().equals(file.getAbsoluteFile());
    }
}
