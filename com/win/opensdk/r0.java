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
/* loaded from: classes10.dex */
public class r0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f77471a;

    /* renamed from: b  reason: collision with root package name */
    public ByteBuffer f77472b;

    /* renamed from: c  reason: collision with root package name */
    public q0 f77473c;

    /* renamed from: d  reason: collision with root package name */
    public int f77474d;

    public r0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f77471a = new byte[256];
        this.f77474d = 0;
    }

    public r0 a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bArr)) == null) {
            if (bArr != null) {
                ByteBuffer wrap = ByteBuffer.wrap(bArr);
                this.f77472b = null;
                Arrays.fill(this.f77471a, (byte) 0);
                this.f77473c = new q0();
                this.f77474d = 0;
                ByteBuffer asReadOnlyBuffer = wrap.asReadOnlyBuffer();
                this.f77472b = asReadOnlyBuffer;
                asReadOnlyBuffer.position(0);
                this.f77472b.order(ByteOrder.LITTLE_ENDIAN);
            } else {
                this.f77472b = null;
                this.f77473c.f77461b = 2;
            }
            return this;
        }
        return (r0) invokeL.objValue;
    }

    public final boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f77473c.f77461b != 0 : invokeV.booleanValue;
    }

    public final int[] a(int i2) {
        InterceptResult invokeI;
        int[] iArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            byte[] bArr = new byte[i2 * 3];
            try {
                this.f77472b.get(bArr);
                iArr = new int[256];
                int i3 = 0;
                int i4 = 0;
                while (i3 < i2) {
                    int i5 = i4 + 1;
                    try {
                        int i6 = i5 + 1;
                        int i7 = i6 + 1;
                        int i8 = i3 + 1;
                        iArr[i3] = ((bArr[i4] & 255) << 16) | (-16777216) | ((bArr[i5] & 255) << 8) | (bArr[i6] & 255);
                        i4 = i7;
                        i3 = i8;
                    } catch (BufferUnderflowException unused) {
                        this.f77473c.f77461b = 1;
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
                return this.f77472b.get() & 255;
            } catch (Exception unused) {
                this.f77473c.f77461b = 1;
                return 0;
            }
        }
        return invokeV.intValue;
    }

    public final int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            int b2 = b();
            this.f77474d = b2;
            int i2 = 0;
            if (b2 > 0) {
                while (i2 < this.f77474d) {
                    try {
                        int i3 = this.f77474d - i2;
                        this.f77472b.get(this.f77471a, i2, i3);
                        i2 += i3;
                    } catch (Exception unused) {
                        this.f77473c.f77461b = 1;
                    }
                }
            }
            return i2;
        }
        return invokeV.intValue;
    }

    public final void d() {
        int b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            do {
                try {
                    b2 = b();
                    this.f77472b.position(this.f77472b.position() + b2);
                } catch (IllegalArgumentException unused) {
                    return;
                }
            } while (b2 > 0);
        }
    }
}
