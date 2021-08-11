package com.google.common.collect;

import c.i.d.c.k1;
import c.i.d.c.o1;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableTable;
import java.util.LinkedHashMap;
import java.util.Map;
/* loaded from: classes10.dex */
public final class SparseImmutableTable<R, C, V> extends RegularImmutableTable<R, C, V> {
    public static /* synthetic */ Interceptable $ic;
    public static final ImmutableTable<Object, Object, Object> EMPTY;
    public transient /* synthetic */ FieldHolder $fh;
    public final int[] cellColumnInRowIndices;
    public final int[] cellRowIndices;
    public final ImmutableMap<C, ImmutableMap<R, V>> columnMap;
    public final ImmutableMap<R, ImmutableMap<C, V>> rowMap;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1975518110, "Lcom/google/common/collect/SparseImmutableTable;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1975518110, "Lcom/google/common/collect/SparseImmutableTable;");
                return;
            }
        }
        EMPTY = new SparseImmutableTable(ImmutableList.of(), ImmutableSet.of(), ImmutableSet.of());
    }

    /* JADX DEBUG: Multi-variable search result rejected for r9v0, resolved type: com.google.common.collect.SparseImmutableTable<R, C, V> */
    /* JADX WARN: Multi-variable type inference failed */
    public SparseImmutableTable(ImmutableList<k1.a<R, C, V>> immutableList, ImmutableSet<R> immutableSet, ImmutableSet<C> immutableSet2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {immutableList, immutableSet, immutableSet2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        ImmutableMap m = Maps.m(immutableSet);
        LinkedHashMap v = Maps.v();
        o1<R> it = immutableSet.iterator();
        while (it.hasNext()) {
            v.put(it.next(), new LinkedHashMap());
        }
        LinkedHashMap v2 = Maps.v();
        o1<C> it2 = immutableSet2.iterator();
        while (it2.hasNext()) {
            v2.put(it2.next(), new LinkedHashMap());
        }
        int[] iArr = new int[immutableList.size()];
        int[] iArr2 = new int[immutableList.size()];
        for (int i4 = 0; i4 < immutableList.size(); i4++) {
            k1.a<R, C, V> aVar = immutableList.get(i4);
            R rowKey = aVar.getRowKey();
            C columnKey = aVar.getColumnKey();
            V value = aVar.getValue();
            iArr[i4] = ((Integer) m.get(rowKey)).intValue();
            Map map = (Map) v.get(rowKey);
            iArr2[i4] = map.size();
            checkNoDuplicate(rowKey, columnKey, map.put(columnKey, value), value);
            ((Map) v2.get(columnKey)).put(rowKey, value);
        }
        this.cellRowIndices = iArr;
        this.cellColumnInRowIndices = iArr2;
        ImmutableMap.b bVar = new ImmutableMap.b(v.size());
        for (Map.Entry entry : v.entrySet()) {
            bVar.c(entry.getKey(), ImmutableMap.copyOf((Map) entry.getValue()));
        }
        this.rowMap = bVar.a();
        ImmutableMap.b bVar2 = new ImmutableMap.b(v2.size());
        for (Map.Entry entry2 : v2.entrySet()) {
            bVar2.c(entry2.getKey(), ImmutableMap.copyOf((Map) entry2.getValue()));
        }
        this.columnMap = bVar2.a();
    }

    @Override // com.google.common.collect.ImmutableTable
    public ImmutableTable.SerializedForm createSerializedForm() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            ImmutableMap m = Maps.m(columnKeySet());
            int[] iArr = new int[cellSet().size()];
            o1<k1.a<R, C, V>> it = cellSet().iterator();
            int i2 = 0;
            while (it.hasNext()) {
                iArr[i2] = ((Integer) m.get(it.next().getColumnKey())).intValue();
                i2++;
            }
            return ImmutableTable.SerializedForm.create(this, this.cellRowIndices, iArr);
        }
        return (ImmutableTable.SerializedForm) invokeV.objValue;
    }

    @Override // com.google.common.collect.RegularImmutableTable
    public k1.a<R, C, V> getCell(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            Map.Entry<R, ImmutableMap<C, V>> entry = this.rowMap.entrySet().asList().get(this.cellRowIndices[i2]);
            Map.Entry<C, V> entry2 = entry.getValue().entrySet().asList().get(this.cellColumnInRowIndices[i2]);
            return ImmutableTable.cellOf(entry.getKey(), entry2.getKey(), entry2.getValue());
        }
        return (k1.a) invokeI.objValue;
    }

    @Override // com.google.common.collect.RegularImmutableTable
    public V getValue(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            return this.rowMap.values().asList().get(this.cellRowIndices[i2]).values().asList().get(this.cellColumnInRowIndices[i2]);
        }
        return (V) invokeI.objValue;
    }

    @Override // com.google.common.collect.RegularImmutableTable, com.google.common.collect.ImmutableTable, c.i.d.c.k1
    public int size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.cellRowIndices.length : invokeV.intValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? ImmutableMap.copyOf((Map) this.rowMap) : (ImmutableMap) invokeV.objValue;
    }
}
