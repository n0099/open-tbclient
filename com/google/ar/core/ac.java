package com.google.ar.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes17.dex */
public final class ac extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ y f4041a;
    private final /* synthetic */ w b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(w wVar, y yVar) {
        this.b = wVar;
        this.f4041a = yVar;
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
                this.f4041a.a(p.ACCEPTED);
                return;
            case 4:
                this.f4041a.a(p.COMPLETED);
                return;
            case 5:
            default:
                return;
            case 6:
                this.f4041a.a(p.CANCELLED);
                return;
        }
    }
}
