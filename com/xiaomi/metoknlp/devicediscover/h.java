package com.xiaomi.metoknlp.devicediscover;

import android.os.Handler;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class h implements p {
    final /* synthetic */ n a;
    private String b;
    private long c;
    private long d;

    private h(n nVar) {
        this.a = nVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ h(n nVar, b bVar) {
        this(nVar);
    }

    public long a() {
        return this.c;
    }

    @Override // com.xiaomi.metoknlp.devicediscover.p
    public void a(String str, long j, long j2) {
        Handler handler;
        this.b = str;
        this.c = j;
        this.d = j2;
        handler = this.a.j;
        handler.obtainMessage(1).sendToTarget();
    }

    public long b() {
        return this.d;
    }
}
