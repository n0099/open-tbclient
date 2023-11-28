package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebChromeClient;
import com.kuaishou.weapon.p0.y;
import java.util.Arrays;
/* loaded from: classes10.dex */
public class df {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String A = "plc002_soc_v";
    public static final String B = "plc002_soc_s";
    public static final String C = "plc002_soc_sna_s";
    public static final String D = "plc002_soc_c";
    public static final String E = "plc002_soc_i";
    public static final String F = "plc002_pp_v";
    public static final String G = "plc002_pp_s";
    public static final String H = "plc002_pp_c";
    public static final String I = "plc002_pp_i";
    public static final String J = "plc002_pp_pcl_gc";
    public static final String K = "plc002_pp_pcl_cp";
    public static final String L = "plc002_pp_pcl_pke";
    public static final String M = "plc002_pp_pcl_pds";
    public static final String N = "plc002_pp_pcl_pam";
    public static final String O = "plc001_r_v";
    public static final String P = "plc001_r_s";
    public static final String Q = "plc001_r_c";
    public static final String R = "plc001_r_i";
    public static final String S = "plc001_r_o";

    /* renamed from: T  reason: collision with root package name */
    public static final String f1203T = "plc001_r_b";
    public static final String U = "plc001_r_rcl_re";
    public static final String V = "plc001_r_rcl_fr";
    public static final String W = "plc001_r_rcl_hk";
    public static final String X = "plc001_r_rcl_dv";
    public static final String Y = "plc001_r_rcl_rcd";
    public static final String Z = "plc001_r_rcl_li";
    public static final String a = "a1_p_s_p_s";
    public static final String aA = "plc001_c_ccl_ll";
    public static final String aB = "plc001_b_v";
    public static final String aC = "plc001_b_s";
    public static final String aD = "plc001_b_c";
    public static final String aE = "plc001_b_i";
    public static final String aF = "plc001_b_bcl_d";
    public static final String aG = "plc001_b_bcl_r";
    public static final String aH = "plc001_b_bcl_c";
    public static final String aI = "plc001_b_bcl_n";
    public static final String aJ = "plc001_b_bcl_s";
    public static final String aK = "plc001_b_bcl_w";
    public static final String aL = "plc001_b_bcl_u";
    public static final String aM = "plc001_b_bcl_a";
    public static final String aN = "plc001_b_bcl_l";
    public static final String aO = "plc001_b_bcl_ie";
    public static final String aP = "plc001_b_bcl_is";
    public static final String aQ = "plc001_b_bcl_ic";
    public static final String aR = "plc001_b_bcl_btm";
    public static final String aS = "plc001_b_bcl_mc";
    public static final String aT = "plc001_b_bcl_rp";
    public static final String aU = "plc001_b_bcl_tc";
    public static final String aV = "plc001_b_bcl_il";
    public static final String aW = "plc001_b_bcl_line";
    public static final String aX = "plc001_b_pry_gno";
    public static final String aY = "plc001_b_pry_gnon";
    public static final String aZ = "plc001_b_pry_gso";
    public static final String aa = "plc001_r_rcl_da";
    public static final String ab = "plc001_r_rcl_em";
    public static final String ac = "plc001_r_rcl_vl";
    public static final String ad = "plc001_hac_v";
    public static final String ae = "plc001_hac_s";
    public static final String af = "plc001_hsdc_s";
    public static final String ag = "plc001_hlbr_s";
    public static final String ah = "plc001_hac_i";
    public static final String ai = "plc001_prop_d";
    public static final String aj = "plc001_r_rcl_vp";
    public static final String ak = "plc001_r_rcl_sc";
    public static final String al = "plc001_r_rcl_mc";
    public static final String am = "plc001_r_rcl_ud";
    public static final String an = "plc001_r_rcl_xp";
    public static final String ao = "plc001_c_v";
    public static final String ap = "plc001_c_s";
    public static final String aq = "plc001_c_c";
    public static final String ar = "plc001_c_i";
    public static final String as = "plc001_c_b";
    public static final String at = "plc001_c_ccl_d";
    public static final String au = "plc001_c_ccl_ie";
    public static final String av = "plc001_c_ccl_is";
    public static final String aw = "plc001_c_ccl_ic";
    public static final String ax = "plc001_c_ccl_mc";
    public static final String ay = "plc001_c_ccl_btm";
    public static final String az = "plc001_c_ccl_wi";
    public static final String b = "a1_p_s_p_s_c_b";
    public static final String ba = "plc001_b_pry_gnci";
    public static final String bb = "plc001_b_pry_gifa";
    public static final String bc = "plc001_b_pry_gsl";
    public static final String bd = "plc001_b_pry_rl";
    public static final String be = "plc001_b_pry_grt";
    public static final String bf = "plc001_b_pry_grs";
    public static final String bg = "plc001_lps_t_p0";
    public static final String bh = "act_a1_1_upl_time";
    public static final String bi = "apl_a1_1_upl_time";
    public static final String bj = "es_a1_1_upl_time";
    public static final String bk = "a1_1_upl_time";
    public static final String bl = "fp_a1_1_upl_time";
    public static final String bm = "cpgc_a1_1_upl_time";
    public static final String bn = "soc_a1_1_upl_time";
    public static final String bo = "a1_1_f_upl";
    public static final String bp = "a1_l_p_i_t";
    public static final String bq = "l_p_i_s";
    public static final String br = "l_p_l_s";
    public static final String bs = "wp_ks_uuid";
    public static final String bt = "wp_ks_td";
    public static final String bu = "wp_ks_con";
    public static df bw = null;
    public static final String c = "plc001_pd_ptii_pi";
    public static final String d = "plc001_t_d";
    public static final String e = "re_po_rt";
    public static final String f = "plc001_lss_v_s";
    public static final String g = "plc001_v";
    public static final String h = "plc001_b_pti";
    public static final String i = "plc001_p_i";
    public static final String j = "plc001_bwc";
    public static final String k = "plc001_blpc";
    public static final String l = "plc001_scc";
    public static final String m = "plc001_scc_e";
    public static final String n = "plc001_al_v";
    public static final String o = "plc001_al_s";
    public static final String p = "plc001_al_i";
    public static final String q = "plc001_al_b";
    public static final String r = "plc001_al_m";
    public static final String s = "plc001_a_aor";
    public static final String t = "plc001_f_dir";
    public static final String u = "plc001_f_is";
    public static final String v = "plc001_f_ii";
    public static final String w = "plc001_f_act";
    public static final String x = "plc001_act_v";
    public static final String y = "plc001_act_s";
    public static final String z = "plc001_act_i";
    public transient /* synthetic */ FieldHolder $fh;
    public Context bv;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(334586517, "Lcom/kuaishou/weapon/p0/df;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(334586517, "Lcom/kuaishou/weapon/p0/df;");
        }
    }

    public df(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.bv = context;
    }

    public long a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            return h.a(this.bv, "re_po_rt").a(str, 0L);
        }
        return invokeL.longValue;
    }

    public void b(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048582, this, j2) == null) {
            h.a(this.bv, "re_po_rt").b(bp, j2);
        }
    }

    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            h.a(this.bv, "re_po_rt").c(bt, str);
        }
    }

    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            h.a(this.bv, "re_po_rt").c(bu, str);
        }
    }

    public static synchronized df a(Context context) {
        InterceptResult invokeL;
        df dfVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            synchronized (df.class) {
                if (bw == null) {
                    synchronized (df.class) {
                        if (bw == null) {
                            bw = new df(context);
                        }
                    }
                }
                dfVar = bw;
            }
            return dfVar;
        }
        return (df) invokeL.objValue;
    }

    public long a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return h.a(this.bv, "re_po_rt").a(bk, 0L);
        }
        return invokeV.longValue;
    }

    public long b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return h.a(this.bv, "re_po_rt").a(bp, 0L);
        }
        return invokeV.longValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return h.a(this.bv, "re_po_rt").b(bs, "");
        }
        return (String) invokeV.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return h.a(this.bv, "re_po_rt").b(bt, "");
        }
        return (String) invokeV.objValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return h.a(this.bv, "re_po_rt").b(bu, "");
        }
        return (String) invokeV.objValue;
    }

    public void a(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j2) == null) {
            h.a(this.bv, "re_po_rt").b(bk, j2);
        }
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            h.a(this.bv, "re_po_rt").c(bs, str);
        }
    }

    public void a(String str, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048579, this, str, j2) == null) {
            h.a(this.bv, "re_po_rt").b(str, j2);
        }
    }

    public void a(String str, y yVar) {
        String str2;
        h a2;
        String a3;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, yVar) == null) {
            if (yVar == null) {
                str3 = "re_po_rt";
            } else {
                try {
                    a2 = h.a(this.bv, "re_po_rt");
                    a3 = a2.a(g);
                    str2 = "re_po_rt";
                } catch (Throwable unused) {
                    str2 = "re_po_rt";
                }
                try {
                    a2.d(h, yVar.n());
                    a2.d(s, yVar.k());
                    a2.a(t, yVar.f());
                    a2.d(w, yVar.l());
                    a2.d(j, yVar.A());
                    a2.d(k, yVar.B());
                    a2.d(l, yVar.C());
                    try {
                        a2.a(u, yVar.g());
                        a2.d(v, yVar.h());
                        String a4 = a2.a(u);
                        if (!TextUtils.isEmpty(a4)) {
                            WeaponHI.isList = Arrays.asList(a4.split(WebChromeClient.PARAM_SEPARATOR));
                            WeaponHI.ii = a2.c(v, 5);
                        }
                    } catch (Exception unused2) {
                    }
                    b(System.currentTimeMillis());
                    String r2 = yVar.r();
                    if (!TextUtils.isEmpty(a3)) {
                        if (a3.compareTo(r2) < 0) {
                        }
                        str3 = str2;
                    }
                    a2.a(g, yVar.r(), false);
                    String a5 = a2.a(n);
                    if (TextUtils.isEmpty(a5) || a5.compareTo(yVar.j()) < 0) {
                        a2.a(n, yVar.j(), false);
                        if (yVar.o() != null) {
                            a2.a(o, yVar.o().c(), false);
                            a2.a(p, yVar.o().e(), false);
                            a2.a(q, yVar.o().b(), false);
                            a2.a(r, yVar.o().a(), false);
                        }
                    }
                    String a6 = a2.a(O);
                    if (TextUtils.isEmpty(a6) || a6.compareTo(yVar.a()) < 0) {
                        a2.a(O, yVar.a(), false);
                        if (yVar.x() != null) {
                            a2.a(P, yVar.x().b(), false);
                            a2.a(Q, yVar.x().c(), false);
                            a2.a(R, yVar.x().d(), false);
                            a2.a(S, yVar.x().f(), false);
                            a2.a(f1203T, yVar.x().a(), false);
                            y.g.a e2 = yVar.x().e();
                            if (e2 != null) {
                                a2.a(Y, e2.f(), false);
                                a2.a(Z, e2.m(), false);
                                a2.a(aa, e2.l(), false);
                                a2.a(X, e2.g(), false);
                                a2.a(ab, e2.b(), false);
                                a2.a(U, e2.h(), false);
                                a2.a(V, e2.c(), false);
                                a2.a(W, e2.a(), false);
                                a2.a(ac, e2.n(), false);
                                a2.a(aj, e2.k());
                                a2.a(am, e2.d());
                                a2.a(an, e2.j());
                                a2.a(ak, e2.e());
                                a2.a(al, e2.i());
                            }
                        }
                    }
                    String a7 = a2.a(aB);
                    if (TextUtils.isEmpty(a7) || a7.compareTo(yVar.u()) < 0) {
                        a2.a(aB, yVar.u(), false);
                        if (yVar.q() != null) {
                            a2.a(aC, yVar.q().a(), false);
                            a2.a(aD, yVar.q().b(), false);
                            a2.a(aE, yVar.q().c(), false);
                            y.c.a d2 = yVar.q().d();
                            y.c.b e3 = yVar.q().e();
                            if (d2 != null) {
                                a2.a(aF, d2.d(), false);
                                a2.a(aG, d2.i(), false);
                                a2.a(aH, d2.b(), false);
                                a2.a(aI, d2.f(), false);
                                a2.a(aK, d2.m(), false);
                                a2.a(aJ, d2.j(), false);
                                a2.a(aL, d2.k(), false);
                                a2.a(aM, d2.a(), false);
                                a2.a(aN, d2.r(), false);
                                a2.a(aO, d2.p(), false);
                                a2.a(aP, d2.e(), false);
                                a2.a(aQ, d2.n(), false);
                                a2.a(aR, d2.o(), false);
                                a2.a(aS, d2.l(), false);
                                a2.a(aT, d2.q(), false);
                                a2.a(aU, d2.g(), false);
                                a2.a(aV, d2.c(), false);
                                a2.a(aW, d2.h(), false);
                            }
                            if (e3 != null) {
                                a2.a(aX, e3.a(), false);
                                a2.a(aY, e3.b(), false);
                                a2.a(aZ, e3.c(), false);
                                a2.a(ba, e3.d(), false);
                                a2.a(bb, e3.e(), false);
                                a2.a(bc, e3.f(), false);
                                a2.a(bd, e3.g(), false);
                                a2.a(be, e3.h(), false);
                                a2.a(bf, e3.i(), false);
                            }
                        }
                    }
                    String a8 = a2.a(ao);
                    if (TextUtils.isEmpty(a8) || a8.compareTo(yVar.i()) < 0) {
                        a2.a(ao, yVar.i(), false);
                        if (yVar.s() != null) {
                            a2.a(ap, yVar.s().a(), false);
                            a2.a(aq, yVar.s().b(), false);
                            a2.a(ar, yVar.s().c(), false);
                            a2.a(as, yVar.s().e(), false);
                            y.d.a d3 = yVar.s().d();
                            if (d3 != null) {
                                a2.a(at, d3.a(), false);
                                a2.a(au, d3.g(), false);
                                a2.a(av, d3.d(), false);
                                a2.a(aw, d3.e(), false);
                                a2.a(ax, d3.b(), false);
                                a2.a(ay, d3.f(), false);
                                a2.a(az, d3.c(), false);
                                a2.a(aA, d3.h(), false);
                            }
                        }
                    }
                    String a9 = a2.a(F);
                    if (TextUtils.isEmpty(a9) || a9.compareTo(yVar.m()) < 0) {
                        a2.a(F, yVar.m(), false);
                        if (yVar.v() != null) {
                            y.f v2 = yVar.v();
                            a2.a(G, v2.a(), false);
                            a2.a(H, v2.b(), false);
                            a2.a(I, v2.d(), false);
                            y.f.a c2 = v2.c();
                            if (c2 != null) {
                                a2.a(K, c2.d(), false);
                                a2.a(J, c2.c(), false);
                                a2.a(M, c2.e(), false);
                                a2.a(L, c2.b(), false);
                                a2.a(N, c2.a(), false);
                            }
                        }
                    }
                    String a10 = a2.a(A);
                    if (TextUtils.isEmpty(a10) || a10.compareTo(yVar.y()) < 0) {
                        a2.a(A, yVar.y(), false);
                        if (yVar.c() != null) {
                            a2.a(B, yVar.c().c(), false);
                            a2.a(D, yVar.c().d(), false);
                            a2.a(E, yVar.c().b(), false);
                            a2.a(C, yVar.c().a(), false);
                        }
                    }
                    String a11 = a2.a(x);
                    if (TextUtils.isEmpty(a11) || a11.compareTo(yVar.b()) < 0) {
                        a2.a(x, yVar.b(), false);
                        if (yVar.p() != null) {
                            a2.a(y, yVar.p().a(), false);
                            a2.a(z, yVar.p().c(), false);
                        }
                    }
                    String a12 = a2.a(ad);
                    if (TextUtils.isEmpty(a12) || a12.compareTo(yVar.e()) < 0) {
                        a2.a(ad, yVar.e(), false);
                        if (yVar.t() != null) {
                            a2.a(ae, yVar.t().b(), false);
                            a2.a(ah, yVar.t().a(), false);
                            a2.a(af, yVar.t().d(), false);
                            a2.a(ag, yVar.t().e(), false);
                            a2.a(ai, yVar.t().f(), false);
                        }
                    }
                    str3 = str2;
                } catch (Throwable unused3) {
                    try {
                        h.a(this.bv, str2).c();
                        return;
                    } catch (Throwable unused4) {
                        return;
                    }
                }
            }
            try {
                h.a(this.bv, str3).c();
            } catch (Throwable unused5) {
            }
        }
    }
}
