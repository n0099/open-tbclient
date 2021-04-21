package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public abstract class a<T> {

    /* renamed from: a  reason: collision with root package name */
    public T f33838a;

    /* renamed from: b  reason: collision with root package name */
    public String f33839b;

    /* renamed from: c  reason: collision with root package name */
    public T f33840c;

    public a(String str, T t) {
        this(str, t, t);
    }

    public a(String str, T t, T t2) {
        this.f33839b = str;
        this.f33840c = t;
        this.f33838a = t2;
        com.kwad.sdk.core.config.b.a(this);
    }

    public String a() {
        return this.f33839b;
    }

    public abstract void a(SharedPreferences.Editor editor);

    public abstract void a(SharedPreferences sharedPreferences);

    public void a(T t) {
        this.f33840c = t;
    }

    public abstract void a(JSONObject jSONObject);

    public T b() {
        return this.f33840c;
    }

    public T c() {
        return this.f33838a;
    }
}
