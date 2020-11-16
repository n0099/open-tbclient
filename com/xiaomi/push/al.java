package com.xiaomi.push;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
/* loaded from: classes18.dex */
public class al {

    /* renamed from: a  reason: collision with root package name */
    private int f4793a;

    /* renamed from: a  reason: collision with other field name */
    private Handler f102a;

    /* renamed from: a  reason: collision with other field name */
    private a f103a;

    /* renamed from: a  reason: collision with other field name */
    private volatile b f104a;

    /* renamed from: a  reason: collision with other field name */
    private volatile boolean f105a;
    private final boolean b;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes18.dex */
    public class a extends Thread {

        /* renamed from: a  reason: collision with other field name */
        private final LinkedBlockingQueue<b> f106a;

        public a() {
            super("PackageProcessor");
            this.f106a = new LinkedBlockingQueue<>();
        }

        private void a(int i, b bVar) {
            try {
                al.this.f102a.sendMessage(al.this.f102a.obtainMessage(i, bVar));
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
            }
        }

        public void a(b bVar) {
            try {
                this.f106a.add(bVar);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            long j = al.this.f4793a > 0 ? al.this.f4793a : Long.MAX_VALUE;
            while (!al.this.f105a) {
                try {
                    b poll = this.f106a.poll(j, TimeUnit.SECONDS);
                    al.this.f104a = poll;
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

    /* loaded from: classes18.dex */
    public static abstract class b {
        public void a() {
        }

        public abstract void b();

        /* renamed from: c */
        public void mo232c() {
        }
    }

    public al() {
        this(false);
    }

    public al(boolean z) {
        this(z, 0);
    }

    public al(boolean z, int i) {
        this.f102a = null;
        this.f105a = false;
        this.f4793a = 0;
        this.f102a = new am(this, Looper.getMainLooper());
        this.b = z;
        this.f4793a = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a() {
        this.f103a = null;
        this.f105a = true;
    }

    public synchronized void a(b bVar) {
        if (this.f103a == null) {
            this.f103a = new a();
            this.f103a.setDaemon(this.b);
            this.f105a = false;
            this.f103a.start();
        }
        this.f103a.a(bVar);
    }

    public void a(b bVar, long j) {
        this.f102a.postDelayed(new an(this, bVar), j);
    }
}
