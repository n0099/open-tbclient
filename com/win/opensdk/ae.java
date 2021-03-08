package com.win.opensdk;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.Executors;
/* loaded from: classes14.dex */
public class ae {

    /* renamed from: a  reason: collision with root package name */
    public static HashMap f8106a;

    static {
        Executors.newFixedThreadPool(1);
        f8106a = new HashMap();
    }

    public static synchronized void a(String str) {
        synchronized (ae.class) {
            f8106a.remove(str);
        }
    }

    public static synchronized void a(String str, ab abVar) {
        synchronized (ae.class) {
            HashSet hashSet = (HashSet) f8106a.get(str);
            if (hashSet == null) {
                hashSet = new HashSet();
                f8106a.put(str, hashSet);
            }
            hashSet.add(abVar);
        }
    }

    public static void a(String str, String str2, Object obj) {
        HashSet hashSet = (HashSet) f8106a.get(str);
        if (hashSet == null || hashSet.size() <= 0) {
            return;
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            ((ab) it.next()).a(str, str2, obj);
        }
    }
}
