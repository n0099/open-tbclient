package com.kwad.sdk.core.videocache;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.io.File;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes4.dex */
public final class g {

    /* renamed from: b  reason: collision with root package name */
    public final String f56496b;

    /* renamed from: c  reason: collision with root package name */
    public volatile e f56497c;

    /* renamed from: e  reason: collision with root package name */
    public final b f56499e;

    /* renamed from: f  reason: collision with root package name */
    public final c f56500f;
    public final AtomicInteger a = new AtomicInteger(0);

    /* renamed from: d  reason: collision with root package name */
    public final List<b> f56498d = new CopyOnWriteArrayList();

    /* loaded from: classes4.dex */
    public static final class a extends Handler implements b {
        public final String a;

        /* renamed from: b  reason: collision with root package name */
        public final List<b> f56501b;

        public a(String str, List<b> list) {
            super(Looper.getMainLooper());
            this.a = str;
            this.f56501b = list;
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
            for (b bVar : this.f56501b) {
                bVar.a((File) message.obj, this.a, message.arg1);
            }
        }
    }

    public g(String str, c cVar) {
        this.f56496b = (String) j.a(str);
        this.f56500f = (c) j.a(cVar);
        this.f56499e = new a(str, this.f56498d);
    }

    private synchronized void c() {
        this.f56497c = this.f56497c == null ? e() : this.f56497c;
    }

    private synchronized void d() {
        if (this.a.decrementAndGet() <= 0) {
            this.f56497c.a();
            this.f56497c = null;
        }
    }

    private e e() {
        String str = this.f56496b;
        c cVar = this.f56500f;
        e eVar = new e(new h(str, cVar.f56476d, cVar.f56477e), new com.kwad.sdk.core.videocache.kwai.b(this.f56500f.a(this.f56496b), this.f56500f.f56475c));
        eVar.a(this.f56499e);
        return eVar;
    }

    public void a() {
        this.f56498d.clear();
        if (this.f56497c != null) {
            this.f56497c.a((b) null);
            this.f56497c.a();
            this.f56497c = null;
        }
        this.a.set(0);
    }

    public void a(d dVar, Socket socket) {
        c();
        try {
            this.a.incrementAndGet();
            this.f56497c.a(dVar, socket);
        } finally {
            d();
        }
    }

    public int b() {
        return this.a.get();
    }
}
