package com.vivo.push.c;

import android.text.TextUtils;
import com.heytap.mcssdk.mode.Message;
import com.vivo.push.util.NotifyAdapterUtil;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class ah extends ab {
    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(com.vivo.push.y yVar) {
        super(yVar);
    }

    @Override // com.vivo.push.v
    protected final void a(com.vivo.push.y yVar) {
        com.vivo.push.b.w wVar = (com.vivo.push.b.w) yVar;
        if (com.vivo.push.p.a().g() && !a(com.vivo.push.util.z.d(this.f14008a), wVar.e(), wVar.i())) {
            com.vivo.push.util.p.d("OnUndoMsgTask", " vertify msg is error ");
            com.vivo.push.b.aa aaVar = new com.vivo.push.b.aa(1021L);
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put(Message.MESSAGE_ID, String.valueOf(wVar.f()));
            String b2 = com.vivo.push.util.z.b(this.f14008a, this.f14008a.getPackageName());
            if (!TextUtils.isEmpty(b2)) {
                hashMap.put("remoteAppId", b2);
            }
            aaVar.a(hashMap);
            com.vivo.push.p.a().a(aaVar);
            return;
        }
        boolean repealNotifyById = NotifyAdapterUtil.repealNotifyById(this.f14008a, (int) wVar.d());
        com.vivo.push.util.p.d("OnUndoMsgTask", "undo message " + wVar.d() + ", " + repealNotifyById);
        if (repealNotifyById) {
            com.vivo.push.util.p.b(this.f14008a, "回收client通知成功, 上报埋点 1031, messageId = " + wVar.d());
            com.vivo.push.util.d.a(this.f14008a, wVar.d(), 1031L);
            return;
        }
        com.vivo.push.util.p.d("OnUndoMsgTask", "undo message fail，messageId = " + wVar.d());
        com.vivo.push.util.p.c(this.f14008a, "回收client通知失败，messageId = " + wVar.d());
    }
}
