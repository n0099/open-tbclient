package com.win.opensdk;

import com.win.opensdk.bn;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes3.dex */
public class bp<T extends bn> {
    private static bp pYZ;
    private ConcurrentHashMap<String, T> qat = new ConcurrentHashMap<>();

    private bp() {
    }

    public static bp eGY() {
        if (pYZ == null) {
            synchronized (bp.class) {
                if (pYZ == null) {
                    pYZ = new bp();
                }
            }
        }
        return pYZ;
    }

    public final void a(String str, T t) {
        synchronized (bp.class) {
            this.qat.put(str, t);
        }
    }

    public final T aaL(String str) {
        T remove;
        synchronized (bp.class) {
            remove = this.qat.remove(str);
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
