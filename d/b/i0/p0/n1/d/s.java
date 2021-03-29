package d.b.i0.p0.n1.d;

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
import d.b.h0.r.q.a2;
import d.b.h0.r.q.z1;
/* loaded from: classes4.dex */
public class s extends d.b.i0.p0.k<z1, FrsCardVideoViewHolder<d.b.i0.p0.n1.g.b>> implements d.b.i0.x.z, d.b.i0.p0.j2.d {
    public static int A = 5;
    public static int B = 10;
    public static int C = 15;
    public TbPageContext<?> w;
    public String x;
    public d.b.i0.p0.j2.b y;
    public d.b.i0.x.b0<a2> z;

    /* loaded from: classes4.dex */
    public class a extends d.b.i0.x.b0<a2> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.i0.x.b0
        /* renamed from: d */
        public void a(View view, a2 a2Var) {
            if (view == null || a2Var == null) {
                return;
            }
            if (view.getId() == R.id.frame_video) {
                s.this.z0(a2Var, "c11718");
            } else if (view.getId() == R.id.layout_root) {
                s.this.z0(a2Var, TbadkCoreStatisticKey.FRS_PHOTO_LIVE_VIEW_PAGER_ITEM);
            } else if (view.getId() == R.id.image_user || view.getId() == R.id.pendant_image_user) {
                s.this.z0(a2Var, "c10241");
            } else if (view.getId() == R.id.card_divider_tv) {
                d.b.i0.p0.m2.l.a(s.this.y, a2Var.V0());
            }
            if (view.getId() != R.id.card_home_page_normal_thread_user_name && !(view instanceof HeadImageView) && !(view instanceof HeadPendantView)) {
                if (view.getId() == R.id.frame_video) {
                    d.b.i0.p0.j2.a.b(a2Var, 4, s.this.i, s.this.y, s.this.i0());
                    return;
                } else if (view.getId() == R.id.thread_info_commont_container) {
                    d.b.i0.p0.j2.a.b(a2Var, 5, s.this.i, s.this.y, s.this.i0());
                    return;
                } else {
                    d.b.i0.p0.j2.a.b(a2Var, 1, s.this.i, s.this.y, s.this.i0());
                    return;
                }
            }
            d.b.i0.p0.j2.a.b(a2Var, 2, s.this.i, s.this.y, s.this.i0());
        }
    }

    public s(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.y = new d.b.i0.p0.j2.b();
        this.z = new a();
        this.w = tbPageContext;
    }

    public final String A0(int i) {
        return i == A ? "3" : i == B ? Constants.VIA_REPORT_TYPE_SHARE_TO_QQ : i == C ? Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE : "";
    }

    public final d.b.i0.i2.o B0(a2 a2Var) {
        if (a2Var != null) {
            d.b.i0.i2.o oVar = new d.b.i0.i2.o();
            oVar.f56164a = A0(a2Var.q0());
            oVar.f56167d = this.y.f57702c;
            oVar.f56166c = a2Var.w1();
            oVar.l = a2Var.T0;
            if (a2Var.u1() != null) {
                oVar.m = a2Var.u1().video_md5;
            }
            a2Var.x4();
            return oVar;
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: C0 */
    public FrsCardVideoViewHolder R(ViewGroup viewGroup) {
        d.b.i0.p0.n1.g.b bVar = new d.b.i0.p0.n1.g.b(this.w, this.i);
        bVar.d0(this.i);
        bVar.a(this.x);
        return new FrsCardVideoViewHolder(bVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.i0.p0.k, d.b.b.j.e.a
    /* renamed from: D0 */
    public View X(int i, View view, ViewGroup viewGroup, z1 z1Var, FrsCardVideoViewHolder frsCardVideoViewHolder) {
        if (frsCardVideoViewHolder == null || frsCardVideoViewHolder.b() == null) {
            return null;
        }
        frsCardVideoViewHolder.b().l0(B0(z1Var.w));
        frsCardVideoViewHolder.b().n(z1Var.w);
        frsCardVideoViewHolder.b().q(this.z);
        d.b.i0.p0.j2.a.i(z1Var.w, this.i, this.y, i0());
        return frsCardVideoViewHolder.a();
    }

    @Override // d.b.i0.x.z
    public void a(String str) {
        this.x = str;
    }

    @Override // d.b.i0.p0.j2.d
    public d.b.i0.p0.j2.b b() {
        return this.y;
    }

    @Override // d.b.i0.x.z
    public void p(int i) {
    }

    public final void z0(a2 a2Var, String str) {
        if (a2Var == null) {
            return;
        }
        int q0 = a2Var.q0();
        StatisticItem statisticItem = new StatisticItem(str);
        statisticItem.param("obj_locate", A0(q0));
        statisticItem.param("tid", a2Var.w1());
        statisticItem.param("obj_type", 2);
        TiebaStatic.log(statisticItem);
    }
}
