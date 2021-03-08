package com.xiaomi.push;

import android.os.Bundle;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class cj {

    /* renamed from: a  reason: collision with root package name */
    public int f8301a;

    /* renamed from: a  reason: collision with other field name */
    public long f163a;

    /* renamed from: a  reason: collision with other field name */
    private String f164a;
    public int b;

    /* renamed from: b  reason: collision with other field name */
    public long f165b;
    public int c;
    public int d;
    public int e;
    public String h;

    public cj() {
    }

    public cj(cj cjVar) {
        this.f163a = cjVar.f163a;
        this.f8301a = cjVar.f8301a;
        this.h = cjVar.h;
        this.b = cjVar.b;
        this.c = cjVar.c;
        this.f165b = cjVar.f165b;
        this.d = cjVar.d;
        this.f164a = cjVar.f164a;
        this.e = cjVar.e;
    }

    public Bundle a() {
        Bundle bundle = new Bundle();
        bundle.putLong("id", this.f163a);
        bundle.putInt("showType", this.f8301a);
        bundle.putInt("nonsense", this.b);
        bundle.putInt("receiveUpperBound", this.c);
        bundle.putLong("lastShowTime", this.f165b);
        bundle.putInt("multi", this.e);
        return bundle;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m205a() {
        return this.f164a;
    }

    public void a(String str) {
        this.f164a = str;
    }

    public void a(JSONObject jSONObject) {
        this.f163a = jSONObject.optLong("id");
        this.f8301a = jSONObject.optInt("showType");
        this.b = jSONObject.optInt("nonsense");
        this.c = jSONObject.optInt("receiveUpperBound");
        this.f165b = jSONObject.optLong("lastShowTime");
        this.e = jSONObject.optInt("multi");
    }

    public String toString() {
        return "";
    }
}
