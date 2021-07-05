package com.bytedance.sdk.openadsdk.e;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class k {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile k f31133a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public c f31134b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, Object> f31135c;

    /* renamed from: d  reason: collision with root package name */
    public b f31136d;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ k f31137a;

        /* renamed from: b  reason: collision with root package name */
        public int f31138b;

        public a(k kVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f31137a = kVar;
            this.f31138b = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f31138b == 100 && this.f31137a.f31136d != null) {
                k kVar = this.f31137a;
                kVar.b(kVar.f31136d);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b extends com.bytedance.sdk.component.e.g implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final AtomicInteger f31139a;

        /* renamed from: b  reason: collision with root package name */
        public final AtomicBoolean f31140b;

        /* renamed from: c  reason: collision with root package name */
        public com.bytedance.sdk.openadsdk.core.e.m f31141c;

        /* renamed from: d  reason: collision with root package name */
        public String f31142d;

        /* renamed from: e  reason: collision with root package name */
        public Map<String, Object> f31143e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f31144f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b() {
            super("EventData");
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((String) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f31139a = new AtomicInteger(0);
            this.f31140b = new AtomicBoolean(false);
        }

        public static b a(com.bytedance.sdk.openadsdk.core.e.m mVar, String str, Map<String, Object> map, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{mVar, str, map, Boolean.valueOf(z)})) == null) ? new b(mVar, str, map, z) : (b) invokeCommon.objValue;
        }

        public int c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f31139a.get() : invokeV.intValue;
        }

        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f31139a.incrementAndGet();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            AtomicBoolean atomicBoolean;
            com.bytedance.sdk.openadsdk.core.e.m mVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                if (this.f31141c != null && !TextUtils.isEmpty(this.f31142d) && (atomicBoolean = this.f31140b) != null) {
                    if (this.f31144f) {
                        com.bytedance.sdk.component.utils.j.b("DMLibManager", "落地页调起应用是否成功 sResult.get() " + this.f31140b.get());
                        d.b(com.bytedance.sdk.openadsdk.core.o.a(), this.f31141c, this.f31142d, this.f31140b.get() ? "lp_dpl_success" : "lp_dpl_failed");
                        return;
                    }
                    d.i(com.bytedance.sdk.openadsdk.core.o.a(), this.f31141c, this.f31142d, atomicBoolean.get() ? "dpl_success" : "dpl_failed", this.f31143e);
                    AtomicBoolean atomicBoolean2 = this.f31140b;
                    if (atomicBoolean2 == null || !atomicBoolean2.get() || (mVar = this.f31141c) == null) {
                        return;
                    }
                    k.b(mVar, this.f31142d);
                    return;
                }
                com.bytedance.sdk.component.utils.j.a("materialMeta or eventTag or sResult is null, pls check");
            }
        }

        public b a(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
                this.f31140b.set(z);
                return this;
            }
            return (b) invokeZ.objValue;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(com.bytedance.sdk.openadsdk.core.e.m mVar, String str, Map<String, Object> map, boolean z) {
            super("EventData");
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mVar, str, map, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((String) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f31139a = new AtomicInteger(0);
            this.f31140b = new AtomicBoolean(false);
            this.f31141c = mVar;
            this.f31142d = str;
            this.f31143e = map;
            this.f31144f = z;
        }
    }

    /* loaded from: classes6.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f31145a;

        /* renamed from: b  reason: collision with root package name */
        public int f31146b;

        /* renamed from: c  reason: collision with root package name */
        public int f31147c;

        /* renamed from: d  reason: collision with root package name */
        public int f31148d;

        public c() {
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
            this.f31145a = 500;
            this.f31146b = 5000;
            this.f31147c = 1000;
            this.f31148d = 300;
        }

        public static c a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? new c() : (c) invokeV.objValue;
        }
    }

    public k() {
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
        this.f31134b = c.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65543, this, bVar) == null) || bVar == null) {
            return;
        }
        if (com.bytedance.sdk.openadsdk.r.o.a()) {
            a(bVar);
        } else {
            c(bVar.a(true));
        }
    }

    private void c(b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65544, this, bVar) == null) || bVar == null) {
            return;
        }
        com.bytedance.sdk.component.e.e.a(bVar, 5);
    }

    public static k a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f31133a == null) {
                synchronized (k.class) {
                    if (f31133a == null) {
                        f31133a = new k();
                    }
                }
            }
            return f31133a;
        }
        return (k) invokeV.objValue;
    }

    public static void b(com.bytedance.sdk.openadsdk.core.e.m mVar, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, mVar, str) == null) || mVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        com.bytedance.sdk.openadsdk.r.d.a(System.currentTimeMillis());
        JSONObject aO = mVar.aO();
        if (aO == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.r.d.d(aO.toString());
        com.bytedance.sdk.openadsdk.r.d.c(str);
    }

    public void a(com.bytedance.sdk.openadsdk.core.e.m mVar, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048576, this, mVar, str, z) == null) {
            this.f31136d = b.a(mVar, str, this.f31135c, z);
            com.bytedance.sdk.component.e.e.d().schedule(new a(this, 100), 0L, TimeUnit.MILLISECONDS);
        }
    }

    private void a(b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65540, this, bVar) == null) || bVar == null) {
            return;
        }
        bVar.d();
        int c2 = bVar.c();
        c cVar = this.f31134b;
        if (c2 * cVar.f31145a > cVar.f31146b) {
            c(bVar.a(false));
        } else {
            com.bytedance.sdk.component.e.e.d().schedule(new a(this, 100), this.f31134b.f31145a, TimeUnit.MILLISECONDS);
        }
    }
}
