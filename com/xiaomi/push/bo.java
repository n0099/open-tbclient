package com.xiaomi.push;

import java.util.Date;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes12.dex */
public class bo implements fv {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bn f4818a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bo(bn bnVar) {
        this.f4818a = bnVar;
    }

    @Override // com.xiaomi.push.fv
    public void a(fs fsVar) {
        fs fsVar2;
        StringBuilder append = new StringBuilder().append("[Slim] ").append(this.f4818a.f132a.format(new Date())).append(" Connection reconnected (");
        fsVar2 = this.f4818a.f129a;
        com.xiaomi.channel.commonutils.logger.b.c(append.append(fsVar2.hashCode()).append(")").toString());
    }

    @Override // com.xiaomi.push.fv
    public void a(fs fsVar, int i, Exception exc) {
        fs fsVar2;
        StringBuilder append = new StringBuilder().append("[Slim] ").append(this.f4818a.f132a.format(new Date())).append(" Connection closed (");
        fsVar2 = this.f4818a.f129a;
        com.xiaomi.channel.commonutils.logger.b.c(append.append(fsVar2.hashCode()).append(")").toString());
    }

    @Override // com.xiaomi.push.fv
    public void a(fs fsVar, Exception exc) {
        fs fsVar2;
        StringBuilder append = new StringBuilder().append("[Slim] ").append(this.f4818a.f132a.format(new Date())).append(" Reconnection failed due to an exception (");
        fsVar2 = this.f4818a.f129a;
        com.xiaomi.channel.commonutils.logger.b.c(append.append(fsVar2.hashCode()).append(")").toString());
        exc.printStackTrace();
    }

    @Override // com.xiaomi.push.fv
    public void b(fs fsVar) {
        fs fsVar2;
        StringBuilder append = new StringBuilder().append("[Slim] ").append(this.f4818a.f132a.format(new Date())).append(" Connection started (");
        fsVar2 = this.f4818a.f129a;
        com.xiaomi.channel.commonutils.logger.b.c(append.append(fsVar2.hashCode()).append(")").toString());
    }
}
