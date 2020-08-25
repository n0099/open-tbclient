package com.xiaomi.push;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
/* loaded from: classes7.dex */
public class al {
    private int a;

    /* renamed from: a  reason: collision with other field name */
    private Handler f101a;

    /* renamed from: a  reason: collision with other field name */
    private a f102a;

    /* renamed from: a  reason: collision with other field name */
    private volatile b f103a;

    /* renamed from: a  reason: collision with other field name */
    private volatile boolean f104a;
    private final boolean b;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class a extends Thread {

        /* renamed from: a  reason: collision with other field name */
        private final LinkedBlockingQueue<b> f105a;

        public a() {
            super("PackageProcessor");
            this.f105a = new LinkedBlockingQueue<>();
        }

        private void a(int i, b bVar) {
            try {
                al.this.f101a.sendMessage(al.this.f101a.obtainMessage(i, bVar));
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
            }
        }

        public void a(b bVar) {
            try {
                this.f105a.add(bVar);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            long j = al.this.a > 0 ? al.this.a : Long.MAX_VALUE;
            while (!al.this.f104a) {
                try {
                    b poll = this.f105a.poll(j, TimeUnit.SECONDS);
                    al.this.f103a = poll;
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

    /* loaded from: classes7.dex */
    public static abstract class b {
        public void a() {
        }

        public abstract void b();

        /* renamed from: c */
        public void mo229c() {
        }
    }

    public al() {
        this(false);
    }

    public al(boolean z) {
        this(z, 0);
    }

    public al(boolean z, int i) {
        this.f101a = null;
        this.f104a = false;
        this.a = 0;
        this.f101a = new am(this, Looper.getMainLooper());
        this.b = z;
        this.a = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a() {
        this.f102a = null;
        this.f104a = true;
    }

    public synchronized void a(b bVar) {
        if (this.f102a == null) {
            this.f102a = new a();
            this.f102a.setDaemon(this.b);
            this.f104a = false;
            this.f102a.start();
        }
        this.f102a.a(bVar);
    }

    public void a(b bVar, long j) {
        this.f101a.postDelayed(new an(this, bVar), j);
    }
}
