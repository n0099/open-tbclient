package com.kwad.sdk.core.threads;

import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes7.dex */
public final class a {
    public static Map<String, WeakReference<C0609a>> adw = new ConcurrentHashMap();

    /* renamed from: com.kwad.sdk.core.threads.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0609a {
        public HandlerThread adx;
        public Handler mHandler;

        public C0609a(String str) {
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
    public static C0609a cv(String str) {
        WeakReference<C0609a> weakReference = adw.get(str);
        if (weakReference == null || weakReference.get() == null) {
            C0609a c0609a = new C0609a(str);
            adw.put(str, new WeakReference<>(c0609a));
            return c0609a;
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
