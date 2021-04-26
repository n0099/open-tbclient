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
    public final RemoteCallbackList<com.kwai.filedownloader.c.a> f35216a = new RemoteCallbackList<>();

    /* renamed from: b  reason: collision with root package name */
    public final g f35217b;

    /* renamed from: c  reason: collision with root package name */
    public final WeakReference<FileDownloadServiceProxy> f35218c;

    public d(WeakReference<FileDownloadServiceProxy> weakReference, g gVar) {
        this.f35218c = weakReference;
        this.f35217b = gVar;
        com.kwai.filedownloader.message.e.a().a(this);
    }

    private synchronized int b(MessageSnapshot messageSnapshot) {
        int beginBroadcast;
        RemoteCallbackList<com.kwai.filedownloader.c.a> remoteCallbackList;
        beginBroadcast = this.f35216a.beginBroadcast();
        for (int i2 = 0; i2 < beginBroadcast; i2++) {
            try {
                this.f35216a.getBroadcastItem(i2).a(messageSnapshot);
            } catch (RemoteException e2) {
                com.kwai.filedownloader.f.d.a(this, e2, "callback error", new Object[0]);
                remoteCallbackList = this.f35216a;
            }
        }
        remoteCallbackList = this.f35216a;
        remoteCallbackList.finishBroadcast();
        return beginBroadcast;
    }

    @Override // com.kwai.filedownloader.services.i
    public IBinder a(Intent intent) {
        return this;
    }

    @Override // com.kwai.filedownloader.c.b
    public void a() {
        this.f35217b.a();
    }

    @Override // com.kwai.filedownloader.c.b
    public void a(int i2, Notification notification) {
        WeakReference<FileDownloadServiceProxy> weakReference = this.f35218c;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.f35218c.get().context.startForeground(i2, notification);
    }

    @Override // com.kwai.filedownloader.services.i
    public void a(Intent intent, int i2, int i3) {
    }

    @Override // com.kwai.filedownloader.c.b
    public void a(com.kwai.filedownloader.c.a aVar) {
        this.f35216a.register(aVar);
    }

    @Override // com.kwai.filedownloader.message.e.b
    public void a(MessageSnapshot messageSnapshot) {
        b(messageSnapshot);
    }

    @Override // com.kwai.filedownloader.c.b
    public void a(String str, String str2, boolean z, int i2, int i3, int i4, boolean z2, com.kwai.filedownloader.d.b bVar, boolean z3) {
        this.f35217b.a(str, str2, z, i2, i3, i4, z2, bVar, z3);
    }

    @Override // com.kwai.filedownloader.c.b
    public void a(boolean z) {
        WeakReference<FileDownloadServiceProxy> weakReference = this.f35218c;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.f35218c.get().context.stopForeground(z);
    }

    @Override // com.kwai.filedownloader.c.b
    public boolean a(int i2) {
        return this.f35217b.b(i2);
    }

    @Override // com.kwai.filedownloader.c.b
    public boolean a(String str, String str2) {
        return this.f35217b.a(str, str2);
    }

    @Override // com.kwai.filedownloader.c.b
    public void b(com.kwai.filedownloader.c.a aVar) {
        this.f35216a.unregister(aVar);
    }

    @Override // com.kwai.filedownloader.c.b
    public boolean b() {
        return this.f35217b.b();
    }

    @Override // com.kwai.filedownloader.c.b
    public boolean b(int i2) {
        return this.f35217b.f(i2);
    }

    @Override // com.kwai.filedownloader.c.b
    public long c(int i2) {
        return this.f35217b.c(i2);
    }

    @Override // com.kwai.filedownloader.c.b
    public void c() {
        this.f35217b.c();
    }

    @Override // com.kwai.filedownloader.c.b
    public long d(int i2) {
        return this.f35217b.d(i2);
    }

    @Override // com.kwai.filedownloader.services.i
    public void d() {
        com.kwai.filedownloader.message.e.a().a((e.b) null);
    }

    @Override // com.kwai.filedownloader.c.b
    public byte e(int i2) {
        return this.f35217b.e(i2);
    }

    @Override // com.kwai.filedownloader.c.b
    public boolean f(int i2) {
        return this.f35217b.g(i2);
    }
}
