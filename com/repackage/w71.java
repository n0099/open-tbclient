package com.repackage;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.payment.PaymentManager;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.searchbox.unitedscheme.SchemeConfig;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
@Singleton
@Service
/* loaded from: classes7.dex */
public class w71 implements y71 {
    public static /* synthetic */ Interceptable $ic;
    public static final String a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755248576, "Lcom/repackage/w71;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755248576, "Lcom/repackage/w71;");
                return;
            }
        }
        a = SchemeConfig.getSchemeHead() + "://swan/";
    }

    public w71() {
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

    @Override // com.repackage.y71
    public void a(Activity activity, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, activity, str, str2) == null) {
            bk2.S().a(activity, str, str2);
        }
    }

    @Override // com.repackage.y71
    public void aLiAuth(Activity activity, String str, e81<JSONObject> e81Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, str, e81Var) == null) {
            bk2.S().f(activity, str, e81Var);
        }
    }

    @Override // com.repackage.y71
    public boolean b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) ? bk2.S().b(context) : invokeL.booleanValue;
    }

    @Override // com.repackage.y71
    public void c(Activity activity, String str, t71 t71Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, activity, str, t71Var) == null) {
            bk2.S().c(activity, str, t71Var);
        }
    }

    @Override // com.repackage.y71
    public void d(Context context, JSONObject jSONObject, t71 t71Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, context, jSONObject, t71Var) == null) {
            bk2.S().d(context, jSONObject, t71Var);
        }
    }

    @Override // com.repackage.y71
    public void e(Activity activity, String str, t71 t71Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, activity, str, t71Var) == null) {
            bk2.S().e(activity, str, t71Var);
        }
    }

    @Override // com.repackage.y71
    public void f(Context context, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, context, jSONObject) == null) {
            if (jSONObject == null) {
                PaymentManager.i(3, "支付信息不能为空");
                return;
            }
            String optString = jSONObject.optString("appKey");
            String optString2 = jSONObject.optString("redirectUrl");
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                SchemeRouter.invoke(context, a + optString + optString2);
                return;
            }
            PaymentManager.i(3, "支付信息不能为空");
        }
    }

    @Override // com.repackage.y71
    public void g(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bundle) == null) {
            String str = it2.b().a;
            if (TextUtils.isEmpty(str)) {
                q71.a(bundle);
                return;
            }
            kx2 e = kx2.e();
            mx2 mx2Var = new mx2(119, bundle);
            mx2Var.c(str);
            mx2Var.p(true);
            e.h(mx2Var);
        }
    }

    @Override // com.repackage.y71
    public void h(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            it2.b().a = str;
        }
    }

    @Override // com.repackage.y71
    public void i(Activity activity, JSONObject jSONObject, t71 t71Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048585, this, activity, jSONObject, t71Var) == null) {
        }
    }

    @Override // com.repackage.y71
    public String j(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, context)) == null) ? bk2.G0().a(context) : (String) invokeL.objValue;
    }
}
