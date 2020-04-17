package com.xiaomi.push;

import android.text.TextUtils;
import com.xiaomi.push.ee;
import com.xiaomi.push.fm;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.al;
/* loaded from: classes8.dex */
public class fk extends ft {
    private fg a;

    /* renamed from: a  reason: collision with other field name */
    private fh f369a;

    /* renamed from: a  reason: collision with other field name */
    private Thread f370a;

    /* renamed from: a  reason: collision with other field name */
    private byte[] f371a;

    public fk(XMPushService xMPushService, fn fnVar) {
        super(xMPushService, fnVar);
    }

    private ff a(boolean z) {
        fj fjVar = new fj();
        if (z) {
            fjVar.a("1");
        }
        byte[] m332a = ha.m332a();
        if (m332a != null) {
            ee.j jVar = new ee.j();
            jVar.a(a.a(m332a));
            fjVar.a(jVar.a(), (String) null);
        }
        return fjVar;
    }

    private void h() {
        try {
            this.a = new fg(this.f392a.getInputStream(), this);
            this.f369a = new fh(this.f392a.getOutputStream(), this);
            this.f370a = new fl(this, "Blob Reader (" + this.b + ")");
            this.f370a.start();
        } catch (Exception e) {
            throw new fx("Error to init reader and writer", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaomi.push.ft, com.xiaomi.push.fm
    public synchronized void a() {
        h();
        this.f369a.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaomi.push.ft
    public synchronized void a(int i, Exception exc) {
        if (this.a != null) {
            this.a.b();
            this.a = null;
        }
        if (this.f369a != null) {
            try {
                this.f369a.b();
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
            }
            this.f369a = null;
        }
        this.f371a = null;
        super.a(i, exc);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ff ffVar) {
        if (ffVar == null) {
            return;
        }
        if (ffVar.m275a()) {
            com.xiaomi.channel.commonutils.logger.b.m50a("[Slim] RCV blob chid=" + ffVar.a() + "; id=" + ffVar.e() + "; errCode=" + ffVar.b() + "; err=" + ffVar.m279c());
        }
        if (ffVar.a() == 0) {
            if ("PING".equals(ffVar.m272a())) {
                com.xiaomi.channel.commonutils.logger.b.m50a("[Slim] RCV ping id=" + ffVar.e());
                g();
            } else if ("CLOSE".equals(ffVar.m272a())) {
                c(13, null);
            }
        }
        for (fm.a aVar : this.f381a.values()) {
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
    protected void mo282a(boolean z) {
        if (this.f369a == null) {
            throw new fx("The BlobWriter is null.");
        }
        ff a = a(z);
        com.xiaomi.channel.commonutils.logger.b.m50a("[Slim] SND ping id=" + a.e());
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
        if (this.f371a == null && !TextUtils.isEmpty(this.f378a)) {
            String m529a = com.xiaomi.push.service.ba.m529a();
            this.f371a = com.xiaomi.push.service.au.a(this.f378a.getBytes(), (this.f378a.substring(this.f378a.length() / 2) + m529a.substring(m529a.length() / 2)).getBytes());
        }
        return this.f371a;
    }

    @Override // com.xiaomi.push.fm
    public void b(ff ffVar) {
        if (this.f369a == null) {
            throw new fx("the writer is null.");
        }
        try {
            int a = this.f369a.a(ffVar);
            this.d = System.currentTimeMillis();
            String f = ffVar.f();
            if (!TextUtils.isEmpty(f)) {
                gr.a(this.f377a, f, a, false, true, System.currentTimeMillis());
            }
            for (fm.a aVar : this.f384b.values()) {
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
        for (fm.a aVar : this.f381a.values()) {
            aVar.a(gdVar);
        }
    }
}
