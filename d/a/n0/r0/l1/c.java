package d.a.n0.r0.l1;

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
import d.a.c.j.e.n;
import d.a.m0.r.q.a2;
import d.a.m0.r.q.m0;
import d.a.m0.r.q.n0;
import d.a.m0.r.q.w0;
import d.a.m0.r.q.z1;
import d.a.n0.r0.t;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
import tbclient.App;
/* loaded from: classes4.dex */
public class c implements NetModel.k {

    /* renamed from: e  reason: collision with root package name */
    public FrsCommonTabFragment f58876e;

    /* renamed from: f  reason: collision with root package name */
    public d f58877f;

    /* renamed from: g  reason: collision with root package name */
    public FrsCommonTabRequestData f58878g;

    /* renamed from: h  reason: collision with root package name */
    public FrsCommonTabNetModel f58879h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f58880i;
    public FrsDynamicRequestData j;
    public FrsDynamicModel k;
    public boolean l;
    public HashSet<String> m = new HashSet<>();
    public int n = 1;
    public long o = -1;
    public int p;
    public String q;
    public String r;
    public d.a.n0.t0.a s;

    public c(FrsCommonTabFragment frsCommonTabFragment, int i2, int i3, String str, int i4) {
        if (frsCommonTabFragment == null) {
            return;
        }
        this.f58876e = frsCommonTabFragment;
        this.r = "FRS_GENERAL_TAB" + i3;
        if (i3 == 89) {
            this.f58880i = true;
            FrsDynamicRequestData frsDynamicRequestData = new FrsDynamicRequestData();
            this.j = frsDynamicRequestData;
            frsDynamicRequestData.forumId = i2;
            frsDynamicRequestData.scrH = l.i(TbadkCoreApplication.getInst());
            this.j.scrW = l.k(TbadkCoreApplication.getInst());
            this.j.scrDip = l.h(TbadkCoreApplication.getInst());
            FrsDynamicModel frsDynamicModel = new FrsDynamicModel(frsCommonTabFragment.getPageContext(), this.j);
            this.k = frsDynamicModel;
            frsDynamicModel.V(this);
            this.k.setUniqueId(frsCommonTabFragment.getUniqueId());
            return;
        }
        this.f58880i = false;
        FrsCommonTabRequestData frsCommonTabRequestData = new FrsCommonTabRequestData();
        this.f58878g = frsCommonTabRequestData;
        frsCommonTabRequestData.fid = i2;
        frsCommonTabRequestData.tabId = i3;
        frsCommonTabRequestData.isDefaultNavTab = i(i3) ? 1 : 0;
        FrsCommonTabRequestData frsCommonTabRequestData2 = this.f58878g;
        frsCommonTabRequestData2.tabName = str;
        frsCommonTabRequestData2.isGeneralTab = i4;
        FrsCommonTabNetModel frsCommonTabNetModel = new FrsCommonTabNetModel(frsCommonTabFragment.getPageContext(), this.f58878g);
        this.f58879h = frsCommonTabNetModel;
        frsCommonTabNetModel.V(this);
        this.f58879h.setUniqueId(frsCommonTabFragment.getUniqueId());
    }

    public void a(a2 a2Var) {
        d dVar;
        if (a2Var == null || (dVar = this.f58877f) == null || dVar.f58883g == null) {
            return;
        }
        ArrayList<n> arrayList = new ArrayList<>();
        arrayList.add(a2Var);
        ArrayList<n> s = s(arrayList);
        if (ListUtils.isEmpty(this.f58877f.f58883g)) {
            this.f58877f.f58883g.addAll(s);
        } else {
            if (this.f58877f.f58883g.size() == 1 && (this.f58877f.f58883g.get(0) instanceof t)) {
                this.f58877f.f58883g.remove(0);
            }
            this.f58877f.f58883g.addAll(0, s);
        }
        this.f58876e.U0(this.f58877f);
    }

