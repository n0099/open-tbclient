package com.xiaomi.push;

import java.util.Date;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class bj implements fp {
    final /* synthetic */ bi a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bj(bi biVar) {
        this.a = biVar;
    }

    @Override // com.xiaomi.push.fp
    public void a(fm fmVar) {
        fm fmVar2;
        StringBuilder append = new StringBuilder().append("[Slim] ").append(this.a.f147a.format(new Date())).append(" Connection reconnected (");
        fmVar2 = this.a.f144a;
        com.xiaomi.channel.commonutils.logger.b.c(append.append(fmVar2.hashCode()).append(")").toString());
    }

    @Override // com.xiaomi.push.fp
    public void a(fm fmVar, int i, Exception exc) {
        fm fmVar2;
        StringBuilder append = new StringBuilder().append("[Slim] ").append(this.a.f147a.format(new Date())).append(" Connection closed (");
        fmVar2 = this.a.f144a;
        com.xiaomi.channel.commonutils.logger.b.c(append.append(fmVar2.hashCode()).append(")").toString());
    }

    @Override // com.xiaomi.push.fp
    public void a(fm fmVar, Exception exc) {
        fm fmVar2;
        StringBuilder append = new StringBuilder().append("[Slim] ").append(this.a.f147a.format(new Date())).append(" Reconnection failed due to an exception (");
        fmVar2 = this.a.f144a;
        com.xiaomi.channel.commonutils.logger.b.c(append.append(fmVar2.hashCode()).append(")").toString());
        exc.printStackTrace();
    }

    @Override // com.xiaomi.push.fp
    public void b(fm fmVar) {
        fm fmVar2;
        StringBuilder append = new StringBuilder().append("[Slim] ").append(this.a.f147a.format(new Date())).append(" Connection started (");
        fmVar2 = this.a.f144a;
        com.xiaomi.channel.commonutils.logger.b.c(append.append(fmVar2.hashCode()).append(")").toString());
    }
}
