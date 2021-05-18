package d.a.k0.x.e0;

import com.baidu.adp.BdUniqueId;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TiebaStaticHelper;
import com.baidu.tbadk.core.util.YYLiveUtil;
import d.a.j0.r.q.a2;
import tbclient.SmartApp;
/* loaded from: classes4.dex */
public class k extends b {
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
    public static String l0 = "";
    public boolean T = false;
    public boolean U = true;
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
    public static final BdUniqueId M0 = BdUniqueId.gen();
    public static final BdUniqueId N0 = BdUniqueId.gen();

    public static boolean i0(a2 a2Var) {
        if (a2Var == null) {
            return false;
        }
        return a2Var.getType() == a2.I2 || a2Var.getType() == a2.e3 || a2Var.getType() == a2.d3 || a2Var.getType() == a2.k3 || a2Var.getType() == a2.p3;
    }

    public static boolean j0(a2 a2Var) {
        if (a2Var == null) {
            return false;
        }
        return a2Var.getType() == a2.r3 || a2Var.getType() == a2.s3;
    }

    @Override // d.a.k0.x.e0.b
    public StatisticItem A(String str) {
        int i2;
        StatisticItem statisticItem = new StatisticItem(str);
        a2 a2Var = this.f63179e;
        if (a2Var != null) {
            if (a2Var.V() == null) {
                statisticItem.param("fid", this.f63179e.c0());
                statisticItem.param("tid", this.f63179e.x1());
            } else {
                statisticItem.param("tid", this.f63179e.V().oriUgcNid);
            }
            if (this.f63179e.B2()) {
                i2 = 2;
            } else if (this.f63179e.g2()) {
                i2 = 4;
            } else {
                a2 a2Var2 = this.f63179e;
                if (a2Var2.s1) {
                    i2 = 5;
                } else if (a2Var2.P1()) {
                    i2 = 6;
                } else if (this.f63179e.Q1()) {
                    i2 = 7;
                } else if (this.f63179e.S1()) {
                    i2 = 8;
                } else {
                    i2 = this.f63179e.R1() ? 9 : 1;
                }
            }
            statisticItem.param("obj_type", i2);
            statisticItem.param("obj_id", this.f63179e.T().getUserId());
            statisticItem.param("obj_param1", P() ? 2 : 1);
        }
        return statisticItem;
    }

