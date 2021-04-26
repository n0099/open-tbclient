package d.a.h0.a.l1.e;

import android.text.TextUtils;
import android.util.Log;
import d.a.h0.a.b2.b;
import d.a.h0.a.u0.d;
import d.a.h0.l.k.h;
import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: d.a.h0.a.l1.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0703a implements Comparator<String> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(String str, String str2) {
            int i2 = (Long.parseLong(str) > Long.parseLong(str2) ? 1 : (Long.parseLong(str) == Long.parseLong(str2) ? 0 : -1));
            if (i2 > 0) {
                return -1;
            }
            return i2 < 0 ? 1 : 0;
        }
    }

    public static void a(String str, int i2) {
        File k;
        String[] list;
        if (TextUtils.isEmpty(str) || i2 < 0 || (k = d.k(str)) == null || (list = k.list()) == null || list.length <= i2) {
            return;
        }
        List asList = Arrays.asList(list);
        try {
            Collections.sort(asList, new C0703a());
        } catch (NumberFormatException e2) {
            d.a.h0.a.l1.d.a.a(Log.getStackTraceString(e2));
        }
        int size = asList.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (i3 >= i2) {
                String str2 = (String) asList.get(i3);
                d.a.h0.p.d.f(d.l(str, str2));
                b(str, Long.parseLong(str2));
                d.a.h0.a.l1.d.a.a("delete plugin name = " + str + " ; version = " + str2);
            }
        }
    }

    public static void b(String str, long j) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        h hVar = new h();
        hVar.f47153g = str;
        hVar.j = b.q(j);
        d.a.h0.l.i.a.h().f(hVar);
    }
}
