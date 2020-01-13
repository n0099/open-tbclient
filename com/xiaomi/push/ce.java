package com.xiaomi.push;

import android.os.Bundle;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class ce {
    public int a;

    /* renamed from: a  reason: collision with other field name */
    public long f180a;

    /* renamed from: a  reason: collision with other field name */
    private String f181a;
    public int b;

    /* renamed from: b  reason: collision with other field name */
    public long f182b;
    public int c;
    public int d;
    public int e;
    public String h;

    public ce() {
    }

    public ce(ce ceVar) {
        this.f180a = ceVar.f180a;
        this.a = ceVar.a;
        this.h = ceVar.h;
        this.b = ceVar.b;
        this.c = ceVar.c;
        this.f182b = ceVar.f182b;
        this.d = ceVar.d;
        this.f181a = ceVar.f181a;
        this.e = ceVar.e;
    }

    public Bundle a() {
        Bundle bundle = new Bundle();
        bundle.putLong("id", this.f180a);
        bundle.putInt("showType", this.a);
        bundle.putInt("nonsense", this.b);
        bundle.putInt("receiveUpperBound", this.c);
        bundle.putLong("lastShowTime", this.f182b);
        bundle.putInt("multi", this.e);
        return bundle;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m187a() {
        return this.f181a;
    }

    public void a(String str) {
        this.f181a = str;
    }

    public void a(JSONObject jSONObject) {
        this.f180a = jSONObject.optLong("id");
        this.a = jSONObject.optInt("showType");
        this.b = jSONObject.optInt("nonsense");
        this.c = jSONObject.optInt("receiveUpperBound");
        this.f182b = jSONObject.optLong("lastShowTime");
        this.e = jSONObject.optInt("multi");
    }

    public String toString() {
        return "";
    }
}
