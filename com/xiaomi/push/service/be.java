package com.xiaomi.push.service;

import android.text.TextUtils;
import com.xiaomi.push.de;
import com.xiaomi.push.dw;
import com.xiaomi.push.ey;
import com.xiaomi.push.fi;
import com.xiaomi.push.fk;
import com.xiaomi.push.fw;
import com.xiaomi.push.gj;
import com.xiaomi.push.gk;
import com.xiaomi.push.gl;
import com.xiaomi.push.gm;
import com.xiaomi.push.ha;
import com.xiaomi.push.service.bg;
import com.yy.hiidostatis.defs.obj.ParamableElem;
import java.util.Date;
/* loaded from: classes10.dex */
public class be {
    public XMPushService a;

    public be(XMPushService xMPushService) {
        this.a = xMPushService;
    }

    private void a(gj gjVar) {
        String c = gjVar.c();
        if (TextUtils.isEmpty(c)) {
            return;
        }
        String[] split = c.split(ParamableElem.DIVIDE_PARAM);
        com.xiaomi.push.cq a = com.xiaomi.push.cu.a().a(fw.a(), false);
        if (a == null || split.length <= 0) {
            return;
        }
        a.a(split);
        this.a.a(20, (Exception) null);
        this.a.a(true);
    }

    private void b(gm gmVar) {
        bg.b a;
        String l = gmVar.l();
        String k = gmVar.k();
        if (TextUtils.isEmpty(l) || TextUtils.isEmpty(k) || (a = bg.a().a(k, l)) == null) {
            return;
        }
        ha.a(this.a, a.f935a, ha.a(gmVar.mo469a()), true, true, System.currentTimeMillis());
    }

    private void c(fk fkVar) {
        bg.b a;
        String g = fkVar.g();
        String num = Integer.toString(fkVar.a());
        if (TextUtils.isEmpty(g) || TextUtils.isEmpty(num) || (a = bg.a().a(num, g)) == null) {
            return;
        }
        ha.a(this.a, a.f935a, fkVar.c(), true, true, System.currentTimeMillis());
    }

    public void a(fk fkVar) {
        if (5 != fkVar.a()) {
            c(fkVar);
        }
        try {
            b(fkVar);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a("handle Blob chid = " + fkVar.a() + " cmd = " + fkVar.m422a() + " packetid = " + fkVar.e() + " failure ", e);
        }
    }

    public void a(gm gmVar) {
        if (!"5".equals(gmVar.k())) {
            b(gmVar);
        }
        String k = gmVar.k();
        if (TextUtils.isEmpty(k)) {
            k = "1";
            gmVar.l("1");
        }
        if (k.equals("0")) {
            com.xiaomi.channel.commonutils.logger.b.m120a("Received wrong packet with chid = 0 : " + gmVar.mo469a());
        }
        if (gmVar instanceof gk) {
            gj a = gmVar.a("kick");
            if (a != null) {
                String l = gmVar.l();
                String a2 = a.a("type");
                String a3 = a.a("reason");
                com.xiaomi.channel.commonutils.logger.b.m120a("kicked by server, chid=" + k + " res=" + bg.b.a(l) + " type=" + a2 + " reason=" + a3);
                if (!"wait".equals(a2)) {
                    this.a.a(k, l, 3, a3, a2);
                    bg.a().m737a(k, l);
                    return;
                }
                bg.b a4 = bg.a().a(k, l);
                if (a4 != null) {
                    this.a.a(a4);
                    a4.a(bg.c.unbind, 3, 0, a3, a2);
                    return;
                }
                return;
            }
        } else if (gmVar instanceof gl) {
            gl glVar = (gl) gmVar;
            if ("redir".equals(glVar.b())) {
                gj a5 = glVar.a("hosts");
                if (a5 != null) {
                    a(a5);
                    return;
                }
                return;
            }
        }
        this.a.m690b().a(this.a, k, gmVar);
    }

