package d.b.g0.o;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.baidu.sso.n.a;
/* loaded from: classes2.dex */
public final class c implements ServiceConnection {

    /* renamed from: e  reason: collision with root package name */
    public a f43739e;

    public c(a aVar) {
        this.f43739e = aVar;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f43739e.f43732a = a.AbstractBinderC0167a.a(iBinder);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this.f43739e.f43732a = null;
    }
}
