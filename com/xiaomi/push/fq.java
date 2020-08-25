package com.xiaomi.push;

import android.text.TextUtils;
import com.xiaomi.push.ek;
import com.xiaomi.push.fs;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.ap;
/* loaded from: classes7.dex */
public class fq extends fz {
    private fm a;

    /* renamed from: a  reason: collision with other field name */
    private fn f357a;

    /* renamed from: a  reason: collision with other field name */
    private Thread f358a;

    /* renamed from: a  reason: collision with other field name */
    private byte[] f359a;

    public fq(XMPushService xMPushService, ft ftVar) {
        super(xMPushService, ftVar);
    }

    private fl a(boolean z) {
        fp fpVar = new fp();
        if (z) {
            fpVar.a("1");
        }
        byte[] m340a = hg.m340a();
        if (m340a != null) {
            ek.j jVar = new ek.j();
            jVar.a(a.a(m340a));
            fpVar.a(jVar.a(), (String) null);
        }
        return fpVar;
    }

    private void h() {
        try {
            this.a = new fm(this.f380a.getInputStream(), this);
            this.f357a = new fn(this.f380a.getOutputStream(), this);
            this.f358a = new fr(this, "Blob Reader (" + this.b + ")");
            this.f358a.start();
        } catch (Exception e) {
            throw new gd("Error to init reader and writer", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaomi.push.fz, com.xiaomi.push.fs
    public synchronized void a() {
        h();
        this.f357a.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaomi.push.fz
    public synchronized void a(int i, Exception exc) {
        if (this.a != null) {
            this.a.b();
            this.a = null;
        }
        if (this.f357a != null) {
            try {
                this.f357a.b();
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
            }
            this.f357a = null;
        }
        this.f359a = null;
        super.a(i, exc);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(fl flVar) {
        if (flVar == null) {
            return;
        }
        if (flVar.m283a()) {
            com.xiaomi.channel.commonutils.logger.b.m54a("[Slim] RCV blob chid=" + flVar.a() + "; id=" + flVar.e() + "; errCode=" + flVar.b() + "; err=" + flVar.m287c());
        }
        if (flVar.a() == 0) {
            if ("PING".equals(flVar.m280a())) {
                com.xiaomi.channel.commonutils.logger.b.m54a("[Slim] RCV ping id=" + flVar.e());
                g();
            } else if ("CLOSE".equals(flVar.m280a())) {
                c(13, null);
            }
        }
        for (fs.a aVar : this.f369a.values()) {
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
    protected void mo290a(boolean z) {
        if (this.f357a == null) {
            throw new gd("The BlobWriter is null.");
        }
        fl a = a(z);
        com.xiaomi.channel.commonutils.logger.b.m54a("[Slim] SND ping id=" + a.e());
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
        if (this.f359a == null && !TextUtils.isEmpty(this.f366a)) {
            String m559a = com.xiaomi.push.service.be.m559a();
            this.f359a = com.xiaomi.push.service.ay.a(this.f366a.getBytes(), (this.f366a.substring(this.f366a.length() / 2) + m559a.substring(m559a.length() / 2)).getBytes());
        }
        return this.f359a;
    }

    @Override // com.xiaomi.push.fs
    public void b(fl flVar) {
        if (this.f357a == null) {
            throw new gd("the writer is null.");
        }
        try {
            int a = this.f357a.a(flVar);
            this.d = System.currentTimeMillis();
            String f = flVar.f();
            if (!TextUtils.isEmpty(f)) {
                gx.a(this.f365a, f, a, false, true, System.currentTimeMillis());
            }
            for (fs.a aVar : this.f372b.values()) {
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
        for (fs.a aVar : this.f369a.values()) {
            aVar.a(gjVar);
        }
    }
}
