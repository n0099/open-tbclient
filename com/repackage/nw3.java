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
import com.repackage.s93;
/* loaded from: classes6.dex */
public class nw3 extends q32 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean k;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755455129, "Lcom/repackage/nw3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755455129, "Lcom/repackage/nw3;");
                return;
            }
        }
        k = sg1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public nw3(bf3<Exception> bf3Var) {
        super(bf3Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bf3Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((bf3) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // com.repackage.q32
    public int U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.q32
    public PMSDownloadType V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? PMSDownloadType.SWAN_GAME_UPDATE_CORE : (PMSDownloadType) invokeV.objValue;
    }

    @Override // com.repackage.q32
    public String W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? a42.f() : (String) invokeV.objValue;
    }

    @Override // com.repackage.q32
    public String X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? a42.e() : (String) invokeV.objValue;
    }

    @Override // com.repackage.q32
    public bc3 b0(b94 b94Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, b94Var)) == null) {
            if (b94Var == null) {
                bc3 bc3Var = new bc3();
                bc3Var.k(14L);
                bc3Var.b(2908L);
                bc3Var.d("小游戏Extension包 Extension null");
                return bc3Var;
            }
            ob2 ob2Var = new ob2();
            ob2Var.b = b94Var.i;
            ob2Var.a = b94Var.j;
            ob2Var.c = b94Var.a;
            ob2Var.d = b94Var.m;
            if (ra2.b(1, ob2Var) == null) {
                if (k) {
                    Log.i("SwanGameUpdateCore", "小游戏Extension包解压成功");
                    return null;
                }
                return null;
            }
            bc3 bc3Var2 = new bc3();
            bc3Var2.k(14L);
            bc3Var2.b(2908L);
            bc3Var2.d("小游戏Extension包更新失败");
            return bc3Var2;
        }
        return (bc3) invokeL.objValue;
    }

    @Override // com.repackage.q32
    public bc3 c0(d94 d94Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, d94Var)) == null) {
            if (k) {
                Log.d("SwanGameUpdateCore", "onFrameworkDownloadFinish framework = " + d94Var);
            }
            if (d94Var == null) {
                bc3 bc3Var = new bc3();
                bc3Var.k(13L);
                bc3Var.b(2907L);
                bc3Var.d("小游戏GameCore包 Framework null");
                return bc3Var;
            }
            s93.b c = s93.c(d94Var, 1);
            kg4.k(d94Var.a);
            if (c.c()) {
                if (k) {
                    Log.d("SwanGameUpdateCore", "小游戏GameCore解压成功");
                }
                long e = s93.e(1);
                if (e > 0) {
                    SwanAppMessengerService.sendMessageWithDataToAllClient(117, e);
                    return null;
                }
                return null;
            }
            bc3 bc3Var2 = new bc3();
            bc3Var2.k(13L);
            bc3Var2.b(2907L);
            bc3Var2.d("小游戏GameCore包更新失败");
            return bc3Var2;
        }
        return (bc3) invokeL.objValue;
    }
}
