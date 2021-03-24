package com.kwad.sdk.core.videocache;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.io.File;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes6.dex */
public final class g {

    /* renamed from: b  reason: collision with root package name */
    public final String f34194b;

    /* renamed from: c  reason: collision with root package name */
    public volatile e f34195c;

    /* renamed from: e  reason: collision with root package name */
    public final b f34197e;

    /* renamed from: f  reason: collision with root package name */
    public final c f34198f;

    /* renamed from: a  reason: collision with root package name */
    public final AtomicInteger f34193a = new AtomicInteger(0);

    /* renamed from: d  reason: collision with root package name */
    public final List<b> f34196d = new CopyOnWriteArrayList();

    /* loaded from: classes6.dex */
    public static final class a extends Handler implements b {

        /* renamed from: a  reason: collision with root package name */
        public final String f34199a;

        /* renamed from: b  reason: collision with root package name */
        public final List<b> f34200b;

        public a(String str, List<b> list) {
            super(Looper.getMainLooper());
            this.f34199a = str;
            this.f34200b = list;
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
            for (b bVar : this.f34200b) {
                bVar.a((File) message.obj, this.f34199a, message.arg1);
            }
        }
    }

    public g(String str, c cVar) {
        this.f34194b = (String) j.a(str);
        this.f34198f = (c) j.a(cVar);
        this.f34197e = new a(str, this.f34196d);
    }

    private synchronized void c() {
        this.f34195c = this.f34195c == null ? e() : this.f34195c;
    }

    private synchronized void d() {
        if (this.f34193a.decrementAndGet() <= 0) {
            this.f34195c.a();
            this.f34195c = null;
        }
    }

    private e e() {
        String str = this.f34194b;
        c cVar = this.f34198f;
        e eVar = new e(new h(str, cVar.f34165d, cVar.f34166e), new com.kwad.sdk.core.videocache.a.b(this.f34198f.a(this.f34194b), this.f34198f.f34164c));
        eVar.a(this.f34197e);
        return eVar;
    }

    public void a() {
        this.f34196d.clear();
        if (this.f34195c != null) {
            this.f34195c.a((b) null);
            this.f34195c.a();
            this.f34195c = null;
        }
        this.f34193a.set(0);
    }

    public void a(d dVar, Socket socket) {
        c();
        try {
            this.f34193a.incrementAndGet();
            this.f34195c.a(dVar, socket);
        } finally {
            d();
        }
    }

    public int b() {
        return this.f34193a.get();
    }
}
