package com.repackage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.prologue.business.data.BaseVM;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tbadk.core.util.schemeaction.deeplink.DeepLinkItem;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
@SuppressLint({"LongLogTag"})
/* loaded from: classes5.dex */
public class cc1 extends yb1 {
    public static /* synthetic */ Interceptable $ic;
    public static final String[] a;
    public static final String b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements vb1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(cc1 cc1Var, ub1 ub1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cc1Var, ub1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements xg0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean[] a;

        public b(cc1 cc1Var, boolean[] zArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cc1Var, zArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zArr;
        }

        @Override // com.repackage.xg0
        public void onResult(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.a[0] = z;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755802112, "Lcom/repackage/cc1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755802112, "Lcom/repackage/cc1;");
                return;
            }
        }
        a = new String[]{"deeplink", "open", "mnprogram"};
        b = sh0.a().a();
    }

    public cc1() {
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

    @Override // com.repackage.yb1
    public void a(HashMap<String, String> hashMap) {
        String[] strArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, hashMap) == null) {
            for (String str : a) {
                hashMap.put("splash/ad/" + str, "splash_ad/" + str);
            }
        }
    }

    @Override // com.repackage.yb1
    @SuppressLint({"LongLogTag"})
    public boolean c(Context context, ac1 ac1Var, ub1 ub1Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, ac1Var, ub1Var)) == null) {
            String d = ac1Var.d(true);
            if (!TextUtils.isEmpty(d) && context != null) {
                if (ac1Var.e()) {
                    return true;
                }
                char c = 65535;
                int hashCode = d.hashCode();
                if (hashCode != -1317819965) {
                    if (hashCode != 3417674) {
                        if (hashCode == 629233382 && d.equals("deeplink")) {
                            c = 0;
                        }
                    } else if (d.equals("open")) {
                        c = 1;
                    }
                } else if (d.equals("mnprogram")) {
                    c = 2;
                }
                if (c != 0) {
                    if (c != 1) {
                        if (c != 2) {
                            return false;
                        }
                        return f(context, ac1Var, ub1Var);
                    }
                    return g(ac1Var, ub1Var);
                }
                return e(context, ac1Var, ub1Var);
            }
            ac1Var.i = dc1.h(201);
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public final boolean e(@NonNull Context context, @NonNull ac1 ac1Var, ub1 ub1Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, context, ac1Var, ub1Var)) == null) {
            String str = ac1Var.c().get("params");
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString(DeepLinkItem.DEEPLINK_APPURL_KEY);
                String optString2 = jSONObject.optString(DeepLinkItem.DEEPLINK_WEBURL_KEY);
                String optString3 = jSONObject.optString("pkgName");
                if (!TextUtils.isEmpty(optString)) {
                    boolean[] zArr = new boolean[1];
                    zg0.a(context, optString, optString3, new b(this, zArr), false);
                    if (zArr[0]) {
                        BaseVM.f("APP");
                        return true;
                    }
                }
                if (!TextUtils.isEmpty(optString3) && zg0.b(context, optString3)) {
                    BaseVM.f("APP");
                    return true;
                } else if (TextUtils.isEmpty(optString2)) {
                    return false;
                } else {
                    BaseVM.f("URL");
                    return h(optString2, ub1Var);
                }
            } catch (JSONException e) {
                e.printStackTrace();
                return false;
            }
        }
        return invokeLLL.booleanValue;
    }

    public final boolean f(Context context, ac1 ac1Var, ub1 ub1Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, context, ac1Var, ub1Var)) == null) {
            if (TextUtils.isEmpty(b)) {
                if (ub1Var != null) {
                    ub1Var.handleSchemeDispatchCallback(String.valueOf(303), null);
                }
                return false;
            }
            String str = ac1Var.c().get("params");
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (TextUtils.isEmpty(jSONObject.optString("mnProgramType"))) {
                    if (ub1Var != null) {
                        ub1Var.handleSchemeDispatchCallback(String.valueOf(202), null);
                    }
                    return false;
                }
                WXLaunchMiniProgram.Req req = new WXLaunchMiniProgram.Req();
                req.userName = jSONObject.optString(TbEnum.SystemMessage.KEY_USER_NAME);
                req.path = jSONObject.optString("path");
                req.miniprogramType = jSONObject.optInt("mnProgramType");
                String optString = jSONObject.optString("extInfo");
                IWXAPI createWXAPI = WXAPIFactory.createWXAPI(context, b);
                boolean sendReq = createWXAPI.sendReq(req);
                if (!sendReq) {
                    i("URL", optString, !createWXAPI.isWXAppInstalled() ? "1001" : "1002");
                    return h(jSONObject.optString(DeepLinkItem.DEEPLINK_WEBURL_KEY), ub1Var);
                }
                i(ClogBuilder.Area.APP.type, optString, null);
                ub1Var.handleSchemeDispatchCallback(String.valueOf(0), null);
                return sendReq;
            } catch (JSONException e) {
                e.printStackTrace();
                return false;
            }
        }
        return invokeLLL.booleanValue;
    }

    public final boolean g(ac1 ac1Var, ub1 ub1Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, ac1Var, ub1Var)) == null) {
            String str = ac1Var.c().get("params");
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString(DeepLinkItem.DEEPLINK_WEBURL_KEY);
                if (TextUtils.isEmpty(optString)) {
                    optString = jSONObject.optString("innerUrl");
                }
                return h(optString, ub1Var);
            } catch (JSONException e) {
                e.printStackTrace();
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public final boolean h(@NonNull String str, ub1 ub1Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, ub1Var)) == null) {
            boolean a2 = cb1.b().a(str, new a(this, ub1Var));
            return (a2 || ub1Var == null) ? a2 : ub1Var.c(str);
        }
        return invokeLL.booleanValue;
    }

    public final void i(@NonNull String str, @Nullable String str2, @Nullable String str3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048582, this, str, str2, str3) == null) || TextUtils.isEmpty(str2)) {
            return;
        }
        ClogBuilder clogBuilder = new ClogBuilder();
        clogBuilder.u(ClogBuilder.Page.MINI_PROGRAM);
        clogBuilder.y(ClogBuilder.LogType.MINI_PROGRAM);
        clogBuilder.j(str);
        clogBuilder.p(str2);
        if (!TextUtils.isEmpty(str3)) {
            clogBuilder.k(str3);
        }
        hy0.b(clogBuilder);
    }
}
