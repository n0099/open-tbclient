package com.google.android.gms.maps.model;

import android.graphics.Bitmap;
import android.os.RemoteException;
import com.google.android.gms.internal.dj;
import com.google.android.gms.internal.x;
/* loaded from: classes.dex */
public final class BitmapDescriptorFactory {
    private static dj a;

    private BitmapDescriptorFactory() {
    }

    private static dj a() {
        return (dj) x.a(a, "IBitmapDescriptorFactory is not initialized");
    }

    public static BitmapDescriptor a(Bitmap bitmap) {
        try {
            return new BitmapDescriptor(a().a(bitmap));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public static void a(dj djVar) {
        if (a != null) {
            return;
        }
        a = (dj) x.a(djVar);
    }
}
