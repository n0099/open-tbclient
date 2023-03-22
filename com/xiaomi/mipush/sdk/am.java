package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.SystemClock;
import android.text.TextUtils;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.searchbox.player.widget.BdPlayerProgressView;
import com.huawei.hms.support.api.entity.auth.AuthCode;
import com.xiaomi.mipush.sdk.PushMessageHandler;
import com.xiaomi.push.Cif;
import com.xiaomi.push.bo;
import com.xiaomi.push.bw;
import com.xiaomi.push.da;
import com.xiaomi.push.em;
import com.xiaomi.push.en;
import com.xiaomi.push.ex;
import com.xiaomi.push.hh;
import com.xiaomi.push.hm;
import com.xiaomi.push.hr;
import com.xiaomi.push.ht;
import com.xiaomi.push.hu;
import com.xiaomi.push.hv;
import com.xiaomi.push.hx;
import com.xiaomi.push.hy;
import com.xiaomi.push.ic;
import com.xiaomi.push.id;
import com.xiaomi.push.ie;
import com.xiaomi.push.ig;
import com.xiaomi.push.ii;
import com.xiaomi.push.ik;
import com.xiaomi.push.im;
import com.xiaomi.push.io;
import com.xiaomi.push.iq;
import com.xiaomi.push.ir;
import com.xiaomi.push.is;
import com.xiaomi.push.ix;
import com.xiaomi.push.service.ay;
import com.xiaomi.push.service.ba;
import com.xiaomi.push.service.bb;
import com.xiaomi.push.service.bk;
import com.xiaomi.push.service.br;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.eventtype.PayUVEventType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TimeZone;
/* loaded from: classes8.dex */
public class am {
    public static am a;

    /* renamed from: a  reason: collision with other field name */
    public static Object f53a = new Object();

    /* renamed from: a  reason: collision with other field name */
    public static Queue<String> f54a;

    /* renamed from: a  reason: collision with other field name */
    public Context f55a;

    public am(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f55a = applicationContext;
        if (applicationContext == null) {
            this.f55a = context;
        }
    }

    public static Intent a(Context context, String str, Map<String, String> map, int i) {
        return com.xiaomi.push.service.ak.b(context, str, map, i);
    }

