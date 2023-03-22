package com.google.ar.core;

import android.os.Bundle;
import android.util.Log;
import com.baidu.tieba.dja;
import com.google.ar.core.ArCoreApk;
/* loaded from: classes8.dex */
public final class u extends com.google.a.b.a.a.a.e {
    public final /* synthetic */ dja a;

    @Override // com.google.a.b.a.a.a.d
    public final void a() {
    }

    @Override // com.google.a.b.a.a.a.d
    public final void a(Bundle bundle) {
    }

    public u(dja djaVar) {
        this.a = djaVar;
    }

    @Override // com.google.a.b.a.a.a.d
    public final void b(Bundle bundle) {
        int i = bundle.getInt("error.code", -100);
        if (i != -5) {
            if (i != -3) {
                if (i != 0) {
                    StringBuilder sb = new StringBuilder(33);
                    sb.append("requestInfo returned: ");
                    sb.append(i);
                    Log.e("ARCore-InstallService", sb.toString());
                    this.a.b.a(ArCoreApk.Availability.UNKNOWN_ERROR);
                    return;
                }
                this.a.b.a(ArCoreApk.Availability.SUPPORTED_NOT_INSTALLED);
                return;
            }
            Log.e("ARCore-InstallService", "The Google Play application must be updated.");
            this.a.b.a(ArCoreApk.Availability.UNKNOWN_ERROR);
            return;
        }
        Log.e("ARCore-InstallService", "The device is not supported.");
        this.a.b.a(ArCoreApk.Availability.UNSUPPORTED_DEVICE_NOT_CAPABLE);
    }
}
