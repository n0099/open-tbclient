package com.kwad.sdk.crash.utils;

import android.text.TextUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
/* loaded from: classes7.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final char f37013a;

    /* renamed from: b  reason: collision with root package name */
    public static final String f37014b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(639243252, "Lcom/kwad/sdk/crash/utils/h;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(639243252, "Lcom/kwad/sdk/crash/utils/h;");
                return;
            }
        }
        f37013a = File.separatorChar;
        StringBuilderWriter stringBuilderWriter = new StringBuilderWriter(4);
        PrintWriter printWriter = new PrintWriter(stringBuilderWriter);
        printWriter.println();
        f37014b = stringBuilderWriter.toString();
        printWriter.close();
    }

    public static int a(Reader reader, Writer writer) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, reader, writer)) == null) {
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
        if (interceptable != null && (invokeLLL = interceptable.invokeLLL(65538, null, reader, writer, cArr)) != null) {
            return invokeLLL.longValue;
        }
        long j = 0;
        while (true) {
            int read = reader.read(cArr);
            if (-1 == read) {
                return j;
            }
            writer.write(cArr, 0, read);
            j += read;
        }
    }

    public static String a(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, file)) == null) ? a(new InputStreamReader(new BufferedInputStream(new FileInputStream(file)), StandardCharsets.UTF_8)) : (String) invokeL.objValue;
    }

    public static String a(InputStream inputStream) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65540, null, inputStream)) == null) ? a(inputStream, Charset.defaultCharset()) : (String) invokeL.objValue;
    }

    public static String a(InputStream inputStream, Charset charset) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, inputStream, charset)) == null) {
            StringBuilderWriter stringBuilderWriter = new StringBuilderWriter();
            a(inputStream, stringBuilderWriter, charset);
            return stringBuilderWriter.toString();
        }
        return (String) invokeLL.objValue;
    }

    public static String a(Reader reader) {
        InterceptResult invokeL;
        StringWriter stringWriter;
        Throwable th;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, reader)) != null) {
            return (String) invokeL.objValue;
        }
        StringWriter stringWriter2 = new StringWriter();
        try {
            stringWriter = new StringWriter();
            try {
                char[] cArr = new char[1024];
                while (true) {
                    int read = reader.read(cArr);
                    if (read == -1) {
                        String stringWriter3 = stringWriter.toString();
                        b.a(reader);
                        b.a((Writer) stringWriter);
                        return stringWriter3;
                    }
                    stringWriter.write(cArr, 0, read);
                }
            } catch (Throwable th2) {
                th = th2;
                b.a(reader);
                b.a((Writer) stringWriter);
                throw th;
            }
        } catch (Throwable th3) {
            stringWriter = stringWriter2;
            th = th3;
        }
    }

    public static void a(InputStream inputStream, Writer writer, Charset charset) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65543, null, inputStream, writer, charset) == null) {
            a(new InputStreamReader(inputStream, a.a(charset)), writer);
        }
    }

    public static void a(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65544, null, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        File file = new File(str);
        if (file.exists() && file.isFile()) {
            file.delete();
        }
    }

    public static void a(String str, OutputStream outputStream, Charset charset) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65545, null, str, outputStream, charset) == null) || str == null) {
            return;
        }
        outputStream.write(str.getBytes(a.a(charset)));
    }

    public static long b(Reader reader, Writer writer) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, reader, writer)) == null) ? a(reader, writer, new char[4096]) : invokeLL.longValue;
    }

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, str) == null) {
            try {
                a(str);
            } catch (Throwable unused) {
            }
        }
    }
}
