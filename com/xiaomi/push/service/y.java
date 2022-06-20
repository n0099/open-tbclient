package com.xiaomi.push.service;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.weapon.un.w0;
import com.xiaomi.mipush.sdk.MiPushMessage;
import com.xiaomi.push.Cif;
import com.xiaomi.push.db;
import com.xiaomi.push.eo;
import com.xiaomi.push.fl;
import com.xiaomi.push.gh;
import com.xiaomi.push.gk;
import com.xiaomi.push.gm;
import com.xiaomi.push.gn;
import com.xiaomi.push.hb;
import com.xiaomi.push.hj;
import com.xiaomi.push.ht;
import com.xiaomi.push.hw;
import com.xiaomi.push.hz;
import com.xiaomi.push.ii;
import com.xiaomi.push.ik;
import com.xiaomi.push.it;
import com.xiaomi.push.iu;
import com.xiaomi.push.iz;
import com.xiaomi.push.service.al;
import com.xiaomi.push.service.bg;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes8.dex */
public class y {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public y() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static Intent a(byte[] bArr, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65537, null, bArr, j)) == null) {
            Cif a = a(bArr);
            if (a == null) {
                return null;
            }
            Intent intent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
            intent.putExtra("mipush_payload", bArr);
            intent.putExtra("mrt", Long.toString(j));
            intent.setPackage(a.f625b);
            return intent;
        }
        return (Intent) invokeLJ.objValue;
    }

    public static Cif a(Context context, Cif cif) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, cif)) == null) ? a(context, cif, (Map<String, String>) null) : (Cif) invokeLL.objValue;
    }

    public static Cif a(Context context, Cif cif, Map<String, String> map) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, context, cif, map)) == null) {
            hz hzVar = new hz();
            hzVar.b(cif.m461a());
            hw m460a = cif.m460a();
            if (m460a != null) {
                hzVar.a(m460a.m426a());
                hzVar.a(m460a.m424a());
                if (!TextUtils.isEmpty(m460a.m431b())) {
                    hzVar.c(m460a.m431b());
                }
            }
            hzVar.a(it.a(context, cif));
            Cif a = ah.a(cif.b(), cif.m461a(), hzVar, hj.f);
            hw m460a2 = cif.m460a();
            if (m460a2 != null) {
                m460a2 = br.a(m460a2.m425a());
            }
            m460a2.a("mat", Long.toString(System.currentTimeMillis()));
            if (map != null) {
                try {
                    if (map.size() > 0) {
                        for (String str : map.keySet()) {
                            m460a2.a(str, map.get(str));
                        }
                    }
                } catch (Throwable unused) {
                }
            }
            a.a(m460a2);
            return a;
        }
        return (Cif) invokeLLL.objValue;
    }

    public static Cif a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, bArr)) == null) {
            Cif cif = new Cif();
            try {
                it.a(cif, bArr);
                return cif;
            } catch (Throwable th) {
                com.xiaomi.channel.commonutils.logger.b.a(th);
                return null;
            }
        }
        return (Cif) invokeL.objValue;
    }

    public static void a(Context context, Cif cif, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65541, null, context, cif, bArr) == null) {
            try {
                al.a(cif);
                cif.m460a();
                al.c m600a = al.m600a(context, cif, bArr);
                if (m600a.a > 0 && !TextUtils.isEmpty(m600a.f888a)) {
                    hb.a(context, m600a.f888a, m600a.a, true, false, System.currentTimeMillis());
                }
                if (!com.xiaomi.push.m.m556a(context) || !ag.a(context, cif, m600a.f889a)) {
                    b(context, cif, bArr);
                    return;
                }
                ag.m595a(context, cif);
                com.xiaomi.channel.commonutils.logger.b.m84a("consume this broadcast by tts");
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.m84a("notify push msg error " + e);
                e.printStackTrace();
            }
        }
    }

    public static void a(XMPushService xMPushService, Cif cif) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, xMPushService, cif) == null) {
            xMPushService.a(new z(4, xMPushService, cif));
        }
    }

    public static void a(XMPushService xMPushService, Cif cif, ii iiVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65543, null, xMPushService, cif, iiVar) == null) {
            xMPushService.a(new af(4, iiVar, cif, xMPushService));
        }
    }

    public static void a(XMPushService xMPushService, Cif cif, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65544, null, xMPushService, cif, str) == null) {
            xMPushService.a(new ad(4, xMPushService, cif, str));
        }
    }

    public static void a(XMPushService xMPushService, Cif cif, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65545, null, xMPushService, cif, str, str2) == null) {
            xMPushService.a(new ae(4, xMPushService, cif, str, str2));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:140:0x03cb  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x03e5  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x042f  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x03ad A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(XMPushService xMPushService, String str, byte[] bArr, Intent intent) {
        boolean z;
        ii iiVar;
        String str2;
        int i;
        eo a;
        String b;
        String m426a;
        int i2;
        String str3;
        String str4;
        eo a2;
        String b2;
        String b3;
        String m426a2;
        String str5;
        String str6;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65546, null, xMPushService, str, bArr, intent) == null) {
            Cif a3 = a(bArr);
            hw m460a = a3.m460a();
            iu iuVar = null;
            String str7 = null;
            if (bArr != null) {
                db.a(a3.b(), xMPushService.getApplicationContext(), null, a3.a(), bArr.length);
            }
            if (c(a3) && a(xMPushService, str)) {
                if (al.e(a3)) {
                    eo.a(xMPushService.getApplicationContext()).a(a3.b(), al.b(a3), m460a.m426a(), "5");
                }
                c(xMPushService, a3);
            } else if (a(a3) && !a(xMPushService, str) && !b(a3)) {
                if (al.e(a3)) {
                    eo.a(xMPushService.getApplicationContext()).a(a3.b(), al.b(a3), m460a.m426a(), "6");
                }
                d(xMPushService, a3);
            } else if ((!al.m604a(a3) || !com.xiaomi.push.h.m383b((Context) xMPushService, a3.f625b)) && !a(xMPushService, intent)) {
                if (!com.xiaomi.push.h.m383b((Context) xMPushService, a3.f625b)) {
                    if (al.e(a3)) {
                        eo.a(xMPushService.getApplicationContext()).b(a3.b(), al.b(a3), m460a.m426a(), "2");
                    }
                    a(xMPushService, a3);
                    return;
                }
                com.xiaomi.channel.commonutils.logger.b.m84a("receive a mipush message, we can see the app, but we can't see the receiver.");
                if (al.e(a3)) {
                    eo.a(xMPushService.getApplicationContext()).b(a3.b(), al.b(a3), m460a.m426a(), "3");
                }
            } else {
                boolean z2 = false;
                if (hj.a == a3.a()) {
                    String b4 = a3.b();
                    SharedPreferences.Editor edit = xMPushService.getSharedPreferences("pref_registered_pkg_names", 0).edit();
                    edit.putString(b4, a3.f621a);
                    edit.commit();
                    ik a4 = n.a(a3);
                    if (a4.a() != 0 || TextUtils.isEmpty(a4.b())) {
                        com.xiaomi.channel.commonutils.logger.b.d("read regSecret failed");
                    } else {
                        n.a(xMPushService, b4, a4.b());
                    }
                    v.a(xMPushService).e(b4);
                    v.a(xMPushService).f(b4);
                    eo.a(xMPushService.getApplicationContext()).a(b4, "E100003", m460a.m426a(), w0.g3, null);
                    if (!TextUtils.isEmpty(m460a.m426a())) {
                        intent.putExtra(MiPushMessage.KEY_MESSAGE_ID, m460a.m426a());
                        intent.putExtra("eventMessageType", 6000);
                    }
                }
                if (al.c(a3)) {
                    eo.a(xMPushService.getApplicationContext()).a(a3.b(), al.b(a3), m460a.m426a(), 1001, System.currentTimeMillis(), null);
                    if (!TextUtils.isEmpty(m460a.m426a())) {
                        intent.putExtra(MiPushMessage.KEY_MESSAGE_ID, m460a.m426a());
                        intent.putExtra("eventMessageType", 1000);
                    }
                }
                if (al.m608b(a3)) {
                    eo.a(xMPushService.getApplicationContext()).a(a3.b(), al.b(a3), m460a.m426a(), 2001, System.currentTimeMillis(), null);
                    if (!TextUtils.isEmpty(m460a.m426a())) {
                        intent.putExtra(MiPushMessage.KEY_MESSAGE_ID, m460a.m426a());
                        intent.putExtra("eventMessageType", 2000);
                    }
                }
                if (al.m604a(a3)) {
                    eo.a(xMPushService.getApplicationContext()).a(a3.b(), al.b(a3), m460a.m426a(), 3001, System.currentTimeMillis(), null);
                    if (!TextUtils.isEmpty(m460a.m426a())) {
                        intent.putExtra(MiPushMessage.KEY_MESSAGE_ID, m460a.m426a());
                        intent.putExtra("eventMessageType", 3000);
                    }
                }
                if (m460a != null && !TextUtils.isEmpty(m460a.m434c()) && !TextUtils.isEmpty(m460a.d()) && m460a.f535b != 1 && !al.m603a((Context) xMPushService, a3.f625b, al.m605a(m460a.m427a()))) {
                    if (m460a != null) {
                        Map<String, String> map = m460a.f533a;
                        str7 = map != null ? map.get("jobkey") : null;
                        if (TextUtils.isEmpty(str7)) {
                            str7 = m460a.m426a();
                        }
                        z2 = an.a(xMPushService, a3.f625b, str7);
                    }
                    if (z2) {
                        eo.a(xMPushService.getApplicationContext()).c(a3.b(), al.b(a3), m460a.m426a(), "1:" + str7);
                        str6 = "drop a duplicate message, key=" + str7;
                    } else if (com.xiaomi.push.m.m556a((Context) xMPushService) && ag.m596a(a3)) {
                        str6 = "receive pull down message";
                    } else {
                        a(xMPushService, a3, bArr);
                        b(xMPushService, a3);
                    }
                    com.xiaomi.channel.commonutils.logger.b.m84a(str6);
                    b(xMPushService, a3);
                } else if ("com.xiaomi.xmsf".contains(a3.f625b) && !a3.m468b() && m460a != null && m460a.m427a() != null && m460a.m427a().containsKey("ab")) {
                    b(xMPushService, a3);
                    com.xiaomi.channel.commonutils.logger.b.c("receive abtest message. ack it." + m460a.m426a());
                } else if (a(xMPushService, str, a3, m460a)) {
                    if (m460a != null && !TextUtils.isEmpty(m460a.m426a())) {
                        if (al.m608b(a3)) {
                            a = eo.a(xMPushService.getApplicationContext());
                            b = a3.b();
                            str4 = al.b(a3);
                            m426a = m460a.m426a();
                            i2 = 2002;
                            str3 = null;
                        } else {
                            if (al.m604a(a3)) {
                                a2 = eo.a(xMPushService.getApplicationContext());
                                b2 = a3.b();
                                b3 = al.b(a3);
                                m426a2 = m460a.m426a();
                                str5 = "7";
                            } else if (al.c(a3)) {
                                a2 = eo.a(xMPushService.getApplicationContext());
                                b2 = a3.b();
                                b3 = al.b(a3);
                                m426a2 = m460a.m426a();
                                str5 = "8";
                            } else if (al.d(a3)) {
                                a = eo.a(xMPushService.getApplicationContext());
                                b = a3.b();
                                m426a = m460a.m426a();
                                i2 = w0.h3;
                                str3 = null;
                                str4 = "E100003";
                            }
                            a2.a(b2, b3, m426a2, str5);
                        }
                        a.a(b, str4, m426a, i2, str3);
                    }
                    if (hj.i == a3.f618a) {
                        try {
                            iuVar = ce.a(xMPushService, a3);
                        } catch (iz e) {
                            com.xiaomi.channel.commonutils.logger.b.d("receive a message which action string is not valid. " + e);
                        }
                        if (iuVar == null) {
                            com.xiaomi.channel.commonutils.logger.b.d("receiving an un-recognized notification message. " + a3.f618a);
                            z = false;
                            if (z && (iuVar instanceof ii)) {
                                iiVar = (ii) iuVar;
                                if (ht.C.f498a.equals(iiVar.f642d) && iiVar.m476a() != null) {
                                    str2 = iiVar.m476a().get(bk.M);
                                    i = -2;
                                    if (!TextUtils.isEmpty(str2)) {
                                        try {
                                            i = Integer.parseInt(str2);
                                        } catch (NumberFormatException e2) {
                                            com.xiaomi.channel.commonutils.logger.b.m84a("parse notifyId from STRING to INT failed: " + e2);
                                        }
                                    }
                                    if (i < -1) {
                                        com.xiaomi.channel.commonutils.logger.b.m84a("try to retract a message by notifyId=" + i);
                                        al.a(xMPushService, a3.f625b, i);
                                    } else {
                                        com.xiaomi.channel.commonutils.logger.b.m84a("try to retract a message by title&description.");
                                        al.a(xMPushService, a3.f625b, iiVar.m476a().get(bk.K), iiVar.m476a().get(bk.L));
                                    }
                                    if (m460a != null && m460a.m427a() != null && com.xiaomi.push.m.m556a((Context) xMPushService) && "pulldown".equals(ay.a((Object) m460a.m427a()))) {
                                        ag.a(a3);
                                    }
                                    a(xMPushService, a3, iiVar);
                                    if (z2) {
                                        com.xiaomi.channel.commonutils.logger.b.m84a("broadcast passthrough message.");
                                        xMPushService.sendBroadcast(intent, ah.a(a3.f625b));
                                    }
                                }
                            }
                        } else {
                            z = true;
                            if (z) {
                                iiVar = (ii) iuVar;
                                if (ht.C.f498a.equals(iiVar.f642d)) {
                                    str2 = iiVar.m476a().get(bk.M);
                                    i = -2;
                                    if (!TextUtils.isEmpty(str2)) {
                                    }
                                    if (i < -1) {
                                    }
                                    if (m460a != null) {
                                        ag.a(a3);
                                    }
                                    a(xMPushService, a3, iiVar);
                                    if (z2) {
                                    }
                                }
                            }
                        }
                    }
                    z2 = true;
                    if (z2) {
                    }
                } else {
                    eo.a(xMPushService.getApplicationContext()).a(a3.b(), al.b(a3), m460a.m426a(), "9");
                }
                if (a3.a() != hj.b || "com.xiaomi.xmsf".equals(xMPushService.getPackageName())) {
                    return;
                }
                xMPushService.stopSelf();
            }
        }
    }

    public static void a(XMPushService xMPushService, byte[] bArr, long j) {
        Cif a;
        Map<String, String> m427a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65547, null, new Object[]{xMPushService, bArr, Long.valueOf(j)}) == null) || (a = a(bArr)) == null) {
            return;
        }
        if (TextUtils.isEmpty(a.f625b)) {
            com.xiaomi.channel.commonutils.logger.b.m84a("receive a mipush message without package name");
            return;
        }
        Long valueOf = Long.valueOf(System.currentTimeMillis());
        Intent a2 = a(bArr, valueOf.longValue());
        String a3 = al.a(a);
        hb.a(xMPushService, a3, j, true, true, System.currentTimeMillis());
        hw m460a = a.m460a();
        if (m460a != null && m460a.m426a() != null) {
            com.xiaomi.channel.commonutils.logger.b.e(String.format("receive a message. appid=%1$s, msgid= %2$s, action=%3$s", a.m461a(), m460a.m426a(), a.a()));
        }
        if (m460a != null) {
            m460a.a("mrt", Long.toString(valueOf.longValue()));
        }
        String str = "";
        if (hj.e == a.a() && v.a(xMPushService).m679a(a.f625b) && !al.m604a(a)) {
            if (m460a != null) {
                str = m460a.m426a();
                if (al.e(a)) {
                    eo.a(xMPushService.getApplicationContext()).a(a.b(), al.b(a), str, "1");
                }
            }
            com.xiaomi.channel.commonutils.logger.b.m84a("Drop a message for unregistered, msgid=" + str);
            a(xMPushService, a, a.f625b);
        } else if (hj.e == a.a() && v.a(xMPushService).m681c(a.f625b) && !al.m604a(a)) {
            if (m460a != null) {
                str = m460a.m426a();
                if (al.e(a)) {
                    eo.a(xMPushService.getApplicationContext()).a(a.b(), al.b(a), str, "2");
                }
            }
            com.xiaomi.channel.commonutils.logger.b.m84a("Drop a message for push closed, msgid=" + str);
            a(xMPushService, a, a.f625b);
        } else if (hj.e == a.a() && !TextUtils.equals(xMPushService.getPackageName(), "com.xiaomi.xmsf") && !TextUtils.equals(xMPushService.getPackageName(), a.f625b)) {
            com.xiaomi.channel.commonutils.logger.b.m84a("Receive a message with wrong package name, expect " + xMPushService.getPackageName() + ", received " + a.f625b);
            a(xMPushService, a, "unmatched_package", "package should be " + xMPushService.getPackageName() + ", but got " + a.f625b);
            if (m460a == null || !al.e(a)) {
                return;
            }
            eo.a(xMPushService.getApplicationContext()).a(a.b(), al.b(a), m460a.m426a(), "3");
        } else if (hj.e != a.a() || com.xiaomi.push.j.a() != 999 || !com.xiaomi.push.j.a(xMPushService, a3)) {
            if (m460a == null || (m427a = m460a.m427a()) == null || !m427a.containsKey("hide") || !"true".equalsIgnoreCase(m427a.get("hide"))) {
                a(xMPushService, a3, bArr, a2);
            } else {
                b(xMPushService, a);
            }
        } else {
            com.xiaomi.channel.commonutils.logger.b.m84a("Receive the uninstalled dual app message");
            try {
                ah.a(xMPushService, ah.a(a3, a.m461a()));
                com.xiaomi.channel.commonutils.logger.b.m84a("uninstall " + a3 + " msg sent");
            } catch (gh e) {
                com.xiaomi.channel.commonutils.logger.b.d("Fail to send Message: " + e.getMessage());
                xMPushService.a(10, e);
            }
            al.m601a((Context) xMPushService, a3);
        }
    }

    public static boolean a(Context context, Intent intent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65548, null, context, intent)) == null) {
            try {
                List<ResolveInfo> queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 32);
                if (queryBroadcastReceivers != null) {
                    if (!queryBroadcastReceivers.isEmpty()) {
                        return true;
                    }
                }
                return false;
            } catch (Exception unused) {
                return true;
            }
        }
        return invokeLL.booleanValue;
    }

    public static boolean a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65549, null, context, str)) == null) {
            Intent intent = new Intent("com.xiaomi.mipush.miui.CLICK_MESSAGE");
            intent.setPackage(str);
            Intent intent2 = new Intent("com.xiaomi.mipush.miui.RECEIVE_MESSAGE");
            intent2.setPackage(str);
            PackageManager packageManager = context.getPackageManager();
            try {
                List<ResolveInfo> queryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent2, 32);
                List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 32);
                if (queryBroadcastReceivers.isEmpty()) {
                    if (queryIntentServices.isEmpty()) {
                        return false;
                    }
                }
                return true;
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public static boolean a(Context context, String str, byte[] bArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65550, null, context, str, bArr)) == null) {
            if (com.xiaomi.push.h.m381a(context, str)) {
                Intent intent = new Intent("com.xiaomi.mipush.MESSAGE_ARRIVED");
                intent.putExtra("mipush_payload", bArr);
                intent.setPackage(str);
                try {
                    if (context.getPackageManager().queryBroadcastReceivers(intent, 0).isEmpty()) {
                        return false;
                    }
                    com.xiaomi.channel.commonutils.logger.b.m84a("broadcast message arrived.");
                    context.sendBroadcast(intent, ah.a(str));
                    return true;
                } catch (Exception e) {
                    com.xiaomi.channel.commonutils.logger.b.m84a("meet error when broadcast message arrived. " + e);
                    return false;
                }
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public static boolean a(Cif cif) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65551, null, cif)) == null) ? "com.xiaomi.xmsf".equals(cif.f625b) && cif.m460a() != null && cif.m460a().m427a() != null && cif.m460a().m427a().containsKey("miui_package_name") : invokeL.booleanValue;
    }

    public static boolean a(XMPushService xMPushService, String str, Cif cif, hw hwVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65552, null, xMPushService, str, cif, hwVar)) == null) {
            boolean z = true;
            if (hwVar != null && hwVar.m427a() != null && hwVar.m427a().containsKey("__check_alive") && hwVar.m427a().containsKey("__awake")) {
                ii iiVar = new ii();
                iiVar.b(cif.m461a());
                iiVar.d(str);
                iiVar.c(ht.H.f498a);
                iiVar.a(hwVar.m426a());
                iiVar.f637a = new HashMap();
                boolean m381a = com.xiaomi.push.h.m381a(xMPushService.getApplicationContext(), str);
                iiVar.f637a.put("app_running", Boolean.toString(m381a));
                if (!m381a) {
                    boolean parseBoolean = Boolean.parseBoolean(hwVar.m427a().get("__awake"));
                    iiVar.f637a.put("awaked", Boolean.toString(parseBoolean));
                    if (!parseBoolean) {
                        z = false;
                    }
                }
                try {
                    ah.a(xMPushService, ah.a(cif.b(), cif.m461a(), iiVar, hj.i));
                } catch (gh e) {
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                }
            }
            return z;
        }
        return invokeLLLL.booleanValue;
    }

    public static void b(Context context, Cif cif, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65553, null, context, cif, bArr) == null) || al.m604a(cif)) {
            return;
        }
        String a = al.a(cif);
        if (TextUtils.isEmpty(a) || a(context, a, bArr)) {
            return;
        }
        eo.a(context).b(a, al.b(cif), cif.m460a().m426a(), "1");
    }

    public static void b(XMPushService xMPushService, Cif cif) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65554, null, xMPushService, cif) == null) {
            xMPushService.a(new aa(4, xMPushService, cif));
        }
    }

    public static boolean b(Cif cif) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, cif)) == null) {
            Map<String, String> m427a = cif.m460a().m427a();
            return m427a != null && m427a.containsKey("notify_effect");
        }
        return invokeL.booleanValue;
    }

    public static void c(XMPushService xMPushService, Cif cif) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65556, null, xMPushService, cif) == null) {
            xMPushService.a(new ab(4, xMPushService, cif));
        }
    }

    public static boolean c(Cif cif) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, null, cif)) == null) {
            if (cif.m460a() == null || cif.m460a().m427a() == null) {
                return false;
            }
            return "1".equals(cif.m460a().m427a().get("obslete_ads_message"));
        }
        return invokeL.booleanValue;
    }

    public static void d(XMPushService xMPushService, Cif cif) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65558, null, xMPushService, cif) == null) {
            xMPushService.a(new ac(4, xMPushService, cif));
        }
    }

    public void a(Context context, bg.b bVar, boolean z, int i, String str) {
        t m675a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{context, bVar, Boolean.valueOf(z), Integer.valueOf(i), str}) == null) || z || (m675a = u.m675a(context)) == null || !"token-expired".equals(str)) {
            return;
        }
        u.a(context, m675a.f, m675a.d, m675a.e);
    }

    public void a(XMPushService xMPushService, fl flVar, bg.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, xMPushService, flVar, bVar) == null) {
            try {
                a(xMPushService, flVar.m335a(bVar.h), flVar.c());
            } catch (IllegalArgumentException e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
            }
        }
    }

    public void a(XMPushService xMPushService, gn gnVar, bg.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, xMPushService, gnVar, bVar) == null) {
            if (!(gnVar instanceof gm)) {
                com.xiaomi.channel.commonutils.logger.b.m84a("not a mipush message");
                return;
            }
            gm gmVar = (gm) gnVar;
            gk a = gmVar.a("s");
            if (a != null) {
                try {
                    a(xMPushService, bp.a(bp.a(bVar.h, gmVar.j()), a.c()), hb.a(gnVar.m366a()));
                } catch (IllegalArgumentException e) {
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                }
            }
        }
    }
}
