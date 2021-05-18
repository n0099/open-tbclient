package com.win.opensdk;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.Executors;
/* loaded from: classes7.dex */
public class f1 {

    /* renamed from: a  reason: collision with root package name */
    public static HashMap f37109a;

    static {
        Executors.newFixedThreadPool(1);
        f37109a = new HashMap();
    }

    public static synchronized void a(String str) {
        synchronized (f1.class) {
            f37109a.remove(str);
        }
    }

    public static synchronized void a(String str, e1 e1Var) {
        synchronized (f1.class) {
            HashSet hashSet = (HashSet) f37109a.get(str);
            if (hashSet == null) {
                hashSet = new HashSet();
                f37109a.put(str, hashSet);
            }
            hashSet.add(e1Var);
        }
    }

    public static void a(String str, String str2, Object obj) {
        HashSet hashSet = (HashSet) f37109a.get(str);
        if (hashSet == null || hashSet.size() <= 0) {
            return;
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            ((e1) it.next()).a(str, str2, obj);
        }
    }
}
