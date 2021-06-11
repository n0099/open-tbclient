package com.kwad.sdk.core.videocache;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.io.File;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
public final class g {

    /* renamed from: b  reason: collision with root package name */
    public final String f34835b;

    /* renamed from: c  reason: collision with root package name */
    public volatile e f34836c;

    /* renamed from: e  reason: collision with root package name */
    public final b f34838e;

    /* renamed from: f  reason: collision with root package name */
    public final c f34839f;

    /* renamed from: a  reason: collision with root package name */
    public final AtomicInteger f34834a = new AtomicInteger(0);

    /* renamed from: d  reason: collision with root package name */
    public final List<b> f34837d = new CopyOnWriteArrayList();

    /* loaded from: classes7.dex */
    public static final class a extends Handler implements b {

        /* renamed from: a  reason: collision with root package name */
        public final String f34840a;

        /* renamed from: b  reason: collision with root package name */
        public final List<b> f34841b;

        public a(String str, List<b> list) {
            super(Looper.getMainLooper());
            this.f34840a = str;
            this.f34841b = list;
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
            for (b bVar : this.f34841b) {
                bVar.a((File) message.obj, this.f34840a, message.arg1);
            }
        }
    }

    public g(String str, c cVar) {
        this.f34835b = (String) j.a(str);
        this.f34839f = (c) j.a(cVar);
        this.f34838e = new a(str, this.f34837d);
    }

    private synchronized void c() {
        this.f34836c = this.f34836c == null ? e() : this.f34836c;
    }

    private synchronized void d() {
        if (this.f34834a.decrementAndGet() <= 0) {
            this.f34836c.a();
            this.f34836c = null;
        }
    }

    private e e() {
        String str = this.f34835b;
        c cVar = this.f34839f;
        e eVar = new e(new h(str, cVar.f34806d, cVar.f34807e), new com.kwad.sdk.core.videocache.a.b(this.f34839f.a(this.f34835b), this.f34839f.f34805c));
        eVar.a(this.f34838e);
        return eVar;
    }

    public void a() {
        this.f34837d.clear();
        if (this.f34836c != null) {
            this.f34836c.a((b) null);
            this.f34836c.a();
            this.f34836c = null;
        }
        this.f34834a.set(0);
    }

    public void a(d dVar, Socket socket) {
        c();
        try {
            this.f34834a.incrementAndGet();
            this.f34836c.a(dVar, socket);
        } finally {
            d();
        }
    }

    public int b() {
        return this.f34834a.get();
    }
}
