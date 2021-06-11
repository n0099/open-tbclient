package d.a.n0.e2.o;

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
import d.a.c.k.e.n;
import d.a.n0.e2.k.e.m;
import d.a.n0.e3.h0.o;
import d.a.n0.t2.t;
import d.a.n0.t2.x;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public class j extends d.a.n0.e2.o.o.a {

    /* renamed from: a  reason: collision with root package name */
    public ReplyFragment f57442a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f57443b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.n0.e2.h.e f57444c;

    /* renamed from: e  reason: collision with root package name */
    public m f57446e;

    /* renamed from: f  reason: collision with root package name */
    public PbReplyLoadMoreAdapter f57447f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.c.k.e.a f57448g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.c.k.e.a f57449h;
    public ArrayList<PostData> j;
    public ArrayList<n> k;

    /* renamed from: d  reason: collision with root package name */
    public final List<d.a.c.k.e.a> f57445d = new ArrayList();

    /* renamed from: i  reason: collision with root package name */
    public boolean f57450i = true;
    public String l = null;
    public boolean m = true;
    public boolean n = false;
    public View.OnClickListener o = null;
    public View.OnClickListener p = null;
    public TbRichTextView.x q = null;
    public d.a.n0.e2.i.c r = null;
    public View.OnLongClickListener s = null;

    public j(ReplyFragment replyFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.f57442a = replyFragment;
        this.f57443b = bdTypeRecyclerView;
        d();
    }

    @Override // d.a.n0.e2.o.o.a
    public ArrayList<n> a() {
        return this.k;
    }

    public final void b(o oVar) {
        ForumData l;
        if (oVar == null || this.f57444c == null || oVar.getAdvertAppInfo() == null) {
            return;
        }
        oVar.getAdvertAppInfo().S3 = new d.a.m0.r.q.d();
        if (this.f57444c.w() != null) {
            oVar.getAdvertAppInfo().S3.f53656b = this.f57444c.w().a();
        }
        oVar.getAdvertAppInfo().S3.f53655a = oVar.E0();
        if (this.f57444c.l() != null && (l = this.f57444c.l()) != null) {
            oVar.getAdvertAppInfo().S3.f53658d = l.getId();
            oVar.getAdvertAppInfo().S3.f53659e = l.getFirst_class();
            oVar.getAdvertAppInfo().S3.f53660f = l.getSecond_class();
        }
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            oVar.getAdvertAppInfo().S3.f53661g = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
        }
        oVar.getAdvertAppInfo().S3.f53662h = oVar.getAdvertAppInfo().Q3;
        oVar.getAdvertAppInfo().S3.f53663i = false;
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
        m mVar = new m(this.f57442a.x(), PostData.p0);
        this.f57446e = mVar;
        mVar.Z0(this.f57442a.x());
        this.f57447f = new PbReplyLoadMoreAdapter(this.f57442a.x(), PostData.v0);
        this.f57448g = x.p().a(this.f57442a.x().getBaseFragmentActivity(), AdvertAppInfo.e4);
        this.f57449h = x.p().a(this.f57442a.x().getBaseFragmentActivity(), AdvertAppInfo.g4);
        this.f57445d.add(this.f57448g);
        this.f57445d.add(this.f57449h);
        this.f57445d.add(this.f57446e);
        this.f57445d.add(this.f57447f);
        this.f57443b.a(this.f57445d);
    }

    public void e() {
        if (this.f57443b.getAdapter() instanceof BdRecyclerAdapter) {
            this.f57443b.getAdapter().notifyDataSetChanged();
        }
    }

    public void f(d.a.n0.e2.h.e eVar) {
        if (eVar == null) {
            return;
        }
        this.f57444c = eVar;
        if (eVar != null && eVar.L() != null && eVar.L().T() != null) {
            this.l = eVar.L().T().getUserId();
        }
        if (this.j == null) {
            this.j = new ArrayList<>();
        }
        this.j.clear();
        d.a.n0.e2.h.e eVar2 = this.f57444c;
        if (eVar2 != null && eVar2.D() != null && this.f57444c.D().size() > 0) {
            this.j.addAll(this.f57444c.D());
        }
        this.f57446e.t(eVar);
        this.f57446e.setFromCDN(this.n);
        this.f57446e.q(this.l);
        this.f57446e.c(this.m);
        this.f57446e.e(this.p);
        this.f57446e.m(this.o);
        this.f57446e.p(this.q);
        this.f57446e.d(this.s);
        this.f57446e.Y0(this.r);
        this.f57447f.j0(this.p);
        n();
        d.a.c.k.e.a aVar = this.f57449h;
        if (aVar != null && (aVar instanceof t)) {
            ((t) aVar).k(this.n);
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
        BdTypeRecyclerView bdTypeRecyclerView = this.f57443b;
        if (bdTypeRecyclerView != null) {
            this.k = arrayList;
            bdTypeRecyclerView.setData(arrayList);
        }
    }

    public void g(boolean z) {
        this.n = z;
    }

    public void h(boolean z) {
        this.f57450i = z;
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

    public void m(d.a.n0.e2.i.c cVar) {
        this.r = cVar;
    }

    public final void n() {
        o oVar;
        o oVar2;
        d.a.n0.e2.h.e eVar = this.f57444c;
        if (eVar == null || eVar.Y || eVar.Z == 2) {
            return;
        }
        ArrayList<PostData> D = eVar.D();
        ArrayList<o> e2 = this.f57444c.e();
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
                next2.F0 = next2.getPosition() - 1;
            }
        }
        SparseArray sparseArray = new SparseArray();
        Iterator<o> it3 = e2.iterator();
        while (it3.hasNext()) {
            o next3 = it3.next();
            if (next3.getAdvertAppInfo() != null) {
                int I4 = next3.getAdvertAppInfo().I4();
                if (I4 != 0) {
                    d.a.n0.t2.i0.d.i(next3, I4);
                    if (I4 != 28 && I4 != 31) {
                        next3.getAdvertAppInfo().L3 = -1001;
                        Log.e("cq", "updateAppData，Data InValidate: " + I4);
                    }
                }
                sparseArray.put(next3.getPosition(), next3);
            }
        }
        HashMap hashMap = new HashMap();
        for (int i2 = 0; i2 < sparseArray.size(); i2++) {
            o oVar3 = (o) sparseArray.get(sparseArray.keyAt(i2));
            if (oVar3 != null && (oVar2 = (o) hashMap.put(oVar3.C0(), oVar3)) != null) {
                d.a.n0.t2.i0.d.i(oVar2, 30);
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
            if (this.f57444c.l() != null) {
                oVar4.z0 = this.f57444c.l().getId();
            }
            if (this.f57444c.L() != null) {
                oVar4.C0 = d.a.c.e.m.b.f(this.f57444c.L().o0(), 0L);
            }
            d.a.n0.e2.h.e eVar2 = this.f57444c;
            if (eVar2 != null && eVar2.w() != null) {
                oVar4.D0 = this.f57444c.w().a();
            }
            b(oVar4);
            int position = oVar4.getPosition() + this.f57444c.X;
            if (position >= D.size()) {
                oVar4.F0 = position;
                d.a.n0.t2.i0.d.j(oVar4, 2, position + i4, d.a.n0.k1.o.k.a.k(arrayList));
                return;
            }
            if (!this.f57450i) {
                position--;
                oVar4.F0 = position;
            }
            if (position < 0) {
                d.a.n0.t2.i0.d.i(oVar4, 23);
            } else if (c(D, position)) {
                d.a.n0.t2.i0.d.i(oVar4, 1);
            } else {
                D.add(position, oVar4);
                TiebaStatic.eventStat(this.f57442a.getPageContext().getPageActivity(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", oVar4.getAdvertAppInfo().b4);
            }
        }
    }
}
