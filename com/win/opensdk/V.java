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
/* loaded from: classes7.dex */
public class V {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f42489a;

    /* renamed from: b  reason: collision with root package name */
    public ByteBuffer f42490b;

    /* renamed from: c  reason: collision with root package name */
    public U f42491c;

    /* renamed from: d  reason: collision with root package name */
    public int f42492d;

    public V() {
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
        this.f42489a = new byte[256];
        this.f42492d = 0;
    }

    public V a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bArr)) == null) {
            if (bArr != null) {
                ByteBuffer wrap = ByteBuffer.wrap(bArr);
                this.f42490b = null;
                Arrays.fill(this.f42489a, (byte) 0);
                this.f42491c = new U();
                this.f42492d = 0;
                ByteBuffer asReadOnlyBuffer = wrap.asReadOnlyBuffer();
                this.f42490b = asReadOnlyBuffer;
                asReadOnlyBuffer.position(0);
                this.f42490b.order(ByteOrder.LITTLE_ENDIAN);
            } else {
                this.f42490b = null;
                this.f42491c.f42479b = 2;
            }
            return this;
        }
        return (V) invokeL.objValue;
    }

    public final boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f42491c.f42479b != 0 : invokeV.booleanValue;
    }

    public final int[] a(int i2) {
        InterceptResult invokeI;
        int[] iArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            byte[] bArr = new byte[i2 * 3];
            try {
                this.f42490b.get(bArr);
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
                        this.f42491c.f42479b = 1;
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
                return this.f42490b.get() & 255;
            } catch (Exception unused) {
                this.f42491c.f42479b = 1;
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
            this.f42492d = b2;
            int i2 = 0;
            if (b2 > 0) {
                while (i2 < this.f42492d) {
                    try {
                        int i3 = this.f42492d - i2;
                        this.f42490b.get(this.f42489a, i2, i3);
                        i2 += i3;
                    } catch (Exception unused) {
                        this.f42491c.f42479b = 1;
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
                    this.f42490b.position(this.f42490b.position() + b2);
                } catch (IllegalArgumentException unused) {
                    return;
                }
            } while (b2 > 0);
        }
    }
}
