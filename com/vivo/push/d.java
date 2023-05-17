package com.vivo.push;

import android.content.Intent;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.vivo.push.b.t;
import com.vivo.push.b.u;
import com.vivo.push.f.aa;
import com.vivo.push.f.ah;
/* loaded from: classes10.dex */
public final class d implements IPushClientFactory {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ah a;

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new ah();
    }

    @Override // com.vivo.push.IPushClientFactory
    public final aa createReceiveTask(o oVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, oVar)) == null) {
            return ah.b(oVar);
        }
        return (aa) invokeL.objValue;
    }

    @Override // com.vivo.push.IPushClientFactory
    public final l createTask(o oVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, oVar)) == null) {
            return ah.a(oVar);
        }
        return (l) invokeL.objValue;
    }

    @Override // com.vivo.push.IPushClientFactory
    public final o createReceiverCommand(Intent intent) {
        InterceptResult invokeL;
        o uVar;
        o tVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, intent)) == null) {
            int intExtra = intent.getIntExtra("command", -1);
            if (intExtra < 0) {
                intExtra = intent.getIntExtra("method", -1);
            }
            if (intExtra != 20) {
                if (intExtra != 2016) {
                    switch (intExtra) {
                        case 1:
                        case 2:
                            tVar = new t(intExtra);
                            uVar = tVar;
                            break;
                        case 3:
                            uVar = new com.vivo.push.b.o();
                            break;
                        case 4:
                            uVar = new com.vivo.push.b.q();
                            break;
                        case 5:
                            uVar = new com.vivo.push.b.p();
                            break;
                        case 6:
                            uVar = new com.vivo.push.b.r();
                            break;
                        case 7:
                            uVar = new com.vivo.push.b.n();
                            break;
                        case 8:
                            uVar = new com.vivo.push.b.m();
                            break;
                        case 9:
                            uVar = new com.vivo.push.b.k();
                            break;
                        case 10:
                        case 11:
                            tVar = new com.vivo.push.b.i(intExtra);
                            uVar = tVar;
                            break;
                        case 12:
                            uVar = new com.vivo.push.b.j();
                            break;
                        default:
                            uVar = null;
                            break;
                    }
                } else {
                    uVar = new com.vivo.push.b.l();
                }
            } else {
                uVar = new u();
            }
            if (uVar != null) {
                a a = a.a(intent);
                if (a == null) {
                    com.vivo.push.util.u.b("PushCommand", "bundleWapper is null");
                } else {
                    uVar.b(a);
                }
            }
            return uVar;
        }
        return (o) invokeL.objValue;
    }
}
