package com.repackage;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.CookieManager;
import com.yy.hiidostatis.defs.obj.ParamableElem;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
/* loaded from: classes7.dex */
public class x24 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements af3<h53> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ os1 a;
        public final /* synthetic */ String b;

        public a(os1 os1Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {os1Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = os1Var;
            this.b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.af3
        /* renamed from: b */
        public void a(h53 h53Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, h53Var) == null) {
                if (h53Var == null || h53Var.d || h53Var.j != 1) {
                    x24.c(this.a, "system deny");
                } else {
                    x24.e(this.a, this.b);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755223497, "Lcom/repackage/x24;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755223497, "Lcom/repackage/x24;");
                return;
            }
        }
        a = rg1.a;
    }

    public static void c(os1 os1Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, os1Var, str) == null) {
            pu3 pu3Var = new pu3();
            pu3Var.errMsg = str;
            s24.call(os1Var, false, pu3Var);
        }
    }

    public static void d(JsObject jsObject) {
        os1 F;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jsObject) == null) || (F = os1.F(jsObject)) == null) {
            return;
        }
        h03 b0 = h03.b0();
        if (b0 == null) {
            c(F, "internal error");
            return;
        }
        String C = F.C("domain", "baidu.com");
        if (a) {
            Log.i("SwanGameUuapApi", "getUUAPInfo-domain: " + C);
        }
        b0.e0().e("mapp_uuap_info", new a(F, C));
    }

    public static void e(os1 os1Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, os1Var, str) == null) {
            y24 y24Var = new y24();
            String cookie = CookieManager.getInstance().getCookie(str);
            if (!TextUtils.isEmpty(cookie)) {
                Map<String, String> f = f(cookie);
                y24Var.uuap_p_token = f.get("UUAP_P_TOKEN");
                y24Var.uuap_p_token_offline = f.get("UUAP_P_TOKEN_OFFLINE");
                y24Var.uuap_s_token = f.get("UUAP_S_TOKEN");
            }
            s24.call(os1Var, true, y24Var);
        }
    }

    @NonNull
    public static Map<String, String> f(@NonNull String str) {
        InterceptResult invokeL;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
            HashMap hashMap = new HashMap();
            for (String str2 : str.split(ParamableElem.DIVIDE_PARAM)) {
                if (str2 != null && str2.contains("=")) {
                    int indexOf = str2.indexOf("=");
                    hashMap.put(str2.substring(0, indexOf).trim().toUpperCase(Locale.US), str2.substring(indexOf + 1));
                }
            }
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }
}
