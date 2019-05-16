package com.xiaomi.channel.commonutils.misc;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
public class k {
    private a a;
    private Handler b;
    private volatile boolean c;
    private final boolean d;
    private int e;
    private volatile b f;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
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
            long j = k.this.e > 0 ? k.this.e : Long.MAX_VALUE;
            while (!k.this.c) {
                try {
                    b poll = this.b.poll(j, TimeUnit.SECONDS);
                    k.this.f = poll;
                    if (poll != null) {
                        k.this.b.sendMessage(k.this.b.obtainMessage(0, poll));
                        poll.b();
                        k.this.b.sendMessage(k.this.b.obtainMessage(1, poll));
                    } else if (k.this.e > 0) {
                        k.this.a();
                    }
                } catch (InterruptedException e) {
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static abstract class b {
        public void a() {
        }

        public abstract void b();

        public void c() {
        }
    }

    public k() {
        this(false);
    }

    public k(boolean z) {
        this(z, 0);
    }

    public k(boolean z, int i) {
        this.b = null;
        this.c = false;
        this.e = 0;
        this.b = new l(this, Looper.getMainLooper());
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
        this.b.postDelayed(new m(this, bVar), j);
    }
}
