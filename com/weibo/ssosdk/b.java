package com.weibo.ssosdk;

import android.content.Context;
import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class b implements Cloneable {
    private Context appContext;
    private String appKey = "";
    private String oJO = "";
    private String from = "";
    private String oJP = "";
    private String oJQ = "";
    private String oJR = "";
    private String oJS = "";
    private HashMap<String, String> extra = new HashMap<>();

    private String WZ(String str) {
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }

    public String zv(boolean z) {
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
            return WZ(jSONObject.toString());
        }
        return jSONObject.toString();
    }

    public String zw(boolean z) {
        return z ? WZ(this.oJR) : this.oJR;
    }

    public String zx(boolean z) {
        return z ? WZ(this.oJP) : this.oJP;
    }

    public void Xa(String str) {
        this.oJP = str;
    }

    public String zy(boolean z) {
        return z ? WZ(this.oJQ) : this.oJQ;
    }

    public String zz(boolean z) {
        return z ? WZ(this.from) : this.from;
    }

    public void setFrom(String str) {
        this.from = str;
    }

    public String zA(boolean z) {
        return z ? WZ(this.appKey) : this.appKey;
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

    public String zB(boolean z) {
        return z ? WZ(this.oJO) : this.oJO;
    }

    public boolean emc() {
        return (this.appContext == null || TextUtils.isEmpty(this.appKey) || TextUtils.isEmpty(this.from) || TextUtils.isEmpty(this.oJP)) ? false : true;
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
