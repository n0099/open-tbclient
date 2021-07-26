package com.google.common.math;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.common.primitives.UnsignedLongs;
import d.f.d.a.n;
import d.f.d.f.e;
import java.math.RoundingMode;
/* loaded from: classes6.dex */
public final class LongMath {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes6.dex */
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
                public long mulMod(long j, long j2, long j3) {
                    InterceptResult invokeCommon;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeCommon = interceptable2.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)})) == null) ? (j * j2) % j3 : invokeCommon.longValue;
                }

                @Override // com.google.common.math.LongMath.MillerRabinTester
                public long squareMod(long j, long j2) {
                    InterceptResult invokeCommon;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeCommon = interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) ? (j * j) % j2 : invokeCommon.longValue;
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

                private long plusMod(long j, long j2, long j3) {
                    InterceptResult invokeCommon;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeCommon = interceptable2.invokeCommon(65537, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)})) == null) {
                        int i2 = (j > (j3 - j2) ? 1 : (j == (j3 - j2) ? 0 : -1));
                        long j4 = j + j2;
                        return i2 >= 0 ? j4 - j3 : j4;
                    }
                    return invokeCommon.longValue;
                }

                private long times2ToThe32Mod(long j, long j2) {
                    InterceptResult invokeCommon;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeCommon = interceptable2.invokeCommon(65538, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) {
                        int i2 = 32;
                        do {
                            int min = Math.min(i2, Long.numberOfLeadingZeros(j));
                            j = UnsignedLongs.e(j << min, j2);
                            i2 -= min;
                        } while (i2 > 0);
                        return j;
                    }
                    return invokeCommon.longValue;
                }

                @Override // com.google.common.math.LongMath.MillerRabinTester
                public long mulMod(long j, long j2, long j3) {
                    InterceptResult invokeCommon;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeCommon = interceptable2.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)})) == null) {
                        long j4 = j >>> 32;
                        long j5 = j2 >>> 32;
                        long j6 = j & 4294967295L;
                        long j7 = j2 & 4294967295L;
                        long times2ToThe32Mod = times2ToThe32Mod(j4 * j5, j3) + (j4 * j7);
                        if (times2ToThe32Mod < 0) {
                            times2ToThe32Mod = UnsignedLongs.e(times2ToThe32Mod, j3);
                        }
                        Long.signum(j6);
                        return plusMod(times2ToThe32Mod(times2ToThe32Mod + (j5 * j6), j3), UnsignedLongs.e(j6 * j7, j3), j3);
                    }
                    return invokeCommon.longValue;
                }

                @Override // com.google.common.math.LongMath.MillerRabinTester
                public long squareMod(long j, long j2) {
                    InterceptResult invokeCommon;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeCommon = interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) {
                        long j3 = j >>> 32;
                        long j4 = j & 4294967295L;
                        long times2ToThe32Mod = times2ToThe32Mod(j3 * j3, j2);
                        long j5 = j3 * j4 * 2;
                        if (j5 < 0) {
                            j5 = UnsignedLongs.e(j5, j2);
                        }
                        return plusMod(times2ToThe32Mod(times2ToThe32Mod + j5, j2), UnsignedLongs.e(j4 * j4, j2), j2);
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

        private long powMod(long j, long j2, long j3) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)})) == null) {
                long j4 = 1;
                while (j2 != 0) {
                    if ((j2 & 1) != 0) {
                        j4 = mulMod(j4, j, j3);
                    }
                    j = squareMod(j, j3);
                    j2 >>= 1;
                }
                return j4;
            }
            return invokeCommon.longValue;
        }

        public static boolean test(long j, long j2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) {
                return (j2 <= 3037000499L ? SMALL : LARGE).testWitness(j, j2);
            }
            return invokeCommon.booleanValue;
        }

        private boolean testWitness(long j, long j2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) {
                long j3 = j2 - 1;
                int numberOfTrailingZeros = Long.numberOfTrailingZeros(j3);
                long j4 = j3 >> numberOfTrailingZeros;
                long j5 = j % j2;
                if (j5 == 0) {
                    return true;
                }
                long powMod = powMod(j5, j4, j2);
                if (powMod == 1) {
                    return true;
                }
                int i2 = 0;
                while (powMod != j3) {
                    i2++;
                    if (i2 == numberOfTrailingZeros) {
                        return false;
                    }
                    powMod = squareMod(powMod, j2);
                }
                return true;
            }
            return invokeCommon.booleanValue;
        }

        public static MillerRabinTester valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, str)) == null) ? (MillerRabinTester) Enum.valueOf(MillerRabinTester.class, str) : (MillerRabinTester) invokeL.objValue;
        }

        public static MillerRabinTester[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? (MillerRabinTester[]) $VALUES.clone() : (MillerRabinTester[]) invokeV.objValue;
        }

        public abstract long mulMod(long j, long j2, long j3);

        public abstract long squareMod(long j, long j2);

        public /* synthetic */ MillerRabinTester(String str, int i2, a aVar) {
            this(str, i2);
        }
    }

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f33717a;
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
            f33717a = iArr;
            try {
                iArr[RoundingMode.UNNECESSARY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f33717a[RoundingMode.DOWN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f33717a[RoundingMode.FLOOR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f33717a[RoundingMode.UP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f33717a[RoundingMode.CEILING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f33717a[RoundingMode.HALF_DOWN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f33717a[RoundingMode.HALF_UP.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f33717a[RoundingMode.HALF_EVEN.ordinal()] = 8;
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
    public static long a(long j, long j2, RoundingMode roundingMode) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Long.valueOf(j), Long.valueOf(j2), roundingMode})) == null) {
            n.p(roundingMode);
            long j3 = j / j2;
            long j4 = j - (j2 * j3);
            int i2 = (j4 > 0L ? 1 : (j4 == 0L ? 0 : -1));
            if (i2 == 0) {
                return j3;
            }
            int i3 = (int) ((j ^ j2) >> 63);
            int i4 = i3 | 1;
            switch (a.f33717a[roundingMode.ordinal()]) {
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
                    long abs = Math.abs(j4);
                    int i5 = ((abs - (Math.abs(j2) - abs)) > 0L ? 1 : ((abs - (Math.abs(j2) - abs)) == 0L ? 0 : -1));
                    if (i5 == 0) {
                        r9 = (((1 & j3) != 0) & (roundingMode == RoundingMode.HALF_EVEN)) | (roundingMode == RoundingMode.HALF_UP);
                        break;
                    }
                    break;
                default:
                    throw new AssertionError();
            }
            return r9 ? j3 + i4 : j3;
        }
        return invokeCommon.longValue;
    }

    public static long b(long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) {
            long j3 = j + j2;
            return (((j2 ^ j) > 0L ? 1 : ((j2 ^ j) == 0L ? 0 : -1)) < 0) | ((j ^ j3) >= 0) ? j3 : ((j3 >>> 63) ^ 1) + Long.MAX_VALUE;
        }
        return invokeCommon.longValue;
    }
}
