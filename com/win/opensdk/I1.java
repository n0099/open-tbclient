package com.win.opensdk;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.Executors;
/* loaded from: classes7.dex */
public class I1 {

    /* renamed from: a  reason: collision with root package name */
    public static HashMap f39687a;

    static {
        Executors.newFixedThreadPool(1);
        f39687a = new HashMap();
    }

    public static synchronized void a(String str) {
        synchronized (I1.class) {
            f39687a.remove(str);
        }
    }

    public static synchronized void a(String str, H1 h1) {
        synchronized (I1.class) {
            HashSet hashSet = (HashSet) f39687a.get(str);
            if (hashSet == null) {
                hashSet = new HashSet();
                f39687a.put(str, hashSet);
            }
            hashSet.add(h1);
        }
    }

    public static void a(String str, String str2, Object obj) {
        HashSet hashSet = (HashSet) f39687a.get(str);
        if (hashSet == null || hashSet.size() <= 0) {
            return;
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            ((H1) it.next()).a(str, str2, obj);
        }
    }
}
