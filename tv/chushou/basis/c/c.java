package tv.chushou.basis.c;

import android.support.annotation.NonNull;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class c {
    private static final Map<String, a> oiT = new HashMap();

    public static a SV(@NonNull String str) {
        a aVar;
        synchronized (oiT) {
            aVar = oiT.get(str);
            if (aVar == null) {
                aVar = new b();
                oiT.put(str, aVar);
            }
        }
        return aVar;
    }
}
