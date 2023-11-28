package com.kwad.framework.filedownloader;

import android.os.IBinder;
import android.os.RemoteException;
import com.kwad.framework.filedownloader.c.a;
import com.kwad.framework.filedownloader.c.b;
import com.kwad.framework.filedownloader.message.MessageSnapshot;
/* loaded from: classes10.dex */
public final class p extends com.kwad.framework.filedownloader.services.a<a, com.kwad.framework.filedownloader.c.b> {
    public p(Class<?> cls) {
        super(cls);
    }

    public static com.kwad.framework.filedownloader.c.b a(IBinder iBinder) {
        return b.a.a(iBinder);
    }

    @Override // com.kwad.framework.filedownloader.u
    public final boolean aY(int i) {
        if (!isConnected()) {
            return com.kwad.framework.filedownloader.f.a.aY(i);
        }
        try {
            return wg().aY(i);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.kwad.framework.filedownloader.u
    public final byte aZ(int i) {
        if (!isConnected()) {
            return com.kwad.framework.filedownloader.f.a.aZ(i);
        }
        try {
            return wg().aZ(i);
        } catch (RemoteException e) {
            e.printStackTrace();
            return (byte) 0;
        }
    }

    /* JADX DEBUG: Return type fixed from 'android.os.IInterface' to match base method */
    @Override // com.kwad.framework.filedownloader.services.a
    public final /* synthetic */ com.kwad.framework.filedownloader.c.b b(IBinder iBinder) {
        return a(iBinder);
    }

    @Override // com.kwad.framework.filedownloader.u
    public final boolean ba(int i) {
        if (!isConnected()) {
            return com.kwad.framework.filedownloader.f.a.ba(i);
        }
        try {
            return wg().ba(i);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    /* loaded from: classes10.dex */
    public static class a extends a.AbstractBinderC0680a {
        @Override // com.kwad.framework.filedownloader.c.a
        public final void q(MessageSnapshot messageSnapshot) {
            com.kwad.framework.filedownloader.message.e.vV().s(messageSnapshot);
        }
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(com.kwad.framework.filedownloader.c.b bVar, a aVar) {
        bVar.a(aVar);
    }

    public static a uG() {
        return new a();
    }

    /* JADX DEBUG: Return type fixed from 'android.os.Binder' to match base method */
    @Override // com.kwad.framework.filedownloader.services.a
    public final /* synthetic */ a uH() {
        return uG();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.os.IInterface, android.os.Binder] */
    @Override // com.kwad.framework.filedownloader.services.a
    public final /* bridge */ /* synthetic */ void a(com.kwad.framework.filedownloader.c.b bVar, a aVar) {
        a2(bVar, aVar);
    }

    @Override // com.kwad.framework.filedownloader.u
    public final boolean a(String str, String str2, boolean z, int i, int i2, int i3, boolean z2, com.kwad.framework.filedownloader.d.b bVar, boolean z3) {
        if (!isConnected()) {
            return com.kwad.framework.filedownloader.f.a.h(str, str2, z);
        }
        try {
            wg().b(str, str2, z, i, i2, i3, z2, bVar, z3);
            return true;
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }
}
