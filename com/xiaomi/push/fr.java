package com.xiaomi.push;

import android.os.SystemClock;
import android.text.TextUtils;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.xiaomi.push.dw;
import com.xiaomi.push.fv;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.bg;
/* loaded from: classes10.dex */
public class fr extends gc {
    public fm a;

    /* renamed from: a  reason: collision with other field name */
    public fn f396a;

    /* renamed from: a  reason: collision with other field name */
    public Thread f397a;

    /* renamed from: a  reason: collision with other field name */
    public byte[] f398a;

    public fr(XMPushService xMPushService, fw fwVar) {
        super(xMPushService, fwVar);
    }

    private fk a(boolean z) {
        fq fqVar = new fq();
        if (z) {
            fqVar.a("1");
        }
        byte[] m421a = fi.m421a();
        if (m421a != null) {
            dw.j jVar = new dw.j();
            jVar.a(a.a(m421a));
            fqVar.a(jVar.m386a(), (String) null);
        }
        return fqVar;
    }

    private void h() {
        try {
            this.a = new fm(((gc) this).f428a.getInputStream(), this, ((fv) this).f411a);
            this.f396a = new fn(((gc) this).f428a.getOutputStream(), this);
            fs fsVar = new fs(this, "Blob Reader (" + ((fv) this).b + SmallTailInfo.EMOTION_SUFFIX);
            this.f397a = fsVar;
            fsVar.start();
        } catch (Exception e) {
            throw new gg("Error to init reader and writer", e);
        }
    }

    /* JADX DEBUG: Possible override for method com.xiaomi.push.fv.a()Lcom/xiaomi/push/fw; */
    /* JADX DEBUG: Possible override for method com.xiaomi.push.fv.a()Ljava/lang/String; */
    /* JADX DEBUG: Possible override for method com.xiaomi.push.fv.a()Ljava/util/Map; */
    /* JADX DEBUG: Possible override for method com.xiaomi.push.fv.a()Z */
    @Override // com.xiaomi.push.gc
    /* renamed from: a */
    public synchronized void mo464a() {
        h();
        this.f396a.a();
    }

    @Override // com.xiaomi.push.gc
    public synchronized void a(int i, Exception exc) {
        if (this.a != null) {
            this.a.b();
            this.a = null;
        }
        if (this.f396a != null) {
            try {
                this.f396a.b();
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
            }
            this.f396a = null;
        }
        this.f398a = null;
        super.a(i, exc);
    }

    public void a(fk fkVar) {
        if (fkVar == null) {
            return;
        }
        if (fkVar.m425a()) {
            com.xiaomi.channel.commonutils.logger.b.m120a("[Slim] RCV blob chid=" + fkVar.a() + "; id=" + fkVar.e() + "; errCode=" + fkVar.b() + "; err=" + fkVar.m429c());
        }
        if (fkVar.a() == 0) {
            if ("PING".equals(fkVar.m422a())) {
                com.xiaomi.channel.commonutils.logger.b.m120a("[Slim] RCV ping id=" + fkVar.e());
                g();
            } else if ("CLOSE".equals(fkVar.m422a())) {
                c(13, null);
            }
        }
        for (fv.a aVar : ((fv) this).f415a.values()) {
            aVar.a(fkVar);
        }
    }

    @Override // com.xiaomi.push.fv
    @Deprecated
    public void a(gm gmVar) {
        b(fk.a(gmVar, (String) null));
    }

    @Override // com.xiaomi.push.fv
    public synchronized void a(bg.b bVar) {
        fj.a(bVar, c(), this);
    }

    @Override // com.xiaomi.push.fv
    public synchronized void a(String str, String str2) {
        fj.a(str, str2, this);
    }

    @Override // com.xiaomi.push.gc
    /* renamed from: a  reason: collision with other method in class */
    public void mo435a(boolean z) {
        if (this.f396a == null) {
            throw new gg("The BlobWriter is null.");
        }
        fk a = a(z);
        com.xiaomi.channel.commonutils.logger.b.m120a("[Slim] SND ping id=" + a.e());
        b(a);
        f();
    }

    @Override // com.xiaomi.push.gc, com.xiaomi.push.fv
    public void a(fk[] fkVarArr) {
        for (fk fkVar : fkVarArr) {
            b(fkVar);
        }
    }

    /* JADX DEBUG: Possible override for method com.xiaomi.push.gc.a()Ljava/lang/String; */
    /* JADX DEBUG: Possible override for method com.xiaomi.push.gc.a()Ljava/net/Socket; */
    /* JADX DEBUG: Possible override for method com.xiaomi.push.gc.a()V */
    @Override // com.xiaomi.push.fv
    /* renamed from: a  reason: collision with other method in class */
    public boolean mo436a() {
        return true;
    }

    /* JADX DEBUG: Possible override for method com.xiaomi.push.fv.a()I */
    /* JADX DEBUG: Possible override for method com.xiaomi.push.fv.a()J */
    /* JADX DEBUG: Possible override for method com.xiaomi.push.fv.a()Lcom/xiaomi/push/fw; */
    /* JADX DEBUG: Possible override for method com.xiaomi.push.fv.a()Ljava/lang/String; */
    /* JADX DEBUG: Possible override for method com.xiaomi.push.fv.a()Ljava/util/Map; */
    /* JADX DEBUG: Possible override for method com.xiaomi.push.fv.a()Z */
    /* JADX DEBUG: Possible override for method com.xiaomi.push.gc.a()Ljava/lang/String; */
    /* JADX DEBUG: Possible override for method com.xiaomi.push.gc.a()Ljava/net/Socket; */
    /* JADX DEBUG: Possible override for method com.xiaomi.push.gc.a()V */
    /* renamed from: a  reason: collision with other method in class */
    public synchronized byte[] m437a() {
        if (this.f398a == null && !TextUtils.isEmpty(((fv) this).f412a)) {
            String m744a = com.xiaomi.push.service.bv.m744a();
            this.f398a = com.xiaomi.push.service.bp.a(((fv) this).f412a.getBytes(), (((fv) this).f412a.substring(((fv) this).f412a.length() / 2) + m744a.substring(m744a.length() / 2)).getBytes());
        }
        return this.f398a;
    }

    @Override // com.xiaomi.push.fv
    public void b(fk fkVar) {
        fn fnVar = this.f396a;
        if (fnVar == null) {
            throw new gg("the writer is null.");
        }
        try {
            int a = fnVar.a(fkVar);
            ((fv) this).d = SystemClock.elapsedRealtime();
            String f = fkVar.f();
            if (!TextUtils.isEmpty(f)) {
                ha.a(((fv) this).f411a, f, a, false, true, System.currentTimeMillis());
            }
            for (fv.a aVar : ((fv) this).f418b.values()) {
                aVar.a(fkVar);
            }
        } catch (Exception e) {
            throw new gg(e);
        }
    }

    public void b(gm gmVar) {
        if (gmVar == null) {
            return;
        }
        for (fv.a aVar : ((fv) this).f415a.values()) {
            aVar.a(gmVar);
        }
    }
}
