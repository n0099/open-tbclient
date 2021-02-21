package com.win.opensdk;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes3.dex */
public final class ar {
    private static ExecutorService qkH = Executors.newFixedThreadPool(1);
    private static HashMap<String, HashSet<a>> qkA = new HashMap<>();

    /* loaded from: classes3.dex */
    public interface a {
        void f(String str, String str2, Object obj);
    }

    public static synchronized void a(String str, a aVar) {
        synchronized (ar.class) {
            HashSet<a> hashSet = qkA.get(str);
            if (hashSet == null) {
                hashSet = new HashSet<>();
                qkA.put(str, hashSet);
            }
            hashSet.add(aVar);
        }
    }

    public static synchronized void abR(String str) {
        synchronized (ar.class) {
            qkA.remove(str);
        }
    }

    public static void f(String str, String str2, Object obj) {
        HashSet<a> hashSet = qkA.get(str);
        if (hashSet != null && hashSet.size() > 0) {
            Iterator<a> it = hashSet.iterator();
            while (it.hasNext()) {
                it.next().f(str, str2, obj);
            }
        }
    }
}
