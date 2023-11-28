package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdMatrixInfo;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class ff implements com.kwad.sdk.core.d<AdMatrixInfo.InstalledActivateInfo> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(AdMatrixInfo.InstalledActivateInfo installedActivateInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        installedActivateInfo.cardSwitch = jSONObject.optBoolean("cardSwitch");
        installedActivateInfo.showTime = jSONObject.optLong("showTime");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(AdMatrixInfo.InstalledActivateInfo installedActivateInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z = installedActivateInfo.cardSwitch;
        if (z) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "cardSwitch", z);
        }
        long j = installedActivateInfo.showTime;
        if (j != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "showTime", j);
        }
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdMatrixInfo.InstalledActivateInfo installedActivateInfo, JSONObject jSONObject) {
        a2(installedActivateInfo, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdMatrixInfo.InstalledActivateInfo installedActivateInfo, JSONObject jSONObject) {
        return b2(installedActivateInfo, jSONObject);
    }
}
