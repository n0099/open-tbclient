package d.a.j0.x.e0;

import com.baidu.adp.BdUniqueId;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TiebaStaticHelper;
import com.baidu.tbadk.core.util.YYLiveUtil;
import d.a.i0.r.q.a2;
import tbclient.SmartApp;
/* loaded from: classes4.dex */
public class k extends b {
    public static String U = "";
    public static String V = "";
    public static String W = "";
    public static String X = "";
    public static String Y = "";
    public static String Z = "";
    public static String a0 = "";
    public static String b0 = "";
    public static String c0 = "";
    public static String d0 = "";
    public static String e0 = "";
    public static String f0 = "";
    public static String g0 = "";
    public static String h0 = "";
    public static String i0 = "";
    public static String j0 = "";
    public static String k0 = "";
    public boolean S = false;
    public boolean T = true;
    public static final BdUniqueId l0 = BdUniqueId.gen();
    public static final BdUniqueId m0 = BdUniqueId.gen();
    public static final BdUniqueId n0 = BdUniqueId.gen();
    public static final BdUniqueId o0 = BdUniqueId.gen();
    public static final BdUniqueId p0 = BdUniqueId.gen();
    public static final BdUniqueId q0 = BdUniqueId.gen();
    public static final BdUniqueId r0 = BdUniqueId.gen();
    public static final BdUniqueId s0 = BdUniqueId.gen();
    public static final BdUniqueId t0 = BdUniqueId.gen();
    public static final BdUniqueId u0 = BdUniqueId.gen();
    public static final BdUniqueId v0 = BdUniqueId.gen();
    public static final BdUniqueId w0 = BdUniqueId.gen();
    public static final BdUniqueId x0 = BdUniqueId.gen();
    public static final BdUniqueId y0 = BdUniqueId.gen();
    public static final BdUniqueId z0 = BdUniqueId.gen();
    public static final BdUniqueId A0 = BdUniqueId.gen();
    public static final BdUniqueId B0 = BdUniqueId.gen();
    public static final BdUniqueId C0 = BdUniqueId.gen();
    public static final BdUniqueId D0 = BdUniqueId.gen();
    public static final BdUniqueId E0 = BdUniqueId.gen();
    public static final BdUniqueId K0 = BdUniqueId.gen();
    public static final BdUniqueId L0 = BdUniqueId.gen();

    public static boolean i0(a2 a2Var) {
        if (a2Var == null) {
            return false;
        }
        return a2Var.getType() == a2.H2 || a2Var.getType() == a2.d3 || a2Var.getType() == a2.c3 || a2Var.getType() == a2.j3 || a2Var.getType() == a2.o3;
    }

    public static boolean j0(a2 a2Var) {
        if (a2Var == null) {
            return false;
        }
        return a2Var.getType() == a2.q3 || a2Var.getType() == a2.r3;
    }

    @Override // d.a.j0.x.e0.b
    public StatisticItem A(String str) {
        int i2;
        StatisticItem statisticItem = new StatisticItem(str);
        a2 a2Var = this.f62455e;
        if (a2Var != null) {
            if (a2Var.V() == null) {
                statisticItem.param("fid", this.f62455e.c0());
                statisticItem.param("tid", this.f62455e.w1());
            } else {
                statisticItem.param("tid", this.f62455e.V().oriUgcNid);
            }
            if (this.f62455e.z2()) {
                i2 = 2;
            } else if (this.f62455e.f2()) {
                i2 = 4;
            } else {
                a2 a2Var2 = this.f62455e;
                if (a2Var2.s1) {
                    i2 = 5;
                } else if (a2Var2.O1()) {
                    i2 = 6;
                } else if (this.f62455e.P1()) {
                    i2 = 7;
                } else if (this.f62455e.R1()) {
                    i2 = 8;
                } else {
                    i2 = this.f62455e.Q1() ? 9 : 1;
                }
            }
            statisticItem.param("obj_type", i2);
            statisticItem.param("obj_id", this.f62455e.T().getUserId());
            statisticItem.param("obj_param1", P() ? 2 : 1);
        }
        return statisticItem;
    }

