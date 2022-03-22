package com.kwad.sdk.core.videocache;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.io.File;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
public final class g {

    /* renamed from: b  reason: collision with root package name */
    public final String f39941b;

    /* renamed from: c  reason: collision with root package name */
    public volatile e f39942c;

    /* renamed from: e  reason: collision with root package name */
    public final b f39944e;

    /* renamed from: f  reason: collision with root package name */
    public final c f39945f;
    public final AtomicInteger a = new AtomicInteger(0);

    /* renamed from: d  reason: collision with root package name */
    public final List<b> f39943d = new CopyOnWriteArrayList();

    /* loaded from: classes7.dex */
    public static final class a extends Handler implements b {
        public final String a;

        /* renamed from: b  reason: collision with root package name */
        public final List<b> f39946b;

        public a(String str, List<b> list) {
            super(Looper.getMainLooper());
            this.a = str;
            this.f39946b = list;
        }

        @Override // com.kwad.sdk.core.videocache.b
        public void a(File file, String str, int i) {
            Message obtainMessage = obtainMessage();
            obtainMessage.arg1 = i;
            obtainMessage.obj = file;
            sendMessage(obtainMessage);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            for (b bVar : this.f39946b) {
                bVar.a((File) message.obj, this.a, message.arg1);
            }
        }
    }

    public g(String str, c cVar) {
        this.f39941b = (String) j.a(str);
        this.f39945f = (c) j.a(cVar);
        this.f39944e = new a(str, this.f39943d);
    }

    private synchronized void c() {
        this.f39942c = this.f39942c == null ? e() : this.f39942c;
    }

    private synchronized void d() {
        if (this.a.decrementAndGet() <= 0) {
            this.f39942c.a();
            this.f39942c = null;
        }
    }

    private e e() {
        String str = this.f39941b;
        c cVar = this.f39945f;
        e eVar = new e(new h(str, cVar.f39921d, cVar.f39922e), new com.kwad.sdk.core.videocache.kwai.b(this.f39945f.a(this.f39941b), this.f39945f.f39920c));
        eVar.a(this.f39944e);
        return eVar;
    }

    public void a() {
        this.f39943d.clear();
        if (this.f39942c != null) {
            this.f39942c.a((b) null);
            this.f39942c.a();
            this.f39942c = null;
        }
        this.a.set(0);
    }

    public void a(d dVar, Socket socket) {
        c();
        try {
            this.a.incrementAndGet();
            this.f39942c.a(dVar, socket);
        } finally {
            d();
        }
    }

    public int b() {
        return this.a.get();
    }
}
