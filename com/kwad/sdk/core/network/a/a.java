package com.kwad.sdk.core.network.a;

import android.util.Log;
import com.kwad.sdk.export.proxy.AdHttpProxy;
import com.kwad.sdk.export.proxy.AdHttpResponseListener;
import com.kwad.sdk.f;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.h;
import java.io.OutputStream;
/* loaded from: classes10.dex */
public final class a {
    public static AdHttpProxy aun;

    /* renamed from: com.kwad.sdk.core.network.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0709a {
        public String msg;
    }

    public static boolean CG() {
        h hVar = (h) ServiceProvider.get(h.class);
        if (hVar != null) {
            return hVar.yz();
        }
        return false;
    }

    public static boolean a(String str, OutputStream outputStream, C0709a c0709a, long j, AdHttpResponseListener adHttpResponseListener) {
        AdHttpProxy aVar;
        boolean CG = CG();
        AdHttpProxy adHttpProxy = aun;
        if (adHttpProxy == null) {
            com.kwad.sdk.core.e.c.d("VideoCacheHelper", "isAdCacheEnable:" + CG);
            if (CG) {
                aVar = f.xI();
            } else {
                aVar = new com.kwad.sdk.core.network.c.a();
            }
            adHttpProxy = aVar;
            aun = adHttpProxy;
        }
        AdHttpProxy adHttpProxy2 = adHttpProxy;
        if (com.kwad.framework.b.a.mc.booleanValue()) {
            if (adHttpProxy2 instanceof com.kwad.sdk.core.network.c.b) {
                com.kwad.sdk.core.e.c.d("VideoCacheHelper", "okHttp");
            } else {
                com.kwad.sdk.core.e.c.d("VideoCacheHelper", "Http");
            }
        }
        try {
            com.kwad.sdk.core.e.c.d("VideoCacheHelper", "downloadUrlToStream success size:" + j + " url:" + str);
            adHttpProxy2.downloadUrlToStream(str, outputStream, j, adHttpResponseListener);
            return true;
        } catch (Exception e) {
            com.kwad.sdk.core.e.c.d("VideoCacheHelper", Log.getStackTraceString(e));
            c0709a.msg = e.getMessage();
            return false;
        }
    }
}
