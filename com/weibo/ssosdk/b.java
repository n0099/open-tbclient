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
    private String pKF = "";
    private String from = "";
    private String pKG = "";
    private String pKH = "";
    private String pKI = "";
    private String pKJ = "";
    private HashMap<String, String> extra = new HashMap<>();

    private String Zq(String str) {
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }

    public String AO(boolean z) {
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
            return Zq(jSONObject.toString());
        }
        return jSONObject.toString();
    }

    public String AP(boolean z) {
        return z ? Zq(this.pKI) : this.pKI;
    }

    public String AQ(boolean z) {
        return z ? Zq(this.pKG) : this.pKG;
    }

    public void Zr(String str) {
        this.pKG = str;
    }

    public String AR(boolean z) {
        return z ? Zq(this.pKH) : this.pKH;
    }

    public String AS(boolean z) {
        return z ? Zq(this.from) : this.from;
    }

    public void setFrom(String str) {
        this.from = str;
    }

    public String AT(boolean z) {
        return z ? Zq(this.appKey) : this.appKey;
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

    public String AU(boolean z) {
        return z ? Zq(this.pKF) : this.pKF;
    }

    public boolean ezR() {
        return (this.appContext == null || TextUtils.isEmpty(this.appKey) || TextUtils.isEmpty(this.from) || TextUtils.isEmpty(this.pKG)) ? false : true;
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
