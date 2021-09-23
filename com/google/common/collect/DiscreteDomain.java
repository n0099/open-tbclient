package com.google.common.collect;

import androidx.core.view.InputDeviceCompat;
import c.i.d.a.n;
import c.i.d.c.m;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.common.primitives.Ints;
import java.io.Serializable;
import java.lang.Comparable;
import java.math.BigInteger;
import java.util.NoSuchElementException;
/* loaded from: classes9.dex */
public abstract class DiscreteDomain<C extends Comparable> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final boolean supportsFastOffset;

    /* loaded from: classes9.dex */
    public static final class BigIntegerDomain extends DiscreteDomain<BigInteger> implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public static final BigIntegerDomain INSTANCE;
        public static final BigInteger MAX_LONG;
        public static final BigInteger MIN_LONG;
        public static final long serialVersionUID = 0;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1036812255, "Lcom/google/common/collect/DiscreteDomain$BigIntegerDomain;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1036812255, "Lcom/google/common/collect/DiscreteDomain$BigIntegerDomain;");
                    return;
                }
            }
            INSTANCE = new BigIntegerDomain();
            MIN_LONG = BigInteger.valueOf(Long.MIN_VALUE);
            MAX_LONG = BigInteger.valueOf(Long.MAX_VALUE);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BigIntegerDomain() {
            super(true, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr = newInitContext.callArgs;
                    super(((Boolean) objArr[0]).booleanValue(), (a) objArr[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
        }

        private Object readResolve() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) ? INSTANCE : invokeV.objValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? "DiscreteDomain.bigIntegers()" : (String) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.DiscreteDomain
        public long distance(BigInteger bigInteger, BigInteger bigInteger2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bigInteger, bigInteger2)) == null) ? bigInteger2.subtract(bigInteger).max(MIN_LONG).min(MAX_LONG).longValue() : invokeLL.longValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.DiscreteDomain
        public BigInteger next(BigInteger bigInteger) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, bigInteger)) == null) ? bigInteger.add(BigInteger.ONE) : (BigInteger) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.DiscreteDomain
        public BigInteger offset(BigInteger bigInteger, long j2) {
            InterceptResult invokeLJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048581, this, bigInteger, j2)) == null) {
                m.c(j2, "distance");
                return bigInteger.add(BigInteger.valueOf(j2));
            }
            return (BigInteger) invokeLJ.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.DiscreteDomain
        public BigInteger previous(BigInteger bigInteger) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, bigInteger)) == null) ? bigInteger.subtract(BigInteger.ONE) : (BigInteger) invokeL.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static final class IntegerDomain extends DiscreteDomain<Integer> implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public static final IntegerDomain INSTANCE;
        public static final long serialVersionUID = 0;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-410159949, "Lcom/google/common/collect/DiscreteDomain$IntegerDomain;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-410159949, "Lcom/google/common/collect/DiscreteDomain$IntegerDomain;");
                    return;
                }
            }
            INSTANCE = new IntegerDomain();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public IntegerDomain() {
            super(true, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr = newInitContext.callArgs;
                    super(((Boolean) objArr[0]).booleanValue(), (a) objArr[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
        }

        private Object readResolve() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) ? INSTANCE : invokeV.objValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? "DiscreteDomain.integers()" : (String) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.DiscreteDomain
        public long distance(Integer num, Integer num2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, num, num2)) == null) ? num2.intValue() - num.intValue() : invokeLL.longValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.DiscreteDomain
        public Integer maxValue() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return Integer.MAX_VALUE;
            }
            return (Integer) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.DiscreteDomain
        public Integer minValue() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return Integer.MIN_VALUE;
            }
            return (Integer) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.DiscreteDomain
        public Integer next(Integer num) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, num)) == null) {
                int intValue = num.intValue();
                if (intValue == Integer.MAX_VALUE) {
                    return null;
                }
                return Integer.valueOf(intValue + 1);
            }
            return (Integer) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.DiscreteDomain
        public Integer offset(Integer num, long j2) {
            InterceptResult invokeLJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048585, this, num, j2)) == null) {
                m.c(j2, "distance");
                return Integer.valueOf(Ints.c(num.longValue() + j2));
            }
            return (Integer) invokeLJ.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.DiscreteDomain
        public Integer previous(Integer num) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, num)) == null) {
                int intValue = num.intValue();
                if (intValue == Integer.MIN_VALUE) {
                    return null;
                }
                return Integer.valueOf(intValue - 1);
            }
            return (Integer) invokeL.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static final class LongDomain extends DiscreteDomain<Long> implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public static final LongDomain INSTANCE;
        public static final long serialVersionUID = 0;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(94688321, "Lcom/google/common/collect/DiscreteDomain$LongDomain;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(94688321, "Lcom/google/common/collect/DiscreteDomain$LongDomain;");
                    return;
                }
            }
            INSTANCE = new LongDomain();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LongDomain() {
            super(true, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr = newInitContext.callArgs;
                    super(((Boolean) objArr[0]).booleanValue(), (a) objArr[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
        }

        private Object readResolve() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) ? INSTANCE : invokeV.objValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? "DiscreteDomain.longs()" : (String) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.DiscreteDomain
        public long distance(Long l, Long l2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, l, l2)) == null) {
                long longValue = l2.longValue() - l.longValue();
                if (l2.longValue() <= l.longValue() || longValue >= 0) {
                    if (l2.longValue() >= l.longValue() || longValue <= 0) {
                        return longValue;
                    }
                    return Long.MIN_VALUE;
                }
                return Long.MAX_VALUE;
            }
            return invokeLL.longValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.DiscreteDomain
        public Long maxValue() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return Long.MAX_VALUE;
            }
            return (Long) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.DiscreteDomain
        public Long minValue() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return Long.MIN_VALUE;
            }
            return (Long) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.DiscreteDomain
        public Long next(Long l) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, l)) == null) {
                long longValue = l.longValue();
                if (longValue == Long.MAX_VALUE) {
                    return null;
                }
                return Long.valueOf(longValue + 1);
            }
            return (Long) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.DiscreteDomain
        public Long offset(Long l, long j2) {
            InterceptResult invokeLJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048585, this, l, j2)) == null) {
                m.c(j2, "distance");
                long longValue = l.longValue() + j2;
                if (longValue < 0) {
                    n.e(l.longValue() < 0, "overflow");
                }
                return Long.valueOf(longValue);
            }
            return (Long) invokeLJ.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.DiscreteDomain
        public Long previous(Long l) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, l)) == null) {
                long longValue = l.longValue();
                if (longValue == Long.MIN_VALUE) {
                    return null;
                }
                return Long.valueOf(longValue - 1);
            }
            return (Long) invokeL.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    public /* synthetic */ DiscreteDomain(boolean z, a aVar) {
        this(z);
    }

    public static DiscreteDomain<BigInteger> bigIntegers() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? BigIntegerDomain.INSTANCE : (DiscreteDomain) invokeV.objValue;
    }

    public static DiscreteDomain<Integer> integers() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? IntegerDomain.INSTANCE : (DiscreteDomain) invokeV.objValue;
    }

    public static DiscreteDomain<Long> longs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? LongDomain.INSTANCE : (DiscreteDomain) invokeV.objValue;
    }

    public abstract long distance(C c2, C c3);

    public C maxValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            throw new NoSuchElementException();
        }
        return (C) invokeV.objValue;
    }

    public C minValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            throw new NoSuchElementException();
        }
        return (C) invokeV.objValue;
    }

    public abstract C next(C c2);

    public abstract C offset(C c2, long j2);

    public abstract C previous(C c2);

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DiscreteDomain() {
        this(false);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this(((Boolean) newInitContext.callArgs[0]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public DiscreteDomain(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.supportsFastOffset = z;
    }
}
