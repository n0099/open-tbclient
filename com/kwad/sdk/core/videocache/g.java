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
    public final String f56284b;

    /* renamed from: c  reason: collision with root package name */
    public volatile e f56285c;

    /* renamed from: e  reason: collision with root package name */
    public final b f56287e;

    /* renamed from: f  reason: collision with root package name */
    public final c f56288f;
    public final AtomicInteger a = new AtomicInteger(0);

    /* renamed from: d  reason: collision with root package name */
    public final List<b> f56286d = new CopyOnWriteArrayList();

    /* loaded from: classes3.dex */
    public static final class a extends Handler implements b {
        public final String a;

        /* renamed from: b  reason: collision with root package name */
        public final List<b> f56289b;

        public a(String str, List<b> list) {
            super(Looper.getMainLooper());
            this.a = str;
            this.f56289b = list;
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
            for (b bVar : this.f56289b) {
                bVar.a((File) message.obj, this.a, message.arg1);
            }
        }
    }

    public g(String str, c cVar) {
        this.f56284b = (String) j.a(str);
        this.f56288f = (c) j.a(cVar);
        this.f56287e = new a(str, this.f56286d);
    }

    private synchronized void c() {
        this.f56285c = this.f56285c == null ? e() : this.f56285c;
    }

    private synchronized void d() {
        if (this.a.decrementAndGet() <= 0) {
            this.f56285c.a();
            this.f56285c = null;
        }
    }

    private e e() {
        String str = this.f56284b;
        c cVar = this.f56288f;
        e eVar = new e(new h(str, cVar.f56264d, cVar.f56265e), new com.kwad.sdk.core.videocache.kwai.b(this.f56288f.a(this.f56284b), this.f56288f.f56263c));
        eVar.a(this.f56287e);
        return eVar;
    }

    public void a() {
        this.f56286d.clear();
        if (this.f56285c != null) {
            this.f56285c.a((b) null);
            this.f56285c.a();
            this.f56285c = null;
        }
        this.a.set(0);
    }

    public void a(d dVar, Socket socket) {
        c();
        try {
            this.a.incrementAndGet();
            this.f56285c.a(dVar, socket);
        } finally {
            d();
        }
    }

    public int b() {
        return this.a.get();
    }
}
