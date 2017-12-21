package com.xiaomi.push.service;

import android.os.Parcelable;
import android.text.TextUtils;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.coremedia.iso.boxes.AuthorBox;
import com.xiaomi.network.Fallback;
import com.xiaomi.network.HostManager;
import com.xiaomi.push.protobuf.b;
import com.xiaomi.push.service.ak;
import java.util.Date;
/* loaded from: classes2.dex */
public class PacketSync {
    private XMPushService a;

    /* loaded from: classes2.dex */
    public interface PacketReceiveHandler extends Parcelable {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PacketSync(XMPushService xMPushService) {
        this.a = xMPushService;
    }

    private void a(com.xiaomi.smack.packet.a aVar) {
        String c = aVar.c();
        if (TextUtils.isEmpty(c)) {
            return;
        }
        String[] split = c.split(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
        Fallback fallbacksByHost = HostManager.getInstance().getFallbacksByHost(com.xiaomi.smack.b.b(), false);
        if (fallbacksByHost == null || split.length <= 0) {
            return;
        }
        fallbacksByHost.a(split);
        this.a.a(20, (Exception) null);
        this.a.a(true);
    }

    private void b(com.xiaomi.smack.packet.d dVar) {
        ak.b b;
        String m = dVar.m();
        String l = dVar.l();
        if (TextUtils.isEmpty(m) || TextUtils.isEmpty(l) || (b = ak.a().b(l, m)) == null) {
            return;
        }
        com.xiaomi.smack.util.g.a(this.a, b.a, com.xiaomi.smack.util.g.a(dVar.c()), true, System.currentTimeMillis());
    }

    private void c(com.xiaomi.slim.b bVar) {
        ak.b b;
        String j = bVar.j();
        String num = Integer.toString(bVar.c());
        if (TextUtils.isEmpty(j) || TextUtils.isEmpty(num) || (b = ak.a().b(num, j)) == null) {
            return;
        }
        com.xiaomi.smack.util.g.a(this.a, b.a, bVar.l(), true, System.currentTimeMillis());
    }

    public void a(com.xiaomi.slim.b bVar) {
        if (5 != bVar.c()) {
            c(bVar);
        }
        try {
            b(bVar);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a("handle Blob chid = " + bVar.c() + " cmd = " + bVar.a() + " packetid = " + bVar.h() + " failure ", e);
        }
    }

    public void a(com.xiaomi.smack.packet.d dVar) {
        if (!"5".equals(dVar.l())) {
            b(dVar);
        }
        String l = dVar.l();
        if (TextUtils.isEmpty(l)) {
            l = "1";
            dVar.l("1");
        }
        if (l.equals("0")) {
            com.xiaomi.channel.commonutils.logger.b.a("Received wrong packet with chid = 0 : " + dVar.c());
        }
        if (dVar instanceof com.xiaomi.smack.packet.b) {
            com.xiaomi.smack.packet.a p = dVar.p("kick");
            if (p != null) {
                String m = dVar.m();
                String a = p.a("type");
                String a2 = p.a("reason");
                com.xiaomi.channel.commonutils.logger.b.a("kicked by server, chid=" + l + " userid=" + m + " type=" + a + " reason=" + a2);
                if (!"wait".equals(a)) {
                    this.a.a(l, m, 3, a2, a);
                    ak.a().a(l, m);
                    return;
                }
                ak.b b = ak.a().b(l, m);
                if (b != null) {
                    this.a.a(b);
                    b.a(ak.c.unbind, 3, 0, a2, a);
                    return;
                }
                return;
            }
        } else if (dVar instanceof com.xiaomi.smack.packet.c) {
            com.xiaomi.smack.packet.c cVar = (com.xiaomi.smack.packet.c) dVar;
            if ("redir".equals(cVar.a())) {
                com.xiaomi.smack.packet.a p2 = cVar.p("hosts");
                if (p2 != null) {
                    a(p2);
                    return;
                }
                return;
            }
        }
        this.a.e().a(this.a, l, dVar);
    }

    public void b(com.xiaomi.slim.b bVar) {
        String a = bVar.a();
        switch (bVar.c()) {
            case 0:
                if ("PING".equals(a)) {
                    byte[] k = bVar.k();
                    if (k != null && k.length > 0) {
                        b.j b = b.j.b(k);
                        if (b.f()) {
                            at.a().a(b.g());
                        }
                    }
                    if ("1".equals(bVar.h())) {
                        this.a.a();
                        return;
                    } else {
                        com.xiaomi.stats.h.b();
                        return;
                    }
                } else if (!"SYNC".equals(a)) {
                    if ("NOTIFY".equals(bVar.a())) {
                        b.h b2 = b.h.b(bVar.k());
                        com.xiaomi.channel.commonutils.logger.b.a("notify by server err = " + b2.d() + " desc = " + b2.f());
                        return;
                    }
                    return;
                } else if ("CONF".equals(bVar.b())) {
                    at.a().a(b.C0179b.b(bVar.k()));
                    return;
                } else if (TextUtils.equals("U", bVar.b())) {
                    b.k b3 = b.k.b(bVar.k());
                    com.xiaomi.push.log.b.a(this.a).a(b3.d(), b3.f(), new Date(b3.h()), new Date(b3.j()), b3.n() * 1024, b3.l());
                    com.xiaomi.slim.b bVar2 = new com.xiaomi.slim.b();
                    bVar2.a(0);
                    bVar2.a(bVar.a(), "UCA");
                    bVar2.a(bVar.h());
                    this.a.a(new as(this.a, bVar2));
                    return;
                } else if (TextUtils.equals("P", bVar.b())) {
                    b.i b4 = b.i.b(bVar.k());
                    com.xiaomi.slim.b bVar3 = new com.xiaomi.slim.b();
                    bVar3.a(0);
                    bVar3.a(bVar.a(), "PCA");
                    bVar3.a(bVar.h());
                    b.i iVar = new b.i();
                    if (b4.e()) {
                        iVar.a(b4.d());
                    }
                    bVar3.a(iVar.c(), (String) null);
                    this.a.a(new as(this.a, bVar3));
                    com.xiaomi.channel.commonutils.logger.b.a("ACK msgP: id = " + bVar.h());
                    return;
                } else {
                    return;
                }
            default:
                String num = Integer.toString(bVar.c());
                if ("SECMSG".equals(bVar.a())) {
                    if (bVar.d()) {
                        com.xiaomi.channel.commonutils.logger.b.a("Recv SECMSG errCode = " + bVar.e() + " errStr = " + bVar.f());
                        return;
                    } else {
                        this.a.e().a(this.a, num, bVar);
                        return;
                    }
                } else if (!"BIND".equals(a)) {
                    if ("KICK".equals(a)) {
                        b.g b5 = b.g.b(bVar.k());
                        String j = bVar.j();
                        String d = b5.d();
                        String f = b5.f();
                        com.xiaomi.channel.commonutils.logger.b.a("kicked by server, chid=" + num + " userid=" + j + " type=" + d + " reason=" + f);
                        if (!"wait".equals(d)) {
                            this.a.a(num, j, 3, f, d);
                            ak.a().a(num, j);
                            return;
                        }
                        ak.b b6 = ak.a().b(num, j);
                        if (b6 != null) {
                            this.a.a(b6);
                            b6.a(ak.c.unbind, 3, 0, f, d);
                            return;
                        }
                        return;
                    }
                    return;
                } else {
                    b.d b7 = b.d.b(bVar.k());
                    String j2 = bVar.j();
                    ak.b b8 = ak.a().b(num, j2);
                    if (b8 != null) {
                        if (b7.d()) {
                            com.xiaomi.channel.commonutils.logger.b.a("SMACK: channel bind succeeded, chid=" + bVar.c());
                            b8.a(ak.c.binded, 1, 0, null, null);
                            return;
                        }
                        String f2 = b7.f();
                        if (AuthorBox.TYPE.equals(f2)) {
                            if ("invalid-sig".equals(b7.h())) {
                                com.xiaomi.channel.commonutils.logger.b.a("SMACK: bind error invalid-sig token = " + b8.c + " sec = " + b8.i);
                                com.xiaomi.stats.h.a(0, com.xiaomi.push.thrift.a.BIND_INVALID_SIG.a(), 1, null, 0);
                            }
                            b8.a(ak.c.unbind, 1, 5, b7.h(), f2);
                            ak.a().a(num, j2);
                        } else if ("cancel".equals(f2)) {
                            b8.a(ak.c.unbind, 1, 7, b7.h(), f2);
                            ak.a().a(num, j2);
                        } else if ("wait".equals(f2)) {
                            this.a.a(b8);
                            b8.a(ak.c.unbind, 1, 7, b7.h(), f2);
                        }
                        com.xiaomi.channel.commonutils.logger.b.a("SMACK: channel bind failed, chid=" + num + " reason=" + b7.h());
                        return;
                    }
                    return;
                }
        }
    }
}
