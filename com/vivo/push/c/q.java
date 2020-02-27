package com.vivo.push.c;

import android.app.NotificationManager;
import android.os.Build;
import android.text.TextUtils;
import com.vivo.push.cache.ClientConfigManagerImpl;
import com.vivo.push.model.InsideNotificationItem;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public final class q extends aa {
    /* JADX INFO: Access modifiers changed from: package-private */
    public q(com.vivo.push.y yVar) {
        super(yVar);
    }

    @Override // com.vivo.push.v
    protected final void a(com.vivo.push.y yVar) {
        NotificationManager notificationManager;
        boolean isEnablePush = ClientConfigManagerImpl.getInstance(this.a).isEnablePush();
        com.vivo.push.b.q qVar = (com.vivo.push.b.q) yVar;
        if (!com.vivo.push.util.s.c(this.a, this.a.getPackageName())) {
            com.vivo.push.b.y yVar2 = new com.vivo.push.b.y(2101L);
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("messageID", String.valueOf(qVar.f()));
            String b = com.vivo.push.util.z.b(this.a, this.a.getPackageName());
            if (!TextUtils.isEmpty(b)) {
                hashMap.put("remoteAppId", b);
            }
            yVar2.a(hashMap);
            com.vivo.push.p.a().a(yVar2);
            return;
        }
        com.vivo.push.p.a().a(new com.vivo.push.b.i(String.valueOf(qVar.f())));
        com.vivo.push.util.p.d("OnNotificationArrivedTask", "PushMessageReceiver " + this.a.getPackageName() + " isEnablePush :" + isEnablePush);
        if (!isEnablePush) {
            com.vivo.push.b.y yVar3 = new com.vivo.push.b.y(1020L);
            HashMap<String, String> hashMap2 = new HashMap<>();
            hashMap2.put("messageID", String.valueOf(qVar.f()));
            String b2 = com.vivo.push.util.z.b(this.a, this.a.getPackageName());
            if (!TextUtils.isEmpty(b2)) {
                hashMap2.put("remoteAppId", b2);
            }
            yVar3.a(hashMap2);
            com.vivo.push.p.a().a(yVar3);
        } else if (com.vivo.push.p.a().g() && !a(com.vivo.push.util.z.d(this.a), qVar.e(), qVar.i())) {
            com.vivo.push.b.y yVar4 = new com.vivo.push.b.y(1021L);
            HashMap<String, String> hashMap3 = new HashMap<>();
            hashMap3.put("messageID", String.valueOf(qVar.f()));
            String b3 = com.vivo.push.util.z.b(this.a, this.a.getPackageName());
            if (!TextUtils.isEmpty(b3)) {
                hashMap3.put("remoteAppId", b3);
            }
            yVar4.a(hashMap3);
            com.vivo.push.p.a().a(yVar4);
        } else if (Build.VERSION.SDK_INT >= 24 && (notificationManager = (NotificationManager) this.a.getSystemService("notification")) != null && !notificationManager.areNotificationsEnabled()) {
            com.vivo.push.util.p.b("OnNotificationArrivedTask", "pkg name : " + this.a.getPackageName() + " notify switch is false");
            com.vivo.push.util.p.b(this.a, "通知开关关闭，导致通知无法展示，请到设置页打开应用通知开关");
            com.vivo.push.b.y yVar5 = new com.vivo.push.b.y(2104L);
            HashMap<String, String> hashMap4 = new HashMap<>();
            hashMap4.put("messageID", String.valueOf(qVar.f()));
            String b4 = com.vivo.push.util.z.b(this.a, this.a.getPackageName());
            if (!TextUtils.isEmpty(b4)) {
                hashMap4.put("remoteAppId", b4);
            }
            yVar5.a(hashMap4);
            com.vivo.push.p.a().a(yVar5);
        } else {
            InsideNotificationItem d = qVar.d();
            if (d != null) {
                com.vivo.push.util.p.d("OnNotificationArrivedTask", "tragetType is " + d.getTargetType() + " ; target is " + d.getTragetContent());
                com.vivo.push.w.b(new r(this, d, qVar));
                return;
            }
            com.vivo.push.util.p.a("OnNotificationArrivedTask", "notify is null");
            com.vivo.push.util.p.c(this.a, "通知内容为空，" + qVar.f());
            com.vivo.push.util.d.a(this.a, qVar.f(), 1027L);
        }
    }
}
