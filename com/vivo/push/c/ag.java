package com.vivo.push.c;

import android.text.TextUtils;
import com.vivo.push.util.NotifyAdapterUtil;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class ag extends aa {
    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(com.vivo.push.y yVar) {
        super(yVar);
    }

    @Override // com.vivo.push.v
    protected final void a(com.vivo.push.y yVar) {
        com.vivo.push.b.u uVar = (com.vivo.push.b.u) yVar;
        if (com.vivo.push.p.a().g() && !a(com.vivo.push.util.z.d(this.a), uVar.e(), uVar.i())) {
            com.vivo.push.util.p.d("OnUndoMsgTask", " vertify msg is error ");
            com.vivo.push.b.y yVar2 = new com.vivo.push.b.y(1021L);
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("messageID", String.valueOf(uVar.f()));
            String b = com.vivo.push.util.z.b(this.a, this.a.getPackageName());
            if (!TextUtils.isEmpty(b)) {
                hashMap.put("remoteAppId", b);
            }
            yVar2.a(hashMap);
            com.vivo.push.p.a().a(yVar2);
            return;
        }
        boolean repealNotifyById = NotifyAdapterUtil.repealNotifyById(this.a, (int) uVar.d());
        com.vivo.push.util.p.d("OnUndoMsgTask", "undo message " + uVar.d() + ", " + repealNotifyById);
        if (repealNotifyById) {
            com.vivo.push.util.p.b(this.a, "回收client通知成功, 上报埋点 1031, messageId = " + uVar.d());
            com.vivo.push.util.d.a(this.a, uVar.d(), 1031L);
            return;
        }
        com.vivo.push.util.p.d("OnUndoMsgTask", "undo message fail，messageId = " + uVar.d());
        com.vivo.push.util.p.c(this.a, "回收client通知失败，messageId = " + uVar.d());
    }
}
