package d.b.j0.t.d.g.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.ala.alasquare.subtablist.view.AlaSubListGameDoubleViewHolder;
import d.b.i0.r.q.a2;
import d.b.j0.t.d.a.c;
import d.b.j0.t.d.g.d.g;
/* loaded from: classes4.dex */
public class a extends d.b.c.j.e.a<d.b.j0.t.d.g.b.a, AlaSubListGameDoubleViewHolder> {
    public TbPageContext<?> m;
    public g n;
    public boolean o;
    public d.b.j0.t.d.g.d.a p;
    public int q;
    public int r;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), d.b.j0.t.d.g.b.a.f62589g);
        this.o = false;
        this.m = tbPageContext;
    }

    public final void h0(d.b.j0.t.d.g.b.a aVar) {
        if (aVar == null) {
            return;
        }
        int i = this.r;
        if (i == 1) {
            if (aVar.f62590e != null) {
                d.b.j0.t.d.d.a c2 = d.b.j0.t.d.d.a.c();
                d.b.j0.t.d.d.a c3 = d.b.j0.t.d.d.a.c();
                int i2 = this.q;
                c cVar = aVar.f62590e;
                c2.a(c3.e(i2, "c12117", cVar.f62224e, cVar.f62225f, cVar.g()));
            }
            if (aVar.f62591f != null) {
                d.b.j0.t.d.d.a c4 = d.b.j0.t.d.d.a.c();
                d.b.j0.t.d.d.a c5 = d.b.j0.t.d.d.a.c();
                int i3 = this.q;
                c cVar2 = aVar.f62591f;
                c4.a(c5.e(i3, "c12117", cVar2.f62224e, cVar2.f62225f, cVar2.g()));
            }
        } else if (i == 2) {
            c cVar3 = aVar.f62590e;
            if (cVar3 != null && cVar3.g() != null && aVar.f62590e.g().q1() != null) {
                a2 g2 = aVar.f62590e.g();
                TiebaStatic.log(new StatisticItem("c12115").param("obj_id", g2.q1().live_id).param(TiebaStatic.Params.OBJ_PARAM3, g2.q1().appId).param("locate_type", aVar.f62590e.f62225f));
            }
            c cVar4 = aVar.f62591f;
            if (cVar4 == null || cVar4.g() == null || aVar.f62591f.g().q1() == null) {
                return;
            }
            a2 g3 = aVar.f62591f.g();
            TiebaStatic.log(new StatisticItem("c12115").param("obj_id", g3.q1().live_id).param(TiebaStatic.Params.OBJ_PARAM3, g3.q1().appId).param("locate_type", aVar.f62591f.f62225f));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: i0 */
    public AlaSubListGameDoubleViewHolder R(ViewGroup viewGroup) {
        this.p = new d.b.j0.t.d.g.d.a(this.m, this.o);
        return new AlaSubListGameDoubleViewHolder(this.p);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: j0 */
    public View X(int i, View view, ViewGroup viewGroup, d.b.j0.t.d.g.b.a aVar, AlaSubListGameDoubleViewHolder alaSubListGameDoubleViewHolder) {
        h0(aVar);
        alaSubListGameDoubleViewHolder.f14609a.n(aVar);
        alaSubListGameDoubleViewHolder.f14609a.v(this.n);
        return alaSubListGameDoubleViewHolder.a();
    }

    public void l0(int i) {
        this.r = i;
    }

    public void m0(int i) {
        this.q = i;
    }

    public void n0(g gVar) {
        this.n = gVar;
    }

    public void o0(boolean z) {
        this.o = z;
    }
}
