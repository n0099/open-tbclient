package d.o.a.d.f;

import d.o.a.e.b.j.a;
/* loaded from: classes7.dex */
public class m {
    public static int a(int i2, int i3) {
        return (i3 <= 0 || i3 >= 100 || !d(i2)) ? i3 : (int) (Math.sqrt(i3) * 10.0d);
    }

    public static long b(int i2, long j, long j2) {
        if (d(i2)) {
            if (j <= 0) {
                return 0L;
            }
            return j2 <= 0 ? j : (j2 * a(i2, (int) ((j * 100) / j2))) / 100;
        }
        return j;
    }

    public static d.o.a.a.a.d.e c(d.o.a.a.a.d.e eVar) {
        if (eVar != null && d((int) eVar.f66548a)) {
            eVar.f66551d = b((int) eVar.f66548a, eVar.f66551d, eVar.f66550c);
        }
        return eVar;
    }

    public static boolean d(int i2) {
        return a.d(i2).b("pause_optimise_pretend_download_percent_switch", 0) == 1 && a.d(i2).b("pause_optimise_switch", 0) == 1;
    }
}
