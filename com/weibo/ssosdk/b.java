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
    private String okO = "";
    private String from = "";
    private String okP = "";
    private String okQ = "";
    private String okR = "";
    private String okS = "";
    private HashMap<String, String> extra = new HashMap<>();

    private String VJ(String str) {
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }

    public String yG(boolean z) {
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

    public String yH(boolean z) {
        return z ? VJ(this.okR) : this.okR;
    }

    public String yI(boolean z) {
        return z ? VJ(this.okP) : this.okP;
    }

    public void VK(String str) {
        this.okP = str;
    }

    public String yJ(boolean z) {
        return z ? VJ(this.okQ) : this.okQ;
    }

    public String yK(boolean z) {
        return z ? VJ(this.from) : this.from;
    }

    public void setFrom(String str) {
        this.from = str;
    }

    public String yL(boolean z) {
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

    public String yM(boolean z) {
        return z ? VJ(this.okO) : this.okO;
    }

    public boolean eeu() {
        return (this.appContext == null || TextUtils.isEmpty(this.appKey) || TextUtils.isEmpty(this.from) || TextUtils.isEmpty(this.okP)) ? false : true;
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
