package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.IInterface;
/* loaded from: classes9.dex */
public abstract class zzae extends com.google.android.gms.internal.common.zzb implements zzaf {
    public static zzaf zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGoogleCertificatesApi");
        if (queryLocalInterface instanceof zzaf) {
            return (zzaf) queryLocalInterface;
        }
        return new zzad(iBinder);
    }
}
