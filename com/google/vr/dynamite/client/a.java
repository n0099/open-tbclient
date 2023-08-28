package com.google.vr.dynamite.client;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.baidu.tieba.xrb;
/* loaded from: classes9.dex */
public final class a extends com.google.a.a.a implements ILoadedInstanceCreator {
    public a(IBinder iBinder) {
        super(iBinder, "com.google.vr.dynamite.client.ILoadedInstanceCreator");
    }

    @Override // com.google.vr.dynamite.client.ILoadedInstanceCreator
    public final INativeLibraryLoader newNativeLibraryLoader(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) {
        INativeLibraryLoader bVar;
        Parcel a = a();
        xrb.b(a, iObjectWrapper);
        xrb.b(a, iObjectWrapper2);
        Parcel a2 = a(1, a);
        IBinder readStrongBinder = a2.readStrongBinder();
        if (readStrongBinder == null) {
            bVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.vr.dynamite.client.INativeLibraryLoader");
            if (queryLocalInterface instanceof INativeLibraryLoader) {
                bVar = (INativeLibraryLoader) queryLocalInterface;
            } else {
                bVar = new b(readStrongBinder);
            }
        }
        a2.recycle();
        return bVar;
    }
}
