package com.kwad.sdk.core.threads;

import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes5.dex */
public final class a {
    public static Map<String, WeakReference<C0393a>> adw = new ConcurrentHashMap();

    /* renamed from: com.kwad.sdk.core.threads.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0393a {
        public HandlerThread adx;
        public Handler mHandler;

        public C0393a(String str) {
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
    public static C0393a cv(String str) {
        WeakReference<C0393a> weakReference = adw.get(str);
        if (weakReference == null || weakReference.get() == null) {
            C0393a c0393a = new C0393a(str);
            adw.put(str, new WeakReference<>(c0393a));
            return c0393a;
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
