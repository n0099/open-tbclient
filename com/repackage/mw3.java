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
import com.repackage.r93;
/* loaded from: classes6.dex */
public class mw3 extends p32 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean k;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755484920, "Lcom/repackage/mw3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755484920, "Lcom/repackage/mw3;");
                return;
            }
        }
        k = rg1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public mw3(af3<Exception> af3Var) {
        super(af3Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {af3Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((af3) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // com.repackage.p32
    public int U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.p32
    public PMSDownloadType V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? PMSDownloadType.SWAN_GAME_UPDATE_CORE : (PMSDownloadType) invokeV.objValue;
    }

    @Override // com.repackage.p32
    public String W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? z32.f() : (String) invokeV.objValue;
    }

    @Override // com.repackage.p32
    public String X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? z32.e() : (String) invokeV.objValue;
    }

    @Override // com.repackage.p32
    public ac3 b0(a94 a94Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, a94Var)) == null) {
            if (a94Var == null) {
                ac3 ac3Var = new ac3();
                ac3Var.k(14L);
                ac3Var.b(2908L);
                ac3Var.d("小游戏Extension包 Extension null");
                return ac3Var;
            }
            nb2 nb2Var = new nb2();
            nb2Var.b = a94Var.i;
            nb2Var.a = a94Var.j;
            nb2Var.c = a94Var.a;
            nb2Var.d = a94Var.m;
            if (qa2.b(1, nb2Var) == null) {
                if (k) {
                    Log.i("SwanGameUpdateCore", "小游戏Extension包解压成功");
                    return null;
                }
                return null;
            }
            ac3 ac3Var2 = new ac3();
            ac3Var2.k(14L);
            ac3Var2.b(2908L);
            ac3Var2.d("小游戏Extension包更新失败");
            return ac3Var2;
        }
        return (ac3) invokeL.objValue;
    }

    @Override // com.repackage.p32
    public ac3 c0(c94 c94Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, c94Var)) == null) {
            if (k) {
                Log.d("SwanGameUpdateCore", "onFrameworkDownloadFinish framework = " + c94Var);
            }
            if (c94Var == null) {
                ac3 ac3Var = new ac3();
                ac3Var.k(13L);
                ac3Var.b(2907L);
                ac3Var.d("小游戏GameCore包 Framework null");
                return ac3Var;
            }
            r93.b c = r93.c(c94Var, 1);
            jg4.k(c94Var.a);
            if (c.c()) {
                if (k) {
                    Log.d("SwanGameUpdateCore", "小游戏GameCore解压成功");
                }
                long e = r93.e(1);
                if (e > 0) {
                    SwanAppMessengerService.sendMessageWithDataToAllClient(117, e);
                    return null;
                }
                return null;
            }
            ac3 ac3Var2 = new ac3();
            ac3Var2.k(13L);
            ac3Var2.b(2907L);
            ac3Var2.d("小游戏GameCore包更新失败");
            return ac3Var2;
        }
        return (ac3) invokeL.objValue;
    }
}
