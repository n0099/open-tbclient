package tv.chushou.basis.c;

import android.support.annotation.NonNull;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class c {
    private static final Map<String, a> oLB = new HashMap();

    public static a WL(@NonNull String str) {
        a aVar;
        synchronized (oLB) {
            aVar = oLB.get(str);
            if (aVar == null) {
                aVar = new b();
                oLB.put(str, aVar);
            }
        }
        return aVar;
    }
}