    public void b(fk fkVar) {
        StringBuilder sb;
        String m369a;
        String str;
        bg.c cVar;
        int i;
        int i2;
        String m422a = fkVar.m422a();
        if (fkVar.a() != 0) {
            String num = Integer.toString(fkVar.a());
            if (!"SECMSG".equals(fkVar.m422a())) {
                if (!"BIND".equals(m422a)) {
                    if ("KICK".equals(m422a)) {
                        dw.g a = dw.g.a(fkVar.m426a());
                        String g = fkVar.g();
                        String m364a = a.m364a();
                        String m366b = a.m366b();
                        com.xiaomi.channel.commonutils.logger.b.m120a("kicked by server, chid=" + num + " res= " + bg.b.a(g) + " type=" + m364a + " reason=" + m366b);
                        if (!"wait".equals(m364a)) {
                            this.a.a(num, g, 3, m366b, m364a);
                            bg.a().m737a(num, g);
                            return;
                        }
                        bg.b a2 = bg.a().a(num, g);
                        if (a2 != null) {
                            this.a.a(a2);
                            a2.a(bg.c.unbind, 3, 0, m366b, m364a);
                            return;
                        }
                        return;
                    }
                    return;
                }
                dw.d a3 = dw.d.a(fkVar.m426a());
                String g2 = fkVar.g();
                bg.b a4 = bg.a().a(num, g2);
                if (a4 == null) {
                    return;
                }
                if (a3.m343a()) {
                    com.xiaomi.channel.commonutils.logger.b.m120a("SMACK: channel bind succeeded, chid=" + fkVar.a());
                    a4.a(bg.c.binded, 1, 0, (String) null, (String) null);
                    return;
                }
                String m342a = a3.m342a();
                if ("auth".equals(m342a)) {
                    if ("invalid-sig".equals(a3.m344b())) {
                        com.xiaomi.channel.commonutils.logger.b.m120a("SMACK: bind error invalid-sig token = " + a4.c + " sec = " + a4.h);
                        fi.a(0, ey.BIND_INVALID_SIG.a(), 1, null, 0);
                    }
                    cVar = bg.c.unbind;
                    i = 1;
                    i2 = 5;
                } else if (!"cancel".equals(m342a)) {
                    if ("wait".equals(m342a)) {
                        this.a.a(a4);
                        a4.a(bg.c.unbind, 1, 7, a3.m344b(), m342a);
                    }
                    str = "SMACK: channel bind failed, chid=" + num + " reason=" + a3.m344b();
                    com.xiaomi.channel.commonutils.logger.b.m120a(str);
                } else {
                    cVar = bg.c.unbind;
                    i = 1;
                    i2 = 7;
                }
                a4.a(cVar, i, i2, a3.m344b(), m342a);
                bg.a().m737a(num, g2);
                str = "SMACK: channel bind failed, chid=" + num + " reason=" + a3.m344b();
                com.xiaomi.channel.commonutils.logger.b.m120a(str);
            } else if (!fkVar.m425a()) {
                this.a.m690b().a(this.a, num, fkVar);
                return;
            } else {
                sb = new StringBuilder();
                sb.append("Recv SECMSG errCode = ");
                sb.append(fkVar.b());
                sb.append(" errStr = ");
                m369a = fkVar.m429c();
            }
        } else if ("PING".equals(m422a)) {
            byte[] m426a = fkVar.m426a();
            if (m426a != null && m426a.length > 0) {
                dw.j a5 = dw.j.a(m426a);
                if (a5.m377b()) {
                    bv.a().a(a5.m375a());
                }
            }
            if (!"com.xiaomi.xmsf".equals(this.a.getPackageName())) {
                this.a.m687a();
            }
            if ("1".equals(fkVar.e())) {
                com.xiaomi.channel.commonutils.logger.b.m120a("received a server ping");
            } else {
                fi.b();
            }
            this.a.m691b();
            return;
        } else if ("SYNC".equals(m422a)) {
            if ("CONF".equals(fkVar.m428b())) {
                bv.a().a(dw.b.a(fkVar.m426a()));
                return;
            } else if (TextUtils.equals("U", fkVar.m428b())) {
                dw.k a6 = dw.k.a(fkVar.m426a());
                de.a(this.a).a(a6.m379a(), a6.m382b(), new Date(a6.m378a()), new Date(a6.m381b()), a6.c() * 1024, a6.e());
                fk fkVar2 = new fk();
                fkVar2.a(0);
                fkVar2.a(fkVar.m422a(), "UCA");
                fkVar2.a(fkVar.e());
                XMPushService xMPushService = this.a;
                xMPushService.a(new bt(xMPushService, fkVar2));
                return;
            } else if (!TextUtils.equals("P", fkVar.m428b())) {
                return;
            } else {
                dw.i a7 = dw.i.a(fkVar.m426a());
                fk fkVar3 = new fk();
                fkVar3.a(0);
                fkVar3.a(fkVar.m422a(), "PCA");
                fkVar3.a(fkVar.e());
                dw.i iVar = new dw.i();
                if (a7.m373a()) {
                    iVar.a(a7.m372a());
                }
                fkVar3.a(iVar.m386a(), (String) null);
                XMPushService xMPushService2 = this.a;
                xMPushService2.a(new bt(xMPushService2, fkVar3));
                sb = new StringBuilder();
                sb.append("ACK msgP: id = ");
                m369a = fkVar.e();
            }
        } else if (!"NOTIFY".equals(fkVar.m422a())) {
            return;
        } else {
            dw.h a8 = dw.h.a(fkVar.m426a());
            sb = new StringBuilder();
            sb.append("notify by server err = ");
            sb.append(a8.c());
            sb.append(" desc = ");
            m369a = a8.m369a();
        }
        sb.append(m369a);
        str = sb.toString();
        com.xiaomi.channel.commonutils.logger.b.m120a(str);
    }
}
