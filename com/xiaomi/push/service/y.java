package com.xiaomi.push.service;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.baidu.searchbox.live.interfaces.DI;
import com.huawei.hms.support.api.entity.auth.AuthCode;
import com.xiaomi.mipush.sdk.MiPushMessage;
import com.xiaomi.push.da;
import com.xiaomi.push.en;
import com.xiaomi.push.fk;
import com.xiaomi.push.gg;
import com.xiaomi.push.gj;
import com.xiaomi.push.gl;
import com.xiaomi.push.gm;
import com.xiaomi.push.ha;
import com.xiaomi.push.hh;
import com.xiaomi.push.hr;
import com.xiaomi.push.hu;
import com.xiaomi.push.hx;
import com.xiaomi.push.id;
import com.xiaomi.push.ig;
import com.xiaomi.push.ii;
import com.xiaomi.push.ir;
import com.xiaomi.push.is;
import com.xiaomi.push.ix;
import com.xiaomi.push.service.ak;
import com.xiaomi.push.service.bg;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes8.dex */
public class y {
    public static Intent a(byte[] bArr, long j) {
        id a = a(bArr);
        if (a == null) {
            return null;
        }
        Intent intent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
        intent.putExtra("mipush_payload", bArr);
        intent.putExtra("mrt", Long.toString(j));
        intent.setPackage(a.f638b);
        return intent;
    }

    public static id a(Context context, id idVar) {
        return a(context, idVar, (Map<String, String>) null);
    }

    public static id a(Context context, id idVar, Map<String, String> map) {
        hx hxVar = new hx();
        hxVar.b(idVar.m542a());
        hu m541a = idVar.m541a();
        if (m541a != null) {
            hxVar.a(m541a.m501a());
            hxVar.a(m541a.m499a());
            if (!TextUtils.isEmpty(m541a.m506b())) {
                hxVar.c(m541a.m506b());
            }
        }
        hxVar.a(ir.a(context, idVar));
        id a = ah.a(idVar.b(), idVar.m542a(), hxVar, hh.AckMessage);
        hu m541a2 = idVar.m541a();
        if (m541a2 != null) {
            m541a2 = br.a(m541a2.m500a());
        }
        m541a2.a("mat", Long.toString(System.currentTimeMillis()));
        if (map != null) {
            try {
                if (map.size() > 0) {
                    for (String str : map.keySet()) {
                        m541a2.a(str, map.get(str));
                    }
                }
            } catch (Throwable unused) {
            }
        }
        a.a(m541a2);
        return a;
    }

    public static id a(byte[] bArr) {
        id idVar = new id();
        try {
            ir.a(idVar, bArr);
            return idVar;
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.a(th);
            return null;
        }
    }

    public static void a(Context context, id idVar, byte[] bArr) {
        try {
            ak.a(idVar);
            idVar.m541a();
            ak.c m678a = ak.m678a(context, idVar, bArr);
            if (m678a.a > 0 && !TextUtils.isEmpty(m678a.f895a)) {
                ha.a(context, m678a.f895a, m678a.a, true, false, System.currentTimeMillis());
            }
            if (!com.xiaomi.push.j.m628a(context) || !ag.a(context, idVar, m678a.f896a)) {
                b(context, idVar, bArr);
                return;
            }
            ag.m673a(context, idVar);
            com.xiaomi.channel.commonutils.logger.b.m97a("consume this broadcast by tts");
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m97a("notify push msg error " + e);
            e.printStackTrace();
        }
    }

    public static void a(XMPushService xMPushService, id idVar) {
        xMPushService.a(new z(4, xMPushService, idVar));
    }

    public static void a(XMPushService xMPushService, id idVar, ig igVar) {
        xMPushService.a(new af(4, igVar, idVar, xMPushService));
    }

    public static void a(XMPushService xMPushService, id idVar, String str) {
        xMPushService.a(new ad(4, xMPushService, idVar, str));
    }

    public static void a(XMPushService xMPushService, id idVar, String str, String str2) {
        xMPushService.a(new ae(4, xMPushService, idVar, str, str2));
    }

