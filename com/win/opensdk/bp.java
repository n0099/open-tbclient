package com.win.opensdk;

import com.win.opensdk.bn;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes3.dex */
public class bp<T extends bn> {
    private static bp pYY;
    private ConcurrentHashMap<String, T> qas = new ConcurrentHashMap<>();

    private bp() {
    }

    public static bp eGY() {
        if (pYY == null) {
            synchronized (bp.class) {
                if (pYY == null) {
                    pYY = new bp();
                }
            }
        }
        return pYY;
    }

    public final void a(String str, T t) {
        synchronized (bp.class) {
            this.qas.put(str, t);
        }
    }

    public final T aaK(String str) {
        T remove;
        synchronized (bp.class) {
            remove = this.qas.remove(str);
        }
        return remove;
    }

    public static String aW(String str, String str2, String str3) {
        if (str.length() > 16) {
            str = str.substring(0, 16);
        }
        return str + str2 + str3;
    }
}
