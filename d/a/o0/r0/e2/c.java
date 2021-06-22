package d.a.o0.r0.e2;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.loadmore.FrsLoadMoreModel;
import com.baidu.tieba.frs.mc.FrsModelController;
import com.baidu.tieba.frs.smartsort.FrsSmartLoadMoreModel;
import com.baidu.tieba.tbadkCore.FrsViewData;
import d.a.o0.r0.r;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public final FrsFragment f62281a;

    /* renamed from: b  reason: collision with root package name */
    public final FrsLoadMoreModel f62282b;

    /* renamed from: c  reason: collision with root package name */
    public final FrsSmartLoadMoreModel f62283c;

    /* renamed from: d  reason: collision with root package name */
    public final FrsModelController f62284d;

    /* renamed from: e  reason: collision with root package name */
    public final r f62285e;

    /* renamed from: f  reason: collision with root package name */
    public final b f62286f = new a();

    /* loaded from: classes4.dex */
    public class a implements b {
        public a() {
        }

        @Override // d.a.o0.r0.e2.c.b
        public void removeItem(int i2) {
            if (c.this.f62285e == null || c.this.f62285e.Z() == null) {
                return;
            }
            List<d.a.c.k.e.n> data = c.this.f62285e.Z().getData();
            if (ListUtils.isEmpty(data) || c.this.f62285e.Z().getAdapter() == null || ((d.a.c.k.e.n) ListUtils.remove(data, i2)) == null) {
                return;
            }
            c.this.f62285e.Z().getAdapter().notifyItemRemoved(i2);
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void removeItem(int i2);
    }

    public c(FrsFragment frsFragment, k kVar) {
        if (frsFragment != null) {
            this.f62281a = frsFragment;
            this.f62282b = new FrsLoadMoreModel(frsFragment, kVar);
            FrsSmartLoadMoreModel frsSmartLoadMoreModel = new FrsSmartLoadMoreModel(frsFragment, kVar);
            this.f62283c = frsSmartLoadMoreModel;
            frsSmartLoadMoreModel.M(this.f62286f);
            this.f62282b.R(this.f62286f);
            this.f62285e = frsFragment.B0();
            FrsModelController e0 = frsFragment.e0();
            this.f62284d = e0;
            this.f62283c.setSortType(e0.a0());
            this.f62282b.setSortType(this.f62284d.a0());
            return;
        }
        throw new NullPointerException("FrsFragment is NullPointerException");
    }

    public boolean b(List<Long> list) {
        FrsModelController frsModelController = this.f62284d;
        if (frsModelController == null || frsModelController.u0()) {
            return false;
        }
        return this.f62282b.A(list);
    }

    public ArrayList<d.a.c.k.e.n> c(boolean z, boolean z2, ArrayList<d.a.c.k.e.n> arrayList, d.a.o0.e3.h0.f fVar, boolean z3) {
        return d(z, z2, arrayList, fVar, false, z3);
    }

    public ArrayList<d.a.c.k.e.n> d(boolean z, boolean z2, ArrayList<d.a.c.k.e.n> arrayList, d.a.o0.e3.h0.f fVar, boolean z3, boolean z4) {
        if (this.f62284d == null) {
            return arrayList;
        }
        boolean t0 = this.f62281a.e0().t0();
        if (this.f62284d.u0()) {
            return this.f62283c.y(z, t0, arrayList, z3, z4);
        }
        return this.f62282b.C(z, t0, z2, arrayList, fVar);
    }

    public ArrayList<d.a.c.k.e.n> e() {
        if (this.f62284d.u0()) {
            return this.f62283c.z();
        }
        return this.f62284d.W();
    }

    public FrsSmartLoadMoreModel f() {
        return this.f62283c;
    }

    public int g() {
        FrsModelController frsModelController = this.f62284d;
        if (frsModelController == null) {
            return 1;
        }
        if (frsModelController.u0()) {
            return this.f62283c.getPn();
        }
        return this.f62282b.getPn();
    }

    public int h() {
        FrsModelController frsModelController = this.f62284d;
        if (frsModelController == null) {
            return -1;
        }
        if (frsModelController.u0()) {
            return this.f62283c.A();
        }
        return this.f62282b.E();
    }

    public void i(String str, String str2, FrsViewData frsViewData) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921462, 0));
        if (this.f62284d == null || this.f62285e == null || frsViewData == null) {
            return;
        }
        this.f62281a.M = System.currentTimeMillis();
        if (this.f62284d.u0()) {
            if (this.f62283c.A() != 1 || this.f62284d.s0()) {
                return;
            }
            this.f62283c.setSortType(this.f62284d.a0());
            this.f62283c.x();
            int pn = this.f62283c.getPn();
            this.f62283c.setPn(pn);
            this.f62284d.x0(pn + 1);
        } else if (this.f62284d.b0() == 1) {
            if (this.f62282b.isLoading || this.f62284d.s0()) {
                return;
            }
            int pn2 = this.f62282b.getPn();
            if (this.f62282b.A(frsViewData.getThreadListIds())) {
                this.f62282b.B();
                this.f62282b.setSortType(this.f62284d.a0());
                this.f62282b.M(d.a.c.e.m.b.f(str2, 0L), frsViewData.getThreadListIds(), str, pn2, frsViewData.isBrandForum, this.f62284d.d0() != null ? d.a.o0.t2.a.e(this.f62284d.d0().getThreadList(), false) : "");
            } else if (this.f62282b.E() == 1) {
                this.f62282b.B();
                this.f62282b.setPn(pn2);
                this.f62284d.x0(pn2 + 1);
                FrsLoadMoreModel frsLoadMoreModel = this.f62282b;
                frsLoadMoreModel.loadingDone = false;
                frsLoadMoreModel.loadIndex = 0;
            }
        } else if (this.f62284d.v0()) {
        } else {
            this.f62284d.w0();
        }
    }

    public void j(d.a.c.k.e.n nVar) {
        if (nVar == null) {
            return;
        }
        if (this.f62284d.u0()) {
            this.f62283c.G(nVar);
        } else {
            this.f62282b.K(nVar);
        }
    }

    public void k() {
        FrsModelController frsModelController = this.f62284d;
        if (frsModelController == null) {
            return;
        }
        if (frsModelController.u0()) {
            this.f62283c.H();
        } else {
            this.f62282b.N();
        }
    }

    public void l(d.a.o0.t0.a aVar) {
        this.f62282b.O(aVar);
        this.f62283c.K(aVar);
    }

    public void m(int i2) {
        FrsModelController frsModelController = this.f62284d;
        if (frsModelController == null) {
            return;
        }
        if (frsModelController.u0()) {
            this.f62283c.L(i2);
        } else {
            this.f62282b.Q(i2);
        }
    }

    public void n(int i2) {
        FrsModelController frsModelController = this.f62284d;
        if (frsModelController == null) {
            return;
        }
        if (frsModelController.u0()) {
            this.f62283c.setPn(i2);
        } else {
            this.f62282b.setPn(i2);
        }
    }
}
