package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import androidx.annotation.Nullable;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public abstract class b<T> {
    public T a;

    /* renamed from: b  reason: collision with root package name */
    public String f54203b;

    /* renamed from: c  reason: collision with root package name */
    public T f54204c;

    public b(String str, T t) {
        this(str, t, t);
    }

    public b(String str, T t, T t2) {
        this.f54203b = str;
        this.f54204c = t;
        this.a = t2;
        com.kwad.sdk.core.config.a.a(this);
    }

    @Nullable
    public T a() {
        return this.f54204c;
    }

    public abstract void a(SharedPreferences.Editor editor);

    public abstract void a(SharedPreferences sharedPreferences);

    public void a(T t) {
        this.f54204c = t;
    }

    public abstract void a(JSONObject jSONObject);

    public String b() {
        return this.f54203b;
    }

    public T c() {
        return this.a;
    }
}
