package com.xiaomi.push;

import android.os.Bundle;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class ce {
    public int a;

    /* renamed from: a  reason: collision with other field name */
    public long f182a;

    /* renamed from: a  reason: collision with other field name */
    private String f183a;
    public int b;

    /* renamed from: b  reason: collision with other field name */
    public long f184b;
    public int c;
    public int d;
    public int e;
    public String h;

    public ce() {
    }

    public ce(ce ceVar) {
        this.f182a = ceVar.f182a;
        this.a = ceVar.a;
        this.h = ceVar.h;
        this.b = ceVar.b;
        this.c = ceVar.c;
        this.f184b = ceVar.f184b;
        this.d = ceVar.d;
        this.f183a = ceVar.f183a;
        this.e = ceVar.e;
    }

    public Bundle a() {
        Bundle bundle = new Bundle();
        bundle.putLong("id", this.f182a);
        bundle.putInt("showType", this.a);
        bundle.putInt("nonsense", this.b);
        bundle.putInt("receiveUpperBound", this.c);
        bundle.putLong("lastShowTime", this.f184b);
        bundle.putInt("multi", this.e);
        return bundle;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m178a() {
        return this.f183a;
    }

    public void a(String str) {
        this.f183a = str;
    }

    public void a(JSONObject jSONObject) {
        this.f182a = jSONObject.optLong("id");
        this.a = jSONObject.optInt("showType");
        this.b = jSONObject.optInt("nonsense");
        this.c = jSONObject.optInt("receiveUpperBound");
        this.f184b = jSONObject.optLong("lastShowTime");
        this.e = jSONObject.optInt("multi");
    }

    public String toString() {
        return "";
    }
}
