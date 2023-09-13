package com.kwad.sdk.c;

import com.baidu.searchbox.cloudcontrol.utils.CloudStabilityUBCUtils;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class b implements a {
    public static volatile b aip;
    public static c aiq;

    public static String a(boolean z, Object obj, int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("userSet", String.valueOf(z));
        hashMap.put("value", obj);
        hashMap.put(CloudStabilityUBCUtils.KEY_ERROR_CODE, String.valueOf(i));
        return new JSONObject(hashMap).toString();
    }

    public static void a(c cVar) {
        aiq = cVar;
    }

    public static synchronized b xm() {
        b bVar;
        synchronized (b.class) {
            if (aip == null) {
                synchronized (b.class) {
                    if (aip == null) {
                        aip = new b();
                    }
                }
            }
            bVar = aip;
        }
        return bVar;
    }

    public static String xn() {
        return a(false, "", 2);
    }

    @Override // com.kwad.sdk.c.a
    public final String getAppId() {
        c cVar = aiq;
        return cVar != null ? cVar.getAppId() : xn();
    }

    @Override // com.kwad.sdk.c.a
    public final String getDeviceId() {
        c cVar = aiq;
        return cVar != null ? cVar.getDeviceId() : xn();
    }

    @Override // com.kwad.sdk.c.a
    public final String getIccId() {
        c cVar = aiq;
        return cVar != null ? cVar.getIccId() : xn();
    }

    @Override // com.kwad.sdk.c.a
    public final String getIp() {
        c cVar = aiq;
        return cVar != null ? cVar.getIp() : xn();
    }

    @Override // com.kwad.sdk.c.a
    public final String getLocation() {
        c cVar = aiq;
        return cVar != null ? cVar.getLocation() : xn();
    }

    @Override // com.kwad.sdk.c.a
    public final String getOaid() {
        c cVar = aiq;
        return cVar != null ? cVar.getOaid() : xn();
    }

    @Override // com.kwad.sdk.c.a
    public final String getSdkVersion() {
        c cVar = aiq;
        return cVar != null ? cVar.getSdkVersion() : xn();
    }

    @Override // com.kwad.sdk.c.a
    public final String xa() {
        c cVar = aiq;
        return cVar != null ? cVar.xa() : xn();
    }

    @Override // com.kwad.sdk.c.a
    public final String xb() {
        c cVar = aiq;
        return cVar != null ? cVar.xb() : xn();
    }

    @Override // com.kwad.sdk.c.a
    public final String xc() {
        c cVar = aiq;
        return cVar != null ? cVar.xc() : xn();
    }

    @Override // com.kwad.sdk.c.a
    public final String xd() {
        c cVar = aiq;
        return cVar != null ? cVar.xd() : xn();
    }

    @Override // com.kwad.sdk.c.a
    public final String xe() {
        c cVar = aiq;
        return cVar != null ? cVar.xe() : xn();
    }

    @Override // com.kwad.sdk.c.a
    public final String xf() {
        c cVar = aiq;
        return cVar != null ? cVar.xf() : xn();
    }

    @Override // com.kwad.sdk.c.a
    public final String xg() {
        c cVar = aiq;
        return cVar != null ? cVar.xg() : xn();
    }

    @Override // com.kwad.sdk.c.a
    public final String xh() {
        c cVar = aiq;
        return cVar != null ? cVar.xh() : xn();
    }

    @Override // com.kwad.sdk.c.a
    public final String xi() {
        c cVar = aiq;
        return cVar != null ? cVar.xi() : xn();
    }

    @Override // com.kwad.sdk.c.a
    public final String xj() {
        c cVar = aiq;
        return cVar != null ? cVar.xj() : xn();
    }

    @Override // com.kwad.sdk.c.a
    public final String xk() {
        c cVar = aiq;
        return cVar != null ? cVar.xk() : xn();
    }

    @Override // com.kwad.sdk.c.a
    public final String xl() {
        c cVar = aiq;
        return cVar != null ? cVar.xl() : xn();
    }
}
