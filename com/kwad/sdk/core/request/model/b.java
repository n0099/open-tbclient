package com.kwad.sdk.core.request.model;

import android.content.Context;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.h;
import com.kwad.sdk.utils.InstalledAppInfoManager;
import com.kwad.sdk.utils.ae;
import com.kwad.sdk.utils.aq;
import com.kwad.sdk.utils.av;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.k;
import com.kwad.sdk.utils.y;
import org.json.JSONArray;
@KsJson
/* loaded from: classes10.dex */
public class b extends com.kwad.sdk.core.response.a.a {
    public static boolean ayb;
    public static JSONArray ayc;
    public String RD;
    public String WE;
    public int WF;
    public int WH;
    public String WI;
    public int WK;
    public int WL;
    public String arh;
    public String ari;
    public String ayA;
    public String ayd;
    public String aye;
    public String ayf;
    public String ayg;
    public String ayh;
    public String ayi;
    public int ayj;
    public int ayk;
    public String ayl;
    public String aym;
    public String ayn;
    public int ayo;
    public String ayp;
    public String ayq;
    public String ayr;
    public JSONArray ays;
    public String ayt;
    public String ayv;
    public String ayw;
    public String ayx;
    public String ayz;
    public int ayu = 0;
    public long ayy = 0;

    public static boolean yr() {
        return ((h) ServiceProvider.get(h.class)).yr();
    }

    public static b DR() {
        b bVar = new b();
        bVar.ari = av.getOaid();
        bVar.aym = av.getDeviceId();
        bVar.ayp = bi.Lu();
        bVar.WF = 1;
        bVar.WH = bi.LG();
        bVar.ayi = bi.getOsVersion();
        bVar.ayr = y.Kj();
        com.kwad.sdk.components.f fVar = (com.kwad.sdk.components.f) com.kwad.sdk.components.c.f(com.kwad.sdk.components.f.class);
        if (fVar != null) {
            bVar.ayq = fVar.om();
        }
        com.kwad.sdk.service.a.f fVar2 = (com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class);
        if (fVar2 != null) {
            bVar.arh = av.cv(fVar2.getContext());
        }
        return bVar;
    }

    public static synchronized JSONArray bh(Context context) {
        synchronized (b.class) {
            if (!ayb) {
                ayb = true;
                InstalledAppInfoManager.a(context, new com.kwad.sdk.g.a<JSONArray>() { // from class: com.kwad.sdk.core.request.model.b.1
                    public static void g(JSONArray jSONArray) {
                        JSONArray unused = b.ayc = jSONArray;
                    }

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    @Override // com.kwad.sdk.g.a
                    public final /* synthetic */ void accept(JSONArray jSONArray) {
                        g(jSONArray);
                    }
                });
            }
            JSONArray jSONArray = ayc;
            if (jSONArray == null) {
                return null;
            }
            ayc = null;
            return jSONArray;
        }
    }

    public static b h(boolean z, int i) {
        Object obj;
        b bVar = new b();
        Context Jn = ServiceProvider.Jn();
        bVar.arh = av.cv(Jn);
        bVar.ayd = av.cy(Jn);
        bVar.aye = av.cz(Jn);
        bVar.ayf = bi.cZ(Jn);
        bVar.ari = av.getOaid();
        bVar.ayp = bi.Lu();
        bVar.WE = bi.Lw();
        bVar.WF = 1;
        bVar.WH = bi.LG();
        bVar.ayi = bi.getOsVersion();
        bVar.WI = k.getLanguage();
        bVar.WL = k.getScreenHeight(Jn);
        bVar.WK = k.getScreenWidth(Jn);
        bVar.ayj = k.bT(Jn);
        bVar.ayk = k.bU(Jn);
        bVar.ayl = av.cw(Jn);
        if (z) {
            bVar.ays = bh(Jn);
        }
        bVar.aym = av.getDeviceId();
        bVar.ayy = bi.Lv();
        bVar.ayn = bi.LD();
        bVar.ayr = y.Kj();
        com.kwad.sdk.components.f fVar = (com.kwad.sdk.components.f) com.kwad.sdk.components.c.f(com.kwad.sdk.components.f.class);
        if (fVar != null) {
            bVar.ayq = fVar.om();
        }
        bVar.ayo = bi.LE();
        com.kwad.sdk.service.a.f fVar2 = (com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class);
        StringBuilder sb = new StringBuilder("DeviceInfo i=");
        sb.append(fVar2.getAppId());
        sb.append(",n=");
        sb.append(fVar2.getAppName());
        sb.append(",external:");
        sb.append(fVar2.getIsExternal());
        sb.append(",v1:");
        sb.append(fVar2.getApiVersion());
        sb.append(",v2:3.3.55");
        sb.append(",d:");
        sb.append(bVar.aym);
        sb.append(",dh:");
        String str = bVar.aym;
        if (str != null) {
            obj = Integer.valueOf(str.hashCode());
        } else {
            obj = "";
        }
        sb.append(obj);
        sb.append(",o:");
        sb.append(bVar.ari);
        sb.append(",b:562");
        sb.append(",p:");
        sb.append(aq.isInMainProcess(Jn));
        sb.append(",dy:");
        sb.append(com.kwad.framework.a.a.ads);
        com.kwad.sdk.core.e.c.m181do(sb.toString());
        bVar.ayt = bi.LF();
        bVar.ayu = i;
        if (yr()) {
            bVar.ayv = com.kwad.sdk.b.b.zt().getVersion(Jn, "com.smile.gifmaker");
            bVar.ayw = com.kwad.sdk.b.b.zt().getVersion(Jn, "com.kuaishou.nebula");
            bVar.ayx = com.kwad.sdk.b.b.zt().getVersion(Jn, "com.tencent.mm");
        }
        bVar.RD = bi.LB();
        bVar.ayh = ae.ci(Jn);
        bVar.ayz = bi.LK();
        bVar.ayA = bi.gs(com.baidu.searchbox.antivr.b.a);
        return bVar;
    }
}
