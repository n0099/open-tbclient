package d.a.k0.p;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.baidu.sso.o.a;
/* loaded from: classes2.dex */
public class c implements ServiceConnection {

    /* renamed from: e  reason: collision with root package name */
    public a f44319e;

    public c(a aVar) {
        this.f44319e = aVar;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f44319e.f44312a = a.AbstractBinderC0151a.a(iBinder);
        d.a.k0.n.b bVar = this.f44319e.f44316e;
        if (bVar != null) {
            bVar.a();
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        a aVar = this.f44319e;
        aVar.f44312a = null;
        d.a.k0.n.b bVar = aVar.f44316e;
        if (bVar != null) {
            bVar.a();
        }
    }
}
