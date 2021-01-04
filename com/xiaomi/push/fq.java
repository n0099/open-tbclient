package com.xiaomi.push;

import android.text.TextUtils;
import com.xiaomi.push.ek;
import com.xiaomi.push.fs;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.ap;
/* loaded from: classes6.dex */
public class fq extends fz {

    /* renamed from: a  reason: collision with root package name */
    private fm f14324a;

    /* renamed from: a  reason: collision with other field name */
    private fn f434a;

    /* renamed from: a  reason: collision with other field name */
    private Thread f435a;

    /* renamed from: a  reason: collision with other field name */
    private byte[] f436a;

    public fq(XMPushService xMPushService, ft ftVar) {
        super(xMPushService, ftVar);
    }

    private fl a(boolean z) {
        fp fpVar = new fp();
        if (z) {
            fpVar.a("1");
        }
        byte[] m359a = hg.m359a();
        if (m359a != null) {
            ek.j jVar = new ek.j();
            jVar.a(a.a(m359a));
            fpVar.a(jVar.a(), (String) null);
        }
        return fpVar;
    }

    private void h() {
        try {
            this.f14324a = new fm(this.f457a.getInputStream(), this);
            this.f434a = new fn(this.f457a.getOutputStream(), this);
            this.f435a = new fr(this, "Blob Reader (" + this.f14327b + ")");
            this.f435a.start();
        } catch (Exception e) {
            throw new gd("Error to init reader and writer", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaomi.push.fz, com.xiaomi.push.fs
    public synchronized void a() {
        h();
        this.f434a.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaomi.push.fz
    public synchronized void a(int i, Exception exc) {
        if (this.f14324a != null) {
            this.f14324a.b();
            this.f14324a = null;
        }
        if (this.f434a != null) {
            try {
                this.f434a.b();
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
            }
            this.f434a = null;
        }
        this.f436a = null;
        super.a(i, exc);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(fl flVar) {
        if (flVar == null) {
            return;
        }
        if (flVar.m302a()) {
            com.xiaomi.channel.commonutils.logger.b.m73a("[Slim] RCV blob chid=" + flVar.a() + "; id=" + flVar.e() + "; errCode=" + flVar.b() + "; err=" + flVar.m306c());
        }
        if (flVar.a() == 0) {
            if ("PING".equals(flVar.m299a())) {
                com.xiaomi.channel.commonutils.logger.b.m73a("[Slim] RCV ping id=" + flVar.e());
                g();
            } else if ("CLOSE".equals(flVar.m299a())) {
                c(13, null);
            }
        }
        for (fs.a aVar : this.f446a.values()) {
            aVar.a(flVar);
        }
    }

    @Override // com.xiaomi.push.fs
    @Deprecated
    public void a(gj gjVar) {
        b(fl.a(gjVar, (String) null));
    }

    @Override // com.xiaomi.push.fs
    public synchronized void a(ap.b bVar) {
        fk.a(bVar, c(), this);
    }

    @Override // com.xiaomi.push.fs
    public synchronized void a(String str, String str2) {
        fk.a(str, str2, this);
    }

    @Override // com.xiaomi.push.fz
    /* renamed from: a  reason: collision with other method in class */
    protected void mo309a(boolean z) {
        if (this.f434a == null) {
            throw new gd("The BlobWriter is null.");
        }
        fl a2 = a(z);
        com.xiaomi.channel.commonutils.logger.b.m73a("[Slim] SND ping id=" + a2.e());
        b(a2);
        f();
    }

    @Override // com.xiaomi.push.fz, com.xiaomi.push.fs
    public void a(fl[] flVarArr) {
        for (fl flVar : flVarArr) {
            b(flVar);
        }
    }

    @Override // com.xiaomi.push.fz, com.xiaomi.push.fs
    public boolean a() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.xiaomi.push.fz, com.xiaomi.push.fs
    public synchronized byte[] a() {
        if (this.f436a == null && !TextUtils.isEmpty(this.f443a)) {
            String m578a = com.xiaomi.push.service.be.m578a();
            this.f436a = com.xiaomi.push.service.ay.a(this.f443a.getBytes(), (this.f443a.substring(this.f443a.length() / 2) + m578a.substring(m578a.length() / 2)).getBytes());
        }
        return this.f436a;
    }

    @Override // com.xiaomi.push.fs
    public void b(fl flVar) {
        if (this.f434a == null) {
            throw new gd("the writer is null.");
        }
        try {
            int a2 = this.f434a.a(flVar);
            this.d = System.currentTimeMillis();
            String f = flVar.f();
            if (!TextUtils.isEmpty(f)) {
                gx.a(this.f442a, f, a2, false, true, System.currentTimeMillis());
            }
            for (fs.a aVar : this.f449b.values()) {
                aVar.a(flVar);
            }
        } catch (Exception e) {
            throw new gd(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(gj gjVar) {
        if (gjVar == null) {
            return;
        }
        for (fs.a aVar : this.f446a.values()) {
            aVar.a(gjVar);
        }
    }
}
