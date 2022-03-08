package com.tachikoma.core.utility;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
/* loaded from: classes8.dex */
public class IOUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEFAULT_BUFFER_SIZE = 4096;
    public static final int EOF = -1;
    public transient /* synthetic */ FieldHolder $fh;

    public IOUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static int copy(InputStream inputStream, OutputStream outputStream) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, inputStream, outputStream)) == null) {
            long copyLarge = copyLarge(inputStream, outputStream);
            if (copyLarge > 2147483647L) {
                return -1;
            }
            return (int) copyLarge;
        }
        return invokeLL.intValue;
    }

    public static long copyLarge(InputStream inputStream, OutputStream outputStream) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, inputStream, outputStream)) == null) ? copyLarge(inputStream, outputStream, new byte[4096]) : invokeLL.longValue;
    }

    public static long copyLarge(InputStream inputStream, OutputStream outputStream, byte[] bArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLLL = interceptable.invokeLLL(65539, null, inputStream, outputStream, bArr)) != null) {
            return invokeLLL.longValue;
        }
        long j2 = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (-1 == read) {
                return j2;
            }
            outputStream.write(bArr, 0, read);
            j2 += read;
        }
    }

    public static long copyLarge(Reader reader, Writer writer) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, reader, writer)) == null) ? copyLarge(reader, writer, new char[4096]) : invokeLL.longValue;
    }

    public static long copyLarge(Reader reader, Writer writer, char[] cArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLLL = interceptable.invokeLLL(65541, null, reader, writer, cArr)) != null) {
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
}
