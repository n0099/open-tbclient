package com.ss.android.socialbase.downloader.h;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes8.dex */
public class g {
    public Object a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public Queue<b> f58655b = new ConcurrentLinkedQueue();

    /* renamed from: c  reason: collision with root package name */
    public a f58656c;

    /* renamed from: d  reason: collision with root package name */
    public Handler f58657d;

    /* loaded from: classes8.dex */
    public class a extends HandlerThread {
        public a(String str) {
            super(str);
        }

        @Override // android.os.HandlerThread
        public void onLooperPrepared() {
            super.onLooperPrepared();
            Looper looper = getLooper();
            synchronized (g.this.a) {
                g.this.f58657d = new Handler(looper);
            }
            while (!g.this.f58655b.isEmpty()) {
                b bVar = (b) g.this.f58655b.poll();
                g.this.f58657d.postDelayed(bVar.a, bVar.f58658b);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b {
        public Runnable a;

        /* renamed from: b  reason: collision with root package name */
        public long f58658b;

        public b(Runnable runnable, long j2) {
            this.a = runnable;
            this.f58658b = j2;
        }
    }

    public g(String str) {
        this.f58656c = new a(str);
    }

    public void b() {
        this.f58656c.quit();
    }

    public void a() {
        this.f58656c.start();
    }

    public void a(Runnable runnable) {
        a(runnable, 0L);
    }

    public void a(Runnable runnable, long j2) {
        if (this.f58657d == null) {
            synchronized (this.a) {
                if (this.f58657d == null) {
                    this.f58655b.add(new b(runnable, j2));
                    return;
                }
            }
        }
        this.f58657d.postDelayed(runnable, j2);
    }
}
