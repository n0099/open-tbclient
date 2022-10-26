package com.google.android.gms.common.internal.safeparcel;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.internal.common.zzag;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes7.dex */
public final class SafeParcelableSerializer {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public SafeParcelableSerializer() {
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

    public static SafeParcelable deserializeFromBytes(byte[] bArr, Parcelable.Creator creator) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, bArr, creator)) == null) {
            Preconditions.checkNotNull(creator);
            Parcel obtain = Parcel.obtain();
            obtain.unmarshall(bArr, 0, bArr.length);
            obtain.setDataPosition(0);
            SafeParcelable safeParcelable = (SafeParcelable) creator.createFromParcel(obtain);
            obtain.recycle();
            return safeParcelable;
        }
        return (SafeParcelable) invokeLL.objValue;
    }

    public static SafeParcelable deserializeFromString(String str, Parcelable.Creator creator) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, creator)) == null) {
            return deserializeFromBytes(Base64Utils.decodeUrlSafe(str), creator);
        }
        return (SafeParcelable) invokeLL.objValue;
    }

    public static SafeParcelable deserializeFromIntentExtra(Intent intent, String str, Parcelable.Creator creator) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, intent, str, creator)) == null) {
            byte[] byteArrayExtra = intent.getByteArrayExtra(str);
            if (byteArrayExtra == null) {
                return null;
            }
            return deserializeFromBytes(byteArrayExtra, creator);
        }
        return (SafeParcelable) invokeLLL.objValue;
    }

    public static ArrayList deserializeIterableFromBundleSafe(Bundle bundle, String str, Parcelable.Creator creator) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65541, null, bundle, str, creator)) == null) {
            return deserializeIterableFromBytes(bundle.getByteArray(str), creator);
        }
        return (ArrayList) invokeLLL.objValue;
    }

    public static ArrayList deserializeIterableFromIntentExtraSafe(Intent intent, String str, Parcelable.Creator creator) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65544, null, intent, str, creator)) == null) {
            return deserializeIterableFromBytes(intent.getByteArrayExtra(str), creator);
        }
        return (ArrayList) invokeLLL.objValue;
    }

    @Deprecated
    public static void serializeIterableToBundle(Iterable iterable, Bundle bundle, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65545, null, iterable, bundle, str) == null) {
            ArrayList arrayList = new ArrayList();
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                arrayList.add(serializeToBytes((SafeParcelable) it.next()));
            }
            bundle.putSerializable(str, arrayList);
        }
    }

    public static void serializeIterableToBundleSafe(Iterable iterable, Bundle bundle, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65546, null, iterable, bundle, str) == null) {
            bundle.putByteArray(str, zza(iterable));
        }
    }

    @Deprecated
    public static void serializeIterableToIntentExtra(Iterable iterable, Intent intent, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65547, null, iterable, intent, str) == null) {
            ArrayList arrayList = new ArrayList();
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                arrayList.add(serializeToBytes((SafeParcelable) it.next()));
            }
            intent.putExtra(str, arrayList);
        }
    }

    public static void serializeIterableToIntentExtraSafe(Iterable iterable, Intent intent, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65548, null, iterable, intent, str) == null) {
            intent.putExtra(str, zza(iterable));
        }
    }

    public static void serializeToIntentExtra(SafeParcelable safeParcelable, Intent intent, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65550, null, safeParcelable, intent, str) == null) {
            intent.putExtra(str, serializeToBytes(safeParcelable));
        }
    }

    @Deprecated
    public static ArrayList deserializeIterableFromBundle(Bundle bundle, String str, Parcelable.Creator creator) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, bundle, str, creator)) == null) {
            ArrayList arrayList = (ArrayList) bundle.getSerializable(str);
            if (arrayList == null) {
                return null;
            }
            ArrayList arrayList2 = new ArrayList(arrayList.size());
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                arrayList2.add(deserializeFromBytes((byte[]) arrayList.get(i), creator));
            }
            return arrayList2;
        }
        return (ArrayList) invokeLLL.objValue;
    }

    @Deprecated
    public static ArrayList deserializeIterableFromIntentExtra(Intent intent, String str, Parcelable.Creator creator) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65543, null, intent, str, creator)) == null) {
            ArrayList arrayList = (ArrayList) intent.getSerializableExtra(str);
            if (arrayList == null) {
                return null;
            }
            ArrayList arrayList2 = new ArrayList(arrayList.size());
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                arrayList2.add(deserializeFromBytes((byte[]) arrayList.get(i), creator));
            }
            return arrayList2;
        }
        return (ArrayList) invokeLLL.objValue;
    }

    public static ArrayList deserializeIterableFromBytes(byte[] bArr, Parcelable.Creator creator) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, bArr, creator)) == null) {
            if (bArr == null) {
                return null;
            }
            int length = bArr.length;
            Parcel obtain = Parcel.obtain();
            obtain.unmarshall(bArr, 0, length);
            obtain.setDataPosition(0);
            try {
                ArrayList arrayList = new ArrayList();
                obtain.readTypedList(arrayList, creator);
                return arrayList;
            } finally {
                obtain.recycle();
            }
        }
        return (ArrayList) invokeLL.objValue;
    }

    public static byte[] serializeToBytes(SafeParcelable safeParcelable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, safeParcelable)) == null) {
            Parcel obtain = Parcel.obtain();
            safeParcelable.writeToParcel(obtain, 0);
            byte[] marshall = obtain.marshall();
            obtain.recycle();
            return marshall;
        }
        return (byte[]) invokeL.objValue;
    }

    public static String serializeToString(SafeParcelable safeParcelable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, safeParcelable)) == null) {
            return Base64Utils.encodeUrlSafe(serializeToBytes(safeParcelable));
        }
        return (String) invokeL.objValue;
    }

    public static byte[] zza(Iterable iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, iterable)) == null) {
            Parcel obtain = Parcel.obtain();
            try {
                obtain.writeTypedList(zzag.zzj(iterable));
                return obtain.marshall();
            } finally {
                obtain.recycle();
            }
        }
        return (byte[]) invokeL.objValue;
    }
}
