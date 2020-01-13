package com.xiaomi.push;

import android.text.TextUtils;
import com.xiaomi.push.ee;
import com.xiaomi.push.fm;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.al;
/* loaded from: classes6.dex */
public class fk extends ft {
    private fg a;

    /* renamed from: a  reason: collision with other field name */
    private fh f371a;

    /* renamed from: a  reason: collision with other field name */
    private Thread f372a;

    /* renamed from: a  reason: collision with other field name */
    private byte[] f373a;

    public fk(XMPushService xMPushService, fn fnVar) {
        super(xMPushService, fnVar);
    }

    private ff a(boolean z) {
        fj fjVar = new fj();
        if (z) {
            fjVar.a("1");
        }
        byte[] m324a = ha.m324a();
        if (m324a != null) {
            ee.j jVar = new ee.j();
            jVar.a(a.a(m324a));
            fjVar.a(jVar.a(), (String) null);
        }
        return fjVar;
    }

    private void h() {
        try {
            this.a = new fg(this.f394a.getInputStream(), this);
            this.f371a = new fh(this.f394a.getOutputStream(), this);
            this.f372a = new fl(this, "Blob Reader (" + this.b + ")");
            this.f372a.start();
        } catch (Exception e) {
            throw new fx("Error to init reader and writer", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaomi.push.ft, com.xiaomi.push.fm
    public synchronized void a() {
        h();
        this.f371a.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaomi.push.ft
    public synchronized void a(int i, Exception exc) {
        if (this.a != null) {
            this.a.b();
            this.a = null;
        }
        if (this.f371a != null) {
            try {
                this.f371a.b();
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
            }
            this.f371a = null;
        }
        this.f373a = null;
        super.a(i, exc);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ff ffVar) {
        if (ffVar == null) {
            return;
        }
        if (ffVar.m267a()) {
            com.xiaomi.channel.commonutils.logger.b.m42a("[Slim] RCV blob chid=" + ffVar.a() + "; id=" + ffVar.e() + "; errCode=" + ffVar.b() + "; err=" + ffVar.m271c());
        }
        if (ffVar.a() == 0) {
            if ("PING".equals(ffVar.m264a())) {
                com.xiaomi.channel.commonutils.logger.b.m42a("[Slim] RCV ping id=" + ffVar.e());
                g();
            } else if ("CLOSE".equals(ffVar.m264a())) {
                c(13, null);
            }
        }
        for (fm.a aVar : this.f383a.values()) {
            aVar.a(ffVar);
        }
    }

    @Override // com.xiaomi.push.fm
    @Deprecated
    public void a(gd gdVar) {
        b(ff.a(gdVar, (String) null));
    }

    @Override // com.xiaomi.push.fm
    public synchronized void a(al.b bVar) {
        fe.a(bVar, c(), this);
    }

    @Override // com.xiaomi.push.fm
    public synchronized void a(String str, String str2) {
        fe.a(str, str2, this);
    }

    @Override // com.xiaomi.push.ft
    /* renamed from: a  reason: collision with other method in class */
    protected void mo274a(boolean z) {
        if (this.f371a == null) {
            throw new fx("The BlobWriter is null.");
        }
        ff a = a(z);
        com.xiaomi.channel.commonutils.logger.b.m42a("[Slim] SND ping id=" + a.e());
        b(a);
        f();
    }

    @Override // com.xiaomi.push.ft, com.xiaomi.push.fm
    public void a(ff[] ffVarArr) {
        for (ff ffVar : ffVarArr) {
            b(ffVar);
        }
    }

    @Override // com.xiaomi.push.ft, com.xiaomi.push.fm
    public boolean a() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.xiaomi.push.ft, com.xiaomi.push.fm
    public synchronized byte[] a() {
        if (this.f373a == null && !TextUtils.isEmpty(this.f380a)) {
            String m521a = com.xiaomi.push.service.ba.m521a();
            this.f373a = com.xiaomi.push.service.au.a(this.f380a.getBytes(), (this.f380a.substring(this.f380a.length() / 2) + m521a.substring(m521a.length() / 2)).getBytes());
        }
        return this.f373a;
    }

    @Override // com.xiaomi.push.fm
    public void b(ff ffVar) {
        if (this.f371a == null) {
            throw new fx("the writer is null.");
        }
        try {
            int a = this.f371a.a(ffVar);
            this.d = System.currentTimeMillis();
            String f = ffVar.f();
            if (!TextUtils.isEmpty(f)) {
                gr.a(this.f379a, f, a, false, true, System.currentTimeMillis());
            }
            for (fm.a aVar : this.f386b.values()) {
                aVar.a(ffVar);
            }
        } catch (Exception e) {
            throw new fx(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(gd gdVar) {
        if (gdVar == null) {
            return;
        }
        for (fm.a aVar : this.f383a.values()) {
            aVar.a(gdVar);
        }
    }
}
