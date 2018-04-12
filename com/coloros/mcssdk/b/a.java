package com.coloros.mcssdk.b;

import android.content.Context;
/* loaded from: classes3.dex */
public final class a implements c {
    @Override // com.coloros.mcssdk.b.c
    public final void a(Context context, com.coloros.mcssdk.e.c cVar, com.coloros.mcssdk.d.a aVar) {
        if (cVar == null) {
            return;
        }
        com.coloros.mcssdk.c.c.a("process--AppMessageProcessor--message:" + cVar);
        if (cVar.getType() == 4098) {
            com.coloros.mcssdk.e.a aVar2 = (com.coloros.mcssdk.e.a) cVar;
            if (aVar != null) {
                aVar.processMessage(context, aVar2);
            }
        }
    }
}