    private PushMessageHandler.a a(id idVar, boolean z, byte[] bArr, String str, int i, Intent intent) {
        en a2;
        String packageName;
        String m371a;
        String str2;
        String str3;
        String str4;
        MiPushMessage miPushMessage;
        en a3;
        String packageName2;
        String m371a2;
        int i2;
        String str5;
        ArrayList arrayList = null;
        try {
            is a4 = ai.a(this.f55a, idVar);
            if (a4 == null) {
                com.xiaomi.channel.commonutils.logger.b.d("receiving an un-recognized message. " + idVar.f631a);
                en.a(this.f55a).b(this.f55a.getPackageName(), em.m371a(i), str, "18");
                s.c(this.f55a, idVar, z);
                return null;
            }
            hh a5 = idVar.a();
            com.xiaomi.channel.commonutils.logger.b.m99a("processing a message, action=" + a5);
            switch (an.a[a5.ordinal()]) {
                case 1:
                    if (!idVar.m551b()) {
                        com.xiaomi.channel.commonutils.logger.b.d("receiving an un-encrypt message(SendMessage).");
                        return null;
                    } else if (b.m143a(this.f55a).m154e() && !z) {
                        com.xiaomi.channel.commonutils.logger.b.m99a("receive a message in pause state. drop it");
                        en.a(this.f55a).a(this.f55a.getPackageName(), em.m371a(i), str, "12");
                        return null;
                    } else {
                        ik ikVar = (ik) a4;
                        ht a6 = ikVar.a();
                        if (a6 == null) {
                            com.xiaomi.channel.commonutils.logger.b.d("receive an empty message without push content, drop it");
                            en.a(this.f55a).b(this.f55a.getPackageName(), em.m371a(i), str, "22");
                            s.d(this.f55a, idVar, z);
                            return null;
                        }
                        int intExtra = intent.getIntExtra("notification_click_button", 0);
                        if (z) {
                            if (com.xiaomi.push.service.ak.m684a(idVar)) {
                                MiPushClient.reportIgnoreRegMessageClicked(this.f55a, a6.m495a(), idVar.m543a(), idVar.f638b, a6.b());
                            } else {
                                hu huVar = idVar.m543a() != null ? new hu(idVar.m543a()) : new hu();
                                if (huVar.m504a() == null) {
                                    huVar.a(new HashMap());
                                }
                                huVar.m504a().put("notification_click_button", String.valueOf(intExtra));
                                MiPushClient.reportMessageClicked(this.f55a, a6.m495a(), huVar, a6.b());
                            }
                        }
                        if (!z) {
                            if (!TextUtils.isEmpty(ikVar.d()) && MiPushClient.aliasSetTime(this.f55a, ikVar.d()) < 0) {
                                MiPushClient.addAlias(this.f55a, ikVar.d());
                            } else if (!TextUtils.isEmpty(ikVar.c()) && MiPushClient.topicSubscribedTime(this.f55a, ikVar.c()) < 0) {
                                MiPushClient.addTopic(this.f55a, ikVar.c());
                            }
                        }
                        hu huVar2 = idVar.f632a;
                        if (huVar2 == null || huVar2.m504a() == null) {
                            str3 = null;
                            str4 = null;
                        } else {
                            str3 = idVar.f632a.f543a.get("jobkey");
                            str4 = str3;
                        }
                        if (TextUtils.isEmpty(str3)) {
                            str3 = a6.m495a();
                        }
                        if (z || !m122a(this.f55a, str3)) {
                            MiPushMessage generateMessage = PushMessageHelper.generateMessage(ikVar, idVar.m543a(), z);
                            if (generateMessage.getPassThrough() == 0 && !z && com.xiaomi.push.service.ak.m685a(generateMessage.getExtra())) {
                                com.xiaomi.push.service.ak.m680a(this.f55a, idVar, bArr);
                                return null;
                            }
                            com.xiaomi.channel.commonutils.logger.b.m99a("receive a message, msgid=" + a6.m495a() + ", jobkey=" + str3 + ", btn=" + intExtra);
                            String a7 = com.xiaomi.push.service.ak.a(generateMessage.getExtra(), intExtra);
                            if (z && generateMessage.getExtra() != null && !TextUtils.isEmpty(a7)) {
                                Map<String, String> extra = generateMessage.getExtra();
                                if (intExtra != 0 && idVar.m543a() != null) {
                                    ao.a(this.f55a).a(idVar.m543a().c(), intExtra);
                                }
                                if (com.xiaomi.push.service.ak.m684a(idVar)) {
                                    Intent a8 = a(this.f55a, idVar.f638b, extra, intExtra);
                                    a8.putExtra("eventMessageType", i);
                                    a8.putExtra(MiPushMessage.KEY_MESSAGE_ID, str);
                                    a8.putExtra("jobkey", str4);
                                    if (a8 == null) {
                                        com.xiaomi.channel.commonutils.logger.b.m99a("Getting Intent fail from ignore reg message. ");
                                        en.a(this.f55a).b(this.f55a.getPackageName(), em.m371a(i), str, "23");
                                        return null;
                                    }
                                    String c = a6.c();
                                    if (!TextUtils.isEmpty(c)) {
                                        a8.putExtra("payload", c);
                                    }
                                    this.f55a.startActivity(a8);
                                    s.a(this.f55a, idVar);
                                    en.a(this.f55a).a(this.f55a.getPackageName(), em.m371a(i), str, 3006, a7);
                                    return null;
                                }
                                Context context = this.f55a;
                                Intent a9 = a(context, context.getPackageName(), extra, intExtra);
                                if (a9 != null) {
                                    if (!a7.equals(bk.c)) {
                                        a9.putExtra(PushMessageHelper.KEY_MESSAGE, generateMessage);
                                        a9.putExtra("eventMessageType", i);
                                        a9.putExtra(MiPushMessage.KEY_MESSAGE_ID, str);
                                        a9.putExtra("jobkey", str4);
                                    }
                                    this.f55a.startActivity(a9);
                                    s.a(this.f55a, idVar);
                                    com.xiaomi.channel.commonutils.logger.b.m99a("start activity succ");
                                    en.a(this.f55a).a(this.f55a.getPackageName(), em.m371a(i), str, 1006, a7);
                                    if (a7.equals(bk.c)) {
                                        en.a(this.f55a).a(this.f55a.getPackageName(), em.m371a(i), str, "13");
                                        return null;
                                    }
                                    return null;
                                }
                                return null;
                            }
                            miPushMessage = generateMessage;
                        } else {
                            com.xiaomi.channel.commonutils.logger.b.m99a("drop a duplicate message, key=" + str3);
                            en a10 = en.a(this.f55a);
                            String packageName3 = this.f55a.getPackageName();
                            String m371a3 = em.m371a(i);
                            a10.c(packageName3, m371a3, str, "2:" + str3);
                            miPushMessage = null;
                        }
                        if (idVar.m543a() == null && !z) {
                            a(ikVar, idVar);
                        }
                        return miPushMessage;
                    }
                case 2:
                    ii iiVar = (ii) a4;
                    String str6 = b.m143a(this.f55a).f72a;
                    if (TextUtils.isEmpty(str6) || !TextUtils.equals(str6, iiVar.m572a())) {
                        com.xiaomi.channel.commonutils.logger.b.m99a("bad Registration result:");
                        en.a(this.f55a).b(this.f55a.getPackageName(), em.m371a(i), str, "21");
                        return null;
                    }
                    long m132a = ao.a(this.f55a).m132a();
                    if (m132a > 0 && SystemClock.elapsedRealtime() - m132a > com.heytap.mcssdk.constant.a.h) {
                        com.xiaomi.channel.commonutils.logger.b.m99a("The received registration result has expired.");
                        en.a(this.f55a).b(this.f55a.getPackageName(), em.m371a(i), str, "26");
                        return null;
                    }
                    b.m143a(this.f55a).f72a = null;
                    int i3 = (iiVar.f694a > 0L ? 1 : (iiVar.f694a == 0L ? 0 : -1));
                    Context context2 = this.f55a;
                    if (i3 == 0) {
                        b.m143a(context2).b(iiVar.f706e, iiVar.f707f, iiVar.f713l);
                        FCMPushHelper.persistIfXmsfSupDecrypt(this.f55a);
                        a3 = en.a(this.f55a);
                        packageName2 = this.f55a.getPackageName();
                        m371a2 = em.m371a(i);
                        i2 = AuthCode.StatusCode.PERMISSION_EXPIRED;
                        str5 = "1";
                    } else {
                        a3 = en.a(context2);
                        packageName2 = this.f55a.getPackageName();
                        m371a2 = em.m371a(i);
                        i2 = AuthCode.StatusCode.PERMISSION_EXPIRED;
                        str5 = "2";
                    }
                    a3.a(packageName2, m371a2, str, i2, str5);
                    if (!TextUtils.isEmpty(iiVar.f706e)) {
                        arrayList = new ArrayList();
                        arrayList.add(iiVar.f706e);
                    }
                    MiPushCommandMessage generateCommandMessage = PushMessageHelper.generateCommandMessage(ex.COMMAND_REGISTER.f336a, arrayList, iiVar.f694a, iiVar.f705d, null, iiVar.m573a());
                    ao.a(this.f55a).m141d();
                    return generateCommandMessage;
                case 3:
                    if (!idVar.m551b()) {
                        com.xiaomi.channel.commonutils.logger.b.d("receiving an un-encrypt message(UnRegistration).");
                        return null;
                    }
                    if (((io) a4).f772a == 0) {
                        b.m143a(this.f55a).m145a();
                        MiPushClient.clearExtras(this.f55a);
                    }
                    PushMessageHandler.a();
                    break;
                case 4:
                    im imVar = (im) a4;
                    if (imVar.f747a == 0) {
                        MiPushClient.addTopic(this.f55a, imVar.b());
                    }
                    if (!TextUtils.isEmpty(imVar.b())) {
                        arrayList = new ArrayList();
                        arrayList.add(imVar.b());
                    }
                    com.xiaomi.channel.commonutils.logger.b.e("resp-cmd:" + ex.COMMAND_SUBSCRIBE_TOPIC + StringUtil.ARRAY_ELEMENT_SEPARATOR + imVar.a());
                    return PushMessageHelper.generateCommandMessage(ex.COMMAND_SUBSCRIBE_TOPIC.f336a, arrayList, imVar.f747a, imVar.f753d, imVar.c(), null);
                case 5:
                    iq iqVar = (iq) a4;
                    if (iqVar.f792a == 0) {
                        MiPushClient.removeTopic(this.f55a, iqVar.b());
                    }
                    if (!TextUtils.isEmpty(iqVar.b())) {
                        arrayList = new ArrayList();
                        arrayList.add(iqVar.b());
                    }
                    com.xiaomi.channel.commonutils.logger.b.e("resp-cmd:" + ex.COMMAND_UNSUBSCRIBE_TOPIC + StringUtil.ARRAY_ELEMENT_SEPARATOR + iqVar.a());
                    return PushMessageHelper.generateCommandMessage(ex.COMMAND_UNSUBSCRIBE_TOPIC.f336a, arrayList, iqVar.f792a, iqVar.f798d, iqVar.c(), null);
                case 6:
                    da.a(this.f55a.getPackageName(), this.f55a, a4, hh.Command, bArr.length);
                    ic icVar = (ic) a4;
                    String b = icVar.b();
                    List<String> m537a = icVar.m537a();
                    if (icVar.f619a == 0) {
                        if (TextUtils.equals(b, ex.COMMAND_SET_ACCEPT_TIME.f336a) && m537a != null && m537a.size() > 1) {
                            MiPushClient.addAcceptTime(this.f55a, m537a.get(0), m537a.get(1));
                            if (BdPlayerProgressView.DEFAULT_TIME_TEXT.equals(m537a.get(0)) && BdPlayerProgressView.DEFAULT_TIME_TEXT.equals(m537a.get(1))) {
                                b.m143a(this.f55a).a(true);
                            } else {
                                b.m143a(this.f55a).a(false);
                            }
                            m537a = a(TimeZone.getTimeZone("GMT+08"), TimeZone.getDefault(), m537a);
                        } else if (TextUtils.equals(b, ex.COMMAND_SET_ALIAS.f336a) && m537a != null && m537a.size() > 0) {
                            MiPushClient.addAlias(this.f55a, m537a.get(0));
                        } else if (TextUtils.equals(b, ex.COMMAND_UNSET_ALIAS.f336a) && m537a != null && m537a.size() > 0) {
                            MiPushClient.removeAlias(this.f55a, m537a.get(0));
                        } else if (TextUtils.equals(b, ex.COMMAND_SET_ACCOUNT.f336a) && m537a != null && m537a.size() > 0) {
                            MiPushClient.addAccount(this.f55a, m537a.get(0));
                        } else if (TextUtils.equals(b, ex.COMMAND_UNSET_ACCOUNT.f336a) && m537a != null && m537a.size() > 0) {
                            MiPushClient.removeAccount(this.f55a, m537a.get(0));
                        } else if (TextUtils.equals(b, ex.COMMAND_CHK_VDEVID.f336a)) {
                            return null;
                        }
                    }
                    List<String> list = m537a;
                    com.xiaomi.channel.commonutils.logger.b.e("resp-cmd:" + b + StringUtil.ARRAY_ELEMENT_SEPARATOR + icVar.a());
                    return PushMessageHelper.generateCommandMessage(b, list, icVar.f619a, icVar.f627d, icVar.c(), null);
                case 7:
                    da.a(this.f55a.getPackageName(), this.f55a, a4, hh.Notification, bArr.length);
                    if (a4 instanceof hy) {
                        hy hyVar = (hy) a4;
                        String a11 = hyVar.a();
                        com.xiaomi.channel.commonutils.logger.b.e("resp-type:" + hyVar.b() + ", code:" + hyVar.f586a + StringUtil.ARRAY_ELEMENT_SEPARATOR + a11);
                        if (hr.DisablePushMessage.f508a.equalsIgnoreCase(hyVar.f593d)) {
                            if (hyVar.f586a == 0) {
                                synchronized (af.class) {
                                    if (af.a(this.f55a).m121a(a11)) {
                                        af.a(this.f55a).c(a11);
                                        if ("syncing".equals(af.a(this.f55a).a(au.DISABLE_PUSH))) {
                                            af.a(this.f55a).a(au.DISABLE_PUSH, "synced");
                                            MiPushClient.clearNotification(this.f55a);
                                            MiPushClient.clearLocalNotificationType(this.f55a);
                                            PushMessageHandler.a();
                                            ao.a(this.f55a).m138b();
                                        }
                                    }
                                }
                                break;
                            } else if ("syncing".equals(af.a(this.f55a).a(au.DISABLE_PUSH))) {
                                synchronized (af.class) {
                                    if (af.a(this.f55a).m121a(a11)) {
                                        if (af.a(this.f55a).a(a11) < 10) {
                                            af.a(this.f55a).b(a11);
                                            ao.a(this.f55a).a(true, a11);
                                        } else {
                                            af.a(this.f55a).c(a11);
                                        }
                                    }
                                }
                                break;
                            }
                        } else if (hr.EnablePushMessage.f508a.equalsIgnoreCase(hyVar.f593d)) {
                            if (hyVar.f586a == 0) {
                                synchronized (af.class) {
                                    if (af.a(this.f55a).m121a(a11)) {
                                        af.a(this.f55a).c(a11);
                                        if ("syncing".equals(af.a(this.f55a).a(au.ENABLE_PUSH))) {
                                            af.a(this.f55a).a(au.ENABLE_PUSH, "synced");
                                        }
                                    }
                                }
                                break;
                            } else if ("syncing".equals(af.a(this.f55a).a(au.ENABLE_PUSH))) {
                                synchronized (af.class) {
                                    if (af.a(this.f55a).m121a(a11)) {
                                        if (af.a(this.f55a).a(a11) < 10) {
                                            af.a(this.f55a).b(a11);
                                            ao.a(this.f55a).a(false, a11);
                                        } else {
                                            af.a(this.f55a).c(a11);
                                        }
                                    }
                                }
                                break;
                            }
                        } else if (hr.ThirdPartyRegUpdate.f508a.equalsIgnoreCase(hyVar.f593d)) {
                            b(hyVar);
                            break;
                        } else if (hr.UploadTinyData.f508a.equalsIgnoreCase(hyVar.f593d)) {
                            a(hyVar);
                            break;
                        }
                        af.a(this.f55a).c(a11);
                        break;
                    } else if (a4 instanceof ig) {
                        ig igVar = (ig) a4;
                        if ("registration id expired".equalsIgnoreCase(igVar.f655d)) {
                            List<String> allAlias = MiPushClient.getAllAlias(this.f55a);
                            List<String> allTopic = MiPushClient.getAllTopic(this.f55a);
                            List<String> allUserAccount = MiPushClient.getAllUserAccount(this.f55a);
                            String acceptTime = MiPushClient.getAcceptTime(this.f55a);
                            com.xiaomi.channel.commonutils.logger.b.e("resp-type:" + igVar.f655d + StringUtil.ARRAY_ELEMENT_SEPARATOR + igVar.m558a());
                            MiPushClient.reInitialize(this.f55a, hv.RegIdExpired);
                            for (String str7 : allAlias) {
                                MiPushClient.removeAlias(this.f55a, str7);
                                MiPushClient.setAlias(this.f55a, str7, null);
                            }
                            for (String str8 : allTopic) {
                                MiPushClient.removeTopic(this.f55a, str8);
                                MiPushClient.subscribe(this.f55a, str8, null);
                            }
                            for (String str9 : allUserAccount) {
                                MiPushClient.removeAccount(this.f55a, str9);
                                MiPushClient.setUserAccount(this.f55a, str9, null);
                            }
                            String[] split = acceptTime.split(",");
                            if (split.length == 2) {
                                MiPushClient.removeAcceptTime(this.f55a);
                                MiPushClient.addAcceptTime(this.f55a, split[0], split[1]);
                                break;
                            }
                        } else if (hr.ClientInfoUpdateOk.f508a.equalsIgnoreCase(igVar.f655d)) {
                            if (igVar.m559a() != null && igVar.m559a().containsKey("app_version")) {
                                b.m143a(this.f55a).m146a(igVar.m559a().get("app_version"));
                                break;
                            }
                        } else if (hr.AwakeApp.f508a.equalsIgnoreCase(igVar.f655d)) {
                            if (idVar.m551b() && igVar.m559a() != null && igVar.m559a().containsKey("awake_info")) {
                                Context context3 = this.f55a;
                                o.a(context3, b.m143a(context3).m144a(), ba.a(this.f55a).a(hm.AwakeInfoUploadWaySwitch.a(), 0), igVar.m559a().get("awake_info"));
                                break;
                            }
                        } else {
                            try {
                                if (hr.NormalClientConfigUpdate.f508a.equalsIgnoreCase(igVar.f655d)) {
                                    Cif cif = new Cif();
                                    ir.a(cif, igVar.m564a());
                                    bb.a(ba.a(this.f55a), cif);
                                } else if (hr.CustomClientConfigUpdate.f508a.equalsIgnoreCase(igVar.f655d)) {
                                    ie ieVar = new ie();
                                    ir.a(ieVar, igVar.m564a());
                                    bb.a(ba.a(this.f55a), ieVar);
                                } else if (hr.SyncInfoResult.f508a.equalsIgnoreCase(igVar.f655d)) {
                                    av.a(this.f55a, igVar);
                                    break;
                                } else if (hr.ForceSync.f508a.equalsIgnoreCase(igVar.f655d)) {
                                    com.xiaomi.channel.commonutils.logger.b.m99a("receive force sync notification");
                                    av.a(this.f55a, false);
                                    break;
                                } else if (hr.CancelPushMessage.f508a.equals(igVar.f655d)) {
                                    com.xiaomi.channel.commonutils.logger.b.e("resp-type:" + igVar.f655d + StringUtil.ARRAY_ELEMENT_SEPARATOR + igVar.m558a());
                                    if (igVar.m559a() != null) {
                                        int i4 = -2;
                                        if (igVar.m559a().containsKey(bk.M)) {
                                            String str10 = igVar.m559a().get(bk.M);
                                            if (!TextUtils.isEmpty(str10)) {
                                                try {
                                                    i4 = Integer.parseInt(str10);
                                                } catch (NumberFormatException e) {
                                                    e.printStackTrace();
                                                }
                                            }
                                        }
                                        if (i4 >= -1) {
                                            MiPushClient.clearNotification(this.f55a, i4);
                                        } else {
                                            MiPushClient.clearNotification(this.f55a, igVar.m559a().containsKey(bk.K) ? igVar.m559a().get(bk.K) : "", igVar.m559a().containsKey(bk.L) ? igVar.m559a().get(bk.L) : "");
                                        }
                                    }
                                    a(igVar);
                                    break;
                                } else {
                                    try {
                                        if (hr.HybridRegisterResult.f508a.equals(igVar.f655d)) {
                                            ii iiVar2 = new ii();
                                            ir.a(iiVar2, igVar.m564a());
                                            MiPushClient4Hybrid.onReceiveRegisterResult(this.f55a, iiVar2);
                                        } else if (hr.HybridUnregisterResult.f508a.equals(igVar.f655d)) {
                                            io ioVar = new io();
                                            ir.a(ioVar, igVar.m564a());
                                            MiPushClient4Hybrid.onReceiveUnregisterResult(this.f55a, ioVar);
                                        } else if (!hr.PushLogUpload.f508a.equals(igVar.f655d)) {
                                            if (hr.DetectAppAlive.f508a.equals(igVar.f655d)) {
                                                com.xiaomi.channel.commonutils.logger.b.b("receive detect msg");
                                                b(igVar);
                                                break;
                                            } else if (com.xiaomi.push.service.i.a(igVar)) {
                                                com.xiaomi.channel.commonutils.logger.b.b("receive notification handle by cpra");
                                                break;
                                            }
                                        }
                                        break;
                                    } catch (ix e2) {
                                        com.xiaomi.channel.commonutils.logger.b.a(e2);
                                        break;
                                    }
                                }
                                break;
                            } catch (ix unused) {
                                break;
                            }
                        }
                    }
                    break;
            }
            return null;
        } catch (u e3) {
            com.xiaomi.channel.commonutils.logger.b.a(e3);
            a(idVar);
            a2 = en.a(this.f55a);
            packageName = this.f55a.getPackageName();
            m371a = em.m371a(i);
            str2 = "19";
            a2.b(packageName, m371a, str, str2);
            s.c(this.f55a, idVar, z);
            return null;
        } catch (ix e4) {
            com.xiaomi.channel.commonutils.logger.b.a(e4);
            com.xiaomi.channel.commonutils.logger.b.d("receive a message which action string is not valid. is the reg expired?");
            a2 = en.a(this.f55a);
            packageName = this.f55a.getPackageName();
            m371a = em.m371a(i);
            str2 = PayUVEventType.PAY_WALLET_BANNER_SHOW;
            a2.b(packageName, m371a, str, str2);
            s.c(this.f55a, idVar, z);
            return null;
        }
    }

