package com.xiaomi.mipush.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.tbadk.core.atomData.ForumSquareActivityConfig;
import com.kwai.sodler.lib.ext.PluginError;
import com.xiaomi.mipush.sdk.PushMessageHandler;
import com.xiaomi.push.bm;
import com.xiaomi.push.bu;
import com.xiaomi.push.cy;
import com.xiaomi.push.ek;
import com.xiaomi.push.el;
import com.xiaomi.push.ev;
import com.xiaomi.push.hf;
import com.xiaomi.push.hk;
import com.xiaomi.push.hp;
import com.xiaomi.push.hr;
import com.xiaomi.push.hs;
import com.xiaomi.push.ht;
import com.xiaomi.push.hv;
import com.xiaomi.push.hw;
import com.xiaomi.push.ia;
import com.xiaomi.push.ib;
import com.xiaomi.push.ic;
import com.xiaomi.push.id;
import com.xiaomi.push.ie;
import com.xiaomi.push.ig;
import com.xiaomi.push.ii;
import com.xiaomi.push.ik;
import com.xiaomi.push.im;
import com.xiaomi.push.io;
import com.xiaomi.push.ip;
import com.xiaomi.push.iq;
import com.xiaomi.push.iv;
import com.xiaomi.push.service.az;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TimeZone;
/* loaded from: classes7.dex */
public class al {

    /* renamed from: a  reason: collision with root package name */
    public static al f40162a;

    /* renamed from: a  reason: collision with other field name */
    public static Object f60a = new Object();

    /* renamed from: a  reason: collision with other field name */
    public static Queue<String> f61a;

    /* renamed from: a  reason: collision with other field name */
    public Context f62a;

