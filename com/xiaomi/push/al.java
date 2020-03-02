package com.xiaomi.push;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
/* loaded from: classes8.dex */
public class al {
    private int a;

    /* renamed from: a  reason: collision with other field name */
    private Handler f120a;

    /* renamed from: a  reason: collision with other field name */
    private a f121a;

    /* renamed from: a  reason: collision with other field name */
    private volatile b f122a;

    /* renamed from: a  reason: collision with other field name */
    private volatile boolean f123a;
    private final boolean b;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a extends Thread {

        /* renamed from: a  reason: collision with other field name */
        private final LinkedBlockingQueue<b> f124a;

        public a() {
            super("PackageProcessor");
            this.f124a = new LinkedBlockingQueue<>();
        }

        private void a(int i, b bVar) {
            al.this.f120a.sendMessage(al.this.f120a.obtainMessage(i, bVar));
        }

        public void a(b bVar) {
            try {
                this.f124a.add(bVar);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            long j = al.this.a > 0 ? al.this.a : Long.MAX_VALUE;
            while (!al.this.f123a) {
                try {
                    b poll = this.f124a.poll(j, TimeUnit.SECONDS);
                    al.this.f122a = poll;
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

    /* loaded from: classes8.dex */
    public static abstract class b {
        public void a() {
        }

        public abstract void b();

        /* renamed from: c */
        public void mo220c() {
        }
    }

    public al() {
        this(false);
    }

    public al(boolean z) {
        this(z, 0);
    }

    public al(boolean z, int i) {
        this.f120a = null;
        this.f123a = false;
        this.a = 0;
        this.f120a = new am(this, Looper.getMainLooper());
        this.b = z;
        this.a = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a() {
        this.f121a = null;
        this.f123a = true;
    }

    public synchronized void a(b bVar) {
        if (this.f121a == null) {
            this.f121a = new a();
            this.f121a.setDaemon(this.b);
            this.f123a = false;
            this.f121a.start();
        }
        this.f121a.a(bVar);
    }

    public void a(b bVar, long j) {
        this.f120a.postDelayed(new an(this, bVar), j);
    }
}
