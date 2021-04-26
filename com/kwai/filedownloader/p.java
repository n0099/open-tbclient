package com.kwai.filedownloader;

import com.kwai.filedownloader.w;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
/* loaded from: classes6.dex */
public class p {

    /* renamed from: a  reason: collision with root package name */
    public final b f35192a = new b();

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final p f35193a = new p();

        static {
            com.kwai.filedownloader.message.e.a().a(new z());
        }
    }

    /* loaded from: classes6.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public ThreadPoolExecutor f35194a;

        /* renamed from: b  reason: collision with root package name */
        public LinkedBlockingQueue<Runnable> f35195b;

        public b() {
            a();
        }

        private void a() {
            LinkedBlockingQueue<Runnable> linkedBlockingQueue = new LinkedBlockingQueue<>();
            this.f35195b = linkedBlockingQueue;
            this.f35194a = com.kwai.filedownloader.f.b.a(3, linkedBlockingQueue, "LauncherTask");
        }

        public void a(w.b bVar) {
            this.f35194a.execute(new c(bVar));
        }

        public void b(w.b bVar) {
            this.f35195b.remove(bVar);
        }
    }

    /* loaded from: classes6.dex */
    public static class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final w.b f35196a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f35197b = false;

        public c(w.b bVar) {
            this.f35196a = bVar;
        }

        public boolean equals(Object obj) {
            return super.equals(obj) || obj == this.f35196a;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f35197b) {
                return;
            }
            this.f35196a.p();
        }
    }

    public static p a() {
        return a.f35193a;
    }

    public synchronized void a(w.b bVar) {
        this.f35192a.a(bVar);
    }

    public synchronized void b(w.b bVar) {
        this.f35192a.b(bVar);
    }
}
