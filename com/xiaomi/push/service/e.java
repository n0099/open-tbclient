package com.xiaomi.push.service;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.push.fa;
import com.xiaomi.push.ga;
import com.xiaomi.push.gb;
import com.xiaomi.push.gc;
import com.xiaomi.push.ge;
import com.xiaomi.push.service.av;
import java.util.Collection;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public q f72410a;

    public e() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f72410a = new q();
    }

    public static String a(av.b bVar) {
        InterceptResult invokeL;
        StringBuilder sb;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bVar)) == null) {
            if ("9".equals(bVar.f72348g)) {
                sb = new StringBuilder();
                sb.append(bVar.f916a);
                str = ".permission.MIMC_RECEIVE";
            } else {
                sb = new StringBuilder();
                sb.append(bVar.f916a);
                str = ".permission.MIPUSH_RECEIVE";
            }
            sb.append(str);
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static void a(Context context, Intent intent, av.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, context, intent, bVar) == null) {
            if ("com.xiaomi.xmsf".equals(context.getPackageName())) {
                context.sendBroadcast(intent);
            } else {
                context.sendBroadcast(intent, a(bVar));
            }
        }
    }

    public av.b a(fa faVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, faVar)) == null) {
            Collection<av.b> m604a = av.a().m604a(Integer.toString(faVar.a()));
            if (m604a.isEmpty()) {
                return null;
            }
            Iterator<av.b> it = m604a.iterator();
            if (m604a.size() == 1) {
                return it.next();
            }
            String g2 = faVar.g();
            while (it.hasNext()) {
                av.b next = it.next();
                if (TextUtils.equals(g2, next.f919b)) {
                    return next;
                }
            }
            return null;
        }
        return (av.b) invokeL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0038  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public av.b a(gc gcVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gcVar)) == null) {
            Collection<av.b> m604a = av.a().m604a(gcVar.k());
            if (m604a.isEmpty()) {
                return null;
            }
            Iterator<av.b> it = m604a.iterator();
            if (m604a.size() == 1) {
                return it.next();
            }
            String m = gcVar.m();
            String l = gcVar.l();
            while (it.hasNext()) {
                av.b next = it.next();
                if (TextUtils.equals(m, next.f919b) || TextUtils.equals(l, next.f919b)) {
                    return next;
                }
                while (it.hasNext()) {
                }
            }
            return null;
        }
        return (av.b) invokeL.objValue;
    }

    @SuppressLint({"WrongConstant"})
    public void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
            Intent intent = new Intent();
            intent.setAction("com.xiaomi.push.service_started");
            if (com.xiaomi.push.l.c()) {
                intent.addFlags(16777216);
            }
            context.sendBroadcast(intent);
        }
    }

    public void a(Context context, av.b bVar, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(1048579, this, context, bVar, i2) == null) || "5".equalsIgnoreCase(bVar.f72348g)) {
            return;
        }
        Intent intent = new Intent();
        intent.setAction("com.xiaomi.push.channel_closed");
        intent.setPackage(bVar.f916a);
        intent.putExtra(az.s, bVar.f72348g);
        intent.putExtra("ext_reason", i2);
        intent.putExtra(az.p, bVar.f919b);
        intent.putExtra(az.D, bVar.f72350i);
        if (bVar.f910a == null || !"9".equals(bVar.f72348g)) {
            a(context, intent, bVar);
            return;
        }
        try {
            bVar.f910a.send(Message.obtain(null, 17, intent));
        } catch (RemoteException unused) {
            bVar.f910a = null;
            StringBuilder sb = new StringBuilder();
            sb.append("peer may died: ");
            String str = bVar.f919b;
            sb.append(str.substring(str.lastIndexOf(64)));
            com.xiaomi.channel.commonutils.logger.b.m73a(sb.toString());
        }
    }

    public void a(Context context, av.b bVar, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048580, this, context, bVar, str, str2) == null) {
            if ("5".equalsIgnoreCase(bVar.f72348g)) {
                com.xiaomi.channel.commonutils.logger.b.d("mipush kicked by server");
                return;
            }
            Intent intent = new Intent();
            intent.setAction("com.xiaomi.push.kicked");
            intent.setPackage(bVar.f916a);
            intent.putExtra("ext_kick_type", str);
            intent.putExtra("ext_kick_reason", str2);
            intent.putExtra("ext_chid", bVar.f72348g);
            intent.putExtra(az.p, bVar.f919b);
            intent.putExtra(az.D, bVar.f72350i);
            a(context, intent, bVar);
        }
    }

    public void a(Context context, av.b bVar, boolean z, int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{context, bVar, Boolean.valueOf(z), Integer.valueOf(i2), str}) == null) {
            if ("5".equalsIgnoreCase(bVar.f72348g)) {
                this.f72410a.a(context, bVar, z, i2, str);
                return;
            }
            Intent intent = new Intent();
            intent.setAction("com.xiaomi.push.channel_opened");
            intent.setPackage(bVar.f916a);
            intent.putExtra("ext_succeeded", z);
            if (!z) {
                intent.putExtra("ext_reason", i2);
            }
            if (!TextUtils.isEmpty(str)) {
                intent.putExtra("ext_reason_msg", str);
            }
            intent.putExtra("ext_chid", bVar.f72348g);
            intent.putExtra(az.p, bVar.f919b);
            intent.putExtra(az.D, bVar.f72350i);
            a(context, intent, bVar);
        }
    }

    public void a(XMPushService xMPushService, String str, fa faVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048582, this, xMPushService, str, faVar) == null) {
            av.b a2 = a(faVar);
            if (a2 == null) {
                com.xiaomi.channel.commonutils.logger.b.d("error while notify channel closed! channel " + str + " not registered");
            } else if ("5".equalsIgnoreCase(str)) {
                this.f72410a.a(xMPushService, faVar, a2);
            } else {
                String str2 = a2.f916a;
                Intent intent = new Intent();
                intent.setAction("com.xiaomi.push.new_msg");
                intent.setPackage(str2);
                intent.putExtra("ext_chid", str);
                intent.putExtra("ext_raw_packet", faVar.m310a(a2.f72349h));
                intent.putExtra(az.D, a2.f72350i);
                intent.putExtra(az.w, a2.f72349h);
                if (a2.f910a != null) {
                    try {
                        a2.f910a.send(Message.obtain(null, 17, intent));
                        com.xiaomi.channel.commonutils.logger.b.m73a("message was sent by messenger for chid=" + str);
                        return;
                    } catch (RemoteException unused) {
                        a2.f910a = null;
                        StringBuilder sb = new StringBuilder();
                        sb.append("peer may died: ");
                        String str3 = a2.f919b;
                        sb.append(str3.substring(str3.lastIndexOf(64)));
                        com.xiaomi.channel.commonutils.logger.b.m73a(sb.toString());
                    }
                }
                if ("com.xiaomi.xmsf".equals(str2)) {
                    return;
                }
                com.xiaomi.channel.commonutils.logger.b.m73a("broadcast message to " + str2 + ", chid=" + str);
                a(xMPushService, intent, a2);
            }
        }
    }

    public void a(XMPushService xMPushService, String str, gc gcVar) {
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048583, this, xMPushService, str, gcVar) == null) {
            av.b a2 = a(gcVar);
            if (a2 != null) {
                if ("5".equalsIgnoreCase(str)) {
                    this.f72410a.a(xMPushService, gcVar, a2);
                    return;
                }
                String str4 = a2.f916a;
                if (gcVar instanceof gb) {
                    str3 = "com.xiaomi.push.new_msg";
                } else if (gcVar instanceof ga) {
                    str3 = "com.xiaomi.push.new_iq";
                } else if (gcVar instanceof ge) {
                    str3 = "com.xiaomi.push.new_pres";
                } else {
                    str2 = "unknown packet type, drop it";
                }
                Intent intent = new Intent();
                intent.setAction(str3);
                intent.setPackage(str4);
                intent.putExtra("ext_chid", str);
                intent.putExtra("ext_packet", gcVar.a());
                intent.putExtra(az.D, a2.f72350i);
                intent.putExtra(az.w, a2.f72349h);
                a(xMPushService, intent, a2);
                return;
            }
            str2 = "error while notify channel closed! channel " + str + " not registered";
            com.xiaomi.channel.commonutils.logger.b.d(str2);
        }
    }
}
