package com.google.android.gms.maps;

import android.os.RemoteException;
import com.google.android.gms.internal.x;
import com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.RuntimeRemoteException;
/* loaded from: classes.dex */
public final class CameraUpdateFactory {
    private static ICameraUpdateFactoryDelegate a;

    private CameraUpdateFactory() {
    }

    public static CameraUpdate a(float f) {
        try {
            return new CameraUpdate(a().a(f));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public static CameraUpdate a(CameraPosition cameraPosition) {
        try {
            return new CameraUpdate(a().a(cameraPosition));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    private static ICameraUpdateFactoryDelegate a() {
        return (ICameraUpdateFactoryDelegate) x.a(a, "CameraUpdateFactory is not initialized");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(ICameraUpdateFactoryDelegate iCameraUpdateFactoryDelegate) {
        if (a != null) {
            return;
        }
        a = (ICameraUpdateFactoryDelegate) x.a(iCameraUpdateFactoryDelegate);
    }
}
