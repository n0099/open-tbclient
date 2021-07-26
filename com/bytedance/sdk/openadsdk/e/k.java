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
/* loaded from: classes5.dex */
public class k {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile k f31486a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public c f31487b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, Object> f31488c;

    /* renamed from: d  reason: collision with root package name */
    public b f31489d;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ k f31490a;

        /* renamed from: b  reason: collision with root package name */
        public int f31491b;

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
            this.f31490a = kVar;
            this.f31491b = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f31491b == 100 && this.f31490a.f31489d != null) {
                k kVar = this.f31490a;
                kVar.b(kVar.f31489d);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b extends com.bytedance.sdk.component.d.g implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final AtomicInteger f31492a;

        /* renamed from: b  reason: collision with root package name */
        public final AtomicBoolean f31493b;

        /* renamed from: c  reason: collision with root package name */
        public com.bytedance.sdk.openadsdk.core.e.m f31494c;

        /* renamed from: d  reason: collision with root package name */
        public String f31495d;

        /* renamed from: e  reason: collision with root package name */
        public Map<String, Object> f31496e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f31497f;

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
            this.f31492a = new AtomicInteger(0);
            this.f31493b = new AtomicBoolean(false);
        }

        public static b a(com.bytedance.sdk.openadsdk.core.e.m mVar, String str, Map<String, Object> map, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{mVar, str, map, Boolean.valueOf(z)})) == null) ? new b(mVar, str, map, z) : (b) invokeCommon.objValue;
        }

        public int c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f31492a.get() : invokeV.intValue;
        }

        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f31492a.incrementAndGet();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            AtomicBoolean atomicBoolean;
            com.bytedance.sdk.openadsdk.core.e.m mVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                if (this.f31494c != null && !TextUtils.isEmpty(this.f31495d) && (atomicBoolean = this.f31493b) != null) {
                    if (this.f31497f) {
                        com.bytedance.sdk.component.utils.k.b("DMLibManager", "落地页调起应用是否成功 sResult.get() " + this.f31493b.get());
                        d.b(com.bytedance.sdk.openadsdk.core.o.a(), this.f31494c, this.f31495d, this.f31493b.get() ? "lp_dpl_success" : "lp_dpl_failed");
                        return;
                    }
                    d.h(com.bytedance.sdk.openadsdk.core.o.a(), this.f31494c, this.f31495d, atomicBoolean.get() ? "dpl_success" : "dpl_failed", this.f31496e);
                    AtomicBoolean atomicBoolean2 = this.f31493b;
                    if (atomicBoolean2 == null || !atomicBoolean2.get() || (mVar = this.f31494c) == null) {
                        return;
                    }
                    k.b(mVar, this.f31495d);
                    return;
                }
                com.bytedance.sdk.component.utils.k.a("materialMeta or eventTag or sResult is null, pls check");
            }
        }

        public b a(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
                this.f31493b.set(z);
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
            this.f31492a = new AtomicInteger(0);
            this.f31493b = new AtomicBoolean(false);
            this.f31494c = mVar;
            this.f31495d = str;
            this.f31496e = map;
            this.f31497f = z;
        }
    }

    /* loaded from: classes5.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f31498a;

        /* renamed from: b  reason: collision with root package name */
        public int f31499b;

        /* renamed from: c  reason: collision with root package name */
        public int f31500c;

        /* renamed from: d  reason: collision with root package name */
        public int f31501d;

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
            this.f31498a = 500;
            this.f31499b = 5000;
            this.f31500c = 1000;
            this.f31501d = 300;
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
        this.f31487b = c.a();
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
            if (f31486a == null) {
                synchronized (k.class) {
                    if (f31486a == null) {
                        f31486a = new k();
                    }
                }
            }
            return f31486a;
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
            this.f31489d = b.a(mVar, str, this.f31488c, z);
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
        c cVar = this.f31487b;
        if (c2 * cVar.f31498a > cVar.f31499b) {
            c(bVar.a(false));
        } else {
            com.bytedance.sdk.component.d.e.d().schedule(new a(this, 100), this.f31487b.f31498a, TimeUnit.MILLISECONDS);
        }
    }
}
