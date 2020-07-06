package com.xiaomi.push;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
/* loaded from: classes8.dex */
public class al {
    private int a;

    /* renamed from: a  reason: collision with other field name */
    private Handler f105a;

    /* renamed from: a  reason: collision with other field name */
    private a f106a;

    /* renamed from: a  reason: collision with other field name */
    private volatile b f107a;

    /* renamed from: a  reason: collision with other field name */
    private volatile boolean f108a;
    private final boolean b;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a extends Thread {

        /* renamed from: a  reason: collision with other field name */
        private final LinkedBlockingQueue<b> f109a;

        public a() {
            super("PackageProcessor");
            this.f109a = new LinkedBlockingQueue<>();
        }

        private void a(int i, b bVar) {
            try {
                al.this.f105a.sendMessage(al.this.f105a.obtainMessage(i, bVar));
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
            }
        }

        public void a(b bVar) {
            try {
                this.f109a.add(bVar);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            long j = al.this.a > 0 ? al.this.a : Long.MAX_VALUE;
            while (!al.this.f108a) {
                try {
                    b poll = this.f109a.poll(j, TimeUnit.SECONDS);
                    al.this.f107a = poll;
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
        this.f105a = null;
        this.f108a = false;
        this.a = 0;
        this.f105a = new am(this, Looper.getMainLooper());
        this.b = z;
        this.a = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a() {
        this.f106a = null;
        this.f108a = true;
    }

    public synchronized void a(b bVar) {
        if (this.f106a == null) {
            this.f106a = new a();
            this.f106a.setDaemon(this.b);
            this.f108a = false;
            this.f106a.start();
        }
        this.f106a.a(bVar);
    }

    public void a(b bVar, long j) {
        this.f105a.postDelayed(new an(this, bVar), j);
    }
}
