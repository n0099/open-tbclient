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
    public static volatile k f68155a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public c f68156b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, Object> f68157c;

    /* renamed from: d  reason: collision with root package name */
    public b f68158d;

    /* loaded from: classes9.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ k f68159a;

        /* renamed from: b  reason: collision with root package name */
        public int f68160b;

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
            this.f68159a = kVar;
            this.f68160b = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f68160b == 100 && this.f68159a.f68158d != null) {
                k kVar = this.f68159a;
                kVar.b(kVar.f68158d);
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class b extends com.bytedance.sdk.component.d.g implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final AtomicInteger f68161a;

        /* renamed from: b  reason: collision with root package name */
        public final AtomicBoolean f68162b;

        /* renamed from: c  reason: collision with root package name */
        public com.bytedance.sdk.openadsdk.core.e.m f68163c;

        /* renamed from: d  reason: collision with root package name */
        public String f68164d;

        /* renamed from: e  reason: collision with root package name */
        public Map<String, Object> f68165e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f68166f;

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
            this.f68161a = new AtomicInteger(0);
            this.f68162b = new AtomicBoolean(false);
        }

        public static b a(com.bytedance.sdk.openadsdk.core.e.m mVar, String str, Map<String, Object> map, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{mVar, str, map, Boolean.valueOf(z)})) == null) ? new b(mVar, str, map, z) : (b) invokeCommon.objValue;
        }

        public int c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f68161a.get() : invokeV.intValue;
        }

        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f68161a.incrementAndGet();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            AtomicBoolean atomicBoolean;
            com.bytedance.sdk.openadsdk.core.e.m mVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                if (this.f68163c != null && !TextUtils.isEmpty(this.f68164d) && (atomicBoolean = this.f68162b) != null) {
                    if (this.f68166f) {
                        com.bytedance.sdk.component.utils.k.b("DMLibManager", "落地页调起应用是否成功 sResult.get() " + this.f68162b.get());
                        d.b(com.bytedance.sdk.openadsdk.core.o.a(), this.f68163c, this.f68164d, this.f68162b.get() ? "lp_dpl_success" : "lp_dpl_failed");
                        return;
                    }
                    d.h(com.bytedance.sdk.openadsdk.core.o.a(), this.f68163c, this.f68164d, atomicBoolean.get() ? "dpl_success" : "dpl_failed", this.f68165e);
                    AtomicBoolean atomicBoolean2 = this.f68162b;
                    if (atomicBoolean2 == null || !atomicBoolean2.get() || (mVar = this.f68163c) == null) {
                        return;
                    }
                    k.b(mVar, this.f68164d);
                    return;
                }
                com.bytedance.sdk.component.utils.k.a("materialMeta or eventTag or sResult is null, pls check");
            }
        }

        public b a(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
                this.f68162b.set(z);
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
            this.f68161a = new AtomicInteger(0);
            this.f68162b = new AtomicBoolean(false);
            this.f68163c = mVar;
            this.f68164d = str;
            this.f68165e = map;
            this.f68166f = z;
        }
    }

    /* loaded from: classes9.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f68167a;

        /* renamed from: b  reason: collision with root package name */
        public int f68168b;

        /* renamed from: c  reason: collision with root package name */
        public int f68169c;

        /* renamed from: d  reason: collision with root package name */
        public int f68170d;

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
            this.f68167a = 500;
            this.f68168b = 5000;
            this.f68169c = 1000;
            this.f68170d = 300;
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
        this.f68156b = c.a();
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
            if (f68155a == null) {
                synchronized (k.class) {
                    if (f68155a == null) {
                        f68155a = new k();
                    }
                }
            }
            return f68155a;
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
            this.f68158d = b.a(mVar, str, this.f68157c, z);
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
        c cVar = this.f68156b;
        if (c2 * cVar.f68167a > cVar.f68168b) {
            c(bVar.a(false));
        } else {
            com.bytedance.sdk.component.d.e.d().schedule(new a(this, 100), this.f68156b.f68167a, TimeUnit.MILLISECONDS);
        }
    }
}
