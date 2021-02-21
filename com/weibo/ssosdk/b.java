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
    private String qji = "";
    private String from = "";
    private String qjj = "";
    private String qjk = "";
    private String qjl = "";
    private String qjm = "";
    private HashMap<String, String> extra = new HashMap<>();

    private String abO(String str) {
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }

    public String CP(boolean z) {
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
            return abO(jSONObject.toString());
        }
        return jSONObject.toString();
    }

    public String CQ(boolean z) {
        return z ? abO(this.qjl) : this.qjl;
    }

    public String CR(boolean z) {
        return z ? abO(this.qjj) : this.qjj;
    }

    public void abP(String str) {
        this.qjj = str;
    }

    public String CS(boolean z) {
        return z ? abO(this.qjk) : this.qjk;
    }

    public String CT(boolean z) {
        return z ? abO(this.from) : this.from;
    }

    public void setFrom(String str) {
        this.from = str;
    }

    public String CU(boolean z) {
        return z ? abO(this.appKey) : this.appKey;
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

    public String CV(boolean z) {
        return z ? abO(this.qji) : this.qji;
    }

    public boolean eIV() {
        return (this.appContext == null || TextUtils.isEmpty(this.appKey) || TextUtils.isEmpty(this.from) || TextUtils.isEmpty(this.qjj)) ? false : true;
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
