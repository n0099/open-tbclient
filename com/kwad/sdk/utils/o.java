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
/* loaded from: classes7.dex */
public final class o {
    public static final BigInteger anl;
    public static final BigInteger anm;
    public static final BigInteger ann;
    public static final BigInteger ano;
    public static final BigInteger anp;
    public static final BigInteger anq;
    public static final char anr;
    public static final BigInteger ans;
    public static final BigInteger ant;
    public static final File[] anu;
    public static final String anv;
    public static final char anw;

    static {
        BigInteger valueOf = BigInteger.valueOf(1024L);
        anl = valueOf;
        BigInteger multiply = valueOf.multiply(valueOf);
        anm = multiply;
        BigInteger multiply2 = anl.multiply(multiply);
        ann = multiply2;
        BigInteger multiply3 = anl.multiply(multiply2);
        ano = multiply3;
        BigInteger multiply4 = anl.multiply(multiply3);
        anp = multiply4;
        anq = anl.multiply(multiply4);
        BigInteger multiply5 = BigInteger.valueOf(1024L).multiply(BigInteger.valueOf(LockFreeTaskQueueCore.FROZEN_MASK));
        ans = multiply5;
        ant = anl.multiply(multiply5);
        anu = new File[0];
        anv = Character.toString(IStringUtil.EXTENSION_SEPARATOR);
        anw = File.separatorChar;
        anr = zm() ? WebvttCueParser.CHAR_SLASH : '\\';
    }

    public static boolean I(File file) {
        return file != null && file.exists() && file.length() > 0;
    }

    public static boolean J(File file) {
        return file.exists();
    }

