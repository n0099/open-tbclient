package com.xiaomi.push.service;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes10.dex */
public class au {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public XMPushService f78447a;

    public au(XMPushService xMPushService) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {xMPushService};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f78447a = xMPushService;
    }

    private void a(fz fzVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, fzVar) == null) {
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
            this.f78447a.a(20, (Exception) null);
            this.f78447a.a(true);
        }
    }

    private void b(gc gcVar) {
        av.b a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, gcVar) == null) {
            String l = gcVar.l();
            String k = gcVar.k();
            if (TextUtils.isEmpty(l) || TextUtils.isEmpty(k) || (a2 = av.a().a(k, l)) == null) {
                return;
            }
            gq.a(this.f78447a, a2.f915a, gq.a(gcVar.m348a()), true, true, System.currentTimeMillis());
        }
    }

    private void c(fa faVar) {
        av.b a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, faVar) == null) {
            String g2 = faVar.g();
            String num = Integer.toString(faVar.a());
            if (TextUtils.isEmpty(g2) || TextUtils.isEmpty(num) || (a2 = av.a().a(num, g2)) == null) {
                return;
            }
            gq.a(this.f78447a, a2.f915a, faVar.c(), true, true, System.currentTimeMillis());
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
                com.xiaomi.channel.commonutils.logger.b.a("handle Blob chid = " + faVar.a() + " cmd = " + faVar.m305a() + " packetid = " + faVar.e() + " failure ", e2);
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
                com.xiaomi.channel.commonutils.logger.b.m73a("Received wrong packet with chid = 0 : " + gcVar.m348a());
            }
            if (gcVar instanceof ga) {
                fz a2 = gcVar.a("kick");
                if (a2 != null) {
                    String l = gcVar.l();
                    String a3 = a2.a("type");
                    String a4 = a2.a("reason");
                    com.xiaomi.channel.commonutils.logger.b.m73a("kicked by server, chid=" + k + " res=" + av.b.a(l) + " type=" + a3 + " reason=" + a4);
                    if (!"wait".equals(a3)) {
                        this.f78447a.a(k, l, 3, a4, a3);
                        av.a().m608a(k, l);
                        return;
                    }
                    av.b a5 = av.a().a(k, l);
                    if (a5 != null) {
                        this.f78447a.a(a5);
                        a5.a(av.c.f78463a, 3, 0, a4, a3);
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
            this.f78447a.b().a(this.f78447a, k, gcVar);
        }
    }

    public void b(fa faVar) {
        StringBuilder sb;
        String a2;
        String str;
        av.c cVar;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, faVar) == null) {
            String m305a = faVar.m305a();
            if (faVar.a() != 0) {
                String num = Integer.toString(faVar.a());
                if (!"SECMSG".equals(faVar.m305a())) {
                    if (!"BIND".equals(m305a)) {
                        if ("KICK".equals(m305a)) {
                            du.g a3 = du.g.a(faVar.m309a());
                            String g2 = faVar.g();
                            String a4 = a3.a();
                            String b2 = a3.b();
                            com.xiaomi.channel.commonutils.logger.b.m73a("kicked by server, chid=" + num + " res= " + av.b.a(g2) + " type=" + a4 + " reason=" + b2);
                            if (!"wait".equals(a4)) {
                                this.f78447a.a(num, g2, 3, b2, a4);
                                av.a().m608a(num, g2);
                                return;
                            }
                            av.b a5 = av.a().a(num, g2);
                            if (a5 != null) {
                                this.f78447a.a(a5);
                                a5.a(av.c.f78463a, 3, 0, b2, a4);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    du.d a6 = du.d.a(faVar.m309a());
                    String g3 = faVar.g();
                    av.b a7 = av.a().a(num, g3);
                    if (a7 == null) {
                        return;
                    }
                    if (a6.a()) {
                        com.xiaomi.channel.commonutils.logger.b.m73a("SMACK: channel bind succeeded, chid=" + faVar.a());
                        a7.a(av.c.f78465c, 1, 0, (String) null, (String) null);
                        return;
                    }
                    String a8 = a6.a();
                    if ("auth".equals(a8)) {
                        if ("invalid-sig".equals(a6.b())) {
                            com.xiaomi.channel.commonutils.logger.b.m73a("SMACK: bind error invalid-sig token = " + a7.f78451c + " sec = " + a7.f78456h);
                            gz.a(0, ew.T.a(), 1, null, 0);
                        }
                        cVar = av.c.f78463a;
                        i2 = 1;
                        i3 = 5;
                    } else if (!QueryResponse.Options.CANCEL.equals(a8)) {
                        if ("wait".equals(a8)) {
                            this.f78447a.a(a7);
                            a7.a(av.c.f78463a, 1, 7, a6.b(), a8);
                        }
                        str = "SMACK: channel bind failed, chid=" + num + " reason=" + a6.b();
                        com.xiaomi.channel.commonutils.logger.b.m73a(str);
                    } else {
                        cVar = av.c.f78463a;
                        i2 = 1;
                        i3 = 7;
                    }
                    a7.a(cVar, i2, i3, a6.b(), a8);
                    av.a().m608a(num, g3);
                    str = "SMACK: channel bind failed, chid=" + num + " reason=" + a6.b();
                    com.xiaomi.channel.commonutils.logger.b.m73a(str);
                } else if (!faVar.m308a()) {
                    this.f78447a.b().a(this.f78447a, num, faVar);
                    return;
                } else {
                    sb = new StringBuilder();
                    sb.append("Recv SECMSG errCode = ");
                    sb.append(faVar.b());
                    sb.append(" errStr = ");
                    a2 = faVar.m312c();
                }
            } else if ("PING".equals(m305a)) {
                byte[] m309a = faVar.m309a();
                if (m309a != null && m309a.length > 0) {
                    du.j a9 = du.j.a(m309a);
                    if (a9.b()) {
                        bi.a().a(a9.a());
                    }
                }
                if (!"com.xiaomi.xmsf".equals(this.f78447a.getPackageName())) {
                    this.f78447a.m565a();
                }
                if ("1".equals(faVar.e())) {
                    com.xiaomi.channel.commonutils.logger.b.m73a("received a server ping");
                } else {
                    gz.b();
                }
                this.f78447a.m568b();
                return;
            } else if ("SYNC".equals(m305a)) {
                if ("CONF".equals(faVar.m311b())) {
                    bi.a().a(du.b.a(faVar.m309a()));
                    return;
                } else if (TextUtils.equals("U", faVar.m311b())) {
                    du.k a10 = du.k.a(faVar.m309a());
                    db.a(this.f78447a).a(a10.a(), a10.b(), new Date(a10.a()), new Date(a10.b()), a10.c() * 1024, a10.e());
                    fa faVar2 = new fa();
                    faVar2.a(0);
                    faVar2.a(faVar.m305a(), "UCA");
                    faVar2.a(faVar.e());
                    XMPushService xMPushService = this.f78447a;
                    xMPushService.a(new bg(xMPushService, faVar2));
                    return;
                } else if (!TextUtils.equals("P", faVar.m311b())) {
                    return;
                } else {
                    du.i a11 = du.i.a(faVar.m309a());
                    fa faVar3 = new fa();
                    faVar3.a(0);
                    faVar3.a(faVar.m305a(), "PCA");
                    faVar3.a(faVar.e());
                    du.i iVar = new du.i();
                    if (a11.a()) {
                        iVar.a(a11.a());
                    }
                    faVar3.a(iVar.m284a(), (String) null);
                    XMPushService xMPushService2 = this.f78447a;
                    xMPushService2.a(new bg(xMPushService2, faVar3));
                    sb = new StringBuilder();
                    sb.append("ACK msgP: id = ");
                    a2 = faVar.e();
                }
            } else if (!"NOTIFY".equals(faVar.m305a())) {
                return;
            } else {
                du.h a12 = du.h.a(faVar.m309a());
                sb = new StringBuilder();
                sb.append("notify by server err = ");
                sb.append(a12.c());
                sb.append(" desc = ");
                a2 = a12.a();
            }
            sb.append(a2);
            str = sb.toString();
            com.xiaomi.channel.commonutils.logger.b.m73a(str);
        }
    }
}
