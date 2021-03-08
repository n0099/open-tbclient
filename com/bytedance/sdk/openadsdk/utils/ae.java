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
    private static Map<String, ae> f5118a = new HashMap();
    private SharedPreferences b;

    public static ae a(String str, Context context) {
        if (TextUtils.isEmpty(str)) {
            str = "tt_ad_sdk_sp";
        }
        ae aeVar = f5118a.get(str);
        if (aeVar == null) {
            ae aeVar2 = new ae(str, context);
            f5118a.put(str, aeVar2);
            return aeVar2;
        }
        return aeVar;
    }

    private ae(String str, Context context) {
        if (context != null) {
            this.b = context.getApplicationContext().getSharedPreferences(str, 0);
        }
    }

    public void a(@NonNull String str, @NonNull String str2) {
        try {
            this.b.edit().putString(str, str2).apply();
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
            return this.b.getString(str, str2);
        } catch (Throwable th) {
            return str2;
        }
    }

    public void a(@NonNull String str, int i) {
        try {
            this.b.edit().putInt(str, i).apply();
        } catch (Throwable th) {
        }
    }

    public int b(@NonNull String str, int i) {
        try {
            return this.b.getInt(str, i);
        } catch (Throwable th) {
            return i;
        }
    }

    public void a(@NonNull String str, long j) {
        try {
            this.b.edit().putLong(str, j).apply();
        } catch (Throwable th) {
        }
    }

    public long b(@NonNull String str, long j) {
        try {
            return this.b.getLong(str, j);
        } catch (Throwable th) {
            return j;
        }
    }

    public void a(@NonNull String str, boolean z) {
        try {
            this.b.edit().putBoolean(str, z).apply();
        } catch (Throwable th) {
        }
    }

    public boolean b(@NonNull String str, boolean z) {
        try {
            return this.b.getBoolean(str, z);
        } catch (Throwable th) {
            return z;
        }
    }

    public void a(@NonNull String str, @NonNull Set<String> set) {
        try {
            this.b.edit().putStringSet(str, set).apply();
        } catch (Throwable th) {
        }
    }

    public Set<String> b(@NonNull String str, @NonNull Set<String> set) {
        try {
            return this.b.getStringSet(str, set);
        } catch (Throwable th) {
            return set;
        }
    }

    public void b(@NonNull String str) {
        try {
            this.b.edit().remove(str).apply();
        } catch (Throwable th) {
        }
    }
}
