package com.google.common.collect;

import androidx.core.view.InputDeviceCompat;
import b.i.d.a.g;
import b.i.d.a.k;
import b.i.d.a.n;
import b.i.d.c.c1;
import b.i.d.c.k1;
import b.i.d.c.m0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
/* loaded from: classes2.dex */
public final class Tables {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final g<? extends Map<?, ?>, ? extends Map<?, ?>> f63588a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public static final class ImmutableCell<R, C, V> extends b<R, C, V> implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public static final long serialVersionUID = 0;
        public transient /* synthetic */ FieldHolder $fh;
        public final C columnKey;
        public final R rowKey;
        public final V value;

        public ImmutableCell(R r, C c2, V v) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r, c2, v};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.rowKey = r;
            this.columnKey = c2;
            this.value = v;
        }

        @Override // b.i.d.c.k1.a
        public C getColumnKey() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.columnKey : (C) invokeV.objValue;
        }

        @Override // b.i.d.c.k1.a
        public R getRowKey() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.rowKey : (R) invokeV.objValue;
        }

        @Override // b.i.d.c.k1.a
        public V getValue() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.value : (V) invokeV.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public static final class UnmodifiableRowSortedMap<R, C, V> extends UnmodifiableTable<R, C, V> implements c1<R, C, V> {
        public static /* synthetic */ Interceptable $ic;
        public static final long serialVersionUID = 0;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UnmodifiableRowSortedMap(c1<R, ? extends C, ? extends V> c1Var) {
            super(c1Var);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((k1) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.Tables.UnmodifiableTable, b.i.d.c.m0, b.i.d.c.k1
        public SortedSet<R> rowKeySet() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? Collections.unmodifiableSortedSet(delegate().rowKeySet()) : (SortedSet) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.Tables.UnmodifiableTable, b.i.d.c.m0, b.i.d.c.k1
        public SortedMap<R, Map<C, V>> rowMap() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? Collections.unmodifiableSortedMap(Maps.H(delegate().rowMap(), Tables.d())) : (SortedMap) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.Tables.UnmodifiableTable, b.i.d.c.m0, b.i.d.c.h0
        public c1<R, C, V> delegate() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (c1) super.delegate() : (c1) invokeV.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public static class UnmodifiableTable<R, C, V> extends m0<R, C, V> implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public static final long serialVersionUID = 0;
        public transient /* synthetic */ FieldHolder $fh;
        public final k1<? extends R, ? extends C, ? extends V> delegate;

        public UnmodifiableTable(k1<? extends R, ? extends C, ? extends V> k1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            n.p(k1Var);
            this.delegate = k1Var;
        }

        @Override // b.i.d.c.m0, b.i.d.c.k1
        public Set<k1.a<R, C, V>> cellSet() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? Collections.unmodifiableSet(super.cellSet()) : (Set) invokeV.objValue;
        }

        @Override // b.i.d.c.m0, b.i.d.c.k1
        public void clear() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                throw new UnsupportedOperationException();
            }
        }

        @Override // b.i.d.c.m0, b.i.d.c.k1
        public Map<R, V> column(C c2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, c2)) == null) ? Collections.unmodifiableMap(super.column(c2)) : (Map) invokeL.objValue;
        }

        @Override // b.i.d.c.m0, b.i.d.c.k1
        public Set<C> columnKeySet() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? Collections.unmodifiableSet(super.columnKeySet()) : (Set) invokeV.objValue;
        }

        @Override // b.i.d.c.m0, b.i.d.c.k1
        public Map<C, Map<R, V>> columnMap() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? Collections.unmodifiableMap(Maps.G(super.columnMap(), Tables.d())) : (Map) invokeV.objValue;
        }

        @Override // b.i.d.c.m0, b.i.d.c.k1
        public V put(R r, C c2, V v) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048583, this, r, c2, v)) == null) {
                throw new UnsupportedOperationException();
            }
            return (V) invokeLLL.objValue;
        }

        @Override // b.i.d.c.m0, b.i.d.c.k1
        public void putAll(k1<? extends R, ? extends C, ? extends V> k1Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, k1Var) == null) {
                throw new UnsupportedOperationException();
            }
        }

        @Override // b.i.d.c.m0, b.i.d.c.k1
        public V remove(Object obj, Object obj2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, obj, obj2)) == null) {
                throw new UnsupportedOperationException();
            }
            return (V) invokeLL.objValue;
        }

        @Override // b.i.d.c.m0, b.i.d.c.k1
        public Map<C, V> row(R r) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, r)) == null) ? Collections.unmodifiableMap(super.row(r)) : (Map) invokeL.objValue;
        }

        @Override // b.i.d.c.m0, b.i.d.c.k1
        public Set<R> rowKeySet() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? Collections.unmodifiableSet(super.rowKeySet()) : (Set) invokeV.objValue;
        }

        @Override // b.i.d.c.m0, b.i.d.c.k1
        public Map<R, Map<C, V>> rowMap() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? Collections.unmodifiableMap(Maps.G(super.rowMap(), Tables.d())) : (Map) invokeV.objValue;
        }

        @Override // b.i.d.c.m0, b.i.d.c.k1
        public Collection<V> values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? Collections.unmodifiableCollection(super.values()) : (Collection) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Type inference failed for r0v2. Raw type applied. Possible types: b.i.d.c.k1<? extends R, ? extends C, ? extends V>, b.i.d.c.k1<R, C, V> */
        @Override // b.i.d.c.m0, b.i.d.c.h0
        public k1<R, C, V> delegate() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? (k1<? extends R, ? extends C, ? extends V>) this.delegate : (k1) invokeV.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public static class a implements g<Map<Object, Object>, Map<Object, Object>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.i.d.a.g
        /* renamed from: a */
        public Map<Object, Object> apply(Map<Object, Object> map) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, map)) == null) ? Collections.unmodifiableMap(map) : (Map) invokeL.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class b<R, C, V> implements k1.a<R, C, V> {
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

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                if (obj == this) {
                    return true;
                }
                if (obj instanceof k1.a) {
                    k1.a aVar = (k1.a) obj;
                    return k.a(getRowKey(), aVar.getRowKey()) && k.a(getColumnKey(), aVar.getColumnKey()) && k.a(getValue(), aVar.getValue());
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? k.b(getRowKey(), getColumnKey(), getValue()) : invokeV.intValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return "(" + getRowKey() + "," + getColumnKey() + ")=" + getValue();
            }
            return (String) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1567876105, "Lcom/google/common/collect/Tables;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1567876105, "Lcom/google/common/collect/Tables;");
                return;
            }
        }
        f63588a = new a();
    }

    public static boolean b(k1<?, ?, ?> k1Var, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, k1Var, obj)) == null) {
            if (obj == k1Var) {
                return true;
            }
            if (obj instanceof k1) {
                return k1Var.cellSet().equals(((k1) obj).cellSet());
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static <R, C, V> k1.a<R, C, V> c(R r, C c2, V v) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, r, c2, v)) == null) ? new ImmutableCell(r, c2, v) : (k1.a) invokeLLL.objValue;
    }

    public static <K, V> g<Map<K, V>, Map<K, V>> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (g<Map<K, V>, Map<K, V>>) f63588a : (g) invokeV.objValue;
    }
}
