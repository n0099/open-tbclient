package com.xiaomi.mipush.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.ServiceInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.tbadk.core.atomData.ForumSquareActivityConfig;
import com.kwai.sodler.lib.ext.PluginError;
import com.xiaomi.mipush.sdk.PushMessageHandler;
import com.xiaomi.push.bf;
import com.xiaomi.push.bp;
import com.xiaomi.push.df;
import com.xiaomi.push.fa;
import com.xiaomi.push.fb;
import com.xiaomi.push.fg;
import com.xiaomi.push.hm;
import com.xiaomi.push.hr;
import com.xiaomi.push.hw;
import com.xiaomi.push.hy;
import com.xiaomi.push.hz;
import com.xiaomi.push.ia;
import com.xiaomi.push.ic;
import com.xiaomi.push.id;
import com.xiaomi.push.ih;
import com.xiaomi.push.ii;
import com.xiaomi.push.ij;
import com.xiaomi.push.ik;
import com.xiaomi.push.il;
import com.xiaomi.push.in;
import com.xiaomi.push.ip;
import com.xiaomi.push.ir;
import com.xiaomi.push.it;
import com.xiaomi.push.iv;
import com.xiaomi.push.iw;
import com.xiaomi.push.ix;
import com.xiaomi.push.jc;
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
import org.apache.http.HttpHost;
/* loaded from: classes5.dex */
public class an {

    /* renamed from: a  reason: collision with root package name */
    private static an f8214a = null;

    /* renamed from: a  reason: collision with other field name */
    private static Object f44a = new Object();

    /* renamed from: a  reason: collision with other field name */
    private static Queue<String> f45a;

    /* renamed from: a  reason: collision with other field name */
    private Context f46a;

