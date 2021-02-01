package com.google.ar.core;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public final class z implements ServiceConnection {
    private final /* synthetic */ w pRO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(w wVar) {
        this.pRO = wVar;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.pRO.a(iBinder);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this.pRO.d();
    }
}
