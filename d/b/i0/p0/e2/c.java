package d.b.i0.p0.e2;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.loadmore.FrsLoadMoreModel;
import com.baidu.tieba.frs.mc.FrsModelController;
import com.baidu.tieba.frs.smartsort.FrsSmartLoadMoreModel;
import com.baidu.tieba.tbadkCore.FrsViewData;
import d.b.i0.p0.r;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public final FrsFragment f57415a;

    /* renamed from: b  reason: collision with root package name */
    public final FrsLoadMoreModel f57416b;

    /* renamed from: c  reason: collision with root package name */
    public final FrsSmartLoadMoreModel f57417c;

    /* renamed from: d  reason: collision with root package name */
    public final FrsModelController f57418d;

    /* renamed from: e  reason: collision with root package name */
    public final r f57419e;

    /* renamed from: f  reason: collision with root package name */
    public final b f57420f = new a();

    /* loaded from: classes4.dex */
    public class a implements b {
        public a() {
        }

        @Override // d.b.i0.p0.e2.c.b
        public void removeItem(int i) {
            if (c.this.f57419e == null || c.this.f57419e.Z() == null) {
                return;
            }
            List<d.b.b.j.e.n> data = c.this.f57419e.Z().getData();
            if (ListUtils.isEmpty(data) || c.this.f57419e.Z().getAdapter() == null || ((d.b.b.j.e.n) ListUtils.remove(data, i)) == null) {
                return;
            }
            c.this.f57419e.Z().getAdapter().notifyItemRemoved(i);
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void removeItem(int i);
    }

    public c(FrsFragment frsFragment, k kVar) {
        if (frsFragment != null) {
            this.f57415a = frsFragment;
            this.f57416b = new FrsLoadMoreModel(frsFragment, kVar);
            FrsSmartLoadMoreModel frsSmartLoadMoreModel = new FrsSmartLoadMoreModel(frsFragment, kVar);
            this.f57417c = frsSmartLoadMoreModel;
            frsSmartLoadMoreModel.I(this.f57420f);
            this.f57416b.N(this.f57420f);
            this.f57419e = frsFragment.x0();
            FrsModelController M = frsFragment.M();
            this.f57418d = M;
            this.f57417c.setSortType(M.W());
            this.f57416b.setSortType(this.f57418d.W());
            return;
        }
        throw new NullPointerException("FrsFragment is NullPointerException");
    }

    public boolean b(List<Long> list) {
        FrsModelController frsModelController = this.f57418d;
        if (frsModelController == null || frsModelController.q0()) {
            return false;
        }
        return this.f57416b.w(list);
    }

    public ArrayList<d.b.b.j.e.n> c(boolean z, boolean z2, ArrayList<d.b.b.j.e.n> arrayList, d.b.i0.c3.h0.f fVar, boolean z3) {
        return d(z, z2, arrayList, fVar, false, z3);
    }

    public ArrayList<d.b.b.j.e.n> d(boolean z, boolean z2, ArrayList<d.b.b.j.e.n> arrayList, d.b.i0.c3.h0.f fVar, boolean z3, boolean z4) {
        if (this.f57418d == null) {
            return arrayList;
        }
        boolean p0 = this.f57415a.M().p0();
        if (this.f57418d.q0()) {
            return this.f57417c.u(z, p0, arrayList, z3, z4);
        }
        return this.f57416b.y(z, p0, z2, arrayList, fVar);
    }

    public ArrayList<d.b.b.j.e.n> e() {
        if (this.f57418d.q0()) {
            return this.f57417c.v();
        }
        return this.f57418d.S();
    }

    public FrsSmartLoadMoreModel f() {
        return this.f57417c;
    }

    public int g() {
        FrsModelController frsModelController = this.f57418d;
        if (frsModelController == null) {
            return 1;
        }
        if (frsModelController.q0()) {
            return this.f57417c.getPn();
        }
        return this.f57416b.getPn();
    }

    public int h() {
        FrsModelController frsModelController = this.f57418d;
        if (frsModelController == null) {
            return -1;
        }
        if (frsModelController.q0()) {
            return this.f57417c.w();
        }
        return this.f57416b.A();
    }

    public void i(String str, String str2, FrsViewData frsViewData) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921462, 0));
        if (this.f57418d == null || this.f57419e == null || frsViewData == null) {
            return;
        }
        this.f57415a.M = System.currentTimeMillis();
        if (this.f57418d.q0()) {
            if (this.f57417c.w() != 1 || this.f57418d.o0()) {
                return;
            }
            this.f57417c.setSortType(this.f57418d.W());
            this.f57417c.t();
            int pn = this.f57417c.getPn();
            this.f57417c.setPn(pn);
            this.f57418d.t0(pn + 1);
        } else if (this.f57418d.X() == 1) {
            if (this.f57416b.isLoading || this.f57418d.o0()) {
                return;
            }
            int pn2 = this.f57416b.getPn();
            if (this.f57416b.w(frsViewData.getThreadListIds())) {
                this.f57416b.x();
                this.f57416b.setSortType(this.f57418d.W());
                this.f57416b.I(d.b.b.e.m.b.f(str2, 0L), frsViewData.getThreadListIds(), str, pn2, frsViewData.isBrandForum, this.f57418d.Z() != null ? d.b.i0.r2.a.e(this.f57418d.Z().getThreadList(), false) : "");
            } else if (this.f57416b.A() == 1) {
                this.f57416b.x();
                this.f57416b.setPn(pn2);
                this.f57418d.t0(pn2 + 1);
                FrsLoadMoreModel frsLoadMoreModel = this.f57416b;
                frsLoadMoreModel.loadingDone = false;
                frsLoadMoreModel.loadIndex = 0;
            }
        } else if (this.f57418d.r0()) {
        } else {
            this.f57418d.s0();
        }
    }

    public void j(d.b.b.j.e.n nVar) {
        if (nVar == null) {
            return;
        }
        if (this.f57418d.q0()) {
            this.f57417c.C(nVar);
        } else {
            this.f57416b.G(nVar);
        }
    }

    public void k() {
        FrsModelController frsModelController = this.f57418d;
        if (frsModelController == null) {
            return;
        }
        if (frsModelController.q0()) {
            this.f57417c.D();
        } else {
            this.f57416b.J();
        }
    }

    public void l(d.b.i0.r0.a aVar) {
        this.f57416b.K(aVar);
        this.f57417c.G(aVar);
    }

    public void m(int i) {
        FrsModelController frsModelController = this.f57418d;
        if (frsModelController == null) {
            return;
        }
        if (frsModelController.q0()) {
            this.f57417c.H(i);
        } else {
            this.f57416b.M(i);
        }
    }

    public void n(int i) {
        FrsModelController frsModelController = this.f57418d;
        if (frsModelController == null) {
            return;
        }
        if (frsModelController.q0()) {
            this.f57417c.setPn(i);
        } else {
            this.f57416b.setPn(i);
        }
    }
}