    public static FileInputStream K(File file) {
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

    public static FileOutputStream L(File file) {
        return a(file, false);
    }

    public static void M(File file) {
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

    public static void N(File file) {
        if (file.exists()) {
            if (!W(file)) {
                Q(file);
            }
            if (file.delete()) {
                return;
            }
            throw new IOException("Unable to delete directory " + file + ".");
        }
    }

    public static boolean O(File file) {
        if (file == null) {
            return false;
        }
        try {
            if (file.isDirectory()) {
                Q(file);
            }
        } catch (Exception unused) {
        }
        try {
            return file.delete();
        } catch (Exception unused2) {
            return false;
        }
    }

    public static boolean P(File file) {
        return O(file);
    }

    public static void Q(File file) {
        if (!file.exists()) {
            throw new IllegalArgumentException(file + " does not exist");
        } else if (!file.isDirectory()) {
            throw new IllegalArgumentException(file + " is not a directory");
        } else {
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                throw new IOException("Failed to list contents of " + file);
            }
            IOException e = null;
            for (File file2 : listFiles) {
                try {
                    T(file2);
                } catch (IOException e2) {
                    e = e2;
                }
            }
            if (e != null) {
                throw e;
            }
        }
    }

    public static byte[] R(File file) {
        return S(file).getBytes();
    }

    public static String S(File file) {
        return a(file, Charset.defaultCharset());
    }

    public static void T(File file) {
        if (file.isDirectory()) {
            N(file);
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

    public static void U(File file) {
        if (file == null) {
            throw new IOException("Dir is null.");
        }
        if (!file.exists()) {
            file.mkdirs();
        } else if (file.isDirectory()) {
            return;
        } else {
            if (!O(file)) {
                throw new IOException("Fail to delete existing file, file = " + file.getAbsolutePath());
            }
            file.mkdir();
        }
        if (file.exists() && file.isDirectory()) {
            return;
        }
        throw new IOException("Fail to create dir, dir = " + file.getAbsolutePath());
    }

    public static void V(File file) {
        O(file);
        p(file);
        if (!file.exists()) {
            throw new IOException("Create file fail");
        }
    }

    public static boolean W(File file) {
        am.checkNotNull(file);
        if (zm()) {
            return false;
        }
        if (file.getParent() != null) {
            file = new File(file.getParentFile().getCanonicalFile(), file.getName());
        }
        return !file.getCanonicalFile().equals(file.getAbsoluteFile());
    }

    public static boolean X(File file) {
        File file2 = new File(file.getAbsolutePath() + System.currentTimeMillis());
        c(file, file2);
        return O(file2);
    }

    public static FileOutputStream a(File file, boolean z) {
        M(file);
        return new FileOutputStream(file, z);
    }

    public static String a(File file, Charset charset) {
        FileInputStream fileInputStream;
        try {
            fileInputStream = K(file);
            try {
                String a = com.kwad.sdk.crash.utils.g.a(fileInputStream, com.kwad.sdk.crash.utils.a.a(charset));
                com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream);
                return a;
            } catch (Throwable th) {
                th = th;
                com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream);
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
            b(inputStream, file);
        } finally {
            com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
        }
    }

    public static void a(File file, File file2, FileFilter fileFilter, boolean z) {
        ArrayList arrayList;
        File[] listFiles;
        am.e(file, "Source");
        am.e(file2, "Destination");
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
                    c(file3, file4, z);
                }
            }
        }
        if (z) {
            file2.setLastModified(file.lastModified());
        }
    }

    public static void a(File file, String str, Charset charset, boolean z) {
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = a(file, false);
            try {
                com.kwad.sdk.crash.utils.g.a(str, fileOutputStream, charset);
                com.kwad.sdk.crash.utils.b.closeQuietly(fileOutputStream);
            } catch (Throwable th) {
                th = th;
                com.kwad.sdk.crash.utils.b.closeQuietly(fileOutputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = null;
        }
    }

    public static void b(File file, File file2, boolean z) {
        am.e(file, "Source");
        am.e(file2, "Destination");
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
                c(file, file2, true);
            } else {
                throw new IOException("Destination '" + file2 + "' exists but is read-only");
            }
        }
    }

    public static void b(InputStream inputStream, File file) {
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = L(file);
        } catch (Throwable th) {
            th = th;
            fileOutputStream = null;
        }
        try {
            com.kwad.sdk.crash.utils.g.e(inputStream, fileOutputStream);
            com.kwad.sdk.crash.utils.b.closeQuietly(fileOutputStream);
            com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
        } catch (Throwable th2) {
            th = th2;
            com.kwad.sdk.crash.utils.b.closeQuietly(fileOutputStream);
            com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
            throw th;
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:29:0x00a0 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.io.Closeable, java.io.FileOutputStream] */
    public static void c(File file, File file2, boolean z) {
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
                        long j = 0;
                        while (j < size) {
                            long j2 = size - j;
                            j += fileChannel2.transferFrom(fileChannel, j, j2 > 31457280 ? 31457280L : j2);
                        }
                        com.kwad.sdk.crash.utils.b.closeQuietly(fileChannel2);
                        com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) r4);
                        com.kwad.sdk.crash.utils.b.closeQuietly(fileChannel);
                        com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream);
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
                        com.kwad.sdk.crash.utils.b.closeQuietly(fileChannel2);
                        com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) r4);
                        com.kwad.sdk.crash.utils.b.closeQuietly(fileChannel);
                        com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream);
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
                com.kwad.sdk.crash.utils.b.closeQuietly(fileChannel2);
                com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) r4);
                com.kwad.sdk.crash.utils.b.closeQuietly(fileChannel);
                com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            fileInputStream = null;
            r4 = 0;
        }
    }

    public static boolean c(File file, File file2) {
        if (file.renameTo(file2)) {
            return true;
        }
        try {
            d(file, file2);
            try {
                file.delete();
            } catch (Exception e) {
                com.kwad.sdk.core.e.b.printStackTraceOnly(e);
            }
            return true;
        } catch (Exception e2) {
            com.kwad.sdk.core.e.b.printStackTraceOnly(e2);
            return false;
        }
    }

    public static void d(File file, File file2) {
        b(file, file2, true);
    }

    public static void d(File file, File file2, boolean z) {
        a(file, file2, (FileFilter) null, true);
    }

    public static boolean dA(String str) {
        return !TextUtils.isEmpty(str) && I(new File(str));
    }

    public static int dB(String str) {
        if (str == null) {
            return -1;
        }
        return Math.max(str.lastIndexOf(47), str.lastIndexOf(92));
    }

    public static int dC(String str) {
        int lastIndexOf;
        if (str != null && dB(str) <= (lastIndexOf = str.lastIndexOf(46))) {
            return lastIndexOf;
        }
        return -1;
    }

    public static boolean delete(String str) {
        return O(new File(str));
    }

    public static void deleteContents(@NonNull File file) {
        File[] listFiles;
        if (file.exists() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    deleteContents(file2);
                }
                file2.delete();
            }
        }
    }

    public static BufferedInputStream dy(String str) {
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

    public static boolean dz(String str) {
        return !TextUtils.isEmpty(str) && new File(str).exists();
    }

    public static void e(File file, File file2) {
        d(file, file2, true);
    }

    public static String getExtension(String str) {
        if (str == null) {
            return null;
        }
        int dC = dC(str);
        return dC == -1 ? "" : str.substring(dC + 1);
    }

    public static void p(File file) {
        if (!file.exists()) {
            com.kwad.sdk.crash.utils.b.closeQuietly(L(file));
        }
        if (file.setLastModified(System.currentTimeMillis())) {
            return;
        }
        throw new IOException("Unable to set the last modification time for " + file);
    }

    public static boolean zm() {
        return anw == '\\';
    }
}
