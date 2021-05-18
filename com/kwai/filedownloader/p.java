package com.kwai.filedownloader;

import com.kwai.filedownloader.w;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
/* loaded from: classes6.dex */
public class p {

    /* renamed from: a  reason: collision with root package name */
    public final b f34437a = new b();

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final p f34438a = new p();

        static {
            com.kwai.filedownloader.message.e.a().a(new z());
        }
    }

    /* loaded from: classes6.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public ThreadPoolExecutor f34439a;

        /* renamed from: b  reason: collision with root package name */
        public LinkedBlockingQueue<Runnable> f34440b;

        public b() {
            a();
        }

        private void a() {
            LinkedBlockingQueue<Runnable> linkedBlockingQueue = new LinkedBlockingQueue<>();
            this.f34440b = linkedBlockingQueue;
            this.f34439a = com.kwai.filedownloader.f.b.a(3, linkedBlockingQueue, "LauncherTask");
        }

        public void a(w.b bVar) {
            this.f34439a.execute(new c(bVar));
        }

        public void b(w.b bVar) {
            this.f34440b.remove(bVar);
        }
    }

    /* loaded from: classes6.dex */
    public static class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final w.b f34441a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f34442b = false;

        public c(w.b bVar) {
            this.f34441a = bVar;
        }

        public boolean equals(Object obj) {
            return super.equals(obj) || obj == this.f34441a;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f34442b) {
                return;
            }
            this.f34441a.p();
        }
    }

    public static p a() {
        return a.f34438a;
    }

    public synchronized void a(w.b bVar) {
        this.f34437a.a(bVar);
    }

    public synchronized void b(w.b bVar) {
        this.f34437a.b(bVar);
    }
}
