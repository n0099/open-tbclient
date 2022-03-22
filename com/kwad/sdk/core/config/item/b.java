package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import androidx.annotation.Nullable;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public abstract class b<T> {
    public T a;

    /* renamed from: b  reason: collision with root package name */
    public String f39338b;

    /* renamed from: c  reason: collision with root package name */
    public T f39339c;

    public b(String str, T t) {
        this(str, t, t);
    }

    public b(String str, T t, T t2) {
        this.f39338b = str;
        this.f39339c = t;
        this.a = t2;
        com.kwad.sdk.core.config.a.a(this);
    }

    @Nullable
    public T a() {
        return this.f39339c;
    }

    public abstract void a(SharedPreferences.Editor editor);

    public abstract void a(SharedPreferences sharedPreferences);

    public void a(T t) {
        this.f39339c = t;
    }

    public abstract void a(JSONObject jSONObject);

    public String b() {
        return this.f39338b;
    }

    public T c() {
        return this.a;
    }
}
