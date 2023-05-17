package com.ss.android.socialbase.downloader.h;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes10.dex */
public class g {
    public Object a = new Object();
    public Queue<b> b = new ConcurrentLinkedQueue();
    public a c;
    public Handler d;

    /* loaded from: classes10.dex */
    public class a extends HandlerThread {
        public a(String str) {
            super(str);
        }

        @Override // android.os.HandlerThread
        public void onLooperPrepared() {
            super.onLooperPrepared();
            Looper looper = getLooper();
            synchronized (g.this.a) {
                g.this.d = new Handler(looper);
            }
            while (!g.this.b.isEmpty()) {
                b bVar = (b) g.this.b.poll();
                g.this.d.postDelayed(bVar.a, bVar.b);
            }
        }
    }

    /* loaded from: classes10.dex */
    public class b {
        public Runnable a;
        public long b;

        public b(Runnable runnable, long j) {
            this.a = runnable;
            this.b = j;
        }
    }

    public g(String str) {
        this.c = new a(str);
    }

    public void a() {
        this.c.start();
    }

    public void b() {
        this.c.quit();
    }

    public void a(Runnable runnable) {
        a(runnable, 0L);
    }

    public void a(Runnable runnable, long j) {
        if (this.d == null) {
            synchronized (this.a) {
                if (this.d == null) {
                    this.b.add(new b(runnable, j));
                    return;
                }
            }
        }
        this.d.postDelayed(runnable, j);
    }
}
