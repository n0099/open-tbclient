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
    public final String f34933b;

    /* renamed from: c  reason: collision with root package name */
    public volatile e f34934c;

    /* renamed from: e  reason: collision with root package name */
    public final b f34936e;

    /* renamed from: f  reason: collision with root package name */
    public final c f34937f;

    /* renamed from: a  reason: collision with root package name */
    public final AtomicInteger f34932a = new AtomicInteger(0);

    /* renamed from: d  reason: collision with root package name */
    public final List<b> f34935d = new CopyOnWriteArrayList();

    /* loaded from: classes7.dex */
    public static final class a extends Handler implements b {

        /* renamed from: a  reason: collision with root package name */
        public final String f34938a;

        /* renamed from: b  reason: collision with root package name */
        public final List<b> f34939b;

        public a(String str, List<b> list) {
            super(Looper.getMainLooper());
            this.f34938a = str;
            this.f34939b = list;
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
            for (b bVar : this.f34939b) {
                bVar.a((File) message.obj, this.f34938a, message.arg1);
            }
        }
    }

    public g(String str, c cVar) {
        this.f34933b = (String) j.a(str);
        this.f34937f = (c) j.a(cVar);
        this.f34936e = new a(str, this.f34935d);
    }

    private synchronized void c() {
        this.f34934c = this.f34934c == null ? e() : this.f34934c;
    }

    private synchronized void d() {
        if (this.f34932a.decrementAndGet() <= 0) {
            this.f34934c.a();
            this.f34934c = null;
        }
    }

    private e e() {
        String str = this.f34933b;
        c cVar = this.f34937f;
        e eVar = new e(new h(str, cVar.f34904d, cVar.f34905e), new com.kwad.sdk.core.videocache.a.b(this.f34937f.a(this.f34933b), this.f34937f.f34903c));
        eVar.a(this.f34936e);
        return eVar;
    }

    public void a() {
        this.f34935d.clear();
        if (this.f34934c != null) {
            this.f34934c.a((b) null);
            this.f34934c.a();
            this.f34934c = null;
        }
        this.f34932a.set(0);
    }

    public void a(d dVar, Socket socket) {
        c();
        try {
            this.f34932a.incrementAndGet();
            this.f34934c.a(dVar, socket);
        } finally {
            d();
        }
    }

    public int b() {
        return this.f34932a.get();
    }
}
