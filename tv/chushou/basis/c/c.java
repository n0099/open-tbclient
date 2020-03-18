package tv.chushou.basis.c;

import android.support.annotation.NonNull;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class c {
    private static final Map<String, a> nXj = new HashMap();

    public static a SJ(@NonNull String str) {
        a aVar;
        synchronized (nXj) {
            aVar = nXj.get(str);
            if (aVar == null) {
                aVar = new b();
                nXj.put(str, aVar);
            }
        }
        return aVar;
    }
}
