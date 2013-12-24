package defpackage;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.baidu.cloudsdk.social.core.MediaType;
import com.baidu.cloudsdk.social.core.SessionManager;
import com.sina.sso.RemoteSSO;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: bv  reason: default package */
/* loaded from: classes.dex */
public class bv implements ServiceConnection {
    final /* synthetic */ bu a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bv(bu buVar) {
        this.a = buVar;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        ServiceConnection serviceConnection;
        RemoteSSO a = RemoteSSO.Stub.a(iBinder);
        try {
            this.a.e = a.a();
            this.a.f = a.b();
            if (!this.a.b()) {
                this.a.g();
            }
        } catch (RemoteException e) {
            this.a.g();
        } finally {
            Context applicationContext = this.a.a.getApplicationContext();
            serviceConnection = this.a.g;
            applicationContext.unbindService(serviceConnection);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        SessionManager.Session session = SessionManager.getInstance(this.a.a).get(MediaType.SINAWEIBO.toString());
        if (session == null || session.isExpired()) {
            this.a.g();
        }
    }
}
