package com.xiaomi.push;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
/* loaded from: classes6.dex */
public class al {

    /* renamed from: a  reason: collision with root package name */
    private int f14155a;

    /* renamed from: a  reason: collision with other field name */
    private Handler f179a;

    /* renamed from: a  reason: collision with other field name */
    private a f180a;

    /* renamed from: a  reason: collision with other field name */
    private volatile b f181a;

    /* renamed from: a  reason: collision with other field name */
    private volatile boolean f182a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f14156b;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class a extends Thread {

        /* renamed from: a  reason: collision with other field name */
        private final LinkedBlockingQueue<b> f183a;

        public a() {
            super("PackageProcessor");
            this.f183a = new LinkedBlockingQueue<>();
        }

        private void a(int i, b bVar) {
            try {
                al.this.f179a.sendMessage(al.this.f179a.obtainMessage(i, bVar));
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
            }
        }

        public void a(b bVar) {
            try {
                this.f183a.add(bVar);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            long j = al.this.f14155a > 0 ? al.this.f14155a : Long.MAX_VALUE;
            while (!al.this.f182a) {
                try {
                    b poll = this.f183a.poll(j, TimeUnit.SECONDS);
                    al.this.f181a = poll;
                    if (poll != null) {
                        a(0, poll);
                        poll.b();
                        a(1, poll);
                    } else if (al.this.f14155a > 0) {
                        al.this.a();
                    }
                } catch (InterruptedException e) {
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static abstract class b {
        public void a() {
        }

        public abstract void b();

        /* renamed from: c */
        public void mo259c() {
        }
    }

    public al() {
        this(false);
    }

    public al(boolean z) {
        this(z, 0);
    }

    public al(boolean z, int i) {
        this.f179a = null;
        this.f182a = false;
        this.f14155a = 0;
        this.f179a = new am(this, Looper.getMainLooper());
        this.f14156b = z;
        this.f14155a = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a() {
        this.f180a = null;
        this.f182a = true;
    }

    public synchronized void a(b bVar) {
        if (this.f180a == null) {
            this.f180a = new a();
            this.f180a.setDaemon(this.f14156b);
            this.f182a = false;
            this.f180a.start();
        }
        this.f180a.a(bVar);
    }

    public void a(b bVar, long j) {
        this.f179a.postDelayed(new an(this, bVar), j);
    }
}
