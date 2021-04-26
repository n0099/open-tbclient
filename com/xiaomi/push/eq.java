package com.xiaomi.push;

import android.util.Pair;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes7.dex */
public class eq {

    /* renamed from: a  reason: collision with root package name */
    public static Vector<Pair<String, Long>> f38358a = new Vector<>();

    /* renamed from: a  reason: collision with other field name */
    public static ConcurrentHashMap<String, Long> f329a = new ConcurrentHashMap<>();

    public static String a() {
        StringBuilder sb = new StringBuilder();
        synchronized (f38358a) {
            for (int i2 = 0; i2 < f38358a.size(); i2++) {
                Pair<String, Long> elementAt = f38358a.elementAt(i2);
                sb.append((String) elementAt.first);
                sb.append(":");
                sb.append(elementAt.second);
                if (i2 < f38358a.size() - 1) {
                    sb.append(";");
                }
            }
            f38358a.clear();
        }
        return sb.toString();
    }
}
