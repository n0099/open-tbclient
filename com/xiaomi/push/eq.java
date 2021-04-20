package com.xiaomi.push;

import android.util.Pair;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes7.dex */
public class eq {

    /* renamed from: a  reason: collision with root package name */
    public static Vector<Pair<String, Long>> f40744a = new Vector<>();

    /* renamed from: a  reason: collision with other field name */
    public static ConcurrentHashMap<String, Long> f329a = new ConcurrentHashMap<>();

    public static String a() {
        StringBuilder sb = new StringBuilder();
        synchronized (f40744a) {
            for (int i = 0; i < f40744a.size(); i++) {
                Pair<String, Long> elementAt = f40744a.elementAt(i);
                sb.append((String) elementAt.first);
                sb.append(":");
                sb.append(elementAt.second);
                if (i < f40744a.size() - 1) {
                    sb.append(";");
                }
            }
            f40744a.clear();
        }
        return sb.toString();
    }
}
