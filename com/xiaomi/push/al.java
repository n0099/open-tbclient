package com.xiaomi.push;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
/* loaded from: classes12.dex */
public class al {

    /* renamed from: a  reason: collision with root package name */
    private int f4793a;

    /* renamed from: a  reason: collision with other field name */
    private Handler f99a;

    /* renamed from: a  reason: collision with other field name */
    private a f100a;

    /* renamed from: a  reason: collision with other field name */
    private volatile b f101a;

    /* renamed from: a  reason: collision with other field name */
    private volatile boolean f102a;
    private final boolean b;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public class a extends Thread {

        /* renamed from: a  reason: collision with other field name */
        private final LinkedBlockingQueue<b> f103a;

        public a() {
            super("PackageProcessor");
            this.f103a = new LinkedBlockingQueue<>();
        }

        private void a(int i, b bVar) {
            try {
                al.this.f99a.sendMessage(al.this.f99a.obtainMessage(i, bVar));
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
            }
        }

        public void a(b bVar) {
            try {
                this.f103a.add(bVar);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            long j = al.this.f4793a > 0 ? al.this.f4793a : Long.MAX_VALUE;
            while (!al.this.f102a) {
                try {
                    b poll = this.f103a.poll(j, TimeUnit.SECONDS);
                    al.this.f101a = poll;
                    if (poll != null) {
                        a(0, poll);
                        poll.b();
                        a(1, poll);
                    } else if (al.this.f4793a > 0) {
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
        this.f99a = null;
        this.f102a = false;
        this.f4793a = 0;
        this.f99a = new am(this, Looper.getMainLooper());
        this.b = z;
        this.f4793a = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a() {
        this.f100a = null;
        this.f102a = true;
    }

    public synchronized void a(b bVar) {
        if (this.f100a == null) {
            this.f100a = new a();
            this.f100a.setDaemon(this.b);
            this.f102a = false;
            this.f100a.start();
        }
        this.f100a.a(bVar);
    }

    public void a(b bVar, long j) {
        this.f99a.postDelayed(new an(this, bVar), j);
    }
}
