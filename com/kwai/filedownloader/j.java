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
    public static int f37029a = 10;

    /* renamed from: b  reason: collision with root package name */
    public static int f37030b = 5;

    /* renamed from: c  reason: collision with root package name */
    public final Executor f37031c;

    /* renamed from: d  reason: collision with root package name */
    public final Handler f37032d;

    /* renamed from: e  reason: collision with root package name */
    public final LinkedBlockingQueue<s> f37033e;

    /* renamed from: f  reason: collision with root package name */
    public final Object f37034f;

    /* renamed from: g  reason: collision with root package name */
    public final ArrayList<s> f37035g;

    /* loaded from: classes6.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public static final j f37038a = new j();
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
        this.f37031c = com.kwai.filedownloader.f.b.a(5, "BlockCompleted");
        this.f37034f = new Object();
        this.f37035g = new ArrayList<>();
        this.f37032d = new Handler(Looper.getMainLooper(), new b());
        this.f37033e = new LinkedBlockingQueue<>();
    }

    public static j a() {
        return a.f37038a;
    }

    private void b(s sVar) {
        Handler handler = this.f37032d;
        handler.sendMessage(handler.obtainMessage(1, sVar));
    }

    public static boolean b() {
        return f37029a > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        synchronized (this.f37034f) {
            if (this.f37035g.isEmpty()) {
                if (this.f37033e.isEmpty()) {
                    return;
                }
                int i = 0;
                if (b()) {
                    int i2 = f37029a;
                    int min = Math.min(this.f37033e.size(), f37030b);
                    while (i < min) {
                        this.f37035g.add(this.f37033e.remove());
                        i++;
                    }
                    i = i2;
                } else {
                    this.f37033e.drainTo(this.f37035g);
                }
                Handler handler = this.f37032d;
                handler.sendMessageDelayed(handler.obtainMessage(2, this.f37035g), i);
            }
        }
    }

    private void c(s sVar) {
        synchronized (this.f37034f) {
            this.f37033e.offer(sVar);
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
            this.f37031c.execute(new Runnable() { // from class: com.kwai.filedownloader.j.1
                @Override // java.lang.Runnable
                public void run() {
                    sVar.b();
                }
            });
        } else {
            if (!b() && !this.f37033e.isEmpty()) {
                synchronized (this.f37034f) {
                    if (!this.f37033e.isEmpty()) {
                        Iterator<s> it = this.f37033e.iterator();
                        while (it.hasNext()) {
                            b(it.next());
                        }
                    }
                    this.f37033e.clear();
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
