package com.kwai.filedownloader;

import com.kwai.filedownloader.w;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
/* loaded from: classes7.dex */
public class p {

    /* renamed from: a  reason: collision with root package name */
    public final b f37948a = new b();

    /* loaded from: classes7.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final p f37949a = new p();

        static {
            com.kwai.filedownloader.message.e.a().a(new z());
        }
    }

    /* loaded from: classes7.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public ThreadPoolExecutor f37950a;

        /* renamed from: b  reason: collision with root package name */
        public LinkedBlockingQueue<Runnable> f37951b;

        public b() {
            a();
        }

        private void a() {
            LinkedBlockingQueue<Runnable> linkedBlockingQueue = new LinkedBlockingQueue<>();
            this.f37951b = linkedBlockingQueue;
            this.f37950a = com.kwai.filedownloader.f.b.a(3, linkedBlockingQueue, "LauncherTask");
        }

        public void a(w.b bVar) {
            this.f37950a.execute(new c(bVar));
        }

        public void b(w.b bVar) {
            this.f37951b.remove(bVar);
        }
    }

    /* loaded from: classes7.dex */
    public static class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final w.b f37952a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f37953b = false;

        public c(w.b bVar) {
            this.f37952a = bVar;
        }

        public boolean equals(Object obj) {
            return super.equals(obj) || obj == this.f37952a;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f37953b) {
                return;
            }
            this.f37952a.p();
        }
    }

    public static p a() {
        return a.f37949a;
    }

    public synchronized void a(w.b bVar) {
        this.f37948a.a(bVar);
    }

    public synchronized void b(w.b bVar) {
        this.f37948a.b(bVar);
    }
}
