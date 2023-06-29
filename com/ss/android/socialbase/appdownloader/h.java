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
/* loaded from: classes10.dex */
public class h {
    public final Queue<Integer> a;
    public boolean b;
    public long c;
    public long d;
    public SoftReference<JumpUnknownSourceActivity> e;
    public Handler f;
    public Runnable g;

    /* loaded from: classes10.dex */
    public static class a {
        public static final h a = new h();
    }

    public h() {
        this.a = new ArrayDeque();
        this.b = false;
        this.f = new Handler(Looper.getMainLooper());
        this.g = new Runnable() { // from class: com.ss.android.socialbase.appdownloader.h.1
            @Override // java.lang.Runnable
            public void run() {
                h.this.c();
            }
        };
        com.ss.android.socialbase.downloader.a.a.a().a(new a.InterfaceC0741a() { // from class: com.ss.android.socialbase.appdownloader.h.2
            @Override // com.ss.android.socialbase.downloader.a.a.InterfaceC0741a
            public void c() {
            }

            @Override // com.ss.android.socialbase.downloader.a.a.InterfaceC0741a
            public void b() {
                if (h.this.a.isEmpty()) {
                    return;
                }
                long a2 = com.ss.android.socialbase.downloader.g.a.c().a("install_on_resume_install_interval", AppConfig.TIMESTAMP_AVAILABLE_DURATION);
                long currentTimeMillis = System.currentTimeMillis() - h.this.d;
                if (currentTimeMillis < a2) {
                    if (!h.this.f.hasCallbacks(h.this.g)) {
                        h.this.f.postDelayed(h.this.g, a2 - currentTimeMillis);
                        return;
                    }
                    return;
                }
                h.this.d = System.currentTimeMillis();
                h.this.c();
            }
        });
    }

    public static h a() {
        return a.a;
    }

    private boolean d() {
        if (System.currentTimeMillis() - this.c < 1000) {
            return true;
        }
        return false;
    }

    public JumpUnknownSourceActivity b() {
        JumpUnknownSourceActivity jumpUnknownSourceActivity;
        SoftReference<JumpUnknownSourceActivity> softReference = this.e;
        if (softReference == null) {
            jumpUnknownSourceActivity = null;
        } else {
            jumpUnknownSourceActivity = softReference.get();
        }
        this.e = null;
        return jumpUnknownSourceActivity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int b(Context context, int i, boolean z) {
        int b = c.b(context, i, z);
        if (b == 1) {
            this.b = true;
        }
        this.c = System.currentTimeMillis();
        return b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        final Integer poll;
        if (Build.VERSION.SDK_INT >= 29 && !com.ss.android.socialbase.downloader.a.a.a().b()) {
            return;
        }
        synchronized (this.a) {
            poll = this.a.poll();
        }
        this.f.removeCallbacks(this.g);
        if (poll != null) {
            final Context N = com.ss.android.socialbase.downloader.downloader.c.N();
            if (Looper.myLooper() != Looper.getMainLooper()) {
                this.f.post(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.h.3
                    @Override // java.lang.Runnable
                    public void run() {
                        h.this.b(N, poll.intValue(), false);
                    }
                });
            } else {
                b(N, poll.intValue(), false);
            }
            this.f.postDelayed(this.g, 20000L);
            return;
        }
        this.b = false;
    }

    public int a(final Context context, final int i, final boolean z) {
        boolean z2;
        if (z) {
            return b(context, i, z);
        }
        if (d()) {
            this.f.postDelayed(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.h.4
                @Override // java.lang.Runnable
                public void run() {
                    h.this.a(context, i, z);
                }
            }, 1000L);
            return 1;
        } else if (com.ss.android.socialbase.downloader.a.a.a().b()) {
            com.ss.android.socialbase.downloader.c.a.c("leaves", "on Foreground");
            return b(context, i, z);
        } else if (b.a()) {
            return 1;
        } else {
            if (Build.VERSION.SDK_INT < 29) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (this.a.isEmpty() && !this.b && z2) {
                return b(context, i, z);
            }
            int a2 = com.ss.android.socialbase.downloader.g.a.c().a("install_queue_size", 3);
            synchronized (this.a) {
                while (this.a.size() > a2) {
                    this.a.poll();
                }
            }
            if (z2) {
                this.f.removeCallbacks(this.g);
                this.f.postDelayed(this.g, com.ss.android.socialbase.downloader.g.a.a(i).a("install_queue_timeout", 20000L));
            }
            synchronized (this.a) {
                if (!this.a.contains(Integer.valueOf(i))) {
                    this.a.offer(Integer.valueOf(i));
                }
            }
            return 1;
        }
    }

    public void a(JumpUnknownSourceActivity jumpUnknownSourceActivity) {
        this.e = new SoftReference<>(jumpUnknownSourceActivity);
    }

    public void a(DownloadInfo downloadInfo, String str) {
        if (downloadInfo != null && !TextUtils.isEmpty(str)) {
            c();
        }
    }
}
