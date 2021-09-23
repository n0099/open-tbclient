package com.bytedance.sdk.openadsdk.e;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
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
/* loaded from: classes9.dex */
public class k {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile k f68120a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public c f68121b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, Object> f68122c;

    /* renamed from: d  reason: collision with root package name */
    public b f68123d;

    /* loaded from: classes9.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ k f68124a;

        /* renamed from: b  reason: collision with root package name */
        public int f68125b;

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
            this.f68124a = kVar;
            this.f68125b = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f68125b == 100 && this.f68124a.f68123d != null) {
                k kVar = this.f68124a;
                kVar.b(kVar.f68123d);
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class b extends com.bytedance.sdk.component.d.g implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final AtomicInteger f68126a;

        /* renamed from: b  reason: collision with root package name */
        public final AtomicBoolean f68127b;

        /* renamed from: c  reason: collision with root package name */
        public com.bytedance.sdk.openadsdk.core.e.m f68128c;

        /* renamed from: d  reason: collision with root package name */
        public String f68129d;

        /* renamed from: e  reason: collision with root package name */
        public Map<String, Object> f68130e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f68131f;

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
            this.f68126a = new AtomicInteger(0);
            this.f68127b = new AtomicBoolean(false);
        }

        public static b a(com.bytedance.sdk.openadsdk.core.e.m mVar, String str, Map<String, Object> map, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{mVar, str, map, Boolean.valueOf(z)})) == null) ? new b(mVar, str, map, z) : (b) invokeCommon.objValue;
        }

        public int c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f68126a.get() : invokeV.intValue;
        }

        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f68126a.incrementAndGet();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            AtomicBoolean atomicBoolean;
            com.bytedance.sdk.openadsdk.core.e.m mVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                if (this.f68128c != null && !TextUtils.isEmpty(this.f68129d) && (atomicBoolean = this.f68127b) != null) {
                    if (this.f68131f) {
                        com.bytedance.sdk.component.utils.k.b("DMLibManager", "落地页调起应用是否成功 sResult.get() " + this.f68127b.get());
                        d.b(com.bytedance.sdk.openadsdk.core.o.a(), this.f68128c, this.f68129d, this.f68127b.get() ? "lp_dpl_success" : "lp_dpl_failed");
                        return;
                    }
                    d.h(com.bytedance.sdk.openadsdk.core.o.a(), this.f68128c, this.f68129d, atomicBoolean.get() ? "dpl_success" : "dpl_failed", this.f68130e);
                    AtomicBoolean atomicBoolean2 = this.f68127b;
                    if (atomicBoolean2 == null || !atomicBoolean2.get() || (mVar = this.f68128c) == null) {
                        return;
                    }
                    k.b(mVar, this.f68129d);
                    return;
                }
                com.bytedance.sdk.component.utils.k.a("materialMeta or eventTag or sResult is null, pls check");
            }
        }

        public b a(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
                this.f68127b.set(z);
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
            this.f68126a = new AtomicInteger(0);
            this.f68127b = new AtomicBoolean(false);
            this.f68128c = mVar;
            this.f68129d = str;
            this.f68130e = map;
            this.f68131f = z;
        }
    }

    /* loaded from: classes9.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f68132a;

        /* renamed from: b  reason: collision with root package name */
        public int f68133b;

        /* renamed from: c  reason: collision with root package name */
        public int f68134c;

        /* renamed from: d  reason: collision with root package name */
        public int f68135d;

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
            this.f68132a = 500;
            this.f68133b = 5000;
            this.f68134c = 1000;
            this.f68135d = 300;
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
        this.f68121b = c.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65543, this, bVar) == null) || bVar == null) {
            return;
        }
        if (com.bytedance.sdk.openadsdk.q.q.a()) {
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
        com.bytedance.sdk.component.d.e.a(bVar, 5);
    }

    public static k a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f68120a == null) {
                synchronized (k.class) {
                    if (f68120a == null) {
                        f68120a = new k();
                    }
                }
            }
            return f68120a;
        }
        return (k) invokeV.objValue;
    }

    public static void b(com.bytedance.sdk.openadsdk.core.e.m mVar, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, mVar, str) == null) || mVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        com.bytedance.sdk.openadsdk.q.e.a(System.currentTimeMillis());
        JSONObject aP = mVar.aP();
        if (aP == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.q.e.d(aP.toString());
        com.bytedance.sdk.openadsdk.q.e.c(str);
    }

    public void a(com.bytedance.sdk.openadsdk.core.e.m mVar, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048576, this, mVar, str, z) == null) {
            this.f68123d = b.a(mVar, str, this.f68122c, z);
            com.bytedance.sdk.component.d.e.d().schedule(new a(this, 100), 0L, TimeUnit.MILLISECONDS);
        }
    }

    private void a(b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, bVar) == null) || bVar == null) {
            return;
        }
        bVar.d();
        int c2 = bVar.c();
        c cVar = this.f68121b;
        if (c2 * cVar.f68132a > cVar.f68133b) {
            c(bVar.a(false));
        } else {
            com.bytedance.sdk.component.d.e.d().schedule(new a(this, 100), this.f68121b.f68132a, TimeUnit.MILLISECONDS);
        }
    }
}
