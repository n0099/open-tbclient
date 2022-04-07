package com.repackage;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
/* loaded from: classes5.dex */
public class d62 extends e62 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public static final String c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755815535, "Lcom/repackage/d62;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755815535, "Lcom/repackage/d62;");
                return;
            }
        }
        b = tg1.a;
        c = "swan_preset" + File.separator + "preset_list.json";
    }

    public d62() {
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

    @Override // com.repackage.e62
    public boolean e(f62 f62Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, f62Var)) == null) {
            if (f62Var == null) {
                return false;
            }
            Context appContext = AppRuntime.getAppContext();
            String str = "swan_preset" + File.separator + f62Var.g + File.separator + f62Var.q;
            try {
                File j = j(f62Var.h, f62Var.g, f62Var.i);
                if (j == null) {
                    if (b) {
                        Log.e("AssetPresetController", "获取解压路径失败");
                    }
                    return false;
                }
                return n(new BufferedInputStream(appContext.getAssets().open(str)), j);
            } catch (IOException e) {
                if (b) {
                    e.printStackTrace();
                }
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    @Override // com.repackage.e62
    public String f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            Application c2 = qj2.c();
            return uc3.b(c2, "swan_preset" + File.separator + str + File.separator + "app_info.json");
        }
        return (String) invokeL.objValue;
    }

    @Override // com.repackage.e62
    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? uc3.b(qj2.c(), c) : (String) invokeV.objValue;
    }
}
