package com.google.android.gms.common.internal.safeparcel;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.common.zzag;
import java.util.ArrayList;
@VisibleForTesting
@KeepForSdk
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

    @NonNull
    @KeepForSdk
    public static <T extends SafeParcelable> T deserializeFromBytes(@NonNull byte[] bArr, @NonNull Parcelable.Creator<T> creator) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, bArr, creator)) == null) {
            Preconditions.checkNotNull(creator);
            Parcel obtain = Parcel.obtain();
            obtain.unmarshall(bArr, 0, bArr.length);
            obtain.setDataPosition(0);
            T createFromParcel = creator.createFromParcel(obtain);
            obtain.recycle();
            return createFromParcel;
        }
        return (T) invokeLL.objValue;
    }

    @Nullable
    @KeepForSdk
    public static <T extends SafeParcelable> T deserializeFromIntentExtra(@NonNull Intent intent, @NonNull String str, @NonNull Parcelable.Creator<T> creator) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, intent, str, creator)) == null) {
            byte[] byteArrayExtra = intent.getByteArrayExtra(str);
            if (byteArrayExtra == null) {
                return null;
            }
            return (T) deserializeFromBytes(byteArrayExtra, creator);
        }
        return (T) invokeLLL.objValue;
    }

    @NonNull
    @KeepForSdk
    public static <T extends SafeParcelable> T deserializeFromString(@NonNull String str, @NonNull Parcelable.Creator<T> creator) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, creator)) == null) ? (T) deserializeFromBytes(Base64Utils.decodeUrlSafe(str), creator) : (T) invokeLL.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v1, resolved type: java.util.ArrayList<T extends com.google.android.gms.common.internal.safeparcel.SafeParcelable> */
    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    @Deprecated
    public static <T extends SafeParcelable> ArrayList<T> deserializeIterableFromBundle(@NonNull Bundle bundle, @NonNull String str, @NonNull Parcelable.Creator<T> creator) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, bundle, str, creator)) == null) {
            ArrayList arrayList = (ArrayList) bundle.getSerializable(str);
            if (arrayList == null) {
                return null;
            }
            ArrayList<T> arrayList2 = (ArrayList<T>) new ArrayList(arrayList.size());
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                arrayList2.add(deserializeFromBytes((byte[]) arrayList.get(i), creator));
            }
            return arrayList2;
        }
        return (ArrayList) invokeLLL.objValue;
    }

    @Nullable
    @KeepForSdk
    public static <T extends SafeParcelable> ArrayList<T> deserializeIterableFromBundleSafe(@NonNull Bundle bundle, @NonNull String str, @NonNull Parcelable.Creator<T> creator) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65541, null, bundle, str, creator)) == null) ? deserializeIterableFromBytes(bundle.getByteArray(str), creator) : (ArrayList) invokeLLL.objValue;
    }

    @Nullable
    public static <T extends SafeParcelable> ArrayList<T> deserializeIterableFromBytes(@Nullable byte[] bArr, @NonNull Parcelable.Creator<T> creator) {
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
                ArrayList<T> arrayList = new ArrayList<>();
                obtain.readTypedList(arrayList, creator);
                return arrayList;
            } finally {
                obtain.recycle();
            }
        }
        return (ArrayList) invokeLL.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v1, resolved type: java.util.ArrayList<T extends com.google.android.gms.common.internal.safeparcel.SafeParcelable> */
    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    @KeepForSdk
    @Deprecated
    public static <T extends SafeParcelable> ArrayList<T> deserializeIterableFromIntentExtra(@NonNull Intent intent, @NonNull String str, @NonNull Parcelable.Creator<T> creator) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65543, null, intent, str, creator)) == null) {
            ArrayList arrayList = (ArrayList) intent.getSerializableExtra(str);
            if (arrayList == null) {
                return null;
            }
            ArrayList<T> arrayList2 = (ArrayList<T>) new ArrayList(arrayList.size());
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                arrayList2.add(deserializeFromBytes((byte[]) arrayList.get(i), creator));
            }
            return arrayList2;
        }
        return (ArrayList) invokeLLL.objValue;
    }

    @Nullable
    @KeepForSdk
    public static <T extends SafeParcelable> ArrayList<T> deserializeIterableFromIntentExtraSafe(@NonNull Intent intent, @NonNull String str, @NonNull Parcelable.Creator<T> creator) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65544, null, intent, str, creator)) == null) ? deserializeIterableFromBytes(intent.getByteArrayExtra(str), creator) : (ArrayList) invokeLLL.objValue;
    }

    @Deprecated
    public static <T extends SafeParcelable> void serializeIterableToBundle(@NonNull Iterable<T> iterable, @NonNull Bundle bundle, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65545, null, iterable, bundle, str) == null) {
            ArrayList arrayList = new ArrayList();
            for (T t : iterable) {
                arrayList.add(serializeToBytes(t));
            }
            bundle.putSerializable(str, arrayList);
        }
    }

    public static <T extends SafeParcelable> void serializeIterableToBundleSafe(@NonNull Iterable<T> iterable, @NonNull Bundle bundle, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65546, null, iterable, bundle, str) == null) {
            bundle.putByteArray(str, zza(iterable));
        }
    }

    @KeepForSdk
    @Deprecated
    public static <T extends SafeParcelable> void serializeIterableToIntentExtra(@NonNull Iterable<T> iterable, @NonNull Intent intent, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65547, null, iterable, intent, str) == null) {
            ArrayList arrayList = new ArrayList();
            for (T t : iterable) {
                arrayList.add(serializeToBytes(t));
            }
            intent.putExtra(str, arrayList);
        }
    }

    @KeepForSdk
    public static <T extends SafeParcelable> void serializeIterableToIntentExtraSafe(@NonNull Iterable<T> iterable, @NonNull Intent intent, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65548, null, iterable, intent, str) == null) {
            intent.putExtra(str, zza(iterable));
        }
    }

    @NonNull
    @KeepForSdk
    public static <T extends SafeParcelable> byte[] serializeToBytes(@NonNull T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, t)) == null) {
            Parcel obtain = Parcel.obtain();
            t.writeToParcel(obtain, 0);
            byte[] marshall = obtain.marshall();
            obtain.recycle();
            return marshall;
        }
        return (byte[]) invokeL.objValue;
    }

    @KeepForSdk
    public static <T extends SafeParcelable> void serializeToIntentExtra(@NonNull T t, @NonNull Intent intent, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65550, null, t, intent, str) == null) {
            intent.putExtra(str, serializeToBytes(t));
        }
    }

    @NonNull
    @KeepForSdk
    public static <T extends SafeParcelable> String serializeToString(@NonNull T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65551, null, t)) == null) ? Base64Utils.encodeUrlSafe(serializeToBytes(t)) : (String) invokeL.objValue;
    }

    public static <T extends SafeParcelable> byte[] zza(Iterable<T> iterable) {
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
