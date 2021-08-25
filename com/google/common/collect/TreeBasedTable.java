package com.google.common.collect;

import androidx.core.view.InputDeviceCompat;
import c.i.d.a.g;
import c.i.d.a.n;
import c.i.d.a.r;
import c.i.d.c.k1;
import c.i.d.c.o0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.common.collect.Maps;
import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
/* loaded from: classes10.dex */
public class TreeBasedTable<R, C, V> extends StandardRowSortedTable<R, C, V> {
    public static /* synthetic */ Interceptable $ic;
    public static final long serialVersionUID = 0;
    public transient /* synthetic */ FieldHolder $fh;
    public final Comparator<? super C> columnComparator;

    /* loaded from: classes10.dex */
    public static class Factory<C, V> implements r<TreeMap<C, V>>, Serializable {
        public static /* synthetic */ Interceptable $ic;
        public static final long serialVersionUID = 0;
        public transient /* synthetic */ FieldHolder $fh;
        public final Comparator<? super C> comparator;

        public Factory(Comparator<? super C> comparator) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {comparator};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.comparator = comparator;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.i.d.a.r
        public TreeMap<C, V> get() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new TreeMap<>(this.comparator) : (TreeMap) invokeV.objValue;
        }
    }

    /* loaded from: classes10.dex */
    public class a implements g<Map<C, V>, Iterator<C>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(TreeBasedTable treeBasedTable) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {treeBasedTable};
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
        public Iterator<C> apply(Map<C, V> map) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, map)) == null) ? map.keySet().iterator() : (Iterator) invokeL.objValue;
        }
    }

    /* loaded from: classes10.dex */
    public class b extends AbstractIterator<C> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: g  reason: collision with root package name */
        public C f70566g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Iterator f70567h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Comparator f70568i;

        public b(TreeBasedTable treeBasedTable, Iterator it, Comparator comparator) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {treeBasedTable, it, comparator};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f70567h = it;
            this.f70568i = comparator;
        }

        @Override // com.google.common.collect.AbstractIterator
        public C a() {
            boolean z;
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                while (this.f70567h.hasNext()) {
                    C c2 = (C) this.f70567h.next();
                    C c3 = this.f70566g;
                    if (c3 == null || this.f70568i.compare(c2, c3) != 0) {
                        z = false;
                        continue;
                    } else {
                        z = true;
                        continue;
                    }
                    if (!z) {
                        this.f70566g = c2;
                        return c2;
                    }
                }
                this.f70566g = null;
                return b();
            }
            return (C) invokeV.objValue;
        }
    }

    /* loaded from: classes10.dex */
    public class c extends StandardTable<R, C, V>.g implements SortedMap<C, V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: h  reason: collision with root package name */
        public final C f70569h;

        /* renamed from: i  reason: collision with root package name */
        public final C f70570i;

        /* renamed from: j  reason: collision with root package name */
        public transient SortedMap<C, V> f70571j;
        public final /* synthetic */ TreeBasedTable k;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public c(TreeBasedTable treeBasedTable, R r) {
            this(treeBasedTable, r, null, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {treeBasedTable, r};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this((TreeBasedTable) objArr2[0], objArr2[1], objArr2[2], objArr2[3]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // java.util.SortedMap
        public Comparator<? super C> comparator() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.k.columnComparator() : (Comparator) invokeV.objValue;
        }

        @Override // com.google.common.collect.StandardTable.g, java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) ? j(obj) && super.containsKey(obj) : invokeL.booleanValue;
        }

        @Override // com.google.common.collect.StandardTable.g
        public void d() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && k() != null && this.f70571j.isEmpty()) {
                this.k.backingMap.remove(this.f70549e);
                this.f70571j = null;
                this.f70550f = null;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.StandardTable.g
        /* renamed from: f */
        public SortedMap<C, V> b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? (SortedMap) super.b() : (SortedMap) invokeV.objValue;
        }

        @Override // java.util.SortedMap
        public C firstKey() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                if (b() != null) {
                    return b().firstKey();
                }
                throw new NoSuchElementException();
            }
            return (C) invokeV.objValue;
        }

        public int g(Object obj, Object obj2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, obj, obj2)) == null) ? comparator().compare(obj, obj2) : invokeLL.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.StandardTable.g
        /* renamed from: h */
        public SortedMap<C, V> c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                SortedMap<C, V> k = k();
                if (k != null) {
                    C c2 = this.f70569h;
                    if (c2 != null) {
                        k = k.tailMap(c2);
                    }
                    C c3 = this.f70570i;
                    return c3 != null ? k.headMap(c3) : k;
                }
                return null;
            }
            return (SortedMap) invokeV.objValue;
        }

        @Override // java.util.SortedMap
        public SortedMap<C, V> headMap(C c2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, c2)) == null) {
                n.p(c2);
                n.d(j(c2));
                return new c(this.k, this.f70549e, this.f70569h, c2);
            }
            return (SortedMap) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.AbstractMap, java.util.Map, java.util.SortedMap
        /* renamed from: i */
        public SortedSet<C> keySet() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? new Maps.s(this) : (SortedSet) invokeV.objValue;
        }

        public boolean j(Object obj) {
            InterceptResult invokeL;
            C c2;
            C c3;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, obj)) == null) ? obj != null && ((c2 = this.f70569h) == null || g(c2, obj) <= 0) && ((c3 = this.f70570i) == null || g(c3, obj) > 0) : invokeL.booleanValue;
        }

        public SortedMap<C, V> k() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
                SortedMap<C, V> sortedMap = this.f70571j;
                if (sortedMap == null || (sortedMap.isEmpty() && this.k.backingMap.containsKey(this.f70549e))) {
                    this.f70571j = (SortedMap) this.k.backingMap.get(this.f70549e);
                }
                return this.f70571j;
            }
            return (SortedMap) invokeV.objValue;
        }

        @Override // java.util.SortedMap
        public C lastKey() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
                if (b() != null) {
                    return b().lastKey();
                }
                throw new NoSuchElementException();
            }
            return (C) invokeV.objValue;
        }

        @Override // com.google.common.collect.StandardTable.g, java.util.AbstractMap, java.util.Map
        public V put(C c2, V v) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, c2, v)) == null) {
                n.p(c2);
                n.d(j(c2));
                return (V) super.put(c2, v);
            }
            return (V) invokeLL.objValue;
        }

        @Override // java.util.SortedMap
        public SortedMap<C, V> subMap(C c2, C c3) {
            InterceptResult invokeLL;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048592, this, c2, c3)) == null) {
                n.p(c2);
                if (j(c2)) {
                    n.p(c3);
                    if (j(c3)) {
                        z = true;
                        n.d(z);
                        return new c(this.k, this.f70549e, c2, c3);
                    }
                }
                z = false;
                n.d(z);
                return new c(this.k, this.f70549e, c2, c3);
            }
            return (SortedMap) invokeLL.objValue;
        }

        @Override // java.util.SortedMap
        public SortedMap<C, V> tailMap(C c2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, c2)) == null) {
                n.p(c2);
                n.d(j(c2));
                return new c(this.k, this.f70549e, c2, this.f70570i);
            }
            return (SortedMap) invokeL.objValue;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(TreeBasedTable treeBasedTable, R r, C c2, C c3) {
            super(treeBasedTable, r);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {treeBasedTable, r, c2, c3};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((StandardTable) objArr2[0], objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.k = treeBasedTable;
            this.f70569h = c2;
            this.f70570i = c3;
            n.d(c2 == null || c3 == null || g(c2, c3) <= 0);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TreeBasedTable(Comparator<? super R> comparator, Comparator<? super C> comparator2) {
        super(new TreeMap(comparator), new Factory(comparator2));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {comparator, comparator2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((SortedMap) objArr2[0], (r) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.columnComparator = comparator2;
    }

    public static <R extends Comparable, C extends Comparable, V> TreeBasedTable<R, C, V> create() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? new TreeBasedTable<>(Ordering.natural(), Ordering.natural()) : (TreeBasedTable) invokeV.objValue;
    }

    @Override // com.google.common.collect.StandardTable, c.i.d.c.i, c.i.d.c.k1
    public /* bridge */ /* synthetic */ Set cellSet() {
        return super.cellSet();
    }

    @Override // com.google.common.collect.StandardTable, c.i.d.c.i, c.i.d.c.k1
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.StandardTable, c.i.d.c.k1
    public /* bridge */ /* synthetic */ Map column(Object obj) {
        return super.column(obj);
    }

    @Deprecated
    public Comparator<? super C> columnComparator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.columnComparator : (Comparator) invokeV.objValue;
    }

    @Override // com.google.common.collect.StandardTable, c.i.d.c.i, c.i.d.c.k1
    public /* bridge */ /* synthetic */ Set columnKeySet() {
        return super.columnKeySet();
    }

    @Override // com.google.common.collect.StandardTable, c.i.d.c.k1
    public /* bridge */ /* synthetic */ Map columnMap() {
        return super.columnMap();
    }

    @Override // com.google.common.collect.StandardTable, c.i.d.c.i, c.i.d.c.k1
    public /* bridge */ /* synthetic */ boolean contains(Object obj, Object obj2) {
        return super.contains(obj, obj2);
    }

    @Override // com.google.common.collect.StandardTable, c.i.d.c.i, c.i.d.c.k1
    public /* bridge */ /* synthetic */ boolean containsColumn(Object obj) {
        return super.containsColumn(obj);
    }

    @Override // com.google.common.collect.StandardTable, c.i.d.c.i, c.i.d.c.k1
    public /* bridge */ /* synthetic */ boolean containsRow(Object obj) {
        return super.containsRow(obj);
    }

    @Override // com.google.common.collect.StandardTable, c.i.d.c.i, c.i.d.c.k1
    public /* bridge */ /* synthetic */ boolean containsValue(Object obj) {
        return super.containsValue(obj);
    }

    @Override // com.google.common.collect.StandardTable
    public Iterator<C> createColumnKeyIterator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            Comparator<? super C> columnComparator = columnComparator();
            return new b(this, Iterators.r(o0.s(this.backingMap.values(), new a(this)), columnComparator), columnComparator);
        }
        return (Iterator) invokeV.objValue;
    }

    @Override // c.i.d.c.i, c.i.d.c.k1
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // com.google.common.collect.StandardTable, c.i.d.c.i, c.i.d.c.k1
    public /* bridge */ /* synthetic */ Object get(Object obj, Object obj2) {
        return super.get(obj, obj2);
    }

    @Override // c.i.d.c.i, c.i.d.c.k1
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.common.collect.StandardTable, c.i.d.c.i, c.i.d.c.k1
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.lang.Object */
    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.StandardTable, c.i.d.c.i, c.i.d.c.k1
    public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2, Object obj3) {
        return super.put(obj, obj2, obj3);
    }

    @Override // c.i.d.c.i, c.i.d.c.k1
    public /* bridge */ /* synthetic */ void putAll(k1 k1Var) {
        super.putAll(k1Var);
    }

    @Override // com.google.common.collect.StandardTable, c.i.d.c.i, c.i.d.c.k1
    public /* bridge */ /* synthetic */ Object remove(Object obj, Object obj2) {
        return super.remove(obj, obj2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.StandardTable, c.i.d.c.k1
    public /* bridge */ /* synthetic */ Map row(Object obj) {
        return row((TreeBasedTable<R, C, V>) obj);
    }

    @Deprecated
    public Comparator<? super R> rowComparator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? rowKeySet().comparator() : (Comparator) invokeV.objValue;
    }

    @Override // com.google.common.collect.StandardTable, c.i.d.c.k1
    public /* bridge */ /* synthetic */ int size() {
        return super.size();
    }

    @Override // c.i.d.c.i
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // com.google.common.collect.StandardTable, c.i.d.c.i, c.i.d.c.k1
    public /* bridge */ /* synthetic */ Collection values() {
        return super.values();
    }

    public static <R, C, V> TreeBasedTable<R, C, V> create(Comparator<? super R> comparator, Comparator<? super C> comparator2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, comparator, comparator2)) == null) {
            n.p(comparator);
            n.p(comparator2);
            return new TreeBasedTable<>(comparator, comparator2);
        }
        return (TreeBasedTable) invokeLL.objValue;
    }

    @Override // com.google.common.collect.StandardTable, c.i.d.c.k1
    public SortedMap<C, V> row(R r) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, r)) == null) ? new c(this, r) : (SortedMap) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.common.collect.StandardRowSortedTable, com.google.common.collect.StandardTable, c.i.d.c.i, c.i.d.c.k1
    public SortedSet<R> rowKeySet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? super.rowKeySet() : (SortedSet) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.common.collect.StandardRowSortedTable, com.google.common.collect.StandardTable, c.i.d.c.k1
    public SortedMap<R, Map<C, V>> rowMap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? super.rowMap() : (SortedMap) invokeV.objValue;
    }

    public static <R, C, V> TreeBasedTable<R, C, V> create(TreeBasedTable<R, C, ? extends V> treeBasedTable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, treeBasedTable)) == null) {
            TreeBasedTable<R, C, V> treeBasedTable2 = new TreeBasedTable<>(treeBasedTable.rowComparator(), treeBasedTable.columnComparator());
            treeBasedTable2.putAll(treeBasedTable);
            return treeBasedTable2;
        }
        return (TreeBasedTable) invokeL.objValue;
    }
}
