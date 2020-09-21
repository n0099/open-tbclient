package tv.chushou.basis.c;

import android.support.annotation.NonNull;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class c {
    private static final Map<String, a> oVx = new HashMap();

    public static a Xn(@NonNull String str) {
        a aVar;
        synchronized (oVx) {
            aVar = oVx.get(str);
            if (aVar == null) {
                aVar = new b();
                oVx.put(str, aVar);
            }
        }
        return aVar;
    }
}
