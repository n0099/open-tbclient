package com.kwad.sdk.core.b.a;

import com.kwad.sdk.i.a;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class df implements com.kwad.sdk.core.d<a.C0721a> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(a.C0721a c0721a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0721a.aHP = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("monitor_info_list");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                a.b bVar = new a.b();
                bVar.parseJson(optJSONArray.optJSONObject(i));
                c0721a.aHP.add(bVar);
            }
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(a.C0721a c0721a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "monitor_info_list", c0721a.aHP);
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(a.C0721a c0721a, JSONObject jSONObject) {
        a2(c0721a, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(a.C0721a c0721a, JSONObject jSONObject) {
        return b2(c0721a, jSONObject);
    }
}
