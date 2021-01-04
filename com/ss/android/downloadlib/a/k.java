package com.ss.android.downloadlib.a;

import com.ss.android.socialbase.downloader.downloader.r;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class k implements r {
    @Override // com.ss.android.socialbase.downloader.downloader.r
    public void a(com.ss.android.socialbase.downloader.g.c cVar, int i, int i2) {
        com.ss.android.b.a.b.a j = com.ss.android.downloadlib.a.b.d.eFp().j(cVar);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("reserve_wifi_source", Integer.valueOf(i2));
            jSONObject.putOpt("reserve_wifi_status", Integer.valueOf(i));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        com.ss.android.downloadlib.e.a.eFX().a("pause_reserve_wifi", jSONObject, j);
    }
}
