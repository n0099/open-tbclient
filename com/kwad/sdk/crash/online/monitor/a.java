package com.kwad.sdk.crash.online.monitor;

import android.text.TextUtils;
import com.kwad.sdk.crash.online.monitor.a.c;
import com.kwad.sdk.crash.online.monitor.block.e;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.g;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class a {
    public static volatile boolean hasInit;

    public static c GE() {
        c cVar = new c();
        com.kwad.sdk.crash.online.monitor.a.a aVar = new com.kwad.sdk.crash.online.monitor.a.a();
        cVar.aFZ = aVar;
        aVar.aFQ = 5;
        return cVar;
    }

    public static /* synthetic */ boolean access$002(boolean z) {
        hasInit = true;
        return true;
    }

    public static void dY(final String str) {
        g.execute(new ay() { // from class: com.kwad.sdk.crash.online.monitor.a.1
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                if (a.hasInit) {
                    return;
                }
                com.kwad.sdk.core.e.c.d("perfMonitor.MonitorManager", "configStr:" + str);
                c eV = a.eV(str);
                com.kwad.sdk.core.e.c.d("perfMonitor.MonitorManager", eV.toJson().toString());
                e.d(eV.aFZ);
                a.access$002(true);
            }
        });
    }

    public static c eV(String str) {
        if (TextUtils.isEmpty(str)) {
            return GE();
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            c cVar = new c();
            cVar.parseJson(jSONObject);
            return cVar;
        } catch (Exception e) {
            com.kwad.sdk.core.e.c.w("perfMonitor.MonitorManager", e);
            return GE();
        }
    }
}
