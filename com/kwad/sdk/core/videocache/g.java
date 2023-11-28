package com.kwad.sdk.core.videocache;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.kwad.sdk.utils.ap;
import java.io.File;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes10.dex */
public final class g {
    public final c aAW;
    public volatile e aBb;
    public final b aBd;
    public final String url;
    public final AtomicInteger aBa = new AtomicInteger(0);
    public final List<b> aBc = new CopyOnWriteArrayList();

    /* loaded from: classes10.dex */
    public static final class a extends Handler implements b {
        public final List<b> aBc;
        public final String url;

        public a(String str, List<b> list) {
            super(Looper.getMainLooper());
            this.url = str;
            this.aBc = list;
        }

        @Override // com.kwad.sdk.core.videocache.b
        public final void a(File file, int i) {
            Message obtainMessage = obtainMessage();
            obtainMessage.arg1 = i;
            obtainMessage.obj = file;
            sendMessage(obtainMessage);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            for (b bVar : this.aBc) {
                bVar.a((File) message.obj, message.arg1);
            }
        }
    }

    public g(String str, c cVar) {
        this.url = ap.fZ(str);
        this.aAW = (c) ap.checkNotNull(cVar);
        this.aBd = new a(str, this.aBc);
    }

    public final void a(d dVar, Socket socket) {
        Fk();
        try {
            this.aBa.incrementAndGet();
            this.aBb.a(dVar, socket);
        } finally {
            Fl();
        }
    }

    private synchronized void Fk() {
        e eVar;
        e eVar2;
        if (this.aAW.aAI == 1 && isOkHttpSupported()) {
            if (this.aBb == null) {
                eVar2 = Fn();
            } else {
                eVar2 = this.aBb;
            }
            this.aBb = eVar2;
            return;
        }
        if (this.aBb == null) {
            eVar = Fm();
        } else {
            eVar = this.aBb;
        }
        this.aBb = eVar;
    }

    private synchronized void Fl() {
        if (this.aBa.decrementAndGet() <= 0) {
            this.aBb.shutdown();
            this.aBb = null;
        }
    }

    private e Fm() {
        String str = this.url;
        c cVar = this.aAW;
        e eVar = new e(new h(str, cVar.aAG, cVar.aAH), new com.kwad.sdk.core.videocache.a.b(this.aAW.ec(this.url), this.aAW.aAF));
        eVar.a(this.aBd);
        return eVar;
    }

    private e Fn() {
        String str = this.url;
        c cVar = this.aAW;
        e eVar = new e(new j(str, cVar.aAG, cVar.aAH), new com.kwad.sdk.core.videocache.a.b(this.aAW.ec(this.url), this.aAW.aAF));
        eVar.a(this.aBd);
        return eVar;
    }

    public static boolean isOkHttpSupported() {
        try {
            Class.forName("okhttp3.OkHttpClient");
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public final int Fh() {
        return this.aBa.get();
    }

    public final void shutdown() {
        this.aBc.clear();
        e eVar = this.aBb;
        if (eVar != null) {
            eVar.a((b) null);
            eVar.shutdown();
        }
        this.aBb = null;
        this.aBa.set(0);
    }
}
