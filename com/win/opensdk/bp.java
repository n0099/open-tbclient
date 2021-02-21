package com.win.opensdk;

import com.win.opensdk.bn;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes3.dex */
public class bp<T extends bn> {
    private static bp qjD;
    private ConcurrentHashMap<String, T> qkX = new ConcurrentHashMap<>();

    private bp() {
    }

    public static bp eJw() {
        if (qjD == null) {
            synchronized (bp.class) {
                if (qjD == null) {
                    qjD = new bp();
                }
            }
        }
        return qjD;
    }

    public final void a(String str, T t) {
        synchronized (bp.class) {
            this.qkX.put(str, t);
        }
    }

    public final T abY(String str) {
        T remove;
        synchronized (bp.class) {
            remove = this.qkX.remove(str);
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
