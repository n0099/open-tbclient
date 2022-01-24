package com.ss.android.socialbase.appdownloader;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.searchbox.config.AppConfig;
import com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity;
import com.ss.android.socialbase.downloader.a.a;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.lang.ref.SoftReference;
import java.util.ArrayDeque;
import java.util.Queue;
/* loaded from: classes4.dex */
public class h {
    public final Queue<Integer> a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f59852b;

    /* renamed from: c  reason: collision with root package name */
    public long f59853c;

    /* renamed from: d  reason: collision with root package name */
    public long f59854d;

    /* renamed from: e  reason: collision with root package name */
    public SoftReference<JumpUnknownSourceActivity> f59855e;

    /* renamed from: f  reason: collision with root package name */
    public Handler f59856f;

    /* renamed from: g  reason: collision with root package name */
    public Runnable f59857g;

    /* loaded from: classes4.dex */
    public static class a {
        public static final h a = new h();
    }

    public h() {
        this.a = new ArrayDeque();
        this.f59852b = false;
        this.f59856f = new Handler(Looper.getMainLooper());
        this.f59857g = new Runnable() { // from class: com.ss.android.socialbase.appdownloader.h.1
            @Override // java.lang.Runnable
            public void run() {
                h.this.c();
            }
        };
        com.ss.android.socialbase.downloader.a.a.a().a(new a.InterfaceC2203a() { // from class: com.ss.android.socialbase.appdownloader.h.2
            @Override // com.ss.android.socialbase.downloader.a.a.InterfaceC2203a
            public void b() {
                if (h.this.a.isEmpty()) {
                    return;
                }
                long a2 = com.ss.android.socialbase.downloader.g.a.c().a("install_on_resume_install_interval", AppConfig.TIMESTAMP_AVAILABLE_DURATION);
                long currentTimeMillis = System.currentTimeMillis() - h.this.f59854d;
                if (currentTimeMillis < a2) {
                    if (h.this.f59856f.hasCallbacks(h.this.f59857g)) {
                        return;
                    }
                    h.this.f59856f.postDelayed(h.this.f59857g, a2 - currentTimeMillis);
                    return;
                }
                h.this.f59854d = System.currentTimeMillis();
                h.this.c();
            }

            @Override // com.ss.android.socialbase.downloader.a.a.InterfaceC2203a
            public void c() {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int b(Context context, int i2, boolean z) {
        int b2 = c.b(context, i2, z);
        if (b2 == 1) {
            this.f59852b = true;
        }
        this.f59853c = System.currentTimeMillis();
        return b2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        final Integer poll;
        if (Build.VERSION.SDK_INT < 29 || com.ss.android.socialbase.downloader.a.a.a().b()) {
            synchronized (this.a) {
                poll = this.a.poll();
            }
            this.f59856f.removeCallbacks(this.f59857g);
            if (poll != null) {
                final Context N = com.ss.android.socialbase.downloader.downloader.c.N();
                if (Looper.myLooper() != Looper.getMainLooper()) {
                    this.f59856f.post(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.h.3
                        @Override // java.lang.Runnable
                        public void run() {
                            h.this.b(N, poll.intValue(), false);
                        }
                    });
                } else {
                    b(N, poll.intValue(), false);
                }
                this.f59856f.postDelayed(this.f59857g, 20000L);
                return;
            }
            this.f59852b = false;
        }
    }

    private boolean d() {
        return System.currentTimeMillis() - this.f59853c < 1000;
    }

    public void a(DownloadInfo downloadInfo, String str) {
        if (downloadInfo == null || TextUtils.isEmpty(str)) {
            return;
        }
        c();
    }

    public JumpUnknownSourceActivity b() {
        SoftReference<JumpUnknownSourceActivity> softReference = this.f59855e;
        JumpUnknownSourceActivity jumpUnknownSourceActivity = softReference == null ? null : softReference.get();
        this.f59855e = null;
        return jumpUnknownSourceActivity;
    }

    public static h a() {
        return a.a;
    }

    public int a(final Context context, final int i2, final boolean z) {
        if (z) {
            return b(context, i2, z);
        }
        if (d()) {
            this.f59856f.postDelayed(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.h.4
                @Override // java.lang.Runnable
                public void run() {
                    h.this.a(context, i2, z);
                }
            }, 1000L);
            return 1;
        } else if (com.ss.android.socialbase.downloader.a.a.a().b()) {
            com.ss.android.socialbase.downloader.c.a.c("leaves", "on Foreground");
            return b(context, i2, z);
        } else if (b.a()) {
            return 1;
        } else {
            boolean z2 = Build.VERSION.SDK_INT < 29;
            if (this.a.isEmpty() && !this.f59852b && z2) {
                return b(context, i2, z);
            }
            int a2 = com.ss.android.socialbase.downloader.g.a.c().a("install_queue_size", 3);
            synchronized (this.a) {
                while (this.a.size() > a2) {
                    this.a.poll();
                }
            }
            if (z2) {
                this.f59856f.removeCallbacks(this.f59857g);
                this.f59856f.postDelayed(this.f59857g, com.ss.android.socialbase.downloader.g.a.a(i2).a("install_queue_timeout", 20000L));
            }
            synchronized (this.a) {
                if (!this.a.contains(Integer.valueOf(i2))) {
                    this.a.offer(Integer.valueOf(i2));
                }
            }
            return 1;
        }
    }

    public void a(JumpUnknownSourceActivity jumpUnknownSourceActivity) {
        this.f59855e = new SoftReference<>(jumpUnknownSourceActivity);
    }
}
