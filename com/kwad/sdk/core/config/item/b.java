package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import androidx.annotation.Nullable;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public abstract class b<T> {
    public T a;
    public String b;
    public T c;

    public b(String str, T t) {
        this(str, t, t);
    }

    public b(String str, T t, T t2) {
        this.b = str;
        this.c = t;
        this.a = t2;
        com.kwad.sdk.core.config.b.a(this);
    }

    public final String a() {
        return this.b;
    }

    public abstract void a(SharedPreferences.Editor editor);

    public abstract void a(SharedPreferences sharedPreferences);

    public final void a(T t) {
        this.c = t;
    }

    public abstract void a(JSONObject jSONObject);

    @Nullable
    public T b() {
        return this.c;
    }

    public final T c() {
        return this.a;
    }
}
