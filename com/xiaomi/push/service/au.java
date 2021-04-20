package com.xiaomi.push.service;

import android.text.TextUtils;
import com.baidu.wallet.paysdk.banksign.datamodel.QueryResponse;
import com.xiaomi.push.co;
import com.xiaomi.push.cs;
import com.xiaomi.push.db;
import com.xiaomi.push.du;
import com.xiaomi.push.ew;
import com.xiaomi.push.fa;
import com.xiaomi.push.fm;
import com.xiaomi.push.fz;
import com.xiaomi.push.ga;
import com.xiaomi.push.gb;
import com.xiaomi.push.gc;
import com.xiaomi.push.gq;
import com.xiaomi.push.gz;
import com.xiaomi.push.service.av;
import java.util.Date;
/* loaded from: classes7.dex */
public class au {

    /* renamed from: a  reason: collision with root package name */
    public XMPushService f41248a;

    public au(XMPushService xMPushService) {
        this.f41248a = xMPushService;
    }

    private void a(fz fzVar) {
        String c2 = fzVar.c();
        if (TextUtils.isEmpty(c2)) {
            return;
        }
        String[] split = c2.split(";");
        co a2 = cs.a().a(fm.a(), false);
        if (a2 == null || split.length <= 0) {
            return;
        }
        a2.a(split);
        this.f41248a.a(20, (Exception) null);
        this.f41248a.a(true);
    }

    private void b(gc gcVar) {
        av.b a2;
        String l = gcVar.l();
        String k = gcVar.k();
        if (TextUtils.isEmpty(l) || TextUtils.isEmpty(k) || (a2 = av.a().a(k, l)) == null) {
            return;
        }
        gq.a(this.f41248a, a2.f908a, gq.a(gcVar.m330a()), true, true, System.currentTimeMillis());
    }

    private void c(fa faVar) {
        av.b a2;
        String g2 = faVar.g();
        String num = Integer.toString(faVar.a());
        if (TextUtils.isEmpty(g2) || TextUtils.isEmpty(num) || (a2 = av.a().a(num, g2)) == null) {
            return;
        }
        gq.a(this.f41248a, a2.f908a, faVar.c(), true, true, System.currentTimeMillis());
    }

    public void a(fa faVar) {
        if (5 != faVar.a()) {
            c(faVar);
        }
        try {
            b(faVar);
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.a("handle Blob chid = " + faVar.a() + " cmd = " + faVar.m287a() + " packetid = " + faVar.e() + " failure ", e2);
        }
    }

    public void a(gc gcVar) {
        if (!"5".equals(gcVar.k())) {
            b(gcVar);
        }
        String k = gcVar.k();
        if (TextUtils.isEmpty(k)) {
            k = "1";
            gcVar.l("1");
        }
        if (k.equals("0")) {
            com.xiaomi.channel.commonutils.logger.b.m55a("Received wrong packet with chid = 0 : " + gcVar.m330a());
        }
        if (gcVar instanceof ga) {
            fz a2 = gcVar.a("kick");
            if (a2 != null) {
                String l = gcVar.l();
                String a3 = a2.a("type");
                String a4 = a2.a("reason");
                com.xiaomi.channel.commonutils.logger.b.m55a("kicked by server, chid=" + k + " res=" + av.b.a(l) + " type=" + a3 + " reason=" + a4);
                if (!"wait".equals(a3)) {
                    this.f41248a.a(k, l, 3, a4, a3);
                    av.a().m590a(k, l);
                    return;
                }
                av.b a5 = av.a().a(k, l);
                if (a5 != null) {
                    this.f41248a.a(a5);
                    a5.a(av.c.unbind, 3, 0, a4, a3);
                    return;
                }
                return;
            }
        } else if (gcVar instanceof gb) {
            gb gbVar = (gb) gcVar;
            if ("redir".equals(gbVar.b())) {
                fz a6 = gbVar.a("hosts");
                if (a6 != null) {
                    a(a6);
                    return;
                }
                return;
            }
        }
        this.f41248a.b().a(this.f41248a, k, gcVar);
    }

