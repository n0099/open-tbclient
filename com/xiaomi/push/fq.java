package com.xiaomi.push;

import android.text.TextUtils;
import com.xiaomi.push.ek;
import com.xiaomi.push.fs;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.ap;
/* loaded from: classes5.dex */
public class fq extends fz {

    /* renamed from: a  reason: collision with root package name */
    private fm f8372a;

    /* renamed from: a  reason: collision with other field name */
    private fn f355a;

    /* renamed from: a  reason: collision with other field name */
    private Thread f356a;

    /* renamed from: a  reason: collision with other field name */
    private byte[] f357a;

    public fq(XMPushService xMPushService, ft ftVar) {
        super(xMPushService, ftVar);
    }

    private fl a(boolean z) {
        fp fpVar = new fp();
        if (z) {
            fpVar.a("1");
        }
        byte[] m344a = hg.m344a();
        if (m344a != null) {
            ek.j jVar = new ek.j();
            jVar.a(a.a(m344a));
            fpVar.a(jVar.a(), (String) null);
        }
        return fpVar;
    }

    private void h() {
        try {
            this.f8372a = new fm(this.f378a.getInputStream(), this);
            this.f355a = new fn(this.f378a.getOutputStream(), this);
            this.f356a = new fr(this, "Blob Reader (" + this.b + ")");
            this.f356a.start();
        } catch (Exception e) {
            throw new gd("Error to init reader and writer", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaomi.push.fz, com.xiaomi.push.fs
    public synchronized void a() {
        h();
        this.f355a.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaomi.push.fz
    public synchronized void a(int i, Exception exc) {
        if (this.f8372a != null) {
            this.f8372a.b();
            this.f8372a = null;
        }
        if (this.f355a != null) {
            try {
                this.f355a.b();
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
            }
            this.f355a = null;
        }
        this.f357a = null;
        super.a(i, exc);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(fl flVar) {
        if (flVar == null) {
            return;
        }
        if (flVar.m287a()) {
            com.xiaomi.channel.commonutils.logger.b.m58a("[Slim] RCV blob chid=" + flVar.a() + "; id=" + flVar.e() + "; errCode=" + flVar.b() + "; err=" + flVar.m291c());
        }
        if (flVar.a() == 0) {
            if ("PING".equals(flVar.m284a())) {
                com.xiaomi.channel.commonutils.logger.b.m58a("[Slim] RCV ping id=" + flVar.e());
                g();
            } else if ("CLOSE".equals(flVar.m284a())) {
                c(13, null);
            }
        }
        for (fs.a aVar : this.f367a.values()) {
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
    protected void mo294a(boolean z) {
        if (this.f355a == null) {
            throw new gd("The BlobWriter is null.");
        }
        fl a2 = a(z);
        com.xiaomi.channel.commonutils.logger.b.m58a("[Slim] SND ping id=" + a2.e());
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
        if (this.f357a == null && !TextUtils.isEmpty(this.f364a)) {
            String m563a = com.xiaomi.push.service.be.m563a();
            this.f357a = com.xiaomi.push.service.ay.a(this.f364a.getBytes(), (this.f364a.substring(this.f364a.length() / 2) + m563a.substring(m563a.length() / 2)).getBytes());
        }
        return this.f357a;
    }

    @Override // com.xiaomi.push.fs
    public void b(fl flVar) {
        if (this.f355a == null) {
            throw new gd("the writer is null.");
        }
        try {
            int a2 = this.f355a.a(flVar);
            this.d = System.currentTimeMillis();
            String f = flVar.f();
            if (!TextUtils.isEmpty(f)) {
                gx.a(this.f363a, f, a2, false, true, System.currentTimeMillis());
            }
            for (fs.a aVar : this.f370b.values()) {
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
        for (fs.a aVar : this.f367a.values()) {
            aVar.a(gjVar);
        }
    }
}
