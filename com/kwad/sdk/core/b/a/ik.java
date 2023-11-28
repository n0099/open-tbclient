package com.kwad.sdk.core.b.a;

import com.baidu.cyberplayer.sdk.config.CyberCfgManager;
import com.kwad.sdk.i.b;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class ik implements com.kwad.sdk.core.d<b.C0722b> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(b.C0722b c0722b, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0722b.aHW = jSONObject.optInt(CyberCfgManager.KEY_INT_ENABLE_MONITOR);
        c0722b.aHX = jSONObject.optString("c_sc_name");
        if (JSONObject.NULL.toString().equals(c0722b.aHX)) {
            c0722b.aHX = "";
        }
        c0722b.aHY = jSONObject.optString("c_pcl_name");
        if (JSONObject.NULL.toString().equals(c0722b.aHY)) {
            c0722b.aHY = "";
        }
        c0722b.aHZ = jSONObject.optString("m_gam_name");
        if (JSONObject.NULL.toString().equals(c0722b.aHZ)) {
            c0722b.aHZ = "";
        }
        c0722b.aIa = jSONObject.optString("m_gsv_name");
        if (JSONObject.NULL.toString().equals(c0722b.aIa)) {
            c0722b.aIa = "";
        }
        c0722b.aIb = jSONObject.optString("m_gpv_name");
        if (JSONObject.NULL.toString().equals(c0722b.aIb)) {
            c0722b.aIb = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(b.C0722b c0722b, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = c0722b.aHW;
        if (i != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, CyberCfgManager.KEY_INT_ENABLE_MONITOR, i);
        }
        String str = c0722b.aHX;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "c_sc_name", c0722b.aHX);
        }
        String str2 = c0722b.aHY;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "c_pcl_name", c0722b.aHY);
        }
        String str3 = c0722b.aHZ;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "m_gam_name", c0722b.aHZ);
        }
        String str4 = c0722b.aIa;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "m_gsv_name", c0722b.aIa);
        }
        String str5 = c0722b.aIb;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "m_gpv_name", c0722b.aIb);
        }
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(b.C0722b c0722b, JSONObject jSONObject) {
        a2(c0722b, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(b.C0722b c0722b, JSONObject jSONObject) {
        return b2(c0722b, jSONObject);
    }
}
