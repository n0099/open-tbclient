package com.xiaomi.push;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
/* loaded from: classes6.dex */
public class al {

    /* renamed from: a  reason: collision with root package name */
    private int f13857a;

    /* renamed from: a  reason: collision with other field name */
    private Handler f178a;

    /* renamed from: a  reason: collision with other field name */
    private a f179a;

    /* renamed from: a  reason: collision with other field name */
    private volatile b f180a;

    /* renamed from: a  reason: collision with other field name */
    private volatile boolean f181a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f13858b;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class a extends Thread {

        /* renamed from: a  reason: collision with other field name */
        private final LinkedBlockingQueue<b> f182a;

        public a() {
            super("PackageProcessor");
            this.f182a = new LinkedBlockingQueue<>();
        }

        private void a(int i, b bVar) {
            try {
                al.this.f178a.sendMessage(al.this.f178a.obtainMessage(i, bVar));
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
            }
        }

        public void a(b bVar) {
            try {
                this.f182a.add(bVar);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            long j = al.this.f13857a > 0 ? al.this.f13857a : Long.MAX_VALUE;
            while (!al.this.f181a) {
                try {
                    b poll = this.f182a.poll(j, TimeUnit.SECONDS);
                    al.this.f180a = poll;
                    if (poll != null) {
                        a(0, poll);
                        poll.b();
                        a(1, poll);
                    } else if (al.this.f13857a > 0) {
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
        public void mo255c() {
        }
    }

    public al() {
        this(false);
    }

    public al(boolean z) {
        this(z, 0);
    }

    public al(boolean z, int i) {
        this.f178a = null;
        this.f181a = false;
        this.f13857a = 0;
        this.f178a = new am(this, Looper.getMainLooper());
        this.f13858b = z;
        this.f13857a = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a() {
        this.f179a = null;
        this.f181a = true;
    }

    public synchronized void a(b bVar) {
        if (this.f179a == null) {
            this.f179a = new a();
            this.f179a.setDaemon(this.f13858b);
            this.f181a = false;
            this.f179a.start();
        }
        this.f179a.a(bVar);
    }

    public void a(b bVar, long j) {
        this.f178a.postDelayed(new an(this, bVar), j);
    }
}
