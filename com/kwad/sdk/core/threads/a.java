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
    public static Map<String, WeakReference<C0545a>> a = new ConcurrentHashMap();

    /* renamed from: com.kwad.sdk.core.threads.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0545a {
        public HandlerThread a;
        public Handler b;

        public C0545a(String str) {
            String str2;
            if (TextUtils.isEmpty(str)) {
                str2 = "ksad-HT";
            } else {
                str2 = "ksad-" + str;
            }
            HandlerThread handlerThread = new HandlerThread(str2);
            this.a = handlerThread;
            handlerThread.start();
            this.b = new Handler(this.a.getLooper());
        }

        public final Handler a() {
            return this.b;
        }
    }

    public static synchronized Handler a() {
        Handler a2;
        synchronized (a.class) {
            a2 = a("commonHT").a();
        }
        return a2;
    }

    @NonNull
    public static C0545a a(String str) {
        WeakReference<C0545a> weakReference = a.get(str);
        if (weakReference == null || weakReference.get() == null) {
            C0545a c0545a = new C0545a(str);
            a.put(str, new WeakReference<>(c0545a));
            return c0545a;
        }
        return weakReference.get();
    }

    public static synchronized Handler b() {
        Handler a2;
        synchronized (a.class) {
            a2 = a("reportHT").a();
        }
        return a2;
    }
}
