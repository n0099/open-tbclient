package com.google.common.hash;

import c.i.d.d.b;
import c.i.d.d.d;
import c.i.d.d.e;
import c.i.d.d.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
/* loaded from: classes3.dex */
public final class Murmur3_128HashFunction extends b implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public static final e GOOD_FAST_HASH_128;
    public static final e MURMUR3_128;
    public static final long serialVersionUID = 0;
    public transient /* synthetic */ FieldHolder $fh;
    public final int seed;

    /* loaded from: classes3.dex */
    public static final class a extends d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: d  reason: collision with root package name */
        public long f54903d;

        /* renamed from: e  reason: collision with root package name */
        public long f54904e;

        /* renamed from: f  reason: collision with root package name */
        public int f54905f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i2) {
            super(16);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            long j2 = i2;
            this.f54903d = j2;
            this.f54904e = j2;
            this.f54905f = 0;
        }

        public static long s(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(65537, null, j2)) == null) {
                long j3 = (j2 ^ (j2 >>> 33)) * (-49064778989728563L);
                long j4 = (j3 ^ (j3 >>> 33)) * (-4265267296055464877L);
                return j4 ^ (j4 >>> 33);
            }
            return invokeJ.longValue;
        }

        public static long t(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeJ = interceptable.invokeJ(65538, null, j2)) == null) ? Long.rotateLeft(j2 * (-8663945395140668459L), 31) * 5545529020109919103L : invokeJ.longValue;
        }

        public static long u(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeJ = interceptable.invokeJ(65539, null, j2)) == null) ? Long.rotateLeft(j2 * 5545529020109919103L, 33) * (-8663945395140668459L) : invokeJ.longValue;
        }

        @Override // c.i.d.d.d
        public HashCode l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                long j2 = this.f54903d;
                int i2 = this.f54905f;
                long j3 = j2 ^ i2;
                this.f54903d = j3;
                long j4 = this.f54904e ^ i2;
                this.f54904e = j4;
                long j5 = j3 + j4;
                this.f54903d = j5;
                this.f54904e = j4 + j5;
                this.f54903d = s(j5);
                long s = s(this.f54904e);
                this.f54904e = s;
                long j6 = this.f54903d + s;
                this.f54903d = j6;
                this.f54904e = s + j6;
                return HashCode.fromBytesNoCopy(ByteBuffer.wrap(new byte[16]).order(ByteOrder.LITTLE_ENDIAN).putLong(this.f54903d).putLong(this.f54904e).array());
            }
            return (HashCode) invokeV.objValue;
        }

        @Override // c.i.d.d.d
        public void o(ByteBuffer byteBuffer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, byteBuffer) == null) {
                r(byteBuffer.getLong(), byteBuffer.getLong());
                this.f54905f += 16;
            }
        }

        @Override // c.i.d.d.d
        public void p(ByteBuffer byteBuffer) {
            long j2;
            long j3;
            long j4;
            long j5;
            long j6;
            long j7;
            long c2;
            long j8;
            long j9;
            long j10;
            long j11;
            long j12;
            long j13;
            long j14;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, byteBuffer) == null) {
                this.f54905f += byteBuffer.remaining();
                long j15 = 0;
                switch (byteBuffer.remaining()) {
                    case 1:
                        j2 = 0;
                        c2 = c.i.d.g.b.c(byteBuffer.get(0)) ^ j2;
                        this.f54903d ^= t(c2);
                        this.f54904e ^= u(j15);
                        return;
                    case 2:
                        j3 = 0;
                        j2 = j3 ^ (c.i.d.g.b.c(byteBuffer.get(1)) << 8);
                        c2 = c.i.d.g.b.c(byteBuffer.get(0)) ^ j2;
                        this.f54903d ^= t(c2);
                        this.f54904e ^= u(j15);
                        return;
                    case 3:
                        j4 = 0;
                        j3 = j4 ^ (c.i.d.g.b.c(byteBuffer.get(2)) << 16);
                        j2 = j3 ^ (c.i.d.g.b.c(byteBuffer.get(1)) << 8);
                        c2 = c.i.d.g.b.c(byteBuffer.get(0)) ^ j2;
                        this.f54903d ^= t(c2);
                        this.f54904e ^= u(j15);
                        return;
                    case 4:
                        j5 = 0;
                        j4 = j5 ^ (c.i.d.g.b.c(byteBuffer.get(3)) << 24);
                        j3 = j4 ^ (c.i.d.g.b.c(byteBuffer.get(2)) << 16);
                        j2 = j3 ^ (c.i.d.g.b.c(byteBuffer.get(1)) << 8);
                        c2 = c.i.d.g.b.c(byteBuffer.get(0)) ^ j2;
                        this.f54903d ^= t(c2);
                        this.f54904e ^= u(j15);
                        return;
                    case 5:
                        j6 = 0;
                        j5 = j6 ^ (c.i.d.g.b.c(byteBuffer.get(4)) << 32);
                        j4 = j5 ^ (c.i.d.g.b.c(byteBuffer.get(3)) << 24);
                        j3 = j4 ^ (c.i.d.g.b.c(byteBuffer.get(2)) << 16);
                        j2 = j3 ^ (c.i.d.g.b.c(byteBuffer.get(1)) << 8);
                        c2 = c.i.d.g.b.c(byteBuffer.get(0)) ^ j2;
                        this.f54903d ^= t(c2);
                        this.f54904e ^= u(j15);
                        return;
                    case 6:
                        j7 = 0;
                        j6 = j7 ^ (c.i.d.g.b.c(byteBuffer.get(5)) << 40);
                        j5 = j6 ^ (c.i.d.g.b.c(byteBuffer.get(4)) << 32);
                        j4 = j5 ^ (c.i.d.g.b.c(byteBuffer.get(3)) << 24);
                        j3 = j4 ^ (c.i.d.g.b.c(byteBuffer.get(2)) << 16);
                        j2 = j3 ^ (c.i.d.g.b.c(byteBuffer.get(1)) << 8);
                        c2 = c.i.d.g.b.c(byteBuffer.get(0)) ^ j2;
                        this.f54903d ^= t(c2);
                        this.f54904e ^= u(j15);
                        return;
                    case 7:
                        j7 = (c.i.d.g.b.c(byteBuffer.get(6)) << 48) ^ 0;
                        j6 = j7 ^ (c.i.d.g.b.c(byteBuffer.get(5)) << 40);
                        j5 = j6 ^ (c.i.d.g.b.c(byteBuffer.get(4)) << 32);
                        j4 = j5 ^ (c.i.d.g.b.c(byteBuffer.get(3)) << 24);
                        j3 = j4 ^ (c.i.d.g.b.c(byteBuffer.get(2)) << 16);
                        j2 = j3 ^ (c.i.d.g.b.c(byteBuffer.get(1)) << 8);
                        c2 = c.i.d.g.b.c(byteBuffer.get(0)) ^ j2;
                        this.f54903d ^= t(c2);
                        this.f54904e ^= u(j15);
                        return;
                    case 8:
                        j8 = 0;
                        c2 = byteBuffer.getLong() ^ 0;
                        j15 = j8;
                        this.f54903d ^= t(c2);
                        this.f54904e ^= u(j15);
                        return;
                    case 9:
                        j9 = 0;
                        j8 = j9 ^ c.i.d.g.b.c(byteBuffer.get(8));
                        c2 = byteBuffer.getLong() ^ 0;
                        j15 = j8;
                        this.f54903d ^= t(c2);
                        this.f54904e ^= u(j15);
                        return;
                    case 10:
                        j10 = 0;
                        j9 = j10 ^ (c.i.d.g.b.c(byteBuffer.get(9)) << 8);
                        j8 = j9 ^ c.i.d.g.b.c(byteBuffer.get(8));
                        c2 = byteBuffer.getLong() ^ 0;
                        j15 = j8;
                        this.f54903d ^= t(c2);
                        this.f54904e ^= u(j15);
                        return;
                    case 11:
                        j11 = 0;
                        j10 = j11 ^ (c.i.d.g.b.c(byteBuffer.get(10)) << 16);
                        j9 = j10 ^ (c.i.d.g.b.c(byteBuffer.get(9)) << 8);
                        j8 = j9 ^ c.i.d.g.b.c(byteBuffer.get(8));
                        c2 = byteBuffer.getLong() ^ 0;
                        j15 = j8;
                        this.f54903d ^= t(c2);
                        this.f54904e ^= u(j15);
                        return;
                    case 12:
                        j12 = 0;
                        j11 = j12 ^ (c.i.d.g.b.c(byteBuffer.get(11)) << 24);
                        j10 = j11 ^ (c.i.d.g.b.c(byteBuffer.get(10)) << 16);
                        j9 = j10 ^ (c.i.d.g.b.c(byteBuffer.get(9)) << 8);
                        j8 = j9 ^ c.i.d.g.b.c(byteBuffer.get(8));
                        c2 = byteBuffer.getLong() ^ 0;
                        j15 = j8;
                        this.f54903d ^= t(c2);
                        this.f54904e ^= u(j15);
                        return;
                    case 13:
                        j13 = 0;
                        j12 = j13 ^ (c.i.d.g.b.c(byteBuffer.get(12)) << 32);
                        j11 = j12 ^ (c.i.d.g.b.c(byteBuffer.get(11)) << 24);
                        j10 = j11 ^ (c.i.d.g.b.c(byteBuffer.get(10)) << 16);
                        j9 = j10 ^ (c.i.d.g.b.c(byteBuffer.get(9)) << 8);
                        j8 = j9 ^ c.i.d.g.b.c(byteBuffer.get(8));
                        c2 = byteBuffer.getLong() ^ 0;
                        j15 = j8;
                        this.f54903d ^= t(c2);
                        this.f54904e ^= u(j15);
                        return;
                    case 14:
                        j14 = 0;
                        j13 = j14 ^ (c.i.d.g.b.c(byteBuffer.get(13)) << 40);
                        j12 = j13 ^ (c.i.d.g.b.c(byteBuffer.get(12)) << 32);
                        j11 = j12 ^ (c.i.d.g.b.c(byteBuffer.get(11)) << 24);
                        j10 = j11 ^ (c.i.d.g.b.c(byteBuffer.get(10)) << 16);
                        j9 = j10 ^ (c.i.d.g.b.c(byteBuffer.get(9)) << 8);
                        j8 = j9 ^ c.i.d.g.b.c(byteBuffer.get(8));
                        c2 = byteBuffer.getLong() ^ 0;
                        j15 = j8;
                        this.f54903d ^= t(c2);
                        this.f54904e ^= u(j15);
                        return;
                    case 15:
                        j14 = (c.i.d.g.b.c(byteBuffer.get(14)) << 48) ^ 0;
                        j13 = j14 ^ (c.i.d.g.b.c(byteBuffer.get(13)) << 40);
                        j12 = j13 ^ (c.i.d.g.b.c(byteBuffer.get(12)) << 32);
                        j11 = j12 ^ (c.i.d.g.b.c(byteBuffer.get(11)) << 24);
                        j10 = j11 ^ (c.i.d.g.b.c(byteBuffer.get(10)) << 16);
                        j9 = j10 ^ (c.i.d.g.b.c(byteBuffer.get(9)) << 8);
                        j8 = j9 ^ c.i.d.g.b.c(byteBuffer.get(8));
                        c2 = byteBuffer.getLong() ^ 0;
                        j15 = j8;
                        this.f54903d ^= t(c2);
                        this.f54904e ^= u(j15);
                        return;
                    default:
                        throw new AssertionError("Should never get here.");
                }
            }
        }

        public final void r(long j2, long j3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) {
                long t = t(j2) ^ this.f54903d;
                this.f54903d = t;
                long rotateLeft = Long.rotateLeft(t, 27);
                this.f54903d = rotateLeft;
                long j4 = this.f54904e;
                long j5 = rotateLeft + j4;
                this.f54903d = j5;
                this.f54903d = (j5 * 5) + 1390208809;
                long u = u(j3) ^ j4;
                this.f54904e = u;
                long rotateLeft2 = Long.rotateLeft(u, 31);
                this.f54904e = rotateLeft2;
                long j6 = rotateLeft2 + this.f54903d;
                this.f54904e = j6;
                this.f54904e = (j6 * 5) + 944331445;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(975248611, "Lcom/google/common/hash/Murmur3_128HashFunction;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(975248611, "Lcom/google/common/hash/Murmur3_128HashFunction;");
                return;
            }
        }
        MURMUR3_128 = new Murmur3_128HashFunction(0);
        GOOD_FAST_HASH_128 = new Murmur3_128HashFunction(Hashing.a);
    }

    public Murmur3_128HashFunction(int i2) {
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

    public int bits() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return 128;
        }
        return invokeV.intValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) ? (obj instanceof Murmur3_128HashFunction) && this.seed == ((Murmur3_128HashFunction) obj).seed : invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? Murmur3_128HashFunction.class.hashCode() ^ this.seed : invokeV.intValue;
    }

    @Override // c.i.d.d.e
    public f newHasher() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? new a(this.seed) : (f) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return "Hashing.murmur3_128(" + this.seed + SmallTailInfo.EMOTION_SUFFIX;
        }
        return (String) invokeV.objValue;
    }
}
