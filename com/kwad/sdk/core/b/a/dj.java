package com.kwad.sdk.core.b.a;

import com.baidu.searchbox.download.util.LocalFilesFilterKt;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class dj implements com.kwad.sdk.core.d<com.kwad.sdk.core.report.m> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(com.kwad.sdk.core.report.m mVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        mVar.avE = jSONObject.optString(LocalFilesFilterKt.FILTER_NAME_LOG);
        if (JSONObject.NULL.toString().equals(mVar.avE)) {
            mVar.avE = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(com.kwad.sdk.core.report.m mVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = mVar.avE;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, LocalFilesFilterKt.FILTER_NAME_LOG, mVar.avE);
        }
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.report.m mVar, JSONObject jSONObject) {
        a2(mVar, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.report.m mVar, JSONObject jSONObject) {
        return b2(mVar, jSONObject);
    }
}
