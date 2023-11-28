package com.kwad.sdk.core.network.idc;

import android.content.Context;
import com.kwad.sdk.core.e.c;
import com.kwad.sdk.crash.utils.h;
import com.kwad.sdk.utils.t;
import com.kwad.sdk.utils.y;
import java.io.IOException;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class b {
    public static void a(Context context, com.kwad.sdk.core.network.idc.a.b bVar) {
        String jSONObject;
        if (bVar == null) {
            jSONObject = "";
        } else {
            jSONObject = bVar.toJson().toString();
        }
        y.a(context, "ksadsdk_idc", "idc_data", jSONObject);
    }

    public static void a(Context context, Map<String, String> map) {
        String str;
        if (map != null && !map.isEmpty()) {
            str = new JSONObject(map).toString();
        } else {
            str = "";
        }
        y.a(context, "ksadsdk_idc", "idc_current", str);
    }

    public static com.kwad.sdk.core.network.idc.a.b aZ(Context context) {
        try {
            return com.kwad.sdk.core.network.idc.a.b.dw(h.J(context, "ksad_idc.json"));
        } catch (IOException e) {
            c.printStackTraceOnly(e);
            return new com.kwad.sdk.core.network.idc.a.b();
        }
    }

    public static com.kwad.sdk.core.network.idc.a.b ba(Context context) {
        return com.kwad.sdk.core.network.idc.a.b.dw(y.b(context, "ksadsdk_idc", "idc_data", ""));
    }

    public static Map<String, String> bb(Context context) {
        return t.parseJSON2MapString(y.b(context, "ksadsdk_idc", "idc_current", ""));
    }
}
