package com.xiaomi.push.service;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.baidu.searchbox.live.interfaces.DI;
import com.baidu.searchbox.player.model.YYOption;
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
/* loaded from: classes10.dex */
public class y {
    public static Intent a(byte[] bArr, long j) {
        id a = a(bArr);
        if (a == null) {
            return null;
        }
        Intent intent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
        intent.putExtra("mipush_payload", bArr);
        intent.putExtra("mrt", Long.toString(j));
        intent.setPackage(a.f639b);
        return intent;
    }

    public static id a(Context context, id idVar) {
        return a(context, idVar, (Map<String, String>) null);
    }

    public static id a(Context context, id idVar, Map<String, String> map) {
        hx hxVar = new hx();
        hxVar.b(idVar.m625a());
        hu m624a = idVar.m624a();
        if (m624a != null) {
            hxVar.a(m624a.m584a());
            hxVar.a(m624a.m582a());
            if (!TextUtils.isEmpty(m624a.m589b())) {
                hxVar.c(m624a.m589b());
            }
        }
        hxVar.a(ir.a(context, idVar));
        id a = ah.a(idVar.b(), idVar.m625a(), hxVar, hh.AckMessage);
        hu m624a2 = idVar.m624a();
        if (m624a2 != null) {
            m624a2 = br.a(m624a2.m583a());
        }
        m624a2.a("mat", Long.toString(System.currentTimeMillis()));
        if (map != null) {
            try {
                if (map.size() > 0) {
                    for (String str : map.keySet()) {
                        m624a2.a(str, map.get(str));
                    }
                }
            } catch (Throwable unused) {
            }
        }
        a.a(m624a2);
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
            idVar.m624a();
            ak.c m761a = ak.m761a(context, idVar, bArr);
            if (m761a.a > 0 && !TextUtils.isEmpty(m761a.f896a)) {
                ha.a(context, m761a.f896a, m761a.a, true, false, System.currentTimeMillis());
            }
            if (!com.xiaomi.push.j.m711a(context) || !ag.a(context, idVar, m761a.f897a)) {
                b(context, idVar, bArr);
                return;
            }
            ag.m756a(context, idVar);
            com.xiaomi.channel.commonutils.logger.b.m180a("consume this broadcast by tts");
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m180a("notify push msg error " + e);
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
        String m584a;
        int i2;
        String str3;
        String str4;
        en a2;
        String b2;
        String b3;
        String m584a2;
        String str5;
        String str6;
        id a3 = a(bArr);
        hu m624a = a3.m624a();
        is isVar = null;
        String str7 = null;
        if (bArr != null) {
            da.a(a3.b(), xMPushService.getApplicationContext(), null, a3.a(), bArr.length);
        }
        if (c(a3) && a(xMPushService, str)) {
            if (ak.e(a3)) {
                en.a(xMPushService.getApplicationContext()).a(a3.b(), ak.b(a3), m624a.m584a(), "5");
            }
            c(xMPushService, a3);
        } else if (a(a3) && !a(xMPushService, str) && !b(a3)) {
            if (ak.e(a3)) {
                en.a(xMPushService.getApplicationContext()).a(a3.b(), ak.b(a3), m624a.m584a(), "6");
            }
            d(xMPushService, a3);
        } else if ((!ak.m765a(a3) || !com.xiaomi.push.g.c(xMPushService, a3.f639b)) && !a(xMPushService, intent)) {
            if (!com.xiaomi.push.g.c(xMPushService, a3.f639b)) {
                if (ak.e(a3)) {
                    en.a(xMPushService.getApplicationContext()).b(a3.b(), ak.b(a3), m624a.m584a(), "2");
                }
                a(xMPushService, a3);
                return;
            }
            com.xiaomi.channel.commonutils.logger.b.m180a("receive a mipush message, we can see the app, but we can't see the receiver.");
            if (ak.e(a3)) {
                en.a(xMPushService.getApplicationContext()).b(a3.b(), ak.b(a3), m624a.m584a(), "3");
            }
        } else {
            boolean z2 = false;
            if (hh.Registration == a3.a()) {
                String b4 = a3.b();
                SharedPreferences.Editor edit = xMPushService.getSharedPreferences("pref_registered_pkg_names", 0).edit();
                edit.putString(b4, a3.f635a);
                edit.commit();
                ii a4 = n.a(a3);
                if (a4.a() != 0 || TextUtils.isEmpty(a4.b())) {
                    com.xiaomi.channel.commonutils.logger.b.d("read regSecret failed");
                } else {
                    n.a(xMPushService, b4, a4.b());
                }
                v.a(xMPushService).e(b4);
                v.a(xMPushService).f(b4);
                en.a(xMPushService.getApplicationContext()).a(b4, "E100003", m624a.m584a(), AuthCode.StatusCode.CERT_FINGERPRINT_ERROR, null);
                if (!TextUtils.isEmpty(m624a.m584a())) {
                    intent.putExtra(MiPushMessage.KEY_MESSAGE_ID, m624a.m584a());
                    intent.putExtra("eventMessageType", 6000);
                }
            }
            if (ak.c(a3)) {
                en.a(xMPushService.getApplicationContext()).a(a3.b(), ak.b(a3), m624a.m584a(), 1001, System.currentTimeMillis(), null);
                if (!TextUtils.isEmpty(m624a.m584a())) {
                    intent.putExtra(MiPushMessage.KEY_MESSAGE_ID, m624a.m584a());
                    intent.putExtra("eventMessageType", 1000);
                }
            }
            if (ak.m769b(a3)) {
                en.a(xMPushService.getApplicationContext()).a(a3.b(), ak.b(a3), m624a.m584a(), 2001, System.currentTimeMillis(), null);
                if (!TextUtils.isEmpty(m624a.m584a())) {
                    intent.putExtra(MiPushMessage.KEY_MESSAGE_ID, m624a.m584a());
                    intent.putExtra("eventMessageType", 2000);
                }
            }
            if (ak.m765a(a3)) {
                en.a(xMPushService.getApplicationContext()).a(a3.b(), ak.b(a3), m624a.m584a(), 3001, System.currentTimeMillis(), null);
                if (!TextUtils.isEmpty(m624a.m584a())) {
                    intent.putExtra(MiPushMessage.KEY_MESSAGE_ID, m624a.m584a());
                    intent.putExtra("eventMessageType", 3000);
                }
            }
            if (m624a != null && !TextUtils.isEmpty(m624a.m592c()) && !TextUtils.isEmpty(m624a.d()) && m624a.f546b != 1 && !ak.m764a((Context) xMPushService, a3.f639b, ak.m766a(m624a.m585a()))) {
                if (m624a != null) {
                    Map<String, String> map = m624a.f544a;
                    str7 = map != null ? map.get("jobkey") : null;
                    if (TextUtils.isEmpty(str7)) {
                        str7 = m624a.m584a();
                    }
                    z2 = am.a(xMPushService, a3.f639b, str7);
                }
                if (z2) {
                    en.a(xMPushService.getApplicationContext()).c(a3.b(), ak.b(a3), m624a.m584a(), "1:" + str7);
                    str6 = "drop a duplicate message, key=" + str7;
                } else if (com.xiaomi.push.j.m711a((Context) xMPushService) && ag.m757a(a3)) {
                    str6 = "receive pull down message";
                } else {
                    a(xMPushService, a3, bArr);
                    b(xMPushService, a3);
                }
                com.xiaomi.channel.commonutils.logger.b.m180a(str6);
                b(xMPushService, a3);
            } else if ("com.xiaomi.xmsf".contains(a3.f639b) && !a3.m632b() && m624a != null && m624a.m585a() != null && m624a.m585a().containsKey(DI.AB_NAME)) {
                b(xMPushService, a3);
                com.xiaomi.channel.commonutils.logger.b.c("receive abtest message. ack it." + m624a.m584a());
            } else if (a(xMPushService, str, a3, m624a)) {
                if (m624a != null && !TextUtils.isEmpty(m624a.m584a())) {
                    if (ak.m769b(a3)) {
                        a = en.a(xMPushService.getApplicationContext());
                        b = a3.b();
                        str4 = ak.b(a3);
                        m584a = m624a.m584a();
                        i2 = 2002;
                        str3 = null;
                    } else {
                        if (ak.m765a(a3)) {
                            a2 = en.a(xMPushService.getApplicationContext());
                            b2 = a3.b();
                            b3 = ak.b(a3);
                            m584a2 = m624a.m584a();
                            str5 = "7";
                        } else if (ak.c(a3)) {
                            a2 = en.a(xMPushService.getApplicationContext());
                            b2 = a3.b();
                            b3 = ak.b(a3);
                            m584a2 = m624a.m584a();
                            str5 = "8";
                        } else if (ak.d(a3)) {
                            a = en.a(xMPushService.getApplicationContext());
                            b = a3.b();
                            m584a = m624a.m584a();
                            i2 = AuthCode.StatusCode.PERMISSION_NOT_EXIST;
                            str3 = null;
                            str4 = "E100003";
                        }
                        a2.a(b2, b3, m584a2, str5);
                    }
                    a.a(b, str4, m584a, i2, str3);
                }
                if (hh.Notification == a3.f632a) {
                    try {
                        isVar = ce.a(xMPushService, a3);
                    } catch (ix e) {
                        com.xiaomi.channel.commonutils.logger.b.d("receive a message which action string is not valid. " + e);
                    }
                    if (isVar == null) {
                        com.xiaomi.channel.commonutils.logger.b.d("receiving an un-recognized notification message. " + a3.f632a);
                        z = false;
                        if (z && (isVar instanceof ig)) {
                            igVar = (ig) isVar;
                            if (hr.CancelPushMessage.f509a.equals(igVar.f656d) && igVar.m640a() != null) {
                                str2 = igVar.m640a().get(bk.M);
                                i = -2;
                                if (!TextUtils.isEmpty(str2)) {
                                    try {
                                        i = Integer.parseInt(str2);
                                    } catch (NumberFormatException e2) {
                                        com.xiaomi.channel.commonutils.logger.b.m180a("parse notifyId from STRING to INT failed: " + e2);
                                    }
                                }
                                if (i < -1) {
                                    com.xiaomi.channel.commonutils.logger.b.m180a("try to retract a message by notifyId=" + i);
                                    ak.a(xMPushService, a3.f639b, i);
                                } else {
                                    com.xiaomi.channel.commonutils.logger.b.m180a("try to retract a message by title&description.");
                                    ak.a(xMPushService, a3.f639b, igVar.m640a().get(bk.K), igVar.m640a().get(bk.L));
                                }
                                if (m624a != null && m624a.m585a() != null && com.xiaomi.push.j.m711a((Context) xMPushService) && "pulldown".equals(ay.a((Object) m624a.m585a()))) {
                                    ag.a(a3);
                                }
                                a(xMPushService, a3, igVar);
                                if (z2) {
                                    com.xiaomi.channel.commonutils.logger.b.m180a("broadcast passthrough message.");
                                    xMPushService.sendBroadcast(intent, ah.a(a3.f639b));
                                }
                            }
                        }
                    } else {
                        z = true;
                        if (z) {
                            igVar = (ig) isVar;
                            if (hr.CancelPushMessage.f509a.equals(igVar.f656d)) {
                                str2 = igVar.m640a().get(bk.M);
                                i = -2;
                                if (!TextUtils.isEmpty(str2)) {
                                }
                                if (i < -1) {
                                }
                                if (m624a != null) {
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
                en.a(xMPushService.getApplicationContext()).a(a3.b(), ak.b(a3), m624a.m584a(), "9");
            }
            if (a3.a() != hh.UnRegistration || "com.xiaomi.xmsf".equals(xMPushService.getPackageName())) {
                return;
            }
            xMPushService.stopSelf();
        }
    }

    public static void a(XMPushService xMPushService, byte[] bArr, long j) {
        Map<String, String> m585a;
        id a = a(bArr);
        if (a == null) {
            return;
        }
        if (TextUtils.isEmpty(a.f639b)) {
            com.xiaomi.channel.commonutils.logger.b.m180a("receive a mipush message without package name");
            return;
        }
        Long valueOf = Long.valueOf(System.currentTimeMillis());
        Intent a2 = a(bArr, valueOf.longValue());
        String a3 = ak.a(a);
        ha.a(xMPushService, a3, j, true, true, System.currentTimeMillis());
        hu m624a = a.m624a();
        if (m624a != null && m624a.m584a() != null) {
            com.xiaomi.channel.commonutils.logger.b.e(String.format("receive a message. appid=%1$s, msgid= %2$s, action=%3$s", a.m625a(), bd.a(m624a.m584a()), a.a()));
        }
        if (m624a != null) {
            m624a.a("mrt", Long.toString(valueOf.longValue()));
        }
        String str = "";
        if (hh.SendMessage == a.a() && v.a(xMPushService).m840a(a.f639b) && !ak.m765a(a)) {
            if (m624a != null) {
                str = m624a.m584a();
                if (ak.e(a)) {
                    en.a(xMPushService.getApplicationContext()).a(a.b(), ak.b(a), str, "1");
                }
            }
            com.xiaomi.channel.commonutils.logger.b.m180a("Drop a message for unregistered, msgid=" + str);
            a(xMPushService, a, a.f639b);
        } else if (hh.SendMessage == a.a() && v.a(xMPushService).m842c(a.f639b) && !ak.m765a(a)) {
            if (m624a != null) {
                str = m624a.m584a();
                if (ak.e(a)) {
                    en.a(xMPushService.getApplicationContext()).a(a.b(), ak.b(a), str, "2");
                }
            }
            com.xiaomi.channel.commonutils.logger.b.m180a("Drop a message for push closed, msgid=" + str);
            a(xMPushService, a, a.f639b);
        } else if (hh.SendMessage == a.a() && !TextUtils.equals(xMPushService.getPackageName(), "com.xiaomi.xmsf") && !TextUtils.equals(xMPushService.getPackageName(), a.f639b)) {
            com.xiaomi.channel.commonutils.logger.b.m180a("Receive a message with wrong package name, expect " + xMPushService.getPackageName() + ", received " + a.f639b);
            a(xMPushService, a, "unmatched_package", "package should be " + xMPushService.getPackageName() + ", but got " + a.f639b);
            if (m624a == null || !ak.e(a)) {
                return;
            }
            en.a(xMPushService.getApplicationContext()).a(a.b(), ak.b(a), m624a.m584a(), "3");
        } else if (hh.SendMessage != a.a() || com.xiaomi.push.i.a() != 999 || !com.xiaomi.push.i.a(xMPushService, a3)) {
            if (m624a == null || (m585a = m624a.m585a()) == null || !m585a.containsKey("hide") || !YYOption.IsLive.VALUE_TRUE.equalsIgnoreCase(m585a.get("hide"))) {
                a(xMPushService, a3, bArr, a2);
            } else {
                b(xMPushService, a);
            }
        } else {
            com.xiaomi.channel.commonutils.logger.b.m180a("Receive the uninstalled dual app message");
            try {
                ah.a(xMPushService, ah.a(a3, a.m625a()));
                com.xiaomi.channel.commonutils.logger.b.m180a("uninstall " + a3 + " msg sent");
            } catch (gg e) {
                com.xiaomi.channel.commonutils.logger.b.d("Fail to send Message: " + e.getMessage());
                xMPushService.a(10, e);
            }
            ak.m762a((Context) xMPushService, a3);
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
        if (com.xiaomi.push.g.m518a(context, str)) {
            Intent intent = new Intent("com.xiaomi.mipush.MESSAGE_ARRIVED");
            intent.putExtra("mipush_payload", bArr);
            intent.setPackage(str);
            try {
                if (context.getPackageManager().queryBroadcastReceivers(intent, 0).isEmpty()) {
                    return false;
                }
                com.xiaomi.channel.commonutils.logger.b.m180a("broadcast message arrived.");
                context.sendBroadcast(intent, ah.a(str));
                return true;
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.m180a("meet error when broadcast message arrived. " + e);
                return false;
            }
        }
        return false;
    }

    public static boolean a(id idVar) {
        return "com.xiaomi.xmsf".equals(idVar.f639b) && idVar.m624a() != null && idVar.m624a().m585a() != null && idVar.m624a().m585a().containsKey("miui_package_name");
    }

    public static boolean a(XMPushService xMPushService, String str, id idVar, hu huVar) {
        boolean z = true;
        if (huVar != null && huVar.m585a() != null && huVar.m585a().containsKey("__check_alive") && huVar.m585a().containsKey("__awake")) {
            ig igVar = new ig();
            igVar.b(idVar.m625a());
            igVar.d(str);
            igVar.c(hr.AwakeSystemApp.f509a);
            igVar.a(huVar.m584a());
            igVar.f651a = new HashMap();
            boolean m518a = com.xiaomi.push.g.m518a(xMPushService.getApplicationContext(), str);
            igVar.f651a.put("app_running", Boolean.toString(m518a));
            if (!m518a) {
                boolean parseBoolean = Boolean.parseBoolean(huVar.m585a().get("__awake"));
                igVar.f651a.put("awaked", Boolean.toString(parseBoolean));
                if (!parseBoolean) {
                    z = false;
                }
            }
            try {
                ah.a(xMPushService, ah.a(idVar.b(), idVar.m625a(), igVar, hh.Notification));
            } catch (gg e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
            }
        }
        return z;
    }

    public static void b(Context context, id idVar, byte[] bArr) {
        if (ak.m765a(idVar)) {
            return;
        }
        String a = ak.a(idVar);
        if (TextUtils.isEmpty(a) || a(context, a, bArr)) {
            return;
        }
        en.a(context).b(a, ak.b(idVar), idVar.m624a().m584a(), "1");
    }

    public static void b(XMPushService xMPushService, id idVar) {
        xMPushService.a(new aa(4, xMPushService, idVar));
    }

    public static boolean b(id idVar) {
        Map<String, String> m585a = idVar.m624a().m585a();
        return m585a != null && m585a.containsKey("notify_effect");
    }

    public static void c(XMPushService xMPushService, id idVar) {
        xMPushService.a(new ab(4, xMPushService, idVar));
    }

    public static boolean c(id idVar) {
        if (idVar.m624a() == null || idVar.m624a().m585a() == null) {
            return false;
        }
        return "1".equals(idVar.m624a().m585a().get("obslete_ads_message"));
    }

    public static void d(XMPushService xMPushService, id idVar) {
        xMPushService.a(new ac(4, xMPushService, idVar));
    }

    public void a(Context context, bg.b bVar, boolean z, int i, String str) {
        t m836a;
        if (z || (m836a = u.m836a(context)) == null || !"token-expired".equals(str)) {
            return;
        }
        u.a(context, m836a.f, m836a.d, m836a.e);
    }

    public void a(XMPushService xMPushService, fk fkVar, bg.b bVar) {
        try {
            a(xMPushService, fkVar.m487a(bVar.h), fkVar.c());
        } catch (IllegalArgumentException e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
        }
    }

    public void a(XMPushService xMPushService, gm gmVar, bg.b bVar) {
        if (!(gmVar instanceof gl)) {
            com.xiaomi.channel.commonutils.logger.b.m180a("not a mipush message");
            return;
        }
        gl glVar = (gl) gmVar;
        gj a = glVar.a("s");
        if (a != null) {
            try {
                a(xMPushService, bp.a(bp.a(bVar.h, glVar.j()), a.c()), ha.a(gmVar.mo529a()));
            } catch (IllegalArgumentException e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
            }
        }
    }
}
