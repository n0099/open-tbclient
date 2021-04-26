package d.a.d.l;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.afd.adapter.AdCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.lego.card.model.ICardInfo;
import d.a.d.d;
import d.a.j0.j1.o.l.f;
import d.a.j0.j1.o.l.k;
import d.a.j0.q0.p2.c;
import d.a.j0.s2.h0.e;
import d.a.j0.s2.h0.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class a extends d.a.c.j.e.a<d, AdCardViewHolder> implements f {
    public ICardInfo m;
    public d n;
    public TbPageContext o;
    public d.a.j0.q0.i1.a p;
    public c q;
    public k r;
    public List<k> s;
    public f t;

    /* renamed from: d.a.d.l.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0529a implements d.a.j0.j1.o.a {
        public C0529a() {
        }

        @Override // d.a.j0.j1.o.a
        public void a(int i2, HashMap<String, Object> hashMap) {
            a aVar = a.this;
            aVar.i0(aVar.n, a.this.n.m());
        }

        @Override // d.a.j0.j1.o.a
        public void b(String str, String str2, HashMap<String, Object> hashMap) {
            a aVar = a.this;
            aVar.i0(aVar.n, a.this.n.m());
        }
    }

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, d.a.j0.q0.i1.a aVar, c cVar, f fVar) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.s = new ArrayList();
        this.o = tbPageContext;
        this.p = aVar;
        this.q = cVar;
        this.t = fVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: g0 */
    public View H(int i2, View view, ViewGroup viewGroup, d dVar) {
        this.n = dVar;
        this.m = dVar.p();
        return super.H(i2, view, viewGroup, dVar);
    }

    @Override // d.a.j0.j1.o.l.f
    public void h(k kVar) {
        this.r = kVar;
        f fVar = this.t;
        if (fVar != null) {
            fVar.h(kVar);
        }
    }

    public boolean h0() {
        k kVar = this.r;
        if (kVar != null) {
            return kVar.isPlaying();
        }
        return false;
    }

    public final void i0(d dVar, int i2) {
        AdvertAppInfo.ILegoAdvert iLegoAdvert;
        if (dVar == null) {
            return;
        }
        AdvertAppInfo v = dVar.v();
        int i3 = 2;
        if (v != null && (iLegoAdvert = v.W3) != null && iLegoAdvert.forFree()) {
            i3 = 102;
        }
        e.b().d(h.b(v, i3, i2));
        d.a.j0.j1.o.h.c.h(dVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: j0 */
    public AdCardViewHolder P(ViewGroup viewGroup) {
        d.a.j0.j1.o.l.e a2;
        if (this.m == null || (a2 = d.a.j0.j1.o.b.h().a(this.o, this.m, 2)) == null) {
            return null;
        }
        if (a2 instanceof k) {
            this.s.add((k) a2);
        }
        a2.setAfterClickSchemeListener(new C0529a());
        return new AdCardViewHolder(a2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: m0 */
    public AdCardViewHolder Q(ViewGroup viewGroup, d dVar) {
        if (dVar == null || dVar.p() == null) {
            return null;
        }
        this.n = dVar;
        this.m = dVar.p();
        return P(viewGroup);
    }

    public void n0() {
        for (k kVar : this.s) {
            if (kVar != null) {
                kVar.onDestroy();
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: p0 */
    public View W(int i2, View view, ViewGroup viewGroup, d dVar, AdCardViewHolder adCardViewHolder) {
        if (dVar == null || adCardViewHolder == null) {
            return null;
        }
        if (adCardViewHolder.b() instanceof d.a.j0.j1.o.l.h) {
            d.a.j0.j1.o.l.h hVar = (d.a.j0.j1.o.l.h) adCardViewHolder.b();
            hVar.setAutoPlayCallBack(this.p);
            hVar.setOnVideoContainerForegroundClickListener(this.q);
            hVar.setCurrentPlayCallBack(this);
        }
        dVar.t();
        if (adCardViewHolder.b() != null) {
            adCardViewHolder.b().setPosition(i2);
            adCardViewHolder.b().g(dVar.p());
        }
        return adCardViewHolder.a();
    }

    public void q0() {
        k kVar = this.r;
        if (kVar != null) {
            kVar.j();
        }
    }

    public void r0() {
        k kVar = this.r;
        if (kVar == null) {
            return;
        }
        kVar.stopPlay();
    }
}
