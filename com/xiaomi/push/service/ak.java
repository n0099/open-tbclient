package com.xiaomi.push.service;

import android.text.TextUtils;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.searchbox.ugc.utils.UgcUBCUtils;
import com.coremedia.iso.boxes.AuthorBox;
import com.xiaomi.push.cq;
import com.xiaomi.push.cu;
import com.xiaomi.push.dd;
import com.xiaomi.push.ee;
import com.xiaomi.push.fb;
import com.xiaomi.push.ff;
import com.xiaomi.push.fn;
import com.xiaomi.push.ga;
import com.xiaomi.push.gb;
import com.xiaomi.push.gc;
import com.xiaomi.push.gd;
import com.xiaomi.push.gr;
import com.xiaomi.push.ha;
import com.xiaomi.push.service.al;
import java.util.Date;
/* loaded from: classes8.dex */
public class ak {
    private XMPushService a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(XMPushService xMPushService) {
        this.a = xMPushService;
    }

    private void a(ga gaVar) {
        String c = gaVar.c();
        if (TextUtils.isEmpty(c)) {
            return;
        }
        String[] split = c.split(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
        cq a = cu.a().a(fn.a(), false);
        if (a == null || split.length <= 0) {
            return;
        }
        a.a(split);
        this.a.a(20, (Exception) null);
        this.a.a(true);
    }

    private void b(gd gdVar) {
        al.b a;
        String l = gdVar.l();
        String k = gdVar.k();
        if (TextUtils.isEmpty(l) || TextUtils.isEmpty(k) || (a = al.a().a(k, l)) == null) {
            return;
        }
        gr.a(this.a, a.f860a, gr.a(gdVar.m305a()), true, true, System.currentTimeMillis());
    }

    private void c(ff ffVar) {
        al.b a;
        String g = ffVar.g();
        String num = Integer.toString(ffVar.a());
        if (TextUtils.isEmpty(g) || TextUtils.isEmpty(num) || (a = al.a().a(num, g)) == null) {
            return;
        }
        gr.a(this.a, a.f860a, ffVar.c(), true, true, System.currentTimeMillis());
    }

    public void a(ff ffVar) {
        if (5 != ffVar.a()) {
            c(ffVar);
        }
        try {
            b(ffVar);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a("handle Blob chid = " + ffVar.a() + " cmd = " + ffVar.m269a() + " packetid = " + ffVar.e() + " failure ", e);
        }
    }

    public void a(gd gdVar) {
        if (!"5".equals(gdVar.k())) {
            b(gdVar);
        }
        String k = gdVar.k();
        if (TextUtils.isEmpty(k)) {
            k = "1";
            gdVar.l("1");
        }
        if (k.equals("0")) {
            com.xiaomi.channel.commonutils.logger.b.m47a("Received wrong packet with chid = 0 : " + gdVar.m305a());
        }
        if (gdVar instanceof gb) {
            ga a = gdVar.a("kick");
            if (a != null) {
                String l = gdVar.l();
                String a2 = a.a("type");
                String a3 = a.a(TiebaInitialize.LogFields.REASON);
                com.xiaomi.channel.commonutils.logger.b.m47a("kicked by server, chid=" + k + " res=" + al.b.a(l) + " type=" + a2 + " reason=" + a3);
                if (!"wait".equals(a2)) {
                    this.a.a(k, l, 3, a3, a2);
                    al.a().m516a(k, l);
                    return;
                }
                al.b a4 = al.a().a(k, l);
                if (a4 != null) {
                    this.a.a(a4);
                    a4.a(al.c.unbind, 3, 0, a3, a2);
                    return;
                }
                return;
            }
        } else if (gdVar instanceof gc) {
            gc gcVar = (gc) gdVar;
            if ("redir".equals(gcVar.b())) {
                ga a5 = gcVar.a("hosts");
                if (a5 != null) {
                    a(a5);
                    return;
                }
                return;
            }
        }
        this.a.b().a(this.a, k, gdVar);
    }

    public void b(ff ffVar) {
        String m269a = ffVar.m269a();
        switch (ffVar.a()) {
            case 0:
                if ("PING".equals(m269a)) {
                    byte[] m273a = ffVar.m273a();
                    if (m273a != null && m273a.length > 0) {
                        ee.j a = ee.j.a(m273a);
                        if (a.b()) {
                            ba.a().a(a.a());
                        }
                    }
                    if (!"com.xiaomi.xmsf".equals(this.a.getPackageName())) {
                        this.a.m501a();
                    }
                    if ("1".equals(ffVar.e())) {
                        com.xiaomi.channel.commonutils.logger.b.m47a("received a server ping");
                    } else {
                        ha.b();
                    }
                    this.a.m504b();
                    return;
                } else if (!"SYNC".equals(m269a)) {
                    if ("NOTIFY".equals(ffVar.m269a())) {
                        ee.h a2 = ee.h.a(ffVar.m273a());
                        com.xiaomi.channel.commonutils.logger.b.m47a("notify by server err = " + a2.c() + " desc = " + a2.a());
                        return;
                    }
                    return;
                } else if ("CONF".equals(ffVar.m275b())) {
                    ba.a().a(ee.b.a(ffVar.m273a()));
                    return;
                } else if (TextUtils.equals("U", ffVar.m275b())) {
                    ee.k a3 = ee.k.a(ffVar.m273a());
                    dd.a(this.a).a(a3.a(), a3.b(), new Date(a3.a()), new Date(a3.b()), a3.c() * 1024, a3.e());
                    ff ffVar2 = new ff();
                    ffVar2.a(0);
                    ffVar2.a(ffVar.m269a(), "UCA");
                    ffVar2.a(ffVar.e());
                    this.a.a(new aw(this.a, ffVar2));
                    return;
                } else if (TextUtils.equals("P", ffVar.m275b())) {
                    ee.i a4 = ee.i.a(ffVar.m273a());
                    ff ffVar3 = new ff();
                    ffVar3.a(0);
                    ffVar3.a(ffVar.m269a(), "PCA");
                    ffVar3.a(ffVar.e());
                    ee.i iVar = new ee.i();
                    if (a4.a()) {
                        iVar.a(a4.a());
                    }
                    ffVar3.a(iVar.a(), (String) null);
                    this.a.a(new aw(this.a, ffVar3));
                    com.xiaomi.channel.commonutils.logger.b.m47a("ACK msgP: id = " + ffVar.e());
                    return;
                } else {
                    return;
                }
            default:
                String num = Integer.toString(ffVar.a());
                if ("SECMSG".equals(ffVar.m269a())) {
                    if (ffVar.m272a()) {
                        com.xiaomi.channel.commonutils.logger.b.m47a("Recv SECMSG errCode = " + ffVar.b() + " errStr = " + ffVar.m276c());
                        return;
                    } else {
                        this.a.b().a(this.a, num, ffVar);
                        return;
                    }
                } else if (!"BIND".equals(m269a)) {
                    if ("KICK".equals(m269a)) {
                        ee.g a5 = ee.g.a(ffVar.m273a());
                        String g = ffVar.g();
                        String a6 = a5.a();
                        String b = a5.b();
                        com.xiaomi.channel.commonutils.logger.b.m47a("kicked by server, chid=" + num + " res= " + al.b.a(g) + " type=" + a6 + " reason=" + b);
                        if (!"wait".equals(a6)) {
                            this.a.a(num, g, 3, b, a6);
                            al.a().m516a(num, g);
                            return;
                        }
                        al.b a7 = al.a().a(num, g);
                        if (a7 != null) {
                            this.a.a(a7);
                            a7.a(al.c.unbind, 3, 0, b, a6);
                            return;
                        }
                        return;
                    }
                    return;
                } else {
                    ee.d a8 = ee.d.a(ffVar.m273a());
                    String g2 = ffVar.g();
                    al.b a9 = al.a().a(num, g2);
                    if (a9 != null) {
                        if (a8.a()) {
                            com.xiaomi.channel.commonutils.logger.b.m47a("SMACK: channel bind succeeded, chid=" + ffVar.a());
                            a9.a(al.c.binded, 1, 0, (String) null, (String) null);
                            return;
                        }
                        String a10 = a8.a();
                        if (AuthorBox.TYPE.equals(a10)) {
                            if ("invalid-sig".equals(a8.b())) {
                                com.xiaomi.channel.commonutils.logger.b.m47a("SMACK: bind error invalid-sig token = " + a9.c + " sec = " + a9.h);
                                ha.a(0, fb.BIND_INVALID_SIG.a(), 1, null, 0);
                            }
                            a9.a(al.c.unbind, 1, 5, a8.b(), a10);
                            al.a().m516a(num, g2);
                        } else if (UgcUBCUtils.UGC_TIME_CANCEL.equals(a10)) {
                            a9.a(al.c.unbind, 1, 7, a8.b(), a10);
                            al.a().m516a(num, g2);
                        } else if ("wait".equals(a10)) {
                            this.a.a(a9);
                            a9.a(al.c.unbind, 1, 7, a8.b(), a10);
                        }
                        com.xiaomi.channel.commonutils.logger.b.m47a("SMACK: channel bind failed, chid=" + num + " reason=" + a8.b());
                        return;
                    }
                    return;
                }
        }
    }
}
