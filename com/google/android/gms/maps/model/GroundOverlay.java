package com.google.android.gms.maps.model;

import android.os.RemoteException;
import com.google.android.gms.internal.dl;
/* loaded from: classes.dex */
public final class GroundOverlay {
    private final dl a;

    public boolean equals(Object obj) {
        if (obj instanceof GroundOverlay) {
            try {
                return this.a.a(((GroundOverlay) obj).a);
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