    public al(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f62a = applicationContext;
        if (applicationContext == null) {
            this.f62a = context;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:67:0x0142  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Intent a(Context context, String str, Map<String, String> map, int i) {
        Intent launchIntentForPackage;
        String str2;
        Intent intent;
        StringBuilder sb;
        String message;
        String protocol;
        if (map == null) {
            return null;
        }
        if (i != 0) {
            return com.xiaomi.push.service.ac.a(context, str, map, i);
        }
        if (map.containsKey("notify_effect")) {
            String str3 = map.get("notify_effect");
            int i2 = -1;
            String str4 = map.get("intent_flag");
            try {
                if (!TextUtils.isEmpty(str4)) {
                    i2 = Integer.parseInt(str4);
                }
            } catch (NumberFormatException e2) {
                com.xiaomi.channel.commonutils.logger.b.d("Cause by intent_flag: " + e2.getMessage());
            }
            if (az.f40980a.equals(str3)) {
                try {
                    launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
                } catch (Exception e3) {
                    com.xiaomi.channel.commonutils.logger.b.d("Cause: " + e3.getMessage());
                }
            } else if (az.f40981b.equals(str3)) {
                if (map.containsKey("intent_uri")) {
                    String str5 = map.get("intent_uri");
                    if (str5 != null) {
                        try {
                            intent = Intent.parseUri(str5, 1);
                        } catch (URISyntaxException e4) {
                            e = e4;
                            intent = null;
                        }
                        try {
                            intent.setPackage(str);
                        } catch (URISyntaxException e5) {
                            e = e5;
                            sb = new StringBuilder();
                            sb.append("Cause: ");
                            message = e.getMessage();
                            sb.append(message);
                            com.xiaomi.channel.commonutils.logger.b.d(sb.toString());
                            launchIntentForPackage = intent;
                            if (launchIntentForPackage != null) {
                            }
                            return null;
                        }
                        launchIntentForPackage = intent;
                    }
                } else if (map.containsKey(ForumSquareActivityConfig.FORUM_CLASS_NAME)) {
                    Intent intent2 = new Intent();
                    intent2.setComponent(new ComponentName(str, map.get(ForumSquareActivityConfig.FORUM_CLASS_NAME)));
                    launchIntentForPackage = intent2;
                }
                launchIntentForPackage = null;
            } else {
                if (az.f40982c.equals(str3) && (str2 = map.get("web_uri")) != null) {
                    String trim = str2.trim();
                    if (!trim.startsWith("http://") && !trim.startsWith("https://")) {
                        trim = "http://" + trim;
                    }
                    try {
                        protocol = new URL(trim).getProtocol();
                    } catch (MalformedURLException e6) {
                        e = e6;
                        intent = null;
                    }
                    if ("http".equals(protocol) || "https".equals(protocol)) {
                        intent = new Intent("android.intent.action.VIEW");
                        try {
                            intent.setData(Uri.parse(trim));
                        } catch (MalformedURLException e7) {
                            e = e7;
                            sb = new StringBuilder();
                            sb.append("Cause: ");
                            message = e.getMessage();
                            sb.append(message);
                            com.xiaomi.channel.commonutils.logger.b.d(sb.toString());
                            launchIntentForPackage = intent;
                            if (launchIntentForPackage != null) {
                            }
                            return null;
                        }
                        launchIntentForPackage = intent;
                    }
                }
                launchIntentForPackage = null;
            }
            if (launchIntentForPackage != null) {
                if (i2 >= 0) {
                    launchIntentForPackage.setFlags(i2);
                }
                launchIntentForPackage.addFlags(268435456);
                try {
                    if (context.getPackageManager().resolveActivity(launchIntentForPackage, 65536) != null) {
                        return launchIntentForPackage;
                    }
                    com.xiaomi.channel.commonutils.logger.b.m51a("not resolve activity:" + launchIntentForPackage);
                } catch (Exception e8) {
                    com.xiaomi.channel.commonutils.logger.b.d("Cause: " + e8.getMessage());
                }
            }
            return null;
        }
        return null;
    }

    private PushMessageHandler.a a(ib ibVar, boolean z, byte[] bArr, String str, int i, Intent intent) {
        el a2;
        String packageName;
        String m267a;
        int i2;
        String str2;
        MiPushMessage miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        ArrayList arrayList = null;
        ArrayList arrayList2 = null;
        miPushMessage = null;
        ArrayList arrayList3 = null;
        miPushMessage = null;
        try {
            iq a3 = ah.a(this.f62a, ibVar);
            if (a3 == null) {
                com.xiaomi.channel.commonutils.logger.b.d("receiving an un-recognized message. " + ibVar.f628a);
                el.a(this.f62a).b(this.f62a.getPackageName(), ek.m267a(i), str, "18");
                return null;
            }
            hf a4 = ibVar.a();
            com.xiaomi.channel.commonutils.logger.b.m51a("processing a message, action=" + a4);
            switch (am.f40163a[a4.ordinal()]) {
                case 1:
                    if (!ibVar.m439b()) {
                        com.xiaomi.channel.commonutils.logger.b.d("receiving an un-encrypt message(SendMessage).");
                        return null;
                    } else if (b.m92a(this.f62a).m103e() && !z) {
                        com.xiaomi.channel.commonutils.logger.b.m51a("receive a message in pause state. drop it");
                        el.a(this.f62a).a(this.f62a.getPackageName(), ek.m267a(i), str, com.tencent.connect.common.Constants.VIA_REPORT_TYPE_SET_AVATAR);
                        return null;
                    } else {
                        ii iiVar = (ii) a3;
                        hr a5 = iiVar.a();
                        if (a5 == null) {
                            com.xiaomi.channel.commonutils.logger.b.d("receive an empty message without push content, drop it");
                            el.a(this.f62a).b(this.f62a.getPackageName(), ek.m267a(i), str, com.tencent.connect.common.Constants.VIA_REPORT_TYPE_DATALINE);
                            return null;
                        }
                        if (z) {
                            if (com.xiaomi.push.service.ac.m556a(ibVar)) {
                                MiPushClient.reportIgnoreRegMessageClicked(this.f62a, a5.m380a(), ibVar.m431a(), ibVar.f635b, a5.b());
                            } else {
                                MiPushClient.reportMessageClicked(this.f62a, a5.m380a(), ibVar.m431a(), a5.b());
                            }
                        }
                        if (!z) {
                            if (!TextUtils.isEmpty(iiVar.d()) && MiPushClient.aliasSetTime(this.f62a, iiVar.d()) < 0) {
                                MiPushClient.addAlias(this.f62a, iiVar.d());
                            } else if (!TextUtils.isEmpty(iiVar.c()) && MiPushClient.topicSubscribedTime(this.f62a, iiVar.c()) < 0) {
                                MiPushClient.addTopic(this.f62a, iiVar.c());
                            }
                        }
                        hs hsVar = ibVar.f629a;
                        String str3 = (hsVar == null || hsVar.m389a() == null) ? null : ibVar.f629a.f541a.get("jobkey");
                        String str4 = str3;
                        if (TextUtils.isEmpty(str3)) {
                            str3 = a5.m380a();
                        }
                        if (z || !m73a(this.f62a, str3)) {
                            MiPushMessage generateMessage = PushMessageHelper.generateMessage(iiVar, ibVar.m431a(), z);
                            if (generateMessage.getPassThrough() == 0 && !z && com.xiaomi.push.service.ac.m557a(generateMessage.getExtra())) {
                                com.xiaomi.push.service.ac.m551a(this.f62a, ibVar, bArr);
                                return null;
                            }
                            com.xiaomi.channel.commonutils.logger.b.m51a("receive a message, msgid=" + a5.m380a() + ", jobkey=" + str3);
                            if (z && generateMessage.getExtra() != null && generateMessage.getExtra().containsKey("notify_effect")) {
                                Map<String, String> extra = generateMessage.getExtra();
                                String str5 = extra.get("notify_effect");
                                int intExtra = intent.getIntExtra("notification_click_button", 0);
                                com.xiaomi.channel.commonutils.logger.b.m51a("click style button is " + intExtra);
                                if (intExtra != 0 && ibVar.m431a() != null) {
                                    MiPushClient.clearNotification(this.f62a, ibVar.m431a().c());
                                }
                                if (com.xiaomi.push.service.ac.m556a(ibVar)) {
                                    Intent a6 = a(this.f62a, ibVar.f635b, extra, intExtra);
                                    a6.putExtra("eventMessageType", i);
                                    a6.putExtra(MiPushMessage.KEY_MESSAGE_ID, str);
                                    a6.putExtra("jobkey", str4);
                                    if (a6 == null) {
                                        com.xiaomi.channel.commonutils.logger.b.m51a("Getting Intent fail from ignore reg message. ");
                                        el.a(this.f62a).b(this.f62a.getPackageName(), ek.m267a(i), str, com.tencent.connect.common.Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR);
                                        return null;
                                    }
                                    String c2 = a5.c();
                                    if (!TextUtils.isEmpty(c2)) {
                                        a6.putExtra("payload", c2);
                                    }
                                    this.f62a.startActivity(a6);
                                    el.a(this.f62a).a(this.f62a.getPackageName(), ek.m267a(i), str, PluginError.ERROR_INS_INSTALL_PATH, str5);
                                } else {
                                    Context context = this.f62a;
                                    Intent a7 = a(context, context.getPackageName(), extra, intExtra);
                                    if (a7 != null) {
                                        if (!str5.equals(az.f40982c)) {
                                            a7.putExtra(PushMessageHelper.KEY_MESSAGE, generateMessage);
                                            a7.putExtra("eventMessageType", i);
                                            a7.putExtra(MiPushMessage.KEY_MESSAGE_ID, str);
                                            a7.putExtra("jobkey", str4);
                                        }
                                        this.f62a.startActivity(a7);
                                        com.xiaomi.channel.commonutils.logger.b.m51a("start activity succ");
                                        el.a(this.f62a).a(this.f62a.getPackageName(), ek.m267a(i), str, 1006, str5);
                                        if (str5.equals(az.f40982c)) {
                                            el.a(this.f62a).a(this.f62a.getPackageName(), ek.m267a(i), str, com.tencent.connect.common.Constants.VIA_REPORT_TYPE_JOININ_GROUP);
                                        }
                                    }
                                }
                                return null;
                            }
                            miPushMessage = generateMessage;
                        } else {
                            com.xiaomi.channel.commonutils.logger.b.m51a("drop a duplicate message, key=" + str3);
                            el a8 = el.a(this.f62a);
                            String packageName2 = this.f62a.getPackageName();
                            String m267a2 = ek.m267a(i);
                            a8.c(packageName2, m267a2, str, "2:" + str3);
                        }
                        if (ibVar.m431a() == null && !z) {
                            a(iiVar, ibVar);
                            break;
                        }
                    }
                    break;
                case 2:
                    ig igVar = (ig) a3;
                    String str6 = b.m92a(this.f62a).f78a;
                    if (TextUtils.isEmpty(str6) || !TextUtils.equals(str6, igVar.m460a())) {
                        com.xiaomi.channel.commonutils.logger.b.m51a("bad Registration result:");
                        el.a(this.f62a).b(this.f62a.getPackageName(), ek.m267a(i), str, com.tencent.connect.common.Constants.VIA_REPORT_TYPE_QQFAVORITES);
                        return null;
                    }
                    b.m92a(this.f62a).f78a = null;
                    int i3 = (igVar.f691a > 0L ? 1 : (igVar.f691a == 0L ? 0 : -1));
                    Context context2 = this.f62a;
                    if (i3 == 0) {
                        b.m92a(context2).b(igVar.f701e, igVar.f702f, igVar.f708l);
                        a2 = el.a(this.f62a);
                        packageName = this.f62a.getPackageName();
                        m267a = ek.m267a(i);
                        i2 = 6006;
                        str2 = "1";
                    } else {
                        a2 = el.a(context2);
                        packageName = this.f62a.getPackageName();
                        m267a = ek.m267a(i);
                        i2 = 6006;
                        str2 = "2";
                    }
                    a2.a(packageName, m267a, str, i2, str2);
                    if (!TextUtils.isEmpty(igVar.f701e)) {
                        arrayList3 = new ArrayList();
                        arrayList3.add(igVar.f701e);
                    }
                    MiPushCommandMessage generateCommandMessage = PushMessageHelper.generateCommandMessage(ev.COMMAND_REGISTER.f337a, arrayList3, igVar.f691a, igVar.f700d, null);
                    an.a(this.f62a).m90d();
                    return generateCommandMessage;
                case 3:
                    if (((im) a3).f767a == 0) {
                        b.m92a(this.f62a).m94a();
                        MiPushClient.clearExtras(this.f62a);
                    }
                    PushMessageHandler.a();
                    break;
                case 4:
                    ik ikVar = (ik) a3;
                    if (ikVar.f742a == 0) {
                        MiPushClient.addTopic(this.f62a, ikVar.b());
                    }
                    if (!TextUtils.isEmpty(ikVar.b())) {
                        arrayList2 = new ArrayList();
                        arrayList2.add(ikVar.b());
                    }
                    com.xiaomi.channel.commonutils.logger.b.e("resp-cmd:" + ev.COMMAND_SUBSCRIBE_TOPIC + StringUtil.ARRAY_ELEMENT_SEPARATOR + ikVar.a());
                    return PushMessageHelper.generateCommandMessage(ev.COMMAND_SUBSCRIBE_TOPIC.f337a, arrayList2, ikVar.f742a, ikVar.f748d, ikVar.c());
                case 5:
                    io ioVar = (io) a3;
                    if (ioVar.f787a == 0) {
                        MiPushClient.removeTopic(this.f62a, ioVar.b());
                    }
                    if (!TextUtils.isEmpty(ioVar.b())) {
                        arrayList = new ArrayList();
                        arrayList.add(ioVar.b());
                    }
                    com.xiaomi.channel.commonutils.logger.b.e("resp-cmd:" + ev.COMMAND_UNSUBSCRIBE_TOPIC + StringUtil.ARRAY_ELEMENT_SEPARATOR + ioVar.a());
                    return PushMessageHelper.generateCommandMessage(ev.COMMAND_UNSUBSCRIBE_TOPIC.f337a, arrayList, ioVar.f787a, ioVar.f793d, ioVar.c());
                case 6:
                    cy.a(this.f62a.getPackageName(), this.f62a, a3, hf.Command, bArr.length);
                    ia iaVar = (ia) a3;
                    String b2 = iaVar.b();
                    List<String> m425a = iaVar.m425a();
                    if (iaVar.f616a == 0) {
                        if (TextUtils.equals(b2, ev.COMMAND_SET_ACCEPT_TIME.f337a) && m425a != null && m425a.size() > 1) {
                            MiPushClient.addAcceptTime(this.f62a, m425a.get(0), m425a.get(1));
                            if ("00:00".equals(m425a.get(0)) && "00:00".equals(m425a.get(1))) {
                                b.m92a(this.f62a).a(true);
                            } else {
                                b.m92a(this.f62a).a(false);
                            }
                            m425a = a(TimeZone.getTimeZone("GMT+08"), TimeZone.getDefault(), m425a);
                        } else if (TextUtils.equals(b2, ev.COMMAND_SET_ALIAS.f337a) && m425a != null && m425a.size() > 0) {
                            MiPushClient.addAlias(this.f62a, m425a.get(0));
                        } else if (TextUtils.equals(b2, ev.COMMAND_UNSET_ALIAS.f337a) && m425a != null && m425a.size() > 0) {
                            MiPushClient.removeAlias(this.f62a, m425a.get(0));
                        } else if (TextUtils.equals(b2, ev.COMMAND_SET_ACCOUNT.f337a) && m425a != null && m425a.size() > 0) {
                            MiPushClient.addAccount(this.f62a, m425a.get(0));
                        } else if (TextUtils.equals(b2, ev.COMMAND_UNSET_ACCOUNT.f337a) && m425a != null && m425a.size() > 0) {
                            MiPushClient.removeAccount(this.f62a, m425a.get(0));
                        } else if (TextUtils.equals(b2, ev.COMMAND_CHK_VDEVID.f337a)) {
                            if (m425a != null && m425a.size() > 0) {
                                com.xiaomi.push.i.a(this.f62a, m425a.get(0));
                            }
                            return null;
                        }
                    }
                    com.xiaomi.channel.commonutils.logger.b.e("resp-cmd:" + b2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + iaVar.a());
                    return PushMessageHelper.generateCommandMessage(b2, m425a, iaVar.f616a, iaVar.f624d, iaVar.c());
                case 7:
                    cy.a(this.f62a.getPackageName(), this.f62a, a3, hf.Notification, bArr.length);
                    if (a3 instanceof hw) {
                        hw hwVar = (hw) a3;
                        String a9 = hwVar.a();
                        com.xiaomi.channel.commonutils.logger.b.e("resp-type:" + hwVar.b() + ", code:" + hwVar.f584a + StringUtil.ARRAY_ELEMENT_SEPARATOR + a9);
                        if (hp.DisablePushMessage.f506a.equalsIgnoreCase(hwVar.f591d)) {
                            if (hwVar.f584a == 0) {
                                synchronized (ae.class) {
                                    if (ae.a(this.f62a).m72a(a9)) {
                                        ae.a(this.f62a).c(a9);
                                        if ("syncing".equals(ae.a(this.f62a).a(at.DISABLE_PUSH))) {
                                            ae.a(this.f62a).a(at.DISABLE_PUSH, "synced");
                                            MiPushClient.clearNotification(this.f62a);
                                            MiPushClient.clearLocalNotificationType(this.f62a);
                                            PushMessageHandler.a();
                                            an.a(this.f62a).m87b();
                                        }
                                    }
                                }
                                break;
                            } else if ("syncing".equals(ae.a(this.f62a).a(at.DISABLE_PUSH))) {
                                synchronized (ae.class) {
                                    if (ae.a(this.f62a).m72a(a9)) {
                                        if (ae.a(this.f62a).a(a9) < 10) {
                                            ae.a(this.f62a).b(a9);
                                            an.a(this.f62a).a(true, a9);
                                        } else {
                                            ae.a(this.f62a).c(a9);
                                        }
                                    }
                                }
                                break;
                            }
                        } else if (hp.EnablePushMessage.f506a.equalsIgnoreCase(hwVar.f591d)) {
                            if (hwVar.f584a == 0) {
                                synchronized (ae.class) {
                                    if (ae.a(this.f62a).m72a(a9)) {
                                        ae.a(this.f62a).c(a9);
                                        if ("syncing".equals(ae.a(this.f62a).a(at.ENABLE_PUSH))) {
                                            ae.a(this.f62a).a(at.ENABLE_PUSH, "synced");
                                        }
                                    }
                                }
                                break;
                            } else if ("syncing".equals(ae.a(this.f62a).a(at.ENABLE_PUSH))) {
                                synchronized (ae.class) {
                                    if (ae.a(this.f62a).m72a(a9)) {
                                        if (ae.a(this.f62a).a(a9) < 10) {
                                            ae.a(this.f62a).b(a9);
                                            an.a(this.f62a).a(false, a9);
                                        } else {
                                            ae.a(this.f62a).c(a9);
                                        }
                                    }
                                }
                                break;
                            }
                        } else if (hp.ThirdPartyRegUpdate.f506a.equalsIgnoreCase(hwVar.f591d)) {
                            b(hwVar);
                            break;
                        } else if (hp.UploadTinyData.f506a.equalsIgnoreCase(hwVar.f591d)) {
                            a(hwVar);
                            break;
                        }
                        ae.a(this.f62a).c(a9);
                        break;
                    } else if (a3 instanceof ie) {
                        ie ieVar = (ie) a3;
                        if ("registration id expired".equalsIgnoreCase(ieVar.f652d)) {
                            List<String> allAlias = MiPushClient.getAllAlias(this.f62a);
                            List<String> allTopic = MiPushClient.getAllTopic(this.f62a);
                            List<String> allUserAccount = MiPushClient.getAllUserAccount(this.f62a);
                            String acceptTime = MiPushClient.getAcceptTime(this.f62a);
                            com.xiaomi.channel.commonutils.logger.b.e("resp-type:" + ieVar.f652d + StringUtil.ARRAY_ELEMENT_SEPARATOR + ieVar.m446a());
                            MiPushClient.reInitialize(this.f62a, ht.RegIdExpired);
                            for (String str7 : allAlias) {
                                MiPushClient.removeAlias(this.f62a, str7);
                                MiPushClient.setAlias(this.f62a, str7, null);
                            }
                            for (String str8 : allTopic) {
                                MiPushClient.removeTopic(this.f62a, str8);
                                MiPushClient.subscribe(this.f62a, str8, null);
                            }
                            for (String str9 : allUserAccount) {
                                MiPushClient.removeAccount(this.f62a, str9);
                                MiPushClient.setUserAccount(this.f62a, str9, null);
                            }
                            String[] split = acceptTime.split(",");
                            if (split.length == 2) {
                                MiPushClient.removeAcceptTime(this.f62a);
                                MiPushClient.addAcceptTime(this.f62a, split[0], split[1]);
                                break;
                            }
                        } else if (hp.ClientInfoUpdateOk.f506a.equalsIgnoreCase(ieVar.f652d)) {
                            if (ieVar.m447a() != null && ieVar.m447a().containsKey("app_version")) {
                                b.m92a(this.f62a).m95a(ieVar.m447a().get("app_version"));
                                break;
                            }
                        } else if (hp.AwakeApp.f506a.equalsIgnoreCase(ieVar.f652d)) {
                            if (ibVar.m439b() && ieVar.m447a() != null && ieVar.m447a().containsKey("awake_info")) {
                                Context context3 = this.f62a;
                                o.a(context3, b.m92a(context3).m93a(), com.xiaomi.push.service.aq.a(this.f62a).a(hk.AwakeInfoUploadWaySwitch.a(), 0), ieVar.m447a().get("awake_info"));
                                break;
                            }
                        } else {
                            try {
                                if (hp.NormalClientConfigUpdate.f506a.equalsIgnoreCase(ieVar.f652d)) {
                                    id idVar = new id();
                                    ip.a(idVar, ieVar.m452a());
                                    com.xiaomi.push.service.ar.a(com.xiaomi.push.service.aq.a(this.f62a), idVar);
                                } else if (hp.CustomClientConfigUpdate.f506a.equalsIgnoreCase(ieVar.f652d)) {
                                    ic icVar = new ic();
                                    ip.a(icVar, ieVar.m452a());
                                    com.xiaomi.push.service.ar.a(com.xiaomi.push.service.aq.a(this.f62a), icVar);
                                } else if (hp.SyncInfoResult.f506a.equalsIgnoreCase(ieVar.f652d)) {
                                    au.a(this.f62a, ieVar);
                                    break;
                                } else if (hp.ForceSync.f506a.equalsIgnoreCase(ieVar.f652d)) {
                                    com.xiaomi.channel.commonutils.logger.b.m51a("receive force sync notification");
                                    au.a(this.f62a, false);
                                    break;
                                } else if (hp.CancelPushMessage.f506a.equals(ieVar.f652d)) {
                                    com.xiaomi.channel.commonutils.logger.b.e("resp-type:" + ieVar.f652d + StringUtil.ARRAY_ELEMENT_SEPARATOR + ieVar.m446a());
                                    if (ieVar.m447a() != null) {
                                        int i4 = -2;
                                        if (ieVar.m447a().containsKey(az.K)) {
                                            String str10 = ieVar.m447a().get(az.K);
                                            if (!TextUtils.isEmpty(str10)) {
                                                try {
                                                    i4 = Integer.parseInt(str10);
                                                } catch (NumberFormatException e2) {
                                                    e2.printStackTrace();
                                                }
                                            }
                                        }
                                        if (i4 >= -1) {
                                            MiPushClient.clearNotification(this.f62a, i4);
                                        } else {
                                            MiPushClient.clearNotification(this.f62a, ieVar.m447a().containsKey(az.I) ? ieVar.m447a().get(az.I) : "", ieVar.m447a().containsKey(az.J) ? ieVar.m447a().get(az.J) : "");
                                        }
                                    }
                                    a(ieVar);
                                    break;
                                } else {
                                    try {
                                        if (hp.HybridRegisterResult.f506a.equals(ieVar.f652d)) {
                                            ig igVar2 = new ig();
                                            ip.a(igVar2, ieVar.m452a());
                                            MiPushClient4Hybrid.onReceiveRegisterResult(this.f62a, igVar2);
                                        } else if (hp.HybridUnregisterResult.f506a.equals(ieVar.f652d)) {
                                            im imVar = new im();
                                            ip.a(imVar, ieVar.m452a());
                                            MiPushClient4Hybrid.onReceiveUnregisterResult(this.f62a, imVar);
                                        } else if (!hp.PushLogUpload.f506a.equals(ieVar.f652d) && com.xiaomi.push.service.d.a(ieVar)) {
                                            com.xiaomi.channel.commonutils.logger.b.b("receive notification handle by cpra");
                                            break;
                                        }
                                        break;
                                    } catch (iv e3) {
                                        com.xiaomi.channel.commonutils.logger.b.a(e3);
                                        break;
                                    }
                                }
                                break;
                            } catch (iv unused) {
                                break;
                            }
                        }
                    }
                    break;
            }
            return miPushMessage;
        } catch (t e4) {
            com.xiaomi.channel.commonutils.logger.b.a(e4);
            a(ibVar);
            el.a(this.f62a).b(this.f62a.getPackageName(), ek.m267a(i), str, com.tencent.connect.common.Constants.VIA_ACT_TYPE_NINETEEN);
            return null;
        } catch (iv e5) {
            com.xiaomi.channel.commonutils.logger.b.a(e5);
            com.xiaomi.channel.commonutils.logger.b.d("receive a message which action string is not valid. is the reg expired?");
            el.a(this.f62a).b(this.f62a.getPackageName(), ek.m267a(i), str, "20");
            return null;
        }
    }

    private PushMessageHandler.a a(ib ibVar, byte[] bArr) {
        String str;
        iq a2;
        String str2 = null;
        try {
            a2 = ah.a(this.f62a, ibVar);
        } catch (t e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
            str = "message arrived: receive a message but decrypt failed. report when click.";
        } catch (iv e3) {
            com.xiaomi.channel.commonutils.logger.b.a(e3);
            str = "message arrived: receive a message which action string is not valid. is the reg expired?";
        }
        if (a2 == null) {
            com.xiaomi.channel.commonutils.logger.b.d("message arrived: receiving an un-recognized message. " + ibVar.f628a);
            return null;
        }
        hf a3 = ibVar.a();
        com.xiaomi.channel.commonutils.logger.b.m51a("message arrived: processing an arrived message, action=" + a3);
        if (am.f40163a[a3.ordinal()] != 1) {
            return null;
        }
        if (ibVar.m439b()) {
            ii iiVar = (ii) a2;
            hr a4 = iiVar.a();
            if (a4 != null) {
                hs hsVar = ibVar.f629a;
                if (hsVar != null && hsVar.m389a() != null) {
                    str2 = ibVar.f629a.f541a.get("jobkey");
                }
                MiPushMessage generateMessage = PushMessageHelper.generateMessage(iiVar, ibVar.m431a(), false);
                generateMessage.setArrivedMessage(true);
                com.xiaomi.channel.commonutils.logger.b.m51a("message arrived: receive a message, msgid=" + a4.m380a() + ", jobkey=" + str2);
                return generateMessage;
            }
            str = "message arrived: receive an empty message without push content, drop it";
        } else {
            str = "message arrived: receiving an un-encrypt message(SendMessage).";
        }
        com.xiaomi.channel.commonutils.logger.b.d(str);
        return null;
    }

    public static al a(Context context) {
        if (f40162a == null) {
            f40162a = new al(context);
        }
        return f40162a;
    }

    private void a() {
        SharedPreferences sharedPreferences = this.f62a.getSharedPreferences("mipush_extra", 0);
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - sharedPreferences.getLong(Constants.SP_KEY_LAST_REINITIALIZE, 0L)) > 1800000) {
            MiPushClient.reInitialize(this.f62a, ht.PackageUnregistered);
            sharedPreferences.edit().putLong(Constants.SP_KEY_LAST_REINITIALIZE, currentTimeMillis).commit();
        }
    }

