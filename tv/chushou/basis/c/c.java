package tv.chushou.basis.c;

import android.support.annotation.NonNull;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class c {
    private static final Map<String, a> pkR = new HashMap();

    public static a Yb(@NonNull String str) {
        a aVar;
        synchronized (pkR) {
            aVar = pkR.get(str);
            if (aVar == null) {
                aVar = new b();
                pkR.put(str, aVar);
            }
        }
        return aVar;
    }
}
