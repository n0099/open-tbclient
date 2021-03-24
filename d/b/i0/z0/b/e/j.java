package d.b.i0.z0.b.e;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.AutoVideoCardViewHolder;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import d.b.i.k0;
import d.b.i0.x.b0;
/* loaded from: classes4.dex */
public class j extends d.b.b.j.e.a<d.b.i0.x.e0.l, ThreadCardViewHolder<d.b.i0.x.e0.l>> implements d.b.i0.m.f {
    public BdUniqueId m;
    public BdUniqueId n;
    public TbPageContext<?> o;
    public String p;
    public d.b.b.j.e.s q;
    public d.b.i.i r;
    public b0<d.b.i0.x.e0.l> s;

    /* loaded from: classes4.dex */
    public class a extends b0<d.b.i0.x.e0.l> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.i0.x.b0
        /* renamed from: d */
        public void a(View view, d.b.i0.x.e0.l lVar) {
            BdToast.i(j.this.o.getContext(), j.this.o.getString(R.string.video_is_checking), R.drawable.icon_pure_toast_mistake40_svg, true).q();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements d.b.b.j.e.w {
        public b() {
        }

        @Override // d.b.b.j.e.w
        public void f(View view, d.b.b.j.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            BdToast.i(j.this.o.getContext(), j.this.o.getString(R.string.video_is_checking), R.drawable.icon_pure_toast_mistake40_svg, true).q();
        }
    }

    public j(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.s = new a();
        this.o = tbPageContext;
        this.n = bdUniqueId2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: i0 */
    public ThreadCardViewHolder<d.b.i0.x.e0.l> O(ViewGroup viewGroup, d.b.i0.x.e0.l lVar) {
        k0.b bVar = new k0.b(this.o.getPageActivity(), false);
        d.b.i.i iVar = new d.b.i.i(this.o.getPageActivity());
        this.r = iVar;
        iVar.q(this.m);
        bVar.n(this.r);
        k0 k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.q);
        ThreadCardViewHolder<d.b.i0.x.e0.l> threadCardViewHolder = new ThreadCardViewHolder<>(k);
        threadCardViewHolder.k(this.m);
        k.p(this.s);
        k.r(1);
        c0(new b());
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: j0 */
    public AutoVideoCardViewHolder<d.b.i0.x.e0.l> R(ViewGroup viewGroup) {
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: l0 */
    public View U(int i, View view, ViewGroup viewGroup, d.b.i0.x.e0.l lVar, ThreadCardViewHolder<d.b.i0.x.e0.l> threadCardViewHolder) {
        if (lVar == null) {
            return threadCardViewHolder.a();
        }
        if (threadCardViewHolder == null) {
            return null;
        }
        lVar.U(lVar.position + 1);
        d.b.i0.x.t.b().a(lVar.A("c12351"));
        threadCardViewHolder.b().q(i);
        lVar.U = 0;
        if (threadCardViewHolder.b() instanceof d.b.i0.m.e) {
            threadCardViewHolder.b().setPage(this.p);
        }
        threadCardViewHolder.f(lVar);
        threadCardViewHolder.b().onChangeSkinType(this.o, TbadkCoreApplication.getInst().getSkinType());
        threadCardViewHolder.b().p(this.s);
        return threadCardViewHolder.a();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: m0 */
    public View X(int i, View view, ViewGroup viewGroup, d.b.i0.x.e0.l lVar, ThreadCardViewHolder<d.b.i0.x.e0.l> threadCardViewHolder) {
        return null;
    }

    public void n0(d.b.b.j.e.s sVar) {
        this.q = sVar;
    }

    @Override // d.b.i0.m.f
    public void o(String str) {
        this.p = str;
    }

    @Override // d.b.b.j.e.a
    public BdUniqueId v() {
        return d.b.i0.x.e0.b.O;
    }

    @Override // d.b.b.j.e.a
    public BdUniqueId w() {
        return d.b.i0.x.e0.b.M;
    }

    @Override // d.b.b.j.e.a
    public BdUniqueId x() {
        return d.b.i0.x.e0.b.N;
    }

    @Override // d.b.b.j.e.a
    public BdUniqueId y() {
        BdUniqueId bdUniqueId = this.n;
        return bdUniqueId != null ? bdUniqueId : d.b.i0.x.e0.b.F;
    }
}
