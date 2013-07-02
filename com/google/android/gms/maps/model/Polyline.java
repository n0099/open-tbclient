package com.google.android.gms.maps.model;

import android.os.RemoteException;
import com.google.android.gms.maps.model.internal.IPolylineDelegate;
/* loaded from: classes.dex */
public final class Polyline {
    private final IPolylineDelegate a;

    public boolean equals(Object obj) {
        if (obj instanceof Polyline) {
            try {
                return this.a.a(((Polyline) obj).a);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        return false;
    }

    public int hashCode() {
        try {
            return this.a.i();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
