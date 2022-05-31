package com.repackage;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.io.Closeables;
import com.baidu.android.util.io.FileUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.SignAllForumAdvertActivityConfig;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.debugtool.annotation.Modify;
import com.baidu.tieba.debugtool.annotation.ModifyClass;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@ModifyClass
/* loaded from: classes5.dex */
public class fb5 {
    public static /* synthetic */ Interceptable $ic;
    public static fb5 a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755713576, "Lcom/repackage/fb5;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755713576, "Lcom/repackage/fb5;");
        }
    }

    public fb5() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Modify(description = "广告-热启动是否开启debug模式", type = 100)
    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Modify(description = "广告-禁止初始化穿山甲", type = 100)
    public static boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? ys4.k().l("key_fun_cjs_init", 1) == 0 : invokeV.booleanValue;
    }

    @Modify(description = "广告-禁止初始化广点通", type = 100)
    public static boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? ys4.k().l("key_fun_gdt_init", 1) == 0 : invokeV.booleanValue;
    }

    @Modify(description = "广告-禁止初始化快手", type = 100)
    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? ys4.k().l("key_fun_ks_init", 1) == 0 : invokeV.booleanValue;
    }

    @Modify(description = "广告-FRS页面混排广告条数", type = 100)
    public static int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? ys4.k().l("key_mix_frs_ad_count", 5) : invokeV.intValue;
    }

    public static String g(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65543, null, str, i)) == null) {
            List<jp6> g = kp6.j().g(str);
            JSONArray jSONArray = new JSONArray();
            for (jp6 jp6Var : g) {
                for (int i2 = 0; i2 < jp6Var.e && jSONArray.length() < i; i2++) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("id", jp6Var.d + i2);
                        jSONObject.put("ecpm", String.valueOf(jp6Var.f));
                        jSONArray.put(jSONObject);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
            return ci.j(jSONArray.toString().getBytes(StandardCharsets.UTF_8));
        }
        return (String) invokeLI.objValue;
    }

    public static double i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            return 0.0d;
        }
        return invokeV.doubleValue;
    }

    public static synchronized fb5 j() {
        InterceptResult invokeV;
        fb5 fb5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            synchronized (fb5.class) {
                if (a == null) {
                    a = new fb5();
                }
                fb5Var = a;
            }
            return fb5Var;
        }
        return (fb5) invokeV.objValue;
    }

    public static int k() {
        InterceptResult invokeV;
        int min;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            int s = s();
            int t = t();
            if (s != t && (min = Math.min(s, t)) > 0 && min < 10000) {
                return min;
            }
            return 1000;
        }
        return invokeV.intValue;
    }

    public static int l() {
        InterceptResult invokeV;
        int max;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            int s = s();
            int t = t();
            if (s != t && (max = Math.max(s, t)) > 0 && max < 10000) {
                return max;
            }
            return 1400;
        }
        return invokeV.intValue;
    }

    public static String m(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65548, null, i)) == null) {
            if (i != -1) {
                return i != 0 ? i != 1 ? i != 2 ? i != 3 ? "PLG_Other" : "PLG_CPC" : "PLG_OperateHighly" : "PLG_OperateNormal" : "PLG_GD";
            }
            return null;
        }
        return (String) invokeI.objValue;
    }

    public static boolean n(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, str)) == null) {
            if (UbsABTestHelper.isFrsFunAdSdkTest()) {
                return !(TbadkCoreApplication.getCurrentAccountInfo() != null && TbadkCoreApplication.getCurrentAccountInfo().getMemberCloseAdVipClose() == 1) && o(str) > 0;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static int o(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, str)) == null) {
            int i = 0;
            for (jp6 jp6Var : kp6.j().g(str)) {
                i += jp6Var.e;
            }
            return i;
        }
        return invokeL.intValue;
    }

    public static boolean p(Object obj) {
        InterceptResult invokeL;
        zg8 zg8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, obj)) == null) {
            if (obj instanceof co4) {
                return true;
            }
            if (obj instanceof rp4) {
                zg8Var = ((rp4) obj).s.funAdData;
            } else if (obj instanceof ThreadData) {
                zg8Var = ((ThreadData) obj).funAdData;
            } else {
                zg8Var = obj instanceof PostData ? ((PostData) obj).s0 : null;
            }
            return zg8Var != null;
        }
        return invokeL.booleanValue;
    }

    @Modify(description = "小熊广告-开屏是否提前初始化", type = 33)
    public static boolean q(int i) {
        InterceptResult invokeI;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65552, null, i)) == null) {
            if (UbsABTestHelper.newSplashStrategy()) {
                if (w()) {
                    return y91.b() && u();
                }
                return u();
            }
            switch (i) {
                case 101:
                case 102:
                case 103:
                case 104:
                case 105:
                    z = true;
                    break;
                default:
                    z = false;
                    break;
            }
            return ys4.k().l("splash_origin_ad_strategy_key", 1) != 0 ? y91.b() && z : z;
        }
        return invokeI.booleanValue;
    }

    @Modify(description = "广告-是否需要请求frs页面的小熊广告", type = 100)
    public static boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) {
            return ((ys4.k().l("splash_origin_ad_strategy_key", 1) == 1) || (TbadkCoreApplication.getCurrentAccountInfo() != null && TbadkCoreApplication.getCurrentAccountInfo().getMemberCloseAdVipClose() == 1)) ? false : true;
        }
        return invokeV.booleanValue;
    }

    @Modify(description = "广告-开屏广告第一次超时时间(新)", type = 100)
    public static int s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) ? ys4.k().l("key_splash_new_policy_first_timeout", 1000) : invokeV.intValue;
    }

    @Modify(description = "广告-开屏广告第二次超时时间(新)", type = 100)
    public static int t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65555, null)) == null) ? ys4.k().l("key_splash_new_policy_second_timeout", 1400) : invokeV.intValue;
    }

    @Modify(description = "小熊广告-开屏是否展示小熊开关(新)", type = 100)
    public static boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65556, null)) == null) ? ys4.k().l("key_splash_new_policy_bear_enable", 0) == 1 : invokeV.booleanValue;
    }

    @Modify(description = "广告-开屏是否展示序章CPC开关(新)", type = 100)
    public static boolean v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65557, null)) == null) ? ys4.k().l("key_splash_new_policy_plg_cpc_enable", 0) == 1 : invokeV.booleanValue;
    }

    @Modify(description = "广告-开屏是否展示序章开关(新)", type = 100)
    public static boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65558, null)) == null) ? ys4.k().l("key_splash_new_policy_plg_enable", 0) == 1 : invokeV.booleanValue;
    }

    public long b(File file, String str) {
        InterceptResult invokeLL;
        FileOutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, file, str)) == null) {
            long j = 0;
            if (TextUtils.isEmpty(str) || file == null) {
                return 0L;
            }
            InputStream inputStream = null;
            try {
                Response executeSync = HttpManager.getDefault(AppRuntime.getAppContext()).getRequest().url(str).build().executeSync();
                if (executeSync == null || executeSync.code() != 200) {
                    fileOutputStream = null;
                } else {
                    InputStream byteStream = executeSync.body().byteStream();
                    if (byteStream != null) {
                        try {
                            fileOutputStream = new FileOutputStream(file);
                            try {
                                j = FileUtils.copyStream(byteStream, fileOutputStream);
                            } catch (Exception e) {
                                e = e;
                                inputStream = byteStream;
                                try {
                                    TiebaStatic.log(e.toString());
                                    Closeables.closeSafely(inputStream);
                                    Closeables.closeSafely(fileOutputStream);
                                    return j;
                                } catch (Throwable th) {
                                    th = th;
                                    Closeables.closeSafely(inputStream);
                                    Closeables.closeSafely(fileOutputStream);
                                    throw th;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                inputStream = byteStream;
                                Closeables.closeSafely(inputStream);
                                Closeables.closeSafely(fileOutputStream);
                                throw th;
                            }
                        } catch (Exception e2) {
                            e = e2;
                            fileOutputStream = null;
                        } catch (Throwable th3) {
                            th = th3;
                            fileOutputStream = null;
                        }
                    } else {
                        fileOutputStream = null;
                    }
                    inputStream = byteStream;
                }
            } catch (Exception e3) {
                e = e3;
                fileOutputStream = null;
            } catch (Throwable th4) {
                th = th4;
                fileOutputStream = null;
            }
            Closeables.closeSafely(inputStream);
            Closeables.closeSafely(fileOutputStream);
            return j;
        }
        return invokeLL.longValue;
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? TbadkSettings.getInst().loadString(SignAllForumAdvertActivityConfig.AD_URL, null) : (String) invokeV.objValue;
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            String h = h();
            if (TextUtils.isEmpty(h)) {
                return;
            }
            fg.h().k(h, 10, null, 0, 0, null, new Object[0]);
        }
    }
}
