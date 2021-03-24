package d.g.b.a;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import com.google.ar.core.ArCoreApk;
import com.google.ar.core.u;
/* loaded from: classes6.dex */
public final class o implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Context f66076e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ ArCoreApk.a f66077f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ l f66078g;

    public o(l lVar, Context context, ArCoreApk.a aVar) {
        this.f66078g = lVar;
        this.f66076e = context;
        this.f66077f = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.google.a.b.a.a.a.a aVar;
        Bundle l;
        try {
            aVar = this.f66078g.f66068d;
            String str = this.f66076e.getApplicationInfo().packageName;
            l lVar = this.f66078g;
            l = l.l();
            aVar.a(str, l, new u(this));
        } catch (RemoteException e2) {
            Log.e("ARCore-InstallService", "requestInfo threw", e2);
            this.f66077f.a(ArCoreApk.Availability.UNKNOWN_ERROR);
        }
    }
}
