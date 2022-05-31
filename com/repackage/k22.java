package com.repackage;

import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.event.SwanJSVersionUpdateEvent;
import com.baidu.swan.apps.process.messaging.service.SwanAppMessengerService;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.r83;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class k22 extends p22 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean l;
    public transient /* synthetic */ FieldHolder $fh;
    public final boolean k;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755610842, "Lcom/repackage/k22;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755610842, "Lcom/repackage/k22;");
                return;
            }
        }
        l = rf1.a;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public k22(ae3<Exception> ae3Var) {
        this(ae3Var, false);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ae3Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((ae3) objArr2[0], ((Boolean) objArr2[1]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // com.repackage.a74
    public Map<String, String> C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            Map<String, String> C = super.C();
            if (this.k && lb4.a) {
                if (C == null) {
                    C = new HashMap<>();
                }
                C.put("hb_type", "1");
                C.put("lastsynctime", String.valueOf(lb4.c));
                C.put("SWAN-TIMEOUT-SETTING", String.valueOf(lb4.b(60) * 1000));
            }
            return C;
        }
        return (Map) invokeV.objValue;
    }

    @Override // com.repackage.p22
    public int V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.p22
    public PMSDownloadType W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? PMSDownloadType.SWAN_APP_UPDATE_CORE : (PMSDownloadType) invokeV.objValue;
    }

    @Override // com.repackage.p22
    public String X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? z22.d() : (String) invokeV.objValue;
    }

    @Override // com.repackage.p22
    public String Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? z22.h() : (String) invokeV.objValue;
    }

    @Override // com.repackage.p22
    public ab3 c0(a84 a84Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, a84Var)) == null) {
            if (a84Var == null) {
                ab3 ab3Var = new ab3();
                ab3Var.k(14L);
                ab3Var.b(2908L);
                ab3Var.d("小程序Extension包 Extension null");
                return ab3Var;
            }
            na2 na2Var = new na2();
            na2Var.b = a84Var.i;
            na2Var.a = a84Var.j;
            na2Var.c = a84Var.a;
            na2Var.d = a84Var.m;
            if (q92.b(0, na2Var) == null) {
                if (l) {
                    Log.i("SwanAppUpdateCore", "小程序Extension包解压成功");
                }
                boolean m = oi2.g0().m();
                if (l) {
                    Log.d("SwanAppUpdateCore", "onExtensionDownloadFinish: extension js 热应用实验开关 " + m);
                }
                if (m) {
                    if (l) {
                        Log.d("SwanAppUpdateCore", "onExtensionDownloadFinish: 命中 extension js 热应用实验");
                    }
                    t92 f = q92.f(0);
                    if (f == null) {
                        return null;
                    }
                    long g = f.f().g();
                    if (g > 0) {
                        if (l) {
                            Log.d("SwanAppUpdateCore", "发送extension core更新事件");
                        }
                        SwanAppMessengerService.sendMessageWithDataToAllClient(121, g);
                    }
                }
                return null;
            }
            ab3 ab3Var2 = new ab3();
            ab3Var2.k(14L);
            ab3Var2.b(2908L);
            ab3Var2.d("小程序Extension包更新失败");
            return ab3Var2;
        }
        return (ab3) invokeL.objValue;
    }

    @Override // com.repackage.p22
    public ab3 d0(c84 c84Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, c84Var)) == null) {
            if (l) {
                Log.d("SwanAppUpdateCore", "onFrameworkDownloadFinish framework = " + c84Var);
            }
            if (c84Var == null) {
                ab3 ab3Var = new ab3();
                ab3Var.k(13L);
                ab3Var.b(2907L);
                ab3Var.d("小程序Core包 Framework null");
                return ab3Var;
            }
            r83.b c = r83.c(c84Var, 0);
            hw1.k("SwanAppUpdateCore", "SwanCore RemoteCoreUpdateStatus: " + c);
            kf4.k(c84Var.a);
            if (c.c()) {
                long e = r83.e(0);
                if (e > 0) {
                    SwanJSVersionUpdateEvent.sendEvent(e);
                    SwanAppMessengerService.sendMessageWithDataToAllClient(114, e);
                    return null;
                }
                return null;
            }
            ab3 ab3Var2 = new ab3();
            ab3Var2.k(13L);
            ab3Var2.b(2907L);
            ab3Var2.d("小程序Core包更新失败");
            return ab3Var2;
        }
        return (ab3) invokeL.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k22(ae3<Exception> ae3Var, boolean z) {
        super(ae3Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ae3Var, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((ae3) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.k = z;
    }
}
