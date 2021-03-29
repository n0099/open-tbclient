package d.b.i0.h2.c.q;

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
import d.b.b.j.e.n;
import d.b.b.j.e.s;
import d.b.b.j.e.w;
import d.b.i.a0;
import d.b.i.d;
import d.b.i.g0;
import d.b.i.k0;
import d.b.i.m0;
import d.b.i.u0.a;
import d.b.i0.h2.j.m;
import d.b.i0.x.b0;
import d.b.i0.x.e0.k;
import d.b.i0.x.e0.l;
/* loaded from: classes5.dex */
public class i extends d.b.b.j.e.a<l, AutoVideoCardViewHolder<l>> implements d.b.i0.m.f {
    public BdUniqueId m;
    public TbPageContext<?> n;
    public String o;
    public int p;
    public int q;
    public boolean r;
    public b0<l> s;

    /* loaded from: classes5.dex */
    public class a extends b0<l> {
        public a(i iVar) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.i0.x.b0
        /* renamed from: d */
        public void a(View view, l lVar) {
            if (view == null || lVar == null || lVar.n() == null) {
                return;
            }
            int id = view.getId();
            if (id != R.id.thread_card_root && id != R.id.video_seg_title) {
                if (id == R.id.operable_video_container) {
                    d.b.i0.h2.a.a(view, lVar, 4);
                    return;
                } else if (id == R.id.forum_name_text) {
                    d.b.i0.h2.a.a(view, lVar, 7);
                    return;
                } else {
                    return;
                }
            }
            d.b.i0.h2.a.a(view, lVar, 2);
        }
    }

    /* loaded from: classes5.dex */
    public class b implements d.b {
        public b(i iVar) {
        }

        @Override // d.b.i.d.b
        public void a(d.b.h0.r.q.a aVar, View view) {
            if (view == null || aVar == null || view.getId() == -1) {
                return;
            }
            int id = view.getId();
            if (id == R.id.user_name || id == R.id.user_avatar) {
                d.b.i0.h2.a.a(view, aVar, 1);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements w {
        public c() {
        }

        @Override // d.b.b.j.e.w
        public void f(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if ((nVar instanceof l) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                l lVar = (l) nVar;
                lVar.k = 1;
                if (i.this.s != null) {
                    i.this.s.a(threadCardViewHolder.a(), lVar);
                }
                ThreadCardUtils.jumpToPB((d.b.h0.r.q.a) lVar, view.getContext(), 4, false, d.b.i.e.a((s) viewGroup, view, i));
                threadCardViewHolder.b().o(new a.C1118a(1));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements ThreadCommentAndPraiseInfoLayout.i {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f55201a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f55202b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f55203c;

        public d(i iVar, ViewGroup viewGroup, View view, int i) {
            this.f55201a = viewGroup;
            this.f55202b = view;
            this.f55203c = i;
        }

        @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.i
        public void a(IntentConfig intentConfig) {
            if (intentConfig instanceof PbActivityConfig) {
                ((PbActivityConfig) intentConfig).setVideoOriginArea(d.b.i.e.a((s) this.f55201a, this.f55202b, this.f55203c));
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
    @Override // d.b.b.j.e.a
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
        bVar.l().d(d.b.b.e.p.l.g(this.f42358e, R.dimen.tbds25));
        bVar.h(new d.b.i.s(this.n.getPageActivity()));
        bVar.h(new g0(this.n.getPageActivity()));
        bVar.h(new a0(this.n.getPageActivity()));
        bVar.h(new d.b.i.k(this.n.getPageActivity()));
        m0 m0Var = new m0(this.n.getPageActivity());
        d.b.h0.r.q.e eVar = new d.b.h0.r.q.e();
        eVar.f50763b = 3;
        eVar.f50769h = 3;
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
    @Override // d.b.b.j.e.a
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
        d.b.i0.h2.a.b(lVar);
        return autoVideoCardViewHolder.a();
    }

    public void m0(boolean z) {
        this.r = z;
    }

    public void n0(int i) {
        this.q = i;
    }

    @Override // d.b.i0.m.f
    public void o(String str) {
        this.o = str;
    }

    public void o0(int i) {
    }

    public void p0(int i) {
        this.p = i;
    }
}
