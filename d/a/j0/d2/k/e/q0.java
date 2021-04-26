package d.a.j0.d2.k.e;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import d.a.i0.r.q.a2;
/* loaded from: classes3.dex */
public class q0 extends d.a.i0.r.f0.q.c {
    public boolean r;
    public boolean s;
    public int t;
    public TbPageContext u;
    public String v;
    public int w;
    public a2 x;

    public q0(TbPageContext tbPageContext, d.a.i0.r.f0.q.b bVar, int i2) {
        super(tbPageContext, bVar);
        this.r = false;
        this.s = false;
        this.t = 0;
        this.t = i2;
        this.u = tbPageContext;
        if (i2 == 1) {
            super.m("4");
        } else if (i2 == 3) {
            super.m("5");
        } else if (i2 != 4 && i2 != 5 && i2 != 6) {
            super.m("0");
        } else {
            super.m("4");
        }
    }

    @Override // d.a.i0.r.f0.q.c, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null && view.getAlpha() >= 0.4d) {
            d.a.i0.r.f0.q.a aVar = this.f48914e;
            String userId = aVar != null ? aVar.getUserId() : "";
            TiebaStatic.log(new StatisticItem("c12408").param("obj_source", t()).param("obj_id", userId).param("tid", this.v));
            int i2 = this.t;
            int i3 = 8;
            int i4 = 0;
            if (i2 == 1) {
                i3 = 3;
            } else if (i2 == 3) {
                i3 = 2;
            } else if (i2 == 5) {
                i3 = 5;
            } else if (i2 == 7) {
                i3 = 7;
            } else if (i2 == 6) {
                i3 = 6;
            } else if (i2 == 4) {
                i3 = 4;
            } else if (i2 != 8) {
                i3 = 0;
            }
            StatisticItem statisticItem = new StatisticItem("c12507");
            statisticItem.param("obj_locate", i3);
            statisticItem.param("obj_id", userId);
            statisticItem.param("tid", this.v);
            statisticItem.param("obj_param1", this.w);
            if (!d.a.c.e.p.k.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
            }
            TiebaStatic.log(statisticItem);
            StatisticItem statisticItem2 = new StatisticItem(TbadkCoreStatisticKey.KEY_CONCERN_BTN_CLICK);
            statisticItem2.param("obj_id", userId);
            statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem2.param("tid", this.v);
            a2 a2Var = this.x;
            if (a2Var != null) {
                statisticItem2.param("nid", a2Var.L0());
                if (this.x.V() != null && !d.a.c.e.p.k.isEmpty(this.x.V().oriUgcVid)) {
                    statisticItem2.param(TiebaStatic.Params.OBJ_PARAM6, this.x.V().oriUgcVid);
                }
                statisticItem2.param("recom_source", this.x.R0);
                statisticItem2.param("ab_tag", this.x.T0);
                statisticItem2.param("weight", this.x.S0);
                statisticItem2.param("extra", this.x.U0);
            }
            TbPageContext tbPageContext = this.u;
            if (tbPageContext != null) {
                d.a.i0.j0.c.e(tbPageContext.getPageActivity(), statisticItem2);
            }
            TiebaStatic.log(statisticItem2);
            super.onClick(view);
            if (this.r && this.f48914e != null) {
                TiebaStatic.log(new StatisticItem("c11924").param("obj_id", this.f48914e.getUserId()));
            }
            if (!this.s || this.f48914e == null) {
                return;
            }
            int i5 = this.t;
            if (i5 == 1) {
                i4 = 1;
            } else if (i5 == 2) {
                i4 = 2;
            }
            TiebaStatic.log(new StatisticItem("c12150").param("obj_locate", i4).param("obj_id", this.f48914e.getUserId()));
        }
    }

    public final int t() {
        String fromPageKey = UtilHelper.getFromPageKey(this.u);
        if (fromPageKey == null) {
            return 3;
        }
        if (fromPageKey.equals("a038")) {
            return 1;
        }
        if (fromPageKey.equals("a002")) {
            return 2;
        }
        if (fromPageKey.equals("a006")) {
            return 3;
        }
        if (fromPageKey.equals("a011")) {
            return 4;
        }
        if (fromPageKey.equals("a033")) {
            return 5;
        }
        return fromPageKey.equals("a010") ? 6 : 7;
    }

    public void u(a2 a2Var) {
        this.x = a2Var;
    }

    public void v(int i2) {
        this.w = i2;
    }

    public void w(String str) {
        this.v = str;
    }
}
