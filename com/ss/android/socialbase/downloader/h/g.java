package com.ss.android.socialbase.downloader.h;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes7.dex */
public class g {
    public Object a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public Queue<b> f43359b = new ConcurrentLinkedQueue();

    /* renamed from: c  reason: collision with root package name */
    public a f43360c;

    /* renamed from: d  reason: collision with root package name */
    public Handler f43361d;

    /* loaded from: classes7.dex */
    public class a extends HandlerThread {
        public a(String str) {
            super(str);
        }

        @Override // android.os.HandlerThread
        public void onLooperPrepared() {
            super.onLooperPrepared();
            Looper looper = getLooper();
            synchronized (g.this.a) {
                g.this.f43361d = new Handler(looper);
            }
            while (!g.this.f43359b.isEmpty()) {
                b bVar = (b) g.this.f43359b.poll();
                g.this.f43361d.postDelayed(bVar.a, bVar.f43362b);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b {
        public Runnable a;

        /* renamed from: b  reason: collision with root package name */
        public long f43362b;

        public b(Runnable runnable, long j) {
            this.a = runnable;
            this.f43362b = j;
        }
    }

    public g(String str) {
        this.f43360c = new a(str);
    }

    public void b() {
        this.f43360c.quit();
    }

    public void a() {
        this.f43360c.start();
    }

    public void a(Runnable runnable) {
        a(runnable, 0L);
    }

    public void a(Runnable runnable, long j) {
        if (this.f43361d == null) {
            synchronized (this.a) {
                if (this.f43361d == null) {
                    this.f43359b.add(new b(runnable, j));
                    return;
                }
            }
        }
        this.f43361d.postDelayed(runnable, j);
    }
}
