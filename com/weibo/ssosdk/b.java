package com.weibo.ssosdk;

import android.content.Context;
import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes19.dex */
public class b implements Cloneable {
    private Context appContext;
    private String appKey = "";
    private String okw = "";
    private String from = "";
    private String okx = "";
    private String oky = "";
    private String okz = "";
    private String okA = "";
    private HashMap<String, String> extra = new HashMap<>();

    private String VJ(String str) {
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }

    public String yE(boolean z) {
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
            return VJ(jSONObject.toString());
        }
        return jSONObject.toString();
    }

    public String yF(boolean z) {
        return z ? VJ(this.okz) : this.okz;
    }

    public String yG(boolean z) {
        return z ? VJ(this.okx) : this.okx;
    }

    public void VK(String str) {
        this.okx = str;
    }

    public String yH(boolean z) {
        return z ? VJ(this.oky) : this.oky;
    }

    public String yI(boolean z) {
        return z ? VJ(this.from) : this.from;
    }

    public void setFrom(String str) {
        this.from = str;
    }

    public String yJ(boolean z) {
        return z ? VJ(this.appKey) : this.appKey;
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

    public String yK(boolean z) {
        return z ? VJ(this.okw) : this.okw;
    }

    public boolean eel() {
        return (this.appContext == null || TextUtils.isEmpty(this.appKey) || TextUtils.isEmpty(this.from) || TextUtils.isEmpty(this.okx)) ? false : true;
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
