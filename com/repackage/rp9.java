package com.repackage;

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
/* loaded from: classes7.dex */
public class rp9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final byte[] a;
    public ByteBuffer b;
    public np9 c;
    public int d;

    public rp9() {
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

    public rp9 a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bArr)) == null) {
            if (bArr != null) {
                ByteBuffer wrap = ByteBuffer.wrap(bArr);
                this.b = null;
                Arrays.fill(this.a, (byte) 0);
                this.c = new np9();
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
        return (rp9) invokeL.objValue;
    }

    public final boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.c.b != 0 : invokeV.booleanValue;
    }

    public final int[] c(int i) {
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

    public final int d() {
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

    public final int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            int d = d();
            this.d = d;
            int i = 0;
            if (d > 0) {
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

    public final void f() {
        int d;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            do {
                try {
                    d = d();
                    this.b.position(this.b.position() + d);
                } catch (IllegalArgumentException unused) {
                    return;
                }
            } while (d > 0);
        }
    }
}
