package com.ss.android.downloadlib.b;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ss.android.downloadlib.a.b.d;
import com.ss.android.downloadlib.a.b.e;
import com.ss.android.downloadlib.a.j;
import com.ss.android.downloadlib.f.f;
import com.ss.android.downloadlib.f.i;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a {
    public static boolean b(@NonNull d.a aVar) {
        e eVar;
        com.ss.android.a.a.d.b eEi = aVar.qco.eEi();
        String a2 = eEi == null ? null : eEi.a();
        e abc = f.abc(a2);
        if (abc.a() == 2) {
            if (!TextUtils.isEmpty(a2)) {
                com.ss.android.downloadlib.e.a.eFo().a("deeplink_url_open_fail", a(a2), aVar);
            }
            eVar = f.bz(j.a(), aVar.qco.v());
        } else {
            eVar = abc;
        }
        if (a(aVar.f7695a) && j.i().optInt("link_ad_click_event", 1) == 1) {
            com.ss.android.downloadlib.e.a.eFo().a(aVar.f7695a, 0);
        }
        switch (eVar.a()) {
            case 1:
                com.ss.android.downloadlib.e.a.eFo().a("deeplink_url_open", aVar);
                j.eEQ().a(j.a(), aVar.qco, aVar.qcq, aVar.qcp, aVar.qco.v());
                return true;
            case 2:
            default:
                i.b();
                return false;
            case 3:
                com.ss.android.downloadlib.e.a.eFo().a("deeplink_app_open", aVar);
                j.eEQ().a(j.a(), aVar.qco, aVar.qcq, aVar.qcp, aVar.qco.v());
                return true;
            case 4:
                com.ss.android.downloadlib.e.a.eFo().a("deeplink_app_open_fail", aVar);
                return false;
        }
    }

    public static void d(@NonNull com.ss.android.b.a.b.a aVar) {
        String A = aVar.A();
        e abc = f.abc(A);
        if (abc.a() == 2) {
            if (!TextUtils.isEmpty(A)) {
                com.ss.android.downloadlib.e.a.eFo().a("deeplink_url_open_fail", a(A), aVar);
            }
            abc = f.bz(j.a(), aVar.m());
        }
        switch (abc.a()) {
            case 1:
                com.ss.android.downloadlib.e.a.eFo().a("download_notification", "deeplink_url_open", aVar);
                j.eEQ().a(j.a(), aVar.eEx(), aVar.eEz(), aVar.eEy(), aVar.m());
                return;
            case 2:
            default:
                i.b();
                return;
            case 3:
                com.ss.android.downloadlib.e.a.eFo().a("download_notification", "deeplink_app_open", aVar);
                j.eEQ().a(j.a(), aVar.eEx(), aVar.eEz(), aVar.eEy(), aVar.m());
                return;
            case 4:
                com.ss.android.downloadlib.e.a.eFo().a("deeplink_app_open_fail", aVar);
                return;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static void a(com.ss.android.b.a.b.a aVar) {
        e eVar;
        if (aVar != null) {
            String A = com.ss.android.socialbase.downloader.k.a.eIH().b("app_link_opt") == 1 ? aVar.A() : null;
            e abc = f.abc(A);
            if (abc.a() == 2) {
                if (!TextUtils.isEmpty(A)) {
                    com.ss.android.downloadlib.e.a.eFo().a("deeplink_url_open_fail", a(A), aVar);
                }
                eVar = f.bz(j.a(), aVar.m());
            } else {
                eVar = abc;
            }
            switch (eVar.a()) {
                case 1:
                case 3:
                    com.ss.android.downloadlib.e.a.eFo().a("market_openapp_success", aVar);
                    j.eEQ().a(j.a(), aVar.eEx(), aVar.eEz(), aVar.eEy(), aVar.m());
                    return;
                case 4:
                    com.ss.android.downloadlib.e.a.eFo().a("deeplink_app_open_fail", aVar);
                    break;
            }
            i.b();
            j.eER().a(4, j.a(), aVar.eEx(), "应用打开失败，请检查是否安装", null, 1);
            com.ss.android.downloadlib.e.a.eFo().a("market_openapp_failed", aVar);
        }
    }

    public static boolean a(@NonNull d.a aVar, int i) {
        com.ss.android.downloadlib.e.a.eFo().a("market_click_open", aVar);
        e bx = f.bx(j.a(), aVar.qco.v());
        switch (bx.a()) {
            case 5:
                com.ss.android.downloadlib.e.a.eFo().a(aVar.f7695a, i);
                com.ss.android.downloadlib.e.a.eFo().a("market_open_success", aVar);
                j.eEQ().a(j.a(), aVar.qco, aVar.qcq, aVar.qcp, aVar.qco.v());
                com.ss.android.b.a.b.a aVar2 = new com.ss.android.b.a.b.a(aVar.qco, aVar.qcp, aVar.qcq);
                aVar2.e(2);
                aVar2.f(System.currentTimeMillis());
                aVar2.h(4);
                d.eEF().d(aVar2);
                return true;
            case 6:
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("error_code", Integer.valueOf(bx.b()));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                com.ss.android.downloadlib.e.a.eFo().a("market_open_failed", jSONObject, aVar);
                return false;
            default:
                return false;
        }
    }

    public static boolean b(String str, @NonNull com.ss.android.b.a.b.a aVar) {
        if (com.ss.android.downloadlib.a.i.b(aVar.D()) && !TextUtils.isEmpty(aVar.A())) {
            com.ss.android.socialbase.downloader.notification.b.eIK().f(aVar.t());
            com.ss.android.downloadlib.e.a.eFo().a("deeplink_url_app", aVar);
            switch (f.abc(aVar.A()).a()) {
                case 1:
                case 3:
                    com.ss.android.downloadlib.e.a.eFo().a("deeplink_open_success", aVar);
                    j.eEQ().a(j.a(), aVar.eEx(), null, null, str);
                    return true;
                case 2:
                default:
                    com.ss.android.downloadlib.e.a.eFo().a("deeplink_open_fail", aVar);
                    return false;
            }
        }
        return false;
    }

    public static boolean a(long j) {
        return d.eEF().je(j) == null;
    }

    private static JSONObject a(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("open_url", str);
        } catch (Exception e) {
        }
        return jSONObject;
    }
}
