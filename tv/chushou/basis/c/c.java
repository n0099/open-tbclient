package tv.chushou.basis.c;

import android.support.annotation.NonNull;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class c {
    private static final Map<String, a> orI = new HashMap();

    public static a TH(@NonNull String str) {
        a aVar;
        synchronized (orI) {
            aVar = orI.get(str);
            if (aVar == null) {
                aVar = new b();
                orI.put(str, aVar);
            }
        }
        return aVar;
    }
}
