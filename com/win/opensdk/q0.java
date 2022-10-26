package com.win.opensdk;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
/* loaded from: classes8.dex */
public class q0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final byte[] a;
    public ByteBuffer b;
    public p0 c;
    public int d;

    public q0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new byte[256];
        this.d = 0;
    }

    public final boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.c.b != 0 : invokeV.booleanValue;
    }

    public final int[] a(int i) {
        InterceptResult invokeI;
        int[] iArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            byte[] bArr = new byte[i * 3];
            try {
                this.b.get(bArr);
                iArr = new int[256];
                int i2 = 0;
                int i3 = 0;
                while (i2 < i) {
                    int i4 = i3 + 1;
                    try {
                        int i5 = i4 + 1;
                        int i6 = i5 + 1;
                        int i7 = i2 + 1;
                        iArr[i2] = ((bArr[i3] & 255) << 16) | (-16777216) | ((bArr[i4] & 255) << 8) | (bArr[i5] & 255);
                        i3 = i6;
                        i2 = i7;
                    } catch (BufferUnderflowException unused) {
                        this.c.b = 1;
                        return iArr;
                    }
                }
            } catch (BufferUnderflowException unused2) {
                iArr = null;
            }
            return iArr;
        }
        return (int[]) invokeI.objValue;
    }

    public final int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            try {
                return this.b.get() & 255;
            } catch (Exception unused) {
                this.c.b = 1;
                return 0;
            }
        }
        return invokeV.intValue;
    }

    public final int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            int b = b();
            this.d = b;
            int i = 0;
            if (b > 0) {
                while (i < this.d) {
                    try {
                        int i2 = this.d - i;
                        this.b.get(this.a, i, i2);
                        i += i2;
                    } catch (Exception unused) {
                        this.c.b = 1;
                    }
                }
            }
            return i;
        }
        return invokeV.intValue;
    }

    public final void d() {
        int b;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            do {
                try {
                    b = b();
                    this.b.position(this.b.position() + b);
                } catch (IllegalArgumentException unused) {
                    return;
                }
            } while (b > 0);
        }
    }

    public q0 a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bArr)) == null) {
            if (bArr != null) {
                ByteBuffer wrap = ByteBuffer.wrap(bArr);
                this.b = null;
                Arrays.fill(this.a, (byte) 0);
                this.c = new p0();
                this.d = 0;
                ByteBuffer asReadOnlyBuffer = wrap.asReadOnlyBuffer();
                this.b = asReadOnlyBuffer;
                asReadOnlyBuffer.position(0);
                this.b.order(ByteOrder.LITTLE_ENDIAN);
            } else {
                this.b = null;
                this.c.b = 2;
            }
            return this;
        }
        return (q0) invokeL.objValue;
    }
}
