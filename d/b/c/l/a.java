package d.b.c.l;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.afd.adapter.AdCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.lego.card.model.ICardInfo;
import d.b.c.d;
import d.b.i0.i1.o.l.f;
import d.b.i0.i1.o.l.k;
import d.b.i0.p0.o2.c;
import d.b.i0.r2.b0.e;
import d.b.i0.r2.b0.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class a extends d.b.b.j.e.a<d, AdCardViewHolder> implements f {
    public ICardInfo m;
    public d n;
    public TbPageContext o;
    public d.b.i0.p0.i1.a p;
    public c q;
    public k r;
    public List<k> s;
    public f t;

    /* renamed from: d.b.c.l.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0556a implements d.b.i0.i1.o.a {
        public C0556a() {
        }

        @Override // d.b.i0.i1.o.a
        public void a(int i, HashMap<String, Object> hashMap) {
            a aVar = a.this;
            aVar.m0(aVar.n, a.this.n.n());
        }

        @Override // d.b.i0.i1.o.a
        public void b(String str, String str2, HashMap<String, Object> hashMap) {
            a aVar = a.this;
            aVar.m0(aVar.n, a.this.n.n());
        }
    }

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, d.b.i0.p0.i1.a aVar, c cVar, f fVar) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.s = new ArrayList();
        this.o = tbPageContext;
        this.p = aVar;
        this.q = cVar;
        this.t = fVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: j0 */
    public View I(int i, View view, ViewGroup viewGroup, d dVar) {
        this.n = dVar;
        this.m = dVar.o();
        return super.I(i, view, viewGroup, dVar);
    }

    public boolean l0() {
        k kVar = this.r;
        if (kVar != null) {
            return kVar.isPlaying();
        }
        return false;
    }

    public final void m0(d dVar, int i) {
        AdvertAppInfo.ILegoAdvert iLegoAdvert;
        if (dVar == null) {
            return;
        }
        AdvertAppInfo v = dVar.v();
        int i2 = 2;
        if (v != null && (iLegoAdvert = v.W3) != null && iLegoAdvert.forFree()) {
            i2 = 102;
        }
        e.b().d(h.b(v, i2, i));
        d.b.i0.i1.o.h.c.h(dVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: n0 */
    public AdCardViewHolder R(ViewGroup viewGroup) {
        d.b.i0.i1.o.l.e a2;
        if (this.m == null || (a2 = d.b.i0.i1.o.b.h().a(this.o, this.m, 2)) == null) {
            return null;
        }
        if (a2 instanceof k) {
            this.s.add((k) a2);
        }
        a2.setAfterClickSchemeListener(new C0556a());
        return new AdCardViewHolder(a2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: o0 */
    public AdCardViewHolder S(ViewGroup viewGroup, d dVar) {
        if (dVar == null || dVar.o() == null) {
            return null;
        }
        this.n = dVar;
        this.m = dVar.o();
        return R(viewGroup);
    }

    public void p0() {
        for (k kVar : this.s) {
            if (kVar != null) {
                kVar.onDestroy();
            }
        }
    }

    @Override // d.b.i0.i1.o.l.f
    public void q(k kVar) {
        this.r = kVar;
        f fVar = this.t;
        if (fVar != null) {
            fVar.q(kVar);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: q0 */
    public View X(int i, View view, ViewGroup viewGroup, d dVar, AdCardViewHolder adCardViewHolder) {
        if (dVar == null || adCardViewHolder == null) {
            return null;
        }
        if (adCardViewHolder.b() instanceof d.b.i0.i1.o.l.h) {
            d.b.i0.i1.o.l.h hVar = (d.b.i0.i1.o.l.h) adCardViewHolder.b();
            hVar.setAutoPlayCallBack(this.p);
            hVar.setOnVideoContainerForegroundClickListener(this.q);
            hVar.setCurrentPlayCallBack(this);
        }
        dVar.t();
        if (adCardViewHolder.b() != null) {
            adCardViewHolder.b().setPosition(i);
            adCardViewHolder.b().c(dVar.o());
        }
        return adCardViewHolder.a();
    }

    public void r0() {
        k kVar = this.r;
        if (kVar != null) {
            kVar.j();
        }
    }

    public void s0() {
        k kVar = this.r;
        if (kVar == null) {
            return;
        }
        kVar.stopPlay();
    }
}
