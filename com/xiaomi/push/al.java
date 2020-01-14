package com.xiaomi.push;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
/* loaded from: classes6.dex */
public class al {
    private int a;

    /* renamed from: a  reason: collision with other field name */
    private Handler f124a;

    /* renamed from: a  reason: collision with other field name */
    private a f125a;

    /* renamed from: a  reason: collision with other field name */
    private volatile b f126a;

    /* renamed from: a  reason: collision with other field name */
    private volatile boolean f127a;
    private final boolean b;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class a extends Thread {

        /* renamed from: a  reason: collision with other field name */
        private final LinkedBlockingQueue<b> f128a;

        public a() {
            super("PackageProcessor");
            this.f128a = new LinkedBlockingQueue<>();
        }

        private void a(int i, b bVar) {
            al.this.f124a.sendMessage(al.this.f124a.obtainMessage(i, bVar));
        }

        public void a(b bVar) {
            try {
                this.f128a.add(bVar);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            long j = al.this.a > 0 ? al.this.a : Long.MAX_VALUE;
            while (!al.this.f127a) {
                try {
                    b poll = this.f128a.poll(j, TimeUnit.SECONDS);
                    al.this.f126a = poll;
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

    /* loaded from: classes6.dex */
    public static abstract class b {
        public void a() {
        }

        public abstract void b();

        /* renamed from: c */
        public void mo215c() {
        }
    }

    public al() {
        this(false);
    }

    public al(boolean z) {
        this(z, 0);
    }

    public al(boolean z, int i) {
        this.f124a = null;
        this.f127a = false;
        this.a = 0;
        this.f124a = new am(this, Looper.getMainLooper());
        this.b = z;
        this.a = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a() {
        this.f125a = null;
        this.f127a = true;
    }

    public synchronized void a(b bVar) {
        if (this.f125a == null) {
            this.f125a = new a();
            this.f125a.setDaemon(this.b);
            this.f127a = false;
            this.f125a.start();
        }
        this.f125a.a(bVar);
    }

    public void a(b bVar, long j) {
        this.f124a.postDelayed(new an(this, bVar), j);
    }
}
