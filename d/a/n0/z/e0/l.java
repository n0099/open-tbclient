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
        this.f67177e = a2Var;
    }

    public static boolean d0(a2 a2Var) {
        return (a2Var == null || a2Var.x1() == null) ? false : true;
    }

    @Override // d.a.n0.z.e0.b
    public StatisticItem A(String str) {
        StatisticItem statisticItem = new StatisticItem(str);
        a2 a2Var = this.f67177e;
        if (a2Var != null) {
            statisticItem.param("fid", a2Var.c0());
            statisticItem.param("tid", this.f67177e.z1());
            if (this.f67177e.U1()) {
                statisticItem.param("obj_type", 8);
            } else if (this.f67177e.T1()) {
                statisticItem.param("obj_type", 9);
            } else if (this.f67177e.D2()) {
                statisticItem.param("obj_type", 2);
            }
            statisticItem.param("obj_param1", P() ? 2 : 1);
            if (this.f67177e.T() != null) {
                statisticItem.param("obj_id", this.f67177e.T().getUserId());
            }
        }
        return statisticItem;
    }

    @Override // d.a.n0.z.e0.b
    public StatisticItem C() {
        StatisticItem I = I(Y, true);
        if (I != null && i() != null) {
            a2 i2 = i();
            if (i2.V() != null) {
                I.param(TiebaStatic.Params.OBJ_PARAM4, i2.V().oriUgcNid);
                I.param(TiebaStatic.Params.OBJ_PARAM6, i2.V().oriUgcVid);
            }
            I.param(TiebaStatic.Params.OBJ_PARAM5, e0(i2));
        }
        return I;
    }

    @Override // d.a.n0.z.e0.b
    public StatisticItem L() {
        int i2 = 1;
        StatisticItem I = I(Z, true);
        if (I != null && i() != null) {
            a2 i3 = i();
            I.param("obj_name", (i3.C1() == null || (i3.C1().K() == null && i3.C1().V() == null)) ? 0 : 1);
            if (i3.T() != null) {
                I.param(TiebaStatic.Params.AB_TYPE, i3.T().hadConcerned() ? 1 : 0);
            }
            if (i3.V() != null) {
                I.param(TiebaStatic.Params.OBJ_PARAM4, i3.V().oriUgcNid);
                I.param(TiebaStatic.Params.OBJ_PARAM6, i3.V().oriUgcVid);
            }
            I.param(TiebaStatic.Params.OBJ_PARAM5, e0(i3));
            if (i3.P1()) {
                I.param(TiebaStatic.Params.OBJ_TO, 2);
            } else {
                I.param(TiebaStatic.Params.OBJ_TO, 1);
            }
            if (i3.T() != null && i3.T().getAlaInfo() != null) {
                int calculateLiveType = YYLiveUtil.calculateLiveType(i3.T().getAlaInfo());
                if (i3.T().getAlaInfo().live_status != 1 && i3.T().getAlaInfo().friendRoomStatus != 2) {
                    i2 = 2;
                }
                if (i3.T().getAlaInfo().mYyExtData != null) {
                    TiebaStaticHelper.addYYParam(I, i3.T().getAlaInfo().mYyExtData);
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
        if (i() != null) {
            a2 i2 = i();
            if (i2.V() != null) {
                I.param(TiebaStatic.Params.OBJ_PARAM4, i2.V().oriUgcNid);
                I.param(TiebaStatic.Params.OBJ_PARAM6, i2.V().oriUgcVid);
            }
            I.param(TiebaStatic.Params.OBJ_PARAM5, e0(i2));
            I.param("nid", i2.M0());
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
            if (i() != null) {
                a2 i3 = i();
                if (i3.V() != null) {
                    I.param(TiebaStatic.Params.OBJ_PARAM4, i3.V().oriUgcNid);
                    I.param(TiebaStatic.Params.OBJ_PARAM6, i3.V().oriUgcVid);
                }
                I.param(TiebaStatic.Params.OBJ_PARAM5, e0(i3));
            }
        }
        return I;
    }

    public StatisticItem b0() {
        StatisticItem I = I(d0, true);
        if (I != null && i() != null) {
            a2 i2 = i();
            if (i2.V() != null) {
                I.param(TiebaStatic.Params.OBJ_PARAM4, i2.V().oriUgcNid);
                I.param(TiebaStatic.Params.OBJ_PARAM6, i2.V().oriUgcVid);
            }
            I.param(TiebaStatic.Params.OBJ_PARAM5, e0(i2));
        }
        return I;
    }

    public StatisticItem c0(a2 a2Var) {
        StatisticItem I = I(X, true);
        if (I != null && i() != null) {
            a2 i2 = i();
            if (i2.V() != null) {
                I.param(TiebaStatic.Params.OBJ_PARAM4, i2.V().oriUgcNid);
                I.param(TiebaStatic.Params.OBJ_PARAM6, i2.V().oriUgcVid);
                if (i2.P1()) {
                    I.param(TiebaStatic.Params.OBJ_PARAM2, 2);
                } else {
                    I.param(TiebaStatic.Params.OBJ_PARAM2, 1);
                }
            }
            if (i2.T() != null && i2.T().getAlaInfo() != null) {
                int calculateLiveType = YYLiveUtil.calculateLiveType(i2.T().getAlaInfo());
                if (i2.T().getAlaInfo().mYyExtData != null) {
                    TiebaStaticHelper.addYYParam(I, i2.T().getAlaInfo().mYyExtData);
                }
                I.param(TiebaStatic.Params.OBJ_PARAM7, calculateLiveType);
            }
            I.param(TiebaStatic.Params.OBJ_PARAM5, e0(i2));
        }
        return I;
    }

    public int e0(a2 a2Var) {
        if (a2Var == null) {
            return 1;
        }
        if (a2Var.T1() || a2Var.S1()) {
            return 2;
        }
        return (a2Var.R1() || a2Var.U1()) ? 3 : 1;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.k.e.n
    public BdUniqueId getType() {
        a2 a2Var = this.f67177e;
        if (a2Var == null) {
            return k.m0;
        }
        if (this.F) {
            if (this.s) {
                return a2.N2;
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
                return k.F0;
            }
            if (this.z) {
                return k.G0;
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
        a2 a2Var = this.f67177e;
        if (a2Var == null || a2Var.x1() == null || this.f67177e.x1().video_url == null) {
            return null;
        }
        return this.f67177e.x1().video_url;
    }

    @Override // d.a.n0.z.e0.b, d.a.m0.r.q.a
    public a2 i() {
        a2 a2Var = this.f67177e;
        if (a2Var == null) {
            return null;
        }
        if (a2Var.c1() != 5) {
            this.f67177e.e4(1);
        }
        return this.f67177e;
    }
}