    @Override // d.a.j0.x.e0.b
    public StatisticItem C() {
        if (h0()) {
            return G(b0);
        }
        if (l.d0(this.f62455e)) {
            StatisticItem I = I(j0, true);
            if (I != null && m() != null) {
                a2 m = m();
                if (m.V() != null) {
                    I.param(TiebaStatic.Params.OBJ_PARAM4, m.V().oriUgcNid);
                    I.param(TiebaStatic.Params.OBJ_PARAM6, m.V().oriUgcVid);
                }
                I.param(TiebaStatic.Params.OBJ_PARAM5, k0(m));
            }
            return I;
        }
        StatisticItem H = H(W, 0);
        if (H != null) {
            H.param("ab_tag", z()).param(TiebaStatic.Params.AB_ACTION, PrefetchEvent.STATE_CLICK);
            if (m() != null) {
                a2 m2 = m();
                if (m2.V() != null) {
                    H.param(TiebaStatic.Params.OBJ_PARAM4, m2.V().oriUgcNid);
                }
                H.param(TiebaStatic.Params.OBJ_PARAM5, k0(m2));
                H.param("nid", m2.L0());
            }
        }
        return H;
    }

    @Override // d.a.j0.x.e0.b
    public StatisticItem K() {
        StatisticItem G;
        SmartApp j1;
        if (h0()) {
            G = G(a0);
        } else if (g0()) {
            StatisticItem G2 = G(g0);
            if (G2 != null && m() != null && (j1 = m().j1()) != null) {
                TiebaStatic.deleteParamByKey(G2, "obj_type");
                G2.param("obj_type", j1.id);
                G2.param("obj_name", j1.name);
            }
            return G2;
        } else {
            G = G(V);
            if (G != null) {
                G.param(TiebaStatic.Params.AB_ACTION, PrefetchEvent.STATE_CLICK);
                if (m() != null) {
                    a2 m = m();
                    if (m.V() != null) {
                        G.param(TiebaStatic.Params.OBJ_PARAM4, m.V().oriUgcNid);
                    }
                    G.param(TiebaStatic.Params.OBJ_PARAM5, k0(m));
                }
            }
        }
        if (G != null && m() != null) {
            G.param(TiebaStatic.Params.IS_FULL, m().r2() ? 1 : 0);
        }
        return G;
    }

    @Override // d.a.j0.x.e0.b
    public StatisticItem L() {
        SmartApp j1;
        int i2 = 0;
        int i3 = 1;
        if (h0()) {
            StatisticItem G = G(Z);
            if (G != null) {
                G.setPosition(this.position);
                if (m() != null) {
                    a2 m = m();
                    if (m.z1() != null && (m.z1().K() != null || m.z1().V() != null)) {
                        i2 = 1;
                    }
                    G.param("obj_name", i2);
                    if (m.T() != null) {
                        G.param(TiebaStatic.Params.AB_TYPE, m.T().hadConcerned() ? 1 : 0);
                    }
                    G.param(TiebaStatic.Params.IS_FULL, m.r2() ? 1 : 0);
                }
            }
            return G;
        } else if (g0()) {
            StatisticItem G2 = G(f0);
            if (G2 != null) {
                G2.setPosition(this.position);
                if (m() != null && (j1 = m().j1()) != null) {
                    TiebaStatic.deleteParamByKey(G2, "obj_type");
                    G2.param("obj_type", j1.id);
                    G2.param("obj_name", j1.name);
                }
            }
            return G2;
        } else if (Q()) {
            return null;
        } else {
            StatisticItem G3 = G(U);
            if (G3 != null) {
                G3.setPosition(this.position);
                G3.param(TiebaStatic.Params.AB_ACTION, "show");
                if (m() != null) {
                    a2 m2 = m();
                    int i4 = (m2.z1() == null || (m2.z1().K() == null && m2.z1().V() == null)) ? 0 : 1;
                    G3.param("obj_name", i4);
                    if (i4 != 0 && m2.z1().K() != null && m2.z1().K().u() != null && m2.z1().K().u().size() > 0) {
                        G3.param(TiebaStatic.Params.OBJ_TO, m2.z1().N ? 2 : 1);
                    }
                    if (m2.T() != null) {
                        G3.param(TiebaStatic.Params.AB_TYPE, m2.T().hadConcerned() ? 1 : 0);
                    }
                    G3.param(TiebaStatic.Params.IS_FULL, m2.r2() ? 1 : 0);
                    if (m2.V() != null) {
                        G3.param(TiebaStatic.Params.OBJ_PARAM4, m2.V().oriUgcNid);
                    }
                    G3.param(TiebaStatic.Params.OBJ_PARAM5, k0(m2));
                    if (m2.M1()) {
                        G3.param(TiebaStatic.Params.OBJ_PARAM6, 2);
                    } else {
                        G3.param(TiebaStatic.Params.OBJ_PARAM6, 1);
                    }
                    if (m2.b2()) {
                        G3.param(TiebaStatic.Params.GUA_TYPE, 1);
                    } else if (m2.y0() != null) {
                        G3.param(TiebaStatic.Params.GUA_TYPE, 2);
                    } else {
                        G3.param(TiebaStatic.Params.GUA_TYPE, 0);
                    }
                    if (m2.T() != null && m2.T().getAlaInfo() != null) {
                        int calculateLiveType = YYLiveUtil.calculateLiveType(m2.T().getAlaInfo());
                        if (m2.T().getAlaInfo().live_status != 1 && m2.T().getAlaInfo().friendRoomStatus != 2) {
                            i3 = 2;
                        }
                        if (m2.T().getAlaInfo().mYyExtData != null) {
                            TiebaStaticHelper.addYYParam(G3, m2.T().getAlaInfo().mYyExtData);
                        }
                        G3.param(TiebaStatic.Params.OBJ_PARAM7, i3);
                        G3.param(TiebaStatic.Params.OBJ_PARAM8, calculateLiveType);
                    }
                }
            }
            return G3;
        }
    }

