package d.g.b.a;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
/* loaded from: classes6.dex */
public final class n implements ServiceConnection {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ l f66212e;

    public n(l lVar) {
        this.f66212e = lVar;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f66212e.f(iBinder);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this.f66212e.q();
    }
}
