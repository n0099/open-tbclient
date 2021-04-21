package d.b.j0.i2.c.q;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.AutoVideoCardViewHolder;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tieba.R;
import d.b.c.j.e.n;
import d.b.c.j.e.s;
import d.b.c.j.e.w;
import d.b.i.a0;
import d.b.i.d;
import d.b.i.g0;
import d.b.i.k0;
import d.b.i.m0;
import d.b.i.u0.a;
import d.b.j0.i2.j.m;
import d.b.j0.x.b0;
import d.b.j0.x.e0.k;
import d.b.j0.x.e0.l;
/* loaded from: classes3.dex */
public class i extends d.b.c.j.e.a<l, AutoVideoCardViewHolder<l>> implements d.b.j0.m.f {
    public BdUniqueId m;
    public TbPageContext<?> n;
    public String o;
    public int p;
    public int q;
    public boolean r;
    public b0<l> s;

    /* loaded from: classes3.dex */
    public class a extends b0<l> {
        public a(i iVar) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.j0.x.b0
        /* renamed from: d */
        public void a(View view, l lVar) {
            if (view == null || lVar == null || lVar.n() == null) {
                return;
            }
            int id = view.getId();
            if (id != R.id.thread_card_root && id != R.id.video_seg_title) {
                if (id == R.id.operable_video_container) {
                    d.b.j0.i2.a.a(view, lVar, 4);
                    return;
                } else if (id == R.id.forum_name_text) {
                    d.b.j0.i2.a.a(view, lVar, 7);
                    return;
                } else {
                    return;
                }
            }
            d.b.j0.i2.a.a(view, lVar, 2);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.b {
        public b(i iVar) {
        }

        @Override // d.b.i.d.b
        public void a(d.b.i0.r.q.a aVar, View view) {
            if (view == null || aVar == null || view.getId() == -1) {
                return;
            }
            int id = view.getId();
            if (id == R.id.user_name || id == R.id.user_avatar) {
                d.b.j0.i2.a.a(view, aVar, 1);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements w {
        public c() {
        }

        @Override // d.b.c.j.e.w
        public void f(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if ((nVar instanceof l) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                l lVar = (l) nVar;
                lVar.k = 1;
                if (i.this.s != null) {
                    i.this.s.a(threadCardViewHolder.a(), lVar);
                }
                ThreadCardUtils.jumpToPB((d.b.i0.r.q.a) lVar, view.getContext(), 4, false, d.b.i.e.a((s) viewGroup, view, i));
                threadCardViewHolder.b().o(new a.C1072a(1));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements ThreadCommentAndPraiseInfoLayout.i {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f57480a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f57481b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f57482c;

        public d(i iVar, ViewGroup viewGroup, View view, int i) {
            this.f57480a = viewGroup;
            this.f57481b = view;
            this.f57482c = i;
        }

        @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.i
        public void a(IntentConfig intentConfig) {
            if (intentConfig instanceof PbActivityConfig) {
                ((PbActivityConfig) intentConfig).setVideoOriginArea(d.b.i.e.a((s) this.f57480a, this.f57481b, this.f57482c));
            }
        }
    }

    public i(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.p = 0;
        this.q = 0;
        this.s = new a(this);
        this.n = tbPageContext;
        i0();
    }

    public final void i0() {
        k.k0 = "c13542";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: j0 */
    public AutoVideoCardViewHolder<l> R(ViewGroup viewGroup) {
        k0.b bVar = new k0.b(this.n.getPageActivity());
        d.b.i.d dVar = new d.b.i.d(this.n.getPageActivity());
        dVar.t(this.m);
        dVar.c(1024);
        dVar.c(32768);
        int i = this.p;
        if (i > 0) {
            dVar.b(i);
        }
        dVar.r(false);
        dVar.w(false);
        dVar.s(new b(this));
        bVar.o(dVar);
        m mVar = new m(this.n.getPageActivity());
        mVar.x(this.m);
        mVar.u("profile");
        mVar.y(null);
        bVar.n(mVar);
        bVar.l().d(d.b.c.e.p.l.g(this.f43095e, R.dimen.tbds25));
        bVar.h(new d.b.i.s(this.n.getPageActivity()));
        bVar.h(new g0(this.n.getPageActivity()));
        bVar.h(new a0(this.n.getPageActivity()));
        bVar.h(new d.b.i.k(this.n.getPageActivity()));
        m0 m0Var = new m0(this.n.getPageActivity());
        d.b.i0.r.q.e eVar = new d.b.i0.r.q.e();
        eVar.f51506b = 3;
        eVar.f51512h = 3;
        m0Var.v(eVar);
        m0Var.w(8);
        m0Var.B("personalize_page");
        m0Var.A(6);
        m0Var.x(4);
        bVar.m(m0Var);
        k0 i2 = bVar.i();
        AutoVideoCardViewHolder<l> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(i2);
        autoVideoCardViewHolder.k(this.m);
        i2.p(this.s);
        i2.r(4);
        autoVideoCardViewHolder.r(this.q);
        c0(new c());
        return autoVideoCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: l0 */
    public View X(int i, View view, ViewGroup viewGroup, l lVar, AutoVideoCardViewHolder autoVideoCardViewHolder) {
        if (lVar == null) {
            return autoVideoCardViewHolder.a();
        }
        if (autoVideoCardViewHolder == null) {
            return null;
        }
        lVar.U(lVar.position + 1);
        if (autoVideoCardViewHolder.b() != null) {
            autoVideoCardViewHolder.b().setPage(this.o);
        }
        if (!this.r) {
            autoVideoCardViewHolder.s();
        }
        if (autoVideoCardViewHolder.b().e() instanceof m0) {
            ((m0) autoVideoCardViewHolder.b().e()).z(new d(this, viewGroup, view, i));
        }
        autoVideoCardViewHolder.f(lVar);
        autoVideoCardViewHolder.b().onChangeSkinType(this.n, TbadkCoreApplication.getInst().getSkinType());
        autoVideoCardViewHolder.b().p(this.s);
        d.b.j0.i2.a.b(lVar);
        return autoVideoCardViewHolder.a();
    }

    public void m0(boolean z) {
        this.r = z;
    }

    public void n0(int i) {
        this.q = i;
    }

    @Override // d.b.j0.m.f
    public void o(String str) {
        this.o = str;
    }

    public void o0(int i) {
    }

    public void p0(int i) {
        this.p = i;
    }
}
