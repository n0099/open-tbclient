package d.a.n0.e2.k.e;

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
/* loaded from: classes5.dex */
public class j extends o<d.a.m0.r.q.p, PbBjhRecommendViewHolder> {
    public d.a.n0.e2.h.e s;
    public int t;
    public boolean u;

    public j(d.a.n0.e2.o.i iVar, BdUniqueId bdUniqueId) {
        super(iVar, bdUniqueId);
    }

    public final void h0(PbBjhRecommendViewHolder pbBjhRecommendViewHolder) {
        if (pbBjhRecommendViewHolder == null) {
            return;
        }
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (pbBjhRecommendViewHolder.f18943a != skinType) {
            SkinManager.setBackgroundColor(pbBjhRecommendViewHolder.j, R.color.CAM_X0204, skinType);
            SkinManager.setBackgroundColor(pbBjhRecommendViewHolder.y, R.color.CAM_X0203, skinType);
            SkinManager.setBackgroundColor(pbBjhRecommendViewHolder.t, R.color.CAM_X0204, skinType);
            SkinManager.setViewTextColor(pbBjhRecommendViewHolder.v, R.color.CAM_X0302, 1, skinType);
            SkinManager.setViewTextColor(pbBjhRecommendViewHolder.o, R.color.CAM_X0105, 1, skinType);
            pbBjhRecommendViewHolder.q.setImageDrawable(SvgManager.getInstance().getPureDrawable(R.drawable.ic_icon_pure_video_play12_svg, R.color.CAM_X0101, null));
            SkinManager.setViewTextColor(pbBjhRecommendViewHolder.r, R.color.CAM_X0101, 1, skinType);
            SkinManager.setViewTextColor(pbBjhRecommendViewHolder.w, R.color.CAM_X0109, 1, skinType);
            SkinManager.setViewTextColor(pbBjhRecommendViewHolder.x, R.color.CAM_X0109, 1, skinType);
            SkinManager.setBackgroundSelector(pbBjhRecommendViewHolder.f18951i, R.color.CAM_X0205, R.color.CAM_X0204, skinType);
            TBSelector.makeDrawableSelector().setShape(0).gradientLinear(R.color.cp_bg_line_d_alpha0, R.color.CAM_X0105).cornerRadius(d.a.c.e.p.l.g(this.m.B(), R.dimen.tbds10)).into(pbBjhRecommendViewHolder.n);
        }
        pbBjhRecommendViewHolder.f18943a = skinType;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: i0 */
    public PbBjhRecommendViewHolder Q(ViewGroup viewGroup) {
        PbBjhRecommendViewHolder pbBjhRecommendViewHolder = new PbBjhRecommendViewHolder(LayoutInflater.from(this.f42909e).inflate(R.layout.bjh_recommend_item, (ViewGroup) null), this.m.B());
        h0(pbBjhRecommendViewHolder);
        return pbBjhRecommendViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.n0.e2.k.e.o, d.a.c.k.e.a
    /* renamed from: j0 */
    public View X(int i2, View view, ViewGroup viewGroup, d.a.m0.r.q.p pVar, PbBjhRecommendViewHolder pbBjhRecommendViewHolder) {
        super.X(i2, view, viewGroup, pVar, pbBjhRecommendViewHolder);
        if (pVar == null) {
            return null;
        }
        h0(pbBjhRecommendViewHolder);
        pbBjhRecommendViewHolder.i(pVar);
        pbBjhRecommendViewHolder.j(this.t);
        pbBjhRecommendViewHolder.n(this.u);
        d.a.n0.e2.h.e eVar = this.s;
        if (eVar != null) {
            pbBjhRecommendViewHolder.m(eVar.N());
            pbBjhRecommendViewHolder.l(this.s.f0());
            if (this.s.L() != null && this.s.L().V() != null) {
                pbBjhRecommendViewHolder.k(this.s.L().V().oriUgcNid);
            }
            int i3 = this.t;
            int i4 = 3;
            if (i3 == 2) {
                i4 = 1;
            } else if (i3 == 1) {
                i4 = 2;
            } else if (i3 != 3) {
                i4 = 4;
            }
            if (pVar.Z == 40) {
                StatisticItem.make("c13536").param("tid", pVar.z1()).param("fid", pVar.c0()).param("obj_source", i4).param("obj_locate", pVar.D4()).param("obj_id", this.s.N()).param("obj_type", pVar.W1() ? 1 : 0).eventStat();
            } else {
                StatisticItem.make("c13533").param("tid", pVar.z1()).param("fid", pVar.c0()).param("obj_source", i4).param("obj_locate", pVar.D4()).param("obj_id", this.s.N()).eventStat();
            }
            if (this.s.f0()) {
                StatisticItem statisticItem = new StatisticItem("c13588");
                if (pVar.h0() != null) {
                    statisticItem.param("fid", pVar.h0().i());
                }
                statisticItem.param("tid", pVar.z1());
                statisticItem.param("obj_param1", pVar.U0);
                statisticItem.param("obj_source", pVar.T0);
                statisticItem.param("obj_locate", pVar.D4());
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, System.currentTimeMillis());
                statisticItem.param("obj_id", this.s.N());
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                pVar.i();
                if (pVar.V() != null) {
                    pVar.i();
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM4, pVar.V().oriUgcNid);
                    pVar.i();
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, pVar.V().oriUgcVid);
                }
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM6, pVar.I1());
                statisticItem.param("ab_tag", pVar.V0);
                statisticItem.param("extra", pVar.W0);
                TiebaStatic.log(statisticItem);
            }
        }
        return view;
    }

    public void k0(int i2) {
        this.t = i2;
    }

    public void l0(d.a.n0.e2.h.e eVar) {
        this.s = eVar;
    }

    public void m0(boolean z) {
        this.u = z;
    }
}
