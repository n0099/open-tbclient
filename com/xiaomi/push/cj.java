package com.xiaomi.push;

import android.os.Bundle;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class cj {
    public int a;

    /* renamed from: a  reason: collision with other field name */
    public long f168a;

    /* renamed from: a  reason: collision with other field name */
    private String f169a;
    public int b;

    /* renamed from: b  reason: collision with other field name */
    public long f170b;
    public int c;
    public int d;
    public int e;
    public String h;

    public cj() {
    }

    public cj(cj cjVar) {
        this.f168a = cjVar.f168a;
        this.a = cjVar.a;
        this.h = cjVar.h;
        this.b = cjVar.b;
        this.c = cjVar.c;
        this.f170b = cjVar.f170b;
        this.d = cjVar.d;
        this.f169a = cjVar.f169a;
        this.e = cjVar.e;
    }

    public Bundle a() {
        Bundle bundle = new Bundle();
        bundle.putLong("id", this.f168a);
        bundle.putInt("showType", this.a);
        bundle.putInt("nonsense", this.b);
        bundle.putInt("receiveUpperBound", this.c);
        bundle.putLong("lastShowTime", this.f170b);
        bundle.putInt("multi", this.e);
        return bundle;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m195a() {
        return this.f169a;
    }

    public void a(String str) {
        this.f169a = str;
    }

    public void a(JSONObject jSONObject) {
        this.f168a = jSONObject.optLong("id");
        this.a = jSONObject.optInt("showType");
        this.b = jSONObject.optInt("nonsense");
        this.c = jSONObject.optInt("receiveUpperBound");
        this.f170b = jSONObject.optLong("lastShowTime");
        this.e = jSONObject.optInt("multi");
    }

    public String toString() {
        return "";
    }
}
