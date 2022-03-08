package com.google.common.collect;

import androidx.core.view.InputDeviceCompat;
import c.i.c.a.k;
import c.i.c.a.n;
import c.i.c.c.i;
import c.i.c.c.k1;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.common.collect.Maps;
import com.google.common.collect.Tables;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
/* loaded from: classes7.dex */
public final class ArrayTable<R, C, V> extends i<R, C, V> implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public static final long serialVersionUID = 0;
    public transient /* synthetic */ FieldHolder $fh;
    public final V[][] array;
    public final ImmutableMap<C, Integer> columnKeyToIndex;
    public final ImmutableList<C> columnList;
    public transient ArrayTable<R, C, V>.f columnMap;
    public final ImmutableMap<R, Integer> rowKeyToIndex;
    public final ImmutableList<R> rowList;
    public transient ArrayTable<R, C, V>.h rowMap;

    /* loaded from: classes7.dex */
    public class a extends c.i.c.c.a<k1.a<R, C, V>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ ArrayTable f53108g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ArrayTable arrayTable, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {arrayTable, Integer.valueOf(i2)};
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
            this.f53108g = arrayTable;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.i.c.c.a
        /* renamed from: b */
        public k1.a<R, C, V> a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? this.f53108g.getCell(i2) : (k1.a) invokeI.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class b extends Tables.b<R, C, V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final int f53109e;

        /* renamed from: f  reason: collision with root package name */
        public final int f53110f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f53111g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ ArrayTable f53112h;

        public b(ArrayTable arrayTable, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {arrayTable, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53112h = arrayTable;
            this.f53111g = i2;
            this.f53109e = this.f53111g / this.f53112h.columnList.size();
            this.f53110f = this.f53111g % this.f53112h.columnList.size();
        }

        @Override // c.i.c.c.k1.a
        public C getColumnKey() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (C) this.f53112h.columnList.get(this.f53110f) : (C) invokeV.objValue;
        }

        @Override // c.i.c.c.k1.a
        public R getRowKey() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (R) this.f53112h.rowList.get(this.f53109e) : (R) invokeV.objValue;
        }

        @Override // c.i.c.c.k1.a
        public V getValue() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? (V) this.f53112h.at(this.f53109e, this.f53110f) : (V) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class c extends c.i.c.c.a<V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ ArrayTable f53113g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(ArrayTable arrayTable, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {arrayTable, Integer.valueOf(i2)};
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
            this.f53113g = arrayTable;
        }

        @Override // c.i.c.c.a
        public V a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? (V) this.f53113g.getValue(i2) : (V) invokeI.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static abstract class d<K, V> extends Maps.p<K, V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final ImmutableMap<K, Integer> f53114e;

        /* loaded from: classes7.dex */
        public class a extends c.i.c.c.b<K, V> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f53115e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ d f53116f;

            public a(d dVar, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar, Integer.valueOf(i2)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f53116f = dVar;
                this.f53115e = i2;
            }

            @Override // c.i.c.c.b, java.util.Map.Entry
            public K getKey() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (K) this.f53116f.c(this.f53115e) : (K) invokeV.objValue;
            }

            @Override // c.i.c.c.b, java.util.Map.Entry
            public V getValue() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (V) this.f53116f.e(this.f53115e) : (V) invokeV.objValue;
            }

            @Override // c.i.c.c.b, java.util.Map.Entry
            public V setValue(V v) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, v)) == null) ? (V) this.f53116f.f(this.f53115e, v) : (V) invokeL.objValue;
            }
        }

        /* loaded from: classes7.dex */
        public class b extends c.i.c.c.a<Map.Entry<K, V>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ d f53117g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(d dVar, int i2) {
                super(i2);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar, Integer.valueOf(i2)};
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
                this.f53117g = dVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.i.c.c.a
            /* renamed from: b */
            public Map.Entry<K, V> a(int i2) {
                InterceptResult invokeI;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? this.f53117g.b(i2) : (Map.Entry) invokeI.objValue;
            }
        }

        public /* synthetic */ d(ImmutableMap immutableMap, a aVar) {
            this(immutableMap);
        }

        @Override // com.google.common.collect.Maps.p
        public Iterator<Map.Entry<K, V>> a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new b(this, size()) : (Iterator) invokeV.objValue;
        }

        public Map.Entry<K, V> b(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
                n.n(i2, size());
                return new a(this, i2);
            }
            return (Map.Entry) invokeI.objValue;
        }

        public K c(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? this.f53114e.keySet().asList().get(i2) : (K) invokeI.objValue;
        }

        @Override // com.google.common.collect.Maps.p, java.util.AbstractMap, java.util.Map
        public void clear() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                throw new UnsupportedOperationException();
            }
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, obj)) == null) ? this.f53114e.containsKey(obj) : invokeL.booleanValue;
        }

        public abstract String d();

        public abstract V e(int i2);

        public abstract V f(int i2, V v);

        @Override // java.util.AbstractMap, java.util.Map
        public V get(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, obj)) == null) {
                Integer num = this.f53114e.get(obj);
                if (num == null) {
                    return null;
                }
                return e(num.intValue());
            }
            return (V) invokeL.objValue;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean isEmpty() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f53114e.isEmpty() : invokeV.booleanValue;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<K> keySet() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f53114e.keySet() : (Set) invokeV.objValue;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V put(K k, V v) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, k, v)) == null) {
                Integer num = this.f53114e.get(k);
                if (num != null) {
                    return f(num.intValue(), v);
                }
                throw new IllegalArgumentException(d() + " " + k + " not in " + this.f53114e.keySet());
            }
            return (V) invokeLL.objValue;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V remove(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, obj)) == null) {
                throw new UnsupportedOperationException();
            }
            return (V) invokeL.objValue;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f53114e.size() : invokeV.intValue;
        }

        public d(ImmutableMap<K, Integer> immutableMap) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {immutableMap};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53114e = immutableMap;
        }
    }

    /* loaded from: classes7.dex */
    public class e extends d<R, V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final int f53118f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ ArrayTable f53119g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(ArrayTable arrayTable, int i2) {
            super(arrayTable.rowKeyToIndex, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {arrayTable, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((ImmutableMap) objArr2[0], (a) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53119g = arrayTable;
            this.f53118f = i2;
        }

        @Override // com.google.common.collect.ArrayTable.d
        public String d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "Row" : (String) invokeV.objValue;
        }

        @Override // com.google.common.collect.ArrayTable.d
        public V e(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? (V) this.f53119g.at(i2, this.f53118f) : (V) invokeI.objValue;
        }

        @Override // com.google.common.collect.ArrayTable.d
        public V f(int i2, V v) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, v)) == null) ? (V) this.f53119g.set(i2, this.f53118f, v) : (V) invokeIL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class f extends d<C, Map<R, V>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ArrayTable f53120f;

        public /* synthetic */ f(ArrayTable arrayTable, a aVar) {
            this(arrayTable);
        }

        @Override // com.google.common.collect.ArrayTable.d
        public String d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "Column" : (String) invokeV.objValue;
        }

        @Override // com.google.common.collect.ArrayTable.d
        public /* bridge */ /* synthetic */ Object f(int i2, Object obj) {
            i(i2, (Map) obj);
            throw null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.ArrayTable.d
        /* renamed from: g */
        public Map<R, V> e(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) ? new e(this.f53120f, i2) : (Map) invokeI.objValue;
        }

        public Map<R, V> h(C c2, Map<R, V> map) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, c2, map)) == null) {
                throw new UnsupportedOperationException();
            }
            return (Map) invokeLL.objValue;
        }

        public Map<R, V> i(int i2, Map<R, V> map) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(1048581, this, i2, map)) == null) {
                throw new UnsupportedOperationException();
            }
            return (Map) invokeIL.objValue;
        }

        @Override // com.google.common.collect.ArrayTable.d, java.util.AbstractMap, java.util.Map
        public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
            h(obj, (Map) obj2);
            throw null;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(ArrayTable arrayTable) {
            super(arrayTable.columnKeyToIndex, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {arrayTable};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((ImmutableMap) objArr2[0], (a) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53120f = arrayTable;
        }
    }

    /* loaded from: classes7.dex */
    public class g extends d<C, V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final int f53121f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ ArrayTable f53122g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(ArrayTable arrayTable, int i2) {
            super(arrayTable.columnKeyToIndex, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {arrayTable, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((ImmutableMap) objArr2[0], (a) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53122g = arrayTable;
            this.f53121f = i2;
        }

        @Override // com.google.common.collect.ArrayTable.d
        public String d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "Column" : (String) invokeV.objValue;
        }

        @Override // com.google.common.collect.ArrayTable.d
        public V e(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? (V) this.f53122g.at(this.f53121f, i2) : (V) invokeI.objValue;
        }

        @Override // com.google.common.collect.ArrayTable.d
        public V f(int i2, V v) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, v)) == null) ? (V) this.f53122g.set(this.f53121f, i2, v) : (V) invokeIL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class h extends d<R, Map<C, V>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ArrayTable f53123f;

        public /* synthetic */ h(ArrayTable arrayTable, a aVar) {
            this(arrayTable);
        }

        @Override // com.google.common.collect.ArrayTable.d
        public String d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "Row" : (String) invokeV.objValue;
        }

        @Override // com.google.common.collect.ArrayTable.d
        public /* bridge */ /* synthetic */ Object f(int i2, Object obj) {
            i(i2, (Map) obj);
            throw null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.ArrayTable.d
        /* renamed from: g */
        public Map<C, V> e(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) ? new g(this.f53123f, i2) : (Map) invokeI.objValue;
        }

        public Map<C, V> h(R r, Map<C, V> map) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, r, map)) == null) {
                throw new UnsupportedOperationException();
            }
            return (Map) invokeLL.objValue;
        }

        public Map<C, V> i(int i2, Map<C, V> map) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(1048581, this, i2, map)) == null) {
                throw new UnsupportedOperationException();
            }
            return (Map) invokeIL.objValue;
        }

        @Override // com.google.common.collect.ArrayTable.d, java.util.AbstractMap, java.util.Map
        public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
            h(obj, (Map) obj2);
            throw null;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(ArrayTable arrayTable) {
            super(arrayTable.rowKeyToIndex, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {arrayTable};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((ImmutableMap) objArr2[0], (a) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53123f = arrayTable;
        }
    }

    public ArrayTable(Iterable<? extends R> iterable, Iterable<? extends C> iterable2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iterable, iterable2};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.rowList = ImmutableList.copyOf(iterable);
        this.columnList = ImmutableList.copyOf(iterable2);
        n.d(this.rowList.isEmpty() == this.columnList.isEmpty());
        this.rowKeyToIndex = Maps.m(this.rowList);
        this.columnKeyToIndex = Maps.m(this.columnList);
        this.array = (V[][]) ((Object[][]) Array.newInstance(Object.class, this.rowList.size(), this.columnList.size()));
        eraseAll();
    }

    public static <R, C, V> ArrayTable<R, C, V> create(Iterable<? extends R> iterable, Iterable<? extends C> iterable2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, iterable, iterable2)) == null) ? new ArrayTable<>(iterable, iterable2) : (ArrayTable) invokeLL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public k1.a<R, C, V> getCell(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65547, this, i2)) == null) ? new b(this, i2) : (k1.a) invokeI.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public V getValue(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65548, this, i2)) == null) ? at(i2 / this.columnList.size(), i2 % this.columnList.size()) : (V) invokeI.objValue;
    }

    public V at(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048576, this, i2, i3)) == null) {
            n.n(i2, this.rowList.size());
            n.n(i3, this.columnList.size());
            return this.array[i2][i3];
        }
        return (V) invokeII.objValue;
    }

    @Override // c.i.c.c.i
    public Iterator<k1.a<R, C, V>> cellIterator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new a(this, size()) : (Iterator) invokeV.objValue;
    }

    @Override // c.i.c.c.i, c.i.c.c.k1
    public Set<k1.a<R, C, V>> cellSet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? super.cellSet() : (Set) invokeV.objValue;
    }

    @Override // c.i.c.c.i, c.i.c.c.k1
    @Deprecated
    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // c.i.c.c.k1
    public Map<R, V> column(C c2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, c2)) == null) {
            n.p(c2);
            Integer num = this.columnKeyToIndex.get(c2);
            return num == null ? ImmutableMap.of() : new e(this, num.intValue());
        }
        return (Map) invokeL.objValue;
    }

    public ImmutableList<C> columnKeyList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.columnList : (ImmutableList) invokeV.objValue;
    }

    @Override // c.i.c.c.k1
    public Map<C, Map<R, V>> columnMap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            ArrayTable<R, C, V>.f fVar = this.columnMap;
            if (fVar == null) {
                ArrayTable<R, C, V>.f fVar2 = new f(this, null);
                this.columnMap = fVar2;
                return fVar2;
            }
            return fVar;
        }
        return (Map) invokeV.objValue;
    }

    @Override // c.i.c.c.i, c.i.c.c.k1
    public boolean contains(Object obj, Object obj2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, obj, obj2)) == null) ? containsRow(obj) && containsColumn(obj2) : invokeLL.booleanValue;
    }

    @Override // c.i.c.c.i, c.i.c.c.k1
    public boolean containsColumn(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, obj)) == null) ? this.columnKeyToIndex.containsKey(obj) : invokeL.booleanValue;
    }

    @Override // c.i.c.c.i, c.i.c.c.k1
    public boolean containsRow(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, obj)) == null) ? this.rowKeyToIndex.containsKey(obj) : invokeL.booleanValue;
    }

    @Override // c.i.c.c.i, c.i.c.c.k1
    public boolean containsValue(Object obj) {
        InterceptResult invokeL;
        V[][] vArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, obj)) == null) {
            for (V[] vArr2 : this.array) {
                for (V v : vArr2) {
                    if (k.a(obj, v)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // c.i.c.c.i, c.i.c.c.k1
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    public V erase(Object obj, Object obj2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, obj, obj2)) == null) {
            Integer num = this.rowKeyToIndex.get(obj);
            Integer num2 = this.columnKeyToIndex.get(obj2);
            if (num == null || num2 == null) {
                return null;
            }
            return set(num.intValue(), num2.intValue(), null);
        }
        return (V) invokeLL.objValue;
    }

    public void eraseAll() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            for (V[] vArr : this.array) {
                Arrays.fill(vArr, (Object) null);
            }
        }
    }

    @Override // c.i.c.c.i, c.i.c.c.k1
    public V get(Object obj, Object obj2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048592, this, obj, obj2)) == null) {
            Integer num = this.rowKeyToIndex.get(obj);
            Integer num2 = this.columnKeyToIndex.get(obj2);
            if (num == null || num2 == null) {
                return null;
            }
            return at(num.intValue(), num2.intValue());
        }
        return (V) invokeLL.objValue;
    }

    @Override // c.i.c.c.i, c.i.c.c.k1
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // c.i.c.c.i, c.i.c.c.k1
    public boolean isEmpty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.rowList.isEmpty() || this.columnList.isEmpty() : invokeV.booleanValue;
    }

    @Override // c.i.c.c.i, c.i.c.c.k1
    public V put(R r, C c2, V v) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048595, this, r, c2, v)) == null) {
            n.p(r);
            n.p(c2);
            Integer num = this.rowKeyToIndex.get(r);
            n.l(num != null, "Row %s not in %s", r, this.rowList);
            Integer num2 = this.columnKeyToIndex.get(c2);
            n.l(num2 != null, "Column %s not in %s", c2, this.columnList);
            return set(num.intValue(), num2.intValue(), v);
        }
        return (V) invokeLLL.objValue;
    }

    @Override // c.i.c.c.i, c.i.c.c.k1
    public void putAll(k1<? extends R, ? extends C, ? extends V> k1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, k1Var) == null) {
            super.putAll(k1Var);
        }
    }

    @Override // c.i.c.c.i, c.i.c.c.k1
    @Deprecated
    public V remove(Object obj, Object obj2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048597, this, obj, obj2)) == null) {
            throw new UnsupportedOperationException();
        }
        return (V) invokeLL.objValue;
    }

    @Override // c.i.c.c.k1
    public Map<C, V> row(R r) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, r)) == null) {
            n.p(r);
            Integer num = this.rowKeyToIndex.get(r);
            return num == null ? ImmutableMap.of() : new g(this, num.intValue());
        }
        return (Map) invokeL.objValue;
    }

    public ImmutableList<R> rowKeyList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.rowList : (ImmutableList) invokeV.objValue;
    }

    @Override // c.i.c.c.k1
    public Map<R, Map<C, V>> rowMap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            ArrayTable<R, C, V>.h hVar = this.rowMap;
            if (hVar == null) {
                ArrayTable<R, C, V>.h hVar2 = new h(this, null);
                this.rowMap = hVar2;
                return hVar2;
            }
            return hVar;
        }
        return (Map) invokeV.objValue;
    }

    public V set(int i2, int i3, V v) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048603, this, i2, i3, v)) == null) {
            n.n(i2, this.rowList.size());
            n.n(i3, this.columnList.size());
            V[][] vArr = this.array;
            V v2 = vArr[i2][i3];
            vArr[i2][i3] = v;
            return v2;
        }
        return (V) invokeIIL.objValue;
    }

    @Override // c.i.c.c.k1
    public int size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.rowList.size() * this.columnList.size() : invokeV.intValue;
    }

    public V[][] toArray(Class<V> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, cls)) == null) {
            V[][] vArr = (V[][]) ((Object[][]) Array.newInstance((Class<?>) cls, this.rowList.size(), this.columnList.size()));
            for (int i2 = 0; i2 < this.rowList.size(); i2++) {
                V[][] vArr2 = this.array;
                System.arraycopy(vArr2[i2], 0, vArr[i2], 0, vArr2[i2].length);
            }
            return vArr;
        }
        return (V[][]) ((Object[][]) invokeL.objValue);
    }

    @Override // c.i.c.c.i
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // c.i.c.c.i, c.i.c.c.k1
    public Collection<V> values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? super.values() : (Collection) invokeV.objValue;
    }

    @Override // c.i.c.c.i
    public Iterator<V> valuesIterator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? new c(this, size()) : (Iterator) invokeV.objValue;
    }

    public static <R, C, V> ArrayTable<R, C, V> create(k1<R, C, V> k1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, null, k1Var)) == null) ? k1Var instanceof ArrayTable ? new ArrayTable<>((ArrayTable) k1Var) : new ArrayTable<>(k1Var) : (ArrayTable) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.i.c.c.i, c.i.c.c.k1
    public ImmutableSet<C> columnKeySet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.columnKeyToIndex.keySet() : (ImmutableSet) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.i.c.c.i, c.i.c.c.k1
    public ImmutableSet<R> rowKeySet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.rowKeyToIndex.keySet() : (ImmutableSet) invokeV.objValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ArrayTable(k1<R, C, V> k1Var) {
        this(k1Var.rowKeySet(), k1Var.columnKeySet());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {k1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Iterable) objArr2[0], (Iterable) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        putAll(k1Var);
    }

    public ArrayTable(ArrayTable<R, C, V> arrayTable) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {arrayTable};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        ImmutableList<R> immutableList = arrayTable.rowList;
        this.rowList = immutableList;
        this.columnList = arrayTable.columnList;
        this.rowKeyToIndex = arrayTable.rowKeyToIndex;
        this.columnKeyToIndex = arrayTable.columnKeyToIndex;
        V[][] vArr = (V[][]) ((Object[][]) Array.newInstance(Object.class, immutableList.size(), this.columnList.size()));
        this.array = vArr;
        for (int i4 = 0; i4 < this.rowList.size(); i4++) {
            V[][] vArr2 = arrayTable.array;
            System.arraycopy(vArr2[i4], 0, vArr[i4], 0, vArr2[i4].length);
        }
    }
}
