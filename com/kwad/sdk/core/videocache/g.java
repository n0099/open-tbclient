package com.kwad.sdk.core.videocache;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.io.File;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes5.dex */
public final class g {
    public final String b;
    public volatile e c;
    public final b e;
    public final c f;
    public final AtomicInteger a = new AtomicInteger(0);
    public final List<b> d = new CopyOnWriteArrayList();

    /* loaded from: classes5.dex */
    public static final class a extends Handler implements b {
        public final String a;
        public final List<b> b;

        public a(String str, List<b> list) {
            super(Looper.getMainLooper());
            this.a = str;
            this.b = list;
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
            for (b bVar : this.b) {
                bVar.a((File) message.obj, this.a, message.arg1);
            }
        }
    }

    public g(String str, c cVar) {
        this.b = (String) j.a(str);
        this.f = (c) j.a(cVar);
        this.e = new a(str, this.d);
    }

    private synchronized void c() {
        this.c = this.c == null ? e() : this.c;
    }

    private synchronized void d() {
        if (this.a.decrementAndGet() <= 0) {
            this.c.a();
            this.c = null;
        }
    }

    private e e() {
        String str = this.b;
        c cVar = this.f;
        e eVar = new e(new h(str, cVar.d, cVar.e), new com.kwad.sdk.core.videocache.kwai.b(this.f.a(this.b), this.f.c));
        eVar.a(this.e);
        return eVar;
    }

    public void a() {
        this.d.clear();
        if (this.c != null) {
            this.c.a((b) null);
            this.c.a();
            this.c = null;
        }
        this.a.set(0);
    }

    public void a(d dVar, Socket socket) {
        c();
        try {
            this.a.incrementAndGet();
            this.c.a(dVar, socket);
        } finally {
            d();
        }
    }

    public int b() {
        return this.a.get();
    }
}
