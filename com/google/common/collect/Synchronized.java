package com.google.common.collect;

import androidx.core.view.InputDeviceCompat;
import b.h.d.a.g;
import b.h.d.a.n;
import b.h.d.c.e0;
import b.h.d.c.e1;
import b.h.d.c.j1;
import b.h.d.c.k;
import b.h.d.c.k1;
import b.h.d.c.m1;
import b.h.d.c.p0;
import b.h.d.c.q0;
import b.h.d.c.s0;
import b.h.d.c.u0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Queue;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
/* loaded from: classes11.dex */
public final class Synchronized {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes11.dex */
    public static class SynchronizedAsMap<K, V> extends SynchronizedMap<K, Collection<V>> {
        public static /* synthetic */ Interceptable $ic;
        public static final long serialVersionUID = 0;
        public transient /* synthetic */ FieldHolder $fh;
        public transient Set<Map.Entry<K, Collection<V>>> asMapEntrySet;
        public transient Collection<Collection<V>> asMapValues;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SynchronizedAsMap(Map<K, Collection<V>> map, Object obj) {
            super(map, obj);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {map, obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Map) objArr2[0], objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMap, java.util.Map
        public boolean containsValue(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) ? values().contains(obj) : invokeL.booleanValue;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMap, java.util.Map
        public Set<Map.Entry<K, Collection<V>>> entrySet() {
            InterceptResult invokeV;
            Set<Map.Entry<K, Collection<V>>> set;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                synchronized (this.mutex) {
                    if (this.asMapEntrySet == null) {
                        this.asMapEntrySet = new SynchronizedAsMapEntries(delegate().entrySet(), this.mutex);
                    }
                    set = this.asMapEntrySet;
                }
                return set;
            }
            return (Set) invokeV.objValue;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMap, java.util.Map
        public Collection<Collection<V>> values() {
            InterceptResult invokeV;
            Collection<Collection<V>> collection;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                synchronized (this.mutex) {
                    if (this.asMapValues == null) {
                        this.asMapValues = new SynchronizedAsMapValues(delegate().values(), this.mutex);
                    }
                    collection = this.asMapValues;
                }
                return collection;
            }
            return (Collection) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.Synchronized.SynchronizedMap, java.util.Map
        public Collection<V> get(Object obj) {
            InterceptResult invokeL;
            Collection<V> q;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
                synchronized (this.mutex) {
                    Collection collection = (Collection) super.get(obj);
                    q = collection == null ? null : Synchronized.q(collection, this.mutex);
                }
                return q;
            }
            return (Collection) invokeL.objValue;
        }
    }

    /* loaded from: classes11.dex */
    public static class SynchronizedAsMapValues<V> extends SynchronizedCollection<Collection<V>> {
        public static /* synthetic */ Interceptable $ic;
        public static final long serialVersionUID = 0;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes11.dex */
        public class a extends m1<Collection<V>, Collection<V>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ SynchronizedAsMapValues f64485f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(SynchronizedAsMapValues synchronizedAsMapValues, Iterator it) {
                super(it);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {synchronizedAsMapValues, it};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        super((Iterator) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f64485f = synchronizedAsMapValues;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // b.h.d.c.m1
            /* renamed from: b */
            public Collection<V> a(Collection<V> collection) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, collection)) == null) ? Synchronized.q(collection, this.f64485f.mutex) : (Collection) invokeL.objValue;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SynchronizedAsMapValues(Collection<Collection<V>> collection, Object obj) {
            super(collection, obj, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {collection, obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Collection) objArr2[0], objArr2[1], (a) objArr2[2]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Collection<V>> iterator() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new a(this, super.iterator()) : (Iterator) invokeV.objValue;
        }
    }

    /* loaded from: classes11.dex */
    public static class SynchronizedBiMap<K, V> extends SynchronizedMap<K, V> implements k<K, V>, Serializable {
        public static /* synthetic */ Interceptable $ic;
        public static final long serialVersionUID = 0;
        public transient /* synthetic */ FieldHolder $fh;
        public transient k<V, K> inverse;
        public transient Set<V> valueSet;

        public /* synthetic */ SynchronizedBiMap(k kVar, Object obj, k kVar2, a aVar) {
            this(kVar, obj, kVar2);
        }

