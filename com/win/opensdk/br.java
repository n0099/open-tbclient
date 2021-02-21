package com.win.opensdk;

import com.win.opensdk.core.Info;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes3.dex */
public class br {
    private static br qkY;
    private ConcurrentHashMap<String, Info> qkX = new ConcurrentHashMap<>();

    private br() {
    }

    public static br eJx() {
        if (qkY == null) {
            synchronized (br.class) {
                if (qkY == null) {
                    qkY = new br();
                }
            }
        }
        return qkY;
    }

    public final void a(String str, Info info) {
        synchronized (br.class) {
            this.qkX.put(str, info);
        }
    }

    public final Info abZ(String str) {
        Info remove;
        synchronized (br.class) {
            remove = this.qkX.remove(str);
        }
        return remove;
    }
}
