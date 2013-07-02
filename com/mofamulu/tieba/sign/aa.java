package com.mofamulu.tieba.sign;

import java.util.Date;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class aa {
    private String a;
    private String b;
    private String c;
    private Date d;
    private String e;

    public aa() {
    }

    public aa(Cookie cookie) {
        this.a = cookie.getName();
        this.b = cookie.getValue();
        this.d = cookie.getExpiryDate();
        this.c = cookie.getDomain();
        this.e = cookie.getPath();
    }

    public aa(JSONObject jSONObject) {
        this.a = jSONObject.optString("name");
        this.b = jSONObject.optString("value");
        long optLong = jSONObject.optLong("ed", 0L);
        if (optLong > 1000) {
            this.d = new Date(optLong);
        }
        this.c = jSONObject.optString("domain");
        this.e = jSONObject.optString("path");
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", this.a);
            jSONObject.put("value", this.b);
            jSONObject.put("domain", this.c);
            jSONObject.put("ed", this.d == null ? 0L : this.d.getTime());
            jSONObject.put("path", this.e);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public BasicClientCookie b() {
        BasicClientCookie basicClientCookie = new BasicClientCookie(this.a, this.b);
        basicClientCookie.setExpiryDate(this.d);
        basicClientCookie.setDomain(this.c);
        basicClientCookie.setPath(this.e);
        return basicClientCookie;
    }
}
