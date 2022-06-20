package com.kwad.sdk.core.i;

import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.imageloader.cache.disc.impl.ext.DiskLruCache;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes5.dex */
public class a {
    public static Map<String, WeakReference<C0308a>> a = new ConcurrentHashMap();

    /* renamed from: com.kwad.sdk.core.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0308a {
        public HandlerThread a;
        public Handler b;

        public C0308a(String str) {
            String str2;
            if (TextUtils.isEmpty(str)) {
                str2 = "ksad-HandlerThread";
            } else {
                str2 = DiskLruCache.KS_THREAD_PREFIX + str;
            }
            HandlerThread handlerThread = new HandlerThread(str2);
            this.a = handlerThread;
            handlerThread.start();
            this.b = new Handler(this.a.getLooper());
        }

        public Handler a() {
            return this.b;
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
    public static C0308a a(String str) {
        if (str == null) {
            return new C0308a(null);
        }
        WeakReference<C0308a> weakReference = a.get(str);
        if (weakReference == null || weakReference.get() == null) {
            C0308a c0308a = new C0308a(str);
            a.put(str, new WeakReference<>(c0308a));
            return c0308a;
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
