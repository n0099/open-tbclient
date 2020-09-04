package com.xiaomi.push.service;

import android.text.TextUtils;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.coremedia.iso.boxes.AuthorBox;
import com.xiaomi.push.cv;
import com.xiaomi.push.cz;
import com.xiaomi.push.di;
import com.xiaomi.push.ek;
import com.xiaomi.push.fh;
import com.xiaomi.push.fl;
import com.xiaomi.push.ft;
import com.xiaomi.push.gg;
import com.xiaomi.push.gh;
import com.xiaomi.push.gi;
import com.xiaomi.push.gj;
import com.xiaomi.push.gx;
import com.xiaomi.push.hg;
import com.xiaomi.push.service.ap;
import java.util.Date;
/* loaded from: classes7.dex */
public class ao {
    private XMPushService a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(XMPushService xMPushService) {
        this.a = xMPushService;
    }

    private void a(gg ggVar) {
        String c = ggVar.c();
        if (TextUtils.isEmpty(c)) {
            return;
        }
        String[] split = c.split(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
        cv a = cz.a().a(ft.a(), false);
        if (a == null || split.length <= 0) {
            return;
        }
        a.a(split);
        this.a.a(20, (Exception) null);
        this.a.a(true);
    }

    private void b(gj gjVar) {
        ap.b a;
        String l = gjVar.l();
        String k = gjVar.k();
        if (TextUtils.isEmpty(l) || TextUtils.isEmpty(k) || (a = ap.a().a(k, l)) == null) {
            return;
        }
        gx.a(this.a, a.f860a, gx.a(gjVar.m316a()), true, true, System.currentTimeMillis());
    }

    private void c(fl flVar) {
        ap.b a;
        String g = flVar.g();
        String num = Integer.toString(flVar.a());
        if (TextUtils.isEmpty(g) || TextUtils.isEmpty(num) || (a = ap.a().a(num, g)) == null) {
            return;
        }
        gx.a(this.a, a.f860a, flVar.c(), true, true, System.currentTimeMillis());
    }

    public void a(fl flVar) {
        if (5 != flVar.a()) {
            c(flVar);
        }
        try {
            b(flVar);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a("handle Blob chid = " + flVar.a() + " cmd = " + flVar.m280a() + " packetid = " + flVar.e() + " failure ", e);
        }
    }

    public void a(gj gjVar) {
        if (!"5".equals(gjVar.k())) {
            b(gjVar);
        }
        String k = gjVar.k();
        if (TextUtils.isEmpty(k)) {
            k = "1";
            gjVar.l("1");
        }
        if (k.equals("0")) {
            com.xiaomi.channel.commonutils.logger.b.m54a("Received wrong packet with chid = 0 : " + gjVar.m316a());
        }
        if (gjVar instanceof gh) {
            gg a = gjVar.a("kick");
            if (a != null) {
                String l = gjVar.l();
                String a2 = a.a("type");
                String a3 = a.a(TiebaInitialize.LogFields.REASON);
                com.xiaomi.channel.commonutils.logger.b.m54a("kicked by server, chid=" + k + " res=" + ap.b.a(l) + " type=" + a2 + " reason=" + a3);
                if (!"wait".equals(a2)) {
                    this.a.a(k, l, 3, a3, a2);
                    ap.a().m549a(k, l);
                    return;
                }
                ap.b a4 = ap.a().a(k, l);
                if (a4 != null) {
                    this.a.a(a4);
                    a4.a(ap.c.unbind, 3, 0, a3, a2);
                    return;
                }
                return;
            }
        } else if (gjVar instanceof gi) {
            gi giVar = (gi) gjVar;
            if ("redir".equals(giVar.b())) {
                gg a5 = giVar.a("hosts");
                if (a5 != null) {
                    a(a5);
                    return;
                }
                return;
            }
        }
        this.a.b().a(this.a, k, gjVar);
    }

    public void b(fl flVar) {
        String m280a = flVar.m280a();
        switch (flVar.a()) {
            case 0:
                if ("PING".equals(m280a)) {
                    byte[] m284a = flVar.m284a();
                    if (m284a != null && m284a.length > 0) {
                        ek.j a = ek.j.a(m284a);
                        if (a.b()) {
                            be.a().a(a.a());
                        }
                    }
                    if (!"com.xiaomi.xmsf".equals(this.a.getPackageName())) {
                        this.a.m521a();
                    }
                    if ("1".equals(flVar.e())) {
                        com.xiaomi.channel.commonutils.logger.b.m54a("received a server ping");
                    } else {
                        hg.b();
                    }
                    this.a.m524b();
                    return;
                } else if (!"SYNC".equals(m280a)) {
                    if ("NOTIFY".equals(flVar.m280a())) {
                        ek.h a2 = ek.h.a(flVar.m284a());
                        com.xiaomi.channel.commonutils.logger.b.m54a("notify by server err = " + a2.c() + " desc = " + a2.a());
                        return;
                    }
                    return;
                } else if ("CONF".equals(flVar.m286b())) {
                    be.a().a(ek.b.a(flVar.m284a()));
                    return;
                } else if (TextUtils.equals("U", flVar.m286b())) {
                    ek.k a3 = ek.k.a(flVar.m284a());
                    di.a(this.a).a(a3.a(), a3.b(), new Date(a3.a()), new Date(a3.b()), a3.c() * 1024, a3.e());
                    fl flVar2 = new fl();
                    flVar2.a(0);
                    flVar2.a(flVar.m280a(), "UCA");
                    flVar2.a(flVar.e());
                    this.a.a(new ba(this.a, flVar2));
                    return;
                } else if (TextUtils.equals("P", flVar.m286b())) {
                    ek.i a4 = ek.i.a(flVar.m284a());
                    fl flVar3 = new fl();
                    flVar3.a(0);
                    flVar3.a(flVar.m280a(), "PCA");
                    flVar3.a(flVar.e());
                    ek.i iVar = new ek.i();
                    if (a4.a()) {
                        iVar.a(a4.a());
                    }
                    flVar3.a(iVar.a(), (String) null);
                    this.a.a(new ba(this.a, flVar3));
                    com.xiaomi.channel.commonutils.logger.b.m54a("ACK msgP: id = " + flVar.e());
                    return;
                } else {
                    return;
                }
            default:
                String num = Integer.toString(flVar.a());
                if ("SECMSG".equals(flVar.m280a())) {
                    if (flVar.m283a()) {
                        com.xiaomi.channel.commonutils.logger.b.m54a("Recv SECMSG errCode = " + flVar.b() + " errStr = " + flVar.m287c());
                        return;
                    } else {
                        this.a.b().a(this.a, num, flVar);
                        return;
                    }
                } else if (!"BIND".equals(m280a)) {
                    if ("KICK".equals(m280a)) {
                        ek.g a5 = ek.g.a(flVar.m284a());
                        String g = flVar.g();
                        String a6 = a5.a();
                        String b = a5.b();
                        com.xiaomi.channel.commonutils.logger.b.m54a("kicked by server, chid=" + num + " res= " + ap.b.a(g) + " type=" + a6 + " reason=" + b);
                        if (!"wait".equals(a6)) {
                            this.a.a(num, g, 3, b, a6);
                            ap.a().m549a(num, g);
                            return;
                        }
                        ap.b a7 = ap.a().a(num, g);
                        if (a7 != null) {
                            this.a.a(a7);
                            a7.a(ap.c.unbind, 3, 0, b, a6);
                            return;
                        }
                        return;
                    }
                    return;
                } else {
                    ek.d a8 = ek.d.a(flVar.m284a());
                    String g2 = flVar.g();
                    ap.b a9 = ap.a().a(num, g2);
                    if (a9 != null) {
                        if (a8.a()) {
                            com.xiaomi.channel.commonutils.logger.b.m54a("SMACK: channel bind succeeded, chid=" + flVar.a());
                            a9.a(ap.c.binded, 1, 0, (String) null, (String) null);
                            return;
                        }
                        String a10 = a8.a();
                        if (AuthorBox.TYPE.equals(a10)) {
                            if ("invalid-sig".equals(a8.b())) {
                                com.xiaomi.channel.commonutils.logger.b.m54a("SMACK: bind error invalid-sig token = " + a9.c + " sec = " + a9.h);
                                hg.a(0, fh.BIND_INVALID_SIG.a(), 1, null, 0);
                            }
                            a9.a(ap.c.unbind, 1, 5, a8.b(), a10);
                            ap.a().m549a(num, g2);
                        } else if ("cancel".equals(a10)) {
                            a9.a(ap.c.unbind, 1, 7, a8.b(), a10);
                            ap.a().m549a(num, g2);
                        } else if ("wait".equals(a10)) {
                            this.a.a(a9);
                            a9.a(ap.c.unbind, 1, 7, a8.b(), a10);
                        }
                        com.xiaomi.channel.commonutils.logger.b.m54a("SMACK: channel bind failed, chid=" + num + " reason=" + a8.b());
                        return;
                    }
                    return;
                }
        }
    }
}
