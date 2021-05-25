package d.a.j0.o;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.baidu.sso.n.a;
/* loaded from: classes2.dex */
public final class c implements ServiceConnection {

    /* renamed from: e  reason: collision with root package name */
    public a f40502e;

    public c(a aVar) {
        this.f40502e = aVar;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f40502e.f40495a = a.AbstractBinderC0148a.a(iBinder);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this.f40502e.f40495a = null;
    }
}
