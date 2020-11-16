package com.weibo.ssosdk;

import android.content.Context;
import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes12.dex */
public class b implements Cloneable {
    private Context appContext;
    private String appKey = "";
    private String pMi = "";
    private String from = "";
    private String pMj = "";
    private String pMk = "";
    private String pMl = "";
    private String pMm = "";
    private HashMap<String, String> extra = new HashMap<>();

    private String Zb(String str) {
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }

    public String AV(boolean z) {
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
            return Zb(jSONObject.toString());
        }
        return jSONObject.toString();
    }

    public String AW(boolean z) {
        return z ? Zb(this.pMl) : this.pMl;
    }

    public String AX(boolean z) {
        return z ? Zb(this.pMj) : this.pMj;
    }

    public void Zc(String str) {
        this.pMj = str;
    }

    public String AY(boolean z) {
        return z ? Zb(this.pMk) : this.pMk;
    }

    public String AZ(boolean z) {
        return z ? Zb(this.from) : this.from;
    }

    public void setFrom(String str) {
        this.from = str;
    }

    public String Ba(boolean z) {
        return z ? Zb(this.appKey) : this.appKey;
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

    public String Bb(boolean z) {
        return z ? Zb(this.pMi) : this.pMi;
    }

    public boolean ezS() {
        return (this.appContext == null || TextUtils.isEmpty(this.appKey) || TextUtils.isEmpty(this.from) || TextUtils.isEmpty(this.pMj)) ? false : true;
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