        @Override // b.h.d.c.k
        public V forcePut(K k, V v) {
            InterceptResult invokeLL;
            V forcePut;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, k, v)) == null) {
                synchronized (this.mutex) {
                    forcePut = delegate().forcePut(k, v);
                }
                return forcePut;
            }
            return (V) invokeLL.objValue;
        }

        @Override // b.h.d.c.k
        public k<V, K> inverse() {
            InterceptResult invokeV;
            k<V, K> kVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                synchronized (this.mutex) {
                    if (this.inverse == null) {
                        this.inverse = new SynchronizedBiMap(delegate().inverse(), this.mutex, this);
                    }
                    kVar = this.inverse;
                }
                return kVar;
            }
            return (k) invokeV.objValue;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SynchronizedBiMap(k<K, V> kVar, Object obj, k<V, K> kVar2) {
            super(kVar, obj);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar, obj, kVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Map) objArr2[0], objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.inverse = kVar2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.Synchronized.SynchronizedMap, java.util.Map
        public Set<V> values() {
            InterceptResult invokeV;
            Set<V> set;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                synchronized (this.mutex) {
                    if (this.valueSet == null) {
                        this.valueSet = Synchronized.n(delegate().values(), this.mutex);
                    }
                    set = this.valueSet;
                }
                return set;
            }
            return (Set) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.Synchronized.SynchronizedMap, com.google.common.collect.Synchronized.SynchronizedObject
        public k<K, V> delegate() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (k) super.delegate() : (k) invokeV.objValue;
        }
    }

    /* loaded from: classes11.dex */
    public static class SynchronizedCollection<E> extends SynchronizedObject implements Collection<E> {
        public static /* synthetic */ Interceptable $ic;
        public static final long serialVersionUID = 0;
        public transient /* synthetic */ FieldHolder $fh;

        public /* synthetic */ SynchronizedCollection(Collection collection, Object obj, a aVar) {
            this(collection, obj);
        }

        @Override // java.util.Collection
        public boolean add(E e2) {
            InterceptResult invokeL;
            boolean add;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, e2)) == null) {
                synchronized (this.mutex) {
                    add = delegate().add(e2);
                }
                return add;
            }
            return invokeL.booleanValue;
        }

        @Override // java.util.Collection
        public boolean addAll(Collection<? extends E> collection) {
            InterceptResult invokeL;
            boolean addAll;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, collection)) == null) {
                synchronized (this.mutex) {
                    addAll = delegate().addAll(collection);
                }
                return addAll;
            }
            return invokeL.booleanValue;
        }

        @Override // java.util.Collection
        public void clear() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                synchronized (this.mutex) {
                    delegate().clear();
                }
            }
        }

        public boolean contains(Object obj) {
            InterceptResult invokeL;
            boolean contains;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
                synchronized (this.mutex) {
                    contains = delegate().contains(obj);
                }
                return contains;
            }
            return invokeL.booleanValue;
        }

        public boolean containsAll(Collection<?> collection) {
            InterceptResult invokeL;
            boolean containsAll;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, collection)) == null) {
                synchronized (this.mutex) {
                    containsAll = delegate().containsAll(collection);
                }
                return containsAll;
            }
            return invokeL.booleanValue;
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            InterceptResult invokeV;
            boolean isEmpty;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                synchronized (this.mutex) {
                    isEmpty = delegate().isEmpty();
                }
                return isEmpty;
            }
            return invokeV.booleanValue;
        }

        public Iterator<E> iterator() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? delegate().iterator() : (Iterator) invokeV.objValue;
        }

        public boolean remove(Object obj) {
            InterceptResult invokeL;
            boolean remove;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, obj)) == null) {
                synchronized (this.mutex) {
                    remove = delegate().remove(obj);
                }
                return remove;
            }
            return invokeL.booleanValue;
        }

        public boolean removeAll(Collection<?> collection) {
            InterceptResult invokeL;
            boolean removeAll;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, collection)) == null) {
                synchronized (this.mutex) {
                    removeAll = delegate().removeAll(collection);
                }
                return removeAll;
            }
            return invokeL.booleanValue;
        }

        public boolean retainAll(Collection<?> collection) {
            InterceptResult invokeL;
            boolean retainAll;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, collection)) == null) {
                synchronized (this.mutex) {
                    retainAll = delegate().retainAll(collection);
                }
                return retainAll;
            }
            return invokeL.booleanValue;
        }

        @Override // java.util.Collection
        public int size() {
            InterceptResult invokeV;
            int size;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
                synchronized (this.mutex) {
                    size = delegate().size();
                }
                return size;
            }
            return invokeV.intValue;
        }

        public Object[] toArray() {
            InterceptResult invokeV;
            Object[] array;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
                synchronized (this.mutex) {
                    array = delegate().toArray();
                }
                return array;
            }
            return (Object[]) invokeV.objValue;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SynchronizedCollection(Collection<E> collection, Object obj) {
            super(collection, obj);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {collection, obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(objArr2[0], objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.Synchronized.SynchronizedObject
        public Collection<E> delegate() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? (Collection) super.delegate() : (Collection) invokeV.objValue;
        }

        public <T> T[] toArray(T[] tArr) {
            InterceptResult invokeL;
            T[] tArr2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, tArr)) == null) {
                synchronized (this.mutex) {
                    tArr2 = (T[]) delegate().toArray(tArr);
                }
                return tArr2;
            }
            return (T[]) ((Object[]) invokeL.objValue);
        }
    }

    /* loaded from: classes11.dex */
    public static class SynchronizedEntry<K, V> extends SynchronizedObject implements Map.Entry<K, V> {
        public static /* synthetic */ Interceptable $ic;
        public static final long serialVersionUID = 0;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SynchronizedEntry(Map.Entry<K, V> entry, Object obj) {
            super(entry, obj);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {entry, obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(objArr2[0], objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            InterceptResult invokeL;
            boolean equals;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) {
                synchronized (this.mutex) {
                    equals = delegate().equals(obj);
                }
                return equals;
            }
            return invokeL.booleanValue;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            InterceptResult invokeV;
            K key;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                synchronized (this.mutex) {
                    key = delegate().getKey();
                }
                return key;
            }
            return (K) invokeV.objValue;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            InterceptResult invokeV;
            V value;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                synchronized (this.mutex) {
                    value = delegate().getValue();
                }
                return value;
            }
            return (V) invokeV.objValue;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            InterceptResult invokeV;
            int hashCode;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                synchronized (this.mutex) {
                    hashCode = delegate().hashCode();
                }
                return hashCode;
            }
            return invokeV.intValue;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            InterceptResult invokeL;
            V value;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, v)) == null) {
                synchronized (this.mutex) {
                    value = delegate().setValue(v);
                }
                return value;
            }
            return (V) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.Synchronized.SynchronizedObject
        public Map.Entry<K, V> delegate() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (Map.Entry) super.delegate() : (Map.Entry) invokeV.objValue;
        }
    }

    /* loaded from: classes11.dex */
    public static class SynchronizedList<E> extends SynchronizedCollection<E> implements List<E> {
        public static /* synthetic */ Interceptable $ic;
        public static final long serialVersionUID = 0;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SynchronizedList(List<E> list, Object obj) {
            super(list, obj, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {list, obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Collection) objArr2[0], objArr2[1], (a) objArr2[2]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // java.util.List
        public void add(int i2, E e2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, e2) == null) {
                synchronized (this.mutex) {
                    delegate().add(i2, e2);
                }
            }
        }

        @Override // java.util.List
        public boolean addAll(int i2, Collection<? extends E> collection) {
            InterceptResult invokeIL;
            boolean addAll;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, collection)) == null) {
                synchronized (this.mutex) {
                    addAll = delegate().addAll(i2, collection);
                }
                return addAll;
            }
            return invokeIL.booleanValue;
        }

        @Override // java.util.Collection, java.util.List
        public boolean equals(Object obj) {
            InterceptResult invokeL;
            boolean equals;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
                if (obj == this) {
                    return true;
                }
                synchronized (this.mutex) {
                    equals = delegate().equals(obj);
                }
                return equals;
            }
            return invokeL.booleanValue;
        }

        @Override // java.util.List
        public E get(int i2) {
            InterceptResult invokeI;
            E e2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
                synchronized (this.mutex) {
                    e2 = delegate().get(i2);
                }
                return e2;
            }
            return (E) invokeI.objValue;
        }

        @Override // java.util.Collection, java.util.List
        public int hashCode() {
            InterceptResult invokeV;
            int hashCode;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                synchronized (this.mutex) {
                    hashCode = delegate().hashCode();
                }
                return hashCode;
            }
            return invokeV.intValue;
        }

        @Override // java.util.List
        public int indexOf(Object obj) {
            InterceptResult invokeL;
            int indexOf;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, obj)) == null) {
                synchronized (this.mutex) {
                    indexOf = delegate().indexOf(obj);
                }
                return indexOf;
            }
            return invokeL.intValue;
        }

        @Override // java.util.List
        public int lastIndexOf(Object obj) {
            InterceptResult invokeL;
            int lastIndexOf;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, obj)) == null) {
                synchronized (this.mutex) {
                    lastIndexOf = delegate().lastIndexOf(obj);
                }
                return lastIndexOf;
            }
            return invokeL.intValue;
        }

        @Override // java.util.List
        public ListIterator<E> listIterator() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? delegate().listIterator() : (ListIterator) invokeV.objValue;
        }

        @Override // java.util.List
        public E remove(int i2) {
            InterceptResult invokeI;
            E remove;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i2)) == null) {
                synchronized (this.mutex) {
                    remove = delegate().remove(i2);
                }
                return remove;
            }
            return (E) invokeI.objValue;
        }

        @Override // java.util.List
        public E set(int i2, E e2) {
            InterceptResult invokeIL;
            E e3;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(1048589, this, i2, e2)) == null) {
                synchronized (this.mutex) {
                    e3 = delegate().set(i2, e2);
                }
                return e3;
            }
            return (E) invokeIL.objValue;
        }

        @Override // java.util.List
        public List<E> subList(int i2, int i3) {
            InterceptResult invokeII;
            List<E> h2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeII = interceptable.invokeII(1048590, this, i2, i3)) == null) {
                synchronized (this.mutex) {
                    h2 = Synchronized.h(delegate().subList(i2, i3), this.mutex);
                }
                return h2;
            }
            return (List) invokeII.objValue;
        }

        @Override // java.util.List
        public ListIterator<E> listIterator(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i2)) == null) ? delegate().listIterator(i2) : (ListIterator) invokeI.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        public List<E> delegate() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? (List) super.delegate() : (List) invokeV.objValue;
        }
    }

    /* loaded from: classes11.dex */
    public static class SynchronizedListMultimap<K, V> extends SynchronizedMultimap<K, V> implements p0<K, V> {
        public static /* synthetic */ Interceptable $ic;
        public static final long serialVersionUID = 0;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SynchronizedListMultimap(p0<K, V> p0Var, Object obj) {
            super(p0Var, obj);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p0Var, obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((q0) objArr2[0], objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, b.h.d.c.q0
        public /* bridge */ /* synthetic */ Collection get(Object obj) {
            return get((SynchronizedListMultimap<K, V>) obj);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, b.h.d.c.q0
        public /* bridge */ /* synthetic */ Collection replaceValues(Object obj, Iterable iterable) {
            return replaceValues((SynchronizedListMultimap<K, V>) obj, iterable);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, b.h.d.c.q0
        public List<V> get(K k) {
            InterceptResult invokeL;
            List<V> h2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, k)) == null) {
                synchronized (this.mutex) {
                    h2 = Synchronized.h(delegate().get((p0<K, V>) k), this.mutex);
                }
                return h2;
            }
            return (List) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, b.h.d.c.q0
        public List<V> removeAll(Object obj) {
            InterceptResult invokeL;
            List<V> removeAll;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, obj)) == null) {
                synchronized (this.mutex) {
                    removeAll = delegate().removeAll(obj);
                }
                return removeAll;
            }
            return (List) invokeL.objValue;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, b.h.d.c.q0
        public List<V> replaceValues(K k, Iterable<? extends V> iterable) {
            InterceptResult invokeLL;
            List<V> replaceValues;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, k, iterable)) == null) {
                synchronized (this.mutex) {
                    replaceValues = delegate().replaceValues((p0<K, V>) k, (Iterable) iterable);
                }
                return replaceValues;
            }
            return (List) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Synchronized.SynchronizedObject
        public p0<K, V> delegate() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (p0) super.delegate() : (p0) invokeV.objValue;
        }
    }

    /* loaded from: classes11.dex */
    public static class SynchronizedMap<K, V> extends SynchronizedObject implements Map<K, V> {
        public static /* synthetic */ Interceptable $ic;
        public static final long serialVersionUID = 0;
        public transient /* synthetic */ FieldHolder $fh;
        public transient Set<Map.Entry<K, V>> entrySet;
        public transient Set<K> keySet;
        public transient Collection<V> values;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SynchronizedMap(Map<K, V> map, Object obj) {
            super(map, obj);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {map, obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(objArr2[0], objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // java.util.Map
        public void clear() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this.mutex) {
                    delegate().clear();
                }
            }
        }

        @Override // java.util.Map
        public boolean containsKey(Object obj) {
            InterceptResult invokeL;
            boolean containsKey;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
                synchronized (this.mutex) {
                    containsKey = delegate().containsKey(obj);
                }
                return containsKey;
            }
            return invokeL.booleanValue;
        }

        public boolean containsValue(Object obj) {
            InterceptResult invokeL;
            boolean containsValue;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) {
                synchronized (this.mutex) {
                    containsValue = delegate().containsValue(obj);
                }
                return containsValue;
            }
            return invokeL.booleanValue;
        }

        public Set<Map.Entry<K, V>> entrySet() {
            InterceptResult invokeV;
            Set<Map.Entry<K, V>> set;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                synchronized (this.mutex) {
                    if (this.entrySet == null) {
                        this.entrySet = Synchronized.n(delegate().entrySet(), this.mutex);
                    }
                    set = this.entrySet;
                }
                return set;
            }
            return (Set) invokeV.objValue;
        }

        @Override // java.util.Map
        public boolean equals(Object obj) {
            InterceptResult invokeL;
            boolean equals;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, obj)) == null) {
                if (obj == this) {
                    return true;
                }
                synchronized (this.mutex) {
                    equals = delegate().equals(obj);
                }
                return equals;
            }
            return invokeL.booleanValue;
        }

        public V get(Object obj) {
            InterceptResult invokeL;
            V v;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, obj)) == null) {
                synchronized (this.mutex) {
                    v = delegate().get(obj);
                }
                return v;
            }
            return (V) invokeL.objValue;
        }

        @Override // java.util.Map
        public int hashCode() {
            InterceptResult invokeV;
            int hashCode;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                synchronized (this.mutex) {
                    hashCode = delegate().hashCode();
                }
                return hashCode;
            }
            return invokeV.intValue;
        }

        @Override // java.util.Map
        public boolean isEmpty() {
            InterceptResult invokeV;
            boolean isEmpty;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                synchronized (this.mutex) {
                    isEmpty = delegate().isEmpty();
                }
                return isEmpty;
            }
            return invokeV.booleanValue;
        }

        @Override // java.util.Map
        public Set<K> keySet() {
            InterceptResult invokeV;
            Set<K> set;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                synchronized (this.mutex) {
                    if (this.keySet == null) {
                        this.keySet = Synchronized.n(delegate().keySet(), this.mutex);
                    }
                    set = this.keySet;
                }
                return set;
            }
            return (Set) invokeV.objValue;
        }

        @Override // java.util.Map
        public V put(K k, V v) {
            InterceptResult invokeLL;
            V put;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, k, v)) == null) {
                synchronized (this.mutex) {
                    put = delegate().put(k, v);
                }
                return put;
            }
            return (V) invokeLL.objValue;
        }

        @Override // java.util.Map
        public void putAll(Map<? extends K, ? extends V> map) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, map) == null) {
                synchronized (this.mutex) {
                    delegate().putAll(map);
                }
            }
        }

        @Override // java.util.Map
        public V remove(Object obj) {
            InterceptResult invokeL;
            V remove;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, obj)) == null) {
                synchronized (this.mutex) {
                    remove = delegate().remove(obj);
                }
                return remove;
            }
            return (V) invokeL.objValue;
        }

        @Override // java.util.Map
        public int size() {
            InterceptResult invokeV;
            int size;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
                synchronized (this.mutex) {
                    size = delegate().size();
                }
                return size;
            }
            return invokeV.intValue;
        }

        public Collection<V> values() {
            InterceptResult invokeV;
            Collection<V> collection;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
                synchronized (this.mutex) {
                    if (this.values == null) {
                        this.values = Synchronized.g(delegate().values(), this.mutex);
                    }
                    collection = this.values;
                }
                return collection;
            }
            return (Collection) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.Synchronized.SynchronizedObject
        public Map<K, V> delegate() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? (Map) super.delegate() : (Map) invokeV.objValue;
        }
    }

    /* loaded from: classes11.dex */
    public static class SynchronizedMultimap<K, V> extends SynchronizedObject implements q0<K, V> {
        public static /* synthetic */ Interceptable $ic;
        public static final long serialVersionUID = 0;
        public transient /* synthetic */ FieldHolder $fh;
        public transient Map<K, Collection<V>> asMap;
        public transient Collection<Map.Entry<K, V>> entries;
        public transient Set<K> keySet;
        public transient s0<K> keys;
        public transient Collection<V> valuesCollection;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SynchronizedMultimap(q0<K, V> q0Var, Object obj) {
            super(q0Var, obj);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q0Var, obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(objArr2[0], objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // b.h.d.c.q0
        public Map<K, Collection<V>> asMap() {
            InterceptResult invokeV;
            Map<K, Collection<V>> map;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                synchronized (this.mutex) {
                    if (this.asMap == null) {
                        this.asMap = new SynchronizedAsMap(delegate().asMap(), this.mutex);
                    }
                    map = this.asMap;
                }
                return map;
            }
            return (Map) invokeV.objValue;
        }

        @Override // b.h.d.c.q0
        public void clear() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                synchronized (this.mutex) {
                    delegate().clear();
                }
            }
        }

        @Override // b.h.d.c.q0
        public boolean containsEntry(Object obj, Object obj2) {
            InterceptResult invokeLL;
            boolean containsEntry;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, obj, obj2)) == null) {
                synchronized (this.mutex) {
                    containsEntry = delegate().containsEntry(obj, obj2);
                }
                return containsEntry;
            }
            return invokeLL.booleanValue;
        }

        @Override // b.h.d.c.q0
        public boolean containsKey(Object obj) {
            InterceptResult invokeL;
            boolean containsKey;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
                synchronized (this.mutex) {
                    containsKey = delegate().containsKey(obj);
                }
                return containsKey;
            }
            return invokeL.booleanValue;
        }

        @Override // b.h.d.c.q0
        public boolean containsValue(Object obj) {
            InterceptResult invokeL;
            boolean containsValue;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, obj)) == null) {
                synchronized (this.mutex) {
                    containsValue = delegate().containsValue(obj);
                }
                return containsValue;
            }
            return invokeL.booleanValue;
        }

        @Override // b.h.d.c.q0
        public Collection<Map.Entry<K, V>> entries() {
            InterceptResult invokeV;
            Collection<Map.Entry<K, V>> collection;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                synchronized (this.mutex) {
                    if (this.entries == null) {
                        this.entries = Synchronized.q(delegate().entries(), this.mutex);
                    }
                    collection = this.entries;
                }
                return collection;
            }
            return (Collection) invokeV.objValue;
        }

        @Override // b.h.d.c.q0
        public boolean equals(Object obj) {
            InterceptResult invokeL;
            boolean equals;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, obj)) == null) {
                if (obj == this) {
                    return true;
                }
                synchronized (this.mutex) {
                    equals = delegate().equals(obj);
                }
                return equals;
            }
            return invokeL.booleanValue;
        }

        public Collection<V> get(K k) {
            InterceptResult invokeL;
            Collection<V> q;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, k)) == null) {
                synchronized (this.mutex) {
                    q = Synchronized.q(delegate().get(k), this.mutex);
                }
                return q;
            }
            return (Collection) invokeL.objValue;
        }

        @Override // b.h.d.c.q0
        public int hashCode() {
            InterceptResult invokeV;
            int hashCode;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                synchronized (this.mutex) {
                    hashCode = delegate().hashCode();
                }
                return hashCode;
            }
            return invokeV.intValue;
        }

        @Override // b.h.d.c.q0
        public boolean isEmpty() {
            InterceptResult invokeV;
            boolean isEmpty;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                synchronized (this.mutex) {
                    isEmpty = delegate().isEmpty();
                }
                return isEmpty;
            }
            return invokeV.booleanValue;
        }

        @Override // b.h.d.c.q0
        public Set<K> keySet() {
            InterceptResult invokeV;
            Set<K> set;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
                synchronized (this.mutex) {
                    if (this.keySet == null) {
                        this.keySet = Synchronized.r(delegate().keySet(), this.mutex);
                    }
                    set = this.keySet;
                }
                return set;
            }
            return (Set) invokeV.objValue;
        }

        @Override // b.h.d.c.q0
        public s0<K> keys() {
            InterceptResult invokeV;
            s0<K> s0Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
                synchronized (this.mutex) {
                    if (this.keys == null) {
                        this.keys = Synchronized.j(delegate().keys(), this.mutex);
                    }
                    s0Var = this.keys;
                }
                return s0Var;
            }
            return (s0) invokeV.objValue;
        }

        @Override // b.h.d.c.q0
        public boolean put(K k, V v) {
            InterceptResult invokeLL;
            boolean put;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, k, v)) == null) {
                synchronized (this.mutex) {
                    put = delegate().put(k, v);
                }
                return put;
            }
            return invokeLL.booleanValue;
        }

        @Override // b.h.d.c.q0
        public boolean putAll(K k, Iterable<? extends V> iterable) {
            InterceptResult invokeLL;
            boolean putAll;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048592, this, k, iterable)) == null) {
                synchronized (this.mutex) {
                    putAll = delegate().putAll(k, iterable);
                }
                return putAll;
            }
            return invokeLL.booleanValue;
        }

        @Override // b.h.d.c.q0
        public boolean remove(Object obj, Object obj2) {
            InterceptResult invokeLL;
            boolean remove;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048593, this, obj, obj2)) == null) {
                synchronized (this.mutex) {
                    remove = delegate().remove(obj, obj2);
                }
                return remove;
            }
            return invokeLL.booleanValue;
        }

        public Collection<V> removeAll(Object obj) {
            InterceptResult invokeL;
            Collection<V> removeAll;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, obj)) == null) {
                synchronized (this.mutex) {
                    removeAll = delegate().removeAll(obj);
                }
                return removeAll;
            }
            return (Collection) invokeL.objValue;
        }

        public Collection<V> replaceValues(K k, Iterable<? extends V> iterable) {
            InterceptResult invokeLL;
            Collection<V> replaceValues;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048595, this, k, iterable)) == null) {
                synchronized (this.mutex) {
                    replaceValues = delegate().replaceValues(k, iterable);
                }
                return replaceValues;
            }
            return (Collection) invokeLL.objValue;
        }

        @Override // b.h.d.c.q0
        public int size() {
            InterceptResult invokeV;
            int size;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
                synchronized (this.mutex) {
                    size = delegate().size();
                }
                return size;
            }
            return invokeV.intValue;
        }

        @Override // b.h.d.c.q0
        public Collection<V> values() {
            InterceptResult invokeV;
            Collection<V> collection;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
                synchronized (this.mutex) {
                    if (this.valuesCollection == null) {
                        this.valuesCollection = Synchronized.g(delegate().values(), this.mutex);
                    }
                    collection = this.valuesCollection;
                }
                return collection;
            }
            return (Collection) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.Synchronized.SynchronizedObject
        public q0<K, V> delegate() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? (q0) super.delegate() : (q0) invokeV.objValue;
        }

        @Override // b.h.d.c.q0
        public boolean putAll(q0<? extends K, ? extends V> q0Var) {
            InterceptResult invokeL;
            boolean putAll;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, q0Var)) == null) {
                synchronized (this.mutex) {
                    putAll = delegate().putAll(q0Var);
                }
                return putAll;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes11.dex */
    public static class SynchronizedObject implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public static final long serialVersionUID = 0;
        public transient /* synthetic */ FieldHolder $fh;
        public final Object delegate;
        public final Object mutex;

        public SynchronizedObject(Object obj, Object obj2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {obj, obj2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            n.p(obj);
            this.delegate = obj;
            this.mutex = obj2 == null ? this : obj2;
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65537, this, objectOutputStream) == null) {
                synchronized (this.mutex) {
                    objectOutputStream.defaultWriteObject();
                }
            }
        }

        public Object delegate() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.delegate : invokeV.objValue;
        }

        public String toString() {
            InterceptResult invokeV;
            String obj;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                synchronized (this.mutex) {
                    obj = this.delegate.toString();
                }
                return obj;
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes11.dex */
    public static class SynchronizedRandomAccessList<E> extends SynchronizedList<E> implements RandomAccess {
        public static /* synthetic */ Interceptable $ic;
        public static final long serialVersionUID = 0;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SynchronizedRandomAccessList(List<E> list, Object obj) {
            super(list, obj);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {list, obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((List) objArr2[0], objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    /* loaded from: classes11.dex */
    public static class SynchronizedSetMultimap<K, V> extends SynchronizedMultimap<K, V> implements e1<K, V> {
        public static /* synthetic */ Interceptable $ic;
        public static final long serialVersionUID = 0;
        public transient /* synthetic */ FieldHolder $fh;
        public transient Set<Map.Entry<K, V>> entrySet;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SynchronizedSetMultimap(e1<K, V> e1Var, Object obj) {
            super(e1Var, obj);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e1Var, obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((q0) objArr2[0], objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, b.h.d.c.q0
        public /* bridge */ /* synthetic */ Collection get(Object obj) {
            return get((SynchronizedSetMultimap<K, V>) obj);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, b.h.d.c.q0
        public /* bridge */ /* synthetic */ Collection replaceValues(Object obj, Iterable iterable) {
            return replaceValues((SynchronizedSetMultimap<K, V>) obj, iterable);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, b.h.d.c.q0
        public Set<Map.Entry<K, V>> entries() {
            InterceptResult invokeV;
            Set<Map.Entry<K, V>> set;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                synchronized (this.mutex) {
                    if (this.entrySet == null) {
                        this.entrySet = Synchronized.n(delegate().entries(), this.mutex);
                    }
                    set = this.entrySet;
                }
                return set;
            }
            return (Set) invokeV.objValue;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, b.h.d.c.q0
        public Set<V> get(K k) {
            InterceptResult invokeL;
            Set<V> n;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, k)) == null) {
                synchronized (this.mutex) {
                    n = Synchronized.n(delegate().get((e1<K, V>) k), this.mutex);
                }
                return n;
            }
            return (Set) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, b.h.d.c.q0
        public Set<V> removeAll(Object obj) {
            InterceptResult invokeL;
            Set<V> removeAll;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, obj)) == null) {
                synchronized (this.mutex) {
                    removeAll = delegate().removeAll(obj);
                }
                return removeAll;
            }
            return (Set) invokeL.objValue;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, b.h.d.c.q0
        public Set<V> replaceValues(K k, Iterable<? extends V> iterable) {
            InterceptResult invokeLL;
            Set<V> replaceValues;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, k, iterable)) == null) {
                synchronized (this.mutex) {
                    replaceValues = delegate().replaceValues((e1<K, V>) k, (Iterable) iterable);
                }
                return replaceValues;
            }
            return (Set) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Synchronized.SynchronizedObject
        public e1<K, V> delegate() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (e1) super.delegate() : (e1) invokeV.objValue;
        }
    }

    /* loaded from: classes11.dex */
    public static class SynchronizedSortedSetMultimap<K, V> extends SynchronizedSetMultimap<K, V> implements j1<K, V> {
        public static /* synthetic */ Interceptable $ic;
        public static final long serialVersionUID = 0;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SynchronizedSortedSetMultimap(j1<K, V> j1Var, Object obj) {
            super(j1Var, obj);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j1Var, obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((e1) objArr2[0], objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Synchronized.SynchronizedSetMultimap, com.google.common.collect.Synchronized.SynchronizedMultimap, b.h.d.c.q0
        public /* bridge */ /* synthetic */ Collection get(Object obj) {
            return get((SynchronizedSortedSetMultimap<K, V>) obj);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Synchronized.SynchronizedSetMultimap, com.google.common.collect.Synchronized.SynchronizedMultimap, b.h.d.c.q0
        public /* bridge */ /* synthetic */ Collection replaceValues(Object obj, Iterable iterable) {
            return replaceValues((SynchronizedSortedSetMultimap<K, V>) obj, iterable);
        }

        @Override // b.h.d.c.j1
        public Comparator<? super V> valueComparator() {
            InterceptResult invokeV;
            Comparator<? super V> valueComparator;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
                synchronized (this.mutex) {
                    valueComparator = delegate().valueComparator();
                }
                return valueComparator;
            }
            return (Comparator) invokeV.objValue;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Synchronized.SynchronizedSetMultimap, com.google.common.collect.Synchronized.SynchronizedMultimap, b.h.d.c.q0
        public /* bridge */ /* synthetic */ Set get(Object obj) {
            return get((SynchronizedSortedSetMultimap<K, V>) obj);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Synchronized.SynchronizedSetMultimap, com.google.common.collect.Synchronized.SynchronizedMultimap, b.h.d.c.q0
        public /* bridge */ /* synthetic */ Set replaceValues(Object obj, Iterable iterable) {
            return replaceValues((SynchronizedSortedSetMultimap<K, V>) obj, iterable);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSetMultimap, com.google.common.collect.Synchronized.SynchronizedMultimap, b.h.d.c.q0
        public SortedSet<V> get(K k) {
            InterceptResult invokeL;
            SortedSet<V> p;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, k)) == null) {
                synchronized (this.mutex) {
                    p = Synchronized.p(delegate().get((j1<K, V>) k), this.mutex);
                }
                return p;
            }
            return (SortedSet) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.Synchronized.SynchronizedSetMultimap, com.google.common.collect.Synchronized.SynchronizedMultimap, b.h.d.c.q0
        public SortedSet<V> removeAll(Object obj) {
            InterceptResult invokeL;
            SortedSet<V> removeAll;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, obj)) == null) {
                synchronized (this.mutex) {
                    removeAll = delegate().removeAll(obj);
                }
                return removeAll;
            }
            return (SortedSet) invokeL.objValue;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSetMultimap, com.google.common.collect.Synchronized.SynchronizedMultimap, b.h.d.c.q0
        public SortedSet<V> replaceValues(K k, Iterable<? extends V> iterable) {
            InterceptResult invokeLL;
            SortedSet<V> replaceValues;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, k, iterable)) == null) {
                synchronized (this.mutex) {
                    replaceValues = delegate().replaceValues((j1<K, V>) k, (Iterable) iterable);
                }
                return replaceValues;
            }
            return (SortedSet) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.Synchronized.SynchronizedSetMultimap, com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Synchronized.SynchronizedObject
        public j1<K, V> delegate() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (j1) super.delegate() : (j1) invokeV.objValue;
        }
    }

    /* loaded from: classes11.dex */
    public static final class SynchronizedTable<R, C, V> extends SynchronizedObject implements k1<R, C, V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes11.dex */
        public class a implements g<Map<C, V>, Map<C, V>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ SynchronizedTable f64486e;

            public a(SynchronizedTable synchronizedTable) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {synchronizedTable};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f64486e = synchronizedTable;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // b.h.d.a.g
            /* renamed from: a */
            public Map<C, V> apply(Map<C, V> map) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, map)) == null) ? Synchronized.i(map, this.f64486e.mutex) : (Map) invokeL.objValue;
            }
        }

        /* loaded from: classes11.dex */
        public class b implements g<Map<R, V>, Map<R, V>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ SynchronizedTable f64487e;

            public b(SynchronizedTable synchronizedTable) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {synchronizedTable};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f64487e = synchronizedTable;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // b.h.d.a.g
            /* renamed from: a */
            public Map<R, V> apply(Map<R, V> map) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, map)) == null) ? Synchronized.i(map, this.f64487e.mutex) : (Map) invokeL.objValue;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SynchronizedTable(k1<R, C, V> k1Var, Object obj) {
            super(k1Var, obj);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k1Var, obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(objArr2[0], objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // b.h.d.c.k1
        public Set<k1.a<R, C, V>> cellSet() {
            InterceptResult invokeV;
            Set<k1.a<R, C, V>> n;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                synchronized (this.mutex) {
                    n = Synchronized.n(delegate().cellSet(), this.mutex);
                }
                return n;
            }
            return (Set) invokeV.objValue;
        }

        @Override // b.h.d.c.k1
        public void clear() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                synchronized (this.mutex) {
                    delegate().clear();
                }
            }
        }

        @Override // b.h.d.c.k1
        public Map<R, V> column(C c2) {
            InterceptResult invokeL;
            Map<R, V> i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, c2)) == null) {
                synchronized (this.mutex) {
                    i2 = Synchronized.i(delegate().column(c2), this.mutex);
                }
                return i2;
            }
            return (Map) invokeL.objValue;
        }

        @Override // b.h.d.c.k1
        public Set<C> columnKeySet() {
            InterceptResult invokeV;
            Set<C> n;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                synchronized (this.mutex) {
                    n = Synchronized.n(delegate().columnKeySet(), this.mutex);
                }
                return n;
            }
            return (Set) invokeV.objValue;
        }

        @Override // b.h.d.c.k1
        public Map<C, Map<R, V>> columnMap() {
            InterceptResult invokeV;
            Map<C, Map<R, V>> i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                synchronized (this.mutex) {
                    i2 = Synchronized.i(Maps.G(delegate().columnMap(), new b(this)), this.mutex);
                }
                return i2;
            }
            return (Map) invokeV.objValue;
        }

        @Override // b.h.d.c.k1
        public boolean contains(Object obj, Object obj2) {
            InterceptResult invokeLL;
            boolean contains;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, obj, obj2)) == null) {
                synchronized (this.mutex) {
                    contains = delegate().contains(obj, obj2);
                }
                return contains;
            }
            return invokeLL.booleanValue;
        }

        @Override // b.h.d.c.k1
        public boolean containsColumn(Object obj) {
            InterceptResult invokeL;
            boolean containsColumn;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, obj)) == null) {
                synchronized (this.mutex) {
                    containsColumn = delegate().containsColumn(obj);
                }
                return containsColumn;
            }
            return invokeL.booleanValue;
        }

        @Override // b.h.d.c.k1
        public boolean containsRow(Object obj) {
            InterceptResult invokeL;
            boolean containsRow;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, obj)) == null) {
                synchronized (this.mutex) {
                    containsRow = delegate().containsRow(obj);
                }
                return containsRow;
            }
            return invokeL.booleanValue;
        }

        @Override // b.h.d.c.k1
        public boolean containsValue(Object obj) {
            InterceptResult invokeL;
            boolean containsValue;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, obj)) == null) {
                synchronized (this.mutex) {
                    containsValue = delegate().containsValue(obj);
                }
                return containsValue;
            }
            return invokeL.booleanValue;
        }

        @Override // b.h.d.c.k1
        public boolean equals(Object obj) {
            InterceptResult invokeL;
            boolean equals;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, obj)) == null) {
                if (this == obj) {
                    return true;
                }
                synchronized (this.mutex) {
                    equals = delegate().equals(obj);
                }
                return equals;
            }
            return invokeL.booleanValue;
        }

        @Override // b.h.d.c.k1
        public V get(Object obj, Object obj2) {
            InterceptResult invokeLL;
            V v;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, obj, obj2)) == null) {
                synchronized (this.mutex) {
                    v = delegate().get(obj, obj2);
                }
                return v;
            }
            return (V) invokeLL.objValue;
        }

        @Override // b.h.d.c.k1
        public int hashCode() {
            InterceptResult invokeV;
            int hashCode;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
                synchronized (this.mutex) {
                    hashCode = delegate().hashCode();
                }
                return hashCode;
            }
            return invokeV.intValue;
        }

        @Override // b.h.d.c.k1
        public boolean isEmpty() {
            InterceptResult invokeV;
            boolean isEmpty;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
                synchronized (this.mutex) {
                    isEmpty = delegate().isEmpty();
                }
                return isEmpty;
            }
            return invokeV.booleanValue;
        }

        @Override // b.h.d.c.k1
        public V put(R r, C c2, V v) {
            InterceptResult invokeLLL;
            V put;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048591, this, r, c2, v)) == null) {
                synchronized (this.mutex) {
                    put = delegate().put(r, c2, v);
                }
                return put;
            }
            return (V) invokeLLL.objValue;
        }

        @Override // b.h.d.c.k1
        public void putAll(k1<? extends R, ? extends C, ? extends V> k1Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048592, this, k1Var) == null) {
                synchronized (this.mutex) {
                    delegate().putAll(k1Var);
                }
            }
        }

        @Override // b.h.d.c.k1
        public V remove(Object obj, Object obj2) {
            InterceptResult invokeLL;
            V remove;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048593, this, obj, obj2)) == null) {
                synchronized (this.mutex) {
                    remove = delegate().remove(obj, obj2);
                }
                return remove;
            }
            return (V) invokeLL.objValue;
        }

        @Override // b.h.d.c.k1
        public Map<C, V> row(R r) {
            InterceptResult invokeL;
            Map<C, V> i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, r)) == null) {
                synchronized (this.mutex) {
                    i2 = Synchronized.i(delegate().row(r), this.mutex);
                }
                return i2;
            }
            return (Map) invokeL.objValue;
        }

        @Override // b.h.d.c.k1
        public Set<R> rowKeySet() {
            InterceptResult invokeV;
            Set<R> n;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
                synchronized (this.mutex) {
                    n = Synchronized.n(delegate().rowKeySet(), this.mutex);
                }
                return n;
            }
            return (Set) invokeV.objValue;
        }

        @Override // b.h.d.c.k1
        public Map<R, Map<C, V>> rowMap() {
            InterceptResult invokeV;
            Map<R, Map<C, V>> i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
                synchronized (this.mutex) {
                    i2 = Synchronized.i(Maps.G(delegate().rowMap(), new a(this)), this.mutex);
                }
                return i2;
            }
            return (Map) invokeV.objValue;
        }

        @Override // b.h.d.c.k1
        public int size() {
            InterceptResult invokeV;
            int size;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
                synchronized (this.mutex) {
                    size = delegate().size();
                }
                return size;
            }
            return invokeV.intValue;
        }

        @Override // b.h.d.c.k1
        public Collection<V> values() {
            InterceptResult invokeV;
            Collection<V> g2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
                synchronized (this.mutex) {
                    g2 = Synchronized.g(delegate().values(), this.mutex);
                }
                return g2;
            }
            return (Collection) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.Synchronized.SynchronizedObject
        public k1<R, C, V> delegate() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? (k1) super.delegate() : (k1) invokeV.objValue;
        }
    }

    /* loaded from: classes11.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    public static <E> Collection<E> g(Collection<E> collection, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, collection, obj)) == null) ? new SynchronizedCollection(collection, obj, null) : (Collection) invokeLL.objValue;
    }

    public static <E> List<E> h(List<E> list, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, list, obj)) == null) ? list instanceof RandomAccess ? new SynchronizedRandomAccessList(list, obj) : new SynchronizedList(list, obj) : (List) invokeLL.objValue;
    }

    public static <K, V> Map<K, V> i(Map<K, V> map, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, map, obj)) == null) ? new SynchronizedMap(map, obj) : (Map) invokeLL.objValue;
    }

    public static <E> s0<E> j(s0<E> s0Var, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, s0Var, obj)) == null) ? ((s0Var instanceof SynchronizedMultiset) || (s0Var instanceof ImmutableMultiset)) ? s0Var : new SynchronizedMultiset(s0Var, obj) : (s0) invokeLL.objValue;
    }

    public static <K, V> NavigableMap<K, V> k(NavigableMap<K, V> navigableMap, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, navigableMap, obj)) == null) ? new SynchronizedNavigableMap(navigableMap, obj) : (NavigableMap) invokeLL.objValue;
    }

    public static <E> NavigableSet<E> l(NavigableSet<E> navigableSet, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65547, null, navigableSet, obj)) == null) ? new SynchronizedNavigableSet(navigableSet, obj) : (NavigableSet) invokeLL.objValue;
    }

    public static <K, V> Map.Entry<K, V> m(Map.Entry<K, V> entry, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65548, null, entry, obj)) == null) {
            if (entry == null) {
                return null;
            }
            return new SynchronizedEntry(entry, obj);
        }
        return (Map.Entry) invokeLL.objValue;
    }

    public static <E> Set<E> n(Set<E> set, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65549, null, set, obj)) == null) ? new SynchronizedSet(set, obj) : (Set) invokeLL.objValue;
    }

    public static <K, V> SortedMap<K, V> o(SortedMap<K, V> sortedMap, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65550, null, sortedMap, obj)) == null) ? new SynchronizedSortedMap(sortedMap, obj) : (SortedMap) invokeLL.objValue;
    }

    public static <E> SortedSet<E> p(SortedSet<E> sortedSet, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65551, null, sortedSet, obj)) == null) ? new SynchronizedSortedSet(sortedSet, obj) : (SortedSet) invokeLL.objValue;
    }

    public static <E> Collection<E> q(Collection<E> collection, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65552, null, collection, obj)) == null) {
            if (collection instanceof SortedSet) {
                return p((SortedSet) collection, obj);
            }
            if (collection instanceof Set) {
                return n((Set) collection, obj);
            }
            if (collection instanceof List) {
                return h((List) collection, obj);
            }
            return g(collection, obj);
        }
        return (Collection) invokeLL.objValue;
    }

    public static <E> Set<E> r(Set<E> set, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65553, null, set, obj)) == null) {
            if (set instanceof SortedSet) {
                return p((SortedSet) set, obj);
            }
            return n(set, obj);
        }
        return (Set) invokeLL.objValue;
    }

    /* loaded from: classes11.dex */
    public static class SynchronizedMultiset<E> extends SynchronizedCollection<E> implements s0<E> {
        public static /* synthetic */ Interceptable $ic;
        public static final long serialVersionUID = 0;
        public transient /* synthetic */ FieldHolder $fh;
        public transient Set<E> elementSet;
        public transient Set<s0.a<E>> entrySet;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SynchronizedMultiset(s0<E> s0Var, Object obj) {
            super(s0Var, obj, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s0Var, obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Collection) objArr2[0], objArr2[1], (a) objArr2[2]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // b.h.d.c.s0
        public int add(E e2, int i2) {
            InterceptResult invokeLI;
            int add;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, e2, i2)) == null) {
                synchronized (this.mutex) {
                    add = delegate().add(e2, i2);
                }
                return add;
            }
            return invokeLI.intValue;
        }

        @Override // b.h.d.c.s0
        public int count(Object obj) {
            InterceptResult invokeL;
            int count;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
                synchronized (this.mutex) {
                    count = delegate().count(obj);
                }
                return count;
            }
            return invokeL.intValue;
        }

        @Override // b.h.d.c.s0
        public Set<E> elementSet() {
            InterceptResult invokeV;
            Set<E> set;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                synchronized (this.mutex) {
                    if (this.elementSet == null) {
                        this.elementSet = Synchronized.r(delegate().elementSet(), this.mutex);
                    }
                    set = this.elementSet;
                }
                return set;
            }
            return (Set) invokeV.objValue;
        }

        @Override // b.h.d.c.s0
        public Set<s0.a<E>> entrySet() {
            InterceptResult invokeV;
            Set<s0.a<E>> set;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                synchronized (this.mutex) {
                    if (this.entrySet == null) {
                        this.entrySet = Synchronized.r(delegate().entrySet(), this.mutex);
                    }
                    set = this.entrySet;
                }
                return set;
            }
            return (Set) invokeV.objValue;
        }

        @Override // java.util.Collection, b.h.d.c.s0
        public boolean equals(Object obj) {
            InterceptResult invokeL;
            boolean equals;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, obj)) == null) {
                if (obj == this) {
                    return true;
                }
                synchronized (this.mutex) {
                    equals = delegate().equals(obj);
                }
                return equals;
            }
            return invokeL.booleanValue;
        }

        @Override // java.util.Collection, b.h.d.c.s0
        public int hashCode() {
            InterceptResult invokeV;
            int hashCode;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                synchronized (this.mutex) {
                    hashCode = delegate().hashCode();
                }
                return hashCode;
            }
            return invokeV.intValue;
        }

        @Override // b.h.d.c.s0
        public int remove(Object obj, int i2) {
            InterceptResult invokeLI;
            int remove;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048585, this, obj, i2)) == null) {
                synchronized (this.mutex) {
                    remove = delegate().remove(obj, i2);
                }
                return remove;
            }
            return invokeLI.intValue;
        }

        @Override // b.h.d.c.s0
        public int setCount(E e2, int i2) {
            InterceptResult invokeLI;
            int count;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048586, this, e2, i2)) == null) {
                synchronized (this.mutex) {
                    count = delegate().setCount(e2, i2);
                }
                return count;
            }
            return invokeLI.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        public s0<E> delegate() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? (s0) super.delegate() : (s0) invokeV.objValue;
        }

        @Override // b.h.d.c.s0
        public boolean setCount(E e2, int i2, int i3) {
            InterceptResult invokeLII;
            boolean count;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(1048587, this, e2, i2, i3)) == null) {
                synchronized (this.mutex) {
                    count = delegate().setCount(e2, i2, i3);
                }
                return count;
            }
            return invokeLII.booleanValue;
        }
    }

    /* loaded from: classes11.dex */
    public static class SynchronizedQueue<E> extends SynchronizedCollection<E> implements Queue<E> {
        public static /* synthetic */ Interceptable $ic;
        public static final long serialVersionUID = 0;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SynchronizedQueue(Queue<E> queue, Object obj) {
            super(queue, obj, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {queue, obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Collection) objArr2[0], objArr2[1], (a) objArr2[2]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // java.util.Queue
        public E element() {
            InterceptResult invokeV;
            E element;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                synchronized (this.mutex) {
                    element = delegate().element();
                }
                return element;
            }
            return (E) invokeV.objValue;
        }

        @Override // java.util.Queue
        public boolean offer(E e2) {
            InterceptResult invokeL;
            boolean offer;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, e2)) == null) {
                synchronized (this.mutex) {
                    offer = delegate().offer(e2);
                }
                return offer;
            }
            return invokeL.booleanValue;
        }

        @Override // java.util.Queue
        public E peek() {
            InterceptResult invokeV;
            E peek;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                synchronized (this.mutex) {
                    peek = delegate().peek();
                }
                return peek;
            }
            return (E) invokeV.objValue;
        }

        @Override // java.util.Queue
        public E poll() {
            InterceptResult invokeV;
            E poll;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                synchronized (this.mutex) {
                    poll = delegate().poll();
                }
                return poll;
            }
            return (E) invokeV.objValue;
        }

        @Override // java.util.Queue
        public E remove() {
            InterceptResult invokeV;
            E remove;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                synchronized (this.mutex) {
                    remove = delegate().remove();
                }
                return remove;
            }
            return (E) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        public Queue<E> delegate() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? (Queue) super.delegate() : (Queue) invokeV.objValue;
        }
    }

    /* loaded from: classes11.dex */
    public static class SynchronizedSet<E> extends SynchronizedCollection<E> implements Set<E> {
        public static /* synthetic */ Interceptable $ic;
        public static final long serialVersionUID = 0;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SynchronizedSet(Set<E> set, Object obj) {
            super(set, obj, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {set, obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Collection) objArr2[0], objArr2[1], (a) objArr2[2]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            boolean equals;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
                if (obj == this) {
                    return true;
                }
                synchronized (this.mutex) {
                    equals = delegate().equals(obj);
                }
                return equals;
            }
            return invokeL.booleanValue;
        }

        @Override // java.util.Collection, java.util.Set
        public int hashCode() {
            InterceptResult invokeV;
            int hashCode;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                synchronized (this.mutex) {
                    hashCode = delegate().hashCode();
                }
                return hashCode;
            }
            return invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        public Set<E> delegate() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? (Set) super.delegate() : (Set) invokeV.objValue;
        }
    }

    /* loaded from: classes11.dex */
    public static class SynchronizedSortedMap<K, V> extends SynchronizedMap<K, V> implements SortedMap<K, V> {
        public static /* synthetic */ Interceptable $ic;
        public static final long serialVersionUID = 0;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SynchronizedSortedMap(SortedMap<K, V> sortedMap, Object obj) {
            super(sortedMap, obj);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sortedMap, obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Map) objArr2[0], objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // java.util.SortedMap
        public Comparator<? super K> comparator() {
            InterceptResult invokeV;
            Comparator<? super K> comparator;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                synchronized (this.mutex) {
                    comparator = delegate().comparator();
                }
                return comparator;
            }
            return (Comparator) invokeV.objValue;
        }

        @Override // java.util.SortedMap
        public K firstKey() {
            InterceptResult invokeV;
            K firstKey;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                synchronized (this.mutex) {
                    firstKey = delegate().firstKey();
                }
                return firstKey;
            }
            return (K) invokeV.objValue;
        }

        public SortedMap<K, V> headMap(K k) {
            InterceptResult invokeL;
            SortedMap<K, V> o;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, k)) == null) {
                synchronized (this.mutex) {
                    o = Synchronized.o(delegate().headMap(k), this.mutex);
                }
                return o;
            }
            return (SortedMap) invokeL.objValue;
        }

        @Override // java.util.SortedMap
        public K lastKey() {
            InterceptResult invokeV;
            K lastKey;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                synchronized (this.mutex) {
                    lastKey = delegate().lastKey();
                }
                return lastKey;
            }
            return (K) invokeV.objValue;
        }

        public SortedMap<K, V> subMap(K k, K k2) {
            InterceptResult invokeLL;
            SortedMap<K, V> o;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, k, k2)) == null) {
                synchronized (this.mutex) {
                    o = Synchronized.o(delegate().subMap(k, k2), this.mutex);
                }
                return o;
            }
            return (SortedMap) invokeLL.objValue;
        }

        public SortedMap<K, V> tailMap(K k) {
            InterceptResult invokeL;
            SortedMap<K, V> o;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, k)) == null) {
                synchronized (this.mutex) {
                    o = Synchronized.o(delegate().tailMap(k), this.mutex);
                }
                return o;
            }
            return (SortedMap) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.Synchronized.SynchronizedMap, com.google.common.collect.Synchronized.SynchronizedObject
        public SortedMap<K, V> delegate() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (SortedMap) super.delegate() : (SortedMap) invokeV.objValue;
        }
    }

    /* loaded from: classes11.dex */
    public static class SynchronizedAsMapEntries<K, V> extends SynchronizedSet<Map.Entry<K, Collection<V>>> {
        public static /* synthetic */ Interceptable $ic;
        public static final long serialVersionUID = 0;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes11.dex */
        public class a extends m1<Map.Entry<K, Collection<V>>, Map.Entry<K, Collection<V>>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ SynchronizedAsMapEntries f64482f;

            /* renamed from: com.google.common.collect.Synchronized$SynchronizedAsMapEntries$a$a  reason: collision with other inner class name */
            /* loaded from: classes11.dex */
            public class C1919a extends e0<K, Collection<V>> {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Map.Entry f64483e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ a f64484f;

                public C1919a(a aVar, Map.Entry entry) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {aVar, entry};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f64484f = aVar;
                    this.f64483e = entry;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // b.h.d.c.h0
                /* renamed from: d */
                public Map.Entry<K, Collection<V>> delegate() {
                    InterceptResult invokeV;
                    Interceptable interceptable = $ic;
                    return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f64483e : (Map.Entry) invokeV.objValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // b.h.d.c.e0, java.util.Map.Entry
                /* renamed from: e */
                public Collection<V> getValue() {
                    InterceptResult invokeV;
                    Interceptable interceptable = $ic;
                    return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? Synchronized.q((Collection) this.f64483e.getValue(), this.f64484f.f64482f.mutex) : (Collection) invokeV.objValue;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(SynchronizedAsMapEntries synchronizedAsMapEntries, Iterator it) {
                super(it);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {synchronizedAsMapEntries, it};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        super((Iterator) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f64482f = synchronizedAsMapEntries;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // b.h.d.c.m1
            /* renamed from: b */
            public Map.Entry<K, Collection<V>> a(Map.Entry<K, Collection<V>> entry) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, entry)) == null) ? new C1919a(this, entry) : (Map.Entry) invokeL.objValue;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SynchronizedAsMapEntries(Set<Map.Entry<K, Collection<V>>> set, Object obj) {
            super(set, obj);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {set, obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Set) objArr2[0], objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            InterceptResult invokeL;
            boolean f2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                synchronized (this.mutex) {
                    f2 = Maps.f(delegate(), obj);
                }
                return f2;
            }
            return invokeL.booleanValue;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> collection) {
            InterceptResult invokeL;
            boolean b2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, collection)) == null) {
                synchronized (this.mutex) {
                    b2 = b.h.d.c.n.b(delegate(), collection);
                }
                return b2;
            }
            return invokeL.booleanValue;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSet, java.util.Collection, java.util.Set
        public boolean equals(Object obj) {
            InterceptResult invokeL;
            boolean a2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) {
                if (obj == this) {
                    return true;
                }
                synchronized (this.mutex) {
                    a2 = Sets.a(delegate(), obj);
                }
                return a2;
            }
            return invokeL.booleanValue;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, Collection<V>>> iterator() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? new a(this, super.iterator()) : (Iterator) invokeV.objValue;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            InterceptResult invokeL;
            boolean y;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, obj)) == null) {
                synchronized (this.mutex) {
                    y = Maps.y(delegate(), obj);
                }
                return y;
            }
            return invokeL.booleanValue;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            InterceptResult invokeL;
            boolean u;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, collection)) == null) {
                synchronized (this.mutex) {
                    u = Iterators.u(delegate().iterator(), collection);
                }
                return u;
            }
            return invokeL.booleanValue;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> collection) {
            InterceptResult invokeL;
            boolean w;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, collection)) == null) {
                synchronized (this.mutex) {
                    w = Iterators.w(delegate().iterator(), collection);
                }
                return w;
            }
            return invokeL.booleanValue;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            InterceptResult invokeV;
            Object[] h2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                synchronized (this.mutex) {
                    h2 = u0.h(delegate());
                }
                return h2;
            }
            return (Object[]) invokeV.objValue;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            InterceptResult invokeL;
            T[] tArr2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, tArr)) == null) {
                synchronized (this.mutex) {
                    tArr2 = (T[]) u0.i(delegate(), tArr);
                }
                return tArr2;
            }
            return (T[]) ((Object[]) invokeL.objValue);
        }
    }

    /* loaded from: classes11.dex */
    public static final class SynchronizedDeque<E> extends SynchronizedQueue<E> implements Deque<E> {
        public static /* synthetic */ Interceptable $ic;
        public static final long serialVersionUID = 0;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SynchronizedDeque(Deque<E> deque, Object obj) {
            super(deque, obj);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {deque, obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Queue) objArr2[0], objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // java.util.Deque
        public void addFirst(E e2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, e2) == null) {
                synchronized (this.mutex) {
                    delegate().addFirst(e2);
                }
            }
        }

        @Override // java.util.Deque
        public void addLast(E e2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, e2) == null) {
                synchronized (this.mutex) {
                    delegate().addLast(e2);
                }
            }
        }

        @Override // java.util.Deque
        public Iterator<E> descendingIterator() {
            InterceptResult invokeV;
            Iterator<E> descendingIterator;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                synchronized (this.mutex) {
                    descendingIterator = delegate().descendingIterator();
                }
                return descendingIterator;
            }
            return (Iterator) invokeV.objValue;
        }

        @Override // java.util.Deque
        public E getFirst() {
            InterceptResult invokeV;
            E first;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                synchronized (this.mutex) {
                    first = delegate().getFirst();
                }
                return first;
            }
            return (E) invokeV.objValue;
        }

        @Override // java.util.Deque
        public E getLast() {
            InterceptResult invokeV;
            E last;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                synchronized (this.mutex) {
                    last = delegate().getLast();
                }
                return last;
            }
            return (E) invokeV.objValue;
        }

        @Override // java.util.Deque
        public boolean offerFirst(E e2) {
            InterceptResult invokeL;
            boolean offerFirst;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, e2)) == null) {
                synchronized (this.mutex) {
                    offerFirst = delegate().offerFirst(e2);
                }
                return offerFirst;
            }
            return invokeL.booleanValue;
        }

        @Override // java.util.Deque
        public boolean offerLast(E e2) {
            InterceptResult invokeL;
            boolean offerLast;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, e2)) == null) {
                synchronized (this.mutex) {
                    offerLast = delegate().offerLast(e2);
                }
                return offerLast;
            }
            return invokeL.booleanValue;
        }

        @Override // java.util.Deque
        public E peekFirst() {
            InterceptResult invokeV;
            E peekFirst;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                synchronized (this.mutex) {
                    peekFirst = delegate().peekFirst();
                }
                return peekFirst;
            }
            return (E) invokeV.objValue;
        }

        @Override // java.util.Deque
        public E peekLast() {
            InterceptResult invokeV;
            E peekLast;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
                synchronized (this.mutex) {
                    peekLast = delegate().peekLast();
                }
                return peekLast;
            }
            return (E) invokeV.objValue;
        }

        @Override // java.util.Deque
        public E pollFirst() {
            InterceptResult invokeV;
            E pollFirst;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
                synchronized (this.mutex) {
                    pollFirst = delegate().pollFirst();
                }
                return pollFirst;
            }
            return (E) invokeV.objValue;
        }

        @Override // java.util.Deque
        public E pollLast() {
            InterceptResult invokeV;
            E pollLast;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
                synchronized (this.mutex) {
                    pollLast = delegate().pollLast();
                }
                return pollLast;
            }
            return (E) invokeV.objValue;
        }

        @Override // java.util.Deque
        public E pop() {
            InterceptResult invokeV;
            E pop;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
                synchronized (this.mutex) {
                    pop = delegate().pop();
                }
                return pop;
            }
            return (E) invokeV.objValue;
        }

        @Override // java.util.Deque
        public void push(E e2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048592, this, e2) == null) {
                synchronized (this.mutex) {
                    delegate().push(e2);
                }
            }
        }

        @Override // java.util.Deque
        public E removeFirst() {
            InterceptResult invokeV;
            E removeFirst;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
                synchronized (this.mutex) {
                    removeFirst = delegate().removeFirst();
                }
                return removeFirst;
            }
            return (E) invokeV.objValue;
        }

        @Override // java.util.Deque
        public boolean removeFirstOccurrence(Object obj) {
            InterceptResult invokeL;
            boolean removeFirstOccurrence;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, obj)) == null) {
                synchronized (this.mutex) {
                    removeFirstOccurrence = delegate().removeFirstOccurrence(obj);
                }
                return removeFirstOccurrence;
            }
            return invokeL.booleanValue;
        }

        @Override // java.util.Deque
        public E removeLast() {
            InterceptResult invokeV;
            E removeLast;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
                synchronized (this.mutex) {
                    removeLast = delegate().removeLast();
                }
                return removeLast;
            }
            return (E) invokeV.objValue;
        }

        @Override // java.util.Deque
        public boolean removeLastOccurrence(Object obj) {
            InterceptResult invokeL;
            boolean removeLastOccurrence;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, obj)) == null) {
                synchronized (this.mutex) {
                    removeLastOccurrence = delegate().removeLastOccurrence(obj);
                }
                return removeLastOccurrence;
            }
            return invokeL.booleanValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.Synchronized.SynchronizedQueue, com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        public Deque<E> delegate() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? (Deque) super.delegate() : (Deque) invokeV.objValue;
        }
    }

    /* loaded from: classes11.dex */
    public static class SynchronizedNavigableMap<K, V> extends SynchronizedSortedMap<K, V> implements NavigableMap<K, V> {
        public static /* synthetic */ Interceptable $ic;
        public static final long serialVersionUID = 0;
        public transient /* synthetic */ FieldHolder $fh;
        public transient NavigableSet<K> descendingKeySet;
        public transient NavigableMap<K, V> descendingMap;
        public transient NavigableSet<K> navigableKeySet;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SynchronizedNavigableMap(NavigableMap<K, V> navigableMap, Object obj) {
            super(navigableMap, obj);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {navigableMap, obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((SortedMap) objArr2[0], objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> ceilingEntry(K k) {
            InterceptResult invokeL;
            Map.Entry<K, V> m;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, k)) == null) {
                synchronized (this.mutex) {
                    m = Synchronized.m(delegate().ceilingEntry(k), this.mutex);
                }
                return m;
            }
            return (Map.Entry) invokeL.objValue;
        }

        @Override // java.util.NavigableMap
        public K ceilingKey(K k) {
            InterceptResult invokeL;
            K ceilingKey;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, k)) == null) {
                synchronized (this.mutex) {
                    ceilingKey = delegate().ceilingKey(k);
                }
                return ceilingKey;
            }
            return (K) invokeL.objValue;
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> descendingKeySet() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                synchronized (this.mutex) {
                    if (this.descendingKeySet == null) {
                        NavigableSet<K> l = Synchronized.l(delegate().descendingKeySet(), this.mutex);
                        this.descendingKeySet = l;
                        return l;
                    }
                    return this.descendingKeySet;
                }
            }
            return (NavigableSet) invokeV.objValue;
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> descendingMap() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                synchronized (this.mutex) {
                    if (this.descendingMap == null) {
                        NavigableMap<K, V> k = Synchronized.k(delegate().descendingMap(), this.mutex);
                        this.descendingMap = k;
                        return k;
                    }
                    return this.descendingMap;
                }
            }
            return (NavigableMap) invokeV.objValue;
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> firstEntry() {
            InterceptResult invokeV;
            Map.Entry<K, V> m;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                synchronized (this.mutex) {
                    m = Synchronized.m(delegate().firstEntry(), this.mutex);
                }
                return m;
            }
            return (Map.Entry) invokeV.objValue;
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> floorEntry(K k) {
            InterceptResult invokeL;
            Map.Entry<K, V> m;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, k)) == null) {
                synchronized (this.mutex) {
                    m = Synchronized.m(delegate().floorEntry(k), this.mutex);
                }
                return m;
            }
            return (Map.Entry) invokeL.objValue;
        }

        @Override // java.util.NavigableMap
        public K floorKey(K k) {
            InterceptResult invokeL;
            K floorKey;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, k)) == null) {
                synchronized (this.mutex) {
                    floorKey = delegate().floorKey(k);
                }
                return floorKey;
            }
            return (K) invokeL.objValue;
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> headMap(K k, boolean z) {
            InterceptResult invokeLZ;
            NavigableMap<K, V> k2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048587, this, k, z)) == null) {
                synchronized (this.mutex) {
                    k2 = Synchronized.k(delegate().headMap(k, z), this.mutex);
                }
                return k2;
            }
            return (NavigableMap) invokeLZ.objValue;
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> higherEntry(K k) {
            InterceptResult invokeL;
            Map.Entry<K, V> m;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, k)) == null) {
                synchronized (this.mutex) {
                    m = Synchronized.m(delegate().higherEntry(k), this.mutex);
                }
                return m;
            }
            return (Map.Entry) invokeL.objValue;
        }

        @Override // java.util.NavigableMap
        public K higherKey(K k) {
            InterceptResult invokeL;
            K higherKey;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, k)) == null) {
                synchronized (this.mutex) {
                    higherKey = delegate().higherKey(k);
                }
                return higherKey;
            }
            return (K) invokeL.objValue;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMap, java.util.Map
        public Set<K> keySet() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? navigableKeySet() : (Set) invokeV.objValue;
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> lastEntry() {
            InterceptResult invokeV;
            Map.Entry<K, V> m;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
                synchronized (this.mutex) {
                    m = Synchronized.m(delegate().lastEntry(), this.mutex);
                }
                return m;
            }
            return (Map.Entry) invokeV.objValue;
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> lowerEntry(K k) {
            InterceptResult invokeL;
            Map.Entry<K, V> m;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, k)) == null) {
                synchronized (this.mutex) {
                    m = Synchronized.m(delegate().lowerEntry(k), this.mutex);
                }
                return m;
            }
            return (Map.Entry) invokeL.objValue;
        }

        @Override // java.util.NavigableMap
        public K lowerKey(K k) {
            InterceptResult invokeL;
            K lowerKey;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, k)) == null) {
                synchronized (this.mutex) {
                    lowerKey = delegate().lowerKey(k);
                }
                return lowerKey;
            }
            return (K) invokeL.objValue;
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> navigableKeySet() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
                synchronized (this.mutex) {
                    if (this.navigableKeySet == null) {
                        NavigableSet<K> l = Synchronized.l(delegate().navigableKeySet(), this.mutex);
                        this.navigableKeySet = l;
                        return l;
                    }
                    return this.navigableKeySet;
                }
            }
            return (NavigableSet) invokeV.objValue;
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> pollFirstEntry() {
            InterceptResult invokeV;
            Map.Entry<K, V> m;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
                synchronized (this.mutex) {
                    m = Synchronized.m(delegate().pollFirstEntry(), this.mutex);
                }
                return m;
            }
            return (Map.Entry) invokeV.objValue;
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> pollLastEntry() {
            InterceptResult invokeV;
            Map.Entry<K, V> m;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
                synchronized (this.mutex) {
                    m = Synchronized.m(delegate().pollLastEntry(), this.mutex);
                }
                return m;
            }
            return (Map.Entry) invokeV.objValue;
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> subMap(K k, boolean z, K k2, boolean z2) {
            InterceptResult invokeCommon;
            NavigableMap<K, V> k3;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048598, this, new Object[]{k, Boolean.valueOf(z), k2, Boolean.valueOf(z2)})) == null) {
                synchronized (this.mutex) {
                    k3 = Synchronized.k(delegate().subMap(k, z, k2, z2), this.mutex);
                }
                return k3;
            }
            return (NavigableMap) invokeCommon.objValue;
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> tailMap(K k, boolean z) {
            InterceptResult invokeLZ;
            NavigableMap<K, V> k2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048600, this, k, z)) == null) {
                synchronized (this.mutex) {
                    k2 = Synchronized.k(delegate().tailMap(k, z), this.mutex);
                }
                return k2;
            }
            return (NavigableMap) invokeLZ.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.Synchronized.SynchronizedSortedMap, com.google.common.collect.Synchronized.SynchronizedMap, com.google.common.collect.Synchronized.SynchronizedObject
        public NavigableMap<K, V> delegate() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? (NavigableMap) super.delegate() : (NavigableMap) invokeV.objValue;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSortedMap, java.util.SortedMap, java.util.NavigableMap
        public SortedMap<K, V> headMap(K k) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, k)) == null) ? headMap(k, false) : (SortedMap) invokeL.objValue;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSortedMap, java.util.SortedMap, java.util.NavigableMap
        public SortedMap<K, V> subMap(K k, K k2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048599, this, k, k2)) == null) ? subMap(k, true, k2, false) : (SortedMap) invokeLL.objValue;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSortedMap, java.util.SortedMap, java.util.NavigableMap
        public SortedMap<K, V> tailMap(K k) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, k)) == null) ? tailMap(k, true) : (SortedMap) invokeL.objValue;
        }
    }

    /* loaded from: classes11.dex */
    public static class SynchronizedNavigableSet<E> extends SynchronizedSortedSet<E> implements NavigableSet<E> {
        public static /* synthetic */ Interceptable $ic;
        public static final long serialVersionUID = 0;
        public transient /* synthetic */ FieldHolder $fh;
        public transient NavigableSet<E> descendingSet;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SynchronizedNavigableSet(NavigableSet<E> navigableSet, Object obj) {
            super(navigableSet, obj);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {navigableSet, obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((SortedSet) objArr2[0], objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // java.util.NavigableSet
        public E ceiling(E e2) {
            InterceptResult invokeL;
            E ceiling;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, e2)) == null) {
                synchronized (this.mutex) {
                    ceiling = delegate().ceiling(e2);
                }
                return ceiling;
            }
            return (E) invokeL.objValue;
        }

        @Override // java.util.NavigableSet
        public Iterator<E> descendingIterator() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? delegate().descendingIterator() : (Iterator) invokeV.objValue;
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> descendingSet() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                synchronized (this.mutex) {
                    if (this.descendingSet == null) {
                        NavigableSet<E> l = Synchronized.l(delegate().descendingSet(), this.mutex);
                        this.descendingSet = l;
                        return l;
                    }
                    return this.descendingSet;
                }
            }
            return (NavigableSet) invokeV.objValue;
        }

        @Override // java.util.NavigableSet
        public E floor(E e2) {
            InterceptResult invokeL;
            E floor;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, e2)) == null) {
                synchronized (this.mutex) {
                    floor = delegate().floor(e2);
                }
                return floor;
            }
            return (E) invokeL.objValue;
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> headSet(E e2, boolean z) {
            InterceptResult invokeLZ;
            NavigableSet<E> l;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048585, this, e2, z)) == null) {
                synchronized (this.mutex) {
                    l = Synchronized.l(delegate().headSet(e2, z), this.mutex);
                }
                return l;
            }
            return (NavigableSet) invokeLZ.objValue;
        }

        @Override // java.util.NavigableSet
        public E higher(E e2) {
            InterceptResult invokeL;
            E higher;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, e2)) == null) {
                synchronized (this.mutex) {
                    higher = delegate().higher(e2);
                }
                return higher;
            }
            return (E) invokeL.objValue;
        }

        @Override // java.util.NavigableSet
        public E lower(E e2) {
            InterceptResult invokeL;
            E lower;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, e2)) == null) {
                synchronized (this.mutex) {
                    lower = delegate().lower(e2);
                }
                return lower;
            }
            return (E) invokeL.objValue;
        }

        @Override // java.util.NavigableSet
        public E pollFirst() {
            InterceptResult invokeV;
            E pollFirst;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
                synchronized (this.mutex) {
                    pollFirst = delegate().pollFirst();
                }
                return pollFirst;
            }
            return (E) invokeV.objValue;
        }

        @Override // java.util.NavigableSet
        public E pollLast() {
            InterceptResult invokeV;
            E pollLast;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
                synchronized (this.mutex) {
                    pollLast = delegate().pollLast();
                }
                return pollLast;
            }
            return (E) invokeV.objValue;
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> subSet(E e2, boolean z, E e3, boolean z2) {
            InterceptResult invokeCommon;
            NavigableSet<E> l;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048591, this, new Object[]{e2, Boolean.valueOf(z), e3, Boolean.valueOf(z2)})) == null) {
                synchronized (this.mutex) {
                    l = Synchronized.l(delegate().subSet(e2, z, e3, z2), this.mutex);
                }
                return l;
            }
            return (NavigableSet) invokeCommon.objValue;
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> tailSet(E e2, boolean z) {
            InterceptResult invokeLZ;
            NavigableSet<E> l;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048593, this, e2, z)) == null) {
                synchronized (this.mutex) {
                    l = Synchronized.l(delegate().tailSet(e2, z), this.mutex);
                }
                return l;
            }
            return (NavigableSet) invokeLZ.objValue;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSortedSet, java.util.SortedSet, java.util.NavigableSet
        public SortedSet<E> headSet(E e2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, e2)) == null) ? headSet(e2, false) : (SortedSet) invokeL.objValue;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSortedSet, java.util.SortedSet, java.util.NavigableSet
        public SortedSet<E> tailSet(E e2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, e2)) == null) ? tailSet(e2, true) : (SortedSet) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.Synchronized.SynchronizedSortedSet, com.google.common.collect.Synchronized.SynchronizedSet, com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        public NavigableSet<E> delegate() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (NavigableSet) super.delegate() : (NavigableSet) invokeV.objValue;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSortedSet, java.util.SortedSet, java.util.NavigableSet
        public SortedSet<E> subSet(E e2, E e3) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048592, this, e2, e3)) == null) ? subSet(e2, true, e3, false) : (SortedSet) invokeLL.objValue;
        }
    }

    /* loaded from: classes11.dex */
    public static class SynchronizedSortedSet<E> extends SynchronizedSet<E> implements SortedSet<E> {
        public static /* synthetic */ Interceptable $ic;
        public static final long serialVersionUID = 0;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SynchronizedSortedSet(SortedSet<E> sortedSet, Object obj) {
            super(sortedSet, obj);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sortedSet, obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Set) objArr2[0], objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // java.util.SortedSet
        public Comparator<? super E> comparator() {
            InterceptResult invokeV;
            Comparator<? super E> comparator;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                synchronized (this.mutex) {
                    comparator = delegate().comparator();
                }
                return comparator;
            }
            return (Comparator) invokeV.objValue;
        }

        @Override // java.util.SortedSet
        public E first() {
            InterceptResult invokeV;
            E first;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                synchronized (this.mutex) {
                    first = delegate().first();
                }
                return first;
            }
            return (E) invokeV.objValue;
        }

        public SortedSet<E> headSet(E e2) {
            InterceptResult invokeL;
            SortedSet<E> p;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, e2)) == null) {
                synchronized (this.mutex) {
                    p = Synchronized.p(delegate().headSet(e2), this.mutex);
                }
                return p;
            }
            return (SortedSet) invokeL.objValue;
        }

        @Override // java.util.SortedSet
        public E last() {
            InterceptResult invokeV;
            E last;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                synchronized (this.mutex) {
                    last = delegate().last();
                }
                return last;
            }
            return (E) invokeV.objValue;
        }

        public SortedSet<E> subSet(E e2, E e3) {
            InterceptResult invokeLL;
            SortedSet<E> p;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, e2, e3)) == null) {
                synchronized (this.mutex) {
                    p = Synchronized.p(delegate().subSet(e2, e3), this.mutex);
                }
                return p;
            }
            return (SortedSet) invokeLL.objValue;
        }

        public SortedSet<E> tailSet(E e2) {
            InterceptResult invokeL;
            SortedSet<E> p;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, e2)) == null) {
                synchronized (this.mutex) {
                    p = Synchronized.p(delegate().tailSet(e2), this.mutex);
                }
                return p;
            }
            return (SortedSet) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.Synchronized.SynchronizedSet, com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        public SortedSet<E> delegate() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? (SortedSet) super.delegate() : (SortedSet) invokeV.objValue;
        }
    }
}
