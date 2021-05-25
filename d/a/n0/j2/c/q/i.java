package d.a.n0.j2.c.q;

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
import d.a.c.j.e.n;
import d.a.c.j.e.s;
import d.a.c.j.e.w;
import d.a.i.a0;
import d.a.i.d;
import d.a.i.h0;
import d.a.i.l0;
import d.a.i.n0;
import d.a.i.v0.a;
import d.a.n0.j2.j.m;
import d.a.n0.z.b0;
import d.a.n0.z.e0.k;
import d.a.n0.z.e0.l;
/* loaded from: classes5.dex */
public class i extends d.a.c.j.e.a<l, AutoVideoCardViewHolder<l>> implements d.a.n0.o.f {
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
        @Override // d.a.n0.z.b0
        /* renamed from: d */
        public void a(View view, l lVar) {
            if (view == null || lVar == null || lVar.m() == null) {
                return;
            }
            int id = view.getId();
            if (id != R.id.thread_card_root && id != R.id.video_seg_title) {
                if (id == R.id.operable_video_container) {
                    d.a.n0.j2.a.a(view, lVar, 4);
                    return;
                } else if (id == R.id.forum_name_text) {
                    d.a.n0.j2.a.a(view, lVar, 7);
                    return;
                } else {
                    return;
                }
            }
            d.a.n0.j2.a.a(view, lVar, 2);
        }
    }

    /* loaded from: classes5.dex */
    public class b implements d.b {
        public b(i iVar) {
        }

        @Override // d.a.i.d.b
        public void a(d.a.m0.r.q.a aVar, View view) {
            if (view == null || aVar == null || view.getId() == -1) {
                return;
            }
            int id = view.getId();
            if (id == R.id.user_name || id == R.id.user_avatar) {
                d.a.n0.j2.a.a(view, aVar, 1);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements w {
        public c() {
        }

        @Override // d.a.c.j.e.w
        public void b(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            if ((nVar instanceof l) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                l lVar = (l) nVar;
                lVar.k = 1;
                if (i.this.s != null) {
                    i.this.s.a(threadCardViewHolder.a(), lVar);
                }
                ThreadCardUtils.jumpToPB((d.a.m0.r.q.a) lVar, view.getContext(), 4, false, d.a.i.e.a((s) viewGroup, view, i2));
                threadCardViewHolder.b().o(new a.C0544a(1));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements ThreadCommentAndPraiseInfoLayout.i {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f56312a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f56313b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f56314c;

        public d(i iVar, ViewGroup viewGroup, View view, int i2) {
            this.f56312a = viewGroup;
            this.f56313b = view;
            this.f56314c = i2;
        }

        @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.i
        public void a(IntentConfig intentConfig) {
            if (intentConfig instanceof PbActivityConfig) {
                ((PbActivityConfig) intentConfig).setVideoOriginArea(d.a.i.e.a((s) this.f56312a, this.f56313b, this.f56314c));
            }
        }
    }

    public i(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.p = 0;
        this.q = 0;
        this.s = new a(this);
        this.n = tbPageContext;
        f0();
    }

    public final void f0() {
        k.l0 = "c13542";
    }

    @Override // d.a.n0.o.f
    public void g(String str) {
        this.o = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: g0 */
    public AutoVideoCardViewHolder<l> P(ViewGroup viewGroup) {
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
        m mVar = new m(this.n.getPageActivity());
        mVar.x(this.m);
        mVar.u("profile");
        mVar.y(null);
        bVar.n(mVar);
        bVar.l().d(d.a.c.e.p.l.g(this.f39228e, R.dimen.tbds25));
        bVar.h(new d.a.i.s(this.n.getPageActivity()));
        bVar.h(new h0(this.n.getPageActivity()));
        bVar.h(new a0(this.n.getPageActivity()));
        bVar.h(new d.a.i.k(this.n.getPageActivity()));
        n0 n0Var = new n0(this.n.getPageActivity());
        d.a.m0.r.q.e eVar = new d.a.m0.r.q.e();
        eVar.f49994b = 3;
        eVar.f50000h = 3;
        n0Var.v(eVar);
        n0Var.w(8);
        n0Var.B("personalize_page");
        n0Var.A(6);
        n0Var.x(4);
        bVar.m(n0Var);
        l0 i3 = bVar.i();
        AutoVideoCardViewHolder<l> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(i3);
        autoVideoCardViewHolder.j(this.m);
        i3.p(this.s);
        i3.r(4);
        autoVideoCardViewHolder.q(this.q);
        Z(new c());
        return autoVideoCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: h0 */
    public View W(int i2, View view, ViewGroup viewGroup, l lVar, AutoVideoCardViewHolder autoVideoCardViewHolder) {
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
            autoVideoCardViewHolder.r();
        }
        if (autoVideoCardViewHolder.b().e() instanceof n0) {
            ((n0) autoVideoCardViewHolder.b().e()).z(new d(this, viewGroup, view, i2));
        }
        autoVideoCardViewHolder.f(lVar);
        autoVideoCardViewHolder.b().onChangeSkinType(this.n, TbadkCoreApplication.getInst().getSkinType());
        autoVideoCardViewHolder.b().p(this.s);
        d.a.n0.j2.a.b(lVar);
        return autoVideoCardViewHolder.a();
    }

    public void i0(boolean z) {
        this.r = z;
    }

    public void j0(int i2) {
        this.q = i2;
    }

    public void m0(int i2) {
    }

    public void n0(int i2) {
        this.p = i2;
    }
}
