package com.bytedance.sdk.openadsdk.preload.a.b.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.preload.a.v;
import com.bytedance.sdk.openadsdk.preload.a.w;
import java.io.IOException;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public final class h extends v<Object> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final w f68727a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final com.bytedance.sdk.openadsdk.preload.a.f f68728b;

    /* renamed from: com.bytedance.sdk.openadsdk.preload.a.b.a.h$2  reason: invalid class name */
    /* loaded from: classes9.dex */
    public static /* synthetic */ class AnonymousClass2 {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f68729a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(988863817, "Lcom/bytedance/sdk/openadsdk/preload/a/b/a/h$2;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(988863817, "Lcom/bytedance/sdk/openadsdk/preload/a/b/a/h$2;");
                    return;
                }
            }
            int[] iArr = new int[com.bytedance.sdk.openadsdk.preload.a.d.b.values().length];
            f68729a = iArr;
            try {
                iArr[com.bytedance.sdk.openadsdk.preload.a.d.b.f68902a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f68729a[com.bytedance.sdk.openadsdk.preload.a.d.b.f68904c.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f68729a[com.bytedance.sdk.openadsdk.preload.a.d.b.f68907f.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f68729a[com.bytedance.sdk.openadsdk.preload.a.d.b.f68908g.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f68729a[com.bytedance.sdk.openadsdk.preload.a.d.b.f68909h.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f68729a[com.bytedance.sdk.openadsdk.preload.a.d.b.f68910i.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(523933463, "Lcom/bytedance/sdk/openadsdk/preload/a/b/a/h;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(523933463, "Lcom/bytedance/sdk/openadsdk/preload/a/b/a/h;");
                return;
            }
        }
        f68727a = new w() { // from class: com.bytedance.sdk.openadsdk.preload.a.b.a.h.1
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

            @Override // com.bytedance.sdk.openadsdk.preload.a.w
            public <T> v<T> a(com.bytedance.sdk.openadsdk.preload.a.f fVar, com.bytedance.sdk.openadsdk.preload.a.c.a<T> aVar) {
                InterceptResult invokeLL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, fVar, aVar)) == null) {
                    if (aVar.a() == Object.class) {
                        return new h(fVar);
                    }
                    return null;
                }
                return (v) invokeLL.objValue;
            }
        };
    }

    public h(com.bytedance.sdk.openadsdk.preload.a.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f68728b = fVar;
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.v
    public void a(com.bytedance.sdk.openadsdk.preload.a.d.c cVar, Object obj) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, cVar, obj) == null) {
            if (obj == null) {
                cVar.f();
                return;
            }
            v a2 = this.f68728b.a((Class) obj.getClass());
            if (a2 instanceof h) {
                cVar.d();
                cVar.e();
                return;
            }
            a2.a(cVar, obj);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.v
    public Object b(com.bytedance.sdk.openadsdk.preload.a.d.a aVar) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar)) == null) {
            switch (AnonymousClass2.f68729a[aVar.f().ordinal()]) {
                case 1:
                    ArrayList arrayList = new ArrayList();
                    aVar.a();
                    while (aVar.e()) {
                        arrayList.add(b(aVar));
                    }
                    aVar.b();
                    return arrayList;
                case 2:
                    com.bytedance.sdk.openadsdk.preload.a.b.h hVar = new com.bytedance.sdk.openadsdk.preload.a.b.h();
                    aVar.c();
                    while (aVar.e()) {
                        hVar.put(aVar.g(), b(aVar));
                    }
                    aVar.d();
                    return hVar;
                case 3:
                    return aVar.h();
                case 4:
                    return Double.valueOf(aVar.k());
                case 5:
                    return Boolean.valueOf(aVar.i());
                case 6:
                    aVar.j();
                    return null;
                default:
                    throw new IllegalStateException();
            }
        }
        return invokeL.objValue;
    }
}
