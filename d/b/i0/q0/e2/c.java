package d.b.i0.q0.e2;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.loadmore.FrsLoadMoreModel;
import com.baidu.tieba.frs.mc.FrsModelController;
import com.baidu.tieba.frs.smartsort.FrsSmartLoadMoreModel;
import com.baidu.tieba.tbadkCore.FrsViewData;
import d.b.i0.q0.r;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public final FrsFragment f59115a;

    /* renamed from: b  reason: collision with root package name */
    public final FrsLoadMoreModel f59116b;

    /* renamed from: c  reason: collision with root package name */
    public final FrsSmartLoadMoreModel f59117c;

    /* renamed from: d  reason: collision with root package name */
    public final FrsModelController f59118d;

    /* renamed from: e  reason: collision with root package name */
    public final r f59119e;

    /* renamed from: f  reason: collision with root package name */
    public final b f59120f = new a();

    /* loaded from: classes4.dex */
    public class a implements b {
        public a() {
        }

        @Override // d.b.i0.q0.e2.c.b
        public void removeItem(int i) {
            if (c.this.f59119e == null || c.this.f59119e.Z() == null) {
                return;
            }
            List<d.b.c.j.e.n> data = c.this.f59119e.Z().getData();
            if (ListUtils.isEmpty(data) || c.this.f59119e.Z().getAdapter() == null || ((d.b.c.j.e.n) ListUtils.remove(data, i)) == null) {
                return;
            }
            c.this.f59119e.Z().getAdapter().notifyItemRemoved(i);
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void removeItem(int i);
    }

    public c(FrsFragment frsFragment, k kVar) {
        if (frsFragment != null) {
            this.f59115a = frsFragment;
            this.f59116b = new FrsLoadMoreModel(frsFragment, kVar);
            FrsSmartLoadMoreModel frsSmartLoadMoreModel = new FrsSmartLoadMoreModel(frsFragment, kVar);
            this.f59117c = frsSmartLoadMoreModel;
            frsSmartLoadMoreModel.I(this.f59120f);
            this.f59116b.N(this.f59120f);
            this.f59119e = frsFragment.x0();
            FrsModelController M = frsFragment.M();
            this.f59118d = M;
            this.f59117c.setSortType(M.W());
            this.f59116b.setSortType(this.f59118d.W());
            return;
        }
        throw new NullPointerException("FrsFragment is NullPointerException");
    }

    public boolean b(List<Long> list) {
        FrsModelController frsModelController = this.f59118d;
        if (frsModelController == null || frsModelController.q0()) {
            return false;
        }
        return this.f59116b.w(list);
    }

    public ArrayList<d.b.c.j.e.n> c(boolean z, boolean z2, ArrayList<d.b.c.j.e.n> arrayList, d.b.i0.d3.h0.f fVar, boolean z3) {
        return d(z, z2, arrayList, fVar, false, z3);
    }

    public ArrayList<d.b.c.j.e.n> d(boolean z, boolean z2, ArrayList<d.b.c.j.e.n> arrayList, d.b.i0.d3.h0.f fVar, boolean z3, boolean z4) {
        if (this.f59118d == null) {
            return arrayList;
        }
        boolean p0 = this.f59115a.M().p0();
        if (this.f59118d.q0()) {
            return this.f59117c.u(z, p0, arrayList, z3, z4);
        }
        return this.f59116b.y(z, p0, z2, arrayList, fVar);
    }

    public ArrayList<d.b.c.j.e.n> e() {
        if (this.f59118d.q0()) {
            return this.f59117c.v();
        }
        return this.f59118d.S();
    }

    public FrsSmartLoadMoreModel f() {
        return this.f59117c;
    }

    public int g() {
        FrsModelController frsModelController = this.f59118d;
        if (frsModelController == null) {
            return 1;
        }
        if (frsModelController.q0()) {
            return this.f59117c.getPn();
        }
        return this.f59116b.getPn();
    }

    public int h() {
        FrsModelController frsModelController = this.f59118d;
        if (frsModelController == null) {
            return -1;
        }
        if (frsModelController.q0()) {
            return this.f59117c.w();
        }
        return this.f59116b.A();
    }

    public void i(String str, String str2, FrsViewData frsViewData) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921462, 0));
        if (this.f59118d == null || this.f59119e == null || frsViewData == null) {
            return;
        }
        this.f59115a.M = System.currentTimeMillis();
        if (this.f59118d.q0()) {
            if (this.f59117c.w() != 1 || this.f59118d.o0()) {
                return;
            }
            this.f59117c.setSortType(this.f59118d.W());
            this.f59117c.t();
            int pn = this.f59117c.getPn();
            this.f59117c.setPn(pn);
            this.f59118d.t0(pn + 1);
        } else if (this.f59118d.X() == 1) {
            if (this.f59116b.isLoading || this.f59118d.o0()) {
                return;
            }
            int pn2 = this.f59116b.getPn();
            if (this.f59116b.w(frsViewData.getThreadListIds())) {
                this.f59116b.x();
                this.f59116b.setSortType(this.f59118d.W());
                this.f59116b.I(d.b.c.e.m.b.f(str2, 0L), frsViewData.getThreadListIds(), str, pn2, frsViewData.isBrandForum, this.f59118d.Z() != null ? d.b.i0.s2.a.e(this.f59118d.Z().getThreadList(), false) : "");
            } else if (this.f59116b.A() == 1) {
                this.f59116b.x();
                this.f59116b.setPn(pn2);
                this.f59118d.t0(pn2 + 1);
                FrsLoadMoreModel frsLoadMoreModel = this.f59116b;
                frsLoadMoreModel.loadingDone = false;
                frsLoadMoreModel.loadIndex = 0;
            }
        } else if (this.f59118d.r0()) {
        } else {
            this.f59118d.s0();
        }
    }

    public void j(d.b.c.j.e.n nVar) {
        if (nVar == null) {
            return;
        }
        if (this.f59118d.q0()) {
            this.f59117c.C(nVar);
        } else {
            this.f59116b.G(nVar);
        }
    }

    public void k() {
        FrsModelController frsModelController = this.f59118d;
        if (frsModelController == null) {
            return;
        }
        if (frsModelController.q0()) {
            this.f59117c.D();
        } else {
            this.f59116b.J();
        }
    }

    public void l(d.b.i0.s0.a aVar) {
        this.f59116b.K(aVar);
        this.f59117c.G(aVar);
    }

    public void m(int i) {
        FrsModelController frsModelController = this.f59118d;
        if (frsModelController == null) {
            return;
        }
        if (frsModelController.q0()) {
            this.f59117c.H(i);
        } else {
            this.f59116b.M(i);
        }
    }

    public void n(int i) {
        FrsModelController frsModelController = this.f59118d;
        if (frsModelController == null) {
            return;
        }
        if (frsModelController.q0()) {
            this.f59117c.setPn(i);
        } else {
            this.f59116b.setPn(i);
        }
    }
}
