package d.b.f0.o;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.baidu.sso.n.a;
/* loaded from: classes3.dex */
public final class c implements ServiceConnection {

    /* renamed from: e  reason: collision with root package name */
    public a f43049e;

    public c(a aVar) {
        this.f43049e = aVar;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f43049e.f43042a = a.AbstractBinderC0163a.a(iBinder);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this.f43049e.f43042a = null;
    }
}
