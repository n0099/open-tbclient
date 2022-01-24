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
    public final String f56329b;

    /* renamed from: c  reason: collision with root package name */
    public volatile e f56330c;

    /* renamed from: e  reason: collision with root package name */
    public final b f56332e;

    /* renamed from: f  reason: collision with root package name */
    public final c f56333f;
    public final AtomicInteger a = new AtomicInteger(0);

    /* renamed from: d  reason: collision with root package name */
    public final List<b> f56331d = new CopyOnWriteArrayList();

    /* loaded from: classes3.dex */
    public static final class a extends Handler implements b {
        public final String a;

        /* renamed from: b  reason: collision with root package name */
        public final List<b> f56334b;

        public a(String str, List<b> list) {
            super(Looper.getMainLooper());
            this.a = str;
            this.f56334b = list;
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
            for (b bVar : this.f56334b) {
                bVar.a((File) message.obj, this.a, message.arg1);
            }
        }
    }

    public g(String str, c cVar) {
        this.f56329b = (String) j.a(str);
        this.f56333f = (c) j.a(cVar);
        this.f56332e = new a(str, this.f56331d);
    }

    private synchronized void c() {
        this.f56330c = this.f56330c == null ? e() : this.f56330c;
    }

    private synchronized void d() {
        if (this.a.decrementAndGet() <= 0) {
            this.f56330c.a();
            this.f56330c = null;
        }
    }

    private e e() {
        String str = this.f56329b;
        c cVar = this.f56333f;
        e eVar = new e(new h(str, cVar.f56309d, cVar.f56310e), new com.kwad.sdk.core.videocache.kwai.b(this.f56333f.a(this.f56329b), this.f56333f.f56308c));
        eVar.a(this.f56332e);
        return eVar;
    }

    public void a() {
        this.f56331d.clear();
        if (this.f56330c != null) {
            this.f56330c.a((b) null);
            this.f56330c.a();
            this.f56330c = null;
        }
        this.a.set(0);
    }

    public void a(d dVar, Socket socket) {
        c();
        try {
            this.a.incrementAndGet();
            this.f56330c.a(dVar, socket);
        } finally {
            d();
        }
    }

    public int b() {
        return this.a.get();
    }
}
