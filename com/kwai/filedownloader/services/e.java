package com.kwai.filedownloader.services;

import android.app.Notification;
import android.content.Intent;
import android.os.IBinder;
import com.kwai.filedownloader.c.b;
import com.kwai.filedownloader.m;
import java.lang.ref.WeakReference;
/* loaded from: classes4.dex */
public class e extends b.a implements i {

    /* renamed from: a  reason: collision with root package name */
    private final g f10988a;

    /* renamed from: b  reason: collision with root package name */
    private final WeakReference<FileDownloadServiceProxy> f10989b;

    /* loaded from: classes4.dex */
    public interface a {
        void a();

        void a(e eVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(WeakReference<FileDownloadServiceProxy> weakReference, g gVar) {
        this.f10989b = weakReference;
        this.f10988a = gVar;
    }

    @Override // com.kwai.filedownloader.services.i
    public IBinder a(Intent intent) {
        return null;
    }

    @Override // com.kwai.filedownloader.c.b
    public void a() {
        this.f10988a.a();
    }

    @Override // com.kwai.filedownloader.c.b
    public void a(int i, Notification notification) {
        if (this.f10989b == null || this.f10989b.get() == null) {
            return;
        }
        this.f10989b.get().context.startForeground(i, notification);
    }

    @Override // com.kwai.filedownloader.services.i
    public void a(Intent intent, int i, int i2) {
        m.b().a(this);
    }

    @Override // com.kwai.filedownloader.c.b
    public void a(com.kwai.filedownloader.c.a aVar) {
    }

    @Override // com.kwai.filedownloader.c.b
    public void a(String str, String str2, boolean z, int i, int i2, int i3, boolean z2, com.kwai.filedownloader.d.b bVar, boolean z3) {
        this.f10988a.a(str, str2, z, i, i2, i3, z2, bVar, z3);
    }

    @Override // com.kwai.filedownloader.c.b
    public void a(boolean z) {
        if (this.f10989b == null || this.f10989b.get() == null) {
            return;
        }
        this.f10989b.get().context.stopForeground(z);
    }

    @Override // com.kwai.filedownloader.c.b
    public boolean a(int i) {
        return this.f10988a.b(i);
    }

    @Override // com.kwai.filedownloader.c.b
    public boolean a(String str, String str2) {
        return this.f10988a.a(str, str2);
    }

    @Override // com.kwai.filedownloader.c.b
    public void b(com.kwai.filedownloader.c.a aVar) {
    }

    @Override // com.kwai.filedownloader.c.b
    public boolean b() {
        return this.f10988a.b();
    }

    @Override // com.kwai.filedownloader.c.b
    public boolean b(int i) {
        return this.f10988a.f(i);
    }

    @Override // com.kwai.filedownloader.c.b
    public long c(int i) {
        return this.f10988a.c(i);
    }

    @Override // com.kwai.filedownloader.c.b
    public void c() {
        this.f10988a.c();
    }

    @Override // com.kwai.filedownloader.c.b
    public long d(int i) {
        return this.f10988a.d(i);
    }

    @Override // com.kwai.filedownloader.services.i
    public void d() {
        m.b().a();
    }

    @Override // com.kwai.filedownloader.c.b
    public byte e(int i) {
        return this.f10988a.e(i);
    }

    @Override // com.kwai.filedownloader.c.b
    public boolean f(int i) {
        return this.f10988a.g(i);
    }
}
