package com.xiaomi.push;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
/* loaded from: classes8.dex */
public class al {
    private int a;

    /* renamed from: a  reason: collision with other field name */
    private Handler f98a;

    /* renamed from: a  reason: collision with other field name */
    private a f99a;

    /* renamed from: a  reason: collision with other field name */
    private volatile b f100a;

    /* renamed from: a  reason: collision with other field name */
    private volatile boolean f101a;
    private final boolean b;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a extends Thread {

        /* renamed from: a  reason: collision with other field name */
        private final LinkedBlockingQueue<b> f102a;

        public a() {
            super("PackageProcessor");
            this.f102a = new LinkedBlockingQueue<>();
        }

        private void a(int i, b bVar) {
            try {
                al.this.f98a.sendMessage(al.this.f98a.obtainMessage(i, bVar));
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
            }
        }

        public void a(b bVar) {
            try {
                this.f102a.add(bVar);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            long j = al.this.a > 0 ? al.this.a : Long.MAX_VALUE;
            while (!al.this.f101a) {
                try {
                    b poll = this.f102a.poll(j, TimeUnit.SECONDS);
                    al.this.f100a = poll;
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
        public void mo226c() {
        }
    }

    public al() {
        this(false);
    }

    public al(boolean z) {
        this(z, 0);
    }

    public al(boolean z, int i) {
        this.f98a = null;
        this.f101a = false;
        this.a = 0;
        this.f98a = new am(this, Looper.getMainLooper());
        this.b = z;
        this.a = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a() {
        this.f99a = null;
        this.f101a = true;
    }

    public synchronized void a(b bVar) {
        if (this.f99a == null) {
            this.f99a = new a();
            this.f99a.setDaemon(this.b);
            this.f101a = false;
            this.f99a.start();
        }
        this.f99a.a(bVar);
    }

    public void a(b bVar, long j) {
        this.f98a.postDelayed(new an(this, bVar), j);
    }
}
