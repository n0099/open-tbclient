package com.xiaomi.push;

import android.os.Bundle;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class ce {
    public int a;

    /* renamed from: a  reason: collision with other field name */
    public long f177a;

    /* renamed from: a  reason: collision with other field name */
    private String f178a;
    public int b;

    /* renamed from: b  reason: collision with other field name */
    public long f179b;
    public int c;
    public int d;
    public int e;
    public String h;

    public ce() {
    }

    public ce(ce ceVar) {
        this.f177a = ceVar.f177a;
        this.a = ceVar.a;
        this.h = ceVar.h;
        this.b = ceVar.b;
        this.c = ceVar.c;
        this.f179b = ceVar.f179b;
        this.d = ceVar.d;
        this.f178a = ceVar.f178a;
        this.e = ceVar.e;
    }

    public Bundle a() {
        Bundle bundle = new Bundle();
        bundle.putLong("id", this.f177a);
        bundle.putInt("showType", this.a);
        bundle.putInt("nonsense", this.b);
        bundle.putInt("receiveUpperBound", this.c);
        bundle.putLong("lastShowTime", this.f179b);
        bundle.putInt("multi", this.e);
        return bundle;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m190a() {
        return this.f178a;
    }

    public void a(String str) {
        this.f178a = str;
    }

    public void a(JSONObject jSONObject) {
        this.f177a = jSONObject.optLong("id");
        this.a = jSONObject.optInt("showType");
        this.b = jSONObject.optInt("nonsense");
        this.c = jSONObject.optInt("receiveUpperBound");
        this.f179b = jSONObject.optLong("lastShowTime");
        this.e = jSONObject.optInt("multi");
    }

    public String toString() {
        return "";
    }
}
