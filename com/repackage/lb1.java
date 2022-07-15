package com.repackage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
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
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
@SuppressLint({"LongLogTag"})
/* loaded from: classes6.dex */
public class lb1 extends hb1 {
    public static /* synthetic */ Interceptable $ic;
    public static final String[] a;
    public static final String b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements eb1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(lb1 lb1Var, db1 db1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lb1Var, db1Var};
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

    /* loaded from: classes6.dex */
    public class b implements bh0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean[] a;

        public b(lb1 lb1Var, boolean[] zArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lb1Var, zArr};
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

        @Override // com.repackage.bh0
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755534954, "Lcom/repackage/lb1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755534954, "Lcom/repackage/lb1;");
                return;
            }
        }
        a = new String[]{"deeplink", "open", "mnprogram"};
        b = wh0.a().a();
    }

    public lb1() {
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

    @Override // com.repackage.hb1
    public void a(HashMap<String, String> hashMap) {
        String[] strArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, hashMap) == null) {
            for (String str : a) {
                hashMap.put("splash/ad/" + str, "splash_ad/" + str);
            }
        }
    }

    @Override // com.repackage.hb1
    @SuppressLint({"LongLogTag"})
    public boolean c(Context context, jb1 jb1Var, db1 db1Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, jb1Var, db1Var)) == null) {
            String d = jb1Var.d(true);
            if (!TextUtils.isEmpty(d) && context != null) {
                if (jb1Var.e()) {
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
                        return f(context, jb1Var, db1Var);
                    }
                    return g(jb1Var, db1Var);
                }
                return e(context, jb1Var, db1Var);
            }
            jb1Var.i = mb1.h(201);
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public final boolean e(@NonNull Context context, @NonNull jb1 jb1Var, db1 db1Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, context, jb1Var, db1Var)) == null) {
            String str = jb1Var.c().get("params");
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
                    dh0.a(context, optString, optString3, new b(this, zArr), false);
                    if (zArr[0]) {
                        BaseVM.f("APP");
                        return true;
                    }
                }
                if (!TextUtils.isEmpty(optString3) && dh0.b(context, optString3)) {
                    BaseVM.f("APP");
                    return true;
                } else if (TextUtils.isEmpty(optString2)) {
                    return false;
                } else {
                    BaseVM.f("URL");
                    return h(optString2, db1Var);
                }
            } catch (JSONException e) {
                e.printStackTrace();
                return false;
            }
        }
        return invokeLLL.booleanValue;
    }

    public final boolean f(Context context, jb1 jb1Var, db1 db1Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, context, jb1Var, db1Var)) == null) {
            if (TextUtils.isEmpty(b)) {
                if (db1Var != null) {
                    db1Var.handleSchemeDispatchCallback(String.valueOf(303), null);
                }
                return false;
            }
            String str = jb1Var.c().get("params");
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (TextUtils.isEmpty(jSONObject.optString("mnProgramType"))) {
                    if (db1Var != null) {
                        db1Var.handleSchemeDispatchCallback(String.valueOf(202), null);
                    }
                    return false;
                }
                WXLaunchMiniProgram.Req req = new WXLaunchMiniProgram.Req();
                req.userName = jSONObject.optString(TbEnum.SystemMessage.KEY_USER_NAME);
                req.path = jSONObject.optString("path");
                req.miniprogramType = jSONObject.optInt("mnProgramType");
                boolean sendReq = WXAPIFactory.createWXAPI(context, b).sendReq(req);
                if (!sendReq) {
                    return h(jSONObject.optString(DeepLinkItem.DEEPLINK_WEBURL_KEY), db1Var);
                }
                db1Var.handleSchemeDispatchCallback(String.valueOf(0), null);
                return sendReq;
            } catch (JSONException e) {
                e.printStackTrace();
                return false;
            }
        }
        return invokeLLL.booleanValue;
    }

    public final boolean g(jb1 jb1Var, db1 db1Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, jb1Var, db1Var)) == null) {
            String str = jb1Var.c().get("params");
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString(DeepLinkItem.DEEPLINK_WEBURL_KEY);
                if (TextUtils.isEmpty(optString)) {
                    optString = jSONObject.optString("innerUrl");
                }
                return h(optString, db1Var);
            } catch (JSONException e) {
                e.printStackTrace();
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public final boolean h(@NonNull String str, db1 db1Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, db1Var)) == null) {
            boolean a2 = la1.b().a(str, new a(this, db1Var));
            return (a2 || db1Var == null) ? a2 : db1Var.c(str);
        }
        return invokeLL.booleanValue;
    }
}
