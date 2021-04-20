package com.xiaomi.push;

import android.text.TextUtils;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.xiaomi.push.du;
import com.xiaomi.push.fl;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.av;
/* loaded from: classes7.dex */
public class fh extends fs {

    /* renamed from: a  reason: collision with root package name */
    public fc f40791a;

    /* renamed from: a  reason: collision with other field name */
    public fd f378a;

    /* renamed from: a  reason: collision with other field name */
    public Thread f379a;

    /* renamed from: a  reason: collision with other field name */
    public byte[] f380a;

    public fh(XMPushService xMPushService, fm fmVar) {
        super(xMPushService, fmVar);
    }

    private fa a(boolean z) {
        fg fgVar = new fg();
        if (z) {
            fgVar.a("1");
        }
        byte[] m354a = gz.m354a();
        if (m354a != null) {
            du.j jVar = new du.j();
            jVar.a(a.a(m354a));
            fgVar.a(jVar.m266a(), (String) null);
        }
        return fgVar;
    }

    private void h() {
        try {
            this.f40791a = new fc(((fs) this).f408a.getInputStream(), this);
            this.f378a = new fd(((fs) this).f408a.getOutputStream(), this);
            fi fiVar = new fi(this, "Blob Reader (" + ((fl) this).f40798b + SmallTailInfo.EMOTION_SUFFIX);
            this.f379a = fiVar;
            fiVar.start();
        } catch (Exception e2) {
            throw new fw("Error to init reader and writer", e2);
        }
    }

    @Override // com.xiaomi.push.fs, com.xiaomi.push.fl
    public synchronized void a() {
        h();
        this.f378a.a();
    }

    @Override // com.xiaomi.push.fs
    public synchronized void a(int i, Exception exc) {
        if (this.f40791a != null) {
            this.f40791a.b();
            this.f40791a = null;
        }
        if (this.f378a != null) {
            try {
                this.f378a.b();
            } catch (Exception e2) {
                com.xiaomi.channel.commonutils.logger.b.a(e2);
            }
            this.f378a = null;
        }
        this.f380a = null;
        super.a(i, exc);
    }

    public void a(fa faVar) {
        if (faVar == null) {
            return;
        }
        if (faVar.m290a()) {
            com.xiaomi.channel.commonutils.logger.b.m55a("[Slim] RCV blob chid=" + faVar.a() + "; id=" + faVar.e() + "; errCode=" + faVar.b() + "; err=" + faVar.m294c());
        }
        if (faVar.a() == 0) {
            if ("PING".equals(faVar.m287a())) {
                com.xiaomi.channel.commonutils.logger.b.m55a("[Slim] RCV ping id=" + faVar.e());
                g();
            } else if ("CLOSE".equals(faVar.m287a())) {
                c(13, null);
            }
        }
        for (fl.a aVar : ((fl) this).f397a.values()) {
            aVar.a(faVar);
        }
    }

    @Override // com.xiaomi.push.fl
    @Deprecated
    public void a(gc gcVar) {
        b(fa.a(gcVar, (String) null));
    }

    @Override // com.xiaomi.push.fl
    public synchronized void a(av.b bVar) {
        ez.a(bVar, c(), this);
    }

    @Override // com.xiaomi.push.fl
    public synchronized void a(String str, String str2) {
        ez.a(str, str2, this);
    }

    @Override // com.xiaomi.push.fs
    /* renamed from: a  reason: collision with other method in class */
    public void mo300a(boolean z) {
        if (this.f378a == null) {
            throw new fw("The BlobWriter is null.");
        }
        fa a2 = a(z);
        com.xiaomi.channel.commonutils.logger.b.m55a("[Slim] SND ping id=" + a2.e());
        b(a2);
        f();
    }

    @Override // com.xiaomi.push.fs, com.xiaomi.push.fl
    public void a(fa[] faVarArr) {
        for (fa faVar : faVarArr) {
            b(faVar);
        }
    }

    @Override // com.xiaomi.push.fs, com.xiaomi.push.fl
    public boolean a() {
        return true;
    }

    @Override // com.xiaomi.push.fs, com.xiaomi.push.fl
    public synchronized byte[] a() {
        if (this.f380a == null && !TextUtils.isEmpty(((fl) this).f394a)) {
            String m597a = com.xiaomi.push.service.bi.m597a();
            this.f380a = com.xiaomi.push.service.be.a(((fl) this).f394a.getBytes(), (((fl) this).f394a.substring(((fl) this).f394a.length() / 2) + m597a.substring(m597a.length() / 2)).getBytes());
        }
        return this.f380a;
    }

    @Override // com.xiaomi.push.fl
    public void b(fa faVar) {
        fd fdVar = this.f378a;
        if (fdVar == null) {
            throw new fw("the writer is null.");
        }
        try {
            int a2 = fdVar.a(faVar);
            ((fl) this).f40800d = System.currentTimeMillis();
            String f2 = faVar.f();
            if (!TextUtils.isEmpty(f2)) {
                gq.a(((fl) this).f393a, f2, a2, false, true, System.currentTimeMillis());
            }
            for (fl.a aVar : ((fl) this).f400b.values()) {
                aVar.a(faVar);
            }
        } catch (Exception e2) {
            throw new fw(e2);
        }
    }

    public void b(gc gcVar) {
        if (gcVar == null) {
            return;
        }
        for (fl.a aVar : ((fl) this).f397a.values()) {
            aVar.a(gcVar);
        }
    }
}
