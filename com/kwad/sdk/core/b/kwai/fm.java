package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.scene.URLPackage;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class fm implements com.kwad.sdk.core.d<URLPackage> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(URLPackage uRLPackage, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        uRLPackage.page = jSONObject.optInt("page");
        uRLPackage.identity = jSONObject.optString("identity");
        if (jSONObject.opt("identity") == JSONObject.NULL) {
            uRLPackage.identity = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(URLPackage uRLPackage, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.r.a(jSONObject, "page", uRLPackage.page);
        com.kwad.sdk.utils.r.a(jSONObject, "identity", uRLPackage.identity);
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(URLPackage uRLPackage, JSONObject jSONObject) {
        a2(uRLPackage, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(URLPackage uRLPackage, JSONObject jSONObject) {
        return b2(uRLPackage, jSONObject);
    }
}
