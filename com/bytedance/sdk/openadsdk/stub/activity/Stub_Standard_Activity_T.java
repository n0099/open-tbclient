package com.bytedance.sdk.openadsdk.stub.activity;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.pangle.activity.GenerateProxyActivity;
import com.bytedance.sdk.openadsdk.TTAdConstant;
/* loaded from: classes2.dex */
public class Stub_Standard_Activity_T extends GenerateProxyActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public Stub_Standard_Activity_T() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.bytedance.pangle.activity.GenerateProxyActivity, com.bytedance.pangle.activity.b
    public String getPluginPkgName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? TTAdConstant.BUILT_IN_PLUGIN_NAME : (String) invokeV.objValue;
    }
}
