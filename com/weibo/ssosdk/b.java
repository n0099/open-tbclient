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
    private String krg = "";
    private String from = "";
    private String krh = "";
    private String kri = "";
    private String krj = "";
    private String krk = "";
    private HashMap<String, String> extra = new HashMap<>();

    private String Ig(String str) {
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }

    public String sK(boolean z) {
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
            return Ig(jSONObject.toString());
        }
        return jSONObject.toString();
    }

    public String sL(boolean z) {
        return z ? Ig(this.krj) : this.krj;
    }

    public String sM(boolean z) {
        return z ? Ig(this.krh) : this.krh;
    }

    public void Ih(String str) {
        this.krh = str;
    }

    public String sN(boolean z) {
        return z ? Ig(this.kri) : this.kri;
    }

    public String sO(boolean z) {
        return z ? Ig(this.from) : this.from;
    }

    public void setFrom(String str) {
        this.from = str;
    }

    public String sP(boolean z) {
        return z ? Ig(this.appKey) : this.appKey;
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

    public String sQ(boolean z) {
        return z ? Ig(this.krg) : this.krg;
    }

    public boolean cNl() {
        return (this.appContext == null || TextUtils.isEmpty(this.appKey) || TextUtils.isEmpty(this.from) || TextUtils.isEmpty(this.krh)) ? false : true;
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
