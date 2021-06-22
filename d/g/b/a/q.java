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
    public final /* synthetic */ Activity f70053e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ m f70054f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ l f70055g;

    public q(l lVar, Activity activity, m mVar) {
        this.f70055g = lVar;
        this.f70053e = activity;
        this.f70054f = mVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.google.a.b.a.a.a.a aVar;
        Bundle l;
        try {
            AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            aVar = this.f70055g.f70040d;
            String str = this.f70053e.getApplicationInfo().packageName;
            l lVar = this.f70055g;
            l = l.l();
            aVar.a(str, Collections.singletonList(l), new Bundle(), new x(this, atomicBoolean));
            new Handler().postDelayed(new r(this, atomicBoolean), 3000L);
        } catch (RemoteException e2) {
            Log.w("ARCore-InstallService", "requestInstall threw, launching fullscreen.", e2);
            l lVar2 = this.f70055g;
            l.n(this.f70053e, this.f70054f);
        }
    }
}
