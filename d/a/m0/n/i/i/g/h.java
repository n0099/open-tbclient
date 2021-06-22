package d.a.m0.n.i.i.g;

import android.text.TextUtils;
import com.baidu.mobads.container.bridge.BaiduAppJsBridgeHandler;
import com.baidu.searchbox.pms.constants.ErrorConstant;
import com.baidu.searchbox.pms.db.PackageTable;
import d.a.m0.n.i.l.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class h {
    public static <T> boolean a(d.a.m0.n.f.c<T> cVar, T t, String str, String str2) {
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

    public static <T> boolean b(T t, d.a.m0.n.f.c<T> cVar) {
        if (cVar == null || t == null) {
            return false;
        }
        if (t instanceof d.a.m0.n.h.e) {
            d.a.m0.n.h.e eVar = (d.a.m0.n.h.e) t;
            return a(cVar, t, eVar.l, eVar.n);
        } else if (t instanceof a.C1137a) {
            d.a.m0.n.h.f fVar = ((a.C1137a) t).f51866d;
            return a(cVar, t, fVar.l, fVar.n);
        } else {
            return false;
        }
    }

    public static f<d.a.m0.n.h.b> c(d.a.m0.n.h.b bVar, d.a.m0.n.f.g gVar) {
        if (gVar != null && b(bVar, gVar.q())) {
            return new f<>(new e(bVar), bVar, new c(gVar.q()));
        }
        return null;
    }

    public static f<d.a.m0.n.h.d> d(d.a.m0.n.h.d dVar, d.a.m0.n.f.g gVar) {
        if (gVar != null && b(dVar, gVar.r())) {
            return new f<>(new e(dVar), dVar, new c(gVar.r()));
        }
        return null;
    }

    public static List<f<a.C1137a>> e(List<a.C1137a> list, d.a.m0.n.f.g gVar) {
        ArrayList arrayList = new ArrayList();
        if (gVar != null && list != null && list.size() > 0) {
            for (a.C1137a c1137a : list) {
                d.a.m0.n.h.f fVar = c1137a.f51866d;
                if (fVar != null && b(c1137a, gVar.u())) {
                    arrayList.add(new f(new e(fVar), c1137a, new c(gVar.u())));
                }
            }
        }
        return arrayList;
    }

    public static f<d.a.m0.n.h.f> f(d.a.m0.n.h.f fVar, d.a.m0.n.f.g gVar) {
        if (gVar != null && b(fVar, gVar.t())) {
            return new f<>(new e(fVar), fVar, new c(gVar.t()));
        }
        return null;
    }

    public static List<f<d.a.m0.n.h.g>> g(List<d.a.m0.n.h.g> list, d.a.m0.n.f.g gVar) {
        ArrayList arrayList = new ArrayList();
        if (gVar != null && list != null && list.size() > 0) {
            for (d.a.m0.n.h.g gVar2 : list) {
                if (b(gVar2, gVar.z())) {
                    arrayList.add(new f(new e(gVar2), gVar2, new c(gVar.z())));
                }
            }
        }
        return arrayList;
    }

    public static f<d.a.m0.n.h.h> h(d.a.m0.n.h.h hVar, d.a.m0.n.f.g gVar) {
        if (gVar != null && b(hVar, gVar.w())) {
            return new f<>(new e(hVar), hVar, new c(gVar.w()));
        }
        return null;
    }

    public static f<d.a.m0.n.h.i> i(d.a.m0.n.h.i iVar, d.a.m0.n.f.g gVar) {
        if (gVar != null && b(iVar, gVar.y())) {
            return new f<>(new e(iVar), iVar, new c(gVar.y()));
        }
        return null;
    }

    public static <T> void j(T t, String str, d.a.m0.n.f.c<T> cVar) {
        cVar.e(t, new d.a.m0.n.h.a(ErrorConstant.Code.DOWNLOAD_ERROR_NETWROK_CHANGE, String.format(ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_MISS_PARAM, str)));
    }
}
