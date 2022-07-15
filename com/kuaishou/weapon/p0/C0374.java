package com.kuaishou.weapon.p0;

import android.content.Context;
import android.content.SharedPreferences;
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
import com.kuaishou.weapon.p0.C0412;
import java.util.Arrays;
/* renamed from: com.kuaishou.weapon.p0.ʽי  reason: contains not printable characters */
/* loaded from: classes5.dex */
public class C0374 {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: ʻʻ  reason: contains not printable characters */
    public static final String f221 = "plc002_soc_s";

    /* renamed from: ʻʼ  reason: contains not printable characters */
    public static final String f222 = "plc001_r_rcl_dv";

    /* renamed from: ʻʽ  reason: contains not printable characters */
    public static final String f223 = "plc001_r_rcl_rcd";

    /* renamed from: ʻʾ  reason: contains not printable characters */
    public static final String f224 = "plc001_r_rcl_li";

    /* renamed from: ʻʿ  reason: contains not printable characters */
    public static final String f225 = "plc001_r_rcl_da";

    /* renamed from: ʻˆ  reason: contains not printable characters */
    public static final String f226 = "plc001_r_rcl_em";

    /* renamed from: ʻˈ  reason: contains not printable characters */
    public static final String f227 = "plc001_r_rcl_vl";

    /* renamed from: ʻˉ  reason: contains not printable characters */
    public static final String f228 = "plc001_r_rcl_vp";

    /* renamed from: ʻˊ  reason: contains not printable characters */
    public static final String f229 = "plc001_r_rcl_sc";

    /* renamed from: ʻˋ  reason: contains not printable characters */
    public static final String f230 = "plc001_r_rcl_mc";

    /* renamed from: ʻˎ  reason: contains not printable characters */
    public static final String f231 = "plc001_r_rcl_ud";

    /* renamed from: ʻˏ  reason: contains not printable characters */
    public static final String f232 = "plc001_r_rcl_xp";

    /* renamed from: ʻˑ  reason: contains not printable characters */
    public static final String f233 = "plc001_c_v";

    /* renamed from: ʻי  reason: contains not printable characters */
    public static final String f234 = "plc001_c_s";

    /* renamed from: ʻـ  reason: contains not printable characters */
    public static final String f235 = "plc001_c_c";

    /* renamed from: ʻٴ  reason: contains not printable characters */
    public static final String f236 = "plc001_c_i";

    /* renamed from: ʻᐧ  reason: contains not printable characters */
    public static final String f237 = "plc001_c_b";

    /* renamed from: ʻᴵ  reason: contains not printable characters */
    public static final String f238 = "plc001_c_ccl_d";

    /* renamed from: ʻᵎ  reason: contains not printable characters */
    public static final String f239 = "plc001_c_ccl_ie";

    /* renamed from: ʻᵔ  reason: contains not printable characters */
    public static final String f240 = "plc001_c_ccl_is";

    /* renamed from: ʻᵢ  reason: contains not printable characters */
    public static final String f241 = "plc001_c_ccl_ic";

    /* renamed from: ʻⁱ  reason: contains not printable characters */
    public static final String f242 = "plc001_c_ccl_mc";

    /* renamed from: ʻﹳ  reason: contains not printable characters */
    public static final String f243 = "plc001_c_ccl_btm";

    /* renamed from: ʻﹶ  reason: contains not printable characters */
    public static final String f244 = "plc001_c_ccl_wi";

    /* renamed from: ʻﾞ  reason: contains not printable characters */
    public static final String f245 = "plc001_c_ccl_ll";

    /* renamed from: ʼʻ  reason: contains not printable characters */
    public static final String f246 = "plc001_b_v";

    /* renamed from: ʼʼ  reason: contains not printable characters */
    public static final String f247 = "plc002_soc_c";

    /* renamed from: ʼʽ  reason: contains not printable characters */
    public static final String f248 = "plc001_b_s";

