package com.xiaomi.push;

import android.util.Pair;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes7.dex */
public class eq {

    /* renamed from: a  reason: collision with root package name */
    public static Vector<Pair<String, Long>> f37603a = new Vector<>();

    /* renamed from: a  reason: collision with other field name */
    public static ConcurrentHashMap<String, Long> f329a = new ConcurrentHashMap<>();

    public static String a() {
        StringBuilder sb = new StringBuilder();
        synchronized (f37603a) {
            for (int i2 = 0; i2 < f37603a.size(); i2++) {
                Pair<String, Long> elementAt = f37603a.elementAt(i2);
                sb.append((String) elementAt.first);
                sb.append(":");
                sb.append(elementAt.second);
                if (i2 < f37603a.size() - 1) {
                    sb.append(";");
                }
            }
            f37603a.clear();
        }
        return sb.toString();
    }
}
