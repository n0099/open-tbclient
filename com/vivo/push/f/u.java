package com.vivo.push.f;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.vivo.push.cache.ClientConfigManagerImpl;
import com.vivo.push.model.InsideNotificationItem;
import java.util.HashMap;
/* loaded from: classes10.dex */
public final class u extends aa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes10.dex */
    public interface a {
        void a();

        void b();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(com.vivo.push.o oVar) {
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
            if (oVar == null) {
                com.vivo.push.util.u.a("OnNotificationArrivedTask", "command is null");
                return;
            }
            boolean isEnablePush = ClientConfigManagerImpl.getInstance(this.a).isEnablePush();
            com.vivo.push.b.q qVar = (com.vivo.push.b.q) oVar;
            Context context = this.a;
            if (!com.vivo.push.util.aa.d(context, context.getPackageName())) {
                com.vivo.push.b.x xVar = new com.vivo.push.b.x(2101L);
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("messageID", String.valueOf(qVar.f()));
                String a2 = com.vivo.push.d.a.a().e().a();
                if (!TextUtils.isEmpty(a2)) {
                    hashMap.put("remoteAppId", a2);
                }
                xVar.a(hashMap);
                com.vivo.push.e.a().a(xVar);
                return;
            }
            com.vivo.push.e.a().a(new com.vivo.push.b.h(String.valueOf(qVar.f())));
            com.vivo.push.util.u.d("OnNotificationArrivedTask", "PushMessageReceiver " + this.a.getPackageName() + " isEnablePush :" + isEnablePush);
            if (!isEnablePush) {
                com.vivo.push.b.x xVar2 = new com.vivo.push.b.x(1020L);
                HashMap<String, String> hashMap2 = new HashMap<>();
                hashMap2.put("messageID", String.valueOf(qVar.f()));
                String a3 = com.vivo.push.d.a.a().e().a();
                if (!TextUtils.isEmpty(a3)) {
                    hashMap2.put("remoteAppId", a3);
                }
                xVar2.a(hashMap2);
                com.vivo.push.e.a().a(xVar2);
            } else if (com.vivo.push.e.a().g() && !a(com.vivo.push.util.ag.c(this.a), qVar.e(), qVar.g())) {
                com.vivo.push.b.x xVar3 = new com.vivo.push.b.x(1021L);
                HashMap<String, String> hashMap3 = new HashMap<>();
                hashMap3.put("messageID", String.valueOf(qVar.f()));
                String a4 = com.vivo.push.d.a.a().e().a();
                if (!TextUtils.isEmpty(a4)) {
                    hashMap3.put("remoteAppId", a4);
                }
                xVar3.a(hashMap3);
                com.vivo.push.e.a().a(xVar3);
            } else {
                InsideNotificationItem d = qVar.d();
                if (d != null) {
                    int targetType = d.getTargetType();
                    String tragetContent = d.getTragetContent();
                    com.vivo.push.util.u.d("OnNotificationArrivedTask", "tragetType is " + targetType + " ; target is " + tragetContent);
                    com.vivo.push.m.c(new v(this, d, qVar));
                    return;
                }
                com.vivo.push.util.u.a("OnNotificationArrivedTask", "notify is null");
                Context context2 = this.a;
                com.vivo.push.util.u.c(context2, "通知内容为空，" + qVar.f());
                com.vivo.push.util.f.a(qVar.f(), 1027L);
            }
        }
    }
}
