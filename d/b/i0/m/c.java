package d.b.i0.m;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.ubs.analytics.SampleResult;
import d.b.c.e.p.k;
import d.b.m0.a.b;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public int f58156a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f58157b = false;

    public c() {
        i();
    }

    public final int a(int i) {
        if (i == 1) {
            return d(i);
        }
        int i2 = this.f58156a;
        if (i2 == 1) {
            return c(i);
        }
        if (i2 == 0) {
            return d(i);
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

    public final int c(int i) {
        String e2 = e(i);
        if (k.isEmpty(e2)) {
            return 0;
        }
        SampleResult a2 = d.b.m0.a.a.a(e2);
        return (a2 == SampleResult.T1 || a2 == SampleResult.T2 || a2 == SampleResult.T3 || a2 == SampleResult.T4 || a2 == SampleResult.T5) ? 1 : 0;
    }

    public final int d(int i) {
        String f2 = f(i);
        return (!k.isEmpty(f2) && d.b.h0.r.d0.b.j().k(f2, 0) == 1) ? 1 : 0;
    }

    public final String e(int i) {
        if (i == 2) {
            return "46";
        }
        return null;
    }

    public final String f(int i) {
        if (i == 1) {
            return "key_card_show_type";
        }
        if (i == 2) {
            return "key_card_abstract_switch";
        }
        return null;
    }

    public boolean g() {
        return this.f58157b;
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
                d.b.m0.a.a.b(aVar.c());
                return true;
            } catch (Exception e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return false;
    }

    public final void i() {
        this.f58156a = d.b.h0.r.d0.b.j().k("key_abtest_channel", 0);
        j();
    }

    public final void j() {
        if (this.f58157b || this.f58156a != 1) {
            return;
        }
        boolean h2 = h();
        this.f58157b = h2;
        if (h2) {
            return;
        }
        this.f58156a = 0;
    }

    public void k(int i) {
        if (i == 1 || i == 0) {
            this.f58156a = i;
            d.b.h0.r.d0.b.j().v("key_abtest_channel", this.f58156a);
            j();
        }
    }
}
