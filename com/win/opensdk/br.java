package com.win.opensdk;

import com.win.opensdk.core.Info;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes3.dex */
public class br {
    private static br qau;
    private ConcurrentHashMap<String, Info> qat = new ConcurrentHashMap<>();

    private br() {
    }

    public static br eGZ() {
        if (qau == null) {
            synchronized (br.class) {
                if (qau == null) {
                    qau = new br();
                }
            }
        }
        return qau;
    }

    public final void a(String str, Info info) {
        synchronized (br.class) {
            this.qat.put(str, info);
        }
    }

    public final Info aaM(String str) {
        Info remove;
        synchronized (br.class) {
            remove = this.qat.remove(str);
        }
        return remove;
    }
}
