package com.huawei.hms.common.internal.safeparcel;

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
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.common.util.Base64Utils;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes8.dex */
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

    public static <S extends SafeParcelable> S deserializeFromBytes(byte[] bArr, Parcelable.Creator<S> creator) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, bArr, creator)) == null) {
            Preconditions.checkNotNull(creator);
            Parcel obtain = Parcel.obtain();
            obtain.unmarshall(bArr, 0, bArr.length);
            obtain.setDataPosition(0);
            S createFromParcel = creator.createFromParcel(obtain);
            obtain.recycle();
            return createFromParcel;
        }
        return (S) invokeLL.objValue;
    }

    public static <S extends SafeParcelable> S deserializeFromString(String str, Parcelable.Creator<S> creator) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, creator)) == null) {
            return (S) deserializeFromBytes(Base64Utils.decodeUrlSafe(str), creator);
        }
        return (S) invokeLL.objValue;
    }

    public static <S extends SafeParcelable> S deserializeFromIntentExtra(Intent intent, String str, Parcelable.Creator<S> creator) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, intent, str, creator)) == null) {
            byte[] byteArrayExtra = intent.getByteArrayExtra(str);
            if (byteArrayExtra == null) {
                return null;
            }
            return (S) deserializeFromBytes(byteArrayExtra, creator);
        }
        return (S) invokeLLL.objValue;
    }

    public static <S extends SafeParcelable> void serializeIterableToBundle(Iterable<S> iterable, Bundle bundle, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65542, null, iterable, bundle, str) == null) {
            ArrayList arrayList = new ArrayList();
            for (S s : iterable) {
                arrayList.add(serializeToBytes(s));
            }
            bundle.putSerializable(str, arrayList);
        }
    }

    public static <S extends SafeParcelable> void serializeIterableToIntentExtra(Iterable<S> iterable, Intent intent, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65543, null, iterable, intent, str) == null) {
            ArrayList arrayList = new ArrayList();
            for (S s : iterable) {
                arrayList.add(serializeToBytes(s));
            }
            intent.putExtra(str, arrayList);
        }
    }

    public static <S extends SafeParcelable> void serializeToIntentExtra(S s, Intent intent, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65545, null, s, intent, str) == null) {
            intent.putExtra(str, serializeToBytes(s));
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v1, resolved type: java.util.ArrayList<S extends com.huawei.hms.common.internal.safeparcel.SafeParcelable> */
    /* JADX WARN: Multi-variable type inference failed */
    public static <S extends SafeParcelable> ArrayList<S> deserializeIterableFromBundle(Bundle bundle, String str, Parcelable.Creator<S> creator) {
        InterceptResult invokeLLL;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, bundle, str, creator)) == null) {
            if (bundle == null || (arrayList = (ArrayList) bundle.getSerializable(str)) == null) {
                return null;
            }
            ArrayList<S> arrayList2 = (ArrayList<S>) new ArrayList(arrayList.size());
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(deserializeFromBytes((byte[]) it.next(), creator));
            }
            return arrayList2;
        }
        return (ArrayList) invokeLLL.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v1, resolved type: java.util.ArrayList<S extends com.huawei.hms.common.internal.safeparcel.SafeParcelable> */
    /* JADX WARN: Multi-variable type inference failed */
    public static <S extends SafeParcelable> ArrayList<S> deserializeIterableFromIntentExtra(Intent intent, String str, Parcelable.Creator<S> creator) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65541, null, intent, str, creator)) == null) {
            ArrayList arrayList = (ArrayList) intent.getSerializableExtra(str);
            if (arrayList == null) {
                return null;
            }
            ArrayList<S> arrayList2 = (ArrayList<S>) new ArrayList(arrayList.size());
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(deserializeFromBytes((byte[]) it.next(), creator));
            }
            return arrayList2;
        }
        return (ArrayList) invokeLLL.objValue;
    }

    public static <S extends SafeParcelable> byte[] serializeToBytes(S s) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, s)) == null) {
            Parcel obtain = Parcel.obtain();
            s.writeToParcel(obtain, 0);
            byte[] marshall = obtain.marshall();
            obtain.recycle();
            return marshall;
        }
        return (byte[]) invokeL.objValue;
    }

    public static <S extends SafeParcelable> String serializeToString(S s) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, s)) == null) {
            return Base64Utils.encodeUrlSafe(serializeToBytes(s));
        }
        return (String) invokeL.objValue;
    }
}
