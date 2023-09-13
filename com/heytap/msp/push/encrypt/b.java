package com.heytap.msp.push.encrypt;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.apache.commons.codec.BinaryDecoder;
import org.apache.commons.codec.BinaryEncoder;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.binary.StringUtils;
/* loaded from: classes10.dex */
public abstract class b implements BinaryDecoder, BinaryEncoder {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int a = 2;
    public static final int b = 76;
    public static final int c = 64;
    public static final int d = 255;
    public static final byte e = 61;
    public static final int m = 8192;
    public transient /* synthetic */ FieldHolder $fh;
    public final byte f;
    public final int g;
    public byte[] h;
    public int i;
    public boolean j;
    public int k;
    public int l;
    public final int n;
    public final int o;
    public final int p;
    public int q;

    public b(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f = (byte) 61;
        this.n = i;
        this.o = i2;
        this.g = (i3 <= 0 || i4 <= 0) ? 0 : (i3 / i2) * i2;
        this.p = i4;
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            byte[] bArr = this.h;
            if (bArr == null) {
                this.h = new byte[d()];
                this.i = 0;
                this.q = 0;
                return;
            }
            byte[] bArr2 = new byte[bArr.length * 2];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            this.h = bArr2;
        }
    }

    public static boolean c(byte b2) {
        InterceptResult invokeB;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeB = interceptable.invokeB(65538, null, b2)) == null) ? b2 == 9 || b2 == 10 || b2 == 13 || b2 == 32 : invokeB.booleanValue;
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            this.h = null;
            this.i = 0;
            this.q = 0;
            this.k = 0;
            this.l = 0;
            this.j = false;
        }
    }

    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            byte[] bArr = this.h;
            if (bArr == null || bArr.length < this.i + i) {
                a();
            }
        }
    }

    public abstract void a(byte[] bArr, int i, int i2);

    public abstract void b(byte[] bArr, int i, int i2);

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.h != null : invokeV.booleanValue;
    }

    public abstract boolean b(byte b2);

    public boolean b(byte[] bArr, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048581, this, bArr, z)) == null) {
            for (int i = 0; i < bArr.length; i++) {
                if (!b(bArr[i]) && (!z || (bArr[i] != 61 && !c(bArr[i])))) {
                    return false;
                }
            }
            return true;
        }
        return invokeLZ.booleanValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.h != null) {
                return this.i - this.q;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public int c(byte[] bArr, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048583, this, bArr, i, i2)) == null) {
            if (this.h == null) {
                return this.j ? -1 : 0;
            }
            int min = Math.min(c(), i2);
            System.arraycopy(this.h, this.q, bArr, i, min);
            int i3 = this.q + min;
            this.q = i3;
            if (i3 >= this.i) {
                this.h = null;
            }
            return min;
        }
        return invokeLII.intValue;
    }

    public byte[] c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) ? decode(StringUtils.getBytesUtf8(str)) : (byte[]) invokeL.objValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return 8192;
        }
        return invokeV.intValue;
    }

    public boolean d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) ? b(StringUtils.getBytesUtf8(str), true) : invokeL.booleanValue;
    }

    @Override // org.apache.commons.codec.Decoder
    public Object decode(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, obj)) == null) {
            if (obj instanceof byte[]) {
                return decode((byte[]) obj);
            }
            if (obj instanceof String) {
                return c((String) obj);
            }
            throw new DecoderException("Parameter supplied to Base-N decode is not a byte[] or a String");
        }
        return invokeL.objValue;
    }

    @Override // org.apache.commons.codec.BinaryDecoder
    public byte[] decode(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, bArr)) == null) {
            e();
            if (bArr == null || bArr.length == 0) {
                return bArr;
            }
            b(bArr, 0, bArr.length);
            b(bArr, 0, -1);
            int i = this.i;
            byte[] bArr2 = new byte[i];
            c(bArr2, 0, i);
            return bArr2;
        }
        return (byte[]) invokeL.objValue;
    }

    @Override // org.apache.commons.codec.Encoder
    public Object encode(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, obj)) == null) {
            if (obj instanceof byte[]) {
                return encode((byte[]) obj);
            }
            throw new EncoderException("Parameter supplied to Base-N encode is not a byte[]");
        }
        return invokeL.objValue;
    }

    @Override // org.apache.commons.codec.BinaryEncoder
    public byte[] encode(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, bArr)) == null) {
            e();
            if (bArr == null || bArr.length == 0) {
                return bArr;
            }
            a(bArr, 0, bArr.length);
            a(bArr, 0, -1);
            int i = this.i - this.q;
            byte[] bArr2 = new byte[i];
            c(bArr2, 0, i);
            return bArr2;
        }
        return (byte[]) invokeL.objValue;
    }

    public String j(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, bArr)) == null) ? StringUtils.newStringUtf8(encode(bArr)) : (String) invokeL.objValue;
    }

    public String k(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, bArr)) == null) ? StringUtils.newStringUtf8(encode(bArr)) : (String) invokeL.objValue;
    }

    public boolean l(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, bArr)) == null) {
            if (bArr == null) {
                return false;
            }
            for (byte b2 : bArr) {
                if (61 == b2 || b(b2)) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public long m(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, bArr)) == null) {
            int length = bArr.length;
            int i = this.n;
            long j = (((length + i) - 1) / i) * this.o;
            int i2 = this.g;
            return i2 > 0 ? j + ((((i2 + j) - 1) / i2) * this.p) : j;
        }
        return invokeL.longValue;
    }
}
