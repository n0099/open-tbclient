package com.win.opensdk;

import com.win.opensdk.bn;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes4.dex */
public class bp<T extends bn> {
    private static bp qbR;
    private ConcurrentHashMap<String, T> qdl = new ConcurrentHashMap<>();

    private bp() {
    }

    public static bp eKk() {
        if (qbR == null) {
            synchronized (bp.class) {
                if (qbR == null) {
                    qbR = new bp();
                }
            }
        }
        return qbR;
    }

    public final void a(String str, T t) {
        synchronized (bp.class) {
            this.qdl.put(str, t);
        }
    }

    public final T abR(String str) {
        T remove;
        synchronized (bp.class) {
            remove = this.qdl.remove(str);
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
