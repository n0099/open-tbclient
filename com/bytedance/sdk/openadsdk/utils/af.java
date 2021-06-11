package com.bytedance.sdk.openadsdk.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/* loaded from: classes6.dex */
public class af {

    /* renamed from: a  reason: collision with root package name */
    public static Map<String, af> f30260a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public SharedPreferences f30261b;

    public af(String str, Context context) {
        if (context != null) {
            this.f30261b = context.getApplicationContext().getSharedPreferences(str, 0);
        }
    }

    public static af a(String str, Context context) {
        if (TextUtils.isEmpty(str)) {
            str = "tt_ad_sdk_sp";
        }
        af afVar = f30260a.get(str);
        if (afVar == null) {
            af afVar2 = new af(str, context);
            f30260a.put(str, afVar2);
            return afVar2;
        }
        return afVar;
    }

    public String b(@NonNull String str, @NonNull String str2) {
        try {
            return this.f30261b.getString(str, str2);
        } catch (Throwable unused) {
            return str2;
        }
    }

    public int b(@NonNull String str, int i2) {
        try {
            return this.f30261b.getInt(str, i2);
        } catch (Throwable unused) {
            return i2;
        }
    }

    public long b(@NonNull String str, long j) {
        try {
            return this.f30261b.getLong(str, j);
        } catch (Throwable unused) {
            return j;
        }
    }

    public boolean b(@NonNull String str, boolean z) {
        try {
            return this.f30261b.getBoolean(str, z);
        } catch (Throwable unused) {
            return z;
        }
    }

    public void a(@NonNull String str, @NonNull String str2) {
        try {
            this.f30261b.edit().putString(str, str2).apply();
        } catch (Throwable unused) {
        }
    }

    public Set<String> b(@NonNull String str, @NonNull Set<String> set) {
        try {
            return this.f30261b.getStringSet(str, set);
        } catch (Throwable unused) {
            return set;
        }
    }

    public String a(@NonNull String str) {
        try {
            return b(str, "");
        } catch (Throwable unused) {
            return null;
        }
    }

    public void b(@NonNull String str) {
        try {
            this.f30261b.edit().remove(str).apply();
        } catch (Throwable unused) {
        }
    }

    public void a(@NonNull String str, int i2) {
        try {
            this.f30261b.edit().putInt(str, i2).apply();
        } catch (Throwable unused) {
        }
    }

    public void a(@NonNull String str, long j) {
        try {
            this.f30261b.edit().putLong(str, j).apply();
        } catch (Throwable unused) {
        }
    }

    public void a(@NonNull String str, boolean z) {
        try {
            this.f30261b.edit().putBoolean(str, z).apply();
        } catch (Throwable unused) {
        }
    }

    public void a(@NonNull String str, @NonNull Set<String> set) {
        try {
            this.f30261b.edit().putStringSet(str, set).apply();
        } catch (Throwable unused) {
        }
    }
}
