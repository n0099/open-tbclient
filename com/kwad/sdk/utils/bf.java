package com.kwad.sdk.utils;

import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import com.kwad.sdk.service.ServiceProvider;
import java.util.Map;
import java.util.Set;
@Deprecated
/* loaded from: classes10.dex */
public class bf {
    public static final String TAG = "bf";

    public static void a(SharedPreferences.Editor editor, String str, Object obj) {
        if (str != null) {
            if (obj instanceof Integer) {
                editor.putInt(str, ((Integer) obj).intValue());
            } else if (obj instanceof Long) {
                editor.putLong(str, ((Long) obj).longValue());
            } else if (obj instanceof Boolean) {
                editor.putBoolean(str, ((Boolean) obj).booleanValue());
            } else if (obj instanceof Float) {
                editor.putFloat(str, ((Float) obj).floatValue());
            } else if (obj instanceof Set) {
                editor.putStringSet(str, (Set) obj);
            } else if (obj instanceof String) {
                editor.putString(str, String.valueOf(obj));
            }
        }
    }

    public static void a(String str, String str2, int i) {
        SharedPreferences gg = gg(str);
        if (gg == null) {
            return;
        }
        gg.edit().putInt(str2, i).apply();
    }

    public static int b(String str, String str2, int i) {
        SharedPreferences gg = gg(str);
        if (gg == null) {
            return i;
        }
        return gg.getInt(str2, i);
    }

    public static void h(String str, String str2, String str3) {
        a(str, str2, str3, false);
    }

    public static String i(String str, String str2, String str3) {
        SharedPreferences gg = gg(str);
        if (gg == null) {
            return str3;
        }
        String string = gg.getString(str2, str3);
        if (string != null && !TextUtils.isEmpty(string)) {
            if (!TextUtils.equals(string, str3) && com.kwad.sdk.core.a.c.dl(string)) {
                return com.kwad.sdk.core.a.c.dk(string);
            }
            return string;
        }
        return str3;
    }

    public static void j(String str, String str2, String str3) {
        if (!com.kwad.sdk.core.a.c.dl(str)) {
            h(str2, str3, com.kwad.sdk.core.a.c.dj(str));
        }
    }

    public static void l(String str, String str2, boolean z) {
        SharedPreferences gg = gg(str);
        if (gg == null) {
            return;
        }
        gg.edit().putBoolean(str2, z).apply();
    }

    public static boolean m(String str, String str2, boolean z) {
        SharedPreferences gg = gg(str);
        if (gg == null) {
            return z;
        }
        return gg.getBoolean(str2, z);
    }

    public static void a(String str, String str2, long j) {
        SharedPreferences gg = gg(str);
        if (gg == null) {
            return;
        }
        gg.edit().putLong(str2, j).apply();
    }

    public static long b(String str, String str2, long j) {
        SharedPreferences gg = gg(str);
        if (gg == null) {
            return j;
        }
        return gg.getLong(str2, j);
    }

    public static void a(String str, String str2, String str3, boolean z) {
        SharedPreferences gg = gg(str);
        if (gg == null) {
            return;
        }
        if (z && !com.kwad.sdk.core.a.c.dl(str3)) {
            gg.edit().putString(str2, com.kwad.sdk.core.a.c.dj(str3)).apply();
            return;
        }
        gg.edit().putString(str2, str3).apply();
    }

    public static <T> void a(String str, Map<String, T> map) {
        SharedPreferences gg = gg(str);
        if (gg == null) {
            return;
        }
        SharedPreferences.Editor edit = gg.edit();
        for (Map.Entry<String, T> entry : map.entrySet()) {
            try {
                a(edit, entry.getKey(), entry.getValue());
            } catch (Throwable th) {
                com.kwad.sdk.core.e.c.e(TAG, Log.getStackTraceString(th));
            }
        }
        edit.apply();
    }

    public static void as(String str, String str2) {
        SharedPreferences gg = gg(str);
        if (gg == null) {
            return;
        }
        gg.edit().remove(str2).apply();
    }

    @Nullable
    public static SharedPreferences gg(String str) {
        try {
            return ServiceProvider.Jn().getSharedPreferences(str, 0);
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(th);
            return null;
        }
    }
}
