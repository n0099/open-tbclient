package com.kuaishou.weapon.un;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.weapon.un.k;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class d {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String A = "wpcf";
    public static final String A0 = "plc001_b_bcl_s_s";
    public static final String B = "wpct";
    public static final String B0 = "plc001_b_bcl_w_s";
    public static final String C = "wpcc";
    public static final String C0 = "plc001_b_bcl_u_s";
    public static final String D = "wsv";
    public static final String D0 = "plc001_b_bcl_a_s";
    public static final String E = "wuiks";
    public static final String E0 = "plc001_b_bcl_ie_s";
    public static final String F = "wjsit";
    public static final String F0 = "plc001_b_bcl_is_s";
    public static final String G = "wustfo";
    public static final String G0 = "plc001_b_bcl_ic_s";
    public static final String H = "wufcfo";
    public static final String H0 = "plc001_b_bcl_btm_s";
    public static final String I = "wlurt";
    public static final String I0 = "plc001_b_bcl_mc_s";
    public static final String J = "wusetfi";
    public static final String J0 = "plc001_b_bcl_rp_s";
    public static final String K = "whcs";
    public static final String K0 = "plc001_b_bcl_tc_s";
    public static final String L = "wlcpst";
    public static final String L0 = "plc001_b_bcl_il_s";
    public static final String M = "wnalrt";
    public static final String M0 = "plc001_kbp_ie";
    public static final int N = 1;
    public static final String N0 = "plc001_kbp_is";
    public static final int O = 6;
    public static final String O0 = "plc001_lss_t_s";
    public static final int P = 12;
    public static final String P0 = "plc001_lss_v_s";
    public static final int Q = 8;
    public static final String Q0 = "plc001_lss_ck_d";
    public static final int R = 1;
    public static final String R0 = "plc001_lss_oa_d";
    public static final String S = "0.0.0";
    public static final String S0 = "a1_1_tk_time_s";
    public static final String T = "plc001_o_c_s";
    public static final String T0 = "a1_1_upl_time_s";
    public static final String U = "plc001_v_s";
    public static final String U0 = "a1_e_upl_time_s";
    public static final String V = "plc001_pd_pti_s";
    public static final String V0 = "a1_a_aor_upl_time_s";
    public static final String W = "plc001_pd_pti_ps";
    public static final String W0 = "a1_a_nc_upl_time_s";
    public static final String X = "plc001_pd_pti_pc";
    public static final String X0 = "a1_1_f_upl_s";
    public static final String Y = "plc001_pd_pti_pi";
    public static final String Y0 = "a1_l_p_i_t_s";
    public static final String Z = "plc001_pd_ptip_pi";
    public static final String Z0 = "a1_p_s_p_s";
    public static final String a0 = "plc001_pd_ptii_pi";
    public static final String a1 = "a1_p_s_p_s_c_b";
    public static final String b0 = "plc001_pd_u_ps";
    public static final String b1 = "a1_l_s_p_s_c_b";
    public static final String c0 = "plc001_pd_cb_ps";
    public static final String c1 = "plc001_nc_w";
    public static final String d = "w_t";
    public static final String d0 = "plc001_pd_pg_ps";
    public static final String d1 = "plc001_ac_a";
    public static final String e = "w_t_r";
    public static final String e0 = "plc001_pd_pt_pi";
    public static final String e1 = "plc001_ac_r";
    public static final String f = "w_t_u";
    public static final String f0 = "plc001_pd_pk_pc";
    public static final String f1 = "plc001_pd_bss";
    public static final String g = "w_t_d";
    public static final String g0 = "plc001_pd_ph_ps";
    public static final String h = "w_t_d_n";
    public static final String h0 = "wlpit";
    public static final String i = "wwv";
    public static final String i0 = "l_p_i_s";
    public static final String j = "wlpauct";
    public static final String j0 = "plc001_p_i";
    public static final String k = "wnpauct";
    public static final String k0 = "plc001_a_v_s";
    public static final String l = "wiipaot";
    public static final String l0 = "plc001_a_s_s";
    public static final String m = "wsiva";
    public static final String m0 = "plc001_a_c_s";
    public static final String n = "wibupa";
    public static final String n0 = "plc001_a_i_s";
    public static final String o = "wopai";
    public static final String o0 = "plc001_e_v_s";
    public static final String p = "wslt";
    public static final String p0 = "plc001_e_s_s";
    public static final String q = "wsle";
    public static final String q0 = "plc001_e_c_s";
    public static final String r = "wppaft";
    public static final String r0 = "plc001_e_i_s";
    public static final String s = "wppafc";
    public static final String s0 = "plc001_b_v_s";
    public static final String t = "wwppcft";
    public static final String t0 = "plc001_b_s_s";
    public static final String u = "wwppcfc";
    public static final String u0 = "plc001_b_c_s";
    public static final String v = "wadft";
    public static final String v0 = "plc001_b_i_s";
    public static final String w = "wadfc";
    public static final String w0 = "plc001_b_bcl_d_s";
    public static final String x = "whcapk";
    public static final String x0 = "plc001_b_bcl_r_s";
    public static final String y = "wlhcapk";
    public static final String y0 = "plc001_b_bcl_c_s";
    public static final String z = "wrpat";
    public static final String z0 = "plc001_b_bcl_n_s";
    public transient /* synthetic */ FieldHolder $fh;
    public SharedPreferences a;
    public SharedPreferences.Editor b;
    public Context c;

    public d(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences(r1.o, 4);
            this.a = sharedPreferences;
            this.b = sharedPreferences.edit();
            this.c = context;
        } catch (Throwable th) {
            l1.a(th);
        }
    }

    public d(String str, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        try {
            this.c = context;
            SharedPreferences sharedPreferences = context.getSharedPreferences(str, 4);
            this.a = sharedPreferences;
            this.b = sharedPreferences.edit();
        } catch (Throwable unused) {
        }
    }

    public int a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? this.a.getInt(str, 0) : invokeL.intValue;
    }

    public int a(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i2)) == null) ? this.a.getInt(str, i2) : invokeLI.intValue;
    }

    public long a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a.getLong(U0, 0L) : invokeV.longValue;
    }

    public String a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, str2)) == null) ? this.a.getString(str, str2) : (String) invokeLL.objValue;
    }

    public String a(String str, String str2, boolean z2) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048580, this, str, str2, z2)) == null) {
            String e2 = e(str);
            return !TextUtils.isEmpty(e2) ? z2 ? k1.b(e2, 2) : e2 : str2;
        }
        return (String) invokeLLZ.objValue;
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.b.putInt(X0, i2);
            this.b.apply();
        }
    }

    public void a(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048582, this, j2) == null) {
            this.b.putLong(U0, j2);
            this.b.apply();
        }
    }

    public void a(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        SharedPreferences sharedPreferences;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, onSharedPreferenceChangeListener) == null) || (sharedPreferences = this.a) == null) {
            return;
        }
        sharedPreferences.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    public void a(String str, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, j2) == null) {
            this.b.putLong(str, j2);
            this.b.apply();
        }
    }

    public void a(String str, k kVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048585, this, str, kVar) == null) || kVar == null || TextUtils.isEmpty(kVar.q()) || TextUtils.isEmpty(kVar.d())) {
            return;
        }
        c(V, kVar.h());
        c(W, kVar.n());
        c(Y, kVar.k());
        c(X, kVar.g());
        c(Z, kVar.m());
        c(a0, kVar.p());
        c(d0, kVar.i());
        c(e0, kVar.o());
        c(f0, kVar.l());
        c(g0, kVar.j());
        c(b0, kVar.e());
        c(c0, kVar.f());
        d(System.currentTimeMillis());
        String e2 = e(U);
        String e3 = e(s0);
        String e4 = e(k0);
        String e5 = e(o0);
        if (kVar.t() == 1) {
            if (TextUtils.isEmpty(e2) || e2.compareTo(kVar.q()) < 0) {
                b(U, kVar.q());
                if ((TextUtils.isEmpty(e4) || e4.compareTo(kVar.b()) < 0) && kVar.a() != null) {
                    b(k0, kVar.b());
                    c(l0, kVar.a().c());
                    c(m0, kVar.a().a());
                    c(n0, kVar.a().b());
                }
                if (TextUtils.isEmpty(e3) || e3.compareTo(kVar.d()) < 0) {
                    b(s0, kVar.d());
                    if (kVar.c() != null) {
                        c(t0, kVar.c().d());
                        c(u0, kVar.c().a());
                        c(v0, kVar.c().c());
                        k.b.a b = kVar.c().b();
                        if (b != null) {
                            c(w0, b.d());
                            c(x0, b.k());
                            c(y0, b.c());
                            c(z0, b.j());
                            c(B0, b.p());
                            c(A0, b.m());
                            c(C0, b.o());
                            c(D0, b.a());
                            c(E0, b.f());
                            c(F0, b.h());
                            c(G0, b.e());
                            c(H0, b.b());
                            c(I0, b.i());
                            c(J0, b.l());
                            c(K0, b.n());
                            c(L0, b.g());
                        }
                    }
                }
                if ((TextUtils.isEmpty(e5) || e5.compareTo(kVar.s()) < 0) && kVar.r() != null) {
                    b(o0, kVar.s());
                    c(p0, kVar.r().c());
                    c(q0, kVar.r().a());
                    c(r0, kVar.r().b());
                }
            }
        }
    }

    public void a(String str, Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, str, bool) == null) {
            try {
                if (this.b != null) {
                    this.b.putBoolean(str, bool.booleanValue());
                    this.b.apply();
                }
            } catch (Exception unused) {
            }
        }
    }

    public void a(List<Integer> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, list) == null) {
            if (list == null || list.size() == 0) {
                this.b.putString(y, "");
            } else {
                StringBuilder sb = new StringBuilder();
                for (int i2 = 0; i2 < list.size(); i2++) {
                    sb.append(list.get(i2));
                    if (i2 != list.size() - 1) {
                        sb.append("-");
                    }
                }
                this.b.putString("glspk", sb.toString());
            }
            this.b.apply();
        }
    }

    public void a(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z2) == null) {
            this.b.putBoolean(n, z2);
            this.b.apply();
        }
    }

    public void a(int... iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, iArr) == null) {
            if (iArr == null || iArr.length == 0) {
                this.b.putString(x, "");
            } else {
                StringBuilder sb = new StringBuilder();
                for (int i2 = 0; i2 < iArr.length; i2++) {
                    sb.append(iArr[i2]);
                    if (i2 != iArr.length - 1) {
                        sb.append("-");
                    }
                }
                this.b.putString("hcpk", sb.toString());
            }
            this.b.apply();
        }
    }

    public int b(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048590, this, str, i2)) == null) {
            try {
                return this.a.getInt(str, i2);
            } catch (Throwable unused) {
                return i2;
            }
        }
        return invokeLI.intValue;
    }

    public List<Integer> b() {
        InterceptResult invokeV;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            ArrayList arrayList = new ArrayList();
            String string = this.a.getString(x, "");
            if (!TextUtils.isEmpty(string) && (split = string.split("-")) != null && split.length > 0) {
                for (String str : split) {
                    try {
                        arrayList.add(Integer.valueOf(Integer.parseInt(str)));
                    } catch (NumberFormatException e2) {
                        l1.a(e2);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public void b(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048592, this, j2) == null) {
            this.b.putLong(V0, j2);
            this.b.apply();
        }
    }

    public void b(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        SharedPreferences sharedPreferences;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, onSharedPreferenceChangeListener) == null) || (sharedPreferences = this.a) == null) {
            return;
        }
        sharedPreferences.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    public void b(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048594, this, str, str2) == null) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.b.putString(str, str2);
        this.b.apply();
    }

    public void b(String str, String str2, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(1048595, this, str, str2, z2) == null) || TextUtils.isEmpty(str2)) {
            return;
        }
        if (z2) {
            str2 = k1.c(str2.getBytes(), 2);
        }
        this.b.putString(str, str2);
        this.b.apply();
    }

    public boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, str)) == null) ? this.a.getBoolean(str, false) : invokeL.booleanValue;
    }

    public int c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, str)) == null) ? this.a.getInt(str, 0) : invokeL.intValue;
    }

    public long c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.a.getInt(X0, 0) : invokeV.longValue;
    }

    public void c(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048599, this, j2) == null) {
            this.b.putLong(W0, j2);
            this.b.apply();
        }
    }

    public void c(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048600, this, str, i2) == null) {
            try {
                this.b.putInt(str, i2);
                this.b.apply();
            } catch (Throwable unused) {
            }
        }
    }

    public void c(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048601, this, str, str2) == null) {
            SharedPreferences.Editor editor = this.b;
            editor.putString("as", str + "-" + str2);
            this.b.apply();
        }
    }

    public long d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, str)) == null) ? this.a.getLong(str, 0L) : invokeL.longValue;
    }

    public void d(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048603, this, j2) == null) {
            this.b.putLong(Y0, j2);
            this.b.apply();
        }
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            try {
                return this.a.getBoolean(n, true);
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public long e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.a.getLong(V0, 0L) : invokeV.longValue;
    }

    public String e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, str)) == null) ? this.a.getString(str, "") : (String) invokeL.objValue;
    }

    public void e(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048607, this, j2) == null) {
            this.b.putLong(S0, j2);
            this.b.apply();
        }
    }

    public long f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.a.getLong(W0, 0L) : invokeV.longValue;
    }

    public void f(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048609, this, j2) == null) {
            this.b.putLong(T0, j2);
            this.b.apply();
        }
    }

    public void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, str) == null) {
            try {
                b(Q0, new String(k1.b(str.getBytes(), 2)));
            } catch (Exception unused) {
            }
        }
    }

    public long g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.a.getLong(Y0, 0L) : invokeV.longValue;
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, str) == null) {
            try {
                b(R0, new String(k1.b(str.getBytes(), 2)));
            } catch (Exception unused) {
            }
        }
    }

    public long h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? this.a.getLong(S0, 0L) : invokeV.longValue;
    }

    public long i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? this.a.getLong(T0, 0L) : invokeV.longValue;
    }

    public List<Integer> j() {
        InterceptResult invokeV;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            ArrayList arrayList = new ArrayList();
            String string = this.a.getString(y, "");
            if (!TextUtils.isEmpty(string) && (split = string.split("-")) != null && split.length > 0) {
                for (String str : split) {
                    try {
                        arrayList.add(Integer.valueOf(Integer.parseInt(str)));
                    } catch (NumberFormatException e2) {
                        l1.a(e2);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.a.getString("as", "") : (String) invokeV.objValue;
    }

    public SharedPreferences.Editor l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) ? this.b : (SharedPreferences.Editor) invokeV.objValue;
    }

    public SharedPreferences m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) ? this.a : (SharedPreferences) invokeV.objValue;
    }
}
