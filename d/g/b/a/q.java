package d.g.b.a;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.RemoteException;
import android.util.Log;
import com.google.ar.core.x;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public final class q implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Activity f66082e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ m f66083f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ l f66084g;

    public q(l lVar, Activity activity, m mVar) {
        this.f66084g = lVar;
        this.f66082e = activity;
        this.f66083f = mVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.google.a.b.a.a.a.a aVar;
        Bundle l;
        try {
            AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            aVar = this.f66084g.f66069d;
            String str = this.f66082e.getApplicationInfo().packageName;
            l lVar = this.f66084g;
            l = l.l();
            aVar.a(str, Collections.singletonList(l), new Bundle(), new x(this, atomicBoolean));
            new Handler().postDelayed(new r(this, atomicBoolean), 3000L);
        } catch (RemoteException e2) {
            Log.w("ARCore-InstallService", "requestInstall threw, launching fullscreen.", e2);
            l lVar2 = this.f66084g;
            l.n(this.f66082e, this.f66083f);
        }
    }
}
