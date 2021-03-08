package com.kwai.sodler.lib.c;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.minivideo.plugin.capture.utils.EncryptUtils;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
/* loaded from: classes3.dex */
public final class a {
    private static long a(InputStream inputStream, OutputStream outputStream, byte[] bArr) {
        long j = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (-1 == read) {
                return j;
            }
            outputStream.write(bArr, 0, read);
            j += read;
        }
    }

    public static String a(InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
            MessageDigest messageDigest = MessageDigest.getInstance(EncryptUtils.ENCRYPT_MD5);
            StringBuilder sb = new StringBuilder(32);
            byte[] bArr = new byte[BdStatsConstant.MAX_WRITE_LOG_SIZE];
            while (true) {
                int read = bufferedInputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                messageDigest.update(bArr, 0, read);
            }
            for (byte b : messageDigest.digest()) {
                sb.append(Integer.toString((b & 255) + 256, 16).substring(1));
            }
            return sb.toString();
        } catch (Exception e) {
            return null;
        }
    }

    public static void a(Context context, String str, File file) {
        OutputStream outputStream;
        InputStream inputStream;
        FileDescriptor fd;
        OutputStream bufferedOutputStream;
        if (TextUtils.isEmpty(str)) {
            throw new IOException("Asset path is empty.");
        }
        d(file);
        try {
            inputStream = context.getAssets().open(str);
            try {
                outputStream = new FileOutputStream(file);
                try {
                    try {
                        fd = ((FileOutputStream) outputStream).getFD();
                        bufferedOutputStream = new BufferedOutputStream(outputStream);
                    } catch (IOException e) {
                        e = e;
                    }
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    a(inputStream, bufferedOutputStream, new byte[16384]);
                    bufferedOutputStream.flush();
                    fd.sync();
                    a((Object) inputStream);
                    a(bufferedOutputStream);
                } catch (IOException e2) {
                    e = e2;
                    outputStream = bufferedOutputStream;
                    com.kwai.sodler.lib.a.a("plugin.files", e);
                    a((Object) inputStream);
                    a(outputStream);
                } catch (Throwable th2) {
                    th = th2;
                    outputStream = bufferedOutputStream;
                    a((Object) inputStream);
                    a(outputStream);
                    throw th;
                }
            } catch (IOException e3) {
                e = e3;
                outputStream = null;
            } catch (Throwable th3) {
                th = th3;
                outputStream = null;
            }
        } catch (IOException e4) {
            e = e4;
            outputStream = null;
            inputStream = null;
        } catch (Throwable th4) {
            th = th4;
            outputStream = null;
            inputStream = null;
        }
    }

    public static void a(File file, File file2) {
        OutputStream outputStream;
        FileInputStream fileInputStream;
        FileDescriptor fd;
        OutputStream bufferedOutputStream;
        if (file == null) {
            throw new IOException("Source file is null.");
        }
        if (file2 == null) {
            throw new IOException("Dest file is null.");
        }
        if (!file.exists()) {
            throw new IOException("Source file not found.");
        }
        d(file2);
        try {
            fileInputStream = new FileInputStream(file);
            try {
                outputStream = new FileOutputStream(file2);
                try {
                    try {
                        fd = ((FileOutputStream) outputStream).getFD();
                        bufferedOutputStream = new BufferedOutputStream(outputStream);
                    } catch (IOException e) {
                        e = e;
                    }
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    a(fileInputStream, bufferedOutputStream, new byte[16384]);
                    bufferedOutputStream.flush();
                    fd.sync();
                    a((Object) fileInputStream);
                    a(bufferedOutputStream);
                } catch (IOException e2) {
                    e = e2;
                    outputStream = bufferedOutputStream;
                    com.kwai.sodler.lib.a.a("plugin.files", e);
                    a((Object) fileInputStream);
                    a(outputStream);
                } catch (Throwable th2) {
                    th = th2;
                    outputStream = bufferedOutputStream;
                    a((Object) fileInputStream);
                    a(outputStream);
                    throw th;
                }
            } catch (IOException e3) {
                e = e3;
                outputStream = null;
            } catch (Throwable th3) {
                th = th3;
                outputStream = null;
            }
        } catch (IOException e4) {
            e = e4;
            outputStream = null;
            fileInputStream = null;
        } catch (Throwable th4) {
            th = th4;
            outputStream = null;
            fileInputStream = null;
        }
    }

    @SuppressLint({"NewApi"})
    public static void a(Object obj) {
        if (obj == null) {
            return;
        }
        if (obj instanceof Closeable) {
            try {
                ((Closeable) obj).close();
            } catch (Throwable th) {
            }
        } else if (Build.VERSION.SDK_INT < 19 || !(obj instanceof AutoCloseable)) {
        } else {
            try {
                ((AutoCloseable) obj).close();
            } catch (Throwable th2) {
            }
        }
    }

    public static boolean a(File file) {
        if (file == null) {
            return false;
        }
        return file.isDirectory() ? c(file) : b(file);
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return a(new File(str));
    }

    static boolean b(File file) {
        boolean z = true;
        if (file != null && file.exists()) {
            com.kwai.sodler.lib.a.c("plugin.files", "safeDeleteFile, try to delete path: " + file.getPath());
            z = file.delete();
            if (!z) {
                com.kwai.sodler.lib.a.d("plugin.files", "Failed to delete file, try to delete when exit. path: " + file.getPath());
                file.deleteOnExit();
            }
        }
        return z;
    }

    public static boolean b(String str) {
        return !TextUtils.isEmpty(str) && new File(str).exists();
    }

    static boolean c(File file) {
        File[] listFiles;
        if (file == null || !file.exists()) {
            return false;
        }
        if (file.isFile()) {
            b(file);
        } else if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                c(file2);
            }
            b(file);
        }
        return true;
    }

    public static void d(File file) {
        if (file == null) {
            throw new IOException("File is null.");
        }
        if (file.exists()) {
            a(file);
        }
        File parentFile = file.getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        if (!file.createNewFile()) {
            throw new IOException("Create file fail, file already exists.");
        }
    }

    public static void e(File file) {
        if (file == null) {
            throw new IOException("Dir is null.");
        }
        if (!file.exists()) {
            file.mkdirs();
        } else if (file.isDirectory()) {
            return;
        } else {
            if (!a(file)) {
                throw new IOException("Fail to delete existing file, file = " + file.getAbsolutePath());
            }
            file.mkdir();
        }
        if (!file.exists() || !file.isDirectory()) {
            throw new IOException("Fail to create dir, dir = " + file.getAbsolutePath());
        }
    }

    public static String f(File file) {
        Throwable th;
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        String str = null;
        if (file != null && file.exists()) {
            try {
                fileInputStream2 = new FileInputStream(file);
                try {
                    str = a((InputStream) fileInputStream2);
                    a((Object) fileInputStream2);
                } catch (Exception e) {
                    a((Object) fileInputStream2);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = fileInputStream2;
                    a((Object) fileInputStream);
                    throw th;
                }
            } catch (Exception e2) {
                fileInputStream2 = null;
            } catch (Throwable th3) {
                th = th3;
                fileInputStream = null;
            }
        }
        return str;
    }
}
