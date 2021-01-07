package com.qq.e.comm.plugin.ab.b;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private final String f12020a;

    /* renamed from: b  reason: collision with root package name */
    private final String f12021b;
    private final String c;
    private final JSONObject d;
    private final String e;

    public d(String str, String str2, String str3, JSONObject jSONObject) {
        this(str, str2, str3, jSONObject, null);
    }

    public d(String str, String str2, String str3, JSONObject jSONObject, String str4) {
        this.f12020a = str;
        this.f12021b = str2;
        this.c = str3;
        this.d = jSONObject;
        this.e = str4;
    }

    public String a() {
        return this.f12020a;
    }

    public String b() {
        return this.f12021b;
    }

    public String c() {
        return this.c;
    }

    public JSONObject d() {
        return this.d;
    }

    public String e() {
        return this.e;
    }

    public String toString() {
        return "GDTJsRequest [service=" + this.f12020a + ", action=" + this.f12021b + ", callbackId=" + this.c + ", paraObj=" + this.d + ", multiActionPara:" + this.e + "]";
    }
}
