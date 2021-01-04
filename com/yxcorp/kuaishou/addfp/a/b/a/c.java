package com.yxcorp.kuaishou.addfp.a.b.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
/* loaded from: classes5.dex */
public abstract class c extends Binder implements b {
    public static b a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.asus.msa.SupplementaryDID.IDidAidlInterface");
        return (queryLocalInterface == null || !(queryLocalInterface instanceof b)) ? new d(iBinder) : (b) queryLocalInterface;
    }
}