    private an(Context context) {
        this.f46a = context.getApplicationContext();
        if (this.f46a == null) {
            this.f46a = context;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0032 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:87:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Intent a(Context context, String str, Map<String, String> map) {
        int i;
        Intent intent;
        String str2;
        MalformedURLException e;
        Intent intent2;
        if (map == null || !map.containsKey("notify_effect")) {
            return null;
        }
        String str3 = map.get("notify_effect");
        String str4 = map.get("intent_flag");
        try {
        } catch (NumberFormatException e2) {
            com.xiaomi.channel.commonutils.logger.b.d("Cause by intent_flag: " + e2.getMessage());
        }
        if (!TextUtils.isEmpty(str4)) {
            i = Integer.parseInt(str4);
            if (com.xiaomi.push.service.at.f8529a.equals(str3)) {
                if (com.xiaomi.push.service.at.b.equals(str3)) {
                    if (map.containsKey("intent_uri")) {
                        String str5 = map.get("intent_uri");
                        if (str5 != null) {
                            try {
                                intent = Intent.parseUri(str5, 1);
                            } catch (URISyntaxException e3) {
                                e = e3;
                                intent = null;
                            }
                            try {
                                intent.setPackage(str);
                            } catch (URISyntaxException e4) {
                                e = e4;
                                com.xiaomi.channel.commonutils.logger.b.d("Cause: " + e.getMessage());
                                if (intent == null) {
                                }
                            }
                        } else {
                            intent = null;
                        }
                    } else if (map.containsKey(ForumSquareActivityConfig.FORUM_CLASS_NAME)) {
                        Intent intent3 = new Intent();
                        intent3.setComponent(new ComponentName(str, map.get(ForumSquareActivityConfig.FORUM_CLASS_NAME)));
                        intent = intent3;
                    }
                } else if (com.xiaomi.push.service.at.c.equals(str3) && (str2 = map.get("web_uri")) != null) {
                    String trim = str2.trim();
                    String str6 = (trim.startsWith("http://") || trim.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX)) ? trim : "http://" + trim;
                    try {
                        String protocol = new URL(str6).getProtocol();
                        if (HttpHost.DEFAULT_SCHEME_NAME.equals(protocol) || "https".equals(protocol)) {
                            intent = new Intent("android.intent.action.VIEW");
                            try {
                                intent.setData(Uri.parse(str6));
                            } catch (MalformedURLException e5) {
                                e = e5;
                                intent2 = intent;
                                com.xiaomi.channel.commonutils.logger.b.d("Cause: " + e.getMessage());
                                intent = intent2;
                                if (intent == null) {
                                }
                            }
                        } else {
                            intent = null;
                        }
                    } catch (MalformedURLException e6) {
                        e = e6;
                        intent2 = null;
                    }
                }
                intent = null;
            } else {
                try {
                    intent = context.getPackageManager().getLaunchIntentForPackage(str);
                } catch (Exception e7) {
                    com.xiaomi.channel.commonutils.logger.b.d("Cause: " + e7.getMessage());
                    intent = null;
                }
            }
            if (intent == null) {
                if (i >= 0) {
                    intent.setFlags(i);
                }
                intent.addFlags(268435456);
                try {
                    if (context.getPackageManager().resolveActivity(intent, 65536) != null) {
                        return intent;
                    }
                    com.xiaomi.channel.commonutils.logger.b.m58a("not resolve activity:" + intent);
                    return null;
                } catch (Exception e8) {
                    com.xiaomi.channel.commonutils.logger.b.d("Cause: " + e8.getMessage());
                    return null;
                }
            }
            return null;
        }
        i = -1;
        if (com.xiaomi.push.service.at.f8529a.equals(str3)) {
        }
        if (intent == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:303:0x0959  */
    /* JADX WARN: Removed duplicated region for block: B:306:0x0966  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private PushMessageHandler.a a(ii iiVar, boolean z, byte[] bArr, String str, int i) {
        int i2;
        List<String> list;
        MiPushMessage generateMessage;
        try {
            ix a2 = aj.a(this.f46a, iiVar);
            if (a2 == null) {
                com.xiaomi.channel.commonutils.logger.b.d("receiving an un-recognized message. " + iiVar.f598a);
                fb.a(this.f46a).b(this.f46a.getPackageName(), fa.m275a(i), str, "18");
                return null;
            }
            hm a3 = iiVar.a();
            com.xiaomi.channel.commonutils.logger.b.m58a("processing a message, action=" + a3);
            switch (ap.f8216a[a3.ordinal()]) {
                case 1:
                    if (!iiVar.m430b()) {
                        com.xiaomi.channel.commonutils.logger.b.d("receiving an un-encrypt message(SendMessage).");
                        return null;
                    } else if (b.m98a(this.f46a).m108d() && !z) {
                        com.xiaomi.channel.commonutils.logger.b.m58a("receive a message in pause state. drop it");
                        fb.a(this.f46a).a(this.f46a.getPackageName(), fa.m275a(i), str, com.tencent.connect.common.Constants.VIA_REPORT_TYPE_SET_AVATAR);
                        return null;
                    } else {
                        ip ipVar = (ip) a2;
                        hy a4 = ipVar.a();
                        if (a4 == null) {
                            com.xiaomi.channel.commonutils.logger.b.d("receive an empty message without push content, drop it");
                            fb.a(this.f46a).b(this.f46a.getPackageName(), fa.m275a(i), str, com.tencent.connect.common.Constants.VIA_REPORT_TYPE_DATALINE);
                            return null;
                        }
                        if (z) {
                            if (com.xiaomi.push.service.aa.m537a(iiVar)) {
                                MiPushClient.reportIgnoreRegMessageClicked(this.f46a, a4.m373a(), iiVar.m422a(), iiVar.f605b, a4.b());
                            } else {
                                MiPushClient.reportMessageClicked(this.f46a, a4.m373a(), iiVar.m422a(), a4.b());
                            }
                        }
                        if (!z) {
                            if (!TextUtils.isEmpty(ipVar.d()) && MiPushClient.aliasSetTime(this.f46a, ipVar.d()) < 0) {
                                MiPushClient.addAlias(this.f46a, ipVar.d());
                            } else if (!TextUtils.isEmpty(ipVar.c()) && MiPushClient.topicSubscribedTime(this.f46a, ipVar.c()) < 0) {
                                MiPushClient.addTopic(this.f46a, ipVar.c());
                            }
                        }
                        String str2 = null;
                        if (iiVar.f599a != null && iiVar.f599a.m382a() != null) {
                            str2 = iiVar.f599a.f511a.get("jobkey");
                        }
                        String m373a = TextUtils.isEmpty(str2) ? a4.m373a() : str2;
                        if (z || !m79a(this.f46a, m373a)) {
                            generateMessage = PushMessageHelper.generateMessage(ipVar, iiVar.m422a(), z);
                            if (generateMessage.getPassThrough() == 0 && !z && com.xiaomi.push.service.aa.m538a(generateMessage.getExtra())) {
                                com.xiaomi.push.service.aa.m534a(this.f46a, iiVar, bArr);
                                return null;
                            }
                            com.xiaomi.channel.commonutils.logger.b.m58a("receive a message, msgid=" + a4.m373a() + ", jobkey=" + m373a);
                            if (z && generateMessage.getExtra() != null && generateMessage.getExtra().containsKey("notify_effect")) {
                                Map<String, String> extra = generateMessage.getExtra();
                                String str3 = extra.get("notify_effect");
                                if (com.xiaomi.push.service.aa.m537a(iiVar)) {
                                    Intent a5 = a(this.f46a, iiVar.f605b, extra);
                                    a5.putExtra("eventMessageType", i);
                                    a5.putExtra("messageId", str);
                                    if (a5 == null) {
                                        com.xiaomi.channel.commonutils.logger.b.m58a("Getting Intent fail from ignore reg message. ");
                                        fb.a(this.f46a).b(this.f46a.getPackageName(), fa.m275a(i), str, com.tencent.connect.common.Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR);
                                        return null;
                                    }
                                    String c = a4.c();
                                    if (!TextUtils.isEmpty(c)) {
                                        a5.putExtra("payload", c);
                                    }
                                    this.f46a.startActivity(a5);
                                    fb.a(this.f46a).a(this.f46a.getPackageName(), fa.m275a(i), str, PluginError.ERROR_INS_INSTALL_PATH, str3);
                                } else {
                                    Intent a6 = a(this.f46a, this.f46a.getPackageName(), extra);
                                    if (a6 != null) {
                                        if (!str3.equals(com.xiaomi.push.service.at.c)) {
                                            a6.putExtra(PushMessageHelper.KEY_MESSAGE, generateMessage);
                                            a6.putExtra("eventMessageType", i);
                                            a6.putExtra("messageId", str);
                                        }
                                        this.f46a.startActivity(a6);
                                        com.xiaomi.channel.commonutils.logger.b.m58a("start activity succ");
                                        fb.a(this.f46a).a(this.f46a.getPackageName(), fa.m275a(i), str, 1006, str3);
                                        if (str3.equals(com.xiaomi.push.service.at.c)) {
                                            fb.a(this.f46a).a(this.f46a.getPackageName(), fa.m275a(i), str, com.tencent.connect.common.Constants.VIA_REPORT_TYPE_JOININ_GROUP);
                                        }
                                    }
                                }
                                return null;
                            }
                        } else {
                            com.xiaomi.channel.commonutils.logger.b.m58a("drop a duplicate message, key=" + m373a);
                            fb.a(this.f46a).c(this.f46a.getPackageName(), fa.m275a(i), str, "2:" + m373a);
                            generateMessage = null;
                        }
                        if (iiVar.m422a() != null || z) {
                            return generateMessage;
                        }
                        a(ipVar, iiVar);
                        return generateMessage;
                    }
                case 2:
                    in inVar = (in) a2;
                    String str4 = b.m98a(this.f46a).f64a;
                    if (TextUtils.isEmpty(str4) || !TextUtils.equals(str4, inVar.m450a())) {
                        com.xiaomi.channel.commonutils.logger.b.m58a("bad Registration result:");
                        fb.a(this.f46a).b(this.f46a.getPackageName(), fa.m275a(i), str, com.tencent.connect.common.Constants.VIA_REPORT_TYPE_QQFAVORITES);
                        return null;
                    }
                    b.m98a(this.f46a).f64a = null;
                    if (inVar.f660a == 0) {
                        b.m98a(this.f46a).b(inVar.f670e, inVar.f671f, inVar.f677l);
                        fb.a(this.f46a).a(this.f46a.getPackageName(), fa.m275a(i), str, 6006, "1");
                    } else {
                        fb.a(this.f46a).a(this.f46a.getPackageName(), fa.m275a(i), str, 6006, "2");
                    }
                    ArrayList arrayList = null;
                    if (!TextUtils.isEmpty(inVar.f670e)) {
                        arrayList = new ArrayList();
                        arrayList.add(inVar.f670e);
                    }
                    MiPushCommandMessage generateCommandMessage = PushMessageHelper.generateCommandMessage(fg.COMMAND_REGISTER.f319a, arrayList, inVar.f660a, inVar.f669d, null);
                    aq.a(this.f46a).m96d();
                    return generateCommandMessage;
                case 3:
                    if (((it) a2).f736a == 0) {
                        b.m98a(this.f46a).m100a();
                        MiPushClient.clearExtras(this.f46a);
                    }
                    PushMessageHandler.a();
                    break;
                case 4:
                    ir irVar = (ir) a2;
                    if (irVar.f711a == 0) {
                        MiPushClient.addTopic(this.f46a, irVar.a());
                    }
                    ArrayList arrayList2 = null;
                    if (!TextUtils.isEmpty(irVar.a())) {
                        arrayList2 = new ArrayList();
                        arrayList2.add(irVar.a());
                    }
                    return PushMessageHelper.generateCommandMessage(fg.COMMAND_SUBSCRIBE_TOPIC.f319a, arrayList2, irVar.f711a, irVar.f717d, irVar.b());
                case 5:
                    iv ivVar = (iv) a2;
                    if (ivVar.f756a == 0) {
                        MiPushClient.removeTopic(this.f46a, ivVar.a());
                    }
                    ArrayList arrayList3 = null;
                    if (!TextUtils.isEmpty(ivVar.a())) {
                        arrayList3 = new ArrayList();
                        arrayList3.add(ivVar.a());
                    }
                    return PushMessageHelper.generateCommandMessage(fg.COMMAND_UNSUBSCRIBE_TOPIC.f319a, arrayList3, ivVar.f756a, ivVar.f762d, ivVar.b());
                case 6:
                    df.a(this.f46a.getPackageName(), this.f46a, a2, hm.Command, bArr.length);
                    ih ihVar = (ih) a2;
                    String a7 = ihVar.a();
                    List<String> m417a = ihVar.m417a();
                    if (ihVar.f586a == 0) {
                        if (TextUtils.equals(a7, fg.COMMAND_SET_ACCEPT_TIME.f319a) && m417a != null && m417a.size() > 1) {
                            MiPushClient.addAcceptTime(this.f46a, m417a.get(0), m417a.get(1));
                            if ("00:00".equals(m417a.get(0)) && "00:00".equals(m417a.get(1))) {
                                b.m98a(this.f46a).a(true);
                            } else {
                                b.m98a(this.f46a).a(false);
                            }
                            list = a(TimeZone.getTimeZone("GMT+08"), TimeZone.getDefault(), m417a);
                        } else if (TextUtils.equals(a7, fg.COMMAND_SET_ALIAS.f319a) && m417a != null && m417a.size() > 0) {
                            MiPushClient.addAlias(this.f46a, m417a.get(0));
                            list = m417a;
                        } else if (TextUtils.equals(a7, fg.COMMAND_UNSET_ALIAS.f319a) && m417a != null && m417a.size() > 0) {
                            MiPushClient.removeAlias(this.f46a, m417a.get(0));
                            list = m417a;
                        } else if (TextUtils.equals(a7, fg.COMMAND_SET_ACCOUNT.f319a) && m417a != null && m417a.size() > 0) {
                            MiPushClient.addAccount(this.f46a, m417a.get(0));
                            list = m417a;
                        } else if (TextUtils.equals(a7, fg.COMMAND_UNSET_ACCOUNT.f319a) && m417a != null && m417a.size() > 0) {
                            MiPushClient.removeAccount(this.f46a, m417a.get(0));
                            list = m417a;
                        } else if (TextUtils.equals(a7, fg.COMMAND_CHK_VDEVID.f319a)) {
                            if (m417a != null && m417a.size() > 0) {
                                com.xiaomi.push.i.a(this.f46a, m417a.get(0));
                            }
                            return null;
                        }
                        return PushMessageHelper.generateCommandMessage(a7, list, ihVar.f586a, ihVar.f594d, ihVar.b());
                    }
                    list = m417a;
                    return PushMessageHelper.generateCommandMessage(a7, list, ihVar.f586a, ihVar.f594d, ihVar.b());
                case 7:
                    df.a(this.f46a.getPackageName(), this.f46a, a2, hm.Notification, bArr.length);
                    if (a2 instanceof id) {
                        id idVar = (id) a2;
                        String a8 = idVar.a();
                        if (hw.DisablePushMessage.f476a.equalsIgnoreCase(idVar.f563d)) {
                            if (idVar.f556a == 0) {
                                synchronized (ag.class) {
                                    if (ag.a(this.f46a).m78a(a8)) {
                                        ag.a(this.f46a).c(a8);
                                        if ("syncing".equals(ag.a(this.f46a).a(av.DISABLE_PUSH))) {
                                            ag.a(this.f46a).a(av.DISABLE_PUSH, "synced");
                                            MiPushClient.clearNotification(this.f46a);
                                            MiPushClient.clearLocalNotificationType(this.f46a);
                                            PushMessageHandler.a();
                                            aq.a(this.f46a).m93b();
                                        }
                                    }
                                }
                                break;
                            } else if ("syncing".equals(ag.a(this.f46a).a(av.DISABLE_PUSH))) {
                                synchronized (ag.class) {
                                    if (ag.a(this.f46a).m78a(a8)) {
                                        if (ag.a(this.f46a).a(a8) < 10) {
                                            ag.a(this.f46a).b(a8);
                                            aq.a(this.f46a).a(true, a8);
                                        } else {
                                            ag.a(this.f46a).c(a8);
                                        }
                                    }
                                }
                                break;
                            } else {
                                ag.a(this.f46a).c(a8);
                                break;
                            }
                        } else if (hw.EnablePushMessage.f476a.equalsIgnoreCase(idVar.f563d)) {
                            if (idVar.f556a == 0) {
                                synchronized (ag.class) {
                                    if (ag.a(this.f46a).m78a(a8)) {
                                        ag.a(this.f46a).c(a8);
                                        if ("syncing".equals(ag.a(this.f46a).a(av.ENABLE_PUSH))) {
                                            ag.a(this.f46a).a(av.ENABLE_PUSH, "synced");
                                        }
                                    }
                                }
                                break;
                            } else if ("syncing".equals(ag.a(this.f46a).a(av.ENABLE_PUSH))) {
                                synchronized (ag.class) {
                                    if (ag.a(this.f46a).m78a(a8)) {
                                        if (ag.a(this.f46a).a(a8) < 10) {
                                            ag.a(this.f46a).b(a8);
                                            aq.a(this.f46a).a(false, a8);
                                        } else {
                                            ag.a(this.f46a).c(a8);
                                        }
                                    }
                                }
                                break;
                            } else {
                                ag.a(this.f46a).c(a8);
                                break;
                            }
                        } else if (hw.ThirdPartyRegUpdate.f476a.equalsIgnoreCase(idVar.f563d)) {
                            b(idVar);
                            break;
                        } else if (hw.UploadTinyData.f476a.equalsIgnoreCase(idVar.f563d)) {
                            a(idVar);
                            break;
                        }
                    } else if (a2 instanceof il) {
                        il ilVar = (il) a2;
                        if ("registration id expired".equalsIgnoreCase(ilVar.f622d)) {
                            List<String> allAlias = MiPushClient.getAllAlias(this.f46a);
                            List<String> allTopic = MiPushClient.getAllTopic(this.f46a);
                            List<String> allUserAccount = MiPushClient.getAllUserAccount(this.f46a);
                            String acceptTime = MiPushClient.getAcceptTime(this.f46a);
                            MiPushClient.reInitialize(this.f46a, ia.RegIdExpired);
                            for (String str5 : allAlias) {
                                MiPushClient.removeAlias(this.f46a, str5);
                                MiPushClient.setAlias(this.f46a, str5, null);
                            }
                            for (String str6 : allTopic) {
                                MiPushClient.removeTopic(this.f46a, str6);
                                MiPushClient.subscribe(this.f46a, str6, null);
                            }
                            for (String str7 : allUserAccount) {
                                MiPushClient.removeAccount(this.f46a, str7);
                                MiPushClient.setUserAccount(this.f46a, str7, null);
                            }
                            String[] split = acceptTime.split(",");
                            if (split.length == 2) {
                                MiPushClient.removeAcceptTime(this.f46a);
                                MiPushClient.addAcceptTime(this.f46a, split[0], split[1]);
                                break;
                            }
                        } else if ("client_info_update_ok".equalsIgnoreCase(ilVar.f622d)) {
                            if (ilVar.m437a() != null && ilVar.m437a().containsKey("app_version")) {
                                b.m98a(this.f46a).m101a(ilVar.m437a().get("app_version"));
                                break;
                            }
                        } else if (hw.AwakeApp.f476a.equalsIgnoreCase(ilVar.f622d)) {
                            if (iiVar.m430b() && ilVar.m437a() != null && ilVar.m437a().containsKey("awake_info")) {
                                n.a(this.f46a, b.m98a(this.f46a).m99a(), com.xiaomi.push.service.ak.a(this.f46a).a(hr.AwakeInfoUploadWaySwitch.a(), 0), ilVar.m437a().get("awake_info"));
                                break;
                            }
                        } else if (hw.NormalClientConfigUpdate.f476a.equalsIgnoreCase(ilVar.f622d)) {
                            ik ikVar = new ik();
                            try {
                                iw.a(ikVar, ilVar.m442a());
                                com.xiaomi.push.service.al.a(com.xiaomi.push.service.ak.a(this.f46a), ikVar);
                                break;
                            } catch (jc e) {
                                com.xiaomi.channel.commonutils.logger.b.a(e);
                                break;
                            }
                        } else if (hw.CustomClientConfigUpdate.f476a.equalsIgnoreCase(ilVar.f622d)) {
                            ij ijVar = new ij();
                            try {
                                iw.a(ijVar, ilVar.m442a());
                                com.xiaomi.push.service.al.a(com.xiaomi.push.service.ak.a(this.f46a), ijVar);
                                break;
                            } catch (jc e2) {
                                com.xiaomi.channel.commonutils.logger.b.a(e2);
                                break;
                            }
                        } else if (hw.SyncInfoResult.f476a.equalsIgnoreCase(ilVar.f622d)) {
                            aw.a(this.f46a, ilVar);
                            break;
                        } else if (hw.ForceSync.f476a.equalsIgnoreCase(ilVar.f622d)) {
                            com.xiaomi.channel.commonutils.logger.b.m58a("receive force sync notification");
                            aw.a(this.f46a, false);
                            break;
                        } else if (!hw.CancelPushMessage.f476a.equals(ilVar.f622d)) {
                            if (hw.HybridRegisterResult.f476a.equals(ilVar.f622d)) {
                                try {
                                    in inVar2 = new in();
                                    iw.a(inVar2, ilVar.m442a());
                                    MiPushClient4Hybrid.onReceiveRegisterResult(this.f46a, inVar2);
                                    break;
                                } catch (jc e3) {
                                    com.xiaomi.channel.commonutils.logger.b.a(e3);
                                    break;
                                }
                            } else if (hw.HybridUnregisterResult.f476a.equals(ilVar.f622d)) {
                                try {
                                    it itVar = new it();
                                    iw.a(itVar, ilVar.m442a());
                                    MiPushClient4Hybrid.onReceiveUnregisterResult(this.f46a, itVar);
                                    break;
                                } catch (jc e4) {
                                    com.xiaomi.channel.commonutils.logger.b.a(e4);
                                    break;
                                }
                            } else if (hw.PushLogUpload.f476a.equals(ilVar.f622d) && ilVar.m437a() != null && ilVar.m437a().containsKey("packages")) {
                                String[] split2 = ilVar.m437a().get("packages").split(",");
                                if (TextUtils.equals(this.f46a.getPackageName(), "com.xiaomi.xmsf")) {
                                    Logger.uploadLogFile(this.f46a, true);
                                    a(this.f46a, split2);
                                    break;
                                } else {
                                    Logger.uploadLogFile(this.f46a, false);
                                    break;
                                }
                            }
                        } else if (ilVar.m437a() != null) {
                            if (ilVar.m437a().containsKey(com.xiaomi.push.service.at.J)) {
                                String str8 = ilVar.m437a().get(com.xiaomi.push.service.at.J);
                                if (!TextUtils.isEmpty(str8)) {
                                    try {
                                        i2 = Integer.parseInt(str8);
                                    } catch (NumberFormatException e5) {
                                        e5.printStackTrace();
                                        i2 = -2;
                                    }
                                    if (i2 < -1) {
                                        MiPushClient.clearNotification(this.f46a, i2);
                                        break;
                                    } else {
                                        MiPushClient.clearNotification(this.f46a, ilVar.m437a().containsKey(com.xiaomi.push.service.at.H) ? ilVar.m437a().get(com.xiaomi.push.service.at.H) : "", ilVar.m437a().containsKey(com.xiaomi.push.service.at.I) ? ilVar.m437a().get(com.xiaomi.push.service.at.I) : "");
                                        break;
                                    }
                                }
                            }
                            i2 = -2;
                            if (i2 < -1) {
                            }
                        }
                    }
                    break;
            }
            return null;
        } catch (t e6) {
            com.xiaomi.channel.commonutils.logger.b.a(e6);
            a(iiVar);
            fb.a(this.f46a).b(this.f46a.getPackageName(), fa.m275a(i), str, com.tencent.connect.common.Constants.VIA_ACT_TYPE_NINETEEN);
            return null;
        } catch (jc e7) {
            com.xiaomi.channel.commonutils.logger.b.a(e7);
            com.xiaomi.channel.commonutils.logger.b.d("receive a message which action string is not valid. is the reg expired?");
            fb.a(this.f46a).b(this.f46a.getPackageName(), fa.m275a(i), str, "20");
            return null;
        }
    }

    private PushMessageHandler.a a(ii iiVar, byte[] bArr) {
        String str = null;
        try {
            ix a2 = aj.a(this.f46a, iiVar);
            if (a2 == null) {
                com.xiaomi.channel.commonutils.logger.b.d("message arrived: receiving an un-recognized message. " + iiVar.f598a);
                return null;
            }
            hm a3 = iiVar.a();
            com.xiaomi.channel.commonutils.logger.b.m58a("message arrived: processing an arrived message, action=" + a3);
            switch (ap.f8216a[a3.ordinal()]) {
                case 1:
                    if (!iiVar.m430b()) {
                        com.xiaomi.channel.commonutils.logger.b.d("message arrived: receiving an un-encrypt message(SendMessage).");
                        return null;
                    }
                    ip ipVar = (ip) a2;
                    hy a4 = ipVar.a();
                    if (a4 == null) {
                        com.xiaomi.channel.commonutils.logger.b.d("message arrived: receive an empty message without push content, drop it");
                        return null;
                    }
                    if (iiVar.f599a != null && iiVar.f599a.m382a() != null) {
                        str = iiVar.f599a.f511a.get("jobkey");
                    }
                    MiPushMessage generateMessage = PushMessageHelper.generateMessage(ipVar, iiVar.m422a(), false);
                    generateMessage.setArrivedMessage(true);
                    com.xiaomi.channel.commonutils.logger.b.m58a("message arrived: receive a message, msgid=" + a4.m373a() + ", jobkey=" + str);
                    return generateMessage;
                default:
                    return null;
            }
        } catch (t e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            com.xiaomi.channel.commonutils.logger.b.d("message arrived: receive a message but decrypt failed. report when click.");
            return null;
        } catch (jc e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
            com.xiaomi.channel.commonutils.logger.b.d("message arrived: receive a message which action string is not valid. is the reg expired?");
            return null;
        }
    }

    public static an a(Context context) {
        if (f8214a == null) {
            f8214a = new an(context);
        }
        return f8214a;
    }

    private void a() {
        SharedPreferences sharedPreferences = this.f46a.getSharedPreferences("mipush_extra", 0);
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - sharedPreferences.getLong(Constants.SP_KEY_LAST_REINITIALIZE, 0L)) > 1800000) {
            MiPushClient.reInitialize(this.f46a, ia.PackageUnregistered);
            sharedPreferences.edit().putLong(Constants.SP_KEY_LAST_REINITIALIZE, currentTimeMillis).commit();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, PackageInfo packageInfo) {
        ServiceInfo[] serviceInfoArr = packageInfo.services;
        if (serviceInfoArr != null) {
            for (ServiceInfo serviceInfo : serviceInfoArr) {
                if (serviceInfo.exported && serviceInfo.enabled && "com.xiaomi.mipush.sdk.PushMessageHandler".equals(serviceInfo.name) && !context.getPackageName().equals(serviceInfo.packageName)) {
                    try {
                        Intent intent = new Intent();
                        intent.setClassName(serviceInfo.packageName, serviceInfo.name);
                        intent.setAction("com.xiaomi.mipush.sdk.SYNC_LOG");
                        PushMessageHandler.a(context, intent);
                        return;
                    } catch (Throwable th) {
                        return;
                    }
                }
            }
        }
    }

    public static void a(Context context, String str) {
        synchronized (f44a) {
            f45a.remove(str);
            b.m98a(context);
            SharedPreferences a2 = b.a(context);
            String a3 = bf.a(f45a, ",");
            SharedPreferences.Editor edit = a2.edit();
            edit.putString("pref_msg_ids", a3);
            com.xiaomi.push.r.a(edit);
        }
    }

    private void a(Context context, String[] strArr) {
        com.xiaomi.push.ai.a(context).a(new ao(this, strArr, context));
    }

    private void a(id idVar) {
        String a2 = idVar.a();
        com.xiaomi.channel.commonutils.logger.b.b("receive ack " + a2);
        Map<String, String> m405a = idVar.m405a();
        if (m405a != null) {
            String str = m405a.get("real_source");
            if (TextUtils.isEmpty(str)) {
                return;
            }
            com.xiaomi.channel.commonutils.logger.b.b("receive ack : messageId = " + a2 + "  realSource = " + str);
            bp.a(this.f46a).a(a2, str, Boolean.valueOf(idVar.f556a == 0));
        }
    }

    private void a(ii iiVar) {
        com.xiaomi.channel.commonutils.logger.b.m58a("receive a message but decrypt failed. report now.");
        il ilVar = new il(iiVar.m422a().f509a, false);
        ilVar.c(hw.DecryptMessageFail.f476a);
        ilVar.b(iiVar.m423a());
        ilVar.d(iiVar.f605b);
        ilVar.f617a = new HashMap();
        ilVar.f617a.put("regid", MiPushClient.getRegId(this.f46a));
        aq.a(this.f46a).a((aq) ilVar, hm.Notification, false, (hz) null);
    }

    private void a(ip ipVar, ii iiVar) {
        hz m422a = iiVar.m422a();
        ic icVar = new ic();
        icVar.b(ipVar.b());
        icVar.a(ipVar.m457a());
        icVar.a(ipVar.a().a());
        if (!TextUtils.isEmpty(ipVar.c())) {
            icVar.c(ipVar.c());
        }
        if (!TextUtils.isEmpty(ipVar.d())) {
            icVar.d(ipVar.d());
        }
        icVar.a(iw.a(this.f46a, iiVar));
        aq.a(this.f46a).a((aq) icVar, hm.AckMessage, m422a);
    }

    private void a(String str, long j, d dVar) {
        av a2 = k.a(dVar);
        if (a2 == null) {
            return;
        }
        if (j == 0) {
            synchronized (ag.class) {
                if (ag.a(this.f46a).m78a(str)) {
                    ag.a(this.f46a).c(str);
                    if ("syncing".equals(ag.a(this.f46a).a(a2))) {
                        ag.a(this.f46a).a(a2, "synced");
                    }
                }
            }
        } else if (!"syncing".equals(ag.a(this.f46a).a(a2))) {
            ag.a(this.f46a).c(str);
        } else {
            synchronized (ag.class) {
                if (ag.a(this.f46a).m78a(str)) {
                    if (ag.a(this.f46a).a(str) < 10) {
                        ag.a(this.f46a).b(str);
                        aq.a(this.f46a).a(str, a2, dVar);
                    } else {
                        ag.a(this.f46a).c(str);
                    }
                }
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    private static boolean m79a(Context context, String str) {
        boolean z = false;
        synchronized (f44a) {
            b.m98a(context);
            SharedPreferences a2 = b.a(context);
            if (f45a == null) {
                String[] split = a2.getString("pref_msg_ids", "").split(",");
                f45a = new LinkedList();
                for (String str2 : split) {
                    f45a.add(str2);
                }
            }
            if (f45a.contains(str)) {
                z = true;
            } else {
                f45a.add(str);
                if (f45a.size() > 25) {
                    f45a.poll();
                }
                String a3 = bf.a(f45a, ",");
                SharedPreferences.Editor edit = a2.edit();
                edit.putString("pref_msg_ids", a3);
                com.xiaomi.push.r.a(edit);
            }
        }
        return z;
    }

    /* renamed from: a  reason: collision with other method in class */
    private boolean m80a(ii iiVar) {
        if (TextUtils.equals(Constants.HYBRID_PACKAGE_NAME, iiVar.b()) || TextUtils.equals(Constants.HYBRID_DEBUG_PACKAGE_NAME, iiVar.b())) {
            Map<String, String> m382a = iiVar.m422a() == null ? null : iiVar.m422a().m382a();
            if (m382a == null) {
                return false;
            }
            String str = m382a.get(Constants.EXTRA_KEY_PUSH_SERVER_ACTION);
            return TextUtils.equals(str, Constants.EXTRA_VALUE_HYBRID_MESSAGE) || TextUtils.equals(str, Constants.EXTRA_VALUE_PLATFORM_MESSAGE);
        }
        return false;
    }

    private void b(id idVar) {
        com.xiaomi.channel.commonutils.logger.b.c("ASSEMBLE_PUSH : " + idVar.toString());
        String a2 = idVar.a();
        Map<String, String> m405a = idVar.m405a();
        if (m405a != null) {
            String str = m405a.get(Constants.ASSEMBLE_PUSH_REG_INFO);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (str.contains("brand:" + ah.FCM.name())) {
                com.xiaomi.channel.commonutils.logger.b.m58a("ASSEMBLE_PUSH : receive fcm token sync ack");
                h.b(this.f46a, d.ASSEMBLE_PUSH_FCM, str);
                a(a2, idVar.f556a, d.ASSEMBLE_PUSH_FCM);
            } else if (str.contains("brand:" + ah.HUAWEI.name())) {
                com.xiaomi.channel.commonutils.logger.b.m58a("ASSEMBLE_PUSH : receive hw token sync ack");
                h.b(this.f46a, d.ASSEMBLE_PUSH_HUAWEI, str);
                a(a2, idVar.f556a, d.ASSEMBLE_PUSH_HUAWEI);
            } else if (str.contains("brand:" + ah.OPPO.name())) {
                com.xiaomi.channel.commonutils.logger.b.m58a("ASSEMBLE_PUSH : receive COS token sync ack");
                h.b(this.f46a, d.ASSEMBLE_PUSH_COS, str);
                a(a2, idVar.f556a, d.ASSEMBLE_PUSH_COS);
            } else if (str.contains("brand:" + ah.VIVO.name())) {
                com.xiaomi.channel.commonutils.logger.b.m58a("ASSEMBLE_PUSH : receive FTOS token sync ack");
                h.b(this.f46a, d.ASSEMBLE_PUSH_FTOS, str);
                a(a2, idVar.f556a, d.ASSEMBLE_PUSH_FTOS);
            }
        }
    }

    private void b(ii iiVar) {
        hz m422a = iiVar.m422a();
        ic icVar = new ic();
        icVar.b(iiVar.m423a());
        icVar.a(m422a.m381a());
        icVar.a(m422a.m379a());
        if (!TextUtils.isEmpty(m422a.m386b())) {
            icVar.c(m422a.m386b());
        }
        icVar.a(iw.a(this.f46a, iiVar));
        aq.a(this.f46a).a((aq) icVar, hm.AckMessage, false, iiVar.m422a());
    }

    public PushMessageHandler.a a(Intent intent) {
        String action = intent.getAction();
        com.xiaomi.channel.commonutils.logger.b.m58a("receive an intent from server, action=" + action);
        String stringExtra = intent.getStringExtra("mrt");
        if (stringExtra == null) {
            stringExtra = Long.toString(System.currentTimeMillis());
        }
        String stringExtra2 = intent.getStringExtra("messageId");
        int intExtra = intent.getIntExtra("eventMessageType", -1);
        if ("com.xiaomi.mipush.RECEIVE_MESSAGE".equals(action)) {
            byte[] byteArrayExtra = intent.getByteArrayExtra("mipush_payload");
            boolean booleanExtra = intent.getBooleanExtra("mipush_notified", false);
            if (byteArrayExtra == null) {
                com.xiaomi.channel.commonutils.logger.b.d("receiving an empty message, drop");
                fb.a(this.f46a).a(this.f46a.getPackageName(), intent, com.tencent.connect.common.Constants.VIA_REPORT_TYPE_SET_AVATAR);
                return null;
            }
            ii iiVar = new ii();
            try {
                iw.a(iiVar, byteArrayExtra);
                b m98a = b.m98a(this.f46a);
                hz m422a = iiVar.m422a();
                if (iiVar.a() == hm.SendMessage && m422a != null && !m98a.m108d() && !booleanExtra) {
                    m422a.a("mrt", stringExtra);
                    m422a.a("mat", Long.toString(System.currentTimeMillis()));
                    if (m80a(iiVar)) {
                        com.xiaomi.channel.commonutils.logger.b.b("this is a mina's message, ack later");
                        m422a.a(Constants.EXTRA_KEY_HYBRID_MESSAGE_TS, String.valueOf(m422a.m379a()));
                        m422a.a(Constants.EXTRA_KEY_HYBRID_DEVICE_STATUS, String.valueOf((int) iw.a(this.f46a, iiVar)));
                    } else {
                        b(iiVar);
                    }
                }
                if (iiVar.a() == hm.SendMessage && !iiVar.m430b()) {
                    if (com.xiaomi.push.service.aa.m537a(iiVar)) {
                        Object[] objArr = new Object[2];
                        objArr[0] = iiVar.b();
                        objArr[1] = m422a != null ? m422a.m381a() : "";
                        com.xiaomi.channel.commonutils.logger.b.m58a(String.format("drop an un-encrypted wake-up messages. %1$s, %2$s", objArr));
                        fb.a(this.f46a).a(this.f46a.getPackageName(), intent, String.format("13: %1$s", iiVar.b()));
                    } else {
                        Object[] objArr2 = new Object[2];
                        objArr2[0] = iiVar.b();
                        objArr2[1] = m422a != null ? m422a.m381a() : "";
                        com.xiaomi.channel.commonutils.logger.b.m58a(String.format("drop an un-encrypted messages. %1$s, %2$s", objArr2));
                        fb.a(this.f46a).a(this.f46a.getPackageName(), intent, String.format("14: %1$s", iiVar.b()));
                    }
                    return null;
                } else if (iiVar.a() == hm.SendMessage && iiVar.m430b() && com.xiaomi.push.service.aa.m537a(iiVar) && (!booleanExtra || m422a == null || m422a.m382a() == null || !m422a.m382a().containsKey("notify_effect"))) {
                    Object[] objArr3 = new Object[2];
                    objArr3[0] = iiVar.b();
                    objArr3[1] = m422a != null ? m422a.m381a() : "";
                    com.xiaomi.channel.commonutils.logger.b.m58a(String.format("drop a wake-up messages which not has 'notify_effect' attr. %1$s, %2$s", objArr3));
                    fb.a(this.f46a).a(this.f46a.getPackageName(), intent, String.format("25: %1$s", iiVar.b()));
                    return null;
                } else if (m98a.m107c() || iiVar.f598a == hm.Registration) {
                    if (!m98a.m107c() || !m98a.m109e()) {
                        return a(iiVar, booleanExtra, byteArrayExtra, stringExtra2, intExtra);
                    }
                    if (iiVar.f598a == hm.UnRegistration) {
                        m98a.m100a();
                        MiPushClient.clearExtras(this.f46a);
                        PushMessageHandler.a();
                    } else {
                        MiPushClient.unregisterPush(this.f46a);
                    }
                } else if (com.xiaomi.push.service.aa.m537a(iiVar)) {
                    return a(iiVar, booleanExtra, byteArrayExtra, stringExtra2, intExtra);
                } else {
                    com.xiaomi.channel.commonutils.logger.b.d("receive message without registration. need re-register!");
                    fb.a(this.f46a).a(this.f46a.getPackageName(), intent, com.tencent.connect.common.Constants.VIA_REPORT_TYPE_WPA_STATE);
                    a();
                }
            } catch (jc e) {
                fb.a(this.f46a).a(this.f46a.getPackageName(), intent, com.tencent.connect.common.Constants.VIA_REPORT_TYPE_START_WAP);
                com.xiaomi.channel.commonutils.logger.b.a(e);
            } catch (Exception e2) {
                fb.a(this.f46a).a(this.f46a.getPackageName(), intent, com.tencent.connect.common.Constants.VIA_REPORT_TYPE_START_GROUP);
                com.xiaomi.channel.commonutils.logger.b.a(e2);
            }
        } else if ("com.xiaomi.mipush.ERROR".equals(action)) {
            MiPushCommandMessage miPushCommandMessage = new MiPushCommandMessage();
            ii iiVar2 = new ii();
            try {
                byte[] byteArrayExtra2 = intent.getByteArrayExtra("mipush_payload");
                if (byteArrayExtra2 != null) {
                    iw.a(iiVar2, byteArrayExtra2);
                }
            } catch (jc e3) {
            }
            miPushCommandMessage.setCommand(String.valueOf(iiVar2.a()));
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
            ii iiVar3 = new ii();
            try {
                iw.a(iiVar3, byteArrayExtra3);
                b m98a2 = b.m98a(this.f46a);
                if (com.xiaomi.push.service.aa.m537a(iiVar3)) {
                    com.xiaomi.channel.commonutils.logger.b.d("message arrived: receive ignore reg message, ignore!");
                } else if (!m98a2.m107c()) {
                    com.xiaomi.channel.commonutils.logger.b.d("message arrived: receive message without registration. need unregister or re-register!");
                } else if (!m98a2.m107c() || !m98a2.m109e()) {
                    return a(iiVar3, byteArrayExtra3);
                } else {
                    com.xiaomi.channel.commonutils.logger.b.d("message arrived: app info is invalidated");
                }
            } catch (jc e4) {
                com.xiaomi.channel.commonutils.logger.b.a(e4);
            } catch (Exception e5) {
                com.xiaomi.channel.commonutils.logger.b.a(e5);
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
        long parseLong2 = (((Long.parseLong(list.get(1).split(":")[1]) + (60 * Long.parseLong(list.get(1).split(":")[0]))) - rawOffset) + 1440) % 1440;
        ArrayList arrayList = new ArrayList();
        arrayList.add(String.format("%1$02d:%2$02d", Long.valueOf(parseLong / 60), Long.valueOf(parseLong % 60)));
        arrayList.add(String.format("%1$02d:%2$02d", Long.valueOf(parseLong2 / 60), Long.valueOf(parseLong2 % 60)));
        return arrayList;
    }
}
