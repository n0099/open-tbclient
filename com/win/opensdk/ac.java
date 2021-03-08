package com.win.opensdk;

import android.os.Handler;
import android.os.Message;
/* loaded from: classes14.dex */
public class ac extends Handler {
    public final /* synthetic */ af qkG;

    public ac(af afVar, aj ajVar) {
        this.qkG = afVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        this.qkG.a(message);
    }
}
