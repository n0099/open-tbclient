package com.vivo.push;

import android.content.Intent;
import com.vivo.push.c.ab;
import com.vivo.push.c.ai;
/* loaded from: classes11.dex */
public final class o implements IPushClientFactory {

    /* renamed from: a  reason: collision with root package name */
    private ai f4457a = new ai();

    @Override // com.vivo.push.IPushClientFactory
    public final y createReceiverCommand(Intent intent) {
        y yVar = null;
        int intExtra = intent.getIntExtra("command", -1);
        if (intExtra < 0) {
            intExtra = intent.getIntExtra("method", -1);
        }
        switch (intExtra) {
            case 1:
            case 2:
                yVar = new com.vivo.push.b.v(intExtra);
                break;
            case 3:
                yVar = new com.vivo.push.b.q();
                break;
            case 4:
                yVar = new com.vivo.push.b.s();
                break;
            case 5:
                yVar = new com.vivo.push.b.r();
                break;
            case 6:
                yVar = new com.vivo.push.b.t();
                break;
            case 7:
                yVar = new com.vivo.push.b.p();
                break;
            case 8:
                yVar = new com.vivo.push.b.o();
                break;
            case 9:
                yVar = new com.vivo.push.b.m();
                break;
            case 10:
            case 11:
                yVar = new com.vivo.push.b.k(intExtra);
                break;
            case 12:
                yVar = new com.vivo.push.b.l();
                break;
            case 20:
                yVar = new com.vivo.push.b.w();
                break;
            case 2016:
                yVar = new com.vivo.push.b.n();
                break;
        }
        if (yVar != null) {
            a a2 = a.a(intent);
            if (a2 == null) {
                com.vivo.push.util.p.b("PushCommand", "bundleWapper is null");
            } else {
                yVar.b(a2);
            }
        }
        return yVar;
    }

    @Override // com.vivo.push.IPushClientFactory
    public final v createTask(y yVar) {
        return ai.a(yVar);
    }

    @Override // com.vivo.push.IPushClientFactory
    public final ab createReceiveTask(y yVar) {
        return ai.b(yVar);
    }
}
