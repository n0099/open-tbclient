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
import d.a.c.j.e.n;
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
    public ReplyFragment f53753a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f53754b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.n0.e2.h.e f53755c;

    /* renamed from: e  reason: collision with root package name */
    public m f53757e;

    /* renamed from: f  reason: collision with root package name */
    public PbReplyLoadMoreAdapter f53758f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.c.j.e.a f53759g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.c.j.e.a f53760h;
    public ArrayList<PostData> j;
    public ArrayList<n> k;

    /* renamed from: d  reason: collision with root package name */
    public final List<d.a.c.j.e.a> f53756d = new ArrayList();

    /* renamed from: i  reason: collision with root package name */
    public boolean f53761i = true;
    public String l = null;
    public boolean m = true;
    public boolean n = false;
    public View.OnClickListener o = null;
    public View.OnClickListener p = null;
    public TbRichTextView.x q = null;
    public d.a.n0.e2.i.c r = null;
    public View.OnLongClickListener s = null;

    public j(ReplyFragment replyFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.f53753a = replyFragment;
        this.f53754b = bdTypeRecyclerView;
        d();
    }

    @Override // d.a.n0.e2.o.o.a
    public ArrayList<n> a() {
        return this.k;
    }

    public final void b(o oVar) {
        ForumData l;
        if (oVar == null || this.f53755c == null || oVar.getAdvertAppInfo() == null) {
            return;
        }
        oVar.getAdvertAppInfo().P3 = new d.a.m0.r.q.d();
        if (this.f53755c.w() != null) {
            oVar.getAdvertAppInfo().P3.f49980b = this.f53755c.w().a();
        }
        oVar.getAdvertAppInfo().P3.f49979a = oVar.E0();
        if (this.f53755c.l() != null && (l = this.f53755c.l()) != null) {
            oVar.getAdvertAppInfo().P3.f49982d = l.getId();
            oVar.getAdvertAppInfo().P3.f49983e = l.getFirst_class();
            oVar.getAdvertAppInfo().P3.f49984f = l.getSecond_class();
        }
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            oVar.getAdvertAppInfo().P3.f49985g = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
        }
        oVar.getAdvertAppInfo().P3.f49986h = oVar.getAdvertAppInfo().N3;
        oVar.getAdvertAppInfo().P3.f49987i = false;
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
        m mVar = new m(this.f53753a.w(), PostData.p0);
        this.f53757e = mVar;
        mVar.Y0(this.f53753a.w());
        this.f53758f = new PbReplyLoadMoreAdapter(this.f53753a.w(), PostData.v0);
        this.f53759g = x.p().a(this.f53753a.w().getBaseFragmentActivity(), AdvertAppInfo.b4);
        this.f53760h = x.p().a(this.f53753a.w().getBaseFragmentActivity(), AdvertAppInfo.d4);
        this.f53756d.add(this.f53759g);
        this.f53756d.add(this.f53760h);
        this.f53756d.add(this.f53757e);
        this.f53756d.add(this.f53758f);
        this.f53754b.a(this.f53756d);
    }

    public void e() {
        if (this.f53754b.getAdapter() instanceof BdRecyclerAdapter) {
            this.f53754b.getAdapter().notifyDataSetChanged();
        }
    }

    public void f(d.a.n0.e2.h.e eVar) {
        if (eVar == null) {
            return;
        }
        this.f53755c = eVar;
        if (eVar != null && eVar.L() != null && eVar.L().T() != null) {
            this.l = eVar.L().T().getUserId();
        }
        if (this.j == null) {
            this.j = new ArrayList<>();
        }
        this.j.clear();
        d.a.n0.e2.h.e eVar2 = this.f53755c;
        if (eVar2 != null && eVar2.D() != null && this.f53755c.D().size() > 0) {
            this.j.addAll(this.f53755c.D());
        }
        this.f53757e.s(eVar);
        this.f53757e.setFromCDN(this.n);
        this.f53757e.p(this.l);
        this.f53757e.c(this.m);
        this.f53757e.e(this.p);
        this.f53757e.l(this.o);
        this.f53757e.o(this.q);
        this.f53757e.d(this.s);
        this.f53757e.X0(this.r);
        this.f53758f.i0(this.p);
        n();
        d.a.c.j.e.a aVar = this.f53760h;
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
        BdTypeRecyclerView bdTypeRecyclerView = this.f53754b;
        if (bdTypeRecyclerView != null) {
            this.k = arrayList;
            bdTypeRecyclerView.setData(arrayList);
        }
    }

    public void g(boolean z) {
        this.n = z;
    }

    public void h(boolean z) {
        this.f53761i = z;
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
        d.a.n0.e2.h.e eVar = this.f53755c;
        if (eVar == null || eVar.Y || eVar.Z == 2) {
            return;
        }
        ArrayList<PostData> D = eVar.D();
        ArrayList<o> e2 = this.f53755c.e();
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
                int H4 = next3.getAdvertAppInfo().H4();
                if (H4 != 0) {
                    d.a.n0.t2.i0.d.i(next3, H4);
                    if (H4 != 28 && H4 != 31) {
                        next3.getAdvertAppInfo().I3 = -1001;
                        Log.e("cq", "updateAppData，Data InValidate: " + H4);
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
            if (this.f53755c.l() != null) {
                oVar4.z0 = this.f53755c.l().getId();
            }
            if (this.f53755c.L() != null) {
                oVar4.C0 = d.a.c.e.m.b.f(this.f53755c.L().o0(), 0L);
            }
            d.a.n0.e2.h.e eVar2 = this.f53755c;
            if (eVar2 != null && eVar2.w() != null) {
                oVar4.D0 = this.f53755c.w().a();
            }
            b(oVar4);
            int position = oVar4.getPosition() + this.f53755c.X;
            if (position >= D.size()) {
                oVar4.K0 = position;
                d.a.n0.t2.i0.d.j(oVar4, 2, position + i4, d.a.n0.k1.o.k.a.k(arrayList));
                return;
            }
            if (!this.f53761i) {
                position--;
                oVar4.K0 = position;
            }
            if (position < 0) {
                d.a.n0.t2.i0.d.i(oVar4, 23);
            } else if (c(D, position)) {
                d.a.n0.t2.i0.d.i(oVar4, 1);
            } else {
                D.add(position, oVar4);
                TiebaStatic.eventStat(this.f53753a.getPageContext().getPageActivity(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", oVar4.getAdvertAppInfo().Y3);
            }
        }
    }
}
