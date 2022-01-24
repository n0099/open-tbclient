package com.google.common.collect;

import androidx.core.view.InputDeviceCompat;
import c.i.d.c.c;
import c.i.d.c.e1;
import c.i.d.c.s0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimaps;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
/* loaded from: classes3.dex */
public abstract class AbstractMapBasedMultimap<K, V> extends c.i.d.c.c<K, V> implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = 2447537837011683357L;
    public transient /* synthetic */ FieldHolder $fh;
    public transient Map<K, Collection<V>> map;
    public transient int totalSize;

    /* loaded from: classes3.dex */
    public class a extends AbstractMapBasedMultimap<K, V>.d<V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(AbstractMapBasedMultimap abstractMapBasedMultimap) {
            super(abstractMapBasedMultimap);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {abstractMapBasedMultimap};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((AbstractMapBasedMultimap) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.d
        public V a(K k, V v) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, k, v)) == null) ? v : (V) invokeLL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class b extends AbstractMapBasedMultimap<K, V>.d<Map.Entry<K, V>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(AbstractMapBasedMultimap abstractMapBasedMultimap) {
            super(abstractMapBasedMultimap);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {abstractMapBasedMultimap};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((AbstractMapBasedMultimap) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.AbstractMapBasedMultimap.d
        /* renamed from: b */
        public Map.Entry<K, V> a(K k, V v) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, k, v)) == null) ? Maps.l(k, v) : (Map.Entry) invokeLL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class c extends Maps.y<K, Collection<V>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: h  reason: collision with root package name */
        public final transient Map<K, Collection<V>> f54555h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ AbstractMapBasedMultimap f54556i;

        /* loaded from: classes3.dex */
        public class a extends Maps.k<K, Collection<V>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f54557e;

            public a(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f54557e = cVar;
            }

            @Override // com.google.common.collect.Maps.k
            public Map<K, Collection<V>> b() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f54557e : (Map) invokeV.objValue;
            }

            @Override // com.google.common.collect.Maps.k, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object obj) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) ? c.i.d.c.n.e(this.f54557e.f54555h.entrySet(), obj) : invokeL.booleanValue;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<K, Collection<V>>> iterator() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? new b(this.f54557e) : (Iterator) invokeV.objValue;
            }

            @Override // com.google.common.collect.Maps.k, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object obj) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
                    if (contains(obj)) {
                        this.f54557e.f54556i.removeValuesForKey(((Map.Entry) obj).getKey());
                        return true;
                    }
                    return false;
                }
                return invokeL.booleanValue;
            }
        }

        /* loaded from: classes3.dex */
        public class b implements Iterator<Map.Entry<K, Collection<V>>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final Iterator<Map.Entry<K, Collection<V>>> f54558e;

            /* renamed from: f  reason: collision with root package name */
            public Collection<V> f54559f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ c f54560g;

            public b(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f54560g = cVar;
                this.f54558e = this.f54560g.f54555h.entrySet().iterator();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Iterator
            /* renamed from: a */
            public Map.Entry<K, Collection<V>> next() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    Map.Entry<K, Collection<V>> next = this.f54558e.next();
                    this.f54559f = next.getValue();
                    return this.f54560g.f(next);
                }
                return (Map.Entry) invokeV.objValue;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f54558e.hasNext() : invokeV.booleanValue;
            }

            @Override // java.util.Iterator
            public void remove() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                    c.i.d.c.m.e(this.f54559f != null);
                    this.f54558e.remove();
                    this.f54560g.f54556i.totalSize -= this.f54559f.size();
                    this.f54559f.clear();
                    this.f54559f = null;
                }
            }
        }

        public c(AbstractMapBasedMultimap abstractMapBasedMultimap, Map<K, Collection<V>> map) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {abstractMapBasedMultimap, map};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54556i = abstractMapBasedMultimap;
            this.f54555h = map;
        }

        @Override // com.google.common.collect.Maps.y
        public Set<Map.Entry<K, Collection<V>>> a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new a(this) : (Set) invokeV.objValue;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (this.f54555h == this.f54556i.map) {
                    this.f54556i.clear();
                } else {
                    Iterators.e(new b(this));
                }
            }
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) ? Maps.z(this.f54555h, obj) : invokeL.booleanValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.AbstractMap, java.util.Map
        /* renamed from: d */
        public Collection<V> get(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
                Collection<V> collection = (Collection) Maps.A(this.f54555h, obj);
                if (collection == null) {
                    return null;
                }
                return this.f54556i.wrapCollection(obj, collection);
            }
            return (Collection) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.AbstractMap, java.util.Map
        /* renamed from: e */
        public Collection<V> remove(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, obj)) == null) {
                Collection<V> remove = this.f54555h.remove(obj);
                if (remove == null) {
                    return null;
                }
                Collection<V> createCollection = this.f54556i.createCollection();
                createCollection.addAll(remove);
                this.f54556i.totalSize -= remove.size();
                remove.clear();
                return createCollection;
            }
            return (Collection) invokeL.objValue;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) ? this == obj || this.f54555h.equals(obj) : invokeL.booleanValue;
        }

        public Map.Entry<K, Collection<V>> f(Map.Entry<K, Collection<V>> entry) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, entry)) == null) {
                K key = entry.getKey();
                return Maps.l(key, this.f54556i.wrapCollection(key, entry.getValue()));
            }
            return (Map.Entry) invokeL.objValue;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f54555h.hashCode() : invokeV.intValue;
        }

        @Override // com.google.common.collect.Maps.y, java.util.AbstractMap, java.util.Map
        public Set<K> keySet() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f54556i.keySet() : (Set) invokeV.objValue;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f54555h.size() : invokeV.intValue;
        }

        @Override // java.util.AbstractMap
        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f54555h.toString() : (String) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public abstract class d<T> implements Iterator<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final Iterator<Map.Entry<K, Collection<V>>> f54561e;

        /* renamed from: f  reason: collision with root package name */
        public K f54562f;

        /* renamed from: g  reason: collision with root package name */
        public Collection<V> f54563g;

        /* renamed from: h  reason: collision with root package name */
        public Iterator<V> f54564h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ AbstractMapBasedMultimap f54565i;

        /* JADX DEBUG: Type inference failed for r6v3. Raw type applied. Possible types: java.util.Iterator<java.util.Map$Entry<K, V>>, java.util.Iterator<java.util.Map$Entry<K, java.util.Collection<V>>> */
        public d(AbstractMapBasedMultimap abstractMapBasedMultimap) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {abstractMapBasedMultimap};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54565i = abstractMapBasedMultimap;
            this.f54561e = (Iterator<Map.Entry<K, V>>) abstractMapBasedMultimap.map.entrySet().iterator();
            this.f54562f = null;
            this.f54563g = null;
            this.f54564h = Iterators.k();
        }

        public abstract T a(K k, V v);

        @Override // java.util.Iterator
        public boolean hasNext() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f54561e.hasNext() || this.f54564h.hasNext() : invokeV.booleanValue;
        }

        @Override // java.util.Iterator
        public T next() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                if (!this.f54564h.hasNext()) {
                    Map.Entry<K, Collection<V>> next = this.f54561e.next();
                    this.f54562f = next.getKey();
                    Collection<V> value = next.getValue();
                    this.f54563g = value;
                    this.f54564h = value.iterator();
                }
                return a(this.f54562f, this.f54564h.next());
            }
            return (T) invokeV.objValue;
        }

        @Override // java.util.Iterator
        public void remove() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.f54564h.remove();
                if (this.f54563g.isEmpty()) {
                    this.f54561e.remove();
                }
                AbstractMapBasedMultimap.access$210(this.f54565i);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e extends Maps.q<K, Collection<V>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ AbstractMapBasedMultimap f54566f;

        /* loaded from: classes3.dex */
        public class a implements Iterator<K> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public Map.Entry<K, Collection<V>> f54567e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ Iterator f54568f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ e f54569g;

            public a(e eVar, Iterator it) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar, it};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f54569g = eVar;
                this.f54568f = it;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f54568f.hasNext() : invokeV.booleanValue;
            }

            @Override // java.util.Iterator
            public K next() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                    Map.Entry<K, Collection<V>> entry = (Map.Entry) this.f54568f.next();
                    this.f54567e = entry;
                    return entry.getKey();
                }
                return (K) invokeV.objValue;
            }

            @Override // java.util.Iterator
            public void remove() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    c.i.d.c.m.e(this.f54567e != null);
                    Collection<V> value = this.f54567e.getValue();
                    this.f54568f.remove();
                    this.f54569g.f54566f.totalSize -= value.size();
                    value.clear();
                    this.f54567e = null;
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(AbstractMapBasedMultimap abstractMapBasedMultimap, Map<K, Collection<V>> map) {
            super(map);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {abstractMapBasedMultimap, map};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Map) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54566f = abstractMapBasedMultimap;
        }

        @Override // com.google.common.collect.Maps.q, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Iterators.e(iterator());
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> collection) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, collection)) == null) ? b().keySet().containsAll(collection) : invokeL.booleanValue;
        }

        @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) ? this == obj || b().keySet().equals(obj) : invokeL.booleanValue;
        }

        @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? b().keySet().hashCode() : invokeV.intValue;
        }

        @Override // com.google.common.collect.Maps.q, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? new a(this, b().entrySet().iterator()) : (Iterator) invokeV.objValue;
        }

        @Override // com.google.common.collect.Maps.q, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            InterceptResult invokeL;
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
                Collection<V> remove = b().remove(obj);
                if (remove != null) {
                    i2 = remove.size();
                    remove.clear();
                    this.f54566f.totalSize -= i2;
                } else {
                    i2 = 0;
                }
                return i2 > 0;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class f extends AbstractMapBasedMultimap<K, V>.i implements NavigableMap<K, Collection<V>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbstractMapBasedMultimap l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(AbstractMapBasedMultimap abstractMapBasedMultimap, NavigableMap<K, Collection<V>> navigableMap) {
            super(abstractMapBasedMultimap, navigableMap);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {abstractMapBasedMultimap, navigableMap};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((AbstractMapBasedMultimap) objArr2[0], (SortedMap) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.l = abstractMapBasedMultimap;
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> ceilingEntry(K k) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, k)) == null) {
                Map.Entry<K, Collection<V>> ceilingEntry = i().ceilingEntry(k);
                if (ceilingEntry == null) {
                    return null;
                }
                return f(ceilingEntry);
            }
            return (Map.Entry) invokeL.objValue;
        }

        @Override // java.util.NavigableMap
        public K ceilingKey(K k) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, k)) == null) ? i().ceilingKey(k) : (K) invokeL.objValue;
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> descendingKeySet() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? descendingMap().navigableKeySet() : (NavigableSet) invokeV.objValue;
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, Collection<V>> descendingMap() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? new f(this.l, i().descendingMap()) : (NavigableMap) invokeV.objValue;
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> firstEntry() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                Map.Entry<K, Collection<V>> firstEntry = i().firstEntry();
                if (firstEntry == null) {
                    return null;
                }
                return f(firstEntry);
            }
            return (Map.Entry) invokeV.objValue;
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> floorEntry(K k) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, k)) == null) {
                Map.Entry<K, Collection<V>> floorEntry = i().floorEntry(k);
                if (floorEntry == null) {
                    return null;
                }
                return f(floorEntry);
            }
            return (Map.Entry) invokeL.objValue;
        }

        @Override // java.util.NavigableMap
        public K floorKey(K k) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, k)) == null) ? i().floorKey(k) : (K) invokeL.objValue;
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> higherEntry(K k) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, k)) == null) {
                Map.Entry<K, Collection<V>> higherEntry = i().higherEntry(k);
                if (higherEntry == null) {
                    return null;
                }
                return f(higherEntry);
            }
            return (Map.Entry) invokeL.objValue;
        }

        @Override // java.util.NavigableMap
        public K higherKey(K k) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, k)) == null) ? i().higherKey(k) : (K) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.AbstractMapBasedMultimap.i
        /* renamed from: j */
        public NavigableSet<K> g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? new g(this.l, i()) : (NavigableSet) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.AbstractMapBasedMultimap.i, java.util.SortedMap, java.util.NavigableMap
        /* renamed from: k */
        public NavigableMap<K, Collection<V>> headMap(K k) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, k)) == null) ? headMap(k, false) : (NavigableMap) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.AbstractMapBasedMultimap.i, com.google.common.collect.AbstractMapBasedMultimap.c, com.google.common.collect.Maps.y, java.util.AbstractMap, java.util.Map
        /* renamed from: l */
        public NavigableSet<K> keySet() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? (NavigableSet) super.keySet() : (NavigableSet) invokeV.objValue;
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> lastEntry() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
                Map.Entry<K, Collection<V>> lastEntry = i().lastEntry();
                if (lastEntry == null) {
                    return null;
                }
                return f(lastEntry);
            }
            return (Map.Entry) invokeV.objValue;
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> lowerEntry(K k) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, k)) == null) {
                Map.Entry<K, Collection<V>> lowerEntry = i().lowerEntry(k);
                if (lowerEntry == null) {
                    return null;
                }
                return f(lowerEntry);
            }
            return (Map.Entry) invokeL.objValue;
        }

        @Override // java.util.NavigableMap
        public K lowerKey(K k) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, k)) == null) ? i().lowerKey(k) : (K) invokeL.objValue;
        }

        public Map.Entry<K, Collection<V>> m(Iterator<Map.Entry<K, Collection<V>>> it) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, it)) == null) {
                if (it.hasNext()) {
                    Map.Entry<K, Collection<V>> next = it.next();
                    Collection<V> createCollection = this.l.createCollection();
                    createCollection.addAll(next.getValue());
                    it.remove();
                    return Maps.l(next.getKey(), this.l.unmodifiableCollectionSubclass(createCollection));
                }
                return null;
            }
            return (Map.Entry) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.AbstractMapBasedMultimap.i
        /* renamed from: n */
        public NavigableMap<K, Collection<V>> i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? (NavigableMap) super.i() : (NavigableMap) invokeV.objValue;
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> navigableKeySet() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? keySet() : (NavigableSet) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.AbstractMapBasedMultimap.i, java.util.SortedMap, java.util.NavigableMap
        /* renamed from: o */
        public NavigableMap<K, Collection<V>> subMap(K k, K k2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048601, this, k, k2)) == null) ? subMap(k, true, k2, false) : (NavigableMap) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.AbstractMapBasedMultimap.i, java.util.SortedMap, java.util.NavigableMap
        /* renamed from: p */
        public NavigableMap<K, Collection<V>> tailMap(K k) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, k)) == null) ? tailMap(k, true) : (NavigableMap) invokeL.objValue;
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> pollFirstEntry() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? m(entrySet().iterator()) : (Map.Entry) invokeV.objValue;
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> pollLastEntry() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? m(descendingMap().entrySet().iterator()) : (Map.Entry) invokeV.objValue;
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, Collection<V>> headMap(K k, boolean z) {
            InterceptResult invokeLZ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048586, this, k, z)) == null) ? new f(this.l, i().headMap(k, z)) : (NavigableMap) invokeLZ.objValue;
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, Collection<V>> subMap(K k, boolean z, K k2, boolean z2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048605, this, new Object[]{k, Boolean.valueOf(z), k2, Boolean.valueOf(z2)})) == null) ? new f(this.l, i().subMap(k, z, k2, z2)) : (NavigableMap) invokeCommon.objValue;
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, Collection<V>> tailMap(K k, boolean z) {
            InterceptResult invokeLZ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048607, this, k, z)) == null) ? new f(this.l, i().tailMap(k, z)) : (NavigableMap) invokeLZ.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class g extends AbstractMapBasedMultimap<K, V>.j implements NavigableSet<K> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ AbstractMapBasedMultimap f54570h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(AbstractMapBasedMultimap abstractMapBasedMultimap, NavigableMap<K, Collection<V>> navigableMap) {
            super(abstractMapBasedMultimap, navigableMap);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {abstractMapBasedMultimap, navigableMap};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((AbstractMapBasedMultimap) objArr2[0], (SortedMap) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54570h = abstractMapBasedMultimap;
        }

        @Override // java.util.NavigableSet
        public K ceiling(K k) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, k)) == null) ? c().ceilingKey(k) : (K) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.AbstractMapBasedMultimap.j, java.util.SortedSet, java.util.NavigableSet
        /* renamed from: d */
        public NavigableSet<K> headSet(K k) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, k)) == null) ? headSet(k, false) : (NavigableSet) invokeL.objValue;
        }

        @Override // java.util.NavigableSet
        public Iterator<K> descendingIterator() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? descendingSet().iterator() : (Iterator) invokeV.objValue;
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> descendingSet() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? new g(this.f54570h, c().descendingMap()) : (NavigableSet) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.AbstractMapBasedMultimap.j
        /* renamed from: e */
        public NavigableMap<K, Collection<V>> c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? (NavigableMap) super.c() : (NavigableMap) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.AbstractMapBasedMultimap.j, java.util.SortedSet, java.util.NavigableSet
        /* renamed from: f */
        public NavigableSet<K> subSet(K k, K k2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, k, k2)) == null) ? subSet(k, true, k2, false) : (NavigableSet) invokeLL.objValue;
        }

        @Override // java.util.NavigableSet
        public K floor(K k) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, k)) == null) ? c().floorKey(k) : (K) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.AbstractMapBasedMultimap.j, java.util.SortedSet, java.util.NavigableSet
        /* renamed from: g */
        public NavigableSet<K> tailSet(K k) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, k)) == null) ? tailSet(k, true) : (NavigableSet) invokeL.objValue;
        }

        @Override // java.util.NavigableSet
        public K higher(K k) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, k)) == null) ? c().higherKey(k) : (K) invokeL.objValue;
        }

        @Override // java.util.NavigableSet
        public K lower(K k) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, k)) == null) ? c().lowerKey(k) : (K) invokeL.objValue;
        }

        @Override // java.util.NavigableSet
        public K pollFirst() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? (K) Iterators.t(iterator()) : (K) invokeV.objValue;
        }

        @Override // java.util.NavigableSet
        public K pollLast() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? (K) Iterators.t(descendingIterator()) : (K) invokeV.objValue;
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> headSet(K k, boolean z) {
            InterceptResult invokeLZ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048585, this, k, z)) == null) ? new g(this.f54570h, c().headMap(k, z)) : (NavigableSet) invokeLZ.objValue;
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> subSet(K k, boolean z, K k2, boolean z2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048591, this, new Object[]{k, Boolean.valueOf(z), k2, Boolean.valueOf(z2)})) == null) ? new g(this.f54570h, c().subMap(k, z, k2, z2)) : (NavigableSet) invokeCommon.objValue;
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> tailSet(K k, boolean z) {
            InterceptResult invokeLZ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048593, this, k, z)) == null) ? new g(this.f54570h, c().tailMap(k, z)) : (NavigableSet) invokeLZ.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class h extends AbstractMapBasedMultimap<K, V>.l implements RandomAccess {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(AbstractMapBasedMultimap abstractMapBasedMultimap, K k, List<V> list, AbstractMapBasedMultimap<K, V>.k kVar) {
            super(abstractMapBasedMultimap, k, list, kVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {abstractMapBasedMultimap, k, list, kVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((AbstractMapBasedMultimap) objArr2[0], objArr2[1], (List) objArr2[2], (k) objArr2[3]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i extends AbstractMapBasedMultimap<K, V>.c implements SortedMap<K, Collection<V>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: j  reason: collision with root package name */
        public SortedSet<K> f54571j;
        public final /* synthetic */ AbstractMapBasedMultimap k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(AbstractMapBasedMultimap abstractMapBasedMultimap, SortedMap<K, Collection<V>> sortedMap) {
            super(abstractMapBasedMultimap, sortedMap);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {abstractMapBasedMultimap, sortedMap};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((AbstractMapBasedMultimap) objArr2[0], (Map) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.k = abstractMapBasedMultimap;
        }

        @Override // java.util.SortedMap
        public Comparator<? super K> comparator() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? i().comparator() : (Comparator) invokeV.objValue;
        }

        @Override // java.util.SortedMap
        public K firstKey() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? i().firstKey() : (K) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.Maps.y
        /* renamed from: g */
        public SortedSet<K> b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? new j(this.k, i()) : (SortedSet) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.AbstractMapBasedMultimap.c, com.google.common.collect.Maps.y, java.util.AbstractMap, java.util.Map
        /* renamed from: h */
        public SortedSet<K> keySet() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                SortedSet<K> sortedSet = this.f54571j;
                if (sortedSet == null) {
                    SortedSet<K> b2 = b();
                    this.f54571j = b2;
                    return b2;
                }
                return sortedSet;
            }
            return (SortedSet) invokeV.objValue;
        }

        public SortedMap<K, Collection<V>> headMap(K k) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, k)) == null) ? new i(this.k, i().headMap(k)) : (SortedMap) invokeL.objValue;
        }

        public SortedMap<K, Collection<V>> i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? (SortedMap) this.f54555h : (SortedMap) invokeV.objValue;
        }

        @Override // java.util.SortedMap
        public K lastKey() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? i().lastKey() : (K) invokeV.objValue;
        }

        public SortedMap<K, Collection<V>> subMap(K k, K k2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, k, k2)) == null) ? new i(this.k, i().subMap(k, k2)) : (SortedMap) invokeLL.objValue;
        }

        public SortedMap<K, Collection<V>> tailMap(K k) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, k)) == null) ? new i(this.k, i().tailMap(k)) : (SortedMap) invokeL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class j extends AbstractMapBasedMultimap<K, V>.e implements SortedSet<K> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ AbstractMapBasedMultimap f54572g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(AbstractMapBasedMultimap abstractMapBasedMultimap, SortedMap<K, Collection<V>> sortedMap) {
            super(abstractMapBasedMultimap, sortedMap);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {abstractMapBasedMultimap, sortedMap};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((AbstractMapBasedMultimap) objArr2[0], (Map) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54572g = abstractMapBasedMultimap;
        }

        public SortedMap<K, Collection<V>> c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (SortedMap) super.b() : (SortedMap) invokeV.objValue;
        }

        @Override // java.util.SortedSet
        public Comparator<? super K> comparator() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? c().comparator() : (Comparator) invokeV.objValue;
        }

        @Override // java.util.SortedSet
        public K first() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? c().firstKey() : (K) invokeV.objValue;
        }

        public SortedSet<K> headSet(K k) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, k)) == null) ? new j(this.f54572g, c().headMap(k)) : (SortedSet) invokeL.objValue;
        }

        @Override // java.util.SortedSet
        public K last() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? c().lastKey() : (K) invokeV.objValue;
        }

        public SortedSet<K> subSet(K k, K k2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, k, k2)) == null) ? new j(this.f54572g, c().subMap(k, k2)) : (SortedSet) invokeLL.objValue;
        }

        public SortedSet<K> tailSet(K k) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, k)) == null) ? new j(this.f54572g, c().tailMap(k)) : (SortedSet) invokeL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class m extends AbstractMapBasedMultimap<K, V>.o implements NavigableSet<V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbstractMapBasedMultimap k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(AbstractMapBasedMultimap abstractMapBasedMultimap, K k, NavigableSet<V> navigableSet, AbstractMapBasedMultimap<K, V>.k kVar) {
            super(abstractMapBasedMultimap, k, navigableSet, kVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {abstractMapBasedMultimap, k, navigableSet, kVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((AbstractMapBasedMultimap) objArr2[0], objArr2[1], (SortedSet) objArr2[2], (k) objArr2[3]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.k = abstractMapBasedMultimap;
        }

        @Override // java.util.NavigableSet
        public V ceiling(V v) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, v)) == null) ? h().ceiling(v) : (V) invokeL.objValue;
        }

        @Override // java.util.NavigableSet
        public Iterator<V> descendingIterator() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new k.a(this, h().descendingIterator()) : (Iterator) invokeV.objValue;
        }

        @Override // java.util.NavigableSet
        public NavigableSet<V> descendingSet() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? j(h().descendingSet()) : (NavigableSet) invokeV.objValue;
        }

        @Override // java.util.NavigableSet
        public V floor(V v) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, v)) == null) ? h().floor(v) : (V) invokeL.objValue;
        }

        @Override // java.util.NavigableSet
        public NavigableSet<V> headSet(V v, boolean z) {
            InterceptResult invokeLZ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048581, this, v, z)) == null) ? j(h().headSet(v, z)) : (NavigableSet) invokeLZ.objValue;
        }

        @Override // java.util.NavigableSet
        public V higher(V v) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, v)) == null) ? h().higher(v) : (V) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.AbstractMapBasedMultimap.o
        /* renamed from: i */
        public NavigableSet<V> h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? (NavigableSet) super.h() : (NavigableSet) invokeV.objValue;
        }

        public final NavigableSet<V> j(NavigableSet<V> navigableSet) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, navigableSet)) == null) {
                return new m(this.k, this.f54573e, navigableSet, c() == null ? this : c());
            }
            return (NavigableSet) invokeL.objValue;
        }

        @Override // java.util.NavigableSet
        public V lower(V v) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, v)) == null) ? h().lower(v) : (V) invokeL.objValue;
        }

        @Override // java.util.NavigableSet
        public V pollFirst() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? (V) Iterators.t(iterator()) : (V) invokeV.objValue;
        }

        @Override // java.util.NavigableSet
        public V pollLast() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? (V) Iterators.t(descendingIterator()) : (V) invokeV.objValue;
        }

        @Override // java.util.NavigableSet
        public NavigableSet<V> subSet(V v, boolean z, V v2, boolean z2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{v, Boolean.valueOf(z), v2, Boolean.valueOf(z2)})) == null) ? j(h().subSet(v, z, v2, z2)) : (NavigableSet) invokeCommon.objValue;
        }

        @Override // java.util.NavigableSet
        public NavigableSet<V> tailSet(V v, boolean z) {
            InterceptResult invokeLZ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048589, this, v, z)) == null) ? j(h().tailSet(v, z)) : (NavigableSet) invokeLZ.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class n extends AbstractMapBasedMultimap<K, V>.k implements Set<V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ AbstractMapBasedMultimap f54583j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n(AbstractMapBasedMultimap abstractMapBasedMultimap, K k, Set<V> set) {
            super(abstractMapBasedMultimap, k, set, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {abstractMapBasedMultimap, k, set};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((AbstractMapBasedMultimap) objArr2[0], objArr2[1], (Collection) objArr2[2], (k) objArr2[3]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54583j = abstractMapBasedMultimap;
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.k, java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, collection)) == null) {
                if (collection.isEmpty()) {
                    return false;
                }
                int size = size();
                boolean k = Sets.k((Set) this.f54574f, collection);
                if (k) {
                    int size2 = this.f54574f.size();
                    this.f54583j.totalSize += size2 - size;
                    g();
                }
                return k;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class o extends AbstractMapBasedMultimap<K, V>.k implements SortedSet<V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ AbstractMapBasedMultimap f54584j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o(AbstractMapBasedMultimap abstractMapBasedMultimap, K k, SortedSet<V> sortedSet, AbstractMapBasedMultimap<K, V>.k kVar) {
            super(abstractMapBasedMultimap, k, sortedSet, kVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {abstractMapBasedMultimap, k, sortedSet, kVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((AbstractMapBasedMultimap) objArr2[0], objArr2[1], (Collection) objArr2[2], (k) objArr2[3]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54584j = abstractMapBasedMultimap;
        }

        @Override // java.util.SortedSet
        public Comparator<? super V> comparator() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? h().comparator() : (Comparator) invokeV.objValue;
        }

        @Override // java.util.SortedSet
        public V first() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                f();
                return h().first();
            }
            return (V) invokeV.objValue;
        }

        public SortedSet<V> h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? (SortedSet) d() : (SortedSet) invokeV.objValue;
        }

        @Override // java.util.SortedSet
        public SortedSet<V> headSet(V v) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, v)) == null) {
                f();
                return new o(this.f54584j, e(), h().headSet(v), c() == null ? this : c());
            }
            return (SortedSet) invokeL.objValue;
        }

        @Override // java.util.SortedSet
        public V last() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                f();
                return h().last();
            }
            return (V) invokeV.objValue;
        }

        @Override // java.util.SortedSet
        public SortedSet<V> subSet(V v, V v2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, v, v2)) == null) {
                f();
                return new o(this.f54584j, e(), h().subSet(v, v2), c() == null ? this : c());
            }
            return (SortedSet) invokeLL.objValue;
        }

        @Override // java.util.SortedSet
        public SortedSet<V> tailSet(V v) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, v)) == null) {
                f();
                return new o(this.f54584j, e(), h().tailSet(v), c() == null ? this : c());
            }
            return (SortedSet) invokeL.objValue;
        }
    }

    public AbstractMapBasedMultimap(Map<K, Collection<V>> map) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {map};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        c.i.d.a.n.d(map.isEmpty());
        this.map = map;
    }

    public static /* synthetic */ int access$208(AbstractMapBasedMultimap abstractMapBasedMultimap) {
        int i2 = abstractMapBasedMultimap.totalSize;
        abstractMapBasedMultimap.totalSize = i2 + 1;
        return i2;
    }

    public static /* synthetic */ int access$210(AbstractMapBasedMultimap abstractMapBasedMultimap) {
        int i2 = abstractMapBasedMultimap.totalSize;
        abstractMapBasedMultimap.totalSize = i2 - 1;
        return i2;
    }

    private Collection<V> getOrCreateCollection(K k2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, this, k2)) == null) {
            Collection<V> collection = this.map.get(k2);
            if (collection == null) {
                Collection<V> createCollection = createCollection(k2);
                this.map.put(k2, createCollection);
                return createCollection;
            }
            return collection;
        }
        return (Collection) invokeL.objValue;
    }

    public static <E> Iterator<E> iteratorOrListIterator(Collection<E> collection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, collection)) == null) {
            if (collection instanceof List) {
                return ((List) collection).listIterator();
            }
            return collection.iterator();
        }
        return (Iterator) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeValuesForKey(Object obj) {
        Collection collection;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65546, this, obj) == null) || (collection = (Collection) Maps.B(this.map, obj)) == null) {
            return;
        }
        int size = collection.size();
        collection.clear();
        this.totalSize -= size;
    }

    public Map<K, Collection<V>> backingMap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.map : (Map) invokeV.objValue;
    }

    @Override // c.i.d.c.q0
    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            for (Collection<V> collection : this.map.values()) {
                collection.clear();
            }
            this.map.clear();
            this.totalSize = 0;
        }
    }

    @Override // c.i.d.c.q0
    public boolean containsKey(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) ? this.map.containsKey(obj) : invokeL.booleanValue;
    }

    @Override // c.i.d.c.c
    public Map<K, Collection<V>> createAsMap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? new c(this, this.map) : (Map) invokeV.objValue;
    }

    public abstract Collection<V> createCollection();

    public Collection<V> createCollection(K k2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, k2)) == null) ? createCollection() : (Collection) invokeL.objValue;
    }

    @Override // c.i.d.c.c
    public Collection<Map.Entry<K, V>> createEntries() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this instanceof e1) {
                return new c.b(this);
            }
            return new c.a(this);
        }
        return (Collection) invokeV.objValue;
    }

    @Override // c.i.d.c.c
    public Set<K> createKeySet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? new e(this, this.map) : (Set) invokeV.objValue;
    }

    @Override // c.i.d.c.c
    public s0<K> createKeys() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? new Multimaps.c(this) : (s0) invokeV.objValue;
    }

    public final Map<K, Collection<V>> createMaybeNavigableAsMap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            Map<K, Collection<V>> map = this.map;
            if (map instanceof NavigableMap) {
                return new f(this, (NavigableMap) this.map);
            }
            if (map instanceof SortedMap) {
                return new i(this, (SortedMap) this.map);
            }
            return new c(this, this.map);
        }
        return (Map) invokeV.objValue;
    }

    public final Set<K> createMaybeNavigableKeySet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            Map<K, Collection<V>> map = this.map;
            if (map instanceof NavigableMap) {
                return new g(this, (NavigableMap) this.map);
            }
            if (map instanceof SortedMap) {
                return new j(this, (SortedMap) this.map);
            }
            return new e(this, this.map);
        }
        return (Set) invokeV.objValue;
    }

    /* JADX DEBUG: Type inference failed for r0v2. Raw type applied. Possible types: java.util.Collection<V>, java.util.Collection<E> */
    public Collection<V> createUnmodifiableEmptyCollection() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? (Collection<V>) unmodifiableCollectionSubclass(createCollection()) : (Collection) invokeV.objValue;
    }

    @Override // c.i.d.c.c
    public Collection<V> createValues() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? new c.C1679c(this) : (Collection) invokeV.objValue;
    }

    @Override // c.i.d.c.c, c.i.d.c.q0
    public Collection<Map.Entry<K, V>> entries() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? super.entries() : (Collection) invokeV.objValue;
    }

    @Override // c.i.d.c.c
    public Iterator<Map.Entry<K, V>> entryIterator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? new b(this) : (Iterator) invokeV.objValue;
    }

    @Override // c.i.d.c.q0
    public Collection<V> get(K k2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, k2)) == null) {
            Collection<V> collection = this.map.get(k2);
            if (collection == null) {
                collection = createCollection(k2);
            }
            return wrapCollection(k2, collection);
        }
        return (Collection) invokeL.objValue;
    }

    @Override // c.i.d.c.c, c.i.d.c.q0
    public boolean put(K k2, V v) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048592, this, k2, v)) == null) {
            Collection<V> collection = this.map.get(k2);
            if (collection == null) {
                Collection<V> createCollection = createCollection(k2);
                if (createCollection.add(v)) {
                    this.totalSize++;
                    this.map.put(k2, createCollection);
                    return true;
                }
                throw new AssertionError("New Collection violated the Collection spec");
            } else if (collection.add(v)) {
                this.totalSize++;
                return true;
            } else {
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    @Override // c.i.d.c.q0
    public Collection<V> removeAll(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, obj)) == null) {
            Collection<V> remove = this.map.remove(obj);
            if (remove == null) {
                return createUnmodifiableEmptyCollection();
            }
            Collection createCollection = createCollection();
            createCollection.addAll(remove);
            this.totalSize -= remove.size();
            remove.clear();
            return (Collection<V>) unmodifiableCollectionSubclass(createCollection);
        }
        return (Collection) invokeL.objValue;
    }

    @Override // c.i.d.c.c, c.i.d.c.q0
    public Collection<V> replaceValues(K k2, Iterable<? extends V> iterable) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048594, this, k2, iterable)) == null) {
            Iterator<? extends V> it = iterable.iterator();
            if (!it.hasNext()) {
                return removeAll(k2);
            }
            Collection<V> orCreateCollection = getOrCreateCollection(k2);
            Collection createCollection = createCollection();
            createCollection.addAll(orCreateCollection);
            this.totalSize -= orCreateCollection.size();
            orCreateCollection.clear();
            while (it.hasNext()) {
                if (orCreateCollection.add(it.next())) {
                    this.totalSize++;
                }
            }
            return (Collection<V>) unmodifiableCollectionSubclass(createCollection);
        }
        return (Collection) invokeLL.objValue;
    }

    public final void setMap(Map<K, Collection<V>> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, map) == null) {
            this.map = map;
            this.totalSize = 0;
            for (Collection<V> collection : map.values()) {
                c.i.d.a.n.d(!collection.isEmpty());
                this.totalSize += collection.size();
            }
        }
    }

    @Override // c.i.d.c.q0
    public int size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.totalSize : invokeV.intValue;
    }

    public <E> Collection<E> unmodifiableCollectionSubclass(Collection<E> collection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, collection)) == null) ? Collections.unmodifiableCollection(collection) : (Collection) invokeL.objValue;
    }

    @Override // c.i.d.c.c
    public Iterator<V> valueIterator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? new a(this) : (Iterator) invokeV.objValue;
    }

    @Override // c.i.d.c.c, c.i.d.c.q0
    public Collection<V> values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? super.values() : (Collection) invokeV.objValue;
    }

    public Collection<V> wrapCollection(K k2, Collection<V> collection) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048600, this, k2, collection)) == null) ? new k(this, k2, collection, null) : (Collection) invokeLL.objValue;
    }

    public final List<V> wrapList(K k2, List<V> list, AbstractMapBasedMultimap<K, V>.k kVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048601, this, k2, list, kVar)) == null) ? list instanceof RandomAccess ? new h(this, k2, list, kVar) : new l(this, k2, list, kVar) : (List) invokeLLL.objValue;
    }

    /* loaded from: classes3.dex */
    public class k extends AbstractCollection<V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final K f54573e;

        /* renamed from: f  reason: collision with root package name */
        public Collection<V> f54574f;

        /* renamed from: g  reason: collision with root package name */
        public final AbstractMapBasedMultimap<K, V>.k f54575g;

        /* renamed from: h  reason: collision with root package name */
        public final Collection<V> f54576h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ AbstractMapBasedMultimap f54577i;

        public k(AbstractMapBasedMultimap abstractMapBasedMultimap, K k, Collection<V> collection, AbstractMapBasedMultimap<K, V>.k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {abstractMapBasedMultimap, k, collection, kVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54577i = abstractMapBasedMultimap;
            this.f54573e = k;
            this.f54574f = collection;
            this.f54575g = kVar;
            this.f54576h = kVar == null ? null : kVar.d();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean add(V v) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, v)) == null) {
                f();
                boolean isEmpty = this.f54574f.isEmpty();
                boolean add = this.f54574f.add(v);
                if (add) {
                    AbstractMapBasedMultimap.access$208(this.f54577i);
                    if (isEmpty) {
                        b();
                    }
                }
                return add;
            }
            return invokeL.booleanValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean addAll(Collection<? extends V> collection) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, collection)) == null) {
                if (collection.isEmpty()) {
                    return false;
                }
                int size = size();
                boolean addAll = this.f54574f.addAll(collection);
                if (addAll) {
                    int size2 = this.f54574f.size();
                    this.f54577i.totalSize += size2 - size;
                    if (size == 0) {
                        b();
                    }
                }
                return addAll;
            }
            return invokeL.booleanValue;
        }

        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                AbstractMapBasedMultimap<K, V>.k kVar = this.f54575g;
                if (kVar == null) {
                    this.f54577i.map.put(this.f54573e, this.f54574f);
                } else {
                    kVar.b();
                }
            }
        }

        public AbstractMapBasedMultimap<K, V>.k c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f54575g : (k) invokeV.objValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            int size;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (size = size()) == 0) {
                return;
            }
            this.f54574f.clear();
            this.f54577i.totalSize -= size;
            g();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
                f();
                return this.f54574f.contains(obj);
            }
            return invokeL.booleanValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, collection)) == null) {
                f();
                return this.f54574f.containsAll(collection);
            }
            return invokeL.booleanValue;
        }

        public Collection<V> d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f54574f : (Collection) invokeV.objValue;
        }

        public K e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f54573e : (K) invokeV.objValue;
        }

        @Override // java.util.Collection
        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, obj)) == null) {
                if (obj == this) {
                    return true;
                }
                f();
                return this.f54574f.equals(obj);
            }
            return invokeL.booleanValue;
        }

        public void f() {
            Collection<V> collection;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
                AbstractMapBasedMultimap<K, V>.k kVar = this.f54575g;
                if (kVar != null) {
                    kVar.f();
                    if (this.f54575g.d() != this.f54576h) {
                        throw new ConcurrentModificationException();
                    }
                } else if (!this.f54574f.isEmpty() || (collection = (Collection) this.f54577i.map.get(this.f54573e)) == null) {
                } else {
                    this.f54574f = collection;
                }
            }
        }

        public void g() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
                AbstractMapBasedMultimap<K, V>.k kVar = this.f54575g;
                if (kVar != null) {
                    kVar.g();
                } else if (this.f54574f.isEmpty()) {
                    this.f54577i.map.remove(this.f54573e);
                }
            }
        }

        @Override // java.util.Collection
        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
                f();
                return this.f54574f.hashCode();
            }
            return invokeV.intValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
                f();
                return new a(this);
            }
            return (Iterator) invokeV.objValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, obj)) == null) {
                f();
                boolean remove = this.f54574f.remove(obj);
                if (remove) {
                    AbstractMapBasedMultimap.access$210(this.f54577i);
                    g();
                }
                return remove;
            }
            return invokeL.booleanValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, collection)) == null) {
                if (collection.isEmpty()) {
                    return false;
                }
                int size = size();
                boolean removeAll = this.f54574f.removeAll(collection);
                if (removeAll) {
                    int size2 = this.f54574f.size();
                    this.f54577i.totalSize += size2 - size;
                    g();
                }
                return removeAll;
            }
            return invokeL.booleanValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, collection)) == null) {
                c.i.d.a.n.p(collection);
                int size = size();
                boolean retainAll = this.f54574f.retainAll(collection);
                if (retainAll) {
                    int size2 = this.f54574f.size();
                    this.f54577i.totalSize += size2 - size;
                    g();
                }
                return retainAll;
            }
            return invokeL.booleanValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
                f();
                return this.f54574f.size();
            }
            return invokeV.intValue;
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
                f();
                return this.f54574f.toString();
            }
            return (String) invokeV.objValue;
        }

        /* loaded from: classes3.dex */
        public class a implements Iterator<V> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final Iterator<V> f54578e;

            /* renamed from: f  reason: collision with root package name */
            public final Collection<V> f54579f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ k f54580g;

            public a(k kVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {kVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f54580g = kVar;
                this.f54579f = this.f54580g.f54574f;
                this.f54578e = AbstractMapBasedMultimap.iteratorOrListIterator(kVar.f54574f);
            }

            public Iterator<V> a() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    b();
                    return this.f54578e;
                }
                return (Iterator) invokeV.objValue;
            }

            public void b() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.f54580g.f();
                    if (this.f54580g.f54574f != this.f54579f) {
                        throw new ConcurrentModificationException();
                    }
                }
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                    b();
                    return this.f54578e.hasNext();
                }
                return invokeV.booleanValue;
            }

            @Override // java.util.Iterator
            public V next() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                    b();
                    return this.f54578e.next();
                }
                return (V) invokeV.objValue;
            }

            @Override // java.util.Iterator
            public void remove() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                    this.f54578e.remove();
                    AbstractMapBasedMultimap.access$210(this.f54580g.f54577i);
                    this.f54580g.g();
                }
            }

            public a(k kVar, Iterator<V> it) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {kVar, it};
                    interceptable.invokeUnInit(65537, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65537, newInitContext);
                        return;
                    }
                }
                this.f54580g = kVar;
                this.f54579f = this.f54580g.f54574f;
                this.f54578e = it;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class l extends AbstractMapBasedMultimap<K, V>.k implements List<V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ AbstractMapBasedMultimap f54581j;

        /* loaded from: classes3.dex */
        public class a extends AbstractMapBasedMultimap<K, V>.k.a implements ListIterator<V> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ l f54582h;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(l lVar) {
                super(lVar);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {lVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        super((k) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f54582h = lVar;
            }

            @Override // java.util.ListIterator
            public void add(V v) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, v) == null) {
                    boolean isEmpty = this.f54582h.isEmpty();
                    c().add(v);
                    AbstractMapBasedMultimap.access$208(this.f54582h.f54581j);
                    if (isEmpty) {
                        this.f54582h.b();
                    }
                }
            }

            public final ListIterator<V> c() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (ListIterator) a() : (ListIterator) invokeV.objValue;
            }

            @Override // java.util.ListIterator
            public boolean hasPrevious() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? c().hasPrevious() : invokeV.booleanValue;
            }

            @Override // java.util.ListIterator
            public int nextIndex() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? c().nextIndex() : invokeV.intValue;
            }

            @Override // java.util.ListIterator
            public V previous() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? c().previous() : (V) invokeV.objValue;
            }

            @Override // java.util.ListIterator
            public int previousIndex() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? c().previousIndex() : invokeV.intValue;
            }

            @Override // java.util.ListIterator
            public void set(V v) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048582, this, v) == null) {
                    c().set(v);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(l lVar, int i2) {
                super(lVar, lVar.h().listIterator(i2));
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {lVar, Integer.valueOf(i2)};
                    interceptable.invokeUnInit(65537, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        Object[] objArr2 = newInitContext.callArgs;
                        super((k) objArr2[0], (Iterator) objArr2[1]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65537, newInitContext);
                        return;
                    }
                }
                this.f54582h = lVar;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(AbstractMapBasedMultimap abstractMapBasedMultimap, K k, List<V> list, AbstractMapBasedMultimap<K, V>.k kVar) {
            super(abstractMapBasedMultimap, k, list, kVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {abstractMapBasedMultimap, k, list, kVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((AbstractMapBasedMultimap) objArr2[0], objArr2[1], (Collection) objArr2[2], (k) objArr2[3]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54581j = abstractMapBasedMultimap;
        }

        @Override // java.util.List
        public void add(int i2, V v) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, v) == null) {
                f();
                boolean isEmpty = d().isEmpty();
                h().add(i2, v);
                AbstractMapBasedMultimap.access$208(this.f54581j);
                if (isEmpty) {
                    b();
                }
            }
        }

        @Override // java.util.List
        public boolean addAll(int i2, Collection<? extends V> collection) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, collection)) == null) {
                if (collection.isEmpty()) {
                    return false;
                }
                int size = size();
                boolean addAll = h().addAll(i2, collection);
                if (addAll) {
                    int size2 = d().size();
                    this.f54581j.totalSize += size2 - size;
                    if (size == 0) {
                        b();
                    }
                }
                return addAll;
            }
            return invokeIL.booleanValue;
        }

        @Override // java.util.List
        public V get(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
                f();
                return h().get(i2);
            }
            return (V) invokeI.objValue;
        }

        public List<V> h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (List) d() : (List) invokeV.objValue;
        }

        @Override // java.util.List
        public int indexOf(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, obj)) == null) {
                f();
                return h().indexOf(obj);
            }
            return invokeL.intValue;
        }

        @Override // java.util.List
        public int lastIndexOf(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
                f();
                return h().lastIndexOf(obj);
            }
            return invokeL.intValue;
        }

        @Override // java.util.List
        public ListIterator<V> listIterator() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                f();
                return new a(this);
            }
            return (ListIterator) invokeV.objValue;
        }

        @Override // java.util.List
        public V remove(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
                f();
                V remove = h().remove(i2);
                AbstractMapBasedMultimap.access$210(this.f54581j);
                g();
                return remove;
            }
            return (V) invokeI.objValue;
        }

        @Override // java.util.List
        public V set(int i2, V v) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(1048585, this, i2, v)) == null) {
                f();
                return h().set(i2, v);
            }
            return (V) invokeIL.objValue;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: com.google.common.collect.AbstractMapBasedMultimap */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.List
        public List<V> subList(int i2, int i3) {
            InterceptResult invokeII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeII = interceptable.invokeII(1048586, this, i2, i3)) == null) {
                f();
                return this.f54581j.wrapList(e(), h().subList(i2, i3), c() == null ? this : c());
            }
            return (List) invokeII.objValue;
        }

        @Override // java.util.List
        public ListIterator<V> listIterator(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
                f();
                return new a(this, i2);
            }
            return (ListIterator) invokeI.objValue;
        }
    }
}
