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
    public final FrsFragment f58465a;

    /* renamed from: b  reason: collision with root package name */
    public final FrsLoadMoreModel f58466b;

    /* renamed from: c  reason: collision with root package name */
    public final FrsSmartLoadMoreModel f58467c;

    /* renamed from: d  reason: collision with root package name */
    public final FrsModelController f58468d;

    /* renamed from: e  reason: collision with root package name */
    public final r f58469e;

    /* renamed from: f  reason: collision with root package name */
    public final b f58470f = new a();

    /* loaded from: classes4.dex */
    public class a implements b {
        public a() {
        }

        @Override // d.a.n0.r0.e2.c.b
        public void removeItem(int i2) {
            if (c.this.f58469e == null || c.this.f58469e.Z() == null) {
                return;
            }
            List<d.a.c.j.e.n> data = c.this.f58469e.Z().getData();
            if (ListUtils.isEmpty(data) || c.this.f58469e.Z().getAdapter() == null || ((d.a.c.j.e.n) ListUtils.remove(data, i2)) == null) {
                return;
            }
            c.this.f58469e.Z().getAdapter().notifyItemRemoved(i2);
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void removeItem(int i2);
    }

    public c(FrsFragment frsFragment, k kVar) {
        if (frsFragment != null) {
            this.f58465a = frsFragment;
            this.f58466b = new FrsLoadMoreModel(frsFragment, kVar);
            FrsSmartLoadMoreModel frsSmartLoadMoreModel = new FrsSmartLoadMoreModel(frsFragment, kVar);
            this.f58467c = frsSmartLoadMoreModel;
            frsSmartLoadMoreModel.I(this.f58470f);
            this.f58466b.N(this.f58470f);
            this.f58469e = frsFragment.y0();
            FrsModelController b0 = frsFragment.b0();
            this.f58468d = b0;
            this.f58467c.setSortType(b0.W());
            this.f58466b.setSortType(this.f58468d.W());
            return;
        }
        throw new NullPointerException("FrsFragment is NullPointerException");
    }

    public boolean b(List<Long> list) {
        FrsModelController frsModelController = this.f58468d;
        if (frsModelController == null || frsModelController.q0()) {
            return false;
        }
        return this.f58466b.w(list);
    }

    public ArrayList<d.a.c.j.e.n> c(boolean z, boolean z2, ArrayList<d.a.c.j.e.n> arrayList, d.a.n0.e3.h0.f fVar, boolean z3) {
        return d(z, z2, arrayList, fVar, false, z3);
    }

    public ArrayList<d.a.c.j.e.n> d(boolean z, boolean z2, ArrayList<d.a.c.j.e.n> arrayList, d.a.n0.e3.h0.f fVar, boolean z3, boolean z4) {
        if (this.f58468d == null) {
            return arrayList;
        }
        boolean p0 = this.f58465a.b0().p0();
        if (this.f58468d.q0()) {
            return this.f58467c.u(z, p0, arrayList, z3, z4);
        }
        return this.f58466b.y(z, p0, z2, arrayList, fVar);
    }

    public ArrayList<d.a.c.j.e.n> e() {
        if (this.f58468d.q0()) {
            return this.f58467c.v();
        }
        return this.f58468d.S();
    }

    public FrsSmartLoadMoreModel f() {
        return this.f58467c;
    }

    public int g() {
        FrsModelController frsModelController = this.f58468d;
        if (frsModelController == null) {
            return 1;
        }
        if (frsModelController.q0()) {
            return this.f58467c.getPn();
        }
        return this.f58466b.getPn();
    }

    public int h() {
        FrsModelController frsModelController = this.f58468d;
        if (frsModelController == null) {
            return -1;
        }
        if (frsModelController.q0()) {
            return this.f58467c.w();
        }
        return this.f58466b.A();
    }

    public void i(String str, String str2, FrsViewData frsViewData) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921462, 0));
        if (this.f58468d == null || this.f58469e == null || frsViewData == null) {
            return;
        }
        this.f58465a.M = System.currentTimeMillis();
        if (this.f58468d.q0()) {
            if (this.f58467c.w() != 1 || this.f58468d.o0()) {
                return;
            }
            this.f58467c.setSortType(this.f58468d.W());
            this.f58467c.t();
            int pn = this.f58467c.getPn();
            this.f58467c.setPn(pn);
            this.f58468d.t0(pn + 1);
        } else if (this.f58468d.X() == 1) {
            if (this.f58466b.isLoading || this.f58468d.o0()) {
                return;
            }
            int pn2 = this.f58466b.getPn();
            if (this.f58466b.w(frsViewData.getThreadListIds())) {
                this.f58466b.x();
                this.f58466b.setSortType(this.f58468d.W());
                this.f58466b.I(d.a.c.e.m.b.f(str2, 0L), frsViewData.getThreadListIds(), str, pn2, frsViewData.isBrandForum, this.f58468d.Z() != null ? d.a.n0.t2.a.e(this.f58468d.Z().getThreadList(), false) : "");
            } else if (this.f58466b.A() == 1) {
                this.f58466b.x();
                this.f58466b.setPn(pn2);
                this.f58468d.t0(pn2 + 1);
                FrsLoadMoreModel frsLoadMoreModel = this.f58466b;
                frsLoadMoreModel.loadingDone = false;
                frsLoadMoreModel.loadIndex = 0;
            }
        } else if (this.f58468d.r0()) {
        } else {
            this.f58468d.s0();
        }
    }

    public void j(d.a.c.j.e.n nVar) {
        if (nVar == null) {
            return;
        }
        if (this.f58468d.q0()) {
            this.f58467c.C(nVar);
        } else {
            this.f58466b.G(nVar);
        }
    }

    public void k() {
        FrsModelController frsModelController = this.f58468d;
        if (frsModelController == null) {
            return;
        }
        if (frsModelController.q0()) {
            this.f58467c.D();
        } else {
            this.f58466b.J();
        }
    }

    public void l(d.a.n0.t0.a aVar) {
        this.f58466b.K(aVar);
        this.f58467c.G(aVar);
    }

    public void m(int i2) {
        FrsModelController frsModelController = this.f58468d;
        if (frsModelController == null) {
            return;
        }
        if (frsModelController.q0()) {
            this.f58467c.H(i2);
        } else {
            this.f58466b.M(i2);
        }
    }

    public void n(int i2) {
        FrsModelController frsModelController = this.f58468d;
        if (frsModelController == null) {
            return;
        }
        if (frsModelController.q0()) {
            this.f58467c.setPn(i2);
        } else {
            this.f58466b.setPn(i2);
        }
    }
}
