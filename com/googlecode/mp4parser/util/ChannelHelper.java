package com.googlecode.mp4parser.util;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
/* loaded from: classes6.dex */
public class ChannelHelper {
    public static /* synthetic */ Interceptable $ic;
    public static ByteBuffer empty;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(775596489, "Lcom/googlecode/mp4parser/util/ChannelHelper;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(775596489, "Lcom/googlecode/mp4parser/util/ChannelHelper;");
                return;
            }
        }
        empty = ByteBuffer.allocate(0).asReadOnlyBuffer();
    }

    public ChannelHelper() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void readFully(ReadableByteChannel readableByteChannel, ByteBuffer byteBuffer) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, readableByteChannel, byteBuffer) == null) {
            readFully(readableByteChannel, byteBuffer, byteBuffer.remaining());
        }
    }

    public static int readFully(ReadableByteChannel readableByteChannel, ByteBuffer byteBuffer, int i2) throws IOException {
        InterceptResult invokeLLI;
        int read;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65538, null, readableByteChannel, byteBuffer, i2)) == null) {
            int i3 = 0;
            do {
                read = readableByteChannel.read(byteBuffer);
                if (-1 == read) {
                    break;
                }
                i3 += read;
            } while (i3 != i2);
            if (read != -1) {
                return i3;
            }
            throw new EOFException("End of file. No more boxes.");
        }
        return invokeLLI.intValue;
    }
}
