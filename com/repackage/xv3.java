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
import com.repackage.c93;
/* loaded from: classes7.dex */
public class xv3 extends a32 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean k;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755158180, "Lcom/repackage/xv3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755158180, "Lcom/repackage/xv3;");
                return;
            }
        }
        k = cg1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xv3(le3<Exception> le3Var) {
        super(le3Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {le3Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((le3) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // com.repackage.a32
    public int U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.a32
    public PMSDownloadType V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? PMSDownloadType.SWAN_GAME_UPDATE_CORE : (PMSDownloadType) invokeV.objValue;
    }

    @Override // com.repackage.a32
    public String W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? k32.f() : (String) invokeV.objValue;
    }

    @Override // com.repackage.a32
    public String X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? k32.e() : (String) invokeV.objValue;
    }

    @Override // com.repackage.a32
    public lb3 b0(l84 l84Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, l84Var)) == null) {
            if (l84Var == null) {
                lb3 lb3Var = new lb3();
                lb3Var.k(14L);
                lb3Var.b(2908L);
                lb3Var.d("小游戏Extension包 Extension null");
                return lb3Var;
            }
            ya2 ya2Var = new ya2();
            ya2Var.b = l84Var.i;
            ya2Var.a = l84Var.j;
            ya2Var.c = l84Var.a;
            ya2Var.d = l84Var.m;
            if (ba2.b(1, ya2Var) == null) {
                if (k) {
                    Log.i("SwanGameUpdateCore", "小游戏Extension包解压成功");
                    return null;
                }
                return null;
            }
            lb3 lb3Var2 = new lb3();
            lb3Var2.k(14L);
            lb3Var2.b(2908L);
            lb3Var2.d("小游戏Extension包更新失败");
            return lb3Var2;
        }
        return (lb3) invokeL.objValue;
    }

    @Override // com.repackage.a32
    public lb3 c0(n84 n84Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, n84Var)) == null) {
            if (k) {
                Log.d("SwanGameUpdateCore", "onFrameworkDownloadFinish framework = " + n84Var);
            }
            if (n84Var == null) {
                lb3 lb3Var = new lb3();
                lb3Var.k(13L);
                lb3Var.b(2907L);
                lb3Var.d("小游戏GameCore包 Framework null");
                return lb3Var;
            }
            c93.b c = c93.c(n84Var, 1);
            uf4.k(n84Var.a);
            if (c.c()) {
                if (k) {
                    Log.d("SwanGameUpdateCore", "小游戏GameCore解压成功");
                }
                long e = c93.e(1);
                if (e > 0) {
                    SwanAppMessengerService.sendMessageWithDataToAllClient(117, e);
                    return null;
                }
                return null;
            }
            lb3 lb3Var2 = new lb3();
            lb3Var2.k(13L);
            lb3Var2.b(2907L);
            lb3Var2.d("小游戏GameCore包更新失败");
            return lb3Var2;
        }
        return (lb3) invokeL.objValue;
    }
}
