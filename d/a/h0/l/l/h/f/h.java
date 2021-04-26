package d.a.h0.l.l.h.f;

import android.text.TextUtils;
import com.baidu.mobads.container.bridge.BaiduAppJsBridgeHandler;
import com.baidu.searchbox.pms.constants.ErrorConstant;
import com.baidu.searchbox.pms.db.PackageTable;
import d.a.h0.l.l.j.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class h {
    public static <T> boolean a(d.a.h0.l.h.c<T> cVar, T t, String str, String str2) {
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

    public static <T> boolean b(T t, d.a.h0.l.h.c<T> cVar) {
        if (cVar == null || t == null) {
            return false;
        }
        if (t instanceof d.a.h0.l.k.e) {
            d.a.h0.l.k.e eVar = (d.a.h0.l.k.e) t;
            return a(cVar, t, eVar.l, eVar.n);
        } else if (t instanceof a.C0991a) {
            d.a.h0.l.k.f fVar = ((a.C0991a) t).f47213d;
            return a(cVar, t, fVar.l, fVar.n);
        } else {
            return false;
        }
    }

    public static f<d.a.h0.l.k.b> c(d.a.h0.l.k.b bVar, d.a.h0.l.h.g gVar) {
        if (gVar != null && b(bVar, gVar.q())) {
            return new f<>(new e(bVar), bVar, new c(gVar.q()));
        }
        return null;
    }

    public static f<d.a.h0.l.k.d> d(d.a.h0.l.k.d dVar, d.a.h0.l.h.g gVar) {
        if (gVar != null && b(dVar, gVar.r())) {
            return new f<>(new e(dVar), dVar, new c(gVar.r()));
        }
        return null;
    }

    public static List<f<a.C0991a>> e(List<a.C0991a> list, d.a.h0.l.h.g gVar) {
        ArrayList arrayList = new ArrayList();
        if (gVar != null && list != null && list.size() > 0) {
            for (a.C0991a c0991a : list) {
                d.a.h0.l.k.f fVar = c0991a.f47213d;
                if (fVar != null && b(c0991a, gVar.u())) {
                    arrayList.add(new f(new e(fVar), c0991a, new c(gVar.u())));
                }
            }
        }
        return arrayList;
    }

    public static f<d.a.h0.l.k.f> f(d.a.h0.l.k.f fVar, d.a.h0.l.h.g gVar) {
        if (gVar != null && b(fVar, gVar.t())) {
            return new f<>(new e(fVar), fVar, new c(gVar.t()));
        }
        return null;
    }

    public static List<f<d.a.h0.l.k.g>> g(List<d.a.h0.l.k.g> list, d.a.h0.l.h.g gVar) {
        ArrayList arrayList = new ArrayList();
        if (gVar != null && list != null && list.size() > 0) {
            for (d.a.h0.l.k.g gVar2 : list) {
                if (b(gVar2, gVar.z())) {
                    arrayList.add(new f(new e(gVar2), gVar2, new c(gVar.z())));
                }
            }
        }
        return arrayList;
    }

    public static f<d.a.h0.l.k.h> h(d.a.h0.l.k.h hVar, d.a.h0.l.h.g gVar) {
        if (gVar != null && b(hVar, gVar.w())) {
            return new f<>(new e(hVar), hVar, new c(gVar.w()));
        }
        return null;
    }

    public static f<d.a.h0.l.k.i> i(d.a.h0.l.k.i iVar, d.a.h0.l.h.g gVar) {
        if (gVar != null && b(iVar, gVar.y())) {
            return new f<>(new e(iVar), iVar, new c(gVar.y()));
        }
        return null;
    }

    public static <T> void j(T t, String str, d.a.h0.l.h.c<T> cVar) {
        cVar.f(t, new d.a.h0.l.k.a(ErrorConstant.Code.DOWNLOAD_ERROR_NETWROK_CHANGE, String.format(ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_MISS_PARAM, str)));
    }
}
