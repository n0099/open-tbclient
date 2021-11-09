package com.google.common.hash;

import androidx.core.view.InputDeviceCompat;
import b.i.d.a.n;
import b.i.d.d.b;
import b.i.d.d.c;
import b.i.d.d.e;
import b.i.d.d.f;
import b.i.d.d.j;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.common.primitives.Ints;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
/* loaded from: classes2.dex */
public final class Murmur3_32HashFunction extends b implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int C1 = -862048943;
    public static final int C2 = 461845907;
    public static final int CHUNK_SIZE = 4;
    public static final e GOOD_FAST_HASH_32;
    public static final e MURMUR3_32;
    public static final long serialVersionUID = 0;
    public transient /* synthetic */ FieldHolder $fh;
    public final int seed;

    /* loaded from: classes2.dex */
    public static final class a extends c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f63650a;

        /* renamed from: b  reason: collision with root package name */
        public long f63651b;

        /* renamed from: c  reason: collision with root package name */
        public int f63652c;

        /* renamed from: d  reason: collision with root package name */
        public int f63653d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f63654e;

        public a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f63650a = i2;
            this.f63653d = 0;
            this.f63654e = false;
        }

        private void update(int i2, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(65537, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j)}) == null) {
                long j2 = this.f63651b;
                int i3 = this.f63652c;
                long j3 = ((j & 4294967295L) << i3) | j2;
                this.f63651b = j3;
                int i4 = i3 + (i2 * 8);
                this.f63652c = i4;
                this.f63653d += i2;
                if (i4 >= 32) {
                    this.f63650a = Murmur3_32HashFunction.mixH1(this.f63650a, Murmur3_32HashFunction.mixK1((int) j3));
                    this.f63651b >>>= 32;
                    this.f63652c -= 32;
                }
            }
        }

        @Override // b.i.d.d.f, b.i.d.d.j
        public /* bridge */ /* synthetic */ j a(int i2) {
            a(i2);
            return this;
        }

        @Override // b.i.d.d.f, b.i.d.d.j
        public /* bridge */ /* synthetic */ j b(long j) {
            b(j);
            return this;
        }

        @Override // b.i.d.d.f
        public HashCode e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                n.w(!this.f63654e);
                this.f63654e = true;
                int mixK1 = this.f63650a ^ Murmur3_32HashFunction.mixK1((int) this.f63651b);
                this.f63650a = mixK1;
                return Murmur3_32HashFunction.fmix(mixK1, this.f63653d);
            }
            return (HashCode) invokeV.objValue;
        }

        @Override // b.i.d.d.c, b.i.d.d.f
        public f h(byte[] bArr, int i2, int i3) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(1048583, this, bArr, i2, i3)) == null) {
                n.v(i2, i2 + i3, bArr.length);
                int i4 = 0;
                while (true) {
                    int i5 = i4 + 4;
                    if (i5 > i3) {
                        break;
                    }
                    update(4, Murmur3_32HashFunction.getIntLittleEndian(bArr, i4 + i2));
                    i4 = i5;
                }
                while (i4 < i3) {
                    l(bArr[i2 + i4]);
                    i4++;
                }
                return this;
            }
            return (f) invokeLII.objValue;
        }

        @Override // b.i.d.d.f
        public f i(ByteBuffer byteBuffer) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, byteBuffer)) == null) {
                ByteOrder order = byteBuffer.order();
                byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
                while (byteBuffer.remaining() >= 4) {
                    a(byteBuffer.getInt());
                }
                while (byteBuffer.hasRemaining()) {
                    l(byteBuffer.get());
                }
                byteBuffer.order(order);
                return this;
            }
            return (f) invokeL.objValue;
        }

        @Override // b.i.d.d.c
        public f k(char c2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{Character.valueOf(c2)})) == null) {
                update(2, c2);
                return this;
            }
            return (f) invokeCommon.objValue;
        }

        public f l(byte b2) {
            InterceptResult invokeB;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeB = interceptable.invokeB(1048586, this, b2)) == null) {
                update(1, b2 & 255);
                return this;
            }
            return (f) invokeB.objValue;
        }

        @Override // b.i.d.d.f, b.i.d.d.j
        public f a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                update(4, i2);
                return this;
            }
            return (f) invokeI.objValue;
        }

        @Override // b.i.d.d.f, b.i.d.d.j
        public f b(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j)) == null) {
                update(4, (int) j);
                update(4, j >>> 32);
                return this;
            }
            return (f) invokeJ.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.i.d.d.c, b.i.d.d.f, b.i.d.d.j
        public f d(CharSequence charSequence, Charset charset) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, charSequence, charset)) == null) {
                if (b.i.d.a.c.f32966a.equals(charset)) {
                    int length = charSequence.length();
                    int i2 = 0;
                    while (true) {
                        int i3 = i2 + 4;
                        if (i3 > length) {
                            break;
                        }
                        char charAt = charSequence.charAt(i2);
                        char charAt2 = charSequence.charAt(i2 + 1);
                        char charAt3 = charSequence.charAt(i2 + 2);
                        char charAt4 = charSequence.charAt(i2 + 3);
                        if (charAt >= 128 || charAt2 >= 128 || charAt3 >= 128 || charAt4 >= 128) {
                            break;
                        }
                        update(4, (charAt2 << '\b') | charAt | (charAt3 << 16) | (charAt4 << 24));
                        i2 = i3;
                    }
                    while (i2 < length) {
                        char charAt5 = charSequence.charAt(i2);
                        if (charAt5 < 128) {
                            update(1, charAt5);
                        } else if (charAt5 < 2048) {
                            update(2, Murmur3_32HashFunction.charToTwoUtf8Bytes(charAt5));
                        } else if (charAt5 < 55296 || charAt5 > 57343) {
                            update(3, Murmur3_32HashFunction.charToThreeUtf8Bytes(charAt5));
                        } else {
                            int codePointAt = Character.codePointAt(charSequence, i2);
                            if (codePointAt != charAt5) {
                                i2++;
                                update(4, Murmur3_32HashFunction.codePointToFourUtf8Bytes(codePointAt));
                            } else {
                                f(charSequence.subSequence(i2, length).toString().getBytes(charset));
                                return this;
                            }
                        }
                        i2++;
                    }
                    return this;
                }
                return super.d(charSequence, charset);
            }
            return (f) invokeLL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2034500271, "Lcom/google/common/hash/Murmur3_32HashFunction;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2034500271, "Lcom/google/common/hash/Murmur3_32HashFunction;");
                return;
            }
        }
        MURMUR3_32 = new Murmur3_32HashFunction(0);
        GOOD_FAST_HASH_32 = new Murmur3_32HashFunction(Hashing.f63642a);
    }

    public Murmur3_32HashFunction(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.seed = i2;
    }

    public static long charToThreeUtf8Bytes(char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, null, new Object[]{Character.valueOf(c2)})) == null) ? (((c2 & '?') | 128) << 16) | (((c2 >>> '\f') | 480) & 255) | ((((c2 >>> 6) & 63) | 128) << 8) : invokeCommon.longValue;
    }

    public static long charToTwoUtf8Bytes(char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65546, null, new Object[]{Character.valueOf(c2)})) == null) ? (((c2 & '?') | 128) << 8) | (((c2 >>> 6) | 960) & 255) : invokeCommon.longValue;
    }

    public static long codePointToFourUtf8Bytes(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65547, null, i2)) == null) ? (((i2 >>> 18) | 240) & 255) | ((((i2 >>> 12) & 63) | 128) << 8) | ((((i2 >>> 6) & 63) | 128) << 16) | (((i2 & 63) | 128) << 24) : invokeI.longValue;
    }

    public static HashCode fmix(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65548, null, i2, i3)) == null) {
            int i4 = i2 ^ i3;
            int i5 = (i4 ^ (i4 >>> 16)) * (-2048144789);
            int i6 = (i5 ^ (i5 >>> 13)) * (-1028477387);
            return HashCode.fromInt(i6 ^ (i6 >>> 16));
        }
        return (HashCode) invokeII.objValue;
    }

    public static int getIntLittleEndian(byte[] bArr, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65549, null, bArr, i2)) == null) ? Ints.e(bArr[i2 + 3], bArr[i2 + 2], bArr[i2 + 1], bArr[i2]) : invokeLI.intValue;
    }

    public static int mixH1(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(65550, null, i2, i3)) == null) ? (Integer.rotateLeft(i2 ^ i3, 13) * 5) - 430675100 : invokeII.intValue;
    }

    public static int mixK1(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65551, null, i2)) == null) ? Integer.rotateLeft(i2 * C1, 15) * C2 : invokeI.intValue;
    }

    public int bits() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return 32;
        }
        return invokeV.intValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) ? (obj instanceof Murmur3_32HashFunction) && this.seed == ((Murmur3_32HashFunction) obj).seed : invokeL.booleanValue;
    }

    @Override // b.i.d.d.b
    public HashCode hashBytes(byte[] bArr, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(Constants.METHOD_SEND_USER_MSG, this, bArr, i2, i3)) == null) {
            n.v(i2, i2 + i3, bArr.length);
            int i4 = this.seed;
            int i5 = 0;
            int i6 = 0;
            while (true) {
                int i7 = i6 + 4;
                if (i7 > i3) {
                    break;
                }
                i4 = mixH1(i4, mixK1(getIntLittleEndian(bArr, i6 + i2)));
                i6 = i7;
            }
            int i8 = i6;
            int i9 = 0;
            while (i8 < i3) {
                i5 ^= b.i.d.g.b.c(bArr[i2 + i8]) << i9;
                i8++;
                i9 += 8;
            }
            return fmix(mixK1(i5) ^ i4, i3);
        }
        return (HashCode) invokeLII.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? Murmur3_32HashFunction.class.hashCode() ^ this.seed : invokeV.intValue;
    }

    @Override // b.i.d.d.b
    public HashCode hashInt(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) ? fmix(mixH1(this.seed, mixK1(i2)), 4) : (HashCode) invokeI.objValue;
    }

    @Override // b.i.d.d.b
    public HashCode hashLong(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048581, this, j)) == null) {
            return fmix(mixH1(mixH1(this.seed, mixK1((int) j)), mixK1((int) (j >>> 32))), 8);
        }
        return (HashCode) invokeJ.objValue;
    }

    @Override // b.i.d.d.b
    public HashCode hashString(CharSequence charSequence, Charset charset) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, charSequence, charset)) == null) {
            if (b.i.d.a.c.f32966a.equals(charset)) {
                int length = charSequence.length();
                int i2 = this.seed;
                int i3 = 0;
                int i4 = 0;
                int i5 = 0;
                while (true) {
                    int i6 = i4 + 4;
                    if (i6 > length) {
                        break;
                    }
                    char charAt = charSequence.charAt(i4);
                    char charAt2 = charSequence.charAt(i4 + 1);
                    char charAt3 = charSequence.charAt(i4 + 2);
                    char charAt4 = charSequence.charAt(i4 + 3);
                    if (charAt >= 128 || charAt2 >= 128 || charAt3 >= 128 || charAt4 >= 128) {
                        break;
                    }
                    i2 = mixH1(i2, mixK1((charAt2 << '\b') | charAt | (charAt3 << 16) | (charAt4 << 24)));
                    i5 += 4;
                    i4 = i6;
                }
                long j = 0;
                while (i4 < length) {
                    char charAt5 = charSequence.charAt(i4);
                    if (charAt5 < 128) {
                        j |= charAt5 << i3;
                        i3 += 8;
                        i5++;
                    } else if (charAt5 < 2048) {
                        j |= charToTwoUtf8Bytes(charAt5) << i3;
                        i3 += 16;
                        i5 += 2;
                    } else if (charAt5 >= 55296 && charAt5 <= 57343) {
                        int codePointAt = Character.codePointAt(charSequence, i4);
                        if (codePointAt == charAt5) {
                            return hashBytes(charSequence.toString().getBytes(charset));
                        }
                        i4++;
                        j |= codePointToFourUtf8Bytes(codePointAt) << i3;
                        i5 += 4;
                    } else {
                        j |= charToThreeUtf8Bytes(charAt5) << i3;
                        i3 += 24;
                        i5 += 3;
                    }
                    if (i3 >= 32) {
                        i2 = mixH1(i2, mixK1((int) j));
                        j >>>= 32;
                        i3 -= 32;
                    }
                    i4++;
                }
                return fmix(mixK1((int) j) ^ i2, i5);
            }
            return hashBytes(charSequence.toString().getBytes(charset));
        }
        return (HashCode) invokeLL.objValue;
    }

    @Override // b.i.d.d.b
    public HashCode hashUnencodedChars(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, charSequence)) == null) {
            int i2 = this.seed;
            for (int i3 = 1; i3 < charSequence.length(); i3 += 2) {
                i2 = mixH1(i2, mixK1(charSequence.charAt(i3 - 1) | (charSequence.charAt(i3) << 16)));
            }
            if ((charSequence.length() & 1) == 1) {
                i2 ^= mixK1(charSequence.charAt(charSequence.length() - 1));
            }
            return fmix(i2, charSequence.length() * 2);
        }
        return (HashCode) invokeL.objValue;
    }

    @Override // b.i.d.d.e
    public f newHasher() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? new a(this.seed) : (f) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return "Hashing.murmur3_32(" + this.seed + SmallTailInfo.EMOTION_SUFFIX;
        }
        return (String) invokeV.objValue;
    }
}
