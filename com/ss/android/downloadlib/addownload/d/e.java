package com.ss.android.downloadlib.addownload.d;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class e implements d {
    private long a(int i) {
        return com.ss.android.socialbase.downloader.g.a.a(i).a("pause_optimise_mistake_click_interval", 300);
    }

    private boolean b(int i) {
        if (com.ss.android.socialbase.downloader.g.a.a(i).a("pause_optimise_mistake_click_interval_switch", 0) != 1) {
            return false;
        }
        return true;
    }

    @Override // com.ss.android.downloadlib.addownload.d.d
    public boolean a(com.ss.android.downloadad.api.a.b bVar, int i, c cVar) {
        if (bVar == null || !b(bVar.s())) {
            return false;
        }
        if (System.currentTimeMillis() - bVar.T() > a(bVar.s())) {
            return false;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("pause_optimise_type", "mistake_click");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        com.ss.android.downloadlib.d.a.a().a("pause_optimise", jSONObject, bVar);
        return true;
    }
}
