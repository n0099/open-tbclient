package com.huawei.hms.framework.common;

import android.database.Cursor;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
/* loaded from: classes10.dex */
public class IoUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int BUFF_SIZE = 4096;
    public static final int MAX_SIZE = 16777216;
    public transient /* synthetic */ FieldHolder $fh;

    public IoUtils() {
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

    public static void close(Cursor cursor) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, cursor) == null) && cursor != null) {
            cursor.close();
        }
    }

    public static void closeSecure(Closeable closeable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, closeable) == null) {
            if (closeable != null) {
                try {
                    closeable.close();
                    return;
                } catch (IOException e) {
                    Logger.w("IOUtil", "closeSecure IOException", e);
                    return;
                }
            }
            Logger.w("IOUtil", "closeable is null");
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

    public static void closeSecure(InputStream inputStream) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, inputStream) == null) {
            closeSecure((Closeable) inputStream);
        }
    }

    public static void closeSecure(OutputStream outputStream) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, outputStream) == null) {
            closeSecure((Closeable) outputStream);
        }
    }

    public static void closeSecure(Reader reader) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, reader) == null) {
            closeSecure((Closeable) reader);
        }
    }

    public static void closeSecure(Writer writer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, writer) == null) {
            closeSecure((Closeable) writer);
        }
    }

    public static long copy(InputStream inputStream, OutputStream outputStream) throws IOException {
        InterceptResult invokeLL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, inputStream, outputStream)) == null) {
            if (ContextHolder.getAppContext() != null) {
                str = ContextHolder.getAppContext().getPackageName();
            } else {
                str = "";
            }
            byte[] bArr = new byte[4096];
            long j = 0;
            while (true) {
                int read = inputStream.read(bArr);
                if (-1 != read) {
                    if (j > 16777216 && !"com.huawei.health".equals(str)) {
                        throw new IOException("input data too large for byte.");
                    }
                    outputStream.write(bArr, 0, read);
                    j += read;
                } else {
                    return j;
                }
            }
        } else {
            return invokeLL.longValue;
        }
    }
}
