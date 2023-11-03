package com.google.a.b.a.a.a;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.baidu.tieba.m3c;
import java.util.List;
/* loaded from: classes9.dex */
public final class c extends com.google.a.a.a implements a {
    public c(IBinder iBinder) {
        super(iBinder, "com.google.android.play.core.install.protocol.IInstallService");
    }

    @Override // com.google.a.b.a.a.a.a
    public final void a(String str, Bundle bundle, d dVar) {
        Parcel a = a();
        a.writeString(str);
        m3c.c(a, bundle);
        m3c.b(a, dVar);
        b(2, a);
    }

    @Override // com.google.a.b.a.a.a.a
    public final void a(String str, List<Bundle> list, Bundle bundle, d dVar) {
        Parcel a = a();
        a.writeString(str);
        a.writeTypedList(list);
        m3c.c(a, bundle);
        m3c.b(a, dVar);
        b(1, a);
    }
}
