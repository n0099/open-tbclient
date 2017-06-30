package com.xiaomi.measite.smack;

import com.xiaomi.smack.d;
import java.util.Date;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class b implements d {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.a = aVar;
    }

    @Override // com.xiaomi.smack.d
    public void a(com.xiaomi.smack.a aVar) {
        com.xiaomi.smack.a aVar2;
        StringBuilder append = new StringBuilder().append("[Slim] ").append(this.a.b.format(new Date())).append(" Connection reconnected (");
        aVar2 = this.a.c;
        com.xiaomi.channel.commonutils.logger.b.c(append.append(aVar2.hashCode()).append(")").toString());
    }

    @Override // com.xiaomi.smack.d
    public void a(com.xiaomi.smack.a aVar, int i, Exception exc) {
        com.xiaomi.smack.a aVar2;
        StringBuilder append = new StringBuilder().append("[Slim] ").append(this.a.b.format(new Date())).append(" Connection closed (");
        aVar2 = this.a.c;
        com.xiaomi.channel.commonutils.logger.b.c(append.append(aVar2.hashCode()).append(")").toString());
    }

    @Override // com.xiaomi.smack.d
    public void a(com.xiaomi.smack.a aVar, Exception exc) {
        com.xiaomi.smack.a aVar2;
        StringBuilder append = new StringBuilder().append("[Slim] ").append(this.a.b.format(new Date())).append(" Reconnection failed due to an exception (");
        aVar2 = this.a.c;
        com.xiaomi.channel.commonutils.logger.b.c(append.append(aVar2.hashCode()).append(")").toString());
        exc.printStackTrace();
    }

    @Override // com.xiaomi.smack.d
    public void b(com.xiaomi.smack.a aVar) {
        com.xiaomi.smack.a aVar2;
        StringBuilder append = new StringBuilder().append("[Slim] ").append(this.a.b.format(new Date())).append(" Connection started (");
        aVar2 = this.a.c;
        com.xiaomi.channel.commonutils.logger.b.c(append.append(aVar2.hashCode()).append(")").toString());
    }
}
