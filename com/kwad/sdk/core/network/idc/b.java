package com.kwad.sdk.core.network.idc;

import android.content.Context;
import com.kwad.sdk.crash.utils.g;
import com.kwad.sdk.utils.r;
import com.kwad.sdk.utils.w;
import java.io.IOException;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class b {
    public static void a(Context context, com.kwad.sdk.core.network.idc.kwai.a aVar) {
        w.c(context, "ksadsdk_idc", "idc_data", aVar == null ? "" : aVar.toJson().toString());
    }

    public static void a(Context context, Map map) {
        w.c(context, "ksadsdk_idc", "idc_current", (map == null || map.isEmpty()) ? "" : new JSONObject(map).toString());
    }

    public static com.kwad.sdk.core.network.idc.kwai.a bs(Context context) {
        try {
            return com.kwad.sdk.core.network.idc.kwai.a.cb(g.u(context, "ksad_idc.json"));
        } catch (IOException e) {
            com.kwad.sdk.core.e.b.printStackTraceOnly(e);
            return new com.kwad.sdk.core.network.idc.kwai.a();
        }
    }

    public static com.kwad.sdk.core.network.idc.kwai.a bt(Context context) {
        return com.kwad.sdk.core.network.idc.kwai.a.cb(w.d(context, "ksadsdk_idc", "idc_data", ""));
    }

    public static Map bu(Context context) {
        return r.parseJSON2MapString(w.d(context, "ksadsdk_idc", "idc_current", ""));
    }
}
