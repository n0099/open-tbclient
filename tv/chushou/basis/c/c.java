package tv.chushou.basis.c;

import android.support.annotation.NonNull;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class c {
    private static final Map<String, a> qcg = new HashMap();

    public static a ZO(@NonNull String str) {
        a aVar;
        synchronized (qcg) {
            aVar = qcg.get(str);
            if (aVar == null) {
                aVar = new b();
                qcg.put(str, aVar);
            }
        }
        return aVar;
    }
}
