package d.a.n0.r0.e2;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.loadmore.FrsLoadMoreModel;
import com.baidu.tieba.frs.mc.FrsModelController;
import com.baidu.tieba.frs.smartsort.FrsSmartLoadMoreModel;
import com.baidu.tieba.tbadkCore.FrsViewData;
import d.a.n0.r0.r;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public final FrsFragment f62156a;

    /* renamed from: b  reason: collision with root package name */
    public final FrsLoadMoreModel f62157b;

    /* renamed from: c  reason: collision with root package name */
    public final FrsSmartLoadMoreModel f62158c;

    /* renamed from: d  reason: collision with root package name */
    public final FrsModelController f62159d;

    /* renamed from: e  reason: collision with root package name */
    public final r f62160e;

    /* renamed from: f  reason: collision with root package name */
    public final b f62161f = new a();

    /* loaded from: classes4.dex */
    public class a implements b {
        public a() {
        }

        @Override // d.a.n0.r0.e2.c.b
        public void removeItem(int i2) {
            if (c.this.f62160e == null || c.this.f62160e.Z() == null) {
                return;
            }
            List<d.a.c.k.e.n> data = c.this.f62160e.Z().getData();
            if (ListUtils.isEmpty(data) || c.this.f62160e.Z().getAdapter() == null || ((d.a.c.k.e.n) ListUtils.remove(data, i2)) == null) {
                return;
            }
            c.this.f62160e.Z().getAdapter().notifyItemRemoved(i2);
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void removeItem(int i2);
    }

    public c(FrsFragment frsFragment, k kVar) {
        if (frsFragment != null) {
            this.f62156a = frsFragment;
            this.f62157b = new FrsLoadMoreModel(frsFragment, kVar);
            FrsSmartLoadMoreModel frsSmartLoadMoreModel = new FrsSmartLoadMoreModel(frsFragment, kVar);
            this.f62158c = frsSmartLoadMoreModel;
            frsSmartLoadMoreModel.M(this.f62161f);
            this.f62157b.R(this.f62161f);
            this.f62160e = frsFragment.B0();
            FrsModelController e0 = frsFragment.e0();
            this.f62159d = e0;
            this.f62158c.setSortType(e0.a0());
            this.f62157b.setSortType(this.f62159d.a0());
            return;
        }
        throw new NullPointerException("FrsFragment is NullPointerException");
    }

    public boolean b(List<Long> list) {
        FrsModelController frsModelController = this.f62159d;
        if (frsModelController == null || frsModelController.u0()) {
            return false;
        }
        return this.f62157b.A(list);
    }

    public ArrayList<d.a.c.k.e.n> c(boolean z, boolean z2, ArrayList<d.a.c.k.e.n> arrayList, d.a.n0.e3.h0.f fVar, boolean z3) {
        return d(z, z2, arrayList, fVar, false, z3);
    }

    public ArrayList<d.a.c.k.e.n> d(boolean z, boolean z2, ArrayList<d.a.c.k.e.n> arrayList, d.a.n0.e3.h0.f fVar, boolean z3, boolean z4) {
        if (this.f62159d == null) {
            return arrayList;
        }
        boolean t0 = this.f62156a.e0().t0();
        if (this.f62159d.u0()) {
            return this.f62158c.y(z, t0, arrayList, z3, z4);
        }
        return this.f62157b.C(z, t0, z2, arrayList, fVar);
    }

    public ArrayList<d.a.c.k.e.n> e() {
        if (this.f62159d.u0()) {
            return this.f62158c.z();
        }
        return this.f62159d.W();
    }

    public FrsSmartLoadMoreModel f() {
        return this.f62158c;
    }

    public int g() {
        FrsModelController frsModelController = this.f62159d;
        if (frsModelController == null) {
            return 1;
        }
        if (frsModelController.u0()) {
            return this.f62158c.getPn();
        }
        return this.f62157b.getPn();
    }

    public int h() {
        FrsModelController frsModelController = this.f62159d;
        if (frsModelController == null) {
            return -1;
        }
        if (frsModelController.u0()) {
            return this.f62158c.A();
        }
        return this.f62157b.E();
    }

    public void i(String str, String str2, FrsViewData frsViewData) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921462, 0));
        if (this.f62159d == null || this.f62160e == null || frsViewData == null) {
            return;
        }
        this.f62156a.M = System.currentTimeMillis();
        if (this.f62159d.u0()) {
            if (this.f62158c.A() != 1 || this.f62159d.s0()) {
                return;
            }
            this.f62158c.setSortType(this.f62159d.a0());
            this.f62158c.x();
            int pn = this.f62158c.getPn();
            this.f62158c.setPn(pn);
            this.f62159d.x0(pn + 1);
        } else if (this.f62159d.b0() == 1) {
            if (this.f62157b.isLoading || this.f62159d.s0()) {
                return;
            }
            int pn2 = this.f62157b.getPn();
            if (this.f62157b.A(frsViewData.getThreadListIds())) {
                this.f62157b.B();
                this.f62157b.setSortType(this.f62159d.a0());
                this.f62157b.M(d.a.c.e.m.b.f(str2, 0L), frsViewData.getThreadListIds(), str, pn2, frsViewData.isBrandForum, this.f62159d.d0() != null ? d.a.n0.t2.a.e(this.f62159d.d0().getThreadList(), false) : "");
            } else if (this.f62157b.E() == 1) {
                this.f62157b.B();
                this.f62157b.setPn(pn2);
                this.f62159d.x0(pn2 + 1);
                FrsLoadMoreModel frsLoadMoreModel = this.f62157b;
                frsLoadMoreModel.loadingDone = false;
                frsLoadMoreModel.loadIndex = 0;
            }
        } else if (this.f62159d.v0()) {
        } else {
            this.f62159d.w0();
        }
    }

    public void j(d.a.c.k.e.n nVar) {
        if (nVar == null) {
            return;
        }
        if (this.f62159d.u0()) {
            this.f62158c.G(nVar);
        } else {
            this.f62157b.K(nVar);
        }
    }

    public void k() {
        FrsModelController frsModelController = this.f62159d;
        if (frsModelController == null) {
            return;
        }
        if (frsModelController.u0()) {
            this.f62158c.H();
        } else {
            this.f62157b.N();
        }
    }

    public void l(d.a.n0.t0.a aVar) {
        this.f62157b.O(aVar);
        this.f62158c.K(aVar);
    }

    public void m(int i2) {
        FrsModelController frsModelController = this.f62159d;
        if (frsModelController == null) {
            return;
        }
        if (frsModelController.u0()) {
            this.f62158c.L(i2);
        } else {
            this.f62157b.Q(i2);
        }
    }

    public void n(int i2) {
        FrsModelController frsModelController = this.f62159d;
        if (frsModelController == null) {
            return;
        }
        if (frsModelController.u0()) {
            this.f62158c.setPn(i2);
        } else {
            this.f62157b.setPn(i2);
        }
    }
}
