package d.a.o0.a.h0.m;

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
import d.a.o0.a.m2.f.a;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes7.dex */
public class i extends l {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean p;
    public transient /* synthetic */ FieldHolder $fh;
    public final boolean o;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(447430756, "Ld/a/o0/a/h0/m/i;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(447430756, "Ld/a/o0/a/h0/m/i;");
                return;
            }
        }
        p = d.a.o0.a.k.f46335a;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public i(d.a.o0.a.v2.e1.b<Exception> bVar) {
        this(bVar, false);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((d.a.o0.a.v2.e1.b) objArr2[0], ((Boolean) objArr2[1]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // d.a.o0.n.f.g
    public Map<String, String> A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            Map<String, String> A = super.A();
            if (this.o && d.a.o0.n.j.i.l.f51282a) {
                if (A == null) {
                    A = new HashMap<>();
                }
                A.put("hb_type", "1");
                A.put("lastsynctime", String.valueOf(d.a.o0.n.j.i.l.f51284c));
                A.put("SWAN-TIMEOUT-SETTING", String.valueOf(d.a.o0.n.j.i.l.b(60) * 1000));
            }
            return A;
        }
        return (Map) invokeV.objValue;
    }

    @Override // d.a.o0.a.h0.m.l
    public int T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // d.a.o0.a.h0.m.l
    public PMSDownloadType U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? PMSDownloadType.SWAN_APP_UPDATE_CORE : (PMSDownloadType) invokeV.objValue;
    }

    @Override // d.a.o0.a.h0.m.l
    public String V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? d.a.o0.a.h0.m.r.a.d() : (String) invokeV.objValue;
    }

    @Override // d.a.o0.a.h0.m.l
    public String W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? d.a.o0.a.h0.m.r.a.h() : (String) invokeV.objValue;
    }

    @Override // d.a.o0.a.h0.m.l
    public d.a.o0.a.q2.a a0(d.a.o0.n.h.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, bVar)) == null) {
            if (bVar == null) {
                d.a.o0.a.q2.a aVar = new d.a.o0.a.q2.a();
                aVar.j(14L);
                aVar.b(2908L);
                aVar.c("小程序Extension包 Extension null");
                return aVar;
            }
            d.a.o0.a.p0.g.a aVar2 = new d.a.o0.a.p0.g.a();
            aVar2.f47219b = bVar.f51142i;
            aVar2.f47218a = bVar.j;
            aVar2.f47220c = bVar.f51134a;
            aVar2.f47221d = bVar.m;
            if (d.a.o0.a.p0.b.b(0, aVar2) == null) {
                if (p) {
                    Log.i("SwanAppUpdateCore", "小程序Extension包解压成功");
                }
                boolean n = d.a.o0.a.c1.a.Z().n();
                if (p) {
                    Log.d("SwanAppUpdateCore", "onExtensionDownloadFinish: extension js 热应用实验开关 " + n);
                }
                if (n) {
                    if (p) {
                        Log.d("SwanAppUpdateCore", "onExtensionDownloadFinish: 命中 extension js 热应用实验");
                    }
                    d.a.o0.a.p0.d.b f2 = d.a.o0.a.p0.b.f(0);
                    if (f2 == null) {
                        return null;
                    }
                    long g2 = f2.f().g();
                    if (g2 > 0) {
                        if (p) {
                            Log.d("SwanAppUpdateCore", "发送extension core更新事件");
                        }
                        SwanAppMessengerService.sendMessageWithDataToAllClient(121, g2);
                    }
                }
                return null;
            }
            d.a.o0.a.q2.a aVar3 = new d.a.o0.a.q2.a();
            aVar3.j(14L);
            aVar3.b(2908L);
            aVar3.c("小程序Extension包更新失败");
            return aVar3;
        }
        return (d.a.o0.a.q2.a) invokeL.objValue;
    }

    @Override // d.a.o0.a.h0.m.l
    public d.a.o0.a.q2.a b0(d.a.o0.n.h.d dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, dVar)) == null) {
            if (p) {
                Log.d("SwanAppUpdateCore", "onFrameworkDownloadFinish framework = " + dVar);
            }
            if (dVar == null) {
                d.a.o0.a.q2.a aVar = new d.a.o0.a.q2.a();
                aVar.j(13L);
                aVar.b(2907L);
                aVar.c("小程序Core包 Framework null");
                return aVar;
            }
            a.b c2 = d.a.o0.a.m2.f.a.c(dVar, 0);
            d.a.o0.a.e0.d.h("SwanAppUpdateCore", "SwanCore RemoteCoreUpdateStatus: " + c2);
            d.a.o0.t.d.j(dVar.f51134a);
            if (c2.c()) {
                long e2 = d.a.o0.a.m2.f.a.e(0);
                if (e2 > 0) {
                    SwanJSVersionUpdateEvent.sendEvent(e2);
                    SwanAppMessengerService.sendMessageWithDataToAllClient(114, e2);
                    return null;
                }
                return null;
            }
            d.a.o0.a.q2.a aVar2 = new d.a.o0.a.q2.a();
            aVar2.j(13L);
            aVar2.b(2907L);
            aVar2.c("小程序Core包更新失败");
            return aVar2;
        }
        return (d.a.o0.a.q2.a) invokeL.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(d.a.o0.a.v2.e1.b<Exception> bVar, boolean z) {
        super(bVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((d.a.o0.a.v2.e1.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.o = z;
    }
}
