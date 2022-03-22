package com.xiaomi.push.service;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public XMPushService a;

    public au(XMPushService xMPushService) {
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

    private void a(fz fzVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, fzVar) == null) {
            String c2 = fzVar.c();
            if (TextUtils.isEmpty(c2)) {
                return;
            }
            String[] split = c2.split(";");
            co a = cs.a().a(fm.a(), false);
            if (a == null || split.length <= 0) {
                return;
            }
            a.a(split);
            this.a.a(20, (Exception) null);
            this.a.a(true);
        }
    }

    private void b(gc gcVar) {
        av.b a;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, gcVar) == null) {
            String l = gcVar.l();
            String k = gcVar.k();
            if (TextUtils.isEmpty(l) || TextUtils.isEmpty(k) || (a = av.a().a(k, l)) == null) {
                return;
            }
            gq.a(this.a, a.f892a, gq.a(gcVar.m387a()), true, true, System.currentTimeMillis());
        }
    }

    private void c(fa faVar) {
        av.b a;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, faVar) == null) {
            String g2 = faVar.g();
            String num = Integer.toString(faVar.a());
            if (TextUtils.isEmpty(g2) || TextUtils.isEmpty(num) || (a = av.a().a(num, g2)) == null) {
                return;
            }
            gq.a(this.a, a.f892a, faVar.c(), true, true, System.currentTimeMillis());
        }
    }

    public void a(fa faVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, faVar) == null) {
            if (5 != faVar.a()) {
                c(faVar);
            }
            try {
                b(faVar);
            } catch (Exception e2) {
                com.xiaomi.channel.commonutils.logger.b.a("handle Blob chid = " + faVar.a() + " cmd = " + faVar.m344a() + " packetid = " + faVar.e() + " failure ", e2);
            }
        }
    }

    public void a(gc gcVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gcVar) == null) {
            if (!"5".equals(gcVar.k())) {
                b(gcVar);
            }
            String k = gcVar.k();
            if (TextUtils.isEmpty(k)) {
                k = "1";
                gcVar.l("1");
            }
            if (k.equals("0")) {
                com.xiaomi.channel.commonutils.logger.b.m112a("Received wrong packet with chid = 0 : " + gcVar.m387a());
            }
            if (gcVar instanceof ga) {
                fz a = gcVar.a("kick");
                if (a != null) {
                    String l = gcVar.l();
                    String a2 = a.a("type");
                    String a3 = a.a("reason");
                    com.xiaomi.channel.commonutils.logger.b.m112a("kicked by server, chid=" + k + " res=" + av.b.a(l) + " type=" + a2 + " reason=" + a3);
                    if (!"wait".equals(a2)) {
                        this.a.a(k, l, 3, a3, a2);
                        av.a().m647a(k, l);
                        return;
                    }
                    av.b a4 = av.a().a(k, l);
                    if (a4 != null) {
                        this.a.a(a4);
                        a4.a(av.c.a, 3, 0, a3, a2);
                        return;
                    }
                    return;
                }
            } else if (gcVar instanceof gb) {
                gb gbVar = (gb) gcVar;
                if ("redir".equals(gbVar.b())) {
                    fz a5 = gbVar.a("hosts");
                    if (a5 != null) {
                        a(a5);
                        return;
                    }
                    return;
                }
            }
            this.a.b().a(this.a, k, gcVar);
        }
    }

    public void b(fa faVar) {
        StringBuilder sb;
        String a;
        String str;
        av.c cVar;
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, faVar) == null) {
            String m344a = faVar.m344a();
            if (faVar.a() != 0) {
                String num = Integer.toString(faVar.a());
                if (!"SECMSG".equals(faVar.m344a())) {
                    if (!"BIND".equals(m344a)) {
                        if ("KICK".equals(m344a)) {
                            du.g a2 = du.g.a(faVar.m348a());
                            String g2 = faVar.g();
                            String a3 = a2.a();
                            String b2 = a2.b();
                            com.xiaomi.channel.commonutils.logger.b.m112a("kicked by server, chid=" + num + " res= " + av.b.a(g2) + " type=" + a3 + " reason=" + b2);
                            if (!"wait".equals(a3)) {
                                this.a.a(num, g2, 3, b2, a3);
                                av.a().m647a(num, g2);
                                return;
                            }
                            av.b a4 = av.a().a(num, g2);
                            if (a4 != null) {
                                this.a.a(a4);
                                a4.a(av.c.a, 3, 0, b2, a3);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    du.d a5 = du.d.a(faVar.m348a());
                    String g3 = faVar.g();
                    av.b a6 = av.a().a(num, g3);
                    if (a6 == null) {
                        return;
                    }
                    if (a5.a()) {
                        com.xiaomi.channel.commonutils.logger.b.m112a("SMACK: channel bind succeeded, chid=" + faVar.a());
                        a6.a(av.c.f44557c, 1, 0, (String) null, (String) null);
                        return;
                    }
                    String a7 = a5.a();
                    if ("auth".equals(a7)) {
                        if ("invalid-sig".equals(a5.b())) {
                            com.xiaomi.channel.commonutils.logger.b.m112a("SMACK: bind error invalid-sig token = " + a6.f44547c + " sec = " + a6.f44552h);
                            gz.a(0, ew.T.a(), 1, null, 0);
                        }
                        cVar = av.c.a;
                        i = 1;
                        i2 = 5;
                    } else if (!"cancel".equals(a7)) {
                        if ("wait".equals(a7)) {
                            this.a.a(a6);
                            a6.a(av.c.a, 1, 7, a5.b(), a7);
                        }
                        str = "SMACK: channel bind failed, chid=" + num + " reason=" + a5.b();
                        com.xiaomi.channel.commonutils.logger.b.m112a(str);
                    } else {
                        cVar = av.c.a;
                        i = 1;
                        i2 = 7;
                    }
                    a6.a(cVar, i, i2, a5.b(), a7);
                    av.a().m647a(num, g3);
                    str = "SMACK: channel bind failed, chid=" + num + " reason=" + a5.b();
                    com.xiaomi.channel.commonutils.logger.b.m112a(str);
                } else if (!faVar.m347a()) {
                    this.a.b().a(this.a, num, faVar);
                    return;
                } else {
                    sb = new StringBuilder();
                    sb.append("Recv SECMSG errCode = ");
                    sb.append(faVar.b());
                    sb.append(" errStr = ");
                    a = faVar.m351c();
                }
            } else if ("PING".equals(m344a)) {
                byte[] m348a = faVar.m348a();
                if (m348a != null && m348a.length > 0) {
                    du.j a8 = du.j.a(m348a);
                    if (a8.b()) {
                        bi.a().a(a8.a());
                    }
                }
                if (!"com.xiaomi.xmsf".equals(this.a.getPackageName())) {
                    this.a.m604a();
                }
                if ("1".equals(faVar.e())) {
                    com.xiaomi.channel.commonutils.logger.b.m112a("received a server ping");
                } else {
                    gz.b();
                }
                this.a.m607b();
                return;
            } else if ("SYNC".equals(m344a)) {
                if ("CONF".equals(faVar.m350b())) {
                    bi.a().a(du.b.a(faVar.m348a()));
                    return;
                } else if (TextUtils.equals("U", faVar.m350b())) {
                    du.k a9 = du.k.a(faVar.m348a());
                    db.a(this.a).a(a9.a(), a9.b(), new Date(a9.a()), new Date(a9.b()), a9.c() * 1024, a9.e());
                    fa faVar2 = new fa();
                    faVar2.a(0);
                    faVar2.a(faVar.m344a(), "UCA");
                    faVar2.a(faVar.e());
                    XMPushService xMPushService = this.a;
                    xMPushService.a(new bg(xMPushService, faVar2));
                    return;
                } else if (!TextUtils.equals("P", faVar.m350b())) {
                    return;
                } else {
                    du.i a10 = du.i.a(faVar.m348a());
                    fa faVar3 = new fa();
                    faVar3.a(0);
                    faVar3.a(faVar.m344a(), "PCA");
                    faVar3.a(faVar.e());
                    du.i iVar = new du.i();
                    if (a10.a()) {
                        iVar.a(a10.a());
                    }
                    faVar3.a(iVar.m323a(), (String) null);
                    XMPushService xMPushService2 = this.a;
                    xMPushService2.a(new bg(xMPushService2, faVar3));
                    sb = new StringBuilder();
                    sb.append("ACK msgP: id = ");
                    a = faVar.e();
                }
            } else if (!"NOTIFY".equals(faVar.m344a())) {
                return;
            } else {
                du.h a11 = du.h.a(faVar.m348a());
                sb = new StringBuilder();
                sb.append("notify by server err = ");
                sb.append(a11.c());
                sb.append(" desc = ");
                a = a11.a();
            }
            sb.append(a);
            str = sb.toString();
            com.xiaomi.channel.commonutils.logger.b.m112a(str);
        }
    }
}
