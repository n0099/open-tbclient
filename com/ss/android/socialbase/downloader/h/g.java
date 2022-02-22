package com.ss.android.socialbase.downloader.h;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes4.dex */
public class g {
    public Object a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public Queue<b> f60305b = new ConcurrentLinkedQueue();

    /* renamed from: c  reason: collision with root package name */
    public a f60306c;

    /* renamed from: d  reason: collision with root package name */
    public Handler f60307d;

    /* loaded from: classes4.dex */
    public class a extends HandlerThread {
        public a(String str) {
            super(str);
        }

        @Override // android.os.HandlerThread
        public void onLooperPrepared() {
            super.onLooperPrepared();
            Looper looper = getLooper();
            synchronized (g.this.a) {
                g.this.f60307d = new Handler(looper);
            }
            while (!g.this.f60305b.isEmpty()) {
                b bVar = (b) g.this.f60305b.poll();
                g.this.f60307d.postDelayed(bVar.a, bVar.f60308b);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b {
        public Runnable a;

        /* renamed from: b  reason: collision with root package name */
        public long f60308b;

        public b(Runnable runnable, long j2) {
            this.a = runnable;
            this.f60308b = j2;
        }
    }

    public g(String str) {
        this.f60306c = new a(str);
    }

    public void b() {
        this.f60306c.quit();
    }

    public void a() {
        this.f60306c.start();
    }

    public void a(Runnable runnable) {
        a(runnable, 0L);
    }

    public void a(Runnable runnable, long j2) {
        if (this.f60307d == null) {
            synchronized (this.a) {
                if (this.f60307d == null) {
                    this.f60305b.add(new b(runnable, j2));
                    return;
                }
            }
        }
        this.f60307d.postDelayed(runnable, j2);
    }
}
