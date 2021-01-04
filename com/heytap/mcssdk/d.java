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
/* loaded from: classes5.dex */
public final class d implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Intent f8196a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ PushManager f8197b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(PushManager pushManager, Intent intent) {
        this.f8197b = pushManager;
        this.f8196a = intent;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Context context;
        Bundle bundle = new Bundle();
        bundle.putAll(this.f8196a.getExtras());
        try {
            IMcsSdkService.Stub.asInterface(iBinder).process(bundle);
        } catch (Exception e) {
            LogUtil.d("bindMcsService exception:" + e);
        }
        context = this.f8197b.mContext;
        context.unbindService(this);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
    }
}
