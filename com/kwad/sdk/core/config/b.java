package com.kwad.sdk.core.config;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.utils.bf;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class b {
    public static final Map<String, Set<com.kwad.sdk.core.config.item.b>> aos = new ConcurrentHashMap();
    public static SharedPreferences aot = null;

    public static SharedPreferences Ak() {
        if (aot == null) {
            aot = bf.gg("ksadsdk_config");
        }
        return aot;
    }

    public static void a(Context context, com.kwad.sdk.core.config.item.b<?> bVar) {
        SharedPreferences Ak;
        if (bVar != null && (Ak = Ak()) != null) {
            try {
                bVar.a(Ak);
            } catch (Exception e) {
                com.kwad.sdk.core.e.c.printStackTraceOnly(e);
            }
        }
    }

    public static void a(SharedPreferences.Editor editor) {
        if (editor != null) {
            for (String str : aos.keySet()) {
                Set<com.kwad.sdk.core.config.item.b> set = aos.get(str);
                if (set != null && !set.isEmpty()) {
                    for (com.kwad.sdk.core.config.item.b bVar : set) {
                        if (bVar != null) {
                            bVar.b(editor);
                        }
                    }
                }
            }
        }
    }

    public static void i(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        for (String str : aos.keySet()) {
            Set<com.kwad.sdk.core.config.item.b> set = aos.get(str);
            if (set != null && !set.isEmpty() && jSONObject.has(str)) {
                for (com.kwad.sdk.core.config.item.b bVar : set) {
                    if (bVar != null) {
                        bVar.j(jSONObject);
                    }
                }
            }
        }
    }

    public static void a(SharedPreferences sharedPreferences) {
        if (sharedPreferences != null) {
            for (String str : aos.keySet()) {
                Set<com.kwad.sdk.core.config.item.b> set = aos.get(str);
                if (set != null && !set.isEmpty()) {
                    for (com.kwad.sdk.core.config.item.b bVar : set) {
                        if (bVar != null) {
                            try {
                                bVar.a(sharedPreferences);
                            } catch (Exception e) {
                                com.kwad.sdk.core.e.c.printStackTraceOnly(e);
                            }
                        }
                    }
                }
            }
        }
    }

    public static <T> void a(@NonNull com.kwad.sdk.core.config.item.b<T> bVar) {
        String key = bVar.getKey();
        if (TextUtils.isEmpty(key)) {
            return;
        }
        Set<com.kwad.sdk.core.config.item.b> cL = cL(key);
        if (cL == null) {
            cL = new CopyOnWriteArraySet<>();
            aos.put(key, cL);
        }
        cL.add(bVar);
    }

    @WorkerThread
    public static synchronized boolean aP(Context context) {
        synchronized (b.class) {
            SharedPreferences Ak = Ak();
            if (Ak != null) {
                SharedPreferences.Editor edit = Ak.edit();
                a(edit);
                return edit.commit();
            }
            return false;
        }
    }

    @WorkerThread
    public static synchronized void aQ(Context context) {
        synchronized (b.class) {
            SharedPreferences Ak = Ak();
            if (Ak != null) {
                a(Ak);
            }
        }
    }

    @Nullable
    public static Set<com.kwad.sdk.core.config.item.b> cL(String str) {
        if (!TextUtils.isEmpty(str)) {
            return aos.get(str);
        }
        return null;
    }
}
