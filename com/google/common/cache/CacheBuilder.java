package com.google.common.cache;

import androidx.core.view.InputDeviceCompat;
import b.i.d.a.j;
import b.i.d.a.n;
import b.i.d.a.r;
import b.i.d.a.t;
import b.i.d.b.c;
import b.i.d.b.d;
import b.i.d.b.f;
import b.i.d.b.i;
import b.i.d.b.j;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.common.base.Equivalence;
import com.google.common.base.Suppliers;
import com.google.common.cache.LocalCache;
import com.meizu.cloud.pushsdk.notification.model.NotificationStyle;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
/* loaded from: classes2.dex */
public final class CacheBuilder<K, V> {
    public static /* synthetic */ Interceptable $ic;
    public static final r<? extends b.i.d.b.b> q;
    public static final d r;
    public static final t s;
    public static final Logger t;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f63150a;

    /* renamed from: b  reason: collision with root package name */
    public int f63151b;

    /* renamed from: c  reason: collision with root package name */
    public int f63152c;

    /* renamed from: d  reason: collision with root package name */
    public long f63153d;

    /* renamed from: e  reason: collision with root package name */
    public long f63154e;

    /* renamed from: f  reason: collision with root package name */
    public j<? super K, ? super V> f63155f;

    /* renamed from: g  reason: collision with root package name */
    public LocalCache.Strength f63156g;

    /* renamed from: h  reason: collision with root package name */
    public LocalCache.Strength f63157h;

