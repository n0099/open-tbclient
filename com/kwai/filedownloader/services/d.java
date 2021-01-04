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
/* loaded from: classes5.dex */
public class d extends b.a implements e.b, i {

    /* renamed from: a  reason: collision with root package name */
    private final RemoteCallbackList<com.kwai.filedownloader.c.a> f11285a = new RemoteCallbackList<>();

    /* renamed from: b  reason: collision with root package name */
    private final g f11286b;
    private final WeakReference<FileDownloadServiceProxy> c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(WeakReference<FileDownloadServiceProxy> weakReference, g gVar) {
        this.c = weakReference;
        this.f11286b = gVar;
        com.kwai.filedownloader.message.e.a().a(this);
    }

    private synchronized int b(MessageSnapshot messageSnapshot) {
        int beginBroadcast;
        beginBroadcast = this.f11285a.beginBroadcast();
        for (int i = 0; i < beginBroadcast; i++) {
            try {
                this.f11285a.getBroadcastItem(i).a(messageSnapshot);
            } catch (RemoteException e) {
                com.kwai.filedownloader.f.d.a(this, e, "callback error", new Object[0]);
                this.f11285a.finishBroadcast();
            }
        }
        this.f11285a.finishBroadcast();
        return beginBroadcast;
    }

    @Override // com.kwai.filedownloader.services.i
    public IBinder a(Intent intent) {
        return this;
    }

    @Override // com.kwai.filedownloader.c.b
    public void a() {
        this.f11286b.a();
    }

    @Override // com.kwai.filedownloader.c.b
    public void a(int i, Notification notification) {
        if (this.c == null || this.c.get() == null) {
            return;
        }
        this.c.get().context.startForeground(i, notification);
    }

    @Override // com.kwai.filedownloader.services.i
    public void a(Intent intent, int i, int i2) {
    }

    @Override // com.kwai.filedownloader.c.b
    public void a(com.kwai.filedownloader.c.a aVar) {
        this.f11285a.register(aVar);
    }

    @Override // com.kwai.filedownloader.message.e.b
    public void a(MessageSnapshot messageSnapshot) {
        b(messageSnapshot);
    }

    @Override // com.kwai.filedownloader.c.b
    public void a(String str, String str2, boolean z, int i, int i2, int i3, boolean z2, com.kwai.filedownloader.d.b bVar, boolean z3) {
        this.f11286b.a(str, str2, z, i, i2, i3, z2, bVar, z3);
    }

    @Override // com.kwai.filedownloader.c.b
    public void a(boolean z) {
        if (this.c == null || this.c.get() == null) {
            return;
        }
        this.c.get().context.stopForeground(z);
    }

    @Override // com.kwai.filedownloader.c.b
    public boolean a(int i) {
        return this.f11286b.b(i);
    }

    @Override // com.kwai.filedownloader.c.b
    public boolean a(String str, String str2) {
        return this.f11286b.a(str, str2);
    }

    @Override // com.kwai.filedownloader.c.b
    public void b(com.kwai.filedownloader.c.a aVar) {
        this.f11285a.unregister(aVar);
    }

    @Override // com.kwai.filedownloader.c.b
    public boolean b() {
        return this.f11286b.b();
    }

    @Override // com.kwai.filedownloader.c.b
    public boolean b(int i) {
        return this.f11286b.f(i);
    }

    @Override // com.kwai.filedownloader.c.b
    public long c(int i) {
        return this.f11286b.c(i);
    }

    @Override // com.kwai.filedownloader.c.b
    public void c() {
        this.f11286b.c();
    }

    @Override // com.kwai.filedownloader.c.b
    public long d(int i) {
        return this.f11286b.d(i);
    }

    @Override // com.kwai.filedownloader.services.i
    public void d() {
        com.kwai.filedownloader.message.e.a().a((e.b) null);
    }

    @Override // com.kwai.filedownloader.c.b
    public byte e(int i) {
        return this.f11286b.e(i);
    }

    @Override // com.kwai.filedownloader.c.b
    public boolean f(int i) {
        return this.f11286b.g(i);
    }
}
