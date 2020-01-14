package com.xiaomi.push;

import android.os.Bundle;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class ce {
    public int a;

    /* renamed from: a  reason: collision with other field name */
    public long f181a;

    /* renamed from: a  reason: collision with other field name */
    private String f182a;
    public int b;

    /* renamed from: b  reason: collision with other field name */
    public long f183b;
    public int c;
    public int d;
    public int e;
    public String h;

    public ce() {
    }

    public ce(ce ceVar) {
        this.f181a = ceVar.f181a;
        this.a = ceVar.a;
        this.h = ceVar.h;
        this.b = ceVar.b;
        this.c = ceVar.c;
        this.f183b = ceVar.f183b;
        this.d = ceVar.d;
        this.f182a = ceVar.f182a;
        this.e = ceVar.e;
    }

    public Bundle a() {
        Bundle bundle = new Bundle();
        bundle.putLong("id", this.f181a);
        bundle.putInt("showType", this.a);
        bundle.putInt("nonsense", this.b);
        bundle.putInt("receiveUpperBound", this.c);
        bundle.putLong("lastShowTime", this.f183b);
        bundle.putInt("multi", this.e);
        return bundle;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m187a() {
        return this.f182a;
    }

    public void a(String str) {
        this.f182a = str;
    }

    public void a(JSONObject jSONObject) {
        this.f181a = jSONObject.optLong("id");
        this.a = jSONObject.optInt("showType");
        this.b = jSONObject.optInt("nonsense");
        this.c = jSONObject.optInt("receiveUpperBound");
        this.f183b = jSONObject.optLong("lastShowTime");
        this.e = jSONObject.optInt("multi");
    }

    public String toString() {
        return "";
    }
}
