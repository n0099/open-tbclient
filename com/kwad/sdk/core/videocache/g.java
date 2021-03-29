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
    public final String f34195b;

    /* renamed from: c  reason: collision with root package name */
    public volatile e f34196c;

    /* renamed from: e  reason: collision with root package name */
    public final b f34198e;

    /* renamed from: f  reason: collision with root package name */
    public final c f34199f;

    /* renamed from: a  reason: collision with root package name */
    public final AtomicInteger f34194a = new AtomicInteger(0);

    /* renamed from: d  reason: collision with root package name */
    public final List<b> f34197d = new CopyOnWriteArrayList();

    /* loaded from: classes6.dex */
    public static final class a extends Handler implements b {

        /* renamed from: a  reason: collision with root package name */
        public final String f34200a;

        /* renamed from: b  reason: collision with root package name */
        public final List<b> f34201b;

        public a(String str, List<b> list) {
            super(Looper.getMainLooper());
            this.f34200a = str;
            this.f34201b = list;
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
            for (b bVar : this.f34201b) {
                bVar.a((File) message.obj, this.f34200a, message.arg1);
            }
        }
    }

    public g(String str, c cVar) {
        this.f34195b = (String) j.a(str);
        this.f34199f = (c) j.a(cVar);
        this.f34198e = new a(str, this.f34197d);
    }

    private synchronized void c() {
        this.f34196c = this.f34196c == null ? e() : this.f34196c;
    }

    private synchronized void d() {
        if (this.f34194a.decrementAndGet() <= 0) {
            this.f34196c.a();
            this.f34196c = null;
        }
    }

    private e e() {
        String str = this.f34195b;
        c cVar = this.f34199f;
        e eVar = new e(new h(str, cVar.f34166d, cVar.f34167e), new com.kwad.sdk.core.videocache.a.b(this.f34199f.a(this.f34195b), this.f34199f.f34165c));
        eVar.a(this.f34198e);
        return eVar;
    }

    public void a() {
        this.f34197d.clear();
        if (this.f34196c != null) {
            this.f34196c.a((b) null);
            this.f34196c.a();
            this.f34196c = null;
        }
        this.f34194a.set(0);
    }

    public void a(d dVar, Socket socket) {
        c();
        try {
            this.f34194a.incrementAndGet();
            this.f34196c.a(dVar, socket);
        } finally {
            d();
        }
    }

    public int b() {
        return this.f34194a.get();
    }
}
