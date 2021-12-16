package com.vivo.push.c;

import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.android.util.io.ActionJsonData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.vivo.push.cache.ClientConfigManagerImpl;
import com.vivo.push.model.InsideNotificationItem;
import java.util.HashMap;
/* loaded from: classes4.dex */
public final class r extends ab {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(com.vivo.push.y yVar) {
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
        NotificationManager notificationManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, yVar) == null) {
            boolean isEnablePush = ClientConfigManagerImpl.getInstance(this.a).isEnablePush();
            com.vivo.push.b.s sVar = (com.vivo.push.b.s) yVar;
            Context context = this.a;
            if (!com.vivo.push.util.s.c(context, context.getPackageName())) {
                com.vivo.push.b.aa aaVar = new com.vivo.push.b.aa(2101L);
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("messageID", String.valueOf(sVar.f()));
                Context context2 = this.a;
                String b2 = com.vivo.push.util.z.b(context2, context2.getPackageName());
                if (!TextUtils.isEmpty(b2)) {
                    hashMap.put("remoteAppId", b2);
                }
                aaVar.a(hashMap);
                com.vivo.push.p.a().a(aaVar);
                return;
            }
            com.vivo.push.p.a().a(new com.vivo.push.b.j(String.valueOf(sVar.f())));
            com.vivo.push.util.p.d("OnNotificationArrivedTask", "PushMessageReceiver " + this.a.getPackageName() + " isEnablePush :" + isEnablePush);
            if (!isEnablePush) {
                com.vivo.push.b.aa aaVar2 = new com.vivo.push.b.aa(1020L);
                HashMap<String, String> hashMap2 = new HashMap<>();
                hashMap2.put("messageID", String.valueOf(sVar.f()));
                Context context3 = this.a;
                String b3 = com.vivo.push.util.z.b(context3, context3.getPackageName());
                if (!TextUtils.isEmpty(b3)) {
                    hashMap2.put("remoteAppId", b3);
                }
                aaVar2.a(hashMap2);
                com.vivo.push.p.a().a(aaVar2);
            } else if (com.vivo.push.p.a().g() && !a(com.vivo.push.util.z.d(this.a), sVar.e(), sVar.i())) {
                com.vivo.push.b.aa aaVar3 = new com.vivo.push.b.aa(1021L);
                HashMap<String, String> hashMap3 = new HashMap<>();
                hashMap3.put("messageID", String.valueOf(sVar.f()));
                Context context4 = this.a;
                String b4 = com.vivo.push.util.z.b(context4, context4.getPackageName());
                if (!TextUtils.isEmpty(b4)) {
                    hashMap3.put("remoteAppId", b4);
                }
                aaVar3.a(hashMap3);
                com.vivo.push.p.a().a(aaVar3);
            } else if (Build.VERSION.SDK_INT >= 24 && (notificationManager = (NotificationManager) this.a.getSystemService(ActionJsonData.TAG_NOTIFICATION)) != null && !notificationManager.areNotificationsEnabled()) {
                com.vivo.push.util.p.b("OnNotificationArrivedTask", "pkg name : " + this.a.getPackageName() + " notify switch is false");
                com.vivo.push.util.p.b(this.a, "通知开关关闭，导致通知无法展示，请到设置页打开应用通知开关");
                com.vivo.push.b.aa aaVar4 = new com.vivo.push.b.aa(2104L);
                HashMap<String, String> hashMap4 = new HashMap<>();
                hashMap4.put("messageID", String.valueOf(sVar.f()));
                Context context5 = this.a;
                String b5 = com.vivo.push.util.z.b(context5, context5.getPackageName());
                if (!TextUtils.isEmpty(b5)) {
                    hashMap4.put("remoteAppId", b5);
                }
                aaVar4.a(hashMap4);
                com.vivo.push.p.a().a(aaVar4);
            } else {
                InsideNotificationItem d2 = sVar.d();
                if (d2 != null) {
                    int targetType = d2.getTargetType();
                    String tragetContent = d2.getTragetContent();
                    com.vivo.push.util.p.d("OnNotificationArrivedTask", "tragetType is " + targetType + " ; target is " + tragetContent);
                    com.vivo.push.w.b(new s(this, d2, sVar));
                    return;
                }
                com.vivo.push.util.p.a("OnNotificationArrivedTask", "notify is null");
                Context context6 = this.a;
                com.vivo.push.util.p.c(context6, "通知内容为空，" + sVar.f());
                com.vivo.push.util.d.a(this.a, sVar.f(), 1027L);
            }
        }
    }
}
