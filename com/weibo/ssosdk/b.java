package com.weibo.ssosdk;

import android.content.Context;
import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b implements Cloneable {
    private Context appContext;
    private String appKey = "";
    private String qde = "";
    private String from = "";
    private String qdf = "";
    private String qdg = "";
    private String qdh = "";
    private String qdi = "";
    private HashMap<String, String> extra = new HashMap<>();

    private String abI(String str) {
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }

    public String Cz(boolean z) {
        if (this.extra.isEmpty()) {
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, String> entry : this.extra.entrySet()) {
            try {
                jSONObject.put(entry.getKey(), entry.getValue());
            } catch (JSONException e) {
                return "";
            }
        }
        if (z) {
            return abI(jSONObject.toString());
        }
        return jSONObject.toString();
    }

    public String CA(boolean z) {
        return z ? abI(this.qdh) : this.qdh;
    }

    public String CB(boolean z) {
        return z ? abI(this.qdf) : this.qdf;
    }

    public void abJ(String str) {
        this.qdf = str;
    }

    public String CC(boolean z) {
        return z ? abI(this.qdg) : this.qdg;
    }

    public String CD(boolean z) {
        return z ? abI(this.from) : this.from;
    }

    public void setFrom(String str) {
        this.from = str;
    }

    public String CE(boolean z) {
        return z ? abI(this.appKey) : this.appKey;
    }

    public void setAppKey(String str) {
        this.appKey = str;
    }

    public Context getApplicationContext() {
        return this.appContext;
    }

    public void setContext(Context context) {
        this.appContext = context.getApplicationContext();
    }

    public String CF(boolean z) {
        return z ? abI(this.qde) : this.qde;
    }

    public boolean eKn() {
        return (this.appContext == null || TextUtils.isEmpty(this.appKey) || TextUtils.isEmpty(this.from) || TextUtils.isEmpty(this.qdf)) ? false : true;
    }

    public Object clone() {
        try {
            b bVar = (b) super.clone();
            HashMap<String, String> hashMap = new HashMap<>();
            for (Map.Entry<String, String> entry : bVar.extra.entrySet()) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
            bVar.extra = hashMap;
            return bVar;
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}