    /* renamed from: ʼʾ  reason: contains not printable characters */
    public static final String f249 = "plc001_b_c";

    /* renamed from: ʼʿ  reason: contains not printable characters */
    public static final String f250 = "plc001_b_i";

    /* renamed from: ʼˆ  reason: contains not printable characters */
    public static final String f251 = "plc001_b_bcl_d";

    /* renamed from: ʼˈ  reason: contains not printable characters */
    public static final String f252 = "plc001_b_bcl_r";

    /* renamed from: ʼˉ  reason: contains not printable characters */
    public static final String f253 = "plc001_b_bcl_c";

    /* renamed from: ʼˊ  reason: contains not printable characters */
    public static final String f254 = "plc001_b_bcl_n";

    /* renamed from: ʼˋ  reason: contains not printable characters */
    public static final String f255 = "plc001_b_bcl_s";

    /* renamed from: ʼˎ  reason: contains not printable characters */
    public static final String f256 = "plc001_b_bcl_w";

    /* renamed from: ʼˏ  reason: contains not printable characters */
    public static final String f257 = "plc001_b_bcl_u";

    /* renamed from: ʼˑ  reason: contains not printable characters */
    public static final String f258 = "plc001_b_bcl_a";

    /* renamed from: ʼי  reason: contains not printable characters */
    public static final String f259 = "plc001_b_bcl_l";

    /* renamed from: ʼـ  reason: contains not printable characters */
    public static final String f260 = "plc001_b_bcl_ie";

    /* renamed from: ʼٴ  reason: contains not printable characters */
    public static final String f261 = "plc001_b_bcl_is";

    /* renamed from: ʼᐧ  reason: contains not printable characters */
    public static final String f262 = "plc001_b_bcl_ic";

    /* renamed from: ʼᴵ  reason: contains not printable characters */
    public static final String f263 = "plc001_b_bcl_btm";

    /* renamed from: ʼᵎ  reason: contains not printable characters */
    public static final String f264 = "plc001_b_bcl_mc";

    /* renamed from: ʼᵔ  reason: contains not printable characters */
    public static final String f265 = "plc001_b_bcl_rp";

    /* renamed from: ʼᵢ  reason: contains not printable characters */
    public static final String f266 = "plc001_b_bcl_tc";

    /* renamed from: ʼⁱ  reason: contains not printable characters */
    public static final String f267 = "plc001_b_bcl_il";

    /* renamed from: ʼﹳ  reason: contains not printable characters */
    public static final String f268 = "plc001_b_bcl_line";

    /* renamed from: ʼﹶ  reason: contains not printable characters */
    public static final String f269 = "plc001_lps_t_p0";

    /* renamed from: ʼﾞ  reason: contains not printable characters */
    public static final String f270 = "act_a1_1_upl_time";

    /* renamed from: ʽʻ  reason: contains not printable characters */
    public static final String f271 = "apl_a1_1_upl_time";

    /* renamed from: ʽʼ  reason: contains not printable characters */
    public static final String f272 = "es_a1_1_upl_time";

    /* renamed from: ʽʽ  reason: contains not printable characters */
    public static final String f273 = "plc002_soc_sna_s";

    /* renamed from: ʽʾ  reason: contains not printable characters */
    public static final String f274 = "a1_1_upl_time";

    /* renamed from: ʽʿ  reason: contains not printable characters */
    public static final String f275 = "fp_a1_1_upl_time";

    /* renamed from: ʽˆ  reason: contains not printable characters */
    public static final String f276 = "cpgc_a1_1_upl_time";

    /* renamed from: ʽˈ  reason: contains not printable characters */
    public static final String f277 = "soc_a1_1_upl_time";

    /* renamed from: ʽˉ  reason: contains not printable characters */
    public static final String f278 = "a1_1_f_upl";

    /* renamed from: ʽˊ  reason: contains not printable characters */
    public static final String f279 = "a1_l_p_i_t";

