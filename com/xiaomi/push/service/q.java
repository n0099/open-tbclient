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
import com.xiaomi.push.cy;
import com.xiaomi.push.el;
import com.xiaomi.push.fa;
import com.xiaomi.push.fw;
import com.xiaomi.push.fz;
import com.xiaomi.push.gb;
import com.xiaomi.push.gc;
import com.xiaomi.push.gq;
import com.xiaomi.push.hf;
import com.xiaomi.push.hp;
import com.xiaomi.push.hs;
import com.xiaomi.push.hv;
import com.xiaomi.push.ib;
import com.xiaomi.push.ie;
import com.xiaomi.push.ip;
import com.xiaomi.push.iq;
import com.xiaomi.push.iv;
import com.xiaomi.push.service.ac;
import com.xiaomi.push.service.av;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
/* loaded from: classes4.dex */
public class q {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public q() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static Intent a(byte[] bArr, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65537, null, bArr, j2)) == null) {
            ib a = a(bArr);
            if (a == null) {
                return null;
            }
            Intent intent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
            intent.putExtra("mipush_payload", bArr);
            intent.putExtra("mrt", Long.toString(j2));
            intent.setPackage(a.f643b);
            return intent;
        }
        return (Intent) invokeLJ.objValue;
    }

    public static ib a(Context context, ib ibVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, ibVar)) == null) {
            hv hvVar = new hv();
            hvVar.b(ibVar.m503a());
            hs m502a = ibVar.m502a();
            if (m502a != null) {
                hvVar.a(m502a.m459a());
                hvVar.a(m502a.m457a());
                if (!TextUtils.isEmpty(m502a.m464b())) {
                    hvVar.c(m502a.m464b());
                }
            }
            hvVar.a(ip.a(context, ibVar));
            ib a = y.a(ibVar.b(), ibVar.m503a(), hvVar, hf.f63553f);
            hs m458a = ibVar.m502a().m458a();
            m458a.a("mat", Long.toString(System.currentTimeMillis()));
            a.a(m458a);
            return a;
        }
        return (ib) invokeLL.objValue;
    }

    public static ib a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bArr)) == null) {
            ib ibVar = new ib();
            try {
                ip.a(ibVar, bArr);
                return ibVar;
            } catch (Throwable th) {
                com.xiaomi.channel.commonutils.logger.b.a(th);
                return null;
            }
        }
        return (ib) invokeL.objValue;
    }

    public static void a(XMPushService xMPushService, ib ibVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, xMPushService, ibVar) == null) {
            xMPushService.a(new r(4, xMPushService, ibVar));
        }
    }

    public static void a(XMPushService xMPushService, ib ibVar, ie ieVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65541, null, xMPushService, ibVar, ieVar) == null) {
            xMPushService.a(new x(4, ieVar, ibVar, xMPushService));
        }
    }

    public static void a(XMPushService xMPushService, ib ibVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65542, null, xMPushService, ibVar, str) == null) {
            xMPushService.a(new v(4, xMPushService, ibVar, str));
        }
    }

    public static void a(XMPushService xMPushService, ib ibVar, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65543, null, xMPushService, ibVar, str, str2) == null) {
            xMPushService.a(new w(4, xMPushService, ibVar, str, str2));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:147:0x0415  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x042f  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0458  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x03f7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(XMPushService xMPushService, String str, byte[] bArr, Intent intent) {
        boolean z;
        ie ieVar;
        String str2;
        int i2;
        el a;
        String b2;
        String m459a;
        int i3;
        String str3;
        String str4;
        el a2;
        String b3;
        String b4;
        String m459a2;
        String str5;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65544, null, xMPushService, str, bArr, intent) == null) {
            ib a3 = a(bArr);
            hs m502a = a3.m502a();
            iq iqVar = null;
            String str6 = null;
            if (bArr != null) {
                cy.a(a3.b(), xMPushService.getApplicationContext(), null, a3.a(), bArr.length);
            }
            if (c(a3) && a(xMPushService, str)) {
                if (ac.e(a3)) {
                    el.a(xMPushService.getApplicationContext()).a(a3.b(), ac.b(a3), m502a.m459a(), "5");
                }
                c(xMPushService, a3);
            } else if (a(a3) && !a(xMPushService, str) && !b(a3)) {
                if (ac.e(a3)) {
                    el.a(xMPushService.getApplicationContext()).a(a3.b(), ac.b(a3), m502a.m459a(), "6");
                }
                d(xMPushService, a3);
            } else if ((!ac.m627a(a3) || !com.xiaomi.push.g.m394b((Context) xMPushService, a3.f643b)) && !a(xMPushService, intent)) {
                if (!com.xiaomi.push.g.m394b((Context) xMPushService, a3.f643b)) {
                    if (ac.e(a3)) {
                        el.a(xMPushService.getApplicationContext()).b(a3.b(), ac.b(a3), m502a.m459a(), "2");
                    }
                    a(xMPushService, a3);
                    return;
                }
                com.xiaomi.channel.commonutils.logger.b.m122a("receive a mipush message, we can see the app, but we can't see the receiver.");
                if (ac.e(a3)) {
                    el.a(xMPushService.getApplicationContext()).b(a3.b(), ac.b(a3), m502a.m459a(), "3");
                }
            } else {
                boolean z3 = false;
                if (hf.a == a3.a()) {
                    String b5 = a3.b();
                    SharedPreferences.Editor edit = xMPushService.getSharedPreferences("pref_registered_pkg_names", 0).edit();
                    edit.putString(b5, a3.f639a);
                    edit.commit();
                    n.a(xMPushService).e(b5);
                    n.a(xMPushService).f(b5);
                    el.a(xMPushService.getApplicationContext()).a(b5, "E100003", m502a.m459a(), w0.g3, null);
                    if (!TextUtils.isEmpty(m502a.m459a())) {
                        intent.putExtra(MiPushMessage.KEY_MESSAGE_ID, m502a.m459a());
                        intent.putExtra("eventMessageType", 6000);
                    }
                }
                if (ac.c(a3)) {
                    el.a(xMPushService.getApplicationContext()).a(a3.b(), ac.b(a3), m502a.m459a(), 1001, System.currentTimeMillis(), null);
                    if (!TextUtils.isEmpty(m502a.m459a())) {
                        intent.putExtra(MiPushMessage.KEY_MESSAGE_ID, m502a.m459a());
                        intent.putExtra("eventMessageType", 1000);
                    }
                }
                if (ac.m631b(a3)) {
                    el.a(xMPushService.getApplicationContext()).a(a3.b(), ac.b(a3), m502a.m459a(), 2001, System.currentTimeMillis(), null);
                    if (!TextUtils.isEmpty(m502a.m459a())) {
                        intent.putExtra(MiPushMessage.KEY_MESSAGE_ID, m502a.m459a());
                        intent.putExtra("eventMessageType", 2000);
                    }
                }
                if (ac.m627a(a3)) {
                    el.a(xMPushService.getApplicationContext()).a(a3.b(), ac.b(a3), m502a.m459a(), 3001, System.currentTimeMillis(), null);
                    if (!TextUtils.isEmpty(m502a.m459a())) {
                        intent.putExtra(MiPushMessage.KEY_MESSAGE_ID, m502a.m459a());
                        intent.putExtra("eventMessageType", 3000);
                    }
                }
                if (m502a != null && !TextUtils.isEmpty(m502a.m467c()) && !TextUtils.isEmpty(m502a.d()) && m502a.f551b != 1 && (ac.m628a(m502a.m460a()) || !ac.m626a((Context) xMPushService, a3.f643b))) {
                    if (m502a != null) {
                        Map<String, String> map = m502a.f549a;
                        str6 = map != null ? map.get("jobkey") : null;
                        if (TextUtils.isEmpty(str6)) {
                            str6 = m502a.m459a();
                        }
                        z2 = af.a(xMPushService, a3.f643b, str6);
                    } else {
                        z2 = false;
                    }
                    if (z2) {
                        el a4 = el.a(xMPushService.getApplicationContext());
                        String b6 = a3.b();
                        String b7 = ac.b(a3);
                        String m459a3 = m502a.m459a();
                        a4.c(b6, b7, m459a3, "1:" + str6);
                        com.xiaomi.channel.commonutils.logger.b.m122a("drop a duplicate message, key=" + str6);
                    } else {
                        ac.c m622a = ac.m622a((Context) xMPushService, a3, bArr);
                        if (m622a.a > 0 && !TextUtils.isEmpty(m622a.f883a)) {
                            gq.a(xMPushService, m622a.f883a, m622a.a, true, false, System.currentTimeMillis());
                        }
                        if (!ac.m627a(a3) && com.xiaomi.push.g.m392a(xMPushService.getApplicationContext(), str)) {
                            Intent intent2 = new Intent("com.xiaomi.mipush.MESSAGE_ARRIVED");
                            intent2.putExtra("mipush_payload", bArr);
                            intent2.setPackage(a3.f643b);
                            try {
                                List<ResolveInfo> queryBroadcastReceivers = xMPushService.getPackageManager().queryBroadcastReceivers(intent2, 0);
                                if (queryBroadcastReceivers != null && !queryBroadcastReceivers.isEmpty()) {
                                    com.xiaomi.channel.commonutils.logger.b.m122a("broadcast message arrived.");
                                    xMPushService.sendBroadcast(intent2, y.a(a3.f643b));
                                }
                            } catch (Exception unused) {
                                el.a(xMPushService.getApplicationContext()).b(a3.b(), ac.b(a3), m502a.m459a(), "1");
                            }
                        }
                    }
                    b(xMPushService, a3);
                } else if ("com.xiaomi.xmsf".contains(a3.f643b) && !a3.m510b() && m502a != null && m502a.m460a() != null && m502a.m460a().containsKey("ab")) {
                    b(xMPushService, a3);
                    com.xiaomi.channel.commonutils.logger.b.c("receive abtest message. ack it." + m502a.m459a());
                } else if (a(xMPushService, str, a3, m502a)) {
                    if (m502a != null && !TextUtils.isEmpty(m502a.m459a())) {
                        if (ac.m631b(a3)) {
                            a = el.a(xMPushService.getApplicationContext());
                            b2 = a3.b();
                            str4 = ac.b(a3);
                            m459a = m502a.m459a();
                            i3 = 2002;
                            str3 = null;
                        } else {
                            if (ac.m627a(a3)) {
                                a2 = el.a(xMPushService.getApplicationContext());
                                b3 = a3.b();
                                b4 = ac.b(a3);
                                m459a2 = m502a.m459a();
                                str5 = "7";
                            } else if (ac.c(a3)) {
                                a2 = el.a(xMPushService.getApplicationContext());
                                b3 = a3.b();
                                b4 = ac.b(a3);
                                m459a2 = m502a.m459a();
                                str5 = "8";
                            } else if (ac.d(a3)) {
                                a = el.a(xMPushService.getApplicationContext());
                                b2 = a3.b();
                                m459a = m502a.m459a();
                                i3 = w0.h3;
                                str3 = null;
                                str4 = "E100003";
                            }
                            a2.a(b3, b4, m459a2, str5);
                        }
                        a.a(b2, str4, m459a, i3, str3);
                    }
                    if (hf.f63556i == a3.f636a) {
                        try {
                            iqVar = bp.a(xMPushService, a3);
                        } catch (iv e2) {
                            com.xiaomi.channel.commonutils.logger.b.d("receive a message which action string is not valid. " + e2);
                        }
                        if (iqVar == null) {
                            com.xiaomi.channel.commonutils.logger.b.d("receiving an un-recognized notification message. " + a3.f636a);
                            z = false;
                            if (z && (iqVar instanceof ie)) {
                                ieVar = (ie) iqVar;
                                if (hp.C.f514a.equals(ieVar.f660d) && ieVar.m518a() != null) {
                                    str2 = ieVar.m518a().get(az.K);
                                    i2 = -2;
                                    if (!TextUtils.isEmpty(str2)) {
                                        try {
                                            i2 = Integer.parseInt(str2);
                                        } catch (NumberFormatException e3) {
                                            com.xiaomi.channel.commonutils.logger.b.m122a("parse notifyId from STRING to INT failed: " + e3);
                                        }
                                    }
                                    if (i2 < -1) {
                                        com.xiaomi.channel.commonutils.logger.b.m122a("try to retract a message by notifyId=" + i2);
                                        ac.a(xMPushService, a3.f643b, i2);
                                    } else {
                                        com.xiaomi.channel.commonutils.logger.b.m122a("try to retract a message by title&description.");
                                        ac.a(xMPushService, a3.f643b, ieVar.m518a().get(az.I), ieVar.m518a().get(az.J));
                                    }
                                    a(xMPushService, a3, ieVar);
                                    if (z3) {
                                        com.xiaomi.channel.commonutils.logger.b.m122a("broadcast passthrough message.");
                                        xMPushService.sendBroadcast(intent, y.a(a3.f643b));
                                    }
                                }
                            }
                        } else {
                            z = true;
                            if (z) {
                                ieVar = (ie) iqVar;
                                if (hp.C.f514a.equals(ieVar.f660d)) {
                                    str2 = ieVar.m518a().get(az.K);
                                    i2 = -2;
                                    if (!TextUtils.isEmpty(str2)) {
                                    }
                                    if (i2 < -1) {
                                    }
                                    a(xMPushService, a3, ieVar);
                                    if (z3) {
                                    }
                                }
                            }
                        }
                    }
                    z3 = true;
                    if (z3) {
                    }
                } else {
                    el.a(xMPushService.getApplicationContext()).a(a3.b(), ac.b(a3), m502a.m459a(), "9");
                }
                if (a3.a() != hf.f63549b || "com.xiaomi.xmsf".equals(xMPushService.getPackageName())) {
                    return;
                }
                xMPushService.stopSelf();
            }
        }
    }

    public static void a(XMPushService xMPushService, byte[] bArr, long j2) {
        ib a;
        Map<String, String> m460a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65545, null, new Object[]{xMPushService, bArr, Long.valueOf(j2)}) == null) || (a = a(bArr)) == null) {
            return;
        }
        if (TextUtils.isEmpty(a.f643b)) {
            com.xiaomi.channel.commonutils.logger.b.m122a("receive a mipush message without package name");
            return;
        }
        Long valueOf = Long.valueOf(System.currentTimeMillis());
        Intent a2 = a(bArr, valueOf.longValue());
        String a3 = ac.a(a);
        gq.a(xMPushService, a3, j2, true, true, System.currentTimeMillis());
        hs m502a = a.m502a();
        if (m502a != null && m502a.m459a() != null) {
            com.xiaomi.channel.commonutils.logger.b.e(String.format("receive a message. appid=%1$s, msgid= %2$s, action=%3$s", a.m503a(), m502a.m459a(), a.a()));
        }
        if (m502a != null) {
            m502a.a("mrt", Long.toString(valueOf.longValue()));
        }
        String str = "";
        if (hf.f63552e == a.a() && n.a(xMPushService).m685a(a.f643b) && !ac.m627a(a)) {
            if (m502a != null) {
                str = m502a.m459a();
                if (ac.e(a)) {
                    el.a(xMPushService.getApplicationContext()).a(a.b(), ac.b(a), str, "1");
                }
            }
            com.xiaomi.channel.commonutils.logger.b.m122a("Drop a message for unregistered, msgid=" + str);
            a(xMPushService, a, a.f643b);
        } else if (hf.f63552e == a.a() && n.a(xMPushService).m687c(a.f643b) && !ac.m627a(a)) {
            if (m502a != null) {
                str = m502a.m459a();
                if (ac.e(a)) {
                    el.a(xMPushService.getApplicationContext()).a(a.b(), ac.b(a), str, "2");
                }
            }
            com.xiaomi.channel.commonutils.logger.b.m122a("Drop a message for push closed, msgid=" + str);
            a(xMPushService, a, a.f643b);
        } else if (hf.f63552e == a.a() && !TextUtils.equals(xMPushService.getPackageName(), "com.xiaomi.xmsf") && !TextUtils.equals(xMPushService.getPackageName(), a.f643b)) {
            com.xiaomi.channel.commonutils.logger.b.m122a("Receive a message with wrong package name, expect " + xMPushService.getPackageName() + ", received " + a.f643b);
            a(xMPushService, a, "unmatched_package", "package should be " + xMPushService.getPackageName() + ", but got " + a.f643b);
            if (m502a == null || !ac.e(a)) {
                return;
            }
            el.a(xMPushService.getApplicationContext()).a(a.b(), ac.b(a), m502a.m459a(), "3");
        } else if (m502a != null && (m460a = m502a.m460a()) != null && m460a.containsKey("hide") && "true".equalsIgnoreCase(m460a.get("hide"))) {
            b(xMPushService, a);
        } else {
            if (m502a != null && m502a.m460a() != null && m502a.m460a().containsKey("__miid")) {
                String str2 = m502a.m460a().get("__miid");
                String a4 = com.xiaomi.push.t.a(xMPushService.getApplicationContext());
                if (TextUtils.isEmpty(a4) || !TextUtils.equals(str2, a4)) {
                    if (ac.e(a)) {
                        el.a(xMPushService.getApplicationContext()).a(a.b(), ac.b(a), m502a.m459a(), "4");
                    }
                    com.xiaomi.channel.commonutils.logger.b.m122a(str2 + " should be login, but got " + a4);
                    a(xMPushService, a, "miid already logout or anther already login", str2 + " should be login, but got " + a4);
                    return;
                }
            }
            a(xMPushService, a3, bArr, a2);
        }
    }

    public static boolean a(Context context, Intent intent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, context, intent)) == null) {
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
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, null, context, str)) == null) {
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
            } catch (Exception e2) {
                com.xiaomi.channel.commonutils.logger.b.a(e2);
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public static boolean a(ib ibVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65548, null, ibVar)) == null) ? "com.xiaomi.xmsf".equals(ibVar.f643b) && ibVar.m502a() != null && ibVar.m502a().m460a() != null && ibVar.m502a().m460a().containsKey("miui_package_name") : invokeL.booleanValue;
    }

    public static boolean a(XMPushService xMPushService, String str, ib ibVar, hs hsVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65549, null, xMPushService, str, ibVar, hsVar)) == null) {
            boolean z = true;
            if (hsVar != null && hsVar.m460a() != null && hsVar.m460a().containsKey("__check_alive") && hsVar.m460a().containsKey("__awake")) {
                ie ieVar = new ie();
                ieVar.b(ibVar.m503a());
                ieVar.d(str);
                ieVar.c(hp.H.f514a);
                ieVar.a(hsVar.m459a());
                ieVar.f655a = new HashMap();
                boolean m392a = com.xiaomi.push.g.m392a(xMPushService.getApplicationContext(), str);
                ieVar.f655a.put("app_running", Boolean.toString(m392a));
                if (!m392a) {
                    boolean parseBoolean = Boolean.parseBoolean(hsVar.m460a().get("__awake"));
                    ieVar.f655a.put("awaked", Boolean.toString(parseBoolean));
                    if (!parseBoolean) {
                        z = false;
                    }
                }
                try {
                    y.a(xMPushService, y.a(ibVar.b(), ibVar.m503a(), ieVar, hf.f63556i));
                } catch (fw e2) {
                    com.xiaomi.channel.commonutils.logger.b.a(e2);
                }
            }
            return z;
        }
        return invokeLLLL.booleanValue;
    }

    public static void b(XMPushService xMPushService, ib ibVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65550, null, xMPushService, ibVar) == null) {
            xMPushService.a(new s(4, xMPushService, ibVar));
        }
    }

    public static boolean b(ib ibVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, ibVar)) == null) {
            Map<String, String> m460a = ibVar.m502a().m460a();
            return m460a != null && m460a.containsKey("notify_effect");
        }
        return invokeL.booleanValue;
    }

    public static void c(XMPushService xMPushService, ib ibVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65552, null, xMPushService, ibVar) == null) {
            xMPushService.a(new t(4, xMPushService, ibVar));
        }
    }

    public static boolean c(ib ibVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, ibVar)) == null) {
            if (ibVar.m502a() == null || ibVar.m502a().m460a() == null) {
                return false;
            }
            return "1".equals(ibVar.m502a().m460a().get("obslete_ads_message"));
        }
        return invokeL.booleanValue;
    }

    public static void d(XMPushService xMPushService, ib ibVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65554, null, xMPushService, ibVar) == null) {
            xMPushService.a(new u(4, xMPushService, ibVar));
        }
    }

    public void a(Context context, av.b bVar, boolean z, int i2, String str) {
        l a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{context, bVar, Boolean.valueOf(z), Integer.valueOf(i2), str}) == null) || z || (a = m.a(context)) == null || !"token-expired".equals(str)) {
            return;
        }
        try {
            m.a(context, a.f63864f, a.f63862d, a.f63863e);
        } catch (IOException | JSONException e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
        }
    }

    public void a(XMPushService xMPushService, fa faVar, av.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, xMPushService, faVar, bVar) == null) {
            try {
                a(xMPushService, faVar.m359a(bVar.f63827h), faVar.c());
            } catch (IllegalArgumentException e2) {
                com.xiaomi.channel.commonutils.logger.b.a(e2);
            }
        }
    }

    public void a(XMPushService xMPushService, gc gcVar, av.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, xMPushService, gcVar, bVar) == null) {
            if (!(gcVar instanceof gb)) {
                com.xiaomi.channel.commonutils.logger.b.m122a("not a mipush message");
                return;
            }
            gb gbVar = (gb) gcVar;
            fz a = gbVar.a("s");
            if (a != null) {
                try {
                    a(xMPushService, be.a(be.a(bVar.f63827h, gbVar.j()), a.c()), gq.a(gcVar.m397a()));
                } catch (IllegalArgumentException e2) {
                    com.xiaomi.channel.commonutils.logger.b.a(e2);
                }
            }
        }
    }
}