    public static void a(Context context, String str) {
        synchronized (f60a) {
            f61a.remove(str);
            b.m92a(context);
            SharedPreferences a2 = b.a(context);
            String a3 = bm.a(f61a, ",");
            SharedPreferences.Editor edit = a2.edit();
            edit.putString("pref_msg_ids", a3);
            com.xiaomi.push.r.a(edit);
        }
    }

    private void a(hw hwVar) {
        String a2 = hwVar.a();
        com.xiaomi.channel.commonutils.logger.b.b("receive ack " + a2);
        Map<String, String> m403a = hwVar.m403a();
        if (m403a != null) {
            String str = m403a.get("real_source");
            if (TextUtils.isEmpty(str)) {
                return;
            }
            com.xiaomi.channel.commonutils.logger.b.b("receive ack : messageId = " + a2 + "  realSource = " + str);
            bu.a(this.f62a).a(a2, str, Boolean.valueOf(hwVar.f584a == 0));
        }
    }

    private void a(ib ibVar) {
        com.xiaomi.channel.commonutils.logger.b.m51a("receive a message but decrypt failed. report now.");
        ie ieVar = new ie(ibVar.m431a().f539a, false);
        ieVar.c(hp.DecryptMessageFail.f506a);
        ieVar.b(ibVar.m432a());
        ieVar.d(ibVar.f635b);
        HashMap hashMap = new HashMap();
        ieVar.f647a = hashMap;
        hashMap.put("regid", MiPushClient.getRegId(this.f62a));
        an.a(this.f62a).a((an) ieVar, hf.Notification, false, (hs) null);
    }

