package com.xiaomi.push;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
/* loaded from: classes8.dex */
public class al {
    private int a;

    /* renamed from: a  reason: collision with other field name */
    private Handler f104a;

    /* renamed from: a  reason: collision with other field name */
    private a f105a;

    /* renamed from: a  reason: collision with other field name */
    private volatile b f106a;

    /* renamed from: a  reason: collision with other field name */
    private volatile boolean f107a;
    private final boolean b;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a extends Thread {

        /* renamed from: a  reason: collision with other field name */
        private final LinkedBlockingQueue<b> f108a;

        public a() {
            super("PackageProcessor");
            this.f108a = new LinkedBlockingQueue<>();
        }

        private void a(int i, b bVar) {
            try {
                al.this.f104a.sendMessage(al.this.f104a.obtainMessage(i, bVar));
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
            }
        }

        public void a(b bVar) {
            try {
                this.f108a.add(bVar);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            long j = al.this.a > 0 ? al.this.a : Long.MAX_VALUE;
            while (!al.this.f107a) {
                try {
                    b poll = this.f108a.poll(j, TimeUnit.SECONDS);
                    al.this.f106a = poll;
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
        public void mo223c() {
        }
    }

    public al() {
        this(false);
    }

    public al(boolean z) {
        this(z, 0);
    }

    public al(boolean z, int i) {
        this.f104a = null;
        this.f107a = false;
        this.a = 0;
        this.f104a = new am(this, Looper.getMainLooper());
        this.b = z;
        this.a = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a() {
        this.f105a = null;
        this.f107a = true;
    }

    public synchronized void a(b bVar) {
        if (this.f105a == null) {
            this.f105a = new a();
            this.f105a.setDaemon(this.b);
            this.f107a = false;
            this.f105a.start();
        }
        this.f105a.a(bVar);
    }

    public void a(b bVar, long j) {
        this.f104a.postDelayed(new an(this, bVar), j);
    }
}
