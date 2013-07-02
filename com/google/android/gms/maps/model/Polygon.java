package com.google.android.gms.maps.model;

import android.os.RemoteException;
import com.google.android.gms.internal.dn;
/* loaded from: classes.dex */
public final class Polygon {
    private final dn a;

    public boolean equals(Object obj) {
        if (obj instanceof Polygon) {
            try {
                return this.a.a(((Polygon) obj).a);
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
