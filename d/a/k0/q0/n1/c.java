package d.a.k0.q0.n1;

import android.view.View;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import com.baidu.tieba.tbadkCore.FrsViewData;
import d.a.c.j.e.n;
import d.a.j0.r.q.a2;
import d.a.k0.q0.n2.k;
import d.a.k0.q0.o2.h;
import d.a.k0.q0.r;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class c implements d.a.k0.q0.n1.e.b {
    @Override // d.a.k0.q0.n1.e.b
    public void a(h hVar, FrsViewData frsViewData) {
        if (hVar == null || frsViewData == null) {
            return;
        }
        ArrayList<n> threadList = frsViewData.getThreadList();
        if (ListUtils.isEmpty(threadList)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<n> it = threadList.iterator();
        while (it.hasNext()) {
            n next = it.next();
            if (next.getType() == a2.H2) {
                arrayList.add(next);
            }
        }
        frsViewData.setTopThreadList(arrayList);
    }

    @Override // d.a.k0.q0.n1.e.b
    public void b(View view) {
        view.setVisibility(8);
    }

    @Override // d.a.k0.q0.n1.e.b
    public void c(h hVar, r rVar, FrsViewData frsViewData) {
        if (hVar == null || rVar == null || frsViewData == null) {
            return;
        }
        hVar.r();
        if (frsViewData == null || frsViewData.getForum() == null) {
            return;
        }
        rVar.S0(frsViewData.getForum().getFrsBannerData());
    }

    @Override // d.a.k0.q0.n1.e.b
    public int d(int i2, FrsRequestData frsRequestData) {
        return k.e(i2, frsRequestData);
    }

    @Override // d.a.k0.q0.n1.e.b
    public boolean e(int i2) {
        return false;
    }
}