    private void a(ie ieVar) {
        hw hwVar = new hw();
        hwVar.c(hp.CancelPushMessageACK.f506a);
        hwVar.a(ieVar.m446a());
        hwVar.a(ieVar.a());
        hwVar.b(ieVar.b());
        hwVar.e(ieVar.c());
        hwVar.a(0L);
        hwVar.d("success clear push message.");
        an.a(this.f62a).a(hwVar, hf.Notification, false, true, null, false, this.f62a.getPackageName(), b.m92a(this.f62a).m93a(), false);
    }

    private void a(ii iiVar, ib ibVar) {
        hs m431a = ibVar.m431a();
        hv hvVar = new hv();
        hvVar.b(iiVar.b());
        hvVar.a(iiVar.m467a());
        hvVar.a(iiVar.a().a());
        if (!TextUtils.isEmpty(iiVar.c())) {
            hvVar.c(iiVar.c());
        }
        if (!TextUtils.isEmpty(iiVar.d())) {
            hvVar.d(iiVar.d());
        }
        hvVar.a(ip.a(this.f62a, ibVar));
        an.a(this.f62a).a((an) hvVar, hf.AckMessage, m431a);
    }

    private void a(String str, long j, e eVar) {
        at a2 = l.a(eVar);
        if (a2 == null) {
            return;
        }
        if (j == 0) {
            synchronized (ae.class) {
                if (ae.a(this.f62a).m72a(str)) {
                    ae.a(this.f62a).c(str);
                    if ("syncing".equals(ae.a(this.f62a).a(a2))) {
                        ae.a(this.f62a).a(a2, "synced");
                    }
                }
            }
        } else if (!"syncing".equals(ae.a(this.f62a).a(a2))) {
            ae.a(this.f62a).c(str);
        } else {
            synchronized (ae.class) {
                if (ae.a(this.f62a).m72a(str)) {
                    if (ae.a(this.f62a).a(str) < 10) {
                        ae.a(this.f62a).b(str);
                        an.a(this.f62a).a(str, a2, eVar);
                    } else {
                        ae.a(this.f62a).c(str);
                    }
                }
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m73a(Context context, String str) {
        synchronized (f60a) {
            b.m92a(context);
            SharedPreferences a2 = b.a(context);
            if (f61a == null) {
                String[] split = a2.getString("pref_msg_ids", "").split(",");
                f61a = new LinkedList();
                for (String str2 : split) {
                    f61a.add(str2);
                }
            }
            if (f61a.contains(str)) {
                return true;
            }
            f61a.add(str);
            if (f61a.size() > 25) {
                f61a.poll();
            }
            String a3 = bm.a(f61a, ",");
            SharedPreferences.Editor edit = a2.edit();
            edit.putString("pref_msg_ids", a3);
            com.xiaomi.push.r.a(edit);
            return false;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    private boolean m74a(ib ibVar) {
        Map<String, String> m389a = ibVar.m431a() == null ? null : ibVar.m431a().m389a();
        if (m389a == null) {
            return false;
        }
        String str = m389a.get(Constants.EXTRA_KEY_PUSH_SERVER_ACTION);
        return TextUtils.equals(str, Constants.EXTRA_VALUE_HYBRID_MESSAGE) || TextUtils.equals(str, Constants.EXTRA_VALUE_PLATFORM_MESSAGE);
    }

    private void b(hw hwVar) {
        long j;
        e eVar;
        com.xiaomi.channel.commonutils.logger.b.c("ASSEMBLE_PUSH : " + hwVar.toString());
        String a2 = hwVar.a();
        Map<String, String> m403a = hwVar.m403a();
        if (m403a != null) {
            String str = m403a.get(Constants.ASSEMBLE_PUSH_REG_INFO);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (str.contains("brand:" + af.FCM.name())) {
                com.xiaomi.channel.commonutils.logger.b.m51a("ASSEMBLE_PUSH : receive fcm token sync ack");
                i.b(this.f62a, e.ASSEMBLE_PUSH_FCM, str);
                j = hwVar.f584a;
                eVar = e.ASSEMBLE_PUSH_FCM;
            } else {
                if (str.contains("brand:" + af.HUAWEI.name())) {
                    com.xiaomi.channel.commonutils.logger.b.m51a("ASSEMBLE_PUSH : receive hw token sync ack");
                    i.b(this.f62a, e.ASSEMBLE_PUSH_HUAWEI, str);
                    j = hwVar.f584a;
                    eVar = e.ASSEMBLE_PUSH_HUAWEI;
                } else {
                    if (str.contains("brand:" + af.OPPO.name())) {
                        com.xiaomi.channel.commonutils.logger.b.m51a("ASSEMBLE_PUSH : receive COS token sync ack");
                        i.b(this.f62a, e.ASSEMBLE_PUSH_COS, str);
                        j = hwVar.f584a;
                        eVar = e.ASSEMBLE_PUSH_COS;
                    } else {
                        if (!str.contains("brand:" + af.VIVO.name())) {
                            return;
                        }
                        com.xiaomi.channel.commonutils.logger.b.m51a("ASSEMBLE_PUSH : receive FTOS token sync ack");
                        i.b(this.f62a, e.ASSEMBLE_PUSH_FTOS, str);
                        j = hwVar.f584a;
                        eVar = e.ASSEMBLE_PUSH_FTOS;
                    }
                }
            }
            a(a2, j, eVar);
        }
    }

    private void b(ib ibVar) {
        hs m431a = ibVar.m431a();
        hv hvVar = new hv();
        hvVar.b(ibVar.m432a());
        hvVar.a(m431a.m388a());
        hvVar.a(m431a.m386a());
        if (!TextUtils.isEmpty(m431a.m393b())) {
            hvVar.c(m431a.m393b());
        }
        hvVar.a(ip.a(this.f62a, ibVar));
        an.a(this.f62a).a((an) hvVar, hf.AckMessage, false, ibVar.m431a());
    }

    public PushMessageHandler.a a(Intent intent) {
        String str;
        el a2;
        String packageName;
        String str2;
        el a3;
        String packageName2;
        String format;
        String action = intent.getAction();
        com.xiaomi.channel.commonutils.logger.b.m51a("receive an intent from server, action=" + action);
        String stringExtra = intent.getStringExtra("mrt");
        if (stringExtra == null) {
            stringExtra = Long.toString(System.currentTimeMillis());
        }
        String stringExtra2 = intent.getStringExtra(MiPushMessage.KEY_MESSAGE_ID);
        int intExtra = intent.getIntExtra("eventMessageType", -1);
        if ("com.xiaomi.mipush.RECEIVE_MESSAGE".equals(action)) {
            byte[] byteArrayExtra = intent.getByteArrayExtra("mipush_payload");
            boolean booleanExtra = intent.getBooleanExtra("mipush_notified", false);
            if (byteArrayExtra == null) {
                com.xiaomi.channel.commonutils.logger.b.d("receiving an empty message, drop");
                el.a(this.f62a).a(this.f62a.getPackageName(), intent, com.tencent.connect.common.Constants.VIA_REPORT_TYPE_SET_AVATAR);
                return null;
            }
            ib ibVar = new ib();
            try {
                ip.a(ibVar, byteArrayExtra);
                b m92a = b.m92a(this.f62a);
                hs m431a = ibVar.m431a();
                if (ibVar.a() == hf.SendMessage && m431a != null && !m92a.m103e() && !booleanExtra) {
                    m431a.a("mrt", stringExtra);
                    m431a.a("mat", Long.toString(System.currentTimeMillis()));
                    if (m74a(ibVar)) {
                        com.xiaomi.channel.commonutils.logger.b.b("this is a mina's message, ack later");
                        m431a.a(Constants.EXTRA_KEY_HYBRID_MESSAGE_TS, String.valueOf(m431a.m386a()));
                        m431a.a(Constants.EXTRA_KEY_HYBRID_DEVICE_STATUS, String.valueOf((int) ip.a(this.f62a, ibVar)));
                    } else {
                        b(ibVar);
                    }
                }
                if (ibVar.a() == hf.SendMessage && !ibVar.m439b()) {
                    if (com.xiaomi.push.service.ac.m556a(ibVar)) {
                        Object[] objArr = new Object[2];
                        objArr[0] = ibVar.b();
                        objArr[1] = m431a != null ? m431a.m388a() : "";
                        com.xiaomi.channel.commonutils.logger.b.m51a(String.format("drop an un-encrypted wake-up messages. %1$s, %2$s", objArr));
                        a3 = el.a(this.f62a);
                        packageName2 = this.f62a.getPackageName();
                        format = String.format("13: %1$s", ibVar.b());
                    } else {
                        Object[] objArr2 = new Object[2];
                        objArr2[0] = ibVar.b();
                        objArr2[1] = m431a != null ? m431a.m388a() : "";
                        com.xiaomi.channel.commonutils.logger.b.m51a(String.format("drop an un-encrypted messages. %1$s, %2$s", objArr2));
                        a3 = el.a(this.f62a);
                        packageName2 = this.f62a.getPackageName();
                        format = String.format("14: %1$s", ibVar.b());
                    }
                    a3.a(packageName2, intent, format);
                    return null;
                }
                if (ibVar.a() == hf.SendMessage && ibVar.m439b() && com.xiaomi.push.service.ac.m556a(ibVar) && (!booleanExtra || m431a == null || m431a.m389a() == null || !m431a.m389a().containsKey("notify_effect"))) {
                    Object[] objArr3 = new Object[2];
                    objArr3[0] = ibVar.b();
                    objArr3[1] = m431a != null ? m431a.m388a() : "";
                    com.xiaomi.channel.commonutils.logger.b.m51a(String.format("drop a wake-up messages which not has 'notify_effect' attr. %1$s, %2$s", objArr3));
                    el.a(this.f62a).a(this.f62a.getPackageName(), intent, String.format("25: %1$s", ibVar.b()));
                    return null;
                }
                if (m92a.m101c() || ibVar.f628a == hf.Registration) {
                    if (!m92a.m101c() || !m92a.m104f()) {
                        return a(ibVar, booleanExtra, byteArrayExtra, stringExtra2, intExtra, intent);
                    }
                    if (ibVar.f628a == hf.UnRegistration) {
                        m92a.m94a();
                        MiPushClient.clearExtras(this.f62a);
                        PushMessageHandler.a();
                    } else {
                        MiPushClient.unregisterPush(this.f62a);
                    }
                } else if (com.xiaomi.push.service.ac.m556a(ibVar)) {
                    return a(ibVar, booleanExtra, byteArrayExtra, stringExtra2, intExtra, intent);
                } else {
                    boolean m102d = m92a.m102d();
                    com.xiaomi.channel.commonutils.logger.b.d("receive message without registration. need re-register!registered?" + m102d);
                    el.a(this.f62a).a(this.f62a.getPackageName(), intent, com.tencent.connect.common.Constants.VIA_REPORT_TYPE_WPA_STATE);
                    if (m102d) {
                        a();
                    }
                }
            } catch (iv e2) {
                e = e2;
                a2 = el.a(this.f62a);
                packageName = this.f62a.getPackageName();
                str2 = com.tencent.connect.common.Constants.VIA_REPORT_TYPE_START_WAP;
                a2.a(packageName, intent, str2);
                com.xiaomi.channel.commonutils.logger.b.a(e);
                return null;
            } catch (Exception e3) {
                e = e3;
                a2 = el.a(this.f62a);
                packageName = this.f62a.getPackageName();
                str2 = com.tencent.connect.common.Constants.VIA_REPORT_TYPE_START_GROUP;
                a2.a(packageName, intent, str2);
                com.xiaomi.channel.commonutils.logger.b.a(e);
                return null;
            }
        } else if ("com.xiaomi.mipush.ERROR".equals(action)) {
            MiPushCommandMessage miPushCommandMessage = new MiPushCommandMessage();
            ib ibVar2 = new ib();
            try {
                byte[] byteArrayExtra2 = intent.getByteArrayExtra("mipush_payload");
                if (byteArrayExtra2 != null) {
                    ip.a(ibVar2, byteArrayExtra2);
                }
            } catch (iv unused) {
            }
            miPushCommandMessage.setCommand(String.valueOf(ibVar2.a()));
            miPushCommandMessage.setResultCode(intent.getIntExtra("mipush_error_code", 0));
            miPushCommandMessage.setReason(intent.getStringExtra("mipush_error_msg"));
            com.xiaomi.channel.commonutils.logger.b.d("receive a error message. code = " + intent.getIntExtra("mipush_error_code", 0) + ", msg= " + intent.getStringExtra("mipush_error_msg"));
            return miPushCommandMessage;
        } else if ("com.xiaomi.mipush.MESSAGE_ARRIVED".equals(action)) {
            byte[] byteArrayExtra3 = intent.getByteArrayExtra("mipush_payload");
            if (byteArrayExtra3 == null) {
                com.xiaomi.channel.commonutils.logger.b.d("message arrived: receiving an empty message, drop");
                return null;
            }
            ib ibVar3 = new ib();
            try {
                ip.a(ibVar3, byteArrayExtra3);
                b m92a2 = b.m92a(this.f62a);
                if (com.xiaomi.push.service.ac.m556a(ibVar3)) {
                    str = "message arrived: receive ignore reg message, ignore!";
                } else if (!m92a2.m101c()) {
                    str = "message arrived: receive message without registration. need unregister or re-register!";
                } else if (!m92a2.m101c() || !m92a2.m104f()) {
                    return a(ibVar3, byteArrayExtra3);
                } else {
                    str = "message arrived: app info is invalidated";
                }
                com.xiaomi.channel.commonutils.logger.b.d(str);
            } catch (Exception e4) {
                com.xiaomi.channel.commonutils.logger.b.d("fail to deal with arrived message. " + e4);
            }
        }
        return null;
    }

    public List<String> a(TimeZone timeZone, TimeZone timeZone2, List<String> list) {
        if (timeZone.equals(timeZone2)) {
            return list;
        }
        long rawOffset = ((timeZone.getRawOffset() - timeZone2.getRawOffset()) / 1000) / 60;
        long parseLong = ((((Long.parseLong(list.get(0).split(":")[0]) * 60) + Long.parseLong(list.get(0).split(":")[1])) - rawOffset) + 1440) % 1440;
        long parseLong2 = ((((Long.parseLong(list.get(1).split(":")[0]) * 60) + Long.parseLong(list.get(1).split(":")[1])) - rawOffset) + 1440) % 1440;
        ArrayList arrayList = new ArrayList();
        arrayList.add(String.format("%1$02d:%2$02d", Long.valueOf(parseLong / 60), Long.valueOf(parseLong % 60)));
        arrayList.add(String.format("%1$02d:%2$02d", Long.valueOf(parseLong2 / 60), Long.valueOf(parseLong2 % 60)));
        return arrayList;
    }
}
