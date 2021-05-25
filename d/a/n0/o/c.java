package d.a.n0.o;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.ubs.analytics.SampleResult;
import d.a.c.e.p.k;
import d.a.r0.a.b;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public int f57752a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f57753b = false;

    public c() {
        i();
    }

    public final int a(int i2) {
        if (i2 == 1) {
            return d(i2);
        }
        int i3 = this.f57752a;
        if (i3 == 1) {
            return c(i2);
        }
        if (i3 == 0) {
            return d(i2);
        }
        return 0;
    }

    public void b(ArrayList<Integer> arrayList, b bVar) {
        if (arrayList == null || bVar == null) {
            return;
        }
        Iterator<Integer> it = arrayList.iterator();
        while (it.hasNext()) {
            int intValue = it.next().intValue();
            bVar.b(intValue, a(intValue));
        }
    }

    public final int c(int i2) {
        String e2 = e(i2);
        if (k.isEmpty(e2)) {
            return 0;
        }
        SampleResult a2 = d.a.r0.a.a.a(e2);
        return (a2 == SampleResult.T1 || a2 == SampleResult.T2 || a2 == SampleResult.T3 || a2 == SampleResult.T4 || a2 == SampleResult.T5) ? 1 : 0;
    }

    public final int d(int i2) {
        String f2 = f(i2);
        return (!k.isEmpty(f2) && d.a.m0.r.d0.b.j().k(f2, 0) == 1) ? 1 : 0;
    }

    public final String e(int i2) {
        if (i2 == 2) {
            return "46";
        }
        return null;
    }

    public final String f(int i2) {
        if (i2 == 1) {
            return "key_card_show_type";
        }
        if (i2 == 2) {
            return "key_card_abstract_switch";
        }
        return null;
    }

    public boolean g() {
        return this.f57753b;
    }

    public boolean h() {
        if (TbadkCoreApplication.getInst().isMainProcess(true)) {
            try {
                b.a aVar = new b.a();
                aVar.e(TbadkCoreApplication.getInst());
                aVar.j(false);
                aVar.n(30L);
                aVar.m(1);
                aVar.l(false);
                aVar.o(15L);
                aVar.k(1000);
                d.a.r0.a.a.b(aVar.c());
                return true;
            } catch (Exception e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return false;
    }

    public final void i() {
        this.f57752a = d.a.m0.r.d0.b.j().k("key_abtest_channel", 0);
        j();
    }

    public final void j() {
        if (this.f57753b || this.f57752a != 1) {
            return;
        }
        boolean h2 = h();
        this.f57753b = h2;
        if (h2) {
            return;
        }
        this.f57752a = 0;
    }

    public void k(int i2) {
        if (i2 == 1 || i2 == 0) {
            this.f57752a = i2;
            d.a.m0.r.d0.b.j().v("key_abtest_channel", this.f57752a);
            j();
        }
    }
}
