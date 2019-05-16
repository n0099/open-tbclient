package com.vivo.push.c;

import com.vivo.push.util.NotifyAdapterUtil;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class ag extends aa {
    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(com.vivo.push.v vVar) {
        super(vVar);
    }

    @Override // com.vivo.push.s
    protected final void a(com.vivo.push.v vVar) {
        com.vivo.push.b.u uVar = (com.vivo.push.b.u) vVar;
        if (com.vivo.push.m.a().h() && !a(com.vivo.push.util.w.d(this.a), uVar.e(), uVar.i())) {
            com.vivo.push.util.m.d("OnUndoMsgTask", " vertify msg is error ");
            com.vivo.push.b.x xVar = new com.vivo.push.b.x(1021L);
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("messageID", String.valueOf(uVar.f()));
            xVar.a(hashMap);
            com.vivo.push.m.a().a(xVar);
            return;
        }
        long b = com.vivo.push.util.t.b().b("com.vivo.push.notify_key", -1L);
        if (b == uVar.d()) {
            com.vivo.push.util.m.d("OnUndoMsgTask", "undo showed message " + uVar.d());
            com.vivo.push.util.m.a(this.a, "回收已展示的通知： " + uVar.d());
            NotifyAdapterUtil.cancelNotify(this.a);
            return;
        }
        com.vivo.push.util.m.d("OnUndoMsgTask", "current showing message id " + b + " not match " + uVar.d());
        com.vivo.push.util.m.a(this.a, "与已展示的通知" + b + "与待回收的通知" + uVar.d() + "不匹配");
    }
}
