package d.c.d.b.a;

import d.c.d.b.h.h;
import java.io.File;
/* loaded from: classes6.dex */
public class d implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public final c f65783e;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f65784f = false;

    /* renamed from: g  reason: collision with root package name */
    public Runnable f65785g = new a();

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.f65784f = false;
        }
    }

    public d(c cVar) {
        this.f65783e = cVar;
        a();
        h.a(2L);
        d.c.d.b.h.g.a().b(4500L, this.f65785g);
        d.c.d.b.h.g.a().c(5000L, this, 40, 5000L);
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
        int i;
        if (this.f65784f) {
            return;
        }
        if (c()) {
            i = 200;
            str = "/data/anr/traces.txt";
        } else {
            str = null;
            i = 100;
        }
        if (this.f65783e.e(i, str, 25)) {
            this.f65784f = true;
        }
    }
}
