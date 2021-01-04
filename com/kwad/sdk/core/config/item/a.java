package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public abstract class a<T> {

    /* renamed from: a  reason: collision with root package name */
    private T f9350a;

    /* renamed from: b  reason: collision with root package name */
    private String f9351b;
    private T c;

    public a(String str, T t) {
        this(str, t, t);
    }

    public a(String str, T t, T t2) {
        this.f9351b = str;
        this.c = t;
        this.f9350a = t2;
        com.kwad.sdk.core.config.b.a(this);
    }

    public String a() {
        return this.f9351b;
    }

    public abstract void a(SharedPreferences.Editor editor);

    public abstract void a(SharedPreferences sharedPreferences);

    public void a(T t) {
        this.c = t;
    }

    public abstract void a(JSONObject jSONObject);

    public T b() {
        return this.c;
    }

    public T c() {
        return this.f9350a;
    }
}
