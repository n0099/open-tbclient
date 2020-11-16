package com.xiaomi.push;

import android.text.TextUtils;
import com.xiaomi.push.ek;
import com.xiaomi.push.fs;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.ap;
/* loaded from: classes18.dex */
public class fq extends fz {

    /* renamed from: a  reason: collision with root package name */
    private fm f4909a;

    /* renamed from: a  reason: collision with other field name */
    private fn f358a;

    /* renamed from: a  reason: collision with other field name */
    private Thread f359a;

    /* renamed from: a  reason: collision with other field name */
    private byte[] f360a;

    public fq(XMPushService xMPushService, ft ftVar) {
        super(xMPushService, ftVar);
    }

    private fl a(boolean z) {
        fp fpVar = new fp();
        if (z) {
            fpVar.a("1");
        }
        byte[] m343a = hg.m343a();
        if (m343a != null) {
            ek.j jVar = new ek.j();
            jVar.a(a.a(m343a));
            fpVar.a(jVar.a(), (String) null);
        }
        return fpVar;
    }

    private void h() {
        try {
            this.f4909a = new fm(this.f381a.getInputStream(), this);
            this.f358a = new fn(this.f381a.getOutputStream(), this);
            this.f359a = new fr(this, "Blob Reader (" + this.b + ")");
            this.f359a.start();
        } catch (Exception e) {
            throw new gd("Error to init reader and writer", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaomi.push.fz, com.xiaomi.push.fs
    public synchronized void a() {
        h();
        this.f358a.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaomi.push.fz
    public synchronized void a(int i, Exception exc) {
        if (this.f4909a != null) {
            this.f4909a.b();
            this.f4909a = null;
        }
        if (this.f358a != null) {
            try {
                this.f358a.b();
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
            }
            this.f358a = null;
        }
        this.f360a = null;
        super.a(i, exc);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(fl flVar) {
        if (flVar == null) {
            return;
        }
        if (flVar.m286a()) {
            com.xiaomi.channel.commonutils.logger.b.m57a("[Slim] RCV blob chid=" + flVar.a() + "; id=" + flVar.e() + "; errCode=" + flVar.b() + "; err=" + flVar.m290c());
        }
        if (flVar.a() == 0) {
            if ("PING".equals(flVar.m283a())) {
                com.xiaomi.channel.commonutils.logger.b.m57a("[Slim] RCV ping id=" + flVar.e());
                g();
            } else if ("CLOSE".equals(flVar.m283a())) {
                c(13, null);
            }
        }
        for (fs.a aVar : this.f370a.values()) {
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
    protected void mo293a(boolean z) {
        if (this.f358a == null) {
            throw new gd("The BlobWriter is null.");
        }
        fl a2 = a(z);
        com.xiaomi.channel.commonutils.logger.b.m57a("[Slim] SND ping id=" + a2.e());
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
        if (this.f360a == null && !TextUtils.isEmpty(this.f367a)) {
            String m562a = com.xiaomi.push.service.be.m562a();
            this.f360a = com.xiaomi.push.service.ay.a(this.f367a.getBytes(), (this.f367a.substring(this.f367a.length() / 2) + m562a.substring(m562a.length() / 2)).getBytes());
        }
        return this.f360a;
    }

    @Override // com.xiaomi.push.fs
    public void b(fl flVar) {
        if (this.f358a == null) {
            throw new gd("the writer is null.");
        }
        try {
            int a2 = this.f358a.a(flVar);
            this.d = System.currentTimeMillis();
            String f = flVar.f();
            if (!TextUtils.isEmpty(f)) {
                gx.a(this.f366a, f, a2, false, true, System.currentTimeMillis());
            }
            for (fs.a aVar : this.f373b.values()) {
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
        for (fs.a aVar : this.f370a.values()) {
            aVar.a(gjVar);
        }
    }
}
