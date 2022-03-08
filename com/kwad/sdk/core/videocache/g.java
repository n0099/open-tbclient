package com.kwad.sdk.core.videocache;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.io.File;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes8.dex */
public final class g {

    /* renamed from: b  reason: collision with root package name */
    public final String f54846b;

    /* renamed from: c  reason: collision with root package name */
    public volatile e f54847c;

    /* renamed from: e  reason: collision with root package name */
    public final b f54849e;

    /* renamed from: f  reason: collision with root package name */
    public final c f54850f;
    public final AtomicInteger a = new AtomicInteger(0);

    /* renamed from: d  reason: collision with root package name */
    public final List<b> f54848d = new CopyOnWriteArrayList();

    /* loaded from: classes8.dex */
    public static final class a extends Handler implements b {
        public final String a;

        /* renamed from: b  reason: collision with root package name */
        public final List<b> f54851b;

        public a(String str, List<b> list) {
            super(Looper.getMainLooper());
            this.a = str;
            this.f54851b = list;
        }

        @Override // com.kwad.sdk.core.videocache.b
        public void a(File file, String str, int i2) {
            Message obtainMessage = obtainMessage();
            obtainMessage.arg1 = i2;
            obtainMessage.obj = file;
            sendMessage(obtainMessage);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            for (b bVar : this.f54851b) {
                bVar.a((File) message.obj, this.a, message.arg1);
            }
        }
    }

    public g(String str, c cVar) {
        this.f54846b = (String) j.a(str);
        this.f54850f = (c) j.a(cVar);
        this.f54849e = new a(str, this.f54848d);
    }

    private synchronized void c() {
        this.f54847c = this.f54847c == null ? e() : this.f54847c;
    }

    private synchronized void d() {
        if (this.a.decrementAndGet() <= 0) {
            this.f54847c.a();
            this.f54847c = null;
        }
    }

    private e e() {
        String str = this.f54846b;
        c cVar = this.f54850f;
        e eVar = new e(new h(str, cVar.f54826d, cVar.f54827e), new com.kwad.sdk.core.videocache.kwai.b(this.f54850f.a(this.f54846b), this.f54850f.f54825c));
        eVar.a(this.f54849e);
        return eVar;
    }

    public void a() {
        this.f54848d.clear();
        if (this.f54847c != null) {
            this.f54847c.a((b) null);
            this.f54847c.a();
            this.f54847c = null;
        }
        this.a.set(0);
    }

    public void a(d dVar, Socket socket) {
        c();
        try {
            this.a.incrementAndGet();
            this.f54847c.a(dVar, socket);
        } finally {
            d();
        }
    }

    public int b() {
        return this.a.get();
    }
}
