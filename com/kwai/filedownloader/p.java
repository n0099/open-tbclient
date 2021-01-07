package com.kwai.filedownloader;

import com.kwai.filedownloader.w;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
/* loaded from: classes5.dex */
class p {

    /* renamed from: a  reason: collision with root package name */
    private final b f11272a = new b();

    /* loaded from: classes5.dex */
    private static class a {

        /* renamed from: a  reason: collision with root package name */
        private static final p f11273a = new p();

        static {
            com.kwai.filedownloader.message.e.a().a(new z());
        }
    }

    /* loaded from: classes5.dex */
    private static class b {

        /* renamed from: a  reason: collision with root package name */
        private ThreadPoolExecutor f11274a;

        /* renamed from: b  reason: collision with root package name */
        private LinkedBlockingQueue<Runnable> f11275b;

        b() {
            a();
        }

        private void a() {
            this.f11275b = new LinkedBlockingQueue<>();
            this.f11274a = com.kwai.filedownloader.f.b.a(3, this.f11275b, "LauncherTask");
        }

        public void a(w.b bVar) {
            this.f11274a.execute(new c(bVar));
        }

        public void b(w.b bVar) {
            this.f11275b.remove(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final w.b f11276a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f11277b = false;

        c(w.b bVar) {
            this.f11276a = bVar;
        }

        public boolean equals(Object obj) {
            return super.equals(obj) || obj == this.f11276a;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f11277b) {
                return;
            }
            this.f11276a.p();
        }
    }

    p() {
    }

    public static p a() {
        return a.f11273a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void a(w.b bVar) {
        this.f11272a.a(bVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void b(w.b bVar) {
        this.f11272a.b(bVar);
    }
}
