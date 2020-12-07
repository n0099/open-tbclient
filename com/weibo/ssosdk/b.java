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
    private String pDm = "";
    private String from = "";
    private String pDn = "";
    private String pDo = "";
    private String pDp = "";
    private String pDq = "";
    private HashMap<String, String> extra = new HashMap<>();

    private String ZY(String str) {
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }

    public String Bj(boolean z) {
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
            return ZY(jSONObject.toString());
        }
        return jSONObject.toString();
    }

    public String Bk(boolean z) {
        return z ? ZY(this.pDp) : this.pDp;
    }

    public String Bl(boolean z) {
        return z ? ZY(this.pDn) : this.pDn;
    }

    public void ZZ(String str) {
        this.pDn = str;
    }

    public String Bm(boolean z) {
        return z ? ZY(this.pDo) : this.pDo;
    }

    public String Bn(boolean z) {
        return z ? ZY(this.from) : this.from;
    }

    public void setFrom(String str) {
        this.from = str;
    }

    public String Bo(boolean z) {
        return z ? ZY(this.appKey) : this.appKey;
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

    public String Bp(boolean z) {
        return z ? ZY(this.pDm) : this.pDm;
    }

    public boolean eCo() {
        return (this.appContext == null || TextUtils.isEmpty(this.appKey) || TextUtils.isEmpty(this.from) || TextUtils.isEmpty(this.pDn)) ? false : true;
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
