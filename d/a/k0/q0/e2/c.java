package d.a.k0.q0.e2;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.loadmore.FrsLoadMoreModel;
import com.baidu.tieba.frs.mc.FrsModelController;
import com.baidu.tieba.frs.smartsort.FrsSmartLoadMoreModel;
import com.baidu.tieba.tbadkCore.FrsViewData;
import d.a.k0.q0.r;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public final FrsFragment f58324a;

    /* renamed from: b  reason: collision with root package name */
    public final FrsLoadMoreModel f58325b;

    /* renamed from: c  reason: collision with root package name */
    public final FrsSmartLoadMoreModel f58326c;

    /* renamed from: d  reason: collision with root package name */
    public final FrsModelController f58327d;

    /* renamed from: e  reason: collision with root package name */
    public final r f58328e;

    /* renamed from: f  reason: collision with root package name */
    public final b f58329f = new a();

    /* loaded from: classes4.dex */
    public class a implements b {
        public a() {
        }

        @Override // d.a.k0.q0.e2.c.b
        public void removeItem(int i2) {
            if (c.this.f58328e == null || c.this.f58328e.Z() == null) {
                return;
            }
            List<d.a.c.j.e.n> data = c.this.f58328e.Z().getData();
            if (ListUtils.isEmpty(data) || c.this.f58328e.Z().getAdapter() == null || ((d.a.c.j.e.n) ListUtils.remove(data, i2)) == null) {
                return;
            }
            c.this.f58328e.Z().getAdapter().notifyItemRemoved(i2);
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void removeItem(int i2);
    }

    public c(FrsFragment frsFragment, k kVar) {
        if (frsFragment != null) {
            this.f58324a = frsFragment;
            this.f58325b = new FrsLoadMoreModel(frsFragment, kVar);
            FrsSmartLoadMoreModel frsSmartLoadMoreModel = new FrsSmartLoadMoreModel(frsFragment, kVar);
            this.f58326c = frsSmartLoadMoreModel;
            frsSmartLoadMoreModel.I(this.f58329f);
            this.f58325b.N(this.f58329f);
            this.f58328e = frsFragment.y0();
            FrsModelController b0 = frsFragment.b0();
            this.f58327d = b0;
            this.f58326c.setSortType(b0.W());
            this.f58325b.setSortType(this.f58327d.W());
            return;
        }
        throw new NullPointerException("FrsFragment is NullPointerException");
    }

    public boolean b(List<Long> list) {
        FrsModelController frsModelController = this.f58327d;
        if (frsModelController == null || frsModelController.q0()) {
            return false;
        }
        return this.f58325b.w(list);
    }

    public ArrayList<d.a.c.j.e.n> c(boolean z, boolean z2, ArrayList<d.a.c.j.e.n> arrayList, d.a.k0.d3.h0.f fVar, boolean z3) {
        return d(z, z2, arrayList, fVar, false, z3);
    }

    public ArrayList<d.a.c.j.e.n> d(boolean z, boolean z2, ArrayList<d.a.c.j.e.n> arrayList, d.a.k0.d3.h0.f fVar, boolean z3, boolean z4) {
        if (this.f58327d == null) {
            return arrayList;
        }
        boolean p0 = this.f58324a.b0().p0();
        if (this.f58327d.q0()) {
            return this.f58326c.u(z, p0, arrayList, z3, z4);
        }
        return this.f58325b.y(z, p0, z2, arrayList, fVar);
    }

    public ArrayList<d.a.c.j.e.n> e() {
        if (this.f58327d.q0()) {
            return this.f58326c.v();
        }
        return this.f58327d.S();
    }

    public FrsSmartLoadMoreModel f() {
        return this.f58326c;
    }

    public int g() {
        FrsModelController frsModelController = this.f58327d;
        if (frsModelController == null) {
            return 1;
        }
        if (frsModelController.q0()) {
            return this.f58326c.getPn();
        }
        return this.f58325b.getPn();
    }

    public int h() {
        FrsModelController frsModelController = this.f58327d;
        if (frsModelController == null) {
            return -1;
        }
        if (frsModelController.q0()) {
            return this.f58326c.w();
        }
        return this.f58325b.A();
    }

    public void i(String str, String str2, FrsViewData frsViewData) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921462, 0));
        if (this.f58327d == null || this.f58328e == null || frsViewData == null) {
            return;
        }
        this.f58324a.M = System.currentTimeMillis();
        if (this.f58327d.q0()) {
            if (this.f58326c.w() != 1 || this.f58327d.o0()) {
                return;
            }
            this.f58326c.setSortType(this.f58327d.W());
            this.f58326c.t();
            int pn = this.f58326c.getPn();
            this.f58326c.setPn(pn);
            this.f58327d.t0(pn + 1);
        } else if (this.f58327d.X() == 1) {
            if (this.f58325b.isLoading || this.f58327d.o0()) {
                return;
            }
            int pn2 = this.f58325b.getPn();
            if (this.f58325b.w(frsViewData.getThreadListIds())) {
                this.f58325b.x();
                this.f58325b.setSortType(this.f58327d.W());
                this.f58325b.I(d.a.c.e.m.b.f(str2, 0L), frsViewData.getThreadListIds(), str, pn2, frsViewData.isBrandForum, this.f58327d.Z() != null ? d.a.k0.s2.a.e(this.f58327d.Z().getThreadList(), false) : "");
            } else if (this.f58325b.A() == 1) {
                this.f58325b.x();
                this.f58325b.setPn(pn2);
                this.f58327d.t0(pn2 + 1);
                FrsLoadMoreModel frsLoadMoreModel = this.f58325b;
                frsLoadMoreModel.loadingDone = false;
                frsLoadMoreModel.loadIndex = 0;
            }
        } else if (this.f58327d.r0()) {
        } else {
            this.f58327d.s0();
        }
    }

    public void j(d.a.c.j.e.n nVar) {
        if (nVar == null) {
            return;
        }
        if (this.f58327d.q0()) {
            this.f58326c.C(nVar);
        } else {
            this.f58325b.G(nVar);
        }
    }

    public void k() {
        FrsModelController frsModelController = this.f58327d;
        if (frsModelController == null) {
            return;
        }
        if (frsModelController.q0()) {
            this.f58326c.D();
        } else {
            this.f58325b.J();
        }
    }

    public void l(d.a.k0.s0.a aVar) {
        this.f58325b.K(aVar);
        this.f58326c.G(aVar);
    }

    public void m(int i2) {
        FrsModelController frsModelController = this.f58327d;
        if (frsModelController == null) {
            return;
        }
        if (frsModelController.q0()) {
            this.f58326c.H(i2);
        } else {
            this.f58325b.M(i2);
        }
    }

    public void n(int i2) {
        FrsModelController frsModelController = this.f58327d;
        if (frsModelController == null) {
            return;
        }
        if (frsModelController.q0()) {
            this.f58326c.setPn(i2);
        } else {
            this.f58325b.setPn(i2);
        }
    }
}
