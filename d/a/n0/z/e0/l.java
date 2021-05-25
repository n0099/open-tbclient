package d.a.n0.z.e0;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TiebaStaticHelper;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.tbadk.core.util.videoPreload.IVideoData;
import d.a.m0.r.q.a2;
/* loaded from: classes4.dex */
public class l extends b implements IVideoData {
    public static String b0;
    public static String c0;
    public boolean T = false;
    public boolean U = true;
    public int V = 0;
    public static final BdUniqueId W = BdUniqueId.gen();
    public static String X = "";
    public static String Y = "";
    public static String Z = "";
    public static String a0 = "";
    public static String d0 = "";

    public l(a2 a2Var) {
        this.f63459e = a2Var;
    }

    public static boolean d0(a2 a2Var) {
        return (a2Var == null || a2Var.w1() == null) ? false : true;
    }

    @Override // d.a.n0.z.e0.b
    public StatisticItem A(String str) {
        StatisticItem statisticItem = new StatisticItem(str);
        a2 a2Var = this.f63459e;
        if (a2Var != null) {
            statisticItem.param("fid", a2Var.c0());
            statisticItem.param("tid", this.f63459e.y1());
            if (this.f63459e.T1()) {
                statisticItem.param("obj_type", 8);
            } else if (this.f63459e.S1()) {
                statisticItem.param("obj_type", 9);
            } else if (this.f63459e.C2()) {
                statisticItem.param("obj_type", 2);
            }
            statisticItem.param("obj_param1", P() ? 2 : 1);
            if (this.f63459e.T() != null) {
                statisticItem.param("obj_id", this.f63459e.T().getUserId());
            }
        }
        return statisticItem;
    }

    @Override // d.a.n0.z.e0.b
    public StatisticItem C() {
        StatisticItem I = I(Y, true);
        if (I != null && m() != null) {
            a2 m = m();
            if (m.V() != null) {
                I.param(TiebaStatic.Params.OBJ_PARAM4, m.V().oriUgcNid);
                I.param(TiebaStatic.Params.OBJ_PARAM6, m.V().oriUgcVid);
            }
            I.param(TiebaStatic.Params.OBJ_PARAM5, e0(m));
        }
        return I;
    }

    @Override // d.a.n0.z.e0.b
    public StatisticItem L() {
        int i2 = 1;
        StatisticItem I = I(Z, true);
        if (I != null && m() != null) {
            a2 m = m();
            I.param("obj_name", (m.B1() == null || (m.B1().K() == null && m.B1().V() == null)) ? 0 : 1);
            if (m.T() != null) {
                I.param(TiebaStatic.Params.AB_TYPE, m.T().hadConcerned() ? 1 : 0);
            }
            if (m.V() != null) {
                I.param(TiebaStatic.Params.OBJ_PARAM4, m.V().oriUgcNid);
                I.param(TiebaStatic.Params.OBJ_PARAM6, m.V().oriUgcVid);
            }
            I.param(TiebaStatic.Params.OBJ_PARAM5, e0(m));
            if (m.O1()) {
                I.param(TiebaStatic.Params.OBJ_TO, 2);
            } else {
                I.param(TiebaStatic.Params.OBJ_TO, 1);
            }
            if (m.T() != null && m.T().getAlaInfo() != null) {
                int calculateLiveType = YYLiveUtil.calculateLiveType(m.T().getAlaInfo());
                if (m.T().getAlaInfo().live_status != 1 && m.T().getAlaInfo().friendRoomStatus != 2) {
                    i2 = 2;
                }
                if (m.T().getAlaInfo().mYyExtData != null) {
                    TiebaStaticHelper.addYYParam(I, m.T().getAlaInfo().mYyExtData);
                }
                I.param(TiebaStatic.Params.OBJ_PARAM7, i2);
                I.param(TiebaStatic.Params.OBJ_PARAM8, calculateLiveType);
            }
        }
        return I;
    }

    @Override // d.a.n0.z.e0.b
    public StatisticItem N() {
        StatisticItem I = I(a0, true);
        if (m() != null) {
            a2 m = m();
            if (m.V() != null) {
                I.param(TiebaStatic.Params.OBJ_PARAM4, m.V().oriUgcNid);
                I.param(TiebaStatic.Params.OBJ_PARAM6, m.V().oriUgcVid);
            }
            I.param(TiebaStatic.Params.OBJ_PARAM5, e0(m));
            I.param("nid", m.M0());
        }
        return I;
    }

