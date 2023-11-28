package com.kwad.framework.filedownloader;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
/* loaded from: classes10.dex */
public final class j {
    public static int aer = 10;
    public static int aes = 5;
    public final Executor aen;
    public final LinkedBlockingQueue<t> aeo;
    public final Object aep;
    public final ArrayList<t> aeq;
    public final Handler handler;

    /* loaded from: classes10.dex */
    public static final class a {
        public static final j aev = new j((byte) 0);
    }

    /* loaded from: classes10.dex */
    public static class b implements Handler.Callback {
        public b() {
        }

        public /* synthetic */ b(byte b) {
            this();
        }

        public static void a(ArrayList<t> arrayList) {
            Iterator<t> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().ux();
            }
            arrayList.clear();
        }

        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                ((t) message.obj).ux();
            } else if (i == 2) {
                a((ArrayList) message.obj);
                j.ut().push();
            }
            return true;
        }
    }

    public j() {
        this.aen = com.kwad.framework.filedownloader.f.b.o(5, "BlockCompleted");
        this.aep = new Object();
        this.aeq = new ArrayList<>();
        this.handler = new Handler(Looper.getMainLooper(), new b((byte) 0));
        this.aeo = new LinkedBlockingQueue<>();
    }

    public /* synthetic */ j(byte b2) {
        this();
    }

    private void b(t tVar) {
        Handler handler = this.handler;
        handler.sendMessage(handler.obtainMessage(1, tVar));
    }

    private void c(t tVar) {
        synchronized (this.aep) {
            this.aeo.offer(tVar);
        }
        push();
    }

    private void a(final t tVar, boolean z) {
        if (tVar.uy()) {
            tVar.ux();
        } else if (tVar.uz()) {
            this.aen.execute(new Runnable() { // from class: com.kwad.framework.filedownloader.j.1
                @Override // java.lang.Runnable
                public final void run() {
                    tVar.ux();
                }
            });
        } else {
            if (!uu() && !this.aeo.isEmpty()) {
                synchronized (this.aep) {
                    if (!this.aeo.isEmpty()) {
                        Iterator<t> it = this.aeo.iterator();
                        while (it.hasNext()) {
                            b(it.next());
                        }
                    }
                    this.aeo.clear();
                }
            }
            if (!uu()) {
                b(tVar);
            } else {
                c(tVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void push() {
        synchronized (this.aep) {
            if (!this.aeq.isEmpty()) {
                return;
            }
            if (this.aeo.isEmpty()) {
                return;
            }
            int i = 0;
            if (!uu()) {
                this.aeo.drainTo(this.aeq);
            } else {
                int i2 = aer;
                int min = Math.min(this.aeo.size(), aes);
                while (i < min) {
                    this.aeq.add(this.aeo.remove());
                    i++;
                }
                i = i2;
            }
            Handler handler = this.handler;
            handler.sendMessageDelayed(handler.obtainMessage(2, this.aeq), i);
        }
    }

    public static j ut() {
        return a.aev;
    }

    public static boolean uu() {
        if (aer > 0) {
            return true;
        }
        return false;
    }

    public final void a(t tVar) {
        a(tVar, false);
    }
}
