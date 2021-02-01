package com.qq.e.comm.plugin.a;

import com.qq.e.comm.managers.GDTADManager;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    private volatile ScheduledExecutorService f11615a;

    /* renamed from: b  reason: collision with root package name */
    private final b f11616b;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes15.dex */
    public class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private final String f11619b;
        private final long c;

        public a(String str, long j) {
            this.f11619b = str;
            this.c = j;
        }

        private long a() {
            if (this.c > 64000) {
                return -1L;
            }
            return this.c;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (e.this.f11616b == null || !e.this.f11616b.b(this.f11619b)) {
                return;
            }
            if (com.qq.e.comm.plugin.a.d.d.a(com.qq.e.comm.plugin.a.d.b.a().a(GDTADManager.getInstance().getAppContext(), this.f11619b))) {
                e.this.f11616b.a(this.f11619b);
                return;
            }
            long a2 = a();
            if (a2 > 0) {
                e.this.a(this.f11619b, a2 * 2);
            }
        }
    }

    /* loaded from: classes15.dex */
    interface b {
        void a(String str);

        boolean b(String str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(b bVar) {
        this.f11616b = bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str) {
        synchronized (this) {
            a(str, 2000L);
        }
    }

    void a(String str, long j) {
        synchronized (this) {
            if (this.f11615a == null) {
                this.f11615a = Executors.newSingleThreadScheduledExecutor(new ThreadFactory() { // from class: com.qq.e.comm.plugin.a.e.1
                    @Override // java.util.concurrent.ThreadFactory
                    public Thread newThread(Runnable runnable) {
                        Thread thread = new Thread(runnable);
                        thread.setDaemon(true);
                        thread.setName("GDT_INSTALL_CHECKER_THREAD");
                        return thread;
                    }
                });
            }
            this.f11615a.schedule(new a(str, j), j, TimeUnit.MILLISECONDS);
        }
    }
}
