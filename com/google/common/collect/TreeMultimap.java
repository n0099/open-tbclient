package com.google.common.collect;

import androidx.core.view.InputDeviceCompat;
import c.i.d.a.n;
import c.i.d.c.d1;
import c.i.d.c.q0;
import c.i.d.c.s0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
/* loaded from: classes2.dex */
public class TreeMultimap<K, V> extends AbstractSortedKeySortedSetMultimap<K, V> {
    public static /* synthetic */ Interceptable $ic;
    public static final long serialVersionUID = 0;
    public transient /* synthetic */ FieldHolder $fh;
    public transient Comparator<? super K> keyComparator;
    public transient Comparator<? super V> valueComparator;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TreeMultimap(Comparator<? super K> comparator, Comparator<? super V> comparator2) {
        super(new TreeMap(comparator));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {comparator, comparator2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((SortedMap) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.keyComparator = comparator;
        this.valueComparator = comparator2;
    }

    public static <K extends Comparable, V extends Comparable> TreeMultimap<K, V> create() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? new TreeMultimap<>(Ordering.natural(), Ordering.natural()) : (TreeMultimap) invokeV.objValue;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, this, objectInputStream) == null) {
            objectInputStream.defaultReadObject();
            Comparator<? super K> comparator = (Comparator) objectInputStream.readObject();
            n.p(comparator);
            this.keyComparator = comparator;
            Comparator<? super V> comparator2 = (Comparator) objectInputStream.readObject();
            n.p(comparator2);
            this.valueComparator = comparator2;
            setMap(new TreeMap(this.keyComparator));
            d1.d(this, objectInputStream);
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, this, objectOutputStream) == null) {
            objectOutputStream.defaultWriteObject();
            objectOutputStream.writeObject(keyComparator());
            objectOutputStream.writeObject(valueComparator());
            d1.j(this, objectOutputStream);
        }
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, c.i.d.c.q0
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    @Override // c.i.d.c.c, c.i.d.c.q0
    public /* bridge */ /* synthetic */ boolean containsEntry(Object obj, Object obj2) {
        return super.containsEntry(obj, obj2);
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, c.i.d.c.q0
    public /* bridge */ /* synthetic */ boolean containsKey(Object obj) {
        return super.containsKey(obj);
    }

    @Override // c.i.d.c.c, c.i.d.c.q0
    public /* bridge */ /* synthetic */ boolean containsValue(Object obj) {
        return super.containsValue(obj);
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, c.i.d.c.c
    public Map<K, Collection<V>> createAsMap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? createMaybeNavigableAsMap() : (Map) invokeV.objValue;
    }

    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, c.i.d.c.c, c.i.d.c.q0
    public /* bridge */ /* synthetic */ Set entries() {
        return super.entries();
    }

    @Override // com.google.common.collect.AbstractSetMultimap, c.i.d.c.c, c.i.d.c.q0
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractSortedSetMultimap, com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, c.i.d.c.q0
    public /* bridge */ /* synthetic */ Collection get(Object obj) {
        return get((TreeMultimap<K, V>) obj);
    }

    @Override // c.i.d.c.c, c.i.d.c.q0
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // c.i.d.c.c, c.i.d.c.q0
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Deprecated
    public Comparator<? super K> keyComparator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.keyComparator : (Comparator) invokeV.objValue;
    }

    @Override // c.i.d.c.c, c.i.d.c.q0
    public /* bridge */ /* synthetic */ s0 keys() {
        return super.keys();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, c.i.d.c.c, c.i.d.c.q0
    public /* bridge */ /* synthetic */ boolean put(Object obj, Object obj2) {
        return super.put(obj, obj2);
    }

    @Override // c.i.d.c.c, c.i.d.c.q0
    public /* bridge */ /* synthetic */ boolean putAll(q0 q0Var) {
        return super.putAll(q0Var);
    }

    @Override // c.i.d.c.c, c.i.d.c.q0
    public /* bridge */ /* synthetic */ boolean remove(Object obj, Object obj2) {
        return super.remove(obj, obj2);
    }

    @Override // com.google.common.collect.AbstractSortedSetMultimap, com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, c.i.d.c.q0
    public /* bridge */ /* synthetic */ SortedSet removeAll(Object obj) {
        return super.removeAll(obj);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractSortedSetMultimap, com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, c.i.d.c.c, c.i.d.c.q0
    public /* bridge */ /* synthetic */ SortedSet replaceValues(Object obj, Iterable iterable) {
        return super.replaceValues((TreeMultimap<K, V>) obj, iterable);
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, c.i.d.c.q0
    public /* bridge */ /* synthetic */ int size() {
        return super.size();
    }

    @Override // c.i.d.c.c
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // com.google.common.collect.AbstractSortedKeySortedSetMultimap, com.google.common.collect.AbstractSortedSetMultimap, c.i.d.c.j1
    public Comparator<? super V> valueComparator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.valueComparator : (Comparator) invokeV.objValue;
    }

    @Override // com.google.common.collect.AbstractSortedSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, c.i.d.c.c, c.i.d.c.q0
    public /* bridge */ /* synthetic */ Collection values() {
        return super.values();
    }

    public static <K, V> TreeMultimap<K, V> create(Comparator<? super K> comparator, Comparator<? super V> comparator2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, comparator, comparator2)) == null) {
            n.p(comparator);
            n.p(comparator2);
            return new TreeMultimap<>(comparator, comparator2);
        }
        return (TreeMultimap) invokeLL.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractSortedSetMultimap, com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, c.i.d.c.q0
    public /* bridge */ /* synthetic */ Set get(Object obj) {
        return get((TreeMultimap<K, V>) obj);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // c.i.d.c.c, c.i.d.c.q0
    public /* bridge */ /* synthetic */ boolean putAll(Object obj, Iterable iterable) {
        return super.putAll(obj, iterable);
    }

    public static <K extends Comparable, V extends Comparable> TreeMultimap<K, V> create(q0<? extends K, ? extends V> q0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, q0Var)) == null) ? new TreeMultimap<>(Ordering.natural(), Ordering.natural(), q0Var) : (TreeMultimap) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.common.collect.AbstractSortedKeySortedSetMultimap, com.google.common.collect.AbstractSortedSetMultimap, com.google.common.collect.AbstractSetMultimap, c.i.d.c.c, c.i.d.c.q0
    public NavigableMap<K, Collection<V>> asMap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (NavigableMap) super.asMap() : (NavigableMap) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.common.collect.AbstractSortedSetMultimap, com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap
    public SortedSet<V> createCollection() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? new TreeSet(this.valueComparator) : (SortedSet) invokeV.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractSortedSetMultimap, com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, c.i.d.c.q0
    public /* bridge */ /* synthetic */ SortedSet get(Object obj) {
        return get((TreeMultimap<K, V>) obj);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.common.collect.AbstractSortedKeySortedSetMultimap, c.i.d.c.c, c.i.d.c.q0
    public NavigableSet<K> keySet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? (NavigableSet) super.keySet() : (NavigableSet) invokeV.objValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TreeMultimap(Comparator<? super K> comparator, Comparator<? super V> comparator2, q0<? extends K, ? extends V> q0Var) {
        this(comparator, comparator2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {comparator, comparator2, q0Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Comparator) objArr2[0], (Comparator) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        putAll(q0Var);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: K */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractMapBasedMultimap
    public Collection<V> createCollection(K k2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, k2)) == null) {
            if (k2 == 0) {
                keyComparator().compare(k2, k2);
            }
            return super.createCollection(k2);
        }
        return (Collection) invokeL.objValue;
    }

    @Override // com.google.common.collect.AbstractSortedSetMultimap, com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, c.i.d.c.q0
    public NavigableSet<V> get(K k2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, k2)) == null) ? (NavigableSet) super.get((TreeMultimap<K, V>) k2) : (NavigableSet) invokeL.objValue;
    }
}
