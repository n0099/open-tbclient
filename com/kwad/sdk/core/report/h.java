package com.kwad.sdk.core.report;

import android.text.TextUtils;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes10.dex */
public final class h extends com.kwad.sdk.core.network.d {
    public String avx;

    public h(String str) {
        this.avx = "";
        this.avx = str;
    }

    public h(List<q> list) {
        this.avx = "";
        if (list != null && list.size() > 0) {
            JSONArray jSONArray = new JSONArray();
            for (q qVar : list) {
                com.kwad.sdk.utils.t.a(jSONArray, qVar.buildReportData());
            }
            putBody("actionList", jSONArray);
        }
    }

    @Override // com.kwad.sdk.core.network.b
    public final String getBodyParamsString() {
        String bodyParamsString = super.getBodyParamsString();
        try {
            if (TextUtils.isEmpty(this.avx)) {
                return bodyParamsString;
            }
            StringBuilder sb = new StringBuilder(bodyParamsString);
            sb.insert(sb.length() - 1, this.avx);
            return sb.toString();
        } catch (Exception e) {
            com.kwad.sdk.core.e.c.printStackTrace(e);
            return bodyParamsString;
        }
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final String getUrl() {
        return com.kwad.sdk.g.xP();
    }
}
