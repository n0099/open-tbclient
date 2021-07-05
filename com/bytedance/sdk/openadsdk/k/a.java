package com.bytedance.sdk.openadsdk.k;

import android.app.Activity;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.ar.constants.ARConfigKey;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.e.e;
import com.bytedance.sdk.component.e.g;
import com.bytedance.sdk.openadsdk.core.c;
import com.bytedance.sdk.openadsdk.core.e.d;
import com.bytedance.sdk.openadsdk.core.e.m;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.j;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.r.q;
import com.tencent.connect.common.Constants;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f31253a;
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

    public static a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f31253a == null) {
                synchronized (a.class) {
                    if (f31253a == null) {
                        f31253a = new a();
                    }
                }
            }
            return f31253a;
        }
        return (a) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(AdIconUtil.AD_TEXT_ID, this, str, i2)) == null) {
            c a2 = c.a(o.a());
            boolean z = false;
            int b2 = a2.b(str, 0);
            z = ((b2 & 2) == 0 || (b2 & 1) != i2) ? true : true;
            if (z) {
                a2.a(str, i2 + 2);
            }
            return z;
        }
        return invokeLI.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject b(@NonNull List<d> list, @NonNull m mVar, JSONObject jSONObject) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(AdIconUtil.BAIDU_LOGO_ID, this, list, mVar, jSONObject)) == null) {
            if (list == null || list.size() == 0 || mVar == null) {
                return null;
            }
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put("log_extra", mVar.ao());
                jSONObject3.put("network_type", com.bytedance.sdk.component.utils.m.c(o.a()));
                jSONObject3.put("timestamp", System.currentTimeMillis() / 1000);
                jSONObject3.put(IAdRequestParam.CELL_ID, mVar.ak());
                jSONObject3.put(Constants.PARAM_PLATFORM, "Android");
                jSONObject3.put("app", h.d().j());
                jSONObject3.put("device_id", j.a(o.a()));
                com.bytedance.sdk.openadsdk.n.a.b(jSONObject3);
                JSONArray jSONArray = new JSONArray();
                for (d dVar : list) {
                    if (dVar != null) {
                        jSONArray.put(dVar.a());
                    }
                }
                jSONObject3.put(NotificationCompat.WearableExtender.KEY_PAGES, jSONArray);
                if (jSONObject != null) {
                    jSONObject3.put(ARConfigKey.EXTRA_INFO, jSONObject);
                    com.bytedance.sdk.component.utils.j.b(ARConfigKey.EXTRA_INFO, "back extra info:" + jSONObject.toString());
                }
                String a2 = com.bytedance.sdk.component.c.a.a(com.bytedance.sdk.openadsdk.r.o.j(jSONObject3.toString()), com.bytedance.sdk.openadsdk.core.a.b());
                jSONObject2.put("content", a2);
                com.bytedance.sdk.component.utils.j.f("StatsLogManager", "html content:" + a2);
            } catch (Exception unused) {
            }
            return jSONObject2;
        }
        return (JSONObject) invokeLLL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean o(com.bytedance.sdk.openadsdk.k.a.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, this, cVar)) == null) ? cVar == null : invokeL.booleanValue;
    }

    public void a(long j, long j2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i2)}) == null) {
            long j3 = j2 - j;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("starttime", j);
                jSONObject.put("endtime", j2);
                jSONObject.put("start_type", i2);
            } catch (Throwable unused) {
            }
            com.bytedance.sdk.openadsdk.k.a.c a2 = com.bytedance.sdk.openadsdk.k.a.c.b().a("general_label");
            o.i().a(a2.f(j3 + "").b(jSONObject.toString()), false);
        }
    }

    public void a(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity) == null) {
            e.b(new g(this, "delegateActivityOnCreate", activity) { // from class: com.bytedance.sdk.openadsdk.k.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ Activity f31254a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ a f31255b;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r8);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r8, activity};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            super((String) newInitContext.callArgs[0]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f31255b = this;
                    this.f31254a = activity;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("page_name", this.f31254a.getClass().getName());
                            q.a(jSONObject);
                            String jSONObject2 = jSONObject.toString();
                            com.bytedance.sdk.openadsdk.k.a.c b2 = com.bytedance.sdk.openadsdk.k.a.c.b().a("delegate_on_create").b(jSONObject2);
                            com.bytedance.sdk.component.utils.j.b("StatsLogManager", "delegate_on_create: " + jSONObject2);
                            o.i().a(b2, false);
                        } catch (Throwable unused) {
                        }
                    }
                }
            });
        }
    }

    public void a(com.bytedance.sdk.openadsdk.k.a.c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this, cVar) == null) || o(cVar)) {
            return;
        }
        cVar.c(System.currentTimeMillis() / 1000);
        o.i().a(cVar);
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("playable_url", str);
            } catch (Throwable unused) {
            }
            o.i().a(com.bytedance.sdk.openadsdk.k.a.c.b().a("click_playable_test_tool").b(jSONObject.toString()), false);
        }
    }

    public void a(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048580, this, str, i2, str2) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("playable_url", str);
                jSONObject.put("error_code", i2);
                jSONObject.put("error_message", str2);
            } catch (Throwable unused) {
            }
            o.i().a(com.bytedance.sdk.openadsdk.k.a.c.b().a("use_playable_test_tool_error").b(jSONObject.toString()), false);
        }
    }

    public void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, str, str2) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("close_time_1", str2);
            } catch (Throwable unused) {
            }
            o.i().a(com.bytedance.sdk.openadsdk.k.a.c.b().a("sdk_retention").f(str).b(jSONObject.toString()), false);
        }
    }

    public void a(String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048582, this, str, jSONObject) == null) || TextUtils.isEmpty(str) || jSONObject == null) {
            return;
        }
        o.i().a(com.bytedance.sdk.openadsdk.k.a.c.b().a(str).b(jSONObject.toString()), false);
    }

    public void a(@NonNull List<d> list, @NonNull m mVar, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048583, this, list, mVar, jSONObject) == null) || list == null || list.size() == 0 || mVar == null) {
            return;
        }
        e.a(new g(this, "upLoadHtmlInfo", list, mVar, jSONObject) { // from class: com.bytedance.sdk.openadsdk.k.a.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ List f31260a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ m f31261b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ JSONObject f31262c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ a f31263d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, r8, list, mVar, jSONObject};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        super((String) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f31263d = this;
                this.f31260a = list;
                this.f31261b = mVar;
                this.f31262c = jSONObject;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    if (!o.h().u() || com.bytedance.sdk.component.utils.m.c(o.a()) == 4) {
                        o.f().a(this.f31263d.b(this.f31260a, this.f31261b, this.f31262c), 1);
                    }
                }
            }
        }, 5);
    }

    public void a(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        o.i().a(com.bytedance.sdk.openadsdk.k.a.c.b().a("app_env").c(System.currentTimeMillis() / 1000).b(jSONObject.toString()));
    }

    public void a(boolean z, String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048585, this, z, strArr) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("if_sd", z ? 1 : 0);
                if (strArr != null && strArr.length > 0) {
                    StringBuilder sb = new StringBuilder();
                    for (String str : strArr) {
                        if (!TextUtils.isEmpty(str)) {
                            sb.append(str);
                            sb.append(",");
                        }
                    }
                    jSONObject.put("permission", sb.toString());
                }
            } catch (Throwable unused) {
            }
            o.i().a(com.bytedance.sdk.openadsdk.k.a.c.b().a("download_permission").c(System.currentTimeMillis() / 1000).b(jSONObject.toString()));
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            boolean alist = h.d().f().alist();
            boolean isCanUseLocation = h.d().f().isCanUseLocation();
            boolean isCanUseWriteExternal = h.d().f().isCanUseWriteExternal();
            boolean isCanUseWifiState = h.d().f().isCanUseWifiState();
            boolean isCanUsePhoneState = h.d().f().isCanUsePhoneState();
            JSONObject jSONObject = new JSONObject();
            int i2 = 1;
            try {
                jSONObject.put("access_fine_location", isCanUseLocation ? 1 : 0);
                jSONObject.put("applist", alist ? 1 : 0);
                jSONObject.put("external_storage", isCanUseWriteExternal ? 1 : 0);
                jSONObject.put("wifi_state", isCanUseWifiState ? 1 : 0);
                if (!isCanUsePhoneState) {
                    i2 = 0;
                }
                jSONObject.put("phone_state", i2);
            } catch (Throwable unused) {
            }
            o.i().a(com.bytedance.sdk.openadsdk.k.a.c.b().a("sdk_permission").b(jSONObject.toString()), false);
        }
    }

    public void b(com.bytedance.sdk.openadsdk.k.a.c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, cVar) == null) || o(cVar)) {
            return;
        }
        cVar.a("outer_call");
        cVar.c(System.currentTimeMillis() / 1000);
        o.i().a(cVar, true);
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("playable_url", str);
            } catch (Throwable unused) {
            }
            o.i().a(com.bytedance.sdk.openadsdk.k.a.c.b().a("close_playable_test_tool").b(jSONObject.toString()), false);
        }
    }

    public void c(com.bytedance.sdk.openadsdk.k.a.c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, cVar) == null) || o(cVar)) {
            return;
        }
        cVar.a("outer_call_send");
        cVar.c(System.currentTimeMillis() / 1000);
        o.i().a(cVar, true);
    }

    public void c(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, str) == null) || str == null) {
            return;
        }
        o.i().a(com.bytedance.sdk.openadsdk.k.a.c.b().a("error_ad_info").c(System.currentTimeMillis() / 1000).k(str));
    }

    public void d(com.bytedance.sdk.openadsdk.k.a.c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, cVar) == null) || o(cVar)) {
            return;
        }
        cVar.a("outer_call_no_rsp");
        cVar.c(System.currentTimeMillis() / 1000);
        o.i().a(cVar, true);
    }

    public void e(com.bytedance.sdk.openadsdk.k.a.c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, cVar) == null) || o(cVar)) {
            return;
        }
        cVar.a("load_ad_duration_no_ad");
        cVar.c(System.currentTimeMillis() / 1000);
        o.i().a(cVar);
    }

    public void f(com.bytedance.sdk.openadsdk.k.a.c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, cVar) == null) || o(cVar)) {
            return;
        }
        cVar.a("load_creative_error");
        cVar.c(System.currentTimeMillis() / 1000);
        o.i().a(cVar, true);
    }

    public void g(com.bytedance.sdk.openadsdk.k.a.c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, cVar) == null) || o(cVar)) {
            return;
        }
        cVar.a("load_timeout");
        cVar.c(System.currentTimeMillis() / 1000);
        o.i().a(cVar, true);
    }

    public void h(com.bytedance.sdk.openadsdk.k.a.c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, cVar) == null) || o(cVar)) {
            return;
        }
        cVar.a("express_ad_render");
        cVar.c(System.currentTimeMillis() / 1000);
        o.i().a(cVar);
    }

    public void i(@NonNull com.bytedance.sdk.openadsdk.k.a.c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048596, this, cVar) == null) || o(cVar)) {
            return;
        }
        e.a(new g(this, "markAtCreativeRegister", cVar) { // from class: com.bytedance.sdk.openadsdk.k.a.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ com.bytedance.sdk.openadsdk.k.a.c f31256a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ a f31257b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, r8, cVar};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        super((String) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f31257b = this;
                this.f31256a = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && !this.f31257b.o(this.f31256a) && this.f31257b.a(this.f31256a.e(), 1)) {
                    this.f31256a.a("reg_creative");
                    o.i().a(this.f31256a);
                }
            }
        }, 5);
    }

    public void j(@NonNull com.bytedance.sdk.openadsdk.k.a.c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048597, this, cVar) == null) || o(cVar)) {
            return;
        }
        e.a(new g(this, "markAtCreativeNotRegister", cVar) { // from class: com.bytedance.sdk.openadsdk.k.a.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ com.bytedance.sdk.openadsdk.k.a.c f31258a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ a f31259b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, r8, cVar};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        super((String) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f31259b = this;
                this.f31258a = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && !this.f31259b.o(this.f31258a) && this.f31259b.a(this.f31258a.e(), 0)) {
                    this.f31258a.a("no_reg_creative");
                    o.i().a(this.f31258a);
                }
            }
        }, 5);
    }

    public void k(@NonNull com.bytedance.sdk.openadsdk.k.a.c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048598, this, cVar) == null) || o(cVar)) {
            return;
        }
        cVar.a("load_icon_error");
        o.i().a(cVar);
    }

    public void l(com.bytedance.sdk.openadsdk.k.a.c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048599, this, cVar) == null) || o(cVar)) {
            return;
        }
        cVar.a("show_backup_endcard");
        cVar.c(System.currentTimeMillis() / 1000);
        o.i().a(cVar);
    }

    public void m(@NonNull com.bytedance.sdk.openadsdk.k.a.c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048600, this, cVar) == null) || o(cVar)) {
            return;
        }
        o.i().a(cVar);
    }

    public void n(@NonNull com.bytedance.sdk.openadsdk.k.a.c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048601, this, cVar) == null) || o(cVar)) {
            return;
        }
        cVar.a("splash_creative_check");
        cVar.c(System.currentTimeMillis() / 1000);
        o.i().a(cVar, true);
    }
}
