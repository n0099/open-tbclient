package com.kwad.sdk.core.videocache;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.io.File;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes3.dex */
public final class g {

    /* renamed from: b  reason: collision with root package name */
    public final String f58492b;

    /* renamed from: c  reason: collision with root package name */
    public volatile e f58493c;

    /* renamed from: e  reason: collision with root package name */
    public final b f58495e;

    /* renamed from: f  reason: collision with root package name */
    public final c f58496f;
    public final AtomicInteger a = new AtomicInteger(0);

    /* renamed from: d  reason: collision with root package name */
    public final List<b> f58494d = new CopyOnWriteArrayList();

    /* loaded from: classes3.dex */
    public static final class a extends Handler implements b {
        public final String a;

        /* renamed from: b  reason: collision with root package name */
        public final List<b> f58497b;

        public a(String str, List<b> list) {
            super(Looper.getMainLooper());
            this.a = str;
            this.f58497b = list;
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
            for (b bVar : this.f58497b) {
                bVar.a((File) message.obj, this.a, message.arg1);
            }
        }
    }

    public g(String str, c cVar) {
        this.f58492b = (String) j.a(str);
        this.f58496f = (c) j.a(cVar);
        this.f58495e = new a(str, this.f58494d);
    }

    private synchronized void c() {
        this.f58493c = this.f58493c == null ? e() : this.f58493c;
    }

    private synchronized void d() {
        if (this.a.decrementAndGet() <= 0) {
            this.f58493c.a();
            this.f58493c = null;
        }
    }

    private e e() {
        String str = this.f58492b;
        c cVar = this.f58496f;
        e eVar = new e(new h(str, cVar.f58472d, cVar.f58473e), new com.kwad.sdk.core.videocache.kwai.b(this.f58496f.a(this.f58492b), this.f58496f.f58471c));
        eVar.a(this.f58495e);
        return eVar;
    }

    public void a() {
        this.f58494d.clear();
        if (this.f58493c != null) {
            this.f58493c.a((b) null);
            this.f58493c.a();
            this.f58493c = null;
        }
        this.a.set(0);
    }

    public void a(d dVar, Socket socket) {
        c();
        try {
            this.a.incrementAndGet();
            this.f58493c.a(dVar, socket);
        } finally {
            d();
        }
    }

    public int b() {
        return this.a.get();
    }
}
