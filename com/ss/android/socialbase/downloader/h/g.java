package com.ss.android.socialbase.downloader.h;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes3.dex */
public class g {
    public Object a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public Queue<b> f62450b = new ConcurrentLinkedQueue();

    /* renamed from: c  reason: collision with root package name */
    public a f62451c;

    /* renamed from: d  reason: collision with root package name */
    public Handler f62452d;

    /* loaded from: classes3.dex */
    public class a extends HandlerThread {
        public a(String str) {
            super(str);
        }

        @Override // android.os.HandlerThread
        public void onLooperPrepared() {
            super.onLooperPrepared();
            Looper looper = getLooper();
            synchronized (g.this.a) {
                g.this.f62452d = new Handler(looper);
            }
            while (!g.this.f62450b.isEmpty()) {
                b bVar = (b) g.this.f62450b.poll();
                g.this.f62452d.postDelayed(bVar.a, bVar.f62453b);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b {
        public Runnable a;

        /* renamed from: b  reason: collision with root package name */
        public long f62453b;

        public b(Runnable runnable, long j2) {
            this.a = runnable;
            this.f62453b = j2;
        }
    }

    public g(String str) {
        this.f62451c = new a(str);
    }

    public void b() {
        this.f62451c.quit();
    }

    public void a() {
        this.f62451c.start();
    }

    public void a(Runnable runnable) {
        a(runnable, 0L);
    }

    public void a(Runnable runnable, long j2) {
        if (this.f62452d == null) {
            synchronized (this.a) {
                if (this.f62452d == null) {
                    this.f62450b.add(new b(runnable, j2));
                    return;
                }
            }
        }
        this.f62452d.postDelayed(runnable, j2);
    }
}
