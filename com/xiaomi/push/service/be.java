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
/* loaded from: classes8.dex */
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
        ha.a(this.a, a.f935a, ha.a(gmVar.mo446a()), true, true, System.currentTimeMillis());
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
            com.xiaomi.channel.commonutils.logger.b.a("handle Blob chid = " + fkVar.a() + " cmd = " + fkVar.m399a() + " packetid = " + fkVar.e() + " failure ", e);
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
            com.xiaomi.channel.commonutils.logger.b.m97a("Received wrong packet with chid = 0 : " + gmVar.mo446a());
        }
        if (gmVar instanceof gk) {
            gj a = gmVar.a("kick");
            if (a != null) {
                String l = gmVar.l();
                String a2 = a.a("type");
                String a3 = a.a("reason");
                com.xiaomi.channel.commonutils.logger.b.m97a("kicked by server, chid=" + k + " res=" + bg.b.a(l) + " type=" + a2 + " reason=" + a3);
                if (!"wait".equals(a2)) {
                    this.a.a(k, l, 3, a3, a2);
                    bg.a().m714a(k, l);
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
        this.a.m667b().a(this.a, k, gmVar);
    }

    public void b(fk fkVar) {
        StringBuilder sb;
        String m346a;
        String str;
        bg.c cVar;
        int i;
        int i2;
        String m399a = fkVar.m399a();
        if (fkVar.a() != 0) {
            String num = Integer.toString(fkVar.a());
            if (!"SECMSG".equals(fkVar.m399a())) {
                if (!"BIND".equals(m399a)) {
                    if ("KICK".equals(m399a)) {
                        dw.g a = dw.g.a(fkVar.m403a());
                        String g = fkVar.g();
                        String m341a = a.m341a();
                        String m343b = a.m343b();
                        com.xiaomi.channel.commonutils.logger.b.m97a("kicked by server, chid=" + num + " res= " + bg.b.a(g) + " type=" + m341a + " reason=" + m343b);
                        if (!"wait".equals(m341a)) {
                            this.a.a(num, g, 3, m343b, m341a);
                            bg.a().m714a(num, g);
                            return;
                        }
                        bg.b a2 = bg.a().a(num, g);
                        if (a2 != null) {
                            this.a.a(a2);
                            a2.a(bg.c.unbind, 3, 0, m343b, m341a);
                            return;
                        }
                        return;
                    }
                    return;
                }
                dw.d a3 = dw.d.a(fkVar.m403a());
                String g2 = fkVar.g();
                bg.b a4 = bg.a().a(num, g2);
                if (a4 == null) {
                    return;
                }
                if (a3.m320a()) {
                    com.xiaomi.channel.commonutils.logger.b.m97a("SMACK: channel bind succeeded, chid=" + fkVar.a());
                    a4.a(bg.c.binded, 1, 0, (String) null, (String) null);
                    return;
                }
                String m319a = a3.m319a();
                if ("auth".equals(m319a)) {
                    if ("invalid-sig".equals(a3.m321b())) {
                        com.xiaomi.channel.commonutils.logger.b.m97a("SMACK: bind error invalid-sig token = " + a4.c + " sec = " + a4.h);
                        fi.a(0, ey.BIND_INVALID_SIG.a(), 1, null, 0);
                    }
                    cVar = bg.c.unbind;
                    i = 1;
                    i2 = 5;
                } else if (!"cancel".equals(m319a)) {
                    if ("wait".equals(m319a)) {
                        this.a.a(a4);
                        a4.a(bg.c.unbind, 1, 7, a3.m321b(), m319a);
                    }
                    str = "SMACK: channel bind failed, chid=" + num + " reason=" + a3.m321b();
                    com.xiaomi.channel.commonutils.logger.b.m97a(str);
                } else {
                    cVar = bg.c.unbind;
                    i = 1;
                    i2 = 7;
                }
                a4.a(cVar, i, i2, a3.m321b(), m319a);
                bg.a().m714a(num, g2);
                str = "SMACK: channel bind failed, chid=" + num + " reason=" + a3.m321b();
                com.xiaomi.channel.commonutils.logger.b.m97a(str);
            } else if (!fkVar.m402a()) {
                this.a.m667b().a(this.a, num, fkVar);
                return;
            } else {
                sb = new StringBuilder();
                sb.append("Recv SECMSG errCode = ");
                sb.append(fkVar.b());
                sb.append(" errStr = ");
                m346a = fkVar.m406c();
            }
        } else if ("PING".equals(m399a)) {
            byte[] m403a = fkVar.m403a();
            if (m403a != null && m403a.length > 0) {
                dw.j a5 = dw.j.a(m403a);
                if (a5.m354b()) {
                    bv.a().a(a5.m352a());
                }
            }
            if (!"com.xiaomi.xmsf".equals(this.a.getPackageName())) {
                this.a.m664a();
            }
            if ("1".equals(fkVar.e())) {
                com.xiaomi.channel.commonutils.logger.b.m97a("received a server ping");
            } else {
                fi.b();
            }
            this.a.m668b();
            return;
        } else if ("SYNC".equals(m399a)) {
            if ("CONF".equals(fkVar.m405b())) {
                bv.a().a(dw.b.a(fkVar.m403a()));
                return;
            } else if (TextUtils.equals("U", fkVar.m405b())) {
                dw.k a6 = dw.k.a(fkVar.m403a());
                de.a(this.a).a(a6.m356a(), a6.m359b(), new Date(a6.m355a()), new Date(a6.m358b()), a6.c() * 1024, a6.e());
                fk fkVar2 = new fk();
                fkVar2.a(0);
                fkVar2.a(fkVar.m399a(), "UCA");
                fkVar2.a(fkVar.e());
                XMPushService xMPushService = this.a;
                xMPushService.a(new bt(xMPushService, fkVar2));
                return;
            } else if (!TextUtils.equals("P", fkVar.m405b())) {
                return;
            } else {
                dw.i a7 = dw.i.a(fkVar.m403a());
                fk fkVar3 = new fk();
                fkVar3.a(0);
                fkVar3.a(fkVar.m399a(), "PCA");
                fkVar3.a(fkVar.e());
                dw.i iVar = new dw.i();
                if (a7.m350a()) {
                    iVar.a(a7.m349a());
                }
                fkVar3.a(iVar.m363a(), (String) null);
                XMPushService xMPushService2 = this.a;
                xMPushService2.a(new bt(xMPushService2, fkVar3));
                sb = new StringBuilder();
                sb.append("ACK msgP: id = ");
                m346a = fkVar.e();
            }
        } else if (!"NOTIFY".equals(fkVar.m399a())) {
            return;
        } else {
            dw.h a8 = dw.h.a(fkVar.m403a());
            sb = new StringBuilder();
            sb.append("notify by server err = ");
            sb.append(a8.c());
            sb.append(" desc = ");
            m346a = a8.m346a();
        }
        sb.append(m346a);
        str = sb.toString();
        com.xiaomi.channel.commonutils.logger.b.m97a(str);
    }
}
