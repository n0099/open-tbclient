package com.kwad.sdk.collector;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.aj;
import com.kwad.sdk.utils.am;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes10.dex */
public final class f {
    public static g aJ(Context context) {
        int i;
        boolean cr = am.cr(context);
        com.kwad.sdk.core.e.c.d("InfoCollector", "queryAccessibilityServicePermission result: " + cr);
        if (cr) {
            i = g.PERMISSION_GRANTED;
        } else {
            i = g.PERMISSION_DENIED;
        }
        return new g(com.kuaishou.weapon.p0.g.k, i);
    }

    @NonNull
    public static List<g> aK(Context context) {
        int i;
        ArrayList arrayList = new ArrayList();
        if (context == null) {
            return arrayList;
        }
        String[] cq = aj.cq(context);
        if (cq != null) {
            for (String str : cq) {
                int aq = am.aq(context, str);
                if (aq == 0) {
                    i = g.PERMISSION_GRANTED;
                } else if (aq == -1) {
                    i = g.PERMISSION_DENIED;
                } else {
                    i = g.amZ;
                }
                arrayList.add(new g(str, i));
            }
        }
        return arrayList;
    }

    @Nullable
    public static JSONArray zD() {
        Context context = ServiceProvider.getContext();
        List<g> aK = aK(context);
        aK.add(aJ(context));
        return g.r(aK);
    }
}
