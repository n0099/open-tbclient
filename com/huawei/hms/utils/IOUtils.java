package com.huawei.hms.utils;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.support.log.HMSLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
/* loaded from: classes10.dex */
public final class IOUtils {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public IOUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void closeQuietly(Closeable closeable) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, closeable) == null) && closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
                HMSLog.e("IOUtils", "An exception occurred while closing the 'Closeable' object.");
            }
        }
    }

    public static byte[] toByteArray(InputStream inputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, inputStream)) == null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            copy(inputStream, byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        }
        return (byte[]) invokeL.objValue;
    }

    public static InputStream toInputStream(byte[] bArr) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, bArr)) == null) {
            return new ByteArrayInputStream(bArr);
        }
        return (InputStream) invokeL.objValue;
    }

    public static void closeQuietly(InputStream inputStream) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, inputStream) == null) {
            closeQuietly((Closeable) inputStream);
        }
    }

    public static void closeQuietly(OutputStream outputStream) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, outputStream) == null) {
            closeQuietly((Closeable) outputStream);
        }
    }

    public static void closeQuietly(Reader reader) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, reader) == null) {
            closeQuietly((Closeable) reader);
        }
    }

    public static void closeQuietly(Writer writer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, writer) == null) {
            closeQuietly((Closeable) writer);
        }
    }

    public static long copy(InputStream inputStream, OutputStream outputStream) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, inputStream, outputStream)) == null) {
            return copy(inputStream, outputStream, new byte[4096]);
        }
        return invokeLL.longValue;
    }

    public static long copy(InputStream inputStream, OutputStream outputStream, byte[] bArr) throws IOException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65543, null, inputStream, outputStream, bArr)) == null) {
            long j = 0;
            while (true) {
                int read = inputStream.read(bArr);
                if (-1 != read) {
                    outputStream.write(bArr, 0, read);
                    j += read;
                } else {
                    return j;
                }
            }
        } else {
            return invokeLLL.longValue;
        }
    }
}
