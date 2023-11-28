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
    public static Map<String, WeakReference<C0712a>> azr = new ConcurrentHashMap();

    /* renamed from: com.kwad.sdk.core.threads.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0712a {
        public HandlerThread azs;
        public Handler fS;

        public C0712a(String str) {
            String str2;
            if (TextUtils.isEmpty(str)) {
                str2 = "ksad-HT";
            } else {
                str2 = "ksad-" + str;
            }
            HandlerThread handlerThread = new HandlerThread(str2);
            this.azs = handlerThread;
            handlerThread.start();
            this.fS = new Handler(this.azs.getLooper());
        }

        public final Handler getHandler() {
            return this.fS;
        }
    }

    public static synchronized Handler Ep() {
        Handler handler;
        synchronized (a.class) {
            handler = dW("commonHT").getHandler();
        }
        return handler;
    }

    public static synchronized Handler Eq() {
        Handler handler;
        synchronized (a.class) {
            handler = dW("reportHT").getHandler();
        }
        return handler;
    }

    @NonNull
    public static C0712a dW(String str) {
        WeakReference<C0712a> weakReference = azr.get(str);
        if (weakReference != null && weakReference.get() != null) {
            return weakReference.get();
        }
        C0712a c0712a = new C0712a(str);
        azr.put(str, new WeakReference<>(c0712a));
        return c0712a;
    }
}
