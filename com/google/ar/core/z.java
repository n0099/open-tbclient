package com.google.ar.core;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes14.dex */
public final class z implements ServiceConnection {
    private final /* synthetic */ w pTd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(w wVar) {
        this.pTd = wVar;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.pTd.a(iBinder);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this.pTd.d();
    }
}
