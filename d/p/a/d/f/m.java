package d.p.a.d.f;

import d.p.a.e.b.j.a;
/* loaded from: classes6.dex */
public class m {
    public static int a(int i, int i2) {
        return (i2 <= 0 || i2 >= 100 || !d(i)) ? i2 : (int) (Math.sqrt(i2) * 10.0d);
    }

    public static long b(int i, long j, long j2) {
        if (d(i)) {
            if (j <= 0) {
                return 0L;
            }
            return j2 <= 0 ? j : (j2 * a(i, (int) ((j * 100) / j2))) / 100;
        }
        return j;
    }

    public static d.p.a.a.a.d.e c(d.p.a.a.a.d.e eVar) {
        if (eVar != null && d((int) eVar.f67526a)) {
            eVar.f67529d = b((int) eVar.f67526a, eVar.f67529d, eVar.f67528c);
        }
        return eVar;
    }

    public static boolean d(int i) {
        return a.d(i).b("pause_optimise_pretend_download_percent_switch", 0) == 1 && a.d(i).b("pause_optimise_switch", 0) == 1;
    }
}
