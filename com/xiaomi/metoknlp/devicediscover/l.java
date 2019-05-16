package com.xiaomi.metoknlp.devicediscover;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class l extends BroadcastReceiver {
    final /* synthetic */ g a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(g gVar) {
        this.a = gVar;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        o oVar;
        o oVar2;
        o oVar3;
        o oVar4;
        if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
            oVar = this.a.h;
            if (oVar.hasMessages(1)) {
                oVar4 = this.a.h;
                oVar4.removeMessages(1);
            }
            oVar2 = this.a.h;
            Message obtainMessage = oVar2.obtainMessage(1);
            oVar3 = this.a.h;
            oVar3.sendMessageDelayed(obtainMessage, 10000L);
        }
    }
}
