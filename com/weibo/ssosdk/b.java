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
    private String qjY = "";
    private String from = "";
    private String qjZ = "";
    private String qka = "";
    private String qkb = "";
    private String qkc = "";
    private HashMap<String, String> extra = new HashMap<>();

    private String abT(String str) {
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }

    public String CN(boolean z) {
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
            return abT(jSONObject.toString());
        }
        return jSONObject.toString();
    }

    public String CO(boolean z) {
        return z ? abT(this.qkb) : this.qkb;
    }

    public String CP(boolean z) {
        return z ? abT(this.qjZ) : this.qjZ;
    }

    public void abU(String str) {
        this.qjZ = str;
    }

    public String CQ(boolean z) {
        return z ? abT(this.qka) : this.qka;
    }

    public String CR(boolean z) {
        return z ? abT(this.from) : this.from;
    }

    public void setFrom(String str) {
        this.from = str;
    }

    public String CS(boolean z) {
        return z ? abT(this.appKey) : this.appKey;
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

    public String CT(boolean z) {
        return z ? abT(this.qjY) : this.qjY;
    }

    public boolean eIW() {
        return (this.appContext == null || TextUtils.isEmpty(this.appKey) || TextUtils.isEmpty(this.from) || TextUtils.isEmpty(this.qjZ)) ? false : true;
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
