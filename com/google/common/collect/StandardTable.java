package com.google.common.collect;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.common.base.Predicates;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import d.f.d.a.n;
import d.f.d.a.o;
import d.f.d.a.r;
import d.f.d.c.e0;
import d.f.d.c.k1;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
/* loaded from: classes7.dex */
public class StandardTable<R, C, V> extends d.f.d.c.i<R, C, V> implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public static final long serialVersionUID = 0;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<R, Map<C, V>> backingMap;
    public transient Set<C> columnKeySet;
    public transient StandardTable<R, C, V>.f columnMap;
    public final r<? extends Map<C, V>> factory;
    public transient Map<R, Map<C, V>> rowMap;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public class c extends Maps.y<R, V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: h  reason: collision with root package name */
        public final C f33307h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ StandardTable f33308i;

        /* loaded from: classes7.dex */
        public class a extends Sets.c<Map.Entry<R, V>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f33309e;

            public a(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f33309e = cVar;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public void clear() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f33309e.d(Predicates.b());
                }
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object obj) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
                    if (obj instanceof Map.Entry) {
                        Map.Entry entry = (Map.Entry) obj;
                        return this.f33309e.f33308i.containsMapping(entry.getKey(), this.f33309e.f33307h, entry.getValue());
                    }
                    return false;
                }
                return invokeL.booleanValue;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean isEmpty() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                    c cVar = this.f33309e;
                    return !cVar.f33308i.containsColumn(cVar.f33307h);
                }
                return invokeV.booleanValue;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<R, V>> iterator() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? new b(this.f33309e, null) : (Iterator) invokeV.objValue;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object obj) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, obj)) == null) {
                    if (obj instanceof Map.Entry) {
                        Map.Entry entry = (Map.Entry) obj;
                        return this.f33309e.f33308i.removeMapping(entry.getKey(), this.f33309e.f33307h, entry.getValue());
                    }
                    return false;
                }
                return invokeL.booleanValue;
            }

            @Override // com.google.common.collect.Sets.c, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean retainAll(Collection<?> collection) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, collection)) == null) ? this.f33309e.d(Predicates.j(Predicates.g(collection))) : invokeL.booleanValue;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                    int i2 = 0;
                    for (Map<C, V> map : this.f33309e.f33308i.backingMap.values()) {
                        if (map.containsKey(this.f33309e.f33307h)) {
                            i2++;
                        }
                    }
                    return i2;
                }
                return invokeV.intValue;
            }

            public /* synthetic */ a(c cVar, a aVar) {
                this(cVar);
            }
        }

        /* renamed from: com.google.common.collect.StandardTable$c$c  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0388c extends Maps.q<R, V> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ c f33314f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0388c(c cVar) {
                super(cVar);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        super((Map) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f33314f = cVar;
            }

            @Override // com.google.common.collect.Maps.q, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object obj) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                    c cVar = this.f33314f;
                    return cVar.f33308i.contains(obj, cVar.f33307h);
                }
                return invokeL.booleanValue;
            }

            @Override // com.google.common.collect.Maps.q, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object obj) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
                    c cVar = this.f33314f;
                    return cVar.f33308i.remove(obj, cVar.f33307h) != null;
                }
                return invokeL.booleanValue;
            }

            @Override // com.google.common.collect.Sets.c, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean retainAll(Collection<?> collection) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, collection)) == null) ? this.f33314f.d(Maps.q(Predicates.j(Predicates.g(collection)))) : invokeL.booleanValue;
            }
        }

        /* loaded from: classes7.dex */
        public class d extends Maps.x<R, V> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ c f33315f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public d(c cVar) {
                super(cVar);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        super((Map) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f33315f = cVar;
            }

            @Override // com.google.common.collect.Maps.x, java.util.AbstractCollection, java.util.Collection
            public boolean remove(Object obj) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) ? obj != null && this.f33315f.d(Maps.Q(Predicates.f(obj))) : invokeL.booleanValue;
            }

            @Override // com.google.common.collect.Maps.x, java.util.AbstractCollection, java.util.Collection
            public boolean removeAll(Collection<?> collection) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, collection)) == null) ? this.f33315f.d(Maps.Q(Predicates.g(collection))) : invokeL.booleanValue;
            }

            @Override // com.google.common.collect.Maps.x, java.util.AbstractCollection, java.util.Collection
            public boolean retainAll(Collection<?> collection) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, collection)) == null) ? this.f33315f.d(Maps.Q(Predicates.j(Predicates.g(collection)))) : invokeL.booleanValue;
            }
        }

        public c(StandardTable standardTable, C c2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {standardTable, c2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f33308i = standardTable;
            n.p(c2);
            this.f33307h = c2;
        }

        @Override // com.google.common.collect.Maps.y
        public Set<Map.Entry<R, V>> a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new a(this, null) : (Set) invokeV.objValue;
        }

        @Override // com.google.common.collect.Maps.y
        public Set<R> b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new C0388c(this) : (Set) invokeV.objValue;
        }

        @Override // com.google.common.collect.Maps.y
        public Collection<V> c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? new d(this) : (Collection) invokeV.objValue;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) ? this.f33308i.contains(obj, this.f33307h) : invokeL.booleanValue;
        }

        public boolean d(o<? super Map.Entry<R, V>> oVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, oVar)) == null) {
                Iterator<Map.Entry<R, Map<C, V>>> it = this.f33308i.backingMap.entrySet().iterator();
                boolean z = false;
                while (it.hasNext()) {
                    Map.Entry<R, Map<C, V>> next = it.next();
                    Map<C, V> value = next.getValue();
                    V v = value.get(this.f33307h);
                    if (v != null && oVar.apply(Maps.l(next.getKey(), v))) {
                        value.remove(this.f33307h);
                        z = true;
                        if (value.isEmpty()) {
                            it.remove();
                        }
                    }
                }
                return z;
            }
            return invokeL.booleanValue;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V get(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) ? (V) this.f33308i.get(obj, this.f33307h) : (V) invokeL.objValue;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V put(R r, V v) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, r, v)) == null) ? (V) this.f33308i.put(r, this.f33307h, v) : (V) invokeLL.objValue;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V remove(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, obj)) == null) ? (V) this.f33308i.remove(obj, this.f33307h) : (V) invokeL.objValue;
        }

        /* loaded from: classes7.dex */
        public class b extends AbstractIterator<Map.Entry<R, V>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: g  reason: collision with root package name */
            public final Iterator<Map.Entry<R, Map<C, V>>> f33310g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ c f33311h;

            /* loaded from: classes7.dex */
            public class a extends d.f.d.c.b<R, V> {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Map.Entry f33312e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ b f33313f;

                /* JADX DEBUG: Incorrect args count in method signature: ()V */
                public a(b bVar, Map.Entry entry) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bVar, entry};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f33313f = bVar;
                    this.f33312e = entry;
                }

                @Override // d.f.d.c.b, java.util.Map.Entry
                public R getKey() {
                    InterceptResult invokeV;
                    Interceptable interceptable = $ic;
                    return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (R) this.f33312e.getKey() : (R) invokeV.objValue;
                }

                @Override // d.f.d.c.b, java.util.Map.Entry
                public V getValue() {
                    InterceptResult invokeV;
                    Interceptable interceptable = $ic;
                    return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (V) ((Map) this.f33312e.getValue()).get(this.f33313f.f33311h.f33307h) : (V) invokeV.objValue;
                }

                @Override // d.f.d.c.b, java.util.Map.Entry
                public V setValue(V v) {
                    InterceptResult invokeL;
                    Interceptable interceptable = $ic;
                    if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, v)) == null) {
                        C c2 = this.f33313f.f33311h.f33307h;
                        n.p(v);
                        return (V) ((Map) this.f33312e.getValue()).put(c2, v);
                    }
                    return (V) invokeL.objValue;
                }
            }

            public b(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f33311h = cVar;
                this.f33310g = this.f33311h.f33308i.backingMap.entrySet().iterator();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.common.collect.AbstractIterator
            /* renamed from: d */
            public Map.Entry<R, V> a() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                    while (this.f33310g.hasNext()) {
                        Map.Entry<R, Map<C, V>> next = this.f33310g.next();
                        if (next.getValue().containsKey(this.f33311h.f33307h)) {
                            return new a(this, next);
                        }
                    }
                    return b();
                }
                return (Map.Entry) invokeV.objValue;
            }

            public /* synthetic */ b(c cVar, a aVar) {
                this(cVar);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e extends StandardTable<R, C, V>.i<C> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ StandardTable f33319f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(StandardTable standardTable) {
            super(standardTable, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {standardTable};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((StandardTable) objArr2[0], (a) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f33319f = standardTable;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) ? this.f33319f.containsColumn(obj) : invokeL.booleanValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<C> iterator() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f33319f.createColumnKeyIterator() : (Iterator) invokeV.objValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) {
                boolean z = false;
                if (obj == null) {
                    return false;
                }
                Iterator<Map<C, V>> it = this.f33319f.backingMap.values().iterator();
                while (it.hasNext()) {
                    Map<C, V> next = it.next();
                    if (next.keySet().remove(obj)) {
                        z = true;
                        if (next.isEmpty()) {
                            it.remove();
                        }
                    }
                }
                return z;
            }
            return invokeL.booleanValue;
        }

        @Override // com.google.common.collect.Sets.c, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, collection)) == null) {
                n.p(collection);
                Iterator<Map<C, V>> it = this.f33319f.backingMap.values().iterator();
                boolean z = false;
                while (it.hasNext()) {
                    Map<C, V> next = it.next();
                    if (Iterators.u(next.keySet().iterator(), collection)) {
                        z = true;
                        if (next.isEmpty()) {
                            it.remove();
                        }
                    }
                }
                return z;
            }
            return invokeL.booleanValue;
        }

        @Override // com.google.common.collect.Sets.c, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> collection) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, collection)) == null) {
                n.p(collection);
                Iterator<Map<C, V>> it = this.f33319f.backingMap.values().iterator();
                boolean z = false;
                while (it.hasNext()) {
                    Map<C, V> next = it.next();
                    if (next.keySet().retainAll(collection)) {
                        z = true;
                        if (next.isEmpty()) {
                            it.remove();
                        }
                    }
                }
                return z;
            }
            return invokeL.booleanValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? Iterators.y(iterator()) : invokeV.intValue;
        }

        public /* synthetic */ e(StandardTable standardTable, a aVar) {
            this(standardTable);
        }
    }

    /* loaded from: classes7.dex */
    public class f extends Maps.y<C, Map<R, V>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ StandardTable f33320h;

        /* loaded from: classes7.dex */
        public class a extends StandardTable<R, C, V>.i<Map.Entry<C, Map<R, V>>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ f f33321f;

            /* renamed from: com.google.common.collect.StandardTable$f$a$a  reason: collision with other inner class name */
            /* loaded from: classes7.dex */
            public class C0389a implements d.f.d.a.g<C, Map<R, V>> {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ a f33322e;

                public C0389a(a aVar) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {aVar};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f33322e = aVar;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // d.f.d.a.g
                /* renamed from: a */
                public Map<R, V> apply(C c2) {
                    InterceptResult invokeL;
                    Interceptable interceptable = $ic;
                    return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, c2)) == null) ? this.f33322e.f33321f.f33320h.column(c2) : (Map) invokeL.objValue;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(f fVar) {
                super(fVar.f33320h, null);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        Object[] objArr2 = newInitContext.callArgs;
                        super((StandardTable) objArr2[0], (a) objArr2[1]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f33321f = fVar;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object obj) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                    if (obj instanceof Map.Entry) {
                        Map.Entry entry = (Map.Entry) obj;
                        if (this.f33321f.f33320h.containsColumn(entry.getKey())) {
                            return this.f33321f.get(entry.getKey()).equals(entry.getValue());
                        }
                        return false;
                    }
                    return false;
                }
                return invokeL.booleanValue;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<C, Map<R, V>>> iterator() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? Maps.d(this.f33321f.f33320h.columnKeySet(), new C0389a(this)) : (Iterator) invokeV.objValue;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object obj) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) {
                    if (contains(obj)) {
                        this.f33321f.f33320h.removeColumn(((Map.Entry) obj).getKey());
                        return true;
                    }
                    return false;
                }
                return invokeL.booleanValue;
            }

            @Override // com.google.common.collect.Sets.c, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean removeAll(Collection<?> collection) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, collection)) == null) {
                    n.p(collection);
                    return Sets.l(this, collection.iterator());
                }
                return invokeL.booleanValue;
            }

            /* JADX DEBUG: Multi-variable search result rejected for r3v2, resolved type: com.google.common.collect.StandardTable */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.Sets.c, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean retainAll(Collection<?> collection) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, collection)) == null) {
                    n.p(collection);
                    Iterator it = Lists.k(this.f33321f.f33320h.columnKeySet().iterator()).iterator();
                    boolean z = false;
                    while (it.hasNext()) {
                        Object next = it.next();
                        if (!collection.contains(Maps.l(next, this.f33321f.f33320h.column(next)))) {
                            this.f33321f.f33320h.removeColumn(next);
                            z = true;
                        }
                    }
                    return z;
                }
                return invokeL.booleanValue;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f33321f.f33320h.columnKeySet().size() : invokeV.intValue;
            }
        }

        /* loaded from: classes7.dex */
        public class b extends Maps.x<C, Map<R, V>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ f f33323f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(f fVar) {
                super(fVar);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        super((Map) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f33323f = fVar;
            }

            @Override // com.google.common.collect.Maps.x, java.util.AbstractCollection, java.util.Collection
            public boolean remove(Object obj) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                    for (Map.Entry<C, Map<R, V>> entry : this.f33323f.entrySet()) {
                        if (entry.getValue().equals(obj)) {
                            this.f33323f.f33320h.removeColumn(entry.getKey());
                            return true;
                        }
                    }
                    return false;
                }
                return invokeL.booleanValue;
            }

            /* JADX DEBUG: Multi-variable search result rejected for r3v2, resolved type: com.google.common.collect.StandardTable */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.Maps.x, java.util.AbstractCollection, java.util.Collection
            public boolean removeAll(Collection<?> collection) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, collection)) == null) {
                    n.p(collection);
                    Iterator it = Lists.k(this.f33323f.f33320h.columnKeySet().iterator()).iterator();
                    boolean z = false;
                    while (it.hasNext()) {
                        Object next = it.next();
                        if (collection.contains(this.f33323f.f33320h.column(next))) {
                            this.f33323f.f33320h.removeColumn(next);
                            z = true;
                        }
                    }
                    return z;
                }
                return invokeL.booleanValue;
            }

            /* JADX DEBUG: Multi-variable search result rejected for r3v2, resolved type: com.google.common.collect.StandardTable */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.Maps.x, java.util.AbstractCollection, java.util.Collection
            public boolean retainAll(Collection<?> collection) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, collection)) == null) {
                    n.p(collection);
                    Iterator it = Lists.k(this.f33323f.f33320h.columnKeySet().iterator()).iterator();
                    boolean z = false;
                    while (it.hasNext()) {
                        Object next = it.next();
                        if (!collection.contains(this.f33323f.f33320h.column(next))) {
                            this.f33323f.f33320h.removeColumn(next);
                            z = true;
                        }
                    }
                    return z;
                }
                return invokeL.booleanValue;
            }
        }

        public f(StandardTable standardTable) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {standardTable};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f33320h = standardTable;
        }

        @Override // com.google.common.collect.Maps.y
        public Set<Map.Entry<C, Map<R, V>>> a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new a(this) : (Set) invokeV.objValue;
        }

        @Override // com.google.common.collect.Maps.y
        public Collection<Map<R, V>> c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new b(this) : (Collection) invokeV.objValue;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) ? this.f33320h.containsColumn(obj) : invokeL.booleanValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.AbstractMap, java.util.Map
        /* renamed from: d */
        public Map<R, V> get(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
                if (this.f33320h.containsColumn(obj)) {
                    return this.f33320h.column(obj);
                }
                return null;
            }
            return (Map) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.AbstractMap, java.util.Map
        /* renamed from: e */
        public Map<R, V> remove(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, obj)) == null) {
                if (this.f33320h.containsColumn(obj)) {
                    return this.f33320h.removeColumn(obj);
                }
                return null;
            }
            return (Map) invokeL.objValue;
        }

        @Override // com.google.common.collect.Maps.y, java.util.AbstractMap, java.util.Map
        public Set<C> keySet() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f33320h.columnKeySet() : (Set) invokeV.objValue;
        }

        public /* synthetic */ f(StandardTable standardTable, a aVar) {
            this(standardTable);
        }
    }

    /* loaded from: classes7.dex */
    public class g extends Maps.p<C, V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final R f33324e;

        /* renamed from: f  reason: collision with root package name */
        public Map<C, V> f33325f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ StandardTable f33326g;

        /* loaded from: classes7.dex */
        public class a implements Iterator<Map.Entry<C, V>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Iterator f33327e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ g f33328f;

            public a(g gVar, Iterator it) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {gVar, it};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f33328f = gVar;
                this.f33327e = it;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Iterator
            /* renamed from: a */
            public Map.Entry<C, V> next() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f33328f.e((Map.Entry) this.f33327e.next()) : (Map.Entry) invokeV.objValue;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f33327e.hasNext() : invokeV.booleanValue;
            }

            @Override // java.util.Iterator
            public void remove() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                    this.f33327e.remove();
                    this.f33328f.d();
                }
            }
        }

        /* loaded from: classes7.dex */
        public class b extends e0<C, V> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Map.Entry f33329e;

            public b(g gVar, Map.Entry entry) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {gVar, entry};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f33329e = entry;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.f.d.c.h0
            /* renamed from: d */
            public Map.Entry<C, V> delegate() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f33329e : (Map.Entry) invokeV.objValue;
            }

            @Override // d.f.d.c.e0, java.util.Map.Entry
            public boolean equals(Object obj) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) ? standardEquals(obj) : invokeL.booleanValue;
            }

            @Override // d.f.d.c.e0, java.util.Map.Entry
            public V setValue(V v) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, v)) == null) {
                    n.p(v);
                    return (V) super.setValue(v);
                }
                return (V) invokeL.objValue;
            }
        }

        public g(StandardTable standardTable, R r) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {standardTable, r};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f33326g = standardTable;
            n.p(r);
            this.f33324e = r;
        }

        @Override // com.google.common.collect.Maps.p
        public Iterator<Map.Entry<C, V>> a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                Map<C, V> b2 = b();
                if (b2 == null) {
                    return Iterators.k();
                }
                return new a(this, b2.entrySet().iterator());
            }
            return (Iterator) invokeV.objValue;
        }

        public Map<C, V> b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                Map<C, V> map = this.f33325f;
                if (map == null || (map.isEmpty() && this.f33326g.backingMap.containsKey(this.f33324e))) {
                    Map<C, V> c2 = c();
                    this.f33325f = c2;
                    return c2;
                }
                return this.f33325f;
            }
            return (Map) invokeV.objValue;
        }

        public Map<C, V> c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f33326g.backingMap.get(this.f33324e) : (Map) invokeV.objValue;
        }

        @Override // com.google.common.collect.Maps.p, java.util.AbstractMap, java.util.Map
        public void clear() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                Map<C, V> b2 = b();
                if (b2 != null) {
                    b2.clear();
                }
                d();
            }
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, obj)) == null) {
                Map<C, V> b2 = b();
                return (obj == null || b2 == null || !Maps.z(b2, obj)) ? false : true;
            }
            return invokeL.booleanValue;
        }

        public void d() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && b() != null && this.f33325f.isEmpty()) {
                this.f33326g.backingMap.remove(this.f33324e);
                this.f33325f = null;
            }
        }

        public Map.Entry<C, V> e(Map.Entry<C, V> entry) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, entry)) == null) ? new b(this, entry) : (Map.Entry) invokeL.objValue;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V get(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, obj)) == null) {
                Map<C, V> b2 = b();
                if (obj == null || b2 == null) {
                    return null;
                }
                return (V) Maps.A(b2, obj);
            }
            return (V) invokeL.objValue;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V put(C c2, V v) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, c2, v)) == null) {
                n.p(c2);
                n.p(v);
                Map<C, V> map = this.f33325f;
                if (map != null && !map.isEmpty()) {
                    return this.f33325f.put(c2, v);
                }
                return (V) this.f33326g.put(this.f33324e, c2, v);
            }
            return (V) invokeLL.objValue;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V remove(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, obj)) == null) {
                Map<C, V> b2 = b();
                if (b2 == null) {
                    return null;
                }
                V v = (V) Maps.B(b2, obj);
                d();
                return v;
            }
            return (V) invokeL.objValue;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                Map<C, V> b2 = b();
                if (b2 == null) {
                    return 0;
                }
                return b2.size();
            }
            return invokeV.intValue;
        }
    }

    /* loaded from: classes7.dex */
    public class h extends Maps.y<R, Map<C, V>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ StandardTable f33330h;

        /* loaded from: classes7.dex */
        public class a extends StandardTable<R, C, V>.i<Map.Entry<R, Map<C, V>>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ h f33331f;

            /* renamed from: com.google.common.collect.StandardTable$h$a$a  reason: collision with other inner class name */
            /* loaded from: classes7.dex */
            public class C0390a implements d.f.d.a.g<R, Map<C, V>> {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ a f33332e;

                public C0390a(a aVar) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {aVar};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f33332e = aVar;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // d.f.d.a.g
                /* renamed from: a */
                public Map<C, V> apply(R r) {
                    InterceptResult invokeL;
                    Interceptable interceptable = $ic;
                    return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, r)) == null) ? this.f33332e.f33331f.f33330h.row(r) : (Map) invokeL.objValue;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(h hVar) {
                super(hVar.f33330h, null);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {hVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        Object[] objArr2 = newInitContext.callArgs;
                        super((StandardTable) objArr2[0], (a) objArr2[1]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f33331f = hVar;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object obj) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                    if (obj instanceof Map.Entry) {
                        Map.Entry entry = (Map.Entry) obj;
                        return entry.getKey() != null && (entry.getValue() instanceof Map) && d.f.d.c.n.e(this.f33331f.f33330h.backingMap.entrySet(), entry);
                    }
                    return false;
                }
                return invokeL.booleanValue;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<R, Map<C, V>>> iterator() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? Maps.d(this.f33331f.f33330h.backingMap.keySet(), new C0390a(this)) : (Iterator) invokeV.objValue;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object obj) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) {
                    if (obj instanceof Map.Entry) {
                        Map.Entry entry = (Map.Entry) obj;
                        return entry.getKey() != null && (entry.getValue() instanceof Map) && this.f33331f.f33330h.backingMap.entrySet().remove(entry);
                    }
                    return false;
                }
                return invokeL.booleanValue;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f33331f.f33330h.backingMap.size() : invokeV.intValue;
            }
        }

        public h(StandardTable standardTable) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {standardTable};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f33330h = standardTable;
        }

        @Override // com.google.common.collect.Maps.y
        public Set<Map.Entry<R, Map<C, V>>> a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new a(this) : (Set) invokeV.objValue;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) ? this.f33330h.containsRow(obj) : invokeL.booleanValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.AbstractMap, java.util.Map
        /* renamed from: d */
        public Map<C, V> get(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) {
                if (this.f33330h.containsRow(obj)) {
                    return this.f33330h.row(obj);
                }
                return null;
            }
            return (Map) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.AbstractMap, java.util.Map
        /* renamed from: e */
        public Map<C, V> remove(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
                if (obj == null) {
                    return null;
                }
                return this.f33330h.backingMap.remove(obj);
            }
            return (Map) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public abstract class i<T> extends Sets.c<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ StandardTable f33333e;

        public i(StandardTable standardTable) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {standardTable};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f33333e = standardTable;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f33333e.backingMap.clear();
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f33333e.backingMap.isEmpty() : invokeV.booleanValue;
        }

        public /* synthetic */ i(StandardTable standardTable, a aVar) {
            this(standardTable);
        }
    }

    public StandardTable(Map<R, Map<C, V>> map, r<? extends Map<C, V>> rVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {map, rVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.backingMap = map;
        this.factory = rVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean containsMapping(Object obj, Object obj2, Object obj3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65540, this, obj, obj2, obj3)) == null) ? obj3 != null && obj3.equals(get(obj, obj2)) : invokeLLL.booleanValue;
    }

    private Map<C, V> getOrCreate(R r) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, r)) == null) {
            Map<C, V> map = this.backingMap.get(r);
            if (map == null) {
                Map<C, V> map2 = this.factory.get();
                this.backingMap.put(r, map2);
                return map2;
            }
            return map;
        }
        return (Map) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<R, V> removeColumn(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, obj)) == null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Iterator<Map.Entry<R, Map<C, V>>> it = this.backingMap.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<R, Map<C, V>> next = it.next();
                V remove = next.getValue().remove(obj);
                if (remove != null) {
                    linkedHashMap.put(next.getKey(), remove);
                    if (next.getValue().isEmpty()) {
                        it.remove();
                    }
                }
            }
            return linkedHashMap;
        }
        return (Map) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean removeMapping(Object obj, Object obj2, Object obj3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65543, this, obj, obj2, obj3)) == null) {
            if (containsMapping(obj, obj2, obj3)) {
                remove(obj, obj2);
                return true;
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    @Override // d.f.d.c.i
    public Iterator<k1.a<R, C, V>> cellIterator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new b(this, null) : (Iterator) invokeV.objValue;
    }

    @Override // d.f.d.c.i, d.f.d.c.k1
    public Set<k1.a<R, C, V>> cellSet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? super.cellSet() : (Set) invokeV.objValue;
    }

    @Override // d.f.d.c.i, d.f.d.c.k1
    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.backingMap.clear();
        }
    }

    @Override // d.f.d.c.k1
    public Map<R, V> column(C c2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, c2)) == null) ? new c(this, c2) : (Map) invokeL.objValue;
    }

    @Override // d.f.d.c.i, d.f.d.c.k1
    public Set<C> columnKeySet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            Set<C> set = this.columnKeySet;
            if (set == null) {
                e eVar = new e(this, null);
                this.columnKeySet = eVar;
                return eVar;
            }
            return set;
        }
        return (Set) invokeV.objValue;
    }

    @Override // d.f.d.c.k1
    public Map<C, Map<R, V>> columnMap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            StandardTable<R, C, V>.f fVar = this.columnMap;
            if (fVar == null) {
                StandardTable<R, C, V>.f fVar2 = new f(this, null);
                this.columnMap = fVar2;
                return fVar2;
            }
            return fVar;
        }
        return (Map) invokeV.objValue;
    }

    @Override // d.f.d.c.i, d.f.d.c.k1
    public boolean contains(Object obj, Object obj2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, obj, obj2)) == null) ? (obj == null || obj2 == null || !super.contains(obj, obj2)) ? false : true : invokeLL.booleanValue;
    }

    @Override // d.f.d.c.i, d.f.d.c.k1
    public boolean containsColumn(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, obj)) == null) {
            if (obj == null) {
                return false;
            }
            for (Map<C, V> map : this.backingMap.values()) {
                if (Maps.z(map, obj)) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // d.f.d.c.i, d.f.d.c.k1
    public boolean containsRow(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, obj)) == null) ? obj != null && Maps.z(this.backingMap, obj) : invokeL.booleanValue;
    }

    @Override // d.f.d.c.i, d.f.d.c.k1
    public boolean containsValue(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, obj)) == null) ? obj != null && super.containsValue(obj) : invokeL.booleanValue;
    }

    public Iterator<C> createColumnKeyIterator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? new d(this, null) : (Iterator) invokeV.objValue;
    }

    public Map<R, Map<C, V>> createRowMap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? new h(this) : (Map) invokeV.objValue;
    }

    @Override // d.f.d.c.i, d.f.d.c.k1
    public V get(Object obj, Object obj2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, obj, obj2)) == null) {
            if (obj == null || obj2 == null) {
                return null;
            }
            return (V) super.get(obj, obj2);
        }
        return (V) invokeLL.objValue;
    }

    @Override // d.f.d.c.i, d.f.d.c.k1
    public boolean isEmpty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.backingMap.isEmpty() : invokeV.booleanValue;
    }

    @Override // d.f.d.c.i, d.f.d.c.k1
    public V put(R r, C c2, V v) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048590, this, r, c2, v)) == null) {
            n.p(r);
            n.p(c2);
            n.p(v);
            return getOrCreate(r).put(c2, v);
        }
        return (V) invokeLLL.objValue;
    }

    @Override // d.f.d.c.i, d.f.d.c.k1
    public V remove(Object obj, Object obj2) {
        InterceptResult invokeLL;
        Map map;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, obj, obj2)) == null) {
            if (obj == null || obj2 == null || (map = (Map) Maps.A(this.backingMap, obj)) == null) {
                return null;
            }
            V v = (V) map.remove(obj2);
            if (map.isEmpty()) {
                this.backingMap.remove(obj);
            }
            return v;
        }
        return (V) invokeLL.objValue;
    }

    @Override // d.f.d.c.k1
    public Map<C, V> row(R r) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, r)) == null) ? new g(this, r) : (Map) invokeL.objValue;
    }

    @Override // d.f.d.c.i, d.f.d.c.k1
    public Set<R> rowKeySet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? rowMap().keySet() : (Set) invokeV.objValue;
    }

    @Override // d.f.d.c.k1
    public Map<R, Map<C, V>> rowMap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            Map<R, Map<C, V>> map = this.rowMap;
            if (map == null) {
                Map<R, Map<C, V>> createRowMap = createRowMap();
                this.rowMap = createRowMap;
                return createRowMap;
            }
            return map;
        }
        return (Map) invokeV.objValue;
    }

    @Override // d.f.d.c.k1
    public int size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            int i2 = 0;
            for (Map<C, V> map : this.backingMap.values()) {
                i2 += map.size();
            }
            return i2;
        }
        return invokeV.intValue;
    }

    @Override // d.f.d.c.i, d.f.d.c.k1
    public Collection<V> values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? super.values() : (Collection) invokeV.objValue;
    }

    /* loaded from: classes7.dex */
    public class b implements Iterator<k1.a<R, C, V>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final Iterator<Map.Entry<R, Map<C, V>>> f33303e;

        /* renamed from: f  reason: collision with root package name */
        public Map.Entry<R, Map<C, V>> f33304f;

        /* renamed from: g  reason: collision with root package name */
        public Iterator<Map.Entry<C, V>> f33305g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ StandardTable f33306h;

        public b(StandardTable standardTable) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {standardTable};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f33306h = standardTable;
            this.f33303e = this.f33306h.backingMap.entrySet().iterator();
            this.f33305g = Iterators.k();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Iterator
        /* renamed from: a */
        public k1.a<R, C, V> next() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (!this.f33305g.hasNext()) {
                    Map.Entry<R, Map<C, V>> next = this.f33303e.next();
                    this.f33304f = next;
                    this.f33305g = next.getValue().entrySet().iterator();
                }
                Map.Entry<C, V> next2 = this.f33305g.next();
                return Tables.c(this.f33304f.getKey(), next2.getKey(), next2.getValue());
            }
            return (k1.a) invokeV.objValue;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f33303e.hasNext() || this.f33305g.hasNext() : invokeV.booleanValue;
        }

        @Override // java.util.Iterator
        public void remove() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.f33305g.remove();
                if (this.f33304f.getValue().isEmpty()) {
                    this.f33303e.remove();
                    this.f33304f = null;
                }
            }
        }

        public /* synthetic */ b(StandardTable standardTable, a aVar) {
            this(standardTable);
        }
    }

    /* loaded from: classes7.dex */
    public class d extends AbstractIterator<C> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: g  reason: collision with root package name */
        public final Map<C, V> f33316g;

        /* renamed from: h  reason: collision with root package name */
        public final Iterator<Map<C, V>> f33317h;

        /* renamed from: i  reason: collision with root package name */
        public Iterator<Map.Entry<C, V>> f33318i;
        public final /* synthetic */ StandardTable j;

        public d(StandardTable standardTable) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {standardTable};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.j = standardTable;
            this.f33316g = this.j.factory.get();
            this.f33317h = this.j.backingMap.values().iterator();
            this.f33318i = Iterators.i();
        }

        @Override // com.google.common.collect.AbstractIterator
        public C a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeV = interceptable.invokeV(1048576, this)) != null) {
                return (C) invokeV.objValue;
            }
            while (true) {
                if (this.f33318i.hasNext()) {
                    Map.Entry<C, V> next = this.f33318i.next();
                    if (!this.f33316g.containsKey(next.getKey())) {
                        this.f33316g.put(next.getKey(), next.getValue());
                        return next.getKey();
                    }
                } else if (this.f33317h.hasNext()) {
                    this.f33318i = this.f33317h.next().entrySet().iterator();
                } else {
                    return b();
                }
            }
        }

        public /* synthetic */ d(StandardTable standardTable, a aVar) {
            this(standardTable);
        }
    }
}
