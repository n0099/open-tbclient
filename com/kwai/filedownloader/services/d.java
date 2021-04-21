package com.kwai.filedownloader.services;

import android.app.Notification;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.kwai.filedownloader.c.b;
import com.kwai.filedownloader.message.MessageSnapshot;
import com.kwai.filedownloader.message.e;
import java.lang.ref.WeakReference;
/* loaded from: classes6.dex */
public class d extends b.a implements e.b, i {

    /* renamed from: a  reason: collision with root package name */
    public final RemoteCallbackList<com.kwai.filedownloader.c.a> f37494a = new RemoteCallbackList<>();

    /* renamed from: b  reason: collision with root package name */
    public final g f37495b;

    /* renamed from: c  reason: collision with root package name */
    public final WeakReference<FileDownloadServiceProxy> f37496c;

    public d(WeakReference<FileDownloadServiceProxy> weakReference, g gVar) {
        this.f37496c = weakReference;
        this.f37495b = gVar;
        com.kwai.filedownloader.message.e.a().a(this);
    }

    private synchronized int b(MessageSnapshot messageSnapshot) {
        int beginBroadcast;
        RemoteCallbackList<com.kwai.filedownloader.c.a> remoteCallbackList;
        beginBroadcast = this.f37494a.beginBroadcast();
        for (int i = 0; i < beginBroadcast; i++) {
            try {
                this.f37494a.getBroadcastItem(i).a(messageSnapshot);
            } catch (RemoteException e2) {
                com.kwai.filedownloader.f.d.a(this, e2, "callback error", new Object[0]);
                remoteCallbackList = this.f37494a;
            }
        }
        remoteCallbackList = this.f37494a;
        remoteCallbackList.finishBroadcast();
        return beginBroadcast;
    }

    @Override // com.kwai.filedownloader.services.i
    public IBinder a(Intent intent) {
        return this;
    }

    @Override // com.kwai.filedownloader.c.b
    public void a() {
        this.f37495b.a();
    }

    @Override // com.kwai.filedownloader.c.b
    public void a(int i, Notification notification) {
        WeakReference<FileDownloadServiceProxy> weakReference = this.f37496c;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.f37496c.get().context.startForeground(i, notification);
    }

    @Override // com.kwai.filedownloader.services.i
    public void a(Intent intent, int i, int i2) {
    }

    @Override // com.kwai.filedownloader.c.b
    public void a(com.kwai.filedownloader.c.a aVar) {
        this.f37494a.register(aVar);
    }

    @Override // com.kwai.filedownloader.message.e.b
    public void a(MessageSnapshot messageSnapshot) {
        b(messageSnapshot);
    }

    @Override // com.kwai.filedownloader.c.b
    public void a(String str, String str2, boolean z, int i, int i2, int i3, boolean z2, com.kwai.filedownloader.d.b bVar, boolean z3) {
        this.f37495b.a(str, str2, z, i, i2, i3, z2, bVar, z3);
    }

    @Override // com.kwai.filedownloader.c.b
    public void a(boolean z) {
        WeakReference<FileDownloadServiceProxy> weakReference = this.f37496c;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.f37496c.get().context.stopForeground(z);
    }

    @Override // com.kwai.filedownloader.c.b
    public boolean a(int i) {
        return this.f37495b.b(i);
    }

    @Override // com.kwai.filedownloader.c.b
    public boolean a(String str, String str2) {
        return this.f37495b.a(str, str2);
    }

    @Override // com.kwai.filedownloader.c.b
    public void b(com.kwai.filedownloader.c.a aVar) {
        this.f37494a.unregister(aVar);
    }

    @Override // com.kwai.filedownloader.c.b
    public boolean b() {
        return this.f37495b.b();
    }

    @Override // com.kwai.filedownloader.c.b
    public boolean b(int i) {
        return this.f37495b.f(i);
    }

    @Override // com.kwai.filedownloader.c.b
    public long c(int i) {
        return this.f37495b.c(i);
    }

    @Override // com.kwai.filedownloader.c.b
    public void c() {
        this.f37495b.c();
    }

    @Override // com.kwai.filedownloader.c.b
    public long d(int i) {
        return this.f37495b.d(i);
    }

    @Override // com.kwai.filedownloader.services.i
    public void d() {
        com.kwai.filedownloader.message.e.a().a((e.b) null);
    }

    @Override // com.kwai.filedownloader.c.b
    public byte e(int i) {
        return this.f37495b.e(i);
    }

    @Override // com.kwai.filedownloader.c.b
    public boolean f(int i) {
        return this.f37495b.g(i);
    }
}
