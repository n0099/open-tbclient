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
import com.repackage.t93;
/* loaded from: classes6.dex */
public class ow3 extends r32 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean k;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755425338, "Lcom/repackage/ow3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755425338, "Lcom/repackage/ow3;");
                return;
            }
        }
        k = tg1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ow3(cf3<Exception> cf3Var) {
        super(cf3Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cf3Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((cf3) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // com.repackage.r32
    public int V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.r32
    public PMSDownloadType W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? PMSDownloadType.SWAN_GAME_UPDATE_CORE : (PMSDownloadType) invokeV.objValue;
    }

    @Override // com.repackage.r32
    public String X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? b42.f() : (String) invokeV.objValue;
    }

    @Override // com.repackage.r32
    public String Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? b42.e() : (String) invokeV.objValue;
    }

    @Override // com.repackage.r32
    public cc3 c0(d94 d94Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, d94Var)) == null) {
            if (d94Var == null) {
                cc3 cc3Var = new cc3();
                cc3Var.k(14L);
                cc3Var.b(2908L);
                cc3Var.d("小游戏Extension包 Extension null");
                return cc3Var;
            }
            pb2 pb2Var = new pb2();
            pb2Var.b = d94Var.i;
            pb2Var.a = d94Var.j;
            pb2Var.c = d94Var.a;
            pb2Var.d = d94Var.m;
            if (sa2.b(1, pb2Var) == null) {
                if (k) {
                    Log.i("SwanGameUpdateCore", "小游戏Extension包解压成功");
                    return null;
                }
                return null;
            }
            cc3 cc3Var2 = new cc3();
            cc3Var2.k(14L);
            cc3Var2.b(2908L);
            cc3Var2.d("小游戏Extension包更新失败");
            return cc3Var2;
        }
        return (cc3) invokeL.objValue;
    }

    @Override // com.repackage.r32
    public cc3 d0(f94 f94Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, f94Var)) == null) {
            if (k) {
                Log.d("SwanGameUpdateCore", "onFrameworkDownloadFinish framework = " + f94Var);
            }
            if (f94Var == null) {
                cc3 cc3Var = new cc3();
                cc3Var.k(13L);
                cc3Var.b(2907L);
                cc3Var.d("小游戏GameCore包 Framework null");
                return cc3Var;
            }
            t93.b c = t93.c(f94Var, 1);
            ng4.k(f94Var.a);
            if (c.c()) {
                if (k) {
                    Log.d("SwanGameUpdateCore", "小游戏GameCore解压成功");
                }
                long e = t93.e(1);
                if (e > 0) {
                    SwanAppMessengerService.sendMessageWithDataToAllClient(117, e);
                    return null;
                }
                return null;
            }
            cc3 cc3Var2 = new cc3();
            cc3Var2.k(13L);
            cc3Var2.b(2907L);
            cc3Var2.d("小游戏GameCore包更新失败");
            return cc3Var2;
        }
        return (cc3) invokeL.objValue;
    }
}
