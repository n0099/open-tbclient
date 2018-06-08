package com.xiaomi.slim;

import android.text.TextUtils;
import com.xiaomi.push.protobuf.b;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.ak;
import com.xiaomi.smack.a;
import com.xiaomi.smack.h;
import com.xiaomi.smack.l;
/* loaded from: classes3.dex */
public class f extends h {
    private Thread v;
    private c w;
    private d x;

    public f(XMPushService xMPushService, com.xiaomi.smack.b bVar) {
        super(xMPushService, bVar);
    }

    private b c(boolean z) {
        b bVar = new b();
        bVar.a("PING", (String) null);
        if (z) {
            bVar.a("1");
        } else {
            bVar.a("0");
        }
        b.j jVar = new b.j();
        byte[] a = c().a();
        if (a != null) {
            try {
                jVar.a(b.C0291b.b(a));
            } catch (com.google.protobuf.micro.d e) {
            }
        }
        byte[] c = com.xiaomi.stats.h.c();
        if (c != null) {
            jVar.a(com.google.protobuf.micro.a.a(c));
        }
        bVar.a(jVar.c(), (String) null);
        return bVar;
    }

    private void v() {
        try {
            this.w = new c(this.p.getInputStream(), this);
            this.x = new d(this.p.getOutputStream(), this);
            this.v = new g(this, "Blob Reader (" + this.l + ")");
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
        super.a(i, exc);
    }

    @Override // com.xiaomi.smack.a
    public synchronized void a(ak.b bVar) {
        a.a(bVar, q(), this);
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
                u();
            } else if ("CLOSE".equals(bVar.a())) {
                c(13, null);
            }
        }
        for (a.C0294a c0294a : this.g.values()) {
            c0294a.a(bVar);
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
        t();
    }

    @Override // com.xiaomi.smack.h, com.xiaomi.smack.a
    public void a(b[] bVarArr) {
        for (b bVar : bVarArr) {
            b(bVar);
        }
    }

    @Override // com.xiaomi.smack.h, com.xiaomi.smack.a
    public void a(com.xiaomi.smack.packet.d[] dVarArr) {
        for (com.xiaomi.smack.packet.d dVar : dVarArr) {
            a(dVar);
        }
    }

    @Override // com.xiaomi.smack.a
    public boolean a() {
        return true;
    }

    @Override // com.xiaomi.smack.h
    protected synchronized void b() {
        v();
        this.x.a();
    }

    @Override // com.xiaomi.smack.a
    public void b(b bVar) {
        if (this.x == null) {
            throw new l("the writer is null.");
        }
        try {
            int a = this.x.a(bVar);
            String i = bVar.i();
            if (!TextUtils.isEmpty(i)) {
                com.xiaomi.smack.util.g.a(this.n, i, a, false, System.currentTimeMillis());
            }
            for (a.C0294a c0294a : this.h.values()) {
                c0294a.a(bVar);
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
        for (a.C0294a c0294a : this.g.values()) {
            c0294a.a(dVar);
        }
    }
}
