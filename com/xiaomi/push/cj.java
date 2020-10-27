package com.xiaomi.push;

import android.os.Bundle;
import org.json.JSONObject;
/* loaded from: classes12.dex */
public class cj {

    /* renamed from: a  reason: collision with root package name */
    public int f4836a;

    /* renamed from: a  reason: collision with other field name */
    public long f161a;

    /* renamed from: a  reason: collision with other field name */
    private String f162a;
    public int b;

    /* renamed from: b  reason: collision with other field name */
    public long f163b;
    public int c;
    public int d;
    public int e;
    public String h;

    public cj() {
    }

    public cj(cj cjVar) {
        this.f161a = cjVar.f161a;
        this.f4836a = cjVar.f4836a;
        this.h = cjVar.h;
        this.b = cjVar.b;
        this.c = cjVar.c;
        this.f163b = cjVar.f163b;
        this.d = cjVar.d;
        this.f162a = cjVar.f162a;
        this.e = cjVar.e;
    }

    public Bundle a() {
        Bundle bundle = new Bundle();
        bundle.putLong("id", this.f161a);
        bundle.putInt("showType", this.f4836a);
        bundle.putInt("nonsense", this.b);
        bundle.putInt("receiveUpperBound", this.c);
        bundle.putLong("lastShowTime", this.f163b);
        bundle.putInt("multi", this.e);
        return bundle;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m201a() {
        return this.f162a;
    }

    public void a(String str) {
        this.f162a = str;
    }

    public void a(JSONObject jSONObject) {
        this.f161a = jSONObject.optLong("id");
        this.f4836a = jSONObject.optInt("showType");
        this.b = jSONObject.optInt("nonsense");
        this.c = jSONObject.optInt("receiveUpperBound");
        this.f163b = jSONObject.optLong("lastShowTime");
        this.e = jSONObject.optInt("multi");
    }

    public String toString() {
        return "";
    }
}
