package d.a.n0.v.d.g.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.ala.alasquare.subtablist.view.AlaSubListGameDoubleViewHolder;
import d.a.m0.r.q.a2;
import d.a.n0.v.d.a.c;
import d.a.n0.v.d.g.d.f;
/* loaded from: classes4.dex */
public class a extends d.a.c.j.e.a<d.a.n0.v.d.g.b.a, AlaSubListGameDoubleViewHolder> {
    public TbPageContext<?> m;
    public f n;
    public boolean o;
    public d.a.n0.v.d.g.d.a p;
    public int q;
    public int r;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), d.a.n0.v.d.g.b.a.f61783g);
        this.o = false;
        this.m = tbPageContext;
    }

    public final void e0(d.a.n0.v.d.g.b.a aVar) {
        if (aVar == null) {
            return;
        }
        int i2 = this.r;
        if (i2 == 1) {
            if (aVar.f61784e != null) {
                d.a.n0.v.d.d.a c2 = d.a.n0.v.d.d.a.c();
                d.a.n0.v.d.d.a c3 = d.a.n0.v.d.d.a.c();
                int i3 = this.q;
                c cVar = aVar.f61784e;
                c2.a(c3.e(i3, "c12117", cVar.f61414e, cVar.f61415f, cVar.h()));
            }
            if (aVar.f61785f != null) {
                d.a.n0.v.d.d.a c4 = d.a.n0.v.d.d.a.c();
                d.a.n0.v.d.d.a c5 = d.a.n0.v.d.d.a.c();
                int i4 = this.q;
                c cVar2 = aVar.f61785f;
                c4.a(c5.e(i4, "c12117", cVar2.f61414e, cVar2.f61415f, cVar2.h()));
            }
        } else if (i2 == 2) {
            c cVar3 = aVar.f61784e;
            if (cVar3 != null && cVar3.h() != null && aVar.f61784e.h().r1() != null) {
                a2 h2 = aVar.f61784e.h();
                TiebaStatic.log(new StatisticItem("c12115").param("obj_id", h2.r1().live_id).param(TiebaStatic.Params.OBJ_PARAM3, h2.r1().appId).param("locate_type", aVar.f61784e.f61415f));
            }
            c cVar4 = aVar.f61785f;
            if (cVar4 == null || cVar4.h() == null || aVar.f61785f.h().r1() == null) {
                return;
            }
            a2 h3 = aVar.f61785f.h();
            TiebaStatic.log(new StatisticItem("c12115").param("obj_id", h3.r1().live_id).param(TiebaStatic.Params.OBJ_PARAM3, h3.r1().appId).param("locate_type", aVar.f61785f.f61415f));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: f0 */
    public AlaSubListGameDoubleViewHolder P(ViewGroup viewGroup) {
        this.p = new d.a.n0.v.d.g.d.a(this.m, this.o);
        return new AlaSubListGameDoubleViewHolder(this.p);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: g0 */
    public View W(int i2, View view, ViewGroup viewGroup, d.a.n0.v.d.g.b.a aVar, AlaSubListGameDoubleViewHolder alaSubListGameDoubleViewHolder) {
        e0(aVar);
        alaSubListGameDoubleViewHolder.f13901a.m(aVar);
        alaSubListGameDoubleViewHolder.f13901a.t(this.n);
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