    @Override // d.a.n0.z.e0.b
    public boolean Q() {
        return true;
    }

    public StatisticItem Z(a2 a2Var) {
        return a0(a2Var, -1);
    }

    public StatisticItem a0(a2 a2Var, int i2) {
        StatisticItem I = I(a0, true);
        if (I != null) {
            if (i2 != -1) {
                I.param(TiebaStatic.Params.CLICK_LOCATE, i2);
            }
            if (m() != null) {
                a2 m = m();
                if (m.V() != null) {
                    I.param(TiebaStatic.Params.OBJ_PARAM4, m.V().oriUgcNid);
                    I.param(TiebaStatic.Params.OBJ_PARAM6, m.V().oriUgcVid);
                }
                I.param(TiebaStatic.Params.OBJ_PARAM5, e0(m));
            }
        }
        return I;
    }

    public StatisticItem b0() {
        StatisticItem I = I(d0, true);
        if (I != null && m() != null) {
            a2 m = m();
            if (m.V() != null) {
                I.param(TiebaStatic.Params.OBJ_PARAM4, m.V().oriUgcNid);
                I.param(TiebaStatic.Params.OBJ_PARAM6, m.V().oriUgcVid);
            }
            I.param(TiebaStatic.Params.OBJ_PARAM5, e0(m));
        }
        return I;
    }

    public StatisticItem c0(a2 a2Var) {
        StatisticItem I = I(X, true);
        if (I != null && m() != null) {
            a2 m = m();
            if (m.V() != null) {
                I.param(TiebaStatic.Params.OBJ_PARAM4, m.V().oriUgcNid);
                I.param(TiebaStatic.Params.OBJ_PARAM6, m.V().oriUgcVid);
                if (m.O1()) {
                    I.param(TiebaStatic.Params.OBJ_PARAM2, 2);
                } else {
                    I.param(TiebaStatic.Params.OBJ_PARAM2, 1);
                }
            }
            if (m.T() != null && m.T().getAlaInfo() != null) {
                int calculateLiveType = YYLiveUtil.calculateLiveType(m.T().getAlaInfo());
                if (m.T().getAlaInfo().mYyExtData != null) {
                    TiebaStaticHelper.addYYParam(I, m.T().getAlaInfo().mYyExtData);
                }
                I.param(TiebaStatic.Params.OBJ_PARAM7, calculateLiveType);
            }
            I.param(TiebaStatic.Params.OBJ_PARAM5, e0(m));
        }
        return I;
    }

    public int e0(a2 a2Var) {
        if (a2Var == null) {
            return 1;
        }
        if (a2Var.S1() || a2Var.R1()) {
            return 2;
        }
        return (a2Var.Q1() || a2Var.T1()) ? 3 : 1;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.j.e.n
    public BdUniqueId getType() {
        a2 a2Var = this.f63459e;
        if (a2Var == null) {
            return k.m0;
        }
        if (this.F) {
            if (this.s) {
                return a2.K2;
            }
            return a2Var.getType();
        } else if (this.r) {
            return k.w0;
        } else {
            if (this.x) {
                return W;
            }
            if (this.E) {
                return k.C0;
            }
            if (this.C) {
                return k.E0;
            }
            if (this.B) {
                return k.D0;
            }
            if (this.s) {
                return k.x0;
            }
            if (this.y) {
                return k.K0;
            }
            if (this.z) {
                return k.L0;
            }
            if (this.A) {
                return k.M0;
            }
            if (this.D) {
                return k.N0;
            }
            return W;
        }
    }

    @Override // com.baidu.tbadk.core.util.videoPreload.IVideoData
    public String getVideoUrl() {
        a2 a2Var = this.f63459e;
        if (a2Var == null || a2Var.w1() == null || this.f63459e.w1().video_url == null) {
            return null;
        }
        return this.f63459e.w1().video_url;
    }

    @Override // d.a.n0.z.e0.b, d.a.m0.r.q.a
    public a2 m() {
        a2 a2Var = this.f63459e;
        if (a2Var == null) {
            return null;
        }
        if (a2Var.b1() != 5) {
            this.f63459e.d4(1);
        }
        return this.f63459e;
    }
}
