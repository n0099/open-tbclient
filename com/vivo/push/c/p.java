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
/* loaded from: classes10.dex */
public final class p extends ab {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(com.vivo.push.y yVar) {
        super(yVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {yVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((com.vivo.push.y) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.vivo.push.v
    public final void a(com.vivo.push.y yVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, yVar) == null) {
            com.vivo.push.b.q qVar = (com.vivo.push.b.q) yVar;
            com.vivo.push.p.a().a(new com.vivo.push.b.j(String.valueOf(qVar.f())));
            if (!ClientConfigManagerImpl.getInstance(this.f77046a).isEnablePush()) {
                com.vivo.push.util.p.d("OnMessageTask", "command  " + yVar + " is ignore by disable push ");
                com.vivo.push.b.aa aaVar = new com.vivo.push.b.aa(1020L);
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("messageID", String.valueOf(qVar.f()));
                Context context = this.f77046a;
                String b2 = com.vivo.push.util.z.b(context, context.getPackageName());
                if (!TextUtils.isEmpty(b2)) {
                    hashMap.put("remoteAppId", b2);
                }
                aaVar.a(hashMap);
                com.vivo.push.p.a().a(aaVar);
            } else if (com.vivo.push.p.a().g() && !a(com.vivo.push.util.z.d(this.f77046a), qVar.d(), qVar.i())) {
                com.vivo.push.b.aa aaVar2 = new com.vivo.push.b.aa(1021L);
                HashMap<String, String> hashMap2 = new HashMap<>();
                hashMap2.put("messageID", String.valueOf(qVar.f()));
                Context context2 = this.f77046a;
                String b3 = com.vivo.push.util.z.b(context2, context2.getPackageName());
                if (!TextUtils.isEmpty(b3)) {
                    hashMap2.put("remoteAppId", b3);
                }
                aaVar2.a(hashMap2);
                com.vivo.push.p.a().a(aaVar2);
            } else {
                UnvarnishedMessage e2 = qVar.e();
                if (e2 != null) {
                    int targetType = e2.getTargetType();
                    String tragetContent = e2.getTragetContent();
                    com.vivo.push.util.p.d("OnMessageTask", "tragetType is " + targetType + " ; target is " + tragetContent);
                    com.vivo.push.w.b(new q(this, e2));
                    return;
                }
                com.vivo.push.util.p.a("OnMessageTask", " message is null");
            }
        }
    }
}
