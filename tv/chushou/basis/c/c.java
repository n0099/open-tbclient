package tv.chushou.basis.c;

import android.support.annotation.NonNull;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class c {
    private static final Map<String, a> qne = new HashMap();

    public static a aad(@NonNull String str) {
        a aVar;
        synchronized (qne) {
            aVar = qne.get(str);
            if (aVar == null) {
                aVar = new b();
                qne.put(str, aVar);
            }
        }
        return aVar;
    }
}