    private PushMessageHandler.a a(id idVar, byte[] bArr) {
        String str;
        is a2;
        String str2 = null;
        try {
            a2 = ai.a(this.f55a, idVar);
        } catch (u e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            str = "message arrived: receive a message but decrypt failed. report when click.";
        } catch (ix e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
            str = "message arrived: receive a message which action string is not valid. is the reg expired?";
        }
        if (a2 == null) {
            com.xiaomi.channel.commonutils.logger.b.d("message arrived: receiving an un-recognized message. " + idVar.f631a);
            return null;
        }
        hh a3 = idVar.a();
        com.xiaomi.channel.commonutils.logger.b.m99a("message arrived: processing an arrived message, action=" + a3);
        if (an.a[a3.ordinal()] != 1) {
            return null;
        }
        if (idVar.m551b()) {
            ik ikVar = (ik) a2;
            ht a4 = ikVar.a();
            if (a4 != null) {
                hu huVar = idVar.f632a;
                if (huVar != null && huVar.m504a() != null) {
                    str2 = idVar.f632a.f543a.get("jobkey");
                }
                MiPushMessage generateMessage = PushMessageHelper.generateMessage(ikVar, idVar.m543a(), false);
                generateMessage.setArrivedMessage(true);
                com.xiaomi.channel.commonutils.logger.b.m99a("message arrived: receive a message, msgid=" + a4.m495a() + ", jobkey=" + str2);
                return generateMessage;
            }
            str = "message arrived: receive an empty message without push content, drop it";
        } else {
            str = "message arrived: receiving an un-encrypt message(SendMessage).";
        }
        com.xiaomi.channel.commonutils.logger.b.d(str);
        return null;
    }

