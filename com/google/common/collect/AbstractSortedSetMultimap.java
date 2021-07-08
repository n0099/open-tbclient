package com.google.common.collect;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.common.collect.AbstractMapBasedMultimap;
import d.f.d.c.j1;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;
/* loaded from: classes6.dex */
public abstract class AbstractSortedSetMultimap<K, V> extends AbstractSetMultimap<K, V> implements j1<K, V> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = 430848587173315748L;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractSortedSetMultimap(Map<K, Collection<V>> map) {
        super(map);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {map};
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
    }

    @Override // com.google.common.collect.AbstractSetMultimap, d.f.d.c.c, d.f.d.c.q0
    public Map<K, Collection<V>> asMap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? super.asMap() : (Map) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap
    public abstract SortedSet<V> createCollection();

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, d.f.d.c.q0, d.f.d.c.p0
    public /* bridge */ /* synthetic */ Collection get(Object obj) {
        return get((AbstractSortedSetMultimap<K, V>) obj);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, d.f.d.c.c, d.f.d.c.q0, d.f.d.c.p0
    public /* bridge */ /* synthetic */ Collection replaceValues(Object obj, Iterable iterable) {
        return replaceValues((AbstractSortedSetMultimap<K, V>) obj, iterable);
    }

    public abstract /* synthetic */ Comparator<? super V> valueComparator();

    @Override // com.google.common.collect.AbstractMapBasedMultimap, d.f.d.c.c, d.f.d.c.q0
    public Collection<V> values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? super.values() : (Collection) invokeV.objValue;
    }

    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap
    public Collection<V> wrapCollection(K k, Collection<V> collection) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048596, this, k, collection)) == null) {
            if (collection instanceof NavigableSet) {
                return new AbstractMapBasedMultimap.m(this, k, (NavigableSet) collection, null);
            }
            return new AbstractMapBasedMultimap.o(this, k, (SortedSet) collection, null);
        }
        return (Collection) invokeLL.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, d.f.d.c.q0, d.f.d.c.p0
    public /* bridge */ /* synthetic */ Set get(Object obj) {
        return get((AbstractSortedSetMultimap<K, V>) obj);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, d.f.d.c.c, d.f.d.c.q0, d.f.d.c.p0
    public /* bridge */ /* synthetic */ Set replaceValues(Object obj, Iterable iterable) {
        return replaceValues((AbstractSortedSetMultimap<K, V>) obj, iterable);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap
    public <E> SortedSet<E> unmodifiableCollectionSubclass(Collection<E> collection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, collection)) == null) {
            if (collection instanceof NavigableSet) {
                return Sets.m((NavigableSet) collection);
            }
            return Collections.unmodifiableSortedSet((SortedSet) collection);
        }
        return (SortedSet) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap
    public SortedSet<V> createUnmodifiableEmptyCollection() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? (SortedSet<V>) unmodifiableCollectionSubclass((Collection) createCollection()) : (SortedSet) invokeV.objValue;
    }

    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, d.f.d.c.q0, d.f.d.c.p0
    public SortedSet<V> get(K k) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, k)) == null) ? (SortedSet) super.get((AbstractSortedSetMultimap<K, V>) k) : (SortedSet) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, d.f.d.c.q0, d.f.d.c.p0
    public SortedSet<V> removeAll(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, obj)) == null) ? (SortedSet) super.removeAll(obj) : (SortedSet) invokeL.objValue;
    }

    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, d.f.d.c.c, d.f.d.c.q0, d.f.d.c.p0
    public SortedSet<V> replaceValues(K k, Iterable<? extends V> iterable) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, k, iterable)) == null) ? (SortedSet) super.replaceValues((AbstractSortedSetMultimap<K, V>) k, (Iterable) iterable) : (SortedSet) invokeLL.objValue;
    }
}
