package d.b.i0.c2.k.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbBjhRecommendViewHolder;
/* loaded from: classes4.dex */
public class h extends m<d.b.h0.r.q.p, PbBjhRecommendViewHolder> {
    public d.b.i0.c2.h.e s;
    public int t;
    public boolean u;

    public h(d.b.i0.c2.o.b bVar, BdUniqueId bdUniqueId) {
        super(bVar, bdUniqueId);
    }

    public final void j0(PbBjhRecommendViewHolder pbBjhRecommendViewHolder) {
        if (pbBjhRecommendViewHolder == null) {
            return;
        }
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (pbBjhRecommendViewHolder.f19516a != skinType) {
            SkinManager.setBackgroundColor(pbBjhRecommendViewHolder.j, R.color.CAM_X0204, skinType);
            SkinManager.setBackgroundColor(pbBjhRecommendViewHolder.y, R.color.CAM_X0203, skinType);
            SkinManager.setBackgroundColor(pbBjhRecommendViewHolder.t, R.color.CAM_X0204, skinType);
            SkinManager.setViewTextColor(pbBjhRecommendViewHolder.v, R.color.CAM_X0302, 1, skinType);
            SkinManager.setViewTextColor(pbBjhRecommendViewHolder.o, R.color.CAM_X0105, 1, skinType);
            pbBjhRecommendViewHolder.q.setImageDrawable(SvgManager.getInstance().getPureDrawable(R.drawable.ic_icon_pure_video_play12_svg, R.color.CAM_X0101, null));
            SkinManager.setViewTextColor(pbBjhRecommendViewHolder.r, R.color.CAM_X0101, 1, skinType);
            SkinManager.setViewTextColor(pbBjhRecommendViewHolder.w, R.color.CAM_X0109, 1, skinType);
            SkinManager.setViewTextColor(pbBjhRecommendViewHolder.x, R.color.CAM_X0109, 1, skinType);
            SkinManager.setBackgroundSelector(pbBjhRecommendViewHolder.i, R.color.CAM_X0205, R.color.CAM_X0204, skinType);
            TBSelector.makeDrawableSelector().setShape(0).gradientLinear(R.color.cp_bg_line_d_alpha0, R.color.CAM_X0105).cornerRadius(d.b.b.e.p.l.g(this.m.P(), R.dimen.tbds10)).into(pbBjhRecommendViewHolder.n);
        }
        pbBjhRecommendViewHolder.f19516a = skinType;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: l0 */
    public PbBjhRecommendViewHolder R(ViewGroup viewGroup) {
        PbBjhRecommendViewHolder pbBjhRecommendViewHolder = new PbBjhRecommendViewHolder(LayoutInflater.from(this.f42357e).inflate(R.layout.bjh_recommend_item, (ViewGroup) null), this.m.P());
        j0(pbBjhRecommendViewHolder);
        return pbBjhRecommendViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.i0.c2.k.e.m, d.b.b.j.e.a
    /* renamed from: m0 */
    public View X(int i, View view, ViewGroup viewGroup, d.b.h0.r.q.p pVar, PbBjhRecommendViewHolder pbBjhRecommendViewHolder) {
        super.X(i, view, viewGroup, pVar, pbBjhRecommendViewHolder);
        if (pVar == null) {
            return null;
        }
        j0(pbBjhRecommendViewHolder);
        pbBjhRecommendViewHolder.i(pVar);
        pbBjhRecommendViewHolder.j(this.t);
        pbBjhRecommendViewHolder.n(this.u);
        d.b.i0.c2.h.e eVar = this.s;
        if (eVar != null) {
            pbBjhRecommendViewHolder.m(eVar.N());
            pbBjhRecommendViewHolder.l(this.s.e0());
            if (this.s.L() != null && this.s.L().V() != null) {
                pbBjhRecommendViewHolder.k(this.s.L().V().oriUgcNid);
            }
            int i2 = this.t;
            int i3 = 3;
            if (i2 == 2) {
                i3 = 1;
            } else if (i2 == 1) {
                i3 = 2;
            } else if (i2 != 3) {
                i3 = 4;
            }
            if (pVar.Z == 40) {
                StatisticItem.make("c13536").param("tid", pVar.w1()).param("fid", pVar.c0()).param("obj_source", i3).param("obj_locate", pVar.y4()).param("obj_id", this.s.N()).param("obj_type", pVar.T1() ? 1 : 0).eventStat();
            } else {
                StatisticItem.make("c13533").param("tid", pVar.w1()).param("fid", pVar.c0()).param("obj_source", i3).param("obj_locate", pVar.y4()).param("obj_id", this.s.N()).eventStat();
            }
            if (this.s.e0()) {
                StatisticItem statisticItem = new StatisticItem("c13588");
                if (pVar.h0() != null) {
                    statisticItem.param("fid", pVar.h0().h());
                }
                statisticItem.param("tid", pVar.w1());
                statisticItem.param("obj_param1", pVar.S0);
                statisticItem.param("obj_source", pVar.R0);
                statisticItem.param("obj_locate", pVar.y4());
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, System.currentTimeMillis());
                statisticItem.param("obj_id", this.s.N());
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                pVar.n();
                if (pVar.V() != null) {
                    pVar.n();
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM4, pVar.V().oriUgcNid);
                    pVar.n();
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, pVar.V().oriUgcVid);
                }
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM6, pVar.F1());
                statisticItem.param("ab_tag", pVar.T0);
                statisticItem.param("extra", pVar.U0);
                TiebaStatic.log(statisticItem);
            }
        }
        return view;
    }

    public void n0(int i) {
        this.t = i;
    }

    public void o0(d.b.i0.c2.h.e eVar) {
        this.s = eVar;
    }

    public void p0(boolean z) {
        this.u = z;
    }
}
