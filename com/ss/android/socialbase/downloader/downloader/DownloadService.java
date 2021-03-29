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
    public static final String f38838b = DownloadService.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    public o f38839a;

    /* loaded from: classes7.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Intent f38840e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f38841f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f38842g;

        public a(Intent intent, int i, int i2) {
            this.f38840e = intent;
            this.f38841f = i;
            this.f38842g = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            o oVar = DownloadService.this.f38839a;
            if (oVar != null) {
                oVar.a(this.f38840e, this.f38841f, this.f38842g);
            }
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        String str = f38838b;
        StringBuilder sb = new StringBuilder();
        sb.append("onBind downloadServiceHandler != null:");
        sb.append(this.f38839a != null);
        d.o.a.e.b.c.a.g(str, sb.toString());
        o oVar = this.f38839a;
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
        this.f38839a = J0;
        J0.c(new WeakReference(this));
    }

    @Override // android.app.Service
    public void onDestroy() {
        if (d.o.a.e.b.c.a.e()) {
            d.o.a.e.b.c.a.g(f38838b, "Service onDestroy");
        }
        o oVar = this.f38839a;
        if (oVar != null) {
            oVar.d();
            this.f38839a = null;
        }
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        if (d.o.a.e.b.c.a.e()) {
            d.o.a.e.b.c.a.g(f38838b, "DownloadService onStartCommand");
        }
        this.f38839a.c();
        ExecutorService w0 = d.w0();
        if (w0 != null) {
            w0.execute(new a(intent, i, i2));
        }
        return d.u0() ? 2 : 3;
    }
}
