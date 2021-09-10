package com.bytedance.sdk.openadsdk.preload.a.b;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
/* loaded from: classes9.dex */
public final class h<K, V> extends AbstractMap<K, V> implements Serializable {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final /* synthetic */ boolean f68502f;

    /* renamed from: g  reason: collision with root package name */
    public static final Comparator<Comparable> f68503g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Comparator<? super K> f68504a;

    /* renamed from: b  reason: collision with root package name */
    public d<K, V> f68505b;

    /* renamed from: c  reason: collision with root package name */
    public int f68506c;

    /* renamed from: d  reason: collision with root package name */
    public int f68507d;

    /* renamed from: e  reason: collision with root package name */
    public final d<K, V> f68508e;

    /* renamed from: h  reason: collision with root package name */
    public h<K, V>.a f68509h;

    /* renamed from: i  reason: collision with root package name */
    public h<K, V>.b f68510i;

    /* loaded from: classes9.dex */
    public class a extends AbstractSet<Map.Entry<K, V>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ h f68511a;

        public a(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f68511a = hVar;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f68511a.clear();
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) ? (obj instanceof Map.Entry) && this.f68511a.a((Map.Entry) obj) != null : invokeL.booleanValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? new h<K, V>.c<Map.Entry<K, V>>(this) { // from class: com.bytedance.sdk.openadsdk.preload.a.b.h.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f68512a;

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
                            h hVar = (h) newInitContext.callArgs[0];
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f68512a = this;
                    h hVar2 = this.f68511a;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Iterator
                /* renamed from: a */
                public Map.Entry<K, V> next() {
                    InterceptResult invokeV2;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048576, this)) == null) ? b() : (Map.Entry) invokeV2.objValue;
                }
            } : (Iterator) invokeV.objValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            InterceptResult invokeL;
            d<K, V> a2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
                if ((obj instanceof Map.Entry) && (a2 = this.f68511a.a((Map.Entry) obj)) != null) {
                    this.f68511a.a((d) a2, true);
                    return true;
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f68511a.f68506c : invokeV.intValue;
        }
    }

    /* loaded from: classes9.dex */
    public final class b extends AbstractSet<K> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ h f68513a;

        public b(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f68513a = hVar;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f68513a.clear();
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) ? this.f68513a.containsKey(obj) : invokeL.booleanValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? new h<K, V>.c<K>(this) { // from class: com.bytedance.sdk.openadsdk.preload.a.b.h.b.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ b f68514a;

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
                            h hVar = (h) newInitContext.callArgs[0];
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f68514a = this;
                    h hVar2 = this.f68513a;
                }

                @Override // java.util.Iterator
                public K next() {
                    InterceptResult invokeV2;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048576, this)) == null) ? b().f68524f : (K) invokeV2.objValue;
                }
            } : (Iterator) invokeV.objValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) ? this.f68513a.b(obj) != null : invokeL.booleanValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f68513a.f68506c : invokeV.intValue;
        }
    }

    /* loaded from: classes9.dex */
    public abstract class c<T> implements Iterator<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public d<K, V> f68515b;

        /* renamed from: c  reason: collision with root package name */
        public d<K, V> f68516c;

        /* renamed from: d  reason: collision with root package name */
        public int f68517d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f68518e;

        public c(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f68518e = hVar;
            h hVar2 = this.f68518e;
            this.f68515b = hVar2.f68508e.f68522d;
            this.f68516c = null;
            this.f68517d = hVar2.f68507d;
        }

        public final d<K, V> b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                d<K, V> dVar = this.f68515b;
                h hVar = this.f68518e;
                if (dVar != hVar.f68508e) {
                    if (hVar.f68507d == this.f68517d) {
                        this.f68515b = dVar.f68522d;
                        this.f68516c = dVar;
                        return dVar;
                    }
                    throw new ConcurrentModificationException();
                }
                throw new NoSuchElementException();
            }
            return (d) invokeV.objValue;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f68515b != this.f68518e.f68508e : invokeV.booleanValue;
        }

        @Override // java.util.Iterator
        public final void remove() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                d<K, V> dVar = this.f68516c;
                if (dVar != null) {
                    this.f68518e.a((d) dVar, true);
                    this.f68516c = null;
                    this.f68517d = this.f68518e.f68507d;
                    return;
                }
                throw new IllegalStateException();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(639650857, "Lcom/bytedance/sdk/openadsdk/preload/a/b/h;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(639650857, "Lcom/bytedance/sdk/openadsdk/preload/a/b/h;");
                return;
            }
        }
        f68502f = !h.class.desiredAssertionStatus();
        f68503g = new Comparator<Comparable>() { // from class: com.bytedance.sdk.openadsdk.preload.a.b.h.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(Comparable comparable, Comparable comparable2) {
                InterceptResult invokeLL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, comparable, comparable2)) == null) ? comparable.compareTo(comparable2) : invokeLL.intValue;
            }
        };
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public h() {
        this(f68503g);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this((Comparator) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Type inference failed for r4v3. Raw type applied. Possible types: K, ? super K */
    public d<K, V> a(K k, boolean z) {
        InterceptResult invokeLZ;
        int i2;
        d<K, V> dVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, k, z)) == null) {
            Comparator<? super K> comparator = this.f68504a;
            d<K, V> dVar2 = this.f68505b;
            if (dVar2 != null) {
                Comparable comparable = comparator == f68503g ? (Comparable) k : null;
                while (true) {
                    if (comparable != null) {
                        i2 = comparable.compareTo(dVar2.f68524f);
                    } else {
                        i2 = comparator.compare(k, (K) dVar2.f68524f);
                    }
                    if (i2 == 0) {
                        return dVar2;
                    }
                    d<K, V> dVar3 = i2 < 0 ? dVar2.f68520b : dVar2.f68521c;
                    if (dVar3 == null) {
                        break;
                    }
                    dVar2 = dVar3;
                }
            } else {
                i2 = 0;
            }
            if (z) {
                d<K, V> dVar4 = this.f68508e;
                if (dVar2 == null) {
                    if (comparator == f68503g && !(k instanceof Comparable)) {
                        throw new ClassCastException(k.getClass().getName() + " is not Comparable");
                    }
                    dVar = new d<>(dVar2, k, dVar4, dVar4.f68523e);
                    this.f68505b = dVar;
                } else {
                    dVar = new d<>(dVar2, k, dVar4, dVar4.f68523e);
                    if (i2 < 0) {
                        dVar2.f68520b = dVar;
                    } else {
                        dVar2.f68521c = dVar;
                    }
                    b(dVar2, true);
                }
                this.f68506c++;
                this.f68507d++;
                return dVar;
            }
            return null;
        }
        return (d) invokeLZ.objValue;
    }

    public d<K, V> b(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, obj)) == null) {
            d<K, V> a2 = a(obj);
            if (a2 != null) {
                a((d) a2, true);
            }
            return a2;
        }
        return (d) invokeL.objValue;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f68505b = null;
            this.f68506c = 0;
            this.f68507d++;
            d<K, V> dVar = this.f68508e;
            dVar.f68523e = dVar;
            dVar.f68522d = dVar;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, obj)) == null) ? a(obj) != null : invokeL.booleanValue;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            h<K, V>.a aVar = this.f68509h;
            if (aVar != null) {
                return aVar;
            }
            h<K, V>.a aVar2 = new a(this);
            this.f68509h = aVar2;
            return aVar2;
        }
        return (Set) invokeV.objValue;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, obj)) == null) {
            d<K, V> a2 = a(obj);
            if (a2 != null) {
                return a2.f68525g;
            }
            return null;
        }
        return (V) invokeL.objValue;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            h<K, V>.b bVar = this.f68510i;
            if (bVar != null) {
                return bVar;
            }
            h<K, V>.b bVar2 = new b(this);
            this.f68510i = bVar2;
            return bVar2;
        }
        return (Set) invokeV.objValue;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k, V v) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, k, v)) == null) {
            if (k != null) {
                d<K, V> a2 = a((h<K, V>) k, true);
                V v2 = a2.f68525g;
                a2.f68525g = v;
                return v2;
            }
            throw new NullPointerException("key == null");
        }
        return (V) invokeLL.objValue;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, obj)) == null) {
            d<K, V> b2 = b(obj);
            if (b2 != null) {
                return b2.f68525g;
            }
            return null;
        }
        return (V) invokeL.objValue;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f68506c : invokeV.intValue;
    }

    public h(Comparator<? super K> comparator) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {comparator};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f68506c = 0;
        this.f68507d = 0;
        this.f68508e = new d<>();
        this.f68504a = comparator == null ? f68503g : comparator;
    }

    /* loaded from: classes9.dex */
    public static final class d<K, V> implements Map.Entry<K, V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public d<K, V> f68519a;

        /* renamed from: b  reason: collision with root package name */
        public d<K, V> f68520b;

        /* renamed from: c  reason: collision with root package name */
        public d<K, V> f68521c;

        /* renamed from: d  reason: collision with root package name */
        public d<K, V> f68522d;

        /* renamed from: e  reason: collision with root package name */
        public d<K, V> f68523e;

        /* renamed from: f  reason: collision with root package name */
        public final K f68524f;

        /* renamed from: g  reason: collision with root package name */
        public V f68525g;

        /* renamed from: h  reason: collision with root package name */
        public int f68526h;

        public d() {
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
            this.f68524f = null;
            this.f68523e = this;
            this.f68522d = this;
        }

        public d<K, V> a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                d<K, V> dVar = this;
                for (d<K, V> dVar2 = this.f68520b; dVar2 != null; dVar2 = dVar2.f68520b) {
                    dVar = dVar2;
                }
                return dVar;
            }
            return (d) invokeV.objValue;
        }

        public d<K, V> b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                d<K, V> dVar = this;
                for (d<K, V> dVar2 = this.f68521c; dVar2 != null; dVar2 = dVar2.f68521c) {
                    dVar = dVar2;
                }
                return dVar;
            }
            return (d) invokeV.objValue;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) {
                if (obj instanceof Map.Entry) {
                    Map.Entry entry = (Map.Entry) obj;
                    K k = this.f68524f;
                    if (k == null) {
                        if (entry.getKey() != null) {
                            return false;
                        }
                    } else if (!k.equals(entry.getKey())) {
                        return false;
                    }
                    V v = this.f68525g;
                    if (v == null) {
                        if (entry.getValue() != null) {
                            return false;
                        }
                    } else if (!v.equals(entry.getValue())) {
                        return false;
                    }
                    return true;
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f68524f : (K) invokeV.objValue;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f68525g : (V) invokeV.objValue;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                K k = this.f68524f;
                int hashCode = k == null ? 0 : k.hashCode();
                V v = this.f68525g;
                return hashCode ^ (v != null ? v.hashCode() : 0);
            }
            return invokeV.intValue;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, v)) == null) {
                V v2 = this.f68525g;
                this.f68525g = v;
                return v2;
            }
            return (V) invokeL.objValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                return this.f68524f + "=" + this.f68525g;
            }
            return (String) invokeV.objValue;
        }

        public d(d<K, V> dVar, K k, d<K, V> dVar2, d<K, V> dVar3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, k, dVar2, dVar3};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f68519a = dVar;
            this.f68524f = k;
            this.f68526h = 1;
            this.f68522d = dVar2;
            this.f68523e = dVar3;
            dVar3.f68522d = this;
            dVar2.f68523e = this;
        }
    }

    private void b(d<K, V> dVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65543, this, dVar, z) == null) {
            while (dVar != null) {
                d<K, V> dVar2 = dVar.f68520b;
                d<K, V> dVar3 = dVar.f68521c;
                int i2 = dVar2 != null ? dVar2.f68526h : 0;
                int i3 = dVar3 != null ? dVar3.f68526h : 0;
                int i4 = i2 - i3;
                if (i4 == -2) {
                    d<K, V> dVar4 = dVar3.f68520b;
                    d<K, V> dVar5 = dVar3.f68521c;
                    int i5 = (dVar4 != null ? dVar4.f68526h : 0) - (dVar5 != null ? dVar5.f68526h : 0);
                    if (i5 != -1 && (i5 != 0 || z)) {
                        if (!f68502f && i5 != 1) {
                            throw new AssertionError();
                        }
                        b((d) dVar3);
                        a((d) dVar);
                    } else {
                        a((d) dVar);
                    }
                    if (z) {
                        return;
                    }
                } else if (i4 == 2) {
                    d<K, V> dVar6 = dVar2.f68520b;
                    d<K, V> dVar7 = dVar2.f68521c;
                    int i6 = (dVar6 != null ? dVar6.f68526h : 0) - (dVar7 != null ? dVar7.f68526h : 0);
                    if (i6 != 1 && (i6 != 0 || z)) {
                        if (!f68502f && i6 != -1) {
                            throw new AssertionError();
                        }
                        a((d) dVar2);
                        b((d) dVar);
                    } else {
                        b((d) dVar);
                    }
                    if (z) {
                        return;
                    }
                } else if (i4 == 0) {
                    dVar.f68526h = i2 + 1;
                    if (z) {
                        return;
                    }
                } else if (!f68502f && i4 != -1 && i4 != 1) {
                    throw new AssertionError();
                } else {
                    dVar.f68526h = Math.max(i2, i3) + 1;
                    if (!z) {
                        return;
                    }
                }
                dVar = dVar.f68519a;
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    public d<K, V> a(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (obj != 0) {
                try {
                    return a((h<K, V>) obj, false);
                } catch (ClassCastException unused) {
                    return null;
                }
            }
            return null;
        }
        return (d) invokeL.objValue;
    }

    public d<K, V> a(Map.Entry<?, ?> entry) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, entry)) == null) {
            d<K, V> a2 = a(entry.getKey());
            if (a2 != null && a(a2.f68525g, entry.getValue())) {
                return a2;
            }
            return null;
        }
        return (d) invokeL.objValue;
    }

    private boolean a(Object obj, Object obj2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, this, obj, obj2)) == null) ? obj == obj2 || (obj != null && obj.equals(obj2)) : invokeLL.booleanValue;
    }

    public void a(d<K, V> dVar, boolean z) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048579, this, dVar, z) == null) {
            if (z) {
                d<K, V> dVar2 = dVar.f68523e;
                dVar2.f68522d = dVar.f68522d;
                dVar.f68522d.f68523e = dVar2;
            }
            d<K, V> dVar3 = dVar.f68520b;
            d<K, V> dVar4 = dVar.f68521c;
            d<K, V> dVar5 = dVar.f68519a;
            int i3 = 0;
            if (dVar3 != null && dVar4 != null) {
                d<K, V> b2 = dVar3.f68526h > dVar4.f68526h ? dVar3.b() : dVar4.a();
                a((d) b2, false);
                d<K, V> dVar6 = dVar.f68520b;
                if (dVar6 != null) {
                    i2 = dVar6.f68526h;
                    b2.f68520b = dVar6;
                    dVar6.f68519a = b2;
                    dVar.f68520b = null;
                } else {
                    i2 = 0;
                }
                d<K, V> dVar7 = dVar.f68521c;
                if (dVar7 != null) {
                    i3 = dVar7.f68526h;
                    b2.f68521c = dVar7;
                    dVar7.f68519a = b2;
                    dVar.f68521c = null;
                }
                b2.f68526h = Math.max(i2, i3) + 1;
                a((d) dVar, (d) b2);
                return;
            }
            if (dVar3 != null) {
                a((d) dVar, (d) dVar3);
                dVar.f68520b = null;
            } else if (dVar4 != null) {
                a((d) dVar, (d) dVar4);
                dVar.f68521c = null;
            } else {
                a((d) dVar, (d) null);
            }
            b(dVar5, false);
            this.f68506c--;
            this.f68507d++;
        }
    }

    private void b(d<K, V> dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, dVar) == null) {
            d<K, V> dVar2 = dVar.f68520b;
            d<K, V> dVar3 = dVar.f68521c;
            d<K, V> dVar4 = dVar2.f68520b;
            d<K, V> dVar5 = dVar2.f68521c;
            dVar.f68520b = dVar5;
            if (dVar5 != null) {
                dVar5.f68519a = dVar;
            }
            a((d) dVar, (d) dVar2);
            dVar2.f68521c = dVar;
            dVar.f68519a = dVar2;
            int max = Math.max(dVar3 != null ? dVar3.f68526h : 0, dVar5 != null ? dVar5.f68526h : 0) + 1;
            dVar.f68526h = max;
            dVar2.f68526h = Math.max(max, dVar4 != null ? dVar4.f68526h : 0) + 1;
        }
    }

    private void a(d<K, V> dVar, d<K, V> dVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, dVar, dVar2) == null) {
            d<K, V> dVar3 = dVar.f68519a;
            dVar.f68519a = null;
            if (dVar2 != null) {
                dVar2.f68519a = dVar3;
            }
            if (dVar3 != null) {
                if (dVar3.f68520b == dVar) {
                    dVar3.f68520b = dVar2;
                    return;
                } else if (!f68502f && dVar3.f68521c != dVar) {
                    throw new AssertionError();
                } else {
                    dVar3.f68521c = dVar2;
                    return;
                }
            }
            this.f68505b = dVar2;
        }
    }

    private void a(d<K, V> dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, dVar) == null) {
            d<K, V> dVar2 = dVar.f68520b;
            d<K, V> dVar3 = dVar.f68521c;
            d<K, V> dVar4 = dVar3.f68520b;
            d<K, V> dVar5 = dVar3.f68521c;
            dVar.f68521c = dVar4;
            if (dVar4 != null) {
                dVar4.f68519a = dVar;
            }
            a((d) dVar, (d) dVar3);
            dVar3.f68520b = dVar;
            dVar.f68519a = dVar3;
            int max = Math.max(dVar2 != null ? dVar2.f68526h : 0, dVar4 != null ? dVar4.f68526h : 0) + 1;
            dVar.f68526h = max;
            dVar3.f68526h = Math.max(max, dVar5 != null ? dVar5.f68526h : 0) + 1;
        }
    }
}
