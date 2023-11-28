package com.kwad.sdk.crash.online.monitor.block;

import android.text.TextUtils;
import android.util.Log;
import com.kwad.sdk.ranger.RangerInjector;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.h;
/* loaded from: classes10.dex */
public final class c {
    public static volatile boolean aFB;

    public static String a(com.kwad.sdk.crash.online.monitor.a.b bVar) {
        String str;
        if (bVar != null && !TextUtils.isEmpty(bVar.aFU)) {
            str = bVar.aFU;
        } else {
            str = "b25SZXBvcnRJc3N1ZQ==";
        }
        String str2 = new String(com.kwad.sdk.core.a.c.Ck().decode(str));
        com.kwad.sdk.core.e.c.d("perfMonitor.Injector", "report methodName:" + str2);
        return str2;
    }

    public static String b(com.kwad.sdk.crash.online.monitor.a.b bVar) {
        String str;
        if (bVar != null && !TextUtils.isEmpty(bVar.aFT)) {
            str = bVar.aFT;
        } else {
            str = "Y29tLnRlbmNlbnQubWF0cml4LnBsdWdpbi5QbHVnaW5MaXN0ZW5lcg==";
        }
        String str2 = new String(com.kwad.sdk.core.a.c.Ck().decode(str));
        com.kwad.sdk.core.e.c.d("perfMonitor.Injector", "ListenerName:" + str2);
        return str2;
    }

    public static com.kwad.sdk.crash.online.monitor.a.b c(com.kwad.sdk.crash.online.monitor.a.a aVar) {
        String str;
        h hVar = (h) ServiceProvider.get(h.class);
        if (hVar != null) {
            str = hVar.getAppId();
        } else {
            str = "";
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return aVar.fd(str);
    }

    public static void onError(String str) {
        f.fc(str);
        com.kwad.sdk.core.e.c.w("perfMonitor.Injector", str);
    }

    public static void b(com.kwad.sdk.crash.online.monitor.a.a aVar) {
        if (aFB) {
            return;
        }
        try {
            com.kwad.sdk.crash.online.monitor.a.b c = c(aVar);
            RangerInjector.a(b(c), a(c), new RangerInjector.b() { // from class: com.kwad.sdk.crash.online.monitor.block.c.1
                @Override // com.kwad.sdk.ranger.RangerInjector.b
                public final void a(String str, long j, long j2, String str2, String str3) {
                    f.a(str, j, j2, str2, str3, false);
                }

                @Override // com.kwad.sdk.ranger.RangerInjector.b
                public final void onError(String str) {
                    c.onError(str);
                }
            });
            aFB = true;
        } catch (Exception e) {
            onError(Log.getStackTraceString(e));
        }
    }
}
