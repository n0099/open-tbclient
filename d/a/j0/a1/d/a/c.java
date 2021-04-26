package d.a.j0.a1.d.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.AutoVideoCardViewHolder;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.tencent.connect.common.Constants;
import d.a.c.j.e.n;
import d.a.c.j.e.s;
import d.a.c.j.e.w;
import d.a.i.c0;
import d.a.i.k0;
import d.a.i.s0;
import d.a.i.u0.a;
import d.a.j0.j2.o;
import d.a.j0.x.b0;
import d.a.j0.x.e0.l;
/* loaded from: classes4.dex */
public class c extends d.a.c.j.e.a<l, AutoVideoCardViewHolder<l>> {
    public TbPageContext m;
    public BdUniqueId n;
    public s o;
    public s0 p;
    public int q;
    public b0<l> r;

    /* loaded from: classes4.dex */
    public class a extends b0<l> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.j0.x.b0
        /* renamed from: d */
        public void a(View view, l lVar) {
            c.this.h0(view, lVar);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements w {
        public b() {
        }

        @Override // d.a.c.j.e.w
        public void b(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            if ((nVar instanceof l) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                l lVar = (l) nVar;
                lVar.k = 1;
                if (c.this.r != null) {
                    c.this.r.a(threadCardViewHolder.a(), lVar);
                }
                d.a.j0.a1.d.e.a.b(lVar, view.getContext(), 18, false, d.a.i.e.a((s) viewGroup, view, i2));
                threadCardViewHolder.b().o(new a.C1011a(1));
            }
        }
    }

    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.r = new a();
        this.m = tbPageContext;
    }

    public final o g0(l lVar) {
        if (lVar != null) {
            o oVar = new o();
            oVar.f56011a = Constants.VIA_REPORT_TYPE_START_GROUP;
            oVar.f56013c = lVar.l;
            if (lVar.m() != null) {
                oVar.f56014d = String.valueOf(lVar.m().c0());
                if (lVar.m().u1() != null) {
                    oVar.m = lVar.m().u1().video_md5;
                    oVar.p = String.valueOf(lVar.m().u1().is_vertical);
                }
            }
            oVar.k = lVar.B();
            oVar.f56016f = lVar.F();
            oVar.l = lVar.z();
            oVar.f56018h = lVar.O();
            oVar.f56015e = TbadkCoreApplication.getCurrentAccount();
            oVar.q = String.valueOf(lVar.E());
            oVar.r = String.valueOf(this.q);
            return oVar;
        }
        return null;
    }

    public final void h0(View view, l lVar) {
        s0 s0Var = this.p;
        if (s0Var == null || s0Var.p() == null || this.p.p().E() == null) {
            return;
        }
        if (view.getId() == this.p.p().E().getId()) {
            d.a.j0.a1.d.e.a.d(lVar, this.q);
        } else if (view.getId() == R.id.thread_card_root) {
            d.a.j0.a1.d.e.a.d(lVar, this.q);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: i0 */
    public AutoVideoCardViewHolder<l> P(ViewGroup viewGroup) {
        k0.b bVar = new k0.b(this.m.getPageActivity(), false);
        c0 c0Var = new c0(this.m.getPageActivity());
        this.p = c0Var;
        c0Var.x(this.n);
        this.p.u(ImageViewerConfig.FROM_GAME_VIDEO);
        this.p.y("2001");
        bVar.n(this.p);
        k0 k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.o);
        AutoVideoCardViewHolder<l> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(k);
        autoVideoCardViewHolder.j(this.n);
        k.p(this.r);
        k.r(18);
        Z(new b());
        return autoVideoCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: j0 */
    public View W(int i2, View view, ViewGroup viewGroup, l lVar, AutoVideoCardViewHolder<l> autoVideoCardViewHolder) {
        if (lVar == null) {
            return autoVideoCardViewHolder.a();
        }
        if (autoVideoCardViewHolder == null) {
            return null;
        }
        lVar.U(lVar.position + 1);
        autoVideoCardViewHolder.b().q(i2);
        d.a.j0.a1.d.e.a.c(lVar, this.q);
        autoVideoCardViewHolder.u(g0(lVar));
        autoVideoCardViewHolder.f(lVar);
        autoVideoCardViewHolder.b().onChangeSkinType(this.m, TbadkCoreApplication.getInst().getSkinType());
        autoVideoCardViewHolder.b().p(this.r);
        return autoVideoCardViewHolder.a();
    }

    public void m0(int i2) {
        this.q = i2;
    }

    public void n0(BdUniqueId bdUniqueId) {
        this.n = bdUniqueId;
    }

    public void onPause() {
        s0 s0Var = this.p;
        if (s0Var != null) {
            s0Var.s();
        }
    }

    public void p0(s sVar) {
        this.o = sVar;
    }
}
