package d.b.j0.q0.e2;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.loadmore.FrsLoadMoreModel;
import com.baidu.tieba.frs.mc.FrsModelController;
import com.baidu.tieba.frs.smartsort.FrsSmartLoadMoreModel;
import com.baidu.tieba.tbadkCore.FrsViewData;
import d.b.j0.q0.r;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public final FrsFragment f59536a;

    /* renamed from: b  reason: collision with root package name */
    public final FrsLoadMoreModel f59537b;

    /* renamed from: c  reason: collision with root package name */
    public final FrsSmartLoadMoreModel f59538c;

    /* renamed from: d  reason: collision with root package name */
    public final FrsModelController f59539d;

    /* renamed from: e  reason: collision with root package name */
    public final r f59540e;

    /* renamed from: f  reason: collision with root package name */
    public final b f59541f = new a();

    /* loaded from: classes4.dex */
    public class a implements b {
        public a() {
        }

        @Override // d.b.j0.q0.e2.c.b
        public void removeItem(int i) {
            if (c.this.f59540e == null || c.this.f59540e.Z() == null) {
                return;
            }
            List<d.b.c.j.e.n> data = c.this.f59540e.Z().getData();
            if (ListUtils.isEmpty(data) || c.this.f59540e.Z().getAdapter() == null || ((d.b.c.j.e.n) ListUtils.remove(data, i)) == null) {
                return;
            }
            c.this.f59540e.Z().getAdapter().notifyItemRemoved(i);
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void removeItem(int i);
    }

    public c(FrsFragment frsFragment, k kVar) {
        if (frsFragment != null) {
            this.f59536a = frsFragment;
            this.f59537b = new FrsLoadMoreModel(frsFragment, kVar);
            FrsSmartLoadMoreModel frsSmartLoadMoreModel = new FrsSmartLoadMoreModel(frsFragment, kVar);
            this.f59538c = frsSmartLoadMoreModel;
            frsSmartLoadMoreModel.I(this.f59541f);
            this.f59537b.N(this.f59541f);
            this.f59540e = frsFragment.x0();
            FrsModelController M = frsFragment.M();
            this.f59539d = M;
            this.f59538c.setSortType(M.W());
            this.f59537b.setSortType(this.f59539d.W());
            return;
        }
        throw new NullPointerException("FrsFragment is NullPointerException");
    }

    public boolean b(List<Long> list) {
        FrsModelController frsModelController = this.f59539d;
        if (frsModelController == null || frsModelController.q0()) {
            return false;
        }
        return this.f59537b.w(list);
    }

    public ArrayList<d.b.c.j.e.n> c(boolean z, boolean z2, ArrayList<d.b.c.j.e.n> arrayList, d.b.j0.d3.h0.f fVar, boolean z3) {
        return d(z, z2, arrayList, fVar, false, z3);
    }

    public ArrayList<d.b.c.j.e.n> d(boolean z, boolean z2, ArrayList<d.b.c.j.e.n> arrayList, d.b.j0.d3.h0.f fVar, boolean z3, boolean z4) {
        if (this.f59539d == null) {
            return arrayList;
        }
        boolean p0 = this.f59536a.M().p0();
        if (this.f59539d.q0()) {
            return this.f59538c.u(z, p0, arrayList, z3, z4);
        }
        return this.f59537b.y(z, p0, z2, arrayList, fVar);
    }

    public ArrayList<d.b.c.j.e.n> e() {
        if (this.f59539d.q0()) {
            return this.f59538c.v();
        }
        return this.f59539d.S();
    }

    public FrsSmartLoadMoreModel f() {
        return this.f59538c;
    }

    public int g() {
        FrsModelController frsModelController = this.f59539d;
        if (frsModelController == null) {
            return 1;
        }
        if (frsModelController.q0()) {
            return this.f59538c.getPn();
        }
        return this.f59537b.getPn();
    }

    public int h() {
        FrsModelController frsModelController = this.f59539d;
        if (frsModelController == null) {
            return -1;
        }
        if (frsModelController.q0()) {
            return this.f59538c.w();
        }
        return this.f59537b.A();
    }

    public void i(String str, String str2, FrsViewData frsViewData) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921462, 0));
        if (this.f59539d == null || this.f59540e == null || frsViewData == null) {
            return;
        }
        this.f59536a.M = System.currentTimeMillis();
        if (this.f59539d.q0()) {
            if (this.f59538c.w() != 1 || this.f59539d.o0()) {
                return;
            }
            this.f59538c.setSortType(this.f59539d.W());
            this.f59538c.t();
            int pn = this.f59538c.getPn();
            this.f59538c.setPn(pn);
            this.f59539d.t0(pn + 1);
        } else if (this.f59539d.X() == 1) {
            if (this.f59537b.isLoading || this.f59539d.o0()) {
                return;
            }
            int pn2 = this.f59537b.getPn();
            if (this.f59537b.w(frsViewData.getThreadListIds())) {
                this.f59537b.x();
                this.f59537b.setSortType(this.f59539d.W());
                this.f59537b.I(d.b.c.e.m.b.f(str2, 0L), frsViewData.getThreadListIds(), str, pn2, frsViewData.isBrandForum, this.f59539d.Z() != null ? d.b.j0.s2.a.e(this.f59539d.Z().getThreadList(), false) : "");
            } else if (this.f59537b.A() == 1) {
                this.f59537b.x();
                this.f59537b.setPn(pn2);
                this.f59539d.t0(pn2 + 1);
                FrsLoadMoreModel frsLoadMoreModel = this.f59537b;
                frsLoadMoreModel.loadingDone = false;
                frsLoadMoreModel.loadIndex = 0;
            }
        } else if (this.f59539d.r0()) {
        } else {
            this.f59539d.s0();
        }
    }

    public void j(d.b.c.j.e.n nVar) {
        if (nVar == null) {
            return;
        }
        if (this.f59539d.q0()) {
            this.f59538c.C(nVar);
        } else {
            this.f59537b.G(nVar);
        }
    }

    public void k() {
        FrsModelController frsModelController = this.f59539d;
        if (frsModelController == null) {
            return;
        }
        if (frsModelController.q0()) {
            this.f59538c.D();
        } else {
            this.f59537b.J();
        }
    }

    public void l(d.b.j0.s0.a aVar) {
        this.f59537b.K(aVar);
        this.f59538c.G(aVar);
    }

    public void m(int i) {
        FrsModelController frsModelController = this.f59539d;
        if (frsModelController == null) {
            return;
        }
        if (frsModelController.q0()) {
            this.f59538c.H(i);
        } else {
            this.f59537b.M(i);
        }
    }

    public void n(int i) {
        FrsModelController frsModelController = this.f59539d;
        if (frsModelController == null) {
            return;
        }
        if (frsModelController.q0()) {
            this.f59538c.setPn(i);
        } else {
            this.f59537b.setPn(i);
        }
    }
}
