package com.google.common.collect;

import androidx.core.view.InputDeviceCompat;
import b.i.d.a.n;
import b.i.d.c.d0;
import b.i.d.c.e0;
import b.i.d.c.j0;
import b.i.d.c.k;
import b.i.d.c.m;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
/* loaded from: classes2.dex */
public abstract class AbstractBiMap<K, V> extends d0<K, V> implements k<K, V>, Serializable {
    public static /* synthetic */ Interceptable $ic;
    public static final long serialVersionUID = 0;
    public transient /* synthetic */ FieldHolder $fh;
    public transient Map<K, V> delegate;
    public transient Set<Map.Entry<K, V>> entrySet;
    public transient AbstractBiMap<V, K> inverse;
    public transient Set<K> keySet;
    public transient Set<V> valueSet;

    /* loaded from: classes2.dex */
    public static class Inverse<K, V> extends AbstractBiMap<K, V> {
        public static /* synthetic */ Interceptable $ic;
        public static final long serialVersionUID = 0;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Inverse(Map<K, V> map, AbstractBiMap<V, K> abstractBiMap) {
            super(map, abstractBiMap, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {map, abstractBiMap};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Map) objArr2[0], (AbstractBiMap) objArr2[1], (a) objArr2[2]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65537, this, objectInputStream) == null) {
                objectInputStream.defaultReadObject();
                setInverse((AbstractBiMap) objectInputStream.readObject());
            }
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65538, this, objectOutputStream) == null) {
                objectOutputStream.defaultWriteObject();
                objectOutputStream.writeObject(inverse());
            }
        }

        @Override // com.google.common.collect.AbstractBiMap
        public K checkKey(K k) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, k)) == null) ? this.inverse.checkValue(k) : (K) invokeL.objValue;
        }

        @Override // com.google.common.collect.AbstractBiMap
        public V checkValue(V v) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, v)) == null) ? this.inverse.checkKey(v) : (V) invokeL.objValue;
        }

        @Override // com.google.common.collect.AbstractBiMap, b.i.d.c.d0, b.i.d.c.h0
        public /* bridge */ /* synthetic */ Object delegate() {
            return super.delegate();
        }

        public Object readResolve() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? inverse().inverse() : invokeV.objValue;
        }

        @Override // com.google.common.collect.AbstractBiMap, b.i.d.c.d0, java.util.Map
        public /* bridge */ /* synthetic */ Collection values() {
            return super.values();
        }
    }

    /* loaded from: classes2.dex */
    public class a implements Iterator<Map.Entry<K, V>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public Map.Entry<K, V> f63225e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Iterator f63226f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ AbstractBiMap f63227g;

        public a(AbstractBiMap abstractBiMap, Iterator it) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {abstractBiMap, it};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f63227g = abstractBiMap;
            this.f63226f = it;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Iterator
        /* renamed from: a */
        public Map.Entry<K, V> next() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                Map.Entry<K, V> entry = (Map.Entry) this.f63226f.next();
                this.f63225e = entry;
                return new b(this.f63227g, entry);
            }
            return (Map.Entry) invokeV.objValue;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f63226f.hasNext() : invokeV.booleanValue;
        }

        @Override // java.util.Iterator
        public void remove() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                m.e(this.f63225e != null);
                V value = this.f63225e.getValue();
                this.f63226f.remove();
                this.f63227g.removeFromInverseMap(value);
                this.f63225e = null;
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b extends e0<K, V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final Map.Entry<K, V> f63228e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ AbstractBiMap f63229f;

        public b(AbstractBiMap abstractBiMap, Map.Entry<K, V> entry) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {abstractBiMap, entry};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f63229f = abstractBiMap;
            this.f63228e = entry;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.i.d.c.h0
        /* renamed from: d */
        public Map.Entry<K, V> delegate() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f63228e : (Map.Entry) invokeV.objValue;
        }

        @Override // b.i.d.c.e0, java.util.Map.Entry
        public V setValue(V v) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, v)) == null) {
                this.f63229f.checkValue(v);
                n.x(this.f63229f.entrySet().contains(this), "entry no longer in map");
                if (b.i.d.a.k.a(v, getValue())) {
                    return v;
                }
                n.k(!this.f63229f.containsValue(v), "value already present: %s", v);
                V value = this.f63228e.setValue(v);
                n.x(b.i.d.a.k.a(v, this.f63229f.get(getKey())), "entry no longer in map");
                this.f63229f.updateInverseMap(getKey(), true, value, v);
                return value;
            }
            return (V) invokeL.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public class c extends j0<Map.Entry<K, V>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final Set<Map.Entry<K, V>> f63230e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ AbstractBiMap f63231f;

        public c(AbstractBiMap abstractBiMap) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {abstractBiMap};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f63231f = abstractBiMap;
            this.f63230e = this.f63231f.delegate.entrySet();
        }

        @Override // b.i.d.c.y, java.util.Collection
        public void clear() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f63231f.clear();
            }
        }

        @Override // b.i.d.c.y, java.util.Collection
        public boolean contains(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) ? Maps.f(delegate(), obj) : invokeL.booleanValue;
        }

        @Override // b.i.d.c.y, java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, collection)) == null) ? standardContainsAll(collection) : invokeL.booleanValue;
        }

        @Override // b.i.d.c.y, java.util.Collection, java.lang.Iterable, b.i.d.c.s0
        public Iterator<Map.Entry<K, V>> iterator() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f63231f.entrySetIterator() : (Iterator) invokeV.objValue;
        }

        @Override // b.i.d.c.y, java.util.Collection
        public boolean remove(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, obj)) == null) {
                if (this.f63230e.contains(obj)) {
                    Map.Entry entry = (Map.Entry) obj;
                    this.f63231f.inverse.delegate.remove(entry.getValue());
                    this.f63230e.remove(entry);
                    return true;
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // b.i.d.c.y, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, collection)) == null) ? standardRemoveAll(collection) : invokeL.booleanValue;
        }

        @Override // b.i.d.c.y, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, collection)) == null) ? standardRetainAll(collection) : invokeL.booleanValue;
        }

        @Override // b.i.d.c.y, java.util.Collection
        public Object[] toArray() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? standardToArray() : (Object[]) invokeV.objValue;
        }

        @Override // b.i.d.c.y, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, tArr)) == null) ? (T[]) standardToArray(tArr) : (T[]) ((Object[]) invokeL.objValue);
        }

        public /* synthetic */ c(AbstractBiMap abstractBiMap, a aVar) {
            this(abstractBiMap);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.i.d.c.j0, b.i.d.c.y, b.i.d.c.h0
        public Set<Map.Entry<K, V>> delegate() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f63230e : (Set) invokeV.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public class d extends j0<K> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbstractBiMap f63232e;

        public d(AbstractBiMap abstractBiMap) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {abstractBiMap};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f63232e = abstractBiMap;
        }

        @Override // b.i.d.c.y, java.util.Collection
        public void clear() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f63232e.clear();
            }
        }

        @Override // b.i.d.c.y, java.util.Collection, java.lang.Iterable, b.i.d.c.s0
        public Iterator<K> iterator() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? Maps.o(this.f63232e.entrySet().iterator()) : (Iterator) invokeV.objValue;
        }

        @Override // b.i.d.c.y, java.util.Collection
        public boolean remove(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
                if (contains(obj)) {
                    this.f63232e.removeFromBothMaps(obj);
                    return true;
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // b.i.d.c.y, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, collection)) == null) ? standardRemoveAll(collection) : invokeL.booleanValue;
        }

        @Override // b.i.d.c.y, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, collection)) == null) ? standardRetainAll(collection) : invokeL.booleanValue;
        }

        public /* synthetic */ d(AbstractBiMap abstractBiMap, a aVar) {
            this(abstractBiMap);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.i.d.c.j0, b.i.d.c.y, b.i.d.c.h0
        public Set<K> delegate() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f63232e.delegate.keySet() : (Set) invokeV.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public class e extends j0<V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final Set<V> f63233e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ AbstractBiMap f63234f;

        public e(AbstractBiMap abstractBiMap) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {abstractBiMap};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f63234f = abstractBiMap;
            this.f63233e = this.f63234f.inverse.keySet();
        }

        @Override // b.i.d.c.y, java.util.Collection, java.lang.Iterable, b.i.d.c.s0
        public Iterator<V> iterator() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? Maps.O(this.f63234f.entrySet().iterator()) : (Iterator) invokeV.objValue;
        }

        @Override // b.i.d.c.y, java.util.Collection
        public Object[] toArray() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? standardToArray() : (Object[]) invokeV.objValue;
        }

        @Override // b.i.d.c.h0, java.lang.Object
        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? standardToString() : (String) invokeV.objValue;
        }

        @Override // b.i.d.c.y, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, tArr)) == null) ? (T[]) standardToArray(tArr) : (T[]) ((Object[]) invokeL.objValue);
        }

        public /* synthetic */ e(AbstractBiMap abstractBiMap, a aVar) {
            this(abstractBiMap);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.i.d.c.j0, b.i.d.c.y, b.i.d.c.h0
        public Set<V> delegate() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f63233e : (Set) invokeV.objValue;
        }
    }

    public /* synthetic */ AbstractBiMap(Map map, AbstractBiMap abstractBiMap, a aVar) {
        this(map, abstractBiMap);
    }

    private V putInBothMaps(K k, V v, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65543, this, k, v, z)) == null) {
            checkKey(k);
            checkValue(v);
            boolean containsKey = containsKey(k);
            if (containsKey && b.i.d.a.k.a(v, get(k))) {
                return v;
            }
            if (z) {
                inverse().remove(v);
            } else {
                n.k(!containsValue(v), "value already present: %s", v);
            }
            V put = this.delegate.put(k, v);
            updateInverseMap(k, containsKey, put, v);
            return put;
        }
        return (V) invokeLLZ.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public V removeFromBothMaps(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, this, obj)) == null) {
            V remove = this.delegate.remove(obj);
            removeFromInverseMap(remove);
            return remove;
        }
        return (V) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeFromInverseMap(V v) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, this, v) == null) {
            this.inverse.delegate.remove(v);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateInverseMap(K k, boolean z, V v, V v2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65546, this, new Object[]{k, Boolean.valueOf(z), v, v2}) == null) {
            if (z) {
                removeFromInverseMap(v);
            }
            this.inverse.delegate.put(v2, k);
        }
    }

    public K checkKey(K k) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, k)) == null) ? k : (K) invokeL.objValue;
    }

    public V checkValue(V v) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, v)) == null) ? v : (V) invokeL.objValue;
    }

    @Override // b.i.d.c.d0, java.util.Map
    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.delegate.clear();
            this.inverse.delegate.clear();
        }
    }

    @Override // b.i.d.c.d0, java.util.Map
    public boolean containsValue(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) ? this.inverse.containsKey(obj) : invokeL.booleanValue;
    }

    @Override // b.i.d.c.d0, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            Set<Map.Entry<K, V>> set = this.entrySet;
            if (set == null) {
                c cVar = new c(this, null);
                this.entrySet = cVar;
                return cVar;
            }
            return set;
        }
        return (Set) invokeV.objValue;
    }

    public Iterator<Map.Entry<K, V>> entrySetIterator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? new a(this, this.delegate.entrySet().iterator()) : (Iterator) invokeV.objValue;
    }

    @Override // b.i.d.c.k
    public V forcePut(K k, V v) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, k, v)) == null) ? putInBothMaps(k, v, true) : (V) invokeLL.objValue;
    }

    @Override // b.i.d.c.k
    public k<V, K> inverse() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.inverse : (k) invokeV.objValue;
    }

    @Override // b.i.d.c.d0, java.util.Map
    public Set<K> keySet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            Set<K> set = this.keySet;
            if (set == null) {
                d dVar = new d(this, null);
                this.keySet = dVar;
                return dVar;
            }
            return set;
        }
        return (Set) invokeV.objValue;
    }

    public AbstractBiMap<V, K> makeInverse(Map<V, K> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, map)) == null) ? new Inverse(map, this) : (AbstractBiMap) invokeL.objValue;
    }

    @Override // b.i.d.c.d0, java.util.Map
    public V put(K k, V v) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, k, v)) == null) ? putInBothMaps(k, v, false) : (V) invokeLL.objValue;
    }

    @Override // b.i.d.c.d0, java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, map) == null) {
            for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
                put(entry.getKey(), entry.getValue());
            }
        }
    }

    @Override // b.i.d.c.d0, java.util.Map
    public V remove(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, obj)) == null) {
            if (containsKey(obj)) {
                return removeFromBothMaps(obj);
            }
            return null;
        }
        return (V) invokeL.objValue;
    }

    public void setDelegates(Map<K, V> map, Map<V, K> map2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, map, map2) == null) {
            n.w(this.delegate == null);
            n.w(this.inverse == null);
            n.d(map.isEmpty());
            n.d(map2.isEmpty());
            n.d(map != map2);
            this.delegate = map;
            this.inverse = makeInverse(map2);
        }
    }

    public void setInverse(AbstractBiMap<V, K> abstractBiMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, abstractBiMap) == null) {
            this.inverse = abstractBiMap;
        }
    }

    public AbstractBiMap(Map<K, V> map, Map<V, K> map2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {map, map2};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        setDelegates(map, map2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.i.d.c.d0, b.i.d.c.h0
    public Map<K, V> delegate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.delegate : (Map) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.i.d.c.d0, java.util.Map
    public Set<V> values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            Set<V> set = this.valueSet;
            if (set == null) {
                e eVar = new e(this, null);
                this.valueSet = eVar;
                return eVar;
            }
            return set;
        }
        return (Set) invokeV.objValue;
    }

    public AbstractBiMap(Map<K, V> map, AbstractBiMap<V, K> abstractBiMap) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {map, abstractBiMap};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.delegate = map;
        this.inverse = abstractBiMap;
    }
}
