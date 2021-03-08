package com.win.opensdk;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.mapapi.UIMsg;
/* loaded from: classes14.dex */
public class dz extends Handler {
    public final /* synthetic */ ek qmc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dz(ek ekVar, Looper looper) {
        super(looper);
        this.qmc = ekVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (message.what == 1101) {
            this.qmc.e.removeMessages(UIMsg.f_FUN.FUN_ID_SCH_POI);
            ek ekVar = this.qmc;
            if (!ekVar.b && ekVar.a(ekVar.f8162a)) {
                eg egVar = this.qmc.qmj;
                if (egVar != null) {
                    egVar.a();
                }
                this.qmc.b = true;
                return;
            }
            this.qmc.e.sendEmptyMessageDelayed(UIMsg.f_FUN.FUN_ID_SCH_POI, 300L);
        }
    }
}
