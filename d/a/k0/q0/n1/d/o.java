package d.a.k0.q0.n1.d;

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
import com.tencent.connect.common.Constants;
import d.a.j0.r.q.a2;
import d.a.j0.r.q.z1;
/* loaded from: classes4.dex */
public class o extends d.a.k0.q0.k<z1, FrsCardVideoViewHolder<d.a.k0.q0.n1.g.b>> implements d.a.k0.x.z, d.a.k0.q0.j2.d {
    public static int A = 5;
    public static int B = 10;
    public static int C = 15;
    public TbPageContext<?> w;
    public String x;
    public d.a.k0.q0.j2.b y;
    public d.a.k0.x.b0<a2> z;

    /* loaded from: classes4.dex */
    public class a extends d.a.k0.x.b0<a2> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.k0.x.b0
        /* renamed from: d */
        public void a(View view, a2 a2Var) {
            if (view == null || a2Var == null) {
                return;
            }
            if (view.getId() == R.id.frame_video) {
                o.this.y0(a2Var, "c11718");
            } else if (view.getId() == R.id.layout_root) {
                o.this.y0(a2Var, TbadkCoreStatisticKey.FRS_PHOTO_LIVE_VIEW_PAGER_ITEM);
            } else if (view.getId() == R.id.image_user || view.getId() == R.id.pendant_image_user) {
                o.this.y0(a2Var, "c10241");
            } else if (view.getId() == R.id.card_divider_tv) {
                d.a.k0.q0.n2.l.a(o.this.y, a2Var.V0());
            }
            if (view.getId() != R.id.card_home_page_normal_thread_user_name && !(view instanceof HeadImageView) && !(view instanceof HeadPendantView)) {
                if (view.getId() == R.id.frame_video) {
                    d.a.k0.q0.j2.a.c(a2Var, 4, o.this.f39568i, o.this.y, o.this.f0());
                    return;
                } else if (view.getId() == R.id.thread_info_commont_container) {
                    d.a.k0.q0.j2.a.c(a2Var, 5, o.this.f39568i, o.this.y, o.this.f0());
                    return;
                } else {
                    d.a.k0.q0.j2.a.c(a2Var, 1, o.this.f39568i, o.this.y, o.this.f0());
                    return;
                }
            }
            d.a.k0.q0.j2.a.c(a2Var, 2, o.this.f39568i, o.this.y, o.this.f0());
        }
    }

    public o(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.y = new d.a.k0.q0.j2.b();
        this.z = new a();
        this.w = tbPageContext;
    }

    public final d.a.k0.j2.o A0(a2 a2Var) {
        if (a2Var != null) {
            d.a.k0.j2.o oVar = new d.a.k0.j2.o();
            oVar.f56718a = z0(a2Var.q0());
            oVar.f56721d = this.y.f58635c;
            oVar.f56720c = a2Var.x1();
            oVar.l = a2Var.T0;
            if (a2Var.v1() != null) {
                oVar.m = a2Var.v1().video_md5;
            }
            a2Var.A4();
            return oVar;
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: B0 */
    public FrsCardVideoViewHolder P(ViewGroup viewGroup) {
        d.a.k0.q0.n1.g.b bVar = new d.a.k0.q0.n1.g.b(this.w, this.f39568i);
        bVar.Z(this.f39568i);
        bVar.a(this.x);
        return new FrsCardVideoViewHolder(bVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.k0.q0.k, d.a.c.j.e.a
    /* renamed from: C0 */
    public View W(int i2, View view, ViewGroup viewGroup, z1 z1Var, FrsCardVideoViewHolder frsCardVideoViewHolder) {
        if (frsCardVideoViewHolder == null || frsCardVideoViewHolder.b() == null) {
            return null;
        }
        frsCardVideoViewHolder.b().g0(A0(z1Var.w));
        frsCardVideoViewHolder.b().m(z1Var.w);
        frsCardVideoViewHolder.b().o(this.z);
        d.a.k0.q0.j2.a.j(z1Var.w, this.f39568i, this.y, f0());
        return frsCardVideoViewHolder.a();
    }

    @Override // d.a.k0.x.z
    public void a(String str) {
        this.x = str;
    }

    @Override // d.a.k0.q0.j2.d
    public d.a.k0.q0.j2.b i() {
        return this.y;
    }

    @Override // d.a.k0.x.z
    public void q(int i2) {
    }

    public final void y0(a2 a2Var, String str) {
        if (a2Var == null) {
            return;
        }
        int q0 = a2Var.q0();
        StatisticItem statisticItem = new StatisticItem(str);
        statisticItem.param("obj_locate", z0(q0));
        statisticItem.param("tid", a2Var.x1());
        statisticItem.param("obj_type", 2);
        TiebaStatic.log(statisticItem);
    }

    public final String z0(int i2) {
        return i2 == A ? "3" : i2 == B ? "10" : i2 == C ? Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE : "";
    }
}
