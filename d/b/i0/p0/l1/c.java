package d.b.i0.p0.l1;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.TbImageHelper;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.model.NetModel;
import com.baidu.tbadk.util.AdExtParam;
import com.baidu.tieba.frs.commontab.FrsCommonTabFragment;
import com.baidu.tieba.frs.commontab.FrsCommonTabNetModel;
import com.baidu.tieba.frs.commontab.FrsCommonTabRequestData;
import com.baidu.tieba.frs.dynamic.FrsDynamicModel;
import com.baidu.tieba.frs.dynamic.FrsDynamicRequestData;
import com.baidu.tieba.tbadkCore.FrsViewData;
import d.b.b.e.p.l;
import d.b.b.j.e.n;
import d.b.h0.r.q.a2;
import d.b.i0.p0.t;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
import tbclient.App;
/* loaded from: classes4.dex */
public class c implements NetModel.k {

    /* renamed from: e  reason: collision with root package name */
    public FrsCommonTabFragment f57799e;

    /* renamed from: f  reason: collision with root package name */
    public d f57800f;

    /* renamed from: g  reason: collision with root package name */
    public FrsCommonTabRequestData f57801g;

    /* renamed from: h  reason: collision with root package name */
    public FrsCommonTabNetModel f57802h;
    public boolean i;
    public FrsDynamicRequestData j;
    public FrsDynamicModel k;
    public boolean l;
    public HashSet<String> m = new HashSet<>();
    public int n = 1;
    public long o = -1;
    public int p;
    public String q;
    public String r;
    public d.b.i0.r0.a s;

    public c(FrsCommonTabFragment frsCommonTabFragment, int i, int i2, String str, int i3) {
        if (frsCommonTabFragment == null) {
            return;
        }
        this.f57799e = frsCommonTabFragment;
        this.r = "FRS_GENERAL_TAB" + i2;
        if (i2 == 89) {
            this.i = true;
            FrsDynamicRequestData frsDynamicRequestData = new FrsDynamicRequestData();
            this.j = frsDynamicRequestData;
            frsDynamicRequestData.forumId = i;
            frsDynamicRequestData.scrH = l.i(TbadkCoreApplication.getInst());
            this.j.scrW = l.k(TbadkCoreApplication.getInst());
            this.j.scrDip = l.h(TbadkCoreApplication.getInst());
            FrsDynamicModel frsDynamicModel = new FrsDynamicModel(frsCommonTabFragment.getPageContext(), this.j);
            this.k = frsDynamicModel;
            frsDynamicModel.V(this);
            this.k.setUniqueId(frsCommonTabFragment.getUniqueId());
            return;
        }
        this.i = false;
        FrsCommonTabRequestData frsCommonTabRequestData = new FrsCommonTabRequestData();
        this.f57801g = frsCommonTabRequestData;
        frsCommonTabRequestData.fid = i;
        frsCommonTabRequestData.tabId = i2;
        frsCommonTabRequestData.isDefaultNavTab = i(i2) ? 1 : 0;
        FrsCommonTabRequestData frsCommonTabRequestData2 = this.f57801g;
        frsCommonTabRequestData2.tabName = str;
        frsCommonTabRequestData2.isGeneralTab = i3;
        FrsCommonTabNetModel frsCommonTabNetModel = new FrsCommonTabNetModel(frsCommonTabFragment.getPageContext(), this.f57801g);
        this.f57802h = frsCommonTabNetModel;
        frsCommonTabNetModel.V(this);
        this.f57802h.setUniqueId(frsCommonTabFragment.getUniqueId());
    }

    public void a(a2 a2Var) {
        d dVar;
        ArrayList<n> arrayList;
        if (a2Var == null || (dVar = this.f57800f) == null || (arrayList = dVar.f57805g) == null) {
            return;
        }
        if (ListUtils.isEmpty(arrayList)) {
            this.f57800f.f57805g.add(a2Var);
        } else {
            if (this.f57800f.f57805g.size() == 1 && (this.f57800f.f57805g.get(0) instanceof t)) {
                this.f57800f.f57805g.remove(0);
            }
            this.f57800f.f57805g.add(0, a2Var);
        }
        this.f57799e.V0(this.f57800f);
    }

