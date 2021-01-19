package com.ss.android.downloadlib.b;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ss.android.a.a.d.b;
import com.ss.android.downloadlib.a.b.d;
import com.ss.android.downloadlib.a.b.e;
import com.ss.android.downloadlib.a.j;
import com.ss.android.downloadlib.f.f;
import com.ss.android.downloadlib.f.i;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    public static boolean b(@NonNull d.a aVar) {
        e eVar;
        b eBE = aVar.pQW.eBE();
        String a2 = eBE == null ? null : eBE.a();
        e ZK = f.ZK(a2);
        if (ZK.a() == 2) {
            if (!TextUtils.isEmpty(a2)) {
                com.ss.android.downloadlib.e.a.eCL().a("deeplink_url_open_fail", a(a2), aVar);
            }
            eVar = f.bC(j.a(), aVar.pQW.v());
        } else {
            eVar = ZK;
        }
        if (a(aVar.f12938a) && j.i().optInt("link_ad_click_event", 1) == 1) {
            com.ss.android.downloadlib.e.a.eCL().a(aVar.f12938a, 0);
        }
        switch (eVar.a()) {
            case 1:
                com.ss.android.downloadlib.e.a.eCL().a("deeplink_url_open", aVar);
                j.eCn().a(j.a(), aVar.pQW, aVar.pQY, aVar.pQX, aVar.pQW.v());
                return true;
            case 2:
            default:
                i.b();
                return false;
            case 3:
                com.ss.android.downloadlib.e.a.eCL().a("deeplink_app_open", aVar);
                j.eCn().a(j.a(), aVar.pQW, aVar.pQY, aVar.pQX, aVar.pQW.v());
                return true;
            case 4:
                com.ss.android.downloadlib.e.a.eCL().a("deeplink_app_open_fail", aVar);
                return false;
        }
    }

    public static void d(@NonNull com.ss.android.b.a.b.a aVar) {
        String A = aVar.A();
        e ZK = f.ZK(A);
        if (ZK.a() == 2) {
            if (!TextUtils.isEmpty(A)) {
                com.ss.android.downloadlib.e.a.eCL().a("deeplink_url_open_fail", a(A), aVar);
            }
            ZK = f.bC(j.a(), aVar.m());
        }
        switch (ZK.a()) {
            case 1:
                com.ss.android.downloadlib.e.a.eCL().a("download_notification", "deeplink_url_open", aVar);
                j.eCn().a(j.a(), aVar.eBU(), aVar.eBW(), aVar.eBV(), aVar.m());
                return;
            case 2:
            default:
                i.b();
                return;
            case 3:
                com.ss.android.downloadlib.e.a.eCL().a("download_notification", "deeplink_app_open", aVar);
                j.eCn().a(j.a(), aVar.eBU(), aVar.eBW(), aVar.eBV(), aVar.m());
                return;
            case 4:
                com.ss.android.downloadlib.e.a.eCL().a("deeplink_app_open_fail", aVar);
                return;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static void a(com.ss.android.b.a.b.a aVar) {
        e eVar;
        if (aVar != null) {
            String A = com.ss.android.socialbase.downloader.k.a.eGg().b("app_link_opt") == 1 ? aVar.A() : null;
            e ZK = f.ZK(A);
            if (ZK.a() == 2) {
                if (!TextUtils.isEmpty(A)) {
                    com.ss.android.downloadlib.e.a.eCL().a("deeplink_url_open_fail", a(A), aVar);
                }
                eVar = f.bC(j.a(), aVar.m());
            } else {
                eVar = ZK;
            }
            switch (eVar.a()) {
                case 1:
                case 3:
                    com.ss.android.downloadlib.e.a.eCL().a("market_openapp_success", aVar);
                    j.eCn().a(j.a(), aVar.eBU(), aVar.eBW(), aVar.eBV(), aVar.m());
                    return;
                case 4:
                    com.ss.android.downloadlib.e.a.eCL().a("deeplink_app_open_fail", aVar);
                    break;
            }
            i.b();
            j.eCo().a(4, j.a(), aVar.eBU(), "应用打开失败，请检查是否安装", null, 1);
            com.ss.android.downloadlib.e.a.eCL().a("market_openapp_failed", aVar);
        }
    }

    public static boolean a(@NonNull d.a aVar, int i) {
        com.ss.android.downloadlib.e.a.eCL().a("market_click_open", aVar);
        e bA = f.bA(j.a(), aVar.pQW.v());
        switch (bA.a()) {
            case 5:
                com.ss.android.downloadlib.e.a.eCL().a(aVar.f12938a, i);
                com.ss.android.downloadlib.e.a.eCL().a("market_open_success", aVar);
                j.eCn().a(j.a(), aVar.pQW, aVar.pQY, aVar.pQX, aVar.pQW.v());
                com.ss.android.b.a.b.a aVar2 = new com.ss.android.b.a.b.a(aVar.pQW, aVar.pQX, aVar.pQY);
                aVar2.e(2);
                aVar2.f(System.currentTimeMillis());
                aVar2.h(4);
                d.eCc().d(aVar2);
                return true;
            case 6:
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("error_code", Integer.valueOf(bA.b()));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                com.ss.android.downloadlib.e.a.eCL().a("market_open_failed", jSONObject, aVar);
                return false;
            default:
                return false;
        }
    }

    public static boolean b(String str, @NonNull com.ss.android.b.a.b.a aVar) {
        if (com.ss.android.downloadlib.a.i.b(aVar.D()) && !TextUtils.isEmpty(aVar.A())) {
            com.ss.android.socialbase.downloader.notification.b.eGk().f(aVar.t());
            com.ss.android.downloadlib.e.a.eCL().a("deeplink_url_app", aVar);
            switch (f.ZK(aVar.A()).a()) {
                case 1:
                case 3:
                    com.ss.android.downloadlib.e.a.eCL().a("deeplink_open_success", aVar);
                    j.eCn().a(j.a(), aVar.eBU(), null, null, str);
                    return true;
                case 2:
                default:
                    com.ss.android.downloadlib.e.a.eCL().a("deeplink_open_fail", aVar);
                    return false;
            }
        }
        return false;
    }

    public static boolean a(long j) {
        return d.eCc().jb(j) == null;
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
