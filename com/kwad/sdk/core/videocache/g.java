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
    public final String f34484b;

    /* renamed from: c  reason: collision with root package name */
    public volatile e f34485c;

    /* renamed from: e  reason: collision with root package name */
    public final b f34487e;

    /* renamed from: f  reason: collision with root package name */
    public final c f34488f;

    /* renamed from: a  reason: collision with root package name */
    public final AtomicInteger f34483a = new AtomicInteger(0);

    /* renamed from: d  reason: collision with root package name */
    public final List<b> f34486d = new CopyOnWriteArrayList();

    /* loaded from: classes6.dex */
    public static final class a extends Handler implements b {

        /* renamed from: a  reason: collision with root package name */
        public final String f34489a;

        /* renamed from: b  reason: collision with root package name */
        public final List<b> f34490b;

        public a(String str, List<b> list) {
            super(Looper.getMainLooper());
            this.f34489a = str;
            this.f34490b = list;
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
            for (b bVar : this.f34490b) {
                bVar.a((File) message.obj, this.f34489a, message.arg1);
            }
        }
    }

    public g(String str, c cVar) {
        this.f34484b = (String) j.a(str);
        this.f34488f = (c) j.a(cVar);
        this.f34487e = new a(str, this.f34486d);
    }

    private synchronized void c() {
        this.f34485c = this.f34485c == null ? e() : this.f34485c;
    }

    private synchronized void d() {
        if (this.f34483a.decrementAndGet() <= 0) {
            this.f34485c.a();
            this.f34485c = null;
        }
    }

    private e e() {
        String str = this.f34484b;
        c cVar = this.f34488f;
        e eVar = new e(new h(str, cVar.f34455d, cVar.f34456e), new com.kwad.sdk.core.videocache.a.b(this.f34488f.a(this.f34484b), this.f34488f.f34454c));
        eVar.a(this.f34487e);
        return eVar;
    }

    public void a() {
        this.f34486d.clear();
        if (this.f34485c != null) {
            this.f34485c.a((b) null);
            this.f34485c.a();
            this.f34485c = null;
        }
        this.f34483a.set(0);
    }

    public void a(d dVar, Socket socket) {
        c();
        try {
            this.f34483a.incrementAndGet();
            this.f34485c.a(dVar, socket);
        } finally {
            d();
        }
    }

    public int b() {
        return this.f34483a.get();
    }
}