    /* renamed from: ʽˋ  reason: contains not printable characters */
    public static final String f280 = "a1_l_p_i_s";

    /* renamed from: ʽˎ  reason: contains not printable characters */
    public static final String f281 = "l_p_i_s";

    /* renamed from: ʽˏ  reason: contains not printable characters */
    public static final String f282 = "l_p_l_s";

    /* renamed from: ʽˑ  reason: contains not printable characters */
    public static final String f283 = "wp_ks_uuid";

    /* renamed from: ʽי  reason: contains not printable characters */
    public static final String f284 = "wp_ks_td";

    /* renamed from: ʽـ  reason: contains not printable characters */
    public static final String f285 = "wp_ks_con";

    /* renamed from: ʽٴ  reason: contains not printable characters */
    public static final String f286 = "plc001_ac_a";

    /* renamed from: ʽᐧ  reason: contains not printable characters */
    public static final String f287 = "plc001_ac_r";

    /* renamed from: ʽᴵ  reason: contains not printable characters */
    public static C0374 f288 = null;

    /* renamed from: ʾ  reason: contains not printable characters */
    public static final String f289 = "a1_p_s_p_s";

    /* renamed from: ʾʾ  reason: contains not printable characters */
    public static final String f290 = "plc002_pp_v";

    /* renamed from: ʿ  reason: contains not printable characters */
    public static final String f291 = "a1_p_s_p_s_c_b";

    /* renamed from: ʿʿ  reason: contains not printable characters */
    public static final String f292 = "plc002_soc_i";

    /* renamed from: ˆ  reason: contains not printable characters */
    public static final String f293 = "plc001_pd_ptii_pi";

    /* renamed from: ˆˆ  reason: contains not printable characters */
    public static final String f294 = "plc002_pp_c";

    /* renamed from: ˈ  reason: contains not printable characters */
    public static final String f295 = "plc001_t_d";

    /* renamed from: ˈˈ  reason: contains not printable characters */
    public static final String f296 = "plc002_pp_pcl_gc";

    /* renamed from: ˉ  reason: contains not printable characters */
    public static final String f297 = "re_po_rt";

    /* renamed from: ˉˉ  reason: contains not printable characters */
    public static final String f298 = "plc002_pp_i";

    /* renamed from: ˊ  reason: contains not printable characters */
    public static final String f299 = "plc001_lss_v_s";

    /* renamed from: ˊˊ  reason: contains not printable characters */
    public static final String f300 = "plc002_pp_pcl_pke";

    /* renamed from: ˋ  reason: contains not printable characters */
    public static final String f301 = "plc001_v";

    /* renamed from: ˋˋ  reason: contains not printable characters */
    public static final String f302 = "plc002_pp_pcl_cp";

    /* renamed from: ˎ  reason: contains not printable characters */
    public static final String f303 = "plc001_b_pti";

    /* renamed from: ˎˎ  reason: contains not printable characters */
    public static final String f304 = "plc002_pp_pcl_pam";

    /* renamed from: ˏ  reason: contains not printable characters */
    public static final String f305 = "plc001_p_i";

    /* renamed from: ˏˏ  reason: contains not printable characters */
    public static final String f306 = "plc002_pp_pcl_pds";

    /* renamed from: ˑ  reason: contains not printable characters */
    public static final String f307 = "plc001_scc";

    /* renamed from: ˑˑ  reason: contains not printable characters */
    public static final String f308 = "plc001_r_v";

    /* renamed from: י  reason: contains not printable characters */
    public static final String f309 = "plc001_scc_e";

    /* renamed from: יי  reason: contains not printable characters */
    public static final String f310 = "plc001_r_c";

    /* renamed from: ـ  reason: contains not printable characters */
    public static final String f311 = "plc001_al_v";

    /* renamed from: ــ  reason: contains not printable characters */
    public static final String f312 = "plc002_pp_s";

