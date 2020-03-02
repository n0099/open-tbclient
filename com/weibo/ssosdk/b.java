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
    private String nsb = "";
    private String from = "";
    private String nsc = "";
    private String nsd = "";
    private String nse = "";
    private String nsf = "";
    private HashMap<String, String> extra = new HashMap<>();

    private String RC(String str) {
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }

    public String ww(boolean z) {
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
            return RC(jSONObject.toString());
        }
        return jSONObject.toString();
    }

    public String wx(boolean z) {
        return z ? RC(this.nse) : this.nse;
    }

    public String wy(boolean z) {
        return z ? RC(this.nsc) : this.nsc;
    }

    public void RD(String str) {
        this.nsc = str;
    }

    public String wz(boolean z) {
        return z ? RC(this.nsd) : this.nsd;
    }

    public String wA(boolean z) {
        return z ? RC(this.from) : this.from;
    }

    public void setFrom(String str) {
        this.from = str;
    }

    public String wB(boolean z) {
        return z ? RC(this.appKey) : this.appKey;
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

    public String wC(boolean z) {
        return z ? RC(this.nsb) : this.nsb;
    }

    public boolean dHW() {
        return (this.appContext == null || TextUtils.isEmpty(this.appKey) || TextUtils.isEmpty(this.from) || TextUtils.isEmpty(this.nsc)) ? false : true;
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
