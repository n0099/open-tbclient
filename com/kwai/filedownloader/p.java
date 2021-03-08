package com.kwai.filedownloader;

import com.kwai.filedownloader.w;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
/* loaded from: classes3.dex */
class p {

    /* renamed from: a  reason: collision with root package name */
    private final b f7232a = new b();

    /* loaded from: classes3.dex */
    private static class a {

        /* renamed from: a  reason: collision with root package name */
        private static final p f7233a = new p();

        static {
            com.kwai.filedownloader.message.e.a().a(new z());
        }
    }

    /* loaded from: classes3.dex */
    private static class b {

        /* renamed from: a  reason: collision with root package name */
        private ThreadPoolExecutor f7234a;
        private LinkedBlockingQueue<Runnable> b;

        b() {
            a();
        }

        private void a() {
            this.b = new LinkedBlockingQueue<>();
            this.f7234a = com.kwai.filedownloader.f.b.a(3, this.b, "LauncherTask");
        }

        public void a(w.b bVar) {
            this.f7234a.execute(new c(bVar));
        }

        public void b(w.b bVar) {
            this.b.remove(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final w.b f7235a;
        private boolean b = false;

        c(w.b bVar) {
            this.f7235a = bVar;
        }

        public boolean equals(Object obj) {
            return super.equals(obj) || obj == this.f7235a;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.b) {
                return;
            }
            this.f7235a.p();
        }
    }

    p() {
    }

    public static p a() {
        return a.f7233a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void a(w.b bVar) {
        this.f7232a.a(bVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void b(w.b bVar) {
        this.f7232a.b(bVar);
    }
}
