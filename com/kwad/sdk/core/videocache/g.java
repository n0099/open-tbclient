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
    public final String f32814b;

    /* renamed from: c  reason: collision with root package name */
    public volatile e f32815c;

    /* renamed from: e  reason: collision with root package name */
    public final b f32817e;

    /* renamed from: f  reason: collision with root package name */
    public final c f32818f;

    /* renamed from: a  reason: collision with root package name */
    public final AtomicInteger f32813a = new AtomicInteger(0);

    /* renamed from: d  reason: collision with root package name */
    public final List<b> f32816d = new CopyOnWriteArrayList();

    /* loaded from: classes6.dex */
    public static final class a extends Handler implements b {

        /* renamed from: a  reason: collision with root package name */
        public final String f32819a;

        /* renamed from: b  reason: collision with root package name */
        public final List<b> f32820b;

        public a(String str, List<b> list) {
            super(Looper.getMainLooper());
            this.f32819a = str;
            this.f32820b = list;
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
            for (b bVar : this.f32820b) {
                bVar.a((File) message.obj, this.f32819a, message.arg1);
            }
        }
    }

    public g(String str, c cVar) {
        this.f32814b = (String) j.a(str);
        this.f32818f = (c) j.a(cVar);
        this.f32817e = new a(str, this.f32816d);
    }

    private synchronized void c() {
        this.f32815c = this.f32815c == null ? e() : this.f32815c;
    }

    private synchronized void d() {
        if (this.f32813a.decrementAndGet() <= 0) {
            this.f32815c.a();
            this.f32815c = null;
        }
    }

    private e e() {
        String str = this.f32814b;
        c cVar = this.f32818f;
        e eVar = new e(new h(str, cVar.f32785d, cVar.f32786e), new com.kwad.sdk.core.videocache.a.b(this.f32818f.a(this.f32814b), this.f32818f.f32784c));
        eVar.a(this.f32817e);
        return eVar;
    }

    public void a() {
        this.f32816d.clear();
        if (this.f32815c != null) {
            this.f32815c.a((b) null);
            this.f32815c.a();
            this.f32815c = null;
        }
        this.f32813a.set(0);
    }

    public void a(d dVar, Socket socket) {
        c();
        try {
            this.f32813a.incrementAndGet();
            this.f32815c.a(dVar, socket);
        } finally {
            d();
        }
    }

    public int b() {
        return this.f32813a.get();
    }
}
