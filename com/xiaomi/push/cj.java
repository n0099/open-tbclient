package com.xiaomi.push;

import android.os.Bundle;
import org.json.JSONObject;
/* loaded from: classes18.dex */
public class cj {

    /* renamed from: a  reason: collision with root package name */
    public int f4838a;

    /* renamed from: a  reason: collision with other field name */
    public long f166a;

    /* renamed from: a  reason: collision with other field name */
    private String f167a;
    public int b;

    /* renamed from: b  reason: collision with other field name */
    public long f168b;
    public int c;
    public int d;
    public int e;
    public String h;

    public cj() {
    }

    public cj(cj cjVar) {
        this.f166a = cjVar.f166a;
        this.f4838a = cjVar.f4838a;
        this.h = cjVar.h;
        this.b = cjVar.b;
        this.c = cjVar.c;
        this.f168b = cjVar.f168b;
        this.d = cjVar.d;
        this.f167a = cjVar.f167a;
        this.e = cjVar.e;
    }

    public Bundle a() {
        Bundle bundle = new Bundle();
        bundle.putLong("id", this.f166a);
        bundle.putInt("showType", this.f4838a);
        bundle.putInt("nonsense", this.b);
        bundle.putInt("receiveUpperBound", this.c);
        bundle.putLong("lastShowTime", this.f168b);
        bundle.putInt("multi", this.e);
        return bundle;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m204a() {
        return this.f167a;
    }

    public void a(String str) {
        this.f167a = str;
    }

    public void a(JSONObject jSONObject) {
        this.f166a = jSONObject.optLong("id");
        this.f4838a = jSONObject.optInt("showType");
        this.b = jSONObject.optInt("nonsense");
        this.c = jSONObject.optInt("receiveUpperBound");
        this.f168b = jSONObject.optLong("lastShowTime");
        this.e = jSONObject.optInt("multi");
    }

    public String toString() {
        return "";
    }
}
