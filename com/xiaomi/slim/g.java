package com.xiaomi.slim;

import android.text.TextUtils;
import com.xiaomi.push.protobuf.b;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.as;
import com.xiaomi.push.service.bb;
import com.xiaomi.push.service.bh;
import com.xiaomi.smack.a;
import com.xiaomi.smack.l;
/* loaded from: classes3.dex */
public class g extends com.xiaomi.smack.h {
    private Thread v;
    private c w;
    private d x;
    private byte[] y;

    public g(XMPushService xMPushService, com.xiaomi.smack.b bVar) {
        super(xMPushService, bVar);
    }

    private b c(boolean z) {
        f fVar = new f();
        if (z) {
            fVar.a("1");
        }
        byte[] c = com.xiaomi.stats.h.c();
        if (c != null) {
            b.j jVar = new b.j();
            jVar.a(com.google.protobuf.micro.a.a(c));
            fVar.a(jVar.c(), (String) null);
        }
        return fVar;
    }

    private void w() {
        try {
            this.w = new c(this.p.getInputStream(), this);
            this.x = new d(this.p.getOutputStream(), this);
            this.v = new h(this, "Blob Reader (" + this.k + ")");
            this.v.start();
        } catch (Exception e) {
            throw new l("Error to init reader and writer", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaomi.smack.h
    public synchronized void a(int i, Exception exc) {
        if (this.w != null) {
            this.w.b();
            this.w = null;
        }
        if (this.x != null) {
            try {
                this.x.b();
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
            }
            this.x = null;
        }
        this.y = null;
        super.a(i, exc);
    }

    @Override // com.xiaomi.smack.a
    public synchronized void a(as.b bVar) {
        a.a(bVar, r(), this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b bVar) {
        if (bVar == null) {
            return;
        }
        if (bVar.d()) {
            com.xiaomi.channel.commonutils.logger.b.a("[Slim] RCV blob chid=" + bVar.c() + "; id=" + bVar.h() + "; errCode=" + bVar.e() + "; err=" + bVar.f());
        }
        if (bVar.c() == 0) {
            if ("PING".equals(bVar.a())) {
                com.xiaomi.channel.commonutils.logger.b.a("[Slim] RCV ping id=" + bVar.h());
                v();
            } else if ("CLOSE".equals(bVar.a())) {
                c(13, null);
            }
        }
        for (a.C0502a c0502a : this.f.values()) {
            c0502a.a(bVar);
        }
    }

    @Override // com.xiaomi.smack.a
    @Deprecated
    public void a(com.xiaomi.smack.packet.d dVar) {
        b(b.a(dVar, (String) null));
    }

    @Override // com.xiaomi.smack.a
    public synchronized void a(String str, String str2) {
        a.a(str, str2, this);
    }

    @Override // com.xiaomi.smack.h
    protected void a(boolean z) {
        if (this.x == null) {
            throw new l("The BlobWriter is null.");
        }
        b c = c(z);
        com.xiaomi.channel.commonutils.logger.b.a("[Slim] SND ping id=" + c.h());
        b(c);
        u();
    }

    @Override // com.xiaomi.smack.h, com.xiaomi.smack.a
    public void a(b[] bVarArr) {
        for (b bVar : bVarArr) {
            b(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized byte[] a() {
        if (this.y == null && !TextUtils.isEmpty(this.i)) {
            String e = bh.e();
            this.y = bb.a(this.i.getBytes(), (this.i.substring(this.i.length() / 2) + e.substring(e.length() / 2)).getBytes());
        }
        return this.y;
    }

    @Override // com.xiaomi.smack.a
    public void b(b bVar) {
        if (this.x == null) {
            throw new l("the writer is null.");
        }
        try {
            int a = this.x.a(bVar);
            this.n = System.currentTimeMillis();
            String i = bVar.i();
            if (!TextUtils.isEmpty(i)) {
                com.xiaomi.smack.util.g.a(this.m, i, a, false, System.currentTimeMillis());
            }
            for (a.C0502a c0502a : this.g.values()) {
                c0502a.a(bVar);
            }
        } catch (Exception e) {
            throw new l(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(com.xiaomi.smack.packet.d dVar) {
        if (dVar == null) {
            return;
        }
        for (a.C0502a c0502a : this.f.values()) {
            c0502a.a(dVar);
        }
    }

    @Override // com.xiaomi.smack.a
    public boolean b() {
        return true;
    }

    @Override // com.xiaomi.smack.h
    protected synchronized void c() {
        w();
        this.x.a();
    }
}
