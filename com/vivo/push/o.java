package com.vivo.push;

import android.content.Intent;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.vivo.push.c.ab;
import com.vivo.push.c.ai;
/* loaded from: classes7.dex */
public final class o implements IPushClientFactory {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ai f42178a;

    public o() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f42178a = new ai();
    }

    @Override // com.vivo.push.IPushClientFactory
    public final ab createReceiveTask(y yVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, yVar)) == null) ? ai.b(yVar) : (ab) invokeL.objValue;
    }

    @Override // com.vivo.push.IPushClientFactory
    public final y createReceiverCommand(Intent intent) {
        InterceptResult invokeL;
        y wVar;
        y vVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, intent)) == null) {
            int intExtra = intent.getIntExtra("command", -1);
            if (intExtra < 0) {
                intExtra = intent.getIntExtra("method", -1);
            }
            if (intExtra == 20) {
                wVar = new com.vivo.push.b.w();
            } else if (intExtra != 2016) {
                switch (intExtra) {
                    case 1:
                    case 2:
                        vVar = new com.vivo.push.b.v(intExtra);
                        wVar = vVar;
                        break;
                    case 3:
                        wVar = new com.vivo.push.b.q();
                        break;
                    case 4:
                        wVar = new com.vivo.push.b.s();
                        break;
                    case 5:
                        wVar = new com.vivo.push.b.r();
                        break;
                    case 6:
                        wVar = new com.vivo.push.b.t();
                        break;
                    case 7:
                        wVar = new com.vivo.push.b.p();
                        break;
                    case 8:
                        wVar = new com.vivo.push.b.o();
                        break;
                    case 9:
                        wVar = new com.vivo.push.b.m();
                        break;
                    case 10:
                    case 11:
                        vVar = new com.vivo.push.b.k(intExtra);
                        wVar = vVar;
                        break;
                    case 12:
                        wVar = new com.vivo.push.b.l();
                        break;
                    default:
                        wVar = null;
                        break;
                }
            } else {
                wVar = new com.vivo.push.b.n();
            }
            if (wVar != null) {
                a a2 = a.a(intent);
                if (a2 == null) {
                    com.vivo.push.util.p.b("PushCommand", "bundleWapper is null");
                } else {
                    wVar.b(a2);
                }
            }
            return wVar;
        }
        return (y) invokeL.objValue;
    }

    @Override // com.vivo.push.IPushClientFactory
    public final v createTask(y yVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, yVar)) == null) ? ai.a(yVar) : (v) invokeL.objValue;
    }
}
