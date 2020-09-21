package com.google.a.b.a.a.a;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;
/* loaded from: classes24.dex */
public final class c extends com.google.a.a.a implements a {
    /* JADX INFO: Access modifiers changed from: package-private */
    public c(IBinder iBinder) {
        super(iBinder, "com.google.android.play.core.install.protocol.IInstallService");
    }

    @Override // com.google.a.b.a.a.a.a
    public final void a(String str, List<Bundle> list, Bundle bundle, d dVar) throws RemoteException {
        Parcel a = a();
        a.writeString(str);
        a.writeTypedList(list);
        com.google.a.a.c.a(a, bundle);
        com.google.a.a.c.a(a, dVar);
        b(1, a);
    }

    @Override // com.google.a.b.a.a.a.a
    public final void a(String str, Bundle bundle, d dVar) throws RemoteException {
        Parcel a = a();
        a.writeString(str);
        com.google.a.a.c.a(a, bundle);
        com.google.a.a.c.a(a, dVar);
        b(2, a);
    }
}
