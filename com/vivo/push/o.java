package com.vivo.push;

import android.content.Intent;
import com.vivo.push.c.ab;
import com.vivo.push.c.ai;
/* loaded from: classes7.dex */
public final class o implements IPushClientFactory {

    /* renamed from: a  reason: collision with root package name */
    public ai f40435a = new ai();

    @Override // com.vivo.push.IPushClientFactory
    public final ab createReceiveTask(y yVar) {
        return ai.b(yVar);
    }

    @Override // com.vivo.push.IPushClientFactory
    public final y createReceiverCommand(Intent intent) {
        y wVar;
        y vVar;
        int intExtra = intent.getIntExtra("command", -1);
        if (intExtra < 0) {
            intExtra = intent.getIntExtra("method", -1);
        }
        if (intExtra == 20) {
            wVar = new com.vivo.push.b.w();
        } else if (intExtra != 2016) {
            switch (intExtra) {
                case 1:
                case 2:
                    vVar = new com.vivo.push.b.v(intExtra);
                    wVar = vVar;
                    break;
                case 3:
                    wVar = new com.vivo.push.b.q();
                    break;
                case 4:
                    wVar = new com.vivo.push.b.s();
                    break;
                case 5:
                    wVar = new com.vivo.push.b.r();
                    break;
                case 6:
                    wVar = new com.vivo.push.b.t();
                    break;
                case 7:
                    wVar = new com.vivo.push.b.p();
                    break;
                case 8:
                    wVar = new com.vivo.push.b.o();
                    break;
                case 9:
                    wVar = new com.vivo.push.b.m();
                    break;
                case 10:
                case 11:
                    vVar = new com.vivo.push.b.k(intExtra);
                    wVar = vVar;
                    break;
                case 12:
                    wVar = new com.vivo.push.b.l();
                    break;
                default:
                    wVar = null;
                    break;
            }
        } else {
            wVar = new com.vivo.push.b.n();
        }
        if (wVar != null) {
            a a2 = a.a(intent);
            if (a2 == null) {
                com.vivo.push.util.p.b("PushCommand", "bundleWapper is null");
            } else {
                wVar.b(a2);
            }
        }
        return wVar;
    }

    @Override // com.vivo.push.IPushClientFactory
    public final v createTask(y yVar) {
        return ai.a(yVar);
    }
}
