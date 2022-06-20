package com.repackage;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.collection.SimpleArrayMap;
import androidx.core.util.Pools;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes7.dex */
public final class s90<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Pools.Pool<ArrayList<T>> a;
    public final SimpleArrayMap<T, ArrayList<T>> b;
    public final ArrayList<T> c;
    public final HashSet<T> d;

    public s90() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new Pools.SimplePool(10);
        this.b = new SimpleArrayMap<>();
        this.c = new ArrayList<>();
        this.d = new HashSet<>();
    }

    public void a(@NonNull T t, @NonNull T t2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, t, t2) == null) && this.b.containsKey(t) && this.b.containsKey(t2)) {
            ArrayList<T> arrayList = this.b.get(t);
            if (arrayList == null) {
                arrayList = f();
                this.b.put(t, arrayList);
            }
            arrayList.add(t2);
        }
    }

    public void b(@NonNull T t) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) == null) || this.b.containsKey(t)) {
            return;
        }
        this.b.put(t, null);
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            int size = this.b.size();
            for (int i = 0; i < size; i++) {
                ArrayList<T> valueAt = this.b.valueAt(i);
                if (valueAt != null) {
                    k(valueAt);
                }
            }
            this.b.clear();
        }
    }

    public boolean d(@NonNull T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, t)) == null) ? this.b.containsKey(t) : invokeL.booleanValue;
    }

    public final void e(T t, ArrayList<T> arrayList, HashSet<T> hashSet) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048580, this, t, arrayList, hashSet) == null) || arrayList.contains(t) || hashSet.contains(t)) {
            return;
        }
        hashSet.add(t);
        ArrayList<T> arrayList2 = this.b.get(t);
        if (arrayList2 != null) {
            int size = arrayList2.size();
            for (int i = 0; i < size; i++) {
                e(arrayList2.get(i), arrayList, hashSet);
            }
        }
        hashSet.remove(t);
        arrayList.add(t);
    }

    @NonNull
    public final ArrayList<T> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            ArrayList<T> acquire = this.a.acquire();
            return acquire == null ? new ArrayList<>() : acquire;
        }
        return (ArrayList) invokeV.objValue;
    }

    @Nullable
    public List g(@NonNull T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, t)) == null) ? this.b.get(t) : (List) invokeL.objValue;
    }

    @Nullable
    public List<T> h(@NonNull T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, t)) == null) {
            int size = this.b.size();
            ArrayList arrayList = null;
            for (int i = 0; i < size; i++) {
                ArrayList<T> valueAt = this.b.valueAt(i);
                if (valueAt != null && valueAt.contains(t)) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(this.b.keyAt(i));
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    @NonNull
    public ArrayList<T> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            this.c.clear();
            this.d.clear();
            int size = this.b.size();
            for (int i = 0; i < size; i++) {
                e(this.b.keyAt(i), this.c, this.d);
            }
            return this.c;
        }
        return (ArrayList) invokeV.objValue;
    }

    public boolean j(@NonNull T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, t)) == null) {
            int size = this.b.size();
            for (int i = 0; i < size; i++) {
                ArrayList<T> valueAt = this.b.valueAt(i);
                if (valueAt != null && valueAt.contains(t)) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void k(@NonNull ArrayList<T> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, arrayList) == null) {
            arrayList.clear();
            this.a.release(arrayList);
        }
    }
}
