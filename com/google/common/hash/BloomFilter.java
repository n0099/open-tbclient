package com.google.common.hash;

import androidx.core.view.InputDeviceCompat;
import b.h.d.a.k;
import b.h.d.a.n;
import b.h.d.a.o;
import b.h.d.g.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.common.hash.BloomFilterStrategies;
import com.google.common.primitives.SignedBytes;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.math.RoundingMode;
/* loaded from: classes11.dex */
public final class BloomFilter<T> implements o<T>, Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BloomFilterStrategies.a bits;
    public final Funnel<? super T> funnel;
    public final int numHashFunctions;
    public final Strategy strategy;

    /* loaded from: classes11.dex */
    public static class SerialForm<T> implements Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 1;
        public transient /* synthetic */ FieldHolder $fh;
        public final long[] data;
        public final Funnel<? super T> funnel;
        public final int numHashFunctions;
        public final Strategy strategy;

        public SerialForm(BloomFilter<T> bloomFilter) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bloomFilter};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.data = BloomFilterStrategies.a.g(bloomFilter.bits.f64538a);
            this.numHashFunctions = bloomFilter.numHashFunctions;
            this.funnel = bloomFilter.funnel;
            this.strategy = bloomFilter.strategy;
        }

        public Object readResolve() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new BloomFilter(new BloomFilterStrategies.a(this.data), this.numHashFunctions, this.funnel, this.strategy, null) : invokeV.objValue;
        }
    }

    /* loaded from: classes11.dex */
    public interface Strategy extends Serializable {
        <T> boolean mightContain(T t, Funnel<? super T> funnel, int i2, BloomFilterStrategies.a aVar);

        int ordinal();

        <T> boolean put(T t, Funnel<? super T> funnel, int i2, BloomFilterStrategies.a aVar);
    }

    /* loaded from: classes11.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    public /* synthetic */ BloomFilter(BloomFilterStrategies.a aVar, int i2, Funnel funnel, Strategy strategy, a aVar2) {
        this(aVar, i2, funnel, strategy);
    }

    public static <T> BloomFilter<T> create(Funnel<? super T> funnel, int i2, double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{funnel, Integer.valueOf(i2), Double.valueOf(d2)})) == null) ? create(funnel, i2, d2) : (BloomFilter) invokeCommon.objValue;
    }

    public static long optimalNumOfBits(long j, double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65547, null, new Object[]{Long.valueOf(j), Double.valueOf(d2)})) == null) {
            if (d2 == 0.0d) {
                d2 = Double.MIN_VALUE;
            }
            return (long) (((-j) * Math.log(d2)) / (Math.log(2.0d) * Math.log(2.0d)));
        }
        return invokeCommon.longValue;
    }

    public static int optimalNumOfHashFunctions(long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, null, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) ? Math.max(1, (int) Math.round((j2 / j) * Math.log(2.0d))) : invokeCommon.intValue;
    }

    public static <T> BloomFilter<T> readFrom(InputStream inputStream, Funnel<? super T> funnel) throws IOException {
        InterceptResult invokeLL;
        int i2;
        int i3;
        int readInt;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(65549, null, inputStream, funnel)) != null) {
            return (BloomFilter) invokeLL.objValue;
        }
        n.q(inputStream, "InputStream");
        n.q(funnel, "Funnel");
        byte b2 = -1;
        try {
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            byte readByte = dataInputStream.readByte();
            try {
                i3 = b.c(dataInputStream.readByte());
                try {
                    readInt = dataInputStream.readInt();
                } catch (RuntimeException e2) {
                    e = e2;
                    b2 = readByte;
                    i2 = -1;
                    throw new IOException("Unable to deserialize BloomFilter from InputStream. strategyOrdinal: " + ((int) b2) + " numHashFunctions: " + i3 + " dataLength: " + i2, e);
                }
                try {
                    BloomFilterStrategies bloomFilterStrategies = BloomFilterStrategies.values()[readByte];
                    long[] jArr = new long[readInt];
                    for (int i4 = 0; i4 < readInt; i4++) {
                        jArr[i4] = dataInputStream.readLong();
                    }
                    return new BloomFilter<>(new BloomFilterStrategies.a(jArr), i3, funnel, bloomFilterStrategies);
                } catch (RuntimeException e3) {
                    e = e3;
                    b2 = readByte;
                    i2 = readInt;
                    throw new IOException("Unable to deserialize BloomFilter from InputStream. strategyOrdinal: " + ((int) b2) + " numHashFunctions: " + i3 + " dataLength: " + i2, e);
                }
            } catch (RuntimeException e4) {
                e = e4;
                i3 = -1;
            }
        } catch (RuntimeException e5) {
            e = e5;
            i2 = -1;
            i3 = -1;
        }
    }

    private Object writeReplace() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65550, this)) == null) ? new SerialForm(this) : invokeV.objValue;
    }

    @Override // b.h.d.a.o
    @Deprecated
    public boolean apply(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, t)) == null) ? mightContain(t) : invokeL.booleanValue;
    }

    public long approximateElementCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            double b2 = this.bits.b();
            return b.h.d.f.a.c(((-Math.log1p(-(this.bits.a() / b2))) * b2) / this.numHashFunctions, RoundingMode.HALF_UP);
        }
        return invokeV.longValue;
    }

    public long bitSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.bits.b() : invokeV.longValue;
    }

    public BloomFilter<T> copy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? new BloomFilter<>(this.bits.c(), this.numHashFunctions, this.funnel, this.strategy) : (BloomFilter) invokeV.objValue;
    }

    @Override // b.h.d.a.o
    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, obj)) == null) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof BloomFilter) {
                BloomFilter bloomFilter = (BloomFilter) obj;
                return this.numHashFunctions == bloomFilter.numHashFunctions && this.funnel.equals(bloomFilter.funnel) && this.bits.equals(bloomFilter.bits) && this.strategy.equals(bloomFilter.strategy);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public double expectedFpp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? Math.pow(this.bits.a() / bitSize(), this.numHashFunctions) : invokeV.doubleValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? k.b(Integer.valueOf(this.numHashFunctions), this.funnel, this.strategy, this.bits) : invokeV.intValue;
    }

    public boolean isCompatible(BloomFilter<T> bloomFilter) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, bloomFilter)) == null) {
            n.p(bloomFilter);
            return this != bloomFilter && this.numHashFunctions == bloomFilter.numHashFunctions && bitSize() == bloomFilter.bitSize() && this.strategy.equals(bloomFilter.strategy) && this.funnel.equals(bloomFilter.funnel);
        }
        return invokeL.booleanValue;
    }

    public boolean mightContain(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, t)) == null) ? this.strategy.mightContain(t, this.funnel, this.numHashFunctions, this.bits) : invokeL.booleanValue;
    }

    public boolean put(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, t)) == null) ? this.strategy.put(t, this.funnel, this.numHashFunctions, this.bits) : invokeL.booleanValue;
    }

    public void putAll(BloomFilter<T> bloomFilter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bloomFilter) == null) {
            n.p(bloomFilter);
            n.e(this != bloomFilter, "Cannot combine a BloomFilter with itself.");
            n.g(this.numHashFunctions == bloomFilter.numHashFunctions, "BloomFilters must have the same number of hash functions (%s != %s)", this.numHashFunctions, bloomFilter.numHashFunctions);
            n.i(bitSize() == bloomFilter.bitSize(), "BloomFilters must have the same size underlying bit arrays (%s != %s)", bitSize(), bloomFilter.bitSize());
            n.l(this.strategy.equals(bloomFilter.strategy), "BloomFilters must have equal strategies (%s != %s)", this.strategy, bloomFilter.strategy);
            n.l(this.funnel.equals(bloomFilter.funnel), "BloomFilters must have equal funnels (%s != %s)", this.funnel, bloomFilter.funnel);
            this.bits.e(bloomFilter.bits);
        }
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, outputStream) == null) {
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
            dataOutputStream.writeByte(SignedBytes.a(this.strategy.ordinal()));
            dataOutputStream.writeByte(b.a(this.numHashFunctions));
            dataOutputStream.writeInt(this.bits.f64538a.length());
            for (int i2 = 0; i2 < this.bits.f64538a.length(); i2++) {
                dataOutputStream.writeLong(this.bits.f64538a.get(i2));
            }
        }
    }

    public BloomFilter(BloomFilterStrategies.a aVar, int i2, Funnel<? super T> funnel, Strategy strategy) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, Integer.valueOf(i2), funnel, strategy};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        n.f(i2 > 0, "numHashFunctions (%s) must be > 0", i2);
        n.f(i2 <= 255, "numHashFunctions (%s) must be <= 255", i2);
        n.p(aVar);
        this.bits = aVar;
        this.numHashFunctions = i2;
        n.p(funnel);
        this.funnel = funnel;
        n.p(strategy);
        this.strategy = strategy;
    }

    public static <T> BloomFilter<T> create(Funnel<? super T> funnel, long j, double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, null, new Object[]{funnel, Long.valueOf(j), Double.valueOf(d2)})) == null) ? create(funnel, j, d2, BloomFilterStrategies.MURMUR128_MITZ_64) : (BloomFilter) invokeCommon.objValue;
    }

    public static <T> BloomFilter<T> create(Funnel<? super T> funnel, long j, double d2, Strategy strategy) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65546, null, new Object[]{funnel, Long.valueOf(j), Double.valueOf(d2), strategy})) == null) {
            n.p(funnel);
            int i2 = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            n.h(i2 >= 0, "Expected insertions (%s) must be >= 0", j);
            n.k(d2 > 0.0d, "False positive probability (%s) must be > 0.0", Double.valueOf(d2));
            n.k(d2 < 1.0d, "False positive probability (%s) must be < 1.0", Double.valueOf(d2));
            n.p(strategy);
            if (i2 == 0) {
                j = 1;
            }
            long optimalNumOfBits = optimalNumOfBits(j, d2);
            try {
                return new BloomFilter<>(new BloomFilterStrategies.a(optimalNumOfBits), optimalNumOfHashFunctions(j, optimalNumOfBits), funnel, strategy);
            } catch (IllegalArgumentException e2) {
                throw new IllegalArgumentException("Could not create BloomFilter of " + optimalNumOfBits + " bits", e2);
            }
        }
        return (BloomFilter) invokeCommon.objValue;
    }

    public static <T> BloomFilter<T> create(Funnel<? super T> funnel, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(AdIconUtil.BAIDU_LOGO_ID, null, funnel, i2)) == null) ? create(funnel, i2) : (BloomFilter) invokeLI.objValue;
    }

    public static <T> BloomFilter<T> create(Funnel<? super T> funnel, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLJ = interceptable.invokeLJ(65544, null, funnel, j)) == null) ? create(funnel, j, 0.03d) : (BloomFilter) invokeLJ.objValue;
    }
}
