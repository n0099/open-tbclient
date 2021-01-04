package com.yxcorp.kuaishou.addfp.a.b.c;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
/* loaded from: classes5.dex */
public abstract class b extends Binder implements a {
    public static a a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.zui.deviceidservice.IDeviceidInterface");
        return (queryLocalInterface == null || !(queryLocalInterface instanceof a)) ? new c(iBinder) : (a) queryLocalInterface;
    }
}
