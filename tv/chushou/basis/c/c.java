package tv.chushou.basis.c;

import android.support.annotation.NonNull;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class c {
    private static final Map<String, a> nVw = new HashMap();

    public static a SK(@NonNull String str) {
        a aVar;
        synchronized (nVw) {
            aVar = nVw.get(str);
            if (aVar == null) {
                aVar = new b();
                nVw.put(str, aVar);
            }
        }
        return aVar;
    }
}
