package com.kwad.sdk.core.network.idc;

import android.content.Context;
import com.kwad.sdk.crash.utils.g;
import com.kwad.sdk.utils.as;
import com.kwad.sdk.utils.r;
import java.io.IOException;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class b {
    public static com.kwad.sdk.core.network.idc.kwai.a a(Context context) {
        try {
            return com.kwad.sdk.core.network.idc.kwai.a.b(g.a(context, "ksad_idc.json"));
        } catch (IOException e) {
            com.kwad.sdk.core.d.b.b(e);
            return new com.kwad.sdk.core.network.idc.kwai.a();
        }
    }

    public static void a(Context context, com.kwad.sdk.core.network.idc.kwai.a aVar) {
        as.a(context, "ksadsdk_idc", "idc_data", aVar == null ? "" : aVar.toJson().toString());
    }

    public static void a(Context context, Map<String, String> map) {
        as.a(context, "ksadsdk_idc", "idc_current", (map == null || map.isEmpty()) ? "" : new JSONObject(map).toString());
    }

    public static com.kwad.sdk.core.network.idc.kwai.a b(Context context) {
        return com.kwad.sdk.core.network.idc.kwai.a.b(as.b(context, "ksadsdk_idc", "idc_data", ""));
    }

    public static Map<String, String> c(Context context) {
        return r.b(as.b(context, "ksadsdk_idc", "idc_current", ""));
    }
}
