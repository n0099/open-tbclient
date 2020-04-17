package com.xiaomi.push;

import android.os.Bundle;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class ce {
    public int a;

    /* renamed from: a  reason: collision with other field name */
    public long f178a;

    /* renamed from: a  reason: collision with other field name */
    private String f179a;
    public int b;

    /* renamed from: b  reason: collision with other field name */
    public long f180b;
    public int c;
    public int d;
    public int e;
    public String h;

    public ce() {
    }

    public ce(ce ceVar) {
        this.f178a = ceVar.f178a;
        this.a = ceVar.a;
        this.h = ceVar.h;
        this.b = ceVar.b;
        this.c = ceVar.c;
        this.f180b = ceVar.f180b;
        this.d = ceVar.d;
        this.f179a = ceVar.f179a;
        this.e = ceVar.e;
    }

    public Bundle a() {
        Bundle bundle = new Bundle();
        bundle.putLong("id", this.f178a);
        bundle.putInt("showType", this.a);
        bundle.putInt("nonsense", this.b);
        bundle.putInt("receiveUpperBound", this.c);
        bundle.putLong("lastShowTime", this.f180b);
        bundle.putInt("multi", this.e);
        return bundle;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m195a() {
        return this.f179a;
    }

    public void a(String str) {
        this.f179a = str;
    }

    public void a(JSONObject jSONObject) {
        this.f178a = jSONObject.optLong("id");
        this.a = jSONObject.optInt("showType");
        this.b = jSONObject.optInt("nonsense");
        this.c = jSONObject.optInt("receiveUpperBound");
        this.f180b = jSONObject.optLong("lastShowTime");
        this.e = jSONObject.optInt("multi");
    }

    public String toString() {
        return "";
    }
}