    public final void b(List<n> list) {
        JSONObject b2;
        if (d.a.n0.k1.o.k.a.e(list)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (n nVar : list) {
            if ((nVar instanceof a2) && (b2 = d.a.n0.t2.i0.b.b(((a2) nVar).U0())) != null) {
                arrayList.add(b2);
            }
        }
        d.a.n0.t2.i0.b.f().h(this.r, arrayList);
    }

    public final String c() {
        int b2 = this.l ? 0 : d.a.n0.t2.a.b(this.f58877f.f58883g);
        String d2 = this.l ? "" : d.a.n0.t2.i0.b.f().d(this.r);
        d dVar = this.f58877f;
        String e2 = d.a.n0.t2.a.e(dVar == null ? null : dVar.f58883g, this.l);
        AdExtParam.a b3 = AdExtParam.a.b();
        b3.g(b2);
        b3.e(e2);
        b3.c(d2);
        b3.f(this.f58876e.j);
        return b3.a();
    }

    public int d() {
        return this.n;
    }

    public d e() {
        return this.f58877f;
    }

    public final void f(List<App> list, List<n> list2) {
        b(list2);
        d.a.n0.t2.a.j(d.a.n0.t2.a.g(list, "FRS_GENERAL_TAB"), list2, 0);
        d.a.n0.t2.a.a(list2, this.n, "FRS_GENERAL_TAB");
    }

    public boolean g() {
        d dVar = this.f58877f;
        return (dVar == null || ListUtils.isEmpty(dVar.f58883g)) ? false : true;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.m
    public void h(MvcSocketResponsedMessage mvcSocketResponsedMessage, MvcSocketMessage mvcSocketMessage, MvcNetMessage mvcNetMessage) {
        if (mvcSocketResponsedMessage == null) {
            return;
        }
        d dVar = null;
        if (!mvcSocketResponsedMessage.hasError()) {
            if (mvcSocketResponsedMessage.getData() instanceof d) {
                dVar = (d) mvcSocketResponsedMessage.getData();
            } else if (mvcSocketResponsedMessage.getData() instanceof d.a.n0.r0.m1.a) {
                d.a.n0.r0.m1.a aVar = (d.a.n0.r0.m1.a) mvcSocketResponsedMessage.getData();
                d dVar2 = new d();
                ArrayList<n> arrayList = aVar.f58894e;
                dVar2.f58883g = arrayList;
                dVar2.f58881e = aVar.f58896g;
                dVar2.f58882f = aVar.f58895f;
                if (!ListUtils.isEmpty(arrayList)) {
                    ArrayList<n> arrayList2 = dVar2.f58883g;
                    n nVar = (n) ListUtils.getItem(arrayList2, arrayList2.size() - 1);
                    if (nVar instanceof a2) {
                        this.j.lastThreadId = d.a.c.e.m.b.f(((a2) nVar).o0(), 0L);
                    }
                }
                dVar = dVar2;
            }
        }
        if (dVar == null || !n(dVar)) {
            this.p = mvcSocketResponsedMessage.getError();
            this.q = mvcSocketResponsedMessage.getErrorString();
            ErrorData errorData = new ErrorData();
            errorData.setError_code(this.p);
            errorData.setError_msg(this.q);
            if (this.p != 0) {
                this.f58876e.onServerError(errorData);
            }
        }
    }

    public final boolean i(int i2) {
        FrsViewData frsViewData;
        FrsCommonTabFragment frsCommonTabFragment = this.f58876e;
        return (frsCommonTabFragment == null || (frsViewData = frsCommonTabFragment.f15270h) == null || frsViewData.mHeadLineDefaultNavTabId != i2) ? false : true;
    }

    public boolean j() {
        return this.l;
    }

    public void k(int i2) {
        this.l = false;
        if (!this.f58880i) {
            if (this.f58879h.M()) {
                return;
            }
            int i3 = this.n + 1;
            this.n = i3;
            FrsCommonTabRequestData frsCommonTabRequestData = this.f58878g;
            frsCommonTabRequestData.pn = i3;
            frsCommonTabRequestData.sortType = i2;
            frsCommonTabRequestData.lastThreadId = -1L;
            frsCommonTabRequestData.adExtParams = c();
            this.f58879h.N();
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

    @Override // com.baidu.tbadk.mvc.model.NetModel.l
    public void l(MvcHttpResponsedMessage mvcHttpResponsedMessage, MvcHttpMessage mvcHttpMessage, MvcNetMessage mvcNetMessage) {
        if (mvcHttpResponsedMessage == null) {
            return;
        }
        d dVar = null;
        if (!mvcHttpResponsedMessage.hasError()) {
            if (mvcHttpResponsedMessage.getData() instanceof d) {
                dVar = (d) mvcHttpResponsedMessage.getData();
            } else if (mvcHttpResponsedMessage.getData() instanceof d.a.n0.r0.m1.a) {
                d.a.n0.r0.m1.a aVar = (d.a.n0.r0.m1.a) mvcHttpResponsedMessage.getData();
                d dVar2 = new d();
                ArrayList<n> arrayList = aVar.f58894e;
                dVar2.f58883g = arrayList;
                dVar2.f58881e = aVar.f58896g;
                dVar2.f58882f = aVar.f58895f;
                if (!ListUtils.isEmpty(arrayList)) {
                    ArrayList<n> arrayList2 = dVar2.f58883g;
                    n nVar = (n) ListUtils.getItem(arrayList2, arrayList2.size() - 1);
                    if (nVar instanceof a2) {
                        this.j.lastThreadId = d.a.c.e.m.b.f(((a2) nVar).o0(), 0L);
                    }
                }
                dVar = dVar2;
            }
        }
        if (dVar == null || !n(dVar)) {
            this.p = mvcHttpResponsedMessage.getError();
            this.q = mvcHttpResponsedMessage.getErrorString();
            ErrorData errorData = new ErrorData();
            errorData.setError_code(this.p);
            errorData.setError_msg(this.q);
            if (this.p != 0) {
                this.f58876e.onServerError(errorData);
            }
        }
    }

    public void m(String str) {
        d dVar = this.f58877f;
        if (dVar == null || d.a.n0.k1.o.k.a.e(dVar.f58883g)) {
            return;
        }
        d.a.n0.t2.a.d(str, this.f58877f.f58883g);
        this.f58876e.U0(this.f58877f);
    }

    public final boolean n(d dVar) {
        if (dVar == null) {
            return false;
        }
        if (this.l) {
            this.m.clear();
            Iterator<n> it = dVar.f58883g.iterator();
            while (it.hasNext()) {
                n next = it.next();
                if (next instanceof a2) {
                    String y1 = ((a2) next).y1();
                    if (!this.m.contains(y1)) {
                        this.m.add(y1);
                    }
                }
            }
            if (d.a.n0.t0.a.d()) {
                d.a.n0.t0.a aVar = this.s;
                if (aVar != null) {
                    aVar.b(dVar.f58883g, this.l, this.f58876e.F());
                }
            } else {
                f(dVar.o, dVar.f58883g);
            }
            this.f58877f = dVar;
            dVar.f58883g = s(dVar.f58883g);
        } else {
            d dVar2 = this.f58877f;
            dVar2.f58881e = dVar.f58881e;
            dVar2.f58882f.putAll(dVar.f58882f);
            ArrayList<n> arrayList = new ArrayList<>();
            Iterator<n> it2 = dVar.f58883g.iterator();
            while (it2.hasNext()) {
                n next2 = it2.next();
                if (next2 instanceof a2) {
                    a2 a2Var = (a2) next2;
                    String y12 = a2Var.y1();
                    if (!this.m.contains(y12)) {
                        a2Var.E1 = this.f58876e.p;
                        arrayList.add(next2);
                        this.m.add(y12);
                    }
                }
            }
            if (d.a.n0.t0.a.d()) {
                d.a.n0.t0.a aVar2 = this.s;
                if (aVar2 != null) {
                    aVar2.b(arrayList, this.l, this.f58876e.F());
                }
            } else {
                f(dVar.o, arrayList);
            }
            this.f58877f.f58883g.addAll(s(arrayList));
        }
        this.f58876e.U0(this.f58877f);
        return true;
    }

    public void o(int i2) {
        this.l = true;
        if (!this.f58880i) {
            if (this.f58879h.M()) {
                return;
            }
            this.n = 1;
            FrsCommonTabRequestData frsCommonTabRequestData = this.f58878g;
            frsCommonTabRequestData.pn = 1;
            frsCommonTabRequestData.sortType = i2;
            long j = this.o;
            if (j >= 0) {
                frsCommonTabRequestData.lastThreadId = j;
            }
            this.f58878g.adExtParams = c();
            this.f58879h.N();
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

    public void p(d.a.n0.t0.a aVar) {
        this.s = aVar;
    }

    public void q(long j) {
        this.o = j;
    }

    public void r(int i2) {
        FrsCommonTabRequestData frsCommonTabRequestData = this.f58878g;
        if (frsCommonTabRequestData != null) {
            frsCommonTabRequestData.tabType = i2;
        }
    }

    public final ArrayList<n> s(ArrayList<n> arrayList) {
        boolean z = this.f58876e.l == 16;
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
                d.a.m0.b.f.a.e(a2Var);
                int[] p0 = a2Var.p0();
                if (a2Var.getType() == a2.J2 && !a2Var.y2()) {
                    z1 z1Var = new z1();
                    z1Var.w = a2Var;
                    z1Var.position = i2;
                    z1Var.f50197e = true;
                    z1Var.setSupportType(BaseCardInfo.SupportType.TOP);
                    arrayList2.add(z1Var);
                    z1 z1Var2 = new z1();
                    z1Var2.w = a2Var;
                    z1Var2.position = i2;
                    if (a2Var.R1()) {
                        z1Var2.j = true;
                    } else if (a2Var.Z2() == 1) {
                        z1Var2.f50200h = true;
                        z1Var2.x = p0[0];
                        z1Var2.y = p0[1];
                    } else if (a2Var.Z2() >= 2) {
                        z1Var2.f50201i = true;
                    } else {
                        z1Var2.f50198f = true;
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
                    if (a2Var.k1() != null) {
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
                    if (a2Var.B1() != null) {
                        z1 z1Var6 = new z1();
                        z1Var6.l = true;
                        z1Var6.w = a2Var;
                        z1Var6.position = i2;
                        z1Var6.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(z1Var6);
                    }
                    if (!z && a2Var.z0() != null && !a2Var.F2()) {
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
                } else if ((a2Var.getType() == a2.g3 || a2Var.getType() == a2.z3) && !a2Var.y2()) {
                    z1 z1Var9 = new z1();
                    z1Var9.w = a2Var;
                    z1Var9.position = i2;
                    z1Var9.f50197e = true;
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
                    if (a2Var.k1() != null) {
                        z1 z1Var12 = new z1();
                        z1Var12.p = true;
                        z1Var12.w = a2Var;
                        z1Var12.position = i2;
                        z1Var12.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(z1Var12);
                    }
                    if (a2Var.B1() != null) {
                        z1 z1Var13 = new z1();
                        z1Var13.l = true;
                        z1Var13.w = a2Var;
                        z1Var13.position = i2;
                        z1Var13.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(z1Var13);
                    }
                    if (!z && a2Var.z0() != null && !a2Var.F2()) {
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
                } else if (a2Var.w1() != null && !a2Var.i2() && a2Var.c2()) {
                    z1 z1Var16 = new z1();
                    z1Var16.w = a2Var;
                    z1Var16.position = i2;
                    z1Var16.f50197e = true;
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
                    if (a2Var.k1() != null) {
                        z1 z1Var19 = new z1();
                        z1Var19.p = true;
                        z1Var19.w = a2Var;
                        z1Var19.position = i2;
                        z1Var19.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(z1Var19);
                    }
                    if (a2Var.B1() != null) {
                        z1 z1Var20 = new z1();
                        z1Var20.l = true;
                        z1Var20.w = a2Var;
                        z1Var20.position = i2;
                        z1Var20.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(z1Var20);
                    }
                    if (!z && a2Var.z0() != null && !a2Var.F2()) {
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
                } else if (a2Var.getType() == a2.Y2 && a2Var.Q1()) {
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
        d.a.m0.b.f.a.d(arrayList2);
        return arrayList2;
    }
}
