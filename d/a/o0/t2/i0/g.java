package d.a.o0.t2.i0;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.afd.ParseError;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.report.DownloadStaticsData;
import d.a.o0.e3.h0.o;
/* loaded from: classes5.dex */
public class g {
    public static c a(d.a.d.d dVar, int i2, int i3) {
        if (dVar == null) {
            return null;
        }
        return b(dVar.t(), i2, i3);
    }

    public static c b(AdvertAppInfo advertAppInfo, int i2, int i3) {
        if (advertAppInfo == null) {
            return null;
        }
        c cVar = new c();
        String str = advertAppInfo.T3;
        if (advertAppInfo.O3) {
            if (i2 == 3) {
                i2 = 103;
            } else if (i2 == 2) {
                i2 = 102;
            }
            str = "RETARGET";
        }
        cVar.h(str);
        cVar.i(i2);
        cVar.t(advertAppInfo.Q3);
        if ("PB_BANNER".equals(advertAppInfo.T3)) {
            cVar.d(-1);
            cVar.v(-1);
        } else {
            cVar.d(advertAppInfo.position + 1);
            cVar.v(i3);
        }
        return cVar;
    }

    public static c c(AdvertAppInfo advertAppInfo, int i2, int i3) {
        if (advertAppInfo == null) {
            return null;
        }
        c cVar = new c();
        String str = advertAppInfo.T3;
        if (advertAppInfo.O3) {
            if (i2 == 3) {
                i2 = 103;
            } else if (i2 == 2) {
                i2 = 102;
            }
            str = "RETARGET";
        }
        cVar.h(str);
        cVar.i(i2);
        cVar.t(advertAppInfo.Q3);
        if ("PB_BANNER".equals(advertAppInfo.T3)) {
            cVar.d(-1);
            cVar.v(-1);
        } else {
            cVar.d(advertAppInfo.position + 1);
            cVar.v(i3);
        }
        return cVar;
    }

    public static c d(DownloadStaticsData downloadStaticsData, int i2, int i3) {
        if (downloadStaticsData == null) {
            return null;
        }
        c cVar = new c();
        cVar.r(downloadStaticsData);
        cVar.i(i2);
        cVar.v(i3);
        return cVar;
    }

    public static c e(o oVar, int i2) {
        if (oVar == null || oVar.getAdvertAppInfo() == null) {
            return null;
        }
        AdvertAppInfo advertAppInfo = oVar.getAdvertAppInfo();
        String E0 = oVar.E0();
        if (oVar.L0) {
            if (i2 == 3) {
                i2 = 103;
            } else if (i2 == 2) {
                i2 = 102;
            }
            E0 = "RETARGET";
        }
        c cVar = new c();
        cVar.t(advertAppInfo.Q3);
        if (oVar.D0) {
            cVar.d(-1);
            cVar.v(-1);
        } else {
            cVar.d(oVar.K0 + 1);
            cVar.v(oVar.I0);
        }
        cVar.i(i2);
        cVar.e(oVar.F0);
        cVar.f(oVar.G0);
        cVar.g(oVar.E0);
        cVar.h(E0);
        return cVar;
    }

    public static c f(@NonNull d.a.d.m.g.a aVar) {
        c cVar = new c();
        cVar.i(aVar.f43363a);
        cVar.d(aVar.f43365c);
        cVar.h(aVar.f43364b);
        cVar.t(aVar.f43366d);
        return cVar;
    }

    public static c g(int i2, int i3, int i4) {
        c cVar = new c();
        cVar.i(i2);
        cVar.d(i3);
        cVar.v(i4);
        return cVar;
    }

    public static c h(AdvertAppInfo advertAppInfo, int i2, int i3, int i4) {
        c b2 = b(advertAppInfo, i2, i3);
        b2.j(i4);
        return b2;
    }

    public static c i(AdvertAppInfo advertAppInfo, int i2, int i3, int i4) {
        c c2 = c(advertAppInfo, i2, i3);
        c2.j(i4);
        return c2;
    }

    public static c j(String str, int i2, String str2) {
        return k(str, i2, str2, "");
    }

    public static c k(String str, int i2, String str2, String str3) {
        c cVar = new c();
        cVar.i(i2);
        cVar.w(str2);
        cVar.h("HOMEPAGE");
        cVar.t(str);
        cVar.c(str3);
        return cVar;
    }

    public static c l(AdvertAppInfo advertAppInfo, int i2, int i3, int i4, int i5, int i6, int i7) {
        c b2 = b(advertAppInfo, i2, i3);
        b2.j(i4);
        b2.l(i6);
        b2.m(i5);
        if (i7 != -1 && i2 == 32) {
            b2.p(i7);
        }
        b2.h(advertAppInfo.T3);
        if (i2 == 2) {
            b2.u("video");
        }
        return b2;
    }

    public static c m(d.a.d.d dVar, int i2, int i3, int i4, int i5, int i6, int i7) {
        c a2 = a(dVar, i2, i3);
        a2.j(i4);
        a2.l(i6);
        a2.m(i5);
        if (i7 != -1 && i2 == 32) {
            a2.p(i7);
        }
        if (dVar != null) {
            a2.h(dVar.t().T3);
        }
        if (i2 == 2) {
            a2.u("video");
        }
        return a2;
    }

    public static c n(@NonNull d.a.d.m.g.a aVar) {
        c cVar = new c();
        cVar.i(aVar.f43363a);
        cVar.d(aVar.f43365c);
        cVar.h(aVar.f43364b);
        cVar.t(aVar.f43366d);
        return cVar;
    }

    public static c o(d.a.d.d dVar, ParseError parseError) {
        if (dVar == null || parseError == null) {
            return null;
        }
        c a2 = a(dVar, 5, dVar.i());
        a2.j(parseError.errorCode);
        return a2;
    }

    public static c p(@NonNull d.a.d.m.g.a aVar) {
        c cVar = new c();
        cVar.i(aVar.f43363a);
        cVar.d(aVar.f43365c);
        cVar.h(aVar.f43364b);
        cVar.t(aVar.f43366d);
        cVar.j(aVar.k);
        if (!TextUtils.isEmpty(aVar.j)) {
            cVar.s(aVar.j);
        }
        cVar.m(aVar.l);
        return cVar;
    }

    public static c q(@NonNull d.a.d.m.g.a aVar) {
        c cVar = new c();
        cVar.i(aVar.f43363a);
        cVar.d(aVar.f43365c);
        cVar.h(aVar.f43364b);
        cVar.t(aVar.f43366d);
        cVar.j(0);
        cVar.l(aVar.f43368f);
        cVar.m(aVar.f43367e);
        cVar.n(aVar.f43369g);
        return cVar;
    }
}
