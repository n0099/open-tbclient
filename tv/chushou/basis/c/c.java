package tv.chushou.basis.c;

import android.support.annotation.NonNull;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class c {
    private static final Map<String, a> nLV = new HashMap();

    public static a Si(@NonNull String str) {
        a aVar;
        synchronized (nLV) {
            aVar = nLV.get(str);
            if (aVar == null) {
                aVar = new b();
                nLV.put(str, aVar);
            }
        }
        return aVar;
    }
}
