package com.google.android.gms.maps.model;

import android.os.RemoteException;
import com.google.android.gms.internal.dm;
import com.google.android.gms.internal.x;
/* loaded from: classes.dex */
public final class Marker {
    private final dm a;

    public Marker(dm dmVar) {
        this.a = (dm) x.a(dmVar);
    }

    public LatLng a() {
        try {
            return this.a.c();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean equals(Object obj) {
        if (obj instanceof Marker) {
            try {
                return this.a.a(((Marker) obj).a);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        return false;
    }

    public int hashCode() {
        try {
            return this.a.k();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
