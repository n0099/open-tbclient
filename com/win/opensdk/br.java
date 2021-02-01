package com.win.opensdk;

import com.win.opensdk.core.Info;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes3.dex */
public class br {
    private static br qky;
    private ConcurrentHashMap<String, Info> qkx = new ConcurrentHashMap<>();

    private br() {
    }

    public static br eJp() {
        if (qky == null) {
            synchronized (br.class) {
                if (qky == null) {
                    qky = new br();
                }
            }
        }
        return qky;
    }

    public final void a(String str, Info info) {
        synchronized (br.class) {
            this.qkx.put(str, info);
        }
    }

    public final Info abN(String str) {
        Info remove;
        synchronized (br.class) {
            remove = this.qkx.remove(str);
        }
        return remove;
    }
}
