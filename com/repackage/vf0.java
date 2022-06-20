package com.repackage;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebChromeClient;
import java.util.HashMap;
import java.util.Map;
@Service
/* loaded from: classes7.dex */
public class vf0 extends lg0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public vf0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.repackage.lg0
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "loadCache" : (String) invokeV.objValue;
    }

    @Override // com.repackage.lg0
    public boolean b(@NonNull Context context, @NonNull pg0 pg0Var, @Nullable Map<String, Object> map, @Nullable tg0 tg0Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, pg0Var, map, tg0Var)) == null) {
            super.b(context, pg0Var, map, tg0Var);
            HashMap<String, String> d = pg0Var.d();
            String str = d.get("key");
            String str2 = d.get(WebChromeClient.KEY_ARG_CALLBACK);
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                d(tg0Var, pg0Var, wf0.a().b(str), 0, true);
                return true;
            }
            c(tg0Var, pg0Var, 202, false);
            return true;
        }
        return invokeLLLL.booleanValue;
    }
}
