package d.a.n0.v.d.g.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.ala.alasquare.subtablist.view.AlaSubListLiveDoubleViewHolder;
import d.a.m0.r.q.a2;
import d.a.n0.v.d.a.c;
import d.a.n0.v.d.g.d.d;
import d.a.n0.v.d.g.d.f;
/* loaded from: classes4.dex */
public class b extends d.a.c.j.e.a<d.a.n0.v.d.g.b.b, AlaSubListLiveDoubleViewHolder> {
    public TbPageContext<?> m;
    public f n;
    public boolean o;
    public d p;
    public int q;
    public int r;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), d.a.n0.v.d.g.b.b.f61786g);
        this.o = false;
        this.m = tbPageContext;
    }

    public final void e0(d.a.n0.v.d.g.b.b bVar) {
        if (bVar == null) {
            return;
        }
        int i2 = this.r;
        if (i2 == 1) {
            if (bVar.f61787e != null) {
                d.a.n0.v.d.d.a c2 = d.a.n0.v.d.d.a.c();
                d.a.n0.v.d.d.a c3 = d.a.n0.v.d.d.a.c();
                int i3 = this.q;
                c cVar = bVar.f61787e;
                c2.a(c3.e(i3, "c12117", cVar.f61414e, cVar.f61415f, cVar.h()));
            }
            if (bVar.f61788f != null) {
                d.a.n0.v.d.d.a c4 = d.a.n0.v.d.d.a.c();
                d.a.n0.v.d.d.a c5 = d.a.n0.v.d.d.a.c();
                int i4 = this.q;
                c cVar2 = bVar.f61788f;
                c4.a(c5.e(i4, "c12117", cVar2.f61414e, cVar2.f61415f, cVar2.h()));
            }
        } else if (i2 == 2) {
            c cVar3 = bVar.f61787e;
            if (cVar3 != null && cVar3.h() != null && bVar.f61787e.h().r1() != null) {
                a2 h2 = bVar.f61787e.h();
                TiebaStatic.log(new StatisticItem("c12115").param("obj_id", h2.r1().live_id).param(TiebaStatic.Params.OBJ_PARAM3, h2.r1().appId).param("locate_type", bVar.f61787e.f61415f));
            }
            c cVar4 = bVar.f61788f;
            if (cVar4 == null || cVar4.h() == null || bVar.f61788f.h().r1() == null) {
                return;
            }
            a2 h3 = bVar.f61788f.h();
            TiebaStatic.log(new StatisticItem("c12115").param("obj_id", h3.r1().live_id).param(TiebaStatic.Params.OBJ_PARAM3, h3.r1().appId).param("locate_type", bVar.f61788f.f61415f));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: f0 */
    public AlaSubListLiveDoubleViewHolder P(ViewGroup viewGroup) {
        this.p = new d(this.m, this.o);
        return new AlaSubListLiveDoubleViewHolder(this.p);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: g0 */
    public View W(int i2, View view, ViewGroup viewGroup, d.a.n0.v.d.g.b.b bVar, AlaSubListLiveDoubleViewHolder alaSubListLiveDoubleViewHolder) {
        e0(bVar);
        alaSubListLiveDoubleViewHolder.f13902a.m(bVar);
        alaSubListLiveDoubleViewHolder.f13902a.t(this.n);
        return alaSubListLiveDoubleViewHolder.a();
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
