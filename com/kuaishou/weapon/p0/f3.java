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
import com.kuaishou.weapon.p0.z;
import java.util.Arrays;
/* loaded from: classes9.dex */
public class f3 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String A = "plc002_soc_v";
    public static final String A0 = "plc001_b_bcl_r";
    public static final String B = "plc002_soc_s";
    public static final String B0 = "plc001_b_bcl_c";
    public static final String C = "plc002_soc_sna_s";
    public static final String C0 = "plc001_b_bcl_n";
    public static final String D = "plc002_soc_c";
    public static final String D0 = "plc001_b_bcl_s";
    public static final String E = "plc002_soc_i";
    public static final String E0 = "plc001_b_bcl_w";
    public static final String F = "plc002_pp_v";
    public static final String F0 = "plc001_b_bcl_u";
    public static final String G = "plc002_pp_s";
    public static final String G0 = "plc001_b_bcl_a";
    public static final String H = "plc002_pp_c";
    public static final String H0 = "plc001_b_bcl_l";
    public static final String I = "plc002_pp_i";
    public static final String I0 = "plc001_b_bcl_ie";
    public static final String J = "plc002_pp_pcl_gc";
    public static final String J0 = "plc001_b_bcl_is";
    public static final String K = "plc002_pp_pcl_cp";
    public static final String K0 = "plc001_b_bcl_ic";
    public static final String L = "plc002_pp_pcl_pke";
    public static final String L0 = "plc001_b_bcl_btm";
    public static final String M = "plc002_pp_pcl_pds";
    public static final String M0 = "plc001_b_bcl_mc";
    public static final String N = "plc002_pp_pcl_pam";
    public static final String N0 = "plc001_b_bcl_rp";
    public static final String O = "plc001_r_v";
    public static final String O0 = "plc001_b_bcl_tc";
    public static final String P = "plc001_r_s";
    public static final String P0 = "plc001_b_bcl_il";
    public static final String Q = "plc001_r_c";
    public static final String Q0 = "plc001_b_bcl_line";
    public static final String R = "plc001_r_i";
    public static final String R0 = "plc001_lps_t_p0";
    public static final String S = "plc001_r_o";
    public static final String S0 = "act_a1_1_upl_time";

    /* renamed from: T  reason: collision with root package name */
    public static final String f1212T = "plc001_r_b";
    public static final String T0 = "apl_a1_1_upl_time";
    public static final String U = "plc001_r_rcl_re";
    public static final String U0 = "es_a1_1_upl_time";
    public static final String V = "plc001_r_rcl_fr";
    public static final String V0 = "a1_1_upl_time";
    public static final String W = "plc001_r_rcl_hk";
    public static final String W0 = "fp_a1_1_upl_time";
    public static final String X = "plc001_r_rcl_dv";
    public static final String X0 = "cpgc_a1_1_upl_time";
    public static final String Y = "plc001_r_rcl_rcd";
    public static final String Y0 = "soc_a1_1_upl_time";
    public static final String Z = "plc001_r_rcl_li";
    public static final String Z0 = "a1_1_f_upl";
    public static final String a0 = "plc001_r_rcl_da";
    public static final String a1 = "a1_l_p_i_t";
    public static f3 b = null;
    public static final String b0 = "plc001_r_rcl_em";
    public static final String b1 = "l_p_i_s";
    public static final String c = "a1_p_s_p_s";
    public static final String c0 = "plc001_r_rcl_vl";
    public static final String c1 = "l_p_l_s";
    public static final String d = "a1_p_s_p_s_c_b";
    public static final String d0 = "plc001_r_rcl_vp";
    public static final String d1 = "wp_ks_uuid";
    public static final String e = "plc001_pd_ptii_pi";
    public static final String e0 = "plc001_r_rcl_sc";
    public static final String e1 = "wp_ks_td";
    public static final String f = "plc001_t_d";
    public static final String f0 = "plc001_r_rcl_mc";
    public static final String f1 = "wp_ks_con";
    public static final String g = "re_po_rt";
    public static final String g0 = "plc001_r_rcl_ud";
    public static final String h = "plc001_lss_v_s";
    public static final String h0 = "plc001_r_rcl_xp";
    public static final String i = "plc001_v";
    public static final String i0 = "plc001_c_v";
    public static final String j = "plc001_b_pti";
    public static final String j0 = "plc001_c_s";
    public static final String k = "plc001_p_i";
    public static final String k0 = "plc001_c_c";
    public static final String l = "plc001_scc";
    public static final String l0 = "plc001_c_i";
    public static final String m = "plc001_scc_e";
    public static final String m0 = "plc001_c_b";
    public static final String n = "plc001_al_v";
    public static final String n0 = "plc001_c_ccl_d";
    public static final String o = "plc001_al_s";
    public static final String o0 = "plc001_c_ccl_ie";
    public static final String p = "plc001_al_i";
    public static final String p0 = "plc001_c_ccl_is";
    public static final String q = "plc001_al_b";
    public static final String q0 = "plc001_c_ccl_ic";
    public static final String r = "plc001_al_m";
    public static final String r0 = "plc001_c_ccl_mc";
    public static final String s = "plc001_a_aor";
    public static final String s0 = "plc001_c_ccl_btm";
    public static final String t = "plc001_f_dir";
    public static final String t0 = "plc001_c_ccl_wi";
    public static final String u = "plc001_f_is";
    public static final String u0 = "plc001_c_ccl_ll";
    public static final String v = "plc001_f_ii";
    public static final String v0 = "plc001_b_v";
    public static final String w = "plc001_f_act";
    public static final String w0 = "plc001_b_s";
    public static final String x = "plc001_act_v";
    public static final String x0 = "plc001_b_c";
    public static final String y = "plc001_act_s";
    public static final String y0 = "plc001_b_i";
    public static final String z = "plc001_act_i";
    public static final String z0 = "plc001_b_bcl_d";
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(334586858, "Lcom/kuaishou/weapon/p0/f3;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(334586858, "Lcom/kuaishou/weapon/p0/f3;");
        }
    }

    public f3(Context context) {
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
        this.a = context;
    }

    public static synchronized f3 a(Context context) {
        InterceptResult invokeL;
        f3 f3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            synchronized (f3.class) {
                if (b == null) {
                    synchronized (f3.class) {
                        if (b == null) {
                            b = new f3(context);
                        }
                    }
                }
                f3Var = b;
            }
            return f3Var;
        }
        return (f3) invokeL.objValue;
    }

    public long a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? i.a(this.a, "re_po_rt").a(str, 0L) : invokeL.longValue;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? i.a(this.a, "re_po_rt").a(f1, "") : (String) invokeV.objValue;
    }

    public void a(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j2) == null) {
            i.a(this.a, "re_po_rt").b(a1, j2);
        }
    }

    public void a(String str, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048579, this, str, j2) == null) {
            i.a(this.a, "re_po_rt").b(str, j2);
        }
    }

    public void a(String str, z zVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, zVar) == null) {
            if (zVar != null) {
                try {
                    i a = i.a(this.a, "re_po_rt");
                    String e2 = a.e(i);
                    a.d(j, zVar.n());
                    a.d(s, zVar.b());
                    a.c(t, zVar.m());
                    a.d(w, zVar.d());
                    a.d(l, zVar.z());
                    try {
                        a.c(u, zVar.t());
                        a.d(v, zVar.s());
                        String e3 = a.e(u);
                        if (!TextUtils.isEmpty(e3)) {
                            WeaponHI.isList = Arrays.asList(e3.split(WebChromeClient.PARAM_SEPARATOR));
                            WeaponHI.ii = a.b(v, 5);
                        }
                    } catch (Exception unused) {
                    }
                    a(System.currentTimeMillis());
                    String o2 = zVar.o();
                    if (TextUtils.isEmpty(e2) || e2.compareTo(o2) < 0) {
                        a.c(i, zVar.o(), false);
                        String e4 = a.e(n);
                        if (TextUtils.isEmpty(e4) || e4.compareTo(zVar.f()) < 0) {
                            a.c(n, zVar.f(), false);
                            if (zVar.a() != null) {
                                a.a(o, zVar.a().e(), false);
                                a.a(p, zVar.a().c(), false);
                                a.a(q, zVar.a().a(), false);
                                a.a(r, zVar.a().d(), false);
                            }
                        }
                        String e5 = a.e(O);
                        if (TextUtils.isEmpty(e5) || e5.compareTo(zVar.y()) < 0) {
                            a.c(O, zVar.y(), false);
                            if (zVar.x() != null) {
                                a.a(P, zVar.x().f(), false);
                                a.a(Q, zVar.x().b(), false);
                                a.a(R, zVar.x().d(), false);
                                a.a(S, zVar.x().e(), false);
                                a.a(f1212T, zVar.x().a(), false);
                                z.g.a c2 = zVar.x().c();
                                if (c2 != null) {
                                    a.a(Y, c2.h(), false);
                                    a.a(Z, c2.f(), false);
                                    a.a(a0, c2.a(), false);
                                    a.a(X, c2.b(), false);
                                    a.a(b0, c2.c(), false);
                                    a.a(U, c2.i(), false);
                                    a.a(V, c2.d(), false);
                                    a.a(W, c2.e(), false);
                                    a.a(c0, c2.l(), false);
                                    a.c(d0, c2.m());
                                    a.c(g0, c2.k());
                                    a.c(h0, c2.n());
                                    a.c(e0, c2.j());
                                    a.c(f0, c2.g());
                                }
                            }
                        }
                        String e6 = a.e(v0);
                        if (TextUtils.isEmpty(e6) || e6.compareTo(zVar.i()) < 0) {
                            a.c(v0, zVar.i(), false);
                            if (zVar.g() != null) {
                                a.a(w0, zVar.g().d(), false);
                                a.a(x0, zVar.g().a(), false);
                                a.a(y0, zVar.g().c(), false);
                                z.c.a b2 = zVar.g().b();
                                if (b2 != null) {
                                    a.a(z0, b2.d(), false);
                                    a.a(A0, b2.m(), false);
                                    a.a(B0, b2.c(), false);
                                    a.a(C0, b2.k(), false);
                                    a.a(E0, b2.r(), false);
                                    a.a(D0, b2.o(), false);
                                    a.a(F0, b2.q(), false);
                                    a.a(G0, b2.a(), false);
                                    a.a(H0, b2.i(), false);
                                    a.a(I0, b2.f(), false);
                                    a.a(J0, b2.h(), false);
                                    a.a(K0, b2.e(), false);
                                    a.a(L0, b2.b(), false);
                                    a.a(M0, b2.j(), false);
                                    a.a(N0, b2.n(), false);
                                    a.a(O0, b2.p(), false);
                                    a.a(P0, b2.g(), false);
                                    a.a(Q0, b2.l(), false);
                                }
                            }
                        }
                        String e7 = a.e(i0);
                        if (TextUtils.isEmpty(e7) || e7.compareTo(zVar.l()) < 0) {
                            a.c(i0, zVar.l(), false);
                            if (zVar.k() != null) {
                                a.a(j0, zVar.k().e(), false);
                                a.a(k0, zVar.k().b(), false);
                                a.a(l0, zVar.k().d(), false);
                                a.a(m0, zVar.k().a(), false);
                                z.d.a c3 = zVar.k().c();
                                if (c3 != null) {
                                    a.a(n0, c3.b(), false);
                                    a.a(o0, c3.d(), false);
                                    a.a(p0, c3.e(), false);
                                    a.a(q0, c3.c(), false);
                                    a.a(r0, c3.f(), false);
                                    a.a(s0, c3.a(), false);
                                    a.a(t0, c3.h(), false);
                                    a.a(u0, c3.g(), false);
                                }
                            }
                        }
                        String e8 = a.e(F);
                        if (TextUtils.isEmpty(e8) || e8.compareTo(zVar.w()) < 0) {
                            a.c(F, zVar.w(), false);
                            if (zVar.v() != null) {
                                z.f v2 = zVar.v();
                                a.a(G, v2.d(), false);
                                a.a(H, v2.a(), false);
                                a.a(I, v2.c(), false);
                                z.f.a b3 = v2.b();
                                if (b3 != null) {
                                    a.a(K, b3.a(), false);
                                    a.a(J, b3.b(), false);
                                    a.a(M, b3.d(), false);
                                    a.a(L, b3.e(), false);
                                    a.a(N, b3.c(), false);
                                }
                            }
                        }
                        String e9 = a.e(A);
                        if (TextUtils.isEmpty(e9) || e9.compareTo(zVar.B()) < 0) {
                            a.c(A, zVar.B(), false);
                            if (zVar.A() != null) {
                                a.a(B, zVar.A().d(), false);
                                a.a(D, zVar.A().b(), false);
                                a.a(E, zVar.A().c(), false);
                                a.a(C, zVar.A().a(), false);
                            }
                        }
                        String e10 = a.e(x);
                        if (TextUtils.isEmpty(e10) || e10.compareTo(zVar.e()) < 0) {
                            a.c(x, zVar.e(), false);
                            if (zVar.c() != null) {
                                a.a(y, zVar.c().c(), false);
                                a.a(z, zVar.c().b(), false);
                            }
                        }
                    }
                } catch (Throwable unused2) {
                }
            }
            try {
                i.a(this.a, "re_po_rt").a();
            } catch (Throwable unused3) {
            }
        }
    }

    public long b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? i.a(this.a, "re_po_rt").a(a1, 0L) : invokeV.longValue;
    }

    public void b(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048582, this, j2) == null) {
            i.a(this.a, "re_po_rt").b(V0, j2);
        }
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            i.a(this.a, "re_po_rt").b(f1, str);
        }
    }

    public long c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? i.a(this.a, "re_po_rt").a(V0, 0L) : invokeV.longValue;
    }

    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            i.a(this.a, "re_po_rt").b(e1, str);
        }
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? i.a(this.a, "re_po_rt").a(e1, "") : (String) invokeV.objValue;
    }

    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            i.a(this.a, "re_po_rt").b(d1, str);
        }
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? i.a(this.a, "re_po_rt").a(d1, "") : (String) invokeV.objValue;
    }
}
