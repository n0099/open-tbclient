package com.google.common.hash;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.f.d.d.b;
import d.f.d.d.d;
import d.f.d.d.e;
import d.f.d.d.f;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
/* loaded from: classes6.dex */
public final class Murmur3_128HashFunction extends b implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public static final e GOOD_FAST_HASH_128;
    public static final e MURMUR3_128;
    public static final long serialVersionUID = 0;
    public transient /* synthetic */ FieldHolder $fh;
    public final int seed;

    /* loaded from: classes6.dex */
    public static final class a extends d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: d  reason: collision with root package name */
        public long f33698d;

        /* renamed from: e  reason: collision with root package name */
        public long f33699e;

        /* renamed from: f  reason: collision with root package name */
        public int f33700f;

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
            long j = i2;
            this.f33698d = j;
            this.f33699e = j;
            this.f33700f = 0;
        }

        public static long s(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(65537, null, j)) == null) {
                long j2 = (j ^ (j >>> 33)) * (-49064778989728563L);
                long j3 = (j2 ^ (j2 >>> 33)) * (-4265267296055464877L);
                return j3 ^ (j3 >>> 33);
            }
            return invokeJ.longValue;
        }

        public static long t(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeJ = interceptable.invokeJ(65538, null, j)) == null) ? Long.rotateLeft(j * (-8663945395140668459L), 31) * 5545529020109919103L : invokeJ.longValue;
        }

        public static long u(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeJ = interceptable.invokeJ(65539, null, j)) == null) ? Long.rotateLeft(j * 5545529020109919103L, 33) * (-8663945395140668459L) : invokeJ.longValue;
        }

        @Override // d.f.d.d.d
        public HashCode l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                long j = this.f33698d;
                int i2 = this.f33700f;
                long j2 = j ^ i2;
                this.f33698d = j2;
                long j3 = this.f33699e ^ i2;
                this.f33699e = j3;
                long j4 = j2 + j3;
                this.f33698d = j4;
                this.f33699e = j3 + j4;
                this.f33698d = s(j4);
                long s = s(this.f33699e);
                this.f33699e = s;
                long j5 = this.f33698d + s;
                this.f33698d = j5;
                this.f33699e = s + j5;
                return HashCode.fromBytesNoCopy(ByteBuffer.wrap(new byte[16]).order(ByteOrder.LITTLE_ENDIAN).putLong(this.f33698d).putLong(this.f33699e).array());
            }
            return (HashCode) invokeV.objValue;
        }

        @Override // d.f.d.d.d
        public void o(ByteBuffer byteBuffer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, byteBuffer) == null) {
                r(byteBuffer.getLong(), byteBuffer.getLong());
                this.f33700f += 16;
            }
        }

        @Override // d.f.d.d.d
        public void p(ByteBuffer byteBuffer) {
            long j;
            long j2;
            long j3;
            long j4;
            long j5;
            long j6;
            long c2;
            long j7;
            long j8;
            long j9;
            long j10;
            long j11;
            long j12;
            long j13;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, byteBuffer) == null) {
                this.f33700f += byteBuffer.remaining();
                long j14 = 0;
                switch (byteBuffer.remaining()) {
                    case 1:
                        j = 0;
                        c2 = d.f.d.g.b.c(byteBuffer.get(0)) ^ j;
                        this.f33698d ^= t(c2);
                        this.f33699e ^= u(j14);
                        return;
                    case 2:
                        j2 = 0;
                        j = j2 ^ (d.f.d.g.b.c(byteBuffer.get(1)) << 8);
                        c2 = d.f.d.g.b.c(byteBuffer.get(0)) ^ j;
                        this.f33698d ^= t(c2);
                        this.f33699e ^= u(j14);
                        return;
                    case 3:
                        j3 = 0;
                        j2 = j3 ^ (d.f.d.g.b.c(byteBuffer.get(2)) << 16);
                        j = j2 ^ (d.f.d.g.b.c(byteBuffer.get(1)) << 8);
                        c2 = d.f.d.g.b.c(byteBuffer.get(0)) ^ j;
                        this.f33698d ^= t(c2);
                        this.f33699e ^= u(j14);
                        return;
                    case 4:
                        j4 = 0;
                        j3 = j4 ^ (d.f.d.g.b.c(byteBuffer.get(3)) << 24);
                        j2 = j3 ^ (d.f.d.g.b.c(byteBuffer.get(2)) << 16);
                        j = j2 ^ (d.f.d.g.b.c(byteBuffer.get(1)) << 8);
                        c2 = d.f.d.g.b.c(byteBuffer.get(0)) ^ j;
                        this.f33698d ^= t(c2);
                        this.f33699e ^= u(j14);
                        return;
                    case 5:
                        j5 = 0;
                        j4 = j5 ^ (d.f.d.g.b.c(byteBuffer.get(4)) << 32);
                        j3 = j4 ^ (d.f.d.g.b.c(byteBuffer.get(3)) << 24);
                        j2 = j3 ^ (d.f.d.g.b.c(byteBuffer.get(2)) << 16);
                        j = j2 ^ (d.f.d.g.b.c(byteBuffer.get(1)) << 8);
                        c2 = d.f.d.g.b.c(byteBuffer.get(0)) ^ j;
                        this.f33698d ^= t(c2);
                        this.f33699e ^= u(j14);
                        return;
                    case 6:
                        j6 = 0;
                        j5 = j6 ^ (d.f.d.g.b.c(byteBuffer.get(5)) << 40);
                        j4 = j5 ^ (d.f.d.g.b.c(byteBuffer.get(4)) << 32);
                        j3 = j4 ^ (d.f.d.g.b.c(byteBuffer.get(3)) << 24);
                        j2 = j3 ^ (d.f.d.g.b.c(byteBuffer.get(2)) << 16);
                        j = j2 ^ (d.f.d.g.b.c(byteBuffer.get(1)) << 8);
                        c2 = d.f.d.g.b.c(byteBuffer.get(0)) ^ j;
                        this.f33698d ^= t(c2);
                        this.f33699e ^= u(j14);
                        return;
                    case 7:
                        j6 = (d.f.d.g.b.c(byteBuffer.get(6)) << 48) ^ 0;
                        j5 = j6 ^ (d.f.d.g.b.c(byteBuffer.get(5)) << 40);
                        j4 = j5 ^ (d.f.d.g.b.c(byteBuffer.get(4)) << 32);
                        j3 = j4 ^ (d.f.d.g.b.c(byteBuffer.get(3)) << 24);
                        j2 = j3 ^ (d.f.d.g.b.c(byteBuffer.get(2)) << 16);
                        j = j2 ^ (d.f.d.g.b.c(byteBuffer.get(1)) << 8);
                        c2 = d.f.d.g.b.c(byteBuffer.get(0)) ^ j;
                        this.f33698d ^= t(c2);
                        this.f33699e ^= u(j14);
                        return;
                    case 8:
                        j7 = 0;
                        c2 = byteBuffer.getLong() ^ 0;
                        j14 = j7;
                        this.f33698d ^= t(c2);
                        this.f33699e ^= u(j14);
                        return;
                    case 9:
                        j8 = 0;
                        j7 = j8 ^ d.f.d.g.b.c(byteBuffer.get(8));
                        c2 = byteBuffer.getLong() ^ 0;
                        j14 = j7;
                        this.f33698d ^= t(c2);
                        this.f33699e ^= u(j14);
                        return;
                    case 10:
                        j9 = 0;
                        j8 = j9 ^ (d.f.d.g.b.c(byteBuffer.get(9)) << 8);
                        j7 = j8 ^ d.f.d.g.b.c(byteBuffer.get(8));
                        c2 = byteBuffer.getLong() ^ 0;
                        j14 = j7;
                        this.f33698d ^= t(c2);
                        this.f33699e ^= u(j14);
                        return;
                    case 11:
                        j10 = 0;
                        j9 = j10 ^ (d.f.d.g.b.c(byteBuffer.get(10)) << 16);
                        j8 = j9 ^ (d.f.d.g.b.c(byteBuffer.get(9)) << 8);
                        j7 = j8 ^ d.f.d.g.b.c(byteBuffer.get(8));
                        c2 = byteBuffer.getLong() ^ 0;
                        j14 = j7;
                        this.f33698d ^= t(c2);
                        this.f33699e ^= u(j14);
                        return;
                    case 12:
                        j11 = 0;
                        j10 = j11 ^ (d.f.d.g.b.c(byteBuffer.get(11)) << 24);
                        j9 = j10 ^ (d.f.d.g.b.c(byteBuffer.get(10)) << 16);
                        j8 = j9 ^ (d.f.d.g.b.c(byteBuffer.get(9)) << 8);
                        j7 = j8 ^ d.f.d.g.b.c(byteBuffer.get(8));
                        c2 = byteBuffer.getLong() ^ 0;
                        j14 = j7;
                        this.f33698d ^= t(c2);
                        this.f33699e ^= u(j14);
                        return;
                    case 13:
                        j12 = 0;
                        j11 = j12 ^ (d.f.d.g.b.c(byteBuffer.get(12)) << 32);
                        j10 = j11 ^ (d.f.d.g.b.c(byteBuffer.get(11)) << 24);
                        j9 = j10 ^ (d.f.d.g.b.c(byteBuffer.get(10)) << 16);
                        j8 = j9 ^ (d.f.d.g.b.c(byteBuffer.get(9)) << 8);
                        j7 = j8 ^ d.f.d.g.b.c(byteBuffer.get(8));
                        c2 = byteBuffer.getLong() ^ 0;
                        j14 = j7;
                        this.f33698d ^= t(c2);
                        this.f33699e ^= u(j14);
                        return;
                    case 14:
                        j13 = 0;
                        j12 = j13 ^ (d.f.d.g.b.c(byteBuffer.get(13)) << 40);
                        j11 = j12 ^ (d.f.d.g.b.c(byteBuffer.get(12)) << 32);
                        j10 = j11 ^ (d.f.d.g.b.c(byteBuffer.get(11)) << 24);
                        j9 = j10 ^ (d.f.d.g.b.c(byteBuffer.get(10)) << 16);
                        j8 = j9 ^ (d.f.d.g.b.c(byteBuffer.get(9)) << 8);
                        j7 = j8 ^ d.f.d.g.b.c(byteBuffer.get(8));
                        c2 = byteBuffer.getLong() ^ 0;
                        j14 = j7;
                        this.f33698d ^= t(c2);
                        this.f33699e ^= u(j14);
                        return;
                    case 15:
                        j13 = (d.f.d.g.b.c(byteBuffer.get(14)) << 48) ^ 0;
                        j12 = j13 ^ (d.f.d.g.b.c(byteBuffer.get(13)) << 40);
                        j11 = j12 ^ (d.f.d.g.b.c(byteBuffer.get(12)) << 32);
                        j10 = j11 ^ (d.f.d.g.b.c(byteBuffer.get(11)) << 24);
                        j9 = j10 ^ (d.f.d.g.b.c(byteBuffer.get(10)) << 16);
                        j8 = j9 ^ (d.f.d.g.b.c(byteBuffer.get(9)) << 8);
                        j7 = j8 ^ d.f.d.g.b.c(byteBuffer.get(8));
                        c2 = byteBuffer.getLong() ^ 0;
                        j14 = j7;
                        this.f33698d ^= t(c2);
                        this.f33699e ^= u(j14);
                        return;
                    default:
                        throw new AssertionError("Should never get here.");
                }
            }
        }

        public final void r(long j, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
                long t = t(j) ^ this.f33698d;
                this.f33698d = t;
                long rotateLeft = Long.rotateLeft(t, 27);
                this.f33698d = rotateLeft;
                long j3 = this.f33699e;
                long j4 = rotateLeft + j3;
                this.f33698d = j4;
                this.f33698d = (j4 * 5) + 1390208809;
                long u = u(j2) ^ j3;
                this.f33699e = u;
                long rotateLeft2 = Long.rotateLeft(u, 31);
                this.f33699e = rotateLeft2;
                long j5 = rotateLeft2 + this.f33698d;
                this.f33699e = j5;
                this.f33699e = (j5 * 5) + 944331445;
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
        GOOD_FAST_HASH_128 = new Murmur3_128HashFunction(Hashing.f33693a);
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

    @Override // d.f.d.d.e
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