    @Override // d.a.j0.x.e0.b
    public StatisticItem N() {
        StatisticItem I = I(h0, true);
        if (m() != null) {
            a2 m = m();
            if (m.V() != null) {
                I.param(TiebaStatic.Params.OBJ_PARAM4, m.V().oriUgcNid);
                I.param(TiebaStatic.Params.OBJ_PARAM6, m.V().oriUgcVid);
            }
            I.param(TiebaStatic.Params.OBJ_PARAM5, k0(m));
        }
        return I;
    }

    @Override // d.a.j0.x.e0.b
    public boolean Q() {
        a2 a2Var = this.f62455e;
        return a2Var != null && a2Var.z2();
    }

    public int Z(a2 a2Var) {
        if (a2Var == null) {
            return 0;
        }
        if (a2Var.O1()) {
            return 1;
        }
        if (a2Var.z2()) {
            return 2;
        }
        if (a2Var.P1()) {
            return 3;
        }
        return a2Var.Q1() ? 4 : 0;
    }

    public StatisticItem a0(String str) {
        StatisticItem G = G(str);
        if (G != null) {
            G.param("ab_tag", z()).param(TiebaStatic.Params.AB_ACTION, "show");
            if (m() != null) {
                a2 m = m();
                int i2 = (m.z1() == null || (m.z1().K() == null && m.z1().V() == null)) ? 0 : 1;
                G.param("obj_name", i2);
                if (i2 != 0 && m.z1().K() != null && m.z1().K().u() != null && m.z1().K().u().size() > 0) {
                    G.param(TiebaStatic.Params.OBJ_TO, m.z1().N ? 2 : 1);
                }
            }
        }
        return G;
    }

    public StatisticItem b0() {
        if (h0()) {
            return G(d0);
        }
        StatisticItem G = G(Y);
        if (G != null) {
            G.param(TiebaStatic.Params.AB_ACTION, PrefetchEvent.STATE_CLICK);
            if (m() != null) {
                a2 m = m();
                if (m.V() != null) {
                    G.param(TiebaStatic.Params.OBJ_PARAM4, m.V().oriUgcNid);
                }
                G.param(TiebaStatic.Params.OBJ_PARAM5, k0(m));
            }
        }
        return G;
    }

    public StatisticItem c0(String str) {
        return G(str);
    }

    public StatisticItem d0(String str) {
        StatisticItem G = G(str);
        a2 a2Var = this.f62455e;
        if (a2Var != null && a2Var.T() != null) {
            G.param(TiebaStatic.Params.AB_TYPE, this.f62455e.T().hadConcerned() ? 1 : 0);
        }
        return G;
    }

