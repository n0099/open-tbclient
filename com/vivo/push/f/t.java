package com.vivo.push.f;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.vivo.push.cache.ClientConfigManagerImpl;
import com.vivo.push.model.UnvarnishedMessage;
/* loaded from: classes8.dex */
public final class t extends aa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(com.vivo.push.o oVar) {
        super(oVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {oVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((com.vivo.push.o) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.vivo.push.l
    public final void a(com.vivo.push.o oVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, oVar) == null) {
            com.vivo.push.b.o oVar2 = (com.vivo.push.b.o) oVar;
            com.vivo.push.e.a().a(new com.vivo.push.b.h(String.valueOf(oVar2.f())));
            if (!ClientConfigManagerImpl.getInstance(this.a).isEnablePush()) {
                com.vivo.push.util.u.d("OnMessageTask", "command  " + oVar + " is ignore by disable push ");
                super.a(1020);
            } else if (com.vivo.push.e.a().g() && !a(com.vivo.push.util.ag.c(this.a), oVar2.d(), oVar2.g())) {
                super.a(1021);
            } else {
                UnvarnishedMessage e = oVar2.e();
                if (e != null) {
                    int targetType = e.getTargetType();
                    long msgId = e.getMsgId();
                    com.vivo.push.util.u.d("OnMessageTask", "tragetType is " + targetType + " ; messageId is " + msgId);
                    ((aa) this).b.onTransmissionMessage(this.a, e);
                    super.a(0);
                    return;
                }
                super.a(2807);
                com.vivo.push.util.u.a("OnMessageTask", " message is null");
            }
        }
    }
}
