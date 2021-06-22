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
    public final /* synthetic */ Context f70048e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ ArCoreApk.a f70049f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ l f70050g;

    public o(l lVar, Context context, ArCoreApk.a aVar) {
        this.f70050g = lVar;
        this.f70048e = context;
        this.f70049f = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.google.a.b.a.a.a.a aVar;
        Bundle l;
        try {
            aVar = this.f70050g.f70040d;
            String str = this.f70048e.getApplicationInfo().packageName;
            l lVar = this.f70050g;
            l = l.l();
            aVar.a(str, l, new u(this));
        } catch (RemoteException e2) {
            Log.e("ARCore-InstallService", "requestInfo threw", e2);
            this.f70049f.a(ArCoreApk.Availability.UNKNOWN_ERROR);
        }
    }
}
