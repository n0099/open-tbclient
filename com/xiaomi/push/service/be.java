package com.xiaomi.push.service;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.push.cv;
import com.xiaomi.push.df;
import com.xiaomi.push.dx;
import com.xiaomi.push.ez;
import com.xiaomi.push.fj;
import com.xiaomi.push.fl;
import com.xiaomi.push.fx;
import com.xiaomi.push.gk;
import com.xiaomi.push.gl;
import com.xiaomi.push.gm;
import com.xiaomi.push.gn;
import com.xiaomi.push.hb;
import com.xiaomi.push.service.bg;
import java.util.Date;
/* loaded from: classes8.dex */
public class be {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public XMPushService a;

    public be(XMPushService xMPushService) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {xMPushService};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = xMPushService;
    }

    private void a(gk gkVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, gkVar) == null) {
            String c = gkVar.c();
            if (TextUtils.isEmpty(c)) {
                return;
            }
            String[] split = c.split(";");
            com.xiaomi.push.cr a = cv.a().a(fx.a(), false);
            if (a == null || split.length <= 0) {
                return;
            }
            a.a(split);
            this.a.a(20, (Exception) null);
            this.a.a(true);
        }
    }

    private void b(gn gnVar) {
        bg.b a;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, gnVar) == null) {
            String l = gnVar.l();
            String k = gnVar.k();
            if (TextUtils.isEmpty(l) || TextUtils.isEmpty(k) || (a = bg.a().a(k, l)) == null) {
                return;
            }
            hb.a(this.a, a.f957a, hb.a(gnVar.mo444a()), true, true, System.currentTimeMillis());
        }
    }

    private void c(fl flVar) {
        bg.b a;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, flVar) == null) {
            String g = flVar.g();
            String num = Integer.toString(flVar.a());
            if (TextUtils.isEmpty(g) || TextUtils.isEmpty(num) || (a = bg.a().a(num, g)) == null) {
                return;
            }
            hb.a(this.a, a.f957a, flVar.c(), true, true, System.currentTimeMillis());
        }
    }

    public void a(fl flVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, flVar) == null) {
            if (5 != flVar.a()) {
                c(flVar);
            }
            try {
                b(flVar);
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.a("handle Blob chid = " + flVar.a() + " cmd = " + flVar.m406a() + " packetid = " + flVar.e() + " failure ", e);
            }
        }
    }

    public void a(gn gnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gnVar) == null) {
            if (!"5".equals(gnVar.k())) {
                b(gnVar);
            }
            String k = gnVar.k();
            if (TextUtils.isEmpty(k)) {
                k = "1";
                gnVar.l("1");
            }
            if (k.equals("0")) {
                com.xiaomi.channel.commonutils.logger.b.m105a("Received wrong packet with chid = 0 : " + gnVar.mo444a());
            }
            if (gnVar instanceof gl) {
                gk a = gnVar.a("kick");
                if (a != null) {
                    String l = gnVar.l();
                    String a2 = a.a("type");
                    String a3 = a.a("reason");
                    com.xiaomi.channel.commonutils.logger.b.m105a("kicked by server, chid=" + k + " res=" + bg.b.a(l) + " type=" + a2 + " reason=" + a3);
                    if (!"wait".equals(a2)) {
                        this.a.a(k, l, 3, a3, a2);
                        bg.a().m717a(k, l);
                        return;
                    }
                    bg.b a4 = bg.a().a(k, l);
                    if (a4 != null) {
                        this.a.a(a4);
                        a4.a(bg.c.a, 3, 0, a3, a2);
                        return;
                    }
                    return;
                }
            } else if (gnVar instanceof gm) {
                gm gmVar = (gm) gnVar;
                if ("redir".equals(gmVar.b())) {
                    gk a5 = gmVar.a("hosts");
                    if (a5 != null) {
                        a(a5);
                        return;
                    }
                    return;
                }
            }
            this.a.m670b().a(this.a, k, gnVar);
        }
    }

    public void b(fl flVar) {
        StringBuilder sb;
        String m353a;
        String str;
        bg.c cVar;
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, flVar) == null) {
            String m406a = flVar.m406a();
            if (flVar.a() != 0) {
                String num = Integer.toString(flVar.a());
                if (!"SECMSG".equals(flVar.m406a())) {
                    if (!"BIND".equals(m406a)) {
                        if ("KICK".equals(m406a)) {
                            dx.g a = dx.g.a(flVar.m410a());
                            String g = flVar.g();
                            String m348a = a.m348a();
                            String m350b = a.m350b();
                            com.xiaomi.channel.commonutils.logger.b.m105a("kicked by server, chid=" + num + " res= " + bg.b.a(g) + " type=" + m348a + " reason=" + m350b);
                            if (!"wait".equals(m348a)) {
                                this.a.a(num, g, 3, m350b, m348a);
                                bg.a().m717a(num, g);
                                return;
                            }
                            bg.b a2 = bg.a().a(num, g);
                            if (a2 != null) {
                                this.a.a(a2);
                                a2.a(bg.c.a, 3, 0, m350b, m348a);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    dx.d a3 = dx.d.a(flVar.m410a());
                    String g2 = flVar.g();
                    bg.b a4 = bg.a().a(num, g2);
                    if (a4 == null) {
                        return;
                    }
                    if (a3.m327a()) {
                        com.xiaomi.channel.commonutils.logger.b.m105a("SMACK: channel bind succeeded, chid=" + flVar.a());
                        a4.a(bg.c.c, 1, 0, (String) null, (String) null);
                        return;
                    }
                    String m326a = a3.m326a();
                    if ("auth".equals(m326a)) {
                        if ("invalid-sig".equals(a3.m328b())) {
                            com.xiaomi.channel.commonutils.logger.b.m105a("SMACK: bind error invalid-sig token = " + a4.c + " sec = " + a4.h);
                            fj.a(0, ez.T.a(), 1, null, 0);
                        }
                        cVar = bg.c.a;
                        i = 1;
                        i2 = 5;
                    } else if (!"cancel".equals(m326a)) {
                        if ("wait".equals(m326a)) {
                            this.a.a(a4);
                            a4.a(bg.c.a, 1, 7, a3.m328b(), m326a);
                        }
                        str = "SMACK: channel bind failed, chid=" + num + " reason=" + a3.m328b();
                        com.xiaomi.channel.commonutils.logger.b.m105a(str);
                    } else {
                        cVar = bg.c.a;
                        i = 1;
                        i2 = 7;
                    }
                    a4.a(cVar, i, i2, a3.m328b(), m326a);
                    bg.a().m717a(num, g2);
                    str = "SMACK: channel bind failed, chid=" + num + " reason=" + a3.m328b();
                    com.xiaomi.channel.commonutils.logger.b.m105a(str);
                } else if (!flVar.m409a()) {
                    this.a.m670b().a(this.a, num, flVar);
                    return;
                } else {
                    sb = new StringBuilder();
                    sb.append("Recv SECMSG errCode = ");
                    sb.append(flVar.b());
                    sb.append(" errStr = ");
                    m353a = flVar.m413c();
                }
            } else if ("PING".equals(m406a)) {
                byte[] m410a = flVar.m410a();
                if (m410a != null && m410a.length > 0) {
                    dx.j a5 = dx.j.a(m410a);
                    if (a5.m361b()) {
                        bv.a().a(a5.m359a());
                    }
                }
                if (!"com.xiaomi.xmsf".equals(this.a.getPackageName())) {
                    this.a.m667a();
                }
                if ("1".equals(flVar.e())) {
                    com.xiaomi.channel.commonutils.logger.b.m105a("received a server ping");
                } else {
                    fj.b();
                }
                this.a.m671b();
                return;
            } else if ("SYNC".equals(m406a)) {
                if ("CONF".equals(flVar.m412b())) {
                    bv.a().a(dx.b.a(flVar.m410a()));
                    return;
                } else if (TextUtils.equals("U", flVar.m412b())) {
                    dx.k a6 = dx.k.a(flVar.m410a());
                    df.a(this.a).a(a6.m363a(), a6.m366b(), new Date(a6.m362a()), new Date(a6.m365b()), a6.c() * 1024, a6.e());
                    fl flVar2 = new fl();
                    flVar2.a(0);
                    flVar2.a(flVar.m406a(), "UCA");
                    flVar2.a(flVar.e());
                    XMPushService xMPushService = this.a;
                    xMPushService.a(new bt(xMPushService, flVar2));
                    return;
                } else if (!TextUtils.equals("P", flVar.m412b())) {
                    return;
                } else {
                    dx.i a7 = dx.i.a(flVar.m410a());
                    fl flVar3 = new fl();
                    flVar3.a(0);
                    flVar3.a(flVar.m406a(), "PCA");
                    flVar3.a(flVar.e());
                    dx.i iVar = new dx.i();
                    if (a7.m357a()) {
                        iVar.a(a7.m356a());
                    }
                    flVar3.a(iVar.m370a(), (String) null);
                    XMPushService xMPushService2 = this.a;
                    xMPushService2.a(new bt(xMPushService2, flVar3));
                    sb = new StringBuilder();
                    sb.append("ACK msgP: id = ");
                    m353a = flVar.e();
                }
            } else if (!"NOTIFY".equals(flVar.m406a())) {
                return;
            } else {
                dx.h a8 = dx.h.a(flVar.m410a());
                sb = new StringBuilder();
                sb.append("notify by server err = ");
                sb.append(a8.c());
                sb.append(" desc = ");
                m353a = a8.m353a();
            }
            sb.append(m353a);
            str = sb.toString();
            com.xiaomi.channel.commonutils.logger.b.m105a(str);
        }
    }
}
