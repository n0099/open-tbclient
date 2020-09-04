package com.xiaomi.push;

import android.os.Bundle;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class cj {
    public int a;

    /* renamed from: a  reason: collision with other field name */
    public long f164a;

    /* renamed from: a  reason: collision with other field name */
    private String f165a;
    public int b;

    /* renamed from: b  reason: collision with other field name */
    public long f166b;
    public int c;
    public int d;
    public int e;
    public String h;

    public cj() {
    }

    public cj(cj cjVar) {
        this.f164a = cjVar.f164a;
        this.a = cjVar.a;
        this.h = cjVar.h;
        this.b = cjVar.b;
        this.c = cjVar.c;
        this.f166b = cjVar.f166b;
        this.d = cjVar.d;
        this.f165a = cjVar.f165a;
        this.e = cjVar.e;
    }

    public Bundle a() {
        Bundle bundle = new Bundle();
        bundle.putLong("id", this.f164a);
        bundle.putInt("showType", this.a);
        bundle.putInt("nonsense", this.b);
        bundle.putInt("receiveUpperBound", this.c);
        bundle.putLong("lastShowTime", this.f166b);
        bundle.putInt("multi", this.e);
        return bundle;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m201a() {
        return this.f165a;
    }

    public void a(String str) {
        this.f165a = str;
    }

    public void a(JSONObject jSONObject) {
        this.f164a = jSONObject.optLong("id");
        this.a = jSONObject.optInt("showType");
        this.b = jSONObject.optInt("nonsense");
        this.c = jSONObject.optInt("receiveUpperBound");
        this.f166b = jSONObject.optLong("lastShowTime");
        this.e = jSONObject.optInt("multi");
    }

    public String toString() {
        return "";
    }
}
