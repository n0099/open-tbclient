package com.vivo.push.c;

import android.text.TextUtils;
import com.vivo.push.cache.ClientConfigManagerImpl;
import com.vivo.push.model.UnvarnishedMessage;
import java.util.HashMap;
/* loaded from: classes3.dex */
final class o extends aa {
    /* JADX INFO: Access modifiers changed from: package-private */
    public o(com.vivo.push.y yVar) {
        super(yVar);
    }

    @Override // com.vivo.push.v
    protected final void a(com.vivo.push.y yVar) {
        com.vivo.push.b.o oVar = (com.vivo.push.b.o) yVar;
        com.vivo.push.p.a().a(new com.vivo.push.b.i(String.valueOf(oVar.f())));
        if (!ClientConfigManagerImpl.getInstance(this.a).isEnablePush()) {
            com.vivo.push.util.p.d("OnMessageTask", "command  " + yVar + " is ignore by disable push ");
            com.vivo.push.b.y yVar2 = new com.vivo.push.b.y(1020L);
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("messageID", String.valueOf(oVar.f()));
            String b = com.vivo.push.util.z.b(this.a, this.a.getPackageName());
            if (!TextUtils.isEmpty(b)) {
                hashMap.put("remoteAppId", b);
            }
            yVar2.a(hashMap);
            com.vivo.push.p.a().a(yVar2);
        } else if (com.vivo.push.p.a().g() && !a(com.vivo.push.util.z.d(this.a), oVar.d(), oVar.i())) {
            com.vivo.push.b.y yVar3 = new com.vivo.push.b.y(1021L);
            HashMap<String, String> hashMap2 = new HashMap<>();
            hashMap2.put("messageID", String.valueOf(oVar.f()));
            String b2 = com.vivo.push.util.z.b(this.a, this.a.getPackageName());
            if (!TextUtils.isEmpty(b2)) {
                hashMap2.put("remoteAppId", b2);
            }
            yVar3.a(hashMap2);
            com.vivo.push.p.a().a(yVar3);
        } else {
            UnvarnishedMessage e = oVar.e();
            if (e != null) {
                int targetType = e.getTargetType();
                com.vivo.push.util.p.d("OnMessageTask", "tragetType is " + targetType + " ; target is " + e.getTragetContent());
                com.vivo.push.w.b(new p(this, e));
                return;
            }
            com.vivo.push.util.p.a("OnMessageTask", " message is null");
        }
    }
}
