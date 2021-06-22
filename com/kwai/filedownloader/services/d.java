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
/* loaded from: classes7.dex */
public class d extends b.a implements e.b, i {

    /* renamed from: a  reason: collision with root package name */
    public final RemoteCallbackList<com.kwai.filedownloader.c.a> f37972a = new RemoteCallbackList<>();

    /* renamed from: b  reason: collision with root package name */
    public final g f37973b;

    /* renamed from: c  reason: collision with root package name */
    public final WeakReference<FileDownloadServiceProxy> f37974c;

    public d(WeakReference<FileDownloadServiceProxy> weakReference, g gVar) {
        this.f37974c = weakReference;
        this.f37973b = gVar;
        com.kwai.filedownloader.message.e.a().a(this);
    }

    private synchronized int b(MessageSnapshot messageSnapshot) {
        int beginBroadcast;
        RemoteCallbackList<com.kwai.filedownloader.c.a> remoteCallbackList;
        beginBroadcast = this.f37972a.beginBroadcast();
        for (int i2 = 0; i2 < beginBroadcast; i2++) {
            try {
                this.f37972a.getBroadcastItem(i2).a(messageSnapshot);
            } catch (RemoteException e2) {
                com.kwai.filedownloader.f.d.a(this, e2, "callback error", new Object[0]);
                remoteCallbackList = this.f37972a;
            }
        }
        remoteCallbackList = this.f37972a;
        remoteCallbackList.finishBroadcast();
        return beginBroadcast;
    }

    @Override // com.kwai.filedownloader.services.i
    public IBinder a(Intent intent) {
        return this;
    }

    @Override // com.kwai.filedownloader.c.b
    public void a() {
        this.f37973b.a();
    }

    @Override // com.kwai.filedownloader.c.b
    public void a(int i2, Notification notification) {
        WeakReference<FileDownloadServiceProxy> weakReference = this.f37974c;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.f37974c.get().context.startForeground(i2, notification);
    }

    @Override // com.kwai.filedownloader.services.i
    public void a(Intent intent, int i2, int i3) {
    }

    @Override // com.kwai.filedownloader.c.b
    public void a(com.kwai.filedownloader.c.a aVar) {
        this.f37972a.register(aVar);
    }

    @Override // com.kwai.filedownloader.message.e.b
    public void a(MessageSnapshot messageSnapshot) {
        b(messageSnapshot);
    }

    @Override // com.kwai.filedownloader.c.b
    public void a(String str, String str2, boolean z, int i2, int i3, int i4, boolean z2, com.kwai.filedownloader.d.b bVar, boolean z3) {
        this.f37973b.a(str, str2, z, i2, i3, i4, z2, bVar, z3);
    }

    @Override // com.kwai.filedownloader.c.b
    public void a(boolean z) {
        WeakReference<FileDownloadServiceProxy> weakReference = this.f37974c;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.f37974c.get().context.stopForeground(z);
    }

    @Override // com.kwai.filedownloader.c.b
    public boolean a(int i2) {
        return this.f37973b.b(i2);
    }

    @Override // com.kwai.filedownloader.c.b
    public boolean a(String str, String str2) {
        return this.f37973b.a(str, str2);
    }

    @Override // com.kwai.filedownloader.c.b
    public void b(com.kwai.filedownloader.c.a aVar) {
        this.f37972a.unregister(aVar);
    }

    @Override // com.kwai.filedownloader.c.b
    public boolean b() {
        return this.f37973b.b();
    }

    @Override // com.kwai.filedownloader.c.b
    public boolean b(int i2) {
        return this.f37973b.f(i2);
    }

    @Override // com.kwai.filedownloader.c.b
    public long c(int i2) {
        return this.f37973b.c(i2);
    }

    @Override // com.kwai.filedownloader.c.b
    public void c() {
        this.f37973b.c();
    }

    @Override // com.kwai.filedownloader.c.b
    public long d(int i2) {
        return this.f37973b.d(i2);
    }

    @Override // com.kwai.filedownloader.services.i
    public void d() {
        com.kwai.filedownloader.message.e.a().a((e.b) null);
    }

    @Override // com.kwai.filedownloader.c.b
    public byte e(int i2) {
        return this.f37973b.e(i2);
    }

    @Override // com.kwai.filedownloader.c.b
    public boolean f(int i2) {
        return this.f37973b.g(i2);
    }
}
