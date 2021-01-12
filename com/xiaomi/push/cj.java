package com.xiaomi.push;

import android.os.Bundle;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class cj {

    /* renamed from: a  reason: collision with root package name */
    public int f13911a;

    /* renamed from: a  reason: collision with other field name */
    public long f242a;

    /* renamed from: a  reason: collision with other field name */
    private String f243a;

    /* renamed from: b  reason: collision with root package name */
    public int f13912b;

    /* renamed from: b  reason: collision with other field name */
    public long f244b;
    public int c;
    public int d;
    public int e;
    public String h;

    public cj() {
    }

    public cj(cj cjVar) {
        this.f242a = cjVar.f242a;
        this.f13911a = cjVar.f13911a;
        this.h = cjVar.h;
        this.f13912b = cjVar.f13912b;
        this.c = cjVar.c;
        this.f244b = cjVar.f244b;
        this.d = cjVar.d;
        this.f243a = cjVar.f243a;
        this.e = cjVar.e;
    }

    public Bundle a() {
        Bundle bundle = new Bundle();
        bundle.putLong("id", this.f242a);
        bundle.putInt("showType", this.f13911a);
        bundle.putInt("nonsense", this.f13912b);
        bundle.putInt("receiveUpperBound", this.c);
        bundle.putLong("lastShowTime", this.f244b);
        bundle.putInt("multi", this.e);
        return bundle;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m227a() {
        return this.f243a;
    }

    public void a(String str) {
        this.f243a = str;
    }

    public void a(JSONObject jSONObject) {
        this.f242a = jSONObject.optLong("id");
        this.f13911a = jSONObject.optInt("showType");
        this.f13912b = jSONObject.optInt("nonsense");
        this.c = jSONObject.optInt("receiveUpperBound");
        this.f244b = jSONObject.optLong("lastShowTime");
        this.e = jSONObject.optInt("multi");
    }

    public String toString() {
        return "";
    }
}
