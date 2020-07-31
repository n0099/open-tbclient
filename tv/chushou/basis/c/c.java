package tv.chushou.basis.c;

import android.support.annotation.NonNull;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class c {
    private static final Map<String, a> orG = new HashMap();

    public static a TH(@NonNull String str) {
        a aVar;
        synchronized (orG) {
            aVar = orG.get(str);
            if (aVar == null) {
                aVar = new b();
                orG.put(str, aVar);
            }
        }
        return aVar;
    }
}
