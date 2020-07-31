package com.xiaomi.push;

import android.os.Bundle;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class cj {
    public int a;

    /* renamed from: a  reason: collision with other field name */
    public long f165a;

    /* renamed from: a  reason: collision with other field name */
    private String f166a;
    public int b;

    /* renamed from: b  reason: collision with other field name */
    public long f167b;
    public int c;
    public int d;
    public int e;
    public String h;

    public cj() {
    }

    public cj(cj cjVar) {
        this.f165a = cjVar.f165a;
        this.a = cjVar.a;
        this.h = cjVar.h;
        this.b = cjVar.b;
        this.c = cjVar.c;
        this.f167b = cjVar.f167b;
        this.d = cjVar.d;
        this.f166a = cjVar.f166a;
        this.e = cjVar.e;
    }

    public Bundle a() {
        Bundle bundle = new Bundle();
        bundle.putLong("id", this.f165a);
        bundle.putInt("showType", this.a);
        bundle.putInt("nonsense", this.b);
        bundle.putInt("receiveUpperBound", this.c);
        bundle.putLong("lastShowTime", this.f167b);
        bundle.putInt("multi", this.e);
        return bundle;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m196a() {
        return this.f166a;
    }

    public void a(String str) {
        this.f166a = str;
    }

    public void a(JSONObject jSONObject) {
        this.f165a = jSONObject.optLong("id");
        this.a = jSONObject.optInt("showType");
        this.b = jSONObject.optInt("nonsense");
        this.c = jSONObject.optInt("receiveUpperBound");
        this.f167b = jSONObject.optLong("lastShowTime");
        this.e = jSONObject.optInt("multi");
    }

    public String toString() {
        return "";
    }
}
