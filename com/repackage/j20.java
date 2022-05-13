package com.repackage;

import android.text.TextUtils;
import com.baidu.android.util.devices.DeviceUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class j20 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public boolean b;

    public j20() {
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

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (!this.b) {
                StringBuilder sb = new StringBuilder();
                if (DeviceUtils.isHarmonyOS(AppRuntime.getAppContext())) {
                    String harmonyVersion = DeviceUtils.getHarmonyVersion();
                    if (TextUtils.isEmpty(harmonyVersion)) {
                        harmonyVersion = "0.0";
                    }
                    sb.append("HMS");
                    sb.append("_");
                    sb.append(harmonyVersion);
                }
                this.a = sb.toString();
                this.b = true;
            }
            return this.a;
        }
        return (String) invokeV.objValue;
    }
}
