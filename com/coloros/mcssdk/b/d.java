package com.coloros.mcssdk.b;

import android.content.Context;
/* loaded from: classes2.dex */
public final class d implements c {
    @Override // com.coloros.mcssdk.b.c
    public final void a(Context context, com.coloros.mcssdk.e.c cVar, com.coloros.mcssdk.d.a aVar) {
        if (cVar == null) {
            return;
        }
        com.coloros.mcssdk.c.c.a("process--SptMessageProcessor--message:" + cVar);
        if (cVar.getType() == 4103) {
            com.coloros.mcssdk.e.d dVar = (com.coloros.mcssdk.e.d) cVar;
            if (aVar != null) {
                aVar.processMessage(context, dVar);
            }
        }
    }
}
