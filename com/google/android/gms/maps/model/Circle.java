package com.google.android.gms.maps.model;

import android.os.RemoteException;
import com.google.android.gms.internal.dk;
/* loaded from: classes.dex */
public final class Circle {
    private final dk a;

    public boolean equals(Object obj) {
        if (obj instanceof Circle) {
            try {
                return this.a.a(((Circle) obj).a);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        return false;
    }

    public int hashCode() {
        try {
            return this.a.j();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
