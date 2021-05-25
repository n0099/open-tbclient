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
    public final String f32743b;

    /* renamed from: c  reason: collision with root package name */
    public volatile e f32744c;

    /* renamed from: e  reason: collision with root package name */
    public final b f32746e;

    /* renamed from: f  reason: collision with root package name */
    public final c f32747f;

    /* renamed from: a  reason: collision with root package name */
    public final AtomicInteger f32742a = new AtomicInteger(0);

    /* renamed from: d  reason: collision with root package name */
    public final List<b> f32745d = new CopyOnWriteArrayList();

    /* loaded from: classes6.dex */
    public static final class a extends Handler implements b {

        /* renamed from: a  reason: collision with root package name */
        public final String f32748a;

        /* renamed from: b  reason: collision with root package name */
        public final List<b> f32749b;

        public a(String str, List<b> list) {
            super(Looper.getMainLooper());
            this.f32748a = str;
            this.f32749b = list;
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
            for (b bVar : this.f32749b) {
                bVar.a((File) message.obj, this.f32748a, message.arg1);
            }
        }
    }

    public g(String str, c cVar) {
        this.f32743b = (String) j.a(str);
        this.f32747f = (c) j.a(cVar);
        this.f32746e = new a(str, this.f32745d);
    }

    private synchronized void c() {
        this.f32744c = this.f32744c == null ? e() : this.f32744c;
    }

    private synchronized void d() {
        if (this.f32742a.decrementAndGet() <= 0) {
            this.f32744c.a();
            this.f32744c = null;
        }
    }

    private e e() {
        String str = this.f32743b;
        c cVar = this.f32747f;
        e eVar = new e(new h(str, cVar.f32714d, cVar.f32715e), new com.kwad.sdk.core.videocache.a.b(this.f32747f.a(this.f32743b), this.f32747f.f32713c));
        eVar.a(this.f32746e);
        return eVar;
    }

    public void a() {
        this.f32745d.clear();
        if (this.f32744c != null) {
            this.f32744c.a((b) null);
            this.f32744c.a();
            this.f32744c = null;
        }
        this.f32742a.set(0);
    }

    public void a(d dVar, Socket socket) {
        c();
        try {
            this.f32742a.incrementAndGet();
            this.f32744c.a(dVar, socket);
        } finally {
            d();
        }
    }

    public int b() {
        return this.f32742a.get();
    }
}
