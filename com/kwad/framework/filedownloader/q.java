package com.kwad.framework.filedownloader;

import com.kwad.framework.filedownloader.x;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
/* loaded from: classes10.dex */
public final class q {
    public final b aeG = new b();

    /* loaded from: classes10.dex */
    public static class a {
        public static final q aeH = new q();

        static {
            com.kwad.framework.filedownloader.message.e.vV().a(new aa());
        }
    }

    /* loaded from: classes10.dex */
    public static class b {
        public ThreadPoolExecutor aeI;
        public LinkedBlockingQueue<Runnable> aeJ;

        public b() {
            init();
        }

        private void init() {
            LinkedBlockingQueue<Runnable> linkedBlockingQueue = new LinkedBlockingQueue<>();
            this.aeJ = linkedBlockingQueue;
            this.aeI = com.kwad.framework.filedownloader.f.b.a(3, linkedBlockingQueue, "LauncherTask");
        }

        public final void b(x.b bVar) {
            this.aeJ.remove(bVar);
        }

        public final void c(x.b bVar) {
            this.aeI.execute(new c(bVar));
        }
    }

    /* loaded from: classes10.dex */
    public static class c implements Runnable {
        public final x.b aeK;
        public boolean aeL = false;

        public c(x.b bVar) {
            this.aeK = bVar;
        }

        public final boolean equals(Object obj) {
            if (!super.equals(obj) && obj != this.aeK) {
                return false;
            }
            return true;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.aeL) {
                return;
            }
            this.aeK.start();
        }
    }

    public static q uI() {
        return a.aeH;
    }

    public final synchronized void a(x.b bVar) {
        this.aeG.c(bVar);
    }

    public final synchronized void b(x.b bVar) {
        this.aeG.b(bVar);
    }
}
