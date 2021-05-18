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
    public static final String f36057b = DownloadService.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    public o f36058a;

    /* loaded from: classes7.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Intent f36059e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f36060f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f36061g;

        public a(Intent intent, int i2, int i3) {
            this.f36059e = intent;
            this.f36060f = i2;
            this.f36061g = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            o oVar = DownloadService.this.f36058a;
            if (oVar != null) {
                oVar.a(this.f36059e, this.f36060f, this.f36061g);
            }
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        String str = f36057b;
        StringBuilder sb = new StringBuilder();
        sb.append("onBind downloadServiceHandler != null:");
        sb.append(this.f36058a != null);
        d.o.a.e.b.c.a.g(str, sb.toString());
        o oVar = this.f36058a;
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
        this.f36058a = J0;
        J0.c(new WeakReference(this));
    }

    @Override // android.app.Service
    public void onDestroy() {
        if (d.o.a.e.b.c.a.e()) {
            d.o.a.e.b.c.a.g(f36057b, "Service onDestroy");
        }
        o oVar = this.f36058a;
        if (oVar != null) {
            oVar.d();
            this.f36058a = null;
        }
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        if (d.o.a.e.b.c.a.e()) {
            d.o.a.e.b.c.a.g(f36057b, "DownloadService onStartCommand");
        }
        this.f36058a.c();
        ExecutorService w0 = d.w0();
        if (w0 != null) {
            w0.execute(new a(intent, i2, i3));
        }
        return d.u0() ? 2 : 3;
    }
}
