package com.kwai.filedownloader;

import com.kwai.filedownloader.w;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
/* loaded from: classes3.dex */
class p {

    /* renamed from: a  reason: collision with root package name */
    private final b f10974a = new b();

    /* loaded from: classes3.dex */
    private static class a {

        /* renamed from: a  reason: collision with root package name */
        private static final p f10975a = new p();

        static {
            com.kwai.filedownloader.message.e.a().a(new z());
        }
    }

    /* loaded from: classes3.dex */
    private static class b {

        /* renamed from: a  reason: collision with root package name */
        private ThreadPoolExecutor f10976a;

        /* renamed from: b  reason: collision with root package name */
        private LinkedBlockingQueue<Runnable> f10977b;

        b() {
            a();
        }

        private void a() {
            this.f10977b = new LinkedBlockingQueue<>();
            this.f10976a = com.kwai.filedownloader.f.b.a(3, this.f10977b, "LauncherTask");
        }

        public void a(w.b bVar) {
            this.f10976a.execute(new c(bVar));
        }

        public void b(w.b bVar) {
            this.f10977b.remove(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final w.b f10978a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f10979b = false;

        c(w.b bVar) {
            this.f10978a = bVar;
        }

        public boolean equals(Object obj) {
            return super.equals(obj) || obj == this.f10978a;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f10979b) {
                return;
            }
            this.f10978a.p();
        }
    }

    p() {
    }

    public static p a() {
        return a.f10975a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void a(w.b bVar) {
        this.f10974a.a(bVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void b(w.b bVar) {
        this.f10974a.b(bVar);
    }
}
