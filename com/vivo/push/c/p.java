package com.vivo.push.c;

import android.text.TextUtils;
import com.heytap.mcssdk.mode.Message;
import com.vivo.push.cache.ClientConfigManagerImpl;
import com.vivo.push.model.UnvarnishedMessage;
import java.util.HashMap;
/* loaded from: classes4.dex */
final class p extends ab {
    /* JADX INFO: Access modifiers changed from: package-private */
    public p(com.vivo.push.y yVar) {
        super(yVar);
    }

    @Override // com.vivo.push.v
    protected final void a(com.vivo.push.y yVar) {
        com.vivo.push.b.q qVar = (com.vivo.push.b.q) yVar;
        com.vivo.push.p.a().a(new com.vivo.push.b.j(String.valueOf(qVar.f())));
        if (!ClientConfigManagerImpl.getInstance(this.f14009a).isEnablePush()) {
            com.vivo.push.util.p.d("OnMessageTask", "command  " + yVar + " is ignore by disable push ");
            com.vivo.push.b.aa aaVar = new com.vivo.push.b.aa(1020L);
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put(Message.MESSAGE_ID, String.valueOf(qVar.f()));
            String b2 = com.vivo.push.util.z.b(this.f14009a, this.f14009a.getPackageName());
            if (!TextUtils.isEmpty(b2)) {
                hashMap.put("remoteAppId", b2);
            }
            aaVar.a(hashMap);
            com.vivo.push.p.a().a(aaVar);
        } else if (com.vivo.push.p.a().g() && !a(com.vivo.push.util.z.d(this.f14009a), qVar.d(), qVar.i())) {
            com.vivo.push.b.aa aaVar2 = new com.vivo.push.b.aa(1021L);
            HashMap<String, String> hashMap2 = new HashMap<>();
            hashMap2.put(Message.MESSAGE_ID, String.valueOf(qVar.f()));
            String b3 = com.vivo.push.util.z.b(this.f14009a, this.f14009a.getPackageName());
            if (!TextUtils.isEmpty(b3)) {
                hashMap2.put("remoteAppId", b3);
            }
            aaVar2.a(hashMap2);
            com.vivo.push.p.a().a(aaVar2);
        } else {
            UnvarnishedMessage e = qVar.e();
            if (e != null) {
                int targetType = e.getTargetType();
                com.vivo.push.util.p.d("OnMessageTask", "tragetType is " + targetType + " ; target is " + e.getTragetContent());
                com.vivo.push.w.b(new q(this, e));
                return;
            }
            com.vivo.push.util.p.a("OnMessageTask", " message is null");
        }
    }
}
