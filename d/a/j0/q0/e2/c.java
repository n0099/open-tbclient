package d.a.j0.q0.e2;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.loadmore.FrsLoadMoreModel;
import com.baidu.tieba.frs.mc.FrsModelController;
import com.baidu.tieba.frs.smartsort.FrsSmartLoadMoreModel;
import com.baidu.tieba.tbadkCore.FrsViewData;
import d.a.j0.q0.r;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public final FrsFragment f57582a;

    /* renamed from: b  reason: collision with root package name */
    public final FrsLoadMoreModel f57583b;

    /* renamed from: c  reason: collision with root package name */
    public final FrsSmartLoadMoreModel f57584c;

    /* renamed from: d  reason: collision with root package name */
    public final FrsModelController f57585d;

    /* renamed from: e  reason: collision with root package name */
    public final r f57586e;

    /* renamed from: f  reason: collision with root package name */
    public final b f57587f = new a();

    /* loaded from: classes4.dex */
    public class a implements b {
        public a() {
        }

        @Override // d.a.j0.q0.e2.c.b
        public void removeItem(int i2) {
            if (c.this.f57586e == null || c.this.f57586e.Z() == null) {
                return;
            }
            List<d.a.c.j.e.n> data = c.this.f57586e.Z().getData();
            if (ListUtils.isEmpty(data) || c.this.f57586e.Z().getAdapter() == null || ((d.a.c.j.e.n) ListUtils.remove(data, i2)) == null) {
                return;
            }
            c.this.f57586e.Z().getAdapter().notifyItemRemoved(i2);
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void removeItem(int i2);
    }

    public c(FrsFragment frsFragment, k kVar) {
        if (frsFragment != null) {
            this.f57582a = frsFragment;
            this.f57583b = new FrsLoadMoreModel(frsFragment, kVar);
            FrsSmartLoadMoreModel frsSmartLoadMoreModel = new FrsSmartLoadMoreModel(frsFragment, kVar);
            this.f57584c = frsSmartLoadMoreModel;
            frsSmartLoadMoreModel.I(this.f57587f);
            this.f57583b.N(this.f57587f);
            this.f57586e = frsFragment.z0();
            FrsModelController b0 = frsFragment.b0();
            this.f57585d = b0;
            this.f57584c.setSortType(b0.W());
            this.f57583b.setSortType(this.f57585d.W());
            return;
        }
        throw new NullPointerException("FrsFragment is NullPointerException");
    }

    public boolean b(List<Long> list) {
        FrsModelController frsModelController = this.f57585d;
        if (frsModelController == null || frsModelController.q0()) {
            return false;
        }
        return this.f57583b.w(list);
    }

    public ArrayList<d.a.c.j.e.n> c(boolean z, boolean z2, ArrayList<d.a.c.j.e.n> arrayList, d.a.j0.d3.h0.f fVar, boolean z3) {
        return d(z, z2, arrayList, fVar, false, z3);
    }

    public ArrayList<d.a.c.j.e.n> d(boolean z, boolean z2, ArrayList<d.a.c.j.e.n> arrayList, d.a.j0.d3.h0.f fVar, boolean z3, boolean z4) {
        if (this.f57585d == null) {
            return arrayList;
        }
        boolean p0 = this.f57582a.b0().p0();
        if (this.f57585d.q0()) {
            return this.f57584c.u(z, p0, arrayList, z3, z4);
        }
        return this.f57583b.y(z, p0, z2, arrayList, fVar);
    }

    public ArrayList<d.a.c.j.e.n> e() {
        if (this.f57585d.q0()) {
            return this.f57584c.v();
        }
        return this.f57585d.S();
    }

    public FrsSmartLoadMoreModel f() {
        return this.f57584c;
    }

    public int g() {
        FrsModelController frsModelController = this.f57585d;
        if (frsModelController == null) {
            return 1;
        }
        if (frsModelController.q0()) {
            return this.f57584c.getPn();
        }
        return this.f57583b.getPn();
    }

    public int h() {
        FrsModelController frsModelController = this.f57585d;
        if (frsModelController == null) {
            return -1;
        }
        if (frsModelController.q0()) {
            return this.f57584c.w();
        }
        return this.f57583b.A();
    }

    public void i(String str, String str2, FrsViewData frsViewData) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921462, 0));
        if (this.f57585d == null || this.f57586e == null || frsViewData == null) {
            return;
        }
        this.f57582a.M = System.currentTimeMillis();
        if (this.f57585d.q0()) {
            if (this.f57584c.w() != 1 || this.f57585d.o0()) {
                return;
            }
            this.f57584c.setSortType(this.f57585d.W());
            this.f57584c.t();
            int pn = this.f57584c.getPn();
            this.f57584c.setPn(pn);
            this.f57585d.t0(pn + 1);
        } else if (this.f57585d.X() == 1) {
            if (this.f57583b.isLoading || this.f57585d.o0()) {
                return;
            }
            int pn2 = this.f57583b.getPn();
            if (this.f57583b.w(frsViewData.getThreadListIds())) {
                this.f57583b.x();
                this.f57583b.setSortType(this.f57585d.W());
                this.f57583b.I(d.a.c.e.m.b.f(str2, 0L), frsViewData.getThreadListIds(), str, pn2, frsViewData.isBrandForum, this.f57585d.Z() != null ? d.a.j0.s2.a.e(this.f57585d.Z().getThreadList(), false) : "");
            } else if (this.f57583b.A() == 1) {
                this.f57583b.x();
                this.f57583b.setPn(pn2);
                this.f57585d.t0(pn2 + 1);
                FrsLoadMoreModel frsLoadMoreModel = this.f57583b;
                frsLoadMoreModel.loadingDone = false;
                frsLoadMoreModel.loadIndex = 0;
            }
        } else if (this.f57585d.r0()) {
        } else {
            this.f57585d.s0();
        }
    }

    public void j(d.a.c.j.e.n nVar) {
        if (nVar == null) {
            return;
        }
        if (this.f57585d.q0()) {
            this.f57584c.C(nVar);
        } else {
            this.f57583b.G(nVar);
        }
    }

    public void k() {
        FrsModelController frsModelController = this.f57585d;
        if (frsModelController == null) {
            return;
        }
        if (frsModelController.q0()) {
            this.f57584c.D();
        } else {
            this.f57583b.J();
        }
    }

    public void l(d.a.j0.s0.a aVar) {
        this.f57583b.K(aVar);
        this.f57584c.G(aVar);
    }

    public void m(int i2) {
        FrsModelController frsModelController = this.f57585d;
        if (frsModelController == null) {
            return;
        }
        if (frsModelController.q0()) {
            this.f57584c.H(i2);
        } else {
            this.f57583b.M(i2);
        }
    }

    public void n(int i2) {
        FrsModelController frsModelController = this.f57585d;
        if (frsModelController == null) {
            return;
        }
        if (frsModelController.q0()) {
            this.f57584c.setPn(i2);
        } else {
            this.f57583b.setPn(i2);
        }
    }
}
