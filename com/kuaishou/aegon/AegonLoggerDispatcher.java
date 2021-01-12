package com.kuaishou.aegon;

import aegon.chrome.net.RequestFinishedInfo;
import android.util.Log;
import androidx.annotation.Keep;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
/* loaded from: classes4.dex */
public class AegonLoggerDispatcher {

    /* renamed from: a  reason: collision with root package name */
    public static ConcurrentLinkedQueue<f> f8107a = new ConcurrentLinkedQueue<>();

    /* renamed from: b  reason: collision with root package name */
    public static Executor f8108b = null;

    public static Executor a() {
        Executor executor = f8108b;
        if (executor == null) {
            synchronized (AegonLoggerDispatcher.class) {
                if (f8108b == null) {
                    f8108b = Executors.newSingleThreadExecutor();
                }
                executor = f8108b;
            }
        }
        return executor;
    }

    @Keep
    public static void onConnectionStats(String str) {
        Log.i("AegonLogger", str);
        if (f8107a.isEmpty()) {
            return;
        }
        Executor a2 = a();
        Iterator<f> it = f8107a.iterator();
        while (it.hasNext()) {
            a2.execute(g.b(it.next(), str));
        }
    }

    @Keep
    public static void onRequestFinished(RequestFinishedInfo requestFinishedInfo, String str) {
        if (f8107a.isEmpty()) {
            return;
        }
        Executor a2 = a();
        Iterator<f> it = f8107a.iterator();
        while (it.hasNext()) {
            a2.execute(h.b(it.next(), requestFinishedInfo, str));
        }
    }
}
