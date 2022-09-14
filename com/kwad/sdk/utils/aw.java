package com.kwad.sdk.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.kwad.sdk.service.ServiceProvider;
import java.util.Map;
import java.util.Set;
@Deprecated
/* loaded from: classes8.dex */
public class aw {
    public static final String TAG = "aw";

    public static void U(String str, String str2) {
        Context context = ((com.kwad.sdk.service.kwai.d) ServiceProvider.get(com.kwad.sdk.service.kwai.d.class)).getContext();
        if (context == null) {
            return;
        }
        j(context, str, str2);
    }

    public static void a(Context context, String str, String str2, int i) {
        if (context == null) {
            return;
        }
        context.getSharedPreferences(str, 0).edit().putInt(str2, i).apply();
    }

    public static void a(Context context, String str, String str2, long j) {
        if (context == null) {
            return;
        }
        context.getSharedPreferences(str, 0).edit().putLong(str2, j).apply();
    }

    public static void a(Context context, String str, String str2, String str3, boolean z) {
        if (context == null) {
            return;
        }
        if (z && !com.kwad.sdk.core.a.c.bP(str3)) {
            str3 = com.kwad.sdk.core.a.c.bN(str3);
        }
        context.getSharedPreferences(str, 0).edit().putString(str2, str3).apply();
    }

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

    public static <T> void a(String str, Map<String, T> map) {
        Context context = ((com.kwad.sdk.service.kwai.d) ServiceProvider.get(com.kwad.sdk.service.kwai.d.class)).getContext();
        if (context == null) {
            return;
        }
        SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
        for (Map.Entry<String, T> entry : map.entrySet()) {
            try {
                a(edit, entry.getKey(), entry.getValue());
            } catch (Throwable th) {
                com.kwad.sdk.core.e.b.e(TAG, Log.getStackTraceString(th));
            }
        }
        edit.apply();
    }

    public static int b(Context context, String str, String str2, int i) {
        return context == null ? i : context.getSharedPreferences(str, 0).getInt(str2, i);
    }

    public static long b(Context context, String str, String str2, long j) {
        return context == null ? j : context.getSharedPreferences(str, 0).getLong(str2, j);
    }

    public static void b(String str, String str2, int i) {
        Context context = ((com.kwad.sdk.service.kwai.d) ServiceProvider.get(com.kwad.sdk.service.kwai.d.class)).getContext();
        if (context == null) {
            return;
        }
        a(context, str, str2, i);
    }

    public static int c(String str, String str2, int i) {
        Context context = ((com.kwad.sdk.service.kwai.d) ServiceProvider.get(com.kwad.sdk.service.kwai.d.class)).getContext();
        if (context == null) {
            return 0;
        }
        return b(context, str, str2, 0);
    }

    public static void c(Context context, @NonNull String str, @NonNull String str2, String str3) {
        if (context == null) {
            return;
        }
        a(context, str, str2, str3, false);
    }

    public static void c(Context context, String str, String str2, boolean z) {
        if (context == null) {
            return;
        }
        context.getSharedPreferences(str, 0).edit().putBoolean(str2, z).apply();
    }

    public static String d(Context context, String str, String str2, String str3) {
        String string;
        return (context == null || (string = context.getSharedPreferences(str, 0).getString(str2, str3)) == null || TextUtils.isEmpty(string)) ? str3 : (TextUtils.equals(string, str3) || !com.kwad.sdk.core.a.c.bP(string)) ? string : com.kwad.sdk.core.a.c.bO(string);
    }

    public static boolean d(Context context, String str, String str2, boolean z) {
        return context == null ? z : context.getSharedPreferences(str, 0).getBoolean(str2, z);
    }

    public static SharedPreferences dS(String str) {
        Context context = ((com.kwad.sdk.service.kwai.d) ServiceProvider.get(com.kwad.sdk.service.kwai.d.class)).getContext();
        if (context == null) {
            return null;
        }
        return context.getSharedPreferences(str, 0);
    }

    public static void e(String str, String str2, String str3) {
        Context context = ((com.kwad.sdk.service.kwai.d) ServiceProvider.get(com.kwad.sdk.service.kwai.d.class)).getContext();
        if (context == null) {
            return;
        }
        c(context, str, str2, str3);
    }

    public static String f(String str, String str2, String str3) {
        Context context = ((com.kwad.sdk.service.kwai.d) ServiceProvider.get(com.kwad.sdk.service.kwai.d.class)).getContext();
        return context == null ? str3 : d(context, str, str2, str3);
    }

    public static void g(String str, String str2, String str3) {
        if (com.kwad.sdk.core.a.c.bP(str)) {
            return;
        }
        e(str2, str3, com.kwad.sdk.core.a.c.bN(str));
    }

    public static void h(String str, String str2, boolean z) {
        Context context = ((com.kwad.sdk.service.kwai.d) ServiceProvider.get(com.kwad.sdk.service.kwai.d.class)).getContext();
        if (context == null) {
            return;
        }
        c(context, str, str2, true);
    }

    public static void j(Context context, String str, String str2) {
        if (context == null) {
            return;
        }
        context.getSharedPreferences(str, 0).edit().remove(str2).apply();
    }
}
