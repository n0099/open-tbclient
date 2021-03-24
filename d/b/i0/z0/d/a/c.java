package d.b.i0.z0.d.a;

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
import d.b.b.j.e.n;
import d.b.b.j.e.s;
import d.b.b.j.e.w;
import d.b.i.c0;
import d.b.i.k0;
import d.b.i.s0;
import d.b.i.u0.a;
import d.b.i0.i2.o;
import d.b.i0.x.b0;
import d.b.i0.x.e0.l;
/* loaded from: classes4.dex */
public class c extends d.b.b.j.e.a<l, AutoVideoCardViewHolder<l>> {
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
        @Override // d.b.i0.x.b0
        /* renamed from: d */
        public void a(View view, l lVar) {
            c.this.l0(view, lVar);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements w {
        public b() {
        }

        @Override // d.b.b.j.e.w
        public void f(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if ((nVar instanceof l) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                l lVar = (l) nVar;
                lVar.k = 1;
                if (c.this.r != null) {
                    c.this.r.a(threadCardViewHolder.a(), lVar);
                }
                d.b.i0.z0.d.e.a.b(lVar, view.getContext(), 18, false, d.b.i.e.a((s) viewGroup, view, i));
                threadCardViewHolder.b().o(new a.C1117a(1));
            }
        }
    }

    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.r = new a();
        this.m = tbPageContext;
    }

    public final o j0(l lVar) {
        if (lVar != null) {
            o oVar = new o();
            oVar.f56163a = Constants.VIA_REPORT_TYPE_START_GROUP;
            oVar.f56165c = lVar.l;
            if (lVar.n() != null) {
                oVar.f56166d = String.valueOf(lVar.n().c0());
                if (lVar.n().u1() != null) {
                    oVar.m = lVar.n().u1().video_md5;
                    oVar.p = String.valueOf(lVar.n().u1().is_vertical);
                }
            }
            oVar.k = lVar.B();
            oVar.f56168f = lVar.F();
            oVar.l = lVar.z();
            oVar.f56170h = lVar.O();
            oVar.f56167e = TbadkCoreApplication.getCurrentAccount();
            oVar.q = String.valueOf(lVar.E());
            oVar.r = String.valueOf(this.q);
            return oVar;
        }
        return null;
    }

    public final void l0(View view, l lVar) {
        s0 s0Var = this.p;
        if (s0Var == null || s0Var.p() == null || this.p.p().C() == null) {
            return;
        }
        if (view.getId() == this.p.p().C().getId()) {
            d.b.i0.z0.d.e.a.d(lVar, this.q);
        } else if (view.getId() == R.id.thread_card_root) {
            d.b.i0.z0.d.e.a.d(lVar, this.q);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: m0 */
    public AutoVideoCardViewHolder<l> R(ViewGroup viewGroup) {
        k0.b bVar = new k0.b(this.m.getPageActivity(), false);
        c0 c0Var = new c0(this.m.getPageActivity());
        this.p = c0Var;
        c0Var.x(this.n);
        this.p.u(ImageViewerConfig.FROM_GAME_VIDEO);
        this.p.y("2001");
        bVar.n(this.p);
        k0 k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.o);
        AutoVideoCardViewHolder<l> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(k);
        autoVideoCardViewHolder.k(this.n);
        k.p(this.r);
        k.r(18);
        c0(new b());
        return autoVideoCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: n0 */
    public View X(int i, View view, ViewGroup viewGroup, l lVar, AutoVideoCardViewHolder<l> autoVideoCardViewHolder) {
        if (lVar == null) {
            return autoVideoCardViewHolder.a();
        }
        if (autoVideoCardViewHolder == null) {
            return null;
        }
        lVar.U(lVar.position + 1);
        autoVideoCardViewHolder.b().q(i);
        d.b.i0.z0.d.e.a.c(lVar, this.q);
        autoVideoCardViewHolder.w(j0(lVar));
        autoVideoCardViewHolder.f(lVar);
        autoVideoCardViewHolder.b().onChangeSkinType(this.m, TbadkCoreApplication.getInst().getSkinType());
        autoVideoCardViewHolder.b().p(this.r);
        return autoVideoCardViewHolder.a();
    }

    public void o0(int i) {
        this.q = i;
    }

    public void onPause() {
        s0 s0Var = this.p;
        if (s0Var != null) {
            s0Var.s();
        }
    }

    public void p0(BdUniqueId bdUniqueId) {
        this.n = bdUniqueId;
    }

    public void q0(s sVar) {
        this.o = sVar;
    }
}
