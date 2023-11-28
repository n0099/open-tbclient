package com.kwad.sdk.f;

import com.baidu.searchbox.cloudcontrol.utils.CloudStabilityUBCUtils;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class b implements a {
    public static volatile b aGO;
    public static c aGP;

    public static synchronized b Hj() {
        b bVar;
        synchronized (b.class) {
            if (aGO == null) {
                synchronized (b.class) {
                    if (aGO == null) {
                        aGO = new b();
                    }
                }
            }
            bVar = aGO;
        }
        return bVar;
    }

    public static String Hk() {
        return a(false, "", 2);
    }

    @Override // com.kwad.sdk.f.a
    public final String GX() {
        c cVar = aGP;
        if (cVar != null) {
            return cVar.GX();
        }
        return Hk();
    }

    @Override // com.kwad.sdk.f.a
    public final String GY() {
        c cVar = aGP;
        if (cVar != null) {
            return cVar.GY();
        }
        return Hk();
    }

    @Override // com.kwad.sdk.f.a
    public final String GZ() {
        c cVar = aGP;
        if (cVar != null) {
            return cVar.GZ();
        }
        return Hk();
    }

    @Override // com.kwad.sdk.f.a
    public final String Ha() {
        c cVar = aGP;
        if (cVar != null) {
            return cVar.Ha();
        }
        return Hk();
    }

    @Override // com.kwad.sdk.f.a
    public final String Hb() {
        c cVar = aGP;
        if (cVar != null) {
            return cVar.Hb();
        }
        return Hk();
    }

    @Override // com.kwad.sdk.f.a
    public final String Hc() {
        c cVar = aGP;
        if (cVar != null) {
            return cVar.Hc();
        }
        return Hk();
    }

    @Override // com.kwad.sdk.f.a
    public final String Hd() {
        c cVar = aGP;
        if (cVar != null) {
            return cVar.Hd();
        }
        return Hk();
    }

    @Override // com.kwad.sdk.f.a
    public final String He() {
        c cVar = aGP;
        if (cVar != null) {
            return cVar.He();
        }
        return Hk();
    }

    @Override // com.kwad.sdk.f.a
    public final String Hf() {
        c cVar = aGP;
        if (cVar != null) {
            return cVar.Hf();
        }
        return Hk();
    }

    @Override // com.kwad.sdk.f.a
    public final String Hg() {
        c cVar = aGP;
        if (cVar != null) {
            return cVar.Hg();
        }
        return Hk();
    }

    @Override // com.kwad.sdk.f.a
    public final String Hh() {
        c cVar = aGP;
        if (cVar != null) {
            return cVar.Hh();
        }
        return Hk();
    }

    @Override // com.kwad.sdk.f.a
    public final String Hi() {
        c cVar = aGP;
        if (cVar != null) {
            return cVar.Hi();
        }
        return Hk();
    }

    @Override // com.kwad.sdk.f.a
    public final String getAppId() {
        c cVar = aGP;
        if (cVar != null) {
            return cVar.getAppId();
        }
        return Hk();
    }

    @Override // com.kwad.sdk.f.a
    public final String getDeviceId() {
        c cVar = aGP;
        if (cVar != null) {
            return cVar.getDeviceId();
        }
        return Hk();
    }

    @Override // com.kwad.sdk.f.a
    public final String getIccId() {
        c cVar = aGP;
        if (cVar != null) {
            return cVar.getIccId();
        }
        return Hk();
    }

    @Override // com.kwad.sdk.f.a
    public final String getIp() {
        c cVar = aGP;
        if (cVar != null) {
            return cVar.getIp();
        }
        return Hk();
    }

    @Override // com.kwad.sdk.f.a
    public final String getLocation() {
        c cVar = aGP;
        if (cVar != null) {
            return cVar.getLocation();
        }
        return Hk();
    }

    @Override // com.kwad.sdk.f.a
    public final String getOaid() {
        c cVar = aGP;
        if (cVar != null) {
            return cVar.getOaid();
        }
        return Hk();
    }

    @Override // com.kwad.sdk.f.a
    public final String getSdkVersion() {
        c cVar = aGP;
        if (cVar != null) {
            return cVar.getSdkVersion();
        }
        return Hk();
    }

    public static String a(boolean z, Object obj, int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("userSet", String.valueOf(z));
        hashMap.put("value", obj);
        hashMap.put(CloudStabilityUBCUtils.KEY_ERROR_CODE, String.valueOf(i));
        return new JSONObject(hashMap).toString();
    }

    public static void a(c cVar) {
        aGP = cVar;
    }
}
