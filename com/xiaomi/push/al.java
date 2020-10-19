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
    private Handler f100a;

    /* renamed from: a  reason: collision with other field name */
    private a f101a;

    /* renamed from: a  reason: collision with other field name */
    private volatile b f102a;

    /* renamed from: a  reason: collision with other field name */
    private volatile boolean f103a;
    private final boolean b;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public class a extends Thread {

        /* renamed from: a  reason: collision with other field name */
        private final LinkedBlockingQueue<b> f104a;

        public a() {
            super("PackageProcessor");
            this.f104a = new LinkedBlockingQueue<>();
        }

        private void a(int i, b bVar) {
            try {
                al.this.f100a.sendMessage(al.this.f100a.obtainMessage(i, bVar));
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
            }
        }

        public void a(b bVar) {
            try {
                this.f104a.add(bVar);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            long j = al.this.f4793a > 0 ? al.this.f4793a : Long.MAX_VALUE;
            while (!al.this.f103a) {
                try {
                    b poll = this.f104a.poll(j, TimeUnit.SECONDS);
                    al.this.f102a = poll;
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
        public void mo230c() {
        }
    }

    public al() {
        this(false);
    }

    public al(boolean z) {
        this(z, 0);
    }

    public al(boolean z, int i) {
        this.f100a = null;
        this.f103a = false;
        this.f4793a = 0;
        this.f100a = new am(this, Looper.getMainLooper());
        this.b = z;
        this.f4793a = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a() {
        this.f101a = null;
        this.f103a = true;
    }

    public synchronized void a(b bVar) {
        if (this.f101a == null) {
            this.f101a = new a();
            this.f101a.setDaemon(this.b);
            this.f103a = false;
            this.f101a.start();
        }
        this.f101a.a(bVar);
    }

    public void a(b bVar, long j) {
        this.f100a.postDelayed(new an(this, bVar), j);
    }
}
