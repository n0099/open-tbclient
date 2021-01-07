package com.win.opensdk;

import com.win.opensdk.core.Info;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes4.dex */
public class br {
    private static br qeU;
    private ConcurrentHashMap<String, Info> qeT = new ConcurrentHashMap<>();

    private br() {
    }

    public static br eKP() {
        if (qeU == null) {
            synchronized (br.class) {
                if (qeU == null) {
                    qeU = new br();
                }
            }
        }
        return qeU;
    }

    public final void a(String str, Info info) {
        synchronized (br.class) {
            this.qeT.put(str, info);
        }
    }

    public final Info abT(String str) {
        Info remove;
        synchronized (br.class) {
            remove = this.qeT.remove(str);
        }
        return remove;
    }
}