    public void b(fa faVar) {
        StringBuilder sb;
        String a2;
        String str;
        av.c cVar;
        int i;
        int i2;
        String m287a = faVar.m287a();
        if (faVar.a() != 0) {
            String num = Integer.toString(faVar.a());
            if (!"SECMSG".equals(faVar.m287a())) {
                if (!"BIND".equals(m287a)) {
                    if ("KICK".equals(m287a)) {
                        du.g a3 = du.g.a(faVar.m291a());
                        String g2 = faVar.g();
                        String a4 = a3.a();
                        String b2 = a3.b();
                        com.xiaomi.channel.commonutils.logger.b.m55a("kicked by server, chid=" + num + " res= " + av.b.a(g2) + " type=" + a4 + " reason=" + b2);
                        if (!"wait".equals(a4)) {
                            this.f41248a.a(num, g2, 3, b2, a4);
                            av.a().m590a(num, g2);
                            return;
                        }
                        av.b a5 = av.a().a(num, g2);
                        if (a5 != null) {
                            this.f41248a.a(a5);
                            a5.a(av.c.unbind, 3, 0, b2, a4);
                            return;
                        }
                        return;
                    }
                    return;
                }
                du.d a6 = du.d.a(faVar.m291a());
                String g3 = faVar.g();
                av.b a7 = av.a().a(num, g3);
                if (a7 == null) {
                    return;
                }
                if (a6.a()) {
                    com.xiaomi.channel.commonutils.logger.b.m55a("SMACK: channel bind succeeded, chid=" + faVar.a());
                    a7.a(av.c.binded, 1, 0, (String) null, (String) null);
                    return;
                }
                String a8 = a6.a();
                if ("auth".equals(a8)) {
                    if ("invalid-sig".equals(a6.b())) {
                        com.xiaomi.channel.commonutils.logger.b.m55a("SMACK: bind error invalid-sig token = " + a7.f41252c + " sec = " + a7.f41257h);
                        gz.a(0, ew.BIND_INVALID_SIG.a(), 1, null, 0);
                    }
                    cVar = av.c.unbind;
                    i = 1;
                    i2 = 5;
                } else if (!QueryResponse.Options.CANCEL.equals(a8)) {
                    if ("wait".equals(a8)) {
                        this.f41248a.a(a7);
                        a7.a(av.c.unbind, 1, 7, a6.b(), a8);
                    }
                    str = "SMACK: channel bind failed, chid=" + num + " reason=" + a6.b();
                    com.xiaomi.channel.commonutils.logger.b.m55a(str);
                } else {
                    cVar = av.c.unbind;
                    i = 1;
                    i2 = 7;
                }
                a7.a(cVar, i, i2, a6.b(), a8);
                av.a().m590a(num, g3);
                str = "SMACK: channel bind failed, chid=" + num + " reason=" + a6.b();
                com.xiaomi.channel.commonutils.logger.b.m55a(str);
            } else if (!faVar.m290a()) {
                this.f41248a.b().a(this.f41248a, num, faVar);
                return;
            } else {
                sb = new StringBuilder();
                sb.append("Recv SECMSG errCode = ");
                sb.append(faVar.b());
                sb.append(" errStr = ");
                a2 = faVar.m294c();
            }
        } else if ("PING".equals(m287a)) {
            byte[] m291a = faVar.m291a();
            if (m291a != null && m291a.length > 0) {
                du.j a9 = du.j.a(m291a);
                if (a9.b()) {
                    bi.a().a(a9.a());
                }
            }
            if (!"com.xiaomi.xmsf".equals(this.f41248a.getPackageName())) {
                this.f41248a.m547a();
            }
            if ("1".equals(faVar.e())) {
                com.xiaomi.channel.commonutils.logger.b.m55a("received a server ping");
            } else {
                gz.b();
            }
            this.f41248a.m550b();
            return;
        } else if ("SYNC".equals(m287a)) {
            if ("CONF".equals(faVar.m293b())) {
                bi.a().a(du.b.a(faVar.m291a()));
                return;
            } else if (TextUtils.equals("U", faVar.m293b())) {
                du.k a10 = du.k.a(faVar.m291a());
                db.a(this.f41248a).a(a10.a(), a10.b(), new Date(a10.a()), new Date(a10.b()), a10.c() * 1024, a10.e());
                fa faVar2 = new fa();
                faVar2.a(0);
                faVar2.a(faVar.m287a(), "UCA");
                faVar2.a(faVar.e());
                XMPushService xMPushService = this.f41248a;
                xMPushService.a(new bg(xMPushService, faVar2));
                return;
            } else if (!TextUtils.equals("P", faVar.m293b())) {
                return;
            } else {
                du.i a11 = du.i.a(faVar.m291a());
                fa faVar3 = new fa();
                faVar3.a(0);
                faVar3.a(faVar.m287a(), "PCA");
                faVar3.a(faVar.e());
                du.i iVar = new du.i();
                if (a11.a()) {
                    iVar.a(a11.a());
                }
                faVar3.a(iVar.m266a(), (String) null);
                XMPushService xMPushService2 = this.f41248a;
                xMPushService2.a(new bg(xMPushService2, faVar3));
                sb = new StringBuilder();
                sb.append("ACK msgP: id = ");
                a2 = faVar.e();
            }
        } else if (!"NOTIFY".equals(faVar.m287a())) {
            return;
        } else {
            du.h a12 = du.h.a(faVar.m291a());
            sb = new StringBuilder();
            sb.append("notify by server err = ");
            sb.append(a12.c());
            sb.append(" desc = ");
            a2 = a12.a();
        }
        sb.append(a2);
        str = sb.toString();
        com.xiaomi.channel.commonutils.logger.b.m55a(str);
    }
}
