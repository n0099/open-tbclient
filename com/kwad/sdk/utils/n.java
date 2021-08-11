package com.kwad.sdk.utils;

import android.os.Build;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.charset.Charset;
/* loaded from: classes10.dex */
public class n {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(Reader reader, Writer writer) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, reader, writer)) == null) {
            long b2 = b(reader, writer);
            if (b2 > 2147483647L) {
                return -1;
            }
            return (int) b2;
        }
        return invokeLL.intValue;
    }

    public static long a(Reader reader, Writer writer, char[] cArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLLL = interceptable.invokeLLL(65537, null, reader, writer, cArr)) != null) {
            return invokeLLL.longValue;
        }
        long j2 = 0;
        while (true) {
            int read = reader.read(cArr);
            if (-1 == read) {
                return j2;
            }
            writer.write(cArr, 0, read);
            j2 += read;
        }
    }

    public static FileInputStream a(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, file)) == null) {
            if (file.exists() && !file.isDirectory() && file.canRead()) {
                return new FileInputStream(file);
            }
            return null;
        }
        return (FileInputStream) invokeL.objValue;
    }

    @Nullable
    public static FileOutputStream a(File file, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65539, null, file, z)) == null) {
            if (!file.exists()) {
                File parentFile = file.getParentFile();
                if (parentFile != null && !parentFile.mkdirs() && !parentFile.isDirectory()) {
                    return null;
                }
            } else if (file.isDirectory() || !file.canWrite()) {
                return null;
            }
            return new FileOutputStream(file, z);
        }
        return (FileOutputStream) invokeLZ.objValue;
    }

    @Nullable
    public static String a(File file, Charset charset) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, file, charset)) != null) {
            return (String) invokeLL.objValue;
        }
        FileInputStream fileInputStream = null;
        try {
            FileInputStream a2 = a(file);
            if (a2 == null) {
                a(a2);
                return null;
            }
            try {
                String a3 = a(a2, a(charset));
                a(a2);
                return a3;
            } catch (Throwable th) {
                th = th;
                fileInputStream = a2;
                a(fileInputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Nullable
    public static String a(InputStream inputStream, Charset charset) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, inputStream, charset)) == null) {
            if (inputStream == null) {
                return null;
            }
            StringWriter stringWriter = new StringWriter();
            a(inputStream, stringWriter, charset);
            return stringWriter.toString();
        }
        return (String) invokeLL.objValue;
    }

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, str)) == null) {
            if (Build.VERSION.SDK_INT >= 19) {
                return new String(com.kwad.sdk.core.b.c.a().a(l.a(b(new File(str)))));
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static Charset a(Charset charset) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, charset)) == null) ? charset == null ? Charset.defaultCharset() : charset : (Charset) invokeL.objValue;
    }

    public static void a(Closeable closeable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65544, null, closeable) == null) || closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (Exception unused) {
        }
    }

    public static void a(File file, String str, Charset charset, boolean z) {
        FileOutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeCommon(65545, null, new Object[]{file, str, charset, Boolean.valueOf(z)}) != null) {
            return;
        }
        try {
            fileOutputStream = a(file, z);
            if (fileOutputStream != null) {
                try {
                    a(str, fileOutputStream, charset);
                } catch (Throwable th) {
                    th = th;
                    a(fileOutputStream);
                    throw th;
                }
            }
            a(fileOutputStream);
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = null;
        }
    }

    public static void a(InputStream inputStream, Writer writer, Charset charset) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65546, null, inputStream, writer, charset) == null) {
            a(new InputStreamReader(inputStream, a(charset)), writer);
        }
    }

    public static void a(String str, OutputStream outputStream, Charset charset) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65547, null, str, outputStream, charset) == null) || outputStream == null || str == null) {
            return;
        }
        outputStream.write(str.getBytes(a(charset)));
    }

    public static long b(Reader reader, Writer writer) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65548, null, reader, writer)) == null) ? a(reader, writer, new char[4096]) : invokeLL.longValue;
    }

    public static byte[] b(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, file)) == null) {
            byte[] bArr = new byte[(int) file.length()];
            FileInputStream fileInputStream = null;
            try {
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    fileInputStream2.read(bArr);
                    com.kwad.sdk.crash.utils.b.a((InputStream) fileInputStream2);
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    try {
                        com.kwad.sdk.core.d.a.a(th);
                        return bArr;
                    } finally {
                        com.kwad.sdk.crash.utils.b.a((InputStream) fileInputStream);
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
            return bArr;
        }
        return (byte[]) invokeL.objValue;
    }
}
