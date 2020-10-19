package com.google.a.b.a.a.a;

import android.os.IBinder;
import android.os.IInterface;
/* loaded from: classes11.dex */
public abstract class b extends com.google.a.a.b implements a {
    public static a a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.play.core.install.protocol.IInstallService");
        if (queryLocalInterface instanceof a) {
            return (a) queryLocalInterface;
        }
        return new c(iBinder);
    }
}
