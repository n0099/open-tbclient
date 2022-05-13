package com.repackage;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
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
import java.util.Map;
@Service
/* loaded from: classes6.dex */
public class ig0 extends uh0 {
    public static /* synthetic */ Interceptable $ic;
    public static final String a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755619553, "Lcom/repackage/ig0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755619553, "Lcom/repackage/ig0;");
                return;
            }
        }
        a = wi0.a().a();
    }

    public ig0() {
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

    @Override // com.repackage.uh0
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "mnprogram" : (String) invokeV.objValue;
    }

    @Override // com.repackage.uh0
    public boolean b(@NonNull Context context, @NonNull yh0 yh0Var, @Nullable Map<String, Object> map, @Nullable ci0 ci0Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, yh0Var, map, ci0Var)) == null) {
            super.b(context, yh0Var, map, ci0Var);
            if (TextUtils.isEmpty(a)) {
                c(ci0Var, yh0Var, 303, false);
                return true;
            }
            HashMap<String, String> d = yh0Var.d();
            if (TextUtils.isEmpty((CharSequence) vy0.b(d, "mn_program_type"))) {
                c(ci0Var, yh0Var, 202, false);
                return true;
            }
            WXLaunchMiniProgram.Req req = new WXLaunchMiniProgram.Req();
            req.userName = (String) vy0.b(d, "user_name");
            req.path = (String) vy0.b(d, "path");
            req.miniprogramType = Integer.parseInt((String) vy0.b(d, "mn_program_type"));
            boolean sendReq = WXAPIFactory.createWXAPI(context, a).sendReq(req);
            if (!sendReq) {
                return th0.e((String) vy0.b(d, "web_url"), context, map, ci0Var);
            }
            c(ci0Var, yh0Var, 0, sendReq);
            return true;
        }
        return invokeLLLL.booleanValue;
    }
}
