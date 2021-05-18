package d.a.i0.a.t1.e;

import android.text.TextUtils;
import android.util.Log;
import d.a.i0.a.a1.e;
import d.a.i0.a.k;
import d.a.i0.a.v2.l0;
import d.a.i0.n.h.h;
import d.a.i0.t.d;
import java.io.File;
import java.util.List;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f44614a = k.f43025a;

    public static void a() {
        String[] list = e.q().list();
        if (list == null || list.length <= 0) {
            return;
        }
        for (String str : list) {
            if (!TextUtils.isEmpty(str)) {
                h hVar = new h();
                hVar.f47836g = str;
                hVar.f47838i = -1L;
                d.a.i0.n.g.a.h().f(hVar);
            }
        }
        e.C0550e.d();
    }

    public static void b(String str) {
        File s;
        String[] list;
        if (TextUtils.isEmpty(str) || (s = e.s(str)) == null || (list = s.list()) == null || list.length <= 1) {
            return;
        }
        List<h> j = d.a.i0.a.t1.b.a.j(str);
        for (String str2 : list) {
            long j2 = -1;
            try {
                j2 = Long.parseLong(str2);
            } catch (NumberFormatException e2) {
                if (f44614a) {
                    d.a.i0.a.t1.d.a.a(Log.getStackTraceString(e2));
                }
            }
            if (!c(j2, j)) {
                d.K(e.t(str, str2));
                d.a.i0.a.t1.d.a.a("delete plugin name = " + str + " ; version = " + str2);
            }
        }
        h hVar = null;
        if (j != null) {
            if (j.size() == 1) {
                hVar = j.get(0);
            } else if (j.size() >= 2) {
                hVar = j.get(1);
            }
        }
        if (hVar != null) {
            d.a.i0.n.g.a.h().f(hVar);
        }
    }

    public static boolean c(long j, List<h> list) {
        if (j >= 0 && list != null && list.size() != 0) {
            int min = Math.min(list.size(), 2);
            for (int i2 = 0; i2 < min; i2++) {
                h hVar = list.get(i2);
                if (hVar != null && (j == hVar.f47838i || j == l0.c(hVar.j))) {
                    return true;
                }
            }
        }
        return false;
    }
}
