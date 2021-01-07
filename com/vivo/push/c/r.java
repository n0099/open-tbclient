package com.vivo.push.c;

import android.app.NotificationManager;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.android.util.io.ActionJsonData;
import com.heytap.mcssdk.mode.Message;
import com.vivo.push.cache.ClientConfigManagerImpl;
import com.vivo.push.model.InsideNotificationItem;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class r extends ab {
    /* JADX INFO: Access modifiers changed from: package-private */
    public r(com.vivo.push.y yVar) {
        super(yVar);
    }

    @Override // com.vivo.push.v
    protected final void a(com.vivo.push.y yVar) {
        NotificationManager notificationManager;
        boolean isEnablePush = ClientConfigManagerImpl.getInstance(this.f14009a).isEnablePush();
        com.vivo.push.b.s sVar = (com.vivo.push.b.s) yVar;
        if (!com.vivo.push.util.s.c(this.f14009a, this.f14009a.getPackageName())) {
            com.vivo.push.b.aa aaVar = new com.vivo.push.b.aa(2101L);
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put(Message.MESSAGE_ID, String.valueOf(sVar.f()));
            String b2 = com.vivo.push.util.z.b(this.f14009a, this.f14009a.getPackageName());
            if (!TextUtils.isEmpty(b2)) {
                hashMap.put("remoteAppId", b2);
            }
            aaVar.a(hashMap);
            com.vivo.push.p.a().a(aaVar);
            return;
        }
        com.vivo.push.p.a().a(new com.vivo.push.b.j(String.valueOf(sVar.f())));
        com.vivo.push.util.p.d("OnNotificationArrivedTask", "PushMessageReceiver " + this.f14009a.getPackageName() + " isEnablePush :" + isEnablePush);
        if (!isEnablePush) {
            com.vivo.push.b.aa aaVar2 = new com.vivo.push.b.aa(1020L);
            HashMap<String, String> hashMap2 = new HashMap<>();
            hashMap2.put(Message.MESSAGE_ID, String.valueOf(sVar.f()));
            String b3 = com.vivo.push.util.z.b(this.f14009a, this.f14009a.getPackageName());
            if (!TextUtils.isEmpty(b3)) {
                hashMap2.put("remoteAppId", b3);
            }
            aaVar2.a(hashMap2);
            com.vivo.push.p.a().a(aaVar2);
        } else if (com.vivo.push.p.a().g() && !a(com.vivo.push.util.z.d(this.f14009a), sVar.e(), sVar.i())) {
            com.vivo.push.b.aa aaVar3 = new com.vivo.push.b.aa(1021L);
            HashMap<String, String> hashMap3 = new HashMap<>();
            hashMap3.put(Message.MESSAGE_ID, String.valueOf(sVar.f()));
            String b4 = com.vivo.push.util.z.b(this.f14009a, this.f14009a.getPackageName());
            if (!TextUtils.isEmpty(b4)) {
                hashMap3.put("remoteAppId", b4);
            }
            aaVar3.a(hashMap3);
            com.vivo.push.p.a().a(aaVar3);
        } else if (Build.VERSION.SDK_INT >= 24 && (notificationManager = (NotificationManager) this.f14009a.getSystemService(ActionJsonData.TAG_NOTIFICATION)) != null && !notificationManager.areNotificationsEnabled()) {
            com.vivo.push.util.p.b("OnNotificationArrivedTask", "pkg name : " + this.f14009a.getPackageName() + " notify switch is false");
            com.vivo.push.util.p.b(this.f14009a, "通知开关关闭，导致通知无法展示，请到设置页打开应用通知开关");
            com.vivo.push.b.aa aaVar4 = new com.vivo.push.b.aa(2104L);
            HashMap<String, String> hashMap4 = new HashMap<>();
            hashMap4.put(Message.MESSAGE_ID, String.valueOf(sVar.f()));
            String b5 = com.vivo.push.util.z.b(this.f14009a, this.f14009a.getPackageName());
            if (!TextUtils.isEmpty(b5)) {
                hashMap4.put("remoteAppId", b5);
            }
            aaVar4.a(hashMap4);
            com.vivo.push.p.a().a(aaVar4);
        } else {
            InsideNotificationItem d = sVar.d();
            if (d != null) {
                com.vivo.push.util.p.d("OnNotificationArrivedTask", "tragetType is " + d.getTargetType() + " ; target is " + d.getTragetContent());
                com.vivo.push.w.b(new s(this, d, sVar));
                return;
            }
            com.vivo.push.util.p.a("OnNotificationArrivedTask", "notify is null");
            com.vivo.push.util.p.c(this.f14009a, "通知内容为空，" + sVar.f());
            com.vivo.push.util.d.a(this.f14009a, sVar.f(), 1027L);
        }
    }
}
