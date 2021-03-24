package com.google.ar.core;

import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import com.google.ar.core.ArCoreApk;
import d.g.b.a.o;
/* loaded from: classes6.dex */
public final class u extends com.google.a.b.a.a.a.e {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ o f30902a;

    public u(o oVar) {
        this.f30902a = oVar;
    }

    @Override // com.google.a.b.a.a.a.d
    public final void a() throws RemoteException {
    }

    @Override // com.google.a.b.a.a.a.d
    public final void a(Bundle bundle) throws RemoteException {
    }

    @Override // com.google.a.b.a.a.a.d
    public final void b(Bundle bundle) throws RemoteException {
        int i = bundle.getInt("error.code", -100);
        if (i == -5) {
            Log.e("ARCore-InstallService", "The device is not supported.");
            this.f30902a.f66077f.a(ArCoreApk.Availability.UNSUPPORTED_DEVICE_NOT_CAPABLE);
        } else if (i == -3) {
            Log.e("ARCore-InstallService", "The Google Play application must be updated.");
            this.f30902a.f66077f.a(ArCoreApk.Availability.UNKNOWN_ERROR);
        } else if (i != 0) {
            StringBuilder sb = new StringBuilder(33);
            sb.append("requestInfo returned: ");
            sb.append(i);
            Log.e("ARCore-InstallService", sb.toString());
            this.f30902a.f66077f.a(ArCoreApk.Availability.UNKNOWN_ERROR);
        } else {
            this.f30902a.f66077f.a(ArCoreApk.Availability.SUPPORTED_NOT_INSTALLED);
        }
    }
}
