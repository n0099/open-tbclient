package com.weibo.ssosdk;

import android.content.Context;
import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b implements Cloneable {
    private Context appContext;
    private String appKey = "";
    private String kuF = "";
    private String from = "";
    private String kuG = "";
    private String kuH = "";
    private String kuI = "";
    private String kuJ = "";
    private HashMap<String, String> extra = new HashMap<>();

    private String IF(String str) {
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }

    public String sO(boolean z) {
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
            return IF(jSONObject.toString());
        }
        return jSONObject.toString();
    }

    public String sP(boolean z) {
        return z ? IF(this.kuI) : this.kuI;
    }

    public String sQ(boolean z) {
        return z ? IF(this.kuG) : this.kuG;
    }

    public void IG(String str) {
        this.kuG = str;
    }

    public String sR(boolean z) {
        return z ? IF(this.kuH) : this.kuH;
    }

    public String sS(boolean z) {
        return z ? IF(this.from) : this.from;
    }

    public void setFrom(String str) {
        this.from = str;
    }

    public String sT(boolean z) {
        return z ? IF(this.appKey) : this.appKey;
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

    public String sU(boolean z) {
        return z ? IF(this.kuF) : this.kuF;
    }

    public boolean cOs() {
        return (this.appContext == null || TextUtils.isEmpty(this.appKey) || TextUtils.isEmpty(this.from) || TextUtils.isEmpty(this.kuG)) ? false : true;
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
