package com.google.common.collect;

import androidx.core.view.InputDeviceCompat;
import c.i.d.c.k1;
import c.i.d.c.o1;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableTable;
import java.lang.reflect.Array;
import java.util.Map;
/* loaded from: classes9.dex */
public final class DenseImmutableTable<R, C, V> extends RegularImmutableTable<R, C, V> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int[] cellColumnIndices;
    public final int[] cellRowIndices;
    public final int[] columnCounts;
    public final ImmutableMap<C, Integer> columnKeyToIndex;
    public final ImmutableMap<C, ImmutableMap<R, V>> columnMap;
    public final int[] rowCounts;
    public final ImmutableMap<R, Integer> rowKeyToIndex;
    public final ImmutableMap<R, ImmutableMap<C, V>> rowMap;
    public final V[][] values;

    /* loaded from: classes9.dex */
    public final class Column extends ImmutableArrayMap<R, V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int columnIndex;
        public final /* synthetic */ DenseImmutableTable this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Column(DenseImmutableTable denseImmutableTable, int i2) {
            super(denseImmutableTable.columnCounts[i2]);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {denseImmutableTable, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = denseImmutableTable;
            this.columnIndex = i2;
        }

        @Override // com.google.common.collect.DenseImmutableTable.ImmutableArrayMap
        public V getValue(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? (V) this.this$0.values[i2][this.columnIndex] : (V) invokeI.objValue;
        }

        @Override // com.google.common.collect.ImmutableMap
        public boolean isPartialView() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }

        @Override // com.google.common.collect.DenseImmutableTable.ImmutableArrayMap
        public ImmutableMap<R, Integer> keyToIndex() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.this$0.rowKeyToIndex : (ImmutableMap) invokeV.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public final class ColumnMap extends ImmutableArrayMap<C, ImmutableMap<R, V>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DenseImmutableTable this$0;

        public /* synthetic */ ColumnMap(DenseImmutableTable denseImmutableTable, a aVar) {
            this(denseImmutableTable);
        }

        @Override // com.google.common.collect.ImmutableMap
        public boolean isPartialView() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.google.common.collect.DenseImmutableTable.ImmutableArrayMap
        public ImmutableMap<C, Integer> keyToIndex() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.this$0.columnKeyToIndex : (ImmutableMap) invokeV.objValue;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ColumnMap(DenseImmutableTable denseImmutableTable) {
            super(denseImmutableTable.columnCounts.length);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {denseImmutableTable};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = denseImmutableTable;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.DenseImmutableTable.ImmutableArrayMap
        public ImmutableMap<R, V> getValue(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? new Column(this.this$0, i2) : (ImmutableMap) invokeI.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static abstract class ImmutableArrayMap<K, V> extends ImmutableMap.IteratorBasedImmutableMap<K, V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int size;

        /* loaded from: classes9.dex */
        public class a extends AbstractIterator<Map.Entry<K, V>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: g  reason: collision with root package name */
            public int f70779g;

            /* renamed from: h  reason: collision with root package name */
            public final int f70780h;

            /* renamed from: i  reason: collision with root package name */
            public final /* synthetic */ ImmutableArrayMap f70781i;

            public a(ImmutableArrayMap immutableArrayMap) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {immutableArrayMap};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f70781i = immutableArrayMap;
                this.f70779g = -1;
                this.f70780h = this.f70781i.keyToIndex().size();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.common.collect.AbstractIterator
            /* renamed from: d */
            public Map.Entry<K, V> a() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable != null && (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) != null) {
                    return (Map.Entry) invokeV.objValue;
                }
                int i2 = this.f70779g;
                while (true) {
                    this.f70779g = i2 + 1;
                    int i3 = this.f70779g;
                    if (i3 < this.f70780h) {
                        Object value = this.f70781i.getValue(i3);
                        if (value != null) {
                            return Maps.l(this.f70781i.getKey(this.f70779g), value);
                        }
                        i2 = this.f70779g;
                    } else {
                        return b();
                    }
                }
            }
        }

        public ImmutableArrayMap(int i2) {
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
            this.size = i2;
        }

        private boolean isFull() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) ? this.size == keyToIndex().size() : invokeV.booleanValue;
        }

        @Override // com.google.common.collect.ImmutableMap.IteratorBasedImmutableMap, com.google.common.collect.ImmutableMap
        public ImmutableSet<K> createKeySet() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? isFull() ? keyToIndex().keySet() : super.createKeySet() : (ImmutableSet) invokeV.objValue;
        }

        @Override // com.google.common.collect.ImmutableMap.IteratorBasedImmutableMap
        public o1<Map.Entry<K, V>> entryIterator() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new a(this) : (o1) invokeV.objValue;
        }

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        public V get(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) {
                Integer num = keyToIndex().get(obj);
                if (num == null) {
                    return null;
                }
                return getValue(num.intValue());
            }
            return (V) invokeL.objValue;
        }

        public K getKey(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) ? keyToIndex().keySet().asList().get(i2) : (K) invokeI.objValue;
        }

        public abstract V getValue(int i2);

        public abstract ImmutableMap<K, Integer> keyToIndex();

        @Override // java.util.Map
        public int size() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.size : invokeV.intValue;
        }
    }

    /* loaded from: classes9.dex */
    public final class Row extends ImmutableArrayMap<C, V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int rowIndex;
        public final /* synthetic */ DenseImmutableTable this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Row(DenseImmutableTable denseImmutableTable, int i2) {
            super(denseImmutableTable.rowCounts[i2]);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {denseImmutableTable, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = denseImmutableTable;
            this.rowIndex = i2;
        }

        @Override // com.google.common.collect.DenseImmutableTable.ImmutableArrayMap
        public V getValue(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? (V) this.this$0.values[this.rowIndex][i2] : (V) invokeI.objValue;
        }

        @Override // com.google.common.collect.ImmutableMap
        public boolean isPartialView() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }

        @Override // com.google.common.collect.DenseImmutableTable.ImmutableArrayMap
        public ImmutableMap<C, Integer> keyToIndex() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.this$0.columnKeyToIndex : (ImmutableMap) invokeV.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public final class RowMap extends ImmutableArrayMap<R, ImmutableMap<C, V>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DenseImmutableTable this$0;

        public /* synthetic */ RowMap(DenseImmutableTable denseImmutableTable, a aVar) {
            this(denseImmutableTable);
        }

        @Override // com.google.common.collect.ImmutableMap
        public boolean isPartialView() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.google.common.collect.DenseImmutableTable.ImmutableArrayMap
        public ImmutableMap<R, Integer> keyToIndex() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.this$0.rowKeyToIndex : (ImmutableMap) invokeV.objValue;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RowMap(DenseImmutableTable denseImmutableTable) {
            super(denseImmutableTable.rowCounts.length);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {denseImmutableTable};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = denseImmutableTable;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.DenseImmutableTable.ImmutableArrayMap
        public ImmutableMap<C, V> getValue(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? new Row(this.this$0, i2) : (ImmutableMap) invokeI.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    public DenseImmutableTable(ImmutableList<k1.a<R, C, V>> immutableList, ImmutableSet<R> immutableSet, ImmutableSet<C> immutableSet2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {immutableList, immutableSet, immutableSet2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.values = (V[][]) ((Object[][]) Array.newInstance(Object.class, immutableSet.size(), immutableSet2.size()));
        this.rowKeyToIndex = Maps.m(immutableSet);
        this.columnKeyToIndex = Maps.m(immutableSet2);
        this.rowCounts = new int[this.rowKeyToIndex.size()];
        this.columnCounts = new int[this.columnKeyToIndex.size()];
        int[] iArr = new int[immutableList.size()];
        int[] iArr2 = new int[immutableList.size()];
        for (int i4 = 0; i4 < immutableList.size(); i4++) {
            k1.a<R, C, V> aVar = immutableList.get(i4);
            R rowKey = aVar.getRowKey();
            C columnKey = aVar.getColumnKey();
            int intValue = this.rowKeyToIndex.get(rowKey).intValue();
            int intValue2 = this.columnKeyToIndex.get(columnKey).intValue();
            checkNoDuplicate(rowKey, columnKey, this.values[intValue][intValue2], aVar.getValue());
            this.values[intValue][intValue2] = aVar.getValue();
            int[] iArr3 = this.rowCounts;
            iArr3[intValue] = iArr3[intValue] + 1;
            int[] iArr4 = this.columnCounts;
            iArr4[intValue2] = iArr4[intValue2] + 1;
            iArr[i4] = intValue;
            iArr2[i4] = intValue2;
        }
        this.cellRowIndices = iArr;
        this.cellColumnIndices = iArr2;
        this.rowMap = new RowMap(this, null);
        this.columnMap = new ColumnMap(this, null);
    }

    @Override // com.google.common.collect.ImmutableTable
    public ImmutableTable.SerializedForm createSerializedForm() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? ImmutableTable.SerializedForm.create(this, this.cellRowIndices, this.cellColumnIndices) : (ImmutableTable.SerializedForm) invokeV.objValue;
    }

    @Override // com.google.common.collect.ImmutableTable, c.i.d.c.i, c.i.d.c.k1
    public V get(Object obj, Object obj2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, obj, obj2)) == null) {
            Integer num = this.rowKeyToIndex.get(obj);
            Integer num2 = this.columnKeyToIndex.get(obj2);
            if (num == null || num2 == null) {
                return null;
            }
            return this.values[num.intValue()][num2.intValue()];
        }
        return (V) invokeLL.objValue;
    }

    @Override // com.google.common.collect.RegularImmutableTable
    public k1.a<R, C, V> getCell(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            int i3 = this.cellRowIndices[i2];
            int i4 = this.cellColumnIndices[i2];
            return ImmutableTable.cellOf(rowKeySet().asList().get(i3), columnKeySet().asList().get(i4), this.values[i3][i4]);
        }
        return (k1.a) invokeI.objValue;
    }

    @Override // com.google.common.collect.RegularImmutableTable
    public V getValue(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) ? this.values[this.cellRowIndices[i2]][this.cellColumnIndices[i2]] : (V) invokeI.objValue;
    }

    @Override // com.google.common.collect.RegularImmutableTable, com.google.common.collect.ImmutableTable, c.i.d.c.k1
    public int size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.cellRowIndices.length : invokeV.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.common.collect.ImmutableTable, c.i.d.c.k1
    public ImmutableMap<C, Map<R, V>> columnMap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? ImmutableMap.copyOf((Map) this.columnMap) : (ImmutableMap) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.common.collect.ImmutableTable, c.i.d.c.k1
    public ImmutableMap<R, Map<C, V>> rowMap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? ImmutableMap.copyOf((Map) this.rowMap) : (ImmutableMap) invokeV.objValue;
    }
}
