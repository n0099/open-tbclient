package com.kwad.sdk.core.request.model;

import android.content.Context;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.InstalledAppInfoManager;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.ar;
import com.kwad.sdk.utils.az;
import com.kwad.sdk.utils.j;
import com.kwad.sdk.utils.w;
import org.json.JSONArray;
@KsJson
/* loaded from: classes5.dex */
public class b extends com.kwad.sdk.core.response.kwai.a {
    public String Ig;
    public String LM;
    public int LN;
    public int LP;
    public String LQ;
    public int LS;
    public int LT;
    public String VB;
    public String VC;
    public String acA;
    public String acB;
    public JSONArray acC;
    public String acD;
    public String acF;
    public String acG;
    public String acH;
    public String acJ;
    public String acK;
    public String acn;
    public String aco;
    public String acp;
    public String acq;
    public String acr;
    public String acs;
    public int act;
    public int acu;
    public String acv;
    public String acw;
    public String acx;
    public int acy;
    public String acz;
    public int acE = 0;
    public long acI = 0;

    public static b f(boolean z, int i) {
        b bVar = new b();
        com.kwad.sdk.service.kwai.d dVar = (com.kwad.sdk.service.kwai.d) ServiceProvider.get(com.kwad.sdk.service.kwai.d.class);
        Context context = dVar.getContext();
        bVar.VB = ar.cI(context);
        bVar.acn = ar.cL(context);
        bVar.aco = ar.cM(context);
        bVar.acp = az.dp(context);
        bVar.VC = ar.getOaid();
        bVar.acz = az.AE();
        bVar.LM = az.AG();
        bVar.LN = 1;
        bVar.LP = az.AQ();
        bVar.acs = az.getOsVersion();
        bVar.LQ = j.getLanguage();
        bVar.LT = j.getScreenHeight(context);
        bVar.LS = j.getScreenWidth(context);
        bVar.act = j.cd(context);
        bVar.acu = j.ce(context);
        bVar.acv = ar.cJ(context);
        if (z) {
            bVar.acC = InstalledAppInfoManager.ch(context);
        }
        bVar.acw = ar.getDeviceId();
        bVar.acI = az.AF();
        bVar.acx = az.AN();
        bVar.acB = w.zE();
        com.kwad.sdk.components.f fVar = (com.kwad.sdk.components.f) com.kwad.sdk.components.c.f(com.kwad.sdk.components.f.class);
        if (fVar != null) {
            bVar.acA = fVar.nb();
        }
        bVar.acy = az.AO();
        StringBuilder sb = new StringBuilder("DeviceInfo i=");
        sb.append(dVar.getAppId());
        sb.append(",n=");
        sb.append(dVar.getAppName());
        sb.append(",external:");
        sb.append(dVar.getIsExternal());
        sb.append(",v1:");
        sb.append(dVar.getApiVersion());
        sb.append(",v2:3.3.26");
        sb.append(",d:");
        sb.append(bVar.acw);
        sb.append(",dh:");
        String str = bVar.acw;
        sb.append(str != null ? Integer.valueOf(str.hashCode()) : "");
        sb.append(",o:");
        sb.append(bVar.VC);
        com.kwad.sdk.core.e.b.bT(sb.toString());
        bVar.acD = az.AP();
        bVar.acE = i;
        if (lE()) {
            bVar.acF = j.y(context, "com.smile.gifmaker");
            bVar.acG = j.y(context, "com.kuaishou.nebula");
            bVar.acH = j.y(context, "com.tencent.mm");
        }
        bVar.Ig = az.AL();
        bVar.acr = ac.cu(context);
        bVar.acJ = az.AU();
        bVar.acK = az.ea("/data/data");
        return bVar;
    }

    public static boolean lE() {
        return ((com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class)).lE();
    }

    public static b uO() {
        b bVar = new b();
        bVar.VC = ar.getOaid();
        bVar.acw = ar.getDeviceId();
        bVar.acz = az.AE();
        bVar.LN = 1;
        bVar.LP = az.AQ();
        bVar.acs = az.getOsVersion();
        bVar.acB = w.zE();
        com.kwad.sdk.components.f fVar = (com.kwad.sdk.components.f) com.kwad.sdk.components.c.f(com.kwad.sdk.components.f.class);
        if (fVar != null) {
            bVar.acA = fVar.nb();
        }
        return bVar;
    }
}
