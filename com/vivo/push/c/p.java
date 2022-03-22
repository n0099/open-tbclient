package com.vivo.push.c;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.vivo.push.cache.ClientConfigManagerImpl;
import com.vivo.push.model.UnvarnishedMessage;
import java.util.HashMap;
/* loaded from: classes7.dex */
public final class p extends z {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(com.vivo.push.o oVar) {
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
                com.vivo.push.util.p.d("OnMessageTask", "command  " + oVar + " is ignore by disable push ");
                com.vivo.push.b.x xVar = new com.vivo.push.b.x(1020L);
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("messageID", String.valueOf(oVar2.f()));
                Context context = this.a;
                String b2 = com.vivo.push.util.aa.b(context, context.getPackageName());
                if (!TextUtils.isEmpty(b2)) {
                    hashMap.put("remoteAppId", b2);
                }
                xVar.a(hashMap);
                com.vivo.push.e.a().a(xVar);
            } else if (com.vivo.push.e.a().g() && !a(com.vivo.push.util.aa.d(this.a), oVar2.d(), oVar2.i())) {
                com.vivo.push.b.x xVar2 = new com.vivo.push.b.x(1021L);
                HashMap<String, String> hashMap2 = new HashMap<>();
                hashMap2.put("messageID", String.valueOf(oVar2.f()));
                Context context2 = this.a;
                String b3 = com.vivo.push.util.aa.b(context2, context2.getPackageName());
                if (!TextUtils.isEmpty(b3)) {
                    hashMap2.put("remoteAppId", b3);
                }
                xVar2.a(hashMap2);
                com.vivo.push.e.a().a(xVar2);
            } else {
                UnvarnishedMessage e2 = oVar2.e();
                if (e2 != null) {
                    int targetType = e2.getTargetType();
                    String tragetContent = e2.getTragetContent();
                    com.vivo.push.util.p.d("OnMessageTask", "tragetType is " + targetType + " ; target is " + tragetContent);
                    com.vivo.push.m.b(new q(this, e2));
                    return;
                }
                com.vivo.push.util.p.a("OnMessageTask", " message is null");
            }
        }
    }
}
