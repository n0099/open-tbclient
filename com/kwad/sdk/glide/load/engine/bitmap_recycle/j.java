package com.kwad.sdk.glide.load.engine.bitmap_recycle;

import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;
/* loaded from: classes7.dex */
public final class j implements com.kwad.sdk.glide.load.engine.bitmap_recycle.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final h<a, Object> f38032a;

    /* renamed from: b  reason: collision with root package name */
    public final b f38033b;

    /* renamed from: c  reason: collision with root package name */
    public final Map<Class<?>, NavigableMap<Integer, Integer>> f38034c;

    /* renamed from: d  reason: collision with root package name */
    public final Map<Class<?>, com.kwad.sdk.glide.load.engine.bitmap_recycle.a<?>> f38035d;

    /* renamed from: e  reason: collision with root package name */
    public final int f38036e;

    /* renamed from: f  reason: collision with root package name */
    public int f38037f;

    /* loaded from: classes7.dex */
    public static final class a implements m {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f38038a;

        /* renamed from: b  reason: collision with root package name */
        public final b f38039b;

        /* renamed from: c  reason: collision with root package name */
        public Class<?> f38040c;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38039b = bVar;
        }

        @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.m
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f38039b.a(this);
            }
        }

        public void a(int i2, Class<?> cls) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, cls) == null) {
                this.f38038a = i2;
                this.f38040c = cls;
            }
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) {
                if (obj instanceof a) {
                    a aVar = (a) obj;
                    return this.f38038a == aVar.f38038a && this.f38040c == aVar.f38040c;
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                int i2 = this.f38038a * 31;
                Class<?> cls = this.f38040c;
                return i2 + (cls != null ? cls.hashCode() : 0);
            }
            return invokeV.intValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return "Key{size=" + this.f38038a + "array=" + this.f38040c + '}';
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static final class b extends d<a> {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.d
        /* renamed from: a */
        public a b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new a(this) : (a) invokeV.objValue;
        }

        public a a(int i2, Class<?> cls) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, cls)) == null) {
                a c2 = c();
                c2.a(i2, cls);
                return c2;
            }
            return (a) invokeIL.objValue;
        }
    }

    @VisibleForTesting
    public j() {
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
        this.f38032a = new h<>();
        this.f38033b = new b();
        this.f38034c = new HashMap();
        this.f38035d = new HashMap();
        this.f38036e = 4194304;
    }

    public j(int i2) {
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
        this.f38032a = new h<>();
        this.f38033b = new b();
        this.f38034c = new HashMap();
        this.f38035d = new HashMap();
        this.f38036e = i2;
    }

    @Nullable
    private <T> T a(a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, this, aVar)) == null) ? (T) this.f38032a.a((h<a, Object>) aVar) : (T) invokeL.objValue;
    }

    private <T> T a(a aVar, Class<T> cls) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, this, aVar, cls)) == null) {
            com.kwad.sdk.glide.load.engine.bitmap_recycle.a<T> b2 = b((Class) cls);
            T t = (T) a(aVar);
            if (t != null) {
                this.f38037f -= b2.a((com.kwad.sdk.glide.load.engine.bitmap_recycle.a<T>) t) * b2.b();
                c(b2.a((com.kwad.sdk.glide.load.engine.bitmap_recycle.a<T>) t), cls);
            }
            if (t == null) {
                if (Log.isLoggable(b2.a(), 2)) {
                    Log.v(b2.a(), "Allocated " + aVar.f38038a + " bytes");
                }
                return b2.a(aVar.f38038a);
            }
            return t;
        }
        return (T) invokeLL.objValue;
    }

    private NavigableMap<Integer, Integer> a(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65540, this, cls)) == null) {
            NavigableMap<Integer, Integer> navigableMap = this.f38034c.get(cls);
            if (navigableMap == null) {
                TreeMap treeMap = new TreeMap();
                this.f38034c.put(cls, treeMap);
                return treeMap;
            }
            return navigableMap;
        }
        return (NavigableMap) invokeL.objValue;
    }

    private boolean a(int i2, Integer num) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(AdIconUtil.AD_TEXT_ID, this, i2, num)) == null) ? num != null && (b() || num.intValue() <= i2 * 8) : invokeIL.booleanValue;
    }

    private <T> com.kwad.sdk.glide.load.engine.bitmap_recycle.a<T> b(Class<T> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, cls)) == null) {
            i iVar = (com.kwad.sdk.glide.load.engine.bitmap_recycle.a<T>) this.f38035d.get(cls);
            if (iVar == null) {
                if (cls.equals(int[].class)) {
                    iVar = new i();
                } else if (!cls.equals(byte[].class)) {
                    throw new IllegalArgumentException("No array pool found for: " + cls.getSimpleName());
                } else {
                    iVar = new g();
                }
                this.f38035d.put(cls, iVar);
            }
            return iVar;
        }
        return (com.kwad.sdk.glide.load.engine.bitmap_recycle.a) invokeL.objValue;
    }

    private <T> com.kwad.sdk.glide.load.engine.bitmap_recycle.a<T> b(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, this, t)) == null) ? b((Class) t.getClass()) : (com.kwad.sdk.glide.load.engine.bitmap_recycle.a) invokeL.objValue;
    }

    private boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) {
            int i2 = this.f38037f;
            return i2 == 0 || this.f38036e / i2 >= 2;
        }
        return invokeV.booleanValue;
    }

    private boolean b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65545, this, i2)) == null) ? i2 <= this.f38036e / 2 : invokeI.booleanValue;
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            c(this.f38036e);
        }
    }

    private void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65547, this, i2) == null) {
            while (this.f38037f > i2) {
                Object a2 = this.f38032a.a();
                com.kwad.sdk.glide.g.j.a(a2);
                com.kwad.sdk.glide.load.engine.bitmap_recycle.a b2 = b((j) a2);
                this.f38037f -= b2.a((com.kwad.sdk.glide.load.engine.bitmap_recycle.a) a2) * b2.b();
                c(b2.a((com.kwad.sdk.glide.load.engine.bitmap_recycle.a) a2), a2.getClass());
                if (Log.isLoggable(b2.a(), 2)) {
                    Log.v(b2.a(), "evicted: " + b2.a((com.kwad.sdk.glide.load.engine.bitmap_recycle.a) a2));
                }
            }
        }
    }

    private void c(int i2, Class<?> cls) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65548, this, i2, cls) == null) {
            NavigableMap<Integer, Integer> a2 = a(cls);
            Integer num = (Integer) a2.get(Integer.valueOf(i2));
            if (num == null) {
                throw new NullPointerException("Tried to decrement empty size, size: " + i2 + ", this: " + this);
            }
            int intValue = num.intValue();
            Integer valueOf = Integer.valueOf(i2);
            if (intValue == 1) {
                a2.remove(valueOf);
            } else {
                a2.put(valueOf, Integer.valueOf(num.intValue() - 1));
            }
        }
    }

    @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.b
    public synchronized <T> T a(int i2, Class<T> cls) {
        InterceptResult invokeIL;
        T t;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i2, cls)) == null) {
            synchronized (this) {
                Integer ceilingKey = a((Class<?>) cls).ceilingKey(Integer.valueOf(i2));
                t = (T) a(a(i2, ceilingKey) ? this.f38033b.a(ceilingKey.intValue(), cls) : this.f38033b.a(i2, cls), (Class<Object>) cls);
            }
            return t;
        }
        return (T) invokeIL.objValue;
    }

    @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.b
    public synchronized void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this) {
                c(0);
            }
        }
    }

    @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.b
    public synchronized void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            synchronized (this) {
                try {
                    if (i2 >= 40) {
                        a();
                    } else if (i2 >= 20 || i2 == 15) {
                        c(this.f38036e / 2);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.b
    public synchronized <T> void a(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, t) == null) {
            synchronized (this) {
                Class<?> cls = t.getClass();
                com.kwad.sdk.glide.load.engine.bitmap_recycle.a<T> b2 = b((Class) cls);
                int a2 = b2.a((com.kwad.sdk.glide.load.engine.bitmap_recycle.a<T>) t);
                int b3 = b2.b() * a2;
                if (b(b3)) {
                    a a3 = this.f38033b.a(a2, cls);
                    this.f38032a.a(a3, t);
                    NavigableMap<Integer, Integer> a4 = a(cls);
                    Integer num = (Integer) a4.get(Integer.valueOf(a3.f38038a));
                    Integer valueOf = Integer.valueOf(a3.f38038a);
                    int i2 = 1;
                    if (num != null) {
                        i2 = 1 + num.intValue();
                    }
                    a4.put(valueOf, Integer.valueOf(i2));
                    this.f38037f += b3;
                    c();
                }
            }
        }
    }

    @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.b
    @Deprecated
    public <T> void a(T t, Class<T> cls) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, t, cls) == null) {
            a((j) t);
        }
    }

    @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.b
    public synchronized <T> T b(int i2, Class<T> cls) {
        InterceptResult invokeIL;
        T t;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048581, this, i2, cls)) == null) {
            synchronized (this) {
                t = (T) a(this.f38033b.a(i2, cls), (Class<Object>) cls);
            }
            return t;
        }
        return (T) invokeIL.objValue;
    }
}
