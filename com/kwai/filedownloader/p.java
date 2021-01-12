package com.kwai.filedownloader;

import com.kwai.filedownloader.w;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
/* loaded from: classes4.dex */
class p {

    /* renamed from: a  reason: collision with root package name */
    private final b f10972a = new b();

    /* loaded from: classes4.dex */
    private static class a {

        /* renamed from: a  reason: collision with root package name */
        private static final p f10973a = new p();

        static {
            com.kwai.filedownloader.message.e.a().a(new z());
        }
    }

    /* loaded from: classes4.dex */
    private static class b {

        /* renamed from: a  reason: collision with root package name */
        private ThreadPoolExecutor f10974a;

        /* renamed from: b  reason: collision with root package name */
        private LinkedBlockingQueue<Runnable> f10975b;

        b() {
            a();
        }

        private void a() {
            this.f10975b = new LinkedBlockingQueue<>();
            this.f10974a = com.kwai.filedownloader.f.b.a(3, this.f10975b, "LauncherTask");
        }

        public void a(w.b bVar) {
            this.f10974a.execute(new c(bVar));
        }

        public void b(w.b bVar) {
            this.f10975b.remove(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final w.b f10976a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f10977b = false;

        c(w.b bVar) {
            this.f10976a = bVar;
        }

        public boolean equals(Object obj) {
            return super.equals(obj) || obj == this.f10976a;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f10977b) {
                return;
            }
            this.f10976a.p();
        }
    }

    p() {
    }

    public static p a() {
        return a.f10973a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void a(w.b bVar) {
        this.f10972a.a(bVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void b(w.b bVar) {
        this.f10972a.b(bVar);
    }
}
