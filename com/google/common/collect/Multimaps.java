package com.google.common.collect;

import androidx.core.view.InputDeviceCompat;
import c.i.d.a.g;
import c.i.d.a.n;
import c.i.d.a.o;
import c.i.d.a.r;
import c.i.d.c.d;
import c.i.d.c.e1;
import c.i.d.c.f0;
import c.i.d.c.j1;
import c.i.d.c.m;
import c.i.d.c.m1;
import c.i.d.c.p0;
import c.i.d.c.q0;
import c.i.d.c.s0;
import c.i.d.c.t;
import c.i.d.c.w;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.common.base.Predicates;
import com.google.common.collect.AbstractMapBasedMultimap;
import com.google.common.collect.Maps;
import com.google.common.collect.Multisets;
import com.google.common.collect.Sets;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedSet;
/* loaded from: classes10.dex */
public final class Multimaps {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes10.dex */
    public static class CustomListMultimap<K, V> extends AbstractListMultimap<K, V> {
        public static /* synthetic */ Interceptable $ic;
        public static final long serialVersionUID = 0;
        public transient /* synthetic */ FieldHolder $fh;
        public transient r<? extends List<V>> factory;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CustomListMultimap(Map<K, Collection<V>> map, r<? extends List<V>> rVar) {
            super(map);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {map, rVar};
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
            n.p(rVar);
            this.factory = rVar;
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65537, this, objectInputStream) == null) {
                objectInputStream.defaultReadObject();
                this.factory = (r) objectInputStream.readObject();
                setMap((Map) objectInputStream.readObject());
            }
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65538, this, objectOutputStream) == null) {
                objectOutputStream.defaultWriteObject();
                objectOutputStream.writeObject(this.factory);
                objectOutputStream.writeObject(backingMap());
            }
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap, c.i.d.c.c
        public Map<K, Collection<V>> createAsMap() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? createMaybeNavigableAsMap() : (Map) invokeV.objValue;
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap, c.i.d.c.c
        public Set<K> createKeySet() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? createMaybeNavigableKeySet() : (Set) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.AbstractListMultimap, com.google.common.collect.AbstractMapBasedMultimap
        public List<V> createCollection() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.factory.get() : (List) invokeV.objValue;
        }
    }

    /* loaded from: classes10.dex */
    public static class CustomMultimap<K, V> extends AbstractMapBasedMultimap<K, V> {
        public static /* synthetic */ Interceptable $ic;
        public static final long serialVersionUID = 0;
        public transient /* synthetic */ FieldHolder $fh;
        public transient r<? extends Collection<V>> factory;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CustomMultimap(Map<K, Collection<V>> map, r<? extends Collection<V>> rVar) {
            super(map);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {map, rVar};
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
            n.p(rVar);
            this.factory = rVar;
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65537, this, objectInputStream) == null) {
                objectInputStream.defaultReadObject();
                this.factory = (r) objectInputStream.readObject();
                setMap((Map) objectInputStream.readObject());
            }
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65538, this, objectOutputStream) == null) {
                objectOutputStream.defaultWriteObject();
                objectOutputStream.writeObject(this.factory);
                objectOutputStream.writeObject(backingMap());
            }
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap, c.i.d.c.c
        public Map<K, Collection<V>> createAsMap() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? createMaybeNavigableAsMap() : (Map) invokeV.objValue;
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap
        public Collection<V> createCollection() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.factory.get() : (Collection) invokeV.objValue;
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap, c.i.d.c.c
        public Set<K> createKeySet() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? createMaybeNavigableKeySet() : (Set) invokeV.objValue;
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap
        public <E> Collection<E> unmodifiableCollectionSubclass(Collection<E> collection) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, collection)) == null) {
                if (collection instanceof NavigableSet) {
                    return Sets.m((NavigableSet) collection);
                }
                if (collection instanceof SortedSet) {
                    return Collections.unmodifiableSortedSet((SortedSet) collection);
                }
                if (collection instanceof Set) {
                    return Collections.unmodifiableSet((Set) collection);
                }
                if (collection instanceof List) {
                    return Collections.unmodifiableList((List) collection);
                }
                return Collections.unmodifiableCollection(collection);
            }
            return (Collection) invokeL.objValue;
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap
        public Collection<V> wrapCollection(K k, Collection<V> collection) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, k, collection)) == null) {
                if (collection instanceof List) {
                    return wrapList(k, (List) collection, null);
                }
                if (collection instanceof NavigableSet) {
                    return new AbstractMapBasedMultimap.m(this, k, (NavigableSet) collection, null);
                }
                if (collection instanceof SortedSet) {
                    return new AbstractMapBasedMultimap.o(this, k, (SortedSet) collection, null);
                }
                if (collection instanceof Set) {
                    return new AbstractMapBasedMultimap.n(this, k, (Set) collection);
                }
                return new AbstractMapBasedMultimap.k(this, k, collection, null);
            }
            return (Collection) invokeLL.objValue;
        }
    }

    /* loaded from: classes10.dex */
    public static class CustomSetMultimap<K, V> extends AbstractSetMultimap<K, V> {
        public static /* synthetic */ Interceptable $ic;
        public static final long serialVersionUID = 0;
        public transient /* synthetic */ FieldHolder $fh;
        public transient r<? extends Set<V>> factory;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CustomSetMultimap(Map<K, Collection<V>> map, r<? extends Set<V>> rVar) {
            super(map);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {map, rVar};
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
            n.p(rVar);
            this.factory = rVar;
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65537, this, objectInputStream) == null) {
                objectInputStream.defaultReadObject();
                this.factory = (r) objectInputStream.readObject();
                setMap((Map) objectInputStream.readObject());
            }
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65538, this, objectOutputStream) == null) {
                objectOutputStream.defaultWriteObject();
                objectOutputStream.writeObject(this.factory);
                objectOutputStream.writeObject(backingMap());
            }
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap, c.i.d.c.c
        public Map<K, Collection<V>> createAsMap() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? createMaybeNavigableAsMap() : (Map) invokeV.objValue;
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap, c.i.d.c.c
        public Set<K> createKeySet() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? createMaybeNavigableKeySet() : (Set) invokeV.objValue;
        }

        @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap
        public <E> Collection<E> unmodifiableCollectionSubclass(Collection<E> collection) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, collection)) == null) {
                if (collection instanceof NavigableSet) {
                    return Sets.m((NavigableSet) collection);
                }
                if (collection instanceof SortedSet) {
                    return Collections.unmodifiableSortedSet((SortedSet) collection);
                }
                return Collections.unmodifiableSet((Set) collection);
            }
            return (Collection) invokeL.objValue;
        }

        @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap
        public Collection<V> wrapCollection(K k, Collection<V> collection) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, k, collection)) == null) {
                if (collection instanceof NavigableSet) {
                    return new AbstractMapBasedMultimap.m(this, k, (NavigableSet) collection, null);
                }
                if (collection instanceof SortedSet) {
                    return new AbstractMapBasedMultimap.o(this, k, (SortedSet) collection, null);
                }
                return new AbstractMapBasedMultimap.n(this, k, (Set) collection);
            }
            return (Collection) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap
        public Set<V> createCollection() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.factory.get() : (Set) invokeV.objValue;
        }
    }

    /* loaded from: classes10.dex */
    public static class MapMultimap<K, V> extends c.i.d.c.c<K, V> implements e1<K, V>, Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 7845222491160860175L;
        public transient /* synthetic */ FieldHolder $fh;
        public final Map<K, V> map;

        /* loaded from: classes10.dex */
        public class a extends Sets.c<V> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Object f70494e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ MapMultimap f70495f;

            /* renamed from: com.google.common.collect.Multimaps$MapMultimap$a$a  reason: collision with other inner class name */
            /* loaded from: classes10.dex */
            public class C1957a implements Iterator<V> {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public int f70496e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ a f70497f;

                public C1957a(a aVar) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {aVar};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f70497f = aVar;
                }

                @Override // java.util.Iterator
                public boolean hasNext() {
                    InterceptResult invokeV;
                    Interceptable interceptable = $ic;
                    if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                        if (this.f70496e == 0) {
                            a aVar = this.f70497f;
                            if (aVar.f70495f.map.containsKey(aVar.f70494e)) {
                                return true;
                            }
                        }
                        return false;
                    }
                    return invokeV.booleanValue;
                }

                @Override // java.util.Iterator
                public V next() {
                    InterceptResult invokeV;
                    Interceptable interceptable = $ic;
                    if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        if (hasNext()) {
                            this.f70496e++;
                            a aVar = this.f70497f;
                            return aVar.f70495f.map.get(aVar.f70494e);
                        }
                        throw new NoSuchElementException();
                    }
                    return (V) invokeV.objValue;
                }

                @Override // java.util.Iterator
                public void remove() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                        m.e(this.f70496e == 1);
                        this.f70496e = -1;
                        a aVar = this.f70497f;
                        aVar.f70495f.map.remove(aVar.f70494e);
                    }
                }
            }

            public a(MapMultimap mapMultimap, Object obj) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {mapMultimap, obj};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f70495f = mapMultimap;
                this.f70494e = obj;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<V> iterator() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new C1957a(this) : (Iterator) invokeV.objValue;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f70495f.map.containsKey(this.f70494e) ? 1 : 0 : invokeV.intValue;
            }
        }

        public MapMultimap(Map<K, V> map) {
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
            n.p(map);
            this.map = map;
        }

        @Override // c.i.d.c.q0
        public void clear() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.map.clear();
            }
        }

        @Override // c.i.d.c.c, c.i.d.c.q0
        public boolean containsEntry(Object obj, Object obj2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj, obj2)) == null) ? this.map.entrySet().contains(Maps.l(obj, obj2)) : invokeLL.booleanValue;
        }

        @Override // c.i.d.c.q0
        public boolean containsKey(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) ? this.map.containsKey(obj) : invokeL.booleanValue;
        }

        @Override // c.i.d.c.c, c.i.d.c.q0
        public boolean containsValue(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) ? this.map.containsValue(obj) : invokeL.booleanValue;
        }

        @Override // c.i.d.c.c
        public Map<K, Collection<V>> createAsMap() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? new a(this) : (Map) invokeV.objValue;
        }

        @Override // c.i.d.c.c
        public Collection<Map.Entry<K, V>> createEntries() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                throw new AssertionError("unreachable");
            }
            return (Collection) invokeV.objValue;
        }

        @Override // c.i.d.c.c
        public Set<K> createKeySet() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.map.keySet() : (Set) invokeV.objValue;
        }

        @Override // c.i.d.c.c
        public s0<K> createKeys() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? new c(this) : (s0) invokeV.objValue;
        }

        @Override // c.i.d.c.c
        public Collection<V> createValues() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.map.values() : (Collection) invokeV.objValue;
        }

        @Override // c.i.d.c.c
        public Iterator<Map.Entry<K, V>> entryIterator() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.map.entrySet().iterator() : (Iterator) invokeV.objValue;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // c.i.d.c.q0
        public /* bridge */ /* synthetic */ Collection get(Object obj) {
            return get((MapMultimap<K, V>) obj);
        }

        @Override // c.i.d.c.c, c.i.d.c.q0
        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.map.hashCode() : invokeV.intValue;
        }

        @Override // c.i.d.c.c, c.i.d.c.q0
        public boolean put(K k, V v) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, k, v)) == null) {
                throw new UnsupportedOperationException();
            }
            return invokeLL.booleanValue;
        }

        @Override // c.i.d.c.c, c.i.d.c.q0
        public boolean putAll(K k, Iterable<? extends V> iterable) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048593, this, k, iterable)) == null) {
                throw new UnsupportedOperationException();
            }
            return invokeLL.booleanValue;
        }

        @Override // c.i.d.c.c, c.i.d.c.q0
        public boolean remove(Object obj, Object obj2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048594, this, obj, obj2)) == null) ? this.map.entrySet().remove(Maps.l(obj, obj2)) : invokeLL.booleanValue;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // c.i.d.c.c, c.i.d.c.q0
        public /* bridge */ /* synthetic */ Collection replaceValues(Object obj, Iterable iterable) {
            return replaceValues((MapMultimap<K, V>) obj, iterable);
        }

        @Override // c.i.d.c.q0
        public int size() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.map.size() : invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.i.d.c.c, c.i.d.c.q0
        public Set<Map.Entry<K, V>> entries() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.map.entrySet() : (Set) invokeV.objValue;
        }

        @Override // c.i.d.c.q0
        public Set<V> get(K k) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, k)) == null) ? new a(this, k) : (Set) invokeL.objValue;
        }

        @Override // c.i.d.c.c, c.i.d.c.q0
        public boolean putAll(q0<? extends K, ? extends V> q0Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, q0Var)) == null) {
                throw new UnsupportedOperationException();
            }
            return invokeL.booleanValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.i.d.c.q0
        public Set<V> removeAll(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, obj)) == null) {
                HashSet hashSet = new HashSet(2);
                if (this.map.containsKey(obj)) {
                    hashSet.add(this.map.remove(obj));
                    return hashSet;
                }
                return hashSet;
            }
            return (Set) invokeL.objValue;
        }

        @Override // c.i.d.c.c, c.i.d.c.q0
        public Set<V> replaceValues(K k, Iterable<? extends V> iterable) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048598, this, k, iterable)) == null) {
                throw new UnsupportedOperationException();
            }
            return (Set) invokeLL.objValue;
        }
    }

    /* loaded from: classes10.dex */
    public static class UnmodifiableListMultimap<K, V> extends UnmodifiableMultimap<K, V> implements p0<K, V> {
        public static /* synthetic */ Interceptable $ic;
        public static final long serialVersionUID = 0;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UnmodifiableListMultimap(p0<K, V> p0Var) {
            super(p0Var);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((q0) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, c.i.d.c.f0, c.i.d.c.q0
        public /* bridge */ /* synthetic */ Collection get(Object obj) {
            return get((UnmodifiableListMultimap<K, V>) obj);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, c.i.d.c.f0, c.i.d.c.q0
        public /* bridge */ /* synthetic */ Collection replaceValues(Object obj, Iterable iterable) {
            return replaceValues((UnmodifiableListMultimap<K, V>) obj, iterable);
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, c.i.d.c.f0, c.i.d.c.q0
        public List<V> get(K k) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, k)) == null) ? Collections.unmodifiableList(delegate().get((p0<K, V>) k)) : (List) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, c.i.d.c.f0, c.i.d.c.q0
        public List<V> removeAll(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, obj)) == null) {
                throw new UnsupportedOperationException();
            }
            return (List) invokeL.objValue;
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, c.i.d.c.f0, c.i.d.c.q0
        public List<V> replaceValues(K k, Iterable<? extends V> iterable) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, k, iterable)) == null) {
                throw new UnsupportedOperationException();
            }
            return (List) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, c.i.d.c.f0, c.i.d.c.h0
        public p0<K, V> delegate() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (p0) super.delegate() : (p0) invokeV.objValue;
        }
    }

    /* loaded from: classes10.dex */
    public static class UnmodifiableMultimap<K, V> extends f0<K, V> implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public static final long serialVersionUID = 0;
        public transient /* synthetic */ FieldHolder $fh;
        public final q0<K, V> delegate;
        public transient Collection<Map.Entry<K, V>> entries;
        public transient Set<K> keySet;
        public transient s0<K> keys;
        public transient Map<K, Collection<V>> map;
        public transient Collection<V> values;

        /* loaded from: classes10.dex */
        public class a implements g<Collection<V>, Collection<V>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(UnmodifiableMultimap unmodifiableMultimap) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {unmodifiableMultimap};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.i.d.a.g
            /* renamed from: a */
            public Collection<V> apply(Collection<V> collection) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, collection)) == null) ? Multimaps.h(collection) : (Collection) invokeL.objValue;
            }
        }

        public UnmodifiableMultimap(q0<K, V> q0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            n.p(q0Var);
            this.delegate = q0Var;
        }

        @Override // c.i.d.c.f0, c.i.d.c.q0
        public Map<K, Collection<V>> asMap() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                Map<K, Collection<V>> map = this.map;
                if (map == null) {
                    Map<K, Collection<V>> unmodifiableMap = Collections.unmodifiableMap(Maps.G(this.delegate.asMap(), new a(this)));
                    this.map = unmodifiableMap;
                    return unmodifiableMap;
                }
                return map;
            }
            return (Map) invokeV.objValue;
        }

        @Override // c.i.d.c.f0, c.i.d.c.q0
        public void clear() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                throw new UnsupportedOperationException();
            }
        }

        @Override // c.i.d.c.f0, c.i.d.c.q0
        public Collection<Map.Entry<K, V>> entries() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                Collection<Map.Entry<K, V>> collection = this.entries;
                if (collection == null) {
                    Collection<Map.Entry<K, V>> g2 = Multimaps.g(this.delegate.entries());
                    this.entries = g2;
                    return g2;
                }
                return collection;
            }
            return (Collection) invokeV.objValue;
        }

        @Override // c.i.d.c.f0, c.i.d.c.q0
        public Collection<V> get(K k) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, k)) == null) ? Multimaps.h(this.delegate.get(k)) : (Collection) invokeL.objValue;
        }

        @Override // c.i.d.c.f0, c.i.d.c.q0
        public Set<K> keySet() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                Set<K> set = this.keySet;
                if (set == null) {
                    Set<K> unmodifiableSet = Collections.unmodifiableSet(this.delegate.keySet());
                    this.keySet = unmodifiableSet;
                    return unmodifiableSet;
                }
                return set;
            }
            return (Set) invokeV.objValue;
        }

        @Override // c.i.d.c.f0, c.i.d.c.q0
        public s0<K> keys() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                s0<K> s0Var = this.keys;
                if (s0Var == null) {
                    s0<K> p = Multisets.p(this.delegate.keys());
                    this.keys = p;
                    return p;
                }
                return s0Var;
            }
            return (s0) invokeV.objValue;
        }

        @Override // c.i.d.c.f0, c.i.d.c.q0
        public boolean put(K k, V v) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, k, v)) == null) {
                throw new UnsupportedOperationException();
            }
            return invokeLL.booleanValue;
        }

        @Override // c.i.d.c.f0, c.i.d.c.q0
        public boolean putAll(K k, Iterable<? extends V> iterable) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, k, iterable)) == null) {
                throw new UnsupportedOperationException();
            }
            return invokeLL.booleanValue;
        }

        @Override // c.i.d.c.f0, c.i.d.c.q0
        public boolean remove(Object obj, Object obj2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, obj, obj2)) == null) {
                throw new UnsupportedOperationException();
            }
            return invokeLL.booleanValue;
        }

        @Override // c.i.d.c.f0, c.i.d.c.q0
        public Collection<V> removeAll(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, obj)) == null) {
                throw new UnsupportedOperationException();
            }
            return (Collection) invokeL.objValue;
        }

        @Override // c.i.d.c.f0, c.i.d.c.q0
        public Collection<V> replaceValues(K k, Iterable<? extends V> iterable) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, k, iterable)) == null) {
                throw new UnsupportedOperationException();
            }
            return (Collection) invokeLL.objValue;
        }

        @Override // c.i.d.c.f0, c.i.d.c.q0
        public Collection<V> values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
                Collection<V> collection = this.values;
                if (collection == null) {
                    Collection<V> unmodifiableCollection = Collections.unmodifiableCollection(this.delegate.values());
                    this.values = unmodifiableCollection;
                    return unmodifiableCollection;
                }
                return collection;
            }
            return (Collection) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.i.d.c.f0, c.i.d.c.h0
        public q0<K, V> delegate() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.delegate : (q0) invokeV.objValue;
        }

        @Override // c.i.d.c.f0, c.i.d.c.q0
        public boolean putAll(q0<? extends K, ? extends V> q0Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, q0Var)) == null) {
                throw new UnsupportedOperationException();
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes10.dex */
    public static class UnmodifiableSetMultimap<K, V> extends UnmodifiableMultimap<K, V> implements e1<K, V> {
        public static /* synthetic */ Interceptable $ic;
        public static final long serialVersionUID = 0;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UnmodifiableSetMultimap(e1<K, V> e1Var) {
            super(e1Var);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((q0) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, c.i.d.c.f0, c.i.d.c.q0
        public /* bridge */ /* synthetic */ Collection get(Object obj) {
            return get((UnmodifiableSetMultimap<K, V>) obj);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, c.i.d.c.f0, c.i.d.c.q0
        public /* bridge */ /* synthetic */ Collection replaceValues(Object obj, Iterable iterable) {
            return replaceValues((UnmodifiableSetMultimap<K, V>) obj, iterable);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, c.i.d.c.f0, c.i.d.c.q0
        public Set<Map.Entry<K, V>> entries() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? Maps.K(delegate().entries()) : (Set) invokeV.objValue;
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, c.i.d.c.f0, c.i.d.c.q0
        public Set<V> get(K k) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, k)) == null) ? Collections.unmodifiableSet(delegate().get((e1<K, V>) k)) : (Set) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, c.i.d.c.f0, c.i.d.c.q0
        public Set<V> removeAll(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, obj)) == null) {
                throw new UnsupportedOperationException();
            }
            return (Set) invokeL.objValue;
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, c.i.d.c.f0, c.i.d.c.q0
        public Set<V> replaceValues(K k, Iterable<? extends V> iterable) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, k, iterable)) == null) {
                throw new UnsupportedOperationException();
            }
            return (Set) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, c.i.d.c.f0, c.i.d.c.h0
        public e1<K, V> delegate() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (e1) super.delegate() : (e1) invokeV.objValue;
        }
    }

    /* loaded from: classes10.dex */
    public static class UnmodifiableSortedSetMultimap<K, V> extends UnmodifiableSetMultimap<K, V> implements j1<K, V> {
        public static /* synthetic */ Interceptable $ic;
        public static final long serialVersionUID = 0;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UnmodifiableSortedSetMultimap(j1<K, V> j1Var) {
            super(j1Var);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((e1) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Multimaps.UnmodifiableSetMultimap, com.google.common.collect.Multimaps.UnmodifiableMultimap, c.i.d.c.f0, c.i.d.c.q0
        public /* bridge */ /* synthetic */ Collection get(Object obj) {
            return get((UnmodifiableSortedSetMultimap<K, V>) obj);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Multimaps.UnmodifiableSetMultimap, com.google.common.collect.Multimaps.UnmodifiableMultimap, c.i.d.c.f0, c.i.d.c.q0
        public /* bridge */ /* synthetic */ Collection replaceValues(Object obj, Iterable iterable) {
            return replaceValues((UnmodifiableSortedSetMultimap<K, V>) obj, iterable);
        }

        @Override // c.i.d.c.j1
        public Comparator<? super V> valueComparator() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? delegate().valueComparator() : (Comparator) invokeV.objValue;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Multimaps.UnmodifiableSetMultimap, com.google.common.collect.Multimaps.UnmodifiableMultimap, c.i.d.c.f0, c.i.d.c.q0
        public /* bridge */ /* synthetic */ Set get(Object obj) {
            return get((UnmodifiableSortedSetMultimap<K, V>) obj);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Multimaps.UnmodifiableSetMultimap, com.google.common.collect.Multimaps.UnmodifiableMultimap, c.i.d.c.f0, c.i.d.c.q0
        public /* bridge */ /* synthetic */ Set replaceValues(Object obj, Iterable iterable) {
            return replaceValues((UnmodifiableSortedSetMultimap<K, V>) obj, iterable);
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableSetMultimap, com.google.common.collect.Multimaps.UnmodifiableMultimap, c.i.d.c.f0, c.i.d.c.q0
        public SortedSet<V> get(K k) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, k)) == null) ? Collections.unmodifiableSortedSet(delegate().get((j1<K, V>) k)) : (SortedSet) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.Multimaps.UnmodifiableSetMultimap, com.google.common.collect.Multimaps.UnmodifiableMultimap, c.i.d.c.f0, c.i.d.c.q0
        public SortedSet<V> removeAll(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, obj)) == null) {
                throw new UnsupportedOperationException();
            }
            return (SortedSet) invokeL.objValue;
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableSetMultimap, com.google.common.collect.Multimaps.UnmodifiableMultimap, c.i.d.c.f0, c.i.d.c.q0
        public SortedSet<V> replaceValues(K k, Iterable<? extends V> iterable) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, k, iterable)) == null) {
                throw new UnsupportedOperationException();
            }
            return (SortedSet) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.Multimaps.UnmodifiableSetMultimap, com.google.common.collect.Multimaps.UnmodifiableMultimap, c.i.d.c.f0, c.i.d.c.h0
        public j1<K, V> delegate() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (j1) super.delegate() : (j1) invokeV.objValue;
        }
    }

    /* loaded from: classes10.dex */
    public static final class a<K, V> extends Maps.y<K, Collection<V>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: h  reason: collision with root package name */
        public final q0<K, V> f70498h;

        /* renamed from: com.google.common.collect.Multimaps$a$a  reason: collision with other inner class name */
        /* loaded from: classes10.dex */
        public class C1958a extends Maps.k<K, Collection<V>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f70499e;

            /* renamed from: com.google.common.collect.Multimaps$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes10.dex */
            public class C1959a implements g<K, Collection<V>> {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ C1958a f70500e;

                public C1959a(C1958a c1958a) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {c1958a};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f70500e = c1958a;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // c.i.d.a.g
                /* renamed from: a */
                public Collection<V> apply(K k) {
                    InterceptResult invokeL;
                    Interceptable interceptable = $ic;
                    return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, k)) == null) ? this.f70500e.f70499e.f70498h.get(k) : (Collection) invokeL.objValue;
                }
            }

            public C1958a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f70499e = aVar;
            }

            @Override // com.google.common.collect.Maps.k
            public Map<K, Collection<V>> b() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f70499e : (Map) invokeV.objValue;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<K, Collection<V>>> iterator() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? Maps.d(this.f70499e.f70498h.keySet(), new C1959a(this)) : (Iterator) invokeV.objValue;
            }

            @Override // com.google.common.collect.Maps.k, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object obj) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) {
                    if (contains(obj)) {
                        this.f70499e.g(((Map.Entry) obj).getKey());
                        return true;
                    }
                    return false;
                }
                return invokeL.booleanValue;
            }
        }

        public a(q0<K, V> q0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            n.p(q0Var);
            this.f70498h = q0Var;
        }

        @Override // com.google.common.collect.Maps.y
        public Set<Map.Entry<K, Collection<V>>> a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new C1958a(this) : (Set) invokeV.objValue;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f70498h.clear();
            }
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) ? this.f70498h.containsKey(obj) : invokeL.booleanValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.AbstractMap, java.util.Map
        /* renamed from: e */
        public Collection<V> get(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
                if (containsKey(obj)) {
                    return this.f70498h.get(obj);
                }
                return null;
            }
            return (Collection) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.AbstractMap, java.util.Map
        /* renamed from: f */
        public Collection<V> remove(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, obj)) == null) {
                if (containsKey(obj)) {
                    return this.f70498h.removeAll(obj);
                }
                return null;
            }
            return (Collection) invokeL.objValue;
        }

        public void g(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, obj) == null) {
                this.f70498h.keySet().remove(obj);
            }
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean isEmpty() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f70498h.isEmpty() : invokeV.booleanValue;
        }

        @Override // com.google.common.collect.Maps.y, java.util.AbstractMap, java.util.Map
        public Set<K> keySet() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f70498h.keySet() : (Set) invokeV.objValue;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f70498h.keySet().size() : invokeV.intValue;
        }
    }

    /* loaded from: classes10.dex */
    public static abstract class b<K, V> extends AbstractCollection<Map.Entry<K, V>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public abstract q0<K, V> b();

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                b().clear();
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) {
                if (obj instanceof Map.Entry) {
                    Map.Entry entry = (Map.Entry) obj;
                    return b().containsEntry(entry.getKey(), entry.getValue());
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
                if (obj instanceof Map.Entry) {
                    Map.Entry entry = (Map.Entry) obj;
                    return b().remove(entry.getKey(), entry.getValue());
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? b().size() : invokeV.intValue;
        }
    }

    /* loaded from: classes10.dex */
    public static class c<K, V> extends d<K> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final q0<K, V> f70501e;

        /* loaded from: classes10.dex */
        public class a extends m1<Map.Entry<K, Collection<V>>, s0.a<K>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: com.google.common.collect.Multimaps$c$a$a  reason: collision with other inner class name */
            /* loaded from: classes10.dex */
            public class C1960a extends Multisets.b<K> {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Map.Entry f70502e;

                public C1960a(a aVar, Map.Entry entry) {
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
                    this.f70502e = entry;
                }

                @Override // c.i.d.c.s0.a
                public int getCount() {
                    InterceptResult invokeV;
                    Interceptable interceptable = $ic;
                    return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? ((Collection) this.f70502e.getValue()).size() : invokeV.intValue;
                }

                @Override // c.i.d.c.s0.a
                public K getElement() {
                    InterceptResult invokeV;
                    Interceptable interceptable = $ic;
                    return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (K) this.f70502e.getKey() : (K) invokeV.objValue;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(c cVar, Iterator it) {
                super(it);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, it};
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
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.i.d.c.m1
            /* renamed from: b */
            public s0.a<K> a(Map.Entry<K, Collection<V>> entry) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, entry)) == null) ? new C1960a(this, entry) : (s0.a) invokeL.objValue;
            }
        }

        public c(q0<K, V> q0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f70501e = q0Var;
        }

        @Override // c.i.d.c.d, java.util.AbstractCollection, java.util.Collection
        public void clear() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f70501e.clear();
            }
        }

        @Override // c.i.d.c.d, java.util.AbstractCollection, java.util.Collection, c.i.d.c.s0
        public boolean contains(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) ? this.f70501e.containsKey(obj) : invokeL.booleanValue;
        }

        @Override // c.i.d.c.s0
        public int count(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) {
                Collection collection = (Collection) Maps.A(this.f70501e.asMap(), obj);
                if (collection == null) {
                    return 0;
                }
                return collection.size();
            }
            return invokeL.intValue;
        }

        @Override // c.i.d.c.d
        public int distinctElements() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f70501e.asMap().size() : invokeV.intValue;
        }

        @Override // c.i.d.c.d
        public Iterator<K> elementIterator() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                throw new AssertionError("should never be called");
            }
            return (Iterator) invokeV.objValue;
        }

        @Override // c.i.d.c.d, c.i.d.c.s0
        public Set<K> elementSet() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f70501e.keySet() : (Set) invokeV.objValue;
        }

        @Override // c.i.d.c.d
        public Iterator<s0.a<K>> entryIterator() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? new a(this, this.f70501e.asMap().entrySet().iterator()) : (Iterator) invokeV.objValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, c.i.d.c.s0
        public Iterator<K> iterator() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? Maps.o(this.f70501e.entries().iterator()) : (Iterator) invokeV.objValue;
        }

        @Override // c.i.d.c.d, c.i.d.c.s0
        public int remove(Object obj, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, obj, i2)) == null) {
                m.b(i2, "occurrences");
                if (i2 == 0) {
                    return count(obj);
                }
                Collection collection = (Collection) Maps.A(this.f70501e.asMap(), obj);
                if (collection == null) {
                    return 0;
                }
                int size = collection.size();
                if (i2 >= size) {
                    collection.clear();
                } else {
                    Iterator it = collection.iterator();
                    for (int i3 = 0; i3 < i2; i3++) {
                        it.next();
                        it.remove();
                    }
                }
                return size;
            }
            return invokeLI.intValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, c.i.d.c.s0
        public int size() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f70501e.size() : invokeV.intValue;
        }
    }

    public static boolean c(q0<?, ?> q0Var, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, q0Var, obj)) == null) {
            if (obj == q0Var) {
                return true;
            }
            if (obj instanceof q0) {
                return q0Var.asMap().equals(((q0) obj).asMap());
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static <K, V> e1<K, V> d(w<K, V> wVar, o<? super Map.Entry<K, V>> oVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, wVar, oVar)) == null) ? new c.i.d.c.r(wVar.b(), Predicates.c(wVar.c(), oVar)) : (e1) invokeLL.objValue;
    }

    public static <K, V> e1<K, V> e(e1<K, V> e1Var, o<? super K> oVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, e1Var, oVar)) == null) {
            if (e1Var instanceof t) {
                t tVar = (t) e1Var;
                return new t(tVar.b(), Predicates.c(tVar.f34129f, oVar));
            } else if (e1Var instanceof w) {
                return d((w) e1Var, Maps.q(oVar));
            } else {
                return new t(e1Var, oVar);
            }
        }
        return (e1) invokeLL.objValue;
    }

    public static <K, V> e1<K, V> f(Map<K, Collection<V>> map, r<? extends Set<V>> rVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, map, rVar)) == null) ? new CustomSetMultimap(map, rVar) : (e1) invokeLL.objValue;
    }

    public static <K, V> Collection<Map.Entry<K, V>> g(Collection<Map.Entry<K, V>> collection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, collection)) == null) {
            if (collection instanceof Set) {
                return Maps.K((Set) collection);
            }
            return new Maps.v(Collections.unmodifiableCollection(collection));
        }
        return (Collection) invokeL.objValue;
    }

    public static <V> Collection<V> h(Collection<V> collection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, collection)) == null) {
            if (collection instanceof SortedSet) {
                return Collections.unmodifiableSortedSet((SortedSet) collection);
            }
            if (collection instanceof Set) {
                return Collections.unmodifiableSet((Set) collection);
            }
            if (collection instanceof List) {
                return Collections.unmodifiableList((List) collection);
            }
            return Collections.unmodifiableCollection(collection);
        }
        return (Collection) invokeL.objValue;
    }

    /* loaded from: classes10.dex */
    public static class CustomSortedSetMultimap<K, V> extends AbstractSortedSetMultimap<K, V> {
        public static /* synthetic */ Interceptable $ic;
        public static final long serialVersionUID = 0;
        public transient /* synthetic */ FieldHolder $fh;
        public transient r<? extends SortedSet<V>> factory;
        public transient Comparator<? super V> valueComparator;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CustomSortedSetMultimap(Map<K, Collection<V>> map, r<? extends SortedSet<V>> rVar) {
            super(map);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {map, rVar};
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
            n.p(rVar);
            this.factory = rVar;
            this.valueComparator = rVar.get().comparator();
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65537, this, objectInputStream) == null) {
                objectInputStream.defaultReadObject();
                r<? extends SortedSet<V>> rVar = (r) objectInputStream.readObject();
                this.factory = rVar;
                this.valueComparator = rVar.get().comparator();
                setMap((Map) objectInputStream.readObject());
            }
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65538, this, objectOutputStream) == null) {
                objectOutputStream.defaultWriteObject();
                objectOutputStream.writeObject(this.factory);
                objectOutputStream.writeObject(backingMap());
            }
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap, c.i.d.c.c
        public Map<K, Collection<V>> createAsMap() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? createMaybeNavigableAsMap() : (Map) invokeV.objValue;
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap, c.i.d.c.c
        public Set<K> createKeySet() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? createMaybeNavigableKeySet() : (Set) invokeV.objValue;
        }

        @Override // com.google.common.collect.AbstractSortedSetMultimap, c.i.d.c.j1
        public Comparator<? super V> valueComparator() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.valueComparator : (Comparator) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.AbstractSortedSetMultimap, com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap
        public SortedSet<V> createCollection() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.factory.get() : (SortedSet) invokeV.objValue;
        }
    }
}
