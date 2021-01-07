package com.xiaomi.push;

import android.os.Bundle;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class cj {

    /* renamed from: a  reason: collision with root package name */
    public int f14211a;

    /* renamed from: a  reason: collision with other field name */
    public long f243a;

    /* renamed from: a  reason: collision with other field name */
    private String f244a;

    /* renamed from: b  reason: collision with root package name */
    public int f14212b;

    /* renamed from: b  reason: collision with other field name */
    public long f245b;
    public int c;
    public int d;
    public int e;
    public String h;

    public cj() {
    }

    public cj(cj cjVar) {
        this.f243a = cjVar.f243a;
        this.f14211a = cjVar.f14211a;
        this.h = cjVar.h;
        this.f14212b = cjVar.f14212b;
        this.c = cjVar.c;
        this.f245b = cjVar.f245b;
        this.d = cjVar.d;
        this.f244a = cjVar.f244a;
        this.e = cjVar.e;
    }

    public Bundle a() {
        Bundle bundle = new Bundle();
        bundle.putLong("id", this.f243a);
        bundle.putInt("showType", this.f14211a);
        bundle.putInt("nonsense", this.f14212b);
        bundle.putInt("receiveUpperBound", this.c);
        bundle.putLong("lastShowTime", this.f245b);
        bundle.putInt("multi", this.e);
        return bundle;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m231a() {
        return this.f244a;
    }

    public void a(String str) {
        this.f244a = str;
    }

    public void a(JSONObject jSONObject) {
        this.f243a = jSONObject.optLong("id");
        this.f14211a = jSONObject.optInt("showType");
        this.f14212b = jSONObject.optInt("nonsense");
        this.c = jSONObject.optInt("receiveUpperBound");
        this.f245b = jSONObject.optLong("lastShowTime");
        this.e = jSONObject.optInt("multi");
    }

    public String toString() {
        return "";
    }
}