    public final void b(List<n> list) {
        JSONObject b2;
        if (d.b.i0.i1.o.k.a.e(list)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (n nVar : list) {
            if ((nVar instanceof a2) && (b2 = d.b.i0.r2.b0.b.b(((a2) nVar).T0())) != null) {
                arrayList.add(b2);
            }
        }
        d.b.i0.r2.b0.b.f().h(this.r, arrayList);
    }

    public final String c() {
        int b2 = this.l ? 0 : d.b.i0.r2.a.b(this.f57800f.f57805g);
        String d2 = this.l ? "" : d.b.i0.r2.b0.b.f().d(this.r);
        d dVar = this.f57800f;
        String e2 = d.b.i0.r2.a.e(dVar == null ? null : dVar.f57805g, this.l);
        AdExtParam.a b3 = AdExtParam.a.b();
        b3.g(b2);
        b3.e(e2);
        b3.c(d2);
        b3.f(this.f57799e.j);
        return b3.a();
    }

    public int d() {
        return this.n;
    }

    public d e() {
        return this.f57800f;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.l
    public void f(MvcHttpResponsedMessage mvcHttpResponsedMessage, MvcHttpMessage mvcHttpMessage, MvcNetMessage mvcNetMessage) {
        if (mvcHttpResponsedMessage == null) {
            return;
        }
        d dVar = null;
        if (!mvcHttpResponsedMessage.hasError()) {
            if (mvcHttpResponsedMessage.getData() instanceof d) {
                dVar = (d) mvcHttpResponsedMessage.getData();
            } else if (mvcHttpResponsedMessage.getData() instanceof d.b.i0.p0.m1.a) {
                d.b.i0.p0.m1.a aVar = (d.b.i0.p0.m1.a) mvcHttpResponsedMessage.getData();
                d dVar2 = new d();
                ArrayList<n> arrayList = aVar.f57900e;
                dVar2.f57805g = arrayList;
                dVar2.f57803e = aVar.f57902g;
                dVar2.f57804f = aVar.f57901f;
                if (!ListUtils.isEmpty(arrayList)) {
                    ArrayList<n> arrayList2 = dVar2.f57805g;
                    n nVar = (n) ListUtils.getItem(arrayList2, arrayList2.size() - 1);
                    if (nVar instanceof a2) {
                        this.j.lastThreadId = d.b.b.e.m.b.f(((a2) nVar).o0(), 0L);
                    }
                }
                dVar = dVar2;
            }
        }
        if (dVar == null || !m(dVar)) {
            this.p = mvcHttpResponsedMessage.getError();
            this.q = mvcHttpResponsedMessage.getErrorString();
            ErrorData errorData = new ErrorData();
            errorData.setError_code(this.p);
            errorData.setError_msg(this.q);
            if (this.p != 0) {
                this.f57799e.onServerError(errorData);
            }
        }
    }

    public final void g(List<App> list, List<n> list2) {
        b(list2);
        d.b.i0.r2.a.j(d.b.i0.r2.a.g(list, "FRS_GENERAL_TAB"), list2, 0);
        d.b.i0.r2.a.a(list2, this.n, "FRS_GENERAL_TAB");
    }

    public boolean h() {
        d dVar = this.f57800f;
        return (dVar == null || ListUtils.isEmpty(dVar.f57805g)) ? false : true;
    }

    public final boolean i(int i) {
        FrsViewData frsViewData;
        FrsCommonTabFragment frsCommonTabFragment = this.f57799e;
        return (frsCommonTabFragment == null || (frsViewData = frsCommonTabFragment.f16197h) == null || frsViewData.mHeadLineDefaultNavTabId != i) ? false : true;
    }

    public boolean j() {
        return this.l;
    }

    public void k(int i) {
        this.l = false;
        if (!this.i) {
            if (this.f57802h.M()) {
                return;
            }
            int i2 = this.n + 1;
            this.n = i2;
            FrsCommonTabRequestData frsCommonTabRequestData = this.f57801g;
            frsCommonTabRequestData.pn = i2;
            frsCommonTabRequestData.sortType = i;
            frsCommonTabRequestData.lastThreadId = -1L;
            frsCommonTabRequestData.adExtParams = c();
            this.f57802h.N();
        } else if (this.k.M()) {
        } else {
            if (TbImageHelper.getInstance().isShowBigImage()) {
                this.j.qType = 2;
            } else {
                this.j.qType = 1;
            }
            this.k.N();
        }
    }

    public void l(String str) {
        d dVar = this.f57800f;
        if (dVar == null || d.b.i0.i1.o.k.a.e(dVar.f57805g)) {
            return;
        }
        d.b.i0.r2.a.d(str, this.f57800f.f57805g);
        this.f57799e.V0(this.f57800f);
    }

    public final boolean m(d dVar) {
        if (dVar == null) {
            return false;
        }
        if (this.l) {
            this.f57800f = dVar;
            this.m.clear();
            Iterator<n> it = dVar.f57805g.iterator();
            while (it.hasNext()) {
                n next = it.next();
                if (next instanceof a2) {
                    String w1 = ((a2) next).w1();
                    if (!this.m.contains(w1)) {
                        this.m.add(w1);
                    }
                }
            }
            if (d.b.i0.r0.a.d()) {
                d.b.i0.r0.a aVar = this.s;
                if (aVar != null) {
                    aVar.b(this.f57800f.f57805g, this.l);
                }
            } else {
                g(dVar.o, this.f57800f.f57805g);
            }
        } else {
            d dVar2 = this.f57800f;
            dVar2.f57803e = dVar.f57803e;
            dVar2.f57804f.putAll(dVar.f57804f);
            ArrayList arrayList = new ArrayList();
            Iterator<n> it2 = dVar.f57805g.iterator();
            while (it2.hasNext()) {
                n next2 = it2.next();
                if (next2 instanceof a2) {
                    a2 a2Var = (a2) next2;
                    String w12 = a2Var.w1();
                    if (!this.m.contains(w12)) {
                        a2Var.D1 = this.f57799e.p;
                        arrayList.add(next2);
                        this.m.add(w12);
                    }
                }
            }
            if (d.b.i0.r0.a.d()) {
                d.b.i0.r0.a aVar2 = this.s;
                if (aVar2 != null) {
                    aVar2.b(arrayList, this.l);
                }
            } else {
                g(dVar.o, arrayList);
            }
            this.f57800f.f57805g.addAll(arrayList);
        }
        this.f57799e.V0(this.f57800f);
        return true;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.m
    public void n(MvcSocketResponsedMessage mvcSocketResponsedMessage, MvcSocketMessage mvcSocketMessage, MvcNetMessage mvcNetMessage) {
        if (mvcSocketResponsedMessage == null) {
            return;
        }
        d dVar = null;
        if (!mvcSocketResponsedMessage.hasError()) {
            if (mvcSocketResponsedMessage.getData() instanceof d) {
                dVar = (d) mvcSocketResponsedMessage.getData();
            } else if (mvcSocketResponsedMessage.getData() instanceof d.b.i0.p0.m1.a) {
                d.b.i0.p0.m1.a aVar = (d.b.i0.p0.m1.a) mvcSocketResponsedMessage.getData();
                d dVar2 = new d();
                ArrayList<n> arrayList = aVar.f57900e;
                dVar2.f57805g = arrayList;
                dVar2.f57803e = aVar.f57902g;
                dVar2.f57804f = aVar.f57901f;
                if (!ListUtils.isEmpty(arrayList)) {
                    ArrayList<n> arrayList2 = dVar2.f57805g;
                    n nVar = (n) ListUtils.getItem(arrayList2, arrayList2.size() - 1);
                    if (nVar instanceof a2) {
                        this.j.lastThreadId = d.b.b.e.m.b.f(((a2) nVar).o0(), 0L);
                    }
                }
                dVar = dVar2;
            }
        }
        if (dVar == null || !m(dVar)) {
            this.p = mvcSocketResponsedMessage.getError();
            this.q = mvcSocketResponsedMessage.getErrorString();
            ErrorData errorData = new ErrorData();
            errorData.setError_code(this.p);
            errorData.setError_msg(this.q);
            if (this.p != 0) {
                this.f57799e.onServerError(errorData);
            }
        }
    }

    public void o(int i) {
        this.l = true;
        if (!this.i) {
            if (this.f57802h.M()) {
                return;
            }
            this.n = 1;
            FrsCommonTabRequestData frsCommonTabRequestData = this.f57801g;
            frsCommonTabRequestData.pn = 1;
            frsCommonTabRequestData.sortType = i;
            long j = this.o;
            if (j >= 0) {
                frsCommonTabRequestData.lastThreadId = j;
            }
            this.f57801g.adExtParams = c();
            this.f57802h.N();
        } else if (this.k.M()) {
        } else {
            if (TbImageHelper.getInstance().isShowBigImage()) {
                this.j.qType = 2;
            } else {
                this.j.qType = 1;
            }
            this.j.lastThreadId = 0L;
            this.k.N();
        }
    }

    public void p(d.b.i0.r0.a aVar) {
        this.s = aVar;
    }

    public void q(long j) {
        this.o = j;
    }

    public void r(int i) {
        FrsCommonTabRequestData frsCommonTabRequestData = this.f57801g;
        if (frsCommonTabRequestData != null) {
            frsCommonTabRequestData.tabType = i;
        }
    }
}
