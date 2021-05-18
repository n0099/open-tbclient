package com.google.a.b.a.a.a;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import java.util.List;
/* loaded from: classes6.dex */
public final class c extends com.google.a.a.a implements a {
    public c(IBinder iBinder) {
        super(iBinder, "com.google.android.play.core.install.protocol.IInstallService");
    }

    @Override // com.google.a.b.a.a.a.a
    public final void a(String str, List<Bundle> list, Bundle bundle, d dVar) {
        Parcel a2 = a();
        a2.writeString(str);
        a2.writeTypedList(list);
        d.g.a.a.a.c(a2, bundle);
        d.g.a.a.a.b(a2, dVar);
        b(1, a2);
    }

    @Override // com.google.a.b.a.a.a.a
    public final void a(String str, Bundle bundle, d dVar) {
        Parcel a2 = a();
        a2.writeString(str);
        d.g.a.a.a.c(a2, bundle);
        d.g.a.a.a.b(a2, dVar);
        b(2, a2);
    }
}
