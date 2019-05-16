package com.vivo.push;

import android.content.Intent;
import com.coloros.mcssdk.mode.CommandMessage;
import com.vivo.push.c.aa;
import com.vivo.push.c.ah;
/* loaded from: classes3.dex */
public final class l implements IPushClientFactory {
    private ah a = new ah();

    @Override // com.vivo.push.IPushClientFactory
    public final v createReceiverCommand(Intent intent) {
        v vVar = null;
        int intExtra = intent.getIntExtra(CommandMessage.COMMAND, -1);
        if (intExtra < 0) {
            intExtra = intent.getIntExtra("method", -1);
        }
        switch (intExtra) {
            case 1:
            case 2:
                vVar = new com.vivo.push.b.t(intExtra);
                break;
            case 3:
                vVar = new com.vivo.push.b.o();
                break;
            case 4:
                vVar = new com.vivo.push.b.q();
                break;
            case 5:
                vVar = new com.vivo.push.b.p();
                break;
            case 6:
                vVar = new com.vivo.push.b.r();
                break;
            case 7:
                vVar = new com.vivo.push.b.n();
                break;
            case 8:
                vVar = new com.vivo.push.b.m();
                break;
            case 9:
                vVar = new com.vivo.push.b.l();
                break;
            case 10:
            case 11:
                vVar = new com.vivo.push.b.j(intExtra);
                break;
            case 12:
                vVar = new com.vivo.push.b.k();
                break;
            case 20:
                vVar = new com.vivo.push.b.u();
                break;
        }
        if (vVar != null) {
            vVar.c(intent);
        }
        return vVar;
    }

    @Override // com.vivo.push.IPushClientFactory
    public final s createTask(v vVar) {
        return ah.a(vVar);
    }

    @Override // com.vivo.push.IPushClientFactory
    public final aa createReceiveTask(v vVar) {
        return ah.b(vVar);
    }
}
