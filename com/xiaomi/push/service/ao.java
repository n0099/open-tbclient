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
/* loaded from: classes6.dex */
public class ao {

    /* renamed from: a  reason: collision with root package name */
    private XMPushService f14540a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(XMPushService xMPushService) {
        this.f14540a = xMPushService;
    }

    private void a(gg ggVar) {
        String c = ggVar.c();
        if (TextUtils.isEmpty(c)) {
            return;
        }
        String[] split = c.split(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
        cv a2 = cz.a().a(ft.a(), false);
        if (a2 == null || split.length <= 0) {
            return;
        }
        a2.a(split);
        this.f14540a.a(20, (Exception) null);
        this.f14540a.a(true);
    }

    private void b(gj gjVar) {
        ap.b a2;
        String l = gjVar.l();
        String k = gjVar.k();
        if (TextUtils.isEmpty(l) || TextUtils.isEmpty(k) || (a2 = ap.a().a(k, l)) == null) {
            return;
        }
        gx.a(this.f14540a, a2.f939a, gx.a(gjVar.m346a()), true, true, System.currentTimeMillis());
    }

    private void c(fl flVar) {
        ap.b a2;
        String g = flVar.g();
        String num = Integer.toString(flVar.a());
        if (TextUtils.isEmpty(g) || TextUtils.isEmpty(num) || (a2 = ap.a().a(num, g)) == null) {
            return;
        }
        gx.a(this.f14540a, a2.f939a, flVar.c(), true, true, System.currentTimeMillis());
    }

    public void a(fl flVar) {
        if (5 != flVar.a()) {
            c(flVar);
        }
        try {
            b(flVar);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a("handle Blob chid = " + flVar.a() + " cmd = " + flVar.m310a() + " packetid = " + flVar.e() + " failure ", e);
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
            com.xiaomi.channel.commonutils.logger.b.m84a("Received wrong packet with chid = 0 : " + gjVar.m346a());
        }
        if (gjVar instanceof gh) {
            gg a2 = gjVar.a("kick");
            if (a2 != null) {
                String l = gjVar.l();
                String a3 = a2.a("type");
                String a4 = a2.a(TiebaInitialize.LogFields.REASON);
                com.xiaomi.channel.commonutils.logger.b.m84a("kicked by server, chid=" + k + " res=" + ap.b.a(l) + " type=" + a3 + " reason=" + a4);
                if (!"wait".equals(a3)) {
                    this.f14540a.a(k, l, 3, a4, a3);
                    ap.a().m579a(k, l);
                    return;
                }
                ap.b a5 = ap.a().a(k, l);
                if (a5 != null) {
                    this.f14540a.a(a5);
                    a5.a(ap.c.unbind, 3, 0, a4, a3);
                    return;
                }
                return;
            }
        } else if (gjVar instanceof gi) {
            gi giVar = (gi) gjVar;
            if ("redir".equals(giVar.b())) {
                gg a6 = giVar.a("hosts");
                if (a6 != null) {
                    a(a6);
                    return;
                }
                return;
            }
        }
        this.f14540a.b().a(this.f14540a, k, gjVar);
    }

    public void b(fl flVar) {
        String m310a = flVar.m310a();
        switch (flVar.a()) {
            case 0:
                if ("PING".equals(m310a)) {
                    byte[] m314a = flVar.m314a();
                    if (m314a != null && m314a.length > 0) {
                        ek.j a2 = ek.j.a(m314a);
                        if (a2.b()) {
                            be.a().a(a2.a());
                        }
                    }
                    if (!"com.xiaomi.xmsf".equals(this.f14540a.getPackageName())) {
                        this.f14540a.m551a();
                    }
                    if ("1".equals(flVar.e())) {
                        com.xiaomi.channel.commonutils.logger.b.m84a("received a server ping");
                    } else {
                        hg.b();
                    }
                    this.f14540a.m554b();
                    return;
                } else if (!"SYNC".equals(m310a)) {
                    if ("NOTIFY".equals(flVar.m310a())) {
                        ek.h a3 = ek.h.a(flVar.m314a());
                        com.xiaomi.channel.commonutils.logger.b.m84a("notify by server err = " + a3.c() + " desc = " + a3.a());
                        return;
                    }
                    return;
                } else if ("CONF".equals(flVar.m316b())) {
                    be.a().a(ek.b.a(flVar.m314a()));
                    return;
                } else if (TextUtils.equals("U", flVar.m316b())) {
                    ek.k a4 = ek.k.a(flVar.m314a());
                    di.a(this.f14540a).a(a4.a(), a4.b(), new Date(a4.a()), new Date(a4.b()), a4.c() * 1024, a4.e());
                    fl flVar2 = new fl();
                    flVar2.a(0);
                    flVar2.a(flVar.m310a(), "UCA");
                    flVar2.a(flVar.e());
                    this.f14540a.a(new ba(this.f14540a, flVar2));
                    return;
                } else if (TextUtils.equals("P", flVar.m316b())) {
                    ek.i a5 = ek.i.a(flVar.m314a());
                    fl flVar3 = new fl();
                    flVar3.a(0);
                    flVar3.a(flVar.m310a(), "PCA");
                    flVar3.a(flVar.e());
                    ek.i iVar = new ek.i();
                    if (a5.a()) {
                        iVar.a(a5.a());
                    }
                    flVar3.a(iVar.a(), (String) null);
                    this.f14540a.a(new ba(this.f14540a, flVar3));
                    com.xiaomi.channel.commonutils.logger.b.m84a("ACK msgP: id = " + flVar.e());
                    return;
                } else {
                    return;
                }
            default:
                String num = Integer.toString(flVar.a());
                if ("SECMSG".equals(flVar.m310a())) {
                    if (flVar.m313a()) {
                        com.xiaomi.channel.commonutils.logger.b.m84a("Recv SECMSG errCode = " + flVar.b() + " errStr = " + flVar.m317c());
                        return;
                    } else {
                        this.f14540a.b().a(this.f14540a, num, flVar);
                        return;
                    }
                } else if (!"BIND".equals(m310a)) {
                    if ("KICK".equals(m310a)) {
                        ek.g a6 = ek.g.a(flVar.m314a());
                        String g = flVar.g();
                        String a7 = a6.a();
                        String b2 = a6.b();
                        com.xiaomi.channel.commonutils.logger.b.m84a("kicked by server, chid=" + num + " res= " + ap.b.a(g) + " type=" + a7 + " reason=" + b2);
                        if (!"wait".equals(a7)) {
                            this.f14540a.a(num, g, 3, b2, a7);
                            ap.a().m579a(num, g);
                            return;
                        }
                        ap.b a8 = ap.a().a(num, g);
                        if (a8 != null) {
                            this.f14540a.a(a8);
                            a8.a(ap.c.unbind, 3, 0, b2, a7);
                            return;
                        }
                        return;
                    }
                    return;
                } else {
                    ek.d a9 = ek.d.a(flVar.m314a());
                    String g2 = flVar.g();
                    ap.b a10 = ap.a().a(num, g2);
                    if (a10 != null) {
                        if (a9.a()) {
                            com.xiaomi.channel.commonutils.logger.b.m84a("SMACK: channel bind succeeded, chid=" + flVar.a());
                            a10.a(ap.c.binded, 1, 0, (String) null, (String) null);
                            return;
                        }
                        String a11 = a9.a();
                        if (AuthorBox.TYPE.equals(a11)) {
                            if ("invalid-sig".equals(a9.b())) {
                                com.xiaomi.channel.commonutils.logger.b.m84a("SMACK: bind error invalid-sig token = " + a10.c + " sec = " + a10.h);
                                hg.a(0, fh.BIND_INVALID_SIG.a(), 1, null, 0);
                            }
                            a10.a(ap.c.unbind, 1, 5, a9.b(), a11);
                            ap.a().m579a(num, g2);
                        } else if ("cancel".equals(a11)) {
                            a10.a(ap.c.unbind, 1, 7, a9.b(), a11);
                            ap.a().m579a(num, g2);
                        } else if ("wait".equals(a11)) {
                            this.f14540a.a(a10);
                            a10.a(ap.c.unbind, 1, 7, a9.b(), a11);
                        }
                        com.xiaomi.channel.commonutils.logger.b.m84a("SMACK: channel bind failed, chid=" + num + " reason=" + a9.b());
                        return;
                    }
                    return;
                }
        }
    }
}
