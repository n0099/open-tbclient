package com.kwai.filedownloader.services;

import android.app.Notification;
import android.content.Intent;
import android.os.IBinder;
import com.kwai.filedownloader.c.b;
import com.kwai.filedownloader.m;
import java.lang.ref.WeakReference;
/* loaded from: classes6.dex */
public class e extends b.a implements i {

    /* renamed from: a  reason: collision with root package name */
    public final g f34464a;

    /* renamed from: b  reason: collision with root package name */
    public final WeakReference<FileDownloadServiceProxy> f34465b;

    /* loaded from: classes6.dex */
    public interface a {
        void a();

        void a(e eVar);
    }

    public e(WeakReference<FileDownloadServiceProxy> weakReference, g gVar) {
        this.f34465b = weakReference;
        this.f34464a = gVar;
    }

    @Override // com.kwai.filedownloader.services.i
    public IBinder a(Intent intent) {
        return null;
    }

    @Override // com.kwai.filedownloader.c.b
    public void a() {
        this.f34464a.a();
    }

    @Override // com.kwai.filedownloader.c.b
    public void a(int i2, Notification notification) {
        WeakReference<FileDownloadServiceProxy> weakReference = this.f34465b;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.f34465b.get().context.startForeground(i2, notification);
    }

    @Override // com.kwai.filedownloader.services.i
    public void a(Intent intent, int i2, int i3) {
        m.b().a(this);
    }

    @Override // com.kwai.filedownloader.c.b
    public void a(com.kwai.filedownloader.c.a aVar) {
    }

    @Override // com.kwai.filedownloader.c.b
    public void a(String str, String str2, boolean z, int i2, int i3, int i4, boolean z2, com.kwai.filedownloader.d.b bVar, boolean z3) {
        this.f34464a.a(str, str2, z, i2, i3, i4, z2, bVar, z3);
    }

    @Override // com.kwai.filedownloader.c.b
    public void a(boolean z) {
        WeakReference<FileDownloadServiceProxy> weakReference = this.f34465b;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.f34465b.get().context.stopForeground(z);
    }

    @Override // com.kwai.filedownloader.c.b
    public boolean a(int i2) {
        return this.f34464a.b(i2);
    }

    @Override // com.kwai.filedownloader.c.b
    public boolean a(String str, String str2) {
        return this.f34464a.a(str, str2);
    }

    @Override // com.kwai.filedownloader.c.b
    public void b(com.kwai.filedownloader.c.a aVar) {
    }

    @Override // com.kwai.filedownloader.c.b
    public boolean b() {
        return this.f34464a.b();
    }

    @Override // com.kwai.filedownloader.c.b
    public boolean b(int i2) {
        return this.f34464a.f(i2);
    }

    @Override // com.kwai.filedownloader.c.b
    public long c(int i2) {
        return this.f34464a.c(i2);
    }

    @Override // com.kwai.filedownloader.c.b
    public void c() {
        this.f34464a.c();
    }

    @Override // com.kwai.filedownloader.c.b
    public long d(int i2) {
        return this.f34464a.d(i2);
    }

    @Override // com.kwai.filedownloader.services.i
    public void d() {
        m.b().a();
    }

    @Override // com.kwai.filedownloader.c.b
    public byte e(int i2) {
        return this.f34464a.e(i2);
    }

    @Override // com.kwai.filedownloader.c.b
    public boolean f(int i2) {
        return this.f34464a.g(i2);
    }
}
