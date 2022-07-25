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
import com.repackage.s93;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class l32 extends q32 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean l;
    public transient /* synthetic */ FieldHolder $fh;
    public final boolean k;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755580090, "Lcom/repackage/l32;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755580090, "Lcom/repackage/l32;");
                return;
            }
        }
        l = sg1.a;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public l32(bf3<Exception> bf3Var) {
        this(bf3Var, false);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bf3Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((bf3) objArr2[0], ((Boolean) objArr2[1]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // com.repackage.b84
    public Map<String, String> B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            Map<String, String> B = super.B();
            if (this.k && mc4.a) {
                if (B == null) {
                    B = new HashMap<>();
                }
                B.put("hb_type", "1");
                B.put("lastsynctime", String.valueOf(mc4.c));
                B.put("SWAN-TIMEOUT-SETTING", String.valueOf(mc4.b(60) * 1000));
            }
            return B;
        }
        return (Map) invokeV.objValue;
    }

    @Override // com.repackage.q32
    public int U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.q32
    public PMSDownloadType V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? PMSDownloadType.SWAN_APP_UPDATE_CORE : (PMSDownloadType) invokeV.objValue;
    }

    @Override // com.repackage.q32
    public String W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? a42.d() : (String) invokeV.objValue;
    }

    @Override // com.repackage.q32
    public String X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? a42.h() : (String) invokeV.objValue;
    }

    @Override // com.repackage.q32
    public bc3 b0(b94 b94Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, b94Var)) == null) {
            if (b94Var == null) {
                bc3 bc3Var = new bc3();
                bc3Var.k(14L);
                bc3Var.b(2908L);
                bc3Var.d("小程序Extension包 Extension null");
                return bc3Var;
            }
            ob2 ob2Var = new ob2();
            ob2Var.b = b94Var.i;
            ob2Var.a = b94Var.j;
            ob2Var.c = b94Var.a;
            ob2Var.d = b94Var.m;
            if (ra2.b(0, ob2Var) == null) {
                if (l) {
                    Log.i("SwanAppUpdateCore", "小程序Extension包解压成功");
                }
                boolean m = pj2.g0().m();
                if (l) {
                    Log.d("SwanAppUpdateCore", "onExtensionDownloadFinish: extension js 热应用实验开关 " + m);
                }
                if (m) {
                    if (l) {
                        Log.d("SwanAppUpdateCore", "onExtensionDownloadFinish: 命中 extension js 热应用实验");
                    }
                    ua2 f = ra2.f(0);
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
            bc3 bc3Var2 = new bc3();
            bc3Var2.k(14L);
            bc3Var2.b(2908L);
            bc3Var2.d("小程序Extension包更新失败");
            return bc3Var2;
        }
        return (bc3) invokeL.objValue;
    }

    @Override // com.repackage.q32
    public bc3 c0(d94 d94Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, d94Var)) == null) {
            if (l) {
                Log.d("SwanAppUpdateCore", "onFrameworkDownloadFinish framework = " + d94Var);
            }
            if (d94Var == null) {
                bc3 bc3Var = new bc3();
                bc3Var.k(13L);
                bc3Var.b(2907L);
                bc3Var.d("小程序Core包 Framework null");
                return bc3Var;
            }
            s93.b c = s93.c(d94Var, 0);
            ix1.k("SwanAppUpdateCore", "SwanCore RemoteCoreUpdateStatus: " + c);
            kg4.k(d94Var.a);
            if (c.c()) {
                long e = s93.e(0);
                if (e > 0) {
                    SwanJSVersionUpdateEvent.sendEvent(e);
                    SwanAppMessengerService.sendMessageWithDataToAllClient(114, e);
                    return null;
                }
                return null;
            }
            bc3 bc3Var2 = new bc3();
            bc3Var2.k(13L);
            bc3Var2.b(2907L);
            bc3Var2.d("小程序Core包更新失败");
            return bc3Var2;
        }
        return (bc3) invokeL.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l32(bf3<Exception> bf3Var, boolean z) {
        super(bf3Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bf3Var, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((bf3) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.k = z;
    }
}
