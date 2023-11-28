package com.kwad.sdk.core.b.a;

import com.kwad.sdk.ranger.a.a;
import com.vivo.push.PushClientConstants;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class hg implements com.kwad.sdk.core.d<a.C0725a> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(a.C0725a c0725a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0725a.aMb = jSONObject.optString("typeStr");
        if (JSONObject.NULL.toString().equals(c0725a.aMb)) {
            c0725a.aMb = "";
        }
        c0725a.aMc = jSONObject.optString("valueStr");
        if (JSONObject.NULL.toString().equals(c0725a.aMc)) {
            c0725a.aMc = "";
        }
        c0725a.aMd = jSONObject.optString("listValueType");
        if (JSONObject.NULL.toString().equals(c0725a.aMd)) {
            c0725a.aMd = "";
        }
        c0725a.aMe = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("valueStrList");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                c0725a.aMe.add((String) optJSONArray.opt(i));
            }
        }
        c0725a.fieldName = jSONObject.optString("fieldName");
        if (JSONObject.NULL.toString().equals(c0725a.fieldName)) {
            c0725a.fieldName = "";
        }
        c0725a.className = jSONObject.optString(PushClientConstants.TAG_CLASS_NAME);
        if (JSONObject.NULL.toString().equals(c0725a.className)) {
            c0725a.className = "";
        }
        c0725a.aMf = new ArrayList();
        JSONArray optJSONArray2 = jSONObject.optJSONArray("childParamList");
        if (optJSONArray2 != null) {
            for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                a.C0725a c0725a2 = new a.C0725a();
                c0725a2.parseJson(optJSONArray2.optJSONObject(i2));
                c0725a.aMf.add(c0725a2);
            }
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(a.C0725a c0725a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = c0725a.aMb;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "typeStr", c0725a.aMb);
        }
        String str2 = c0725a.aMc;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "valueStr", c0725a.aMc);
        }
        String str3 = c0725a.aMd;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "listValueType", c0725a.aMd);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "valueStrList", c0725a.aMe);
        String str4 = c0725a.fieldName;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "fieldName", c0725a.fieldName);
        }
        String str5 = c0725a.className;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, PushClientConstants.TAG_CLASS_NAME, c0725a.className);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "childParamList", c0725a.aMf);
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(a.C0725a c0725a, JSONObject jSONObject) {
        a2(c0725a, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(a.C0725a c0725a, JSONObject jSONObject) {
        return b2(c0725a, jSONObject);
    }
}
