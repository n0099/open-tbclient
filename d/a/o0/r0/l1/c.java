package d.a.o0.r0.l1;

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
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.frs.commontab.FrsCommonTabFragment;
import com.baidu.tieba.frs.commontab.FrsCommonTabNetModel;
import com.baidu.tieba.frs.commontab.FrsCommonTabRequestData;
import com.baidu.tieba.frs.dynamic.FrsDynamicModel;
import com.baidu.tieba.frs.dynamic.FrsDynamicRequestData;
import com.baidu.tieba.tbadkCore.FrsViewData;
import d.a.c.e.p.l;
import d.a.c.k.e.n;
import d.a.n0.r.q.a2;
import d.a.n0.r.q.m0;
import d.a.n0.r.q.n0;
import d.a.n0.r.q.w0;
import d.a.n0.r.q.z1;
import d.a.o0.r0.t;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
import tbclient.App;
/* loaded from: classes4.dex */
public class c implements NetModel.k {

    /* renamed from: e  reason: collision with root package name */
    public FrsCommonTabFragment f62692e;

    /* renamed from: f  reason: collision with root package name */
    public d f62693f;

    /* renamed from: g  reason: collision with root package name */
    public FrsCommonTabRequestData f62694g;

    /* renamed from: h  reason: collision with root package name */
    public FrsCommonTabNetModel f62695h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f62696i;
    public FrsDynamicRequestData j;
    public FrsDynamicModel k;
    public boolean l;
    public HashSet<String> m = new HashSet<>();
    public int n = 1;
    public long o = -1;
    public int p;
    public String q;
    public String r;
    public d.a.o0.t0.a s;

    public c(FrsCommonTabFragment frsCommonTabFragment, int i2, int i3, String str, int i4) {
        if (frsCommonTabFragment == null) {
            return;
        }
        this.f62692e = frsCommonTabFragment;
        this.r = "FRS_GENERAL_TAB" + i3;
        if (i3 == 89) {
            this.f62696i = true;
            FrsDynamicRequestData frsDynamicRequestData = new FrsDynamicRequestData();
            this.j = frsDynamicRequestData;
            frsDynamicRequestData.forumId = i2;
            frsDynamicRequestData.scrH = l.i(TbadkCoreApplication.getInst());
            this.j.scrW = l.k(TbadkCoreApplication.getInst());
            this.j.scrDip = l.h(TbadkCoreApplication.getInst());
            FrsDynamicModel frsDynamicModel = new FrsDynamicModel(frsCommonTabFragment.getPageContext(), this.j);
            this.k = frsDynamicModel;
            frsDynamicModel.Z(this);
            this.k.setUniqueId(frsCommonTabFragment.getUniqueId());
            return;
        }
        this.f62696i = false;
        FrsCommonTabRequestData frsCommonTabRequestData = new FrsCommonTabRequestData();
        this.f62694g = frsCommonTabRequestData;
        frsCommonTabRequestData.fid = i2;
        frsCommonTabRequestData.tabId = i3;
        frsCommonTabRequestData.isDefaultNavTab = h(i3) ? 1 : 0;
        FrsCommonTabRequestData frsCommonTabRequestData2 = this.f62694g;
        frsCommonTabRequestData2.tabName = str;
        frsCommonTabRequestData2.isGeneralTab = i4;
        FrsCommonTabNetModel frsCommonTabNetModel = new FrsCommonTabNetModel(frsCommonTabFragment.getPageContext(), this.f62694g);
        this.f62695h = frsCommonTabNetModel;
        frsCommonTabNetModel.Z(this);
        this.f62695h.setUniqueId(frsCommonTabFragment.getUniqueId());
    }

    public void a(a2 a2Var) {
        d dVar;
        if (a2Var == null || (dVar = this.f62693f) == null || dVar.f62699g == null) {
            return;
        }
        ArrayList<n> arrayList = new ArrayList<>();
        arrayList.add(a2Var);
        ArrayList<n> s = s(arrayList);
        if (ListUtils.isEmpty(this.f62693f.f62699g)) {
            this.f62693f.f62699g.addAll(s);
        } else {
            if (this.f62693f.f62699g.size() == 1 && (this.f62693f.f62699g.get(0) instanceof t)) {
                this.f62693f.f62699g.remove(0);
            }
            this.f62693f.f62699g.addAll(0, s);
        }
        this.f62692e.X0(this.f62693f);
    }

