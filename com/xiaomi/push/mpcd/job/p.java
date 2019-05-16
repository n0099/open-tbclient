package com.xiaomi.push.mpcd.job;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class p implements com.xiaomi.metoknlp.devicediscover.a {
    final /* synthetic */ o a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar) {
        this.a = oVar;
    }

    @Override // com.xiaomi.metoknlp.devicediscover.a
    public void a(String str) {
        String b;
        Object obj;
        Object obj2;
        o oVar = this.a;
        b = o.b(str);
        oVar.b = b;
        obj = this.a.a;
        synchronized (obj) {
            try {
                obj2 = this.a.a;
                obj2.notify();
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
            }
        }
    }
}