    /* renamed from: ٴ  reason: contains not printable characters */
    public static final String f313 = "plc001_al_s";

    /* renamed from: ٴٴ  reason: contains not printable characters */
    public static final String f314 = "plc001_r_rcl_fr";

    /* renamed from: ᐧ  reason: contains not printable characters */
    public static final String f315 = "plc001_al_i";

    /* renamed from: ᐧᐧ  reason: contains not printable characters */
    public static final String f316 = "plc001_act_i";

    /* renamed from: ᴵ  reason: contains not printable characters */
    public static final String f317 = "plc001_al_b";

    /* renamed from: ᴵᴵ  reason: contains not printable characters */
    public static final String f318 = "plc002_soc_v";

    /* renamed from: ᵎ  reason: contains not printable characters */
    public static final String f319 = "plc001_al_m";

    /* renamed from: ᵎᵎ  reason: contains not printable characters */
    public static final String f320 = "plc001_r_i";

    /* renamed from: ᵔ  reason: contains not printable characters */
    public static final String f321 = "plc001_a_aor";

    /* renamed from: ᵔᵔ  reason: contains not printable characters */
    public static final String f322 = "plc001_r_s";

    /* renamed from: ᵢ  reason: contains not printable characters */
    public static final String f323 = "plc001_f_dir";

    /* renamed from: ᵢᵢ  reason: contains not printable characters */
    public static final String f324 = "plc001_r_o";

    /* renamed from: ⁱ  reason: contains not printable characters */
    public static final String f325 = "plc001_f_is";

    /* renamed from: ⁱⁱ  reason: contains not printable characters */
    public static final String f326 = "plc001_r_b";

    /* renamed from: ﹳ  reason: contains not printable characters */
    public static final String f327 = "plc001_f_ii";

    /* renamed from: ﹳﹳ  reason: contains not printable characters */
    public static final String f328 = "plc001_r_rcl_re";

    /* renamed from: ﹶ  reason: contains not printable characters */
    public static final String f329 = "plc001_f_act";

    /* renamed from: ﹶﹶ  reason: contains not printable characters */
    public static final String f330 = "plc001_r_rcl_hk";

    /* renamed from: ﾞ  reason: contains not printable characters */
    public static final String f331 = "plc001_act_v";

    /* renamed from: ﾞﾞ  reason: contains not printable characters */
    public static final String f332 = "plc001_act_s";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: ʻ  reason: contains not printable characters */
    public SharedPreferences f333;

    /* renamed from: ʼ  reason: contains not printable characters */
    public SharedPreferences.Editor f334;

