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
final class g {

    /* renamed from: b  reason: collision with root package name */
    private final String f9795b;
    private volatile e c;
    private final b e;
    private final c f;

    /* renamed from: a  reason: collision with root package name */
    private final AtomicInteger f9794a = new AtomicInteger(0);
    private final List<b> d = new CopyOnWriteArrayList();

    /* loaded from: classes5.dex */
    private static final class a extends Handler implements b {

        /* renamed from: a  reason: collision with root package name */
        private final String f9796a;

        /* renamed from: b  reason: collision with root package name */
        private final List<b> f9797b;

        public a(String str, List<b> list) {
            super(Looper.getMainLooper());
            this.f9796a = str;
            this.f9797b = list;
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
            for (b bVar : this.f9797b) {
                bVar.a((File) message.obj, this.f9796a, message.arg1);
            }
        }
    }

    public g(String str, c cVar) {
        this.f9795b = (String) j.a(str);
        this.f = (c) j.a(cVar);
        this.e = new a(str, this.d);
    }

    private synchronized void c() {
        this.c = this.c == null ? e() : this.c;
    }

    private synchronized void d() {
        if (this.f9794a.decrementAndGet() <= 0) {
            this.c.a();
            this.c = null;
        }
    }

    private e e() {
        e eVar = new e(new h(this.f9795b, this.f.d, this.f.e), new com.kwad.sdk.core.videocache.a.b(this.f.a(this.f9795b), this.f.c));
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
        this.f9794a.set(0);
    }

    public void a(d dVar, Socket socket) {
        c();
        try {
            this.f9794a.incrementAndGet();
            this.c.a(dVar, socket);
        } finally {
            d();
        }
    }

    public int b() {
        return this.f9794a.get();
    }
}
