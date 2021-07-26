package com.google.common.primitives;

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
import d.f.d.a.n;
import java.math.BigInteger;
import java.util.Comparator;
/* loaded from: classes6.dex */
public final class UnsignedLongs {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes6.dex */
    public static final class LexicographicalComparator implements Comparator<long[]> {
        public static final /* synthetic */ LexicographicalComparator[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final LexicographicalComparator INSTANCE;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2016080219, "Lcom/google/common/primitives/UnsignedLongs$LexicographicalComparator;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-2016080219, "Lcom/google/common/primitives/UnsignedLongs$LexicographicalComparator;");
                    return;
                }
            }
            LexicographicalComparator lexicographicalComparator = new LexicographicalComparator("INSTANCE", 0);
            INSTANCE = lexicographicalComparator;
            $VALUES = new LexicographicalComparator[]{lexicographicalComparator};
        }

        public LexicographicalComparator(String str, int i2) {
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

        public static LexicographicalComparator valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (LexicographicalComparator) Enum.valueOf(LexicographicalComparator.class, str) : (LexicographicalComparator) invokeL.objValue;
        }

        public static LexicographicalComparator[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (LexicographicalComparator[]) $VALUES.clone() : (LexicographicalComparator[]) invokeV.objValue;
        }

        @Override // java.lang.Enum
        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "UnsignedLongs.lexicographicalComparator()" : (String) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        public int compare(long[] jArr, long[] jArr2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jArr, jArr2)) == null) {
                int min = Math.min(jArr.length, jArr2.length);
                for (int i2 = 0; i2 < min; i2++) {
                    if (jArr[i2] != jArr2[i2]) {
                        return UnsignedLongs.a(jArr[i2], jArr2[i2]);
                    }
                }
                return jArr.length - jArr2.length;
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes6.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final long[] f33724a;

        /* renamed from: b  reason: collision with root package name */
        public static final int[] f33725b;

        /* renamed from: c  reason: collision with root package name */
        public static final int[] f33726c;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(369305943, "Lcom/google/common/primitives/UnsignedLongs$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(369305943, "Lcom/google/common/primitives/UnsignedLongs$a;");
                    return;
                }
            }
            f33724a = new long[37];
            f33725b = new int[37];
            f33726c = new int[37];
            BigInteger bigInteger = new BigInteger("10000000000000000", 16);
            for (int i2 = 2; i2 <= 36; i2++) {
                long j = i2;
                f33724a[i2] = UnsignedLongs.b(-1L, j);
                f33725b[i2] = (int) UnsignedLongs.e(-1L, j);
                f33726c[i2] = bigInteger.toString(i2).length() - 1;
            }
        }

        public static boolean a(long j, int i2, int i3) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Long.valueOf(j), Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
                if (j >= 0) {
                    long[] jArr = f33724a;
                    if (j < jArr[i3]) {
                        return false;
                    }
                    return j > jArr[i3] || i2 > f33725b[i3];
                }
                return true;
            }
            return invokeCommon.booleanValue;
        }
    }

    public static int a(long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) ? Longs.c(c(j), c(j2)) : invokeCommon.intValue;
    }

    public static long b(long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) {
            if (j2 < 0) {
                return a(j, j2) < 0 ? 0L : 1L;
            } else if (j >= 0) {
                return j / j2;
            } else {
                long j3 = ((j >>> 1) / j2) << 1;
                return j3 + (a(j - (j3 * j2), j2) < 0 ? 0 : 1);
            }
        }
        return invokeCommon.longValue;
    }

    public static long c(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65538, null, j)) == null) ? j ^ Long.MIN_VALUE : invokeJ.longValue;
    }

    public static long d(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, str, i2)) == null) {
            n.p(str);
            if (str.length() != 0) {
                if (i2 >= 2 && i2 <= 36) {
                    int i3 = a.f33726c[i2] - 1;
                    long j = 0;
                    for (int i4 = 0; i4 < str.length(); i4++) {
                        int digit = Character.digit(str.charAt(i4), i2);
                        if (digit != -1) {
                            if (i4 > i3 && a.a(j, digit, i2)) {
                                throw new NumberFormatException("Too large for unsigned long: " + str);
                            }
                            j = (j * i2) + digit;
                        } else {
                            throw new NumberFormatException(str);
                        }
                    }
                    return j;
                }
                throw new NumberFormatException("illegal radix: " + i2);
            }
            throw new NumberFormatException("empty string");
        }
        return invokeLI.longValue;
    }

    public static long e(long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) {
            if (j2 < 0) {
                return a(j, j2) < 0 ? j : j - j2;
            } else if (j >= 0) {
                return j % j2;
            } else {
                long j3 = j - ((((j >>> 1) / j2) << 1) * j2);
                if (a(j3, j2) < 0) {
                    j2 = 0;
                }
                return j3 - j2;
            }
        }
        return invokeCommon.longValue;
    }

    public static String f(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(AdIconUtil.AD_TEXT_ID, null, j)) == null) ? g(j, 10) : (String) invokeJ.objValue;
    }

    public static String g(long j, int i2) {
        InterceptResult invokeCommon;
        long b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, null, new Object[]{Long.valueOf(j), Integer.valueOf(i2)})) == null) {
            n.f(i2 >= 2 && i2 <= 36, "radix (%s) must be between Character.MIN_RADIX and Character.MAX_RADIX", i2);
            int i3 = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i3 == 0) {
                return "0";
            }
            if (i3 > 0) {
                return Long.toString(j, i2);
            }
            int i4 = 64;
            char[] cArr = new char[64];
            int i5 = i2 - 1;
            if ((i2 & i5) == 0) {
                int numberOfTrailingZeros = Integer.numberOfTrailingZeros(i2);
                do {
                    i4--;
                    cArr[i4] = Character.forDigit(((int) j) & i5, i2);
                    j >>>= numberOfTrailingZeros;
                } while (j != 0);
            } else {
                if ((i2 & 1) == 0) {
                    b2 = (j >>> 1) / (i2 >>> 1);
                } else {
                    b2 = b(j, i2);
                }
                long j2 = i2;
                cArr[63] = Character.forDigit((int) (j - (b2 * j2)), i2);
                i4 = 63;
                while (b2 > 0) {
                    i4--;
                    cArr[i4] = Character.forDigit((int) (b2 % j2), i2);
                    b2 /= j2;
                }
            }
            return new String(cArr, i4, 64 - i4);
        }
        return (String) invokeCommon.objValue;
    }
}
