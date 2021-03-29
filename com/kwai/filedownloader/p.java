package com.kwai.filedownloader;

import com.kwai.filedownloader.w;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
/* loaded from: classes6.dex */
public class p {

    /* renamed from: a  reason: collision with root package name */
    public final b f37086a = new b();

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final p f37087a = new p();

        static {
            com.kwai.filedownloader.message.e.a().a(new z());
        }
    }

    /* loaded from: classes6.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public ThreadPoolExecutor f37088a;

        /* renamed from: b  reason: collision with root package name */
        public LinkedBlockingQueue<Runnable> f37089b;

        public b() {
            a();
        }

        private void a() {
            LinkedBlockingQueue<Runnable> linkedBlockingQueue = new LinkedBlockingQueue<>();
            this.f37089b = linkedBlockingQueue;
            this.f37088a = com.kwai.filedownloader.f.b.a(3, linkedBlockingQueue, "LauncherTask");
        }

        public void a(w.b bVar) {
            this.f37088a.execute(new c(bVar));
        }

        public void b(w.b bVar) {
            this.f37089b.remove(bVar);
        }
    }

    /* loaded from: classes6.dex */
    public static class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final w.b f37090a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f37091b = false;

        public c(w.b bVar) {
            this.f37090a = bVar;
        }

        public boolean equals(Object obj) {
            return super.equals(obj) || obj == this.f37090a;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f37091b) {
                return;
            }
            this.f37090a.p();
        }
    }

    public static p a() {
        return a.f37087a;
    }

    public synchronized void a(w.b bVar) {
        this.f37086a.a(bVar);
    }

    public synchronized void b(w.b bVar) {
        this.f37086a.b(bVar);
    }
}
