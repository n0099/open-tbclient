package com.qq.e.comm.plugin.util;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class u {

    /* renamed from: a  reason: collision with root package name */
    private JSONObject f12590a;

    public u() {
        this.f12590a = new JSONObject();
    }

    public u(String str) {
        JSONObject jSONObject;
        if (str != null) {
            try {
                if (!str.trim().isEmpty() && !str.toLowerCase().equals("null")) {
                    jSONObject = new JSONObject(str);
                    this.f12590a = jSONObject;
                }
            } catch (JSONException e) {
                e.printStackTrace();
                this.f12590a = new JSONObject();
                return;
            }
        }
        jSONObject = new JSONObject();
        this.f12590a = jSONObject;
    }

    public u(JSONObject jSONObject) {
        if (jSONObject == null) {
            this.f12590a = new JSONObject();
        } else {
            this.f12590a = jSONObject;
        }
    }

    public u a(String str, int i) {
        try {
            if (!TextUtils.isEmpty(str)) {
                this.f12590a.put(str, i);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return this;
    }

    public u a(String str, long j) {
        try {
            if (!TextUtils.isEmpty(str)) {
                this.f12590a.put(str, j);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return this;
    }

    public u a(String str, Object obj) {
        try {
            if (!TextUtils.isEmpty(str) && obj != null) {
                this.f12590a.put(str, obj);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return this;
    }

    public u a(String str, String str2) {
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                this.f12590a.put(str, str2);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return this;
    }

    public JSONObject a() {
        return this.f12590a;
    }

    public String toString() {
        return this.f12590a.toString();
    }
}
