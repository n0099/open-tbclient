package com.google.ar.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class ac extends BroadcastReceiver {
    private final /* synthetic */ y a;
    private final /* synthetic */ w b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(w wVar, y yVar) {
        this.b = wVar;
        this.a = yVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        Bundle extras = intent.getExtras();
        if (!"com.google.android.play.core.install.ACTION_INSTALL_STATUS".equals(action) || extras == null || !extras.containsKey("install.status")) {
            return;
        }
        this.b.c();
        switch (extras.getInt("install.status")) {
            case 1:
            case 2:
            case 3:
                this.a.a(p.ACCEPTED);
                return;
            case 4:
                this.a.a(p.COMPLETED);
                return;
            case 5:
            default:
                return;
            case 6:
                this.a.a(p.CANCELLED);
                return;
        }
    }
}
