package com.kwai.filedownloader;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
/* loaded from: classes7.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    public static int f37793a = 10;

    /* renamed from: b  reason: collision with root package name */
    public static int f37794b = 5;

    /* renamed from: c  reason: collision with root package name */
    public final Executor f37795c;

    /* renamed from: d  reason: collision with root package name */
    public final Handler f37796d;

    /* renamed from: e  reason: collision with root package name */
    public final LinkedBlockingQueue<s> f37797e;

    /* renamed from: f  reason: collision with root package name */
    public final Object f37798f;

    /* renamed from: g  reason: collision with root package name */
    public final ArrayList<s> f37799g;

    /* loaded from: classes7.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public static final j f37802a = new j();
    }

    /* loaded from: classes7.dex */
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
            int i2 = message.what;
            if (i2 == 1) {
                ((s) message.obj).b();
            } else if (i2 == 2) {
                a((ArrayList) message.obj);
                j.a().c();
            }
            return true;
        }
    }

    public j() {
        this.f37795c = com.kwai.filedownloader.f.b.a(5, "BlockCompleted");
        this.f37798f = new Object();
        this.f37799g = new ArrayList<>();
        this.f37796d = new Handler(Looper.getMainLooper(), new b());
        this.f37797e = new LinkedBlockingQueue<>();
    }

    public static j a() {
        return a.f37802a;
    }

    private void b(s sVar) {
        Handler handler = this.f37796d;
        handler.sendMessage(handler.obtainMessage(1, sVar));
    }

    public static boolean b() {
        return f37793a > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        synchronized (this.f37798f) {
            if (this.f37799g.isEmpty()) {
                if (this.f37797e.isEmpty()) {
                    return;
                }
                int i2 = 0;
                if (b()) {
                    int i3 = f37793a;
                    int min = Math.min(this.f37797e.size(), f37794b);
                    while (i2 < min) {
                        this.f37799g.add(this.f37797e.remove());
                        i2++;
                    }
                    i2 = i3;
                } else {
                    this.f37797e.drainTo(this.f37799g);
                }
                Handler handler = this.f37796d;
                handler.sendMessageDelayed(handler.obtainMessage(2, this.f37799g), i2);
            }
        }
    }

    private void c(s sVar) {
        synchronized (this.f37798f) {
            this.f37797e.offer(sVar);
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
            this.f37795c.execute(new Runnable() { // from class: com.kwai.filedownloader.j.1
                @Override // java.lang.Runnable
                public void run() {
                    sVar.b();
                }
            });
        } else {
            if (!b() && !this.f37797e.isEmpty()) {
                synchronized (this.f37798f) {
                    if (!this.f37797e.isEmpty()) {
                        Iterator<s> it = this.f37797e.iterator();
                        while (it.hasNext()) {
                            b(it.next());
                        }
                    }
                    this.f37797e.clear();
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
