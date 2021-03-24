package d.o.a.e.b.m;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import com.ss.android.socialbase.downloader.downloader.DownloadService;
/* loaded from: classes7.dex */
public class h extends d.o.a.e.b.g.c {
    public static final String m = "h";

    @Override // d.o.a.e.b.g.c, d.o.a.e.b.g.o
    public void a(Intent intent, int i, int i2) {
        if (d.o.a.e.b.c.a.e()) {
            d.o.a.e.b.c.a.g(m, "onStartCommand");
        }
        if (!d.o.a.e.b.l.a.a(262144)) {
            this.f66969g = true;
        }
        g();
    }

    @Override // d.o.a.e.b.g.c, d.o.a.e.b.g.o
    public void c() {
        if (d.o.a.e.b.l.a.a(262144)) {
            this.f66969g = true;
            this.i = false;
            if (d.o.a.e.b.c.a.e()) {
                d.o.a.e.b.c.a.g(m, "onStartCommandOnMainThread");
            }
        }
    }

    @Override // d.o.a.e.b.g.c
    public void e(Context context, ServiceConnection serviceConnection) {
        try {
            context.startService(new Intent(context, DownloadService.class));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
