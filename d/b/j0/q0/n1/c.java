package d.b.j0.q0.n1;

import android.view.View;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import com.baidu.tieba.tbadkCore.FrsViewData;
import d.b.c.j.e.n;
import d.b.i0.r.q.a2;
import d.b.j0.q0.n2.k;
import d.b.j0.q0.o2.h;
import d.b.j0.q0.r;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class c implements d.b.j0.q0.n1.e.b {
    @Override // d.b.j0.q0.n1.e.b
    public void a(View view) {
        view.setVisibility(8);
    }

    @Override // d.b.j0.q0.n1.e.b
    public void b(h hVar, r rVar, FrsViewData frsViewData) {
        if (hVar == null || rVar == null || frsViewData == null) {
            return;
        }
        hVar.s();
        if (frsViewData == null || frsViewData.getForum() == null) {
            return;
        }
        rVar.S0(frsViewData.getForum().getFrsBannerData());
    }

    @Override // d.b.j0.q0.n1.e.b
    public int c(int i, FrsRequestData frsRequestData) {
        return k.e(i, frsRequestData);
    }

    @Override // d.b.j0.q0.n1.e.b
    public boolean d(int i) {
        return false;
    }

    @Override // d.b.j0.q0.n1.e.b
    public void e(h hVar, FrsViewData frsViewData) {
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
            if (next.getType() == a2.G2) {
                arrayList.add(next);
            }
        }
        frsViewData.setTopThreadList(arrayList);
    }
}
