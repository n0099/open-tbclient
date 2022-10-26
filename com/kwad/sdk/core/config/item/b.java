package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public abstract class b {
    public Object VA;
    public Object Vz;
    public String mKey;

    public b(String str, Object obj) {
        this(str, obj, obj);
    }

    public b(String str, Object obj, Object obj2) {
        this.mKey = str;
        this.VA = obj;
        this.Vz = obj2;
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

    public Object getValue() {
        return this.VA;
    }

    public final void setValue(Object obj) {
        this.VA = obj;
    }

    public final Object sx() {
        return this.Vz;
    }
}
