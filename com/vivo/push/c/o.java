package com.vivo.push.c;

import com.vivo.push.cache.ClientConfigManagerImpl;
import com.vivo.push.model.UnvarnishedMessage;
import java.util.HashMap;
/* loaded from: classes3.dex */
final class o extends aa {
    /* JADX INFO: Access modifiers changed from: package-private */
    public o(com.vivo.push.v vVar) {
        super(vVar);
    }

    @Override // com.vivo.push.s
    protected final void a(com.vivo.push.v vVar) {
        com.vivo.push.b.o oVar = (com.vivo.push.b.o) vVar;
        com.vivo.push.m.a().a(new com.vivo.push.b.i(String.valueOf(oVar.f())));
        if (!ClientConfigManagerImpl.getInstance(this.a).isEnablePush()) {
            com.vivo.push.util.m.d("OnMessageTask", "command  " + vVar + " is ignore by disable push ");
            com.vivo.push.b.x xVar = new com.vivo.push.b.x(1020L);
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("messageID", String.valueOf(oVar.f()));
            xVar.a(hashMap);
            com.vivo.push.m.a().a(xVar);
        } else if (com.vivo.push.m.a().h() && !a(com.vivo.push.util.w.d(this.a), oVar.d(), oVar.i())) {
            com.vivo.push.b.x xVar2 = new com.vivo.push.b.x(1021L);
            HashMap<String, String> hashMap2 = new HashMap<>();
            hashMap2.put("messageID", String.valueOf(oVar.f()));
            xVar2.a(hashMap2);
            com.vivo.push.m.a().a(xVar2);
        } else {
            UnvarnishedMessage e = oVar.e();
            if (e != null) {
                int targetType = e.getTargetType();
                com.vivo.push.util.m.d("OnMessageTask", "tragetType is " + targetType + " ; target is " + e.getTragetContent());
                b.post(new p(this, e));
                return;
            }
            com.vivo.push.util.m.a("OnMessageTask", " message is null");
        }
    }
}
