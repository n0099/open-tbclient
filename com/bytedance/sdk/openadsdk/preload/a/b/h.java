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
    public static final /* synthetic */ boolean f68322f;

    /* renamed from: g  reason: collision with root package name */
    public static final Comparator<Comparable> f68323g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Comparator<? super K> f68324a;

    /* renamed from: b  reason: collision with root package name */
    public d<K, V> f68325b;

    /* renamed from: c  reason: collision with root package name */
    public int f68326c;

    /* renamed from: d  reason: collision with root package name */
    public int f68327d;

    /* renamed from: e  reason: collision with root package name */
    public final d<K, V> f68328e;

    /* renamed from: h  reason: collision with root package name */
    public h<K, V>.a f68329h;

    /* renamed from: i  reason: collision with root package name */
    public h<K, V>.b f68330i;

    /* loaded from: classes9.dex */
    public class a extends AbstractSet<Map.Entry<K, V>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ h f68331a;

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
            this.f68331a = hVar;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f68331a.clear();
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) ? (obj instanceof Map.Entry) && this.f68331a.a((Map.Entry) obj) != null : invokeL.booleanValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? new h<K, V>.c<Map.Entry<K, V>>(this) { // from class: com.bytedance.sdk.openadsdk.preload.a.b.h.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f68332a;

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
                    this.f68332a = this;
                    h hVar2 = this.f68331a;
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
                if ((obj instanceof Map.Entry) && (a2 = this.f68331a.a((Map.Entry) obj)) != null) {
                    this.f68331a.a((d) a2, true);
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
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f68331a.f68326c : invokeV.intValue;
        }
    }

    /* loaded from: classes9.dex */
    public final class b extends AbstractSet<K> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ h f68333a;

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
            this.f68333a = hVar;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f68333a.clear();
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) ? this.f68333a.containsKey(obj) : invokeL.booleanValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? new h<K, V>.c<K>(this) { // from class: com.bytedance.sdk.openadsdk.preload.a.b.h.b.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ b f68334a;

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
                    this.f68334a = this;
                    h hVar2 = this.f68333a;
                }

                @Override // java.util.Iterator
                public K next() {
                    InterceptResult invokeV2;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048576, this)) == null) ? b().f68344f : (K) invokeV2.objValue;
                }
            } : (Iterator) invokeV.objValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) ? this.f68333a.b(obj) != null : invokeL.booleanValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f68333a.f68326c : invokeV.intValue;
        }
    }

    /* loaded from: classes9.dex */
    public abstract class c<T> implements Iterator<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public d<K, V> f68335b;

        /* renamed from: c  reason: collision with root package name */
        public d<K, V> f68336c;

        /* renamed from: d  reason: collision with root package name */
        public int f68337d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f68338e;

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
            this.f68338e = hVar;
            h hVar2 = this.f68338e;
            this.f68335b = hVar2.f68328e.f68342d;
            this.f68336c = null;
            this.f68337d = hVar2.f68327d;
        }

        public final d<K, V> b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                d<K, V> dVar = this.f68335b;
                h hVar = this.f68338e;
                if (dVar != hVar.f68328e) {
                    if (hVar.f68327d == this.f68337d) {
                        this.f68335b = dVar.f68342d;
                        this.f68336c = dVar;
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
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f68335b != this.f68338e.f68328e : invokeV.booleanValue;
        }

        @Override // java.util.Iterator
        public final void remove() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                d<K, V> dVar = this.f68336c;
                if (dVar != null) {
                    this.f68338e.a((d) dVar, true);
                    this.f68336c = null;
                    this.f68337d = this.f68338e.f68327d;
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
        f68322f = !h.class.desiredAssertionStatus();
        f68323g = new Comparator<Comparable>() { // from class: com.bytedance.sdk.openadsdk.preload.a.b.h.1
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
        this(f68323g);
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
            Comparator<? super K> comparator = this.f68324a;
            d<K, V> dVar2 = this.f68325b;
            if (dVar2 != null) {
                Comparable comparable = comparator == f68323g ? (Comparable) k : null;
                while (true) {
                    if (comparable != null) {
                        i2 = comparable.compareTo(dVar2.f68344f);
                    } else {
                        i2 = comparator.compare(k, (K) dVar2.f68344f);
                    }
                    if (i2 == 0) {
                        return dVar2;
                    }
                    d<K, V> dVar3 = i2 < 0 ? dVar2.f68340b : dVar2.f68341c;
                    if (dVar3 == null) {
                        break;
                    }
                    dVar2 = dVar3;
                }
            } else {
                i2 = 0;
            }
            if (z) {
                d<K, V> dVar4 = this.f68328e;
                if (dVar2 == null) {
                    if (comparator == f68323g && !(k instanceof Comparable)) {
                        throw new ClassCastException(k.getClass().getName() + " is not Comparable");
                    }
                    dVar = new d<>(dVar2, k, dVar4, dVar4.f68343e);
                    this.f68325b = dVar;
                } else {
                    dVar = new d<>(dVar2, k, dVar4, dVar4.f68343e);
                    if (i2 < 0) {
                        dVar2.f68340b = dVar;
                    } else {
                        dVar2.f68341c = dVar;
                    }
                    b(dVar2, true);
                }
                this.f68326c++;
                this.f68327d++;
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
            this.f68325b = null;
            this.f68326c = 0;
            this.f68327d++;
            d<K, V> dVar = this.f68328e;
            dVar.f68343e = dVar;
            dVar.f68342d = dVar;
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
            h<K, V>.a aVar = this.f68329h;
            if (aVar != null) {
                return aVar;
            }
            h<K, V>.a aVar2 = new a(this);
            this.f68329h = aVar2;
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
                return a2.f68345g;
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
            h<K, V>.b bVar = this.f68330i;
            if (bVar != null) {
                return bVar;
            }
            h<K, V>.b bVar2 = new b(this);
            this.f68330i = bVar2;
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
                V v2 = a2.f68345g;
                a2.f68345g = v;
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
                return b2.f68345g;
            }
            return null;
        }
        return (V) invokeL.objValue;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f68326c : invokeV.intValue;
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
        this.f68326c = 0;
        this.f68327d = 0;
        this.f68328e = new d<>();
        this.f68324a = comparator == null ? f68323g : comparator;
    }

    /* loaded from: classes9.dex */
    public static final class d<K, V> implements Map.Entry<K, V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public d<K, V> f68339a;

        /* renamed from: b  reason: collision with root package name */
        public d<K, V> f68340b;

        /* renamed from: c  reason: collision with root package name */
        public d<K, V> f68341c;

        /* renamed from: d  reason: collision with root package name */
        public d<K, V> f68342d;

        /* renamed from: e  reason: collision with root package name */
        public d<K, V> f68343e;

        /* renamed from: f  reason: collision with root package name */
        public final K f68344f;

        /* renamed from: g  reason: collision with root package name */
        public V f68345g;

        /* renamed from: h  reason: collision with root package name */
        public int f68346h;

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
            this.f68344f = null;
            this.f68343e = this;
            this.f68342d = this;
        }

        public d<K, V> a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                d<K, V> dVar = this;
                for (d<K, V> dVar2 = this.f68340b; dVar2 != null; dVar2 = dVar2.f68340b) {
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
                for (d<K, V> dVar2 = this.f68341c; dVar2 != null; dVar2 = dVar2.f68341c) {
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
                    K k = this.f68344f;
                    if (k == null) {
                        if (entry.getKey() != null) {
                            return false;
                        }
                    } else if (!k.equals(entry.getKey())) {
                        return false;
                    }
                    V v = this.f68345g;
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
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f68344f : (K) invokeV.objValue;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f68345g : (V) invokeV.objValue;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                K k = this.f68344f;
                int hashCode = k == null ? 0 : k.hashCode();
                V v = this.f68345g;
                return hashCode ^ (v != null ? v.hashCode() : 0);
            }
            return invokeV.intValue;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, v)) == null) {
                V v2 = this.f68345g;
                this.f68345g = v;
                return v2;
            }
            return (V) invokeL.objValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                return this.f68344f + "=" + this.f68345g;
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
            this.f68339a = dVar;
            this.f68344f = k;
            this.f68346h = 1;
            this.f68342d = dVar2;
            this.f68343e = dVar3;
            dVar3.f68342d = this;
            dVar2.f68343e = this;
        }
    }

    private void b(d<K, V> dVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65543, this, dVar, z) == null) {
            while (dVar != null) {
                d<K, V> dVar2 = dVar.f68340b;
                d<K, V> dVar3 = dVar.f68341c;
                int i2 = dVar2 != null ? dVar2.f68346h : 0;
                int i3 = dVar3 != null ? dVar3.f68346h : 0;
                int i4 = i2 - i3;
                if (i4 == -2) {
                    d<K, V> dVar4 = dVar3.f68340b;
                    d<K, V> dVar5 = dVar3.f68341c;
                    int i5 = (dVar4 != null ? dVar4.f68346h : 0) - (dVar5 != null ? dVar5.f68346h : 0);
                    if (i5 != -1 && (i5 != 0 || z)) {
                        if (!f68322f && i5 != 1) {
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
                    d<K, V> dVar6 = dVar2.f68340b;
                    d<K, V> dVar7 = dVar2.f68341c;
                    int i6 = (dVar6 != null ? dVar6.f68346h : 0) - (dVar7 != null ? dVar7.f68346h : 0);
                    if (i6 != 1 && (i6 != 0 || z)) {
                        if (!f68322f && i6 != -1) {
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
                    dVar.f68346h = i2 + 1;
                    if (z) {
                        return;
                    }
                } else if (!f68322f && i4 != -1 && i4 != 1) {
                    throw new AssertionError();
                } else {
                    dVar.f68346h = Math.max(i2, i3) + 1;
                    if (!z) {
                        return;
                    }
                }
                dVar = dVar.f68339a;
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
            if (a2 != null && a(a2.f68345g, entry.getValue())) {
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
                d<K, V> dVar2 = dVar.f68343e;
                dVar2.f68342d = dVar.f68342d;
                dVar.f68342d.f68343e = dVar2;
            }
            d<K, V> dVar3 = dVar.f68340b;
            d<K, V> dVar4 = dVar.f68341c;
            d<K, V> dVar5 = dVar.f68339a;
            int i3 = 0;
            if (dVar3 != null && dVar4 != null) {
                d<K, V> b2 = dVar3.f68346h > dVar4.f68346h ? dVar3.b() : dVar4.a();
                a((d) b2, false);
                d<K, V> dVar6 = dVar.f68340b;
                if (dVar6 != null) {
                    i2 = dVar6.f68346h;
                    b2.f68340b = dVar6;
                    dVar6.f68339a = b2;
                    dVar.f68340b = null;
                } else {
                    i2 = 0;
                }
                d<K, V> dVar7 = dVar.f68341c;
                if (dVar7 != null) {
                    i3 = dVar7.f68346h;
                    b2.f68341c = dVar7;
                    dVar7.f68339a = b2;
                    dVar.f68341c = null;
                }
                b2.f68346h = Math.max(i2, i3) + 1;
                a((d) dVar, (d) b2);
                return;
            }
            if (dVar3 != null) {
                a((d) dVar, (d) dVar3);
                dVar.f68340b = null;
            } else if (dVar4 != null) {
                a((d) dVar, (d) dVar4);
                dVar.f68341c = null;
            } else {
                a((d) dVar, (d) null);
            }
            b(dVar5, false);
            this.f68326c--;
            this.f68327d++;
        }
    }

    private void b(d<K, V> dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, dVar) == null) {
            d<K, V> dVar2 = dVar.f68340b;
            d<K, V> dVar3 = dVar.f68341c;
            d<K, V> dVar4 = dVar2.f68340b;
            d<K, V> dVar5 = dVar2.f68341c;
            dVar.f68340b = dVar5;
            if (dVar5 != null) {
                dVar5.f68339a = dVar;
            }
            a((d) dVar, (d) dVar2);
            dVar2.f68341c = dVar;
            dVar.f68339a = dVar2;
            int max = Math.max(dVar3 != null ? dVar3.f68346h : 0, dVar5 != null ? dVar5.f68346h : 0) + 1;
            dVar.f68346h = max;
            dVar2.f68346h = Math.max(max, dVar4 != null ? dVar4.f68346h : 0) + 1;
        }
    }

    private void a(d<K, V> dVar, d<K, V> dVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, dVar, dVar2) == null) {
            d<K, V> dVar3 = dVar.f68339a;
            dVar.f68339a = null;
            if (dVar2 != null) {
                dVar2.f68339a = dVar3;
            }
            if (dVar3 != null) {
                if (dVar3.f68340b == dVar) {
                    dVar3.f68340b = dVar2;
                    return;
                } else if (!f68322f && dVar3.f68341c != dVar) {
                    throw new AssertionError();
                } else {
                    dVar3.f68341c = dVar2;
                    return;
                }
            }
            this.f68325b = dVar2;
        }
    }

    private void a(d<K, V> dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, dVar) == null) {
            d<K, V> dVar2 = dVar.f68340b;
            d<K, V> dVar3 = dVar.f68341c;
            d<K, V> dVar4 = dVar3.f68340b;
            d<K, V> dVar5 = dVar3.f68341c;
            dVar.f68341c = dVar4;
            if (dVar4 != null) {
                dVar4.f68339a = dVar;
            }
            a((d) dVar, (d) dVar3);
            dVar3.f68340b = dVar;
            dVar.f68339a = dVar3;
            int max = Math.max(dVar2 != null ? dVar2.f68346h : 0, dVar4 != null ? dVar4.f68346h : 0) + 1;
            dVar.f68346h = max;
            dVar3.f68346h = Math.max(max, dVar5 != null ? dVar5.f68346h : 0) + 1;
        }
    }
}
