package com.kwad.sdk.core.i;

import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.imageloader.cache.disc.impl.ext.DiskLruCache;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes3.dex */
public class a {
    public static Map<String, WeakReference<C2104a>> a = new ConcurrentHashMap();

    /* renamed from: com.kwad.sdk.core.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C2104a {
        public HandlerThread a;

        /* renamed from: b  reason: collision with root package name */
        public Handler f55856b;

        public C2104a(String str) {
            String str2;
            if (TextUtils.isEmpty(str)) {
                str2 = "ksad-HandlerThread";
            } else {
                str2 = DiskLruCache.KS_THREAD_PREFIX + str;
            }
            HandlerThread handlerThread = new HandlerThread(str2);
            this.a = handlerThread;
            handlerThread.start();
            this.f55856b = new Handler(this.a.getLooper());
        }

        public Handler a() {
            return this.f55856b;
        }
    }

    public static synchronized Handler a() {
        Handler a2;
        synchronized (a.class) {
            a2 = a("commonHandlerThread").a();
        }
        return a2;
    }

    @NonNull
    public static C2104a a(String str) {
        if (str == null) {
            return new C2104a(null);
        }
        WeakReference<C2104a> weakReference = a.get(str);
        if (weakReference == null || weakReference.get() == null) {
            C2104a c2104a = new C2104a(str);
            a.put(str, new WeakReference<>(c2104a));
            return c2104a;
        }
        return weakReference.get();
    }

    public static synchronized Handler b() {
        Handler a2;
        synchronized (a.class) {
            a2 = a("reportHandlerThread").a();
        }
        return a2;
    }
}
