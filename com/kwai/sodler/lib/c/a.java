package com.kwai.sodler.lib.c;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
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
/* loaded from: classes2.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static long a(InputStream inputStream, OutputStream outputStream, byte[] bArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLLL = interceptable.invokeLLL(65536, null, inputStream, outputStream, bArr)) != null) {
            return invokeLLL.longValue;
        }
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
        InterceptResult invokeL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, inputStream)) == null) {
            if (inputStream == null) {
                return null;
            }
            try {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                StringBuilder sb = new StringBuilder(32);
                byte[] bArr = new byte[102400];
                while (true) {
                    int read = bufferedInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    messageDigest.update(bArr, 0, read);
                }
                for (byte b2 : messageDigest.digest()) {
                    sb.append(Integer.toString((b2 & 255) + 256, 16).substring(1));
                }
                return sb.toString();
            } catch (Exception unused) {
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:38:0x0016 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [java.io.OutputStream, java.lang.Object, java.io.BufferedOutputStream] */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v8 */
    public static void a(Context context, String str, File file) {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLLL(65538, null, context, str, file) != null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            throw new IOException("Asset path is empty.");
        }
        d(file);
        InputStream inputStream = null;
        r0 = 0;
        ?? r0 = 0;
        inputStream = null;
        try {
            InputStream open = context.getAssets().open(str);
            try {
                fileOutputStream2 = new FileOutputStream(file);
            } catch (IOException e2) {
                e = e2;
                FileOutputStream fileOutputStream3 = r0;
                inputStream = open;
                fileOutputStream = fileOutputStream3;
            } catch (Throwable th) {
                th = th;
                FileOutputStream fileOutputStream4 = r0;
                inputStream = open;
                fileOutputStream = fileOutputStream4;
            }
            try {
                FileDescriptor fd = fileOutputStream2.getFD();
                r0 = new BufferedOutputStream(fileOutputStream2);
                a(open, (OutputStream) r0, new byte[16384]);
                r0.flush();
                fd.sync();
                a((Object) open);
                a((Object) r0);
            } catch (IOException e3) {
                inputStream = open;
                fileOutputStream = fileOutputStream2;
                e = e3;
                try {
                    com.kwai.sodler.lib.a.a("plugin.files", e);
                    a((Object) inputStream);
                    a(fileOutputStream);
                } catch (Throwable th2) {
                    th = th2;
                    a((Object) inputStream);
                    a(fileOutputStream);
                    throw th;
                }
            } catch (Throwable th3) {
                inputStream = open;
                fileOutputStream = fileOutputStream2;
                th = th3;
                a((Object) inputStream);
                a(fileOutputStream);
                throw th;
            }
        } catch (IOException e4) {
            e = e4;
            fileOutputStream = null;
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream = null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.Object, java.io.FileInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r4v11, types: [java.io.OutputStream, java.io.FileOutputStream] */
    public static void a(File file, File file2) {
        BufferedOutputStream bufferedOutputStream;
        ?? fileOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLL(65539, null, file, file2) != null) {
            return;
        }
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
        BufferedOutputStream bufferedOutputStream2 = null;
        try {
            ?? fileInputStream = new FileInputStream(file);
            try {
                fileOutputStream = new FileOutputStream(file2);
            } catch (IOException e2) {
                e = e2;
                bufferedOutputStream = bufferedOutputStream2;
                bufferedOutputStream2 = fileInputStream;
            } catch (Throwable th) {
                th = th;
                bufferedOutputStream = bufferedOutputStream2;
                bufferedOutputStream2 = fileInputStream;
            }
            try {
                FileDescriptor fd = fileOutputStream.getFD();
                bufferedOutputStream2 = new BufferedOutputStream(fileOutputStream);
                a((InputStream) fileInputStream, bufferedOutputStream2, new byte[16384]);
                bufferedOutputStream2.flush();
                fd.sync();
                a((Object) fileInputStream);
                a(bufferedOutputStream2);
            } catch (IOException e3) {
                bufferedOutputStream2 = fileInputStream;
                bufferedOutputStream = fileOutputStream;
                e = e3;
                try {
                    com.kwai.sodler.lib.a.a("plugin.files", e);
                    a(bufferedOutputStream2);
                    a(bufferedOutputStream);
                } catch (Throwable th2) {
                    th = th2;
                    a(bufferedOutputStream2);
                    a(bufferedOutputStream);
                    throw th;
                }
            } catch (Throwable th3) {
                bufferedOutputStream2 = fileInputStream;
                bufferedOutputStream = fileOutputStream;
                th = th3;
                a(bufferedOutputStream2);
                a(bufferedOutputStream);
                throw th;
            }
        } catch (IOException e4) {
            e = e4;
            bufferedOutputStream = null;
        } catch (Throwable th4) {
            th = th4;
            bufferedOutputStream = null;
        }
    }

    @SuppressLint({"NewApi"})
    public static void a(Object obj) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, obj) == null) || obj == null) {
            return;
        }
        try {
            if (obj instanceof Closeable) {
                ((Closeable) obj).close();
            } else if (Build.VERSION.SDK_INT < 19 || !(obj instanceof AutoCloseable)) {
            } else {
                ((AutoCloseable) obj).close();
            }
        } catch (Throwable unused) {
        }
    }

    public static boolean a(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, file)) == null) {
            if (file == null) {
                return false;
            }
            return file.isDirectory() ? c(file) : b(file);
        }
        return invokeL.booleanValue;
    }

    public static boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return a(new File(str));
        }
        return invokeL.booleanValue;
    }

    public static boolean b(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, file)) == null) {
            boolean z = true;
            if (file == null) {
                return true;
            }
            if (file.exists()) {
                com.kwai.sodler.lib.a.c("plugin.files", "safeDeleteFile, try to delete path: " + file.getPath());
                z = file.delete();
                if (!z) {
                    com.kwai.sodler.lib.a.d("plugin.files", "Failed to delete file, try to delete when exit. path: " + file.getPath());
                    file.deleteOnExit();
                }
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public static boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) ? !TextUtils.isEmpty(str) && new File(str).exists() : invokeL.booleanValue;
    }

    public static boolean c(File file) {
        InterceptResult invokeL;
        File[] listFiles;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, file)) == null) {
            if (file == null || !file.exists()) {
                return false;
            }
            if (!file.isFile()) {
                if (!file.isDirectory() || (listFiles = file.listFiles()) == null) {
                    return true;
                }
                for (File file2 : listFiles) {
                    c(file2);
                }
            }
            b(file);
            return true;
        }
        return invokeL.booleanValue;
    }

    public static void d(File file) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, file) == null) {
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
    }

    public static void e(File file) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, file) == null) {
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
            if (file.exists() && file.isDirectory()) {
                return;
            }
            throw new IOException("Fail to create dir, dir = " + file.getAbsolutePath());
        }
    }

    public static String f(File file) {
        InterceptResult invokeL;
        FileInputStream fileInputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, file)) == null) {
            FileInputStream fileInputStream2 = null;
            if (file != null && file.exists()) {
                try {
                    fileInputStream = new FileInputStream(file);
                    try {
                        String a2 = a((InputStream) fileInputStream);
                        a((Object) fileInputStream);
                        return a2;
                    } catch (Exception unused) {
                        a((Object) fileInputStream);
                        return null;
                    } catch (Throwable th) {
                        th = th;
                        fileInputStream2 = fileInputStream;
                        a((Object) fileInputStream2);
                        throw th;
                    }
                } catch (Exception unused2) {
                    fileInputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            return null;
        }
        return (String) invokeL.objValue;
    }
}
