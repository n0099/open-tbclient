package com.win.opensdk;

import com.win.opensdk.bn;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes4.dex */
public class bp<T extends bn> {
    private static bp qdz;
    private ConcurrentHashMap<String, T> qeT = new ConcurrentHashMap<>();

    private bp() {
    }

    public static bp eKO() {
        if (qdz == null) {
            synchronized (bp.class) {
                if (qdz == null) {
                    qdz = new bp();
                }
            }
        }
        return qdz;
    }

    public final void a(String str, T t) {
        synchronized (bp.class) {
            this.qeT.put(str, t);
        }
    }

    public final T abS(String str) {
        T remove;
        synchronized (bp.class) {
            remove = this.qeT.remove(str);
        }
        return remove;
    }

    public static String aX(String str, String str2, String str3) {
        if (str.length() > 16) {
            str = str.substring(0, 16);
        }
        return str + str2 + str3;
    }
}
