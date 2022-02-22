package com.google.common.collect;

import androidx.core.view.InputDeviceCompat;
import c.i.d.a.n;
import c.i.d.c.k1;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
/* loaded from: classes3.dex */
public abstract class RegularImmutableTable<R, C, V> extends ImmutableTable<R, C, V> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public final class CellSet extends IndexedImmutableSet<k1.a<R, C, V>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RegularImmutableTable this$0;

        public CellSet(RegularImmutableTable regularImmutableTable) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {regularImmutableTable};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = regularImmutableTable;
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                if (obj instanceof k1.a) {
                    k1.a aVar = (k1.a) obj;
                    Object obj2 = this.this$0.get(aVar.getRowKey(), aVar.getColumnKey());
                    return obj2 != null && obj2.equals(aVar.getValue());
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.this$0.size() : invokeV.intValue;
        }

        public /* synthetic */ CellSet(RegularImmutableTable regularImmutableTable, a aVar) {
            this(regularImmutableTable);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.IndexedImmutableSet
        public k1.a<R, C, V> get(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? this.this$0.getCell(i2) : (k1.a) invokeI.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public final class Values extends ImmutableList<V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RegularImmutableTable this$0;

        public Values(RegularImmutableTable regularImmutableTable) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {regularImmutableTable};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = regularImmutableTable;
        }

        @Override // java.util.List
        public V get(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? (V) this.this$0.getValue(i2) : (V) invokeI.objValue;
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.this$0.size() : invokeV.intValue;
        }

        public /* synthetic */ Values(RegularImmutableTable regularImmutableTable, a aVar) {
            this(regularImmutableTable);
        }
    }

    /* loaded from: classes3.dex */
    public static class a implements Comparator<k1.a<R, C, V>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Comparator f55019e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Comparator f55020f;

        public a(Comparator comparator, Comparator comparator2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {comparator, comparator2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55019e = comparator;
            this.f55020f = comparator2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(k1.a<R, C, V> aVar, k1.a<R, C, V> aVar2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, aVar, aVar2)) == null) {
                Comparator comparator = this.f55019e;
                int compare = comparator == null ? 0 : comparator.compare(aVar.getRowKey(), aVar2.getRowKey());
                if (compare != 0) {
                    return compare;
                }
                Comparator comparator2 = this.f55020f;
                if (comparator2 == null) {
                    return 0;
                }
                return comparator2.compare(aVar.getColumnKey(), aVar2.getColumnKey());
            }
            return invokeLL.intValue;
        }
    }

    public RegularImmutableTable() {
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

    public static <R, C, V> RegularImmutableTable<R, C, V> forCells(List<k1.a<R, C, V>> list, Comparator<? super R> comparator, Comparator<? super C> comparator2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, list, comparator, comparator2)) == null) {
            n.p(list);
            if (comparator != null || comparator2 != null) {
                Collections.sort(list, new a(comparator, comparator2));
            }
            return forCellsInternal(list, comparator, comparator2);
        }
        return (RegularImmutableTable) invokeLLL.objValue;
    }

    public static <R, C, V> RegularImmutableTable<R, C, V> forCellsInternal(Iterable<k1.a<R, C, V>> iterable, Comparator<? super R> comparator, Comparator<? super C> comparator2) {
        InterceptResult invokeLLL;
        ImmutableSet copyOf;
        ImmutableSet copyOf2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, iterable, comparator, comparator2)) == null) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            LinkedHashSet linkedHashSet2 = new LinkedHashSet();
            ImmutableList copyOf3 = ImmutableList.copyOf(iterable);
            for (k1.a<R, C, V> aVar : iterable) {
                linkedHashSet.add(aVar.getRowKey());
                linkedHashSet2.add(aVar.getColumnKey());
            }
            if (comparator == null) {
                copyOf = ImmutableSet.copyOf((Collection) linkedHashSet);
            } else {
                copyOf = ImmutableSet.copyOf((Collection) ImmutableList.sortedCopyOf(comparator, linkedHashSet));
            }
            if (comparator2 == null) {
                copyOf2 = ImmutableSet.copyOf((Collection) linkedHashSet2);
            } else {
                copyOf2 = ImmutableSet.copyOf((Collection) ImmutableList.sortedCopyOf(comparator2, linkedHashSet2));
            }
            return forOrderedComponents(copyOf3, copyOf, copyOf2);
        }
        return (RegularImmutableTable) invokeLLL.objValue;
    }

    public static <R, C, V> RegularImmutableTable<R, C, V> forOrderedComponents(ImmutableList<k1.a<R, C, V>> immutableList, ImmutableSet<R> immutableSet, ImmutableSet<C> immutableSet2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, immutableList, immutableSet, immutableSet2)) == null) ? ((long) immutableList.size()) > (((long) immutableSet.size()) * ((long) immutableSet2.size())) / 2 ? new DenseImmutableTable(immutableList, immutableSet, immutableSet2) : new SparseImmutableTable(immutableList, immutableSet, immutableSet2) : (RegularImmutableTable) invokeLLL.objValue;
    }

    public final void checkNoDuplicate(R r, C c2, V v, V v2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, r, c2, v, v2) == null) {
            n.m(v == null, "Duplicate key: (row=%s, column=%s), values: [%s, %s].", r, c2, v2, v);
        }
    }

    public abstract k1.a<R, C, V> getCell(int i2);

    public abstract V getValue(int i2);

    @Override // com.google.common.collect.ImmutableTable, c.i.d.c.k1
    public abstract /* synthetic */ int size();

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.common.collect.ImmutableTable, c.i.d.c.i
    public final ImmutableSet<k1.a<R, C, V>> createCellSet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? isEmpty() ? ImmutableSet.of() : new CellSet(this, null) : (ImmutableSet) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.common.collect.ImmutableTable, c.i.d.c.i
    public final ImmutableCollection<V> createValues() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? isEmpty() ? ImmutableList.of() : new Values(this, null) : (ImmutableCollection) invokeV.objValue;
    }

    public static <R, C, V> RegularImmutableTable<R, C, V> forCells(Iterable<k1.a<R, C, V>> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, iterable)) == null) ? forCellsInternal(iterable, null, null) : (RegularImmutableTable) invokeL.objValue;
    }
}
