package d.a.o0.j2.c.q;

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
import d.a.c.k.e.n;
import d.a.c.k.e.s;
import d.a.c.k.e.w;
import d.a.i.a0;
import d.a.i.d;
import d.a.i.h0;
import d.a.i.l0;
import d.a.i.n0;
import d.a.i.v0.a;
import d.a.o0.j2.j.m;
import d.a.o0.z.b0;
import d.a.o0.z.e0.k;
import d.a.o0.z.e0.l;
/* loaded from: classes5.dex */
public class i extends d.a.c.k.e.a<l, AutoVideoCardViewHolder<l>> implements d.a.o0.o.f {
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
        @Override // d.a.o0.z.b0
        /* renamed from: d */
        public void a(View view, l lVar) {
            if (view == null || lVar == null || lVar.i() == null) {
                return;
            }
            int id = view.getId();
            if (id != R.id.thread_card_root && id != R.id.video_seg_title) {
                if (id == R.id.operable_video_container) {
                    d.a.o0.j2.a.a(view, lVar, 4);
                    return;
                } else if (id == R.id.forum_name_text) {
                    d.a.o0.j2.a.a(view, lVar, 7);
                    return;
                } else {
                    return;
                }
            }
            d.a.o0.j2.a.a(view, lVar, 2);
        }
    }

    /* loaded from: classes5.dex */
    public class b implements d.b {
        public b(i iVar) {
        }

        @Override // d.a.i.d.b
        public void a(d.a.n0.r.q.a aVar, View view) {
            if (view == null || aVar == null || view.getId() == -1) {
                return;
            }
            int id = view.getId();
            if (id == R.id.user_name || id == R.id.user_avatar) {
                d.a.o0.j2.a.a(view, aVar, 1);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements w {
        public c() {
        }

        @Override // d.a.c.k.e.w
        public void b(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            if ((nVar instanceof l) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                l lVar = (l) nVar;
                lVar.k = 1;
                if (i.this.s != null) {
                    i.this.s.a(threadCardViewHolder.a(), lVar);
                }
                ThreadCardUtils.jumpToPB((d.a.n0.r.q.a) lVar, view.getContext(), 4, false, d.a.i.e.a((s) viewGroup, view, i2));
                threadCardViewHolder.b().o(new a.C0602a(1));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements ThreadCommentAndPraiseInfoLayout.i {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f60126a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f60127b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f60128c;

        public d(i iVar, ViewGroup viewGroup, View view, int i2) {
            this.f60126a = viewGroup;
            this.f60127b = view;
            this.f60128c = i2;
        }

        @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.i
        public void a(IntentConfig intentConfig) {
            if (intentConfig instanceof PbActivityConfig) {
                ((PbActivityConfig) intentConfig).setVideoOriginArea(d.a.i.e.a((s) this.f60126a, this.f60127b, this.f60128c));
            }
        }
    }

    public i(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.p = 0;
        this.q = 0;
        this.s = new a(this);
        this.n = tbPageContext;
        g0();
    }

    @Override // d.a.o0.o.f
    public void g(String str) {
        this.o = str;
    }

    public final void g0() {
        k.q0 = "c13542";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: h0 */
    public AutoVideoCardViewHolder<l> Q(ViewGroup viewGroup) {
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
        bVar.l().d(d.a.c.e.p.l.g(this.f43012e, R.dimen.tbds25));
        bVar.h(new d.a.i.s(this.n.getPageActivity()));
        bVar.h(new h0(this.n.getPageActivity()));
        bVar.h(new a0(this.n.getPageActivity()));
        bVar.h(new d.a.i.k(this.n.getPageActivity()));
        n0 n0Var = new n0(this.n.getPageActivity());
        d.a.n0.r.q.e eVar = new d.a.n0.r.q.e();
        eVar.f53777b = 3;
        eVar.f53783h = 3;
        n0Var.v(eVar);
        n0Var.w(8);
        n0Var.B("personalize_page");
        n0Var.A(6);
        n0Var.x(4);
        bVar.m(n0Var);
        l0 i3 = bVar.i();
        AutoVideoCardViewHolder<l> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(i3);
        autoVideoCardViewHolder.k(this.m);
        i3.p(this.s);
        i3.r(4);
        autoVideoCardViewHolder.r(this.q);
        a0(new c());
        return autoVideoCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: i0 */
    public View X(int i2, View view, ViewGroup viewGroup, l lVar, AutoVideoCardViewHolder autoVideoCardViewHolder) {
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
        if (autoVideoCardViewHolder.b().e() instanceof n0) {
            ((n0) autoVideoCardViewHolder.b().e()).z(new d(this, viewGroup, view, i2));
        }
        autoVideoCardViewHolder.f(lVar);
        autoVideoCardViewHolder.b().onChangeSkinType(this.n, TbadkCoreApplication.getInst().getSkinType());
        autoVideoCardViewHolder.b().p(this.s);
        d.a.o0.j2.a.b(lVar);
        return autoVideoCardViewHolder.a();
    }

    public void j0(boolean z) {
        this.r = z;
    }

    public void k0(int i2) {
        this.q = i2;
    }

    public void l0(int i2) {
    }

    public void m0(int i2) {
        this.p = i2;
    }
}
