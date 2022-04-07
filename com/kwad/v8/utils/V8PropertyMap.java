package com.kwad.v8.utils;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;
/* loaded from: classes5.dex */
public class V8PropertyMap<V> implements Map<String, V> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Hashtable<String, V> map;
    public Set<String> nulls;

    public V8PropertyMap() {
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
        this.map = new Hashtable<>();
        this.nulls = new HashSet();
    }

    @Override // java.util.Map
    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.map.clear();
            this.nulls.clear();
        }
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) ? this.map.containsKey(obj) || this.nulls.contains(obj) : invokeL.booleanValue;
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) {
            if (obj != null || this.nulls.isEmpty()) {
                if (obj == null) {
                    return false;
                }
                return this.map.containsValue(obj);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // java.util.Map
    public Set<Map.Entry<String, V>> entrySet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            HashSet hashSet = new HashSet(this.map.entrySet());
            for (String str : this.nulls) {
                hashSet.add(new AbstractMap.SimpleEntry(str, null));
            }
            return hashSet;
        }
        return (Set) invokeV.objValue;
    }

    @Override // java.util.Map
    public V get(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, obj)) == null) {
            if (this.nulls.contains(obj)) {
                return null;
            }
            return this.map.get(obj);
        }
        return (V) invokeL.objValue;
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.map.isEmpty() && this.nulls.isEmpty() : invokeV.booleanValue;
    }

    @Override // java.util.Map
    public Set<String> keySet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            HashSet hashSet = new HashSet(this.map.keySet());
            hashSet.addAll(this.nulls);
            return hashSet;
        }
        return (Set) invokeV.objValue;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public /* bridge */ /* synthetic */ Object put(String str, Object obj) {
        return put2(str, (String) obj);
    }

    /* renamed from: put  reason: avoid collision after fix types in other method */
    public V put2(String str, V v) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, v)) == null) {
            if (v != null) {
                if (this.nulls.contains(str)) {
                    this.nulls.remove(str);
                }
                return this.map.put(str, v);
            }
            if (this.map.containsKey(str)) {
                this.map.remove(str);
            }
            this.nulls.add(str);
            return null;
        }
        return (V) invokeLL.objValue;
    }

    @Override // java.util.Map
    public void putAll(Map<? extends String, ? extends V> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, map) == null) {
            for (Map.Entry<? extends String, ? extends V> entry : map.entrySet()) {
                put2(entry.getKey(), (String) entry.getValue());
            }
        }
    }

    @Override // java.util.Map
    public V remove(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, obj)) == null) {
            if (this.nulls.contains(obj)) {
                this.nulls.remove(obj);
                return null;
            }
            return this.map.remove(obj);
        }
        return (V) invokeL.objValue;
    }

    @Override // java.util.Map
    public int size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.map.size() + this.nulls.size() : invokeV.intValue;
    }

    @Override // java.util.Map
    public Collection<V> values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            ArrayList arrayList = new ArrayList(this.map.values());
            for (int i = 0; i < this.nulls.size(); i++) {
                arrayList.add(null);
            }
            return arrayList;
        }
        return (Collection) invokeV.objValue;
    }
}
