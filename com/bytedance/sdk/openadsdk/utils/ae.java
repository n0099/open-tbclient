package com.bytedance.sdk.openadsdk.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/* loaded from: classes6.dex */
public class ae {

    /* renamed from: a  reason: collision with root package name */
    private static Map<String, ae> f7546a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private SharedPreferences f7547b;

    public static ae a(String str, Context context) {
        if (TextUtils.isEmpty(str)) {
            str = "tt_ad_sdk_sp";
        }
        ae aeVar = f7546a.get(str);
        if (aeVar == null) {
            ae aeVar2 = new ae(str, context);
            f7546a.put(str, aeVar2);
            return aeVar2;
        }
        return aeVar;
    }

    private ae(String str, Context context) {
        if (context != null) {
            this.f7547b = context.getApplicationContext().getSharedPreferences(str, 0);
        }
    }

    public void a(@NonNull String str, @NonNull String str2) {
        try {
            this.f7547b.edit().putString(str, str2).apply();
        } catch (Throwable th) {
        }
    }

    public String a(@NonNull String str) {
        try {
            return b(str, "");
        } catch (Throwable th) {
            return null;
        }
    }

    public String b(@NonNull String str, @NonNull String str2) {
        try {
            return this.f7547b.getString(str, str2);
        } catch (Throwable th) {
            return str2;
        }
    }

    public void a(@NonNull String str, int i) {
        try {
            this.f7547b.edit().putInt(str, i).apply();
        } catch (Throwable th) {
        }
    }

    public int b(@NonNull String str, int i) {
        try {
            return this.f7547b.getInt(str, i);
        } catch (Throwable th) {
            return i;
        }
    }

    public void a(@NonNull String str, long j) {
        try {
            this.f7547b.edit().putLong(str, j).apply();
        } catch (Throwable th) {
        }
    }

    public long b(@NonNull String str, long j) {
        try {
            return this.f7547b.getLong(str, j);
        } catch (Throwable th) {
            return j;
        }
    }

    public void a(@NonNull String str, @NonNull Set<String> set) {
        try {
            this.f7547b.edit().putStringSet(str, set).apply();
        } catch (Throwable th) {
        }
    }

    public Set<String> b(@NonNull String str, @NonNull Set<String> set) {
        try {
            return this.f7547b.getStringSet(str, set);
        } catch (Throwable th) {
            return set;
        }
    }

    public void b(@NonNull String str) {
        try {
            this.f7547b.edit().remove(str).apply();
        } catch (Throwable th) {
        }
    }
}
