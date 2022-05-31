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
    public static Map<String, WeakReference<C0300a>> a = new ConcurrentHashMap();

    /* renamed from: com.kwad.sdk.core.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0300a {
        public HandlerThread a;
        public Handler b;

        public C0300a(String str) {
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
    public static C0300a a(String str) {
        if (str == null) {
            return new C0300a(null);
        }
        WeakReference<C0300a> weakReference = a.get(str);
        if (weakReference == null || weakReference.get() == null) {
            C0300a c0300a = new C0300a(str);
            a.put(str, new WeakReference<>(c0300a));
            return c0300a;
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
