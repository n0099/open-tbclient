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
    public final String f33569b;

    /* renamed from: c  reason: collision with root package name */
    public volatile e f33570c;

    /* renamed from: e  reason: collision with root package name */
    public final b f33572e;

    /* renamed from: f  reason: collision with root package name */
    public final c f33573f;

    /* renamed from: a  reason: collision with root package name */
    public final AtomicInteger f33568a = new AtomicInteger(0);

    /* renamed from: d  reason: collision with root package name */
    public final List<b> f33571d = new CopyOnWriteArrayList();

    /* loaded from: classes6.dex */
    public static final class a extends Handler implements b {

        /* renamed from: a  reason: collision with root package name */
        public final String f33574a;

        /* renamed from: b  reason: collision with root package name */
        public final List<b> f33575b;

        public a(String str, List<b> list) {
            super(Looper.getMainLooper());
            this.f33574a = str;
            this.f33575b = list;
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
            for (b bVar : this.f33575b) {
                bVar.a((File) message.obj, this.f33574a, message.arg1);
            }
        }
    }

    public g(String str, c cVar) {
        this.f33569b = (String) j.a(str);
        this.f33573f = (c) j.a(cVar);
        this.f33572e = new a(str, this.f33571d);
    }

    private synchronized void c() {
        this.f33570c = this.f33570c == null ? e() : this.f33570c;
    }

    private synchronized void d() {
        if (this.f33568a.decrementAndGet() <= 0) {
            this.f33570c.a();
            this.f33570c = null;
        }
    }

    private e e() {
        String str = this.f33569b;
        c cVar = this.f33573f;
        e eVar = new e(new h(str, cVar.f33540d, cVar.f33541e), new com.kwad.sdk.core.videocache.a.b(this.f33573f.a(this.f33569b), this.f33573f.f33539c));
        eVar.a(this.f33572e);
        return eVar;
    }

    public void a() {
        this.f33571d.clear();
        if (this.f33570c != null) {
            this.f33570c.a((b) null);
            this.f33570c.a();
            this.f33570c = null;
        }
        this.f33568a.set(0);
    }

    public void a(d dVar, Socket socket) {
        c();
        try {
            this.f33568a.incrementAndGet();
            this.f33570c.a(dVar, socket);
        } finally {
            d();
        }
    }

    public int b() {
        return this.f33568a.get();
    }
}
