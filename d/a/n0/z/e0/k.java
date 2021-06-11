package d.a.n0.z.e0;

import com.baidu.adp.BdUniqueId;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TiebaStaticHelper;
import com.baidu.tbadk.core.util.YYLiveUtil;
import d.a.m0.r.q.a2;
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
    public static final BdUniqueId F0 = BdUniqueId.gen();
    public static final BdUniqueId G0 = BdUniqueId.gen();
    public static final BdUniqueId M0 = BdUniqueId.gen();
    public static final BdUniqueId N0 = BdUniqueId.gen();

    public static boolean i0(a2 a2Var) {
        if (a2Var == null) {
            return false;
        }
        return a2Var.getType() == a2.M2 || a2Var.getType() == a2.i3 || a2Var.getType() == a2.h3 || a2Var.getType() == a2.o3 || a2Var.getType() == a2.t3;
    }

    public static boolean j0(a2 a2Var) {
        if (a2Var == null) {
            return false;
        }
        return a2Var.getType() == a2.v3 || a2Var.getType() == a2.w3;
    }

    @Override // d.a.n0.z.e0.b
    public StatisticItem A(String str) {
        int i2;
        StatisticItem statisticItem = new StatisticItem(str);
        a2 a2Var = this.f67177e;
        if (a2Var != null) {
            if (a2Var.V() == null) {
                statisticItem.param("fid", this.f67177e.c0());
                statisticItem.param("tid", this.f67177e.z1());
            } else {
                statisticItem.param("tid", this.f67177e.V().oriUgcNid);
            }
            if (this.f67177e.D2()) {
                i2 = 2;
            } else if (this.f67177e.i2()) {
                i2 = 4;
            } else {
                a2 a2Var2 = this.f67177e;
                if (a2Var2.u1) {
                    i2 = 5;
                } else if (a2Var2.R1()) {
                    i2 = 6;
                } else if (this.f67177e.S1()) {
                    i2 = 7;
                } else if (this.f67177e.U1()) {
                    i2 = 8;
                } else {
                    i2 = this.f67177e.T1() ? 9 : 1;
                }
            }
            statisticItem.param("obj_type", i2);
            statisticItem.param("obj_id", this.f67177e.T().getUserId());
            statisticItem.param("obj_param1", P() ? 2 : 1);
        }
        return statisticItem;
    }

    @Override // d.a.n0.z.e0.b
    public StatisticItem C() {
        if (h0()) {
            return G(c0);
        }
        if (l.d0(this.f67177e)) {
            StatisticItem I = I(k0, true);
            if (I != null && i() != null) {
                a2 i2 = i();
                if (i2.V() != null) {
                    I.param(TiebaStatic.Params.OBJ_PARAM4, i2.V().oriUgcNid);
                    I.param(TiebaStatic.Params.OBJ_PARAM6, i2.V().oriUgcVid);
                }
                I.param(TiebaStatic.Params.OBJ_PARAM5, k0(i2));
            }
            return I;
        }
        StatisticItem H = H(X, 0);
        if (H != null) {
            H.param("ab_tag", z()).param(TiebaStatic.Params.AB_ACTION, PrefetchEvent.STATE_CLICK);
            if (i() != null) {
                a2 i3 = i();
                if (i3.V() != null) {
                    H.param(TiebaStatic.Params.OBJ_PARAM4, i3.V().oriUgcNid);
                }
                H.param(TiebaStatic.Params.OBJ_PARAM5, k0(i3));
                H.param("nid", i3.M0());
            }
        }
        return H;
    }

    @Override // d.a.n0.z.e0.b
    public StatisticItem K() {
        StatisticItem G;
        SmartApp l1;
        if (h0()) {
            G = G(b0);
        } else if (g0()) {
            StatisticItem G2 = G(h0);
            if (G2 != null && i() != null && (l1 = i().l1()) != null) {
                TiebaStatic.deleteParamByKey(G2, "obj_type");
                G2.param("obj_type", l1.id);
                G2.param("obj_name", l1.name);
            }
            return G2;
        } else {
            G = G(W);
            if (G != null) {
                G.param(TiebaStatic.Params.AB_ACTION, PrefetchEvent.STATE_CLICK);
                if (i() != null) {
                    a2 i2 = i();
                    if (i2.V() != null) {
                        G.param(TiebaStatic.Params.OBJ_PARAM4, i2.V().oriUgcNid);
                    }
                    G.param(TiebaStatic.Params.OBJ_PARAM5, k0(i2));
                }
            }
        }
        if (G != null && i() != null) {
            G.param(TiebaStatic.Params.IS_FULL, i().v2() ? 1 : 0);
        }
        return G;
    }

    @Override // d.a.n0.z.e0.b
    public StatisticItem L() {
        SmartApp l1;
        int i2 = 0;
        int i3 = 1;
        if (h0()) {
            StatisticItem G = G(a0);
            if (G != null) {
                G.setPosition(this.position);
                if (i() != null) {
                    a2 i4 = i();
                    if (i4.C1() != null && (i4.C1().K() != null || i4.C1().V() != null)) {
                        i2 = 1;
                    }
                    G.param("obj_name", i2);
                    if (i4.T() != null) {
                        G.param(TiebaStatic.Params.AB_TYPE, i4.T().hadConcerned() ? 1 : 0);
                    }
                    G.param(TiebaStatic.Params.IS_FULL, i4.v2() ? 1 : 0);
                }
            }
            return G;
        } else if (g0()) {
            StatisticItem G2 = G(g0);
            if (G2 != null) {
                G2.setPosition(this.position);
                if (i() != null && (l1 = i().l1()) != null) {
                    TiebaStatic.deleteParamByKey(G2, "obj_type");
                    G2.param("obj_type", l1.id);
                    G2.param("obj_name", l1.name);
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
                if (i() != null) {
                    a2 i5 = i();
                    int i6 = (i5.C1() == null || (i5.C1().K() == null && i5.C1().V() == null)) ? 0 : 1;
                    G3.param("obj_name", i6);
                    if (i6 != 0 && i5.C1().K() != null && i5.C1().K().y() != null && i5.C1().K().y().size() > 0) {
                        G3.param(TiebaStatic.Params.OBJ_TO, i5.C1().N ? 2 : 1);
                    }
                    if (i5.T() != null) {
                        G3.param(TiebaStatic.Params.AB_TYPE, i5.T().hadConcerned() ? 1 : 0);
                    }
                    G3.param(TiebaStatic.Params.IS_FULL, i5.v2() ? 1 : 0);
                    if (i5.V() != null) {
                        G3.param(TiebaStatic.Params.OBJ_PARAM4, i5.V().oriUgcNid);
                    }
                    G3.param(TiebaStatic.Params.OBJ_PARAM5, k0(i5));
                    if (i5.P1()) {
                        G3.param(TiebaStatic.Params.OBJ_PARAM6, 2);
                    } else {
                        G3.param(TiebaStatic.Params.OBJ_PARAM6, 1);
                    }
                    if (i5.e2()) {
                        G3.param(TiebaStatic.Params.GUA_TYPE, 1);
                    } else if (i5.z0() != null) {
                        G3.param(TiebaStatic.Params.GUA_TYPE, 2);
                    } else {
                        G3.param(TiebaStatic.Params.GUA_TYPE, 0);
                    }
                    if (i5.T() != null && i5.T().getAlaInfo() != null) {
                        int calculateLiveType = YYLiveUtil.calculateLiveType(i5.T().getAlaInfo());
                        if (i5.T().getAlaInfo().live_status != 1 && i5.T().getAlaInfo().friendRoomStatus != 2) {
                            i3 = 2;
                        }
                        if (i5.T().getAlaInfo().mYyExtData != null) {
                            TiebaStaticHelper.addYYParam(G3, i5.T().getAlaInfo().mYyExtData);
                        }
                        G3.param(TiebaStatic.Params.OBJ_PARAM7, i3);
                        G3.param(TiebaStatic.Params.OBJ_PARAM8, calculateLiveType);
                    }
                }
            }
            return G3;
        }
    }

    @Override // d.a.n0.z.e0.b
    public StatisticItem N() {
        StatisticItem I = I(i0, true);
        if (i() != null) {
            a2 i2 = i();
            if (i2.V() != null) {
                I.param(TiebaStatic.Params.OBJ_PARAM4, i2.V().oriUgcNid);
                I.param(TiebaStatic.Params.OBJ_PARAM6, i2.V().oriUgcVid);
            }
            I.param(TiebaStatic.Params.OBJ_PARAM5, k0(i2));
        }
        return I;
    }

    @Override // d.a.n0.z.e0.b
    public boolean Q() {
        a2 a2Var = this.f67177e;
        return a2Var != null && a2Var.D2();
    }

    public int Z(a2 a2Var) {
        if (a2Var == null) {
            return 0;
        }
        if (a2Var.R1()) {
            return 1;
        }
        if (a2Var.D2()) {
            return 2;
        }
        if (a2Var.S1()) {
            return 3;
        }
        return a2Var.T1() ? 4 : 0;
    }

    public StatisticItem a0(String str) {
        StatisticItem G = G(str);
        if (G != null) {
            G.param("ab_tag", z()).param(TiebaStatic.Params.AB_ACTION, "show");
            if (i() != null) {
                a2 i2 = i();
                int i3 = (i2.C1() == null || (i2.C1().K() == null && i2.C1().V() == null)) ? 0 : 1;
                G.param("obj_name", i3);
                if (i3 != 0 && i2.C1().K() != null && i2.C1().K().y() != null && i2.C1().K().y().size() > 0) {
                    G.param(TiebaStatic.Params.OBJ_TO, i2.C1().N ? 2 : 1);
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
            if (i() != null) {
                a2 i2 = i();
                if (i2.V() != null) {
                    G.param(TiebaStatic.Params.OBJ_PARAM4, i2.V().oriUgcNid);
                }
                G.param(TiebaStatic.Params.OBJ_PARAM5, k0(i2));
            }
        }
        return G;
    }

    public StatisticItem c0(String str) {
        return G(str);
    }

    public StatisticItem d0(String str) {
        StatisticItem G = G(str);
        a2 a2Var = this.f67177e;
        if (a2Var != null && a2Var.T() != null) {
            G.param(TiebaStatic.Params.AB_TYPE, this.f67177e.T().hadConcerned() ? 1 : 0);
        }
        return G;
    }

    public StatisticItem e0() {
        if (l.d0(this.f67177e)) {
            StatisticItem I = I(j0, true);
            if (I != null && i() != null) {
                a2 i2 = i();
                if (i2.V() != null) {
                    I.param(TiebaStatic.Params.OBJ_PARAM4, i2.V().oriUgcNid);
                    I.param(TiebaStatic.Params.OBJ_PARAM6, i2.V().oriUgcVid);
                }
                I.param(TiebaStatic.Params.OBJ_PARAM5, k0(i2));
                if (i2.P1()) {
                    I.addParam(TiebaStatic.Params.OBJ_PARAM2, 2);
                } else {
                    I.addParam(TiebaStatic.Params.OBJ_PARAM2, 1);
                }
                if (i2.T() != null && i2.T().getAlaInfo() != null) {
                    int calculateLiveType = YYLiveUtil.calculateLiveType(i2.T().getAlaInfo());
                    if (i2.T().getAlaInfo().mYyExtData != null) {
                        TiebaStaticHelper.addYYParam(I, i2.T().getAlaInfo().mYyExtData);
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
                if (i() != null) {
                    a2 i3 = i();
                    if (i3.V() != null) {
                        G.param(TiebaStatic.Params.OBJ_PARAM4, i3.V().oriUgcNid);
                    }
                    G.param(TiebaStatic.Params.OBJ_PARAM5, k0(i3));
                    G.param("nid", i3.M0());
                    if (i3.P1()) {
                        G.param(TiebaStatic.Params.OBJ_PARAM2, 2);
                    } else {
                        G.param(TiebaStatic.Params.OBJ_PARAM2, 1);
                    }
                    if (i3.T() != null && i3.T().getAlaInfo() != null) {
                        int calculateLiveType2 = YYLiveUtil.calculateLiveType(i3.T().getAlaInfo());
                        if (i3.T().getAlaInfo().mYyExtData != null) {
                            TiebaStaticHelper.addYYParam(G, i3.T().getAlaInfo().mYyExtData);
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
        a2 a2Var = this.f67177e;
        return a2Var == null || a2Var.w2();
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.k.e.n
    public BdUniqueId getType() {
        OriginalThreadInfo originalThreadInfo;
        int indexOf;
        int indexOf2;
        a2 a2Var = this.f67177e;
        if (a2Var == null) {
            return m0;
        }
        if (this.F && b.S.length > 1) {
            BdUniqueId type = a2Var.getType();
            if (type == a2.M2 || type == a2.h3 || type == a2.t3 || type == a2.i3) {
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
        a2 a2Var2 = this.f67177e;
        int i2 = a2Var2.Z;
        if (i2 == 63) {
            return t0;
        }
        if (i2 == 64) {
            return u0;
        }
        if (a2Var2.u1 && (originalThreadInfo = a2Var2.t1) != null) {
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
                return F0;
            }
            if (this.z) {
                return G0;
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
        a2 a2Var = this.f67177e;
        return (a2Var == null || ListUtils.getCount(a2Var.K1()) == 0) ? false : true;
    }

    @Override // d.a.n0.z.e0.b, d.a.m0.r.q.a
    public a2 i() {
        a2 a2Var = this.f67177e;
        if (a2Var == null) {
            return null;
        }
        if (a2Var.c1() == 5) {
            return this.f67177e;
        }
        this.f67177e.e4(1);
        return this.f67177e;
    }

    public int k0(a2 a2Var) {
        if (a2Var == null) {
            return 1;
        }
        if (a2Var.T1() || a2Var.S1()) {
            return 2;
        }
        return (a2Var.R1() || a2Var.U1()) ? 3 : 1;
    }
}
