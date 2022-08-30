package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public abstract class b<T> {
    public T VA;
    public T Vz;
    public String mKey;

    public b(String str, T t) {
        this(str, t, t);
    }

    public b(String str, T t, T t2) {
        this.mKey = str;
        this.VA = t;
        this.Vz = t2;
        com.kwad.sdk.core.config.b.a(this);
    }

    public static String bt(String str) {
        return !TextUtils.isEmpty(str) ? com.kwad.sdk.core.a.c.bN(str) : str;
    }

    public static String bu(String str) {
        return (TextUtils.isEmpty(str) || !com.kwad.sdk.core.a.c.bP(str)) ? str : com.kwad.sdk.core.a.c.bO(str);
    }

    public abstract void a(SharedPreferences sharedPreferences);

    public abstract void b(SharedPreferences.Editor editor);

    public abstract void e(JSONObject jSONObject);

    public final String getKey() {
        return this.mKey;
    }

    @Nullable
    public T getValue() {
        return this.VA;
    }

    public final void setValue(T t) {
        this.VA = t;
    }

    public final T sx() {
        return this.Vz;
    }
}
