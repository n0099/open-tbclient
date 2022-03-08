package com.kwad.sdk.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class ax {
    public static final Handler a = new Handler(Looper.getMainLooper());

    public static void a(Runnable runnable) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            a.post(runnable);
        }
    }

    public static void a(Runnable runnable, long j2) {
        a.postDelayed(runnable, j2);
    }

    public static void a(Runnable runnable, Object obj, long j2) {
        Message obtain = Message.obtain(a, runnable);
        obtain.obj = obj;
        a.sendMessageDelayed(obtain, j2);
    }

    public static boolean a(JSONObject jSONObject, JSONObject jSONObject2) {
        boolean z = false;
        if (jSONObject != null && jSONObject2 != null) {
            Iterator<String> keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                try {
                    jSONObject.put(next, jSONObject2.opt(next));
                } catch (JSONException e2) {
                    com.kwad.sdk.core.d.a.b(e2);
                }
                z = true;
            }
        }
        return z;
    }

    public static void b(Runnable runnable) {
        a.removeCallbacks(runnable);
    }
}
