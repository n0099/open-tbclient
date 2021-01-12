package com.win.opensdk;

import com.win.opensdk.core.Info;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes3.dex */
public class br {
    private static br qat;
    private ConcurrentHashMap<String, Info> qas = new ConcurrentHashMap<>();

    private br() {
    }

    public static br eGZ() {
        if (qat == null) {
            synchronized (br.class) {
                if (qat == null) {
                    qat = new br();
                }
            }
        }
        return qat;
    }

    public final void a(String str, Info info) {
        synchronized (br.class) {
            this.qas.put(str, info);
        }
    }

    public final Info aaL(String str) {
        Info remove;
        synchronized (br.class) {
            remove = this.qas.remove(str);
        }
        return remove;
    }
}
