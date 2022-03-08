package com.google.common.math;

import androidx.core.view.InputDeviceCompat;
import c.i.c.a.n;
import c.i.c.f.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.common.primitives.UnsignedLongs;
import java.math.RoundingMode;
/* loaded from: classes7.dex */
public final class LongMath {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes7.dex */
    public static abstract class MillerRabinTester {
        public static final /* synthetic */ MillerRabinTester[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final MillerRabinTester LARGE;
        public static final MillerRabinTester SMALL;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(10777614, "Lcom/google/common/math/LongMath$MillerRabinTester;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(10777614, "Lcom/google/common/math/LongMath$MillerRabinTester;");
                    return;
                }
            }
            SMALL = new MillerRabinTester("SMALL", 0) { // from class: com.google.common.math.LongMath.MillerRabinTester.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r9, r10, null);
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
                            super((String) objArr2[0], ((Integer) objArr2[1]).intValue(), (a) objArr2[2]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                }

                @Override // com.google.common.math.LongMath.MillerRabinTester
                public long mulMod(long j2, long j3, long j4) {
                    InterceptResult invokeCommon;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeCommon = interceptable2.invokeCommon(1048576, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4)})) == null) ? (j2 * j3) % j4 : invokeCommon.longValue;
                }

                @Override // com.google.common.math.LongMath.MillerRabinTester
                public long squareMod(long j2, long j3) {
                    InterceptResult invokeCommon;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeCommon = interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)})) == null) ? (j2 * j2) % j3 : invokeCommon.longValue;
                }
            };
            MillerRabinTester millerRabinTester = new MillerRabinTester("LARGE", 1) { // from class: com.google.common.math.LongMath.MillerRabinTester.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r9, r10, null);
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
                            super((String) objArr2[0], ((Integer) objArr2[1]).intValue(), (a) objArr2[2]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                }

                private long plusMod(long j2, long j3, long j4) {
                    InterceptResult invokeCommon;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeCommon = interceptable2.invokeCommon(65537, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4)})) == null) {
                        int i2 = (j2 > (j4 - j3) ? 1 : (j2 == (j4 - j3) ? 0 : -1));
                        long j5 = j2 + j3;
                        return i2 >= 0 ? j5 - j4 : j5;
                    }
                    return invokeCommon.longValue;
                }

                private long times2ToThe32Mod(long j2, long j3) {
                    InterceptResult invokeCommon;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeCommon = interceptable2.invokeCommon(65538, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)})) == null) {
                        int i2 = 32;
                        do {
                            int min = Math.min(i2, Long.numberOfLeadingZeros(j2));
                            j2 = UnsignedLongs.e(j2 << min, j3);
                            i2 -= min;
                        } while (i2 > 0);
                        return j2;
                    }
                    return invokeCommon.longValue;
                }

                @Override // com.google.common.math.LongMath.MillerRabinTester
                public long mulMod(long j2, long j3, long j4) {
                    InterceptResult invokeCommon;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeCommon = interceptable2.invokeCommon(1048576, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4)})) == null) {
                        long j5 = j2 >>> 32;
                        long j6 = j3 >>> 32;
                        long j7 = j2 & 4294967295L;
                        long j8 = j3 & 4294967295L;
                        long times2ToThe32Mod = times2ToThe32Mod(j5 * j6, j4) + (j5 * j8);
                        if (times2ToThe32Mod < 0) {
                            times2ToThe32Mod = UnsignedLongs.e(times2ToThe32Mod, j4);
                        }
                        Long.signum(j7);
                        return plusMod(times2ToThe32Mod(times2ToThe32Mod + (j6 * j7), j4), UnsignedLongs.e(j7 * j8, j4), j4);
                    }
                    return invokeCommon.longValue;
                }

                @Override // com.google.common.math.LongMath.MillerRabinTester
                public long squareMod(long j2, long j3) {
                    InterceptResult invokeCommon;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeCommon = interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)})) == null) {
                        long j4 = j2 >>> 32;
                        long j5 = j2 & 4294967295L;
                        long times2ToThe32Mod = times2ToThe32Mod(j4 * j4, j3);
                        long j6 = j4 * j5 * 2;
                        if (j6 < 0) {
                            j6 = UnsignedLongs.e(j6, j3);
                        }
                        return plusMod(times2ToThe32Mod(times2ToThe32Mod + j6, j3), UnsignedLongs.e(j5 * j5, j3), j3);
                    }
                    return invokeCommon.longValue;
                }
            };
            LARGE = millerRabinTester;
            $VALUES = new MillerRabinTester[]{SMALL, millerRabinTester};
        }

        public MillerRabinTester(String str, int i2) {
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

        private long powMod(long j2, long j3, long j4) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4)})) == null) {
                long j5 = 1;
                while (j3 != 0) {
                    if ((j3 & 1) != 0) {
                        j5 = mulMod(j5, j2, j4);
                    }
                    j2 = squareMod(j2, j4);
                    j3 >>= 1;
                }
                return j5;
            }
            return invokeCommon.longValue;
        }

        public static boolean test(long j2, long j3) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Long.valueOf(j2), Long.valueOf(j3)})) == null) {
                return (j3 <= 3037000499L ? SMALL : LARGE).testWitness(j2, j3);
            }
            return invokeCommon.booleanValue;
        }

        private boolean testWitness(long j2, long j3) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)})) == null) {
                long j4 = j3 - 1;
                int numberOfTrailingZeros = Long.numberOfTrailingZeros(j4);
                long j5 = j4 >> numberOfTrailingZeros;
                long j6 = j2 % j3;
                if (j6 == 0) {
                    return true;
                }
                long powMod = powMod(j6, j5, j3);
                if (powMod == 1) {
                    return true;
                }
                int i2 = 0;
                while (powMod != j4) {
                    i2++;
                    if (i2 == numberOfTrailingZeros) {
                        return false;
                    }
                    powMod = squareMod(powMod, j3);
                }
                return true;
            }
            return invokeCommon.booleanValue;
        }

        public static MillerRabinTester valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) ? (MillerRabinTester) Enum.valueOf(MillerRabinTester.class, str) : (MillerRabinTester) invokeL.objValue;
        }

        public static MillerRabinTester[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? (MillerRabinTester[]) $VALUES.clone() : (MillerRabinTester[]) invokeV.objValue;
        }

        public abstract long mulMod(long j2, long j3, long j4);

        public abstract long squareMod(long j2, long j3);

        public /* synthetic */ MillerRabinTester(String str, int i2, a aVar) {
            this(str, i2);
        }
    }

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-713644613, "Lcom/google/common/math/LongMath$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-713644613, "Lcom/google/common/math/LongMath$a;");
                    return;
                }
            }
            int[] iArr = new int[RoundingMode.values().length];
            a = iArr;
            try {
                iArr[RoundingMode.UNNECESSARY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[RoundingMode.DOWN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[RoundingMode.FLOOR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[RoundingMode.UP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[RoundingMode.CEILING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[RoundingMode.HALF_DOWN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[RoundingMode.HALF_UP.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[RoundingMode.HALF_EVEN.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-836495848, "Lcom/google/common/math/LongMath;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-836495848, "Lcom/google/common/math/LongMath;");
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0055, code lost:
        if (r11 > 0) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0058, code lost:
        if (r10 > 0) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x005b, code lost:
        if (r10 < 0) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static long a(long j2, long j3, RoundingMode roundingMode) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Long.valueOf(j2), Long.valueOf(j3), roundingMode})) == null) {
            n.p(roundingMode);
            long j4 = j2 / j3;
            long j5 = j2 - (j3 * j4);
            int i2 = (j5 > 0L ? 1 : (j5 == 0L ? 0 : -1));
            if (i2 == 0) {
                return j4;
            }
            int i3 = (int) ((j2 ^ j3) >> 63);
            int i4 = i3 | 1;
            switch (a.a[roundingMode.ordinal()]) {
                case 1:
                    e.d(i2 == 0);
                    r9 = false;
                    break;
                case 2:
                    r9 = false;
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                case 7:
                case 8:
                    long abs = Math.abs(j5);
                    int i5 = ((abs - (Math.abs(j3) - abs)) > 0L ? 1 : ((abs - (Math.abs(j3) - abs)) == 0L ? 0 : -1));
                    if (i5 == 0) {
                        r9 = (((1 & j4) != 0) & (roundingMode == RoundingMode.HALF_EVEN)) | (roundingMode == RoundingMode.HALF_UP);
                        break;
                    }
                    break;
                default:
                    throw new AssertionError();
            }
            return r9 ? j4 + i4 : j4;
        }
        return invokeCommon.longValue;
    }

    public static long b(long j2, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Long.valueOf(j2), Long.valueOf(j3)})) == null) {
            long j4 = j2 + j3;
            return (((j3 ^ j2) > 0L ? 1 : ((j3 ^ j2) == 0L ? 0 : -1)) < 0) | ((j2 ^ j4) >= 0) ? j4 : ((j4 >>> 63) ^ 1) + Long.MAX_VALUE;
        }
        return invokeCommon.longValue;
    }
}
