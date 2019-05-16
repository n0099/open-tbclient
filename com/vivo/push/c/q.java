package com.vivo.push.c;

import com.vivo.push.cache.ClientConfigManagerImpl;
import com.vivo.push.model.InsideNotificationItem;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class q extends aa {
    /* JADX INFO: Access modifiers changed from: package-private */
    public q(com.vivo.push.v vVar) {
        super(vVar);
    }

    @Override // com.vivo.push.s
    protected final void a(com.vivo.push.v vVar) {
        boolean isEnablePush = ClientConfigManagerImpl.getInstance(this.a).isEnablePush();
        com.vivo.push.b.q qVar = (com.vivo.push.b.q) vVar;
        if (!com.vivo.push.util.p.c(this.a, this.a.getPackageName())) {
            com.vivo.push.b.x xVar = new com.vivo.push.b.x(2101L);
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("messageID", String.valueOf(qVar.f()));
            xVar.a(hashMap);
            com.vivo.push.m.a().a(xVar);
            return;
        }
        com.vivo.push.m.a().a(new com.vivo.push.b.i(String.valueOf(qVar.f())));
        com.vivo.push.util.m.d("OnNotificationArrivedTask", "PushMessageReceiver " + this.a.getPackageName() + " isEnablePush :" + isEnablePush);
        if (!isEnablePush) {
            com.vivo.push.b.x xVar2 = new com.vivo.push.b.x(1020L);
            HashMap<String, String> hashMap2 = new HashMap<>();
            hashMap2.put("messageID", String.valueOf(qVar.f()));
            xVar2.a(hashMap2);
            com.vivo.push.m.a().a(xVar2);
        } else if (com.vivo.push.m.a().h() && !a(com.vivo.push.util.w.d(this.a), qVar.e(), qVar.i())) {
            com.vivo.push.b.x xVar3 = new com.vivo.push.b.x(1021L);
            HashMap<String, String> hashMap3 = new HashMap<>();
            hashMap3.put("messageID", String.valueOf(qVar.f()));
            xVar3.a(hashMap3);
            com.vivo.push.m.a().a(xVar3);
        } else {
            InsideNotificationItem d = qVar.d();
            if (d != null) {
                int targetType = d.getTargetType();
                com.vivo.push.util.m.d("OnNotificationArrivedTask", "tragetType is " + targetType + " ; target is " + d.getTragetContent());
                b.post(new r(this, d, qVar, ClientConfigManagerImpl.getInstance(this.a).isShowBigPic()));
                return;
            }
            com.vivo.push.util.m.a("OnNotificationArrivedTask", "notify is null");
            com.vivo.push.util.m.c(this.a, "通知内容为空，" + qVar.f());
            long f = qVar.f();
            com.vivo.push.util.m.d("ClientReportUtil", "report message: " + f + ", reportType: 1027");
            com.vivo.push.b.x xVar4 = new com.vivo.push.b.x(1027L);
            HashMap<String, String> hashMap4 = new HashMap<>();
            hashMap4.put("messageID", String.valueOf(f));
            xVar4.a(hashMap4);
            com.vivo.push.m.a().a(xVar4);
        }
    }
}
