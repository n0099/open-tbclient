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
    public static int f34309a = 10;

    /* renamed from: b  reason: collision with root package name */
    public static int f34310b = 5;

    /* renamed from: c  reason: collision with root package name */
    public final Executor f34311c;

    /* renamed from: d  reason: collision with root package name */
    public final Handler f34312d;

    /* renamed from: e  reason: collision with root package name */
    public final LinkedBlockingQueue<s> f34313e;

    /* renamed from: f  reason: collision with root package name */
    public final Object f34314f;

    /* renamed from: g  reason: collision with root package name */
    public final ArrayList<s> f34315g;

    /* loaded from: classes6.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public static final j f34318a = new j();
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
        this.f34311c = com.kwai.filedownloader.f.b.a(5, "BlockCompleted");
        this.f34314f = new Object();
        this.f34315g = new ArrayList<>();
        this.f34312d = new Handler(Looper.getMainLooper(), new b());
        this.f34313e = new LinkedBlockingQueue<>();
    }

    public static j a() {
        return a.f34318a;
    }

    private void b(s sVar) {
        Handler handler = this.f34312d;
        handler.sendMessage(handler.obtainMessage(1, sVar));
    }

    public static boolean b() {
        return f34309a > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        synchronized (this.f34314f) {
            if (this.f34315g.isEmpty()) {
                if (this.f34313e.isEmpty()) {
                    return;
                }
                int i2 = 0;
                if (b()) {
                    int i3 = f34309a;
                    int min = Math.min(this.f34313e.size(), f34310b);
                    while (i2 < min) {
                        this.f34315g.add(this.f34313e.remove());
                        i2++;
                    }
                    i2 = i3;
                } else {
                    this.f34313e.drainTo(this.f34315g);
                }
                Handler handler = this.f34312d;
                handler.sendMessageDelayed(handler.obtainMessage(2, this.f34315g), i2);
            }
        }
    }

    private void c(s sVar) {
        synchronized (this.f34314f) {
            this.f34313e.offer(sVar);
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
            this.f34311c.execute(new Runnable() { // from class: com.kwai.filedownloader.j.1
                @Override // java.lang.Runnable
                public void run() {
                    sVar.b();
                }
            });
        } else {
            if (!b() && !this.f34313e.isEmpty()) {
                synchronized (this.f34314f) {
                    if (!this.f34313e.isEmpty()) {
                        Iterator<s> it = this.f34313e.iterator();
                        while (it.hasNext()) {
                            b(it.next());
                        }
                    }
                    this.f34313e.clear();
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
