package com.bytedance.sdk.openadsdk.preload.a.b.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.preload.a.r;
import com.bytedance.sdk.openadsdk.preload.a.s;
import com.bytedance.sdk.openadsdk.preload.a.v;
import com.bytedance.sdk.openadsdk.preload.a.w;
import java.io.IOException;
/* loaded from: classes9.dex */
public final class l<T> extends v<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final com.bytedance.sdk.openadsdk.preload.a.f f68025a;

    /* renamed from: b  reason: collision with root package name */
    public final s<T> f68026b;

    /* renamed from: c  reason: collision with root package name */
    public final com.bytedance.sdk.openadsdk.preload.a.k<T> f68027c;

    /* renamed from: d  reason: collision with root package name */
    public final com.bytedance.sdk.openadsdk.preload.a.c.a<T> f68028d;

    /* renamed from: e  reason: collision with root package name */
    public final w f68029e;

    /* renamed from: f  reason: collision with root package name */
    public final l<T>.a f68030f;

    /* renamed from: g  reason: collision with root package name */
    public v<T> f68031g;

    /* renamed from: com.bytedance.sdk.openadsdk.preload.a.b.a.l$1  reason: invalid class name */
    /* loaded from: classes9.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes9.dex */
    public final class a implements com.bytedance.sdk.openadsdk.preload.a.j, r {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ l f68032a;

        public a(l lVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f68032a = lVar;
        }

        public /* synthetic */ a(l lVar, AnonymousClass1 anonymousClass1) {
            this(lVar);
        }
    }

    /* loaded from: classes9.dex */
    public static final class b implements w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final com.bytedance.sdk.openadsdk.preload.a.c.a<?> f68033a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f68034b;

        /* renamed from: c  reason: collision with root package name */
        public final Class<?> f68035c;

        /* renamed from: d  reason: collision with root package name */
        public final s<?> f68036d;

        /* renamed from: e  reason: collision with root package name */
        public final com.bytedance.sdk.openadsdk.preload.a.k<?> f68037e;

        public b(Object obj, com.bytedance.sdk.openadsdk.preload.a.c.a<?> aVar, boolean z, Class<?> cls) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {obj, aVar, Boolean.valueOf(z), cls};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f68036d = obj instanceof s ? (s) obj : null;
            com.bytedance.sdk.openadsdk.preload.a.k<?> kVar = obj instanceof com.bytedance.sdk.openadsdk.preload.a.k ? (com.bytedance.sdk.openadsdk.preload.a.k) obj : null;
            this.f68037e = kVar;
            com.bytedance.sdk.openadsdk.preload.a.b.a.a((this.f68036d == null && kVar == null) ? false : true);
            this.f68033a = aVar;
            this.f68034b = z;
            this.f68035c = cls;
        }

        @Override // com.bytedance.sdk.openadsdk.preload.a.w
        public <T> v<T> a(com.bytedance.sdk.openadsdk.preload.a.f fVar, com.bytedance.sdk.openadsdk.preload.a.c.a<T> aVar) {
            InterceptResult invokeLL;
            boolean isAssignableFrom;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, fVar, aVar)) == null) {
                com.bytedance.sdk.openadsdk.preload.a.c.a<?> aVar2 = this.f68033a;
                if (aVar2 != null) {
                    isAssignableFrom = aVar2.equals(aVar) || (this.f68034b && this.f68033a.b() == aVar.a());
                } else {
                    isAssignableFrom = this.f68035c.isAssignableFrom(aVar.a());
                }
                if (isAssignableFrom) {
                    return new l(this.f68036d, this.f68037e, fVar, aVar, this);
                }
                return null;
            }
            return (v) invokeLL.objValue;
        }
    }

    public l(s<T> sVar, com.bytedance.sdk.openadsdk.preload.a.k<T> kVar, com.bytedance.sdk.openadsdk.preload.a.f fVar, com.bytedance.sdk.openadsdk.preload.a.c.a<T> aVar, w wVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {sVar, kVar, fVar, aVar, wVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f68030f = new a(this, null);
        this.f68026b = sVar;
        this.f68027c = kVar;
        this.f68025a = fVar;
        this.f68028d = aVar;
        this.f68029e = wVar;
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.v
    public void a(com.bytedance.sdk.openadsdk.preload.a.d.c cVar, T t) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, cVar, t) == null) {
            s<T> sVar = this.f68026b;
            if (sVar == null) {
                b().a(cVar, t);
            } else if (t == null) {
                cVar.f();
            } else {
                com.bytedance.sdk.openadsdk.preload.a.b.l.a(sVar.a(t, this.f68028d.b(), this.f68030f), cVar);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.v
    public T b(com.bytedance.sdk.openadsdk.preload.a.d.a aVar) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar)) == null) {
            if (this.f68027c == null) {
                return b().b(aVar);
            }
            com.bytedance.sdk.openadsdk.preload.a.l a2 = com.bytedance.sdk.openadsdk.preload.a.b.l.a(aVar);
            if (a2.j()) {
                return null;
            }
            return this.f68027c.a(a2, this.f68028d.b(), this.f68030f);
        }
        return (T) invokeL.objValue;
    }

    public static w a(com.bytedance.sdk.openadsdk.preload.a.c.a<?> aVar, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, aVar, obj)) == null) {
            return new b(obj, aVar, aVar.b() == aVar.a(), null);
        }
        return (w) invokeLL.objValue;
    }

    private v<T> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            v<T> vVar = this.f68031g;
            if (vVar != null) {
                return vVar;
            }
            v<T> a2 = this.f68025a.a(this.f68029e, this.f68028d);
            this.f68031g = a2;
            return a2;
        }
        return (v) invokeV.objValue;
    }
}
