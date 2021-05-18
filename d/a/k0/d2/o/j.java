package d.a.k0.d2.o;

import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import com.baidu.adp.widget.ListView.BdRecyclerAdapter;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.pb.pb.adapter.PbReplyLoadMoreAdapter;
import com.baidu.tieba.pb.videopb.fragment.ReplyFragment;
import com.baidu.tieba.tbadkCore.data.PostData;
import d.a.c.j.e.n;
import d.a.k0.d2.k.e.m;
import d.a.k0.d3.h0.o;
import d.a.k0.s2.t;
import d.a.k0.s2.x;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public class j extends d.a.k0.d2.o.o.a {

    /* renamed from: a  reason: collision with root package name */
    public ReplyFragment f53543a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f53544b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.k0.d2.h.e f53545c;

    /* renamed from: e  reason: collision with root package name */
    public m f53547e;

    /* renamed from: f  reason: collision with root package name */
    public PbReplyLoadMoreAdapter f53548f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.c.j.e.a f53549g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.c.j.e.a f53550h;
    public ArrayList<PostData> j;
    public ArrayList<n> k;

    /* renamed from: d  reason: collision with root package name */
    public final List<d.a.c.j.e.a> f53546d = new ArrayList();

    /* renamed from: i  reason: collision with root package name */
    public boolean f53551i = true;
    public String l = null;
    public boolean m = true;
    public boolean n = false;
    public View.OnClickListener o = null;
    public View.OnClickListener p = null;
    public TbRichTextView.x q = null;
    public d.a.k0.d2.i.c r = null;
    public View.OnLongClickListener s = null;

    public j(ReplyFragment replyFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.f53543a = replyFragment;
        this.f53544b = bdTypeRecyclerView;
        d();
    }

    @Override // d.a.k0.d2.o.o.a
    public ArrayList<n> a() {
        return this.k;
    }

    public final void b(o oVar) {
        ForumData l;
        if (oVar == null || this.f53545c == null || oVar.getAdvertAppInfo() == null) {
            return;
        }
        oVar.getAdvertAppInfo().O3 = new d.a.j0.r.q.d();
        if (this.f53545c.w() != null) {
            oVar.getAdvertAppInfo().O3.f49936b = this.f53545c.w().a();
        }
        oVar.getAdvertAppInfo().O3.f49935a = oVar.E0();
        if (this.f53545c.l() != null && (l = this.f53545c.l()) != null) {
            oVar.getAdvertAppInfo().O3.f49938d = l.getId();
            oVar.getAdvertAppInfo().O3.f49939e = l.getFirst_class();
            oVar.getAdvertAppInfo().O3.f49940f = l.getSecond_class();
        }
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            oVar.getAdvertAppInfo().O3.f49941g = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
        }
        oVar.getAdvertAppInfo().O3.f49942h = oVar.getAdvertAppInfo().M3;
        oVar.getAdvertAppInfo().O3.f49943i = false;
    }

    public final boolean c(ArrayList<PostData> arrayList, int i2) {
        for (int max = Math.max(i2 - 4, 0); max < arrayList.size() && max < i2 + 4; max++) {
            if (arrayList.get(max) instanceof o) {
                return true;
            }
        }
        return false;
    }

    public final void d() {
        m mVar = new m(this.f53543a.w(), PostData.p0);
        this.f53547e = mVar;
        mVar.Y0(this.f53543a.w());
        this.f53548f = new PbReplyLoadMoreAdapter(this.f53543a.w(), PostData.v0);
        this.f53549g = x.p().a(this.f53543a.w().getBaseFragmentActivity(), AdvertAppInfo.a4);
        this.f53550h = x.p().a(this.f53543a.w().getBaseFragmentActivity(), AdvertAppInfo.c4);
        this.f53546d.add(this.f53549g);
        this.f53546d.add(this.f53550h);
        this.f53546d.add(this.f53547e);
        this.f53546d.add(this.f53548f);
        this.f53544b.a(this.f53546d);
    }

    public void e() {
        if (this.f53544b.getAdapter() instanceof BdRecyclerAdapter) {
            this.f53544b.getAdapter().notifyDataSetChanged();
        }
    }

    public void f(d.a.k0.d2.h.e eVar) {
        if (eVar == null) {
            return;
        }
        this.f53545c = eVar;
        if (eVar != null && eVar.L() != null && eVar.L().T() != null) {
            this.l = eVar.L().T().getUserId();
        }
        if (this.j == null) {
            this.j = new ArrayList<>();
        }
        this.j.clear();
        d.a.k0.d2.h.e eVar2 = this.f53545c;
        if (eVar2 != null && eVar2.D() != null && this.f53545c.D().size() > 0) {
            this.j.addAll(this.f53545c.D());
        }
        this.f53547e.s(eVar);
        this.f53547e.setFromCDN(this.n);
        this.f53547e.p(this.l);
        this.f53547e.c(this.m);
        this.f53547e.e(this.p);
        this.f53547e.l(this.o);
        this.f53547e.o(this.q);
        this.f53547e.d(this.s);
        this.f53547e.X0(this.r);
        this.f53548f.i0(this.p);
        n();
        d.a.c.j.e.a aVar = this.f53550h;
        if (aVar != null && (aVar instanceof t)) {
            ((t) aVar).j(this.n);
        }
        ArrayList<n> arrayList = new ArrayList<>(eVar.D());
        boolean z = false;
        PostData postData = null;
        Iterator<n> it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            n next = it.next();
            if (next instanceof PostData) {
                PostData postData2 = (PostData) next;
                if (postData2.A() == 1) {
                    postData = postData2;
                    z = true;
                    break;
                }
            }
        }
        if (z) {
            arrayList.remove(postData);
        }
        BdTypeRecyclerView bdTypeRecyclerView = this.f53544b;
        if (bdTypeRecyclerView != null) {
            this.k = arrayList;
            bdTypeRecyclerView.setData(arrayList);
        }
    }

    public void g(boolean z) {
        this.n = z;
    }

    public void h(boolean z) {
        this.f53551i = z;
    }

    public void i(View.OnClickListener onClickListener) {
        this.o = onClickListener;
    }

    public void j(TbRichTextView.x xVar) {
        this.q = xVar;
    }

    public void k(View.OnLongClickListener onLongClickListener) {
        this.s = onLongClickListener;
    }

    public void l(View.OnClickListener onClickListener) {
        this.p = onClickListener;
    }

    public void m(d.a.k0.d2.i.c cVar) {
        this.r = cVar;
    }

    public final void n() {
        o oVar;
        o oVar2;
        d.a.k0.d2.h.e eVar = this.f53545c;
        if (eVar == null || eVar.Y || eVar.Z == 2) {
            return;
        }
        ArrayList<PostData> D = eVar.D();
        ArrayList<o> e2 = this.f53545c.e();
        if (e2 == null || e2.isEmpty() || D == null || D.isEmpty()) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        Iterator<o> it = e2.iterator();
        while (it.hasNext()) {
            o next = it.next();
            if (next != null && next.D0() != null) {
                sb.append(next.D0());
                sb.append(",");
            }
        }
        if (sb.length() > 1) {
            sb.deleteCharAt(sb.length() - 1);
        }
        Iterator<o> it2 = e2.iterator();
        while (it2.hasNext()) {
            o next2 = it2.next();
            if (next2 != null) {
                next2.K0 = next2.getPosition() - 1;
            }
        }
        SparseArray sparseArray = new SparseArray();
        Iterator<o> it3 = e2.iterator();
        while (it3.hasNext()) {
            o next3 = it3.next();
            if (next3.getAdvertAppInfo() != null) {
                int G4 = next3.getAdvertAppInfo().G4();
                if (G4 != 0) {
                    d.a.k0.s2.i0.d.i(next3, G4);
                    if (G4 != 28 && G4 != 31) {
                        next3.getAdvertAppInfo().H3 = -1001;
                        Log.e("cq", "updateAppData，Data InValidate: " + G4);
                    }
                }
                sparseArray.put(next3.getPosition(), next3);
            }
        }
        HashMap hashMap = new HashMap();
        for (int i2 = 0; i2 < sparseArray.size(); i2++) {
            o oVar3 = (o) sparseArray.get(sparseArray.keyAt(i2));
            if (oVar3 != null && (oVar2 = (o) hashMap.put(oVar3.C0(), oVar3)) != null) {
                d.a.k0.s2.i0.d.i(oVar2, 30);
            }
        }
        sparseArray.clear();
        for (Map.Entry entry : hashMap.entrySet()) {
            if (entry != null && (oVar = (o) entry.getValue()) != null) {
                sparseArray.put(oVar.getPosition(), oVar);
            }
        }
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < sparseArray.size(); i3++) {
            arrayList.add(Integer.valueOf(sparseArray.keyAt(i3)));
        }
        Collections.sort(arrayList);
        for (int i4 = 0; i4 < arrayList.size(); i4++) {
            o oVar4 = (o) sparseArray.get(((Integer) arrayList.get(i4)).intValue());
            if (this.f53545c.l() != null) {
                oVar4.z0 = this.f53545c.l().getId();
            }
            if (this.f53545c.L() != null) {
                oVar4.C0 = d.a.c.e.m.b.f(this.f53545c.L().o0(), 0L);
            }
            d.a.k0.d2.h.e eVar2 = this.f53545c;
            if (eVar2 != null && eVar2.w() != null) {
                oVar4.D0 = this.f53545c.w().a();
            }
            b(oVar4);
            int position = oVar4.getPosition() + this.f53545c.X;
            if (position >= D.size()) {
                oVar4.K0 = position;
                d.a.k0.s2.i0.d.j(oVar4, 2, position + i4, d.a.k0.j1.o.k.a.k(arrayList));
                return;
            }
            if (!this.f53551i) {
                position--;
                oVar4.K0 = position;
            }
            if (position < 0) {
                d.a.k0.s2.i0.d.i(oVar4, 23);
            } else if (c(D, position)) {
                d.a.k0.s2.i0.d.i(oVar4, 1);
            } else {
                D.add(position, oVar4);
                TiebaStatic.eventStat(this.f53543a.getPageContext().getPageActivity(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", oVar4.getAdvertAppInfo().X3);
            }
        }
    }
}
