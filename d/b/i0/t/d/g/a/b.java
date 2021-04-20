package d.b.i0.t.d.g.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.ala.alasquare.subtablist.view.AlaSubListLiveDoubleViewHolder;
import d.b.h0.r.q.a2;
import d.b.i0.t.d.a.c;
import d.b.i0.t.d.g.d.d;
import d.b.i0.t.d.g.d.g;
/* loaded from: classes4.dex */
public class b extends d.b.c.j.e.a<d.b.i0.t.d.g.b.b, AlaSubListLiveDoubleViewHolder> {
    public TbPageContext<?> m;
    public g n;
    public boolean o;
    public d p;
    public int q;
    public int r;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), d.b.i0.t.d.g.b.b.f62171g);
        this.o = false;
        this.m = tbPageContext;
    }

    public final void h0(d.b.i0.t.d.g.b.b bVar) {
        if (bVar == null) {
            return;
        }
        int i = this.r;
        if (i == 1) {
            if (bVar.f62172e != null) {
                d.b.i0.t.d.d.a c2 = d.b.i0.t.d.d.a.c();
                d.b.i0.t.d.d.a c3 = d.b.i0.t.d.d.a.c();
                int i2 = this.q;
                c cVar = bVar.f62172e;
                c2.a(c3.e(i2, "c12117", cVar.f61803e, cVar.f61804f, cVar.g()));
            }
            if (bVar.f62173f != null) {
                d.b.i0.t.d.d.a c4 = d.b.i0.t.d.d.a.c();
                d.b.i0.t.d.d.a c5 = d.b.i0.t.d.d.a.c();
                int i3 = this.q;
                c cVar2 = bVar.f62173f;
                c4.a(c5.e(i3, "c12117", cVar2.f61803e, cVar2.f61804f, cVar2.g()));
            }
        } else if (i == 2) {
            c cVar3 = bVar.f62172e;
            if (cVar3 != null && cVar3.g() != null && bVar.f62172e.g().q1() != null) {
                a2 g2 = bVar.f62172e.g();
                TiebaStatic.log(new StatisticItem("c12115").param("obj_id", g2.q1().live_id).param(TiebaStatic.Params.OBJ_PARAM3, g2.q1().appId).param("locate_type", bVar.f62172e.f61804f));
            }
            c cVar4 = bVar.f62173f;
            if (cVar4 == null || cVar4.g() == null || bVar.f62173f.g().q1() == null) {
                return;
            }
            a2 g3 = bVar.f62173f.g();
            TiebaStatic.log(new StatisticItem("c12115").param("obj_id", g3.q1().live_id).param(TiebaStatic.Params.OBJ_PARAM3, g3.q1().appId).param("locate_type", bVar.f62173f.f61804f));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: i0 */
    public AlaSubListLiveDoubleViewHolder R(ViewGroup viewGroup) {
        this.p = new d(this.m, this.o);
        return new AlaSubListLiveDoubleViewHolder(this.p);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: j0 */
    public View X(int i, View view, ViewGroup viewGroup, d.b.i0.t.d.g.b.b bVar, AlaSubListLiveDoubleViewHolder alaSubListLiveDoubleViewHolder) {
        h0(bVar);
        alaSubListLiveDoubleViewHolder.f14602a.n(bVar);
        alaSubListLiveDoubleViewHolder.f14602a.v(this.n);
        return alaSubListLiveDoubleViewHolder.a();
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
