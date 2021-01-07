package com.kwai.filedownloader;

import android.os.IBinder;
import android.os.RemoteException;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwai.filedownloader.c.a;
import com.kwai.filedownloader.c.b;
import com.kwai.filedownloader.message.MessageSnapshot;
import com.kwai.filedownloader.services.FileDownloadServiceProxy;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class o extends com.kwai.filedownloader.services.a<a, com.kwai.filedownloader.c.b> {

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes5.dex */
    public static class a extends a.AbstractBinderC1169a {
        protected a() {
        }

        @Override // com.kwai.filedownloader.c.a
        public void a(MessageSnapshot messageSnapshot) {
            com.kwai.filedownloader.message.e.a().a(messageSnapshot);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public o() {
        super(KsAdSDKImpl.getProxyRealClass(FileDownloadServiceProxy.SeparateProcessServiceProxy.class));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwai.filedownloader.services.a
    /* renamed from: a */
    public com.kwai.filedownloader.c.b b(IBinder iBinder) {
        return b.a.a(iBinder);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwai.filedownloader.services.a
    /* renamed from: a */
    public a b() {
        return new a();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwai.filedownloader.services.a
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public void b(com.kwai.filedownloader.c.b bVar, a aVar) {
        bVar.a(aVar);
    }

    @Override // com.kwai.filedownloader.t
    public boolean a(int i) {
        if (c()) {
            try {
                return d().a(i);
            } catch (RemoteException e) {
                e.printStackTrace();
                return false;
            }
        }
        return com.kwai.filedownloader.f.a.a(i);
    }

    @Override // com.kwai.filedownloader.t
    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, boolean z2, com.kwai.filedownloader.d.b bVar, boolean z3) {
        if (c()) {
            try {
                d().a(str, str2, z, i, i2, i3, z2, bVar, z3);
                return true;
            } catch (RemoteException e) {
                e.printStackTrace();
                return false;
            }
        }
        return com.kwai.filedownloader.f.a.a(str, str2, z);
    }

    @Override // com.kwai.filedownloader.t
    public byte b(int i) {
        if (c()) {
            try {
                return d().e(i);
            } catch (RemoteException e) {
                e.printStackTrace();
                return (byte) 0;
            }
        }
        return com.kwai.filedownloader.f.a.b(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwai.filedownloader.services.a
    /* renamed from: b  reason: avoid collision after fix types in other method */
    public void a(com.kwai.filedownloader.c.b bVar, a aVar) {
        bVar.b(aVar);
    }

    @Override // com.kwai.filedownloader.t
    public boolean c(int i) {
        if (c()) {
            try {
                return d().f(i);
            } catch (RemoteException e) {
                e.printStackTrace();
                return false;
            }
        }
        return com.kwai.filedownloader.f.a.c(i);
    }
}
