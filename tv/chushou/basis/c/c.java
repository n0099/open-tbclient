package tv.chushou.basis.c;

import android.support.annotation.NonNull;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class c {
    private static final Map<String, a> nNf = new HashMap();

    public static a Sj(@NonNull String str) {
        a aVar;
        synchronized (nNf) {
            aVar = nNf.get(str);
            if (aVar == null) {
                aVar = new b();
                nNf.put(str, aVar);
            }
        }
        return aVar;
    }
}
