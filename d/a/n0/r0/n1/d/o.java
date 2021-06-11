package d.a.n0.r0.n1.d;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.entelechy.adapter.FrsCardVideoViewHolder;
import d.a.m0.r.q.a2;
import d.a.m0.r.q.z1;
/* loaded from: classes4.dex */
public class o extends d.a.n0.r0.k<z1, FrsCardVideoViewHolder<d.a.n0.r0.n1.g.b>> implements d.a.n0.z.z, d.a.n0.r0.j2.d {
    public static int A = 5;
    public static int B = 10;
    public static int C = 15;
    public TbPageContext<?> w;
    public String x;
    public d.a.n0.r0.j2.b y;
    public d.a.n0.z.b0<a2> z;

    /* loaded from: classes4.dex */
    public class a extends d.a.n0.z.b0<a2> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.z.b0
        /* renamed from: d */
        public void a(View view, a2 a2Var) {
            if (view == null || a2Var == null) {
                return;
            }
            if (view.getId() == R.id.frame_video) {
                o.this.z0(a2Var, "c11718");
            } else if (view.getId() == R.id.layout_root) {
                o.this.z0(a2Var, TbadkCoreStatisticKey.FRS_PHOTO_LIVE_VIEW_PAGER_ITEM);
            } else if (view.getId() == R.id.image_user || view.getId() == R.id.pendant_image_user) {
                o.this.z0(a2Var, "c10241");
            } else if (view.getId() == R.id.card_divider_tv) {
                d.a.n0.r0.n2.l.a(o.this.y, a2Var.X0());
            }
            if (view.getId() != R.id.card_home_page_normal_thread_user_name && !(view instanceof HeadImageView) && !(view instanceof HeadPendantView)) {
                if (view.getId() == R.id.frame_video) {
                    d.a.n0.r0.j2.a.c(a2Var, 4, o.this.f42913i, o.this.y, o.this.g0());
                    return;
                } else if (view.getId() == R.id.thread_info_commont_container) {
                    d.a.n0.r0.j2.a.c(a2Var, 5, o.this.f42913i, o.this.y, o.this.g0());
                    return;
                } else {
                    d.a.n0.r0.j2.a.c(a2Var, 1, o.this.f42913i, o.this.y, o.this.g0());
                    return;
                }
            }
            d.a.n0.r0.j2.a.c(a2Var, 2, o.this.f42913i, o.this.y, o.this.g0());
        }
    }

    public o(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.y = new d.a.n0.r0.j2.b();
        this.z = new a();
        this.w = tbPageContext;
    }

    public final String A0(int i2) {
        return i2 == A ? "3" : i2 == B ? "10" : i2 == C ? "11" : "";
    }

    public final d.a.n0.k2.o B0(a2 a2Var) {
        if (a2Var != null) {
            d.a.n0.k2.o oVar = new d.a.n0.k2.o();
            oVar.f60587a = A0(a2Var.q0());
            oVar.f60590d = this.y.f62467c;
            oVar.f60589c = a2Var.z1();
            oVar.l = a2Var.V0;
            if (a2Var.x1() != null) {
                oVar.m = a2Var.x1().video_md5;
            }
            a2Var.C4();
            return oVar;
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: C0 */
    public FrsCardVideoViewHolder Q(ViewGroup viewGroup) {
        d.a.n0.r0.n1.g.b bVar = new d.a.n0.r0.n1.g.b(this.w, this.f42913i);
        bVar.a0(this.f42913i);
        bVar.a(this.x);
        return new FrsCardVideoViewHolder(bVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.n0.r0.k, d.a.c.k.e.a
    /* renamed from: D0 */
    public View X(int i2, View view, ViewGroup viewGroup, z1 z1Var, FrsCardVideoViewHolder frsCardVideoViewHolder) {
        if (frsCardVideoViewHolder == null || frsCardVideoViewHolder.b() == null) {
            return null;
        }
        frsCardVideoViewHolder.b().h0(B0(z1Var.w));
        frsCardVideoViewHolder.b().n(z1Var.w);
        frsCardVideoViewHolder.b().p(this.z);
        d.a.n0.r0.j2.a.j(z1Var.w, this.f42913i, this.y, g0());
        return frsCardVideoViewHolder.a();
    }

    @Override // d.a.n0.z.z
    public void a(String str) {
        this.x = str;
    }

    @Override // d.a.n0.r0.j2.d
    public d.a.n0.r0.j2.b j() {
        return this.y;
    }

    @Override // d.a.n0.z.z
    public void r(int i2) {
    }

    public final void z0(a2 a2Var, String str) {
        if (a2Var == null) {
            return;
        }
        int q0 = a2Var.q0();
        StatisticItem statisticItem = new StatisticItem(str);
        statisticItem.param("obj_locate", A0(q0));
        statisticItem.param("tid", a2Var.z1());
        statisticItem.param("obj_type", 2);
        TiebaStatic.log(statisticItem);
    }
}
