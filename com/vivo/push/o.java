package com.vivo.push;

import android.content.Intent;
import com.coloros.mcssdk.mode.CommandMessage;
import com.vivo.push.c.ah;
/* loaded from: classes3.dex */
public final class o implements IPushClientFactory {
    private ah a = new ah();

    @Override // com.vivo.push.IPushClientFactory
    public final y createReceiverCommand(Intent intent) {
        y yVar = null;
        int intExtra = intent.getIntExtra(CommandMessage.COMMAND, -1);
        if (intExtra < 0) {
            intExtra = intent.getIntExtra("method", -1);
        }
        switch (intExtra) {
            case 1:
            case 2:
                yVar = new com.vivo.push.b.t(intExtra);
                break;
            case 3:
                yVar = new com.vivo.push.b.o();
                break;
            case 4:
                yVar = new com.vivo.push.b.q();
                break;
            case 5:
                yVar = new com.vivo.push.b.p();
                break;
            case 6:
                yVar = new com.vivo.push.b.r();
                break;
            case 7:
                yVar = new com.vivo.push.b.n();
                break;
            case 8:
                yVar = new com.vivo.push.b.m();
                break;
            case 9:
                yVar = new com.vivo.push.b.l();
                break;
            case 10:
            case 11:
                yVar = new com.vivo.push.b.j(intExtra);
                break;
            case 12:
                yVar = new com.vivo.push.b.k();
                break;
            case 20:
                yVar = new com.vivo.push.b.u();
                break;
        }
        if (yVar != null) {
            a a = a.a(intent);
            if (a == null) {
                com.vivo.push.util.p.b("PushCommand", "bundleWapper is null");
            } else {
                yVar.b(a);
            }
        }
        return yVar;
    }

    @Override // com.vivo.push.IPushClientFactory
    public final v createTask(y yVar) {
        return ah.a(yVar);
    }

    @Override // com.vivo.push.IPushClientFactory
    public final com.vivo.push.c.aa createReceiveTask(y yVar) {
        return ah.b(yVar);
    }
}
