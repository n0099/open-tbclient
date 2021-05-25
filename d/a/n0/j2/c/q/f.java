package d.a.n0.j2.c.q;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
import d.a.c.j.e.n;
import d.a.c.j.e.w;
import d.a.i.a;
import d.a.i.d;
import d.a.i.g0;
import d.a.i.l0;
import d.a.i.n0;
import d.a.i.p0;
import d.a.i.s0;
import d.a.i.v0.a;
import d.a.n0.z.b0;
import d.a.n0.z.e0.k;
/* loaded from: classes5.dex */
public class f extends d.a.c.j.e.a<k, ThreadCardViewHolder<k>> implements d.a.n0.o.f {
    public BdUniqueId m;
    public TbPageContext<?> n;
    public String o;
    public int p;
    public int q;
    public boolean r;
    public b0<k> s;

    /* loaded from: classes5.dex */
    public class a extends b0<k> {
        public a(f fVar) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.z.b0
        /* renamed from: d */
        public void a(View view, k kVar) {
            if (view == null || kVar == null || kVar.m() == null || view.getId() != R.id.forum_name_text) {
                return;
            }
            d.a.n0.j2.a.a(view, kVar, 7);
        }
    }

    /* loaded from: classes5.dex */
    public class b implements d.b {
        public b(f fVar) {
        }

        @Override // d.a.i.d.b
        public void a(d.a.m0.r.q.a aVar, View view) {
            if (view == null || aVar == null) {
                return;
            }
            int id = view.getId();
            if (id == R.id.user_name || id == R.id.user_avatar) {
                d.a.n0.j2.a.a(view, aVar, 1);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements a.InterfaceC0542a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g0 f56300a;

        public c(g0 g0Var) {
            this.f56300a = g0Var;
        }

        @Override // d.a.i.a.InterfaceC0542a
        public void a(d.a.m0.r.q.a aVar) {
            if (aVar == null || aVar.m() == null || aVar.m().s1 == null) {
                return;
            }
            ThreadCardUtils.jumpToPB(aVar.m().s1, f.this.f39228e, 4);
            d.a.n0.j2.a.a(this.f56300a.g(), aVar, 6);
        }
    }

    /* loaded from: classes5.dex */
    public class d implements a.InterfaceC0542a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ s0 f56302a;

        public d(s0 s0Var) {
            this.f56302a = s0Var;
        }

        @Override // d.a.i.a.InterfaceC0542a
        public void a(d.a.m0.r.q.a aVar) {
            if (aVar == null || aVar.m() == null || aVar.m().s1 == null) {
                return;
            }
            ThreadCardUtils.jumpToPB(aVar.m().s1, f.this.f39228e, 4);
            d.a.n0.j2.a.a(this.f56302a.g(), aVar, 6);
        }
    }

    /* loaded from: classes5.dex */
    public class e implements w {
        public e() {
        }

        @Override // d.a.c.j.e.w
        public void b(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            if ((nVar instanceof k) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                k kVar = (k) nVar;
                kVar.k = 1;
                if (f.this.s != null) {
                    f.this.s.a(threadCardViewHolder.a(), kVar);
                }
                ThreadCardUtils.jumpToPB((d.a.m0.r.q.a) kVar, view.getContext(), 4, false);
                threadCardViewHolder.b().o(new a.C0544a(1));
            }
        }
    }

    public f(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.p = 0;
        this.q = 0;
        this.s = new a(this);
        this.n = tbPageContext;
    }

    @Override // d.a.n0.o.f
    public void g(String str) {
        this.o = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: h0 */
    public ThreadCardViewHolder<k> P(ViewGroup viewGroup) {
        l0.b bVar = new l0.b(this.n.getPageActivity());
        d.a.i.d dVar = new d.a.i.d(this.n.getPageActivity());
        dVar.t(this.m);
        dVar.c(1024);
        dVar.c(32768);
        int i2 = this.p;
        if (i2 > 0) {
            dVar.b(i2);
        }
        dVar.r(false);
        dVar.w(false);
        dVar.s(new b(this));
        bVar.o(dVar);
        g0 g0Var = new g0(this.n);
        g0Var.n(Boolean.FALSE);
        g0Var.r(l.g(this.f39228e, R.dimen.tbds9));
        bVar.n(g0Var);
        bVar.l().d(l.g(this.f39228e, R.dimen.tbds25));
        g0 g0Var2 = new g0(this.n);
        g0Var2.n(Boolean.TRUE);
        g0Var2.y(UtilHelper.getDimenPixelSize(R.dimen.M_W_X005), UtilHelper.getDimenPixelSize(R.dimen.M_H_X004), UtilHelper.getDimenPixelSize(R.dimen.M_W_X005), UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
        g0Var2.w(new c(g0Var2));
        bVar.h(g0Var2);
        s0 s0Var = new s0(this.n.getPageActivity());
        s0Var.n(Boolean.TRUE);
        s0Var.w(new d(s0Var));
        bVar.h(s0Var);
        bVar.h(new p0(this.n.getPageActivity()));
        bVar.h(new d.a.i.k(this.n.getPageActivity()));
        n0 n0Var = new n0(this.n.getPageActivity());
        d.a.m0.r.q.e eVar = new d.a.m0.r.q.e();
        eVar.f49994b = 3;
        eVar.f50000h = 3;
        n0Var.v(eVar);
        n0Var.w(8);
        n0Var.A(6);
        n0Var.x(4);
        bVar.m(n0Var);
        l0 i3 = bVar.i();
        i3.r(4);
        ThreadCardViewHolder<k> threadCardViewHolder = new ThreadCardViewHolder<>(i3);
        threadCardViewHolder.j(this.m);
        threadCardViewHolder.q(this.q);
        Z(new e());
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: i0 */
    public View W(int i2, View view, ViewGroup viewGroup, k kVar, ThreadCardViewHolder<k> threadCardViewHolder) {
        if (kVar == null || threadCardViewHolder == null || threadCardViewHolder.a() == null || kVar.f63459e == null) {
            return null;
        }
        kVar.U(kVar.position + 1);
        threadCardViewHolder.b().setPage(this.o);
        if (!this.r) {
            threadCardViewHolder.r();
        }
        threadCardViewHolder.f(kVar);
        threadCardViewHolder.b().onChangeSkinType(this.n, TbadkCoreApplication.getInst().getSkinType());
        threadCardViewHolder.b().p(this.s);
        d.a.n0.j2.a.b(kVar);
        return threadCardViewHolder.a();
    }

    public void j0(boolean z) {
        this.r = z;
    }

    public void m0(int i2) {
        this.q = i2;
    }

    public void n0(int i2) {
    }

    public void p0(int i2) {
        this.p = i2;
    }
}
