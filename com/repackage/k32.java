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
import com.repackage.r93;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class k32 extends p32 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean l;
    public transient /* synthetic */ FieldHolder $fh;
    public final boolean k;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755609881, "Lcom/repackage/k32;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755609881, "Lcom/repackage/k32;");
                return;
            }
        }
        l = rg1.a;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public k32(af3<Exception> af3Var) {
        this(af3Var, false);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {af3Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((af3) objArr2[0], ((Boolean) objArr2[1]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // com.repackage.a84
    public Map<String, String> B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            Map<String, String> B = super.B();
            if (this.k && lc4.a) {
                if (B == null) {
                    B = new HashMap<>();
                }
                B.put("hb_type", "1");
                B.put("lastsynctime", String.valueOf(lc4.c));
                B.put("SWAN-TIMEOUT-SETTING", String.valueOf(lc4.b(60) * 1000));
            }
            return B;
        }
        return (Map) invokeV.objValue;
    }

    @Override // com.repackage.p32
    public int U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.p32
    public PMSDownloadType V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? PMSDownloadType.SWAN_APP_UPDATE_CORE : (PMSDownloadType) invokeV.objValue;
    }

    @Override // com.repackage.p32
    public String W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? z32.d() : (String) invokeV.objValue;
    }

    @Override // com.repackage.p32
    public String X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? z32.h() : (String) invokeV.objValue;
    }

    @Override // com.repackage.p32
    public ac3 b0(a94 a94Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, a94Var)) == null) {
            if (a94Var == null) {
                ac3 ac3Var = new ac3();
                ac3Var.k(14L);
                ac3Var.b(2908L);
                ac3Var.d("小程序Extension包 Extension null");
                return ac3Var;
            }
            nb2 nb2Var = new nb2();
            nb2Var.b = a94Var.i;
            nb2Var.a = a94Var.j;
            nb2Var.c = a94Var.a;
            nb2Var.d = a94Var.m;
            if (qa2.b(0, nb2Var) == null) {
                if (l) {
                    Log.i("SwanAppUpdateCore", "小程序Extension包解压成功");
                }
                boolean m = oj2.g0().m();
                if (l) {
                    Log.d("SwanAppUpdateCore", "onExtensionDownloadFinish: extension js 热应用实验开关 " + m);
                }
                if (m) {
                    if (l) {
                        Log.d("SwanAppUpdateCore", "onExtensionDownloadFinish: 命中 extension js 热应用实验");
                    }
                    ta2 f = qa2.f(0);
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
            ac3 ac3Var2 = new ac3();
            ac3Var2.k(14L);
            ac3Var2.b(2908L);
            ac3Var2.d("小程序Extension包更新失败");
            return ac3Var2;
        }
        return (ac3) invokeL.objValue;
    }

    @Override // com.repackage.p32
    public ac3 c0(c94 c94Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, c94Var)) == null) {
            if (l) {
                Log.d("SwanAppUpdateCore", "onFrameworkDownloadFinish framework = " + c94Var);
            }
            if (c94Var == null) {
                ac3 ac3Var = new ac3();
                ac3Var.k(13L);
                ac3Var.b(2907L);
                ac3Var.d("小程序Core包 Framework null");
                return ac3Var;
            }
            r93.b c = r93.c(c94Var, 0);
            hx1.k("SwanAppUpdateCore", "SwanCore RemoteCoreUpdateStatus: " + c);
            jg4.k(c94Var.a);
            if (c.c()) {
                long e = r93.e(0);
                if (e > 0) {
                    SwanJSVersionUpdateEvent.sendEvent(e);
                    SwanAppMessengerService.sendMessageWithDataToAllClient(114, e);
                    return null;
                }
                return null;
            }
            ac3 ac3Var2 = new ac3();
            ac3Var2.k(13L);
            ac3Var2.b(2907L);
            ac3Var2.d("小程序Core包更新失败");
            return ac3Var2;
        }
        return (ac3) invokeL.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k32(af3<Exception> af3Var, boolean z) {
        super(af3Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {af3Var, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((af3) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.k = z;
    }
}
