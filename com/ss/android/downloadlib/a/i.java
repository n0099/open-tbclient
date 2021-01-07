package com.ss.android.downloadlib.a;

import android.content.Intent;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class i {
    public static boolean a(int i) {
        return i == 0 || i == 1;
    }

    public static boolean b(int i) {
        return i == 2 || i == 1;
    }

    public static boolean b(com.ss.android.a.a.b.c cVar) {
        return cVar.t() && (cVar instanceof com.ss.android.b.a.a.c) && cVar.A() == 1;
    }

    public static boolean e(com.ss.android.a.a.b.c cVar) {
        return cVar != null && cVar.A() == 2;
    }

    public static int a(@NonNull com.ss.android.a.a.b.c cVar, boolean z, com.ss.android.socialbase.appdownloader.f fVar) {
        if (fVar == null || TextUtils.isEmpty(fVar.c()) || fVar.b() == null) {
            return 0;
        }
        int a2 = com.ss.android.socialbase.appdownloader.d.eGM().a(fVar);
        com.ss.android.socialbase.downloader.k.a fl = com.ss.android.socialbase.downloader.k.a.fl(fVar.eHm());
        if (!a(fVar, fl) && cVar.k()) {
            String d = fl.d("download_start_toast_text");
            if (TextUtils.isEmpty(d)) {
                d = z ? "已开始下载，可在\"我的\"里查看管理" : "已开始下载";
            }
            j.eGf().a(2, fVar.b(), cVar, d, null, 0);
        }
        return a2;
    }

    private static boolean a(com.ss.android.socialbase.appdownloader.f fVar, @NonNull com.ss.android.socialbase.downloader.k.a aVar) {
        JSONObject jSONObject;
        if (aVar.c("show_unknown_source_on_startup")) {
            JSONArray abC = aVar.abC("anti_plans");
            int length = abC.length();
            int i = 0;
            while (true) {
                if (i < length) {
                    jSONObject = abC.optJSONObject(i);
                    if (jSONObject != null && "jump_unknown_source".equals(jSONObject.optString("type"))) {
                        break;
                    }
                    i++;
                } else {
                    jSONObject = null;
                    break;
                }
            }
            if (jSONObject != null) {
                return com.ss.android.socialbase.appdownloader.b.a(com.ss.android.socialbase.downloader.downloader.b.eHT(), (Intent) null, jSONObject, new com.ss.android.socialbase.appdownloader.a());
            }
            return false;
        }
        return false;
    }

    public static String m(com.ss.android.socialbase.downloader.g.c cVar) {
        if (cVar == null) {
            return null;
        }
        try {
            String C = cVar.C();
            if (TextUtils.isEmpty(C)) {
                return null;
            }
            return new JSONObject(C).optString("notification_jump_url", null);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
