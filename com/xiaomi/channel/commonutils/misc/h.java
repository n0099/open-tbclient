package com.xiaomi.channel.commonutils.misc;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
/* loaded from: classes2.dex */
public class h {
    private a a;
    private Handler b;
    private volatile boolean c;
    private final boolean d;
    private int e;
    private volatile b f;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a extends Thread {
        private final LinkedBlockingQueue<b> b;

        public a() {
            super("PackageProcessor");
            this.b = new LinkedBlockingQueue<>();
        }

        public void a(b bVar) {
            this.b.add(bVar);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            int i = h.this.e > 0 ? h.this.e : 1;
            while (!h.this.c) {
                try {
                    h.this.f = this.b.poll(i, TimeUnit.SECONDS);
                    if (h.this.f != null) {
                        h.this.b.sendMessage(h.this.b.obtainMessage(0, h.this.f));
                        h.this.f.b();
                        h.this.b.sendMessage(h.this.b.obtainMessage(1, h.this.f));
                    } else if (h.this.e > 0) {
                        h.this.a();
                    }
                } catch (InterruptedException e) {
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class b {
        public void a() {
        }

        public abstract void b();

        public void c() {
        }
    }

    public h() {
        this(false);
    }

    public h(boolean z) {
        this(z, 0);
    }

    public h(boolean z, int i) {
        this.b = null;
        this.c = false;
        this.e = 0;
        this.b = new i(this, Looper.getMainLooper());
        this.d = z;
        this.e = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a() {
        this.a = null;
        this.c = true;
    }

    public synchronized void a(b bVar) {
        if (this.a == null) {
            this.a = new a();
            this.a.setDaemon(this.d);
            this.c = false;
            this.a.start();
        }
        this.a.a(bVar);
    }

    public void a(b bVar, long j) {
        this.b.postDelayed(new j(this, bVar), j);
    }
}
