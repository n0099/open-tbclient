package d.a.n0.h.p.b;

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
import d.a.n0.a.h0.m.l;
import d.a.n0.a.k;
import d.a.n0.a.m2.f.a;
import d.a.n0.a.v2.e1.b;
import d.a.n0.n.h.d;
/* loaded from: classes7.dex */
public class a extends l {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean o;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-29747307, "Ld/a/n0/h/p/b/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-29747307, "Ld/a/n0/h/p/b/a;");
                return;
            }
        }
        o = k.f45831a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(b<Exception> bVar) {
        super(bVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // d.a.n0.a.h0.m.l
    public int T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    @Override // d.a.n0.a.h0.m.l
    public PMSDownloadType U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? PMSDownloadType.SWAN_GAME_UPDATE_CORE : (PMSDownloadType) invokeV.objValue;
    }

    @Override // d.a.n0.a.h0.m.l
    public String V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? d.a.n0.a.h0.m.r.a.f() : (String) invokeV.objValue;
    }

    @Override // d.a.n0.a.h0.m.l
    public String W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? d.a.n0.a.h0.m.r.a.e() : (String) invokeV.objValue;
    }

    @Override // d.a.n0.a.h0.m.l
    public d.a.n0.a.q2.a a0(d.a.n0.n.h.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, bVar)) == null) {
            if (bVar == null) {
                d.a.n0.a.q2.a aVar = new d.a.n0.a.q2.a();
                aVar.j(14L);
                aVar.b(2908L);
                aVar.c("小游戏Extension包 Extension null");
                return aVar;
            }
            d.a.n0.a.p0.g.a aVar2 = new d.a.n0.a.p0.g.a();
            aVar2.f46715b = bVar.f50638i;
            aVar2.f46714a = bVar.j;
            aVar2.f46716c = bVar.f50630a;
            aVar2.f46717d = bVar.m;
            if (d.a.n0.a.p0.b.b(1, aVar2) == null) {
                if (o) {
                    Log.i("SwanGameUpdateCore", "小游戏Extension包解压成功");
                    return null;
                }
                return null;
            }
            d.a.n0.a.q2.a aVar3 = new d.a.n0.a.q2.a();
            aVar3.j(14L);
            aVar3.b(2908L);
            aVar3.c("小游戏Extension包更新失败");
            return aVar3;
        }
        return (d.a.n0.a.q2.a) invokeL.objValue;
    }

    @Override // d.a.n0.a.h0.m.l
    public d.a.n0.a.q2.a b0(d dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, dVar)) == null) {
            if (o) {
                Log.d("SwanGameUpdateCore", "onFrameworkDownloadFinish framework = " + dVar);
            }
            if (dVar == null) {
                d.a.n0.a.q2.a aVar = new d.a.n0.a.q2.a();
                aVar.j(13L);
                aVar.b(2907L);
                aVar.c("小游戏GameCore包 Framework null");
                return aVar;
            }
            a.b c2 = d.a.n0.a.m2.f.a.c(dVar, 1);
            d.a.n0.t.d.j(dVar.f50630a);
            if (c2.c()) {
                if (o) {
                    Log.d("SwanGameUpdateCore", "小游戏GameCore解压成功");
                }
                long e2 = d.a.n0.a.m2.f.a.e(1);
                if (e2 > 0) {
                    SwanAppMessengerService.sendMessageWithDataToAllClient(117, e2);
                    return null;
                }
                return null;
            }
            d.a.n0.a.q2.a aVar2 = new d.a.n0.a.q2.a();
            aVar2.j(13L);
            aVar2.b(2907L);
            aVar2.c("小游戏GameCore包更新失败");
            return aVar2;
        }
        return (d.a.n0.a.q2.a) invokeL.objValue;
    }
}
