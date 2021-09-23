package com.google.common.hash;

import androidx.core.view.InputDeviceCompat;
import c.i.d.a.n;
import c.i.d.d.i;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.common.hash.BloomFilter;
import com.google.common.math.LongMath;
import com.google.common.primitives.Ints;
import com.google.common.primitives.Longs;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLongArray;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes10.dex */
public abstract class BloomFilterStrategies implements BloomFilter.Strategy {
    public static final /* synthetic */ BloomFilterStrategies[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final BloomFilterStrategies MURMUR128_MITZ_32;
    public static final BloomFilterStrategies MURMUR128_MITZ_64;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1880190088, "Lcom/google/common/hash/BloomFilterStrategies;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1880190088, "Lcom/google/common/hash/BloomFilterStrategies;");
                return;
            }
        }
        MURMUR128_MITZ_32 = new BloomFilterStrategies("MURMUR128_MITZ_32", 0) { // from class: com.google.common.hash.BloomFilterStrategies.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r9, r10);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {r9, Integer.valueOf(r10)};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        Object[] objArr2 = newInitContext.callArgs;
                        super((String) objArr2[0], ((Integer) objArr2[1]).intValue());
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
            }

            @Override // com.google.common.hash.BloomFilter.Strategy
            public <T> boolean mightContain(T t, Funnel<? super T> funnel, int i2, a aVar) {
                InterceptResult invokeLLIL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeLLIL = interceptable2.invokeLLIL(1048576, this, t, funnel, i2, aVar)) == null) {
                    long b2 = aVar.b();
                    long asLong = Hashing.a().hashObject(t, funnel).asLong();
                    int i3 = (int) asLong;
                    int i4 = (int) (asLong >>> 32);
                    for (int i5 = 1; i5 <= i2; i5++) {
                        int i6 = (i5 * i4) + i3;
                        if (i6 < 0) {
                            i6 = ~i6;
                        }
                        if (!aVar.d(i6 % b2)) {
                            return false;
                        }
                    }
                    return true;
                }
                return invokeLLIL.booleanValue;
            }

            @Override // com.google.common.hash.BloomFilter.Strategy
            public <T> boolean put(T t, Funnel<? super T> funnel, int i2, a aVar) {
                InterceptResult invokeLLIL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeLLIL = interceptable2.invokeLLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t, funnel, i2, aVar)) == null) {
                    long b2 = aVar.b();
                    long asLong = Hashing.a().hashObject(t, funnel).asLong();
                    int i3 = (int) asLong;
                    int i4 = (int) (asLong >>> 32);
                    boolean z = false;
                    for (int i5 = 1; i5 <= i2; i5++) {
                        int i6 = (i5 * i4) + i3;
                        if (i6 < 0) {
                            i6 = ~i6;
                        }
                        z |= aVar.f(i6 % b2);
                    }
                    return z;
                }
                return invokeLLIL.booleanValue;
            }
        };
        BloomFilterStrategies bloomFilterStrategies = new BloomFilterStrategies("MURMUR128_MITZ_64", 1) { // from class: com.google.common.hash.BloomFilterStrategies.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r9, r10);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {r9, Integer.valueOf(r10)};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        Object[] objArr2 = newInitContext.callArgs;
                        super((String) objArr2[0], ((Integer) objArr2[1]).intValue());
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
            }

            private long lowerEight(byte[] bArr) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(65537, this, bArr)) == null) ? Longs.d(bArr[7], bArr[6], bArr[5], bArr[4], bArr[3], bArr[2], bArr[1], bArr[0]) : invokeL.longValue;
            }

            private long upperEight(byte[] bArr) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(65538, this, bArr)) == null) ? Longs.d(bArr[15], bArr[14], bArr[13], bArr[12], bArr[11], bArr[10], bArr[9], bArr[8]) : invokeL.longValue;
            }

            @Override // com.google.common.hash.BloomFilter.Strategy
            public <T> boolean mightContain(T t, Funnel<? super T> funnel, int i2, a aVar) {
                InterceptResult invokeLLIL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeLLIL = interceptable2.invokeLLIL(1048576, this, t, funnel, i2, aVar)) == null) {
                    long b2 = aVar.b();
                    byte[] bytesInternal = Hashing.a().hashObject(t, funnel).getBytesInternal();
                    long lowerEight = lowerEight(bytesInternal);
                    long upperEight = upperEight(bytesInternal);
                    for (int i3 = 0; i3 < i2; i3++) {
                        if (!aVar.d((Long.MAX_VALUE & lowerEight) % b2)) {
                            return false;
                        }
                        lowerEight += upperEight;
                    }
                    return true;
                }
                return invokeLLIL.booleanValue;
            }

            @Override // com.google.common.hash.BloomFilter.Strategy
            public <T> boolean put(T t, Funnel<? super T> funnel, int i2, a aVar) {
                InterceptResult invokeLLIL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeLLIL = interceptable2.invokeLLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t, funnel, i2, aVar)) == null) {
                    long b2 = aVar.b();
                    byte[] bytesInternal = Hashing.a().hashObject(t, funnel).getBytesInternal();
                    long lowerEight = lowerEight(bytesInternal);
                    long upperEight = upperEight(bytesInternal);
                    boolean z = false;
                    for (int i3 = 0; i3 < i2; i3++) {
                        z |= aVar.f((Long.MAX_VALUE & lowerEight) % b2);
                        lowerEight += upperEight;
                    }
                    return z;
                }
                return invokeLLIL.booleanValue;
            }
        };
        MURMUR128_MITZ_64 = bloomFilterStrategies;
        $VALUES = new BloomFilterStrategies[]{MURMUR128_MITZ_32, bloomFilterStrategies};
    }

    public BloomFilterStrategies(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static BloomFilterStrategies valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (BloomFilterStrategies) Enum.valueOf(BloomFilterStrategies.class, str) : (BloomFilterStrategies) invokeL.objValue;
    }

    public static BloomFilterStrategies[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (BloomFilterStrategies[]) $VALUES.clone() : (BloomFilterStrategies[]) invokeV.objValue;
    }

    /* loaded from: classes10.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final AtomicLongArray f71117a;

        /* renamed from: b  reason: collision with root package name */
        public final i f71118b;

        public a(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Long.valueOf(j2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            n.e(j2 > 0, "data length is zero!");
            this.f71117a = new AtomicLongArray(Ints.c(LongMath.a(j2, 64L, RoundingMode.CEILING)));
            this.f71118b = LongAddables.a();
        }

        public static long[] g(AtomicLongArray atomicLongArray) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, atomicLongArray)) == null) {
                int length = atomicLongArray.length();
                long[] jArr = new long[length];
                for (int i2 = 0; i2 < length; i2++) {
                    jArr[i2] = atomicLongArray.get(i2);
                }
                return jArr;
            }
            return (long[]) invokeL.objValue;
        }

        public long a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f71118b.sum() : invokeV.longValue;
        }

        public long b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f71117a.length() * 64 : invokeV.longValue;
        }

        public a c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? new a(g(this.f71117a)) : (a) invokeV.objValue;
        }

        public boolean d(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeJ = interceptable.invokeJ(1048579, this, j2)) == null) ? ((1 << ((int) j2)) & this.f71117a.get((int) (j2 >>> 6))) != 0 : invokeJ.booleanValue;
        }

        public void e(a aVar) {
            long j2;
            long j3;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
                n.g(this.f71117a.length() == aVar.f71117a.length(), "BitArrays must be of equal length (%s != %s)", this.f71117a.length(), aVar.f71117a.length());
                for (int i2 = 0; i2 < this.f71117a.length(); i2++) {
                    long j4 = aVar.f71117a.get(i2);
                    while (true) {
                        j2 = this.f71117a.get(i2);
                        j3 = j2 | j4;
                        if (j2 == j3) {
                            z = false;
                            break;
                        } else if (this.f71117a.compareAndSet(i2, j2, j3)) {
                            z = true;
                            break;
                        }
                    }
                    if (z) {
                        this.f71118b.add(Long.bitCount(j3) - Long.bitCount(j2));
                    }
                }
            }
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
                if (obj instanceof a) {
                    return Arrays.equals(g(this.f71117a), g(((a) obj).f71117a));
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public boolean f(long j2) {
            InterceptResult invokeJ;
            long j3;
            long j4;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048582, this, j2)) == null) {
                if (d(j2)) {
                    return false;
                }
                int i2 = (int) (j2 >>> 6);
                long j5 = 1 << ((int) j2);
                do {
                    j3 = this.f71117a.get(i2);
                    j4 = j3 | j5;
                    if (j3 == j4) {
                        return false;
                    }
                } while (!this.f71117a.compareAndSet(i2, j3, j4));
                this.f71118b.increment();
                return true;
            }
            return invokeJ.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? Arrays.hashCode(g(this.f71117a)) : invokeV.intValue;
        }

        public a(long[] jArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jArr};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            n.e(jArr.length > 0, "data length is zero!");
            this.f71117a = new AtomicLongArray(jArr);
            this.f71118b = LongAddables.a();
            long j2 = 0;
            for (long j3 : jArr) {
                j2 += Long.bitCount(j3);
            }
            this.f71118b.add(j2);
        }
    }
}
