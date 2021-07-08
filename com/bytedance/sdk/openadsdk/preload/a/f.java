package com.bytedance.sdk.openadsdk.preload.a;

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
import com.bumptech.glide.load.engine.GlideException;
import com.google.gson.Gson;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;
/* loaded from: classes5.dex */
public final class f {
    public static /* synthetic */ Interceptable $ic;
    public static final com.bytedance.sdk.openadsdk.preload.a.c.a<?> r;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final List<w> f32038a;

    /* renamed from: b  reason: collision with root package name */
    public final com.bytedance.sdk.openadsdk.preload.a.b.d f32039b;

    /* renamed from: c  reason: collision with root package name */
    public final e f32040c;

    /* renamed from: d  reason: collision with root package name */
    public final Map<Type, h<?>> f32041d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f32042e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f32043f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f32044g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f32045h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f32046i;
    public final boolean j;
    public final boolean k;
    public final String l;
    public final int m;
    public final int n;
    public final u o;
    public final List<w> p;
    public final List<w> q;
    public final ThreadLocal<Map<com.bytedance.sdk.openadsdk.preload.a.c.a<?>, a<?>>> s;
    public final Map<com.bytedance.sdk.openadsdk.preload.a.c.a<?>, v<?>> t;
    public final com.bytedance.sdk.openadsdk.preload.a.b.c u;
    public final com.bytedance.sdk.openadsdk.preload.a.b.a.d v;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(45358430, "Lcom/bytedance/sdk/openadsdk/preload/a/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(45358430, "Lcom/bytedance/sdk/openadsdk/preload/a/f;");
                return;
            }
        }
        r = com.bytedance.sdk.openadsdk.preload.a.c.a.b(Object.class);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public f() {
        this(com.bytedance.sdk.openadsdk.preload.a.b.d.f31951a, d.f32004a, Collections.emptyMap(), false, false, false, true, false, false, false, u.f32065a, null, 2, 2, Collections.emptyList(), Collections.emptyList(), Collections.emptyList());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr = newInitContext.callArgs;
                this((com.bytedance.sdk.openadsdk.preload.a.b.d) objArr[0], (e) objArr[1], (Map) objArr[2], ((Boolean) objArr[3]).booleanValue(), ((Boolean) objArr[4]).booleanValue(), ((Boolean) objArr[5]).booleanValue(), ((Boolean) objArr[6]).booleanValue(), ((Boolean) objArr[7]).booleanValue(), ((Boolean) objArr[8]).booleanValue(), ((Boolean) objArr[9]).booleanValue(), (u) objArr[10], (String) objArr[11], ((Integer) objArr[12]).intValue(), ((Integer) objArr[13]).intValue(), (List) objArr[14], (List) objArr[15], (List) objArr[16]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    private v<Number> a(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(AdIconUtil.AD_TEXT_ID, this, z)) == null) {
            if (z) {
                return com.bytedance.sdk.openadsdk.preload.a.b.a.n.v;
            }
            return new v<Number>(this) { // from class: com.bytedance.sdk.openadsdk.preload.a.f.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ f f32047a;

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
                    this.f32047a = this;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.bytedance.sdk.openadsdk.preload.a.v
                /* renamed from: a */
                public Double b(com.bytedance.sdk.openadsdk.preload.a.d.a aVar) throws IOException {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, aVar)) == null) {
                        if (aVar.f() == com.bytedance.sdk.openadsdk.preload.a.d.b.f32028i) {
                            aVar.j();
                            return null;
                        }
                        return Double.valueOf(aVar.k());
                    }
                    return (Double) invokeL.objValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.bytedance.sdk.openadsdk.preload.a.v
                public void a(com.bytedance.sdk.openadsdk.preload.a.d.c cVar, Number number) throws IOException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar, number) == null) {
                        if (number == null) {
                            cVar.f();
                            return;
                        }
                        f.a(number.doubleValue());
                        cVar.a(number);
                    }
                }
            };
        }
        return (v) invokeZ.objValue;
    }

    private v<Number> b(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65545, this, z)) == null) {
            if (z) {
                return com.bytedance.sdk.openadsdk.preload.a.b.a.n.u;
            }
            return new v<Number>(this) { // from class: com.bytedance.sdk.openadsdk.preload.a.f.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ f f32048a;

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
                    this.f32048a = this;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.bytedance.sdk.openadsdk.preload.a.v
                /* renamed from: a */
                public Float b(com.bytedance.sdk.openadsdk.preload.a.d.a aVar) throws IOException {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, aVar)) == null) {
                        if (aVar.f() == com.bytedance.sdk.openadsdk.preload.a.d.b.f32028i) {
                            aVar.j();
                            return null;
                        }
                        return Float.valueOf((float) aVar.k());
                    }
                    return (Float) invokeL.objValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.bytedance.sdk.openadsdk.preload.a.v
                public void a(com.bytedance.sdk.openadsdk.preload.a.d.c cVar, Number number) throws IOException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar, number) == null) {
                        if (number == null) {
                            cVar.f();
                            return;
                        }
                        f.a(number.floatValue());
                        cVar.a(number);
                    }
                }
            };
        }
        return (v) invokeZ.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return "{serializeNulls:" + this.f32042e + ",factories:" + this.f32038a + ",instanceCreators:" + this.u + "}";
        }
        return (String) invokeV.objValue;
    }

    /* loaded from: classes5.dex */
    public static class a<T> extends v<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public v<T> f32051a;

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

        public void a(v<T> vVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, vVar) == null) {
                if (this.f32051a == null) {
                    this.f32051a = vVar;
                    return;
                }
                throw new AssertionError();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.preload.a.v
        public T b(com.bytedance.sdk.openadsdk.preload.a.d.a aVar) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar)) == null) {
                v<T> vVar = this.f32051a;
                if (vVar != null) {
                    return vVar.b(aVar);
                }
                throw new IllegalStateException();
            }
            return (T) invokeL.objValue;
        }

        @Override // com.bytedance.sdk.openadsdk.preload.a.v
        public void a(com.bytedance.sdk.openadsdk.preload.a.d.c cVar, T t) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, cVar, t) == null) {
                v<T> vVar = this.f32051a;
                if (vVar != null) {
                    vVar.a(cVar, t);
                    return;
                }
                throw new IllegalStateException();
            }
        }
    }

    public static void a(double d2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, null, new Object[]{Double.valueOf(d2)}) == null) {
            if (Double.isNaN(d2) || Double.isInfinite(d2)) {
                throw new IllegalArgumentException(d2 + " is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
            }
        }
    }

    public static v<AtomicLongArray> b(v<Number> vVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, vVar)) == null) ? new v<AtomicLongArray>(vVar) { // from class: com.bytedance.sdk.openadsdk.preload.a.f.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ v f32050a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {vVar};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f32050a = vVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.bytedance.sdk.openadsdk.preload.a.v
            public void a(com.bytedance.sdk.openadsdk.preload.a.d.c cVar, AtomicLongArray atomicLongArray) throws IOException {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_SEND_USER_MSG, this, cVar, atomicLongArray) == null) {
                    cVar.b();
                    int length = atomicLongArray.length();
                    for (int i2 = 0; i2 < length; i2++) {
                        this.f32050a.a(cVar, Long.valueOf(atomicLongArray.get(i2)));
                    }
                    cVar.c();
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.bytedance.sdk.openadsdk.preload.a.v
            /* renamed from: a */
            public AtomicLongArray b(com.bytedance.sdk.openadsdk.preload.a.d.a aVar) throws IOException {
                InterceptResult invokeL2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, aVar)) == null) {
                    ArrayList arrayList = new ArrayList();
                    aVar.a();
                    while (aVar.e()) {
                        arrayList.add(Long.valueOf(((Number) this.f32050a.b(aVar)).longValue()));
                    }
                    aVar.b();
                    int size = arrayList.size();
                    AtomicLongArray atomicLongArray = new AtomicLongArray(size);
                    for (int i2 = 0; i2 < size; i2++) {
                        atomicLongArray.set(i2, ((Long) arrayList.get(i2)).longValue());
                    }
                    return atomicLongArray;
                }
                return (AtomicLongArray) invokeL2.objValue;
            }
        }.a() : (v) invokeL.objValue;
    }

    public static v<Number> a(u uVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, uVar)) == null) {
            if (uVar == u.f32065a) {
                return com.bytedance.sdk.openadsdk.preload.a.b.a.n.t;
            }
            return new v<Number>() { // from class: com.bytedance.sdk.openadsdk.preload.a.f.3
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
                @Override // com.bytedance.sdk.openadsdk.preload.a.v
                /* renamed from: a */
                public Number b(com.bytedance.sdk.openadsdk.preload.a.d.a aVar) throws IOException {
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, aVar)) == null) {
                        if (aVar.f() == com.bytedance.sdk.openadsdk.preload.a.d.b.f32028i) {
                            aVar.j();
                            return null;
                        }
                        return Long.valueOf(aVar.l());
                    }
                    return (Number) invokeL2.objValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.bytedance.sdk.openadsdk.preload.a.v
                public void a(com.bytedance.sdk.openadsdk.preload.a.d.c cVar, Number number) throws IOException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar, number) == null) {
                        if (number == null) {
                            cVar.f();
                        } else {
                            cVar.b(number.toString());
                        }
                    }
                }
            };
        }
        return (v) invokeL.objValue;
    }

    public f(com.bytedance.sdk.openadsdk.preload.a.b.d dVar, e eVar, Map<Type, h<?>> map, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, u uVar, String str, int i2, int i3, List<w> list, List<w> list2, List<w> list3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dVar, eVar, map, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), Boolean.valueOf(z5), Boolean.valueOf(z6), Boolean.valueOf(z7), uVar, str, Integer.valueOf(i2), Integer.valueOf(i3), list, list2, list3};
            interceptable.invokeUnInit(65538, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.s = new ThreadLocal<>();
        this.t = new ConcurrentHashMap();
        this.f32039b = dVar;
        this.f32040c = eVar;
        this.f32041d = map;
        this.u = new com.bytedance.sdk.openadsdk.preload.a.b.c(map);
        this.f32042e = z;
        this.f32043f = z2;
        this.f32044g = z3;
        this.f32045h = z4;
        this.f32046i = z5;
        this.j = z6;
        this.k = z7;
        this.o = uVar;
        this.l = str;
        this.m = i2;
        this.n = i3;
        this.p = list;
        this.q = list2;
        ArrayList arrayList = new ArrayList();
        arrayList.add(com.bytedance.sdk.openadsdk.preload.a.b.a.n.Y);
        arrayList.add(com.bytedance.sdk.openadsdk.preload.a.b.a.h.f31848a);
        arrayList.add(dVar);
        arrayList.addAll(list3);
        arrayList.add(com.bytedance.sdk.openadsdk.preload.a.b.a.n.D);
        arrayList.add(com.bytedance.sdk.openadsdk.preload.a.b.a.n.m);
        arrayList.add(com.bytedance.sdk.openadsdk.preload.a.b.a.n.f31893g);
        arrayList.add(com.bytedance.sdk.openadsdk.preload.a.b.a.n.f31895i);
        arrayList.add(com.bytedance.sdk.openadsdk.preload.a.b.a.n.k);
        v<Number> a2 = a(uVar);
        arrayList.add(com.bytedance.sdk.openadsdk.preload.a.b.a.n.a(Long.TYPE, Long.class, a2));
        arrayList.add(com.bytedance.sdk.openadsdk.preload.a.b.a.n.a(Double.TYPE, Double.class, a(z7)));
        arrayList.add(com.bytedance.sdk.openadsdk.preload.a.b.a.n.a(Float.TYPE, Float.class, b(z7)));
        arrayList.add(com.bytedance.sdk.openadsdk.preload.a.b.a.n.x);
        arrayList.add(com.bytedance.sdk.openadsdk.preload.a.b.a.n.o);
        arrayList.add(com.bytedance.sdk.openadsdk.preload.a.b.a.n.q);
        arrayList.add(com.bytedance.sdk.openadsdk.preload.a.b.a.n.a(AtomicLong.class, a(a2)));
        arrayList.add(com.bytedance.sdk.openadsdk.preload.a.b.a.n.a(AtomicLongArray.class, b(a2)));
        arrayList.add(com.bytedance.sdk.openadsdk.preload.a.b.a.n.s);
        arrayList.add(com.bytedance.sdk.openadsdk.preload.a.b.a.n.z);
        arrayList.add(com.bytedance.sdk.openadsdk.preload.a.b.a.n.F);
        arrayList.add(com.bytedance.sdk.openadsdk.preload.a.b.a.n.H);
        arrayList.add(com.bytedance.sdk.openadsdk.preload.a.b.a.n.a(BigDecimal.class, com.bytedance.sdk.openadsdk.preload.a.b.a.n.B));
        arrayList.add(com.bytedance.sdk.openadsdk.preload.a.b.a.n.a(BigInteger.class, com.bytedance.sdk.openadsdk.preload.a.b.a.n.C));
        arrayList.add(com.bytedance.sdk.openadsdk.preload.a.b.a.n.J);
        arrayList.add(com.bytedance.sdk.openadsdk.preload.a.b.a.n.L);
        arrayList.add(com.bytedance.sdk.openadsdk.preload.a.b.a.n.P);
        arrayList.add(com.bytedance.sdk.openadsdk.preload.a.b.a.n.R);
        arrayList.add(com.bytedance.sdk.openadsdk.preload.a.b.a.n.W);
        arrayList.add(com.bytedance.sdk.openadsdk.preload.a.b.a.n.N);
        arrayList.add(com.bytedance.sdk.openadsdk.preload.a.b.a.n.f31890d);
        arrayList.add(com.bytedance.sdk.openadsdk.preload.a.b.a.c.f31828a);
        arrayList.add(com.bytedance.sdk.openadsdk.preload.a.b.a.n.U);
        arrayList.add(com.bytedance.sdk.openadsdk.preload.a.b.a.k.f31869a);
        arrayList.add(com.bytedance.sdk.openadsdk.preload.a.b.a.j.f31867a);
        arrayList.add(com.bytedance.sdk.openadsdk.preload.a.b.a.n.S);
        arrayList.add(com.bytedance.sdk.openadsdk.preload.a.b.a.a.f31821a);
        arrayList.add(com.bytedance.sdk.openadsdk.preload.a.b.a.n.f31888b);
        arrayList.add(new com.bytedance.sdk.openadsdk.preload.a.b.a.b(this.u));
        arrayList.add(new com.bytedance.sdk.openadsdk.preload.a.b.a.g(this.u, z2));
        com.bytedance.sdk.openadsdk.preload.a.b.a.d dVar2 = new com.bytedance.sdk.openadsdk.preload.a.b.a.d(this.u);
        this.v = dVar2;
        arrayList.add(dVar2);
        arrayList.add(com.bytedance.sdk.openadsdk.preload.a.b.a.n.Z);
        arrayList.add(new com.bytedance.sdk.openadsdk.preload.a.b.a.i(this.u, eVar, dVar, this.v));
        this.f32038a = Collections.unmodifiableList(arrayList);
    }

    public static v<AtomicLong> a(v<Number> vVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, vVar)) == null) ? new v<AtomicLong>(vVar) { // from class: com.bytedance.sdk.openadsdk.preload.a.f.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ v f32049a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {vVar};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f32049a = vVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.bytedance.sdk.openadsdk.preload.a.v
            public void a(com.bytedance.sdk.openadsdk.preload.a.d.c cVar, AtomicLong atomicLong) throws IOException {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_SEND_USER_MSG, this, cVar, atomicLong) == null) {
                    this.f32049a.a(cVar, Long.valueOf(atomicLong.get()));
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.bytedance.sdk.openadsdk.preload.a.v
            /* renamed from: a */
            public AtomicLong b(com.bytedance.sdk.openadsdk.preload.a.d.a aVar) throws IOException {
                InterceptResult invokeL2;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, aVar)) == null) ? new AtomicLong(((Number) this.f32049a.b(aVar)).longValue()) : (AtomicLong) invokeL2.objValue;
            }
        }.a() : (v) invokeL.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v5, resolved type: java.util.Map<com.bytedance.sdk.openadsdk.preload.a.c.a<?>, com.bytedance.sdk.openadsdk.preload.a.v<?>> */
    /* JADX DEBUG: Type inference failed for r4v5. Raw type applied. Possible types: com.bytedance.sdk.openadsdk.preload.a.v<T>, com.bytedance.sdk.openadsdk.preload.a.v<?> */
    /* JADX WARN: Multi-variable type inference failed */
    public <T> v<T> a(com.bytedance.sdk.openadsdk.preload.a.c.a<T> aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar)) == null) {
            v<T> vVar = (v<T>) this.t.get(aVar == null ? r : aVar);
            if (vVar != null) {
                return vVar;
            }
            Map<com.bytedance.sdk.openadsdk.preload.a.c.a<?>, a<?>> map = this.s.get();
            boolean z = false;
            if (map == null) {
                map = new HashMap<>();
                this.s.set(map);
                z = true;
            }
            a<?> aVar2 = map.get(aVar);
            if (aVar2 != null) {
                return aVar2;
            }
            try {
                a<?> aVar3 = new a<>();
                map.put(aVar, aVar3);
                for (w wVar : this.f32038a) {
                    v vVar2 = (v<T>) wVar.a(this, aVar);
                    if (vVar2 != null) {
                        aVar3.a((v<?>) vVar2);
                        this.t.put(aVar, vVar2);
                        return vVar2;
                    }
                }
                throw new IllegalArgumentException("GSON (pangle-v3200) cannot handle " + aVar);
            } finally {
                map.remove(aVar);
                if (z) {
                    this.s.remove();
                }
            }
        }
        return (v) invokeL.objValue;
    }

    public <T> v<T> a(w wVar, com.bytedance.sdk.openadsdk.preload.a.c.a<T> aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, wVar, aVar)) == null) {
            if (!this.f32038a.contains(wVar)) {
                wVar = this.v;
            }
            boolean z = false;
            for (w wVar2 : this.f32038a) {
                if (z) {
                    v<T> a2 = wVar2.a(this, aVar);
                    if (a2 != null) {
                        return a2;
                    }
                } else if (wVar2 == wVar) {
                    z = true;
                }
            }
            throw new IllegalArgumentException("GSON cannot serialize " + aVar);
        }
        return (v) invokeLL.objValue;
    }

    public <T> v<T> a(Class<T> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, cls)) == null) ? a((com.bytedance.sdk.openadsdk.preload.a.c.a) com.bytedance.sdk.openadsdk.preload.a.c.a.b(cls)) : (v) invokeL.objValue;
    }

    public String a(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, obj)) == null) {
            if (obj == null) {
                return a((l) n.f32062a);
            }
            return a(obj, obj.getClass());
        }
        return (String) invokeL.objValue;
    }

    public String a(Object obj, Type type) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, obj, type)) == null) {
            StringWriter stringWriter = new StringWriter();
            a(obj, type, stringWriter);
            return stringWriter.toString();
        }
        return (String) invokeLL.objValue;
    }

    public void a(Object obj, Type type, Appendable appendable) throws m {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048590, this, obj, type, appendable) == null) {
            try {
                a(obj, type, a(com.bytedance.sdk.openadsdk.preload.a.b.l.a(appendable)));
            } catch (IOException e2) {
                throw new m(e2);
            }
        }
    }

    public void a(Object obj, Type type, com.bytedance.sdk.openadsdk.preload.a.d.c cVar) throws m {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048589, this, obj, type, cVar) == null) {
            v a2 = a((com.bytedance.sdk.openadsdk.preload.a.c.a) com.bytedance.sdk.openadsdk.preload.a.c.a.a(type));
            boolean g2 = cVar.g();
            cVar.b(true);
            boolean h2 = cVar.h();
            cVar.c(this.f32045h);
            boolean i2 = cVar.i();
            cVar.d(this.f32042e);
            try {
                try {
                    try {
                        a2.a(cVar, obj);
                    } catch (IOException e2) {
                        throw new m(e2);
                    }
                } catch (AssertionError e3) {
                    AssertionError assertionError = new AssertionError("AssertionError (GSON pangle-v3200): " + e3.getMessage());
                    assertionError.initCause(e3);
                    throw assertionError;
                }
            } finally {
                cVar.b(g2);
                cVar.c(h2);
                cVar.d(i2);
            }
        }
    }

    public String a(l lVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, lVar)) == null) {
            StringWriter stringWriter = new StringWriter();
            a(lVar, stringWriter);
            return stringWriter.toString();
        }
        return (String) invokeL.objValue;
    }

    public void a(l lVar, Appendable appendable) throws m {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, lVar, appendable) == null) {
            try {
                a(lVar, a(com.bytedance.sdk.openadsdk.preload.a.b.l.a(appendable)));
            } catch (IOException e2) {
                throw new m(e2);
            }
        }
    }

    public com.bytedance.sdk.openadsdk.preload.a.d.c a(Writer writer) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, writer)) == null) {
            if (this.f32044g) {
                writer.write(Gson.JSON_NON_EXECUTABLE_PREFIX);
            }
            com.bytedance.sdk.openadsdk.preload.a.d.c cVar = new com.bytedance.sdk.openadsdk.preload.a.d.c(writer);
            if (this.f32046i) {
                cVar.c(GlideException.IndentedAppendable.INDENT);
            }
            cVar.d(this.f32042e);
            return cVar;
        }
        return (com.bytedance.sdk.openadsdk.preload.a.d.c) invokeL.objValue;
    }

    public com.bytedance.sdk.openadsdk.preload.a.d.a a(Reader reader) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, reader)) == null) {
            com.bytedance.sdk.openadsdk.preload.a.d.a aVar = new com.bytedance.sdk.openadsdk.preload.a.d.a(reader);
            aVar.a(this.j);
            return aVar;
        }
        return (com.bytedance.sdk.openadsdk.preload.a.d.a) invokeL.objValue;
    }

    public void a(l lVar, com.bytedance.sdk.openadsdk.preload.a.d.c cVar) throws m {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, lVar, cVar) == null) {
            boolean g2 = cVar.g();
            cVar.b(true);
            boolean h2 = cVar.h();
            cVar.c(this.f32045h);
            boolean i2 = cVar.i();
            cVar.d(this.f32042e);
            try {
                try {
                    com.bytedance.sdk.openadsdk.preload.a.b.l.a(lVar, cVar);
                } catch (IOException e2) {
                    throw new m(e2);
                } catch (AssertionError e3) {
                    AssertionError assertionError = new AssertionError("AssertionError (GSON pangle-v3200): " + e3.getMessage());
                    assertionError.initCause(e3);
                    throw assertionError;
                }
            } finally {
                cVar.b(g2);
                cVar.c(h2);
                cVar.d(i2);
            }
        }
    }

    public <T> T a(String str, Type type) throws t {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, str, type)) == null) {
            if (str == null) {
                return null;
            }
            return (T) a((Reader) new StringReader(str), type);
        }
        return (T) invokeLL.objValue;
    }

    public <T> T a(Reader reader, Type type) throws m, t {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, reader, type)) == null) {
            com.bytedance.sdk.openadsdk.preload.a.d.a a2 = a(reader);
            T t = (T) a(a2, type);
            a(t, a2);
            return t;
        }
        return (T) invokeLL.objValue;
    }

    public static void a(Object obj, com.bytedance.sdk.openadsdk.preload.a.d.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65543, null, obj, aVar) == null) || obj == null) {
            return;
        }
        try {
            if (aVar.f() == com.bytedance.sdk.openadsdk.preload.a.d.b.j) {
                return;
            }
            throw new m("JSON document was not fully consumed.");
        } catch (com.bytedance.sdk.openadsdk.preload.a.d.d e2) {
            throw new t(e2);
        } catch (IOException e3) {
            throw new m(e3);
        }
    }

    public <T> T a(com.bytedance.sdk.openadsdk.preload.a.d.a aVar, Type type) throws m, t {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, aVar, type)) == null) {
            boolean q = aVar.q();
            boolean z = true;
            aVar.a(true);
            try {
                try {
                    try {
                        try {
                            try {
                                aVar.f();
                                z = false;
                                T b2 = a((com.bytedance.sdk.openadsdk.preload.a.c.a) com.bytedance.sdk.openadsdk.preload.a.c.a.a(type)).b(aVar);
                                aVar.a(q);
                                return b2;
                            } catch (EOFException e2) {
                                if (z) {
                                    aVar.a(q);
                                    return null;
                                }
                                throw new t(e2);
                            }
                        } catch (IOException e3) {
                            throw new t(e3);
                        }
                    } catch (AssertionError e4) {
                        AssertionError assertionError = new AssertionError("AssertionError (GSON pangle-v3200): " + e4.getMessage());
                        assertionError.initCause(e4);
                        throw assertionError;
                    }
                } catch (IllegalStateException e5) {
                    throw new t(e5);
                }
            } catch (Throwable th) {
                aVar.a(q);
                throw th;
            }
        }
        return (T) invokeLL.objValue;
    }
}
