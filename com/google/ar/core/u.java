package com.google.ar.core;

import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import com.google.ar.core.ArCoreApk;
/* loaded from: classes5.dex */
final class u extends com.google.a.b.a.a.a.e {
    private final /* synthetic */ aa a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(aa aaVar) {
        this.a = aaVar;
    }

    @Override // com.google.a.b.a.a.a.d
    public final void b(Bundle bundle) throws RemoteException {
        int i = bundle.getInt("error.code", -100);
        switch (i) {
            case -5:
                Log.e("ARCore-InstallService", "The device is not supported.");
                this.a.niH.a(ArCoreApk.Availability.UNSUPPORTED_DEVICE_NOT_CAPABLE);
                return;
            case -4:
            case -2:
            case -1:
            default:
                Log.e("ARCore-InstallService", new StringBuilder(33).append("requestInfo returned: ").append(i).toString());
                this.a.niH.a(ArCoreApk.Availability.UNKNOWN_ERROR);
                return;
            case -3:
                Log.e("ARCore-InstallService", "The Google Play application must be updated.");
                this.a.niH.a(ArCoreApk.Availability.UNKNOWN_ERROR);
                return;
            case 0:
                this.a.niH.a(ArCoreApk.Availability.SUPPORTED_NOT_INSTALLED);
                return;
        }
    }

    @Override // com.google.a.b.a.a.a.d
    public final void a(Bundle bundle) throws RemoteException {
    }

    @Override // com.google.a.b.a.a.a.d
    public final void a() throws RemoteException {
    }
}
