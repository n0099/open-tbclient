package com.ss.android.socialbase.downloader.downloader;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import d.o.a.e.b.g.d;
import d.o.a.e.b.g.o;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutorService;
/* loaded from: classes7.dex */
public class DownloadService extends Service {

    /* renamed from: b  reason: collision with root package name */
    public static final String f39768b = DownloadService.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    public o f39769a;

    /* loaded from: classes7.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Intent f39770e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f39771f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f39772g;

        public a(Intent intent, int i2, int i3) {
            this.f39770e = intent;
            this.f39771f = i2;
            this.f39772g = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            o oVar = DownloadService.this.f39769a;
            if (oVar != null) {
                oVar.a(this.f39770e, this.f39771f, this.f39772g);
            }
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        String str = f39768b;
        StringBuilder sb = new StringBuilder();
        sb.append("onBind downloadServiceHandler != null:");
        sb.append(this.f39769a != null);
        d.o.a.e.b.c.a.g(str, sb.toString());
        o oVar = this.f39769a;
        if (oVar != null) {
            return oVar.a(intent);
        }
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        d.y(this);
        o J0 = d.J0();
        this.f39769a = J0;
        J0.c(new WeakReference(this));
    }

    @Override // android.app.Service
    public void onDestroy() {
        if (d.o.a.e.b.c.a.e()) {
            d.o.a.e.b.c.a.g(f39768b, "Service onDestroy");
        }
        o oVar = this.f39769a;
        if (oVar != null) {
            oVar.d();
            this.f39769a = null;
        }
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        if (d.o.a.e.b.c.a.e()) {
            d.o.a.e.b.c.a.g(f39768b, "DownloadService onStartCommand");
        }
        this.f39769a.c();
        ExecutorService w0 = d.w0();
        if (w0 != null) {
            w0.execute(new a(intent, i2, i3));
        }
        return d.u0() ? 2 : 3;
    }
}
