package com.ss.android.socialbase.appdownloader;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.a.a;
import java.util.ArrayDeque;
import java.util.Queue;
/* loaded from: classes6.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    private Queue<Integer> f7769a;
    private boolean b;
    private long c;
    private long d;
    private Handler e;
    private Runnable f;

    private h() {
        this.f7769a = new ArrayDeque();
        this.b = false;
        this.e = new Handler(Looper.getMainLooper());
        this.f = new Runnable() { // from class: com.ss.android.socialbase.appdownloader.h.1
            @Override // java.lang.Runnable
            public void run() {
                h.this.b();
            }
        };
        com.ss.android.socialbase.downloader.a.a.eGc().a(new a.InterfaceC1223a() { // from class: com.ss.android.socialbase.appdownloader.h.2
            @Override // com.ss.android.socialbase.downloader.a.a.InterfaceC1223a
            public void b() {
                if (System.currentTimeMillis() - h.this.d >= com.ss.android.socialbase.downloader.k.a.eIH().a("install_on_resume_install_interval", 300000L)) {
                    h.this.d = System.currentTimeMillis();
                    h.this.b();
                }
            }

            @Override // com.ss.android.socialbase.downloader.a.a.InterfaceC1223a
            public void c() {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        final Integer poll = this.f7769a.poll();
        this.e.removeCallbacks(this.f);
        if (poll != null) {
            final Context eGG = com.ss.android.socialbase.downloader.downloader.b.eGG();
            if (Looper.myLooper() != Looper.getMainLooper()) {
                this.e.post(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.h.3
                    @Override // java.lang.Runnable
                    public void run() {
                        h.this.g(eGG, poll.intValue(), false);
                    }
                });
            } else {
                g(eGG, poll.intValue(), false);
            }
            this.e.postDelayed(this.f, 20000L);
            return;
        }
        this.b = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(com.ss.android.socialbase.downloader.g.c cVar, String str) {
        if (cVar != null && !TextUtils.isEmpty(str)) {
            b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class a {
        private static final h qfq = new h();
    }

    public static h eGa() {
        return a.qfq;
    }

    public int f(final Context context, final int i, final boolean z) {
        if (z) {
            return g(context, i, z);
        }
        if (c()) {
            this.e.postDelayed(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.h.4
                @Override // java.lang.Runnable
                public void run() {
                    h.this.f(context, i, z);
                }
            }, 1000L);
            return 1;
        } else if (com.ss.android.socialbase.downloader.a.a.eGc().b()) {
            return g(context, i, z);
        } else {
            if (this.f7769a.isEmpty() && !this.b) {
                return g(context, i, z);
            }
            int a2 = com.ss.android.socialbase.downloader.k.a.eIH().a("install_queue_size", 3);
            while (this.f7769a.size() > a2) {
                this.f7769a.poll();
            }
            this.e.removeCallbacks(this.f);
            this.e.postDelayed(this.f, com.ss.android.socialbase.downloader.k.a.Sa(i).a("install_queue_timeout", 20000L));
            if (this.f7769a.contains(Integer.valueOf(i))) {
                return 1;
            }
            this.f7769a.offer(Integer.valueOf(i));
            return 1;
        }
    }

    private boolean c() {
        return System.currentTimeMillis() - this.c < 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int g(Context context, int i, boolean z) {
        int g = c.g(context, i, z);
        if (g == 1) {
            this.b = true;
        }
        this.c = System.currentTimeMillis();
        return g;
    }
}
