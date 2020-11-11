package tv.chushou.basis.c;

import android.support.annotation.NonNull;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class c {
    private static final Map<String, a> qlB = new HashMap();

    public static a aas(@NonNull String str) {
        a aVar;
        synchronized (qlB) {
            aVar = qlB.get(str);
            if (aVar == null) {
                aVar = new b();
                qlB.put(str, aVar);
            }
        }
        return aVar;
    }
}