    /* renamed from: ʽ  reason: contains not printable characters */
    public Context f335;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(335207323, "Lcom/kuaishou/weapon/p0/ʽי;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(335207323, "Lcom/kuaishou/weapon/p0/ʽי;");
        }
    }

    public C0374(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        try {
            this.f335 = context;
            SharedPreferences sharedPreferences = context.getSharedPreferences("re_po_rt", 4);
            this.f333 = sharedPreferences;
            this.f334 = sharedPreferences.edit();
        } catch (Throwable unused) {
        }
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public static synchronized C0374 m389(Context context) {
        InterceptResult invokeL;
        C0374 c0374;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            synchronized (C0374.class) {
                if (f288 == null) {
                    synchronized (C0374.class) {
                        if (f288 == null) {
                            f288 = new C0374(context);
                        }
                    }
                }
                c0374 = f288;
            }
            return c0374;
        }
        return (C0374) invokeL.objValue;
    }

    /* renamed from: ˈ  reason: contains not printable characters */
    public static C0374 m390() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? f288 : (C0374) invokeV.objValue;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public int m391(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            try {
                return this.f333.getInt(str, 0);
            } catch (Exception unused) {
                return 0;
            }
        }
        return invokeL.intValue;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public int m392(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i)) == null) {
            try {
                return this.f333.getInt(str, i);
            } catch (Exception unused) {
                return i;
            }
        }
        return invokeLI.intValue;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public long m393(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLJ = interceptable.invokeLJ(Constants.METHOD_SEND_USER_MSG, this, str, j)) == null) ? this.f333.getLong(str, j) : invokeLJ.longValue;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public String m394() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f333.getString(f285, "") : (String) invokeV.objValue;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public String m395(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, str2)) == null) ? this.f333.getString(str, str2) : (String) invokeLL.objValue;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public String m396(String str, String str2, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048581, this, str, str2, z)) == null) {
            String m395 = m395(str, "");
            return !TextUtils.isEmpty(m395) ? z ? C0446.m976(m395, 2) : m395 : str2;
        }
        return (String) invokeLLZ.objValue;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public void m397(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048582, this, j) == null) {
            this.f334.putLong(f279, j);
            this.f334.apply();
        }
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public void m398(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, context) == null) {
            this.f335 = context;
        }
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public void m399(String str, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{str, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            this.f334.putInt(str, i);
            if (z) {
                this.f334.apply();
            }
        }
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public void m400(String str, C0412 c0412) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, str, c0412) == null) {
            if (c0412 != null) {
                try {
                    String m421 = m421(f301);
                    m417(f303, c0412.m630());
                    m417(f321, c0412.m599());
                    m413(f323, c0412.m628());
                    m417(f329, c0412.m605());
                    m417(f307, c0412.m644());
                    try {
                        m413(f325, c0412.m638());
                        m417(f327, c0412.m637());
                        String m4212 = m421(f325);
                        if (!TextUtils.isEmpty(m4212)) {
                            WeaponHI.isList = Arrays.asList(m4212.split(WebChromeClient.PARAM_SEPARATOR));
                            WeaponHI.ii = m402(f327, 5);
                        }
                    } catch (Exception unused) {
                    }
                    m397(System.currentTimeMillis());
                    String m631 = c0412.m631();
                    if (TextUtils.isEmpty(m421) || m421.compareTo(m631) < 0) {
                        m414(f301, c0412.m631(), false);
                        String m4213 = m421(f311);
                        if (TextUtils.isEmpty(m4213) || m4213.compareTo(c0412.m611()) < 0) {
                            m414(f311, c0412.m611(), false);
                            if (c0412.m587() != null) {
                                m399(f313, c0412.m587().m653(), false);
                                m399(f315, c0412.m587().m649(), false);
                                m399(f317, c0412.m587().m645(), false);
                                m399(f319, c0412.m587().m651(), false);
                            }
                        }
                        String m4214 = m421(f308);
                        if (TextUtils.isEmpty(m4214) || m4214.compareTo(c0412.m643()) < 0) {
                            m414(f308, c0412.m643(), false);
                            if (c0412.m642() != null) {
                                m399(f322, c0412.m642().m772(), false);
                                m399(f310, c0412.m642().m764(), false);
                                m399(f320, c0412.m642().m768(), false);
                                m399(f324, c0412.m642().m770(), false);
                                m399(f326, c0412.m642().m761(), false);
                                C0412.C0422.C0423 m766 = c0412.m642().m766();
                                if (m766 != null) {
                                    m399(f223, m766.m787(), false);
                                    m399(f224, m766.m783(), false);
                                    m399(f225, m766.m773(), false);
                                    m399(f222, m766.m775(), false);
                                    m399(f226, m766.m777(), false);
                                    m399(f328, m766.m789(), false);
                                    m399(f314, m766.m779(), false);
                                    m399(f330, m766.m781(), false);
                                    m399(f227, m766.m795(), false);
                                    m411(f228, m766.m797());
                                    m411(f231, m766.m793());
                                    m411(f232, m766.m799());
                                    m411(f229, m766.m791());
                                    m411(f230, m766.m785());
                                }
                            }
                        }
                        String m4215 = m421(f246);
                        if (TextUtils.isEmpty(m4215) || m4215.compareTo(c0412.m620()) < 0) {
                            m414(f246, c0412.m620(), false);
                            if (c0412.m614() != null) {
                                m399(f248, c0412.m614().m668(), false);
                                m399(f249, c0412.m614().m661(), false);
                                m399(f250, c0412.m614().m666(), false);
                                C0412.C0415.C0416 m664 = c0412.m614().m664();
                                if (m664 != null) {
                                    m399(f251, m664.m675(), false);
                                    m399(f252, m664.m693(), false);
                                    m399(f253, m664.m673(), false);
                                    m399(f254, m664.m689(), false);
                                    m399(f256, m664.m703(), false);
                                    m399(f255, m664.m697(), false);
                                    m399(f257, m664.m701(), false);
                                    m399(f258, m664.m669(), false);
                                    m399(f259, m664.m685(), false);
                                    m399(f260, m664.m679(), false);
                                    m399(f261, m664.m683(), false);
                                    m399(f262, m664.m677(), false);
                                    m399(f263, m664.m671(), false);
                                    m399(f264, m664.m687(), false);
                                    m399(f265, m664.m695(), false);
                                    m399(f266, m664.m699(), false);
                                    m399(f267, m664.m681(), false);
                                    m399(f268, m664.m691(), false);
                                }
                            }
                        }
                        String m4216 = m421(f233);
                        if (TextUtils.isEmpty(m4216) || m4216.compareTo(c0412.m626()) < 0) {
                            m414(f233, c0412.m626(), false);
                            if (c0412.m624() != null) {
                                m399(f234, c0412.m624().m714(), false);
                                m399(f235, c0412.m624().m708(), false);
                                m399(f236, c0412.m624().m712(), false);
                                m399(f237, c0412.m624().m705(), false);
                                C0412.C0417.C0418 m710 = c0412.m624().m710();
                                if (m710 != null) {
                                    m399(f238, m710.m717(), false);
                                    m399(f239, m710.m721(), false);
                                    m399(f240, m710.m723(), false);
                                    m399(f241, m710.m719(), false);
                                    m399(f242, m710.m725(), false);
                                    m399(f243, m710.m715(), false);
                                    m399(f244, m710.m729(), false);
                                    m399(f245, m710.m727(), false);
                                }
                            }
                        }
                        String m4217 = m421(f290);
                        if (TextUtils.isEmpty(m4217) || m4217.compareTo(c0412.m641()) < 0) {
                            m414(f290, c0412.m641(), false);
                            if (c0412.m640() != null) {
                                C0412.C0420 m640 = c0412.m640();
                                m399(f312, m640.m750(), false);
                                m399(f294, m640.m743(), false);
                                m399(f298, m640.m748(), false);
                                C0412.C0420.C0421 m746 = m640.m746();
                                if (m746 != null) {
                                    m399(f302, m746.m751(), false);
                                    m399(f296, m746.m753(), false);
                                    m399(f306, m746.m757(), false);
                                    m399(f300, m746.m759(), false);
                                    m399(f304, m746.m755(), false);
                                }
                            }
                        }
                        String m4218 = m421(f318);
                        if (TextUtils.isEmpty(m4218) || m4218.compareTo(c0412.m636()) < 0) {
                            m414(f318, c0412.m636(), false);
                            if (c0412.m634() != null) {
                                m399(f221, c0412.m634().m807(), false);
                                m399(f247, c0412.m634().m803(), false);
                                m399(f292, c0412.m634().m805(), false);
                                m399(f273, c0412.m634().m801(), false);
                            }
                        }
                        String m4219 = m421(f331);
                        if (TextUtils.isEmpty(m4219) || m4219.compareTo(c0412.m608()) < 0) {
                            m414(f331, c0412.m608(), false);
                            if (c0412.m602() != null) {
                                m399(f332, c0412.m602().m659(), false);
                                m399(f316, c0412.m602().m657(), false);
                            }
                        }
                    }
                } catch (Throwable unused2) {
                }
            }
            try {
                this.f334.apply();
            } catch (Throwable unused3) {
            }
        }
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public void m401(String str, Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, str, bool) == null) {
            this.f334.putBoolean(str, bool.booleanValue());
            this.f334.apply();
        }
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public int m402(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048587, this, str, i)) == null) {
            try {
                return this.f333.getInt(str, i);
            } catch (Exception unused) {
                return i;
            }
        }
        return invokeLI.intValue;
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public Context m403() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f335 : (Context) invokeV.objValue;
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public void m404(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048589, this, j) == null) {
            this.f334.putLong(f274, j);
            this.f334.apply();
        }
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public void m405(String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048590, this, str, j) == null) {
            this.f334.putLong(str, j);
            this.f334.apply();
        }
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public void m406(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, str, str2) == null) {
            try {
                this.f334.putString(str, str2);
                this.f334.apply();
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public void m407(String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(1048592, this, str, str2, z) == null) || TextUtils.isEmpty(str2)) {
            return;
        }
        if (z) {
            str2 = C0446.m979(str2.getBytes(), 2);
        }
        this.f334.putString(str, str2);
        this.f334.apply();
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public boolean m408(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) ? this.f333.getBoolean(str, false) : invokeL.booleanValue;
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    public int m409(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, str)) == null) {
            try {
                return this.f333.getInt(str, 0);
            } catch (Exception unused) {
                return 0;
            }
        }
        return invokeL.intValue;
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    public long m410() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f333.getLong(f279, 0L) : invokeV.longValue;
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    public void m411(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048596, this, str, i) == null) {
            this.f334.putInt(str, i);
            this.f334.apply();
        }
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    public void m412(String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048597, this, str, j) == null) {
            this.f334.putLong(str, j);
            this.f334.apply();
        }
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    public void m413(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048598, this, str, str2) == null) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.f334.putString(str, str2);
        this.f334.apply();
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    public void m414(String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(1048599, this, str, str2, z) == null) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.f334.putString(str, str2);
        if (z) {
            this.f334.apply();
        }
    }

    /* renamed from: ʾ  reason: contains not printable characters */
    public long m415() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.f333.getLong(f274, 0L) : invokeV.longValue;
    }

    /* renamed from: ʾ  reason: contains not printable characters */
    public long m416(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, str)) == null) ? this.f333.getLong(str, 0L) : invokeL.longValue;
    }

    /* renamed from: ʾ  reason: contains not printable characters */
    public void m417(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048602, this, str, i) == null) {
            this.f334.putInt(str, i);
            this.f334.apply();
        }
    }

    /* renamed from: ʿ  reason: contains not printable characters */
    public long m418(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, str)) == null) ? this.f333.getLong(str, 0L) : invokeL.longValue;
    }

    /* renamed from: ʿ  reason: contains not printable characters */
    public String m419() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.f333.getString(f284, "") : (String) invokeV.objValue;
    }

    /* renamed from: ˆ  reason: contains not printable characters */
    public String m420() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.f333.getString(f283, "") : (String) invokeV.objValue;
    }

    /* renamed from: ˆ  reason: contains not printable characters */
    public String m421(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, str)) == null) ? this.f333.getString(str, "") : (String) invokeL.objValue;
    }

    /* renamed from: ˈ  reason: contains not printable characters */
    public void m422(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, str) == null) {
            this.f334.putString(f285, str);
            this.f334.commit();
        }
    }

    /* renamed from: ˉ  reason: contains not printable characters */
    public void m423(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, str) == null) {
            this.f334.putString(f284, str);
            this.f334.apply();
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m424(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, str) == null) {
            this.f334.putString(f283, str);
            this.f334.commit();
        }
    }
}
