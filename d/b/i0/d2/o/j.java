package d.b.i0.d2.o;

import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import com.baidu.adp.widget.ListView.BdRecyclerAdapter;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
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
import d.b.c.j.e.n;
import d.b.i0.d2.k.e.m;
import d.b.i0.d3.h0.o;
import d.b.i0.s2.s;
import d.b.i0.s2.v;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class j extends d.b.i0.d2.o.o.a {

    /* renamed from: a  reason: collision with root package name */
    public ReplyFragment f54595a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f54596b;

    /* renamed from: c  reason: collision with root package name */
    public d.b.i0.d2.h.e f54597c;

    /* renamed from: e  reason: collision with root package name */
    public m f54599e;

    /* renamed from: f  reason: collision with root package name */
    public PbReplyLoadMoreAdapter f54600f;

    /* renamed from: g  reason: collision with root package name */
    public d.b.c.j.e.a f54601g;

    /* renamed from: h  reason: collision with root package name */
    public d.b.c.j.e.a f54602h;
    public ArrayList<PostData> j;
    public ArrayList<n> k;

    /* renamed from: d  reason: collision with root package name */
    public final List<d.b.c.j.e.a> f54598d = new ArrayList();
    public boolean i = true;
    public String l = null;
    public boolean m = true;
    public boolean n = false;
    public View.OnClickListener o = null;
    public View.OnClickListener p = null;
    public TbRichTextView.x q = null;
    public d.b.i0.d2.i.c r = null;
    public View.OnLongClickListener s = null;

    public j(ReplyFragment replyFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.f54595a = replyFragment;
        this.f54596b = bdTypeRecyclerView;
        d();
    }

    @Override // d.b.i0.d2.o.o.a
    public ArrayList<n> a() {
        return this.k;
    }

    public final void b(o oVar) {
        ForumData l;
        if (oVar == null || this.f54597c == null || oVar.D0() == null) {
            return;
        }
        oVar.D0().advertAppContext = new d.b.h0.r.q.d();
        if (this.f54597c.w() != null) {
            oVar.D0().advertAppContext.f51157b = this.f54597c.w().a();
        }
        oVar.D0().advertAppContext.f51156a = oVar.E0();
        if (this.f54597c.l() != null && (l = this.f54597c.l()) != null) {
            oVar.D0().advertAppContext.f51159d = l.getId();
            oVar.D0().advertAppContext.f51160e = l.getFirst_class();
            oVar.D0().advertAppContext.f51161f = l.getSecond_class();
        }
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            oVar.D0().advertAppContext.f51162g = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
        }
        oVar.D0().advertAppContext.f51163h = oVar.D0().ext_info;
        oVar.D0().advertAppContext.i = false;
    }

    public final boolean c(ArrayList<PostData> arrayList, int i) {
        for (int max = Math.max(i - 4, 0); max < arrayList.size() && max < i + 4; max++) {
            if (arrayList.get(max) instanceof o) {
                return true;
            }
        }
        return false;
    }

    public final void d() {
        m mVar = new m(this.f54595a.I(), PostData.p0);
        this.f54599e = mVar;
        mVar.Y0(this.f54595a.I());
        this.f54600f = new PbReplyLoadMoreAdapter(this.f54595a.I(), PostData.v0);
        this.f54601g = v.p().a(this.f54595a.I().getBaseFragmentActivity(), AdvertAppInfo.i4);
        this.f54602h = v.p().a(this.f54595a.I().getBaseFragmentActivity(), AdvertAppInfo.k4);
        this.f54598d.add(this.f54601g);
        this.f54598d.add(this.f54602h);
        this.f54598d.add(this.f54599e);
        this.f54598d.add(this.f54600f);
        this.f54596b.a(this.f54598d);
    }

    public void e() {
        if (this.f54596b.getAdapter() instanceof BdRecyclerAdapter) {
            this.f54596b.getAdapter().notifyDataSetChanged();
        }
    }

    public void f(d.b.i0.d2.h.e eVar) {
        if (eVar == null) {
            return;
        }
        this.f54597c = eVar;
        if (eVar != null && eVar.L() != null && eVar.L().T() != null) {
            this.l = eVar.L().T().getUserId();
        }
        if (this.j == null) {
            this.j = new ArrayList<>();
        }
        this.j.clear();
        d.b.i0.d2.h.e eVar2 = this.f54597c;
        if (eVar2 != null && eVar2.D() != null && this.f54597c.D().size() > 0) {
            this.j.addAll(this.f54597c.D());
        }
        this.f54599e.s(eVar);
        this.f54599e.setFromCDN(this.n);
        this.f54599e.n(this.l);
        this.f54599e.h(this.m);
        this.f54599e.l(this.p);
        this.f54599e.e(this.o);
        this.f54599e.j(this.q);
        this.f54599e.k(this.s);
        this.f54599e.X0(this.r);
        this.f54600f.m0(this.p);
        n();
        d.b.c.j.e.a aVar = this.f54602h;
        if (aVar != null && (aVar instanceof s)) {
            ((s) aVar).c(this.n);
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
        BdTypeRecyclerView bdTypeRecyclerView = this.f54596b;
        if (bdTypeRecyclerView != null) {
            this.k = arrayList;
            bdTypeRecyclerView.setData(arrayList);
        }
    }

    public void g(boolean z) {
        this.n = z;
    }

    public void h(boolean z) {
        this.i = z;
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

    public void m(d.b.i0.d2.i.c cVar) {
        this.r = cVar;
    }

    public final void n() {
        o oVar;
        o oVar2;
        d.b.i0.d2.h.e eVar = this.f54597c;
        if (eVar == null || eVar.Y || eVar.Z == 2) {
            return;
        }
        ArrayList<PostData> D = eVar.D();
        ArrayList<o> e2 = this.f54597c.e();
        if (e2 == null || e2.isEmpty() || D == null || D.isEmpty()) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        Iterator<o> it = e2.iterator();
        while (it.hasNext()) {
            o next = it.next();
            if (next != null && next.C0() != null) {
                sb.append(next.C0());
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
                next2.A0 = sb.toString();
                next2.M0 = next2.getPosition() - 1;
            }
        }
        SparseArray sparseArray = new SparseArray();
        Iterator<o> it3 = e2.iterator();
        while (it3.hasNext()) {
            o next3 = it3.next();
            if (next3.D0() != null) {
                int u = next3.D0().u();
                if (u != 0) {
                    d.b.i0.s2.f0.d.i(next3, u);
                    if (u != 28 && u != 31) {
                        if (next3.D0().goods != null) {
                            next3.D0().goods.goods_style = -1001;
                        }
                        Log.e("cq", "updateAppData，Data InValidate: " + u);
                    }
                }
                sparseArray.put(next3.getPosition(), next3);
            }
        }
        HashMap hashMap = new HashMap();
        for (int i = 0; i < sparseArray.size(); i++) {
            o oVar3 = (o) sparseArray.get(sparseArray.keyAt(i));
            if (oVar3 != null && (oVar2 = (o) hashMap.put(oVar3.C0(), oVar3)) != null) {
                d.b.i0.s2.f0.d.i(oVar2, 30);
            }
        }
        sparseArray.clear();
        for (Map.Entry entry : hashMap.entrySet()) {
            if (entry != null && (oVar = (o) entry.getValue()) != null) {
                sparseArray.put(oVar.getPosition(), oVar);
            }
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < sparseArray.size(); i2++) {
            arrayList.add(Integer.valueOf(sparseArray.keyAt(i2)));
        }
        Collections.sort(arrayList);
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            o oVar4 = (o) sparseArray.get(((Integer) arrayList.get(i3)).intValue());
            if (this.f54597c.l() != null) {
                oVar4.B0 = this.f54597c.l().getId();
            }
            if (this.f54597c.L() != null) {
                oVar4.E0 = d.b.c.e.m.b.f(this.f54597c.L().o0(), 0L);
            }
            d.b.i0.d2.h.e eVar2 = this.f54597c;
            if (eVar2 != null && eVar2.w() != null) {
                oVar4.K0 = this.f54597c.w().a();
            }
            b(oVar4);
            int position = oVar4.getPosition() + this.f54597c.X;
            if (position >= D.size()) {
                oVar4.M0 = position;
                d.b.i0.s2.f0.d.j(oVar4, 2, position + i3, d.b.i0.j1.o.k.a.k(arrayList));
                return;
            }
            if (!this.i) {
                position--;
                oVar4.M0 = position;
            }
            if (position < 0) {
                d.b.i0.s2.f0.d.i(oVar4, 23);
            } else if (c(D, position)) {
                d.b.i0.s2.f0.d.i(oVar4, 1);
            } else {
                D.add(position, oVar4);
                TiebaStatic.eventStat(this.f54595a.getPageContext().getPageActivity(), CommonStatisticKey.PB_SHOW_APP, "", 1, DpStatConstants.KEY_APP_NAME, oVar4.D0().apk_name);
            }
        }
    }
}
