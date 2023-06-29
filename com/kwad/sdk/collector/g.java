package com.kwad.sdk.collector;

import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class g {
    public static int PERMISSION_DENIED = 2;
    public static int PERMISSION_GRANTED = 1;
    public static int SP;
    public String SO;
    public int state;

    public g(String str, int i) {
        this.state = SP;
        this.SO = str;
        this.state = i;
    }

    public static JSONArray l(List<g> list) {
        JSONArray jSONArray = new JSONArray();
        if (list == null) {
            return jSONArray;
        }
        for (g gVar : list) {
            jSONArray.put(gVar.toJson());
        }
        return jSONArray;
    }

    private String rs() {
        int lastIndexOf;
        String str = this.SO;
        return ((str.startsWith("com.android.") || this.SO.startsWith("android.permission")) && (lastIndexOf = this.SO.lastIndexOf(".")) < this.SO.length() + (-1)) ? this.SO.substring(lastIndexOf + 1) : str;
    }

    private JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", rs());
            jSONObject.put("state", this.state);
        } catch (JSONException e) {
            com.kwad.sdk.core.e.b.printStackTrace(e);
        }
        return jSONObject;
    }
}
