package com.win.opensdk;

import com.win.opensdk.core.Info;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes4.dex */
public class br {
    private static br qdm;
    private ConcurrentHashMap<String, Info> qdl = new ConcurrentHashMap<>();

    private br() {
    }

    public static br eKl() {
        if (qdm == null) {
            synchronized (br.class) {
                if (qdm == null) {
                    qdm = new br();
                }
            }
        }
        return qdm;
    }

    public final void a(String str, Info info) {
        synchronized (br.class) {
            this.qdl.put(str, info);
        }
    }

    public final Info abS(String str) {
        Info remove;
        synchronized (br.class) {
            remove = this.qdl.remove(str);
        }
        return remove;
    }
}
