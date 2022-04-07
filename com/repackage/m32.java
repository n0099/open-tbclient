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
import com.repackage.t93;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class m32 extends r32 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean l;
    public transient /* synthetic */ FieldHolder $fh;
    public final boolean k;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755550299, "Lcom/repackage/m32;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755550299, "Lcom/repackage/m32;");
                return;
            }
        }
        l = tg1.a;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public m32(cf3<Exception> cf3Var) {
        this(cf3Var, false);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cf3Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((cf3) objArr2[0], ((Boolean) objArr2[1]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // com.repackage.d84
    public Map<String, String> C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            Map<String, String> C = super.C();
            if (this.k && oc4.a) {
                if (C == null) {
                    C = new HashMap<>();
                }
                C.put("hb_type", "1");
                C.put("lastsynctime", String.valueOf(oc4.c));
                C.put("SWAN-TIMEOUT-SETTING", String.valueOf(oc4.b(60) * 1000));
            }
            return C;
        }
        return (Map) invokeV.objValue;
    }

    @Override // com.repackage.r32
    public int V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.r32
    public PMSDownloadType W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? PMSDownloadType.SWAN_APP_UPDATE_CORE : (PMSDownloadType) invokeV.objValue;
    }

    @Override // com.repackage.r32
    public String X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? b42.d() : (String) invokeV.objValue;
    }

    @Override // com.repackage.r32
    public String Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? b42.h() : (String) invokeV.objValue;
    }

    @Override // com.repackage.r32
    public cc3 c0(d94 d94Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, d94Var)) == null) {
            if (d94Var == null) {
                cc3 cc3Var = new cc3();
                cc3Var.k(14L);
                cc3Var.b(2908L);
                cc3Var.d("小程序Extension包 Extension null");
                return cc3Var;
            }
            pb2 pb2Var = new pb2();
            pb2Var.b = d94Var.i;
            pb2Var.a = d94Var.j;
            pb2Var.c = d94Var.a;
            pb2Var.d = d94Var.m;
            if (sa2.b(0, pb2Var) == null) {
                if (l) {
                    Log.i("SwanAppUpdateCore", "小程序Extension包解压成功");
                }
                boolean m = qj2.g0().m();
                if (l) {
                    Log.d("SwanAppUpdateCore", "onExtensionDownloadFinish: extension js 热应用实验开关 " + m);
                }
                if (m) {
                    if (l) {
                        Log.d("SwanAppUpdateCore", "onExtensionDownloadFinish: 命中 extension js 热应用实验");
                    }
                    va2 f = sa2.f(0);
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
            cc3 cc3Var2 = new cc3();
            cc3Var2.k(14L);
            cc3Var2.b(2908L);
            cc3Var2.d("小程序Extension包更新失败");
            return cc3Var2;
        }
        return (cc3) invokeL.objValue;
    }

    @Override // com.repackage.r32
    public cc3 d0(f94 f94Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, f94Var)) == null) {
            if (l) {
                Log.d("SwanAppUpdateCore", "onFrameworkDownloadFinish framework = " + f94Var);
            }
            if (f94Var == null) {
                cc3 cc3Var = new cc3();
                cc3Var.k(13L);
                cc3Var.b(2907L);
                cc3Var.d("小程序Core包 Framework null");
                return cc3Var;
            }
            t93.b c = t93.c(f94Var, 0);
            jx1.k("SwanAppUpdateCore", "SwanCore RemoteCoreUpdateStatus: " + c);
            ng4.k(f94Var.a);
            if (c.c()) {
                long e = t93.e(0);
                if (e > 0) {
                    SwanJSVersionUpdateEvent.sendEvent(e);
                    SwanAppMessengerService.sendMessageWithDataToAllClient(114, e);
                    return null;
                }
                return null;
            }
            cc3 cc3Var2 = new cc3();
            cc3Var2.k(13L);
            cc3Var2.b(2907L);
            cc3Var2.d("小程序Core包更新失败");
            return cc3Var2;
        }
        return (cc3) invokeL.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m32(cf3<Exception> cf3Var, boolean z) {
        super(cf3Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cf3Var, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((cf3) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.k = z;
    }
}
