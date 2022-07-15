package com.repackage;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes6.dex */
public class fk9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(@NonNull Parcel parcel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65536, null, parcel)) == null) ? n(parcel, 20293) : invokeL.intValue;
    }

    public static void b(@NonNull Parcel parcel, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65537, null, parcel, i) == null) {
            o(parcel, i);
        }
    }

    public static void c(@NonNull Parcel parcel, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{parcel, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            p(parcel, i, 4);
            parcel.writeInt(z ? 1 : 0);
        }
    }

    public static void d(@NonNull Parcel parcel, int i, @NonNull Bundle bundle, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{parcel, Integer.valueOf(i), bundle, Boolean.valueOf(z)}) == null) {
            if (bundle == null) {
                if (z) {
                    p(parcel, i, 0);
                    return;
                }
                return;
            }
            int n = n(parcel, i);
            parcel.writeBundle(bundle);
            o(parcel, n);
        }
    }

    public static void e(@NonNull Parcel parcel, int i, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{parcel, Integer.valueOf(i), Float.valueOf(f)}) == null) {
            p(parcel, i, 4);
            parcel.writeFloat(f);
        }
    }

    public static void f(@NonNull Parcel parcel, int i, @NonNull IBinder iBinder, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{parcel, Integer.valueOf(i), iBinder, Boolean.valueOf(z)}) == null) {
            if (iBinder == null) {
                if (z) {
                    p(parcel, i, 0);
                    return;
                }
                return;
            }
            int n = n(parcel, i);
            parcel.writeStrongBinder(iBinder);
            o(parcel, n);
        }
    }

    public static void g(@NonNull Parcel parcel, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65542, null, parcel, i, i2) == null) {
            p(parcel, i, 4);
            parcel.writeInt(i2);
        }
    }

    public static void h(@NonNull Parcel parcel, int i, @NonNull int[] iArr, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{parcel, Integer.valueOf(i), iArr, Boolean.valueOf(z)}) == null) {
            if (iArr == null) {
                if (z) {
                    p(parcel, i, 0);
                    return;
                }
                return;
            }
            int n = n(parcel, i);
            parcel.writeIntArray(iArr);
            o(parcel, n);
        }
    }

    public static void i(@NonNull Parcel parcel, int i, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{parcel, Integer.valueOf(i), Long.valueOf(j)}) == null) {
            p(parcel, i, 8);
            parcel.writeLong(j);
        }
    }

    public static void j(@NonNull Parcel parcel, int i, @NonNull Parcelable parcelable, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65545, null, new Object[]{parcel, Integer.valueOf(i), parcelable, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            if (parcelable == null) {
                if (z) {
                    p(parcel, i, 0);
                    return;
                }
                return;
            }
            int n = n(parcel, i);
            parcelable.writeToParcel(parcel, i2);
            o(parcel, n);
        }
    }

    public static void k(@NonNull Parcel parcel, int i, @NonNull String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65546, null, new Object[]{parcel, Integer.valueOf(i), str, Boolean.valueOf(z)}) == null) {
            if (str == null) {
                if (z) {
                    p(parcel, i, 0);
                    return;
                }
                return;
            }
            int n = n(parcel, i);
            parcel.writeString(str);
            o(parcel, n);
        }
    }

    public static void l(@NonNull Parcel parcel, int i, @NonNull List<String> list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65547, null, new Object[]{parcel, Integer.valueOf(i), list, Boolean.valueOf(z)}) == null) {
            if (list == null) {
                if (z) {
                    p(parcel, i, 0);
                    return;
                }
                return;
            }
            int n = n(parcel, i);
            parcel.writeStringList(list);
            o(parcel, n);
        }
    }

    public static <T extends Parcelable> void m(@NonNull Parcel parcel, int i, @NonNull T[] tArr, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65548, null, new Object[]{parcel, Integer.valueOf(i), tArr, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            if (tArr == null) {
                if (z) {
                    p(parcel, i, 0);
                    return;
                }
                return;
            }
            int n = n(parcel, i);
            parcel.writeInt(tArr.length);
            for (T t : tArr) {
                if (t == null) {
                    parcel.writeInt(0);
                } else {
                    q(parcel, t, i2);
                }
            }
            o(parcel, n);
        }
    }

    public static int n(Parcel parcel, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65549, null, parcel, i)) == null) {
            parcel.writeInt(i | SupportMenu.CATEGORY_MASK);
            parcel.writeInt(0);
            return parcel.dataPosition();
        }
        return invokeLI.intValue;
    }

    public static void o(Parcel parcel, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65550, null, parcel, i) == null) {
            int dataPosition = parcel.dataPosition();
            parcel.setDataPosition(i - 4);
            parcel.writeInt(dataPosition - i);
            parcel.setDataPosition(dataPosition);
        }
    }

    public static void p(Parcel parcel, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65551, null, parcel, i, i2) == null) {
            parcel.writeInt(i | (i2 << 16));
        }
    }

    public static <T extends Parcelable> void q(Parcel parcel, T t, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65552, null, parcel, t, i) == null) {
            int dataPosition = parcel.dataPosition();
            parcel.writeInt(1);
            int dataPosition2 = parcel.dataPosition();
            t.writeToParcel(parcel, i);
            int dataPosition3 = parcel.dataPosition();
            parcel.setDataPosition(dataPosition);
            parcel.writeInt(dataPosition3 - dataPosition2);
            parcel.setDataPosition(dataPosition3);
        }
    }
}
