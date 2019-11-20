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
    private String kuw = "";
    private String from = "";
    private String kux = "";
    private String kuy = "";
    private String kuz = "";
    private String kuA = "";
    private HashMap<String, String> extra = new HashMap<>();

    private String GW(String str) {
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }

    public String st(boolean z) {
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
            return GW(jSONObject.toString());
        }
        return jSONObject.toString();
    }

    public String su(boolean z) {
        return z ? GW(this.kuz) : this.kuz;
    }

    public String sv(boolean z) {
        return z ? GW(this.kux) : this.kux;
    }

    public void GX(String str) {
        this.kux = str;
    }

    public String sw(boolean z) {
        return z ? GW(this.kuy) : this.kuy;
    }

    public String sx(boolean z) {
        return z ? GW(this.from) : this.from;
    }

    public void setFrom(String str) {
        this.from = str;
    }

    public String sy(boolean z) {
        return z ? GW(this.appKey) : this.appKey;
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

    public String sz(boolean z) {
        return z ? GW(this.kuw) : this.kuw;
    }

    public boolean cMx() {
        return (this.appContext == null || TextUtils.isEmpty(this.appKey) || TextUtils.isEmpty(this.from) || TextUtils.isEmpty(this.kux)) ? false : true;
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