    @Override // d.a.k0.x.e0.b
    public StatisticItem C() {
        if (h0()) {
            return G(c0);
        }
        if (l.d0(this.f63179e)) {
            StatisticItem I = I(k0, true);
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
        StatisticItem H = H(X, 0);
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

    @Override // d.a.k0.x.e0.b
    public StatisticItem K() {
        StatisticItem G;
        SmartApp j1;
        if (h0()) {
            G = G(b0);
        } else if (g0()) {
            StatisticItem G2 = G(h0);
            if (G2 != null && m() != null && (j1 = m().j1()) != null) {
                TiebaStatic.deleteParamByKey(G2, "obj_type");
                G2.param("obj_type", j1.id);
                G2.param("obj_name", j1.name);
            }
            return G2;
        } else {
            G = G(W);
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
            G.param(TiebaStatic.Params.IS_FULL, m().t2() ? 1 : 0);
        }
        return G;
    }

    @Override // d.a.k0.x.e0.b
    public StatisticItem L() {
        SmartApp j1;
        int i2 = 0;
        int i3 = 1;
        if (h0()) {
            StatisticItem G = G(a0);
            if (G != null) {
                G.setPosition(this.position);
                if (m() != null) {
                    a2 m = m();
                    if (m.A1() != null && (m.A1().K() != null || m.A1().V() != null)) {
                        i2 = 1;
                    }
                    G.param("obj_name", i2);
                    if (m.T() != null) {
                        G.param(TiebaStatic.Params.AB_TYPE, m.T().hadConcerned() ? 1 : 0);
                    }
                    G.param(TiebaStatic.Params.IS_FULL, m.t2() ? 1 : 0);
                }
            }
            return G;
        } else if (g0()) {
            StatisticItem G2 = G(g0);
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
            StatisticItem G3 = G(V);
            if (G3 != null) {
                G3.setPosition(this.position);
                G3.param(TiebaStatic.Params.AB_ACTION, "show");
                if (m() != null) {
                    a2 m2 = m();
                    int i4 = (m2.A1() == null || (m2.A1().K() == null && m2.A1().V() == null)) ? 0 : 1;
                    G3.param("obj_name", i4);
                    if (i4 != 0 && m2.A1().K() != null && m2.A1().K().u() != null && m2.A1().K().u().size() > 0) {
                        G3.param(TiebaStatic.Params.OBJ_TO, m2.A1().N ? 2 : 1);
                    }
                    if (m2.T() != null) {
                        G3.param(TiebaStatic.Params.AB_TYPE, m2.T().hadConcerned() ? 1 : 0);
                    }
                    G3.param(TiebaStatic.Params.IS_FULL, m2.t2() ? 1 : 0);
                    if (m2.V() != null) {
                        G3.param(TiebaStatic.Params.OBJ_PARAM4, m2.V().oriUgcNid);
                    }
                    G3.param(TiebaStatic.Params.OBJ_PARAM5, k0(m2));
                    if (m2.N1()) {
                        G3.param(TiebaStatic.Params.OBJ_PARAM6, 2);
                    } else {
                        G3.param(TiebaStatic.Params.OBJ_PARAM6, 1);
                    }
                    if (m2.c2()) {
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

    @Override // d.a.k0.x.e0.b
    public StatisticItem N() {
        StatisticItem I = I(i0, true);
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

    @Override // d.a.k0.x.e0.b
    public boolean Q() {
        a2 a2Var = this.f63179e;
        return a2Var != null && a2Var.B2();
    }

    public int Z(a2 a2Var) {
        if (a2Var == null) {
            return 0;
        }
        if (a2Var.P1()) {
            return 1;
        }
        if (a2Var.B2()) {
            return 2;
        }
        if (a2Var.Q1()) {
            return 3;
        }
        return a2Var.R1() ? 4 : 0;
    }

    public StatisticItem a0(String str) {
        StatisticItem G = G(str);
        if (G != null) {
            G.param("ab_tag", z()).param(TiebaStatic.Params.AB_ACTION, "show");
            if (m() != null) {
                a2 m = m();
                int i2 = (m.A1() == null || (m.A1().K() == null && m.A1().V() == null)) ? 0 : 1;
                G.param("obj_name", i2);
                if (i2 != 0 && m.A1().K() != null && m.A1().K().u() != null && m.A1().K().u().size() > 0) {
                    G.param(TiebaStatic.Params.OBJ_TO, m.A1().N ? 2 : 1);
                }
            }
        }
        return G;
    }

    public StatisticItem b0() {
        if (h0()) {
            return G(e0);
        }
        StatisticItem G = G(Z);
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
        a2 a2Var = this.f63179e;
        if (a2Var != null && a2Var.T() != null) {
            G.param(TiebaStatic.Params.AB_TYPE, this.f63179e.T().hadConcerned() ? 1 : 0);
        }
        return G;
    }

    public StatisticItem e0() {
        if (l.d0(this.f63179e)) {
            StatisticItem I = I(j0, true);
            if (I != null && m() != null) {
                a2 m = m();
                if (m.V() != null) {
                    I.param(TiebaStatic.Params.OBJ_PARAM4, m.V().oriUgcNid);
                    I.param(TiebaStatic.Params.OBJ_PARAM6, m.V().oriUgcVid);
                }
                I.param(TiebaStatic.Params.OBJ_PARAM5, k0(m));
                if (m.N1()) {
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
            return G(d0);
        } else {
            StatisticItem G = G(Y);
            if (G != null) {
                G.param("ab_tag", z()).param(TiebaStatic.Params.AB_ACTION, PrefetchEvent.STATE_CLICK);
                if (m() != null) {
                    a2 m2 = m();
                    if (m2.V() != null) {
                        G.param(TiebaStatic.Params.OBJ_PARAM4, m2.V().oriUgcNid);
                    }
                    G.param(TiebaStatic.Params.OBJ_PARAM5, k0(m2));
                    G.param("nid", m2.L0());
                    if (m2.N1()) {
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
        return G(f0);
    }

    public boolean g0() {
        a2 a2Var = this.f63179e;
        return a2Var == null || a2Var.u2();
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.j.e.n
    public BdUniqueId getType() {
        OriginalThreadInfo originalThreadInfo;
        int indexOf;
        int indexOf2;
        a2 a2Var = this.f63179e;
        if (a2Var == null) {
            return m0;
        }
        if (this.F && b.S.length > 1) {
            BdUniqueId type = a2Var.getType();
            if (type == a2.I2 || type == a2.d3 || type == a2.p3 || type == a2.e3) {
                if (this.s) {
                    indexOf = b.Q.indexOf(b.H);
                } else {
                    indexOf = b.Q.indexOf(b.G);
                }
                if (this.t) {
                    indexOf2 = b.R.indexOf(b.I);
                } else if (this.v) {
                    indexOf2 = b.R.indexOf(b.K);
                } else if (this.u) {
                    indexOf2 = b.R.indexOf(b.J);
                } else {
                    indexOf2 = b.R.indexOf(b.L);
                }
                if (indexOf >= 0) {
                    BdUniqueId[][] bdUniqueIdArr = b.S;
                    return (indexOf >= bdUniqueIdArr.length || indexOf2 < 0 || indexOf2 >= bdUniqueIdArr[0].length) ? type : bdUniqueIdArr[indexOf][indexOf2];
                }
                return type;
            }
            return type;
        }
        a2 a2Var2 = this.f63179e;
        int i2 = a2Var2.Z;
        if (i2 == 63) {
            return t0;
        }
        if (i2 == 64) {
            return u0;
        }
        if (a2Var2.s1 && (originalThreadInfo = a2Var2.r1) != null) {
            if (originalThreadInfo.u) {
                if (originalThreadInfo.r != null) {
                    return s0;
                }
                if (originalThreadInfo.d()) {
                    return r0;
                }
                return q0;
            }
            return p0;
        } else if (this.r) {
            return w0;
        } else {
            if (this.w) {
                return y0;
            }
            if (this.u) {
                return z0;
            }
            if (this.v) {
                return A0;
            }
            if (this.t) {
                return B0;
            }
            if (this.E) {
                return C0;
            }
            if (this.C) {
                return E0;
            }
            if (this.B) {
                return D0;
            }
            if (this.s) {
                return x0;
            }
            if (this.y) {
                return K0;
            }
            if (this.z) {
                return L0;
            }
            if (this.A) {
                return M0;
            }
            if (this.D) {
                return N0;
            }
            return m0;
        }
    }

    public boolean h0() {
        a2 a2Var = this.f63179e;
        return (a2Var == null || ListUtils.getCount(a2Var.I1()) == 0) ? false : true;
    }

    public int k0(a2 a2Var) {
        if (a2Var == null) {
            return 1;
        }
        if (a2Var.R1() || a2Var.Q1()) {
            return 2;
        }
        return (a2Var.P1() || a2Var.S1()) ? 3 : 1;
    }

    @Override // d.a.k0.x.e0.b, d.a.j0.r.q.a
    public a2 m() {
        a2 a2Var = this.f63179e;
        if (a2Var == null) {
            return null;
        }
        if (a2Var.a1() == 5) {
            return this.f63179e;
        }
        this.f63179e.c4(1);
        return this.f63179e;
    }
}
