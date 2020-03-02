package tv.chushou.basis.c;

import android.support.annotation.NonNull;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class c {
    private static final Map<String, a> nVl = new HashMap();

    public static a SJ(@NonNull String str) {
        a aVar;
        synchronized (nVl) {
            aVar = nVl.get(str);
            if (aVar == null) {
                aVar = new b();
                nVl.put(str, aVar);
            }
        }
        return aVar;
    }
}
