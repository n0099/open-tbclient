package com.google.ar.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class ac extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ y f8152a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ w f8153b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(w wVar, y yVar) {
        this.f8153b = wVar;
        this.f8152a = yVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        Bundle extras = intent.getExtras();
        if (!"com.google.android.play.core.install.ACTION_INSTALL_STATUS".equals(action) || extras == null || !extras.containsKey("install.status")) {
            return;
        }
        this.f8153b.c();
        switch (extras.getInt("install.status")) {
            case 1:
            case 2:
            case 3:
                this.f8152a.a(p.ACCEPTED);
                return;
            case 4:
                this.f8152a.a(p.COMPLETED);
                return;
            case 5:
            default:
                return;
            case 6:
                this.f8152a.a(p.CANCELLED);
                return;
        }
    }
}
