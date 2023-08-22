package com.xiaomi.push;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
/* loaded from: classes10.dex */
public class am {
    public int a;

    /* renamed from: a  reason: collision with other field name */
    public Handler f104a;

    /* renamed from: a  reason: collision with other field name */
    public a f105a;

    /* renamed from: a  reason: collision with other field name */
    public volatile b f106a;

    /* renamed from: a  reason: collision with other field name */
    public volatile boolean f107a;
    public final boolean b;

    /* loaded from: classes10.dex */
    public class a extends Thread {

        /* renamed from: a  reason: collision with other field name */
        public final LinkedBlockingQueue<b> f108a;

        public a() {
            super("PackageProcessor");
            this.f108a = new LinkedBlockingQueue<>();
        }

        private void a(int i, b bVar) {
            try {
                am.this.f104a.sendMessage(am.this.f104a.obtainMessage(i, bVar));
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
            long j = am.this.a > 0 ? am.this.a : Long.MAX_VALUE;
            while (!am.this.f107a) {
                try {
                    b poll = this.f108a.poll(j, TimeUnit.SECONDS);
                    am.this.f106a = poll;
                    if (poll != null) {
                        a(0, poll);
                        poll.b();
                        a(1, poll);
                    } else if (am.this.a > 0) {
                        am.this.a();
                    }
                } catch (InterruptedException e) {
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public static abstract class b {
        public void a() {
        }

        public abstract void b();

        /* renamed from: c */
        public void mo359c() {
        }
    }

    public am() {
        this(false);
    }

    public am(boolean z) {
        this(z, 0);
    }

    public am(boolean z, int i) {
        this.f104a = null;
        this.f107a = false;
        this.a = 0;
        this.f104a = new an(this, Looper.getMainLooper());
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
            a aVar = new a();
            this.f105a = aVar;
            aVar.setDaemon(this.b);
            this.f107a = false;
            this.f105a.start();
        }
        this.f105a.a(bVar);
    }

    public void a(b bVar, long j) {
        this.f104a.postDelayed(new ao(this, bVar), j);
    }
}
