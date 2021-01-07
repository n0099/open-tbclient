package com.ss.android.downloadlib;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d implements com.ss.android.socialbase.downloader.h.b {
    @Override // com.ss.android.socialbase.downloader.h.b
    public void a(com.ss.android.socialbase.downloader.g.c cVar, String str, JSONObject jSONObject) {
        com.ss.android.b.a.b.a j = com.ss.android.downloadlib.a.b.d.eFT().j(cVar);
        if (j != null) {
            if ("install_view_result".equals(str)) {
                jSONObject = com.ss.android.downloadlib.f.i.a(jSONObject);
                b.a(jSONObject, cVar, false);
                try {
                    jSONObject.put("model_id", com.ss.android.downloadlib.f.i.C(new JSONObject(cVar.C()), "extra"));
                } catch (Exception e) {
                }
            }
            com.ss.android.downloadlib.e.a.eGB().a(str, jSONObject, j);
        }
    }
}
