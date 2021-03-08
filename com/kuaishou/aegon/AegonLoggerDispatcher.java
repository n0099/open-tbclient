package com.kuaishou.aegon;

import aegon.chrome.net.RequestFinishedInfo;
import android.util.Log;
import androidx.annotation.Keep;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
/* loaded from: classes3.dex */
public class AegonLoggerDispatcher {

    /* renamed from: a  reason: collision with root package name */
    public static ConcurrentLinkedQueue<f> f5409a = new ConcurrentLinkedQueue<>();
    public static Executor b = null;

    public static Executor a() {
        Executor executor = b;
        if (executor == null) {
            synchronized (AegonLoggerDispatcher.class) {
                if (b == null) {
                    b = Executors.newSingleThreadExecutor();
                }
                executor = b;
            }
        }
        return executor;
    }

    @Keep
    public static void onConnectionStats(String str) {
        Log.i("AegonLogger", str);
        if (f5409a.isEmpty()) {
            return;
        }
        Executor a2 = a();
        Iterator<f> it = f5409a.iterator();
        while (it.hasNext()) {
            a2.execute(g.b(it.next(), str));
        }
    }

    @Keep
    public static void onRequestFinished(RequestFinishedInfo requestFinishedInfo, String str) {
        if (f5409a.isEmpty()) {
            return;
        }
        Executor a2 = a();
        Iterator<f> it = f5409a.iterator();
        while (it.hasNext()) {
            a2.execute(h.b(it.next(), requestFinishedInfo, str));
        }
    }
}
