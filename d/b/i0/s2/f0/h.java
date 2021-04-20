package d.b.i0.s2.f0;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.afd.ParseError;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.report.DownloadStaticsData;
import com.baidu.tieba.tbadkCore.data.AppData;
import d.b.i0.d3.h0.o;
/* loaded from: classes4.dex */
public class h {
    public static c a(d.b.d.d dVar, int i, int i2) {
        if (dVar == null) {
            return null;
        }
        return b(dVar.v(), i, i2);
    }

    public static c b(AdvertAppInfo advertAppInfo, int i, int i2) {
        if (advertAppInfo == null) {
            return null;
        }
        c cVar = new c();
        String str = advertAppInfo.c4;
        if (advertAppInfo.g4) {
            if (i == 3) {
                i = 103;
            } else if (i == 2) {
                i = 102;
            }
            str = "RETARGET";
        }
        cVar.h(str);
        cVar.j(i);
        cVar.i(advertAppInfo.O3);
        cVar.u(advertAppInfo.T3);
        if ("PB_BANNER".equals(advertAppInfo.c4)) {
            cVar.d(-1);
            cVar.w(-1);
        } else {
            cVar.d(advertAppInfo.position + 1);
            cVar.w(i2);
        }
        cVar.e(advertAppInfo.Z3);
        cVar.f(advertAppInfo.a4);
        cVar.g(advertAppInfo.b4);
        return cVar;
    }

    public static c c(AdvertAppInfo advertAppInfo, int i, int i2) {
        if (advertAppInfo == null) {
            return null;
        }
        c cVar = new c();
        String str = advertAppInfo.c4;
        if (advertAppInfo.g4) {
            if (i == 3) {
                i = 103;
            } else if (i == 2) {
                i = 102;
            }
            str = "RETARGET";
        }
        cVar.h(str);
        cVar.j(i);
        cVar.i(advertAppInfo.O3);
        cVar.u(advertAppInfo.T3);
        if ("PB_BANNER".equals(advertAppInfo.c4)) {
            cVar.d(-1);
            cVar.w(-1);
        } else {
            cVar.d(advertAppInfo.position + 1);
            cVar.w(i2);
        }
        cVar.e(advertAppInfo.Z3);
        cVar.f(advertAppInfo.a4);
        cVar.g(advertAppInfo.b4);
        return cVar;
    }

    public static c d(DownloadStaticsData downloadStaticsData, int i, int i2) {
        if (downloadStaticsData == null) {
            return null;
        }
        c cVar = new c();
        cVar.s(downloadStaticsData);
        cVar.j(i);
        cVar.w(i2);
        return cVar;
    }

    public static c e(o oVar, int i) {
        if (oVar == null || oVar.D0() == null) {
            return null;
        }
        AppData D0 = oVar.D0();
        String E0 = oVar.E0();
        if (oVar.N0) {
            if (i == 3) {
                i = 103;
            } else if (i == 2) {
                i = 102;
            }
            E0 = "RETARGET";
        }
        c cVar = new c();
        cVar.u(D0.ext_info);
        if (oVar.y0) {
            cVar.d(-1);
            cVar.w(-1);
        } else {
            cVar.d(oVar.M0 + 1);
            cVar.w(oVar.K0);
        }
        cVar.j(i);
        cVar.i(D0.price);
        cVar.e(oVar.C0);
        cVar.f(oVar.D0);
        cVar.g(oVar.B0);
        cVar.h(E0);
        return cVar;
    }

    public static c f(@NonNull d.b.d.m.g.a aVar) {
        c cVar = new c();
        cVar.j(aVar.f43122a);
        cVar.d(aVar.f43124c);
        cVar.h(aVar.f43123b);
        cVar.u(aVar.f43125d);
        return cVar;
    }

    public static c g(int i, int i2, int i3) {
        c cVar = new c();
        cVar.j(i);
        cVar.d(i2);
        cVar.w(i3);
        return cVar;
    }

    public static c h(AdvertAppInfo advertAppInfo, int i, int i2, int i3) {
        c b2 = b(advertAppInfo, i, i2);
        b2.k(i3);
        return b2;
    }

    public static c i(AdvertAppInfo advertAppInfo, int i, int i2, int i3) {
        c c2 = c(advertAppInfo, i, i2);
        c2.k(i3);
        return c2;
    }

    public static c j(String str, int i, String str2) {
        return k(str, i, str2, "");
    }

    public static c k(String str, int i, String str2, String str3) {
        c cVar = new c();
        cVar.j(i);
        cVar.x(str2);
        cVar.h("HOMEPAGE");
        cVar.u(str);
        cVar.c(str3);
        return cVar;
    }

    public static c l(AdvertAppInfo advertAppInfo, int i, int i2, int i3, int i4, int i5, int i6) {
        c b2 = b(advertAppInfo, i, i2);
        b2.k(i3);
        b2.m(i5);
        b2.n(i4);
        if (i6 != -1 && i == 32) {
            b2.q(i6);
        }
        b2.h(advertAppInfo.c4);
        if (i == 2) {
            b2.v("video");
        }
        return b2;
    }

    public static c m(d.b.d.d dVar, int i, int i2, int i3, int i4, int i5, int i6) {
        c a2 = a(dVar, i, i2);
        a2.k(i3);
        a2.m(i5);
        a2.n(i4);
        if (i6 != -1 && i == 32) {
            a2.q(i6);
        }
        if (dVar != null) {
            a2.h(dVar.v().c4);
        }
        if (i == 2) {
            a2.v("video");
        }
        return a2;
    }

    public static c n(@NonNull d.b.d.m.g.a aVar) {
        c cVar = new c();
        cVar.j(aVar.f43122a);
        cVar.d(aVar.f43124c);
        cVar.h(aVar.f43123b);
        cVar.u(aVar.f43125d);
        return cVar;
    }

    public static c o(d.b.d.d dVar, ParseError parseError) {
        if (dVar == null || parseError == null) {
            return null;
        }
        c a2 = a(dVar, 5, dVar.n());
        a2.k(parseError.errorCode);
        return a2;
    }

    public static c p(@NonNull d.b.d.m.g.a aVar) {
        c cVar = new c();
        cVar.j(aVar.f43122a);
        cVar.d(aVar.f43124c);
        cVar.h(aVar.f43123b);
        cVar.u(aVar.f43125d);
        cVar.k(aVar.k);
        if (!TextUtils.isEmpty(aVar.j)) {
            cVar.t(aVar.j);
        }
        cVar.n(aVar.l);
        return cVar;
    }

    public static c q(@NonNull d.b.d.m.g.a aVar) {
        c cVar = new c();
        cVar.j(aVar.f43122a);
        cVar.d(aVar.f43124c);
        cVar.h(aVar.f43123b);
        cVar.u(aVar.f43125d);
        cVar.k(0);
        cVar.m(aVar.f43127f);
        cVar.n(aVar.f43126e);
        cVar.o(aVar.f43128g);
        return cVar;
    }
}