    public StatisticItem e0() {
        if (l.d0(this.f62455e)) {
            StatisticItem I = I(i0, true);
            if (I != null && m() != null) {
                a2 m = m();
                if (m.V() != null) {
                    I.param(TiebaStatic.Params.OBJ_PARAM4, m.V().oriUgcNid);
                    I.param(TiebaStatic.Params.OBJ_PARAM6, m.V().oriUgcVid);
                }
                I.param(TiebaStatic.Params.OBJ_PARAM5, k0(m));
                if (m.M1()) {
                    I.addParam(TiebaStatic.Params.OBJ_PARAM2, 2);
                } else {
                    I.addParam(TiebaStatic.Params.OBJ_PARAM2, 1);
                }
                if (m.T() != null && m.T().getAlaInfo() != null) {
                    int calculateLiveType = YYLiveUtil.calculateLiveType(m.T().getAlaInfo());
                    if (m.T().getAlaInfo().mYyExtData != null) {
                        TiebaStaticHelper.addYYParam(I, m.T().getAlaInfo().mYyExtData);
                    }
                    I.param(TiebaStatic.Params.OBJ_PARAM7, calculateLiveType);
                }
            }
            return I;
        } else if (h0()) {
            return G(c0);
        } else {
            StatisticItem G = G(X);
            if (G != null) {
                G.param("ab_tag", z()).param(TiebaStatic.Params.AB_ACTION, PrefetchEvent.STATE_CLICK);
                if (m() != null) {
                    a2 m2 = m();
                    if (m2.V() != null) {
                        G.param(TiebaStatic.Params.OBJ_PARAM4, m2.V().oriUgcNid);
                    }
                    G.param(TiebaStatic.Params.OBJ_PARAM5, k0(m2));
                    G.param("nid", m2.L0());
                    if (m2.M1()) {
                        G.param(TiebaStatic.Params.OBJ_PARAM2, 2);
                    } else {
                        G.param(TiebaStatic.Params.OBJ_PARAM2, 1);
                    }
                    if (m2.T() != null && m2.T().getAlaInfo() != null) {
                        int calculateLiveType2 = YYLiveUtil.calculateLiveType(m2.T().getAlaInfo());
                        if (m2.T().getAlaInfo().mYyExtData != null) {
                            TiebaStaticHelper.addYYParam(G, m2.T().getAlaInfo().mYyExtData);
                        }
                        G.param(TiebaStatic.Params.OBJ_PARAM6, calculateLiveType2);
                    }
                }
            }
            return G;
        }
    }

    public StatisticItem f0() {
        return G(e0);
    }

    public boolean g0() {
        a2 a2Var = this.f62455e;
        return a2Var == null || a2Var.s2();
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.j.e.n
    public BdUniqueId getType() {
        OriginalThreadInfo originalThreadInfo;
        int indexOf;
        int indexOf2;
        a2 a2Var = this.f62455e;
        if (a2Var == null) {
            return l0;
        }
        if (this.E && b.R.length > 1) {
            BdUniqueId type = a2Var.getType();
            if (type == a2.H2 || type == a2.c3 || type == a2.o3 || type == a2.d3) {
                if (this.s) {
                    indexOf = b.P.indexOf(b.G);
                } else {
                    indexOf = b.P.indexOf(b.F);
                }
                if (this.t) {
                    indexOf2 = b.Q.indexOf(b.H);
                } else if (this.v) {
                    indexOf2 = b.Q.indexOf(b.J);
                } else if (this.u) {
                    indexOf2 = b.Q.indexOf(b.I);
                } else {
                    indexOf2 = b.Q.indexOf(b.K);
                }
                if (indexOf >= 0) {
                    BdUniqueId[][] bdUniqueIdArr = b.R;
                    return (indexOf >= bdUniqueIdArr.length || indexOf2 < 0 || indexOf2 >= bdUniqueIdArr[0].length) ? type : bdUniqueIdArr[indexOf][indexOf2];
                }
                return type;
            }
            return type;
        }
        a2 a2Var2 = this.f62455e;
        int i2 = a2Var2.Z;
        if (i2 == 63) {
            return s0;
        }
        if (i2 == 64) {
            return t0;
        }
        if (a2Var2.s1 && (originalThreadInfo = a2Var2.r1) != null) {
            if (originalThreadInfo.u) {
                if (originalThreadInfo.r != null) {
                    return r0;
                }
                if (originalThreadInfo.d()) {
                    return q0;
                }
                return p0;
            }
            return o0;
        } else if (this.r) {
            return v0;
        } else {
            if (this.w) {
                return x0;
            }
            if (this.u) {
                return y0;
            }
            if (this.v) {
                return z0;
            }
            if (this.t) {
                return A0;
            }
            if (this.D) {
                return B0;
            }
            if (this.C) {
                return D0;
            }
            if (this.B) {
                return C0;
            }
            if (this.s) {
                return w0;
            }
            if (this.y) {
                return E0;
            }
            if (this.z) {
                return K0;
            }
            if (this.A) {
                return L0;
            }
            return l0;
        }
    }

    public boolean h0() {
        a2 a2Var = this.f62455e;
        return (a2Var == null || ListUtils.getCount(a2Var.H1()) == 0) ? false : true;
    }

    public int k0(a2 a2Var) {
        if (a2Var == null) {
            return 1;
        }
        if (a2Var.Q1() || a2Var.P1()) {
            return 2;
        }
        return (a2Var.O1() || a2Var.R1()) ? 3 : 1;
    }

    @Override // d.a.j0.x.e0.b, d.a.i0.r.q.a
    public a2 m() {
        a2 a2Var = this.f62455e;
        if (a2Var == null) {
            return null;
        }
        if (a2Var.a1() == 5) {
            return this.f62455e;
        }
        this.f62455e.a4(1);
        return this.f62455e;
    }
}
