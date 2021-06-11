package d.a.j0.p;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.baidu.sso.o.a;
/* loaded from: classes2.dex */
public class c implements ServiceConnection {

    /* renamed from: e  reason: collision with root package name */
    public a f44179e;

    public c(a aVar) {
        this.f44179e = aVar;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f44179e.f44172a = a.AbstractBinderC0148a.a(iBinder);
        d.a.j0.n.b bVar = this.f44179e.f44176e;
        if (bVar != null) {
            bVar.a();
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        a aVar = this.f44179e;
        aVar.f44172a = null;
        d.a.j0.n.b bVar = aVar.f44176e;
        if (bVar != null) {
            bVar.a();
        }
    }
}
