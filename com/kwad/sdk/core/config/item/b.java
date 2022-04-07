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
        com.kwad.sdk.core.config.a.a(this);
    }

    @Nullable
    public T a() {
        return this.c;
    }

    public abstract void a(SharedPreferences.Editor editor);

    public abstract void a(SharedPreferences sharedPreferences);

    public void a(T t) {
        this.c = t;
    }

    public abstract void a(JSONObject jSONObject);

    public String b() {
        return this.b;
    }

    public T c() {
        return this.a;
    }
}
