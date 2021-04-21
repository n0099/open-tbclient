package d.b.h0.l.l.h.f;

import android.text.TextUtils;
import com.baidu.mobads.container.bridge.BaiduAppJsBridgeHandler;
import com.baidu.searchbox.pms.constants.ErrorConstant;
import com.baidu.searchbox.pms.db.PackageTable;
import d.b.h0.l.l.j.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class h {
    public static <T> boolean a(d.b.h0.l.h.c<T> cVar, T t, String str, String str2) {
        if (t == null || cVar == null) {
            return false;
        }
        if (TextUtils.isEmpty(str)) {
            j(t, PackageTable.MD5, cVar);
            return false;
        } else if (TextUtils.isEmpty(str2)) {
            j(t, BaiduAppJsBridgeHandler.INPUT_PARAM_DOWNLOAD_URL, cVar);
            return false;
        } else {
            return true;
        }
    }

    public static <T> boolean b(T t, d.b.h0.l.h.c<T> cVar) {
        if (cVar == null || t == null) {
            return false;
        }
        if (t instanceof d.b.h0.l.k.e) {
            d.b.h0.l.k.e eVar = (d.b.h0.l.k.e) t;
            return a(cVar, t, eVar.l, eVar.n);
        } else if (t instanceof a.C1052a) {
            d.b.h0.l.k.f fVar = ((a.C1052a) t).f49701d;
            return a(cVar, t, fVar.l, fVar.n);
        } else {
            return false;
        }
    }

    public static f<d.b.h0.l.k.b> c(d.b.h0.l.k.b bVar, d.b.h0.l.h.g gVar) {
        if (gVar != null && b(bVar, gVar.q())) {
            return new f<>(new e(bVar), bVar, new c(gVar.q()));
        }
        return null;
    }

    public static f<d.b.h0.l.k.d> d(d.b.h0.l.k.d dVar, d.b.h0.l.h.g gVar) {
        if (gVar != null && b(dVar, gVar.r())) {
            return new f<>(new e(dVar), dVar, new c(gVar.r()));
        }
        return null;
    }

    public static List<f<a.C1052a>> e(List<a.C1052a> list, d.b.h0.l.h.g gVar) {
        ArrayList arrayList = new ArrayList();
        if (gVar != null && list != null && list.size() > 0) {
            for (a.C1052a c1052a : list) {
                d.b.h0.l.k.f fVar = c1052a.f49701d;
                if (fVar != null && b(c1052a, gVar.u())) {
                    arrayList.add(new f(new e(fVar), c1052a, new c(gVar.u())));
                }
            }
        }
        return arrayList;
    }

    public static f<d.b.h0.l.k.f> f(d.b.h0.l.k.f fVar, d.b.h0.l.h.g gVar) {
        if (gVar != null && b(fVar, gVar.t())) {
            return new f<>(new e(fVar), fVar, new c(gVar.t()));
        }
        return null;
    }

    public static List<f<d.b.h0.l.k.g>> g(List<d.b.h0.l.k.g> list, d.b.h0.l.h.g gVar) {
        ArrayList arrayList = new ArrayList();
        if (gVar != null && list != null && list.size() > 0) {
            for (d.b.h0.l.k.g gVar2 : list) {
                if (b(gVar2, gVar.z())) {
                    arrayList.add(new f(new e(gVar2), gVar2, new c(gVar.z())));
                }
            }
        }
        return arrayList;
    }

    public static f<d.b.h0.l.k.h> h(d.b.h0.l.k.h hVar, d.b.h0.l.h.g gVar) {
        if (gVar != null && b(hVar, gVar.w())) {
            return new f<>(new e(hVar), hVar, new c(gVar.w()));
        }
        return null;
    }

    public static f<d.b.h0.l.k.i> i(d.b.h0.l.k.i iVar, d.b.h0.l.h.g gVar) {
        if (gVar != null && b(iVar, gVar.y())) {
            return new f<>(new e(iVar), iVar, new c(gVar.y()));
        }
        return null;
    }

    public static <T> void j(T t, String str, d.b.h0.l.h.c<T> cVar) {
        cVar.l(t, new d.b.h0.l.k.a(ErrorConstant.Code.DOWNLOAD_ERROR_NETWROK_CHANGE, String.format(ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_MISS_PARAM, str)));
    }
}
