package com.qq.e.comm.plugin.ad;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private boolean f12185a;

    /* renamed from: b  reason: collision with root package name */
    private int f12186b;
    private int c;
    private int d;
    private int e;
    private String f;

    public f(boolean z, int i, int i2, int i3, int i4, String str) {
        this.f12185a = z;
        this.f12186b = i;
        this.c = i2;
        this.d = i3;
        this.e = i4;
        this.f = str;
    }

    public Object a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.putOpt("width", Integer.valueOf(this.f12186b));
        jSONObject.putOpt("height", Integer.valueOf(this.c));
        jSONObject.putOpt("visibleWidth", Integer.valueOf(this.d));
        jSONObject.putOpt("visibleHeight", Integer.valueOf(this.e));
        jSONObject.putOpt("description", this.f);
        return jSONObject;
    }
}
