package com.bytedance.sdk.openadsdk.h;

import android.app.Activity;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.searchbox.pms.constants.PmsConstant;
import com.bytedance.sdk.openadsdk.core.b;
import com.bytedance.sdk.openadsdk.core.d.d;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.i;
import com.bytedance.sdk.openadsdk.core.k;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.h.a.c;
import com.bytedance.sdk.openadsdk.l.e;
import com.bytedance.sdk.openadsdk.l.g;
import com.bytedance.sdk.openadsdk.utils.ak;
import com.bytedance.sdk.openadsdk.utils.al;
import com.bytedance.sdk.openadsdk.utils.u;
import com.bytedance.sdk.openadsdk.utils.x;
import com.tencent.connect.common.Constants;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f29093a;

    /* JADX INFO: Access modifiers changed from: private */
    public boolean o(c cVar) {
        return cVar == null;
    }

    public void b(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("playable_url", str);
        } catch (Throwable unused) {
        }
        p.i().a(c.b().a("close_playable_test_tool").b(jSONObject.toString()), false);
    }

    public void c(c cVar) {
        if (o(cVar)) {
            return;
        }
        cVar.a("outer_call_send");
        cVar.c(System.currentTimeMillis() / 1000);
        p.i().a(cVar, true);
    }

    public void d(c cVar) {
        if (o(cVar)) {
            return;
        }
        cVar.a("outer_call_no_rsp");
        cVar.c(System.currentTimeMillis() / 1000);
        p.i().a(cVar, true);
    }

    public void e(c cVar) {
        if (o(cVar)) {
            return;
        }
        cVar.a("load_ad_duration_no_ad");
        cVar.c(System.currentTimeMillis() / 1000);
        p.i().a(cVar);
    }

    public void f(c cVar) {
        if (o(cVar)) {
            return;
        }
        cVar.a("load_creative_error");
        cVar.c(System.currentTimeMillis() / 1000);
        p.i().a(cVar, true);
    }

    public void g(c cVar) {
        if (o(cVar)) {
            return;
        }
        cVar.a("load_timeout");
        cVar.c(System.currentTimeMillis() / 1000);
        p.i().a(cVar, true);
    }

    public void h(c cVar) {
        if (o(cVar)) {
            return;
        }
        cVar.a("express_ad_render");
        cVar.c(System.currentTimeMillis() / 1000);
        p.i().a(cVar);
    }

    public void i(@NonNull final c cVar) {
        if (o(cVar)) {
            return;
        }
        e.a(new g("markAtCreativeRegister") { // from class: com.bytedance.sdk.openadsdk.h.a.1
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.o(cVar) || !a.this.a(cVar.e(), 1)) {
                    return;
                }
                cVar.a("reg_creative");
                p.i().a(cVar);
            }
        }, 5);
    }

    public void j(@NonNull final c cVar) {
        if (o(cVar)) {
            return;
        }
        e.a(new g("markAtCreativeNotRegister") { // from class: com.bytedance.sdk.openadsdk.h.a.2
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.o(cVar) || !a.this.a(cVar.e(), 0)) {
                    return;
                }
                cVar.a("no_reg_creative");
                p.i().a(cVar);
            }
        }, 5);
    }

    public void k(@NonNull c cVar) {
        if (o(cVar)) {
            return;
        }
        cVar.a("load_icon_error");
        p.i().a(cVar);
    }

    public void l(c cVar) {
        if (o(cVar)) {
            return;
        }
        cVar.a("show_backup_endcard");
        cVar.c(System.currentTimeMillis() / 1000);
        p.i().a(cVar);
    }

    public void m(@NonNull c cVar) {
        if (o(cVar)) {
            return;
        }
        p.i().a(cVar);
    }

    public void n(@NonNull c cVar) {
        if (o(cVar)) {
            return;
        }
        cVar.a("splash_creative_check");
        cVar.c(System.currentTimeMillis() / 1000);
        p.i().a(cVar, true);
    }

    public static a a() {
        if (f29093a == null) {
            synchronized (a.class) {
                if (f29093a == null) {
                    f29093a = new a();
                }
            }
        }
        return f29093a;
    }

    public void b() {
        boolean alist = i.d().e().alist();
        boolean isCanUseLocation = i.d().e().isCanUseLocation();
        boolean isCanUseWriteExternal = i.d().e().isCanUseWriteExternal();
        boolean isCanUseWifiState = i.d().e().isCanUseWifiState();
        boolean isCanUsePhoneState = i.d().e().isCanUsePhoneState();
        JSONObject jSONObject = new JSONObject();
        int i = 1;
        try {
            jSONObject.put("access_fine_location", isCanUseLocation ? 1 : 0);
            jSONObject.put("applist", alist ? 1 : 0);
            jSONObject.put("external_storage", isCanUseWriteExternal ? 1 : 0);
            jSONObject.put("wifi_state", isCanUseWifiState ? 1 : 0);
            if (!isCanUsePhoneState) {
                i = 0;
            }
            jSONObject.put("phone_state", i);
        } catch (Throwable unused) {
        }
        p.i().a(c.b().a("sdk_permission").b(jSONObject.toString()), false);
    }

    public void a(c cVar) {
        if (o(cVar)) {
            return;
        }
        cVar.c(System.currentTimeMillis() / 1000);
        p.i().a(cVar);
    }

    public void a(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("playable_url", str);
        } catch (Throwable unused) {
        }
        p.i().a(c.b().a("click_playable_test_tool").b(jSONObject.toString()), false);
    }

    public void a(String str, int i, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("playable_url", str);
            jSONObject.put("error_code", i);
            jSONObject.put("error_message", str2);
        } catch (Throwable unused) {
        }
        p.i().a(c.b().a("use_playable_test_tool_error").b(jSONObject.toString()), false);
    }

    public void b(c cVar) {
        if (o(cVar)) {
            return;
        }
        cVar.a("outer_call");
        cVar.c(System.currentTimeMillis() / 1000);
        p.i().a(cVar, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject b(@NonNull List<d> list, @NonNull l lVar, JSONObject jSONObject) {
        if (list == null || list.size() == 0 || lVar == null) {
            return null;
        }
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject3.put("log_extra", lVar.ap());
            jSONObject3.put(PmsConstant.Statistic.STATISTIC_NETWORK, x.c(p.a()));
            jSONObject3.put("timestamp", System.currentTimeMillis() / 1000);
            jSONObject3.put(IAdRequestParam.CELL_ID, lVar.am());
            jSONObject3.put(Constants.PARAM_PLATFORM, "Android");
            jSONObject3.put("app", i.d().i());
            jSONObject3.put(com.baidu.android.imsdk.internal.Constants.KEY_DEVICE_ID, k.a(p.a()));
            com.bytedance.sdk.openadsdk.utils.c a2 = com.bytedance.sdk.openadsdk.utils.d.a(p.a());
            JSONObject jSONObject4 = new JSONObject();
            if (a2 != null) {
                jSONObject4.put("longitude", a2.f30083b);
                jSONObject4.put("latitude", a2.f30082a);
            }
            jSONObject3.put("location", jSONObject4);
            JSONArray jSONArray = new JSONArray();
            for (d dVar : list) {
                if (dVar != null) {
                    jSONArray.put(dVar.a());
                }
            }
            jSONObject3.put(NotificationCompat.WearableExtender.KEY_PAGES, jSONArray);
            if (jSONObject != null) {
                jSONObject3.put("extra_info", jSONObject);
                u.b("extra_info", "back extra info:" + jSONObject.toString());
            }
            String a3 = com.bytedance.sdk.openadsdk.core.a.a(ak.i(jSONObject3.toString()), b.c());
            jSONObject2.put("content", a3);
            u.f("StatsLogManager", "html content:" + a3);
        } catch (Exception unused) {
        }
        return jSONObject2;
    }

    public void a(Activity activity) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("page_name", activity.getClass().getName());
            al.a(jSONObject);
            String jSONObject2 = jSONObject.toString();
            c b2 = c.b().a("delegate_on_create").b(jSONObject2);
            u.b("StatsLogManager", "delegate_on_create: " + jSONObject2);
            p.i().a(b2, false);
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(String str, int i) {
        com.bytedance.sdk.openadsdk.core.d a2 = com.bytedance.sdk.openadsdk.core.d.a(p.a());
        boolean z = false;
        int b2 = a2.b(str, 0);
        z = ((b2 & 2) == 0 || (b2 & 1) != i) ? true : true;
        if (z) {
            a2.a(str, i + 2);
        }
        return z;
    }

    public void a(boolean z, String[] strArr) {
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
        p.i().a(c.b().a("download_permission").c(System.currentTimeMillis() / 1000).b(jSONObject.toString()));
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        p.i().a(c.b().a("app_env").c(System.currentTimeMillis() / 1000).b(jSONObject.toString()));
    }

    public void a(@NonNull final List<d> list, @NonNull final l lVar, final JSONObject jSONObject) {
        if (list == null || list.size() == 0 || lVar == null) {
            return;
        }
        e.a(new g("upLoadHtmlInfo") { // from class: com.bytedance.sdk.openadsdk.h.a.3
            @Override // java.lang.Runnable
            public void run() {
                if (!p.h().u() || x.c(p.a()) == 4) {
                    p.f().a(a.this.b(list, lVar, jSONObject), 1);
                }
            }
        }, 5);
    }

    public void a(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str) || jSONObject == null) {
            return;
        }
        p.i().a(c.b().a(str).b(jSONObject.toString()), false);
    }
}
