package com.google.android.gms.common.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
@VisibleForTesting
@KeepForSdk
/* loaded from: classes7.dex */
public final class ArrayUtils {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ArrayUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @NonNull
    @KeepForSdk
    public static <T> T[] concat(@NonNull T[]... tArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, tArr)) == null) {
            if (tArr.length != 0) {
                int i = 0;
                for (T[] tArr2 : tArr) {
                    i += tArr2.length;
                }
                T[] tArr3 = (T[]) Arrays.copyOf(tArr[0], i);
                int length = tArr[0].length;
                for (int i2 = 1; i2 < tArr.length; i2++) {
                    T[] tArr4 = tArr[i2];
                    int length2 = tArr4.length;
                    System.arraycopy(tArr4, 0, tArr3, length, length2);
                    length += length2;
                }
                return tArr3;
            }
            return (T[]) ((Object[]) Array.newInstance(tArr.getClass(), 0));
        }
        return (T[]) ((Object[]) invokeL.objValue);
    }

    @NonNull
    @KeepForSdk
    public static byte[] concatByteArrays(@NonNull byte[]... bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bArr)) == null) {
            if (bArr.length != 0) {
                int i = 0;
                for (byte[] bArr2 : bArr) {
                    i += bArr2.length;
                }
                byte[] copyOf = Arrays.copyOf(bArr[0], i);
                int length = bArr[0].length;
                for (int i2 = 1; i2 < bArr.length; i2++) {
                    byte[] bArr3 = bArr[i2];
                    int length2 = bArr3.length;
                    System.arraycopy(bArr3, 0, copyOf, length, length2);
                    length += length2;
                }
                return copyOf;
            }
            return new byte[0];
        }
        return (byte[]) invokeL.objValue;
    }

    @NonNull
    @KeepForSdk
    public static int[] toPrimitiveArray(@NonNull Collection<Integer> collection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, collection)) == null) {
            int i = 0;
            if (collection != null && collection.size() != 0) {
                int[] iArr = new int[collection.size()];
                for (Integer num : collection) {
                    iArr[i] = num.intValue();
                    i++;
                }
                return iArr;
            }
            return new int[0];
        }
        return (int[]) invokeL.objValue;
    }

    @KeepForSdk
    public static boolean contains(@NonNull int[] iArr, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, iArr, i)) == null) {
            if (iArr == null) {
                return false;
            }
            for (int i2 : iArr) {
                if (i2 == i) {
                    return true;
                }
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    @KeepForSdk
    public static void writeArray(@NonNull StringBuilder sb, @NonNull double[] dArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, sb, dArr) == null) {
            int length = dArr.length;
            for (int i = 0; i < length; i++) {
                if (i != 0) {
                    sb.append(",");
                }
                sb.append(Double.toString(dArr[i]));
            }
        }
    }

    @KeepForSdk
    public static void writeStringArray(@NonNull StringBuilder sb, @NonNull String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65552, null, sb, strArr) == null) {
            int length = strArr.length;
            for (int i = 0; i < length; i++) {
                if (i != 0) {
                    sb.append(",");
                }
                sb.append("\"");
                sb.append(strArr[i]);
                sb.append("\"");
            }
        }
    }

    @KeepForSdk
    public static <T> boolean contains(@NonNull T[] tArr, @NonNull T t) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, tArr, t)) == null) {
            if (tArr != null) {
                i = tArr.length;
            } else {
                i = 0;
            }
            int i2 = 0;
            while (true) {
                if (i2 >= i) {
                    break;
                } else if (Objects.equal(tArr[i2], t)) {
                    if (i2 >= 0) {
                        return true;
                    }
                } else {
                    i2++;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    @KeepForSdk
    public static void writeArray(@NonNull StringBuilder sb, @NonNull float[] fArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65547, null, sb, fArr) == null) {
            int length = fArr.length;
            for (int i = 0; i < length; i++) {
                if (i != 0) {
                    sb.append(",");
                }
                sb.append(Float.toString(fArr[i]));
            }
        }
    }

    @NonNull
    @KeepForSdk
    public static <T> ArrayList<T> newArrayList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            return new ArrayList<>();
        }
        return (ArrayList) invokeV.objValue;
    }

    @Nullable
    @KeepForSdk
    public static <T> T[] removeAll(@NonNull T[] tArr, @NonNull T... tArr2) {
        InterceptResult invokeLL;
        int length;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, tArr, tArr2)) == null) {
            if (tArr == null) {
                return null;
            }
            if (tArr2 != null && (length = tArr2.length) != 0) {
                T[] tArr3 = (T[]) ((Object[]) Array.newInstance(tArr2.getClass().getComponentType(), tArr.length));
                if (length == 1) {
                    i = 0;
                    for (T t : tArr) {
                        if (!Objects.equal(tArr2[0], t)) {
                            tArr3[i] = t;
                            i++;
                        }
                    }
                } else {
                    int i2 = 0;
                    for (T t2 : tArr) {
                        if (!contains(tArr2, t2)) {
                            tArr3[i2] = t2;
                            i2++;
                        }
                    }
                    i = i2;
                }
                if (tArr3 == null) {
                    return null;
                }
                if (i == tArr3.length) {
                    return tArr3;
                }
                return (T[]) Arrays.copyOf(tArr3, i);
            }
            return (T[]) Arrays.copyOf(tArr, tArr.length);
        }
        return (T[]) ((Object[]) invokeLL.objValue);
    }

    @NonNull
    @KeepForSdk
    public static <T> ArrayList<T> toArrayList(@NonNull T[] tArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, tArr)) == null) {
            ArrayList<T> arrayList = new ArrayList<>(tArr.length);
            for (T t : tArr) {
                arrayList.add(t);
            }
            return arrayList;
        }
        return (ArrayList) invokeL.objValue;
    }

    @Nullable
    @KeepForSdk
    public static Integer[] toWrapperArray(@NonNull int[] iArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, iArr)) == null) {
            if (iArr == null) {
                return null;
            }
            int length = iArr.length;
            Integer[] numArr = new Integer[length];
            for (int i = 0; i < length; i++) {
                numArr[i] = Integer.valueOf(iArr[i]);
            }
            return numArr;
        }
        return (Integer[]) invokeL.objValue;
    }

    @KeepForSdk
    public static void writeArray(@NonNull StringBuilder sb, @NonNull int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65548, null, sb, iArr) == null) {
            int length = iArr.length;
            for (int i = 0; i < length; i++) {
                if (i != 0) {
                    sb.append(",");
                }
                sb.append(Integer.toString(iArr[i]));
            }
        }
    }

    @KeepForSdk
    public static void writeArray(@NonNull StringBuilder sb, @NonNull long[] jArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65549, null, sb, jArr) == null) {
            int length = jArr.length;
            for (int i = 0; i < length; i++) {
                if (i != 0) {
                    sb.append(",");
                }
                sb.append(Long.toString(jArr[i]));
            }
        }
    }

    @KeepForSdk
    public static <T> void writeArray(@NonNull StringBuilder sb, @NonNull T[] tArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65550, null, sb, tArr) == null) {
            int length = tArr.length;
            for (int i = 0; i < length; i++) {
                if (i != 0) {
                    sb.append(",");
                }
                sb.append(tArr[i]);
            }
        }
    }

    @KeepForSdk
    public static void writeArray(@NonNull StringBuilder sb, @NonNull boolean[] zArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65551, null, sb, zArr) == null) {
            int length = zArr.length;
            for (int i = 0; i < length; i++) {
                if (i != 0) {
                    sb.append(",");
                }
                sb.append(Boolean.toString(zArr[i]));
            }
        }
    }
}
