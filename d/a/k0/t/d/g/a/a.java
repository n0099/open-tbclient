package d.a.k0.t.d.g.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.ala.alasquare.subtablist.view.AlaSubListGameDoubleViewHolder;
import d.a.j0.r.q.a2;
import d.a.k0.t.d.a.c;
import d.a.k0.t.d.g.d.f;
/* loaded from: classes4.dex */
public class a extends d.a.c.j.e.a<d.a.k0.t.d.g.b.a, AlaSubListGameDoubleViewHolder> {
    public TbPageContext<?> m;
    public f n;
    public boolean o;
    public d.a.k0.t.d.g.d.a p;
    public int q;
    public int r;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), d.a.k0.t.d.g.b.a.f61495g);
        this.o = false;
        this.m = tbPageContext;
    }

    public final void e0(d.a.k0.t.d.g.b.a aVar) {
        if (aVar == null) {
            return;
        }
        int i2 = this.r;
        if (i2 == 1) {
            if (aVar.f61496e != null) {
                d.a.k0.t.d.d.a c2 = d.a.k0.t.d.d.a.c();
                d.a.k0.t.d.d.a c3 = d.a.k0.t.d.d.a.c();
                int i3 = this.q;
                c cVar = aVar.f61496e;
                c2.a(c3.e(i3, "c12117", cVar.f61126e, cVar.f61127f, cVar.h()));
            }
            if (aVar.f61497f != null) {
                d.a.k0.t.d.d.a c4 = d.a.k0.t.d.d.a.c();
                d.a.k0.t.d.d.a c5 = d.a.k0.t.d.d.a.c();
                int i4 = this.q;
                c cVar2 = aVar.f61497f;
                c4.a(c5.e(i4, "c12117", cVar2.f61126e, cVar2.f61127f, cVar2.h()));
            }
        } else if (i2 == 2) {
            c cVar3 = aVar.f61496e;
            if (cVar3 != null && cVar3.h() != null && aVar.f61496e.h().q1() != null) {
                a2 h2 = aVar.f61496e.h();
                TiebaStatic.log(new StatisticItem("c12115").param("obj_id", h2.q1().live_id).param(TiebaStatic.Params.OBJ_PARAM3, h2.q1().appId).param("locate_type", aVar.f61496e.f61127f));
            }
            c cVar4 = aVar.f61497f;
            if (cVar4 == null || cVar4.h() == null || aVar.f61497f.h().q1() == null) {
                return;
            }
            a2 h3 = aVar.f61497f.h();
            TiebaStatic.log(new StatisticItem("c12115").param("obj_id", h3.q1().live_id).param(TiebaStatic.Params.OBJ_PARAM3, h3.q1().appId).param("locate_type", aVar.f61497f.f61127f));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: f0 */
    public AlaSubListGameDoubleViewHolder P(ViewGroup viewGroup) {
        this.p = new d.a.k0.t.d.g.d.a(this.m, this.o);
        return new AlaSubListGameDoubleViewHolder(this.p);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: g0 */
    public View W(int i2, View view, ViewGroup viewGroup, d.a.k0.t.d.g.b.a aVar, AlaSubListGameDoubleViewHolder alaSubListGameDoubleViewHolder) {
        e0(aVar);
        alaSubListGameDoubleViewHolder.f13998a.m(aVar);
        alaSubListGameDoubleViewHolder.f13998a.t(this.n);
        return alaSubListGameDoubleViewHolder.a();
    }

    public void h0(int i2) {
        this.r = i2;
    }

    public void i0(int i2) {
        this.q = i2;
    }

    public void j0(f fVar) {
        this.n = fVar;
    }

    public void m0(boolean z) {
        this.o = z;
    }
}
