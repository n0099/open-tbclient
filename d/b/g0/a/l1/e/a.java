package d.b.g0.a.l1.e;

import android.text.TextUtils;
import android.util.Log;
import d.b.g0.a.b2.b;
import d.b.g0.a.u0.d;
import d.b.g0.l.k.h;
import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: d.b.g0.a.l1.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0744a implements Comparator<String> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(String str, String str2) {
            int i = (Long.parseLong(str) > Long.parseLong(str2) ? 1 : (Long.parseLong(str) == Long.parseLong(str2) ? 0 : -1));
            if (i > 0) {
                return -1;
            }
            return i < 0 ? 1 : 0;
        }
    }

    public static void a(String str, int i) {
        File k;
        String[] list;
        if (TextUtils.isEmpty(str) || i < 0 || (k = d.k(str)) == null || (list = k.list()) == null || list.length <= i) {
            return;
        }
        List asList = Arrays.asList(list);
        try {
            Collections.sort(asList, new C0744a());
        } catch (NumberFormatException e2) {
            d.b.g0.a.l1.d.a.a(Log.getStackTraceString(e2));
        }
        int size = asList.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (i2 >= i) {
                String str2 = (String) asList.get(i2);
                d.b.g0.p.d.f(d.l(str, str2));
                b(str, Long.parseLong(str2));
                d.b.g0.a.l1.d.a.a("delete plugin name = " + str + " ; version = " + str2);
            }
        }
    }

    public static void b(String str, long j) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        h hVar = new h();
        hVar.f49315g = str;
        hVar.j = b.q(j);
        d.b.g0.l.i.a.h().f(hVar);
    }
}