    /* JADX WARN: Removed duplicated region for block: B:138:0x03c7  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x03e1  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x042b  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x03a9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(XMPushService xMPushService, String str, byte[] bArr, Intent intent) {
        boolean z;
        ig igVar;
        String str2;
        int i;
        en a;
        String b;
        String m501a;
        int i2;
        String str3;
        String str4;
        en a2;
        String b2;
        String b3;
        String m501a2;
        String str5;
        String str6;
        id a3 = a(bArr);
        hu m541a = a3.m541a();
        is isVar = null;
        String str7 = null;
        if (bArr != null) {
            da.a(a3.b(), xMPushService.getApplicationContext(), null, a3.a(), bArr.length);
        }
        if (c(a3) && a(xMPushService, str)) {
            if (ak.e(a3)) {
                en.a(xMPushService.getApplicationContext()).a(a3.b(), ak.b(a3), m541a.m501a(), "5");
            }
            c(xMPushService, a3);
        } else if (a(a3) && !a(xMPushService, str) && !b(a3)) {
            if (ak.e(a3)) {
                en.a(xMPushService.getApplicationContext()).a(a3.b(), ak.b(a3), m541a.m501a(), "6");
            }
            d(xMPushService, a3);
        } else if ((!ak.m682a(a3) || !com.xiaomi.push.g.c(xMPushService, a3.f638b)) && !a(xMPushService, intent)) {
            if (!com.xiaomi.push.g.c(xMPushService, a3.f638b)) {
                if (ak.e(a3)) {
                    en.a(xMPushService.getApplicationContext()).b(a3.b(), ak.b(a3), m541a.m501a(), "2");
                }
                a(xMPushService, a3);
                return;
            }
            com.xiaomi.channel.commonutils.logger.b.m97a("receive a mipush message, we can see the app, but we can't see the receiver.");
            if (ak.e(a3)) {
                en.a(xMPushService.getApplicationContext()).b(a3.b(), ak.b(a3), m541a.m501a(), "3");
            }
        } else {
            boolean z2 = false;
            if (hh.Registration == a3.a()) {
                String b4 = a3.b();
                SharedPreferences.Editor edit = xMPushService.getSharedPreferences("pref_registered_pkg_names", 0).edit();
                edit.putString(b4, a3.f634a);
                edit.commit();
                ii a4 = n.a(a3);
                if (a4.a() != 0 || TextUtils.isEmpty(a4.b())) {
                    com.xiaomi.channel.commonutils.logger.b.d("read regSecret failed");
                } else {
                    n.a(xMPushService, b4, a4.b());
                }
                v.a(xMPushService).e(b4);
                v.a(xMPushService).f(b4);
                en.a(xMPushService.getApplicationContext()).a(b4, "E100003", m541a.m501a(), AuthCode.StatusCode.CERT_FINGERPRINT_ERROR, null);
                if (!TextUtils.isEmpty(m541a.m501a())) {
                    intent.putExtra(MiPushMessage.KEY_MESSAGE_ID, m541a.m501a());
                    intent.putExtra("eventMessageType", 6000);
                }
            }
            if (ak.c(a3)) {
                en.a(xMPushService.getApplicationContext()).a(a3.b(), ak.b(a3), m541a.m501a(), 1001, System.currentTimeMillis(), null);
                if (!TextUtils.isEmpty(m541a.m501a())) {
                    intent.putExtra(MiPushMessage.KEY_MESSAGE_ID, m541a.m501a());
                    intent.putExtra("eventMessageType", 1000);
                }
            }
            if (ak.m686b(a3)) {
                en.a(xMPushService.getApplicationContext()).a(a3.b(), ak.b(a3), m541a.m501a(), 2001, System.currentTimeMillis(), null);
                if (!TextUtils.isEmpty(m541a.m501a())) {
                    intent.putExtra(MiPushMessage.KEY_MESSAGE_ID, m541a.m501a());
                    intent.putExtra("eventMessageType", 2000);
                }
            }
            if (ak.m682a(a3)) {
                en.a(xMPushService.getApplicationContext()).a(a3.b(), ak.b(a3), m541a.m501a(), 3001, System.currentTimeMillis(), null);
                if (!TextUtils.isEmpty(m541a.m501a())) {
                    intent.putExtra(MiPushMessage.KEY_MESSAGE_ID, m541a.m501a());
                    intent.putExtra("eventMessageType", 3000);
                }
            }
            if (m541a != null && !TextUtils.isEmpty(m541a.m509c()) && !TextUtils.isEmpty(m541a.d()) && m541a.f545b != 1 && !ak.m681a((Context) xMPushService, a3.f638b, ak.m683a(m541a.m502a()))) {
                if (m541a != null) {
                    Map<String, String> map = m541a.f543a;
                    str7 = map != null ? map.get("jobkey") : null;
                    if (TextUtils.isEmpty(str7)) {
                        str7 = m541a.m501a();
                    }
                    z2 = am.a(xMPushService, a3.f638b, str7);
                }
                if (z2) {
                    en.a(xMPushService.getApplicationContext()).c(a3.b(), ak.b(a3), m541a.m501a(), "1:" + str7);
                    str6 = "drop a duplicate message, key=" + str7;
                } else if (com.xiaomi.push.j.m628a((Context) xMPushService) && ag.m674a(a3)) {
                    str6 = "receive pull down message";
                } else {
                    a(xMPushService, a3, bArr);
                    b(xMPushService, a3);
                }
                com.xiaomi.channel.commonutils.logger.b.m97a(str6);
                b(xMPushService, a3);
            } else if ("com.xiaomi.xmsf".contains(a3.f638b) && !a3.m549b() && m541a != null && m541a.m502a() != null && m541a.m502a().containsKey(DI.AB_NAME)) {
                b(xMPushService, a3);
                com.xiaomi.channel.commonutils.logger.b.c("receive abtest message. ack it." + m541a.m501a());
            } else if (a(xMPushService, str, a3, m541a)) {
                if (m541a != null && !TextUtils.isEmpty(m541a.m501a())) {
                    if (ak.m686b(a3)) {
                        a = en.a(xMPushService.getApplicationContext());
                        b = a3.b();
                        str4 = ak.b(a3);
                        m501a = m541a.m501a();
                        i2 = 2002;
                        str3 = null;
                    } else {
                        if (ak.m682a(a3)) {
                            a2 = en.a(xMPushService.getApplicationContext());
                            b2 = a3.b();
                            b3 = ak.b(a3);
                            m501a2 = m541a.m501a();
                            str5 = "7";
                        } else if (ak.c(a3)) {
                            a2 = en.a(xMPushService.getApplicationContext());
                            b2 = a3.b();
                            b3 = ak.b(a3);
                            m501a2 = m541a.m501a();
                            str5 = "8";
                        } else if (ak.d(a3)) {
                            a = en.a(xMPushService.getApplicationContext());
                            b = a3.b();
                            m501a = m541a.m501a();
                            i2 = AuthCode.StatusCode.PERMISSION_NOT_EXIST;
                            str3 = null;
                            str4 = "E100003";
                        }
                        a2.a(b2, b3, m501a2, str5);
                    }
                    a.a(b, str4, m501a, i2, str3);
                }
                if (hh.Notification == a3.f631a) {
                    try {
                        isVar = ce.a(xMPushService, a3);
                    } catch (ix e) {
                        com.xiaomi.channel.commonutils.logger.b.d("receive a message which action string is not valid. " + e);
                    }
                    if (isVar == null) {
                        com.xiaomi.channel.commonutils.logger.b.d("receiving an un-recognized notification message. " + a3.f631a);
                        z = false;
                        if (z && (isVar instanceof ig)) {
                            igVar = (ig) isVar;
                            if (hr.CancelPushMessage.f508a.equals(igVar.f655d) && igVar.m557a() != null) {
                                str2 = igVar.m557a().get(bk.M);
                                i = -2;
                                if (!TextUtils.isEmpty(str2)) {
                                    try {
                                        i = Integer.parseInt(str2);
                                    } catch (NumberFormatException e2) {
                                        com.xiaomi.channel.commonutils.logger.b.m97a("parse notifyId from STRING to INT failed: " + e2);
                                    }
                                }
                                if (i < -1) {
                                    com.xiaomi.channel.commonutils.logger.b.m97a("try to retract a message by notifyId=" + i);
                                    ak.a(xMPushService, a3.f638b, i);
                                } else {
                                    com.xiaomi.channel.commonutils.logger.b.m97a("try to retract a message by title&description.");
                                    ak.a(xMPushService, a3.f638b, igVar.m557a().get(bk.K), igVar.m557a().get(bk.L));
                                }
                                if (m541a != null && m541a.m502a() != null && com.xiaomi.push.j.m628a((Context) xMPushService) && "pulldown".equals(ay.a((Object) m541a.m502a()))) {
                                    ag.a(a3);
                                }
                                a(xMPushService, a3, igVar);
                                if (z2) {
                                    com.xiaomi.channel.commonutils.logger.b.m97a("broadcast passthrough message.");
                                    xMPushService.sendBroadcast(intent, ah.a(a3.f638b));
                                }
                            }
                        }
                    } else {
                        z = true;
                        if (z) {
                            igVar = (ig) isVar;
                            if (hr.CancelPushMessage.f508a.equals(igVar.f655d)) {
                                str2 = igVar.m557a().get(bk.M);
                                i = -2;
                                if (!TextUtils.isEmpty(str2)) {
                                }
                                if (i < -1) {
                                }
                                if (m541a != null) {
                                    ag.a(a3);
                                }
                                a(xMPushService, a3, igVar);
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
                en.a(xMPushService.getApplicationContext()).a(a3.b(), ak.b(a3), m541a.m501a(), "9");
            }
            if (a3.a() != hh.UnRegistration || "com.xiaomi.xmsf".equals(xMPushService.getPackageName())) {
                return;
            }
            xMPushService.stopSelf();
        }
    }

    public static void a(XMPushService xMPushService, byte[] bArr, long j) {
        Map<String, String> m502a;
        id a = a(bArr);
        if (a == null) {
            return;
        }
        if (TextUtils.isEmpty(a.f638b)) {
            com.xiaomi.channel.commonutils.logger.b.m97a("receive a mipush message without package name");
            return;
        }
        Long valueOf = Long.valueOf(System.currentTimeMillis());
        Intent a2 = a(bArr, valueOf.longValue());
        String a3 = ak.a(a);
        ha.a(xMPushService, a3, j, true, true, System.currentTimeMillis());
        hu m541a = a.m541a();
        if (m541a != null && m541a.m501a() != null) {
            com.xiaomi.channel.commonutils.logger.b.e(String.format("receive a message. appid=%1$s, msgid= %2$s, action=%3$s", a.m542a(), bd.a(m541a.m501a()), a.a()));
        }
        if (m541a != null) {
            m541a.a("mrt", Long.toString(valueOf.longValue()));
        }
        String str = "";
        if (hh.SendMessage == a.a() && v.a(xMPushService).m757a(a.f638b) && !ak.m682a(a)) {
            if (m541a != null) {
                str = m541a.m501a();
                if (ak.e(a)) {
                    en.a(xMPushService.getApplicationContext()).a(a.b(), ak.b(a), str, "1");
                }
            }
            com.xiaomi.channel.commonutils.logger.b.m97a("Drop a message for unregistered, msgid=" + str);
            a(xMPushService, a, a.f638b);
        } else if (hh.SendMessage == a.a() && v.a(xMPushService).m759c(a.f638b) && !ak.m682a(a)) {
            if (m541a != null) {
                str = m541a.m501a();
                if (ak.e(a)) {
                    en.a(xMPushService.getApplicationContext()).a(a.b(), ak.b(a), str, "2");
                }
            }
            com.xiaomi.channel.commonutils.logger.b.m97a("Drop a message for push closed, msgid=" + str);
            a(xMPushService, a, a.f638b);
        } else if (hh.SendMessage == a.a() && !TextUtils.equals(xMPushService.getPackageName(), "com.xiaomi.xmsf") && !TextUtils.equals(xMPushService.getPackageName(), a.f638b)) {
            com.xiaomi.channel.commonutils.logger.b.m97a("Receive a message with wrong package name, expect " + xMPushService.getPackageName() + ", received " + a.f638b);
            a(xMPushService, a, "unmatched_package", "package should be " + xMPushService.getPackageName() + ", but got " + a.f638b);
            if (m541a == null || !ak.e(a)) {
                return;
            }
            en.a(xMPushService.getApplicationContext()).a(a.b(), ak.b(a), m541a.m501a(), "3");
        } else if (hh.SendMessage != a.a() || com.xiaomi.push.i.a() != 999 || !com.xiaomi.push.i.a(xMPushService, a3)) {
            if (m541a == null || (m502a = m541a.m502a()) == null || !m502a.containsKey("hide") || !"true".equalsIgnoreCase(m502a.get("hide"))) {
                a(xMPushService, a3, bArr, a2);
            } else {
                b(xMPushService, a);
            }
        } else {
            com.xiaomi.channel.commonutils.logger.b.m97a("Receive the uninstalled dual app message");
            try {
                ah.a(xMPushService, ah.a(a3, a.m542a()));
                com.xiaomi.channel.commonutils.logger.b.m97a("uninstall " + a3 + " msg sent");
            } catch (gg e) {
                com.xiaomi.channel.commonutils.logger.b.d("Fail to send Message: " + e.getMessage());
                xMPushService.a(10, e);
            }
            ak.m679a((Context) xMPushService, a3);
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
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            return false;
        }
    }

    public static boolean a(Context context, String str, byte[] bArr) {
        if (com.xiaomi.push.g.m435a(context, str)) {
            Intent intent = new Intent("com.xiaomi.mipush.MESSAGE_ARRIVED");
            intent.putExtra("mipush_payload", bArr);
            intent.setPackage(str);
            try {
                if (context.getPackageManager().queryBroadcastReceivers(intent, 0).isEmpty()) {
                    return false;
                }
                com.xiaomi.channel.commonutils.logger.b.m97a("broadcast message arrived.");
                context.sendBroadcast(intent, ah.a(str));
                return true;
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.m97a("meet error when broadcast message arrived. " + e);
                return false;
            }
        }
        return false;
    }

    public static boolean a(id idVar) {
        return "com.xiaomi.xmsf".equals(idVar.f638b) && idVar.m541a() != null && idVar.m541a().m502a() != null && idVar.m541a().m502a().containsKey("miui_package_name");
    }

    public static boolean a(XMPushService xMPushService, String str, id idVar, hu huVar) {
        boolean z = true;
        if (huVar != null && huVar.m502a() != null && huVar.m502a().containsKey("__check_alive") && huVar.m502a().containsKey("__awake")) {
            ig igVar = new ig();
            igVar.b(idVar.m542a());
            igVar.d(str);
            igVar.c(hr.AwakeSystemApp.f508a);
            igVar.a(huVar.m501a());
            igVar.f650a = new HashMap();
            boolean m435a = com.xiaomi.push.g.m435a(xMPushService.getApplicationContext(), str);
            igVar.f650a.put("app_running", Boolean.toString(m435a));
            if (!m435a) {
                boolean parseBoolean = Boolean.parseBoolean(huVar.m502a().get("__awake"));
                igVar.f650a.put("awaked", Boolean.toString(parseBoolean));
                if (!parseBoolean) {
                    z = false;
                }
            }
            try {
                ah.a(xMPushService, ah.a(idVar.b(), idVar.m542a(), igVar, hh.Notification));
            } catch (gg e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
            }
        }
        return z;
    }

    public static void b(Context context, id idVar, byte[] bArr) {
        if (ak.m682a(idVar)) {
            return;
        }
        String a = ak.a(idVar);
        if (TextUtils.isEmpty(a) || a(context, a, bArr)) {
            return;
        }
        en.a(context).b(a, ak.b(idVar), idVar.m541a().m501a(), "1");
    }

    public static void b(XMPushService xMPushService, id idVar) {
        xMPushService.a(new aa(4, xMPushService, idVar));
    }

    public static boolean b(id idVar) {
        Map<String, String> m502a = idVar.m541a().m502a();
        return m502a != null && m502a.containsKey("notify_effect");
    }

    public static void c(XMPushService xMPushService, id idVar) {
        xMPushService.a(new ab(4, xMPushService, idVar));
    }

    public static boolean c(id idVar) {
        if (idVar.m541a() == null || idVar.m541a().m502a() == null) {
            return false;
        }
        return "1".equals(idVar.m541a().m502a().get("obslete_ads_message"));
    }

    public static void d(XMPushService xMPushService, id idVar) {
        xMPushService.a(new ac(4, xMPushService, idVar));
    }

    public void a(Context context, bg.b bVar, boolean z, int i, String str) {
        t m753a;
        if (z || (m753a = u.m753a(context)) == null || !"token-expired".equals(str)) {
            return;
        }
        u.a(context, m753a.f, m753a.d, m753a.e);
    }

    public void a(XMPushService xMPushService, fk fkVar, bg.b bVar) {
        try {
            a(xMPushService, fkVar.m404a(bVar.h), fkVar.c());
        } catch (IllegalArgumentException e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
        }
    }

    public void a(XMPushService xMPushService, gm gmVar, bg.b bVar) {
        if (!(gmVar instanceof gl)) {
            com.xiaomi.channel.commonutils.logger.b.m97a("not a mipush message");
            return;
        }
        gl glVar = (gl) gmVar;
        gj a = glVar.a("s");
        if (a != null) {
            try {
                a(xMPushService, bp.a(bp.a(bVar.h, glVar.j()), a.c()), ha.a(gmVar.mo446a()));
            } catch (IllegalArgumentException e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
            }
        }
    }
}
