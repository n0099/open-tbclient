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
    public final String f34579b;

    /* renamed from: c  reason: collision with root package name */
    public volatile e f34580c;

    /* renamed from: e  reason: collision with root package name */
    public final b f34582e;

    /* renamed from: f  reason: collision with root package name */
    public final c f34583f;

    /* renamed from: a  reason: collision with root package name */
    public final AtomicInteger f34578a = new AtomicInteger(0);

    /* renamed from: d  reason: collision with root package name */
    public final List<b> f34581d = new CopyOnWriteArrayList();

    /* loaded from: classes6.dex */
    public static final class a extends Handler implements b {

        /* renamed from: a  reason: collision with root package name */
        public final String f34584a;

        /* renamed from: b  reason: collision with root package name */
        public final List<b> f34585b;

        public a(String str, List<b> list) {
            super(Looper.getMainLooper());
            this.f34584a = str;
            this.f34585b = list;
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
            for (b bVar : this.f34585b) {
                bVar.a((File) message.obj, this.f34584a, message.arg1);
            }
        }
    }

    public g(String str, c cVar) {
        this.f34579b = (String) j.a(str);
        this.f34583f = (c) j.a(cVar);
        this.f34582e = new a(str, this.f34581d);
    }

    private synchronized void c() {
        this.f34580c = this.f34580c == null ? e() : this.f34580c;
    }

    private synchronized void d() {
        if (this.f34578a.decrementAndGet() <= 0) {
            this.f34580c.a();
            this.f34580c = null;
        }
    }

    private e e() {
        String str = this.f34579b;
        c cVar = this.f34583f;
        e eVar = new e(new h(str, cVar.f34550d, cVar.f34551e), new com.kwad.sdk.core.videocache.a.b(this.f34583f.a(this.f34579b), this.f34583f.f34549c));
        eVar.a(this.f34582e);
        return eVar;
    }

    public void a() {
        this.f34581d.clear();
        if (this.f34580c != null) {
            this.f34580c.a((b) null);
            this.f34580c.a();
            this.f34580c = null;
        }
        this.f34578a.set(0);
    }

    public void a(d dVar, Socket socket) {
        c();
        try {
            this.f34578a.incrementAndGet();
            this.f34580c.a(dVar, socket);
        } finally {
            d();
        }
    }

    public int b() {
        return this.f34578a.get();
    }
}
