package com.bytedance.sdk.openadsdk.g;

import android.app.Activity;
import android.net.http.Headers;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.ar.constants.ARConfigKey;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.bytedance.sdk.openadsdk.core.b;
import com.bytedance.sdk.openadsdk.core.d;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.i;
import com.bytedance.sdk.openadsdk.core.k;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.g.a.c;
import com.bytedance.sdk.openadsdk.j.e;
import com.bytedance.sdk.openadsdk.utils.aj;
import com.bytedance.sdk.openadsdk.utils.ak;
import com.bytedance.sdk.openadsdk.utils.u;
import com.bytedance.sdk.openadsdk.utils.x;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static volatile a f4770a;

    private a() {
    }

    public static a a() {
        if (f4770a == null) {
            synchronized (a.class) {
                if (f4770a == null) {
                    f4770a = new a();
                }
            }
        }
        return f4770a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean o(c cVar) {
        return cVar == null;
    }

    public void a(c cVar) {
        if (!o(cVar)) {
            cVar.c(System.currentTimeMillis() / 1000);
            p.i().a(cVar);
        }
    }

    public void a(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("playable_url", str);
        } catch (Throwable th) {
        }
        p.i().a(c.b().a("click_playable_test_tool").b(jSONObject.toString()), false);
    }

    public void b(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("playable_url", str);
        } catch (Throwable th) {
        }
        p.i().a(c.b().a("close_playable_test_tool").b(jSONObject.toString()), false);
    }

    public void a(String str, int i, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("playable_url", str);
            jSONObject.put("error_code", i);
            jSONObject.put("error_message", str2);
        } catch (Throwable th) {
        }
        p.i().a(c.b().a("use_playable_test_tool_error").b(jSONObject.toString()), false);
    }

    public void b() {
        boolean alist = i.d().e().alist();
        boolean isCanUseLocation = i.d().e().isCanUseLocation();
        boolean isCanUseWriteExternal = i.d().e().isCanUseWriteExternal();
        boolean isCanUseWifiState = i.d().e().isCanUseWifiState();
        boolean isCanUsePhoneState = i.d().e().isCanUsePhoneState();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("access_fine_location", isCanUseLocation ? 1 : 0);
            jSONObject.put("applist", alist ? 1 : 0);
            jSONObject.put("external_storage", isCanUseWriteExternal ? 1 : 0);
            jSONObject.put("wifi_state", isCanUseWifiState ? 1 : 0);
            jSONObject.put("phone_state", isCanUsePhoneState ? 1 : 0);
        } catch (Throwable th) {
        }
        p.i().a(c.b().a("sdk_permission").b(jSONObject.toString()), false);
    }

    public void a(Activity activity) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("page_name", activity.getClass().getName());
            ak.a(jSONObject);
            String jSONObject2 = jSONObject.toString();
            c b = c.b().a("delegate_on_create").b(jSONObject2);
            u.b("StatsLogManager", "delegate_on_create: " + jSONObject2);
            p.i().a(b, false);
        } catch (Throwable th) {
        }
    }

    public void b(c cVar) {
        if (!o(cVar)) {
            cVar.a("outer_call");
            cVar.c(System.currentTimeMillis() / 1000);
            p.i().a(cVar, true);
        }
    }

    public void c(c cVar) {
        if (!o(cVar)) {
            cVar.a("outer_call_send");
            cVar.c(System.currentTimeMillis() / 1000);
            p.i().a(cVar, true);
        }
    }

    public void d(c cVar) {
        if (!o(cVar)) {
            cVar.a("outer_call_no_rsp");
            cVar.c(System.currentTimeMillis() / 1000);
            p.i().a(cVar, true);
        }
    }

    public void e(c cVar) {
        if (!o(cVar)) {
            cVar.a("load_ad_duration_no_ad");
            cVar.c(System.currentTimeMillis() / 1000);
            p.i().a(cVar);
        }
    }

    public void f(c cVar) {
        if (!o(cVar)) {
            cVar.a("load_creative_error");
            cVar.c(System.currentTimeMillis() / 1000);
            p.i().a(cVar, true);
        }
    }

    public void g(c cVar) {
        if (!o(cVar)) {
            cVar.a("load_timeout");
            cVar.c(System.currentTimeMillis() / 1000);
            p.i().a(cVar, true);
        }
    }

    public void h(c cVar) {
        if (!o(cVar)) {
            cVar.a("express_ad_render");
            cVar.c(System.currentTimeMillis() / 1000);
            p.i().a(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(String str, int i) {
        boolean z = false;
        d a2 = d.a(p.a());
        int b = a2.b(str, 0);
        z = ((b & 2) == 0 || (b & 1) != i) ? true : true;
        if (z) {
            a2.a(str, i + 2);
        }
        return z;
    }

    public void i(@NonNull final c cVar) {
        if (!o(cVar)) {
            e.a(new Runnable() { // from class: com.bytedance.sdk.openadsdk.g.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (!a.this.o(cVar) && a.this.a(cVar.e(), 1)) {
                        cVar.a("reg_creative");
                        p.i().a(cVar);
                    }
                }
            }, 5);
        }
    }

    public void j(@NonNull final c cVar) {
        if (!o(cVar)) {
            e.a(new Runnable() { // from class: com.bytedance.sdk.openadsdk.g.a.2
                @Override // java.lang.Runnable
                public void run() {
                    if (!a.this.o(cVar) && a.this.a(cVar.e(), 0)) {
                        cVar.a("no_reg_creative");
                        p.i().a(cVar);
                    }
                }
            }, 5);
        }
    }

    public void k(@NonNull c cVar) {
        if (!o(cVar)) {
            cVar.a("load_icon_error");
            p.i().a(cVar);
        }
    }

    public void l(c cVar) {
        if (!o(cVar)) {
            cVar.a("show_backup_endcard");
            cVar.c(System.currentTimeMillis() / 1000);
            p.i().a(cVar);
        }
    }

    public void m(@NonNull c cVar) {
        if (!o(cVar)) {
            p.i().a(cVar);
        }
    }

    public void n(@NonNull c cVar) {
        if (!o(cVar)) {
            cVar.a("splash_creative_check");
            cVar.c(System.currentTimeMillis() / 1000);
            p.i().a(cVar, true);
        }
    }

    public void a(boolean z, String[] strArr) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("if_sd", z ? 1 : 0);
            if (strArr != null && strArr.length > 0) {
                StringBuilder sb = new StringBuilder();
                for (String str : strArr) {
                    if (!TextUtils.isEmpty(str)) {
                        sb.append(str).append(",");
                    }
                }
                jSONObject.put("permission", sb.toString());
            }
        } catch (Throwable th) {
        }
        p.i().a(c.b().a("download_permission").c(System.currentTimeMillis() / 1000).b(jSONObject.toString()));
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            p.i().a(c.b().a("app_env").c(System.currentTimeMillis() / 1000).b(jSONObject.toString()));
        }
    }

    public void a(@NonNull final List<com.bytedance.sdk.openadsdk.core.d.d> list, @NonNull final l lVar, final JSONObject jSONObject) {
        if (list != null && list.size() != 0 && lVar != null) {
            e.a(new Runnable() { // from class: com.bytedance.sdk.openadsdk.g.a.3
                @Override // java.lang.Runnable
                public void run() {
                    if (!p.h().v() || x.c(p.a()) == 4) {
                        p.f().a(a.this.b(list, lVar, jSONObject), 1);
                    }
                }
            }, 5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject b(@NonNull List<com.bytedance.sdk.openadsdk.core.d.d> list, @NonNull l lVar, JSONObject jSONObject) {
        if (list == null || list.size() == 0 || lVar == null) {
            return null;
        }
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject3.put("log_extra", lVar.aj());
            jSONObject3.put(HttpConstants.NETWORK_TYPE, x.c(p.a()));
            jSONObject3.put("timestamp", System.currentTimeMillis() / 1000);
            jSONObject3.put(IXAdRequestInfo.CELL_ID, lVar.ag());
            jSONObject3.put("platform", "Android");
            jSONObject3.put("app", i.d().g());
            jSONObject3.put("device_id", k.a(p.a()));
            com.bytedance.sdk.openadsdk.utils.c a2 = com.bytedance.sdk.openadsdk.utils.d.a(p.a());
            JSONObject jSONObject4 = new JSONObject();
            if (a2 != null) {
                jSONObject4.put("longitude", a2.b);
                jSONObject4.put("latitude", a2.f5126a);
            }
            jSONObject3.put(Headers.LOCATION, jSONObject4);
            JSONArray jSONArray = new JSONArray();
            for (com.bytedance.sdk.openadsdk.core.d.d dVar : list) {
                if (dVar != null) {
                    jSONArray.put(dVar.a());
                }
            }
            jSONObject3.put("pages", jSONArray);
            if (jSONObject != null) {
                jSONObject3.put(ARConfigKey.EXTRA_INFO, jSONObject);
                u.b(ARConfigKey.EXTRA_INFO, "back extra info:" + jSONObject.toString());
            }
            String a3 = com.bytedance.sdk.openadsdk.core.a.a(aj.i(jSONObject3.toString()), b.c());
            jSONObject2.put("content", a3);
            u.f("StatsLogManager", "html content:" + a3);
        } catch (Exception e) {
        }
        return jSONObject2;
    }

    public void a(String str, JSONObject jSONObject) {
        if (!TextUtils.isEmpty(str) && jSONObject != null) {
            p.i().a(c.b().a(str).b(jSONObject.toString()), false);
        }
    }
}
