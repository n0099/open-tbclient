package d.p.a.e.b.m;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import com.ss.android.socialbase.downloader.downloader.DownloadService;
/* loaded from: classes6.dex */
public class h extends d.p.a.e.b.g.c {
    public static final String m = "h";

    @Override // d.p.a.e.b.g.c, d.p.a.e.b.g.o
    public void a(Intent intent, int i, int i2) {
        if (d.p.a.e.b.c.a.e()) {
            d.p.a.e.b.c.a.g(m, "onStartCommand");
        }
        if (!d.p.a.e.b.l.a.a(262144)) {
            this.f68114g = true;
        }
        g();
    }

    @Override // d.p.a.e.b.g.c, d.p.a.e.b.g.o
    public void c() {
        if (d.p.a.e.b.l.a.a(262144)) {
            this.f68114g = true;
            this.i = false;
            if (d.p.a.e.b.c.a.e()) {
                d.p.a.e.b.c.a.g(m, "onStartCommandOnMainThread");
            }
        }
    }

    @Override // d.p.a.e.b.g.c
    public void e(Context context, ServiceConnection serviceConnection) {
        try {
            context.startService(new Intent(context, DownloadService.class));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
