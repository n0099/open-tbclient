package com.google.common.collect;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.f.d.a.r;
import d.f.d.c.k1;
import d.f.d.c.m;
import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
/* loaded from: classes7.dex */
public class HashBasedTable<R, C, V> extends StandardTable<R, C, V> {
    public static /* synthetic */ Interceptable $ic;
    public static final long serialVersionUID = 0;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class Factory<C, V> implements r<Map<C, V>>, Serializable {
        public static /* synthetic */ Interceptable $ic;
        public static final long serialVersionUID = 0;
        public transient /* synthetic */ FieldHolder $fh;
        public final int expectedSize;

        public Factory(int i2) {
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
            this.expectedSize = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.f.d.a.r
        public Map<C, V> get() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? Maps.w(this.expectedSize) : (Map) invokeV.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HashBasedTable(Map<R, Map<C, V>> map, Factory<C, V> factory) {
        super(map, factory);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {map, factory};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Map) objArr2[0], (r) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static <R, C, V> HashBasedTable<R, C, V> create() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? new HashBasedTable<>(new LinkedHashMap(), new Factory(0)) : (HashBasedTable) invokeV.objValue;
    }

    @Override // com.google.common.collect.StandardTable, d.f.d.c.i, d.f.d.c.k1
    public /* bridge */ /* synthetic */ Set cellSet() {
        return super.cellSet();
    }

    @Override // com.google.common.collect.StandardTable, d.f.d.c.i, d.f.d.c.k1
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.StandardTable, d.f.d.c.k1
    public /* bridge */ /* synthetic */ Map column(Object obj) {
        return super.column(obj);
    }

    @Override // com.google.common.collect.StandardTable, d.f.d.c.i, d.f.d.c.k1
    public /* bridge */ /* synthetic */ Set columnKeySet() {
        return super.columnKeySet();
    }

    @Override // com.google.common.collect.StandardTable, d.f.d.c.k1
    public /* bridge */ /* synthetic */ Map columnMap() {
        return super.columnMap();
    }

    @Override // com.google.common.collect.StandardTable, d.f.d.c.i, d.f.d.c.k1
    public boolean contains(Object obj, Object obj2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, obj, obj2)) == null) ? super.contains(obj, obj2) : invokeLL.booleanValue;
    }

    @Override // com.google.common.collect.StandardTable, d.f.d.c.i, d.f.d.c.k1
    public boolean containsColumn(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, obj)) == null) ? super.containsColumn(obj) : invokeL.booleanValue;
    }

    @Override // com.google.common.collect.StandardTable, d.f.d.c.i, d.f.d.c.k1
    public boolean containsRow(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, obj)) == null) ? super.containsRow(obj) : invokeL.booleanValue;
    }

    @Override // com.google.common.collect.StandardTable, d.f.d.c.i, d.f.d.c.k1
    public boolean containsValue(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, obj)) == null) ? super.containsValue(obj) : invokeL.booleanValue;
    }

    @Override // d.f.d.c.i, d.f.d.c.k1
    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, obj)) == null) ? super.equals(obj) : invokeL.booleanValue;
    }

    @Override // com.google.common.collect.StandardTable, d.f.d.c.i, d.f.d.c.k1
    public V get(Object obj, Object obj2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, obj, obj2)) == null) ? (V) super.get(obj, obj2) : (V) invokeLL.objValue;
    }

    @Override // d.f.d.c.i, d.f.d.c.k1
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.common.collect.StandardTable, d.f.d.c.i, d.f.d.c.k1
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.lang.Object */
    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.StandardTable, d.f.d.c.i, d.f.d.c.k1
    public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2, Object obj3) {
        return super.put(obj, obj2, obj3);
    }

    @Override // d.f.d.c.i, d.f.d.c.k1
    public /* bridge */ /* synthetic */ void putAll(k1 k1Var) {
        super.putAll(k1Var);
    }

    @Override // com.google.common.collect.StandardTable, d.f.d.c.i, d.f.d.c.k1
    public V remove(Object obj, Object obj2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, obj, obj2)) == null) ? (V) super.remove(obj, obj2) : (V) invokeLL.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.StandardTable, d.f.d.c.k1
    public /* bridge */ /* synthetic */ Map row(Object obj) {
        return super.row(obj);
    }

    @Override // com.google.common.collect.StandardTable, d.f.d.c.i, d.f.d.c.k1
    public /* bridge */ /* synthetic */ Set rowKeySet() {
        return super.rowKeySet();
    }

    @Override // com.google.common.collect.StandardTable, d.f.d.c.k1
    public /* bridge */ /* synthetic */ Map rowMap() {
        return super.rowMap();
    }

    @Override // com.google.common.collect.StandardTable, d.f.d.c.k1
    public /* bridge */ /* synthetic */ int size() {
        return super.size();
    }

    @Override // d.f.d.c.i
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // com.google.common.collect.StandardTable, d.f.d.c.i, d.f.d.c.k1
    public /* bridge */ /* synthetic */ Collection values() {
        return super.values();
    }

    public static <R, C, V> HashBasedTable<R, C, V> create(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65538, null, i2, i3)) == null) {
            m.b(i3, "expectedCellsPerRow");
            return new HashBasedTable<>(Maps.w(i2), new Factory(i3));
        }
        return (HashBasedTable) invokeII.objValue;
    }

    public static <R, C, V> HashBasedTable<R, C, V> create(k1<? extends R, ? extends C, ? extends V> k1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, k1Var)) == null) {
            HashBasedTable<R, C, V> create = create();
            create.putAll(k1Var);
            return create;
        }
        return (HashBasedTable) invokeL.objValue;
    }
}
