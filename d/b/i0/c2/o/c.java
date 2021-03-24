package d.b.i0.c2.o;

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
import d.b.b.j.e.n;
import d.b.i0.c2.k.e.k;
import d.b.i0.c3.h0.o;
import d.b.i0.r2.p;
import d.b.i0.r2.s;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public class c extends d.b.i0.c2.o.h.a {

    /* renamed from: a  reason: collision with root package name */
    public ReplyFragment f53170a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f53171b;

    /* renamed from: c  reason: collision with root package name */
    public d.b.i0.c2.h.e f53172c;

    /* renamed from: e  reason: collision with root package name */
    public k f53174e;

    /* renamed from: f  reason: collision with root package name */
    public PbReplyLoadMoreAdapter f53175f;

    /* renamed from: g  reason: collision with root package name */
    public d.b.b.j.e.a f53176g;

    /* renamed from: h  reason: collision with root package name */
    public d.b.b.j.e.a f53177h;
    public ArrayList<PostData> j;
    public ArrayList<n> k;

    /* renamed from: d  reason: collision with root package name */
    public final List<d.b.b.j.e.a> f53173d = new ArrayList();
    public boolean i = true;
    public String l = null;
    public boolean m = true;
    public boolean n = false;
    public View.OnClickListener o = null;
    public View.OnClickListener p = null;
    public TbRichTextView.w q = null;
    public d.b.i0.c2.i.c r = null;
    public View.OnLongClickListener s = null;

    public c(ReplyFragment replyFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.f53170a = replyFragment;
        this.f53171b = bdTypeRecyclerView;
        d();
    }

    @Override // d.b.i0.c2.o.h.a
    public ArrayList<n> a() {
        return this.k;
    }

    public final void b(o oVar) {
        ForumData l;
        if (oVar == null || this.f53172c == null || oVar.B0() == null) {
            return;
        }
        oVar.B0().advertAppContext = new d.b.h0.r.q.d();
        if (this.f53172c.w() != null) {
            oVar.B0().advertAppContext.f50749b = this.f53172c.w().a();
        }
        oVar.B0().advertAppContext.f50748a = oVar.C0();
        if (this.f53172c.l() != null && (l = this.f53172c.l()) != null) {
            oVar.B0().advertAppContext.f50751d = l.getId();
            oVar.B0().advertAppContext.f50752e = l.getFirst_class();
            oVar.B0().advertAppContext.f50753f = l.getSecond_class();
        }
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            oVar.B0().advertAppContext.f50754g = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
        }
        oVar.B0().advertAppContext.f50755h = oVar.B0().ext_info;
        oVar.B0().advertAppContext.i = false;
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
        k kVar = new k(this.f53170a.I(), PostData.o0);
        this.f53174e = kVar;
        kVar.Y0(this.f53170a.I());
        this.f53175f = new PbReplyLoadMoreAdapter(this.f53170a.I(), PostData.u0);
        this.f53176g = s.o().a(this.f53170a.I().getBaseFragmentActivity(), AdvertAppInfo.i4);
        this.f53177h = s.o().a(this.f53170a.I().getBaseFragmentActivity(), AdvertAppInfo.k4);
        this.f53173d.add(this.f53176g);
        this.f53173d.add(this.f53177h);
        this.f53173d.add(this.f53174e);
        this.f53173d.add(this.f53175f);
        this.f53171b.a(this.f53173d);
    }

    public void e() {
        if (this.f53171b.getAdapter() instanceof BdRecyclerAdapter) {
            this.f53171b.getAdapter().notifyDataSetChanged();
        }
    }

    public void f(d.b.i0.c2.h.e eVar) {
        if (eVar == null) {
            return;
        }
        this.f53172c = eVar;
        if (eVar != null && eVar.L() != null && eVar.L().T() != null) {
            this.l = eVar.L().T().getUserId();
        }
        if (this.j == null) {
            this.j = new ArrayList<>();
        }
        this.j.clear();
        d.b.i0.c2.h.e eVar2 = this.f53172c;
        if (eVar2 != null && eVar2.D() != null && this.f53172c.D().size() > 0) {
            this.j.addAll(this.f53172c.D());
        }
        this.f53174e.s(eVar);
        this.f53174e.setFromCDN(this.n);
        this.f53174e.n(this.l);
        this.f53174e.h(this.m);
        this.f53174e.l(this.p);
        this.f53174e.e(this.o);
        this.f53174e.j(this.q);
        this.f53174e.k(this.s);
        this.f53174e.X0(this.r);
        this.f53175f.m0(this.p);
        n();
        d.b.b.j.e.a aVar = this.f53177h;
        if (aVar != null && (aVar instanceof p)) {
            ((p) aVar).c(this.n);
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
                if (postData2.z() == 1) {
                    postData = postData2;
                    z = true;
                    break;
                }
            }
        }
        if (z) {
            arrayList.remove(postData);
        }
        BdTypeRecyclerView bdTypeRecyclerView = this.f53171b;
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

    public void j(TbRichTextView.w wVar) {
        this.q = wVar;
    }

    public void k(View.OnLongClickListener onLongClickListener) {
        this.s = onLongClickListener;
    }

    public void l(View.OnClickListener onClickListener) {
        this.p = onClickListener;
    }

    public void m(d.b.i0.c2.i.c cVar) {
        this.r = cVar;
    }

    public final void n() {
        o oVar;
        o oVar2;
        d.b.i0.c2.h.e eVar = this.f53172c;
        if (eVar == null || eVar.Y || eVar.Z == 2) {
            return;
        }
        ArrayList<PostData> D = eVar.D();
        ArrayList<o> e2 = this.f53172c.e();
        if (e2 == null || e2.isEmpty() || D == null || D.isEmpty()) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        Iterator<o> it = e2.iterator();
        while (it.hasNext()) {
            o next = it.next();
            if (next != null && next.A0() != null) {
                sb.append(next.A0());
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
                next2.z0 = sb.toString();
                next2.L0 = next2.getPosition() - 1;
            }
        }
        SparseArray sparseArray = new SparseArray();
        Iterator<o> it3 = e2.iterator();
        while (it3.hasNext()) {
            o next3 = it3.next();
            if (next3.B0() != null) {
                int u = next3.B0().u();
                if (u != 0) {
                    d.b.i0.r2.b0.d.h(next3, u);
                    if (u != 28 && u != 31) {
                        if (next3.B0().goods != null) {
                            next3.B0().goods.goods_style = -1001;
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
            if (oVar3 != null && (oVar2 = (o) hashMap.put(oVar3.A0(), oVar3)) != null) {
                d.b.i0.r2.b0.d.h(oVar2, 30);
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
            if (this.f53172c.l() != null) {
                oVar4.A0 = this.f53172c.l().getId();
            }
            if (this.f53172c.L() != null) {
                oVar4.D0 = d.b.b.e.m.b.f(this.f53172c.L().o0(), 0L);
            }
            d.b.i0.c2.h.e eVar2 = this.f53172c;
            if (eVar2 != null && eVar2.w() != null) {
                oVar4.E0 = this.f53172c.w().a();
            }
            b(oVar4);
            int position = oVar4.getPosition() + this.f53172c.X;
            if (position >= D.size()) {
                oVar4.L0 = position;
                d.b.i0.r2.b0.d.i(oVar4, 2, position + i3, d.b.i0.i1.o.k.a.j(arrayList));
                return;
            }
            if (!this.i) {
                position--;
                oVar4.L0 = position;
            }
            if (position < 0) {
                d.b.i0.r2.b0.d.h(oVar4, 23);
            } else if (c(D, position)) {
                d.b.i0.r2.b0.d.h(oVar4, 1);
            } else {
                D.add(position, oVar4);
                TiebaStatic.eventStat(this.f53170a.getPageContext().getPageActivity(), CommonStatisticKey.PB_SHOW_APP, "", 1, DpStatConstants.KEY_APP_NAME, oVar4.B0().apk_name);
            }
        }
    }
}
