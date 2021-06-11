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
    public XMPushService f41740a;

    public au(XMPushService xMPushService) {
        this.f41740a = xMPushService;
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
        this.f41740a.a(20, (Exception) null);
        this.f41740a.a(true);
    }

    private void b(gc gcVar) {
        av.b a2;
        String l = gcVar.l();
        String k = gcVar.k();
        if (TextUtils.isEmpty(l) || TextUtils.isEmpty(k) || (a2 = av.a().a(k, l)) == null) {
            return;
        }
        gq.a(this.f41740a, a2.f908a, gq.a(gcVar.m331a()), true, true, System.currentTimeMillis());
    }

    private void c(fa faVar) {
        av.b a2;
        String g2 = faVar.g();
        String num = Integer.toString(faVar.a());
        if (TextUtils.isEmpty(g2) || TextUtils.isEmpty(num) || (a2 = av.a().a(num, g2)) == null) {
            return;
        }
        gq.a(this.f41740a, a2.f908a, faVar.c(), true, true, System.currentTimeMillis());
    }

    public void a(fa faVar) {
        if (5 != faVar.a()) {
            c(faVar);
        }
        try {
            b(faVar);
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.a("handle Blob chid = " + faVar.a() + " cmd = " + faVar.m288a() + " packetid = " + faVar.e() + " failure ", e2);
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
            com.xiaomi.channel.commonutils.logger.b.m56a("Received wrong packet with chid = 0 : " + gcVar.m331a());
        }
        if (gcVar instanceof ga) {
            fz a2 = gcVar.a("kick");
            if (a2 != null) {
                String l = gcVar.l();
                String a3 = a2.a("type");
                String a4 = a2.a("reason");
                com.xiaomi.channel.commonutils.logger.b.m56a("kicked by server, chid=" + k + " res=" + av.b.a(l) + " type=" + a3 + " reason=" + a4);
                if (!"wait".equals(a3)) {
                    this.f41740a.a(k, l, 3, a4, a3);
                    av.a().m591a(k, l);
                    return;
                }
                av.b a5 = av.a().a(k, l);
                if (a5 != null) {
                    this.f41740a.a(a5);
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
        this.f41740a.b().a(this.f41740a, k, gcVar);
    }

    public void b(fa faVar) {
        StringBuilder sb;
        String a2;
        String str;
        av.c cVar;
        int i2;
        int i3;
        String m288a = faVar.m288a();
        if (faVar.a() != 0) {
            String num = Integer.toString(faVar.a());
            if (!"SECMSG".equals(faVar.m288a())) {
                if (!"BIND".equals(m288a)) {
                    if ("KICK".equals(m288a)) {
                        du.g a3 = du.g.a(faVar.m292a());
                        String g2 = faVar.g();
                        String a4 = a3.a();
                        String b2 = a3.b();
                        com.xiaomi.channel.commonutils.logger.b.m56a("kicked by server, chid=" + num + " res= " + av.b.a(g2) + " type=" + a4 + " reason=" + b2);
                        if (!"wait".equals(a4)) {
                            this.f41740a.a(num, g2, 3, b2, a4);
                            av.a().m591a(num, g2);
                            return;
                        }
                        av.b a5 = av.a().a(num, g2);
                        if (a5 != null) {
                            this.f41740a.a(a5);
                            a5.a(av.c.unbind, 3, 0, b2, a4);
                            return;
                        }
                        return;
                    }
                    return;
                }
                du.d a6 = du.d.a(faVar.m292a());
                String g3 = faVar.g();
                av.b a7 = av.a().a(num, g3);
                if (a7 == null) {
                    return;
                }
                if (a6.a()) {
                    com.xiaomi.channel.commonutils.logger.b.m56a("SMACK: channel bind succeeded, chid=" + faVar.a());
                    a7.a(av.c.binded, 1, 0, (String) null, (String) null);
                    return;
                }
                String a8 = a6.a();
                if ("auth".equals(a8)) {
                    if ("invalid-sig".equals(a6.b())) {
                        com.xiaomi.channel.commonutils.logger.b.m56a("SMACK: bind error invalid-sig token = " + a7.f41744c + " sec = " + a7.f41749h);
                        gz.a(0, ew.BIND_INVALID_SIG.a(), 1, null, 0);
                    }
                    cVar = av.c.unbind;
                    i2 = 1;
                    i3 = 5;
                } else if (!QueryResponse.Options.CANCEL.equals(a8)) {
                    if ("wait".equals(a8)) {
                        this.f41740a.a(a7);
                        a7.a(av.c.unbind, 1, 7, a6.b(), a8);
                    }
                    str = "SMACK: channel bind failed, chid=" + num + " reason=" + a6.b();
                    com.xiaomi.channel.commonutils.logger.b.m56a(str);
                } else {
                    cVar = av.c.unbind;
                    i2 = 1;
                    i3 = 7;
                }
                a7.a(cVar, i2, i3, a6.b(), a8);
                av.a().m591a(num, g3);
                str = "SMACK: channel bind failed, chid=" + num + " reason=" + a6.b();
                com.xiaomi.channel.commonutils.logger.b.m56a(str);
            } else if (!faVar.m291a()) {
                this.f41740a.b().a(this.f41740a, num, faVar);
                return;
            } else {
                sb = new StringBuilder();
                sb.append("Recv SECMSG errCode = ");
                sb.append(faVar.b());
                sb.append(" errStr = ");
                a2 = faVar.m295c();
            }
        } else if ("PING".equals(m288a)) {
            byte[] m292a = faVar.m292a();
            if (m292a != null && m292a.length > 0) {
                du.j a9 = du.j.a(m292a);
                if (a9.b()) {
                    bi.a().a(a9.a());
                }
            }
            if (!"com.xiaomi.xmsf".equals(this.f41740a.getPackageName())) {
                this.f41740a.m548a();
            }
            if ("1".equals(faVar.e())) {
                com.xiaomi.channel.commonutils.logger.b.m56a("received a server ping");
            } else {
                gz.b();
            }
            this.f41740a.m551b();
            return;
        } else if ("SYNC".equals(m288a)) {
            if ("CONF".equals(faVar.m294b())) {
                bi.a().a(du.b.a(faVar.m292a()));
                return;
            } else if (TextUtils.equals("U", faVar.m294b())) {
                du.k a10 = du.k.a(faVar.m292a());
                db.a(this.f41740a).a(a10.a(), a10.b(), new Date(a10.a()), new Date(a10.b()), a10.c() * 1024, a10.e());
                fa faVar2 = new fa();
                faVar2.a(0);
                faVar2.a(faVar.m288a(), "UCA");
                faVar2.a(faVar.e());
                XMPushService xMPushService = this.f41740a;
                xMPushService.a(new bg(xMPushService, faVar2));
                return;
            } else if (!TextUtils.equals("P", faVar.m294b())) {
                return;
            } else {
                du.i a11 = du.i.a(faVar.m292a());
                fa faVar3 = new fa();
                faVar3.a(0);
                faVar3.a(faVar.m288a(), "PCA");
                faVar3.a(faVar.e());
                du.i iVar = new du.i();
                if (a11.a()) {
                    iVar.a(a11.a());
                }
                faVar3.a(iVar.m267a(), (String) null);
                XMPushService xMPushService2 = this.f41740a;
                xMPushService2.a(new bg(xMPushService2, faVar3));
                sb = new StringBuilder();
                sb.append("ACK msgP: id = ");
                a2 = faVar.e();
            }
        } else if (!"NOTIFY".equals(faVar.m288a())) {
            return;
        } else {
            du.h a12 = du.h.a(faVar.m292a());
            sb = new StringBuilder();
            sb.append("notify by server err = ");
            sb.append(a12.c());
            sb.append(" desc = ");
            a2 = a12.a();
        }
        sb.append(a2);
        str = sb.toString();
        com.xiaomi.channel.commonutils.logger.b.m56a(str);
    }
}
