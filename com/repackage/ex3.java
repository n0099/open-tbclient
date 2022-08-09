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
import com.repackage.ja3;
/* loaded from: classes6.dex */
public class ex3 extends h42 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean k;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755722287, "Lcom/repackage/ex3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755722287, "Lcom/repackage/ex3;");
                return;
            }
        }
        k = jh1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ex3(sf3<Exception> sf3Var) {
        super(sf3Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {sf3Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((sf3) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // com.repackage.h42
    public int U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.h42
    public PMSDownloadType V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? PMSDownloadType.SWAN_GAME_UPDATE_CORE : (PMSDownloadType) invokeV.objValue;
    }

    @Override // com.repackage.h42
    public String W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? r42.f() : (String) invokeV.objValue;
    }

    @Override // com.repackage.h42
    public String X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? r42.e() : (String) invokeV.objValue;
    }

    @Override // com.repackage.h42
    public sc3 b0(s94 s94Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, s94Var)) == null) {
            if (s94Var == null) {
                sc3 sc3Var = new sc3();
                sc3Var.k(14L);
                sc3Var.b(2908L);
                sc3Var.d("小游戏Extension包 Extension null");
                return sc3Var;
            }
            fc2 fc2Var = new fc2();
            fc2Var.b = s94Var.i;
            fc2Var.a = s94Var.j;
            fc2Var.c = s94Var.a;
            fc2Var.d = s94Var.m;
            if (ib2.b(1, fc2Var) == null) {
                if (k) {
                    Log.i("SwanGameUpdateCore", "小游戏Extension包解压成功");
                    return null;
                }
                return null;
            }
            sc3 sc3Var2 = new sc3();
            sc3Var2.k(14L);
            sc3Var2.b(2908L);
            sc3Var2.d("小游戏Extension包更新失败");
            return sc3Var2;
        }
        return (sc3) invokeL.objValue;
    }

    @Override // com.repackage.h42
    public sc3 c0(u94 u94Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, u94Var)) == null) {
            if (k) {
                Log.d("SwanGameUpdateCore", "onFrameworkDownloadFinish framework = " + u94Var);
            }
            if (u94Var == null) {
                sc3 sc3Var = new sc3();
                sc3Var.k(13L);
                sc3Var.b(2907L);
                sc3Var.d("小游戏GameCore包 Framework null");
                return sc3Var;
            }
            ja3.b c = ja3.c(u94Var, 1);
            bh4.k(u94Var.a);
            if (c.c()) {
                if (k) {
                    Log.d("SwanGameUpdateCore", "小游戏GameCore解压成功");
                }
                long e = ja3.e(1);
                if (e > 0) {
                    SwanAppMessengerService.sendMessageWithDataToAllClient(117, e);
                    return null;
                }
                return null;
            }
            sc3 sc3Var2 = new sc3();
            sc3Var2.k(13L);
            sc3Var2.b(2907L);
            sc3Var2.d("小游戏GameCore包更新失败");
            return sc3Var2;
        }
        return (sc3) invokeL.objValue;
    }
}
