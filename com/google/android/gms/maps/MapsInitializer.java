package com.google.android.gms.maps;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.internal.cl;
import com.google.android.gms.internal.cw;
import com.google.android.gms.internal.x;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.RuntimeRemoteException;
/* loaded from: classes.dex */
public final class MapsInitializer {
    private MapsInitializer() {
    }

    public static void a(Context context) {
        x.a(context);
        cl a = cw.a(context);
        try {
            CameraUpdateFactory.a(a.a());
            BitmapDescriptorFactory.a(a.b());
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
