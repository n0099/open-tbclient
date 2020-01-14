package tv.chushou.basis.c;

import android.support.annotation.NonNull;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public class c {
    private static final Map<String, a> nUu = new HashMap();

    public static a Sy(@NonNull String str) {
        a aVar;
        synchronized (nUu) {
            aVar = nUu.get(str);
            if (aVar == null) {
                aVar = new b();
                nUu.put(str, aVar);
            }
        }
        return aVar;
    }
}
