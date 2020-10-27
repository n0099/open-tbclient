package com.xiaomi.push;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
/* loaded from: classes12.dex */
public class al {

    /* renamed from: a  reason: collision with root package name */
    private int f4791a;

    /* renamed from: a  reason: collision with other field name */
    private Handler f97a;

    /* renamed from: a  reason: collision with other field name */
    private a f98a;

    /* renamed from: a  reason: collision with other field name */
    private volatile b f99a;

    /* renamed from: a  reason: collision with other field name */
    private volatile boolean f100a;
    private final boolean b;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public class a extends Thread {

        /* renamed from: a  reason: collision with other field name */
        private final LinkedBlockingQueue<b> f101a;

        public a() {
            super("PackageProcessor");
            this.f101a = new LinkedBlockingQueue<>();
        }

        private void a(int i, b bVar) {
            try {
                al.this.f97a.sendMessage(al.this.f97a.obtainMessage(i, bVar));
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
            }
        }

        public void a(b bVar) {
            try {
                this.f101a.add(bVar);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            long j = al.this.f4791a > 0 ? al.this.f4791a : Long.MAX_VALUE;
            while (!al.this.f100a) {
                try {
                    b poll = this.f101a.poll(j, TimeUnit.SECONDS);
                    al.this.f99a = poll;
                    if (poll != null) {
                        a(0, poll);
                        poll.b();
                        a(1, poll);
                    } else if (al.this.f4791a > 0) {
                        al.this.a();
                    }
                } catch (InterruptedException e) {
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                }
            }
        }
    }

    /* loaded from: classes12.dex */
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
        this.f97a = null;
        this.f100a = false;
        this.f4791a = 0;
        this.f97a = new am(this, Looper.getMainLooper());
        this.b = z;
        this.f4791a = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a() {
        this.f98a = null;
        this.f100a = true;
    }

    public synchronized void a(b bVar) {
        if (this.f98a == null) {
            this.f98a = new a();
            this.f98a.setDaemon(this.b);
            this.f100a = false;
            this.f98a.start();
        }
        this.f98a.a(bVar);
    }

    public void a(b bVar, long j) {
        this.f97a.postDelayed(new an(this, bVar), j);
    }
}
