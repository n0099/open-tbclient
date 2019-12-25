package com.weibo.ssosdk;

import android.content.Context;
import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b implements Cloneable {
    private Context appContext;
    private String appKey = "";
    private String mPt = "";
    private String from = "";
    private String mPu = "";
    private String mPv = "";
    private String mPw = "";
    private String mPx = "";
    private HashMap<String, String> extra = new HashMap<>();

    private String QF(String str) {
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }

    public String vU(boolean z) {
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
            return QF(jSONObject.toString());
        }
        return jSONObject.toString();
    }

    public String vV(boolean z) {
        return z ? QF(this.mPw) : this.mPw;
    }

    public String vW(boolean z) {
        return z ? QF(this.mPu) : this.mPu;
    }

    public void QG(String str) {
        this.mPu = str;
    }

    public String vX(boolean z) {
        return z ? QF(this.mPv) : this.mPv;
    }

    public String vY(boolean z) {
        return z ? QF(this.from) : this.from;
    }

    public void setFrom(String str) {
        this.from = str;
    }

    public String vZ(boolean z) {
        return z ? QF(this.appKey) : this.appKey;
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

    public String wa(boolean z) {
        return z ? QF(this.mPt) : this.mPt;
    }

    public boolean dCG() {
        return (this.appContext == null || TextUtils.isEmpty(this.appKey) || TextUtils.isEmpty(this.from) || TextUtils.isEmpty(this.mPu)) ? false : true;
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
