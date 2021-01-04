package com.google.a.b.a.a.a;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;
/* loaded from: classes3.dex */
public abstract class e extends com.google.a.a.b implements d {
    public e() {
        super("com.google.android.play.core.install.protocol.IInstallServiceCallback");
    }

    @Override // com.google.a.a.b
    protected final boolean a(int i, Parcel parcel) throws RemoteException {
        switch (i) {
            case 1:
                a((Bundle) com.google.a.a.c.a(parcel, Bundle.CREATOR));
                break;
            case 2:
                b((Bundle) com.google.a.a.c.a(parcel, Bundle.CREATOR));
                break;
            case 3:
                com.google.a.a.c.a(parcel, Bundle.CREATOR);
                a();
                break;
            default:
                return false;
        }
        return true;
    }
}
