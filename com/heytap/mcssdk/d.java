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
/* loaded from: classes15.dex */
public final class d implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Intent f4055a;
    final /* synthetic */ PushManager b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(PushManager pushManager, Intent intent) {
        this.b = pushManager;
        this.f4055a = intent;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Context context;
        Bundle bundle = new Bundle();
        bundle.putAll(this.f4055a.getExtras());
        try {
            IMcsSdkService.Stub.asInterface(iBinder).process(bundle);
        } catch (Exception e) {
            LogUtil.d("bindMcsService exception:" + e);
        }
        context = this.b.mContext;
        context.unbindService(this);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
    }
}
