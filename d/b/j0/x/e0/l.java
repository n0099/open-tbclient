package d.b.j0.x.e0;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.videoPreload.IVideoData;
import d.b.i0.r.q.a2;
/* loaded from: classes4.dex */
public class l extends b implements IVideoData {
    public static String a0;
    public static String b0;
    public boolean S = false;
    public boolean T = true;
    public int U = 0;
    public static final BdUniqueId V = BdUniqueId.gen();
    public static String W = "";
    public static String X = "";
    public static String Y = "";
    public static String Z = "";
    public static String c0 = "";

    public l(a2 a2Var) {
        this.f64193e = a2Var;
    }

    public static boolean d0(a2 a2Var) {
        return (a2Var == null || a2Var.u1() == null) ? false : true;
    }

    @Override // d.b.j0.x.e0.b
    public StatisticItem A(String str) {
        StatisticItem statisticItem = new StatisticItem(str);
        a2 a2Var = this.f64193e;
        if (a2Var != null) {
            statisticItem.param("fid", a2Var.c0());
            statisticItem.param("tid", this.f64193e.w1());
            if (this.f64193e.R1()) {
                statisticItem.param("obj_type", 8);
            } else if (this.f64193e.Q1()) {
                statisticItem.param("obj_type", 9);
            } else if (this.f64193e.z2()) {
                statisticItem.param("obj_type", 2);
            }
            statisticItem.param("obj_param1", P() ? 2 : 1);
            if (this.f64193e.T() != null) {
                statisticItem.param("obj_id", this.f64193e.T().getUserId());
            }
        }
        return statisticItem;
    }

    @Override // d.b.j0.x.e0.b
    public StatisticItem C() {
        StatisticItem I = I(X, true);
        if (I != null && n() != null) {
            a2 n = n();
            if (n.V() != null) {
                I.param(TiebaStatic.Params.OBJ_PARAM4, n.V().oriUgcNid);
                I.param(TiebaStatic.Params.OBJ_PARAM6, n.V().oriUgcVid);
            }
            I.param(TiebaStatic.Params.OBJ_PARAM5, e0(n));
        }
        return I;
    }

    @Override // d.b.j0.x.e0.b
    public StatisticItem L() {
        StatisticItem I = I(Y, true);
        if (I != null && n() != null) {
            a2 n = n();
            I.param("obj_name", (n.z1() == null || (n.z1().K() == null && n.z1().V() == null)) ? 0 : 1);
            if (n.T() != null) {
                I.param(TiebaStatic.Params.AB_TYPE, n.T().hadConcerned() ? 1 : 0);
            }
            if (n.V() != null) {
                I.param(TiebaStatic.Params.OBJ_PARAM4, n.V().oriUgcNid);
                I.param(TiebaStatic.Params.OBJ_PARAM6, n.V().oriUgcVid);
            }
            I.param(TiebaStatic.Params.OBJ_PARAM5, e0(n));
            if (n.M1()) {
                I.param(TiebaStatic.Params.OBJ_TO, 2);
            } else {
                I.param(TiebaStatic.Params.OBJ_TO, 1);
            }
        }
        return I;
    }

    @Override // d.b.j0.x.e0.b
    public StatisticItem N() {
        StatisticItem I = I(Z, true);
        if (n() != null) {
            a2 n = n();
            if (n.V() != null) {
                I.param(TiebaStatic.Params.OBJ_PARAM4, n.V().oriUgcNid);
                I.param(TiebaStatic.Params.OBJ_PARAM6, n.V().oriUgcVid);
            }
            I.param(TiebaStatic.Params.OBJ_PARAM5, e0(n));
            I.param("nid", n.L0());
        }
        return I;
    }

    @Override // d.b.j0.x.e0.b
    public boolean Q() {
        return true;
    }

    public StatisticItem Z(a2 a2Var) {
        return a0(a2Var, -1);
    }

    public StatisticItem a0(a2 a2Var, int i) {
        StatisticItem I = I(Z, true);
        if (I != null) {
            if (i != -1) {
                I.param(TiebaStatic.Params.CLICK_LOCATE, i);
            }
            if (n() != null) {
                a2 n = n();
                if (n.V() != null) {
                    I.param(TiebaStatic.Params.OBJ_PARAM4, n.V().oriUgcNid);
                    I.param(TiebaStatic.Params.OBJ_PARAM6, n.V().oriUgcVid);
                }
                I.param(TiebaStatic.Params.OBJ_PARAM5, e0(n));
            }
        }
        return I;
    }

    public StatisticItem b0() {
        StatisticItem I = I(c0, true);
        if (I != null && n() != null) {
            a2 n = n();
            if (n.V() != null) {
                I.param(TiebaStatic.Params.OBJ_PARAM4, n.V().oriUgcNid);
                I.param(TiebaStatic.Params.OBJ_PARAM6, n.V().oriUgcVid);
            }
            I.param(TiebaStatic.Params.OBJ_PARAM5, e0(n));
        }
        return I;
    }

    public StatisticItem c0(a2 a2Var) {
        StatisticItem I = I(W, true);
        if (I != null && n() != null) {
            a2 n = n();
            if (n.V() != null) {
                I.param(TiebaStatic.Params.OBJ_PARAM4, n.V().oriUgcNid);
                I.param(TiebaStatic.Params.OBJ_PARAM6, n.V().oriUgcVid);
                if (n.M1()) {
                    I.param(TiebaStatic.Params.OBJ_PARAM2, 2);
                } else {
                    I.param(TiebaStatic.Params.OBJ_PARAM2, 1);
                }
            }
            I.param(TiebaStatic.Params.OBJ_PARAM5, e0(n));
        }
        return I;
    }

    public int e0(a2 a2Var) {
        if (a2Var == null) {
            return 1;
        }
        if (a2Var.Q1() || a2Var.P1()) {
            return 2;
        }
        return (a2Var.O1() || a2Var.R1()) ? 3 : 1;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.b.c.j.e.n
    public BdUniqueId getType() {
        a2 a2Var = this.f64193e;
        if (a2Var == null) {
            return k.l0;
        }
        if (this.E) {
            if (this.s) {
                return a2.I2;
            }
            return a2Var.getType();
        } else if (this.r) {
            return k.v0;
        } else {
            if (this.x) {
                return V;
            }
            if (this.D) {
                return k.B0;
            }
            if (this.C) {
                return k.D0;
            }
            if (this.B) {
                return k.C0;
            }
            if (this.s) {
                return k.w0;
            }
            if (this.y) {
                return k.E0;
            }
            if (this.z) {
                return k.K0;
            }
            if (this.A) {
                return k.L0;
            }
            return V;
        }
    }

    @Override // com.baidu.tbadk.core.util.videoPreload.IVideoData
    public String getVideoUrl() {
        a2 a2Var = this.f64193e;
        if (a2Var == null || a2Var.u1() == null || this.f64193e.u1().video_url == null) {
            return null;
        }
        return this.f64193e.u1().video_url;
    }

    @Override // d.b.j0.x.e0.b, d.b.i0.r.q.a
    public a2 n() {
        a2 a2Var = this.f64193e;
        if (a2Var == null) {
            return null;
        }
        if (a2Var.a1() != 5) {
            this.f64193e.a4(1);
        }
        return this.f64193e;
    }
}
