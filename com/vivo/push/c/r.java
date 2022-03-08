package com.vivo.push.c;

import android.app.NotificationChannel;
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
import com.vivo.push.util.NotifyAdapterUtil;
import java.util.HashMap;
/* loaded from: classes8.dex */
public final class r extends z {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public interface a {
        void a();

        void b();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(com.vivo.push.o oVar) {
        super(oVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {oVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
                com.vivo.push.util.p.a("OnNotificationArrivedTask", "command is null");
                return;
            }
            boolean isEnablePush = ClientConfigManagerImpl.getInstance(this.a).isEnablePush();
            com.vivo.push.b.q qVar = (com.vivo.push.b.q) oVar;
            Context context = this.a;
            if (!com.vivo.push.util.t.d(context, context.getPackageName())) {
                com.vivo.push.b.x xVar = new com.vivo.push.b.x(2101L);
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("messageID", String.valueOf(qVar.f()));
                Context context2 = this.a;
                String b2 = com.vivo.push.util.aa.b(context2, context2.getPackageName());
                if (!TextUtils.isEmpty(b2)) {
                    hashMap.put("remoteAppId", b2);
                }
                xVar.a(hashMap);
                com.vivo.push.e.a().a(xVar);
                return;
            }
            com.vivo.push.e.a().a(new com.vivo.push.b.h(String.valueOf(qVar.f())));
            com.vivo.push.util.p.d("OnNotificationArrivedTask", "PushMessageReceiver " + this.a.getPackageName() + " isEnablePush :" + isEnablePush);
            if (!isEnablePush) {
                com.vivo.push.b.x xVar2 = new com.vivo.push.b.x(1020L);
                HashMap<String, String> hashMap2 = new HashMap<>();
                hashMap2.put("messageID", String.valueOf(qVar.f()));
                Context context3 = this.a;
                String b3 = com.vivo.push.util.aa.b(context3, context3.getPackageName());
                if (!TextUtils.isEmpty(b3)) {
                    hashMap2.put("remoteAppId", b3);
                }
                xVar2.a(hashMap2);
                com.vivo.push.e.a().a(xVar2);
            } else if (com.vivo.push.e.a().g() && !a(com.vivo.push.util.aa.d(this.a), qVar.e(), qVar.i())) {
                com.vivo.push.b.x xVar3 = new com.vivo.push.b.x(1021L);
                HashMap<String, String> hashMap3 = new HashMap<>();
                hashMap3.put("messageID", String.valueOf(qVar.f()));
                Context context4 = this.a;
                String b4 = com.vivo.push.util.aa.b(context4, context4.getPackageName());
                if (!TextUtils.isEmpty(b4)) {
                    hashMap3.put("remoteAppId", b4);
                }
                xVar3.a(hashMap3);
                com.vivo.push.e.a().a(xVar3);
            } else {
                if (Build.VERSION.SDK_INT >= 24) {
                    NotificationManager notificationManager = (NotificationManager) this.a.getSystemService(ActionJsonData.TAG_NOTIFICATION);
                    if (notificationManager != null && !notificationManager.areNotificationsEnabled()) {
                        com.vivo.push.util.p.b("OnNotificationArrivedTask", "pkg name : " + this.a.getPackageName() + " notify switch is false");
                        com.vivo.push.util.p.b(this.a, "通知开关关闭，导致通知无法展示，请到设置页打开应用通知开关");
                        com.vivo.push.b.x xVar4 = new com.vivo.push.b.x(2104L);
                        HashMap<String, String> hashMap4 = new HashMap<>();
                        hashMap4.put("messageID", String.valueOf(qVar.f()));
                        Context context5 = this.a;
                        String b5 = com.vivo.push.util.aa.b(context5, context5.getPackageName());
                        if (!TextUtils.isEmpty(b5)) {
                            hashMap4.put("remoteAppId", b5);
                        }
                        xVar4.a(hashMap4);
                        com.vivo.push.e.a().a(xVar4);
                        return;
                    } else if (Build.VERSION.SDK_INT >= 26 && notificationManager != null) {
                        try {
                            NotificationChannel notificationChannel = notificationManager.getNotificationChannel(NotifyAdapterUtil.PRIMARY_CHANNEL);
                            if (notificationChannel != null && notificationChannel.getImportance() == 0) {
                                com.vivo.push.util.p.b("OnNotificationArrivedTask", "pkg name : " + this.a.getPackageName() + " notify channel switch is false");
                                com.vivo.push.util.p.b(this.a, "通知通道开关关闭，导致通知无法展示，请到设置页打开应用通知开关");
                                HashMap hashMap5 = new HashMap();
                                hashMap5.put("messageID", String.valueOf(qVar.f()));
                                String b6 = com.vivo.push.util.aa.b(this.a, this.a.getPackageName());
                                if (!TextUtils.isEmpty(b6)) {
                                    hashMap5.put("remoteAppId", b6);
                                }
                                com.vivo.push.util.e.a(2121L, hashMap5);
                                return;
                            }
                        } catch (Exception unused) {
                            com.vivo.push.util.p.b("OnNotificationArrivedTask", "判断通知通道出现系统错误");
                        }
                    }
                }
                InsideNotificationItem d2 = qVar.d();
                if (d2 != null) {
                    int targetType = d2.getTargetType();
                    String tragetContent = d2.getTragetContent();
                    com.vivo.push.util.p.d("OnNotificationArrivedTask", "tragetType is " + targetType + " ; target is " + tragetContent);
                    com.vivo.push.m.c(new s(this, d2, qVar));
                    return;
                }
                com.vivo.push.util.p.a("OnNotificationArrivedTask", "notify is null");
                Context context6 = this.a;
                com.vivo.push.util.p.c(context6, "通知内容为空，" + qVar.f());
                com.vivo.push.util.e.a(this.a, qVar.f(), 1027L);
            }
        }
    }
}
