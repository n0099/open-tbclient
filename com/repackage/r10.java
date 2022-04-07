package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.security.GeneralSecurityException;
import java.util.Random;
/* loaded from: classes7.dex */
public class r10 {
    public static /* synthetic */ Interceptable $ic;
    public static final int[] b;
    public transient /* synthetic */ FieldHolder $fh;
    public final int a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755403328, "Lcom/repackage/r10;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755403328, "Lcom/repackage/r10;");
                return;
            }
        }
        b = n(new byte[]{Constants.SHORT_PING_CMD_TYPE, 120, 112, 97, 110, 100, 32, 51, 50, 45, 98, 121, 116, Constants.SHORT_PING_CMD_TYPE, 32, 107});
    }

    public r10(int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = i;
    }

    public static int b(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(65538, null, i, i2)) == null) ? (i >>> (-i2)) | (i << i2) : invokeII.intValue;
    }

    public static void f(int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, iArr) == null) {
            for (int i = 0; i < 10; i++) {
                g(iArr, 0, 4, 8, 12);
                g(iArr, 1, 5, 9, 13);
                g(iArr, 2, 6, 10, 14);
                g(iArr, 3, 7, 11, 15);
                g(iArr, 0, 5, 10, 15);
                g(iArr, 1, 6, 11, 12);
                g(iArr, 2, 7, 8, 13);
                g(iArr, 3, 4, 9, 14);
            }
        }
    }

    public static void g(int[] iArr, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{iArr, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            iArr[i] = iArr[i] + iArr[i2];
            iArr[i4] = b(iArr[i4] ^ iArr[i], 16);
            iArr[i3] = iArr[i3] + iArr[i4];
            iArr[i2] = b(iArr[i2] ^ iArr[i3], 12);
            iArr[i] = iArr[i] + iArr[i2];
            iArr[i4] = b(iArr[i] ^ iArr[i4], 8);
            iArr[i3] = iArr[i3] + iArr[i4];
            iArr[i2] = b(iArr[i2] ^ iArr[i3], 7);
        }
    }

    public static void h(int[] iArr, int[] iArr2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, iArr, iArr2) == null) {
            int[] iArr3 = b;
            System.arraycopy(iArr3, 0, iArr, 0, iArr3.length);
            System.arraycopy(iArr2, 0, iArr, b.length, 8);
        }
    }

    public static int[] n(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, bArr)) == null) {
            IntBuffer asIntBuffer = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN).asIntBuffer();
            int[] iArr = new int[asIntBuffer.remaining()];
            asIntBuffer.get(iArr);
            return iArr;
        }
        return (int[]) invokeL.objValue;
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return 12;
        }
        return invokeV.intValue;
    }

    public ByteBuffer c(byte[] bArr, byte[] bArr2, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bArr, bArr2, i)) == null) {
            int[] l = l(n(bArr), n(bArr2), i);
            int[] iArr = (int[]) l.clone();
            f(iArr);
            for (int i2 = 0; i2 < l.length; i2++) {
                l[i2] = l[i2] + iArr[i2];
            }
            ByteBuffer order = ByteBuffer.allocate(64).order(ByteOrder.LITTLE_ENDIAN);
            order.asIntBuffer().put(l, 0, 16);
            return order;
        }
        return (ByteBuffer) invokeLLI.objValue;
    }

    public void d(ByteBuffer byteBuffer, byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, byteBuffer, bArr, bArr2) == null) {
            if (byteBuffer.remaining() - a() < bArr.length) {
                throw new IllegalArgumentException("data output is too small");
            }
            if (bArr2 == null) {
                bArr2 = new byte[a()];
                new Random().nextBytes(bArr2);
            }
            byteBuffer.put(bArr2);
            e(bArr2, u10.b(), byteBuffer, ByteBuffer.wrap(bArr));
        }
    }

    public final void e(byte[] bArr, byte[] bArr2, ByteBuffer byteBuffer, ByteBuffer byteBuffer2) throws GeneralSecurityException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048579, this, bArr, bArr2, byteBuffer, byteBuffer2) == null) {
            int remaining = byteBuffer2.remaining();
            int i = (remaining / 64) + 1;
            for (int i2 = 0; i2 < i; i2++) {
                ByteBuffer c = c(bArr, bArr2, this.a + i2);
                if (i2 == i - 1) {
                    q10.a(byteBuffer, byteBuffer2, c, remaining % 64);
                } else {
                    q10.a(byteBuffer, byteBuffer2, c, 64);
                }
            }
        }
    }

    public byte[] i(ByteBuffer byteBuffer) throws GeneralSecurityException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, byteBuffer)) == null) {
            if (byteBuffer.remaining() >= a()) {
                byte[] bArr = new byte[a()];
                byteBuffer.get(bArr);
                ByteBuffer allocate = ByteBuffer.allocate(byteBuffer.remaining());
                e(bArr, u10.a(), allocate, byteBuffer);
                return allocate.array();
            }
            throw new GeneralSecurityException("data too short");
        }
        return (byte[]) invokeL.objValue;
    }

    public byte[] j(byte[] bArr) throws GeneralSecurityException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, bArr)) == null) ? i(ByteBuffer.wrap(bArr)) : (byte[]) invokeL.objValue;
    }

    public byte[] k(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, bArr, bArr2)) == null) {
            if (bArr.length <= Integer.MAX_VALUE - a()) {
                ByteBuffer allocate = ByteBuffer.allocate(a() + bArr.length);
                d(allocate, bArr, bArr2);
                return allocate.array();
            }
            throw new GeneralSecurityException("data too long");
        }
        return (byte[]) invokeLL.objValue;
    }

    public int[] l(int[] iArr, int[] iArr2, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048583, this, iArr, iArr2, i)) == null) {
            if (iArr.length == a() / 4) {
                int[] iArr3 = new int[16];
                h(iArr3, iArr2);
                iArr3[12] = i;
                System.arraycopy(iArr, 0, iArr3, 13, iArr.length);
                return iArr3;
            }
            throw new IllegalArgumentException(String.format("need 96-bit param, but got a %d-bit param", Integer.valueOf(iArr.length * 32)));
        }
        return (int[]) invokeLLI.objValue;
    }

    public byte[] m(byte[] bArr) throws GeneralSecurityException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bArr)) == null) ? k(bArr, null) : (byte[]) invokeL.objValue;
    }
}
