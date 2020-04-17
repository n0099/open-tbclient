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
    private String mQK = "";
    private String from = "";
    private String wm = "";
    private String mQL = "";
    private String mQM = "";
    private String mQN = "";
    private HashMap<String, String> extra = new HashMap<>();

    private String Pn(String str) {
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }

    public String wm(boolean z) {
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
            return Pn(jSONObject.toString());
        }
        return jSONObject.toString();
    }

    public String wn(boolean z) {
        return z ? Pn(this.mQM) : this.mQM;
    }

    public String wo(boolean z) {
        return z ? Pn(this.wm) : this.wm;
    }

    public void Po(String str) {
        this.wm = str;
    }

    public String wp(boolean z) {
        return z ? Pn(this.mQL) : this.mQL;
    }

    public String wq(boolean z) {
        return z ? Pn(this.from) : this.from;
    }

    public void setFrom(String str) {
        this.from = str;
    }

    public String wr(boolean z) {
        return z ? Pn(this.appKey) : this.appKey;
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

    public String ws(boolean z) {
        return z ? Pn(this.mQK) : this.mQK;
    }

    public boolean dCz() {
        return (this.appContext == null || TextUtils.isEmpty(this.appKey) || TextUtils.isEmpty(this.from) || TextUtils.isEmpty(this.wm)) ? false : true;
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
