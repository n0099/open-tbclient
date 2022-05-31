package com.repackage;

import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.process.messaging.service.SwanAppMessengerService;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.r83;
/* loaded from: classes6.dex */
public class mv3 extends p22 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean k;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755485881, "Lcom/repackage/mv3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755485881, "Lcom/repackage/mv3;");
                return;
            }
        }
        k = rf1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public mv3(ae3<Exception> ae3Var) {
        super(ae3Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ae3Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((ae3) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // com.repackage.p22
    public int V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.p22
    public PMSDownloadType W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? PMSDownloadType.SWAN_GAME_UPDATE_CORE : (PMSDownloadType) invokeV.objValue;
    }

    @Override // com.repackage.p22
    public String X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? z22.f() : (String) invokeV.objValue;
    }

    @Override // com.repackage.p22
    public String Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? z22.e() : (String) invokeV.objValue;
    }

    @Override // com.repackage.p22
    public ab3 c0(a84 a84Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, a84Var)) == null) {
            if (a84Var == null) {
                ab3 ab3Var = new ab3();
                ab3Var.k(14L);
                ab3Var.b(2908L);
                ab3Var.d("小游戏Extension包 Extension null");
                return ab3Var;
            }
            na2 na2Var = new na2();
            na2Var.b = a84Var.i;
            na2Var.a = a84Var.j;
            na2Var.c = a84Var.a;
            na2Var.d = a84Var.m;
            if (q92.b(1, na2Var) == null) {
                if (k) {
                    Log.i("SwanGameUpdateCore", "小游戏Extension包解压成功");
                    return null;
                }
                return null;
            }
            ab3 ab3Var2 = new ab3();
            ab3Var2.k(14L);
            ab3Var2.b(2908L);
            ab3Var2.d("小游戏Extension包更新失败");
            return ab3Var2;
        }
        return (ab3) invokeL.objValue;
    }

    @Override // com.repackage.p22
    public ab3 d0(c84 c84Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, c84Var)) == null) {
            if (k) {
                Log.d("SwanGameUpdateCore", "onFrameworkDownloadFinish framework = " + c84Var);
            }
            if (c84Var == null) {
                ab3 ab3Var = new ab3();
                ab3Var.k(13L);
                ab3Var.b(2907L);
                ab3Var.d("小游戏GameCore包 Framework null");
                return ab3Var;
            }
            r83.b c = r83.c(c84Var, 1);
            kf4.k(c84Var.a);
            if (c.c()) {
                if (k) {
                    Log.d("SwanGameUpdateCore", "小游戏GameCore解压成功");
                }
                long e = r83.e(1);
                if (e > 0) {
                    SwanAppMessengerService.sendMessageWithDataToAllClient(117, e);
                    return null;
                }
                return null;
            }
            ab3 ab3Var2 = new ab3();
            ab3Var2.k(13L);
            ab3Var2.b(2907L);
            ab3Var2.d("小游戏GameCore包更新失败");
            return ab3Var2;
        }
        return (ab3) invokeL.objValue;
    }
}
