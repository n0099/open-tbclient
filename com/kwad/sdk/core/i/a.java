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
    public static Map<String, WeakReference<C2087a>> a = new ConcurrentHashMap();

    /* renamed from: com.kwad.sdk.core.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C2087a {
        public HandlerThread a;

        /* renamed from: b  reason: collision with root package name */
        public Handler f58052b;

        public C2087a(String str) {
            String str2;
            if (TextUtils.isEmpty(str)) {
                str2 = "ksad-HandlerThread";
            } else {
                str2 = DiskLruCache.KS_THREAD_PREFIX + str;
            }
            HandlerThread handlerThread = new HandlerThread(str2);
            this.a = handlerThread;
            handlerThread.start();
            this.f58052b = new Handler(this.a.getLooper());
        }

        public Handler a() {
            return this.f58052b;
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
    public static C2087a a(String str) {
        if (str == null) {
            return new C2087a(null);
        }
        WeakReference<C2087a> weakReference = a.get(str);
        if (weakReference == null || weakReference.get() == null) {
            C2087a c2087a = new C2087a(str);
            a.put(str, new WeakReference<>(c2087a));
            return c2087a;
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
