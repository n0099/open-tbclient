package com.xiaomi.push;

import android.util.Pair;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes7.dex */
public class eq {

    /* renamed from: a  reason: collision with root package name */
    public static Vector<Pair<String, Long>> f40455a = new Vector<>();

    /* renamed from: a  reason: collision with other field name */
    public static ConcurrentHashMap<String, Long> f329a = new ConcurrentHashMap<>();

    public static String a() {
        StringBuilder sb = new StringBuilder();
        synchronized (f40455a) {
            for (int i = 0; i < f40455a.size(); i++) {
                Pair<String, Long> elementAt = f40455a.elementAt(i);
                sb.append((String) elementAt.first);
                sb.append(":");
                sb.append(elementAt.second);
                if (i < f40455a.size() - 1) {
                    sb.append(";");
                }
            }
            f40455a.clear();
        }
        return sb.toString();
    }
}
