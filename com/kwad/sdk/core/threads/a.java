package com.kwad.sdk.core.threads;

import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes10.dex */
public final class a {
    public static Map<String, WeakReference<C0658a>> adw = new ConcurrentHashMap();

    /* renamed from: com.kwad.sdk.core.threads.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0658a {
        public HandlerThread adx;
        public Handler mHandler;

        public C0658a(String str) {
            String str2;
            if (TextUtils.isEmpty(str)) {
                str2 = "ksad-HT";
            } else {
                str2 = "ksad-" + str;
            }
            HandlerThread handlerThread = new HandlerThread(str2);
            this.adx = handlerThread;
            handlerThread.start();
            this.mHandler = new Handler(this.adx.getLooper());
        }

        public final Handler getHandler() {
            return this.mHandler;
        }
    }

    @NonNull
    public static C0658a cv(String str) {
        WeakReference<C0658a> weakReference = adw.get(str);
        if (weakReference == null || weakReference.get() == null) {
            C0658a c0658a = new C0658a(str);
            adw.put(str, new WeakReference<>(c0658a));
            return c0658a;
        }
        return weakReference.get();
    }

    public static synchronized Handler vf() {
        Handler handler;
        synchronized (a.class) {
            handler = cv("commonHT").getHandler();
        }
        return handler;
    }

    public static synchronized Handler vg() {
        Handler handler;
        synchronized (a.class) {
            handler = cv("reportHT").getHandler();
        }
        return handler;
    }
}
