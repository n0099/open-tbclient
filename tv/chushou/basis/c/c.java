package tv.chushou.basis.c;

import android.support.annotation.NonNull;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class c {
    private static final Map<String, a> nqY = new HashMap();

    public static a Qc(@NonNull String str) {
        a aVar;
        synchronized (nqY) {
            aVar = nqY.get(str);
            if (aVar == null) {
                aVar = new b();
                nqY.put(str, aVar);
            }
        }
        return aVar;
    }
}
