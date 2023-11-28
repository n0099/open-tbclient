package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public abstract class b<T> {
    public T arf;
    public T arg;
    public String mKey;

    public abstract void a(SharedPreferences sharedPreferences);

    public abstract void b(SharedPreferences.Editor editor);

    public abstract void j(JSONObject jSONObject);

    public b(String str, T t) {
        this(str, t, t);
    }

    public b(String str, T t, T t2) {
        this.mKey = str;
        this.arg = t;
        this.arf = t2;
        com.kwad.sdk.core.config.b.a(this);
    }

    public static String cM(String str) {
        if (!TextUtils.isEmpty(str)) {
            return com.kwad.sdk.core.a.c.dj(str);
        }
        return str;
    }

    public static String cN(String str) {
        if (!TextUtils.isEmpty(str) && com.kwad.sdk.core.a.c.dl(str)) {
            return com.kwad.sdk.core.a.c.dk(str);
        }
        return str;
    }

    public final void setValue(T t) {
        this.arg = t;
    }

    public final T Bx() {
        return this.arf;
    }

    public final String getKey() {
        return this.mKey;
    }

    @Nullable
    public T getValue() {
        return this.arg;
    }
}
