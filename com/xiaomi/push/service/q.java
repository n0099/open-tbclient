package com.xiaomi.push.service;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes10.dex */
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
            ib a2 = a(bArr);
            if (a2 == null) {
                return null;
            }
            Intent intent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
            intent.putExtra("mipush_payload", bArr);
            intent.putExtra("mrt", Long.toString(j2));
            intent.setPackage(a2.f642b);
            return intent;
        }
        return (Intent) invokeLJ.objValue;
    }

    public static ib a(Context context, ib ibVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, ibVar)) == null) {
            hv hvVar = new hv();
            hvVar.b(ibVar.m454a());
            hs m453a = ibVar.m453a();
            if (m453a != null) {
                hvVar.a(m453a.m410a());
                hvVar.a(m453a.m408a());
                if (!TextUtils.isEmpty(m453a.m415b())) {
                    hvVar.c(m453a.m415b());
                }
            }
            hvVar.a(ip.a(context, ibVar));
            ib a2 = y.a(ibVar.b(), ibVar.m454a(), hvVar, hf.f77767f);
            hs m409a = ibVar.m453a().m409a();
            m409a.a("mat", Long.toString(System.currentTimeMillis()));
            a2.a(m409a);
            return a2;
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
        if (interceptable == null || interceptable.invokeLLL(AdIconUtil.AD_TEXT_ID, null, xMPushService, ibVar, ieVar) == null) {
            xMPushService.a(new x(4, ieVar, ibVar, xMPushService));
        }
    }

    public static void a(XMPushService xMPushService, ib ibVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(AdIconUtil.BAIDU_LOGO_ID, null, xMPushService, ibVar, str) == null) {
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
        el a2;
        String b2;
        String m410a;
        int i3;
        String str3;
        String str4;
        el a3;
        String b3;
        String b4;
        String m410a2;
        String str5;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65544, null, xMPushService, str, bArr, intent) == null) {
            ib a4 = a(bArr);
            hs m453a = a4.m453a();
            iq iqVar = null;
            String str6 = null;
            if (bArr != null) {
                cy.a(a4.b(), xMPushService.getApplicationContext(), null, a4.a(), bArr.length);
            }
            if (c(a4) && a(xMPushService, str)) {
                if (ac.e(a4)) {
                    el.a(xMPushService.getApplicationContext()).a(a4.b(), ac.b(a4), m453a.m410a(), "5");
                }
                c(xMPushService, a4);
            } else if (a(a4) && !a(xMPushService, str) && !b(a4)) {
                if (ac.e(a4)) {
                    el.a(xMPushService.getApplicationContext()).a(a4.b(), ac.b(a4), m453a.m410a(), "6");
                }
                d(xMPushService, a4);
            } else if ((!ac.m578a(a4) || !com.xiaomi.push.g.m345b((Context) xMPushService, a4.f642b)) && !a(xMPushService, intent)) {
                if (!com.xiaomi.push.g.m345b((Context) xMPushService, a4.f642b)) {
                    if (ac.e(a4)) {
                        el.a(xMPushService.getApplicationContext()).b(a4.b(), ac.b(a4), m453a.m410a(), "2");
                    }
                    a(xMPushService, a4);
                    return;
                }
                com.xiaomi.channel.commonutils.logger.b.m73a("receive a mipush message, we can see the app, but we can't see the receiver.");
                if (ac.e(a4)) {
                    el.a(xMPushService.getApplicationContext()).b(a4.b(), ac.b(a4), m453a.m410a(), "3");
                }
            } else {
                boolean z3 = false;
                if (hf.f77762a == a4.a()) {
                    String b5 = a4.b();
                    SharedPreferences.Editor edit = xMPushService.getSharedPreferences("pref_registered_pkg_names", 0).edit();
                    edit.putString(b5, a4.f638a);
                    edit.commit();
                    n.a(xMPushService).e(b5);
                    n.a(xMPushService).f(b5);
                    el.a(xMPushService.getApplicationContext()).a(b5, "E100003", m453a.m410a(), 6003, null);
                    if (!TextUtils.isEmpty(m453a.m410a())) {
                        intent.putExtra(MiPushMessage.KEY_MESSAGE_ID, m453a.m410a());
                        intent.putExtra("eventMessageType", 6000);
                    }
                }
                if (ac.c(a4)) {
                    el.a(xMPushService.getApplicationContext()).a(a4.b(), ac.b(a4), m453a.m410a(), 1001, System.currentTimeMillis(), null);
                    if (!TextUtils.isEmpty(m453a.m410a())) {
                        intent.putExtra(MiPushMessage.KEY_MESSAGE_ID, m453a.m410a());
                        intent.putExtra("eventMessageType", 1000);
                    }
                }
                if (ac.m582b(a4)) {
                    el.a(xMPushService.getApplicationContext()).a(a4.b(), ac.b(a4), m453a.m410a(), 2001, System.currentTimeMillis(), null);
                    if (!TextUtils.isEmpty(m453a.m410a())) {
                        intent.putExtra(MiPushMessage.KEY_MESSAGE_ID, m453a.m410a());
                        intent.putExtra("eventMessageType", 2000);
                    }
                }
                if (ac.m578a(a4)) {
                    el.a(xMPushService.getApplicationContext()).a(a4.b(), ac.b(a4), m453a.m410a(), 3001, System.currentTimeMillis(), null);
                    if (!TextUtils.isEmpty(m453a.m410a())) {
                        intent.putExtra(MiPushMessage.KEY_MESSAGE_ID, m453a.m410a());
                        intent.putExtra("eventMessageType", 3000);
                    }
                }
                if (m453a != null && !TextUtils.isEmpty(m453a.m418c()) && !TextUtils.isEmpty(m453a.d()) && m453a.f550b != 1 && (ac.m579a(m453a.m411a()) || !ac.m577a((Context) xMPushService, a4.f642b))) {
                    if (m453a != null) {
                        Map<String, String> map = m453a.f548a;
                        str6 = map != null ? map.get("jobkey") : null;
                        if (TextUtils.isEmpty(str6)) {
                            str6 = m453a.m410a();
                        }
                        z2 = af.a(xMPushService, a4.f642b, str6);
                    } else {
                        z2 = false;
                    }
                    if (z2) {
                        el a5 = el.a(xMPushService.getApplicationContext());
                        String b6 = a4.b();
                        String b7 = ac.b(a4);
                        String m410a3 = m453a.m410a();
                        a5.c(b6, b7, m410a3, "1:" + str6);
                        com.xiaomi.channel.commonutils.logger.b.m73a("drop a duplicate message, key=" + str6);
                    } else {
                        ac.c m573a = ac.m573a((Context) xMPushService, a4, bArr);
                        if (m573a.f78106a > 0 && !TextUtils.isEmpty(m573a.f882a)) {
                            gq.a(xMPushService, m573a.f882a, m573a.f78106a, true, false, System.currentTimeMillis());
                        }
                        if (!ac.m578a(a4) && com.xiaomi.push.g.m343a(xMPushService.getApplicationContext(), str)) {
                            Intent intent2 = new Intent("com.xiaomi.mipush.MESSAGE_ARRIVED");
                            intent2.putExtra("mipush_payload", bArr);
                            intent2.setPackage(a4.f642b);
                            try {
                                List<ResolveInfo> queryBroadcastReceivers = xMPushService.getPackageManager().queryBroadcastReceivers(intent2, 0);
                                if (queryBroadcastReceivers != null && !queryBroadcastReceivers.isEmpty()) {
                                    com.xiaomi.channel.commonutils.logger.b.m73a("broadcast message arrived.");
                                    xMPushService.sendBroadcast(intent2, y.a(a4.f642b));
                                }
                            } catch (Exception unused) {
                                el.a(xMPushService.getApplicationContext()).b(a4.b(), ac.b(a4), m453a.m410a(), "1");
                            }
                        }
                    }
                    b(xMPushService, a4);
                } else if ("com.xiaomi.xmsf".contains(a4.f642b) && !a4.m461b() && m453a != null && m453a.m411a() != null && m453a.m411a().containsKey("ab")) {
                    b(xMPushService, a4);
                    com.xiaomi.channel.commonutils.logger.b.c("receive abtest message. ack it." + m453a.m410a());
                } else if (a(xMPushService, str, a4, m453a)) {
                    if (m453a != null && !TextUtils.isEmpty(m453a.m410a())) {
                        if (ac.m582b(a4)) {
                            a2 = el.a(xMPushService.getApplicationContext());
                            b2 = a4.b();
                            str4 = ac.b(a4);
                            m410a = m453a.m410a();
                            i3 = 2002;
                            str3 = null;
                        } else {
                            if (ac.m578a(a4)) {
                                a3 = el.a(xMPushService.getApplicationContext());
                                b3 = a4.b();
                                b4 = ac.b(a4);
                                m410a2 = m453a.m410a();
                                str5 = "7";
                            } else if (ac.c(a4)) {
                                a3 = el.a(xMPushService.getApplicationContext());
                                b3 = a4.b();
                                b4 = ac.b(a4);
                                m410a2 = m453a.m410a();
                                str5 = "8";
                            } else if (ac.d(a4)) {
                                a2 = el.a(xMPushService.getApplicationContext());
                                b2 = a4.b();
                                m410a = m453a.m410a();
                                i3 = 6004;
                                str3 = null;
                                str4 = "E100003";
                            }
                            a3.a(b3, b4, m410a2, str5);
                        }
                        a2.a(b2, str4, m410a, i3, str3);
                    }
                    if (hf.f77770i == a4.f635a) {
                        try {
                            iqVar = bp.a(xMPushService, a4);
                        } catch (iv e2) {
                            com.xiaomi.channel.commonutils.logger.b.d("receive a message which action string is not valid. " + e2);
                        }
                        if (iqVar == null) {
                            com.xiaomi.channel.commonutils.logger.b.d("receiving an un-recognized notification message. " + a4.f635a);
                            z = false;
                            if (z && (iqVar instanceof ie)) {
                                ieVar = (ie) iqVar;
                                if (hp.C.f513a.equals(ieVar.f659d) && ieVar.m469a() != null) {
                                    str2 = ieVar.m469a().get(az.K);
                                    i2 = -2;
                                    if (!TextUtils.isEmpty(str2)) {
                                        try {
                                            i2 = Integer.parseInt(str2);
                                        } catch (NumberFormatException e3) {
                                            com.xiaomi.channel.commonutils.logger.b.m73a("parse notifyId from STRING to INT failed: " + e3);
                                        }
                                    }
                                    if (i2 < -1) {
                                        com.xiaomi.channel.commonutils.logger.b.m73a("try to retract a message by notifyId=" + i2);
                                        ac.a(xMPushService, a4.f642b, i2);
                                    } else {
                                        com.xiaomi.channel.commonutils.logger.b.m73a("try to retract a message by title&description.");
                                        ac.a(xMPushService, a4.f642b, ieVar.m469a().get(az.I), ieVar.m469a().get(az.J));
                                    }
                                    a(xMPushService, a4, ieVar);
                                    if (z3) {
                                        com.xiaomi.channel.commonutils.logger.b.m73a("broadcast passthrough message.");
                                        xMPushService.sendBroadcast(intent, y.a(a4.f642b));
                                    }
                                }
                            }
                        } else {
                            z = true;
                            if (z) {
                                ieVar = (ie) iqVar;
                                if (hp.C.f513a.equals(ieVar.f659d)) {
                                    str2 = ieVar.m469a().get(az.K);
                                    i2 = -2;
                                    if (!TextUtils.isEmpty(str2)) {
                                    }
                                    if (i2 < -1) {
                                    }
                                    a(xMPushService, a4, ieVar);
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
                    el.a(xMPushService.getApplicationContext()).a(a4.b(), ac.b(a4), m453a.m410a(), "9");
                }
                if (a4.a() != hf.f77763b || "com.xiaomi.xmsf".equals(xMPushService.getPackageName())) {
                    return;
                }
                xMPushService.stopSelf();
            }
        }
    }

    public static void a(XMPushService xMPushService, byte[] bArr, long j2) {
        ib a2;
        Map<String, String> m411a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65545, null, new Object[]{xMPushService, bArr, Long.valueOf(j2)}) == null) || (a2 = a(bArr)) == null) {
            return;
        }
        if (TextUtils.isEmpty(a2.f642b)) {
            com.xiaomi.channel.commonutils.logger.b.m73a("receive a mipush message without package name");
            return;
        }
        Long valueOf = Long.valueOf(System.currentTimeMillis());
        Intent a3 = a(bArr, valueOf.longValue());
        String a4 = ac.a(a2);
        gq.a(xMPushService, a4, j2, true, true, System.currentTimeMillis());
        hs m453a = a2.m453a();
        if (m453a != null && m453a.m410a() != null) {
            com.xiaomi.channel.commonutils.logger.b.e(String.format("receive a message. appid=%1$s, msgid= %2$s, action=%3$s", a2.m454a(), m453a.m410a(), a2.a()));
        }
        if (m453a != null) {
            m453a.a("mrt", Long.toString(valueOf.longValue()));
        }
        String str = "";
        if (hf.f77766e == a2.a() && n.a(xMPushService).m636a(a2.f642b) && !ac.m578a(a2)) {
            if (m453a != null) {
                str = m453a.m410a();
                if (ac.e(a2)) {
                    el.a(xMPushService.getApplicationContext()).a(a2.b(), ac.b(a2), str, "1");
                }
            }
            com.xiaomi.channel.commonutils.logger.b.m73a("Drop a message for unregistered, msgid=" + str);
            a(xMPushService, a2, a2.f642b);
        } else if (hf.f77766e == a2.a() && n.a(xMPushService).m638c(a2.f642b) && !ac.m578a(a2)) {
            if (m453a != null) {
                str = m453a.m410a();
                if (ac.e(a2)) {
                    el.a(xMPushService.getApplicationContext()).a(a2.b(), ac.b(a2), str, "2");
                }
            }
            com.xiaomi.channel.commonutils.logger.b.m73a("Drop a message for push closed, msgid=" + str);
            a(xMPushService, a2, a2.f642b);
        } else if (hf.f77766e == a2.a() && !TextUtils.equals(xMPushService.getPackageName(), "com.xiaomi.xmsf") && !TextUtils.equals(xMPushService.getPackageName(), a2.f642b)) {
            com.xiaomi.channel.commonutils.logger.b.m73a("Receive a message with wrong package name, expect " + xMPushService.getPackageName() + ", received " + a2.f642b);
            a(xMPushService, a2, "unmatched_package", "package should be " + xMPushService.getPackageName() + ", but got " + a2.f642b);
            if (m453a == null || !ac.e(a2)) {
                return;
            }
            el.a(xMPushService.getApplicationContext()).a(a2.b(), ac.b(a2), m453a.m410a(), "3");
        } else if (m453a != null && (m411a = m453a.m411a()) != null && m411a.containsKey("hide") && "true".equalsIgnoreCase(m411a.get("hide"))) {
            b(xMPushService, a2);
        } else {
            if (m453a != null && m453a.m411a() != null && m453a.m411a().containsKey("__miid")) {
                String str2 = m453a.m411a().get("__miid");
                String a5 = com.xiaomi.push.t.a(xMPushService.getApplicationContext());
                if (TextUtils.isEmpty(a5) || !TextUtils.equals(str2, a5)) {
                    if (ac.e(a2)) {
                        el.a(xMPushService.getApplicationContext()).a(a2.b(), ac.b(a2), m453a.m410a(), "4");
                    }
                    com.xiaomi.channel.commonutils.logger.b.m73a(str2 + " should be login, but got " + a5);
                    a(xMPushService, a2, "miid already logout or anther already login", str2 + " should be login, but got " + a5);
                    return;
                }
            }
            a(xMPushService, a4, bArr, a3);
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
        return (interceptable == null || (invokeL = interceptable.invokeL(65548, null, ibVar)) == null) ? "com.xiaomi.xmsf".equals(ibVar.f642b) && ibVar.m453a() != null && ibVar.m453a().m411a() != null && ibVar.m453a().m411a().containsKey("miui_package_name") : invokeL.booleanValue;
    }

    public static boolean a(XMPushService xMPushService, String str, ib ibVar, hs hsVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65549, null, xMPushService, str, ibVar, hsVar)) == null) {
            boolean z = true;
            if (hsVar != null && hsVar.m411a() != null && hsVar.m411a().containsKey("__check_alive") && hsVar.m411a().containsKey("__awake")) {
                ie ieVar = new ie();
                ieVar.b(ibVar.m454a());
                ieVar.d(str);
                ieVar.c(hp.H.f513a);
                ieVar.a(hsVar.m410a());
                ieVar.f654a = new HashMap();
                boolean m343a = com.xiaomi.push.g.m343a(xMPushService.getApplicationContext(), str);
                ieVar.f654a.put("app_running", Boolean.toString(m343a));
                if (!m343a) {
                    boolean parseBoolean = Boolean.parseBoolean(hsVar.m411a().get("__awake"));
                    ieVar.f654a.put("awaked", Boolean.toString(parseBoolean));
                    if (!parseBoolean) {
                        z = false;
                    }
                }
                try {
                    y.a(xMPushService, y.a(ibVar.b(), ibVar.m454a(), ieVar, hf.f77770i));
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
            Map<String, String> m411a = ibVar.m453a().m411a();
            return m411a != null && m411a.containsKey("notify_effect");
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
            if (ibVar.m453a() == null || ibVar.m453a().m411a() == null) {
                return false;
            }
            return "1".equals(ibVar.m453a().m411a().get("obslete_ads_message"));
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
        l a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{context, bVar, Boolean.valueOf(z), Integer.valueOf(i2), str}) == null) || z || (a2 = m.a(context)) == null || !"token-expired".equals(str)) {
            return;
        }
        try {
            m.a(context, a2.f78221f, a2.f78219d, a2.f78220e);
        } catch (IOException | JSONException e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
        }
    }

    public void a(XMPushService xMPushService, fa faVar, av.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, xMPushService, faVar, bVar) == null) {
            try {
                a(xMPushService, faVar.m310a(bVar.f78137h), faVar.c());
            } catch (IllegalArgumentException e2) {
                com.xiaomi.channel.commonutils.logger.b.a(e2);
            }
        }
    }

    public void a(XMPushService xMPushService, gc gcVar, av.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, xMPushService, gcVar, bVar) == null) {
            if (!(gcVar instanceof gb)) {
                com.xiaomi.channel.commonutils.logger.b.m73a("not a mipush message");
                return;
            }
            gb gbVar = (gb) gcVar;
            fz a2 = gbVar.a("s");
            if (a2 != null) {
                try {
                    a(xMPushService, be.a(be.a(bVar.f78137h, gbVar.j()), a2.c()), gq.a(gcVar.m348a()));
                } catch (IllegalArgumentException e2) {
                    com.xiaomi.channel.commonutils.logger.b.a(e2);
                }
            }
        }
    }
}
