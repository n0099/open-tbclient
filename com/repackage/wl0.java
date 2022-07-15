package com.repackage;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.max.ImmersiveVideoDetailActivity;
import com.baidu.pyramid.annotation.Service;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunAdSdk;
import java.util.HashMap;
import java.util.Map;
@Service
/* loaded from: classes7.dex */
public class wl0 extends rg0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public wl0() {
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

    @Override // com.repackage.rg0
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? FunAdSdk.PLATFORM_MAX : (String) invokeV.objValue;
    }

    @Override // com.repackage.rg0
    public boolean b(@NonNull Context context, @NonNull vg0 vg0Var, @Nullable Map<String, Object> map, @Nullable zg0 zg0Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, vg0Var, map, zg0Var)) == null) {
            super.b(context, vg0Var, map, zg0Var);
            HashMap<String, String> d = vg0Var.d();
            Intent intent = new Intent(context, ImmersiveVideoDetailActivity.class);
            intent.putExtra("map", d);
            return k01.c(context, intent);
        }
        return invokeLLLL.booleanValue;
    }
}
