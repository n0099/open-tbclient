package com.repackage;

import android.app.Activity;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.searchbox.live.interfaces.service.yy.ThirdPartAliRechargeService;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class zj7 implements ThirdPartAliRechargeService {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public zj7() {
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

    @Override // com.baidu.searchbox.live.interfaces.service.yy.ThirdPartAliRechargeService
    public String aliRecharge(Activity activity, String str, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048576, this, activity, str, z)) == null) {
            kl4 kl4Var = new kl4();
            kl4Var.a = activity;
            kl4Var.b = str;
            kl4Var.c = z;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921539, String.class, kl4Var);
            return runTask == null ? "" : (String) runTask.getData();
        }
        return (String) invokeLLZ.objValue;
    }
}
