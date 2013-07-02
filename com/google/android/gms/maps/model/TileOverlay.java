package com.google.android.gms.maps.model;

import android.os.RemoteException;
import com.google.android.gms.internal.Cdo;
/* loaded from: classes.dex */
public final class TileOverlay {
    private final Cdo a;

    public boolean equals(Object obj) {
        if (obj instanceof TileOverlay) {
            try {
                return this.a.a(((TileOverlay) obj).a);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        return false;
    }

    public int hashCode() {
        try {
            return this.a.f();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
