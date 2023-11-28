package com.kwad.sdk.collector;

import android.text.TextUtils;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class g {
    public static int PERMISSION_DENIED = 2;
    public static int PERMISSION_GRANTED = 1;
    public static int amZ;
    public String amY;
    public int state;

    public g(String str, int i) {
        this.state = amZ;
        this.amY = str;
        this.state = i;
    }

    public static JSONArray r(List<g> list) {
        JSONArray jSONArray = new JSONArray();
        if (list == null) {
            return jSONArray;
        }
        for (g gVar : list) {
            jSONArray.put(gVar.toJson());
        }
        return jSONArray;
    }

    private JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", zE());
            jSONObject.put("state", this.state);
        } catch (JSONException e) {
            com.kwad.sdk.core.e.c.printStackTrace(e);
        }
        return jSONObject;
    }

    private String zE() {
        int lastIndexOf;
        String str = this.amY;
        if (!TextUtils.isEmpty(str)) {
            if ((str.startsWith("com.android.") || str.startsWith("android.permission")) && (lastIndexOf = str.lastIndexOf(".")) < str.length() - 1) {
                return str.substring(lastIndexOf + 1);
            }
            return str;
        }
        return str;
    }
}
