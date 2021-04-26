package d.a.g0.o;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.baidu.sso.n.a;
/* loaded from: classes2.dex */
public final class c implements ServiceConnection {

    /* renamed from: e  reason: collision with root package name */
    public a f40996e;

    public c(a aVar) {
        this.f40996e = aVar;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f40996e.f40989a = a.AbstractBinderC0162a.a(iBinder);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this.f40996e.f40989a = null;
    }
}
