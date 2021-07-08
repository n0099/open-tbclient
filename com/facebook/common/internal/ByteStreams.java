package com.facebook.common.internal;

import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
/* loaded from: classes5.dex */
public final class ByteStreams {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int BUF_SIZE = 4096;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.facebook.common.internal.ByteStreams$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes5.dex */
    public static final class FastByteArrayOutputStream extends ByteArrayOutputStream {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public FastByteArrayOutputStream() {
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

        public void writeTo(byte[] bArr, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, bArr, i2) == null) {
                System.arraycopy(((ByteArrayOutputStream) this).buf, 0, bArr, i2, ((ByteArrayOutputStream) this).count);
            }
        }

        public /* synthetic */ FastByteArrayOutputStream(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public ByteStreams() {
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

    public static long copy(InputStream inputStream, OutputStream outputStream) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(65537, null, inputStream, outputStream)) != null) {
            return invokeLL.longValue;
        }
        Preconditions.checkNotNull(inputStream);
        Preconditions.checkNotNull(outputStream);
        byte[] bArr = new byte[4096];
        long j = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return j;
            }
            outputStream.write(bArr, 0, read);
            j += read;
        }
    }

    public static int read(InputStream inputStream, byte[] bArr, int i2, int i3) throws IOException {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(65538, null, inputStream, bArr, i2, i3)) == null) {
            Preconditions.checkNotNull(inputStream);
            Preconditions.checkNotNull(bArr);
            if (i3 >= 0) {
                int i4 = 0;
                while (i4 < i3) {
                    int read = inputStream.read(bArr, i2 + i4, i3 - i4);
                    if (read == -1) {
                        break;
                    }
                    i4 += read;
                }
                return i4;
            }
            throw new IndexOutOfBoundsException("len is negative");
        }
        return invokeLLII.intValue;
    }

    public static void readFully(InputStream inputStream, byte[] bArr, int i2, int i3) throws IOException {
        int read;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLII(65539, null, inputStream, bArr, i2, i3) == null) || (read = read(inputStream, bArr, i2, i3)) == i3) {
            return;
        }
        throw new EOFException("reached end of stream after reading " + read + " bytes; " + i3 + " bytes expected");
    }

    public static byte[] toByteArray(InputStream inputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, inputStream)) == null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            copy(inputStream, byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        }
        return (byte[]) invokeL.objValue;
    }

    public static byte[] toByteArray(InputStream inputStream, int i2) throws IOException {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(AdIconUtil.AD_TEXT_ID, null, inputStream, i2)) == null) {
            byte[] bArr = new byte[i2];
            int i3 = i2;
            while (i3 > 0) {
                int i4 = i2 - i3;
                int read = inputStream.read(bArr, i4, i3);
                if (read == -1) {
                    return Arrays.copyOf(bArr, i4);
                }
                i3 -= read;
            }
            int read2 = inputStream.read();
            if (read2 == -1) {
                return bArr;
            }
            FastByteArrayOutputStream fastByteArrayOutputStream = new FastByteArrayOutputStream(null);
            fastByteArrayOutputStream.write(read2);
            copy(inputStream, fastByteArrayOutputStream);
            byte[] bArr2 = new byte[fastByteArrayOutputStream.size() + i2];
            System.arraycopy(bArr, 0, bArr2, 0, i2);
            fastByteArrayOutputStream.writeTo(bArr2, i2);
            return bArr2;
        }
        return (byte[]) invokeLI.objValue;
    }
}
