package com.win.opensdk;

import com.win.opensdk.bn;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes3.dex */
public class bp<T extends bn> {
    private static bp qjd;
    private ConcurrentHashMap<String, T> qkx = new ConcurrentHashMap<>();

    private bp() {
    }

    public static bp eJo() {
        if (qjd == null) {
            synchronized (bp.class) {
                if (qjd == null) {
                    qjd = new bp();
                }
            }
        }
        return qjd;
    }

    public final void a(String str, T t) {
        synchronized (bp.class) {
            this.qkx.put(str, t);
        }
    }

    public final T abM(String str) {
        T remove;
        synchronized (bp.class) {
            remove = this.qkx.remove(str);
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
