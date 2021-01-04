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
        b eER = aVar.pTO.eER();
        String a2 = eER == null ? null : eER.a();
        e aaQ = f.aaQ(a2);
        if (aaQ.a() == 2) {
            if (!TextUtils.isEmpty(a2)) {
                com.ss.android.downloadlib.e.a.eFX().a("deeplink_url_open_fail", a(a2), aVar);
            }
            eVar = f.bC(j.a(), aVar.pTO.v());
        } else {
            eVar = aaQ;
        }
        if (a(aVar.f13237a) && j.i().optInt("link_ad_click_event", 1) == 1) {
            com.ss.android.downloadlib.e.a.eFX().a(aVar.f13237a, 0);
        }
        switch (eVar.a()) {
            case 1:
                com.ss.android.downloadlib.e.a.eFX().a("deeplink_url_open", aVar);
                j.eFA().a(j.a(), aVar.pTO, aVar.pTQ, aVar.pTP, aVar.pTO.v());
                return true;
            case 2:
            default:
                i.b();
                return false;
            case 3:
                com.ss.android.downloadlib.e.a.eFX().a("deeplink_app_open", aVar);
                j.eFA().a(j.a(), aVar.pTO, aVar.pTQ, aVar.pTP, aVar.pTO.v());
                return true;
            case 4:
                com.ss.android.downloadlib.e.a.eFX().a("deeplink_app_open_fail", aVar);
                return false;
        }
    }

    public static void d(@NonNull com.ss.android.b.a.b.a aVar) {
        String A = aVar.A();
        e aaQ = f.aaQ(A);
        if (aaQ.a() == 2) {
            if (!TextUtils.isEmpty(A)) {
                com.ss.android.downloadlib.e.a.eFX().a("deeplink_url_open_fail", a(A), aVar);
            }
            aaQ = f.bC(j.a(), aVar.m());
        }
        switch (aaQ.a()) {
            case 1:
                com.ss.android.downloadlib.e.a.eFX().a("download_notification", "deeplink_url_open", aVar);
                j.eFA().a(j.a(), aVar.eFh(), aVar.eFj(), aVar.eFi(), aVar.m());
                return;
            case 2:
            default:
                i.b();
                return;
            case 3:
                com.ss.android.downloadlib.e.a.eFX().a("download_notification", "deeplink_app_open", aVar);
                j.eFA().a(j.a(), aVar.eFh(), aVar.eFj(), aVar.eFi(), aVar.m());
                return;
            case 4:
                com.ss.android.downloadlib.e.a.eFX().a("deeplink_app_open_fail", aVar);
                return;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static void a(com.ss.android.b.a.b.a aVar) {
        e eVar;
        if (aVar != null) {
            String A = com.ss.android.socialbase.downloader.k.a.eJs().b("app_link_opt") == 1 ? aVar.A() : null;
            e aaQ = f.aaQ(A);
            if (aaQ.a() == 2) {
                if (!TextUtils.isEmpty(A)) {
                    com.ss.android.downloadlib.e.a.eFX().a("deeplink_url_open_fail", a(A), aVar);
                }
                eVar = f.bC(j.a(), aVar.m());
            } else {
                eVar = aaQ;
            }
            switch (eVar.a()) {
                case 1:
                case 3:
                    com.ss.android.downloadlib.e.a.eFX().a("market_openapp_success", aVar);
                    j.eFA().a(j.a(), aVar.eFh(), aVar.eFj(), aVar.eFi(), aVar.m());
                    return;
                case 4:
                    com.ss.android.downloadlib.e.a.eFX().a("deeplink_app_open_fail", aVar);
                    break;
            }
            i.b();
            j.eFB().a(4, j.a(), aVar.eFh(), "应用打开失败，请检查是否安装", null, 1);
            com.ss.android.downloadlib.e.a.eFX().a("market_openapp_failed", aVar);
        }
    }

    public static boolean a(@NonNull d.a aVar, int i) {
        com.ss.android.downloadlib.e.a.eFX().a("market_click_open", aVar);
        e bA = f.bA(j.a(), aVar.pTO.v());
        switch (bA.a()) {
            case 5:
                com.ss.android.downloadlib.e.a.eFX().a(aVar.f13237a, i);
                com.ss.android.downloadlib.e.a.eFX().a("market_open_success", aVar);
                j.eFA().a(j.a(), aVar.pTO, aVar.pTQ, aVar.pTP, aVar.pTO.v());
                com.ss.android.b.a.b.a aVar2 = new com.ss.android.b.a.b.a(aVar.pTO, aVar.pTP, aVar.pTQ);
                aVar2.e(2);
                aVar2.f(System.currentTimeMillis());
                aVar2.h(4);
                d.eFp().d(aVar2);
                return true;
            case 6:
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("error_code", Integer.valueOf(bA.b()));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                com.ss.android.downloadlib.e.a.eFX().a("market_open_failed", jSONObject, aVar);
                return false;
            default:
                return false;
        }
    }

    public static boolean b(String str, @NonNull com.ss.android.b.a.b.a aVar) {
        if (com.ss.android.downloadlib.a.i.b(aVar.D()) && !TextUtils.isEmpty(aVar.A())) {
            com.ss.android.socialbase.downloader.notification.b.eJw().f(aVar.t());
            com.ss.android.downloadlib.e.a.eFX().a("deeplink_url_app", aVar);
            switch (f.aaQ(aVar.A()).a()) {
                case 1:
                case 3:
                    com.ss.android.downloadlib.e.a.eFX().a("deeplink_open_success", aVar);
                    j.eFA().a(j.a(), aVar.eFh(), null, null, str);
                    return true;
                case 2:
                default:
                    com.ss.android.downloadlib.e.a.eFX().a("deeplink_open_fail", aVar);
                    return false;
            }
        }
        return false;
    }

    public static boolean a(long j) {
        return d.eFp().iY(j) == null;
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
