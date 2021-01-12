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
/* loaded from: classes6.dex */
public class an {

    /* renamed from: a  reason: collision with root package name */
    private static an f13806a = null;

    /* renamed from: a  reason: collision with other field name */
    private static Object f123a = new Object();

    /* renamed from: a  reason: collision with other field name */
    private static Queue<String> f124a;

    /* renamed from: a  reason: collision with other field name */
    private Context f125a;

    private an(Context context) {
        this.f125a = context.getApplicationContext();
        if (this.f125a == null) {
            this.f125a = context;
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
            if (com.xiaomi.push.service.at.f14253a.equals(str3)) {
                if (com.xiaomi.push.service.at.f14254b.equals(str3)) {
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
                    com.xiaomi.channel.commonutils.logger.b.m80a("not resolve activity:" + intent);
                    return null;
                } catch (Exception e8) {
                    com.xiaomi.channel.commonutils.logger.b.d("Cause: " + e8.getMessage());
                    return null;
                }
            }
            return null;
        }
        i = -1;
        if (com.xiaomi.push.service.at.f14253a.equals(str3)) {
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
            ix a2 = aj.a(this.f125a, iiVar);
            if (a2 == null) {
                com.xiaomi.channel.commonutils.logger.b.d("receiving an un-recognized message. " + iiVar.f677a);
                fb.a(this.f125a).b(this.f125a.getPackageName(), fa.m297a(i), str, "18");
                return null;
            }
            hm a3 = iiVar.a();
            com.xiaomi.channel.commonutils.logger.b.m80a("processing a message, action=" + a3);
            switch (ap.f13808a[a3.ordinal()]) {
                case 1:
                    if (!iiVar.m452b()) {
                        com.xiaomi.channel.commonutils.logger.b.d("receiving an un-encrypt message(SendMessage).");
                        return null;
                    } else if (b.m120a(this.f125a).m130d() && !z) {
                        com.xiaomi.channel.commonutils.logger.b.m80a("receive a message in pause state. drop it");
                        fb.a(this.f125a).a(this.f125a.getPackageName(), fa.m297a(i), str, com.tencent.connect.common.Constants.VIA_REPORT_TYPE_SET_AVATAR);
                        return null;
                    } else {
                        ip ipVar = (ip) a2;
                        hy a4 = ipVar.a();
                        if (a4 == null) {
                            com.xiaomi.channel.commonutils.logger.b.d("receive an empty message without push content, drop it");
                            fb.a(this.f125a).b(this.f125a.getPackageName(), fa.m297a(i), str, com.tencent.connect.common.Constants.VIA_REPORT_TYPE_DATALINE);
                            return null;
                        }
                        if (z) {
                            if (com.xiaomi.push.service.aa.m559a(iiVar)) {
                                MiPushClient.reportIgnoreRegMessageClicked(this.f125a, a4.m395a(), iiVar.m444a(), iiVar.f684b, a4.b());
                            } else {
                                MiPushClient.reportMessageClicked(this.f125a, a4.m395a(), iiVar.m444a(), a4.b());
                            }
                        }
                        if (!z) {
                            if (!TextUtils.isEmpty(ipVar.d()) && MiPushClient.aliasSetTime(this.f125a, ipVar.d()) < 0) {
                                MiPushClient.addAlias(this.f125a, ipVar.d());
                            } else if (!TextUtils.isEmpty(ipVar.c()) && MiPushClient.topicSubscribedTime(this.f125a, ipVar.c()) < 0) {
                                MiPushClient.addTopic(this.f125a, ipVar.c());
                            }
                        }
                        String str2 = null;
                        if (iiVar.f678a != null && iiVar.f678a.m404a() != null) {
                            str2 = iiVar.f678a.f590a.get("jobkey");
                        }
                        String m395a = TextUtils.isEmpty(str2) ? a4.m395a() : str2;
                        if (z || !m101a(this.f125a, m395a)) {
                            generateMessage = PushMessageHelper.generateMessage(ipVar, iiVar.m444a(), z);
                            if (generateMessage.getPassThrough() == 0 && !z && com.xiaomi.push.service.aa.m560a(generateMessage.getExtra())) {
                                com.xiaomi.push.service.aa.m556a(this.f125a, iiVar, bArr);
                                return null;
                            }
                            com.xiaomi.channel.commonutils.logger.b.m80a("receive a message, msgid=" + a4.m395a() + ", jobkey=" + m395a);
                            if (z && generateMessage.getExtra() != null && generateMessage.getExtra().containsKey("notify_effect")) {
                                Map<String, String> extra = generateMessage.getExtra();
                                String str3 = extra.get("notify_effect");
                                if (com.xiaomi.push.service.aa.m559a(iiVar)) {
                                    Intent a5 = a(this.f125a, iiVar.f684b, extra);
                                    a5.putExtra("eventMessageType", i);
                                    a5.putExtra("messageId", str);
                                    if (a5 == null) {
                                        com.xiaomi.channel.commonutils.logger.b.m80a("Getting Intent fail from ignore reg message. ");
                                        fb.a(this.f125a).b(this.f125a.getPackageName(), fa.m297a(i), str, com.tencent.connect.common.Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR);
                                        return null;
                                    }
                                    String c = a4.c();
                                    if (!TextUtils.isEmpty(c)) {
                                        a5.putExtra("payload", c);
                                    }
                                    this.f125a.startActivity(a5);
                                    fb.a(this.f125a).a(this.f125a.getPackageName(), fa.m297a(i), str, PluginError.ERROR_INS_INSTALL_PATH, str3);
                                } else {
                                    Intent a6 = a(this.f125a, this.f125a.getPackageName(), extra);
                                    if (a6 != null) {
                                        if (!str3.equals(com.xiaomi.push.service.at.c)) {
                                            a6.putExtra(PushMessageHelper.KEY_MESSAGE, generateMessage);
                                            a6.putExtra("eventMessageType", i);
                                            a6.putExtra("messageId", str);
                                        }
                                        this.f125a.startActivity(a6);
                                        com.xiaomi.channel.commonutils.logger.b.m80a("start activity succ");
                                        fb.a(this.f125a).a(this.f125a.getPackageName(), fa.m297a(i), str, 1006, str3);
                                        if (str3.equals(com.xiaomi.push.service.at.c)) {
                                            fb.a(this.f125a).a(this.f125a.getPackageName(), fa.m297a(i), str, com.tencent.connect.common.Constants.VIA_REPORT_TYPE_JOININ_GROUP);
                                        }
                                    }
                                }
                                return null;
                            }
                        } else {
                            com.xiaomi.channel.commonutils.logger.b.m80a("drop a duplicate message, key=" + m395a);
                            fb.a(this.f125a).c(this.f125a.getPackageName(), fa.m297a(i), str, "2:" + m395a);
                            generateMessage = null;
                        }
                        if (iiVar.m444a() != null || z) {
                            return generateMessage;
                        }
                        a(ipVar, iiVar);
                        return generateMessage;
                    }
                case 2:
                    in inVar = (in) a2;
                    String str4 = b.m120a(this.f125a).f143a;
                    if (TextUtils.isEmpty(str4) || !TextUtils.equals(str4, inVar.m472a())) {
                        com.xiaomi.channel.commonutils.logger.b.m80a("bad Registration result:");
                        fb.a(this.f125a).b(this.f125a.getPackageName(), fa.m297a(i), str, com.tencent.connect.common.Constants.VIA_REPORT_TYPE_QQFAVORITES);
                        return null;
                    }
                    b.m120a(this.f125a).f143a = null;
                    if (inVar.f739a == 0) {
                        b.m120a(this.f125a).b(inVar.f749e, inVar.f750f, inVar.f756l);
                        fb.a(this.f125a).a(this.f125a.getPackageName(), fa.m297a(i), str, 6006, "1");
                    } else {
                        fb.a(this.f125a).a(this.f125a.getPackageName(), fa.m297a(i), str, 6006, "2");
                    }
                    ArrayList arrayList = null;
                    if (!TextUtils.isEmpty(inVar.f749e)) {
                        arrayList = new ArrayList();
                        arrayList.add(inVar.f749e);
                    }
                    MiPushCommandMessage generateCommandMessage = PushMessageHelper.generateCommandMessage(fg.COMMAND_REGISTER.f398a, arrayList, inVar.f739a, inVar.f748d, null);
                    aq.a(this.f125a).m118d();
                    return generateCommandMessage;
                case 3:
                    if (((it) a2).f815a == 0) {
                        b.m120a(this.f125a).m122a();
                        MiPushClient.clearExtras(this.f125a);
                    }
                    PushMessageHandler.a();
                    break;
                case 4:
                    ir irVar = (ir) a2;
                    if (irVar.f790a == 0) {
                        MiPushClient.addTopic(this.f125a, irVar.a());
                    }
                    ArrayList arrayList2 = null;
                    if (!TextUtils.isEmpty(irVar.a())) {
                        arrayList2 = new ArrayList();
                        arrayList2.add(irVar.a());
                    }
                    return PushMessageHelper.generateCommandMessage(fg.COMMAND_SUBSCRIBE_TOPIC.f398a, arrayList2, irVar.f790a, irVar.f796d, irVar.b());
                case 5:
                    iv ivVar = (iv) a2;
                    if (ivVar.f835a == 0) {
                        MiPushClient.removeTopic(this.f125a, ivVar.a());
                    }
                    ArrayList arrayList3 = null;
                    if (!TextUtils.isEmpty(ivVar.a())) {
                        arrayList3 = new ArrayList();
                        arrayList3.add(ivVar.a());
                    }
                    return PushMessageHelper.generateCommandMessage(fg.COMMAND_UNSUBSCRIBE_TOPIC.f398a, arrayList3, ivVar.f835a, ivVar.f841d, ivVar.b());
                case 6:
                    df.a(this.f125a.getPackageName(), this.f125a, a2, hm.Command, bArr.length);
                    ih ihVar = (ih) a2;
                    String a7 = ihVar.a();
                    List<String> m439a = ihVar.m439a();
                    if (ihVar.f665a == 0) {
                        if (TextUtils.equals(a7, fg.COMMAND_SET_ACCEPT_TIME.f398a) && m439a != null && m439a.size() > 1) {
                            MiPushClient.addAcceptTime(this.f125a, m439a.get(0), m439a.get(1));
                            if ("00:00".equals(m439a.get(0)) && "00:00".equals(m439a.get(1))) {
                                b.m120a(this.f125a).a(true);
                            } else {
                                b.m120a(this.f125a).a(false);
                            }
                            list = a(TimeZone.getTimeZone("GMT+08"), TimeZone.getDefault(), m439a);
                        } else if (TextUtils.equals(a7, fg.COMMAND_SET_ALIAS.f398a) && m439a != null && m439a.size() > 0) {
                            MiPushClient.addAlias(this.f125a, m439a.get(0));
                            list = m439a;
                        } else if (TextUtils.equals(a7, fg.COMMAND_UNSET_ALIAS.f398a) && m439a != null && m439a.size() > 0) {
                            MiPushClient.removeAlias(this.f125a, m439a.get(0));
                            list = m439a;
                        } else if (TextUtils.equals(a7, fg.COMMAND_SET_ACCOUNT.f398a) && m439a != null && m439a.size() > 0) {
                            MiPushClient.addAccount(this.f125a, m439a.get(0));
                            list = m439a;
                        } else if (TextUtils.equals(a7, fg.COMMAND_UNSET_ACCOUNT.f398a) && m439a != null && m439a.size() > 0) {
                            MiPushClient.removeAccount(this.f125a, m439a.get(0));
                            list = m439a;
                        } else if (TextUtils.equals(a7, fg.COMMAND_CHK_VDEVID.f398a)) {
                            if (m439a != null && m439a.size() > 0) {
                                com.xiaomi.push.i.a(this.f125a, m439a.get(0));
                            }
                            return null;
                        }
                        return PushMessageHelper.generateCommandMessage(a7, list, ihVar.f665a, ihVar.f673d, ihVar.b());
                    }
                    list = m439a;
                    return PushMessageHelper.generateCommandMessage(a7, list, ihVar.f665a, ihVar.f673d, ihVar.b());
                case 7:
                    df.a(this.f125a.getPackageName(), this.f125a, a2, hm.Notification, bArr.length);
                    if (a2 instanceof id) {
                        id idVar = (id) a2;
                        String a8 = idVar.a();
                        if (hw.DisablePushMessage.f555a.equalsIgnoreCase(idVar.f642d)) {
                            if (idVar.f635a == 0) {
                                synchronized (ag.class) {
                                    if (ag.a(this.f125a).m100a(a8)) {
                                        ag.a(this.f125a).c(a8);
                                        if ("syncing".equals(ag.a(this.f125a).a(av.DISABLE_PUSH))) {
                                            ag.a(this.f125a).a(av.DISABLE_PUSH, "synced");
                                            MiPushClient.clearNotification(this.f125a);
                                            MiPushClient.clearLocalNotificationType(this.f125a);
                                            PushMessageHandler.a();
                                            aq.a(this.f125a).m115b();
                                        }
                                    }
                                }
                                break;
                            } else if ("syncing".equals(ag.a(this.f125a).a(av.DISABLE_PUSH))) {
                                synchronized (ag.class) {
                                    if (ag.a(this.f125a).m100a(a8)) {
                                        if (ag.a(this.f125a).a(a8) < 10) {
                                            ag.a(this.f125a).b(a8);
                                            aq.a(this.f125a).a(true, a8);
                                        } else {
                                            ag.a(this.f125a).c(a8);
                                        }
                                    }
                                }
                                break;
                            } else {
                                ag.a(this.f125a).c(a8);
                                break;
                            }
                        } else if (hw.EnablePushMessage.f555a.equalsIgnoreCase(idVar.f642d)) {
                            if (idVar.f635a == 0) {
                                synchronized (ag.class) {
                                    if (ag.a(this.f125a).m100a(a8)) {
                                        ag.a(this.f125a).c(a8);
                                        if ("syncing".equals(ag.a(this.f125a).a(av.ENABLE_PUSH))) {
                                            ag.a(this.f125a).a(av.ENABLE_PUSH, "synced");
                                        }
                                    }
                                }
                                break;
                            } else if ("syncing".equals(ag.a(this.f125a).a(av.ENABLE_PUSH))) {
                                synchronized (ag.class) {
                                    if (ag.a(this.f125a).m100a(a8)) {
                                        if (ag.a(this.f125a).a(a8) < 10) {
                                            ag.a(this.f125a).b(a8);
                                            aq.a(this.f125a).a(false, a8);
                                        } else {
                                            ag.a(this.f125a).c(a8);
                                        }
                                    }
                                }
                                break;
                            } else {
                                ag.a(this.f125a).c(a8);
                                break;
                            }
                        } else if (hw.ThirdPartyRegUpdate.f555a.equalsIgnoreCase(idVar.f642d)) {
                            b(idVar);
                            break;
                        } else if (hw.UploadTinyData.f555a.equalsIgnoreCase(idVar.f642d)) {
                            a(idVar);
                            break;
                        }
                    } else if (a2 instanceof il) {
                        il ilVar = (il) a2;
                        if ("registration id expired".equalsIgnoreCase(ilVar.f701d)) {
                            List<String> allAlias = MiPushClient.getAllAlias(this.f125a);
                            List<String> allTopic = MiPushClient.getAllTopic(this.f125a);
                            List<String> allUserAccount = MiPushClient.getAllUserAccount(this.f125a);
                            String acceptTime = MiPushClient.getAcceptTime(this.f125a);
                            MiPushClient.reInitialize(this.f125a, ia.RegIdExpired);
                            for (String str5 : allAlias) {
                                MiPushClient.removeAlias(this.f125a, str5);
                                MiPushClient.setAlias(this.f125a, str5, null);
                            }
                            for (String str6 : allTopic) {
                                MiPushClient.removeTopic(this.f125a, str6);
                                MiPushClient.subscribe(this.f125a, str6, null);
                            }
                            for (String str7 : allUserAccount) {
                                MiPushClient.removeAccount(this.f125a, str7);
                                MiPushClient.setUserAccount(this.f125a, str7, null);
                            }
                            String[] split = acceptTime.split(",");
                            if (split.length == 2) {
                                MiPushClient.removeAcceptTime(this.f125a);
                                MiPushClient.addAcceptTime(this.f125a, split[0], split[1]);
                                break;
                            }
                        } else if ("client_info_update_ok".equalsIgnoreCase(ilVar.f701d)) {
                            if (ilVar.m459a() != null && ilVar.m459a().containsKey("app_version")) {
                                b.m120a(this.f125a).m123a(ilVar.m459a().get("app_version"));
                                break;
                            }
                        } else if (hw.AwakeApp.f555a.equalsIgnoreCase(ilVar.f701d)) {
                            if (iiVar.m452b() && ilVar.m459a() != null && ilVar.m459a().containsKey("awake_info")) {
                                n.a(this.f125a, b.m120a(this.f125a).m121a(), com.xiaomi.push.service.ak.a(this.f125a).a(hr.AwakeInfoUploadWaySwitch.a(), 0), ilVar.m459a().get("awake_info"));
                                break;
                            }
                        } else if (hw.NormalClientConfigUpdate.f555a.equalsIgnoreCase(ilVar.f701d)) {
                            ik ikVar = new ik();
                            try {
                                iw.a(ikVar, ilVar.m464a());
                                com.xiaomi.push.service.al.a(com.xiaomi.push.service.ak.a(this.f125a), ikVar);
                                break;
                            } catch (jc e) {
                                com.xiaomi.channel.commonutils.logger.b.a(e);
                                break;
                            }
                        } else if (hw.CustomClientConfigUpdate.f555a.equalsIgnoreCase(ilVar.f701d)) {
                            ij ijVar = new ij();
                            try {
                                iw.a(ijVar, ilVar.m464a());
                                com.xiaomi.push.service.al.a(com.xiaomi.push.service.ak.a(this.f125a), ijVar);
                                break;
                            } catch (jc e2) {
                                com.xiaomi.channel.commonutils.logger.b.a(e2);
                                break;
                            }
                        } else if (hw.SyncInfoResult.f555a.equalsIgnoreCase(ilVar.f701d)) {
                            aw.a(this.f125a, ilVar);
                            break;
                        } else if (hw.ForceSync.f555a.equalsIgnoreCase(ilVar.f701d)) {
                            com.xiaomi.channel.commonutils.logger.b.m80a("receive force sync notification");
                            aw.a(this.f125a, false);
                            break;
                        } else if (!hw.CancelPushMessage.f555a.equals(ilVar.f701d)) {
                            if (hw.HybridRegisterResult.f555a.equals(ilVar.f701d)) {
                                try {
                                    in inVar2 = new in();
                                    iw.a(inVar2, ilVar.m464a());
                                    MiPushClient4Hybrid.onReceiveRegisterResult(this.f125a, inVar2);
                                    break;
                                } catch (jc e3) {
                                    com.xiaomi.channel.commonutils.logger.b.a(e3);
                                    break;
                                }
                            } else if (hw.HybridUnregisterResult.f555a.equals(ilVar.f701d)) {
                                try {
                                    it itVar = new it();
                                    iw.a(itVar, ilVar.m464a());
                                    MiPushClient4Hybrid.onReceiveUnregisterResult(this.f125a, itVar);
                                    break;
                                } catch (jc e4) {
                                    com.xiaomi.channel.commonutils.logger.b.a(e4);
                                    break;
                                }
                            } else if (hw.PushLogUpload.f555a.equals(ilVar.f701d) && ilVar.m459a() != null && ilVar.m459a().containsKey("packages")) {
                                String[] split2 = ilVar.m459a().get("packages").split(",");
                                if (TextUtils.equals(this.f125a.getPackageName(), "com.xiaomi.xmsf")) {
                                    Logger.uploadLogFile(this.f125a, true);
                                    a(this.f125a, split2);
                                    break;
                                } else {
                                    Logger.uploadLogFile(this.f125a, false);
                                    break;
                                }
                            }
                        } else if (ilVar.m459a() != null) {
                            if (ilVar.m459a().containsKey(com.xiaomi.push.service.at.J)) {
                                String str8 = ilVar.m459a().get(com.xiaomi.push.service.at.J);
                                if (!TextUtils.isEmpty(str8)) {
                                    try {
                                        i2 = Integer.parseInt(str8);
                                    } catch (NumberFormatException e5) {
                                        e5.printStackTrace();
                                        i2 = -2;
                                    }
                                    if (i2 < -1) {
                                        MiPushClient.clearNotification(this.f125a, i2);
                                        break;
                                    } else {
                                        MiPushClient.clearNotification(this.f125a, ilVar.m459a().containsKey(com.xiaomi.push.service.at.H) ? ilVar.m459a().get(com.xiaomi.push.service.at.H) : "", ilVar.m459a().containsKey(com.xiaomi.push.service.at.I) ? ilVar.m459a().get(com.xiaomi.push.service.at.I) : "");
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
            fb.a(this.f125a).b(this.f125a.getPackageName(), fa.m297a(i), str, com.tencent.connect.common.Constants.VIA_ACT_TYPE_NINETEEN);
            return null;
        } catch (jc e7) {
            com.xiaomi.channel.commonutils.logger.b.a(e7);
            com.xiaomi.channel.commonutils.logger.b.d("receive a message which action string is not valid. is the reg expired?");
            fb.a(this.f125a).b(this.f125a.getPackageName(), fa.m297a(i), str, "20");
            return null;
        }
    }

    private PushMessageHandler.a a(ii iiVar, byte[] bArr) {
        String str = null;
        try {
            ix a2 = aj.a(this.f125a, iiVar);
            if (a2 == null) {
                com.xiaomi.channel.commonutils.logger.b.d("message arrived: receiving an un-recognized message. " + iiVar.f677a);
                return null;
            }
            hm a3 = iiVar.a();
            com.xiaomi.channel.commonutils.logger.b.m80a("message arrived: processing an arrived message, action=" + a3);
            switch (ap.f13808a[a3.ordinal()]) {
                case 1:
                    if (!iiVar.m452b()) {
                        com.xiaomi.channel.commonutils.logger.b.d("message arrived: receiving an un-encrypt message(SendMessage).");
                        return null;
                    }
                    ip ipVar = (ip) a2;
                    hy a4 = ipVar.a();
                    if (a4 == null) {
                        com.xiaomi.channel.commonutils.logger.b.d("message arrived: receive an empty message without push content, drop it");
                        return null;
                    }
                    if (iiVar.f678a != null && iiVar.f678a.m404a() != null) {
                        str = iiVar.f678a.f590a.get("jobkey");
                    }
                    MiPushMessage generateMessage = PushMessageHelper.generateMessage(ipVar, iiVar.m444a(), false);
                    generateMessage.setArrivedMessage(true);
                    com.xiaomi.channel.commonutils.logger.b.m80a("message arrived: receive a message, msgid=" + a4.m395a() + ", jobkey=" + str);
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
        if (f13806a == null) {
            f13806a = new an(context);
        }
        return f13806a;
    }

    private void a() {
        SharedPreferences sharedPreferences = this.f125a.getSharedPreferences("mipush_extra", 0);
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - sharedPreferences.getLong(Constants.SP_KEY_LAST_REINITIALIZE, 0L)) > 1800000) {
            MiPushClient.reInitialize(this.f125a, ia.PackageUnregistered);
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
        synchronized (f123a) {
            f124a.remove(str);
            b.m120a(context);
            SharedPreferences a2 = b.a(context);
            String a3 = bf.a(f124a, ",");
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
        Map<String, String> m427a = idVar.m427a();
        if (m427a != null) {
            String str = m427a.get("real_source");
            if (TextUtils.isEmpty(str)) {
                return;
            }
            com.xiaomi.channel.commonutils.logger.b.b("receive ack : messageId = " + a2 + "  realSource = " + str);
            bp.a(this.f125a).a(a2, str, Boolean.valueOf(idVar.f635a == 0));
        }
    }

    private void a(ii iiVar) {
        com.xiaomi.channel.commonutils.logger.b.m80a("receive a message but decrypt failed. report now.");
        il ilVar = new il(iiVar.m444a().f588a, false);
        ilVar.c(hw.DecryptMessageFail.f555a);
        ilVar.b(iiVar.m445a());
        ilVar.d(iiVar.f684b);
        ilVar.f696a = new HashMap();
        ilVar.f696a.put("regid", MiPushClient.getRegId(this.f125a));
        aq.a(this.f125a).a((aq) ilVar, hm.Notification, false, (hz) null);
    }

    private void a(ip ipVar, ii iiVar) {
        hz m444a = iiVar.m444a();
        ic icVar = new ic();
        icVar.b(ipVar.b());
        icVar.a(ipVar.m479a());
        icVar.a(ipVar.a().a());
        if (!TextUtils.isEmpty(ipVar.c())) {
            icVar.c(ipVar.c());
        }
        if (!TextUtils.isEmpty(ipVar.d())) {
            icVar.d(ipVar.d());
        }
        icVar.a(iw.a(this.f125a, iiVar));
        aq.a(this.f125a).a((aq) icVar, hm.AckMessage, m444a);
    }

    private void a(String str, long j, d dVar) {
        av a2 = k.a(dVar);
        if (a2 == null) {
            return;
        }
        if (j == 0) {
            synchronized (ag.class) {
                if (ag.a(this.f125a).m100a(str)) {
                    ag.a(this.f125a).c(str);
                    if ("syncing".equals(ag.a(this.f125a).a(a2))) {
                        ag.a(this.f125a).a(a2, "synced");
                    }
                }
            }
        } else if (!"syncing".equals(ag.a(this.f125a).a(a2))) {
            ag.a(this.f125a).c(str);
        } else {
            synchronized (ag.class) {
                if (ag.a(this.f125a).m100a(str)) {
                    if (ag.a(this.f125a).a(str) < 10) {
                        ag.a(this.f125a).b(str);
                        aq.a(this.f125a).a(str, a2, dVar);
                    } else {
                        ag.a(this.f125a).c(str);
                    }
                }
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    private static boolean m101a(Context context, String str) {
        boolean z = false;
        synchronized (f123a) {
            b.m120a(context);
            SharedPreferences a2 = b.a(context);
            if (f124a == null) {
                String[] split = a2.getString("pref_msg_ids", "").split(",");
                f124a = new LinkedList();
                for (String str2 : split) {
                    f124a.add(str2);
                }
            }
            if (f124a.contains(str)) {
                z = true;
            } else {
                f124a.add(str);
                if (f124a.size() > 25) {
                    f124a.poll();
                }
                String a3 = bf.a(f124a, ",");
                SharedPreferences.Editor edit = a2.edit();
                edit.putString("pref_msg_ids", a3);
                com.xiaomi.push.r.a(edit);
            }
        }
        return z;
    }

    /* renamed from: a  reason: collision with other method in class */
    private boolean m102a(ii iiVar) {
        if (TextUtils.equals(Constants.HYBRID_PACKAGE_NAME, iiVar.b()) || TextUtils.equals(Constants.HYBRID_DEBUG_PACKAGE_NAME, iiVar.b())) {
            Map<String, String> m404a = iiVar.m444a() == null ? null : iiVar.m444a().m404a();
            if (m404a == null) {
                return false;
            }
            String str = m404a.get(Constants.EXTRA_KEY_PUSH_SERVER_ACTION);
            return TextUtils.equals(str, Constants.EXTRA_VALUE_HYBRID_MESSAGE) || TextUtils.equals(str, Constants.EXTRA_VALUE_PLATFORM_MESSAGE);
        }
        return false;
    }

    private void b(id idVar) {
        com.xiaomi.channel.commonutils.logger.b.c("ASSEMBLE_PUSH : " + idVar.toString());
        String a2 = idVar.a();
        Map<String, String> m427a = idVar.m427a();
        if (m427a != null) {
            String str = m427a.get(Constants.ASSEMBLE_PUSH_REG_INFO);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (str.contains("brand:" + ah.FCM.name())) {
                com.xiaomi.channel.commonutils.logger.b.m80a("ASSEMBLE_PUSH : receive fcm token sync ack");
                h.b(this.f125a, d.ASSEMBLE_PUSH_FCM, str);
                a(a2, idVar.f635a, d.ASSEMBLE_PUSH_FCM);
            } else if (str.contains("brand:" + ah.HUAWEI.name())) {
                com.xiaomi.channel.commonutils.logger.b.m80a("ASSEMBLE_PUSH : receive hw token sync ack");
                h.b(this.f125a, d.ASSEMBLE_PUSH_HUAWEI, str);
                a(a2, idVar.f635a, d.ASSEMBLE_PUSH_HUAWEI);
            } else if (str.contains("brand:" + ah.OPPO.name())) {
                com.xiaomi.channel.commonutils.logger.b.m80a("ASSEMBLE_PUSH : receive COS token sync ack");
                h.b(this.f125a, d.ASSEMBLE_PUSH_COS, str);
                a(a2, idVar.f635a, d.ASSEMBLE_PUSH_COS);
            } else if (str.contains("brand:" + ah.VIVO.name())) {
                com.xiaomi.channel.commonutils.logger.b.m80a("ASSEMBLE_PUSH : receive FTOS token sync ack");
                h.b(this.f125a, d.ASSEMBLE_PUSH_FTOS, str);
                a(a2, idVar.f635a, d.ASSEMBLE_PUSH_FTOS);
            }
        }
    }

    private void b(ii iiVar) {
        hz m444a = iiVar.m444a();
        ic icVar = new ic();
        icVar.b(iiVar.m445a());
        icVar.a(m444a.m403a());
        icVar.a(m444a.m401a());
        if (!TextUtils.isEmpty(m444a.m408b())) {
            icVar.c(m444a.m408b());
        }
        icVar.a(iw.a(this.f125a, iiVar));
        aq.a(this.f125a).a((aq) icVar, hm.AckMessage, false, iiVar.m444a());
    }

    public PushMessageHandler.a a(Intent intent) {
        String action = intent.getAction();
        com.xiaomi.channel.commonutils.logger.b.m80a("receive an intent from server, action=" + action);
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
                fb.a(this.f125a).a(this.f125a.getPackageName(), intent, com.tencent.connect.common.Constants.VIA_REPORT_TYPE_SET_AVATAR);
                return null;
            }
            ii iiVar = new ii();
            try {
                iw.a(iiVar, byteArrayExtra);
                b m120a = b.m120a(this.f125a);
                hz m444a = iiVar.m444a();
                if (iiVar.a() == hm.SendMessage && m444a != null && !m120a.m130d() && !booleanExtra) {
                    m444a.a("mrt", stringExtra);
                    m444a.a("mat", Long.toString(System.currentTimeMillis()));
                    if (m102a(iiVar)) {
                        com.xiaomi.channel.commonutils.logger.b.b("this is a mina's message, ack later");
                        m444a.a(Constants.EXTRA_KEY_HYBRID_MESSAGE_TS, String.valueOf(m444a.m401a()));
                        m444a.a(Constants.EXTRA_KEY_HYBRID_DEVICE_STATUS, String.valueOf((int) iw.a(this.f125a, iiVar)));
                    } else {
                        b(iiVar);
                    }
                }
                if (iiVar.a() == hm.SendMessage && !iiVar.m452b()) {
                    if (com.xiaomi.push.service.aa.m559a(iiVar)) {
                        Object[] objArr = new Object[2];
                        objArr[0] = iiVar.b();
                        objArr[1] = m444a != null ? m444a.m403a() : "";
                        com.xiaomi.channel.commonutils.logger.b.m80a(String.format("drop an un-encrypted wake-up messages. %1$s, %2$s", objArr));
                        fb.a(this.f125a).a(this.f125a.getPackageName(), intent, String.format("13: %1$s", iiVar.b()));
                    } else {
                        Object[] objArr2 = new Object[2];
                        objArr2[0] = iiVar.b();
                        objArr2[1] = m444a != null ? m444a.m403a() : "";
                        com.xiaomi.channel.commonutils.logger.b.m80a(String.format("drop an un-encrypted messages. %1$s, %2$s", objArr2));
                        fb.a(this.f125a).a(this.f125a.getPackageName(), intent, String.format("14: %1$s", iiVar.b()));
                    }
                    return null;
                } else if (iiVar.a() == hm.SendMessage && iiVar.m452b() && com.xiaomi.push.service.aa.m559a(iiVar) && (!booleanExtra || m444a == null || m444a.m404a() == null || !m444a.m404a().containsKey("notify_effect"))) {
                    Object[] objArr3 = new Object[2];
                    objArr3[0] = iiVar.b();
                    objArr3[1] = m444a != null ? m444a.m403a() : "";
                    com.xiaomi.channel.commonutils.logger.b.m80a(String.format("drop a wake-up messages which not has 'notify_effect' attr. %1$s, %2$s", objArr3));
                    fb.a(this.f125a).a(this.f125a.getPackageName(), intent, String.format("25: %1$s", iiVar.b()));
                    return null;
                } else if (m120a.m129c() || iiVar.f677a == hm.Registration) {
                    if (!m120a.m129c() || !m120a.m131e()) {
                        return a(iiVar, booleanExtra, byteArrayExtra, stringExtra2, intExtra);
                    }
                    if (iiVar.f677a == hm.UnRegistration) {
                        m120a.m122a();
                        MiPushClient.clearExtras(this.f125a);
                        PushMessageHandler.a();
                    } else {
                        MiPushClient.unregisterPush(this.f125a);
                    }
                } else if (com.xiaomi.push.service.aa.m559a(iiVar)) {
                    return a(iiVar, booleanExtra, byteArrayExtra, stringExtra2, intExtra);
                } else {
                    com.xiaomi.channel.commonutils.logger.b.d("receive message without registration. need re-register!");
                    fb.a(this.f125a).a(this.f125a.getPackageName(), intent, com.tencent.connect.common.Constants.VIA_REPORT_TYPE_WPA_STATE);
                    a();
                }
            } catch (jc e) {
                fb.a(this.f125a).a(this.f125a.getPackageName(), intent, com.tencent.connect.common.Constants.VIA_REPORT_TYPE_START_WAP);
                com.xiaomi.channel.commonutils.logger.b.a(e);
            } catch (Exception e2) {
                fb.a(this.f125a).a(this.f125a.getPackageName(), intent, com.tencent.connect.common.Constants.VIA_REPORT_TYPE_START_GROUP);
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
                b m120a2 = b.m120a(this.f125a);
                if (com.xiaomi.push.service.aa.m559a(iiVar3)) {
                    com.xiaomi.channel.commonutils.logger.b.d("message arrived: receive ignore reg message, ignore!");
                } else if (!m120a2.m129c()) {
                    com.xiaomi.channel.commonutils.logger.b.d("message arrived: receive message without registration. need unregister or re-register!");
                } else if (!m120a2.m129c() || !m120a2.m131e()) {
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
