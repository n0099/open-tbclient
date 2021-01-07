package com.google.ar.core;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class z implements ServiceConnection {
    private final /* synthetic */ w pMj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(w wVar) {
        this.pMj = wVar;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.pMj.a(iBinder);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this.pMj.d();
    }
}
