package com.google.common.collect;

import androidx.core.view.InputDeviceCompat;
import c.i.d.a.n;
import c.i.d.c.d1;
import c.i.d.c.k;
import c.i.d.c.m;
import c.i.d.c.n0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.common.collect.ImmutableCollection;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
/* loaded from: classes9.dex */
public final class HashBiMap<K, V> extends AbstractMap<K, V> implements k<K, V>, Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ABSENT = -1;
    public static final int ENDPOINT = -2;
    public transient /* synthetic */ FieldHolder $fh;
    public transient Set<Map.Entry<K, V>> entrySet;
    public transient int firstInInsertionOrder;
    public transient int[] hashTableKToV;
    public transient int[] hashTableVToK;
    public transient k<V, K> inverse;
    public transient Set<K> keySet;
    public transient K[] keys;
    public transient int lastInInsertionOrder;
    public transient int modCount;
    public transient int[] nextInBucketKToV;
    public transient int[] nextInBucketVToK;
    public transient int[] nextInInsertionOrder;
    public transient int[] prevInInsertionOrder;
    public transient int size;
    public transient Set<V> valueSet;
    public transient V[] values;

    /* loaded from: classes9.dex */
    public static class Inverse<K, V> extends AbstractMap<V, K> implements k<V, K>, Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final HashBiMap<K, V> forward;
        public transient Set<Map.Entry<V, K>> inverseEntrySet;

        public Inverse(HashBiMap<K, V> hashBiMap) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hashBiMap};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.forward = hashBiMap;
        }

        private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65537, this, objectInputStream) == null) {
                objectInputStream.defaultReadObject();
                this.forward.inverse = this;
            }
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.forward.clear();
            }
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) ? this.forward.containsValue(obj) : invokeL.booleanValue;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsValue(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) ? this.forward.containsKey(obj) : invokeL.booleanValue;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<Map.Entry<V, K>> entrySet() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                Set<Map.Entry<V, K>> set = this.inverseEntrySet;
                if (set == null) {
                    d dVar = new d(this.forward);
                    this.inverseEntrySet = dVar;
                    return dVar;
                }
                return set;
            }
            return (Set) invokeV.objValue;
        }

        @Override // c.i.d.c.k
        public K forcePut(V v, K k) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, v, k)) == null) ? this.forward.putInverse(v, k, true) : (K) invokeLL.objValue;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public K get(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) ? this.forward.getInverse(obj) : (K) invokeL.objValue;
        }

        @Override // c.i.d.c.k
        public k<K, V> inverse() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.forward : (k) invokeV.objValue;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<V> keySet() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.forward.values() : (Set) invokeV.objValue;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public K put(V v, K k) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, v, k)) == null) ? this.forward.putInverse(v, k, false) : (K) invokeLL.objValue;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public K remove(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, obj)) == null) ? this.forward.removeInverse(obj) : (K) invokeL.objValue;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.forward.size : invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.AbstractMap, java.util.Map, c.i.d.c.k
        public Set<K> values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.forward.keySet() : (Set) invokeV.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public final class a extends c.i.d.c.b<K, V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final K f70824e;

        /* renamed from: f  reason: collision with root package name */
        public int f70825f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ HashBiMap f70826g;

        public a(HashBiMap hashBiMap, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hashBiMap, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f70826g = hashBiMap;
            this.f70824e = hashBiMap.keys[i2];
            this.f70825f = i2;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int i2 = this.f70825f;
                if (i2 != -1) {
                    HashBiMap hashBiMap = this.f70826g;
                    if (i2 <= hashBiMap.size && c.i.d.a.k.a(hashBiMap.keys[i2], this.f70824e)) {
                        return;
                    }
                }
                this.f70825f = this.f70826g.findEntryByKey(this.f70824e);
            }
        }

        @Override // c.i.d.c.b, java.util.Map.Entry
        public K getKey() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f70824e : (K) invokeV.objValue;
        }

        @Override // c.i.d.c.b, java.util.Map.Entry
        public V getValue() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                a();
                int i2 = this.f70825f;
                if (i2 == -1) {
                    return null;
                }
                return this.f70826g.values[i2];
            }
            return (V) invokeV.objValue;
        }

        @Override // c.i.d.c.b, java.util.Map.Entry
        public V setValue(V v) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, v)) == null) {
                a();
                int i2 = this.f70825f;
                if (i2 == -1) {
                    return (V) this.f70826g.put(this.f70824e, v);
                }
                V v2 = this.f70826g.values[i2];
                if (c.i.d.a.k.a(v2, v)) {
                    return v;
                }
                this.f70826g.replaceValueInEntry(this.f70825f, v, false);
                return v2;
            }
            return (V) invokeL.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static final class b<K, V> extends c.i.d.c.b<V, K> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final HashBiMap<K, V> f70827e;

        /* renamed from: f  reason: collision with root package name */
        public final V f70828f;

        /* renamed from: g  reason: collision with root package name */
        public int f70829g;

        public b(HashBiMap<K, V> hashBiMap, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hashBiMap, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f70827e = hashBiMap;
            this.f70828f = hashBiMap.values[i2];
            this.f70829g = i2;
        }

        public final void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int i2 = this.f70829g;
                if (i2 != -1) {
                    HashBiMap<K, V> hashBiMap = this.f70827e;
                    if (i2 <= hashBiMap.size && c.i.d.a.k.a(this.f70828f, hashBiMap.values[i2])) {
                        return;
                    }
                }
                this.f70829g = this.f70827e.findEntryByValue(this.f70828f);
            }
        }

        @Override // c.i.d.c.b, java.util.Map.Entry
        public V getKey() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f70828f : (V) invokeV.objValue;
        }

        @Override // c.i.d.c.b, java.util.Map.Entry
        public K getValue() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                a();
                int i2 = this.f70829g;
                if (i2 == -1) {
                    return null;
                }
                return this.f70827e.keys[i2];
            }
            return (K) invokeV.objValue;
        }

        @Override // c.i.d.c.b, java.util.Map.Entry
        public K setValue(K k) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, k)) == null) {
                a();
                int i2 = this.f70829g;
                if (i2 == -1) {
                    return this.f70827e.putInverse(this.f70828f, k, false);
                }
                K k2 = this.f70827e.keys[i2];
                if (c.i.d.a.k.a(k2, k)) {
                    return k;
                }
                this.f70827e.replaceKeyInEntry(this.f70829g, k, false);
                return k2;
            }
            return (K) invokeL.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public final class c extends g<K, V, Map.Entry<K, V>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ HashBiMap f70830f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(HashBiMap hashBiMap) {
            super(hashBiMap);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hashBiMap};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((HashBiMap) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f70830f = hashBiMap;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.HashBiMap.g
        /* renamed from: b */
        public Map.Entry<K, V> a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? new a(this.f70830f, i2) : (Map.Entry) invokeI.objValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) {
                if (obj instanceof Map.Entry) {
                    Map.Entry entry = (Map.Entry) obj;
                    Object key = entry.getKey();
                    Object value = entry.getValue();
                    int findEntryByKey = this.f70830f.findEntryByKey(key);
                    return findEntryByKey != -1 && c.i.d.a.k.a(value, this.f70830f.values[findEntryByKey]);
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
                if (obj instanceof Map.Entry) {
                    Map.Entry entry = (Map.Entry) obj;
                    Object key = entry.getKey();
                    Object value = entry.getValue();
                    int d2 = n0.d(key);
                    int findEntryByKey = this.f70830f.findEntryByKey(key, d2);
                    if (findEntryByKey == -1 || !c.i.d.a.k.a(value, this.f70830f.values[findEntryByKey])) {
                        return false;
                    }
                    this.f70830f.removeEntryKeyHashKnown(findEntryByKey, d2);
                    return true;
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public static class d<K, V> extends g<K, V, Map.Entry<V, K>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(HashBiMap<K, V> hashBiMap) {
            super(hashBiMap);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hashBiMap};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((HashBiMap) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.HashBiMap.g
        /* renamed from: b */
        public Map.Entry<V, K> a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? new b(this.f70833e, i2) : (Map.Entry) invokeI.objValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) {
                if (obj instanceof Map.Entry) {
                    Map.Entry entry = (Map.Entry) obj;
                    Object key = entry.getKey();
                    Object value = entry.getValue();
                    int findEntryByValue = this.f70833e.findEntryByValue(key);
                    return findEntryByValue != -1 && c.i.d.a.k.a(this.f70833e.keys[findEntryByValue], value);
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
                if (obj instanceof Map.Entry) {
                    Map.Entry entry = (Map.Entry) obj;
                    Object key = entry.getKey();
                    Object value = entry.getValue();
                    int d2 = n0.d(key);
                    int findEntryByValue = this.f70833e.findEntryByValue(key, d2);
                    if (findEntryByValue == -1 || !c.i.d.a.k.a(this.f70833e.keys[findEntryByValue], value)) {
                        return false;
                    }
                    this.f70833e.removeEntryValueHashKnown(findEntryByValue, d2);
                    return true;
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public final class e extends g<K, V, K> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ HashBiMap f70831f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(HashBiMap hashBiMap) {
            super(hashBiMap);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hashBiMap};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((HashBiMap) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f70831f = hashBiMap;
        }

        @Override // com.google.common.collect.HashBiMap.g
        public K a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? this.f70831f.keys[i2] : (K) invokeI.objValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) ? this.f70831f.containsKey(obj) : invokeL.booleanValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) {
                int d2 = n0.d(obj);
                int findEntryByKey = this.f70831f.findEntryByKey(obj, d2);
                if (findEntryByKey != -1) {
                    this.f70831f.removeEntryKeyHashKnown(findEntryByKey, d2);
                    return true;
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public final class f extends g<K, V, V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ HashBiMap f70832f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(HashBiMap hashBiMap) {
            super(hashBiMap);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hashBiMap};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((HashBiMap) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f70832f = hashBiMap;
        }

        @Override // com.google.common.collect.HashBiMap.g
        public V a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? this.f70832f.values[i2] : (V) invokeI.objValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) ? this.f70832f.containsValue(obj) : invokeL.booleanValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) {
                int d2 = n0.d(obj);
                int findEntryByValue = this.f70832f.findEntryByValue(obj, d2);
                if (findEntryByValue != -1) {
                    this.f70832f.removeEntryValueHashKnown(findEntryByValue, d2);
                    return true;
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public static abstract class g<K, V, T> extends AbstractSet<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final HashBiMap<K, V> f70833e;

        /* loaded from: classes9.dex */
        public class a implements Iterator<T> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public int f70834e;

            /* renamed from: f  reason: collision with root package name */
            public int f70835f;

            /* renamed from: g  reason: collision with root package name */
            public int f70836g;

            /* renamed from: h  reason: collision with root package name */
            public int f70837h;

            /* renamed from: i  reason: collision with root package name */
            public final /* synthetic */ g f70838i;

            public a(g gVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {gVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f70838i = gVar;
                this.f70834e = this.f70838i.f70833e.firstInInsertionOrder;
                this.f70835f = -1;
                HashBiMap<K, V> hashBiMap = this.f70838i.f70833e;
                this.f70836g = hashBiMap.modCount;
                this.f70837h = hashBiMap.size;
            }

            public final void a() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f70838i.f70833e.modCount != this.f70836g) {
                    throw new ConcurrentModificationException();
                }
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                    a();
                    return this.f70834e != -2 && this.f70837h > 0;
                }
                return invokeV.booleanValue;
            }

            @Override // java.util.Iterator
            public T next() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                    if (hasNext()) {
                        T t = (T) this.f70838i.a(this.f70834e);
                        this.f70835f = this.f70834e;
                        this.f70834e = this.f70838i.f70833e.nextInInsertionOrder[this.f70834e];
                        this.f70837h--;
                        return t;
                    }
                    throw new NoSuchElementException();
                }
                return (T) invokeV.objValue;
            }

            @Override // java.util.Iterator
            public void remove() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                    a();
                    m.e(this.f70835f != -1);
                    this.f70838i.f70833e.removeEntry(this.f70835f);
                    if (this.f70834e == this.f70838i.f70833e.size) {
                        this.f70834e = this.f70835f;
                    }
                    this.f70835f = -1;
                    this.f70836g = this.f70838i.f70833e.modCount;
                }
            }
        }

        public g(HashBiMap<K, V> hashBiMap) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hashBiMap};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f70833e = hashBiMap;
        }

        public abstract T a(int i2);

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f70833e.clear();
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<T> iterator() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? new a(this) : (Iterator) invokeV.objValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f70833e.size : invokeV.intValue;
        }
    }

    public HashBiMap(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        init(i2);
    }

    private int bucket(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(AdIconUtil.BAIDU_LOGO_ID, this, i2)) == null) ? i2 & (this.hashTableKToV.length - 1) : invokeI.intValue;
    }

    public static <K, V> HashBiMap<K, V> create() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? create(16) : (HashBiMap) invokeV.objValue;
    }

    public static int[] createFilledWithAbsent(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65546, null, i2)) == null) {
            int[] iArr = new int[i2];
            Arrays.fill(iArr, -1);
            return iArr;
        }
        return (int[]) invokeI.objValue;
    }

    private void deleteFromTableKToV(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeII(65547, this, i2, i3) != null) {
            return;
        }
        n.d(i2 != -1);
        int bucket = bucket(i3);
        int[] iArr = this.hashTableKToV;
        if (iArr[bucket] == i2) {
            int[] iArr2 = this.nextInBucketKToV;
            iArr[bucket] = iArr2[i2];
            iArr2[i2] = -1;
            return;
        }
        int i4 = iArr[bucket];
        int i5 = this.nextInBucketKToV[i4];
        while (true) {
            int i6 = i5;
            int i7 = i4;
            i4 = i6;
            if (i4 == -1) {
                throw new AssertionError("Expected to find entry with key " + this.keys[i2]);
            } else if (i4 == i2) {
                int[] iArr3 = this.nextInBucketKToV;
                iArr3[i7] = iArr3[i2];
                iArr3[i2] = -1;
                return;
            } else {
                i5 = this.nextInBucketKToV[i4];
            }
        }
    }

    private void deleteFromTableVToK(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeII(65548, this, i2, i3) != null) {
            return;
        }
        n.d(i2 != -1);
        int bucket = bucket(i3);
        int[] iArr = this.hashTableVToK;
        if (iArr[bucket] == i2) {
            int[] iArr2 = this.nextInBucketVToK;
            iArr[bucket] = iArr2[i2];
            iArr2[i2] = -1;
            return;
        }
        int i4 = iArr[bucket];
        int i5 = this.nextInBucketVToK[i4];
        while (true) {
            int i6 = i5;
            int i7 = i4;
            i4 = i6;
            if (i4 == -1) {
                throw new AssertionError("Expected to find entry with value " + this.values[i2]);
            } else if (i4 == i2) {
                int[] iArr3 = this.nextInBucketVToK;
                iArr3[i7] = iArr3[i2];
                iArr3[i2] = -1;
                return;
            } else {
                i5 = this.nextInBucketVToK[i4];
            }
        }
    }

    private void ensureCapacity(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65549, this, i2) == null) {
            int[] iArr = this.nextInBucketKToV;
            if (iArr.length < i2) {
                int e2 = ImmutableCollection.b.e(iArr.length, i2);
                this.keys = (K[]) Arrays.copyOf(this.keys, e2);
                this.values = (V[]) Arrays.copyOf(this.values, e2);
                this.nextInBucketKToV = expandAndFillWithAbsent(this.nextInBucketKToV, e2);
                this.nextInBucketVToK = expandAndFillWithAbsent(this.nextInBucketVToK, e2);
                this.prevInInsertionOrder = expandAndFillWithAbsent(this.prevInInsertionOrder, e2);
                this.nextInInsertionOrder = expandAndFillWithAbsent(this.nextInInsertionOrder, e2);
            }
            if (this.hashTableKToV.length < i2) {
                int a2 = n0.a(i2, 1.0d);
                this.hashTableKToV = createFilledWithAbsent(a2);
                this.hashTableVToK = createFilledWithAbsent(a2);
                for (int i3 = 0; i3 < this.size; i3++) {
                    int bucket = bucket(n0.d(this.keys[i3]));
                    int[] iArr2 = this.nextInBucketKToV;
                    int[] iArr3 = this.hashTableKToV;
                    iArr2[i3] = iArr3[bucket];
                    iArr3[bucket] = i3;
                    int bucket2 = bucket(n0.d(this.values[i3]));
                    int[] iArr4 = this.nextInBucketVToK;
                    int[] iArr5 = this.hashTableVToK;
                    iArr4[i3] = iArr5[bucket2];
                    iArr5[bucket2] = i3;
                }
            }
        }
    }

    public static int[] expandAndFillWithAbsent(int[] iArr, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65550, null, iArr, i2)) == null) {
            int length = iArr.length;
            int[] copyOf = Arrays.copyOf(iArr, i2);
            Arrays.fill(copyOf, length, i2, -1);
            return copyOf;
        }
        return (int[]) invokeLI.objValue;
    }

    private void insertIntoTableKToV(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65551, this, i2, i3) == null) {
            n.d(i2 != -1);
            int bucket = bucket(i3);
            int[] iArr = this.nextInBucketKToV;
            int[] iArr2 = this.hashTableKToV;
            iArr[i2] = iArr2[bucket];
            iArr2[bucket] = i2;
        }
    }

    private void insertIntoTableVToK(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65552, this, i2, i3) == null) {
            n.d(i2 != -1);
            int bucket = bucket(i3);
            int[] iArr = this.nextInBucketVToK;
            int[] iArr2 = this.hashTableVToK;
            iArr[i2] = iArr2[bucket];
            iArr2[bucket] = i2;
        }
    }

    private void moveEntryToIndex(int i2, int i3) {
        int i4;
        int i5;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(65553, this, i2, i3) == null) || i2 == i3) {
            return;
        }
        int i6 = this.prevInInsertionOrder[i2];
        int i7 = this.nextInInsertionOrder[i2];
        setSucceeds(i6, i3);
        setSucceeds(i3, i7);
        K[] kArr = this.keys;
        K k = kArr[i2];
        V[] vArr = this.values;
        V v = vArr[i2];
        kArr[i3] = k;
        vArr[i3] = v;
        int bucket = bucket(n0.d(k));
        int[] iArr = this.hashTableKToV;
        if (iArr[bucket] == i2) {
            iArr[bucket] = i3;
        } else {
            int i8 = iArr[bucket];
            int i9 = this.nextInBucketKToV[i8];
            while (true) {
                int i10 = i9;
                i4 = i8;
                i8 = i10;
                if (i8 == i2) {
                    break;
                }
                i9 = this.nextInBucketKToV[i8];
            }
            this.nextInBucketKToV[i4] = i3;
        }
        int[] iArr2 = this.nextInBucketKToV;
        iArr2[i3] = iArr2[i2];
        iArr2[i2] = -1;
        int bucket2 = bucket(n0.d(v));
        int[] iArr3 = this.hashTableVToK;
        if (iArr3[bucket2] == i2) {
            iArr3[bucket2] = i3;
        } else {
            int i11 = iArr3[bucket2];
            int i12 = this.nextInBucketVToK[i11];
            while (true) {
                int i13 = i12;
                i5 = i11;
                i11 = i13;
                if (i11 == i2) {
                    break;
                }
                i12 = this.nextInBucketVToK[i11];
            }
            this.nextInBucketVToK[i5] = i3;
        }
        int[] iArr4 = this.nextInBucketVToK;
        iArr4[i3] = iArr4[i2];
        iArr4[i2] = -1;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65554, this, objectInputStream) == null) {
            objectInputStream.defaultReadObject();
            int h2 = d1.h(objectInputStream);
            init(16);
            d1.c(this, objectInputStream, h2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void replaceKeyInEntry(int i2, K k, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65556, this, new Object[]{Integer.valueOf(i2), k, Boolean.valueOf(z)}) == null) {
            n.d(i2 != -1);
            int d2 = n0.d(k);
            int findEntryByKey = findEntryByKey(k, d2);
            int i3 = this.lastInInsertionOrder;
            int i4 = -2;
            if (findEntryByKey != -1) {
                if (z) {
                    i3 = this.prevInInsertionOrder[findEntryByKey];
                    i4 = this.nextInInsertionOrder[findEntryByKey];
                    removeEntryKeyHashKnown(findEntryByKey, d2);
                    if (i2 == this.size) {
                        i2 = findEntryByKey;
                    }
                } else {
                    throw new IllegalArgumentException("Key already present in map: " + k);
                }
            }
            if (i3 == i2) {
                i3 = this.prevInInsertionOrder[i2];
            } else if (i3 == this.size) {
                i3 = findEntryByKey;
            }
            if (i4 == i2) {
                findEntryByKey = this.nextInInsertionOrder[i2];
            } else if (i4 != this.size) {
                findEntryByKey = i4;
            }
            setSucceeds(this.prevInInsertionOrder[i2], this.nextInInsertionOrder[i2]);
            deleteFromTableKToV(i2, n0.d(this.keys[i2]));
            this.keys[i2] = k;
            insertIntoTableKToV(i2, n0.d(k));
            setSucceeds(i3, i2);
            setSucceeds(i2, findEntryByKey);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void replaceValueInEntry(int i2, V v, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65557, this, new Object[]{Integer.valueOf(i2), v, Boolean.valueOf(z)}) == null) {
            n.d(i2 != -1);
            int d2 = n0.d(v);
            int findEntryByValue = findEntryByValue(v, d2);
            if (findEntryByValue != -1) {
                if (z) {
                    removeEntryValueHashKnown(findEntryByValue, d2);
                    if (i2 == this.size) {
                        i2 = findEntryByValue;
                    }
                } else {
                    throw new IllegalArgumentException("Value already present in map: " + v);
                }
            }
            deleteFromTableVToK(i2, n0.d(this.values[i2]));
            this.values[i2] = v;
            insertIntoTableVToK(i2, d2);
        }
    }

    private void setSucceeds(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65558, this, i2, i3) == null) {
            if (i2 == -2) {
                this.firstInInsertionOrder = i3;
            } else {
                this.nextInInsertionOrder[i2] = i3;
            }
            if (i3 == -2) {
                this.lastInInsertionOrder = i2;
            } else {
                this.prevInInsertionOrder[i3] = i2;
            }
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65559, this, objectOutputStream) == null) {
            objectOutputStream.defaultWriteObject();
            d1.i(this, objectOutputStream);
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Arrays.fill(this.keys, 0, this.size, (Object) null);
            Arrays.fill(this.values, 0, this.size, (Object) null);
            Arrays.fill(this.hashTableKToV, -1);
            Arrays.fill(this.hashTableVToK, -1);
            Arrays.fill(this.nextInBucketKToV, 0, this.size, -1);
            Arrays.fill(this.nextInBucketVToK, 0, this.size, -1);
            Arrays.fill(this.prevInInsertionOrder, 0, this.size, -1);
            Arrays.fill(this.nextInInsertionOrder, 0, this.size, -1);
            this.size = 0;
            this.firstInInsertionOrder = -2;
            this.lastInInsertionOrder = -2;
            this.modCount++;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) ? findEntryByKey(obj) != -1 : invokeL.booleanValue;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) ? findEntryByValue(obj) != -1 : invokeL.booleanValue;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            Set<Map.Entry<K, V>> set = this.entrySet;
            if (set == null) {
                c cVar = new c(this);
                this.entrySet = cVar;
                return cVar;
            }
            return set;
        }
        return (Set) invokeV.objValue;
    }

    public int findEntry(Object obj, int i2, int[] iArr, int[] iArr2, Object[] objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{obj, Integer.valueOf(i2), iArr, iArr2, objArr})) == null) {
            int i3 = iArr[bucket(i2)];
            while (i3 != -1) {
                if (c.i.d.a.k.a(objArr[i3], obj)) {
                    return i3;
                }
                i3 = iArr2[i3];
            }
            return -1;
        }
        return invokeCommon.intValue;
    }

    public int findEntryByKey(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) ? findEntryByKey(obj, n0.d(obj)) : invokeL.intValue;
    }

    public int findEntryByValue(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, obj)) == null) ? findEntryByValue(obj, n0.d(obj)) : invokeL.intValue;
    }

    @Override // c.i.d.c.k
    public V forcePut(K k, V v) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, k, v)) == null) ? put(k, v, true) : (V) invokeLL.objValue;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, obj)) == null) {
            int findEntryByKey = findEntryByKey(obj);
            if (findEntryByKey == -1) {
                return null;
            }
            return this.values[findEntryByKey];
        }
        return (V) invokeL.objValue;
    }

    public K getInverse(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, obj)) == null) {
            int findEntryByValue = findEntryByValue(obj);
            if (findEntryByValue == -1) {
                return null;
            }
            return this.keys[findEntryByValue];
        }
        return (K) invokeL.objValue;
    }

    public void init(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            m.b(i2, "expectedSize");
            int a2 = n0.a(i2, 1.0d);
            this.size = 0;
            this.keys = (K[]) new Object[i2];
            this.values = (V[]) new Object[i2];
            this.hashTableKToV = createFilledWithAbsent(a2);
            this.hashTableVToK = createFilledWithAbsent(a2);
            this.nextInBucketKToV = createFilledWithAbsent(i2);
            this.nextInBucketVToK = createFilledWithAbsent(i2);
            this.firstInInsertionOrder = -2;
            this.lastInInsertionOrder = -2;
            this.prevInInsertionOrder = createFilledWithAbsent(i2);
            this.nextInInsertionOrder = createFilledWithAbsent(i2);
        }
    }

    @Override // c.i.d.c.k
    public k<V, K> inverse() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            k<V, K> kVar = this.inverse;
            if (kVar == null) {
                Inverse inverse = new Inverse(this);
                this.inverse = inverse;
                return inverse;
            }
            return kVar;
        }
        return (k) invokeV.objValue;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            Set<K> set = this.keySet;
            if (set == null) {
                e eVar = new e(this);
                this.keySet = eVar;
                return eVar;
            }
            return set;
        }
        return (Set) invokeV.objValue;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k, V v) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, k, v)) == null) ? put(k, v, false) : (V) invokeLL.objValue;
    }

    public K putInverse(V v, K k, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048593, this, v, k, z)) == null) {
            int d2 = n0.d(v);
            int findEntryByValue = findEntryByValue(v, d2);
            if (findEntryByValue != -1) {
                K k2 = this.keys[findEntryByValue];
                if (c.i.d.a.k.a(k2, k)) {
                    return k;
                }
                replaceKeyInEntry(findEntryByValue, k, z);
                return k2;
            }
            int i2 = this.lastInInsertionOrder;
            int d3 = n0.d(k);
            int findEntryByKey = findEntryByKey(k, d3);
            if (!z) {
                n.k(findEntryByKey == -1, "Key already present: %s", k);
            } else if (findEntryByKey != -1) {
                i2 = this.prevInInsertionOrder[findEntryByKey];
                removeEntryKeyHashKnown(findEntryByKey, d3);
            }
            ensureCapacity(this.size + 1);
            K[] kArr = this.keys;
            int i3 = this.size;
            kArr[i3] = k;
            this.values[i3] = v;
            insertIntoTableKToV(i3, d3);
            insertIntoTableVToK(this.size, d2);
            int i4 = i2 == -2 ? this.firstInInsertionOrder : this.nextInInsertionOrder[i2];
            setSucceeds(i2, this.size);
            setSucceeds(this.size, i4);
            this.size++;
            this.modCount++;
            return null;
        }
        return (K) invokeLLZ.objValue;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, obj)) == null) {
            int d2 = n0.d(obj);
            int findEntryByKey = findEntryByKey(obj, d2);
            if (findEntryByKey == -1) {
                return null;
            }
            V v = this.values[findEntryByKey];
            removeEntryKeyHashKnown(findEntryByKey, d2);
            return v;
        }
        return (V) invokeL.objValue;
    }

    public void removeEntry(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            removeEntryKeyHashKnown(i2, n0.d(this.keys[i2]));
        }
    }

    public void removeEntryKeyHashKnown(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048596, this, i2, i3) == null) {
            removeEntry(i2, i3, n0.d(this.values[i2]));
        }
    }

    public void removeEntryValueHashKnown(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048597, this, i2, i3) == null) {
            removeEntry(i2, n0.d(this.keys[i2]), i3);
        }
    }

    public K removeInverse(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, obj)) == null) {
            int d2 = n0.d(obj);
            int findEntryByValue = findEntryByValue(obj, d2);
            if (findEntryByValue == -1) {
                return null;
            }
            K k = this.keys[findEntryByValue];
            removeEntryValueHashKnown(findEntryByValue, d2);
            return k;
        }
        return (K) invokeL.objValue;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.size : invokeV.intValue;
    }

    public static <K, V> HashBiMap<K, V> create(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65544, null, i2)) == null) ? new HashBiMap<>(i2) : (HashBiMap) invokeI.objValue;
    }

    private void removeEntry(int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(65555, this, i2, i3, i4) == null) {
            n.d(i2 != -1);
            deleteFromTableKToV(i2, i3);
            deleteFromTableVToK(i2, i4);
            setSucceeds(this.prevInInsertionOrder[i2], this.nextInInsertionOrder[i2]);
            moveEntryToIndex(this.size - 1, i2);
            K[] kArr = this.keys;
            int i5 = this.size;
            kArr[i5 - 1] = null;
            this.values[i5 - 1] = null;
            this.size = i5 - 1;
            this.modCount++;
        }
    }

    public int findEntryByKey(Object obj, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048582, this, obj, i2)) == null) ? findEntry(obj, i2, this.hashTableKToV, this.nextInBucketKToV, this.keys) : invokeLI.intValue;
    }

    public int findEntryByValue(Object obj, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, obj, i2)) == null) ? findEntry(obj, i2, this.hashTableVToK, this.nextInBucketVToK, this.values) : invokeLI.intValue;
    }

    public V put(K k, V v, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048592, this, k, v, z)) == null) {
            int d2 = n0.d(k);
            int findEntryByKey = findEntryByKey(k, d2);
            if (findEntryByKey != -1) {
                V v2 = this.values[findEntryByKey];
                if (c.i.d.a.k.a(v2, v)) {
                    return v;
                }
                replaceValueInEntry(findEntryByKey, v, z);
                return v2;
            }
            int d3 = n0.d(v);
            int findEntryByValue = findEntryByValue(v, d3);
            if (!z) {
                n.k(findEntryByValue == -1, "Value already present: %s", v);
            } else if (findEntryByValue != -1) {
                removeEntryValueHashKnown(findEntryByValue, d3);
            }
            ensureCapacity(this.size + 1);
            K[] kArr = this.keys;
            int i2 = this.size;
            kArr[i2] = k;
            this.values[i2] = v;
            insertIntoTableKToV(i2, d2);
            insertIntoTableVToK(this.size, d3);
            setSucceeds(this.lastInInsertionOrder, this.size);
            setSucceeds(this.size, -2);
            this.size++;
            this.modCount++;
            return null;
        }
        return (V) invokeLLZ.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.AbstractMap, java.util.Map, c.i.d.c.k
    public Set<V> values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            Set<V> set = this.valueSet;
            if (set == null) {
                f fVar = new f(this);
                this.valueSet = fVar;
                return fVar;
            }
            return set;
        }
        return (Set) invokeV.objValue;
    }

    public static <K, V> HashBiMap<K, V> create(Map<? extends K, ? extends V> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, map)) == null) {
            HashBiMap<K, V> create = create(map.size());
            create.putAll(map);
            return create;
        }
        return (HashBiMap) invokeL.objValue;
    }
}
