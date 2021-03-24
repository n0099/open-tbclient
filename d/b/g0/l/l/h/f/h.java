package d.b.g0.l.l.h.f;

import android.text.TextUtils;
import com.baidu.searchbox.pms.constants.ErrorConstant;
import com.baidu.searchbox.pms.db.PackageTable;
import d.b.g0.l.l.j.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class h {
    public static <T> boolean a(d.b.g0.l.h.c<T> cVar, T t, String str, String str2) {
        if (t == null || cVar == null) {
            return false;
        }
        if (TextUtils.isEmpty(str)) {
            j(t, PackageTable.MD5, cVar);
            return false;
        } else if (TextUtils.isEmpty(str2)) {
            j(t, "downloadUrl", cVar);
            return false;
        } else {
            return true;
        }
    }

    public static <T> boolean b(T t, d.b.g0.l.h.c<T> cVar) {
        if (cVar == null || t == null) {
            return false;
        }
        if (t instanceof d.b.g0.l.k.e) {
            d.b.g0.l.k.e eVar = (d.b.g0.l.k.e) t;
            return a(cVar, t, eVar.l, eVar.n);
        } else if (t instanceof a.C1019a) {
            d.b.g0.l.k.f fVar = ((a.C1019a) t).f48979d;
            return a(cVar, t, fVar.l, fVar.n);
        } else {
            return false;
        }
    }

    public static f<d.b.g0.l.k.b> c(d.b.g0.l.k.b bVar, d.b.g0.l.h.g gVar) {
        if (gVar != null && b(bVar, gVar.r())) {
            return new f<>(new e(bVar), bVar, new c(gVar.r()));
        }
        return null;
    }

    public static f<d.b.g0.l.k.d> d(d.b.g0.l.k.d dVar, d.b.g0.l.h.g gVar) {
        if (gVar != null && b(dVar, gVar.s())) {
            return new f<>(new e(dVar), dVar, new c(gVar.s()));
        }
        return null;
    }

    public static List<f<a.C1019a>> e(List<a.C1019a> list, d.b.g0.l.h.g gVar) {
        ArrayList arrayList = new ArrayList();
        if (gVar != null && list != null && list.size() > 0) {
            for (a.C1019a c1019a : list) {
                d.b.g0.l.k.f fVar = c1019a.f48979d;
                if (fVar != null && b(c1019a, gVar.v())) {
                    arrayList.add(new f(new e(fVar), c1019a, new c(gVar.v())));
                }
            }
        }
        return arrayList;
    }

    public static f<d.b.g0.l.k.f> f(d.b.g0.l.k.f fVar, d.b.g0.l.h.g gVar) {
        if (gVar != null && b(fVar, gVar.u())) {
            return new f<>(new e(fVar), fVar, new c(gVar.u()));
        }
        return null;
    }

    public static List<f<d.b.g0.l.k.g>> g(List<d.b.g0.l.k.g> list, d.b.g0.l.h.g gVar) {
        ArrayList arrayList = new ArrayList();
        if (gVar != null && list != null && list.size() > 0) {
            for (d.b.g0.l.k.g gVar2 : list) {
                if (b(gVar2, gVar.A())) {
                    arrayList.add(new f(new e(gVar2), gVar2, new c(gVar.A())));
                }
            }
        }
        return arrayList;
    }

    public static f<d.b.g0.l.k.h> h(d.b.g0.l.k.h hVar, d.b.g0.l.h.g gVar) {
        if (gVar != null && b(hVar, gVar.x())) {
            return new f<>(new e(hVar), hVar, new c(gVar.x()));
        }
        return null;
    }

    public static f<d.b.g0.l.k.i> i(d.b.g0.l.k.i iVar, d.b.g0.l.h.g gVar) {
        if (gVar != null && b(iVar, gVar.z())) {
            return new f<>(new e(iVar), iVar, new c(gVar.z()));
        }
        return null;
    }

    public static <T> void j(T t, String str, d.b.g0.l.h.c<T> cVar) {
        cVar.l(t, new d.b.g0.l.k.a(ErrorConstant.Code.DOWNLOAD_ERROR_NETWROK_CHANGE, String.format(ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_MISS_PARAM, str)));
    }
}
