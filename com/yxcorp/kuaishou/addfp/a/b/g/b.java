package com.yxcorp.kuaishou.addfp.a.b.g;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
/* loaded from: classes3.dex */
public abstract class b extends Binder implements a {
    public static a a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.samsung.android.deviceidservice.IDeviceIdService");
        return (queryLocalInterface == null || !(queryLocalInterface instanceof a)) ? new c(iBinder) : (a) queryLocalInterface;
    }
}
