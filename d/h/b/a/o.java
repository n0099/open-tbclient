package d.h.b.a;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import com.google.ar.core.ArCoreApk;
import com.google.ar.core.u;
/* loaded from: classes6.dex */
public final class o implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Context f67069e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ ArCoreApk.a f67070f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ l f67071g;

    public o(l lVar, Context context, ArCoreApk.a aVar) {
        this.f67071g = lVar;
        this.f67069e = context;
        this.f67070f = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.google.a.b.a.a.a.a aVar;
        Bundle l;
        try {
            aVar = this.f67071g.f67061d;
            String str = this.f67069e.getApplicationInfo().packageName;
            l lVar = this.f67071g;
            l = l.l();
            aVar.a(str, l, new u(this));
        } catch (RemoteException e2) {
            Log.e("ARCore-InstallService", "requestInfo threw", e2);
            this.f67070f.a(ArCoreApk.Availability.UNKNOWN_ERROR);
        }
    }
}
