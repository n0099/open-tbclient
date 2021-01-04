package com.kwai.filedownloader;

import com.kwai.filedownloader.w;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
/* loaded from: classes5.dex */
class p {

    /* renamed from: a  reason: collision with root package name */
    private final b f11271a = new b();

    /* loaded from: classes5.dex */
    private static class a {

        /* renamed from: a  reason: collision with root package name */
        private static final p f11272a = new p();

        static {
            com.kwai.filedownloader.message.e.a().a(new z());
        }
    }

    /* loaded from: classes5.dex */
    private static class b {

        /* renamed from: a  reason: collision with root package name */
        private ThreadPoolExecutor f11273a;

        /* renamed from: b  reason: collision with root package name */
        private LinkedBlockingQueue<Runnable> f11274b;

        b() {
            a();
        }

        private void a() {
            this.f11274b = new LinkedBlockingQueue<>();
            this.f11273a = com.kwai.filedownloader.f.b.a(3, this.f11274b, "LauncherTask");
        }

        public void a(w.b bVar) {
            this.f11273a.execute(new c(bVar));
        }

        public void b(w.b bVar) {
            this.f11274b.remove(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final w.b f11275a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f11276b = false;

        c(w.b bVar) {
            this.f11275a = bVar;
        }

        public boolean equals(Object obj) {
            return super.equals(obj) || obj == this.f11275a;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f11276b) {
                return;
            }
            this.f11275a.p();
        }
    }

    p() {
    }

    public static p a() {
        return a.f11272a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void a(w.b bVar) {
        this.f11271a.a(bVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void b(w.b bVar) {
        this.f11271a.b(bVar);
    }
}
