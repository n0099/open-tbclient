package com.kwad.framework.filedownloader.services;

import android.app.Notification;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.kwad.framework.filedownloader.c.b;
import com.kwad.framework.filedownloader.message.MessageSnapshot;
import com.kwad.framework.filedownloader.message.e;
import java.lang.ref.WeakReference;
/* loaded from: classes10.dex */
public final class d extends b.a implements e.b, i {
    public final RemoteCallbackList<com.kwad.framework.filedownloader.c.a> ahI = new RemoteCallbackList<>();
    public final g ahJ;
    public final WeakReference<FileDownloadServiceProxy> ahK;

    @Override // com.kwad.framework.filedownloader.services.i
    public final void wr() {
    }

    @Override // com.kwad.framework.filedownloader.services.i
    public final IBinder ws() {
        return this;
    }

    public d(WeakReference<FileDownloadServiceProxy> weakReference, g gVar) {
        this.ahK = weakReference;
        this.ahJ = gVar;
        com.kwad.framework.filedownloader.message.e.vV().a(this);
    }

    @Override // com.kwad.framework.filedownloader.c.b
    public final boolean r(String str, String str2) {
        return this.ahJ.t(str, str2);
    }

    @Override // com.kwad.framework.filedownloader.c.b
    public final void startForeground(int i, Notification notification) {
        WeakReference<FileDownloadServiceProxy> weakReference = this.ahK;
        if (weakReference != null && weakReference.get() != null) {
            this.ahK.get().context.startForeground(i, notification);
        }
    }

    private synchronized int v(MessageSnapshot messageSnapshot) {
        int beginBroadcast;
        RemoteCallbackList<com.kwad.framework.filedownloader.c.a> remoteCallbackList;
        beginBroadcast = this.ahI.beginBroadcast();
        for (int i = 0; i < beginBroadcast; i++) {
            try {
                this.ahI.getBroadcastItem(i).q(messageSnapshot);
            } catch (RemoteException e) {
                com.kwad.framework.filedownloader.f.d.a(this, e, "callback error", new Object[0]);
                remoteCallbackList = this.ahI;
            }
        }
        remoteCallbackList = this.ahI;
        remoteCallbackList.finishBroadcast();
        return beginBroadcast;
    }

    @Override // com.kwad.framework.filedownloader.c.b
    public final void a(com.kwad.framework.filedownloader.c.a aVar) {
        this.ahI.register(aVar);
    }

    @Override // com.kwad.framework.filedownloader.c.b
    public final boolean aY(int i) {
        return this.ahJ.aY(i);
    }

    @Override // com.kwad.framework.filedownloader.c.b
    public final byte aZ(int i) {
        return this.ahJ.aZ(i);
    }

    @Override // com.kwad.framework.filedownloader.c.b
    public final void b(com.kwad.framework.filedownloader.c.a aVar) {
        this.ahI.unregister(aVar);
    }

    @Override // com.kwad.framework.filedownloader.c.b
    public final boolean ba(int i) {
        return this.ahJ.ba(i);
    }

    @Override // com.kwad.framework.filedownloader.c.b
    public final boolean bs(int i) {
        return this.ahJ.bs(i);
    }

    @Override // com.kwad.framework.filedownloader.c.b
    public final long bt(int i) {
        return this.ahJ.bE(i);
    }

    @Override // com.kwad.framework.filedownloader.c.b
    public final long bu(int i) {
        return this.ahJ.bu(i);
    }

    @Override // com.kwad.framework.filedownloader.message.e.b
    public final void r(MessageSnapshot messageSnapshot) {
        v(messageSnapshot);
    }

    @Override // com.kwad.framework.filedownloader.c.b
    public final void stopForeground(boolean z) {
        WeakReference<FileDownloadServiceProxy> weakReference = this.ahK;
        if (weakReference != null && weakReference.get() != null) {
            this.ahK.get().context.stopForeground(z);
        }
    }

    @Override // com.kwad.framework.filedownloader.c.b
    public final void b(String str, String str2, boolean z, int i, int i2, int i3, boolean z2, com.kwad.framework.filedownloader.d.b bVar, boolean z3) {
        this.ahJ.b(str, str2, z, i, i2, i3, z2, bVar, z3);
    }

    @Override // com.kwad.framework.filedownloader.c.b
    public final boolean isIdle() {
        return this.ahJ.isIdle();
    }

    @Override // com.kwad.framework.filedownloader.services.i
    public final void onDestroy() {
        com.kwad.framework.filedownloader.message.e.vV().a(null);
    }

    @Override // com.kwad.framework.filedownloader.c.b
    public final void pauseAllTasks() {
        this.ahJ.wu();
    }

    @Override // com.kwad.framework.filedownloader.c.b
    public final void vL() {
        this.ahJ.vL();
    }
}
