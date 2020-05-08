package com.xiaomi.push;

import android.text.TextUtils;
import com.xiaomi.push.ek;
import com.xiaomi.push.fs;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.ap;
/* loaded from: classes8.dex */
public class fq extends fz {
    private fm a;

    /* renamed from: a  reason: collision with other field name */
    private fn f354a;

    /* renamed from: a  reason: collision with other field name */
    private Thread f355a;

    /* renamed from: a  reason: collision with other field name */
    private byte[] f356a;

    public fq(XMPushService xMPushService, ft ftVar) {
        super(xMPushService, ftVar);
    }

    private fl a(boolean z) {
        fp fpVar = new fp();
        if (z) {
            fpVar.a("1");
        }
        byte[] m336a = hg.m336a();
        if (m336a != null) {
            ek.j jVar = new ek.j();
            jVar.a(a.a(m336a));
            fpVar.a(jVar.a(), (String) null);
        }
        return fpVar;
    }

    private void h() {
        try {
            this.a = new fm(this.f377a.getInputStream(), this);
            this.f354a = new fn(this.f377a.getOutputStream(), this);
            this.f355a = new fr(this, "Blob Reader (" + this.b + ")");
            this.f355a.start();
        } catch (Exception e) {
            throw new gd("Error to init reader and writer", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaomi.push.fz, com.xiaomi.push.fs
    public synchronized void a() {
        h();
        this.f354a.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaomi.push.fz
    public synchronized void a(int i, Exception exc) {
        if (this.a != null) {
            this.a.b();
            this.a = null;
        }
        if (this.f354a != null) {
            try {
                this.f354a.b();
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
            }
            this.f354a = null;
        }
        this.f356a = null;
        super.a(i, exc);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(fl flVar) {
        if (flVar == null) {
            return;
        }
        if (flVar.m279a()) {
            com.xiaomi.channel.commonutils.logger.b.m50a("[Slim] RCV blob chid=" + flVar.a() + "; id=" + flVar.e() + "; errCode=" + flVar.b() + "; err=" + flVar.m283c());
        }
        if (flVar.a() == 0) {
            if ("PING".equals(flVar.m276a())) {
                com.xiaomi.channel.commonutils.logger.b.m50a("[Slim] RCV ping id=" + flVar.e());
                g();
            } else if ("CLOSE".equals(flVar.m276a())) {
                c(13, null);
            }
        }
        for (fs.a aVar : this.f366a.values()) {
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
    protected void mo286a(boolean z) {
        if (this.f354a == null) {
            throw new gd("The BlobWriter is null.");
        }
        fl a = a(z);
        com.xiaomi.channel.commonutils.logger.b.m50a("[Slim] SND ping id=" + a.e());
        b(a);
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
        if (this.f356a == null && !TextUtils.isEmpty(this.f363a)) {
            String m555a = com.xiaomi.push.service.be.m555a();
            this.f356a = com.xiaomi.push.service.ay.a(this.f363a.getBytes(), (this.f363a.substring(this.f363a.length() / 2) + m555a.substring(m555a.length() / 2)).getBytes());
        }
        return this.f356a;
    }

    @Override // com.xiaomi.push.fs
    public void b(fl flVar) {
        if (this.f354a == null) {
            throw new gd("the writer is null.");
        }
        try {
            int a = this.f354a.a(flVar);
            this.d = System.currentTimeMillis();
            String f = flVar.f();
            if (!TextUtils.isEmpty(f)) {
                gx.a(this.f362a, f, a, false, true, System.currentTimeMillis());
            }
            for (fs.a aVar : this.f369b.values()) {
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
        for (fs.a aVar : this.f366a.values()) {
            aVar.a(gjVar);
        }
    }
}
