package com.xiaomi.push.service;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.push.fl;
import com.xiaomi.push.gl;
import com.xiaomi.push.gm;
import com.xiaomi.push.gn;
import com.xiaomi.push.gp;
import com.xiaomi.push.hi;
import com.xiaomi.push.service.bg;
import java.util.Collection;
import java.util.Iterator;
/* loaded from: classes8.dex */
public class j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public y a;

    public j() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new y();
    }

    public static String a(bg.b bVar) {
        InterceptResult invokeL;
        StringBuilder sb;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bVar)) == null) {
            if ("9".equals(bVar.g)) {
                sb = new StringBuilder();
                sb.append(bVar.f957a);
                str = ".permission.MIMC_RECEIVE";
            } else {
                sb = new StringBuilder();
                sb.append(bVar.f957a);
                str = ".permission.MIPUSH_RECEIVE";
            }
            sb.append(str);
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static void a(Context context, Intent intent, bg.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, context, intent, bVar) == null) {
            if ("com.xiaomi.xmsf".equals(context.getPackageName())) {
                context.sendBroadcast(intent);
            } else {
                context.sendBroadcast(intent, a(bVar));
            }
        }
    }

    public bg.b a(fl flVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, flVar)) == null) {
            Collection<bg.b> m647a = bg.a().m647a(Integer.toString(flVar.a()));
            if (m647a.isEmpty()) {
                return null;
            }
            Iterator<bg.b> it = m647a.iterator();
            if (m647a.size() == 1) {
                return it.next();
            }
            String g = flVar.g();
            while (it.hasNext()) {
                bg.b next = it.next();
                if (TextUtils.equals(g, next.f960b)) {
                    return next;
                }
            }
            return null;
        }
        return (bg.b) invokeL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0038  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public bg.b a(gn gnVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gnVar)) == null) {
            Collection<bg.b> m647a = bg.a().m647a(gnVar.k());
            if (m647a.isEmpty()) {
                return null;
            }
            Iterator<bg.b> it = m647a.iterator();
            if (m647a.size() == 1) {
                return it.next();
            }
            String m = gnVar.m();
            String l = gnVar.l();
            while (it.hasNext()) {
                bg.b next = it.next();
                if (TextUtils.equals(m, next.f960b) || TextUtils.equals(l, next.f960b)) {
                    return next;
                }
                while (it.hasNext()) {
                }
            }
            return null;
        }
        return (bg.b) invokeL.objValue;
    }

    @SuppressLint({"WrongConstant"})
    public void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
            Intent intent = new Intent();
            intent.setAction("com.xiaomi.push.service_started");
            if (com.xiaomi.push.m.m575c()) {
                intent.addFlags(16777216);
            }
            com.xiaomi.channel.commonutils.logger.b.m99a("[Bcst] send ***.push.service_started broadcast to inform push service has started.");
            context.sendBroadcast(intent);
        }
    }

    @SuppressLint({"DefaultLocale"})
    public void a(Context context, bg.b bVar, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(1048579, this, context, bVar, i) == null) || "5".equalsIgnoreCase(bVar.g)) {
            return;
        }
        Intent intent = new Intent();
        intent.setAction("com.xiaomi.push.channel_closed");
        intent.setPackage(bVar.f957a);
        intent.putExtra(bk.t, bVar.g);
        intent.putExtra("ext_reason", i);
        intent.putExtra(bk.q, bVar.f960b);
        intent.putExtra(bk.F, bVar.i);
        if (bVar.f951a == null || !"9".equals(bVar.g)) {
            com.xiaomi.channel.commonutils.logger.b.m99a(String.format("[Bcst] notify channel closed. %s,%s,%d", bVar.g, bVar.f957a, Integer.valueOf(i)));
            a(context, intent, bVar);
            return;
        }
        try {
            bVar.f951a.send(Message.obtain(null, 17, intent));
        } catch (RemoteException unused) {
            bVar.f951a = null;
            StringBuilder sb = new StringBuilder();
            sb.append("peer may died: ");
            String str = bVar.f960b;
            sb.append(str.substring(str.lastIndexOf(64)));
            com.xiaomi.channel.commonutils.logger.b.m99a(sb.toString());
        }
    }

    public void a(Context context, bg.b bVar, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048580, this, context, bVar, str, str2) == null) {
            if (bVar == null) {
                com.xiaomi.channel.commonutils.logger.b.d("error while notify kick by server!");
            } else if ("5".equalsIgnoreCase(bVar.g)) {
                com.xiaomi.channel.commonutils.logger.b.d("mipush kicked by server");
            } else {
                Intent intent = new Intent();
                intent.setAction("com.xiaomi.push.kicked");
                intent.setPackage(bVar.f957a);
                intent.putExtra("ext_kick_type", str);
                intent.putExtra("ext_kick_reason", str2);
                intent.putExtra("ext_chid", bVar.g);
                intent.putExtra(bk.q, bVar.f960b);
                intent.putExtra(bk.F, bVar.i);
                com.xiaomi.channel.commonutils.logger.b.m99a(String.format("[Bcst] notify packet(blob) arrival. %s,%s,%s", bVar.g, bVar.f957a, str2));
                a(context, intent, bVar);
            }
        }
    }

    @SuppressLint({"DefaultLocale"})
    public void a(Context context, bg.b bVar, boolean z, int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{context, bVar, Boolean.valueOf(z), Integer.valueOf(i), str}) == null) {
            if ("5".equalsIgnoreCase(bVar.g)) {
                this.a.a(context, bVar, z, i, str);
                return;
            }
            Intent intent = new Intent();
            intent.setAction("com.xiaomi.push.channel_opened");
            intent.setPackage(bVar.f957a);
            intent.putExtra("ext_succeeded", z);
            if (!z) {
                intent.putExtra("ext_reason", i);
            }
            if (!TextUtils.isEmpty(str)) {
                intent.putExtra("ext_reason_msg", str);
            }
            intent.putExtra("ext_chid", bVar.g);
            intent.putExtra(bk.q, bVar.f960b);
            intent.putExtra(bk.F, bVar.i);
            com.xiaomi.channel.commonutils.logger.b.m99a(String.format("[Bcst] notify channel open result. %s,%s,%b,%d", bVar.g, bVar.f957a, Boolean.valueOf(z), Integer.valueOf(i)));
            a(context, intent, bVar);
        }
    }

    public void a(XMPushService xMPushService, String str, fl flVar) {
        ao aoVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048582, this, xMPushService, str, flVar) == null) {
            bg.b a = a(flVar);
            if (a == null) {
                com.xiaomi.channel.commonutils.logger.b.d("error while notify channel closed! channel " + str + " not registered");
            } else if ("5".equalsIgnoreCase(str)) {
                this.a.a(xMPushService, flVar, a);
            } else {
                String str2 = a.f957a;
                Intent intent = new Intent();
                intent.setAction("com.xiaomi.push.new_msg");
                intent.setPackage(str2);
                intent.putExtra("ext_rcv_timestamp", SystemClock.elapsedRealtime());
                intent.putExtra("ext_chid", str);
                intent.putExtra("ext_raw_packet", flVar.m350a(a.h));
                intent.putExtra(bk.F, a.i);
                intent.putExtra(bk.x, a.h);
                if (a.f951a != null) {
                    try {
                        a.f951a.send(Message.obtain(null, 17, intent));
                        com.xiaomi.channel.commonutils.logger.b.m99a("message was sent by messenger for chid=" + str);
                        return;
                    } catch (RemoteException unused) {
                        a.f951a = null;
                        StringBuilder sb = new StringBuilder();
                        sb.append("peer may died: ");
                        String str3 = a.f960b;
                        sb.append(str3.substring(str3.lastIndexOf(64)));
                        com.xiaomi.channel.commonutils.logger.b.m99a(sb.toString());
                    }
                }
                if ("com.xiaomi.xmsf".equals(str2)) {
                    return;
                }
                com.xiaomi.channel.commonutils.logger.b.m99a(String.format("[Bcst] notify packet(blob) arrival. %s,%s,%s", a.g, a.f957a, flVar.e()));
                a(xMPushService, intent, a);
                if (!"10".equals(str) || (aoVar = flVar.f396a) == null) {
                    return;
                }
                aoVar.d = System.currentTimeMillis();
                if (hi.a(xMPushService, 1)) {
                    bz.a("category_coord_down", "coord_down", "com.xiaomi.xmsf", flVar.f396a);
                }
            }
        }
    }

    public void a(XMPushService xMPushService, String str, gn gnVar) {
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048583, this, xMPushService, str, gnVar) == null) {
            bg.b a = a(gnVar);
            if (a != null) {
                if ("5".equalsIgnoreCase(str)) {
                    this.a.a(xMPushService, gnVar, a);
                    return;
                }
                String str4 = a.f957a;
                if (gnVar instanceof gm) {
                    str3 = "com.xiaomi.push.new_msg";
                } else if (gnVar instanceof gl) {
                    str3 = "com.xiaomi.push.new_iq";
                } else if (gnVar instanceof gp) {
                    str3 = "com.xiaomi.push.new_pres";
                } else {
                    str2 = "unknown packet type, drop it";
                }
                Intent intent = new Intent();
                intent.setAction(str3);
                intent.setPackage(str4);
                intent.putExtra("ext_chid", str);
                intent.putExtra("ext_packet", gnVar.a());
                intent.putExtra(bk.F, a.i);
                intent.putExtra(bk.x, a.h);
                com.xiaomi.channel.commonutils.logger.b.m99a(String.format("[Bcst] notify packet arrival. %s,%s,%s", a.g, a.f957a, gnVar.j()));
                a(xMPushService, intent, a);
                return;
            }
            str2 = "error while notify channel closed! channel " + str + " not registered";
            com.xiaomi.channel.commonutils.logger.b.d(str2);
        }
    }
}
