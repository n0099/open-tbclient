package d.a.j0.x1.d.c;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.Align;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tieba.R;
import d.a.c.j.e.n;
import d.a.c.j.e.w;
import d.a.i.d;
import d.a.i.k0;
import d.a.i.m0;
import d.a.i.o0;
import d.a.i.p0;
import d.a.i.u0.a;
import d.a.j0.x.b0;
/* loaded from: classes3.dex */
public class i extends d.a.j0.x1.d.c.a<d.a.j0.x.e0.k, ThreadCardViewHolder<d.a.j0.x.e0.k>> implements d.a.j0.m.f {
    public BdUniqueId n;
    public TbPageContext<?> o;
    public String p;
    public boolean q;
    public b0<d.a.j0.x.e0.k> r;

    /* loaded from: classes3.dex */
    public class a extends b0<d.a.j0.x.e0.k> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.j0.x.b0
        /* renamed from: d */
        public void a(View view, d.a.j0.x.e0.k kVar) {
            d.a.j0.x1.c.b(i.this, kVar);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.b {
        public b(i iVar) {
        }

        @Override // d.a.i.d.b
        public void a(d.a.i0.r.q.a aVar, View view) {
            if (aVar != null) {
                if (view.getId() == R.id.user_name) {
                    aVar.objType = 3;
                } else if (view.getId() == R.id.user_avatar) {
                    aVar.objType = 4;
                } else {
                    aVar.objType = 1;
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements w {
        public c() {
        }

        @Override // d.a.c.j.e.w
        public void b(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            if ((nVar instanceof d.a.j0.x.e0.k) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                d.a.j0.x.e0.k kVar = (d.a.j0.x.e0.k) nVar;
                kVar.k = 1;
                if (i.this.r != null) {
                    i.this.r.a(threadCardViewHolder.a(), kVar);
                }
                ThreadCardUtils.jumpToPB((d.a.i0.r.q.a) kVar, view.getContext(), 17, false);
                threadCardViewHolder.b().o(new a.C1011a(1));
            }
        }
    }

    public i(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.q = true;
        this.r = new a();
        this.o = tbPageContext;
    }

    @Override // d.a.j0.m.f
    public void g(String str) {
        this.p = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: h0 */
    public ThreadCardViewHolder<d.a.j0.x.e0.k> P(ViewGroup viewGroup) {
        k0.b bVar = new k0.b(this.o.getPageActivity());
        d.a.i.d dVar = new d.a.i.d(this.o.getPageActivity());
        dVar.t(this.n);
        dVar.b(128);
        dVar.c(1024);
        dVar.s(new b(this));
        bVar.o(dVar);
        p0 p0Var = new p0(this.o.getPageActivity());
        bVar.n(p0Var);
        p0Var.u(2);
        bVar.h(new o0(this.o.getPageActivity()));
        bVar.h(new d.a.i.k(this.o.getPageActivity()));
        d.a.i.n nVar = new d.a.i.n(this.o.getPageActivity());
        nVar.x(this.q);
        nVar.w(ImageViewerConfig.FROM_CONCERN);
        bVar.h(nVar);
        m0 m0Var = new m0(this.o.getPageActivity());
        d.a.i0.r.q.e eVar = new d.a.i0.r.q.e();
        eVar.f49131b = 9;
        eVar.f49137h = 9;
        m0Var.v(eVar);
        m0Var.w(9);
        m0Var.A(4);
        m0Var.x(17);
        bVar.m(m0Var);
        k0 i2 = bVar.i();
        i2.r(17);
        ThreadCardViewHolder<d.a.j0.x.e0.k> threadCardViewHolder = new ThreadCardViewHolder<>(i2);
        threadCardViewHolder.j(this.n);
        Z(new c());
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: i0 */
    public View W(int i2, View view, ViewGroup viewGroup, d.a.j0.x.e0.k kVar, ThreadCardViewHolder<d.a.j0.x.e0.k> threadCardViewHolder) {
        if (kVar == null || threadCardViewHolder == null || threadCardViewHolder.a() == null || kVar.f62455e == null) {
            return null;
        }
        kVar.U(kVar.position + 1);
        threadCardViewHolder.b().setPage(this.p);
        threadCardViewHolder.s(true, Align.ALIGN_RIGHT_TOP);
        threadCardViewHolder.f(kVar);
        threadCardViewHolder.b().onChangeSkinType(this.o, TbadkCoreApplication.getInst().getSkinType());
        threadCardViewHolder.b().p(this.r);
        d.a.j0.x1.c.c(this, kVar);
        return threadCardViewHolder.a();
    }
}
