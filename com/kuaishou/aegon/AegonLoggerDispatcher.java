package com.kuaishou.aegon;

import aegon.chrome.net.RequestFinishedInfo;
import android.util.Log;
import androidx.annotation.Keep;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
/* loaded from: classes5.dex */
public class AegonLoggerDispatcher {

    /* renamed from: a  reason: collision with root package name */
    public static ConcurrentLinkedQueue<f> f8406a = new ConcurrentLinkedQueue<>();

    /* renamed from: b  reason: collision with root package name */
    public static Executor f8407b = null;

    public static Executor a() {
        Executor executor = f8407b;
        if (executor == null) {
            synchronized (AegonLoggerDispatcher.class) {
                if (f8407b == null) {
                    f8407b = Executors.newSingleThreadExecutor();
                }
                executor = f8407b;
            }
        }
        return executor;
    }

    @Keep
    public static void onConnectionStats(String str) {
        Log.i("AegonLogger", str);
        if (f8406a.isEmpty()) {
            return;
        }
        Executor a2 = a();
        Iterator<f> it = f8406a.iterator();
        while (it.hasNext()) {
            a2.execute(g.b(it.next(), str));
        }
    }

    @Keep
    public static void onRequestFinished(RequestFinishedInfo requestFinishedInfo, String str) {
        if (f8406a.isEmpty()) {
            return;
        }
        Executor a2 = a();
        Iterator<f> it = f8406a.iterator();
        while (it.hasNext()) {
            a2.execute(h.b(it.next(), requestFinishedInfo, str));
        }
    }
}
