package com.weibo.ssosdk;

import android.content.Context;
import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b implements Cloneable {
    private Context appContext;
    private String appKey = "";
    private String pYD = "";
    private String from = "";
    private String pYE = "";
    private String pYF = "";
    private String pYG = "";
    private String pYH = "";
    private HashMap<String, String> extra = new HashMap<>();

    private String aaA(String str) {
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }

    public String Cv(boolean z) {
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
            return aaA(jSONObject.toString());
        }
        return jSONObject.toString();
    }

    public String Cw(boolean z) {
        return z ? aaA(this.pYG) : this.pYG;
    }

    public String Cx(boolean z) {
        return z ? aaA(this.pYE) : this.pYE;
    }

    public void aaB(String str) {
        this.pYE = str;
    }

    public String Cy(boolean z) {
        return z ? aaA(this.pYF) : this.pYF;
    }

    public String Cz(boolean z) {
        return z ? aaA(this.from) : this.from;
    }

    public void setFrom(String str) {
        this.from = str;
    }

    public String CA(boolean z) {
        return z ? aaA(this.appKey) : this.appKey;
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

    public String CB(boolean z) {
        return z ? aaA(this.pYD) : this.pYD;
    }

    public boolean eGx() {
        return (this.appContext == null || TextUtils.isEmpty(this.appKey) || TextUtils.isEmpty(this.from) || TextUtils.isEmpty(this.pYE)) ? false : true;
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
