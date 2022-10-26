package com.google.android.gms.common.internal.safeparcel;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import android.util.SparseLongArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
/* loaded from: classes7.dex */
public class SafeParcelWriter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public SafeParcelWriter() {
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

    public static int beginObjectHeader(Parcel parcel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, parcel)) == null) {
            return zza(parcel, 20293);
        }
        return invokeL.intValue;
    }

    public static void finishObjectHeader(Parcel parcel, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65538, null, parcel, i) == null) {
            zzb(parcel, i);
        }
    }

    public static int zza(Parcel parcel, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65594, null, parcel, i)) == null) {
            parcel.writeInt(i | (-65536));
            parcel.writeInt(0);
            return parcel.dataPosition();
        }
        return invokeLI.intValue;
    }

    public static void zzb(Parcel parcel, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65595, null, parcel, i) == null) {
            int dataPosition = parcel.dataPosition();
            parcel.setDataPosition(i - 4);
            parcel.writeInt(dataPosition - i);
            parcel.setDataPosition(dataPosition);
        }
    }

    public static void writeBigDecimal(Parcel parcel, int i, BigDecimal bigDecimal, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{parcel, Integer.valueOf(i), bigDecimal, Boolean.valueOf(z)}) == null) {
            if (bigDecimal == null) {
                if (z) {
                    zzc(parcel, i, 0);
                    return;
                }
                return;
            }
            int zza = zza(parcel, i);
            parcel.writeByteArray(bigDecimal.unscaledValue().toByteArray());
            parcel.writeInt(bigDecimal.scale());
            zzb(parcel, zza);
        }
    }

    public static void writeBigDecimalArray(Parcel parcel, int i, BigDecimal[] bigDecimalArr, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{parcel, Integer.valueOf(i), bigDecimalArr, Boolean.valueOf(z)}) == null) {
            if (bigDecimalArr == null) {
                if (z) {
                    zzc(parcel, i, 0);
                    return;
                }
                return;
            }
            int zza = zza(parcel, i);
            int length = bigDecimalArr.length;
            parcel.writeInt(length);
            for (int i2 = 0; i2 < length; i2++) {
                parcel.writeByteArray(bigDecimalArr[i2].unscaledValue().toByteArray());
                parcel.writeInt(bigDecimalArr[i2].scale());
            }
            zzb(parcel, zza);
        }
    }

    public static void writeBigIntegerArray(Parcel parcel, int i, BigInteger[] bigIntegerArr, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{parcel, Integer.valueOf(i), bigIntegerArr, Boolean.valueOf(z)}) == null) {
            if (bigIntegerArr == null) {
                if (z) {
                    zzc(parcel, i, 0);
                    return;
                }
                return;
            }
            int zza = zza(parcel, i);
            parcel.writeInt(bigIntegerArr.length);
            for (BigInteger bigInteger : bigIntegerArr) {
                parcel.writeByteArray(bigInteger.toByteArray());
            }
            zzb(parcel, zza);
        }
    }

    public static void writeBooleanList(Parcel parcel, int i, List list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65545, null, new Object[]{parcel, Integer.valueOf(i), list, Boolean.valueOf(z)}) == null) {
            if (list == null) {
                if (z) {
                    zzc(parcel, i, 0);
                    return;
                }
                return;
            }
            int zza = zza(parcel, i);
            int size = list.size();
            parcel.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                parcel.writeInt(((Boolean) list.get(i2)).booleanValue() ? 1 : 0);
            }
            zzb(parcel, zza);
        }
    }

    public static void writeByteArrayArray(Parcel parcel, int i, byte[][] bArr, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65550, null, new Object[]{parcel, Integer.valueOf(i), bArr, Boolean.valueOf(z)}) == null) {
            if (bArr == null) {
                if (z) {
                    zzc(parcel, i, 0);
                    return;
                }
                return;
            }
            int zza = zza(parcel, i);
            parcel.writeInt(bArr.length);
            for (byte[] bArr2 : bArr) {
                parcel.writeByteArray(bArr2);
            }
            zzb(parcel, zza);
        }
    }

    public static void writeByteArraySparseArray(Parcel parcel, int i, SparseArray sparseArray, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65551, null, new Object[]{parcel, Integer.valueOf(i), sparseArray, Boolean.valueOf(z)}) == null) {
            if (sparseArray == null) {
                if (z) {
                    zzc(parcel, i, 0);
                    return;
                }
                return;
            }
            int zza = zza(parcel, i);
            int size = sparseArray.size();
            parcel.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                parcel.writeInt(sparseArray.keyAt(i2));
                parcel.writeByteArray((byte[]) sparseArray.valueAt(i2));
            }
            zzb(parcel, zza);
        }
    }

    public static void writeDoubleList(Parcel parcel, int i, List list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65556, null, new Object[]{parcel, Integer.valueOf(i), list, Boolean.valueOf(z)}) == null) {
            if (list == null) {
                if (z) {
                    zzc(parcel, i, 0);
                    return;
                }
                return;
            }
            int zza = zza(parcel, i);
            int size = list.size();
            parcel.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                parcel.writeDouble(((Double) list.get(i2)).doubleValue());
            }
            zzb(parcel, zza);
        }
    }

    public static void writeDoubleSparseArray(Parcel parcel, int i, SparseArray sparseArray, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65558, null, new Object[]{parcel, Integer.valueOf(i), sparseArray, Boolean.valueOf(z)}) == null) {
            if (sparseArray == null) {
                if (z) {
                    zzc(parcel, i, 0);
                    return;
                }
                return;
            }
            int zza = zza(parcel, i);
            int size = sparseArray.size();
            parcel.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                parcel.writeInt(sparseArray.keyAt(i2));
                parcel.writeDouble(((Double) sparseArray.valueAt(i2)).doubleValue());
            }
            zzb(parcel, zza);
        }
    }

    public static void writeFloatList(Parcel parcel, int i, List list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65561, null, new Object[]{parcel, Integer.valueOf(i), list, Boolean.valueOf(z)}) == null) {
            if (list == null) {
                if (z) {
                    zzc(parcel, i, 0);
                    return;
                }
                return;
            }
            int zza = zza(parcel, i);
            int size = list.size();
            parcel.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                parcel.writeFloat(((Float) list.get(i2)).floatValue());
            }
            zzb(parcel, zza);
        }
    }

    public static void writeFloatSparseArray(Parcel parcel, int i, SparseArray sparseArray, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65563, null, new Object[]{parcel, Integer.valueOf(i), sparseArray, Boolean.valueOf(z)}) == null) {
            if (sparseArray == null) {
                if (z) {
                    zzc(parcel, i, 0);
                    return;
                }
                return;
            }
            int zza = zza(parcel, i);
            int size = sparseArray.size();
            parcel.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                parcel.writeInt(sparseArray.keyAt(i2));
                parcel.writeFloat(((Float) sparseArray.valueAt(i2)).floatValue());
            }
            zzb(parcel, zza);
        }
    }

    public static void writeIBinderSparseArray(Parcel parcel, int i, SparseArray sparseArray, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65567, null, new Object[]{parcel, Integer.valueOf(i), sparseArray, Boolean.valueOf(z)}) == null) {
            if (sparseArray == null) {
                if (z) {
                    zzc(parcel, i, 0);
                    return;
                }
                return;
            }
            int zza = zza(parcel, i);
            int size = sparseArray.size();
            parcel.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                parcel.writeInt(sparseArray.keyAt(i2));
                parcel.writeStrongBinder((IBinder) sparseArray.valueAt(i2));
            }
            zzb(parcel, zza);
        }
    }

    public static void writeIntegerList(Parcel parcel, int i, List list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65570, null, new Object[]{parcel, Integer.valueOf(i), list, Boolean.valueOf(z)}) == null) {
            if (list == null) {
                if (z) {
                    zzc(parcel, i, 0);
                    return;
                }
                return;
            }
            int zza = zza(parcel, i);
            int size = list.size();
            parcel.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                parcel.writeInt(((Integer) list.get(i2)).intValue());
            }
            zzb(parcel, zza);
        }
    }

    public static void writeLongList(Parcel parcel, int i, List list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65575, null, new Object[]{parcel, Integer.valueOf(i), list, Boolean.valueOf(z)}) == null) {
            if (list == null) {
                if (z) {
                    zzc(parcel, i, 0);
                    return;
                }
                return;
            }
            int zza = zza(parcel, i);
            int size = list.size();
            parcel.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                parcel.writeLong(((Long) list.get(i2)).longValue());
            }
            zzb(parcel, zza);
        }
    }

    public static void writeParcelArray(Parcel parcel, int i, Parcel[] parcelArr, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65578, null, new Object[]{parcel, Integer.valueOf(i), parcelArr, Boolean.valueOf(z)}) == null) {
            if (parcelArr == null) {
                if (z) {
                    zzc(parcel, i, 0);
                    return;
                }
                return;
            }
            int zza = zza(parcel, i);
            parcel.writeInt(parcelArr.length);
            for (Parcel parcel2 : parcelArr) {
                if (parcel2 != null) {
                    parcel.writeInt(parcel2.dataSize());
                    parcel.appendFrom(parcel2, 0, parcel2.dataSize());
                } else {
                    parcel.writeInt(0);
                }
            }
            zzb(parcel, zza);
        }
    }

    public static void writeParcelList(Parcel parcel, int i, List list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65579, null, new Object[]{parcel, Integer.valueOf(i), list, Boolean.valueOf(z)}) == null) {
            if (list == null) {
                if (z) {
                    zzc(parcel, i, 0);
                    return;
                }
                return;
            }
            int zza = zza(parcel, i);
            int size = list.size();
            parcel.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                Parcel parcel2 = (Parcel) list.get(i2);
                if (parcel2 != null) {
                    parcel.writeInt(parcel2.dataSize());
                    parcel.appendFrom(parcel2, 0, parcel2.dataSize());
                } else {
                    parcel.writeInt(0);
                }
            }
            zzb(parcel, zza);
        }
    }

    public static void writeSparseIntArray(Parcel parcel, int i, SparseIntArray sparseIntArray, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65585, null, new Object[]{parcel, Integer.valueOf(i), sparseIntArray, Boolean.valueOf(z)}) == null) {
            if (sparseIntArray == null) {
                if (z) {
                    zzc(parcel, i, 0);
                    return;
                }
                return;
            }
            int zza = zza(parcel, i);
            int size = sparseIntArray.size();
            parcel.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                parcel.writeInt(sparseIntArray.keyAt(i2));
                parcel.writeInt(sparseIntArray.valueAt(i2));
            }
            zzb(parcel, zza);
        }
    }

    public static void writeSparseLongArray(Parcel parcel, int i, SparseLongArray sparseLongArray, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65586, null, new Object[]{parcel, Integer.valueOf(i), sparseLongArray, Boolean.valueOf(z)}) == null) {
            if (sparseLongArray == null) {
                if (z) {
                    zzc(parcel, i, 0);
                    return;
                }
                return;
            }
            int zza = zza(parcel, i);
            int size = sparseLongArray.size();
            parcel.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                parcel.writeInt(sparseLongArray.keyAt(i2));
                parcel.writeLong(sparseLongArray.valueAt(i2));
            }
            zzb(parcel, zza);
        }
    }

    public static void writeStringSparseArray(Parcel parcel, int i, SparseArray sparseArray, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65590, null, new Object[]{parcel, Integer.valueOf(i), sparseArray, Boolean.valueOf(z)}) == null) {
            if (sparseArray == null) {
                if (z) {
                    zzc(parcel, i, 0);
                    return;
                }
                return;
            }
            int zza = zza(parcel, i);
            int size = sparseArray.size();
            parcel.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                parcel.writeInt(sparseArray.keyAt(i2));
                parcel.writeString((String) sparseArray.valueAt(i2));
            }
            zzb(parcel, zza);
        }
    }

    public static void writeTypedList(Parcel parcel, int i, List list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65592, null, new Object[]{parcel, Integer.valueOf(i), list, Boolean.valueOf(z)}) == null) {
            if (list == null) {
                if (z) {
                    zzc(parcel, i, 0);
                    return;
                }
                return;
            }
            int zza = zza(parcel, i);
            int size = list.size();
            parcel.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                Parcelable parcelable = (Parcelable) list.get(i2);
                if (parcelable == null) {
                    parcel.writeInt(0);
                } else {
                    zzd(parcel, parcelable, 0);
                }
            }
            zzb(parcel, zza);
        }
    }

    public static void writeTypedSparseArray(Parcel parcel, int i, SparseArray sparseArray, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65593, null, new Object[]{parcel, Integer.valueOf(i), sparseArray, Boolean.valueOf(z)}) == null) {
            if (sparseArray == null) {
                if (z) {
                    zzc(parcel, i, 0);
                    return;
                }
                return;
            }
            int zza = zza(parcel, i);
            int size = sparseArray.size();
            parcel.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                parcel.writeInt(sparseArray.keyAt(i2));
                Parcelable parcelable = (Parcelable) sparseArray.valueAt(i2);
                if (parcelable == null) {
                    parcel.writeInt(0);
                } else {
                    zzd(parcel, parcelable, 0);
                }
            }
            zzb(parcel, zza);
        }
    }

    public static void writeBigInteger(Parcel parcel, int i, BigInteger bigInteger, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{parcel, Integer.valueOf(i), bigInteger, Boolean.valueOf(z)}) == null) {
            if (bigInteger == null) {
                if (z) {
                    zzc(parcel, i, 0);
                    return;
                }
                return;
            }
            int zza = zza(parcel, i);
            parcel.writeByteArray(bigInteger.toByteArray());
            zzb(parcel, zza);
        }
    }

    public static void writeBooleanArray(Parcel parcel, int i, boolean[] zArr, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{parcel, Integer.valueOf(i), zArr, Boolean.valueOf(z)}) == null) {
            if (zArr == null) {
                if (z) {
                    zzc(parcel, i, 0);
                    return;
                }
                return;
            }
            int zza = zza(parcel, i);
            parcel.writeBooleanArray(zArr);
            zzb(parcel, zza);
        }
    }

    public static void writeBooleanObject(Parcel parcel, int i, Boolean bool, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65546, null, new Object[]{parcel, Integer.valueOf(i), bool, Boolean.valueOf(z)}) == null) {
            if (bool == null) {
                if (z) {
                    zzc(parcel, i, 0);
                    return;
                }
                return;
            }
            zzc(parcel, i, 4);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        }
    }

    public static void writeBundle(Parcel parcel, int i, Bundle bundle, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65547, null, new Object[]{parcel, Integer.valueOf(i), bundle, Boolean.valueOf(z)}) == null) {
            if (bundle == null) {
                if (z) {
                    zzc(parcel, i, 0);
                    return;
                }
                return;
            }
            int zza = zza(parcel, i);
            parcel.writeBundle(bundle);
            zzb(parcel, zza);
        }
    }

    public static void writeByteArray(Parcel parcel, int i, byte[] bArr, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65549, null, new Object[]{parcel, Integer.valueOf(i), bArr, Boolean.valueOf(z)}) == null) {
            if (bArr == null) {
                if (z) {
                    zzc(parcel, i, 0);
                    return;
                }
                return;
            }
            int zza = zza(parcel, i);
            parcel.writeByteArray(bArr);
            zzb(parcel, zza);
        }
    }

    public static void writeCharArray(Parcel parcel, int i, char[] cArr, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65553, null, new Object[]{parcel, Integer.valueOf(i), cArr, Boolean.valueOf(z)}) == null) {
            if (cArr == null) {
                if (z) {
                    zzc(parcel, i, 0);
                    return;
                }
                return;
            }
            int zza = zza(parcel, i);
            parcel.writeCharArray(cArr);
            zzb(parcel, zza);
        }
    }

    public static void writeDoubleArray(Parcel parcel, int i, double[] dArr, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65555, null, new Object[]{parcel, Integer.valueOf(i), dArr, Boolean.valueOf(z)}) == null) {
            if (dArr == null) {
                if (z) {
                    zzc(parcel, i, 0);
                    return;
                }
                return;
            }
            int zza = zza(parcel, i);
            parcel.writeDoubleArray(dArr);
            zzb(parcel, zza);
        }
    }

    public static void writeDoubleObject(Parcel parcel, int i, Double d, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65557, null, new Object[]{parcel, Integer.valueOf(i), d, Boolean.valueOf(z)}) == null) {
            if (d == null) {
                if (z) {
                    zzc(parcel, i, 0);
                    return;
                }
                return;
            }
            zzc(parcel, i, 8);
            parcel.writeDouble(d.doubleValue());
        }
    }

    public static void writeFloatArray(Parcel parcel, int i, float[] fArr, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65560, null, new Object[]{parcel, Integer.valueOf(i), fArr, Boolean.valueOf(z)}) == null) {
            if (fArr == null) {
                if (z) {
                    zzc(parcel, i, 0);
                    return;
                }
                return;
            }
            int zza = zza(parcel, i);
            parcel.writeFloatArray(fArr);
            zzb(parcel, zza);
        }
    }

    public static void writeFloatObject(Parcel parcel, int i, Float f, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65562, null, new Object[]{parcel, Integer.valueOf(i), f, Boolean.valueOf(z)}) == null) {
            if (f == null) {
                if (z) {
                    zzc(parcel, i, 0);
                    return;
                }
                return;
            }
            zzc(parcel, i, 4);
            parcel.writeFloat(f.floatValue());
        }
    }

    public static void writeIBinder(Parcel parcel, int i, IBinder iBinder, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65564, null, new Object[]{parcel, Integer.valueOf(i), iBinder, Boolean.valueOf(z)}) == null) {
            if (iBinder == null) {
                if (z) {
                    zzc(parcel, i, 0);
                    return;
                }
                return;
            }
            int zza = zza(parcel, i);
            parcel.writeStrongBinder(iBinder);
            zzb(parcel, zza);
        }
    }

    public static void writeIBinderArray(Parcel parcel, int i, IBinder[] iBinderArr, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65565, null, new Object[]{parcel, Integer.valueOf(i), iBinderArr, Boolean.valueOf(z)}) == null) {
            if (iBinderArr == null) {
                if (z) {
                    zzc(parcel, i, 0);
                    return;
                }
                return;
            }
            int zza = zza(parcel, i);
            parcel.writeBinderArray(iBinderArr);
            zzb(parcel, zza);
        }
    }

    public static void writeIBinderList(Parcel parcel, int i, List list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65566, null, new Object[]{parcel, Integer.valueOf(i), list, Boolean.valueOf(z)}) == null) {
            if (list == null) {
                if (z) {
                    zzc(parcel, i, 0);
                    return;
                }
                return;
            }
            int zza = zza(parcel, i);
            parcel.writeBinderList(list);
            zzb(parcel, zza);
        }
    }

    public static void writeIntArray(Parcel parcel, int i, int[] iArr, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65569, null, new Object[]{parcel, Integer.valueOf(i), iArr, Boolean.valueOf(z)}) == null) {
            if (iArr == null) {
                if (z) {
                    zzc(parcel, i, 0);
                    return;
                }
                return;
            }
            int zza = zza(parcel, i);
            parcel.writeIntArray(iArr);
            zzb(parcel, zza);
        }
    }

    public static void writeIntegerObject(Parcel parcel, int i, Integer num, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65571, null, new Object[]{parcel, Integer.valueOf(i), num, Boolean.valueOf(z)}) == null) {
            if (num == null) {
                if (z) {
                    zzc(parcel, i, 0);
                    return;
                }
                return;
            }
            zzc(parcel, i, 4);
            parcel.writeInt(num.intValue());
        }
    }

    public static void writeList(Parcel parcel, int i, List list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65572, null, new Object[]{parcel, Integer.valueOf(i), list, Boolean.valueOf(z)}) == null) {
            if (list == null) {
                if (z) {
                    zzc(parcel, i, 0);
                    return;
                }
                return;
            }
            int zza = zza(parcel, i);
            parcel.writeList(list);
            zzb(parcel, zza);
        }
    }

    public static void writeLongArray(Parcel parcel, int i, long[] jArr, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65574, null, new Object[]{parcel, Integer.valueOf(i), jArr, Boolean.valueOf(z)}) == null) {
            if (jArr == null) {
                if (z) {
                    zzc(parcel, i, 0);
                    return;
                }
                return;
            }
            int zza = zza(parcel, i);
            parcel.writeLongArray(jArr);
            zzb(parcel, zza);
        }
    }

    public static void writeLongObject(Parcel parcel, int i, Long l, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65576, null, new Object[]{parcel, Integer.valueOf(i), l, Boolean.valueOf(z)}) == null) {
            if (l == null) {
                if (z) {
                    zzc(parcel, i, 0);
                    return;
                }
                return;
            }
            zzc(parcel, i, 8);
            parcel.writeLong(l.longValue());
        }
    }

    public static void writeParcel(Parcel parcel, int i, Parcel parcel2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65577, null, new Object[]{parcel, Integer.valueOf(i), parcel2, Boolean.valueOf(z)}) == null) {
            if (parcel2 == null) {
                if (z) {
                    zzc(parcel, i, 0);
                    return;
                }
                return;
            }
            int zza = zza(parcel, i);
            parcel.appendFrom(parcel2, 0, parcel2.dataSize());
            zzb(parcel, zza);
        }
    }

    public static void writePendingIntent(Parcel parcel, int i, PendingIntent pendingIntent, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65582, null, new Object[]{parcel, Integer.valueOf(i), pendingIntent, Boolean.valueOf(z)}) == null) {
            if (pendingIntent == null) {
                if (z) {
                    zzc(parcel, i, 0);
                    return;
                }
                return;
            }
            int zza = zza(parcel, i);
            PendingIntent.writePendingIntentOrNullToParcel(pendingIntent, parcel);
            zzb(parcel, zza);
        }
    }

    public static void writeSparseBooleanArray(Parcel parcel, int i, SparseBooleanArray sparseBooleanArray, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65584, null, new Object[]{parcel, Integer.valueOf(i), sparseBooleanArray, Boolean.valueOf(z)}) == null) {
            if (sparseBooleanArray == null) {
                if (z) {
                    zzc(parcel, i, 0);
                    return;
                }
                return;
            }
            int zza = zza(parcel, i);
            parcel.writeSparseBooleanArray(sparseBooleanArray);
            zzb(parcel, zza);
        }
    }

    public static void writeString(Parcel parcel, int i, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65587, null, new Object[]{parcel, Integer.valueOf(i), str, Boolean.valueOf(z)}) == null) {
            if (str == null) {
                if (z) {
                    zzc(parcel, i, 0);
                    return;
                }
                return;
            }
            int zza = zza(parcel, i);
            parcel.writeString(str);
            zzb(parcel, zza);
        }
    }

    public static void writeStringArray(Parcel parcel, int i, String[] strArr, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65588, null, new Object[]{parcel, Integer.valueOf(i), strArr, Boolean.valueOf(z)}) == null) {
            if (strArr == null) {
                if (z) {
                    zzc(parcel, i, 0);
                    return;
                }
                return;
            }
            int zza = zza(parcel, i);
            parcel.writeStringArray(strArr);
            zzb(parcel, zza);
        }
    }

    public static void writeStringList(Parcel parcel, int i, List list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65589, null, new Object[]{parcel, Integer.valueOf(i), list, Boolean.valueOf(z)}) == null) {
            if (list == null) {
                if (z) {
                    zzc(parcel, i, 0);
                    return;
                }
                return;
            }
            int zza = zza(parcel, i);
            parcel.writeStringList(list);
            zzb(parcel, zza);
        }
    }

    public static void writeBoolean(Parcel parcel, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{parcel, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            zzc(parcel, i, 4);
            parcel.writeInt(z ? 1 : 0);
        }
    }

    public static void writeByte(Parcel parcel, int i, byte b) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65548, null, new Object[]{parcel, Integer.valueOf(i), Byte.valueOf(b)}) == null) {
            zzc(parcel, i, 4);
            parcel.writeInt(b);
        }
    }

    public static void writeChar(Parcel parcel, int i, char c) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65552, null, new Object[]{parcel, Integer.valueOf(i), Character.valueOf(c)}) == null) {
            zzc(parcel, i, 4);
            parcel.writeInt(c);
        }
    }

    public static void writeDouble(Parcel parcel, int i, double d) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65554, null, new Object[]{parcel, Integer.valueOf(i), Double.valueOf(d)}) == null) {
            zzc(parcel, i, 8);
            parcel.writeDouble(d);
        }
    }

    public static void writeFloat(Parcel parcel, int i, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65559, null, new Object[]{parcel, Integer.valueOf(i), Float.valueOf(f)}) == null) {
            zzc(parcel, i, 4);
            parcel.writeFloat(f);
        }
    }

    public static void writeInt(Parcel parcel, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65568, null, parcel, i, i2) == null) {
            zzc(parcel, i, 4);
            parcel.writeInt(i2);
        }
    }

    public static void writeLong(Parcel parcel, int i, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65573, null, new Object[]{parcel, Integer.valueOf(i), Long.valueOf(j)}) == null) {
            zzc(parcel, i, 8);
            parcel.writeLong(j);
        }
    }

    public static void writeShort(Parcel parcel, int i, short s) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65583, null, new Object[]{parcel, Integer.valueOf(i), Short.valueOf(s)}) == null) {
            zzc(parcel, i, 4);
            parcel.writeInt(s);
        }
    }

    public static void zzc(Parcel parcel, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65596, null, parcel, i, i2) == null) {
            parcel.writeInt(i | (i2 << 16));
        }
    }

    public static void zzd(Parcel parcel, Parcelable parcelable, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65597, null, parcel, parcelable, i) == null) {
            int dataPosition = parcel.dataPosition();
            parcel.writeInt(1);
            int dataPosition2 = parcel.dataPosition();
            parcelable.writeToParcel(parcel, i);
            int dataPosition3 = parcel.dataPosition();
            parcel.setDataPosition(dataPosition);
            parcel.writeInt(dataPosition3 - dataPosition2);
            parcel.setDataPosition(dataPosition3);
        }
    }

    public static void writeParcelSparseArray(Parcel parcel, int i, SparseArray sparseArray, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65580, null, new Object[]{parcel, Integer.valueOf(i), sparseArray, Boolean.valueOf(z)}) == null) {
            if (sparseArray == null) {
                if (z) {
                    zzc(parcel, i, 0);
                    return;
                }
                return;
            }
            int zza = zza(parcel, i);
            int size = sparseArray.size();
            parcel.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                parcel.writeInt(sparseArray.keyAt(i2));
                Parcel parcel2 = (Parcel) sparseArray.valueAt(i2);
                if (parcel2 != null) {
                    parcel.writeInt(parcel2.dataSize());
                    parcel.appendFrom(parcel2, 0, parcel2.dataSize());
                } else {
                    parcel.writeInt(0);
                }
            }
            zzb(parcel, zza);
        }
    }

    public static void writeParcelable(Parcel parcel, int i, Parcelable parcelable, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65581, null, new Object[]{parcel, Integer.valueOf(i), parcelable, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            if (parcelable == null) {
                if (z) {
                    zzc(parcel, i, 0);
                    return;
                }
                return;
            }
            int zza = zza(parcel, i);
            parcelable.writeToParcel(parcel, i2);
            zzb(parcel, zza);
        }
    }

    public static void writeTypedArray(Parcel parcel, int i, Parcelable[] parcelableArr, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65591, null, new Object[]{parcel, Integer.valueOf(i), parcelableArr, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            if (parcelableArr == null) {
                if (z) {
                    zzc(parcel, i, 0);
                    return;
                }
                return;
            }
            int zza = zza(parcel, i);
            parcel.writeInt(parcelableArr.length);
            for (Parcelable parcelable : parcelableArr) {
                if (parcelable == null) {
                    parcel.writeInt(0);
                } else {
                    zzd(parcel, parcelable, i2);
                }
            }
            zzb(parcel, zza);
        }
    }
}
