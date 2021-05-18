package com.xiaomi.push;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
/* loaded from: classes7.dex */
public class al {

    /* renamed from: a  reason: collision with root package name */
    public int f37372a;

    /* renamed from: a  reason: collision with other field name */
    public Handler f109a;

    /* renamed from: a  reason: collision with other field name */
    public a f110a;

    /* renamed from: a  reason: collision with other field name */
    public volatile b f111a;

    /* renamed from: a  reason: collision with other field name */
    public volatile boolean f112a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f37373b;

    /* loaded from: classes7.dex */
    public class a extends Thread {

        /* renamed from: a  reason: collision with other field name */
        public final LinkedBlockingQueue<b> f113a;

        public a() {
            super("PackageProcessor");
            this.f113a = new LinkedBlockingQueue<>();
        }

        private void a(int i2, b bVar) {
            try {
                al.this.f109a.sendMessage(al.this.f109a.obtainMessage(i2, bVar));
            } catch (Exception e2) {
                com.xiaomi.channel.commonutils.logger.b.a(e2);
            }
        }

        public void a(b bVar) {
            try {
                this.f113a.add(bVar);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            long j = al.this.f37372a > 0 ? al.this.f37372a : Long.MAX_VALUE;
            while (!al.this.f112a) {
                try {
                    b poll = this.f113a.poll(j, TimeUnit.SECONDS);
                    al.this.f111a = poll;
                    if (poll != null) {
                        a(0, poll);
                        poll.b();
                        a(1, poll);
                    } else if (al.this.f37372a > 0) {
                        al.this.a();
                    }
                } catch (InterruptedException e2) {
                    com.xiaomi.channel.commonutils.logger.b.a(e2);
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

    public al(boolean z, int i2) {
        this.f109a = null;
        this.f112a = false;
        this.f37372a = 0;
        this.f109a = new am(this, Looper.getMainLooper());
        this.f37373b = z;
        this.f37372a = i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a() {
        this.f110a = null;
        this.f112a = true;
    }

    public synchronized void a(b bVar) {
        if (this.f110a == null) {
            a aVar = new a();
            this.f110a = aVar;
            aVar.setDaemon(this.f37373b);
            this.f112a = false;
            this.f110a.start();
        }
        this.f110a.a(bVar);
    }

    public void a(b bVar, long j) {
        this.f109a.postDelayed(new an(this, bVar), j);
    }
}
