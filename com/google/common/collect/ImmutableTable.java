package com.google.common.collect;

import androidx.core.view.InputDeviceCompat;
import c.i.d.a.j;
import c.i.d.a.n;
import c.i.d.c.i;
import c.i.d.c.k1;
import c.i.d.c.o0;
import c.i.d.c.o1;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Tables;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes10.dex */
public abstract class ImmutableTable<R, C, V> extends i<R, C, V> implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes10.dex */
    public static final class SerializedForm implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public static final long serialVersionUID = 0;
        public transient /* synthetic */ FieldHolder $fh;
        public final int[] cellColumnIndices;
        public final int[] cellRowIndices;
        public final Object[] cellValues;
        public final Object[] columnKeys;
        public final Object[] rowKeys;

        public SerializedForm(Object[] objArr, Object[] objArr2, Object[] objArr3, int[] iArr, int[] iArr2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr4 = {objArr, objArr2, objArr3, iArr, iArr2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.rowKeys = objArr;
            this.columnKeys = objArr2;
            this.cellValues = objArr3;
            this.cellRowIndices = iArr;
            this.cellColumnIndices = iArr2;
        }

        public static SerializedForm create(ImmutableTable<?, ?, ?> immutableTable, int[] iArr, int[] iArr2) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, immutableTable, iArr, iArr2)) == null) ? new SerializedForm(immutableTable.rowKeySet().toArray(), immutableTable.columnKeySet().toArray(), immutableTable.values().toArray(), iArr, iArr2) : (SerializedForm) invokeLLL.objValue;
        }

        public Object readResolve() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeV = interceptable.invokeV(1048576, this)) != null) {
                return invokeV.objValue;
            }
            Object[] objArr = this.cellValues;
            if (objArr.length == 0) {
                return ImmutableTable.of();
            }
            int i2 = 0;
            if (objArr.length == 1) {
                return ImmutableTable.of(this.rowKeys[0], this.columnKeys[0], objArr[0]);
            }
            ImmutableList.a aVar = new ImmutableList.a(objArr.length);
            while (true) {
                Object[] objArr2 = this.cellValues;
                if (i2 < objArr2.length) {
                    aVar.h(ImmutableTable.cellOf(this.rowKeys[this.cellRowIndices[i2]], this.columnKeys[this.cellColumnIndices[i2]], objArr2[i2]));
                    i2++;
                } else {
                    return RegularImmutableTable.forOrderedComponents(aVar.j(), ImmutableSet.copyOf(this.rowKeys), ImmutableSet.copyOf(this.columnKeys));
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public static final class a<R, C, V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final List<k1.a<R, C, V>> f70538a;

        /* renamed from: b  reason: collision with root package name */
        public Comparator<? super R> f70539b;

        /* renamed from: c  reason: collision with root package name */
        public Comparator<? super C> f70540c;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f70538a = Lists.i();
        }

        public ImmutableTable<R, C, V> a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                int size = this.f70538a.size();
                if (size != 0) {
                    if (size != 1) {
                        return RegularImmutableTable.forCells(this.f70538a, this.f70539b, this.f70540c);
                    }
                    return new SingletonImmutableTable((k1.a) o0.i(this.f70538a));
                }
                return ImmutableTable.of();
            }
            return (ImmutableTable) invokeV.objValue;
        }

        public a<R, C, V> b(k1.a<? extends R, ? extends C, ? extends V> aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar)) == null) {
                if (aVar instanceof Tables.ImmutableCell) {
                    n.q(aVar.getRowKey(), "row");
                    n.q(aVar.getColumnKey(), "column");
                    n.q(aVar.getValue(), "value");
                    this.f70538a.add(aVar);
                } else {
                    c(aVar.getRowKey(), aVar.getColumnKey(), aVar.getValue());
                }
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a<R, C, V> c(R r, C c2, V v) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, r, c2, v)) == null) {
                this.f70538a.add(ImmutableTable.cellOf(r, c2, v));
                return this;
            }
            return (a) invokeLLL.objValue;
        }
    }

    public ImmutableTable() {
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

    public static <R, C, V> a<R, C, V> builder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? new a<>() : (a) invokeV.objValue;
    }

    public static <R, C, V> k1.a<R, C, V> cellOf(R r, C c2, V v) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, r, c2, v)) == null) {
            n.q(r, "rowKey");
            n.q(c2, "columnKey");
            n.q(v, "value");
            return Tables.c(r, c2, v);
        }
        return (k1.a) invokeLLL.objValue;
    }

    public static <R, C, V> ImmutableTable<R, C, V> copyOf(k1<? extends R, ? extends C, ? extends V> k1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, k1Var)) == null) {
            if (k1Var instanceof ImmutableTable) {
                return (ImmutableTable) k1Var;
            }
            return copyOf(k1Var.cellSet());
        }
        return (ImmutableTable) invokeL.objValue;
    }

    public static <R, C, V> ImmutableTable<R, C, V> of() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? (ImmutableTable<R, C, V>) SparseImmutableTable.EMPTY : (ImmutableTable) invokeV.objValue;
    }

    @Override // c.i.d.c.i, c.i.d.c.k1
    @Deprecated
    public final void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            throw new UnsupportedOperationException();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // c.i.d.c.k1
    public /* bridge */ /* synthetic */ Map column(Object obj) {
        return column((ImmutableTable<R, C, V>) obj);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.i.d.c.k1
    public abstract ImmutableMap<C, Map<R, V>> columnMap();

    @Override // c.i.d.c.i, c.i.d.c.k1
    public boolean contains(Object obj, Object obj2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, obj, obj2)) == null) ? get(obj, obj2) != null : invokeLL.booleanValue;
    }

    @Override // c.i.d.c.i, c.i.d.c.k1
    public /* bridge */ /* synthetic */ boolean containsColumn(Object obj) {
        return super.containsColumn(obj);
    }

    @Override // c.i.d.c.i, c.i.d.c.k1
    public /* bridge */ /* synthetic */ boolean containsRow(Object obj) {
        return super.containsRow(obj);
    }

    @Override // c.i.d.c.i, c.i.d.c.k1
    public boolean containsValue(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, obj)) == null) ? values().contains(obj) : invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.i.d.c.i
    public abstract ImmutableSet<k1.a<R, C, V>> createCellSet();

    public abstract SerializedForm createSerializedForm();

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.i.d.c.i
    public abstract ImmutableCollection<V> createValues();

    @Override // c.i.d.c.i, c.i.d.c.k1
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // c.i.d.c.i, c.i.d.c.k1
    public /* bridge */ /* synthetic */ Object get(Object obj, Object obj2) {
        return super.get(obj, obj2);
    }

    @Override // c.i.d.c.i, c.i.d.c.k1
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // c.i.d.c.i, c.i.d.c.k1
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // c.i.d.c.i, c.i.d.c.k1
    @Deprecated
    public final V put(R r, C c2, V v) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048600, this, r, c2, v)) == null) {
            throw new UnsupportedOperationException();
        }
        return (V) invokeLLL.objValue;
    }

    @Override // c.i.d.c.i, c.i.d.c.k1
    @Deprecated
    public final void putAll(k1<? extends R, ? extends C, ? extends V> k1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, k1Var) == null) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // c.i.d.c.i, c.i.d.c.k1
    @Deprecated
    public final V remove(Object obj, Object obj2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048602, this, obj, obj2)) == null) {
            throw new UnsupportedOperationException();
        }
        return (V) invokeLL.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // c.i.d.c.k1
    public /* bridge */ /* synthetic */ Map row(Object obj) {
        return row((ImmutableTable<R, C, V>) obj);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.i.d.c.k1
    public abstract ImmutableMap<R, Map<C, V>> rowMap();

    @Override // c.i.d.c.k1
    public abstract /* synthetic */ int size();

    @Override // c.i.d.c.i
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // c.i.d.c.i
    public final Iterator<V> valuesIterator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            throw new AssertionError("should never be called");
        }
        return (Iterator) invokeV.objValue;
    }

    public final Object writeReplace() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? createSerializedForm() : invokeV.objValue;
    }

    public static <R, C, V> ImmutableTable<R, C, V> of(R r, C c2, V v) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(AdIconUtil.BAIDU_LOGO_ID, null, r, c2, v)) == null) ? new SingletonImmutableTable(r, c2, v) : (ImmutableTable) invokeLLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.i.d.c.i
    public final o1<k1.a<R, C, V>> cellIterator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            throw new AssertionError("should never be called");
        }
        return (o1) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.i.d.c.i, c.i.d.c.k1
    public ImmutableSet<k1.a<R, C, V>> cellSet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? (ImmutableSet) super.cellSet() : (ImmutableSet) invokeV.objValue;
    }

    @Override // c.i.d.c.k1
    public ImmutableMap<R, V> column(C c2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, c2)) == null) {
            n.q(c2, "columnKey");
            return (ImmutableMap) j.a((ImmutableMap) columnMap().get(c2), ImmutableMap.of());
        }
        return (ImmutableMap) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.i.d.c.i, c.i.d.c.k1
    public ImmutableSet<C> columnKeySet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? columnMap().keySet() : (ImmutableSet) invokeV.objValue;
    }

    @Override // c.i.d.c.k1
    public ImmutableMap<C, V> row(R r) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, r)) == null) {
            n.q(r, "rowKey");
            return (ImmutableMap) j.a((ImmutableMap) rowMap().get(r), ImmutableMap.of());
        }
        return (ImmutableMap) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.i.d.c.i, c.i.d.c.k1
    public ImmutableSet<R> rowKeySet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? rowMap().keySet() : (ImmutableSet) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.i.d.c.i, c.i.d.c.k1
    public ImmutableCollection<V> values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? (ImmutableCollection) super.values() : (ImmutableCollection) invokeV.objValue;
    }

    public static <R, C, V> ImmutableTable<R, C, V> copyOf(Iterable<? extends k1.a<? extends R, ? extends C, ? extends V>> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, iterable)) == null) {
            a builder = builder();
            for (k1.a<? extends R, ? extends C, ? extends V> aVar : iterable) {
                builder.b(aVar);
            }
            return builder.a();
        }
        return (ImmutableTable) invokeL.objValue;
    }
}
