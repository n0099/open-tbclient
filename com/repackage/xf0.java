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
public class xf0 extends ng0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public xf0() {
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

    @Override // com.repackage.ng0
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "loadCache" : (String) invokeV.objValue;
    }

    @Override // com.repackage.ng0
    public boolean b(@NonNull Context context, @NonNull rg0 rg0Var, @Nullable Map<String, Object> map, @Nullable vg0 vg0Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, rg0Var, map, vg0Var)) == null) {
            super.b(context, rg0Var, map, vg0Var);
            HashMap<String, String> d = rg0Var.d();
            String str = d.get("key");
            String str2 = d.get(WebChromeClient.KEY_ARG_CALLBACK);
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                d(vg0Var, rg0Var, yf0.a().b(str), 0, true);
                return true;
            }
            c(vg0Var, rg0Var, 202, false);
            return true;
        }
        return invokeLLLL.booleanValue;
    }
}
