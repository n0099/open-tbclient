package tv.chushou.basis.c;

import android.support.annotation.NonNull;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class c {
    private static final Map<String, a> oiW = new HashMap();

    public static a SW(@NonNull String str) {
        a aVar;
        synchronized (oiW) {
            aVar = oiW.get(str);
            if (aVar == null) {
                aVar = new b();
                oiW.put(str, aVar);
            }
        }
        return aVar;
    }
}
