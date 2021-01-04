package com.ss.android.socialbase.appdownloader;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.a.a;
import java.util.ArrayDeque;
import java.util.Queue;
/* loaded from: classes4.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    private Queue<Integer> f13352a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f13353b;
    private long c;
    private long d;
    private Handler e;
    private Runnable f;

    private h() {
        this.f13352a = new ArrayDeque();
        this.f13353b = false;
        this.e = new Handler(Looper.getMainLooper());
        this.f = new Runnable() { // from class: com.ss.android.socialbase.appdownloader.h.1
            @Override // java.lang.Runnable
            public void run() {
                h.this.b();
            }
        };
        com.ss.android.socialbase.downloader.a.a.eGL().a(new a.InterfaceC1203a() { // from class: com.ss.android.socialbase.appdownloader.h.2
            @Override // com.ss.android.socialbase.downloader.a.a.InterfaceC1203a
            public void b() {
                if (System.currentTimeMillis() - h.this.d >= com.ss.android.socialbase.downloader.k.a.eJs().a("install_on_resume_install_interval", 300000L)) {
                    h.this.d = System.currentTimeMillis();
                    h.this.b();
                }
            }

            @Override // com.ss.android.socialbase.downloader.a.a.InterfaceC1203a
            public void c() {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        final Integer poll = this.f13352a.poll();
        this.e.removeCallbacks(this.f);
        if (poll != null) {
            final Context eHp = com.ss.android.socialbase.downloader.downloader.b.eHp();
            if (Looper.myLooper() != Looper.getMainLooper()) {
                this.e.post(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.h.3
                    @Override // java.lang.Runnable
                    public void run() {
                        h.this.g(eHp, poll.intValue(), false);
                    }
                });
            } else {
                g(eHp, poll.intValue(), false);
            }
            this.e.postDelayed(this.f, 20000L);
            return;
        }
        this.f13353b = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(com.ss.android.socialbase.downloader.g.c cVar, String str) {
        if (cVar != null && !TextUtils.isEmpty(str)) {
            b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class a {
        private static final h pWO = new h();
    }

    public static h eGJ() {
        return a.pWO;
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
        } else if (com.ss.android.socialbase.downloader.a.a.eGL().b()) {
            return g(context, i, z);
        } else {
            if (this.f13352a.isEmpty() && !this.f13353b) {
                return g(context, i, z);
            }
            int a2 = com.ss.android.socialbase.downloader.k.a.eJs().a("install_queue_size", 3);
            while (this.f13352a.size() > a2) {
                this.f13352a.poll();
            }
            this.e.removeCallbacks(this.f);
            this.e.postDelayed(this.f, com.ss.android.socialbase.downloader.k.a.SR(i).a("install_queue_timeout", 20000L));
            if (this.f13352a.contains(Integer.valueOf(i))) {
                return 1;
            }
            this.f13352a.offer(Integer.valueOf(i));
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
            this.f13353b = true;
        }
        this.c = System.currentTimeMillis();
        return g;
    }
}
