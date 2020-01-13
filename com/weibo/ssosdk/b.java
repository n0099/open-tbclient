package com.weibo.ssosdk;

import android.content.Context;
import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class b implements Cloneable {
    private Context appContext;
    private String appKey = "";
    private String nrs = "";
    private String from = "";
    private String nrt = "";
    private String nru = "";
    private String nrv = "";
    private String nrw = "";
    private HashMap<String, String> extra = new HashMap<>();

    private String Rr(String str) {
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }

    public String wt(boolean z) {
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
            return Rr(jSONObject.toString());
        }
        return jSONObject.toString();
    }

    public String wu(boolean z) {
        return z ? Rr(this.nrv) : this.nrv;
    }

    public String wv(boolean z) {
        return z ? Rr(this.nrt) : this.nrt;
    }

    public void Rs(String str) {
        this.nrt = str;
    }

    public String ww(boolean z) {
        return z ? Rr(this.nru) : this.nru;
    }

    public String wx(boolean z) {
        return z ? Rr(this.from) : this.from;
    }

    public void setFrom(String str) {
        this.from = str;
    }

    public String wy(boolean z) {
        return z ? Rr(this.appKey) : this.appKey;
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

    public String wz(boolean z) {
        return z ? Rr(this.nrs) : this.nrs;
    }

    public boolean dGL() {
        return (this.appContext == null || TextUtils.isEmpty(this.appKey) || TextUtils.isEmpty(this.from) || TextUtils.isEmpty(this.nrt)) ? false : true;
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
