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
import com.repackage.ea3;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes7.dex */
public class x32 extends c42 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean l;
    public transient /* synthetic */ FieldHolder $fh;
    public final boolean k;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755222598, "Lcom/repackage/x32;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755222598, "Lcom/repackage/x32;");
                return;
            }
        }
        l = eh1.a;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public x32(nf3<Exception> nf3Var) {
        this(nf3Var, false);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {nf3Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((nf3) objArr2[0], ((Boolean) objArr2[1]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // com.repackage.n84
    public Map<String, String> C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            Map<String, String> C = super.C();
            if (this.k && yc4.a) {
                if (C == null) {
                    C = new HashMap<>();
                }
                C.put("hb_type", "1");
                C.put("lastsynctime", String.valueOf(yc4.c));
                C.put("SWAN-TIMEOUT-SETTING", String.valueOf(yc4.b(60) * 1000));
            }
            return C;
        }
        return (Map) invokeV.objValue;
    }

    @Override // com.repackage.c42
    public int V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.c42
    public PMSDownloadType W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? PMSDownloadType.SWAN_APP_UPDATE_CORE : (PMSDownloadType) invokeV.objValue;
    }

    @Override // com.repackage.c42
    public String X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? m42.d() : (String) invokeV.objValue;
    }

    @Override // com.repackage.c42
    public String Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? m42.h() : (String) invokeV.objValue;
    }

    @Override // com.repackage.c42
    public nc3 c0(n94 n94Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, n94Var)) == null) {
            if (n94Var == null) {
                nc3 nc3Var = new nc3();
                nc3Var.k(14L);
                nc3Var.b(2908L);
                nc3Var.d("小程序Extension包 Extension null");
                return nc3Var;
            }
            ac2 ac2Var = new ac2();
            ac2Var.b = n94Var.i;
            ac2Var.a = n94Var.j;
            ac2Var.c = n94Var.a;
            ac2Var.d = n94Var.m;
            if (db2.b(0, ac2Var) == null) {
                if (l) {
                    Log.i("SwanAppUpdateCore", "小程序Extension包解压成功");
                }
                boolean m = bk2.g0().m();
                if (l) {
                    Log.d("SwanAppUpdateCore", "onExtensionDownloadFinish: extension js 热应用实验开关 " + m);
                }
                if (m) {
                    if (l) {
                        Log.d("SwanAppUpdateCore", "onExtensionDownloadFinish: 命中 extension js 热应用实验");
                    }
                    gb2 f = db2.f(0);
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
            nc3 nc3Var2 = new nc3();
            nc3Var2.k(14L);
            nc3Var2.b(2908L);
            nc3Var2.d("小程序Extension包更新失败");
            return nc3Var2;
        }
        return (nc3) invokeL.objValue;
    }

    @Override // com.repackage.c42
    public nc3 d0(p94 p94Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, p94Var)) == null) {
            if (l) {
                Log.d("SwanAppUpdateCore", "onFrameworkDownloadFinish framework = " + p94Var);
            }
            if (p94Var == null) {
                nc3 nc3Var = new nc3();
                nc3Var.k(13L);
                nc3Var.b(2907L);
                nc3Var.d("小程序Core包 Framework null");
                return nc3Var;
            }
            ea3.b c = ea3.c(p94Var, 0);
            ux1.k("SwanAppUpdateCore", "SwanCore RemoteCoreUpdateStatus: " + c);
            xg4.k(p94Var.a);
            if (c.c()) {
                long e = ea3.e(0);
                if (e > 0) {
                    SwanJSVersionUpdateEvent.sendEvent(e);
                    SwanAppMessengerService.sendMessageWithDataToAllClient(114, e);
                    return null;
                }
                return null;
            }
            nc3 nc3Var2 = new nc3();
            nc3Var2.k(13L);
            nc3Var2.b(2907L);
            nc3Var2.d("小程序Core包更新失败");
            return nc3Var2;
        }
        return (nc3) invokeL.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x32(nf3<Exception> nf3Var, boolean z) {
        super(nf3Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {nf3Var, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((nf3) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.k = z;
    }
}
