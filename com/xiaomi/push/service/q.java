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
/* loaded from: classes7.dex */
public class q {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public q() {
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
            ib a = a(bArr);
            if (a == null) {
                return null;
            }
            Intent intent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
            intent.putExtra("mipush_payload", bArr);
            intent.putExtra("mrt", Long.toString(j));
            intent.setPackage(a.f619b);
            return intent;
        }
        return (Intent) invokeLJ.objValue;
    }

    public static ib a(Context context, ib ibVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, ibVar)) == null) {
            hv hvVar = new hv();
            hvVar.b(ibVar.m493a());
            hs m492a = ibVar.m492a();
            if (m492a != null) {
                hvVar.a(m492a.m449a());
                hvVar.a(m492a.m447a());
                if (!TextUtils.isEmpty(m492a.m454b())) {
                    hvVar.c(m492a.m454b());
                }
            }
            hvVar.a(ip.a(context, ibVar));
            ib a = y.a(ibVar.b(), ibVar.m493a(), hvVar, hf.f44326f);
            hs m448a = ibVar.m492a().m448a();
            m448a.a("mat", Long.toString(System.currentTimeMillis()));
            a.a(m448a);
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
        int i;
        el a;
        String b2;
        String m449a;
        int i2;
        String str3;
        String str4;
        el a2;
        String b3;
        String b4;
        String m449a2;
        String str5;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65544, null, xMPushService, str, bArr, intent) == null) {
            ib a3 = a(bArr);
            hs m492a = a3.m492a();
            iq iqVar = null;
            String str6 = null;
            if (bArr != null) {
                cy.a(a3.b(), xMPushService.getApplicationContext(), null, a3.a(), bArr.length);
            }
            if (c(a3) && a(xMPushService, str)) {
                if (ac.e(a3)) {
                    el.a(xMPushService.getApplicationContext()).a(a3.b(), ac.b(a3), m492a.m449a(), "5");
                }
                c(xMPushService, a3);
            } else if (a(a3) && !a(xMPushService, str) && !b(a3)) {
                if (ac.e(a3)) {
                    el.a(xMPushService.getApplicationContext()).a(a3.b(), ac.b(a3), m492a.m449a(), "6");
                }
                d(xMPushService, a3);
            } else if ((!ac.m617a(a3) || !com.xiaomi.push.g.m384b((Context) xMPushService, a3.f619b)) && !a(xMPushService, intent)) {
                if (!com.xiaomi.push.g.m384b((Context) xMPushService, a3.f619b)) {
                    if (ac.e(a3)) {
                        el.a(xMPushService.getApplicationContext()).b(a3.b(), ac.b(a3), m492a.m449a(), "2");
                    }
                    a(xMPushService, a3);
                    return;
                }
                com.xiaomi.channel.commonutils.logger.b.m112a("receive a mipush message, we can see the app, but we can't see the receiver.");
                if (ac.e(a3)) {
                    el.a(xMPushService.getApplicationContext()).b(a3.b(), ac.b(a3), m492a.m449a(), "3");
                }
            } else {
                boolean z3 = false;
                if (hf.a == a3.a()) {
                    String b5 = a3.b();
                    SharedPreferences.Editor edit = xMPushService.getSharedPreferences("pref_registered_pkg_names", 0).edit();
                    edit.putString(b5, a3.f615a);
                    edit.commit();
                    n.a(xMPushService).e(b5);
                    n.a(xMPushService).f(b5);
                    el.a(xMPushService.getApplicationContext()).a(b5, "E100003", m492a.m449a(), w0.g3, null);
                    if (!TextUtils.isEmpty(m492a.m449a())) {
                        intent.putExtra(MiPushMessage.KEY_MESSAGE_ID, m492a.m449a());
                        intent.putExtra("eventMessageType", 6000);
                    }
                }
                if (ac.c(a3)) {
                    el.a(xMPushService.getApplicationContext()).a(a3.b(), ac.b(a3), m492a.m449a(), 1001, System.currentTimeMillis(), null);
                    if (!TextUtils.isEmpty(m492a.m449a())) {
                        intent.putExtra(MiPushMessage.KEY_MESSAGE_ID, m492a.m449a());
                        intent.putExtra("eventMessageType", 1000);
                    }
                }
                if (ac.m621b(a3)) {
                    el.a(xMPushService.getApplicationContext()).a(a3.b(), ac.b(a3), m492a.m449a(), 2001, System.currentTimeMillis(), null);
                    if (!TextUtils.isEmpty(m492a.m449a())) {
                        intent.putExtra(MiPushMessage.KEY_MESSAGE_ID, m492a.m449a());
                        intent.putExtra("eventMessageType", 2000);
                    }
                }
                if (ac.m617a(a3)) {
                    el.a(xMPushService.getApplicationContext()).a(a3.b(), ac.b(a3), m492a.m449a(), 3001, System.currentTimeMillis(), null);
                    if (!TextUtils.isEmpty(m492a.m449a())) {
                        intent.putExtra(MiPushMessage.KEY_MESSAGE_ID, m492a.m449a());
                        intent.putExtra("eventMessageType", 3000);
                    }
                }
                if (m492a != null && !TextUtils.isEmpty(m492a.m457c()) && !TextUtils.isEmpty(m492a.d()) && m492a.f527b != 1 && (ac.m618a(m492a.m450a()) || !ac.m616a((Context) xMPushService, a3.f619b))) {
                    if (m492a != null) {
                        Map<String, String> map = m492a.f525a;
                        str6 = map != null ? map.get("jobkey") : null;
                        if (TextUtils.isEmpty(str6)) {
                            str6 = m492a.m449a();
                        }
                        z2 = af.a(xMPushService, a3.f619b, str6);
                    } else {
                        z2 = false;
                    }
                    if (z2) {
                        el a4 = el.a(xMPushService.getApplicationContext());
                        String b6 = a3.b();
                        String b7 = ac.b(a3);
                        String m449a3 = m492a.m449a();
                        a4.c(b6, b7, m449a3, "1:" + str6);
                        com.xiaomi.channel.commonutils.logger.b.m112a("drop a duplicate message, key=" + str6);
                    } else {
                        ac.c m612a = ac.m612a((Context) xMPushService, a3, bArr);
                        if (m612a.a > 0 && !TextUtils.isEmpty(m612a.f859a)) {
                            gq.a(xMPushService, m612a.f859a, m612a.a, true, false, System.currentTimeMillis());
                        }
                        if (!ac.m617a(a3) && com.xiaomi.push.g.m382a(xMPushService.getApplicationContext(), str)) {
                            Intent intent2 = new Intent("com.xiaomi.mipush.MESSAGE_ARRIVED");
                            intent2.putExtra("mipush_payload", bArr);
                            intent2.setPackage(a3.f619b);
                            try {
                                List<ResolveInfo> queryBroadcastReceivers = xMPushService.getPackageManager().queryBroadcastReceivers(intent2, 0);
                                if (queryBroadcastReceivers != null && !queryBroadcastReceivers.isEmpty()) {
                                    com.xiaomi.channel.commonutils.logger.b.m112a("broadcast message arrived.");
                                    xMPushService.sendBroadcast(intent2, y.a(a3.f619b));
                                }
                            } catch (Exception unused) {
                                el.a(xMPushService.getApplicationContext()).b(a3.b(), ac.b(a3), m492a.m449a(), "1");
                            }
                        }
                    }
                    b(xMPushService, a3);
                } else if ("com.xiaomi.xmsf".contains(a3.f619b) && !a3.m500b() && m492a != null && m492a.m450a() != null && m492a.m450a().containsKey("ab")) {
                    b(xMPushService, a3);
                    com.xiaomi.channel.commonutils.logger.b.c("receive abtest message. ack it." + m492a.m449a());
                } else if (a(xMPushService, str, a3, m492a)) {
                    if (m492a != null && !TextUtils.isEmpty(m492a.m449a())) {
                        if (ac.m621b(a3)) {
                            a = el.a(xMPushService.getApplicationContext());
                            b2 = a3.b();
                            str4 = ac.b(a3);
                            m449a = m492a.m449a();
                            i2 = 2002;
                            str3 = null;
                        } else {
                            if (ac.m617a(a3)) {
                                a2 = el.a(xMPushService.getApplicationContext());
                                b3 = a3.b();
                                b4 = ac.b(a3);
                                m449a2 = m492a.m449a();
                                str5 = "7";
                            } else if (ac.c(a3)) {
                                a2 = el.a(xMPushService.getApplicationContext());
                                b3 = a3.b();
                                b4 = ac.b(a3);
                                m449a2 = m492a.m449a();
                                str5 = "8";
                            } else if (ac.d(a3)) {
                                a = el.a(xMPushService.getApplicationContext());
                                b2 = a3.b();
                                m449a = m492a.m449a();
                                i2 = w0.h3;
                                str3 = null;
                                str4 = "E100003";
                            }
                            a2.a(b3, b4, m449a2, str5);
                        }
                        a.a(b2, str4, m449a, i2, str3);
                    }
                    if (hf.i == a3.f612a) {
                        try {
                            iqVar = bp.a(xMPushService, a3);
                        } catch (iv e2) {
                            com.xiaomi.channel.commonutils.logger.b.d("receive a message which action string is not valid. " + e2);
                        }
                        if (iqVar == null) {
                            com.xiaomi.channel.commonutils.logger.b.d("receiving an un-recognized notification message. " + a3.f612a);
                            z = false;
                            if (z && (iqVar instanceof ie)) {
                                ieVar = (ie) iqVar;
                                if (hp.C.f490a.equals(ieVar.f636d) && ieVar.m508a() != null) {
                                    str2 = ieVar.m508a().get(az.K);
                                    i = -2;
                                    if (!TextUtils.isEmpty(str2)) {
                                        try {
                                            i = Integer.parseInt(str2);
                                        } catch (NumberFormatException e3) {
                                            com.xiaomi.channel.commonutils.logger.b.m112a("parse notifyId from STRING to INT failed: " + e3);
                                        }
                                    }
                                    if (i < -1) {
                                        com.xiaomi.channel.commonutils.logger.b.m112a("try to retract a message by notifyId=" + i);
                                        ac.a(xMPushService, a3.f619b, i);
                                    } else {
                                        com.xiaomi.channel.commonutils.logger.b.m112a("try to retract a message by title&description.");
                                        ac.a(xMPushService, a3.f619b, ieVar.m508a().get(az.I), ieVar.m508a().get(az.J));
                                    }
                                    a(xMPushService, a3, ieVar);
                                    if (z3) {
                                        com.xiaomi.channel.commonutils.logger.b.m112a("broadcast passthrough message.");
                                        xMPushService.sendBroadcast(intent, y.a(a3.f619b));
                                    }
                                }
                            }
                        } else {
                            z = true;
                            if (z) {
                                ieVar = (ie) iqVar;
                                if (hp.C.f490a.equals(ieVar.f636d)) {
                                    str2 = ieVar.m508a().get(az.K);
                                    i = -2;
                                    if (!TextUtils.isEmpty(str2)) {
                                    }
                                    if (i < -1) {
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
                    el.a(xMPushService.getApplicationContext()).a(a3.b(), ac.b(a3), m492a.m449a(), "9");
                }
                if (a3.a() != hf.f44322b || "com.xiaomi.xmsf".equals(xMPushService.getPackageName())) {
                    return;
                }
                xMPushService.stopSelf();
            }
        }
    }

    public static void a(XMPushService xMPushService, byte[] bArr, long j) {
        ib a;
        Map<String, String> m450a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65545, null, new Object[]{xMPushService, bArr, Long.valueOf(j)}) == null) || (a = a(bArr)) == null) {
            return;
        }
        if (TextUtils.isEmpty(a.f619b)) {
            com.xiaomi.channel.commonutils.logger.b.m112a("receive a mipush message without package name");
            return;
        }
        Long valueOf = Long.valueOf(System.currentTimeMillis());
        Intent a2 = a(bArr, valueOf.longValue());
        String a3 = ac.a(a);
        gq.a(xMPushService, a3, j, true, true, System.currentTimeMillis());
        hs m492a = a.m492a();
        if (m492a != null && m492a.m449a() != null) {
            com.xiaomi.channel.commonutils.logger.b.e(String.format("receive a message. appid=%1$s, msgid= %2$s, action=%3$s", a.m493a(), m492a.m449a(), a.a()));
        }
        if (m492a != null) {
            m492a.a("mrt", Long.toString(valueOf.longValue()));
        }
        String str = "";
        if (hf.f44325e == a.a() && n.a(xMPushService).m675a(a.f619b) && !ac.m617a(a)) {
            if (m492a != null) {
                str = m492a.m449a();
                if (ac.e(a)) {
                    el.a(xMPushService.getApplicationContext()).a(a.b(), ac.b(a), str, "1");
                }
            }
            com.xiaomi.channel.commonutils.logger.b.m112a("Drop a message for unregistered, msgid=" + str);
            a(xMPushService, a, a.f619b);
        } else if (hf.f44325e == a.a() && n.a(xMPushService).m677c(a.f619b) && !ac.m617a(a)) {
            if (m492a != null) {
                str = m492a.m449a();
                if (ac.e(a)) {
                    el.a(xMPushService.getApplicationContext()).a(a.b(), ac.b(a), str, "2");
                }
            }
            com.xiaomi.channel.commonutils.logger.b.m112a("Drop a message for push closed, msgid=" + str);
            a(xMPushService, a, a.f619b);
        } else if (hf.f44325e == a.a() && !TextUtils.equals(xMPushService.getPackageName(), "com.xiaomi.xmsf") && !TextUtils.equals(xMPushService.getPackageName(), a.f619b)) {
            com.xiaomi.channel.commonutils.logger.b.m112a("Receive a message with wrong package name, expect " + xMPushService.getPackageName() + ", received " + a.f619b);
            a(xMPushService, a, "unmatched_package", "package should be " + xMPushService.getPackageName() + ", but got " + a.f619b);
            if (m492a == null || !ac.e(a)) {
                return;
            }
            el.a(xMPushService.getApplicationContext()).a(a.b(), ac.b(a), m492a.m449a(), "3");
        } else if (m492a != null && (m450a = m492a.m450a()) != null && m450a.containsKey("hide") && "true".equalsIgnoreCase(m450a.get("hide"))) {
            b(xMPushService, a);
        } else {
            if (m492a != null && m492a.m450a() != null && m492a.m450a().containsKey("__miid")) {
                String str2 = m492a.m450a().get("__miid");
                String a4 = com.xiaomi.push.t.a(xMPushService.getApplicationContext());
                if (TextUtils.isEmpty(a4) || !TextUtils.equals(str2, a4)) {
                    if (ac.e(a)) {
                        el.a(xMPushService.getApplicationContext()).a(a.b(), ac.b(a), m492a.m449a(), "4");
                    }
                    com.xiaomi.channel.commonutils.logger.b.m112a(str2 + " should be login, but got " + a4);
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
        return (interceptable == null || (invokeL = interceptable.invokeL(65548, null, ibVar)) == null) ? "com.xiaomi.xmsf".equals(ibVar.f619b) && ibVar.m492a() != null && ibVar.m492a().m450a() != null && ibVar.m492a().m450a().containsKey("miui_package_name") : invokeL.booleanValue;
    }

    public static boolean a(XMPushService xMPushService, String str, ib ibVar, hs hsVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65549, null, xMPushService, str, ibVar, hsVar)) == null) {
            boolean z = true;
            if (hsVar != null && hsVar.m450a() != null && hsVar.m450a().containsKey("__check_alive") && hsVar.m450a().containsKey("__awake")) {
                ie ieVar = new ie();
                ieVar.b(ibVar.m493a());
                ieVar.d(str);
                ieVar.c(hp.H.f490a);
                ieVar.a(hsVar.m449a());
                ieVar.f631a = new HashMap();
                boolean m382a = com.xiaomi.push.g.m382a(xMPushService.getApplicationContext(), str);
                ieVar.f631a.put("app_running", Boolean.toString(m382a));
                if (!m382a) {
                    boolean parseBoolean = Boolean.parseBoolean(hsVar.m450a().get("__awake"));
                    ieVar.f631a.put("awaked", Boolean.toString(parseBoolean));
                    if (!parseBoolean) {
                        z = false;
                    }
                }
                try {
                    y.a(xMPushService, y.a(ibVar.b(), ibVar.m493a(), ieVar, hf.i));
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
            Map<String, String> m450a = ibVar.m492a().m450a();
            return m450a != null && m450a.containsKey("notify_effect");
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
            if (ibVar.m492a() == null || ibVar.m492a().m450a() == null) {
                return false;
            }
            return "1".equals(ibVar.m492a().m450a().get("obslete_ads_message"));
        }
        return invokeL.booleanValue;
    }

    public static void d(XMPushService xMPushService, ib ibVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65554, null, xMPushService, ibVar) == null) {
            xMPushService.a(new u(4, xMPushService, ibVar));
        }
    }

    public void a(Context context, av.b bVar, boolean z, int i, String str) {
        l a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{context, bVar, Boolean.valueOf(z), Integer.valueOf(i), str}) == null) || z || (a = m.a(context)) == null || !"token-expired".equals(str)) {
            return;
        }
        try {
            m.a(context, a.f44585f, a.f44583d, a.f44584e);
        } catch (IOException | JSONException e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
        }
    }

    public void a(XMPushService xMPushService, fa faVar, av.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, xMPushService, faVar, bVar) == null) {
            try {
                a(xMPushService, faVar.m349a(bVar.f44552h), faVar.c());
            } catch (IllegalArgumentException e2) {
                com.xiaomi.channel.commonutils.logger.b.a(e2);
            }
        }
    }

    public void a(XMPushService xMPushService, gc gcVar, av.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, xMPushService, gcVar, bVar) == null) {
            if (!(gcVar instanceof gb)) {
                com.xiaomi.channel.commonutils.logger.b.m112a("not a mipush message");
                return;
            }
            gb gbVar = (gb) gcVar;
            fz a = gbVar.a("s");
            if (a != null) {
                try {
                    a(xMPushService, be.a(be.a(bVar.f44552h, gbVar.j()), a.c()), gq.a(gcVar.m387a()));
                } catch (IllegalArgumentException e2) {
                    com.xiaomi.channel.commonutils.logger.b.a(e2);
                }
            }
        }
    }
}
