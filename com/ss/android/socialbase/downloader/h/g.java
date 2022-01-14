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
    public Queue<b> f60093b = new ConcurrentLinkedQueue();

    /* renamed from: c  reason: collision with root package name */
    public a f60094c;

    /* renamed from: d  reason: collision with root package name */
    public Handler f60095d;

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
                g.this.f60095d = new Handler(looper);
            }
            while (!g.this.f60093b.isEmpty()) {
                b bVar = (b) g.this.f60093b.poll();
                g.this.f60095d.postDelayed(bVar.a, bVar.f60096b);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b {
        public Runnable a;

        /* renamed from: b  reason: collision with root package name */
        public long f60096b;

        public b(Runnable runnable, long j2) {
            this.a = runnable;
            this.f60096b = j2;
        }
    }

    public g(String str) {
        this.f60094c = new a(str);
    }

    public void b() {
        this.f60094c.quit();
    }

    public void a() {
        this.f60094c.start();
    }

    public void a(Runnable runnable) {
        a(runnable, 0L);
    }

    public void a(Runnable runnable, long j2) {
        if (this.f60095d == null) {
            synchronized (this.a) {
                if (this.f60095d == null) {
                    this.f60093b.add(new b(runnable, j2));
                    return;
                }
            }
        }
        this.f60095d.postDelayed(runnable, j2);
    }
}
