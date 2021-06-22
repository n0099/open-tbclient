package d.a.o0.v.d.g.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.ala.alasquare.subtablist.view.AlaSubListGameDoubleViewHolder;
import d.a.n0.r.q.a2;
import d.a.o0.v.d.a.c;
import d.a.o0.v.d.g.d.f;
/* loaded from: classes4.dex */
public class a extends d.a.c.k.e.a<d.a.o0.v.d.g.b.a, AlaSubListGameDoubleViewHolder> {
    public TbPageContext<?> m;
    public f n;
    public boolean o;
    public d.a.o0.v.d.g.d.a p;
    public int q;
    public int r;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), d.a.o0.v.d.g.b.a.f65623g);
        this.o = false;
        this.m = tbPageContext;
    }

    public final void e0(d.a.o0.v.d.g.b.a aVar) {
        if (aVar == null) {
            return;
        }
        int i2 = this.r;
        if (i2 == 1) {
            if (aVar.f65624e != null) {
                d.a.o0.v.d.d.a c2 = d.a.o0.v.d.d.a.c();
                d.a.o0.v.d.d.a c3 = d.a.o0.v.d.d.a.c();
                int i3 = this.q;
                c cVar = aVar.f65624e;
                c2.a(c3.e(i3, "c12117", cVar.f65252e, cVar.f65253f, cVar.c()));
            }
            if (aVar.f65625f != null) {
                d.a.o0.v.d.d.a c4 = d.a.o0.v.d.d.a.c();
                d.a.o0.v.d.d.a c5 = d.a.o0.v.d.d.a.c();
                int i4 = this.q;
                c cVar2 = aVar.f65625f;
                c4.a(c5.e(i4, "c12117", cVar2.f65252e, cVar2.f65253f, cVar2.c()));
            }
        } else if (i2 == 2) {
            c cVar3 = aVar.f65624e;
            if (cVar3 != null && cVar3.c() != null && aVar.f65624e.c().s1() != null) {
                a2 c6 = aVar.f65624e.c();
                TiebaStatic.log(new StatisticItem("c12115").param("obj_id", c6.s1().live_id).param(TiebaStatic.Params.OBJ_PARAM3, c6.s1().appId).param("locate_type", aVar.f65624e.f65253f));
            }
            c cVar4 = aVar.f65625f;
            if (cVar4 == null || cVar4.c() == null || aVar.f65625f.c().s1() == null) {
                return;
            }
            a2 c7 = aVar.f65625f.c();
            TiebaStatic.log(new StatisticItem("c12115").param("obj_id", c7.s1().live_id).param(TiebaStatic.Params.OBJ_PARAM3, c7.s1().appId).param("locate_type", aVar.f65625f.f65253f));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: g0 */
    public AlaSubListGameDoubleViewHolder Q(ViewGroup viewGroup) {
        this.p = new d.a.o0.v.d.g.d.a(this.m, this.o);
        return new AlaSubListGameDoubleViewHolder(this.p);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: h0 */
    public View X(int i2, View view, ViewGroup viewGroup, d.a.o0.v.d.g.b.a aVar, AlaSubListGameDoubleViewHolder alaSubListGameDoubleViewHolder) {
        e0(aVar);
        alaSubListGameDoubleViewHolder.f14040a.n(aVar);
        alaSubListGameDoubleViewHolder.f14040a.u(this.n);
        return alaSubListGameDoubleViewHolder.a();
    }

    public void i0(int i2) {
        this.r = i2;
    }

    public void j0(int i2) {
        this.q = i2;
    }

    public void k0(f fVar) {
        this.n = fVar;
    }

    public void l0(boolean z) {
        this.o = z;
    }
}
