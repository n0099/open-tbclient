package com.kwai.filedownloader;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
/* loaded from: classes6.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    public static int f37028a = 10;

    /* renamed from: b  reason: collision with root package name */
    public static int f37029b = 5;

    /* renamed from: c  reason: collision with root package name */
    public final Executor f37030c;

    /* renamed from: d  reason: collision with root package name */
    public final Handler f37031d;

    /* renamed from: e  reason: collision with root package name */
    public final LinkedBlockingQueue<s> f37032e;

    /* renamed from: f  reason: collision with root package name */
    public final Object f37033f;

    /* renamed from: g  reason: collision with root package name */
    public final ArrayList<s> f37034g;

    /* loaded from: classes6.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public static final j f37037a = new j();
    }

    /* loaded from: classes6.dex */
    public static class b implements Handler.Callback {
        public b() {
        }

        private void a(ArrayList<s> arrayList) {
            Iterator<s> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().b();
            }
            arrayList.clear();
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                ((s) message.obj).b();
            } else if (i == 2) {
                a((ArrayList) message.obj);
                j.a().c();
            }
            return true;
        }
    }

    public j() {
        this.f37030c = com.kwai.filedownloader.f.b.a(5, "BlockCompleted");
        this.f37033f = new Object();
        this.f37034g = new ArrayList<>();
        this.f37031d = new Handler(Looper.getMainLooper(), new b());
        this.f37032e = new LinkedBlockingQueue<>();
    }

    public static j a() {
        return a.f37037a;
    }

    private void b(s sVar) {
        Handler handler = this.f37031d;
        handler.sendMessage(handler.obtainMessage(1, sVar));
    }

    public static boolean b() {
        return f37028a > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        synchronized (this.f37033f) {
            if (this.f37034g.isEmpty()) {
                if (this.f37032e.isEmpty()) {
                    return;
                }
                int i = 0;
                if (b()) {
                    int i2 = f37028a;
                    int min = Math.min(this.f37032e.size(), f37029b);
                    while (i < min) {
                        this.f37034g.add(this.f37032e.remove());
                        i++;
                    }
                    i = i2;
                } else {
                    this.f37032e.drainTo(this.f37034g);
                }
                Handler handler = this.f37031d;
                handler.sendMessageDelayed(handler.obtainMessage(2, this.f37034g), i);
            }
        }
    }

    private void c(s sVar) {
        synchronized (this.f37033f) {
            this.f37032e.offer(sVar);
        }
        c();
    }

    public void a(s sVar) {
        a(sVar, false);
    }

    public void a(final s sVar, boolean z) {
        if (sVar.c()) {
            sVar.b();
        } else if (sVar.d()) {
            this.f37030c.execute(new Runnable() { // from class: com.kwai.filedownloader.j.1
                @Override // java.lang.Runnable
                public void run() {
                    sVar.b();
                }
            });
        } else {
            if (!b() && !this.f37032e.isEmpty()) {
                synchronized (this.f37033f) {
                    if (!this.f37032e.isEmpty()) {
                        Iterator<s> it = this.f37032e.iterator();
                        while (it.hasNext()) {
                            b(it.next());
                        }
                    }
                    this.f37032e.clear();
                }
            }
            if (!b() || z) {
                b(sVar);
            } else {
                c(sVar);
            }
        }
    }
}
