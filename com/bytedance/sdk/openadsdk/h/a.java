package com.bytedance.sdk.openadsdk.h;

import android.app.Activity;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.ar.constants.ARConfigKey;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.bytedance.sdk.openadsdk.core.b;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.i;
import com.bytedance.sdk.openadsdk.core.k;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.h.a.d;
import com.bytedance.sdk.openadsdk.utils.aj;
import com.bytedance.sdk.openadsdk.utils.ak;
import com.bytedance.sdk.openadsdk.utils.c;
import com.bytedance.sdk.openadsdk.utils.u;
import com.bytedance.sdk.openadsdk.utils.x;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static volatile a f7465a;

    private a() {
    }

    public static a a() {
        if (f7465a == null) {
            synchronized (a.class) {
                if (f7465a == null) {
                    f7465a = new a();
                }
            }
        }
        return f7465a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean o(d dVar) {
        return dVar == null;
    }

    public void a(d dVar) {
        if (!o(dVar)) {
            dVar.c(System.currentTimeMillis() / 1000);
            p.j().a(dVar);
        }
    }

    public void a(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("playable_url", str);
        } catch (Throwable th) {
        }
        p.j().a(d.b().a("click_playable_test_tool").b(jSONObject.toString()), false);
    }

    public void b(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("playable_url", str);
        } catch (Throwable th) {
        }
        p.j().a(d.b().a("close_playable_test_tool").b(jSONObject.toString()), false);
    }

    public void a(String str, int i, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("playable_url", str);
            jSONObject.put("error_code", i);
            jSONObject.put("error_message", str2);
        } catch (Throwable th) {
        }
        p.j().a(d.b().a("use_playable_test_tool_error").b(jSONObject.toString()), false);
    }

    public void b() {
        boolean alist = i.c().d().alist();
        boolean isCanUseLocation = i.c().d().isCanUseLocation();
        boolean isCanUseWriteExternal = i.c().d().isCanUseWriteExternal();
        boolean isCanUseWifiState = i.c().d().isCanUseWifiState();
        boolean isCanUsePhoneState = i.c().d().isCanUsePhoneState();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("access_fine_location", isCanUseLocation ? 1 : 0);
            jSONObject.put("applist", alist ? 1 : 0);
            jSONObject.put("external_storage", isCanUseWriteExternal ? 1 : 0);
            jSONObject.put("wifi_state", isCanUseWifiState ? 1 : 0);
            jSONObject.put("phone_state", isCanUsePhoneState ? 1 : 0);
        } catch (Throwable th) {
        }
        p.j().a(d.b().a("sdk_permission").b(jSONObject.toString()), false);
    }

    public void a(Activity activity) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("page_name", activity.getClass().getName());
            ak.a(jSONObject);
            String jSONObject2 = jSONObject.toString();
            d b2 = d.b().a("delegate_on_create").b(jSONObject2);
            u.b("StatsLogManager", "delegate_on_create: " + jSONObject2);
            p.j().a(b2, false);
        } catch (Throwable th) {
        }
    }

    public void b(d dVar) {
        if (!o(dVar)) {
            dVar.a("outer_call");
            dVar.c(System.currentTimeMillis() / 1000);
            p.j().a(dVar, true);
        }
    }

    public void c(d dVar) {
        if (!o(dVar)) {
            dVar.a("outer_call_send");
            dVar.c(System.currentTimeMillis() / 1000);
            p.j().a(dVar, true);
        }
    }

    public void d(d dVar) {
        if (!o(dVar)) {
            dVar.a("outer_call_no_rsp");
            dVar.c(System.currentTimeMillis() / 1000);
            p.j().a(dVar, true);
        }
    }

    public void e(d dVar) {
        if (!o(dVar)) {
            dVar.a("load_ad_duration_no_ad");
            dVar.c(System.currentTimeMillis() / 1000);
            p.j().a(dVar);
        }
    }

    public void f(d dVar) {
        if (!o(dVar)) {
            dVar.a("load_creative_error");
            dVar.c(System.currentTimeMillis() / 1000);
            p.j().a(dVar, true);
        }
    }

    public void g(d dVar) {
        if (!o(dVar)) {
            dVar.a("load_timeout");
            dVar.c(System.currentTimeMillis() / 1000);
            p.j().a(dVar, true);
        }
    }

    public void h(d dVar) {
        if (!o(dVar)) {
            dVar.a("express_ad_render");
            dVar.c(System.currentTimeMillis() / 1000);
            p.j().a(dVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(String str, int i) {
        boolean z = false;
        com.bytedance.sdk.openadsdk.core.d a2 = com.bytedance.sdk.openadsdk.core.d.a(p.a());
        int b2 = a2.b(str, 0);
        z = ((b2 & 2) == 0 || (b2 & 1) != i) ? true : true;
        if (z) {
            a2.a(str, i + 2);
        }
        return z;
    }

    public void i(@NonNull final d dVar) {
        if (!o(dVar)) {
            com.bytedance.sdk.openadsdk.k.a.a().d(new Runnable() { // from class: com.bytedance.sdk.openadsdk.h.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (!a.this.o(dVar) && a.this.a(dVar.e(), 1)) {
                        dVar.a("reg_creative");
                        p.j().a(dVar);
                    }
                }
            }, 5);
        }
    }

    public void j(@NonNull final d dVar) {
        if (!o(dVar)) {
            com.bytedance.sdk.openadsdk.k.a.a().d(new Runnable() { // from class: com.bytedance.sdk.openadsdk.h.a.2
                @Override // java.lang.Runnable
                public void run() {
                    if (!a.this.o(dVar) && a.this.a(dVar.e(), 0)) {
                        dVar.a("no_reg_creative");
                        p.j().a(dVar);
                    }
                }
            }, 5);
        }
    }

    public void k(@NonNull d dVar) {
        if (!o(dVar)) {
            dVar.a("load_icon_error");
            p.j().a(dVar);
        }
    }

    public void l(d dVar) {
        if (!o(dVar)) {
            dVar.a("show_backup_endcard");
            dVar.c(System.currentTimeMillis() / 1000);
            p.j().a(dVar);
        }
    }

    public void m(@NonNull d dVar) {
        if (!o(dVar)) {
            p.j().a(dVar);
        }
    }

    public void n(@NonNull d dVar) {
        if (!o(dVar)) {
            dVar.a("splash_creative_check");
            dVar.c(System.currentTimeMillis() / 1000);
            p.j().a(dVar, true);
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
        p.j().a(d.b().a("download_permission").c(System.currentTimeMillis() / 1000).b(jSONObject.toString()));
    }

    public void a(@NonNull final List<com.bytedance.sdk.openadsdk.core.d.d> list, @NonNull final l lVar, final JSONObject jSONObject) {
        if (list != null && list.size() != 0 && lVar != null) {
            com.bytedance.sdk.openadsdk.k.a.a().d(new Runnable() { // from class: com.bytedance.sdk.openadsdk.h.a.3
                @Override // java.lang.Runnable
                public void run() {
                    if (!p.h().w() || x.c(p.a()) == 4) {
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
            jSONObject3.put("log_extra", lVar.W());
            jSONObject3.put(HttpConstants.NETWORK_TYPE, x.c(p.a()));
            jSONObject3.put("timestamp", System.currentTimeMillis() / 1000);
            jSONObject3.put(IXAdRequestInfo.CELL_ID, lVar.T());
            jSONObject3.put("platform", "Android");
            jSONObject3.put("app", i.c().f());
            jSONObject3.put("device_id", k.a(p.a()));
            c a2 = com.bytedance.sdk.openadsdk.utils.d.a(p.a());
            JSONObject jSONObject4 = new JSONObject();
            if (a2 != null) {
                jSONObject4.put("longitude", a2.f7865b);
                jSONObject4.put("latitude", a2.f7864a);
            }
            jSONObject3.put("location", jSONObject4);
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
}
