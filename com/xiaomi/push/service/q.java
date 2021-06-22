package com.xiaomi.push.service;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
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
    public static Intent a(byte[] bArr, long j) {
        ib a2 = a(bArr);
        if (a2 == null) {
            return null;
        }
        Intent intent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
        intent.putExtra("mipush_payload", bArr);
        intent.putExtra("mrt", Long.toString(j));
        intent.setPackage(a2.f635b);
        return intent;
    }

    public static ib a(Context context, ib ibVar) {
        hv hvVar = new hv();
        hvVar.b(ibVar.m437a());
        hs m436a = ibVar.m436a();
        if (m436a != null) {
            hvVar.a(m436a.m393a());
            hvVar.a(m436a.m391a());
            if (!TextUtils.isEmpty(m436a.m398b())) {
                hvVar.c(m436a.m398b());
            }
        }
        hvVar.a(ip.a(context, ibVar));
        ib a2 = y.a(ibVar.b(), ibVar.m437a(), hvVar, hf.AckMessage);
        hs m392a = ibVar.m436a().m392a();
        m392a.a("mat", Long.toString(System.currentTimeMillis()));
        a2.a(m392a);
        return a2;
    }

    public static ib a(byte[] bArr) {
        ib ibVar = new ib();
        try {
            ip.a(ibVar, bArr);
            return ibVar;
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.a(th);
            return null;
        }
    }

    public static void a(XMPushService xMPushService, ib ibVar) {
        xMPushService.a(new r(4, xMPushService, ibVar));
    }

    public static void a(XMPushService xMPushService, ib ibVar, ie ieVar) {
        xMPushService.a(new x(4, ieVar, ibVar, xMPushService));
    }

    public static void a(XMPushService xMPushService, ib ibVar, String str) {
        xMPushService.a(new v(4, xMPushService, ibVar, str));
    }

    public static void a(XMPushService xMPushService, ib ibVar, String str, String str2) {
        xMPushService.a(new w(4, xMPushService, ibVar, str, str2));
    }

    /* JADX WARN: Removed duplicated region for block: B:145:0x0411  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x042b  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0454  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x03f3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
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
        String m393a;
        int i3;
        String str3;
        String str4;
        el a3;
        String b3;
        String b4;
        String m393a2;
        String str5;
        boolean z2;
        ib a4 = a(bArr);
        hs m436a = a4.m436a();
        iq iqVar = null;
        String str6 = null;
        if (bArr != null) {
            cy.a(a4.b(), xMPushService.getApplicationContext(), null, a4.a(), bArr.length);
        }
        if (c(a4) && a(xMPushService, str)) {
            if (ac.e(a4)) {
                el.a(xMPushService.getApplicationContext()).a(a4.b(), ac.b(a4), m436a.m393a(), "5");
            }
            c(xMPushService, a4);
        } else if (a(a4) && !a(xMPushService, str) && !b(a4)) {
            if (ac.e(a4)) {
                el.a(xMPushService.getApplicationContext()).a(a4.b(), ac.b(a4), m436a.m393a(), "6");
            }
            d(xMPushService, a4);
        } else if ((!ac.m561a(a4) || !com.xiaomi.push.g.m328b((Context) xMPushService, a4.f635b)) && !a(xMPushService, intent)) {
            if (!com.xiaomi.push.g.m328b((Context) xMPushService, a4.f635b)) {
                if (ac.e(a4)) {
                    el.a(xMPushService.getApplicationContext()).b(a4.b(), ac.b(a4), m436a.m393a(), "2");
                }
                a(xMPushService, a4);
                return;
            }
            com.xiaomi.channel.commonutils.logger.b.m56a("receive a mipush message, we can see the app, but we can't see the receiver.");
            if (ac.e(a4)) {
                el.a(xMPushService.getApplicationContext()).b(a4.b(), ac.b(a4), m436a.m393a(), "3");
            }
        } else {
            boolean z3 = false;
            if (hf.Registration == a4.a()) {
                String b5 = a4.b();
                SharedPreferences.Editor edit = xMPushService.getSharedPreferences("pref_registered_pkg_names", 0).edit();
                edit.putString(b5, a4.f631a);
                edit.commit();
                n.a(xMPushService).e(b5);
                n.a(xMPushService).f(b5);
                el.a(xMPushService.getApplicationContext()).a(b5, "E100003", m436a.m393a(), 6003, null);
                if (!TextUtils.isEmpty(m436a.m393a())) {
                    intent.putExtra(MiPushMessage.KEY_MESSAGE_ID, m436a.m393a());
                    intent.putExtra("eventMessageType", 6000);
                }
            }
            if (ac.c(a4)) {
                el.a(xMPushService.getApplicationContext()).a(a4.b(), ac.b(a4), m436a.m393a(), 1001, System.currentTimeMillis(), null);
                if (!TextUtils.isEmpty(m436a.m393a())) {
                    intent.putExtra(MiPushMessage.KEY_MESSAGE_ID, m436a.m393a());
                    intent.putExtra("eventMessageType", 1000);
                }
            }
            if (ac.m565b(a4)) {
                el.a(xMPushService.getApplicationContext()).a(a4.b(), ac.b(a4), m436a.m393a(), 2001, System.currentTimeMillis(), null);
                if (!TextUtils.isEmpty(m436a.m393a())) {
                    intent.putExtra(MiPushMessage.KEY_MESSAGE_ID, m436a.m393a());
                    intent.putExtra("eventMessageType", 2000);
                }
            }
            if (ac.m561a(a4)) {
                el.a(xMPushService.getApplicationContext()).a(a4.b(), ac.b(a4), m436a.m393a(), 3001, System.currentTimeMillis(), null);
                if (!TextUtils.isEmpty(m436a.m393a())) {
                    intent.putExtra(MiPushMessage.KEY_MESSAGE_ID, m436a.m393a());
                    intent.putExtra("eventMessageType", 3000);
                }
            }
            if (m436a != null && !TextUtils.isEmpty(m436a.m401c()) && !TextUtils.isEmpty(m436a.d()) && m436a.f543b != 1 && (ac.m562a(m436a.m394a()) || !ac.m560a((Context) xMPushService, a4.f635b))) {
                if (m436a != null) {
                    Map<String, String> map = m436a.f541a;
                    str6 = map != null ? map.get("jobkey") : null;
                    if (TextUtils.isEmpty(str6)) {
                        str6 = m436a.m393a();
                    }
                    z2 = af.a(xMPushService, a4.f635b, str6);
                } else {
                    z2 = false;
                }
                if (z2) {
                    el a5 = el.a(xMPushService.getApplicationContext());
                    String b6 = a4.b();
                    String b7 = ac.b(a4);
                    String m393a3 = m436a.m393a();
                    a5.c(b6, b7, m393a3, "1:" + str6);
                    com.xiaomi.channel.commonutils.logger.b.m56a("drop a duplicate message, key=" + str6);
                } else {
                    ac.c m556a = ac.m556a((Context) xMPushService, a4, bArr);
                    if (m556a.f41821a > 0 && !TextUtils.isEmpty(m556a.f875a)) {
                        gq.a(xMPushService, m556a.f875a, m556a.f41821a, true, false, System.currentTimeMillis());
                    }
                    if (!ac.m561a(a4) && com.xiaomi.push.g.m326a(xMPushService.getApplicationContext(), str)) {
                        Intent intent2 = new Intent("com.xiaomi.mipush.MESSAGE_ARRIVED");
                        intent2.putExtra("mipush_payload", bArr);
                        intent2.setPackage(a4.f635b);
                        try {
                            List<ResolveInfo> queryBroadcastReceivers = xMPushService.getPackageManager().queryBroadcastReceivers(intent2, 0);
                            if (queryBroadcastReceivers != null && !queryBroadcastReceivers.isEmpty()) {
                                com.xiaomi.channel.commonutils.logger.b.m56a("broadcast message arrived.");
                                xMPushService.sendBroadcast(intent2, y.a(a4.f635b));
                            }
                        } catch (Exception unused) {
                            el.a(xMPushService.getApplicationContext()).b(a4.b(), ac.b(a4), m436a.m393a(), "1");
                        }
                    }
                }
                b(xMPushService, a4);
            } else if ("com.xiaomi.xmsf".contains(a4.f635b) && !a4.m444b() && m436a != null && m436a.m394a() != null && m436a.m394a().containsKey("ab")) {
                b(xMPushService, a4);
                com.xiaomi.channel.commonutils.logger.b.c("receive abtest message. ack it." + m436a.m393a());
            } else if (a(xMPushService, str, a4, m436a)) {
                if (m436a != null && !TextUtils.isEmpty(m436a.m393a())) {
                    if (ac.m565b(a4)) {
                        a2 = el.a(xMPushService.getApplicationContext());
                        b2 = a4.b();
                        str4 = ac.b(a4);
                        m393a = m436a.m393a();
                        i3 = 2002;
                        str3 = null;
                    } else {
                        if (ac.m561a(a4)) {
                            a3 = el.a(xMPushService.getApplicationContext());
                            b3 = a4.b();
                            b4 = ac.b(a4);
                            m393a2 = m436a.m393a();
                            str5 = "7";
                        } else if (ac.c(a4)) {
                            a3 = el.a(xMPushService.getApplicationContext());
                            b3 = a4.b();
                            b4 = ac.b(a4);
                            m393a2 = m436a.m393a();
                            str5 = "8";
                        } else if (ac.d(a4)) {
                            a2 = el.a(xMPushService.getApplicationContext());
                            b2 = a4.b();
                            m393a = m436a.m393a();
                            i3 = 6004;
                            str3 = null;
                            str4 = "E100003";
                        }
                        a3.a(b3, b4, m393a2, str5);
                    }
                    a2.a(b2, str4, m393a, i3, str3);
                }
                if (hf.Notification == a4.f628a) {
                    try {
                        iqVar = bp.a(xMPushService, a4);
                    } catch (iv e2) {
                        com.xiaomi.channel.commonutils.logger.b.d("receive a message which action string is not valid. " + e2);
                    }
                    if (iqVar == null) {
                        com.xiaomi.channel.commonutils.logger.b.d("receiving an un-recognized notification message. " + a4.f628a);
                        z = false;
                        if (z && (iqVar instanceof ie)) {
                            ieVar = (ie) iqVar;
                            if (hp.CancelPushMessage.f506a.equals(ieVar.f652d) && ieVar.m452a() != null) {
                                str2 = ieVar.m452a().get(az.K);
                                i2 = -2;
                                if (!TextUtils.isEmpty(str2)) {
                                    try {
                                        i2 = Integer.parseInt(str2);
                                    } catch (NumberFormatException e3) {
                                        com.xiaomi.channel.commonutils.logger.b.m56a("parse notifyId from STRING to INT failed: " + e3);
                                    }
                                }
                                if (i2 < -1) {
                                    com.xiaomi.channel.commonutils.logger.b.m56a("try to retract a message by notifyId=" + i2);
                                    ac.a(xMPushService, a4.f635b, i2);
                                } else {
                                    com.xiaomi.channel.commonutils.logger.b.m56a("try to retract a message by title&description.");
                                    ac.a(xMPushService, a4.f635b, ieVar.m452a().get(az.I), ieVar.m452a().get(az.J));
                                }
                                a(xMPushService, a4, ieVar);
                                if (z3) {
                                    com.xiaomi.channel.commonutils.logger.b.m56a("broadcast passthrough message.");
                                    xMPushService.sendBroadcast(intent, y.a(a4.f635b));
                                }
                            }
                        }
                    } else {
                        z = true;
                        if (z) {
                            ieVar = (ie) iqVar;
                            if (hp.CancelPushMessage.f506a.equals(ieVar.f652d)) {
                                str2 = ieVar.m452a().get(az.K);
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
                el.a(xMPushService.getApplicationContext()).a(a4.b(), ac.b(a4), m436a.m393a(), "9");
            }
            if (a4.a() != hf.UnRegistration || "com.xiaomi.xmsf".equals(xMPushService.getPackageName())) {
                return;
            }
            xMPushService.stopSelf();
        }
    }

    public static void a(XMPushService xMPushService, byte[] bArr, long j) {
        Map<String, String> m394a;
        ib a2 = a(bArr);
        if (a2 == null) {
            return;
        }
        if (TextUtils.isEmpty(a2.f635b)) {
            com.xiaomi.channel.commonutils.logger.b.m56a("receive a mipush message without package name");
            return;
        }
        Long valueOf = Long.valueOf(System.currentTimeMillis());
        Intent a3 = a(bArr, valueOf.longValue());
        String a4 = ac.a(a2);
        gq.a(xMPushService, a4, j, true, true, System.currentTimeMillis());
        hs m436a = a2.m436a();
        if (m436a != null && m436a.m393a() != null) {
            com.xiaomi.channel.commonutils.logger.b.e(String.format("receive a message. appid=%1$s, msgid= %2$s, action=%3$s", a2.m437a(), m436a.m393a(), a2.a()));
        }
        if (m436a != null) {
            m436a.a("mrt", Long.toString(valueOf.longValue()));
        }
        String str = "";
        if (hf.SendMessage == a2.a() && n.a(xMPushService).m619a(a2.f635b) && !ac.m561a(a2)) {
            if (m436a != null) {
                str = m436a.m393a();
                if (ac.e(a2)) {
                    el.a(xMPushService.getApplicationContext()).a(a2.b(), ac.b(a2), str, "1");
                }
            }
            com.xiaomi.channel.commonutils.logger.b.m56a("Drop a message for unregistered, msgid=" + str);
            a(xMPushService, a2, a2.f635b);
        } else if (hf.SendMessage == a2.a() && n.a(xMPushService).m621c(a2.f635b) && !ac.m561a(a2)) {
            if (m436a != null) {
                str = m436a.m393a();
                if (ac.e(a2)) {
                    el.a(xMPushService.getApplicationContext()).a(a2.b(), ac.b(a2), str, "2");
                }
            }
            com.xiaomi.channel.commonutils.logger.b.m56a("Drop a message for push closed, msgid=" + str);
            a(xMPushService, a2, a2.f635b);
        } else if (hf.SendMessage == a2.a() && !TextUtils.equals(xMPushService.getPackageName(), "com.xiaomi.xmsf") && !TextUtils.equals(xMPushService.getPackageName(), a2.f635b)) {
            com.xiaomi.channel.commonutils.logger.b.m56a("Receive a message with wrong package name, expect " + xMPushService.getPackageName() + ", received " + a2.f635b);
            a(xMPushService, a2, "unmatched_package", "package should be " + xMPushService.getPackageName() + ", but got " + a2.f635b);
            if (m436a == null || !ac.e(a2)) {
                return;
            }
            el.a(xMPushService.getApplicationContext()).a(a2.b(), ac.b(a2), m436a.m393a(), "3");
        } else if (m436a != null && (m394a = m436a.m394a()) != null && m394a.containsKey("hide") && "true".equalsIgnoreCase(m394a.get("hide"))) {
            b(xMPushService, a2);
        } else {
            if (m436a != null && m436a.m394a() != null && m436a.m394a().containsKey("__miid")) {
                String str2 = m436a.m394a().get("__miid");
                String a5 = com.xiaomi.push.t.a(xMPushService.getApplicationContext());
                if (TextUtils.isEmpty(a5) || !TextUtils.equals(str2, a5)) {
                    if (ac.e(a2)) {
                        el.a(xMPushService.getApplicationContext()).a(a2.b(), ac.b(a2), m436a.m393a(), "4");
                    }
                    com.xiaomi.channel.commonutils.logger.b.m56a(str2 + " should be login, but got " + a5);
                    a(xMPushService, a2, "miid already logout or anther already login", str2 + " should be login, but got " + a5);
                    return;
                }
            }
            a(xMPushService, a4, bArr, a3);
        }
    }

    public static boolean a(Context context, Intent intent) {
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

    public static boolean a(Context context, String str) {
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

    public static boolean a(ib ibVar) {
        return "com.xiaomi.xmsf".equals(ibVar.f635b) && ibVar.m436a() != null && ibVar.m436a().m394a() != null && ibVar.m436a().m394a().containsKey("miui_package_name");
    }

    public static boolean a(XMPushService xMPushService, String str, ib ibVar, hs hsVar) {
        boolean z = true;
        if (hsVar != null && hsVar.m394a() != null && hsVar.m394a().containsKey("__check_alive") && hsVar.m394a().containsKey("__awake")) {
            ie ieVar = new ie();
            ieVar.b(ibVar.m437a());
            ieVar.d(str);
            ieVar.c(hp.AwakeSystemApp.f506a);
            ieVar.a(hsVar.m393a());
            ieVar.f647a = new HashMap();
            boolean m326a = com.xiaomi.push.g.m326a(xMPushService.getApplicationContext(), str);
            ieVar.f647a.put("app_running", Boolean.toString(m326a));
            if (!m326a) {
                boolean parseBoolean = Boolean.parseBoolean(hsVar.m394a().get("__awake"));
                ieVar.f647a.put("awaked", Boolean.toString(parseBoolean));
                if (!parseBoolean) {
                    z = false;
                }
            }
            try {
                y.a(xMPushService, y.a(ibVar.b(), ibVar.m437a(), ieVar, hf.Notification));
            } catch (fw e2) {
                com.xiaomi.channel.commonutils.logger.b.a(e2);
            }
        }
        return z;
    }

    public static void b(XMPushService xMPushService, ib ibVar) {
        xMPushService.a(new s(4, xMPushService, ibVar));
    }

    public static boolean b(ib ibVar) {
        Map<String, String> m394a = ibVar.m436a().m394a();
        return m394a != null && m394a.containsKey("notify_effect");
    }

    public static void c(XMPushService xMPushService, ib ibVar) {
        xMPushService.a(new t(4, xMPushService, ibVar));
    }

    public static boolean c(ib ibVar) {
        if (ibVar.m436a() == null || ibVar.m436a().m394a() == null) {
            return false;
        }
        return "1".equals(ibVar.m436a().m394a().get("obslete_ads_message"));
    }

    public static void d(XMPushService xMPushService, ib ibVar) {
        xMPushService.a(new u(4, xMPushService, ibVar));
    }

    public void a(Context context, av.b bVar, boolean z, int i2, String str) {
        l a2;
        if (z || (a2 = m.a(context)) == null || !"token-expired".equals(str)) {
            return;
        }
        try {
            m.a(context, a2.f41935f, a2.f41933d, a2.f41934e);
        } catch (IOException | JSONException e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
        }
    }

    public void a(XMPushService xMPushService, fa faVar, av.b bVar) {
        try {
            a(xMPushService, faVar.m293a(bVar.f41852h), faVar.c());
        } catch (IllegalArgumentException e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
        }
    }

    public void a(XMPushService xMPushService, gc gcVar, av.b bVar) {
        if (!(gcVar instanceof gb)) {
            com.xiaomi.channel.commonutils.logger.b.m56a("not a mipush message");
            return;
        }
        gb gbVar = (gb) gcVar;
        fz a2 = gbVar.a("s");
        if (a2 != null) {
            try {
                a(xMPushService, be.a(be.a(bVar.f41852h, gbVar.j()), a2.c()), gq.a(gcVar.m331a()));
            } catch (IllegalArgumentException e2) {
                com.xiaomi.channel.commonutils.logger.b.a(e2);
            }
        }
    }
}