    public final void b(List<n> list) {
        JSONObject b2;
        if (d.a.o0.k1.o.k.a.e(list)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (n nVar : list) {
            if ((nVar instanceof a2) && (b2 = d.a.o0.t2.i0.b.b(((a2) nVar).V0())) != null) {
                arrayList.add(b2);
            }
        }
        d.a.o0.t2.i0.b.f().h(this.r, arrayList);
    }

    public final String c() {
        int b2 = this.l ? 0 : d.a.o0.t2.a.b(this.f62693f.f62699g);
        String d2 = this.l ? "" : d.a.o0.t2.i0.b.f().d(this.r);
        d dVar = this.f62693f;
        String e2 = d.a.o0.t2.a.e(dVar == null ? null : dVar.f62699g, this.l);
        AdExtParam.a b3 = AdExtParam.a.b();
        b3.g(b2);
        b3.e(e2);
        b3.c(d2);
        b3.f(this.f62692e.j);
        return b3.a();
    }

    public int d() {
        return this.n;
    }

    public d e() {
        return this.f62693f;
    }

    public final void f(List<App> list, List<n> list2) {
        b(list2);
        d.a.o0.t2.a.j(d.a.o0.t2.a.g(list, "FRS_GENERAL_TAB"), list2, 0);
        d.a.o0.t2.a.a(list2, this.n, "FRS_GENERAL_TAB");
    }

    public boolean g() {
        d dVar = this.f62693f;
        return (dVar == null || ListUtils.isEmpty(dVar.f62699g)) ? false : true;
    }

    public final boolean h(int i2) {
        FrsViewData frsViewData;
        FrsCommonTabFragment frsCommonTabFragment = this.f62692e;
        return (frsCommonTabFragment == null || (frsViewData = frsCommonTabFragment.f15414h) == null || frsViewData.mHeadLineDefaultNavTabId != i2) ? false : true;
    }

    public boolean i() {
        return this.l;
    }

    public void j(int i2) {
        this.l = false;
        if (!this.f62696i) {
            if (this.f62695h.Q()) {
                return;
            }
            int i3 = this.n + 1;
            this.n = i3;
            FrsCommonTabRequestData frsCommonTabRequestData = this.f62694g;
            frsCommonTabRequestData.pn = i3;
            frsCommonTabRequestData.sortType = i2;
            frsCommonTabRequestData.lastThreadId = -1L;
            frsCommonTabRequestData.adExtParams = c();
            this.f62695h.R();
        } else if (this.k.Q()) {
        } else {
            if (TbImageHelper.getInstance().isShowBigImage()) {
                this.j.qType = 2;
            } else {
                this.j.qType = 1;
            }
            this.k.R();
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.m
    public void k(MvcSocketResponsedMessage mvcSocketResponsedMessage, MvcSocketMessage mvcSocketMessage, MvcNetMessage mvcNetMessage) {
        if (mvcSocketResponsedMessage == null) {
            return;
        }
        d dVar = null;
        if (!mvcSocketResponsedMessage.hasError()) {
            if (mvcSocketResponsedMessage.getData() instanceof d) {
                dVar = (d) mvcSocketResponsedMessage.getData();
            } else if (mvcSocketResponsedMessage.getData() instanceof d.a.o0.r0.m1.a) {
                d.a.o0.r0.m1.a aVar = (d.a.o0.r0.m1.a) mvcSocketResponsedMessage.getData();
                d dVar2 = new d();
                ArrayList<n> arrayList = aVar.f62710e;
                dVar2.f62699g = arrayList;
                dVar2.f62697e = aVar.f62712g;
                dVar2.f62698f = aVar.f62711f;
                if (!ListUtils.isEmpty(arrayList)) {
                    ArrayList<n> arrayList2 = dVar2.f62699g;
                    n nVar = (n) ListUtils.getItem(arrayList2, arrayList2.size() - 1);
                    if (nVar instanceof a2) {
                        this.j.lastThreadId = d.a.c.e.m.b.f(((a2) nVar).o0(), 0L);
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
                this.f62692e.onServerError(errorData);
            }
        }
    }

    public void l(String str) {
        d dVar = this.f62693f;
        if (dVar == null || d.a.o0.k1.o.k.a.e(dVar.f62699g)) {
            return;
        }
        d.a.o0.t2.a.d(str, this.f62693f.f62699g);
        this.f62692e.X0(this.f62693f);
    }

    public final boolean m(d dVar) {
        if (dVar == null) {
            return false;
        }
        if (this.l) {
            this.m.clear();
            Iterator<n> it = dVar.f62699g.iterator();
            while (it.hasNext()) {
                n next = it.next();
                if (next instanceof a2) {
                    String z1 = ((a2) next).z1();
                    if (!this.m.contains(z1)) {
                        this.m.add(z1);
                    }
                }
            }
            if (d.a.o0.t0.a.d()) {
                d.a.o0.t0.a aVar = this.s;
                if (aVar != null) {
                    aVar.b(dVar.f62699g, this.l, this.f62692e.G());
                }
            } else {
                f(dVar.o, dVar.f62699g);
            }
            this.f62693f = dVar;
            dVar.f62699g = s(dVar.f62699g);
        } else {
            d dVar2 = this.f62693f;
            dVar2.f62697e = dVar.f62697e;
            dVar2.f62698f.putAll(dVar.f62698f);
            ArrayList<n> arrayList = new ArrayList<>();
            Iterator<n> it2 = dVar.f62699g.iterator();
            while (it2.hasNext()) {
                n next2 = it2.next();
                if (next2 instanceof a2) {
                    a2 a2Var = (a2) next2;
                    String z12 = a2Var.z1();
                    if (!this.m.contains(z12)) {
                        a2Var.F1 = this.f62692e.p;
                        arrayList.add(next2);
                        this.m.add(z12);
                    }
                }
            }
            if (d.a.o0.t0.a.d()) {
                d.a.o0.t0.a aVar2 = this.s;
                if (aVar2 != null) {
                    aVar2.b(arrayList, this.l, this.f62692e.G());
                }
            } else {
                f(dVar.o, arrayList);
            }
            this.f62693f.f62699g.addAll(s(arrayList));
        }
        this.f62692e.X0(this.f62693f);
        return true;
    }

    public void n(int i2) {
        this.l = true;
        if (!this.f62696i) {
            if (this.f62695h.Q()) {
                return;
            }
            this.n = 1;
            FrsCommonTabRequestData frsCommonTabRequestData = this.f62694g;
            frsCommonTabRequestData.pn = 1;
            frsCommonTabRequestData.sortType = i2;
            long j = this.o;
            if (j >= 0) {
                frsCommonTabRequestData.lastThreadId = j;
            }
            this.f62694g.adExtParams = c();
            this.f62695h.R();
        } else if (this.k.Q()) {
        } else {
            if (TbImageHelper.getInstance().isShowBigImage()) {
                this.j.qType = 2;
            } else {
                this.j.qType = 1;
            }
            this.j.lastThreadId = 0L;
            this.k.R();
        }
    }

    public void o(d.a.o0.t0.a aVar) {
        this.s = aVar;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.l
    public void p(MvcHttpResponsedMessage mvcHttpResponsedMessage, MvcHttpMessage mvcHttpMessage, MvcNetMessage mvcNetMessage) {
        if (mvcHttpResponsedMessage == null) {
            return;
        }
        d dVar = null;
        if (!mvcHttpResponsedMessage.hasError()) {
            if (mvcHttpResponsedMessage.getData() instanceof d) {
                dVar = (d) mvcHttpResponsedMessage.getData();
            } else if (mvcHttpResponsedMessage.getData() instanceof d.a.o0.r0.m1.a) {
                d.a.o0.r0.m1.a aVar = (d.a.o0.r0.m1.a) mvcHttpResponsedMessage.getData();
                d dVar2 = new d();
                ArrayList<n> arrayList = aVar.f62710e;
                dVar2.f62699g = arrayList;
                dVar2.f62697e = aVar.f62712g;
                dVar2.f62698f = aVar.f62711f;
                if (!ListUtils.isEmpty(arrayList)) {
                    ArrayList<n> arrayList2 = dVar2.f62699g;
                    n nVar = (n) ListUtils.getItem(arrayList2, arrayList2.size() - 1);
                    if (nVar instanceof a2) {
                        this.j.lastThreadId = d.a.c.e.m.b.f(((a2) nVar).o0(), 0L);
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
                this.f62692e.onServerError(errorData);
            }
        }
    }

    public void q(long j) {
        this.o = j;
    }

    public void r(int i2) {
        FrsCommonTabRequestData frsCommonTabRequestData = this.f62694g;
        if (frsCommonTabRequestData != null) {
            frsCommonTabRequestData.tabType = i2;
        }
    }

    public final ArrayList<n> s(ArrayList<n> arrayList) {
        boolean z = this.f62692e.l == 16;
        ArrayList<n> arrayList2 = new ArrayList<>();
        Iterator<n> it = arrayList.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            n next = it.next();
            if (next instanceof m0) {
                ((m0) next).setPosition(i2);
                arrayList2.add(next);
            } else if (next instanceof n0) {
                ((n0) next).position = i2;
                arrayList2.add(next);
            } else if (next instanceof a2) {
                a2 a2Var = (a2) next;
                d.a.n0.b.f.a.e(a2Var);
                int[] p0 = a2Var.p0();
                if (a2Var.getType() == a2.M2 && !a2Var.z2()) {
                    z1 z1Var = new z1();
                    z1Var.w = a2Var;
                    z1Var.position = i2;
                    z1Var.f53980e = true;
                    z1Var.setSupportType(BaseCardInfo.SupportType.TOP);
                    arrayList2.add(z1Var);
                    z1 z1Var2 = new z1();
                    z1Var2.w = a2Var;
                    z1Var2.position = i2;
                    if (a2Var.S1()) {
                        z1Var2.j = true;
                    } else if (a2Var.a3() == 1) {
                        z1Var2.f53983h = true;
                        z1Var2.x = p0[0];
                        z1Var2.y = p0[1];
                    } else if (a2Var.a3() >= 2) {
                        z1Var2.f53984i = true;
                    } else {
                        z1Var2.f53981f = true;
                    }
                    z1Var2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                    arrayList2.add(z1Var2);
                    if (a2Var.P0() != null) {
                        z1 z1Var3 = new z1();
                        z1Var3.s = true;
                        z1Var3.w = a2Var;
                        z1Var3.position = i2;
                        z1Var3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(z1Var3);
                    }
                    if (a2Var.l1() != null) {
                        z1 z1Var4 = new z1();
                        z1Var4.p = true;
                        z1Var4.w = a2Var;
                        z1Var4.position = i2;
                        z1Var4.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(z1Var4);
                    }
                    if (!ListUtils.isEmpty(a2Var.H0()) || !ListUtils.isEmpty(a2Var.l0())) {
                        z1 z1Var5 = new z1();
                        if (ListUtils.getCount(a2Var.H0()) + ListUtils.getCount(a2Var.l0()) == 1) {
                            z1Var5.t = true;
                        } else if (ListUtils.getCount(a2Var.H0()) + ListUtils.getCount(a2Var.l0()) > 1) {
                            z1Var5.u = true;
                        }
                        z1Var5.w = a2Var;
                        z1Var5.position = i2;
                        z1Var5.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(z1Var5);
                    }
                    if (a2Var.C1() != null) {
                        z1 z1Var6 = new z1();
                        z1Var6.l = true;
                        z1Var6.w = a2Var;
                        z1Var6.position = i2;
                        z1Var6.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(z1Var6);
                    }
                    if (!z && a2Var.z0() != null && !a2Var.G2()) {
                        z1 z1Var7 = new z1();
                        z1Var7.r = true;
                        z1Var7.w = a2Var;
                        z1Var7.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(z1Var7);
                    }
                    z1 z1Var8 = new z1();
                    z1Var8.k = true;
                    z1Var8.w = a2Var;
                    z1Var8.position = i2;
                    z1Var8.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                    arrayList2.add(z1Var8);
                } else if ((a2Var.getType() == a2.j3 || a2Var.getType() == a2.C3) && !a2Var.z2()) {
                    z1 z1Var9 = new z1();
                    z1Var9.w = a2Var;
                    z1Var9.position = i2;
                    z1Var9.f53980e = true;
                    z1Var9.setSupportType(BaseCardInfo.SupportType.TOP);
                    arrayList2.add(z1Var9);
                    z1 z1Var10 = new z1();
                    z1Var10.w = a2Var;
                    z1Var10.position = i2;
                    if (a2Var instanceof w0) {
                        z1Var10.n = true;
                    } else {
                        z1Var10.m = true;
                    }
                    z1Var10.setSupportType(BaseCardInfo.SupportType.CONTENT);
                    arrayList2.add(z1Var10);
                    if (a2Var.P0() != null) {
                        z1 z1Var11 = new z1();
                        z1Var11.s = true;
                        z1Var11.w = a2Var;
                        z1Var11.position = i2;
                        z1Var11.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(z1Var11);
                    }
                    if (a2Var.l1() != null) {
                        z1 z1Var12 = new z1();
                        z1Var12.p = true;
                        z1Var12.w = a2Var;
                        z1Var12.position = i2;
                        z1Var12.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(z1Var12);
                    }
                    if (a2Var.C1() != null) {
                        z1 z1Var13 = new z1();
                        z1Var13.l = true;
                        z1Var13.w = a2Var;
                        z1Var13.position = i2;
                        z1Var13.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(z1Var13);
                    }
                    if (!z && a2Var.z0() != null && !a2Var.G2()) {
                        z1 z1Var14 = new z1();
                        z1Var14.r = true;
                        z1Var14.w = a2Var;
                        z1Var14.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(z1Var14);
                    }
                    z1 z1Var15 = new z1();
                    z1Var15.k = true;
                    z1Var15.w = a2Var;
                    z1Var15.position = i2;
                    z1Var15.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                    arrayList2.add(z1Var15);
                } else if (a2Var.x1() != null && !a2Var.j2() && a2Var.d2()) {
                    z1 z1Var16 = new z1();
                    z1Var16.w = a2Var;
                    z1Var16.position = i2;
                    z1Var16.f53980e = true;
                    z1Var16.setSupportType(BaseCardInfo.SupportType.TOP);
                    arrayList2.add(z1Var16);
                    z1 z1Var17 = new z1();
                    z1Var17.w = a2Var;
                    z1Var17.position = i2;
                    z1Var17.o = true;
                    z1Var17.setSupportType(BaseCardInfo.SupportType.CONTENT);
                    arrayList2.add(z1Var17);
                    if (a2Var.P0() != null) {
                        z1 z1Var18 = new z1();
                        z1Var18.s = true;
                        z1Var18.w = a2Var;
                        z1Var18.position = i2;
                        z1Var18.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(z1Var18);
                    }
                    if (a2Var.l1() != null) {
                        z1 z1Var19 = new z1();
                        z1Var19.p = true;
                        z1Var19.w = a2Var;
                        z1Var19.position = i2;
                        z1Var19.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(z1Var19);
                    }
                    if (a2Var.C1() != null) {
                        z1 z1Var20 = new z1();
                        z1Var20.l = true;
                        z1Var20.w = a2Var;
                        z1Var20.position = i2;
                        z1Var20.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(z1Var20);
                    }
                    if (!z && a2Var.z0() != null && !a2Var.G2()) {
                        z1 z1Var21 = new z1();
                        z1Var21.r = true;
                        z1Var21.w = a2Var;
                        z1Var21.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(z1Var21);
                    }
                    z1 z1Var22 = new z1();
                    z1Var22.k = true;
                    z1Var22.w = a2Var;
                    z1Var22.position = i2;
                    z1Var22.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                    arrayList2.add(z1Var22);
                } else if (a2Var.getType() == a2.b3 && a2Var.R1()) {
                    a2Var.position = i2;
                    arrayList2.add(a2Var);
                } else {
                    z1 z1Var23 = new z1();
                    z1Var23.w = a2Var;
                    z1Var23.position = i2;
                    arrayList2.add(z1Var23);
                }
                i2++;
                a2Var.setSupportType(BaseCardInfo.SupportType.TOP);
            } else {
                arrayList2.add(next);
            }
            i2++;
        }
        d.a.n0.b.f.a.d(arrayList2);
        return arrayList2;
    }
}
