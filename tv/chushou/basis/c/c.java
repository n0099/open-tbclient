package tv.chushou.basis.c;

import android.support.annotation.NonNull;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public class c {
    private static final Map<String, a> nUp = new HashMap();

    public static a Sy(@NonNull String str) {
        a aVar;
        synchronized (nUp) {
            aVar = nUp.get(str);
            if (aVar == null) {
                aVar = new b();
                nUp.put(str, aVar);
            }
        }
        return aVar;
    }
}
