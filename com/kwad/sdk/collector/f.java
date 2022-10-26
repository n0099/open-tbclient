package com.kwad.sdk.collector;

import android.content.Context;
import com.kwad.sdk.utils.ah;
import com.kwad.sdk.utils.aj;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes7.dex */
public final class f {
    public static JSONArray aL(Context context) {
        List aN = aN(context);
        aN.add(aM(context));
        return g.l(aN);
    }

    public static g aM(Context context) {
        boolean cF = aj.cF(context);
        com.kwad.sdk.core.e.b.d("InfoCollector", "queryAccessibilityServicePermission result: " + cF);
        return new g(com.kuaishou.weapon.p0.h.k, cF ? g.PERMISSION_GRANTED : g.PERMISSION_DENIED);
    }

    public static List aN(Context context) {
        String[] cE;
        ArrayList arrayList = new ArrayList();
        if (context != null && (cE = ah.cE(context)) != null) {
            for (String str : cE) {
                int Y = aj.Y(context, str);
                arrayList.add(new g(str, Y == 0 ? g.PERMISSION_GRANTED : Y == -1 ? g.PERMISSION_DENIED : g.SP));
            }
        }
        return arrayList;
    }
}
