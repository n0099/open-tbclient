package com.kwai.filedownloader;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
/* loaded from: classes4.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    static int f10936a = 10;

    /* renamed from: b  reason: collision with root package name */
    static int f10937b = 5;
    private final Executor c;
    private final Handler d;
    private final LinkedBlockingQueue<s> e;
    private final Object f;
    private final ArrayList<s> g;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private static final j f10940a = new j();
    }

    /* loaded from: classes4.dex */
    private static class b implements Handler.Callback {
        private b() {
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
            if (message.what == 1) {
                ((s) message.obj).b();
            } else if (message.what == 2) {
                a((ArrayList) message.obj);
                j.a().c();
            }
            return true;
        }
    }

    private j() {
        this.c = com.kwai.filedownloader.f.b.a(5, "BlockCompleted");
        this.f = new Object();
        this.g = new ArrayList<>();
        this.d = new Handler(Looper.getMainLooper(), new b());
        this.e = new LinkedBlockingQueue<>();
    }

    public static j a() {
        return a.f10940a;
    }

    private void b(s sVar) {
        this.d.sendMessage(this.d.obtainMessage(1, sVar));
    }

    public static boolean b() {
        return f10936a > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        int i = 0;
        synchronized (this.f) {
            if (this.g.isEmpty()) {
                if (this.e.isEmpty()) {
                    return;
                }
                if (b()) {
                    int i2 = f10936a;
                    int min = Math.min(this.e.size(), f10937b);
                    while (i < min) {
                        this.g.add(this.e.remove());
                        i++;
                    }
                    i = i2;
                } else {
                    this.e.drainTo(this.g);
                }
                this.d.sendMessageDelayed(this.d.obtainMessage(2, this.g), i);
            }
        }
    }

    private void c(s sVar) {
        synchronized (this.f) {
            this.e.offer(sVar);
        }
        c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(s sVar) {
        a(sVar, false);
    }

    void a(final s sVar, boolean z) {
        if (sVar.c()) {
            sVar.b();
        } else if (sVar.d()) {
            this.c.execute(new Runnable() { // from class: com.kwai.filedownloader.j.1
                @Override // java.lang.Runnable
                public void run() {
                    sVar.b();
                }
            });
        } else {
            if (!b() && !this.e.isEmpty()) {
                synchronized (this.f) {
                    if (!this.e.isEmpty()) {
                        Iterator<s> it = this.e.iterator();
                        while (it.hasNext()) {
                            b(it.next());
                        }
                    }
                    this.e.clear();
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
