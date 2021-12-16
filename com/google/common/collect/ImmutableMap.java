package com.google.common.collect;

import androidx.core.view.InputDeviceCompat;
import c.i.d.c.m;
import c.i.d.c.o1;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.common.collect.ImmutableCollection;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
/* loaded from: classes3.dex */
public abstract class ImmutableMap<K, V> implements Map<K, V>, Serializable {
    public static /* synthetic */ Interceptable $ic;
    public static final Map.Entry<?, ?>[] EMPTY_ENTRY_ARRAY;
    public transient /* synthetic */ FieldHolder $fh;
    public transient ImmutableSet<Map.Entry<K, V>> entrySet;
    public transient ImmutableSet<K> keySet;
    public transient ImmutableSetMultimap<K, V> multimapView;
    public transient ImmutableCollection<V> values;

    /* loaded from: classes3.dex */
    public static abstract class IteratorBasedImmutableMap<K, V> extends ImmutableMap<K, V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public IteratorBasedImmutableMap() {
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

        @Override // com.google.common.collect.ImmutableMap
        public ImmutableSet<Map.Entry<K, V>> createEntrySet() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new ImmutableMapEntrySet<K, V>(this) { // from class: com.google.common.collect.ImmutableMap.IteratorBasedImmutableMap.1EntrySetImpl
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ IteratorBasedImmutableMap this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // com.google.common.collect.ImmutableMapEntrySet
                public ImmutableMap<K, V> map() {
                    InterceptResult invokeV2;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV2 = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.this$0 : (ImmutableMap) invokeV2.objValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
                public o1<Map.Entry<K, V>> iterator() {
                    InterceptResult invokeV2;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048576, this)) == null) ? this.this$0.entryIterator() : (o1) invokeV2.objValue;
                }
            } : (ImmutableSet) invokeV.objValue;
        }

        @Override // com.google.common.collect.ImmutableMap
        public ImmutableSet<K> createKeySet() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new ImmutableMapKeySet(this) : (ImmutableSet) invokeV.objValue;
        }

        @Override // com.google.common.collect.ImmutableMap
        public ImmutableCollection<V> createValues() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? new ImmutableMapValues(this) : (ImmutableCollection) invokeV.objValue;
        }

        public abstract o1<Map.Entry<K, V>> entryIterator();

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        public /* bridge */ /* synthetic */ Set entrySet() {
            return super.entrySet();
        }

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        public /* bridge */ /* synthetic */ Set keySet() {
            return super.keySet();
        }

        @Override // com.google.common.collect.ImmutableMap, java.util.Map, c.i.d.c.k
        public /* bridge */ /* synthetic */ Collection values() {
            return super.values();
        }
    }

    /* loaded from: classes3.dex */
    public final class MapViewOfValuesAsSingletonSets extends IteratorBasedImmutableMap<K, ImmutableSet<V>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImmutableMap this$0;

        /* loaded from: classes3.dex */
        public class a extends o1<Map.Entry<K, ImmutableSet<V>>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Iterator f56771e;

            /* renamed from: com.google.common.collect.ImmutableMap$MapViewOfValuesAsSingletonSets$a$a  reason: collision with other inner class name */
            /* loaded from: classes3.dex */
            public class C2042a extends c.i.d.c.b<K, ImmutableSet<V>> {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Map.Entry f56772e;

                public C2042a(a aVar, Map.Entry entry) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {aVar, entry};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f56772e = entry;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // c.i.d.c.b, java.util.Map.Entry
                /* renamed from: a */
                public ImmutableSet<V> getValue() {
                    InterceptResult invokeV;
                    Interceptable interceptable = $ic;
                    return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? ImmutableSet.of(this.f56772e.getValue()) : (ImmutableSet) invokeV.objValue;
                }

                @Override // c.i.d.c.b, java.util.Map.Entry
                public K getKey() {
                    InterceptResult invokeV;
                    Interceptable interceptable = $ic;
                    return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (K) this.f56772e.getKey() : (K) invokeV.objValue;
                }
            }

            public a(MapViewOfValuesAsSingletonSets mapViewOfValuesAsSingletonSets, Iterator it) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {mapViewOfValuesAsSingletonSets, it};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f56771e = it;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Iterator
            /* renamed from: a */
            public Map.Entry<K, ImmutableSet<V>> next() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new C2042a(this, (Map.Entry) this.f56771e.next()) : (Map.Entry) invokeV.objValue;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f56771e.hasNext() : invokeV.booleanValue;
            }
        }

        public MapViewOfValuesAsSingletonSets(ImmutableMap immutableMap) {
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
            this.this$0 = immutableMap;
        }

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        public boolean containsKey(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) ? this.this$0.containsKey(obj) : invokeL.booleanValue;
        }

        @Override // com.google.common.collect.ImmutableMap.IteratorBasedImmutableMap, com.google.common.collect.ImmutableMap
        public ImmutableSet<K> createKeySet() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.this$0.keySet() : (ImmutableSet) invokeV.objValue;
        }

        @Override // com.google.common.collect.ImmutableMap.IteratorBasedImmutableMap
        public o1<Map.Entry<K, ImmutableSet<V>>> entryIterator() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? new a(this, this.this$0.entrySet().iterator()) : (o1) invokeV.objValue;
        }

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.this$0.hashCode() : invokeV.intValue;
        }

        @Override // com.google.common.collect.ImmutableMap
        public boolean isHashCodeFast() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.this$0.isHashCodeFast() : invokeV.booleanValue;
        }

        @Override // com.google.common.collect.ImmutableMap
        public boolean isPartialView() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.this$0.isPartialView() : invokeV.booleanValue;
        }

        @Override // java.util.Map
        public int size() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.this$0.size() : invokeV.intValue;
        }

        public /* synthetic */ MapViewOfValuesAsSingletonSets(ImmutableMap immutableMap, a aVar) {
            this(immutableMap);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        public ImmutableSet<V> get(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
                Object obj2 = this.this$0.get(obj);
                if (obj2 == null) {
                    return null;
                }
                return ImmutableSet.of(obj2);
            }
            return (ImmutableSet) invokeL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class SerializedForm implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public static final long serialVersionUID = 0;
        public transient /* synthetic */ FieldHolder $fh;
        public final Object[] keys;
        public final Object[] values;

        public SerializedForm(ImmutableMap<?, ?> immutableMap) {
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
            this.keys = new Object[immutableMap.size()];
            this.values = new Object[immutableMap.size()];
            o1<Map.Entry<?, ?>> it = immutableMap.entrySet().iterator();
            int i4 = 0;
            while (it.hasNext()) {
                Map.Entry<?, ?> next = it.next();
                this.keys[i4] = next.getKey();
                this.values[i4] = next.getValue();
                i4++;
            }
        }

        public Object createMap(b<Object, Object> bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, bVar)) != null) {
                return invokeL.objValue;
            }
            int i2 = 0;
            while (true) {
                Object[] objArr = this.keys;
                if (i2 < objArr.length) {
                    bVar.c(objArr[i2], this.values[i2]);
                    i2++;
                } else {
                    return bVar.a();
                }
            }
        }

        public Object readResolve() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? createMap(new b<>(this.keys.length)) : invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class a extends o1<K> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ o1 f56773e;

        public a(ImmutableMap immutableMap, o1 o1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {immutableMap, o1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56773e = o1Var;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f56773e.hasNext() : invokeV.booleanValue;
        }

        @Override // java.util.Iterator
        public K next() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (K) ((Map.Entry) this.f56773e.next()).getKey() : (K) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class b<K, V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Comparator<? super V> a;

        /* renamed from: b  reason: collision with root package name */
        public Object[] f56774b;

        /* renamed from: c  reason: collision with root package name */
        public int f56775c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f56776d;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public b() {
            this(4);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    this(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public ImmutableMap<K, V> a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                g();
                this.f56776d = true;
                return RegularImmutableMap.create(this.f56775c, this.f56774b);
            }
            return (ImmutableMap) invokeV.objValue;
        }

        public final void b(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                int i3 = i2 * 2;
                Object[] objArr = this.f56774b;
                if (i3 > objArr.length) {
                    this.f56774b = Arrays.copyOf(objArr, ImmutableCollection.b.e(objArr.length, i3));
                    this.f56776d = false;
                }
            }
        }

        public b<K, V> c(K k2, V v) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, k2, v)) == null) {
                b(this.f56775c + 1);
                m.a(k2, v);
                Object[] objArr = this.f56774b;
                int i2 = this.f56775c;
                objArr[i2 * 2] = k2;
                objArr[(i2 * 2) + 1] = v;
                this.f56775c = i2 + 1;
                return this;
            }
            return (b) invokeLL.objValue;
        }

        public b<K, V> d(Map.Entry<? extends K, ? extends V> entry) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, entry)) == null) ? c(entry.getKey(), entry.getValue()) : (b) invokeL.objValue;
        }

        public b<K, V> e(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, iterable)) == null) {
                if (iterable instanceof Collection) {
                    b(this.f56775c + ((Collection) iterable).size());
                }
                for (Map.Entry<? extends K, ? extends V> entry : iterable) {
                    d(entry);
                }
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b<K, V> f(Map<? extends K, ? extends V> map) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, map)) == null) ? e(map.entrySet()) : (b) invokeL.objValue;
        }

        public void g() {
            int i2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.a == null) {
                return;
            }
            if (this.f56776d) {
                this.f56774b = Arrays.copyOf(this.f56774b, this.f56775c * 2);
            }
            Map.Entry[] entryArr = new Map.Entry[this.f56775c];
            int i3 = 0;
            while (true) {
                i2 = this.f56775c;
                if (i3 >= i2) {
                    break;
                }
                Object[] objArr = this.f56774b;
                int i4 = i3 * 2;
                entryArr[i3] = new AbstractMap.SimpleImmutableEntry(objArr[i4], objArr[i4 + 1]);
                i3++;
            }
            Arrays.sort(entryArr, 0, i2, Ordering.from(this.a).onResultOf(Maps.N()));
            for (int i5 = 0; i5 < this.f56775c; i5++) {
                int i6 = i5 * 2;
                this.f56774b[i6] = entryArr[i5].getKey();
                this.f56774b[i6 + 1] = entryArr[i5].getValue();
            }
        }

        public b(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f56774b = new Object[i2 * 2];
            this.f56775c = 0;
            this.f56776d = false;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1818992212, "Lcom/google/common/collect/ImmutableMap;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1818992212, "Lcom/google/common/collect/ImmutableMap;");
                return;
            }
        }
        EMPTY_ENTRY_ARRAY = new Map.Entry[0];
    }

    public ImmutableMap() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static <K, V> b<K, V> builder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? new b<>() : (b) invokeV.objValue;
    }

    public static <K, V> b<K, V> builderWithExpectedSize(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i2)) == null) {
            m.b(i2, "expectedSize");
            return new b<>(i2);
        }
        return (b) invokeI.objValue;
    }

    public static void checkNoConflict(boolean z, String str, Map.Entry<?, ?> entry, Map.Entry<?, ?> entry2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Boolean.valueOf(z), str, entry, entry2}) == null) && !z) {
            throw conflictException(str, entry, entry2);
        }
    }

    public static IllegalArgumentException conflictException(String str, Object obj, Object obj2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65541, null, str, obj, obj2)) == null) {
            return new IllegalArgumentException("Multiple entries with same " + str + ": " + obj + " and " + obj2);
        }
        return (IllegalArgumentException) invokeLLL.objValue;
    }

    public static <K, V> ImmutableMap<K, V> copyOf(Map<? extends K, ? extends V> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, map)) == null) {
            if ((map instanceof ImmutableMap) && !(map instanceof SortedMap)) {
                ImmutableMap<K, V> immutableMap = (ImmutableMap) map;
                if (!immutableMap.isPartialView()) {
                    return immutableMap;
                }
            }
            return copyOf(map.entrySet());
        }
        return (ImmutableMap) invokeL.objValue;
    }

    public static <K, V> Map.Entry<K, V> entryOf(K k2, V v) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, k2, v)) == null) {
            m.a(k2, v);
            return new AbstractMap.SimpleImmutableEntry(k2, v);
        }
        return (Map.Entry) invokeLL.objValue;
    }

    public static <K, V> ImmutableMap<K, V> of() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? (ImmutableMap<K, V>) RegularImmutableMap.EMPTY : (ImmutableMap) invokeV.objValue;
    }

    public ImmutableSetMultimap<K, V> asMultimap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (isEmpty()) {
                return ImmutableSetMultimap.of();
            }
            ImmutableSetMultimap<K, V> immutableSetMultimap = this.multimapView;
            if (immutableSetMultimap == null) {
                ImmutableSetMultimap<K, V> immutableSetMultimap2 = new ImmutableSetMultimap<>(new MapViewOfValuesAsSingletonSets(this, null), size(), null);
                this.multimapView = immutableSetMultimap2;
                return immutableSetMultimap2;
            }
            return immutableSetMultimap;
        }
        return (ImmutableSetMultimap) invokeV.objValue;
    }

    @Override // java.util.Map
    @Deprecated
    public final void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) ? get(obj) != null : invokeL.booleanValue;
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) ? values().contains(obj) : invokeL.booleanValue;
    }

    public abstract ImmutableSet<Map.Entry<K, V>> createEntrySet();

    public abstract ImmutableSet<K> createKeySet();

    public abstract ImmutableCollection<V> createValues();

    @Override // java.util.Map
    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, obj)) == null) ? Maps.i(this, obj) : invokeL.booleanValue;
    }

    @Override // java.util.Map
    public abstract V get(Object obj);

    @Override // java.util.Map
    public final V getOrDefault(Object obj, V v) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, obj, v)) == null) {
            V v2 = get(obj);
            return v2 != null ? v2 : v;
        }
        return (V) invokeLL.objValue;
    }

    @Override // java.util.Map
    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? Sets.d(entrySet()) : invokeV.intValue;
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? size() == 0 : invokeV.booleanValue;
    }

    public boolean isHashCodeFast() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public abstract boolean isPartialView();

    public o1<K> keyIterator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? new a(this, entrySet().iterator()) : (o1) invokeV.objValue;
    }

    @Override // java.util.Map
    @Deprecated
    public final V put(K k2, V v) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048595, this, k2, v)) == null) {
            throw new UnsupportedOperationException();
        }
        return (V) invokeLL.objValue;
    }

    @Override // java.util.Map
    @Deprecated
    public final void putAll(Map<? extends K, ? extends V> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, map) == null) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.Map
    @Deprecated
    public final V remove(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, obj)) == null) {
            throw new UnsupportedOperationException();
        }
        return (V) invokeL.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? Maps.C(this) : (String) invokeV.objValue;
    }

    public Object writeReplace() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? new SerializedForm(this) : invokeV.objValue;
    }

    public static <K, V> ImmutableMap<K, V> of(K k2, V v) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, k2, v)) == null) {
            m.a(k2, v);
            return RegularImmutableMap.create(1, new Object[]{k2, v});
        }
        return (ImmutableMap) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Map
    public ImmutableSet<Map.Entry<K, V>> entrySet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            ImmutableSet<Map.Entry<K, V>> immutableSet = this.entrySet;
            if (immutableSet == null) {
                ImmutableSet<Map.Entry<K, V>> createEntrySet = createEntrySet();
                this.entrySet = createEntrySet;
                return createEntrySet;
            }
            return immutableSet;
        }
        return (ImmutableSet) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Map
    public ImmutableSet<K> keySet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            ImmutableSet<K> immutableSet = this.keySet;
            if (immutableSet == null) {
                ImmutableSet<K> createKeySet = createKeySet();
                this.keySet = createKeySet;
                return createKeySet;
            }
            return immutableSet;
        }
        return (ImmutableSet) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Map
    public ImmutableCollection<V> values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            ImmutableCollection<V> immutableCollection = this.values;
            if (immutableCollection == null) {
                ImmutableCollection<V> createValues = createValues();
                this.values = createValues;
                return createValues;
            }
            return immutableCollection;
        }
        return (ImmutableCollection) invokeV.objValue;
    }

    public static <K, V> ImmutableMap<K, V> of(K k2, V v, K k3, V v2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65547, null, k2, v, k3, v2)) == null) {
            m.a(k2, v);
            m.a(k3, v2);
            return RegularImmutableMap.create(2, new Object[]{k2, v, k3, v2});
        }
        return (ImmutableMap) invokeLLLL.objValue;
    }

    public static <K, V> ImmutableMap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, iterable)) == null) {
            b bVar = new b(iterable instanceof Collection ? ((Collection) iterable).size() : 4);
            bVar.e(iterable);
            return bVar.a();
        }
        return (ImmutableMap) invokeL.objValue;
    }

    public static <K, V> ImmutableMap<K, V> of(K k2, V v, K k3, V v2, K k4, V v3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, null, new Object[]{k2, v, k3, v2, k4, v3})) == null) {
            m.a(k2, v);
            m.a(k3, v2);
            m.a(k4, v3);
            return RegularImmutableMap.create(3, new Object[]{k2, v, k3, v2, k4, v3});
        }
        return (ImmutableMap) invokeCommon.objValue;
    }

    public static <K, V> ImmutableMap<K, V> of(K k2, V v, K k3, V v2, K k4, V v3, K k5, V v4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65549, null, new Object[]{k2, v, k3, v2, k4, v3, k5, v4})) == null) {
            m.a(k2, v);
            m.a(k3, v2);
            m.a(k4, v3);
            m.a(k5, v4);
            return RegularImmutableMap.create(4, new Object[]{k2, v, k3, v2, k4, v3, k5, v4});
        }
        return (ImmutableMap) invokeCommon.objValue;
    }

    public static <K, V> ImmutableMap<K, V> of(K k2, V v, K k3, V v2, K k4, V v3, K k5, V v4, K k6, V v5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65550, null, new Object[]{k2, v, k3, v2, k4, v3, k5, v4, k6, v5})) == null) {
            m.a(k2, v);
            m.a(k3, v2);
            m.a(k4, v3);
            m.a(k5, v4);
            m.a(k6, v5);
            return RegularImmutableMap.create(5, new Object[]{k2, v, k3, v2, k4, v3, k5, v4, k6, v5});
        }
        return (ImmutableMap) invokeCommon.objValue;
    }
}
