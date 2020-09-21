package com.weibo.ssosdk;

import android.content.Context;
import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class b implements Cloneable {
    private Context appContext;
    private String appKey = "";
    private String ouz = "";
    private String from = "";
    private String ouA = "";
    private String ouB = "";
    private String ouC = "";
    private String ouD = "";
    private HashMap<String, String> extra = new HashMap<>();

    private String Wl(String str) {
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }

    public String yO(boolean z) {
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
            return Wl(jSONObject.toString());
        }
        return jSONObject.toString();
    }

    public String yP(boolean z) {
        return z ? Wl(this.ouC) : this.ouC;
    }

    public String yQ(boolean z) {
        return z ? Wl(this.ouA) : this.ouA;
    }

    public void Wm(String str) {
        this.ouA = str;
    }

    public String yR(boolean z) {
        return z ? Wl(this.ouB) : this.ouB;
    }

    public String yS(boolean z) {
        return z ? Wl(this.from) : this.from;
    }

    public void setFrom(String str) {
        this.from = str;
    }

    public String yT(boolean z) {
        return z ? Wl(this.appKey) : this.appKey;
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

    public String yU(boolean z) {
        return z ? Wl(this.ouz) : this.ouz;
    }

    public boolean eir() {
        return (this.appContext == null || TextUtils.isEmpty(this.appKey) || TextUtils.isEmpty(this.from) || TextUtils.isEmpty(this.ouA)) ? false : true;
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
