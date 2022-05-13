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
import com.repackage.ea3;
/* loaded from: classes7.dex */
public class zw3 extends c42 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean k;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755097637, "Lcom/repackage/zw3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755097637, "Lcom/repackage/zw3;");
                return;
            }
        }
        k = eh1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zw3(nf3<Exception> nf3Var) {
        super(nf3Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {nf3Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((nf3) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // com.repackage.c42
    public int V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.c42
    public PMSDownloadType W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? PMSDownloadType.SWAN_GAME_UPDATE_CORE : (PMSDownloadType) invokeV.objValue;
    }

    @Override // com.repackage.c42
    public String X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? m42.f() : (String) invokeV.objValue;
    }

    @Override // com.repackage.c42
    public String Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? m42.e() : (String) invokeV.objValue;
    }

    @Override // com.repackage.c42
    public nc3 c0(n94 n94Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, n94Var)) == null) {
            if (n94Var == null) {
                nc3 nc3Var = new nc3();
                nc3Var.k(14L);
                nc3Var.b(2908L);
                nc3Var.d("小游戏Extension包 Extension null");
                return nc3Var;
            }
            ac2 ac2Var = new ac2();
            ac2Var.b = n94Var.i;
            ac2Var.a = n94Var.j;
            ac2Var.c = n94Var.a;
            ac2Var.d = n94Var.m;
            if (db2.b(1, ac2Var) == null) {
                if (k) {
                    Log.i("SwanGameUpdateCore", "小游戏Extension包解压成功");
                    return null;
                }
                return null;
            }
            nc3 nc3Var2 = new nc3();
            nc3Var2.k(14L);
            nc3Var2.b(2908L);
            nc3Var2.d("小游戏Extension包更新失败");
            return nc3Var2;
        }
        return (nc3) invokeL.objValue;
    }

    @Override // com.repackage.c42
    public nc3 d0(p94 p94Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, p94Var)) == null) {
            if (k) {
                Log.d("SwanGameUpdateCore", "onFrameworkDownloadFinish framework = " + p94Var);
            }
            if (p94Var == null) {
                nc3 nc3Var = new nc3();
                nc3Var.k(13L);
                nc3Var.b(2907L);
                nc3Var.d("小游戏GameCore包 Framework null");
                return nc3Var;
            }
            ea3.b c = ea3.c(p94Var, 1);
            xg4.k(p94Var.a);
            if (c.c()) {
                if (k) {
                    Log.d("SwanGameUpdateCore", "小游戏GameCore解压成功");
                }
                long e = ea3.e(1);
                if (e > 0) {
                    SwanAppMessengerService.sendMessageWithDataToAllClient(117, e);
                    return null;
                }
                return null;
            }
            nc3 nc3Var2 = new nc3();
            nc3Var2.k(13L);
            nc3Var2.b(2907L);
            nc3Var2.d("小游戏GameCore包更新失败");
            return nc3Var2;
        }
        return (nc3) invokeL.objValue;
    }
}
