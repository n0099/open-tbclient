package com.xiaomi.mipush.sdk;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.searchbox.player.widget.BdPlayerProgressView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.mipush.sdk.PushMessageHandler;
import com.xiaomi.push.Cif;
import com.xiaomi.push.bp;
import com.xiaomi.push.bx;
import com.xiaomi.push.db;
import com.xiaomi.push.en;
import com.xiaomi.push.eo;
import com.xiaomi.push.ey;
import com.xiaomi.push.hj;
import com.xiaomi.push.ho;
import com.xiaomi.push.ht;
import com.xiaomi.push.hv;
import com.xiaomi.push.hw;
import com.xiaomi.push.hx;
import com.xiaomi.push.hz;
import com.xiaomi.push.ia;
import com.xiaomi.push.ie;
import com.xiaomi.push.ig;
import com.xiaomi.push.ih;
import com.xiaomi.push.ii;
import com.xiaomi.push.ik;
import com.xiaomi.push.im;
import com.xiaomi.push.io;
import com.xiaomi.push.iq;
import com.xiaomi.push.is;
import com.xiaomi.push.it;
import com.xiaomi.push.iu;
import com.xiaomi.push.iz;
import com.xiaomi.push.service.ay;
import com.xiaomi.push.service.ba;
import com.xiaomi.push.service.bb;
import com.xiaomi.push.service.bk;
import com.xiaomi.push.service.br;
import com.xiaomi.push.w;
import com.yy.hiidostatis.inner.FlushManager;
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
    public static /* synthetic */ Interceptable $ic;
    public static am a;

    /* renamed from: a  reason: collision with other field name */
    public static Object f76a;

    /* renamed from: a  reason: collision with other field name */
    public static Queue<String> f77a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public Context f78a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1871206693, "Lcom/xiaomi/mipush/sdk/am;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1871206693, "Lcom/xiaomi/mipush/sdk/am;");
                return;
            }
        }
        f76a = new Object();
    }

    public am(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Context applicationContext = context.getApplicationContext();
        this.f78a = applicationContext;
        if (applicationContext == null) {
            this.f78a = context;
        }
    }

    public static Intent a(Context context, String str, Map<String, String> map, int i) {
        InterceptResult invokeLLLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(65538, null, context, str, map, i)) == null) ? com.xiaomi.push.service.al.b(context, str, map, i) : (Intent) invokeLLLI.objValue;
    }

    private PushMessageHandler.a a(Cif cif, boolean z, byte[] bArr, String str, int i, Intent intent) {
        InterceptResult invokeCommon;
        eo a2;
        String packageName;
        String m376a;
        String str2;
        String str3;
        String str4;
        MiPushMessage miPushMessage;
        eo a3;
        String packageName2;
        String m376a2;
        int i2;
        String str5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, this, new Object[]{cif, Boolean.valueOf(z), bArr, str, Integer.valueOf(i), intent})) == null) {
            ArrayList arrayList = null;
            try {
                iu a4 = ai.a(this.f78a, cif);
                if (a4 == null) {
                    com.xiaomi.channel.commonutils.logger.b.d("receiving an un-recognized message. " + cif.f649a);
                    eo.a(this.f78a).b(this.f78a.getPackageName(), en.m376a(i), str, "18");
                    s.c(this.f78a, cif, z);
                    return null;
                }
                hj a5 = cif.a();
                com.xiaomi.channel.commonutils.logger.b.m105a("processing a message, action=" + a5);
                switch (an.a[a5.ordinal()]) {
                    case 1:
                        if (!cif.m548b()) {
                            com.xiaomi.channel.commonutils.logger.b.d("receiving an un-encrypt message(SendMessage).");
                            return null;
                        } else if (b.m147a(this.f78a).m158e() && !z) {
                            com.xiaomi.channel.commonutils.logger.b.m105a("receive a message in pause state. drop it");
                            eo.a(this.f78a).a(this.f78a.getPackageName(), en.m376a(i), str, "12");
                            return null;
                        } else {
                            im imVar = (im) a4;
                            hv a6 = imVar.a();
                            if (a6 == null) {
                                com.xiaomi.channel.commonutils.logger.b.d("receive an empty message without push content, drop it");
                                eo.a(this.f78a).b(this.f78a.getPackageName(), en.m376a(i), str, "22");
                                s.d(this.f78a, cif, z);
                                return null;
                            }
                            int intExtra = intent.getIntExtra("notification_click_button", 0);
                            if (z) {
                                if (com.xiaomi.push.service.al.m685a(cif)) {
                                    MiPushClient.reportIgnoreRegMessageClicked(this.f78a, a6.m498a(), cif.m540a(), cif.f656b, a6.b());
                                } else {
                                    hw hwVar = cif.m540a() != null ? new hw(cif.m540a()) : new hw();
                                    if (hwVar.m507a() == null) {
                                        hwVar.a(new HashMap());
                                    }
                                    hwVar.m507a().put("notification_click_button", String.valueOf(intExtra));
                                    MiPushClient.reportMessageClicked(this.f78a, a6.m498a(), hwVar, a6.b());
                                }
                            }
                            if (!z) {
                                if (!TextUtils.isEmpty(imVar.d()) && MiPushClient.aliasSetTime(this.f78a, imVar.d()) < 0) {
                                    MiPushClient.addAlias(this.f78a, imVar.d());
                                } else if (!TextUtils.isEmpty(imVar.c()) && MiPushClient.topicSubscribedTime(this.f78a, imVar.c()) < 0) {
                                    MiPushClient.addTopic(this.f78a, imVar.c());
                                }
                            }
                            hw hwVar2 = cif.f650a;
                            if (hwVar2 == null || hwVar2.m507a() == null) {
                                str3 = null;
                                str4 = null;
                            } else {
                                str3 = cif.f650a.f564a.get("jobkey");
                                str4 = str3;
                            }
                            if (TextUtils.isEmpty(str3)) {
                                str3 = a6.m498a();
                            }
                            if (z || !m128a(this.f78a, str3)) {
                                MiPushMessage generateMessage = PushMessageHelper.generateMessage(imVar, cif.m540a(), z);
                                if (generateMessage.getPassThrough() == 0 && !z && com.xiaomi.push.service.al.m686a(generateMessage.getExtra())) {
                                    com.xiaomi.push.service.al.m681a(this.f78a, cif, bArr);
                                    return null;
                                }
                                com.xiaomi.channel.commonutils.logger.b.m105a("receive a message, msgid=" + a6.m498a() + ", jobkey=" + str3 + ", btn=" + intExtra);
                                String a7 = com.xiaomi.push.service.al.a(generateMessage.getExtra(), intExtra);
                                if (z && generateMessage.getExtra() != null && !TextUtils.isEmpty(a7)) {
                                    Map<String, String> extra = generateMessage.getExtra();
                                    if (intExtra != 0 && cif.m540a() != null) {
                                        ao.a(this.f78a).a(cif.m540a().c(), intExtra);
                                    }
                                    if (com.xiaomi.push.service.al.m685a(cif)) {
                                        Intent a8 = a(this.f78a, cif.f656b, extra, intExtra);
                                        a8.putExtra("eventMessageType", i);
                                        a8.putExtra(MiPushMessage.KEY_MESSAGE_ID, str);
                                        a8.putExtra("jobkey", str4);
                                        if (a8 == null) {
                                            com.xiaomi.channel.commonutils.logger.b.m105a("Getting Intent fail from ignore reg message. ");
                                            eo.a(this.f78a).b(this.f78a.getPackageName(), en.m376a(i), str, "23");
                                            return null;
                                        }
                                        String c = a6.c();
                                        if (!TextUtils.isEmpty(c)) {
                                            a8.putExtra("payload", c);
                                        }
                                        this.f78a.startActivity(a8);
                                        s.a(this.f78a, cif);
                                        eo.a(this.f78a).a(this.f78a.getPackageName(), en.m376a(i), str, 3006, a7);
                                        return null;
                                    }
                                    Context context = this.f78a;
                                    Intent a9 = a(context, context.getPackageName(), extra, intExtra);
                                    if (a9 != null) {
                                        if (!a7.equals(bk.c)) {
                                            a9.putExtra(PushMessageHelper.KEY_MESSAGE, generateMessage);
                                            a9.putExtra("eventMessageType", i);
                                            a9.putExtra(MiPushMessage.KEY_MESSAGE_ID, str);
                                            a9.putExtra("jobkey", str4);
                                        }
                                        this.f78a.startActivity(a9);
                                        s.a(this.f78a, cif);
                                        com.xiaomi.channel.commonutils.logger.b.m105a("start activity succ");
                                        eo.a(this.f78a).a(this.f78a.getPackageName(), en.m376a(i), str, 1006, a7);
                                        if (a7.equals(bk.c)) {
                                            eo.a(this.f78a).a(this.f78a.getPackageName(), en.m376a(i), str, "13");
                                            return null;
                                        }
                                        return null;
                                    }
                                    return null;
                                }
                                miPushMessage = generateMessage;
                            } else {
                                com.xiaomi.channel.commonutils.logger.b.m105a("drop a duplicate message, key=" + str3);
                                eo a10 = eo.a(this.f78a);
                                String packageName3 = this.f78a.getPackageName();
                                String m376a3 = en.m376a(i);
                                a10.c(packageName3, m376a3, str, "2:" + str3);
                                miPushMessage = null;
                            }
                            if (cif.m540a() == null && !z) {
                                a(imVar, cif);
                            }
                            return miPushMessage;
                        }
                    case 2:
                        ik ikVar = (ik) a4;
                        String str6 = b.m147a(this.f78a).f94a;
                        if (TextUtils.isEmpty(str6) || !TextUtils.equals(str6, ikVar.m569a())) {
                            com.xiaomi.channel.commonutils.logger.b.m105a("bad Registration result:");
                            eo.a(this.f78a).b(this.f78a.getPackageName(), en.m376a(i), str, "21");
                            return null;
                        }
                        b.m147a(this.f78a).f94a = null;
                        int i3 = (ikVar.f712a > 0L ? 1 : (ikVar.f712a == 0L ? 0 : -1));
                        Context context2 = this.f78a;
                        if (i3 == 0) {
                            b.m147a(context2).b(ikVar.f724e, ikVar.f725f, ikVar.f731l);
                            FCMPushHelper.persistIfXmsfSupDecrypt(this.f78a);
                            a3 = eo.a(this.f78a);
                            packageName2 = this.f78a.getPackageName();
                            m376a2 = en.m376a(i);
                            i2 = 6006;
                            str5 = "1";
                        } else {
                            a3 = eo.a(context2);
                            packageName2 = this.f78a.getPackageName();
                            m376a2 = en.m376a(i);
                            i2 = 6006;
                            str5 = "2";
                        }
                        a3.a(packageName2, m376a2, str, i2, str5);
                        if (!TextUtils.isEmpty(ikVar.f724e)) {
                            arrayList = new ArrayList();
                            arrayList.add(ikVar.f724e);
                        }
                        MiPushCommandMessage generateCommandMessage = PushMessageHelper.generateCommandMessage(ey.a.f357a, arrayList, ikVar.f712a, ikVar.f723d, null, ikVar.m570a());
                        ao.a(this.f78a).m145d();
                        return generateCommandMessage;
                    case 3:
                        if (!cif.m548b()) {
                            com.xiaomi.channel.commonutils.logger.b.d("receiving an un-encrypt message(UnRegistration).");
                            return null;
                        }
                        if (((iq) a4).f790a == 0) {
                            b.m147a(this.f78a).m149a();
                            MiPushClient.clearExtras(this.f78a);
                        }
                        PushMessageHandler.a();
                        break;
                    case 4:
                        io ioVar = (io) a4;
                        if (ioVar.f765a == 0) {
                            MiPushClient.addTopic(this.f78a, ioVar.b());
                        }
                        if (!TextUtils.isEmpty(ioVar.b())) {
                            arrayList = new ArrayList();
                            arrayList.add(ioVar.b());
                        }
                        com.xiaomi.channel.commonutils.logger.b.e("resp-cmd:" + ey.g + StringUtil.ARRAY_ELEMENT_SEPARATOR + ioVar.a());
                        return PushMessageHelper.generateCommandMessage(ey.g.f357a, arrayList, ioVar.f765a, ioVar.f771d, ioVar.c(), null);
                    case 5:
                        is isVar = (is) a4;
                        if (isVar.f810a == 0) {
                            MiPushClient.removeTopic(this.f78a, isVar.b());
                        }
                        if (!TextUtils.isEmpty(isVar.b())) {
                            arrayList = new ArrayList();
                            arrayList.add(isVar.b());
                        }
                        com.xiaomi.channel.commonutils.logger.b.e("resp-cmd:" + ey.h + StringUtil.ARRAY_ELEMENT_SEPARATOR + isVar.a());
                        return PushMessageHelper.generateCommandMessage(ey.h.f357a, arrayList, isVar.f810a, isVar.f816d, isVar.c(), null);
                    case 6:
                        db.a(this.f78a.getPackageName(), this.f78a, a4, hj.j, bArr.length);
                        ie ieVar = (ie) a4;
                        String b = ieVar.b();
                        List<String> m534a = ieVar.m534a();
                        if (ieVar.f637a == 0) {
                            if (TextUtils.equals(b, ey.i.f357a) && m534a != null && m534a.size() > 1) {
                                MiPushClient.addAcceptTime(this.f78a, m534a.get(0), m534a.get(1));
                                if (BdPlayerProgressView.DEFAULT_TIME_TEXT.equals(m534a.get(0)) && BdPlayerProgressView.DEFAULT_TIME_TEXT.equals(m534a.get(1))) {
                                    b.m147a(this.f78a).a(true);
                                } else {
                                    b.m147a(this.f78a).a(false);
                                }
                                m534a = a(TimeZone.getTimeZone("GMT+08"), TimeZone.getDefault(), m534a);
                            } else if (TextUtils.equals(b, ey.c.f357a) && m534a != null && m534a.size() > 0) {
                                MiPushClient.addAlias(this.f78a, m534a.get(0));
                            } else if (TextUtils.equals(b, ey.d.f357a) && m534a != null && m534a.size() > 0) {
                                MiPushClient.removeAlias(this.f78a, m534a.get(0));
                            } else if (TextUtils.equals(b, ey.e.f357a) && m534a != null && m534a.size() > 0) {
                                MiPushClient.addAccount(this.f78a, m534a.get(0));
                            } else if (TextUtils.equals(b, ey.f.f357a) && m534a != null && m534a.size() > 0) {
                                MiPushClient.removeAccount(this.f78a, m534a.get(0));
                            } else if (TextUtils.equals(b, ey.j.f357a)) {
                                return null;
                            }
                        }
                        List<String> list = m534a;
                        com.xiaomi.channel.commonutils.logger.b.e("resp-cmd:" + b + StringUtil.ARRAY_ELEMENT_SEPARATOR + ieVar.a());
                        return PushMessageHelper.generateCommandMessage(b, list, ieVar.f637a, ieVar.f645d, ieVar.c(), null);
                    case 7:
                        db.a(this.f78a.getPackageName(), this.f78a, a4, hj.i, bArr.length);
                        if (a4 instanceof ia) {
                            ia iaVar = (ia) a4;
                            String a11 = iaVar.a();
                            com.xiaomi.channel.commonutils.logger.b.e("resp-type:" + iaVar.b() + ", code:" + iaVar.f607a + StringUtil.ARRAY_ELEMENT_SEPARATOR + a11);
                            if (ht.E.f529a.equalsIgnoreCase(iaVar.f614d)) {
                                if (iaVar.f607a == 0) {
                                    synchronized (af.class) {
                                        if (af.a(this.f78a).m127a(a11)) {
                                            af.a(this.f78a).c(a11);
                                            if ("syncing".equals(af.a(this.f78a).a(au.a))) {
                                                af.a(this.f78a).a(au.a, "synced");
                                                MiPushClient.clearNotification(this.f78a);
                                                MiPushClient.clearLocalNotificationType(this.f78a);
                                                PushMessageHandler.a();
                                                ao.a(this.f78a).m142b();
                                            }
                                        }
                                    }
                                    break;
                                } else if ("syncing".equals(af.a(this.f78a).a(au.a))) {
                                    synchronized (af.class) {
                                        if (af.a(this.f78a).m127a(a11)) {
                                            if (af.a(this.f78a).a(a11) < 10) {
                                                af.a(this.f78a).b(a11);
                                                ao.a(this.f78a).a(true, a11);
                                            } else {
                                                af.a(this.f78a).c(a11);
                                            }
                                        }
                                    }
                                    break;
                                }
                            } else if (ht.F.f529a.equalsIgnoreCase(iaVar.f614d)) {
                                if (iaVar.f607a == 0) {
                                    synchronized (af.class) {
                                        if (af.a(this.f78a).m127a(a11)) {
                                            af.a(this.f78a).c(a11);
                                            if ("syncing".equals(af.a(this.f78a).a(au.b))) {
                                                af.a(this.f78a).a(au.b, "synced");
                                            }
                                        }
                                    }
                                    break;
                                } else if ("syncing".equals(af.a(this.f78a).a(au.b))) {
                                    synchronized (af.class) {
                                        if (af.a(this.f78a).m127a(a11)) {
                                            if (af.a(this.f78a).a(a11) < 10) {
                                                af.a(this.f78a).b(a11);
                                                ao.a(this.f78a).a(false, a11);
                                            } else {
                                                af.a(this.f78a).c(a11);
                                            }
                                        }
                                    }
                                    break;
                                }
                            } else if (ht.N.f529a.equalsIgnoreCase(iaVar.f614d)) {
                                b(iaVar);
                                break;
                            } else if (ht.B.f529a.equalsIgnoreCase(iaVar.f614d)) {
                                a(iaVar);
                                break;
                            }
                            af.a(this.f78a).c(a11);
                            break;
                        } else if (a4 instanceof ii) {
                            ii iiVar = (ii) a4;
                            if ("registration id expired".equalsIgnoreCase(iiVar.f673d)) {
                                List<String> allAlias = MiPushClient.getAllAlias(this.f78a);
                                List<String> allTopic = MiPushClient.getAllTopic(this.f78a);
                                List<String> allUserAccount = MiPushClient.getAllUserAccount(this.f78a);
                                String acceptTime = MiPushClient.getAcceptTime(this.f78a);
                                com.xiaomi.channel.commonutils.logger.b.e("resp-type:" + iiVar.f673d + StringUtil.ARRAY_ELEMENT_SEPARATOR + iiVar.m555a());
                                MiPushClient.reInitialize(this.f78a, hx.a);
                                for (String str7 : allAlias) {
                                    MiPushClient.removeAlias(this.f78a, str7);
                                    MiPushClient.setAlias(this.f78a, str7, null);
                                }
                                for (String str8 : allTopic) {
                                    MiPushClient.removeTopic(this.f78a, str8);
                                    MiPushClient.subscribe(this.f78a, str8, null);
                                }
                                for (String str9 : allUserAccount) {
                                    MiPushClient.removeAccount(this.f78a, str9);
                                    MiPushClient.setUserAccount(this.f78a, str9, null);
                                }
                                String[] split = acceptTime.split(",");
                                if (split.length == 2) {
                                    MiPushClient.removeAcceptTime(this.f78a);
                                    MiPushClient.addAcceptTime(this.f78a, split[0], split[1]);
                                    break;
                                }
                            } else if (ht.h.f529a.equalsIgnoreCase(iiVar.f673d)) {
                                if (iiVar.m556a() != null && iiVar.m556a().containsKey("app_version")) {
                                    b.m147a(this.f78a).m150a(iiVar.m556a().get("app_version"));
                                    break;
                                }
                            } else if (ht.m.f529a.equalsIgnoreCase(iiVar.f673d)) {
                                if (cif.m548b() && iiVar.m556a() != null && iiVar.m556a().containsKey("awake_info")) {
                                    Context context3 = this.f78a;
                                    o.a(context3, b.m147a(context3).m148a(), ba.a(this.f78a).a(ho.aF.a(), 0), iiVar.m556a().get("awake_info"));
                                    break;
                                }
                            } else {
                                try {
                                    if (ht.n.f529a.equalsIgnoreCase(iiVar.f673d)) {
                                        ih ihVar = new ih();
                                        it.a(ihVar, iiVar.m561a());
                                        bb.a(ba.a(this.f78a), ihVar);
                                    } else if (ht.o.f529a.equalsIgnoreCase(iiVar.f673d)) {
                                        ig igVar = new ig();
                                        it.a(igVar, iiVar.m561a());
                                        bb.a(ba.a(this.f78a), igVar);
                                    } else if (ht.w.f529a.equalsIgnoreCase(iiVar.f673d)) {
                                        av.a(this.f78a, iiVar);
                                        break;
                                    } else if (ht.x.f529a.equalsIgnoreCase(iiVar.f673d)) {
                                        com.xiaomi.channel.commonutils.logger.b.m105a("receive force sync notification");
                                        av.a(this.f78a, false);
                                        break;
                                    } else if (ht.C.f529a.equals(iiVar.f673d)) {
                                        com.xiaomi.channel.commonutils.logger.b.e("resp-type:" + iiVar.f673d + StringUtil.ARRAY_ELEMENT_SEPARATOR + iiVar.m555a());
                                        if (iiVar.m556a() != null) {
                                            int i4 = -2;
                                            if (iiVar.m556a().containsKey(bk.M)) {
                                                String str10 = iiVar.m556a().get(bk.M);
                                                if (!TextUtils.isEmpty(str10)) {
                                                    try {
                                                        i4 = Integer.parseInt(str10);
                                                    } catch (NumberFormatException e) {
                                                        e.printStackTrace();
                                                    }
                                                }
                                            }
                                            if (i4 >= -1) {
                                                MiPushClient.clearNotification(this.f78a, i4);
                                            } else {
                                                MiPushClient.clearNotification(this.f78a, iiVar.m556a().containsKey(bk.K) ? iiVar.m556a().get(bk.K) : "", iiVar.m556a().containsKey(bk.L) ? iiVar.m556a().get(bk.L) : "");
                                            }
                                        }
                                        a(iiVar);
                                        break;
                                    } else {
                                        try {
                                            if (ht.K.f529a.equals(iiVar.f673d)) {
                                                ik ikVar2 = new ik();
                                                it.a(ikVar2, iiVar.m561a());
                                                MiPushClient4Hybrid.onReceiveRegisterResult(this.f78a, ikVar2);
                                            } else if (ht.M.f529a.equals(iiVar.f673d)) {
                                                iq iqVar = new iq();
                                                it.a(iqVar, iiVar.m561a());
                                                MiPushClient4Hybrid.onReceiveUnregisterResult(this.f78a, iqVar);
                                            } else if (!ht.P.f529a.equals(iiVar.f673d)) {
                                                if (ht.af.f529a.equals(iiVar.f673d)) {
                                                    com.xiaomi.channel.commonutils.logger.b.b("receive detect msg");
                                                    b(iiVar);
                                                    break;
                                                } else if (com.xiaomi.push.service.i.a(iiVar)) {
                                                    com.xiaomi.channel.commonutils.logger.b.b("receive notification handle by cpra");
                                                    break;
                                                }
                                            }
                                            break;
                                        } catch (iz e2) {
                                            com.xiaomi.channel.commonutils.logger.b.a(e2);
                                            break;
                                        }
                                    }
                                    break;
                                } catch (iz unused) {
                                    break;
                                }
                            }
                        }
                        break;
                }
                return null;
            } catch (u e3) {
                com.xiaomi.channel.commonutils.logger.b.a(e3);
                a(cif);
                a2 = eo.a(this.f78a);
                packageName = this.f78a.getPackageName();
                m376a = en.m376a(i);
                str2 = "19";
                a2.b(packageName, m376a, str, str2);
                s.c(this.f78a, cif, z);
                return null;
            } catch (iz e4) {
                com.xiaomi.channel.commonutils.logger.b.a(e4);
                com.xiaomi.channel.commonutils.logger.b.d("receive a message which action string is not valid. is the reg expired?");
                a2 = eo.a(this.f78a);
                packageName = this.f78a.getPackageName();
                m376a = en.m376a(i);
                str2 = PayUVEventType.PAY_WALLET_BANNER_SHOW;
                a2.b(packageName, m376a, str, str2);
                s.c(this.f78a, cif, z);
                return null;
            }
        }
        return (PushMessageHandler.a) invokeCommon.objValue;
    }

    private PushMessageHandler.a a(Cif cif, byte[] bArr) {
        InterceptResult invokeLL;
        String str;
        iu a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, cif, bArr)) == null) {
            String str2 = null;
            try {
                a2 = ai.a(this.f78a, cif);
            } catch (u e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
                str = "message arrived: receive a message but decrypt failed. report when click.";
            } catch (iz e2) {
                com.xiaomi.channel.commonutils.logger.b.a(e2);
                str = "message arrived: receive a message which action string is not valid. is the reg expired?";
            }
            if (a2 == null) {
                com.xiaomi.channel.commonutils.logger.b.d("message arrived: receiving an un-recognized message. " + cif.f649a);
                return null;
            }
            hj a3 = cif.a();
            com.xiaomi.channel.commonutils.logger.b.m105a("message arrived: processing an arrived message, action=" + a3);
            if (an.a[a3.ordinal()] != 1) {
                return null;
            }
            if (cif.m548b()) {
                im imVar = (im) a2;
                hv a4 = imVar.a();
                if (a4 != null) {
                    hw hwVar = cif.f650a;
                    if (hwVar != null && hwVar.m507a() != null) {
                        str2 = cif.f650a.f564a.get("jobkey");
                    }
                    MiPushMessage generateMessage = PushMessageHelper.generateMessage(imVar, cif.m540a(), false);
                    generateMessage.setArrivedMessage(true);
                    com.xiaomi.channel.commonutils.logger.b.m105a("message arrived: receive a message, msgid=" + a4.m498a() + ", jobkey=" + str2);
                    return generateMessage;
                }
                str = "message arrived: receive an empty message without push content, drop it";
            } else {
                str = "message arrived: receiving an un-encrypt message(SendMessage).";
            }
            com.xiaomi.channel.commonutils.logger.b.d(str);
            return null;
        }
        return (PushMessageHandler.a) invokeLL.objValue;
    }

    public static am a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            if (a == null) {
                a = new am(context);
            }
            return a;
        }
        return (am) invokeL.objValue;
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            SharedPreferences sharedPreferences = this.f78a.getSharedPreferences("mipush_extra", 0);
            long currentTimeMillis = System.currentTimeMillis();
            if (Math.abs(currentTimeMillis - sharedPreferences.getLong(Constants.SP_KEY_LAST_REINITIALIZE, 0L)) > FlushManager.ReportTimer.DEFAULT_INTERVAL) {
                MiPushClient.reInitialize(this.f78a, hx.b);
                sharedPreferences.edit().putLong(Constants.SP_KEY_LAST_REINITIALIZE, currentTimeMillis).commit();
            }
        }
    }

    public static void a(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, context, str) == null) {
            synchronized (f76a) {
                f77a.remove(str);
                b.m147a(context);
                SharedPreferences a2 = b.a(context);
                String a3 = bp.a(f77a, ",");
                SharedPreferences.Editor edit = a2.edit();
                edit.putString("pref_msg_ids", a3);
                com.xiaomi.push.t.a(edit);
            }
        }
    }

    private void a(ia iaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, this, iaVar) == null) {
            String a2 = iaVar.a();
            com.xiaomi.channel.commonutils.logger.b.b("receive ack " + a2);
            Map<String, String> m521a = iaVar.m521a();
            if (m521a != null) {
                String str = m521a.get("real_source");
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                com.xiaomi.channel.commonutils.logger.b.b("receive ack : messageId = " + a2 + "  realSource = " + str);
                bx.a(this.f78a).a(a2, str, Boolean.valueOf(iaVar.f607a == 0));
            }
        }
    }

    private void a(Cif cif) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, this, cif) == null) {
            com.xiaomi.channel.commonutils.logger.b.m105a("receive a message but decrypt failed. report now.");
            ii iiVar = new ii(cif.m540a().f562a, false);
            iiVar.c(ht.u.f529a);
            iiVar.b(cif.m541a());
            iiVar.d(cif.f656b);
            HashMap hashMap = new HashMap();
            iiVar.f668a = hashMap;
            hashMap.put("regid", MiPushClient.getRegId(this.f78a));
            ao.a(this.f78a).a((ao) iiVar, hj.i, false, (hw) null);
        }
    }

    private void a(ii iiVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, this, iiVar) == null) {
            ia iaVar = new ia();
            iaVar.c(ht.D.f529a);
            iaVar.a(iiVar.m555a());
            iaVar.a(iiVar.a());
            iaVar.b(iiVar.b());
            iaVar.e(iiVar.c());
            iaVar.a(0L);
            iaVar.d("success clear push message.");
            ao.a(this.f78a).a(iaVar, hj.i, false, true, null, false, this.f78a.getPackageName(), b.m147a(this.f78a).m148a(), false);
        }
    }

    private void a(im imVar, Cif cif) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65547, this, imVar, cif) == null) {
            hw m540a = cif.m540a();
            if (m540a != null) {
                m540a = br.a(m540a.m505a());
            }
            hz hzVar = new hz();
            hzVar.b(imVar.b());
            hzVar.a(imVar.m578a());
            hzVar.a(imVar.a().a());
            if (!TextUtils.isEmpty(imVar.c())) {
                hzVar.c(imVar.c());
            }
            if (!TextUtils.isEmpty(imVar.d())) {
                hzVar.d(imVar.d());
            }
            hzVar.a(it.a(this.f78a, cif));
            ao.a(this.f78a).a((ao) hzVar, hj.f, m540a);
        }
    }

    private void a(String str, long j, e eVar) {
        au a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65548, this, new Object[]{str, Long.valueOf(j), eVar}) == null) || (a2 = l.a(eVar)) == null) {
            return;
        }
        if (j == 0) {
            synchronized (af.class) {
                if (af.a(this.f78a).m127a(str)) {
                    af.a(this.f78a).c(str);
                    if ("syncing".equals(af.a(this.f78a).a(a2))) {
                        af.a(this.f78a).a(a2, "synced");
                    }
                }
            }
        } else if (!"syncing".equals(af.a(this.f78a).a(a2))) {
            af.a(this.f78a).c(str);
        } else {
            synchronized (af.class) {
                if (af.a(this.f78a).m127a(str)) {
                    if (af.a(this.f78a).a(str) < 10) {
                        af.a(this.f78a).b(str);
                        ao.a(this.f78a).a(str, a2, eVar);
                    } else {
                        af.a(this.f78a).c(str);
                    }
                }
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m128a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65549, null, context, str)) == null) {
            synchronized (f76a) {
                b.m147a(context);
                SharedPreferences a2 = b.a(context);
                if (f77a == null) {
                    String[] split = a2.getString("pref_msg_ids", "").split(",");
                    f77a = new LinkedList();
                    for (String str2 : split) {
                        f77a.add(str2);
                    }
                }
                if (f77a.contains(str)) {
                    return true;
                }
                f77a.add(str);
                if (f77a.size() > 25) {
                    f77a.poll();
                }
                String a3 = bp.a(f77a, ",");
                SharedPreferences.Editor edit = a2.edit();
                edit.putString("pref_msg_ids", a3);
                com.xiaomi.push.t.a(edit);
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    private boolean m129a(Cif cif) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, this, cif)) == null) {
            Map<String, String> m507a = cif.m540a() == null ? null : cif.m540a().m507a();
            if (m507a == null) {
                return false;
            }
            String str = m507a.get(Constants.EXTRA_KEY_PUSH_SERVER_ACTION);
            return TextUtils.equals(str, Constants.EXTRA_VALUE_HYBRID_MESSAGE) || TextUtils.equals(str, Constants.EXTRA_VALUE_PLATFORM_MESSAGE);
        }
        return invokeL.booleanValue;
    }

    private void b(ia iaVar) {
        long j;
        e eVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, this, iaVar) == null) {
            com.xiaomi.channel.commonutils.logger.b.c("ASSEMBLE_PUSH : " + iaVar.toString());
            String a2 = iaVar.a();
            Map<String, String> m521a = iaVar.m521a();
            if (m521a != null) {
                String str = m521a.get(Constants.ASSEMBLE_PUSH_REG_INFO);
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                if (str.contains("brand:" + ag.c.name())) {
                    com.xiaomi.channel.commonutils.logger.b.m105a("ASSEMBLE_PUSH : receive fcm token sync ack");
                    i.b(this.f78a, e.b, str);
                    j = iaVar.f607a;
                    eVar = e.b;
                } else {
                    if (str.contains("brand:" + ag.a.name())) {
                        com.xiaomi.channel.commonutils.logger.b.m105a("ASSEMBLE_PUSH : receive hw token sync ack");
                        i.b(this.f78a, e.a, str);
                        j = iaVar.f607a;
                        eVar = e.a;
                    } else {
                        if (str.contains("brand:" + ag.d.name())) {
                            com.xiaomi.channel.commonutils.logger.b.m105a("ASSEMBLE_PUSH : receive COS token sync ack");
                            i.b(this.f78a, e.c, str);
                            j = iaVar.f607a;
                            eVar = e.c;
                        } else {
                            if (!str.contains("brand:" + ag.e.name())) {
                                return;
                            }
                            com.xiaomi.channel.commonutils.logger.b.m105a("ASSEMBLE_PUSH : receive FTOS token sync ack");
                            i.b(this.f78a, e.d, str);
                            j = iaVar.f607a;
                            eVar = e.d;
                        }
                    }
                }
                a(a2, j, eVar);
            }
        }
    }

    private void b(Cif cif) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, this, cif) == null) {
            hw m540a = cif.m540a();
            if (m540a != null) {
                m540a = br.a(m540a.m505a());
            }
            hz hzVar = new hz();
            hzVar.b(cif.m541a());
            hzVar.a(m540a.m506a());
            hzVar.a(m540a.m504a());
            if (!TextUtils.isEmpty(m540a.m511b())) {
                hzVar.c(m540a.m511b());
            }
            hzVar.a(it.a(this.f78a, cif));
            ao.a(this.f78a).a((ao) hzVar, hj.f, false, m540a);
        }
    }

    private void b(ii iiVar) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, this, iiVar) == null) {
            Map<String, String> m556a = iiVar.m556a();
            if (m556a == null) {
                str = "detect failed because null";
            } else {
                String str2 = (String) ay.a(m556a, "pkgList", (Object) null);
                if (!TextUtils.isEmpty(str2)) {
                    try {
                        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) this.f78a.getSystemService("activity")).getRunningAppProcesses();
                        if (com.xiaomi.push.w.a(runningAppProcesses)) {
                            com.xiaomi.channel.commonutils.logger.b.m105a("detect failed because params illegal");
                            return;
                        }
                        String[] split = str2.split(",");
                        HashMap hashMap = new HashMap();
                        for (String str3 : split) {
                            String[] split2 = str3.split(Constants.WAVE_SEPARATOR);
                            if (split2.length >= 2) {
                                hashMap.put(split2[1], split2[0]);
                            }
                        }
                        w.a aVar = new w.a(Constants.WAVE_SEPARATOR, ",");
                        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                            if (hashMap.containsKey(runningAppProcessInfo.processName)) {
                                aVar.a((String) hashMap.get(runningAppProcessInfo.processName), String.valueOf(runningAppProcessInfo.importance));
                                hashMap.remove(runningAppProcessInfo.processName);
                            }
                        }
                        if (aVar.toString().length() <= 0) {
                            com.xiaomi.channel.commonutils.logger.b.b("detect failed because no alive process");
                            return;
                        }
                        ii iiVar2 = new ii();
                        iiVar2.a(iiVar.m555a());
                        iiVar2.b(iiVar.b());
                        iiVar2.d(iiVar.c());
                        iiVar2.c(ht.ag.f529a);
                        HashMap hashMap2 = new HashMap();
                        iiVar2.f668a = hashMap2;
                        hashMap2.put("alive", aVar.toString());
                        if (Boolean.parseBoolean((String) ay.a(m556a, "reportNotAliveApp", "false")) && hashMap.size() > 0) {
                            w.a aVar2 = new w.a("", ",");
                            for (String str4 : hashMap.keySet()) {
                                aVar2.a((String) hashMap.get(str4), "");
                            }
                            iiVar2.f668a.put("notAlive", aVar2.toString());
                        }
                        ao.a(this.f78a).a((ao) iiVar2, hj.i, false, (hw) null);
                        return;
                    } catch (Throwable th) {
                        com.xiaomi.channel.commonutils.logger.b.m105a("detect failed " + th);
                        return;
                    }
                }
                str = "detect failed because empty";
            }
            com.xiaomi.channel.commonutils.logger.b.m105a(str);
        }
    }

    public PushMessageHandler.a a(Intent intent) {
        InterceptResult invokeL;
        String str;
        eo a2;
        String packageName;
        String str2;
        eo a3;
        String packageName2;
        String format;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, intent)) == null) {
            String action = intent.getAction();
            com.xiaomi.channel.commonutils.logger.b.m105a("receive an intent from server, action=" + action);
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
                    eo.a(this.f78a).a(this.f78a.getPackageName(), intent, "12");
                    return null;
                }
                Cif cif = new Cif();
                try {
                    it.a(cif, byteArrayExtra);
                    b m147a = b.m147a(this.f78a);
                    hw m540a = cif.m540a();
                    if (cif.a() == hj.e && m540a != null && !m147a.m158e() && !booleanExtra) {
                        m540a.a("mrt", stringExtra);
                        m540a.a("mat", Long.toString(System.currentTimeMillis()));
                        if (m129a(cif)) {
                            com.xiaomi.channel.commonutils.logger.b.b("this is a mina's message, ack later");
                            m540a.a(Constants.EXTRA_KEY_HYBRID_MESSAGE_TS, String.valueOf(m540a.m504a()));
                            m540a.a(Constants.EXTRA_KEY_HYBRID_DEVICE_STATUS, String.valueOf((int) it.a(this.f78a, cif)));
                        } else {
                            b(cif);
                        }
                    }
                    if (cif.a() == hj.e && !cif.m548b()) {
                        if (com.xiaomi.push.service.al.m685a(cif)) {
                            Object[] objArr = new Object[2];
                            objArr[0] = cif.b();
                            objArr[1] = m540a != null ? m540a.m506a() : "";
                            com.xiaomi.channel.commonutils.logger.b.m105a(String.format("drop an un-encrypted wake-up messages. %1$s, %2$s", objArr));
                            a3 = eo.a(this.f78a);
                            packageName2 = this.f78a.getPackageName();
                            format = String.format("13: %1$s", cif.b());
                        } else {
                            Object[] objArr2 = new Object[2];
                            objArr2[0] = cif.b();
                            objArr2[1] = m540a != null ? m540a.m506a() : "";
                            com.xiaomi.channel.commonutils.logger.b.m105a(String.format("drop an un-encrypted messages. %1$s, %2$s", objArr2));
                            a3 = eo.a(this.f78a);
                            packageName2 = this.f78a.getPackageName();
                            format = String.format("14: %1$s", cif.b());
                        }
                        a3.a(packageName2, intent, format);
                        s.a(this.f78a, cif, booleanExtra);
                        return null;
                    }
                    if (cif.a() == hj.e && cif.m548b() && com.xiaomi.push.service.al.m685a(cif) && (!booleanExtra || m540a == null || m540a.m507a() == null || !m540a.m507a().containsKey("notify_effect"))) {
                        Object[] objArr3 = new Object[2];
                        objArr3[0] = cif.b();
                        objArr3[1] = m540a != null ? m540a.m506a() : "";
                        com.xiaomi.channel.commonutils.logger.b.m105a(String.format("drop a wake-up messages which not has 'notify_effect' attr. %1$s, %2$s", objArr3));
                        eo.a(this.f78a).a(this.f78a.getPackageName(), intent, String.format("25: %1$s", cif.b()));
                        s.b(this.f78a, cif, booleanExtra);
                        return null;
                    }
                    if (m147a.m156c() || cif.f649a == hj.a) {
                        if (!m147a.m156c() || !m147a.m159f()) {
                            return a(cif, booleanExtra, byteArrayExtra, stringExtra2, intExtra, intent);
                        }
                        if (cif.f649a != hj.b) {
                            s.e(this.f78a, cif, booleanExtra);
                            MiPushClient.unregisterPush(this.f78a);
                        } else if (cif.m548b()) {
                            m147a.m149a();
                            MiPushClient.clearExtras(this.f78a);
                            PushMessageHandler.a();
                        } else {
                            com.xiaomi.channel.commonutils.logger.b.d("receiving an un-encrypt unregistration message");
                        }
                    } else if (com.xiaomi.push.service.al.m685a(cif)) {
                        return a(cif, booleanExtra, byteArrayExtra, stringExtra2, intExtra, intent);
                    } else {
                        s.e(this.f78a, cif, booleanExtra);
                        boolean m157d = m147a.m157d();
                        com.xiaomi.channel.commonutils.logger.b.d("receive message without registration. need re-register!registered?" + m157d);
                        eo.a(this.f78a).a(this.f78a.getPackageName(), intent, "15");
                        if (m157d) {
                            a();
                        }
                    }
                } catch (iz e) {
                    e = e;
                    a2 = eo.a(this.f78a);
                    packageName = this.f78a.getPackageName();
                    str2 = "16";
                    a2.a(packageName, intent, str2);
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                    return null;
                } catch (Exception e2) {
                    e = e2;
                    a2 = eo.a(this.f78a);
                    packageName = this.f78a.getPackageName();
                    str2 = "17";
                    a2.a(packageName, intent, str2);
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                    return null;
                }
            } else if ("com.xiaomi.mipush.ERROR".equals(action)) {
                MiPushCommandMessage miPushCommandMessage = new MiPushCommandMessage();
                Cif cif2 = new Cif();
                try {
                    byte[] byteArrayExtra2 = intent.getByteArrayExtra("mipush_payload");
                    if (byteArrayExtra2 != null) {
                        it.a(cif2, byteArrayExtra2);
                    }
                } catch (iz unused) {
                }
                miPushCommandMessage.setCommand(String.valueOf(cif2.a()));
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
                Cif cif3 = new Cif();
                try {
                    it.a(cif3, byteArrayExtra3);
                    b m147a2 = b.m147a(this.f78a);
                    if (com.xiaomi.push.service.al.m685a(cif3)) {
                        str = "message arrived: receive ignore reg message, ignore!";
                    } else if (!m147a2.m156c()) {
                        str = "message arrived: receive message without registration. need unregister or re-register!";
                    } else if (!m147a2.m156c() || !m147a2.m159f()) {
                        return a(cif3, byteArrayExtra3);
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
        return (PushMessageHandler.a) invokeL.objValue;
    }

    public List<String> a(TimeZone timeZone, TimeZone timeZone2, List<String> list) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, timeZone, timeZone2, list)) == null) {
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
        return (List) invokeLLL.objValue;
    }
}
