package com.heytap.mcssdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import com.heytap.mcssdk.utils.LogUtil;
import com.mcs.aidl.IMcsSdkService;
/* loaded from: classes6.dex */
public final class d implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Intent f32338a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PushManager f32339b;

    public d(PushManager pushManager, Intent intent) {
        this.f32339b = pushManager;
        this.f32338a = intent;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Context context;
        Bundle bundle = new Bundle();
        bundle.putAll(this.f32338a.getExtras());
        try {
            IMcsSdkService.Stub.asInterface(iBinder).process(bundle);
        } catch (Exception e2) {
            LogUtil.d("bindMcsService exception:" + e2);
        }
        context = this.f32339b.mContext;
        context.unbindService(this);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
    }
}
