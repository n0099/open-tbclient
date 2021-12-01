package com.facebook.common.util;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.ByteStreams;
import com.facebook.common.internal.Preconditions;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes12.dex */
public class StreamUtil {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public StreamUtil() {
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

    public static byte[] getBytesFromStream(InputStream inputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, inputStream)) == null) ? getBytesFromStream(inputStream, inputStream.available()) : (byte[]) invokeL.objValue;
    }

    public static long skip(InputStream inputStream, long j2) throws IOException {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65539, null, inputStream, j2)) == null) {
            Preconditions.checkNotNull(inputStream);
            Preconditions.checkArgument(j2 >= 0);
            long j3 = j2;
            while (j3 > 0) {
                long skip = inputStream.skip(j3);
                if (skip <= 0) {
                    if (inputStream.read() == -1) {
                        return j2 - j3;
                    }
                    skip = 1;
                }
                j3 -= skip;
            }
            return j2;
        }
        return invokeLJ.longValue;
    }

    public static byte[] getBytesFromStream(InputStream inputStream, int i2) throws IOException {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, inputStream, i2)) == null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(i2) { // from class: com.facebook.common.util.StreamUtil.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(i2);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {Integer.valueOf(i2)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            super(((Integer) newInitContext.callArgs[0]).intValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                }

                @Override // java.io.ByteArrayOutputStream
                public byte[] toByteArray() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        int i3 = ((ByteArrayOutputStream) this).count;
                        byte[] bArr = ((ByteArrayOutputStream) this).buf;
                        return i3 == bArr.length ? bArr : super.toByteArray();
                    }
                    return (byte[]) invokeV.objValue;
                }
            };
            ByteStreams.copy(inputStream, byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        }
        return (byte[]) invokeLI.objValue;
    }
}
