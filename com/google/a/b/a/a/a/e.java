package com.google.a.b.a.a.a;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;
/* loaded from: classes6.dex */
public abstract class e extends com.google.a.a.b implements d {
    public e() {
        super("com.google.android.play.core.install.protocol.IInstallServiceCallback");
    }

    @Override // com.google.a.a.b
    public final boolean a(int i2, Parcel parcel) throws RemoteException {
        if (i2 == 1) {
            a((Bundle) d.g.a.a.a.a(parcel, Bundle.CREATOR));
        } else if (i2 == 2) {
            b((Bundle) d.g.a.a.a.a(parcel, Bundle.CREATOR));
        } else if (i2 != 3) {
            return false;
        } else {
            d.g.a.a.a.a(parcel, Bundle.CREATOR);
            a();
        }
        return true;
    }
}
