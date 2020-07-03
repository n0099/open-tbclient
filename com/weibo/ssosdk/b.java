package com.weibo.ssosdk;

import android.content.Context;
import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b implements Cloneable {
    private Context appContext;
    private String appKey = "";
    private String nHP = "";
    private String from = "";
    private String wm = "";
    private String nHQ = "";
    private String nHR = "";
    private String nHS = "";
    private HashMap<String, String> extra = new HashMap<>();

    private String RT(String str) {
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }

    public String xh(boolean z) {
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
            return RT(jSONObject.toString());
        }
        return jSONObject.toString();
    }

    public String xi(boolean z) {
        return z ? RT(this.nHR) : this.nHR;
    }

    public String xj(boolean z) {
        return z ? RT(this.wm) : this.wm;
    }

    public void RU(String str) {
        this.wm = str;
    }

    public String xk(boolean z) {
        return z ? RT(this.nHQ) : this.nHQ;
    }

    public String xl(boolean z) {
        return z ? RT(this.from) : this.from;
    }

    public void setFrom(String str) {
        this.from = str;
    }

    public String xm(boolean z) {
        return z ? RT(this.appKey) : this.appKey;
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

    public String xn(boolean z) {
        return z ? RT(this.nHP) : this.nHP;
    }

    public boolean dOI() {
        return (this.appContext == null || TextUtils.isEmpty(this.appKey) || TextUtils.isEmpty(this.from) || TextUtils.isEmpty(this.wm)) ? false : true;
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