    /* renamed from: i  reason: collision with root package name */
    public long f63158i;
    public long j;
    public long k;
    public Equivalence<Object> l;
    public Equivalence<Object> m;
    public i<? super K, ? super V> n;
    public t o;
    public r<? extends b.i.d.b.b> p;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
    public static final class NullListener implements i<Object, Object> {
        public static final /* synthetic */ NullListener[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final NullListener INSTANCE;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1790992214, "Lcom/google/common/cache/CacheBuilder$NullListener;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1790992214, "Lcom/google/common/cache/CacheBuilder$NullListener;");
                    return;
                }
            }
            NullListener nullListener = new NullListener("INSTANCE", 0);
            INSTANCE = nullListener;
            $VALUES = new NullListener[]{nullListener};
        }

        public NullListener(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static NullListener valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (NullListener) Enum.valueOf(NullListener.class, str) : (NullListener) invokeL.objValue;
        }

        public static NullListener[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (NullListener[]) $VALUES.clone() : (NullListener[]) invokeV.objValue;
        }

        @Override // b.i.d.b.i
        public void onRemoval(RemovalNotification<Object, Object> removalNotification) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, removalNotification) == null) {
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
    public static final class OneWeigher implements j<Object, Object> {
        public static final /* synthetic */ OneWeigher[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final OneWeigher INSTANCE;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1595021918, "Lcom/google/common/cache/CacheBuilder$OneWeigher;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1595021918, "Lcom/google/common/cache/CacheBuilder$OneWeigher;");
                    return;
                }
            }
            OneWeigher oneWeigher = new OneWeigher("INSTANCE", 0);
            INSTANCE = oneWeigher;
            $VALUES = new OneWeigher[]{oneWeigher};
        }

        public OneWeigher(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static OneWeigher valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (OneWeigher) Enum.valueOf(OneWeigher.class, str) : (OneWeigher) invokeL.objValue;
        }

        public static OneWeigher[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (OneWeigher[]) $VALUES.clone() : (OneWeigher[]) invokeV.objValue;
        }

        @Override // b.i.d.b.j
        public int weigh(Object obj, Object obj2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, obj, obj2)) == null) {
                return 1;
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes2.dex */
    public static class a implements b.i.d.b.b {
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

        @Override // b.i.d.b.b
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            }
        }

        @Override // b.i.d.b.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        @Override // b.i.d.b.b
        public void c(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j) == null) {
            }
        }

        @Override // b.i.d.b.b
        public void d(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            }
        }

        @Override // b.i.d.b.b
        public void e(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048580, this, j) == null) {
            }
        }

        @Override // b.i.d.b.b
        public d f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? CacheBuilder.r : (d) invokeV.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public static class b extends t {
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

        @Override // b.i.d.a.t
        public long a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 0L;
            }
            return invokeV.longValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(791702349, "Lcom/google/common/cache/CacheBuilder;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(791702349, "Lcom/google/common/cache/CacheBuilder;");
                return;
            }
        }
        q = Suppliers.a(new a());
        r = new d(0L, 0L, 0L, 0L, 0L, 0L);
        s = new b();
        t = Logger.getLogger(CacheBuilder.class.getName());
    }

    public CacheBuilder() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f63150a = true;
        this.f63151b = -1;
        this.f63152c = -1;
        this.f63153d = -1L;
        this.f63154e = -1L;
        this.f63158i = -1L;
        this.j = -1L;
        this.k = -1L;
        this.p = q;
    }

    public static CacheBuilder<Object, Object> y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? new CacheBuilder<>() : (CacheBuilder) invokeV.objValue;
    }

    public CacheBuilder<K, V> A(LocalCache.Strength strength) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, strength)) == null) {
            n.A(this.f63156g == null, "Key strength was already set to %s", this.f63156g);
            n.p(strength);
            this.f63156g = strength;
            return this;
        }
        return (CacheBuilder) invokeL.objValue;
    }

    public CacheBuilder<K, V> B(LocalCache.Strength strength) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, strength)) == null) {
            n.A(this.f63157h == null, "Value strength was already set to %s", this.f63157h);
            n.p(strength);
            this.f63157h = strength;
            return this;
        }
        return (CacheBuilder) invokeL.objValue;
    }

    public CacheBuilder<K, V> C(t tVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tVar)) == null) {
            n.w(this.o == null);
            n.p(tVar);
            this.o = tVar;
            return this;
        }
        return (CacheBuilder) invokeL.objValue;
    }

    public CacheBuilder<K, V> D(Equivalence<Object> equivalence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, equivalence)) == null) {
            n.A(this.m == null, "value equivalence was already set to %s", this.m);
            n.p(equivalence);
            this.m = equivalence;
            return this;
        }
        return (CacheBuilder) invokeL.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: com.google.common.cache.CacheBuilder<K, V> */
    /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: b.i.d.b.j<? super K1 extends K, ? super V1 extends V> */
    /* JADX WARN: Multi-variable type inference failed */
    public <K1 extends K, V1 extends V> CacheBuilder<K1, V1> E(j<? super K1, ? super V1> jVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, jVar)) == null) {
            n.w(this.f63155f == null);
            if (this.f63150a) {
                n.z(this.f63153d == -1, "weigher can not be combined with maximum size", this.f63153d);
            }
            n.p(jVar);
            this.f63155f = jVar;
            return this;
        }
        return (CacheBuilder) invokeL.objValue;
    }

    public <K1 extends K, V1 extends V> c<K1, V1> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            d();
            c();
            return new LocalCache.LocalManualCache(this);
        }
        return (c) invokeV.objValue;
    }

    public <K1 extends K, V1 extends V> f<K1, V1> b(CacheLoader<? super K1, V1> cacheLoader) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, cacheLoader)) == null) {
            d();
            return new LocalCache.LocalLoadingCache(this, cacheLoader);
        }
        return (f) invokeL.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            n.x(this.k == -1, "refreshAfterWrite requires a LoadingCache");
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (this.f63155f == null) {
                n.x(this.f63154e == -1, "maximumWeight requires weigher");
            } else if (this.f63150a) {
                n.x(this.f63154e != -1, "weigher requires maximumWeight");
            } else if (this.f63154e == -1) {
                t.log(Level.WARNING, "ignoring weigher specified without maximumWeight");
            }
        }
    }

    public CacheBuilder<K, V> e(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) {
            n.y(this.f63152c == -1, "concurrency level was already set to %s", this.f63152c);
            n.d(i2 > 0);
            this.f63152c = i2;
            return this;
        }
        return (CacheBuilder) invokeI.objValue;
    }

    public CacheBuilder<K, V> f(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048586, this, j, timeUnit)) == null) {
            n.z(this.j == -1, "expireAfterAccess was already set to %s ns", this.j);
            n.j(j >= 0, "duration cannot be negative: %s %s", j, timeUnit);
            this.j = timeUnit.toNanos(j);
            return this;
        }
        return (CacheBuilder) invokeJL.objValue;
    }

    public CacheBuilder<K, V> g(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048587, this, j, timeUnit)) == null) {
            n.z(this.f63158i == -1, "expireAfterWrite was already set to %s ns", this.f63158i);
            n.j(j >= 0, "duration cannot be negative: %s %s", j, timeUnit);
            this.f63158i = timeUnit.toNanos(j);
            return this;
        }
        return (CacheBuilder) invokeJL.objValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            int i2 = this.f63152c;
            if (i2 == -1) {
                return 4;
            }
            return i2;
        }
        return invokeV.intValue;
    }

    public long i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            long j = this.j;
            if (j == -1) {
                return 0L;
            }
            return j;
        }
        return invokeV.longValue;
    }

    public long j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            long j = this.f63158i;
            if (j == -1) {
                return 0L;
            }
            return j;
        }
        return invokeV.longValue;
    }

    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            int i2 = this.f63151b;
            if (i2 == -1) {
                return 16;
            }
            return i2;
        }
        return invokeV.intValue;
    }

    public Equivalence<Object> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? (Equivalence) b.i.d.a.j.a(this.l, m().defaultEquivalence()) : (Equivalence) invokeV.objValue;
    }

    public LocalCache.Strength m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? (LocalCache.Strength) b.i.d.a.j.a(this.f63156g, LocalCache.Strength.STRONG) : (LocalCache.Strength) invokeV.objValue;
    }

    public long n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.f63158i == 0 || this.j == 0) {
                return 0L;
            }
            return this.f63155f == null ? this.f63153d : this.f63154e;
        }
        return invokeV.longValue;
    }

    public long o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            long j = this.k;
            if (j == -1) {
                return 0L;
            }
            return j;
        }
        return invokeV.longValue;
    }

    public <K1 extends K, V1 extends V> i<K1, V1> p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? (i) b.i.d.a.j.a(this.n, NullListener.INSTANCE) : (i) invokeV.objValue;
    }

    public r<? extends b.i.d.b.b> q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.p : (r) invokeV.objValue;
    }

    public t r(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048598, this, z)) == null) {
            t tVar = this.o;
            return tVar != null ? tVar : z ? t.b() : s;
        }
        return (t) invokeZ.objValue;
    }

    public Equivalence<Object> s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? (Equivalence) b.i.d.a.j.a(this.m, t().defaultEquivalence()) : (Equivalence) invokeV.objValue;
    }

    public LocalCache.Strength t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? (LocalCache.Strength) b.i.d.a.j.a(this.f63157h, LocalCache.Strength.STRONG) : (LocalCache.Strength) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            j.b c2 = b.i.d.a.j.c(this);
            int i2 = this.f63151b;
            if (i2 != -1) {
                c2.b("initialCapacity", i2);
            }
            int i3 = this.f63152c;
            if (i3 != -1) {
                c2.b("concurrencyLevel", i3);
            }
            long j = this.f63153d;
            if (j != -1) {
                c2.c("maximumSize", j);
            }
            long j2 = this.f63154e;
            if (j2 != -1) {
                c2.c("maximumWeight", j2);
            }
            if (this.f63158i != -1) {
                c2.d("expireAfterWrite", this.f63158i + NotificationStyle.NOTIFICATION_STYLE);
            }
            if (this.j != -1) {
                c2.d("expireAfterAccess", this.j + NotificationStyle.NOTIFICATION_STYLE);
            }
            LocalCache.Strength strength = this.f63156g;
            if (strength != null) {
                c2.d("keyStrength", b.i.d.a.a.c(strength.toString()));
            }
            LocalCache.Strength strength2 = this.f63157h;
            if (strength2 != null) {
                c2.d("valueStrength", b.i.d.a.a.c(strength2.toString()));
            }
            if (this.l != null) {
                c2.h("keyEquivalence");
            }
            if (this.m != null) {
                c2.h("valueEquivalence");
            }
            if (this.n != null) {
                c2.h("removalListener");
            }
            return c2.toString();
        }
        return (String) invokeV.objValue;
    }

    public <K1 extends K, V1 extends V> b.i.d.b.j<K1, V1> u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? (b.i.d.b.j) b.i.d.a.j.a(this.f63155f, OneWeigher.INSTANCE) : (b.i.d.b.j) invokeV.objValue;
    }

    public CacheBuilder<K, V> v(Equivalence<Object> equivalence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, equivalence)) == null) {
            n.A(this.l == null, "key equivalence was already set to %s", this.l);
            n.p(equivalence);
            this.l = equivalence;
            return this;
        }
        return (CacheBuilder) invokeL.objValue;
    }

    public CacheBuilder<K, V> w(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048604, this, j)) == null) {
            n.z(this.f63153d == -1, "maximum size was already set to %s", this.f63153d);
            n.z(this.f63154e == -1, "maximum weight was already set to %s", this.f63154e);
            n.x(this.f63155f == null, "maximum size can not be combined with weigher");
            n.e(j >= 0, "maximum size must not be negative");
            this.f63153d = j;
            return this;
        }
        return (CacheBuilder) invokeJ.objValue;
    }

    public CacheBuilder<K, V> x(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048605, this, j)) == null) {
            n.z(this.f63154e == -1, "maximum weight was already set to %s", this.f63154e);
            n.z(this.f63153d == -1, "maximum size was already set to %s", this.f63153d);
            this.f63154e = j;
            n.e(j >= 0, "maximum weight must not be negative");
            return this;
        }
        return (CacheBuilder) invokeJ.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.google.common.cache.CacheBuilder<K, V> */
    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: b.i.d.b.i<? super K1 extends K, ? super V1 extends V> */
    /* JADX WARN: Multi-variable type inference failed */
    public <K1 extends K, V1 extends V> CacheBuilder<K1, V1> z(i<? super K1, ? super V1> iVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, iVar)) == null) {
            n.w(this.n == null);
            n.p(iVar);
            this.n = iVar;
            return this;
        }
        return (CacheBuilder) invokeL.objValue;
    }
}
