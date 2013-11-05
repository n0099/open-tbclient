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

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bu f388a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bv(bu buVar) {
        this.f388a = buVar;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        ServiceConnection serviceConnection;
        RemoteSSO a2 = RemoteSSO.Stub.a(iBinder);
        try {
            this.f388a.e = a2.a();
            this.f388a.f = a2.b();
            if (!this.f388a.b()) {
                this.f388a.g();
            }
        } catch (RemoteException e) {
            this.f388a.g();
        } finally {
            Context applicationContext = this.f388a.f395a.getApplicationContext();
            serviceConnection = this.f388a.g;
            applicationContext.unbindService(serviceConnection);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        SessionManager.Session session = SessionManager.getInstance(this.f388a.f395a).get(MediaType.SINAWEIBO.toString());
        if (session == null || session.isExpired()) {
            this.f388a.g();
        }
    }
}
