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
/* loaded from: classes8.dex */
public class an {
    private static an a = null;

    /* renamed from: a  reason: collision with other field name */
    private static Object f43a = new Object();

    /* renamed from: a  reason: collision with other field name */
    private static Queue<String> f44a;

    /* renamed from: a  reason: collision with other field name */
    private Context f45a;

    private an(Context context) {
        this.f45a = context.getApplicationContext();
        if (this.f45a == null) {
            this.f45a = context;
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
        Intent intent2;
        URISyntaxException e;
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
            if (com.xiaomi.push.service.at.a.equals(str3)) {
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
                                intent2 = intent;
                                e = e5;
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
                    com.xiaomi.channel.commonutils.logger.b.m51a("not resolve activity:" + intent);
                    return null;
                } catch (Exception e8) {
                    com.xiaomi.channel.commonutils.logger.b.d("Cause: " + e8.getMessage());
                    return null;
                }
            }
            return null;
        }
        i = -1;
        if (com.xiaomi.push.service.at.a.equals(str3)) {
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
            ix a2 = aj.a(this.f45a, iiVar);
            if (a2 == null) {
                com.xiaomi.channel.commonutils.logger.b.d("receiving an un-recognized message. " + iiVar.f597a);
                fb.a(this.f45a).b(this.f45a.getPackageName(), fa.m268a(i), str, "18");
                return null;
            }
            hm a3 = iiVar.a();
            com.xiaomi.channel.commonutils.logger.b.m51a("processing a message, action=" + a3);
            switch (ap.a[a3.ordinal()]) {
                case 1:
                    if (!iiVar.m423b()) {
                        com.xiaomi.channel.commonutils.logger.b.d("receiving an un-encrypt message(SendMessage).");
                        return null;
                    } else if (b.m91a(this.f45a).m101d() && !z) {
                        com.xiaomi.channel.commonutils.logger.b.m51a("receive a message in pause state. drop it");
                        fb.a(this.f45a).a(this.f45a.getPackageName(), fa.m268a(i), str, "12");
                        return null;
                    } else {
                        ip ipVar = (ip) a2;
                        hy a4 = ipVar.a();
                        if (a4 == null) {
                            com.xiaomi.channel.commonutils.logger.b.d("receive an empty message without push content, drop it");
                            fb.a(this.f45a).b(this.f45a.getPackageName(), fa.m268a(i), str, com.tencent.connect.common.Constants.VIA_REPORT_TYPE_DATALINE);
                            return null;
                        }
                        if (z) {
                            if (com.xiaomi.push.service.aa.m530a(iiVar)) {
                                MiPushClient.reportIgnoreRegMessageClicked(this.f45a, a4.m366a(), iiVar.m415a(), iiVar.f604b, a4.b());
                            } else {
                                MiPushClient.reportMessageClicked(this.f45a, a4.m366a(), iiVar.m415a(), a4.b());
                            }
                        }
                        if (!z) {
                            if (!TextUtils.isEmpty(ipVar.d()) && MiPushClient.aliasSetTime(this.f45a, ipVar.d()) < 0) {
                                MiPushClient.addAlias(this.f45a, ipVar.d());
                            } else if (!TextUtils.isEmpty(ipVar.c()) && MiPushClient.topicSubscribedTime(this.f45a, ipVar.c()) < 0) {
                                MiPushClient.addTopic(this.f45a, ipVar.c());
                            }
                        }
                        String str2 = null;
                        if (iiVar.f598a != null && iiVar.f598a.m375a() != null) {
                            str2 = iiVar.f598a.f510a.get("jobkey");
                        }
                        String m366a = TextUtils.isEmpty(str2) ? a4.m366a() : str2;
                        if (z || !m72a(this.f45a, m366a)) {
                            generateMessage = PushMessageHelper.generateMessage(ipVar, iiVar.m415a(), z);
                            if (generateMessage.getPassThrough() == 0 && !z && com.xiaomi.push.service.aa.m531a(generateMessage.getExtra())) {
                                com.xiaomi.push.service.aa.m527a(this.f45a, iiVar, bArr);
                                return null;
                            }
                            com.xiaomi.channel.commonutils.logger.b.m51a("receive a message, msgid=" + a4.m366a() + ", jobkey=" + m366a);
                            if (z && generateMessage.getExtra() != null && generateMessage.getExtra().containsKey("notify_effect")) {
                                Map<String, String> extra = generateMessage.getExtra();
                                String str3 = extra.get("notify_effect");
                                if (com.xiaomi.push.service.aa.m530a(iiVar)) {
                                    Intent a5 = a(this.f45a, iiVar.f604b, extra);
                                    a5.putExtra("eventMessageType", i);
                                    a5.putExtra("messageId", str);
                                    if (a5 == null) {
                                        com.xiaomi.channel.commonutils.logger.b.m51a("Getting Intent fail from ignore reg message. ");
                                        fb.a(this.f45a).b(this.f45a.getPackageName(), fa.m268a(i), str, com.tencent.connect.common.Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR);
                                        return null;
                                    }
                                    String c = a4.c();
                                    if (!TextUtils.isEmpty(c)) {
                                        a5.putExtra("payload", c);
                                    }
                                    this.f45a.startActivity(a5);
                                    fb.a(this.f45a).a(this.f45a.getPackageName(), fa.m268a(i), str, 3006, str3);
                                } else {
                                    Intent a6 = a(this.f45a, this.f45a.getPackageName(), extra);
                                    if (a6 != null) {
                                        if (!str3.equals(com.xiaomi.push.service.at.c)) {
                                            a6.putExtra(PushMessageHelper.KEY_MESSAGE, generateMessage);
                                            a6.putExtra("eventMessageType", i);
                                            a6.putExtra("messageId", str);
                                        }
                                        this.f45a.startActivity(a6);
                                        com.xiaomi.channel.commonutils.logger.b.m51a("start activity succ");
                                        fb.a(this.f45a).a(this.f45a.getPackageName(), fa.m268a(i), str, 1006, str3);
                                        if (str3.equals(com.xiaomi.push.service.at.c)) {
                                            fb.a(this.f45a).a(this.f45a.getPackageName(), fa.m268a(i), str, com.tencent.connect.common.Constants.VIA_REPORT_TYPE_JOININ_GROUP);
                                        }
                                    }
                                }
                                return null;
                            }
                        } else {
                            com.xiaomi.channel.commonutils.logger.b.m51a("drop a duplicate message, key=" + m366a);
                            fb.a(this.f45a).c(this.f45a.getPackageName(), fa.m268a(i), str, "2:" + m366a);
                            generateMessage = null;
                        }
                        if (iiVar.m415a() != null || z) {
                            return generateMessage;
                        }
                        a(ipVar, iiVar);
                        return generateMessage;
                    }
                case 2:
                    in inVar = (in) a2;
                    String str4 = b.m91a(this.f45a).f63a;
                    if (TextUtils.isEmpty(str4) || !TextUtils.equals(str4, inVar.m443a())) {
                        com.xiaomi.channel.commonutils.logger.b.m51a("bad Registration result:");
                        fb.a(this.f45a).b(this.f45a.getPackageName(), fa.m268a(i), str, com.tencent.connect.common.Constants.VIA_REPORT_TYPE_QQFAVORITES);
                        return null;
                    }
                    b.m91a(this.f45a).f63a = null;
                    if (inVar.f659a == 0) {
                        b.m91a(this.f45a).b(inVar.f669e, inVar.f670f, inVar.f676l);
                        fb.a(this.f45a).a(this.f45a.getPackageName(), fa.m268a(i), str, 6006, "1");
                    } else {
                        fb.a(this.f45a).a(this.f45a.getPackageName(), fa.m268a(i), str, 6006, "2");
                    }
                    ArrayList arrayList = null;
                    if (!TextUtils.isEmpty(inVar.f669e)) {
                        arrayList = new ArrayList();
                        arrayList.add(inVar.f669e);
                    }
                    MiPushCommandMessage generateCommandMessage = PushMessageHelper.generateCommandMessage(fg.COMMAND_REGISTER.f318a, arrayList, inVar.f659a, inVar.f668d, null);
                    aq.a(this.f45a).m89d();
                    return generateCommandMessage;
                case 3:
                    if (((it) a2).f735a == 0) {
                        b.m91a(this.f45a).m93a();
                        MiPushClient.clearExtras(this.f45a);
                    }
                    PushMessageHandler.a();
                    break;
                case 4:
                    ir irVar = (ir) a2;
                    if (irVar.f710a == 0) {
                        MiPushClient.addTopic(this.f45a, irVar.a());
                    }
                    ArrayList arrayList2 = null;
                    if (!TextUtils.isEmpty(irVar.a())) {
                        arrayList2 = new ArrayList();
                        arrayList2.add(irVar.a());
                    }
                    return PushMessageHelper.generateCommandMessage(fg.COMMAND_SUBSCRIBE_TOPIC.f318a, arrayList2, irVar.f710a, irVar.f716d, irVar.b());
                case 5:
                    iv ivVar = (iv) a2;
                    if (ivVar.f755a == 0) {
                        MiPushClient.removeTopic(this.f45a, ivVar.a());
                    }
                    ArrayList arrayList3 = null;
                    if (!TextUtils.isEmpty(ivVar.a())) {
                        arrayList3 = new ArrayList();
                        arrayList3.add(ivVar.a());
                    }
                    return PushMessageHelper.generateCommandMessage(fg.COMMAND_UNSUBSCRIBE_TOPIC.f318a, arrayList3, ivVar.f755a, ivVar.f761d, ivVar.b());
                case 6:
                    df.a(this.f45a.getPackageName(), this.f45a, a2, hm.Command, bArr.length);
                    ih ihVar = (ih) a2;
                    String a7 = ihVar.a();
                    List<String> m410a = ihVar.m410a();
                    if (ihVar.f585a == 0) {
                        if (TextUtils.equals(a7, fg.COMMAND_SET_ACCEPT_TIME.f318a) && m410a != null && m410a.size() > 1) {
                            MiPushClient.addAcceptTime(this.f45a, m410a.get(0), m410a.get(1));
                            if ("00:00".equals(m410a.get(0)) && "00:00".equals(m410a.get(1))) {
                                b.m91a(this.f45a).a(true);
                            } else {
                                b.m91a(this.f45a).a(false);
                            }
                            list = a(TimeZone.getTimeZone("GMT+08"), TimeZone.getDefault(), m410a);
                        } else if (TextUtils.equals(a7, fg.COMMAND_SET_ALIAS.f318a) && m410a != null && m410a.size() > 0) {
                            MiPushClient.addAlias(this.f45a, m410a.get(0));
                            list = m410a;
                        } else if (TextUtils.equals(a7, fg.COMMAND_UNSET_ALIAS.f318a) && m410a != null && m410a.size() > 0) {
                            MiPushClient.removeAlias(this.f45a, m410a.get(0));
                            list = m410a;
                        } else if (TextUtils.equals(a7, fg.COMMAND_SET_ACCOUNT.f318a) && m410a != null && m410a.size() > 0) {
                            MiPushClient.addAccount(this.f45a, m410a.get(0));
                            list = m410a;
                        } else if (TextUtils.equals(a7, fg.COMMAND_UNSET_ACCOUNT.f318a) && m410a != null && m410a.size() > 0) {
                            MiPushClient.removeAccount(this.f45a, m410a.get(0));
                            list = m410a;
                        } else if (TextUtils.equals(a7, fg.COMMAND_CHK_VDEVID.f318a)) {
                            if (m410a != null && m410a.size() > 0) {
                                com.xiaomi.push.i.a(this.f45a, m410a.get(0));
                            }
                            return null;
                        }
                        return PushMessageHelper.generateCommandMessage(a7, list, ihVar.f585a, ihVar.f593d, ihVar.b());
                    }
                    list = m410a;
                    return PushMessageHelper.generateCommandMessage(a7, list, ihVar.f585a, ihVar.f593d, ihVar.b());
                case 7:
                    df.a(this.f45a.getPackageName(), this.f45a, a2, hm.Notification, bArr.length);
                    if (a2 instanceof id) {
                        id idVar = (id) a2;
                        String a8 = idVar.a();
                        if (hw.DisablePushMessage.f475a.equalsIgnoreCase(idVar.f562d)) {
                            if (idVar.f555a == 0) {
                                synchronized (ag.class) {
                                    if (ag.a(this.f45a).m71a(a8)) {
                                        ag.a(this.f45a).c(a8);
                                        if ("syncing".equals(ag.a(this.f45a).a(av.DISABLE_PUSH))) {
                                            ag.a(this.f45a).a(av.DISABLE_PUSH, "synced");
                                            MiPushClient.clearNotification(this.f45a);
                                            MiPushClient.clearLocalNotificationType(this.f45a);
                                            PushMessageHandler.a();
                                            aq.a(this.f45a).m86b();
                                        }
                                    }
                                }
                                break;
                            } else if ("syncing".equals(ag.a(this.f45a).a(av.DISABLE_PUSH))) {
                                synchronized (ag.class) {
                                    if (ag.a(this.f45a).m71a(a8)) {
                                        if (ag.a(this.f45a).a(a8) < 10) {
                                            ag.a(this.f45a).b(a8);
                                            aq.a(this.f45a).a(true, a8);
                                        } else {
                                            ag.a(this.f45a).c(a8);
                                        }
                                    }
                                }
                                break;
                            } else {
                                ag.a(this.f45a).c(a8);
                                break;
                            }
                        } else if (hw.EnablePushMessage.f475a.equalsIgnoreCase(idVar.f562d)) {
                            if (idVar.f555a == 0) {
                                synchronized (ag.class) {
                                    if (ag.a(this.f45a).m71a(a8)) {
                                        ag.a(this.f45a).c(a8);
                                        if ("syncing".equals(ag.a(this.f45a).a(av.ENABLE_PUSH))) {
                                            ag.a(this.f45a).a(av.ENABLE_PUSH, "synced");
                                        }
                                    }
                                }
                                break;
                            } else if ("syncing".equals(ag.a(this.f45a).a(av.ENABLE_PUSH))) {
                                synchronized (ag.class) {
                                    if (ag.a(this.f45a).m71a(a8)) {
                                        if (ag.a(this.f45a).a(a8) < 10) {
                                            ag.a(this.f45a).b(a8);
                                            aq.a(this.f45a).a(false, a8);
                                        } else {
                                            ag.a(this.f45a).c(a8);
                                        }
                                    }
                                }
                                break;
                            } else {
                                ag.a(this.f45a).c(a8);
                                break;
                            }
                        } else if (hw.ThirdPartyRegUpdate.f475a.equalsIgnoreCase(idVar.f562d)) {
                            b(idVar);
                            break;
                        } else if (hw.UploadTinyData.f475a.equalsIgnoreCase(idVar.f562d)) {
                            a(idVar);
                            break;
                        }
                    } else if (a2 instanceof il) {
                        il ilVar = (il) a2;
                        if ("registration id expired".equalsIgnoreCase(ilVar.f621d)) {
                            List<String> allAlias = MiPushClient.getAllAlias(this.f45a);
                            List<String> allTopic = MiPushClient.getAllTopic(this.f45a);
                            List<String> allUserAccount = MiPushClient.getAllUserAccount(this.f45a);
                            String acceptTime = MiPushClient.getAcceptTime(this.f45a);
                            MiPushClient.reInitialize(this.f45a, ia.RegIdExpired);
                            for (String str5 : allAlias) {
                                MiPushClient.removeAlias(this.f45a, str5);
                                MiPushClient.setAlias(this.f45a, str5, null);
                            }
                            for (String str6 : allTopic) {
                                MiPushClient.removeTopic(this.f45a, str6);
                                MiPushClient.subscribe(this.f45a, str6, null);
                            }
                            for (String str7 : allUserAccount) {
                                MiPushClient.removeAccount(this.f45a, str7);
                                MiPushClient.setUserAccount(this.f45a, str7, null);
                            }
                            String[] split = acceptTime.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                            if (split.length == 2) {
                                MiPushClient.removeAcceptTime(this.f45a);
                                MiPushClient.addAcceptTime(this.f45a, split[0], split[1]);
                                break;
                            }
                        } else if ("client_info_update_ok".equalsIgnoreCase(ilVar.f621d)) {
                            if (ilVar.m430a() != null && ilVar.m430a().containsKey("app_version")) {
                                b.m91a(this.f45a).m94a(ilVar.m430a().get("app_version"));
                                break;
                            }
                        } else if (hw.AwakeApp.f475a.equalsIgnoreCase(ilVar.f621d)) {
                            if (iiVar.m423b() && ilVar.m430a() != null && ilVar.m430a().containsKey("awake_info")) {
                                n.a(this.f45a, b.m91a(this.f45a).m92a(), com.xiaomi.push.service.ak.a(this.f45a).a(hr.AwakeInfoUploadWaySwitch.a(), 0), ilVar.m430a().get("awake_info"));
                                break;
                            }
                        } else if (hw.NormalClientConfigUpdate.f475a.equalsIgnoreCase(ilVar.f621d)) {
                            ik ikVar = new ik();
                            try {
                                iw.a(ikVar, ilVar.m435a());
                                com.xiaomi.push.service.al.a(com.xiaomi.push.service.ak.a(this.f45a), ikVar);
                                break;
                            } catch (jc e) {
                                com.xiaomi.channel.commonutils.logger.b.a(e);
                                break;
                            }
                        } else if (hw.CustomClientConfigUpdate.f475a.equalsIgnoreCase(ilVar.f621d)) {
                            ij ijVar = new ij();
                            try {
                                iw.a(ijVar, ilVar.m435a());
                                com.xiaomi.push.service.al.a(com.xiaomi.push.service.ak.a(this.f45a), ijVar);
                                break;
                            } catch (jc e2) {
                                com.xiaomi.channel.commonutils.logger.b.a(e2);
                                break;
                            }
                        } else if (hw.SyncInfoResult.f475a.equalsIgnoreCase(ilVar.f621d)) {
                            aw.a(this.f45a, ilVar);
                            break;
                        } else if (hw.ForceSync.f475a.equalsIgnoreCase(ilVar.f621d)) {
                            com.xiaomi.channel.commonutils.logger.b.m51a("receive force sync notification");
                            aw.a(this.f45a, false);
                            break;
                        } else if (!hw.CancelPushMessage.f475a.equals(ilVar.f621d)) {
                            if (hw.HybridRegisterResult.f475a.equals(ilVar.f621d)) {
                                try {
                                    in inVar2 = new in();
                                    iw.a(inVar2, ilVar.m435a());
                                    MiPushClient4Hybrid.onReceiveRegisterResult(this.f45a, inVar2);
                                    break;
                                } catch (jc e3) {
                                    com.xiaomi.channel.commonutils.logger.b.a(e3);
                                    break;
                                }
                            } else if (hw.HybridUnregisterResult.f475a.equals(ilVar.f621d)) {
                                try {
                                    it itVar = new it();
                                    iw.a(itVar, ilVar.m435a());
                                    MiPushClient4Hybrid.onReceiveUnregisterResult(this.f45a, itVar);
                                    break;
                                } catch (jc e4) {
                                    com.xiaomi.channel.commonutils.logger.b.a(e4);
                                    break;
                                }
                            } else if (hw.PushLogUpload.f475a.equals(ilVar.f621d) && ilVar.m430a() != null && ilVar.m430a().containsKey("packages")) {
                                String[] split2 = ilVar.m430a().get("packages").split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                                if (TextUtils.equals(this.f45a.getPackageName(), "com.xiaomi.xmsf")) {
                                    Logger.uploadLogFile(this.f45a, true);
                                    a(this.f45a, split2);
                                    break;
                                } else {
                                    Logger.uploadLogFile(this.f45a, false);
                                    break;
                                }
                            }
                        } else if (ilVar.m430a() != null) {
                            if (ilVar.m430a().containsKey(com.xiaomi.push.service.at.J)) {
                                String str8 = ilVar.m430a().get(com.xiaomi.push.service.at.J);
                                if (!TextUtils.isEmpty(str8)) {
                                    try {
                                        i2 = Integer.parseInt(str8);
                                    } catch (NumberFormatException e5) {
                                        e5.printStackTrace();
                                        i2 = -2;
                                    }
                                    if (i2 < -1) {
                                        MiPushClient.clearNotification(this.f45a, i2);
                                        break;
                                    } else {
                                        MiPushClient.clearNotification(this.f45a, ilVar.m430a().containsKey(com.xiaomi.push.service.at.H) ? ilVar.m430a().get(com.xiaomi.push.service.at.H) : "", ilVar.m430a().containsKey(com.xiaomi.push.service.at.I) ? ilVar.m430a().get(com.xiaomi.push.service.at.I) : "");
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
            fb.a(this.f45a).b(this.f45a.getPackageName(), fa.m268a(i), str, com.tencent.connect.common.Constants.VIA_ACT_TYPE_NINETEEN);
            return null;
        } catch (jc e7) {
            com.xiaomi.channel.commonutils.logger.b.a(e7);
            com.xiaomi.channel.commonutils.logger.b.d("receive a message which action string is not valid. is the reg expired?");
            fb.a(this.f45a).b(this.f45a.getPackageName(), fa.m268a(i), str, "20");
            return null;
        }
    }

    private PushMessageHandler.a a(ii iiVar, byte[] bArr) {
        String str = null;
        try {
            ix a2 = aj.a(this.f45a, iiVar);
            if (a2 == null) {
                com.xiaomi.channel.commonutils.logger.b.d("message arrived: receiving an un-recognized message. " + iiVar.f597a);
                return null;
            }
            hm a3 = iiVar.a();
            com.xiaomi.channel.commonutils.logger.b.m51a("message arrived: processing an arrived message, action=" + a3);
            switch (ap.a[a3.ordinal()]) {
                case 1:
                    if (!iiVar.m423b()) {
                        com.xiaomi.channel.commonutils.logger.b.d("message arrived: receiving an un-encrypt message(SendMessage).");
                        return null;
                    }
                    ip ipVar = (ip) a2;
                    hy a4 = ipVar.a();
                    if (a4 == null) {
                        com.xiaomi.channel.commonutils.logger.b.d("message arrived: receive an empty message without push content, drop it");
                        return null;
                    }
                    if (iiVar.f598a != null && iiVar.f598a.m375a() != null) {
                        str = iiVar.f598a.f510a.get("jobkey");
                    }
                    MiPushMessage generateMessage = PushMessageHelper.generateMessage(ipVar, iiVar.m415a(), false);
                    generateMessage.setArrivedMessage(true);
                    com.xiaomi.channel.commonutils.logger.b.m51a("message arrived: receive a message, msgid=" + a4.m366a() + ", jobkey=" + str);
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
        if (a == null) {
            a = new an(context);
        }
        return a;
    }

    private void a() {
        SharedPreferences sharedPreferences = this.f45a.getSharedPreferences("mipush_extra", 0);
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - sharedPreferences.getLong(Constants.SP_KEY_LAST_REINITIALIZE, 0L)) > 1800000) {
            MiPushClient.reInitialize(this.f45a, ia.PackageUnregistered);
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
        synchronized (f43a) {
            f44a.remove(str);
            b.m91a(context);
            SharedPreferences a2 = b.a(context);
            String a3 = bf.a(f44a, Constants.ACCEPT_TIME_SEPARATOR_SP);
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
        Map<String, String> m398a = idVar.m398a();
        if (m398a != null) {
            String str = m398a.get("real_source");
            if (TextUtils.isEmpty(str)) {
                return;
            }
            com.xiaomi.channel.commonutils.logger.b.b("receive ack : messageId = " + a2 + "  realSource = " + str);
            bp.a(this.f45a).a(a2, str, Boolean.valueOf(idVar.f555a == 0));
        }
    }

    private void a(ii iiVar) {
        com.xiaomi.channel.commonutils.logger.b.m51a("receive a message but decrypt failed. report now.");
        il ilVar = new il(iiVar.m415a().f508a, false);
        ilVar.c(hw.DecryptMessageFail.f475a);
        ilVar.b(iiVar.m416a());
        ilVar.d(iiVar.f604b);
        ilVar.f616a = new HashMap();
        ilVar.f616a.put("regid", MiPushClient.getRegId(this.f45a));
        aq.a(this.f45a).a((aq) ilVar, hm.Notification, false, (hz) null);
    }

    private void a(ip ipVar, ii iiVar) {
        hz m415a = iiVar.m415a();
        ic icVar = new ic();
        icVar.b(ipVar.b());
        icVar.a(ipVar.m450a());
        icVar.a(ipVar.a().a());
        if (!TextUtils.isEmpty(ipVar.c())) {
            icVar.c(ipVar.c());
        }
        if (!TextUtils.isEmpty(ipVar.d())) {
            icVar.d(ipVar.d());
        }
        icVar.a(iw.a(this.f45a, iiVar));
        aq.a(this.f45a).a((aq) icVar, hm.AckMessage, m415a);
    }

    private void a(String str, long j, d dVar) {
        av a2 = k.a(dVar);
        if (a2 == null) {
            return;
        }
        if (j == 0) {
            synchronized (ag.class) {
                if (ag.a(this.f45a).m71a(str)) {
                    ag.a(this.f45a).c(str);
                    if ("syncing".equals(ag.a(this.f45a).a(a2))) {
                        ag.a(this.f45a).a(a2, "synced");
                    }
                }
            }
        } else if (!"syncing".equals(ag.a(this.f45a).a(a2))) {
            ag.a(this.f45a).c(str);
        } else {
            synchronized (ag.class) {
                if (ag.a(this.f45a).m71a(str)) {
                    if (ag.a(this.f45a).a(str) < 10) {
                        ag.a(this.f45a).b(str);
                        aq.a(this.f45a).a(str, a2, dVar);
                    } else {
                        ag.a(this.f45a).c(str);
                    }
                }
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    private static boolean m72a(Context context, String str) {
        boolean z = false;
        synchronized (f43a) {
            b.m91a(context);
            SharedPreferences a2 = b.a(context);
            if (f44a == null) {
                String[] split = a2.getString("pref_msg_ids", "").split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                f44a = new LinkedList();
                for (String str2 : split) {
                    f44a.add(str2);
                }
            }
            if (f44a.contains(str)) {
                z = true;
            } else {
                f44a.add(str);
                if (f44a.size() > 25) {
                    f44a.poll();
                }
                String a3 = bf.a(f44a, Constants.ACCEPT_TIME_SEPARATOR_SP);
                SharedPreferences.Editor edit = a2.edit();
                edit.putString("pref_msg_ids", a3);
                com.xiaomi.push.r.a(edit);
            }
        }
        return z;
    }

    /* renamed from: a  reason: collision with other method in class */
    private boolean m73a(ii iiVar) {
        if (TextUtils.equals(Constants.HYBRID_PACKAGE_NAME, iiVar.b()) || TextUtils.equals(Constants.HYBRID_DEBUG_PACKAGE_NAME, iiVar.b())) {
            Map<String, String> m375a = iiVar.m415a() == null ? null : iiVar.m415a().m375a();
            if (m375a == null) {
                return false;
            }
            String str = m375a.get(Constants.EXTRA_KEY_PUSH_SERVER_ACTION);
            return TextUtils.equals(str, Constants.EXTRA_VALUE_HYBRID_MESSAGE) || TextUtils.equals(str, Constants.EXTRA_VALUE_PLATFORM_MESSAGE);
        }
        return false;
    }

    private void b(id idVar) {
        com.xiaomi.channel.commonutils.logger.b.c("ASSEMBLE_PUSH : " + idVar.toString());
        String a2 = idVar.a();
        Map<String, String> m398a = idVar.m398a();
        if (m398a != null) {
            String str = m398a.get(Constants.ASSEMBLE_PUSH_REG_INFO);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (str.contains("brand:" + ah.FCM.name())) {
                com.xiaomi.channel.commonutils.logger.b.m51a("ASSEMBLE_PUSH : receive fcm token sync ack");
                h.b(this.f45a, d.ASSEMBLE_PUSH_FCM, str);
                a(a2, idVar.f555a, d.ASSEMBLE_PUSH_FCM);
            } else if (str.contains("brand:" + ah.HUAWEI.name())) {
                com.xiaomi.channel.commonutils.logger.b.m51a("ASSEMBLE_PUSH : receive hw token sync ack");
                h.b(this.f45a, d.ASSEMBLE_PUSH_HUAWEI, str);
                a(a2, idVar.f555a, d.ASSEMBLE_PUSH_HUAWEI);
            } else if (str.contains("brand:" + ah.OPPO.name())) {
                com.xiaomi.channel.commonutils.logger.b.m51a("ASSEMBLE_PUSH : receive COS token sync ack");
                h.b(this.f45a, d.ASSEMBLE_PUSH_COS, str);
                a(a2, idVar.f555a, d.ASSEMBLE_PUSH_COS);
            } else if (str.contains("brand:" + ah.VIVO.name())) {
                com.xiaomi.channel.commonutils.logger.b.m51a("ASSEMBLE_PUSH : receive FTOS token sync ack");
                h.b(this.f45a, d.ASSEMBLE_PUSH_FTOS, str);
                a(a2, idVar.f555a, d.ASSEMBLE_PUSH_FTOS);
            }
        }
    }

    private void b(ii iiVar) {
        hz m415a = iiVar.m415a();
        ic icVar = new ic();
        icVar.b(iiVar.m416a());
        icVar.a(m415a.m374a());
        icVar.a(m415a.m372a());
        if (!TextUtils.isEmpty(m415a.m379b())) {
            icVar.c(m415a.m379b());
        }
        icVar.a(iw.a(this.f45a, iiVar));
        aq.a(this.f45a).a((aq) icVar, hm.AckMessage, false, iiVar.m415a());
    }

    public PushMessageHandler.a a(Intent intent) {
        String action = intent.getAction();
        com.xiaomi.channel.commonutils.logger.b.m51a("receive an intent from server, action=" + action);
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
                fb.a(this.f45a).a(this.f45a.getPackageName(), intent, "12");
                return null;
            }
            ii iiVar = new ii();
            try {
                iw.a(iiVar, byteArrayExtra);
                b m91a = b.m91a(this.f45a);
                hz m415a = iiVar.m415a();
                if (iiVar.a() == hm.SendMessage && m415a != null && !m91a.m101d() && !booleanExtra) {
                    m415a.a("mrt", stringExtra);
                    m415a.a("mat", Long.toString(System.currentTimeMillis()));
                    if (m73a(iiVar)) {
                        com.xiaomi.channel.commonutils.logger.b.b("this is a mina's message, ack later");
                        m415a.a(Constants.EXTRA_KEY_HYBRID_MESSAGE_TS, String.valueOf(m415a.m372a()));
                        m415a.a(Constants.EXTRA_KEY_HYBRID_DEVICE_STATUS, String.valueOf((int) iw.a(this.f45a, iiVar)));
                    } else {
                        b(iiVar);
                    }
                }
                if (iiVar.a() == hm.SendMessage && !iiVar.m423b()) {
                    if (com.xiaomi.push.service.aa.m530a(iiVar)) {
                        Object[] objArr = new Object[2];
                        objArr[0] = iiVar.b();
                        objArr[1] = m415a != null ? m415a.m374a() : "";
                        com.xiaomi.channel.commonutils.logger.b.m51a(String.format("drop an un-encrypted wake-up messages. %1$s, %2$s", objArr));
                        fb.a(this.f45a).a(this.f45a.getPackageName(), intent, String.format("13: %1$s", iiVar.b()));
                    } else {
                        Object[] objArr2 = new Object[2];
                        objArr2[0] = iiVar.b();
                        objArr2[1] = m415a != null ? m415a.m374a() : "";
                        com.xiaomi.channel.commonutils.logger.b.m51a(String.format("drop an un-encrypted messages. %1$s, %2$s", objArr2));
                        fb.a(this.f45a).a(this.f45a.getPackageName(), intent, String.format("14: %1$s", iiVar.b()));
                    }
                    return null;
                } else if (iiVar.a() == hm.SendMessage && iiVar.m423b() && com.xiaomi.push.service.aa.m530a(iiVar) && (!booleanExtra || m415a == null || m415a.m375a() == null || !m415a.m375a().containsKey("notify_effect"))) {
                    Object[] objArr3 = new Object[2];
                    objArr3[0] = iiVar.b();
                    objArr3[1] = m415a != null ? m415a.m374a() : "";
                    com.xiaomi.channel.commonutils.logger.b.m51a(String.format("drop a wake-up messages which not has 'notify_effect' attr. %1$s, %2$s", objArr3));
                    fb.a(this.f45a).a(this.f45a.getPackageName(), intent, String.format("25: %1$s", iiVar.b()));
                    return null;
                } else if (m91a.m100c() || iiVar.f597a == hm.Registration) {
                    if (!m91a.m100c() || !m91a.m102e()) {
                        return a(iiVar, booleanExtra, byteArrayExtra, stringExtra2, intExtra);
                    }
                    if (iiVar.f597a == hm.UnRegistration) {
                        m91a.m93a();
                        MiPushClient.clearExtras(this.f45a);
                        PushMessageHandler.a();
                    } else {
                        MiPushClient.unregisterPush(this.f45a);
                    }
                } else if (com.xiaomi.push.service.aa.m530a(iiVar)) {
                    return a(iiVar, booleanExtra, byteArrayExtra, stringExtra2, intExtra);
                } else {
                    com.xiaomi.channel.commonutils.logger.b.d("receive message without registration. need re-register!");
                    fb.a(this.f45a).a(this.f45a.getPackageName(), intent, com.tencent.connect.common.Constants.VIA_REPORT_TYPE_WPA_STATE);
                    a();
                }
            } catch (jc e) {
                fb.a(this.f45a).a(this.f45a.getPackageName(), intent, com.tencent.connect.common.Constants.VIA_REPORT_TYPE_START_WAP);
                com.xiaomi.channel.commonutils.logger.b.a(e);
            } catch (Exception e2) {
                fb.a(this.f45a).a(this.f45a.getPackageName(), intent, "17");
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
                b m91a2 = b.m91a(this.f45a);
                if (com.xiaomi.push.service.aa.m530a(iiVar3)) {
                    com.xiaomi.channel.commonutils.logger.b.d("message arrived: receive ignore reg message, ignore!");
                } else if (!m91a2.m100c()) {
                    com.xiaomi.channel.commonutils.logger.b.d("message arrived: receive message without registration. need unregister or re-register!");
                } else if (!m91a2.m100c() || !m91a2.m102e()) {
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
