package com.xiaomi.push;

import android.util.Pair;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes7.dex */
public class eq {

    /* renamed from: a  reason: collision with root package name */
    public static Vector<Pair<String, Long>> f41314a = new Vector<>();

    /* renamed from: a  reason: collision with other field name */
    public static ConcurrentHashMap<String, Long> f329a = new ConcurrentHashMap<>();

    public static String a() {
        StringBuilder sb = new StringBuilder();
        synchronized (f41314a) {
            for (int i2 = 0; i2 < f41314a.size(); i2++) {
                Pair<String, Long> elementAt = f41314a.elementAt(i2);
                sb.append((String) elementAt.first);
                sb.append(":");
                sb.append(elementAt.second);
                if (i2 < f41314a.size() - 1) {
                    sb.append(";");
                }
            }
            f41314a.clear();
        }
        return sb.toString();
    }
}
