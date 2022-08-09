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
import com.yy.hiidostatis.defs.obj.ParamableElem;
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
            String[] split = c.split(ParamableElem.DIVIDE_PARAM);
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
            hb.a(this.a, a.f934a, hb.a(gnVar.m371a()), true, true, System.currentTimeMillis());
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
            hb.a(this.a, a.f934a, flVar.c(), true, true, System.currentTimeMillis());
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
                com.xiaomi.channel.commonutils.logger.b.a("handle Blob chid = " + flVar.a() + " cmd = " + flVar.m335a() + " packetid = " + flVar.e() + " failure ", e);
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
                com.xiaomi.channel.commonutils.logger.b.m89a("Received wrong packet with chid = 0 : " + gnVar.m371a());
            }
            if (gnVar instanceof gl) {
                gk a = gnVar.a("kick");
                if (a != null) {
                    String l = gnVar.l();
                    String a2 = a.a("type");
                    String a3 = a.a("reason");
                    com.xiaomi.channel.commonutils.logger.b.m89a("kicked by server, chid=" + k + " res=" + bg.b.a(l) + " type=" + a2 + " reason=" + a3);
                    if (!"wait".equals(a2)) {
                        this.a.a(k, l, 3, a3, a2);
                        bg.a().m641a(k, l);
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
            this.a.m594b().a(this.a, k, gnVar);
        }
    }

    public void b(fl flVar) {
        StringBuilder sb;
        String a;
        String str;
        bg.c cVar;
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, flVar) == null) {
            String m335a = flVar.m335a();
            if (flVar.a() != 0) {
                String num = Integer.toString(flVar.a());
                if (!"SECMSG".equals(flVar.m335a())) {
                    if (!"BIND".equals(m335a)) {
                        if ("KICK".equals(m335a)) {
                            dx.g a2 = dx.g.a(flVar.m339a());
                            String g = flVar.g();
                            String a3 = a2.a();
                            String b = a2.b();
                            com.xiaomi.channel.commonutils.logger.b.m89a("kicked by server, chid=" + num + " res= " + bg.b.a(g) + " type=" + a3 + " reason=" + b);
                            if (!"wait".equals(a3)) {
                                this.a.a(num, g, 3, b, a3);
                                bg.a().m641a(num, g);
                                return;
                            }
                            bg.b a4 = bg.a().a(num, g);
                            if (a4 != null) {
                                this.a.a(a4);
                                a4.a(bg.c.a, 3, 0, b, a3);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    dx.d a5 = dx.d.a(flVar.m339a());
                    String g2 = flVar.g();
                    bg.b a6 = bg.a().a(num, g2);
                    if (a6 == null) {
                        return;
                    }
                    if (a5.a()) {
                        com.xiaomi.channel.commonutils.logger.b.m89a("SMACK: channel bind succeeded, chid=" + flVar.a());
                        a6.a(bg.c.c, 1, 0, (String) null, (String) null);
                        return;
                    }
                    String a7 = a5.a();
                    if ("auth".equals(a7)) {
                        if ("invalid-sig".equals(a5.b())) {
                            com.xiaomi.channel.commonutils.logger.b.m89a("SMACK: bind error invalid-sig token = " + a6.c + " sec = " + a6.h);
                            fj.a(0, ez.T.a(), 1, null, 0);
                        }
                        cVar = bg.c.a;
                        i = 1;
                        i2 = 5;
                    } else if (!"cancel".equals(a7)) {
                        if ("wait".equals(a7)) {
                            this.a.a(a6);
                            a6.a(bg.c.a, 1, 7, a5.b(), a7);
                        }
                        str = "SMACK: channel bind failed, chid=" + num + " reason=" + a5.b();
                        com.xiaomi.channel.commonutils.logger.b.m89a(str);
                    } else {
                        cVar = bg.c.a;
                        i = 1;
                        i2 = 7;
                    }
                    a6.a(cVar, i, i2, a5.b(), a7);
                    bg.a().m641a(num, g2);
                    str = "SMACK: channel bind failed, chid=" + num + " reason=" + a5.b();
                    com.xiaomi.channel.commonutils.logger.b.m89a(str);
                } else if (!flVar.m338a()) {
                    this.a.m594b().a(this.a, num, flVar);
                    return;
                } else {
                    sb = new StringBuilder();
                    sb.append("Recv SECMSG errCode = ");
                    sb.append(flVar.b());
                    sb.append(" errStr = ");
                    a = flVar.m342c();
                }
            } else if ("PING".equals(m335a)) {
                byte[] m339a = flVar.m339a();
                if (m339a != null && m339a.length > 0) {
                    dx.j a8 = dx.j.a(m339a);
                    if (a8.b()) {
                        bv.a().a(a8.a());
                    }
                }
                if (!"com.xiaomi.xmsf".equals(this.a.getPackageName())) {
                    this.a.m591a();
                }
                if ("1".equals(flVar.e())) {
                    com.xiaomi.channel.commonutils.logger.b.m89a("received a server ping");
                } else {
                    fj.b();
                }
                this.a.m595b();
                return;
            } else if ("SYNC".equals(m335a)) {
                if ("CONF".equals(flVar.m341b())) {
                    bv.a().a(dx.b.a(flVar.m339a()));
                    return;
                } else if (TextUtils.equals("U", flVar.m341b())) {
                    dx.k a9 = dx.k.a(flVar.m339a());
                    df.a(this.a).a(a9.a(), a9.b(), new Date(a9.a()), new Date(a9.b()), a9.c() * 1024, a9.e());
                    fl flVar2 = new fl();
                    flVar2.a(0);
                    flVar2.a(flVar.m335a(), "UCA");
                    flVar2.a(flVar.e());
                    XMPushService xMPushService = this.a;
                    xMPushService.a(new bt(xMPushService, flVar2));
                    return;
                } else if (!TextUtils.equals("P", flVar.m341b())) {
                    return;
                } else {
                    dx.i a10 = dx.i.a(flVar.m339a());
                    fl flVar3 = new fl();
                    flVar3.a(0);
                    flVar3.a(flVar.m335a(), "PCA");
                    flVar3.a(flVar.e());
                    dx.i iVar = new dx.i();
                    if (a10.a()) {
                        iVar.a(a10.a());
                    }
                    flVar3.a(iVar.m303a(), (String) null);
                    XMPushService xMPushService2 = this.a;
                    xMPushService2.a(new bt(xMPushService2, flVar3));
                    sb = new StringBuilder();
                    sb.append("ACK msgP: id = ");
                    a = flVar.e();
                }
            } else if (!"NOTIFY".equals(flVar.m335a())) {
                return;
            } else {
                dx.h a11 = dx.h.a(flVar.m339a());
                sb = new StringBuilder();
                sb.append("notify by server err = ");
                sb.append(a11.c());
                sb.append(" desc = ");
                a = a11.a();
            }
            sb.append(a);
            str = sb.toString();
            com.xiaomi.channel.commonutils.logger.b.m89a(str);
        }
    }
}
