package com.xiaomi.push;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
/* loaded from: classes6.dex */
public class al {
    private int a;

    /* renamed from: a  reason: collision with other field name */
    private Handler f123a;

    /* renamed from: a  reason: collision with other field name */
    private a f124a;

    /* renamed from: a  reason: collision with other field name */
    private volatile b f125a;

    /* renamed from: a  reason: collision with other field name */
    private volatile boolean f126a;
    private final boolean b;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class a extends Thread {

        /* renamed from: a  reason: collision with other field name */
        private final LinkedBlockingQueue<b> f127a;

        public a() {
            super("PackageProcessor");
            this.f127a = new LinkedBlockingQueue<>();
        }

        private void a(int i, b bVar) {
            al.this.f123a.sendMessage(al.this.f123a.obtainMessage(i, bVar));
        }

        public void a(b bVar) {
            try {
                this.f127a.add(bVar);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            long j = al.this.a > 0 ? al.this.a : Long.MAX_VALUE;
            while (!al.this.f126a) {
                try {
                    b poll = this.f127a.poll(j, TimeUnit.SECONDS);
                    al.this.f125a = poll;
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
        this.f123a = null;
        this.f126a = false;
        this.a = 0;
        this.f123a = new am(this, Looper.getMainLooper());
        this.b = z;
        this.a = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a() {
        this.f124a = null;
        this.f126a = true;
    }

    public synchronized void a(b bVar) {
        if (this.f124a == null) {
            this.f124a = new a();
            this.f124a.setDaemon(this.b);
            this.f126a = false;
            this.f124a.start();
        }
        this.f124a.a(bVar);
    }

    public void a(b bVar, long j) {
        this.f123a.postDelayed(new an(this, bVar), j);
    }
}
