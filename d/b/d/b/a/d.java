package d.b.d.b.a;

import d.b.d.b.h.h;
import java.io.File;
/* loaded from: classes6.dex */
public class d implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public final c f69585e;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f69586f = false;

    /* renamed from: g  reason: collision with root package name */
    public Runnable f69587g = new a();

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.f69586f = false;
        }
    }

    public d(c cVar) {
        this.f69585e = cVar;
        a();
        h.a(2L);
        d.b.d.b.h.g.a().b(4500L, this.f69587g);
        d.b.d.b.h.g.a().c(5000L, this, 40, 5000L);
    }

    public final long a() {
        File file = new File("/data/anr/traces.txt");
        if (file.exists()) {
            return file.lastModified();
        }
        return 0L;
    }

    public final boolean c() {
        File file = new File("/data/anr/traces.txt");
        return file.exists() && file.canRead();
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        int i2;
        if (this.f69586f) {
            return;
        }
        if (c()) {
            i2 = 200;
            str = "/data/anr/traces.txt";
        } else {
            str = null;
            i2 = 100;
        }
        if (this.f69585e.e(i2, str, 25)) {
            this.f69586f = true;
        }
    }
}
