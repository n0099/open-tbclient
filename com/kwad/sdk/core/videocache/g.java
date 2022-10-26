package com.kwad.sdk.core.videocache;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.kwad.sdk.utils.am;
import java.io.File;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
public final class g {
    public volatile e aeD;
    public final b aeF;
    public final c aey;
    public final String url;
    public final AtomicInteger aeC = new AtomicInteger(0);
    public final List aeE = new CopyOnWriteArrayList();

    /* loaded from: classes7.dex */
    public final class a extends Handler implements b {
        public final List aeE;
        public final String url;

        public a(String str, List list) {
            super(Looper.getMainLooper());
            this.url = str;
            this.aeE = list;
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
            for (b bVar : this.aeE) {
                bVar.a((File) message.obj, message.arg1);
            }
        }
    }

    public g(String str, c cVar) {
        this.url = am.dQ(str);
        this.aey = (c) am.checkNotNull(cVar);
        this.aeF = new a(str, this.aeE);
    }

    private synchronized void vO() {
        this.aeD = this.aeD == null ? vQ() : this.aeD;
    }

    private synchronized void vP() {
        if (this.aeC.decrementAndGet() <= 0) {
            this.aeD.shutdown();
            this.aeD = null;
        }
    }

    private e vQ() {
        String str = this.url;
        c cVar = this.aey;
        e eVar = new e(new h(str, cVar.aek, cVar.ael), new com.kwad.sdk.core.videocache.kwai.b(this.aey.cx(this.url), this.aey.aej));
        eVar.a(this.aeF);
        return eVar;
    }

    public final void a(d dVar, Socket socket) {
        vO();
        try {
            this.aeC.incrementAndGet();
            this.aeD.a(dVar, socket);
        } finally {
            vP();
        }
    }

    public final void shutdown() {
        this.aeE.clear();
        e eVar = this.aeD;
        if (eVar != null) {
            eVar.a((b) null);
            eVar.shutdown();
        }
        this.aeD = null;
        this.aeC.set(0);
    }

    public final int vL() {
        return this.aeC.get();
    }
}
