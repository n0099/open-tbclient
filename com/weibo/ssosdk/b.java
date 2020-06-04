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
    private String nma = "";
    private String from = "";
    private String wm = "";
    private String nmb = "";
    private String nmc = "";
    private String nmd = "";
    private HashMap<String, String> extra = new HashMap<>();

    private String Rh(String str) {
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }

    public String wM(boolean z) {
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
            return Rh(jSONObject.toString());
        }
        return jSONObject.toString();
    }

    public String wN(boolean z) {
        return z ? Rh(this.nmc) : this.nmc;
    }

    public String wO(boolean z) {
        return z ? Rh(this.wm) : this.wm;
    }

    public void Ri(String str) {
        this.wm = str;
    }

    public String wP(boolean z) {
        return z ? Rh(this.nmb) : this.nmb;
    }

    public String wQ(boolean z) {
        return z ? Rh(this.from) : this.from;
    }

    public void setFrom(String str) {
        this.from = str;
    }

    public String wR(boolean z) {
        return z ? Rh(this.appKey) : this.appKey;
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

    public String wS(boolean z) {
        return z ? Rh(this.nma) : this.nma;
    }

    public boolean dKc() {
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
