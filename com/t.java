package com;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.baidu.cloudsdk.social.core.MediaType;
import com.baidu.cloudsdk.social.core.SessionManager;
import com.sina.sso.RemoteSSO;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements ServiceConnection {
    final /* synthetic */ s a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(s sVar) {
        this.a = sVar;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        ServiceConnection serviceConnection;
        RemoteSSO asInterface = RemoteSSO.Stub.asInterface(iBinder);
        try {
            this.a.f = asInterface.getPackageName();
            this.a.g = asInterface.getActivityName();
            if (!this.a.g()) {
                this.a.f();
            }
        } catch (RemoteException e) {
            this.a.f();
        } finally {
            Context applicationContext = this.a.a.getApplicationContext();
            serviceConnection = this.a.h;
            applicationContext.unbindService(serviceConnection);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        SessionManager.Session session = SessionManager.getInstance(this.a.a).get(MediaType.SINAWEIBO.toString());
        if (session == null || session.isExpired()) {
            this.a.f();
        }
    }
}
