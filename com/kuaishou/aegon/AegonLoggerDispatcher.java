package com.kuaishou.aegon;

import aegon.chrome.net.RequestFinishedInfo;
import android.util.Log;
import androidx.annotation.Keep;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
/* loaded from: classes6.dex */
public class AegonLoggerDispatcher {

    /* renamed from: a  reason: collision with root package name */
    public static ConcurrentLinkedQueue<a> f31605a = new ConcurrentLinkedQueue<>();

    /* renamed from: b  reason: collision with root package name */
    public static Executor f31606b = null;

    public static Executor a() {
        Executor executor;
        Executor executor2 = f31606b;
        if (executor2 != null) {
            return executor2;
        }
        synchronized (AegonLoggerDispatcher.class) {
            if (f31606b == null) {
                f31606b = Executors.newSingleThreadExecutor();
            }
            executor = f31606b;
        }
        return executor;
    }

    public static void a(a aVar) {
        f31605a.add(aVar);
    }

    public static void b(a aVar) {
        f31605a.remove(aVar);
    }

    @Keep
    public static void onConnectionStats(String str) {
        Log.i("AegonLogger", str);
        if (f31605a.isEmpty()) {
            return;
        }
        Executor a2 = a();
        Iterator<a> it = f31605a.iterator();
        while (it.hasNext()) {
            a2.execute(b.a(it.next(), str));
        }
    }

    @Keep
    public static void onRequestFinished(RequestFinishedInfo requestFinishedInfo, String str) {
        if (f31605a.isEmpty()) {
            return;
        }
        Executor a2 = a();
        Iterator<a> it = f31605a.iterator();
        while (it.hasNext()) {
            a2.execute(c.a(it.next(), requestFinishedInfo, str));
        }
    }
}
