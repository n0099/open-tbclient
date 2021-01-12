package com.heytap.mcssdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import com.heytap.mcssdk.utils.LogUtil;
import com.mcs.aidl.IMcsSdkService;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class d implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Intent f7897a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ PushManager f7898b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(PushManager pushManager, Intent intent) {
        this.f7898b = pushManager;
        this.f7897a = intent;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Context context;
        Bundle bundle = new Bundle();
        bundle.putAll(this.f7897a.getExtras());
        try {
            IMcsSdkService.Stub.asInterface(iBinder).process(bundle);
        } catch (Exception e) {
            LogUtil.d("bindMcsService exception:" + e);
        }
        context = this.f7898b.mContext;
        context.unbindService(this);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
    }
}
