package com.xiaomi.push;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
/* loaded from: classes5.dex */
public class al {
    private int a;

    /* renamed from: a  reason: collision with other field name */
    private Handler f125a;

    /* renamed from: a  reason: collision with other field name */
    private a f126a;

    /* renamed from: a  reason: collision with other field name */
    private volatile b f127a;

    /* renamed from: a  reason: collision with other field name */
    private volatile boolean f128a;
    private final boolean b;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class a extends Thread {

        /* renamed from: a  reason: collision with other field name */
        private final LinkedBlockingQueue<b> f129a;

        public a() {
            super("PackageProcessor");
            this.f129a = new LinkedBlockingQueue<>();
        }

        private void a(int i, b bVar) {
            al.this.f125a.sendMessage(al.this.f125a.obtainMessage(i, bVar));
        }

        public void a(b bVar) {
            try {
                this.f129a.add(bVar);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            long j = al.this.a > 0 ? al.this.a : Long.MAX_VALUE;
            while (!al.this.f128a) {
                try {
                    b poll = this.f129a.poll(j, TimeUnit.SECONDS);
                    al.this.f127a = poll;
                    if (poll != null) {
                        a(0, poll);
                        poll.b();
                        a(1, poll);
                    } else if (al.this.a > 0) {
                        al.this.a();
                    }
                } catch (InterruptedException e) {
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static abstract class b {
        public void a() {
        }

        public abstract void b();

        /* renamed from: c */
        public void mo206c() {
        }
    }

    public al() {
        this(false);
    }

    public al(boolean z) {
        this(z, 0);
    }

    public al(boolean z, int i) {
        this.f125a = null;
        this.f128a = false;
        this.a = 0;
        this.f125a = new am(this, Looper.getMainLooper());
        this.b = z;
        this.a = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a() {
        this.f126a = null;
        this.f128a = true;
    }

    public synchronized void a(b bVar) {
        if (this.f126a == null) {
            this.f126a = new a();
            this.f126a.setDaemon(this.b);
            this.f128a = false;
            this.f126a.start();
        }
        this.f126a.a(bVar);
    }

    public void a(b bVar, long j) {
        this.f125a.postDelayed(new an(this, bVar), j);
    }
}
