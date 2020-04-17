package tv.chushou.basis.c;

import android.support.annotation.NonNull;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class c {
    private static final Map<String, a> nqV = new HashMap();

    public static a PZ(@NonNull String str) {
        a aVar;
        synchronized (nqV) {
            aVar = nqV.get(str);
            if (aVar == null) {
                aVar = new b();
                nqV.put(str, aVar);
            }
        }
        return aVar;
    }
}
