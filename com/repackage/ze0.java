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
/* loaded from: classes7.dex */
public class ze0 extends lg0 {
    public static /* synthetic */ Interceptable $ic;
    public static final String a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755115028, "Lcom/repackage/ze0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755115028, "Lcom/repackage/ze0;");
                return;
            }
        }
        a = nh0.a().a();
    }

    public ze0() {
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

    @Override // com.repackage.lg0
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "mnprogram" : (String) invokeV.objValue;
    }

    @Override // com.repackage.lg0
    public boolean b(@NonNull Context context, @NonNull pg0 pg0Var, @Nullable Map<String, Object> map, @Nullable tg0 tg0Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, pg0Var, map, tg0Var)) == null) {
            super.b(context, pg0Var, map, tg0Var);
            if (TextUtils.isEmpty(a)) {
                c(tg0Var, pg0Var, 303, false);
                return true;
            }
            HashMap<String, String> d = pg0Var.d();
            if (TextUtils.isEmpty((CharSequence) mx0.b(d, "mn_program_type"))) {
                c(tg0Var, pg0Var, 202, false);
                return true;
            }
            WXLaunchMiniProgram.Req req = new WXLaunchMiniProgram.Req();
            req.userName = (String) mx0.b(d, "user_name");
            req.path = (String) mx0.b(d, "path");
            req.miniprogramType = Integer.parseInt((String) mx0.b(d, "mn_program_type"));
            boolean sendReq = WXAPIFactory.createWXAPI(context, a).sendReq(req);
            if (!sendReq) {
                return kg0.e((String) mx0.b(d, "web_url"), context, map, tg0Var);
            }
            c(tg0Var, pg0Var, 0, sendReq);
            return true;
        }
        return invokeLLLL.booleanValue;
    }
}
