package com.kwai.filedownloader;

import com.kwai.filedownloader.w;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
/* loaded from: classes6.dex */
public class p {

    /* renamed from: a  reason: collision with root package name */
    public final b f37085a = new b();

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final p f37086a = new p();

        static {
            com.kwai.filedownloader.message.e.a().a(new z());
        }
    }

    /* loaded from: classes6.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public ThreadPoolExecutor f37087a;

        /* renamed from: b  reason: collision with root package name */
        public LinkedBlockingQueue<Runnable> f37088b;

        public b() {
            a();
        }

        private void a() {
            LinkedBlockingQueue<Runnable> linkedBlockingQueue = new LinkedBlockingQueue<>();
            this.f37088b = linkedBlockingQueue;
            this.f37087a = com.kwai.filedownloader.f.b.a(3, linkedBlockingQueue, "LauncherTask");
        }

        public void a(w.b bVar) {
            this.f37087a.execute(new c(bVar));
        }

        public void b(w.b bVar) {
            this.f37088b.remove(bVar);
        }
    }

    /* loaded from: classes6.dex */
    public static class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final w.b f37089a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f37090b = false;

        public c(w.b bVar) {
            this.f37089a = bVar;
        }

        public boolean equals(Object obj) {
            return super.equals(obj) || obj == this.f37089a;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f37090b) {
                return;
            }
            this.f37089a.p();
        }
    }

    public static p a() {
        return a.f37086a;
    }

    public synchronized void a(w.b bVar) {
        this.f37085a.a(bVar);
    }

    public synchronized void b(w.b bVar) {
        this.f37085a.b(bVar);
    }
}
