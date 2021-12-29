package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import androidx.annotation.Nullable;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public abstract class b<T> {
    public T a;

    /* renamed from: b  reason: collision with root package name */
    public String f57832b;

    /* renamed from: c  reason: collision with root package name */
    public T f57833c;

    public b(String str, T t) {
        this(str, t, t);
    }

    public b(String str, T t, T t2) {
        this.f57832b = str;
        this.f57833c = t;
        this.a = t2;
        com.kwad.sdk.core.config.a.a(this);
    }

    @Nullable
    public T a() {
        return this.f57833c;
    }

    public abstract void a(SharedPreferences.Editor editor);

    public abstract void a(SharedPreferences sharedPreferences);

    public void a(T t) {
        this.f57833c = t;
    }

    public abstract void a(JSONObject jSONObject);

    public String b() {
        return this.f57832b;
    }

    public T c() {
        return this.a;
    }
}