    public static am a(Context context) {
        if (a == null) {
            a = new am(context);
        }
        return a;
    }

    private void a() {
        SharedPreferences sharedPreferences = this.f55a.getSharedPreferences("mipush_extra", 0);
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - sharedPreferences.getLong(Constants.SP_KEY_LAST_REINITIALIZE, 0L)) > 1800000) {
            MiPushClient.reInitialize(this.f55a, hv.PackageUnregistered);
            sharedPreferences.edit().putLong(Constants.SP_KEY_LAST_REINITIALIZE, currentTimeMillis).commit();
        }
    }

    public static void a(Context context, String str) {
        synchronized (f53a) {
            f54a.remove(str);
            b.m143a(context);
            SharedPreferences a2 = b.a(context);
            String a3 = bo.a(f54a, ",");
            SharedPreferences.Editor edit = a2.edit();
            edit.putString("pref_msg_ids", a3);
            com.xiaomi.push.q.a(edit);
        }
    }

    private void a(hy hyVar) {
        String a2 = hyVar.a();
        com.xiaomi.channel.commonutils.logger.b.b("receive ack " + a2);
        Map<String, String> m518a = hyVar.m518a();
        if (m518a != null) {
            String str = m518a.get("real_source");
            if (TextUtils.isEmpty(str)) {
                return;
            }
            com.xiaomi.channel.commonutils.logger.b.b("receive ack : messageId = " + a2 + "  realSource = " + str);
            bw.a(this.f55a).a(a2, str, Boolean.valueOf(hyVar.f586a == 0));
        }
    }

    private void a(id idVar) {
        com.xiaomi.channel.commonutils.logger.b.m99a("receive a message but decrypt failed. report now.");
        ig igVar = new ig(idVar.m543a().f541a, false);
        igVar.c(hr.DecryptMessageFail.f508a);
        igVar.b(idVar.m544a());
        igVar.d(idVar.f638b);
        HashMap hashMap = new HashMap();
        igVar.f650a = hashMap;
        hashMap.put("regid", MiPushClient.getRegId(this.f55a));
        ao.a(this.f55a).a((ao) igVar, hh.Notification, false, (hu) null);
    }

    private void a(ig igVar) {
        hy hyVar = new hy();
        hyVar.c(hr.CancelPushMessageACK.f508a);
        hyVar.a(igVar.m558a());
        hyVar.a(igVar.a());
        hyVar.b(igVar.b());
        hyVar.e(igVar.c());
        hyVar.a(0L);
        hyVar.d("success clear push message.");
        ao.a(this.f55a).a(hyVar, hh.Notification, false, true, null, false, this.f55a.getPackageName(), b.m143a(this.f55a).m144a(), false);
    }

    private void a(ik ikVar, id idVar) {
        hu m543a = idVar.m543a();
        if (m543a != null) {
            m543a = br.a(m543a.m502a());
        }
        hx hxVar = new hx();
        hxVar.b(ikVar.b());
        hxVar.a(ikVar.m581a());
        hxVar.a(ikVar.a().a());
        if (!TextUtils.isEmpty(ikVar.c())) {
            hxVar.c(ikVar.c());
        }
        if (!TextUtils.isEmpty(ikVar.d())) {
            hxVar.d(ikVar.d());
        }
        hxVar.a(ir.a(this.f55a, idVar));
        ao.a(this.f55a).a((ao) hxVar, hh.AckMessage, m543a);
    }

    private void a(String str, long j, e eVar) {
        au a2 = l.a(eVar);
        if (a2 == null) {
            return;
        }
        if (j == 0) {
            synchronized (af.class) {
                if (af.a(this.f55a).m121a(str)) {
                    af.a(this.f55a).c(str);
                    if ("syncing".equals(af.a(this.f55a).a(a2))) {
                        af.a(this.f55a).a(a2, "synced");
                    }
                }
            }
        } else if (!"syncing".equals(af.a(this.f55a).a(a2))) {
            af.a(this.f55a).c(str);
        } else {
            synchronized (af.class) {
                if (af.a(this.f55a).m121a(str)) {
                    if (af.a(this.f55a).a(str) < 10) {
                        af.a(this.f55a).b(str);
                        ao.a(this.f55a).a(str, a2, eVar, HttpRetryStrategyDataParse.DOWNFLOW_RETRY_REQUEST_PARAM);
                    } else {
                        af.a(this.f55a).c(str);
                    }
                }
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m122a(Context context, String str) {
        synchronized (f53a) {
            b.m143a(context);
            SharedPreferences a2 = b.a(context);
            if (f54a == null) {
                String[] split = a2.getString("pref_msg_ids", "").split(",");
                f54a = new LinkedList();
                for (String str2 : split) {
                    f54a.add(str2);
                }
            }
            if (f54a.contains(str)) {
                return true;
            }
            f54a.add(str);
            if (f54a.size() > 25) {
                f54a.poll();
            }
            String a3 = bo.a(f54a, ",");
            SharedPreferences.Editor edit = a2.edit();
            edit.putString("pref_msg_ids", a3);
            com.xiaomi.push.q.a(edit);
            return false;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    private boolean m123a(id idVar) {
        Map<String, String> m504a = idVar.m543a() == null ? null : idVar.m543a().m504a();
        if (m504a == null) {
            return false;
        }
        String str = m504a.get(Constants.EXTRA_KEY_PUSH_SERVER_ACTION);
        return TextUtils.equals(str, Constants.EXTRA_VALUE_HYBRID_MESSAGE) || TextUtils.equals(str, Constants.EXTRA_VALUE_PLATFORM_MESSAGE);
    }

    private void b(hy hyVar) {
        long j;
        e eVar;
        com.xiaomi.channel.commonutils.logger.b.c("ASSEMBLE_PUSH : " + hyVar.toString());
        String a2 = hyVar.a();
        Map<String, String> m518a = hyVar.m518a();
        if (m518a != null) {
            String str = m518a.get(Constants.ASSEMBLE_PUSH_REG_INFO);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (str.contains("brand:" + ag.FCM.name())) {
                com.xiaomi.channel.commonutils.logger.b.m99a("ASSEMBLE_PUSH : receive fcm token sync ack");
                i.b(this.f55a, e.ASSEMBLE_PUSH_FCM, str);
                j = hyVar.f586a;
                eVar = e.ASSEMBLE_PUSH_FCM;
            } else {
                if (!str.contains("brand:" + ag.HUAWEI.name())) {
                    if (!str.contains("channel:" + ag.HUAWEI.name())) {
                        if (!str.contains("brand:" + ag.OPPO.name())) {
                            if (!str.contains("channel:" + ag.OPPO.name())) {
                                if (!str.contains("brand:" + ag.VIVO.name())) {
                                    if (!str.contains("channel:" + ag.VIVO.name())) {
                                        return;
                                    }
                                }
                                com.xiaomi.channel.commonutils.logger.b.m99a("ASSEMBLE_PUSH : receive FTOS token sync ack");
                                i.b(this.f55a, e.ASSEMBLE_PUSH_FTOS, str);
                                j = hyVar.f586a;
                                eVar = e.ASSEMBLE_PUSH_FTOS;
                            }
                        }
                        com.xiaomi.channel.commonutils.logger.b.m99a("ASSEMBLE_PUSH : receive COS token sync ack");
                        i.b(this.f55a, e.ASSEMBLE_PUSH_COS, str);
                        j = hyVar.f586a;
                        eVar = e.ASSEMBLE_PUSH_COS;
                    }
                }
                com.xiaomi.channel.commonutils.logger.b.m99a("ASSEMBLE_PUSH : receive hw token sync ack");
                i.b(this.f55a, e.ASSEMBLE_PUSH_HUAWEI, str);
                j = hyVar.f586a;
                eVar = e.ASSEMBLE_PUSH_HUAWEI;
            }
            a(a2, j, eVar);
        }
    }

    private void b(id idVar) {
        hu m543a = idVar.m543a();
        if (m543a != null) {
            m543a = br.a(m543a.m502a());
        }
        hx hxVar = new hx();
        hxVar.b(idVar.m544a());
        hxVar.a(m543a.m503a());
        hxVar.a(m543a.m501a());
        if (!TextUtils.isEmpty(m543a.m508b())) {
            hxVar.c(m543a.m508b());
        }
        hxVar.a(ir.a(this.f55a, idVar));
        ao.a(this.f55a).a((ao) hxVar, hh.AckMessage, false, m543a);
    }

    private void b(ig igVar) {
        String str;
        Map<String, String> m559a = igVar.m559a();
        if (m559a == null) {
            str = "detect failed because null";
        } else {
            String str2 = (String) ay.a(m559a, "pkgList", (Object) null);
            if (!TextUtils.isEmpty(str2)) {
                Map<String, String> m435a = com.xiaomi.push.g.m435a(this.f55a, str2);
                if (m435a == null) {
                    com.xiaomi.channel.commonutils.logger.b.m99a("detect failed because get status illegal");
                    return;
                }
                String str3 = m435a.get("alive");
                String str4 = m435a.get("notAlive");
                if (TextUtils.isEmpty(str3)) {
                    com.xiaomi.channel.commonutils.logger.b.b("detect failed because no alive process");
                    return;
                }
                ig igVar2 = new ig();
                igVar2.a(igVar.m558a());
                igVar2.b(igVar.b());
                igVar2.d(igVar.c());
                igVar2.c(hr.DetectAppAliveResult.f508a);
                HashMap hashMap = new HashMap();
                igVar2.f650a = hashMap;
                hashMap.put("alive", str3);
                if (Boolean.parseBoolean((String) ay.a(m559a, "reportNotAliveApp", "false")) && !TextUtils.isEmpty(str4)) {
                    igVar2.f650a.put("notAlive", str4);
                }
                ao.a(this.f55a).a((ao) igVar2, hh.Notification, false, (hu) null);
                return;
            }
            str = "detect failed because empty";
        }
        com.xiaomi.channel.commonutils.logger.b.m99a(str);
    }

    public PushMessageHandler.a a(Intent intent) {
        String str;
        en a2;
        String packageName;
        String str2;
        en a3;
        String packageName2;
        String format;
        String action = intent.getAction();
        com.xiaomi.channel.commonutils.logger.b.m99a("receive an intent from server, action=" + action);
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
                en.a(this.f55a).a(this.f55a.getPackageName(), intent, "12");
                return null;
            }
            id idVar = new id();
            try {
                ir.a(idVar, byteArrayExtra);
                b m143a = b.m143a(this.f55a);
                hu m543a = idVar.m543a();
                if (idVar.a() == hh.SendMessage && m543a != null && !m143a.m154e() && !booleanExtra) {
                    m543a.a("mrt", stringExtra);
                    m543a.a("mat", Long.toString(System.currentTimeMillis()));
                    if (m123a(idVar)) {
                        com.xiaomi.channel.commonutils.logger.b.b("this is a mina's message, ack later");
                        m543a.a(Constants.EXTRA_KEY_HYBRID_MESSAGE_TS, String.valueOf(m543a.m501a()));
                        m543a.a(Constants.EXTRA_KEY_HYBRID_DEVICE_STATUS, String.valueOf((int) ir.a(this.f55a, idVar)));
                    } else {
                        b(idVar);
                    }
                }
                if (idVar.a() == hh.SendMessage && !idVar.m551b()) {
                    if (com.xiaomi.push.service.ak.m684a(idVar)) {
                        Object[] objArr = new Object[2];
                        objArr[0] = idVar.b();
                        objArr[1] = m543a != null ? m543a.m503a() : "";
                        com.xiaomi.channel.commonutils.logger.b.m99a(String.format("drop an un-encrypted wake-up messages. %1$s, %2$s", objArr));
                        a3 = en.a(this.f55a);
                        packageName2 = this.f55a.getPackageName();
                        format = String.format("13: %1$s", idVar.b());
                    } else {
                        Object[] objArr2 = new Object[2];
                        objArr2[0] = idVar.b();
                        objArr2[1] = m543a != null ? m543a.m503a() : "";
                        com.xiaomi.channel.commonutils.logger.b.m99a(String.format("drop an un-encrypted messages. %1$s, %2$s", objArr2));
                        a3 = en.a(this.f55a);
                        packageName2 = this.f55a.getPackageName();
                        format = String.format("14: %1$s", idVar.b());
                    }
                    a3.a(packageName2, intent, format);
                    s.a(this.f55a, idVar, booleanExtra);
                    return null;
                }
                if (idVar.a() == hh.SendMessage && idVar.m551b() && com.xiaomi.push.service.ak.m684a(idVar) && (!booleanExtra || m543a == null || m543a.m504a() == null || !m543a.m504a().containsKey("notify_effect"))) {
                    Object[] objArr3 = new Object[2];
                    objArr3[0] = idVar.b();
                    objArr3[1] = m543a != null ? m543a.m503a() : "";
                    com.xiaomi.channel.commonutils.logger.b.m99a(String.format("drop a wake-up messages which not has 'notify_effect' attr. %1$s, %2$s", objArr3));
                    en.a(this.f55a).a(this.f55a.getPackageName(), intent, String.format("25: %1$s", idVar.b()));
                    s.b(this.f55a, idVar, booleanExtra);
                    return null;
                }
                if (m143a.m152c() || idVar.f631a == hh.Registration) {
                    if (!m143a.m152c() || !m143a.m155f()) {
                        return a(idVar, booleanExtra, byteArrayExtra, stringExtra2, intExtra, intent);
                    }
                    if (idVar.f631a != hh.UnRegistration) {
                        s.e(this.f55a, idVar, booleanExtra);
                        MiPushClient.unregisterPush(this.f55a);
                    } else if (idVar.m551b()) {
                        m143a.m145a();
                        MiPushClient.clearExtras(this.f55a);
                        PushMessageHandler.a();
                    } else {
                        com.xiaomi.channel.commonutils.logger.b.d("receiving an un-encrypt unregistration message");
                    }
                } else if (com.xiaomi.push.service.ak.m684a(idVar)) {
                    return a(idVar, booleanExtra, byteArrayExtra, stringExtra2, intExtra, intent);
                } else {
                    s.e(this.f55a, idVar, booleanExtra);
                    boolean m153d = m143a.m153d();
                    com.xiaomi.channel.commonutils.logger.b.d("receive message without registration. need re-register!registered?" + m153d);
                    en.a(this.f55a).a(this.f55a.getPackageName(), intent, "15");
                    if (m153d) {
                        a();
                    }
                }
            } catch (ix e) {
                e = e;
                a2 = en.a(this.f55a);
                packageName = this.f55a.getPackageName();
                str2 = "16";
                a2.a(packageName, intent, str2);
                com.xiaomi.channel.commonutils.logger.b.a(e);
                return null;
            } catch (Exception e2) {
                e = e2;
                a2 = en.a(this.f55a);
                packageName = this.f55a.getPackageName();
                str2 = "17";
                a2.a(packageName, intent, str2);
                com.xiaomi.channel.commonutils.logger.b.a(e);
                return null;
            }
        } else if ("com.xiaomi.mipush.ERROR".equals(action)) {
            MiPushCommandMessage miPushCommandMessage = new MiPushCommandMessage();
            id idVar2 = new id();
            try {
                byte[] byteArrayExtra2 = intent.getByteArrayExtra("mipush_payload");
                if (byteArrayExtra2 != null) {
                    ir.a(idVar2, byteArrayExtra2);
                }
            } catch (ix unused) {
            }
            miPushCommandMessage.setCommand(String.valueOf(idVar2.a()));
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
            id idVar3 = new id();
            try {
                ir.a(idVar3, byteArrayExtra3);
                b m143a2 = b.m143a(this.f55a);
                if (com.xiaomi.push.service.ak.m684a(idVar3)) {
                    str = "message arrived: receive ignore reg message, ignore!";
                } else if (!m143a2.m152c()) {
                    str = "message arrived: receive message without registration. need unregister or re-register!";
                } else if (!m143a2.m152c() || !m143a2.m155f()) {
                    return a(idVar3, byteArrayExtra3);
                } else {
                    str = "message arrived: app info is invalidated";
                }
                com.xiaomi.channel.commonutils.logger.b.d(str);
            } catch (Exception e3) {
                com.xiaomi.channel.commonutils.logger.b.d("fail to deal with arrived message. " + e3);
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
