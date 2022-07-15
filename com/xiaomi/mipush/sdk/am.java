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
import com.yy.mobile.framework.revenuesdk.statistics.hiido.eventtype.UVEventType;
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
    public static Object f772a;

    /* renamed from: a  reason: collision with other field name */
    public static Queue<String> f773a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public Context f774a;

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
        f772a = new Object();
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
        this.f774a = applicationContext;
        if (applicationContext == null) {
            this.f774a = context;
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
        String m1247a;
        String str2;
        String str3;
        String str4;
        MiPushMessage miPushMessage;
        eo a3;
        String packageName2;
        String m1247a2;
        int i2;
        String str5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, this, new Object[]{cif, Boolean.valueOf(z), bArr, str, Integer.valueOf(i), intent})) == null) {
            ArrayList arrayList = null;
            try {
                iu a4 = ai.a(this.f774a, cif);
                if (a4 == null) {
                    com.xiaomi.channel.commonutils.logger.b.d("receiving an un-recognized message. " + cif.f1345a);
                    eo.a(this.f774a).b(this.f774a.getPackageName(), en.m1247a(i), str, "18");
                    s.c(this.f774a, cif, z);
                    return null;
                }
                hj a5 = cif.a();
                com.xiaomi.channel.commonutils.logger.b.m1027a("processing a message, action=" + a5);
                switch (an.a[a5.ordinal()]) {
                    case 1:
                        if (!cif.m1411b()) {
                            com.xiaomi.channel.commonutils.logger.b.d("receiving an un-encrypt message(SendMessage).");
                            return null;
                        } else if (b.m1069a(this.f774a).m1080e() && !z) {
                            com.xiaomi.channel.commonutils.logger.b.m1027a("receive a message in pause state. drop it");
                            eo.a(this.f774a).a(this.f774a.getPackageName(), en.m1247a(i), str, "12");
                            return null;
                        } else {
                            im imVar = (im) a4;
                            hv a6 = imVar.a();
                            if (a6 == null) {
                                com.xiaomi.channel.commonutils.logger.b.d("receive an empty message without push content, drop it");
                                eo.a(this.f774a).b(this.f774a.getPackageName(), en.m1247a(i), str, "22");
                                s.d(this.f774a, cif, z);
                                return null;
                            }
                            int intExtra = intent.getIntExtra("notification_click_button", 0);
                            if (z) {
                                if (com.xiaomi.push.service.al.m1547a(cif)) {
                                    MiPushClient.reportIgnoreRegMessageClicked(this.f774a, a6.m1361a(), cif.m1403a(), cif.f1352b, a6.b());
                                } else {
                                    hw hwVar = cif.m1403a() != null ? new hw(cif.m1403a()) : new hw();
                                    if (hwVar.m1370a() == null) {
                                        hwVar.a(new HashMap());
                                    }
                                    hwVar.m1370a().put("notification_click_button", String.valueOf(intExtra));
                                    MiPushClient.reportMessageClicked(this.f774a, a6.m1361a(), hwVar, a6.b());
                                }
                            }
                            if (!z) {
                                if (!TextUtils.isEmpty(imVar.d()) && MiPushClient.aliasSetTime(this.f774a, imVar.d()) < 0) {
                                    MiPushClient.addAlias(this.f774a, imVar.d());
                                } else if (!TextUtils.isEmpty(imVar.c()) && MiPushClient.topicSubscribedTime(this.f774a, imVar.c()) < 0) {
                                    MiPushClient.addTopic(this.f774a, imVar.c());
                                }
                            }
                            hw hwVar2 = cif.f1346a;
                            if (hwVar2 == null || hwVar2.m1370a() == null) {
                                str3 = null;
                                str4 = null;
                            } else {
                                str3 = cif.f1346a.f1260a.get("jobkey");
                                str4 = str3;
                            }
                            if (TextUtils.isEmpty(str3)) {
                                str3 = a6.m1361a();
                            }
                            if (z || !m1050a(this.f774a, str3)) {
                                MiPushMessage generateMessage = PushMessageHelper.generateMessage(imVar, cif.m1403a(), z);
                                if (generateMessage.getPassThrough() == 0 && !z && com.xiaomi.push.service.al.m1548a(generateMessage.getExtra())) {
                                    com.xiaomi.push.service.al.m1543a(this.f774a, cif, bArr);
                                    return null;
                                }
                                com.xiaomi.channel.commonutils.logger.b.m1027a("receive a message, msgid=" + a6.m1361a() + ", jobkey=" + str3 + ", btn=" + intExtra);
                                String a7 = com.xiaomi.push.service.al.a(generateMessage.getExtra(), intExtra);
                                if (z && generateMessage.getExtra() != null && !TextUtils.isEmpty(a7)) {
                                    Map<String, String> extra = generateMessage.getExtra();
                                    if (intExtra != 0 && cif.m1403a() != null) {
                                        ao.a(this.f774a).a(cif.m1403a().c(), intExtra);
                                    }
                                    if (com.xiaomi.push.service.al.m1547a(cif)) {
                                        Intent a8 = a(this.f774a, cif.f1352b, extra, intExtra);
                                        a8.putExtra("eventMessageType", i);
                                        a8.putExtra(MiPushMessage.KEY_MESSAGE_ID, str);
                                        a8.putExtra("jobkey", str4);
                                        if (a8 == null) {
                                            com.xiaomi.channel.commonutils.logger.b.m1027a("Getting Intent fail from ignore reg message. ");
                                            eo.a(this.f774a).b(this.f774a.getPackageName(), en.m1247a(i), str, "23");
                                            return null;
                                        }
                                        String c = a6.c();
                                        if (!TextUtils.isEmpty(c)) {
                                            a8.putExtra("payload", c);
                                        }
                                        this.f774a.startActivity(a8);
                                        s.a(this.f774a, cif);
                                        eo.a(this.f774a).a(this.f774a.getPackageName(), en.m1247a(i), str, 3006, a7);
                                        return null;
                                    }
                                    Context context = this.f774a;
                                    Intent a9 = a(context, context.getPackageName(), extra, intExtra);
                                    if (a9 != null) {
                                        if (!a7.equals(bk.c)) {
                                            a9.putExtra(PushMessageHelper.KEY_MESSAGE, generateMessage);
                                            a9.putExtra("eventMessageType", i);
                                            a9.putExtra(MiPushMessage.KEY_MESSAGE_ID, str);
                                            a9.putExtra("jobkey", str4);
                                        }
                                        this.f774a.startActivity(a9);
                                        s.a(this.f774a, cif);
                                        com.xiaomi.channel.commonutils.logger.b.m1027a("start activity succ");
                                        eo.a(this.f774a).a(this.f774a.getPackageName(), en.m1247a(i), str, 1006, a7);
                                        if (a7.equals(bk.c)) {
                                            eo.a(this.f774a).a(this.f774a.getPackageName(), en.m1247a(i), str, "13");
                                            return null;
                                        }
                                        return null;
                                    }
                                    return null;
                                }
                                miPushMessage = generateMessage;
                            } else {
                                com.xiaomi.channel.commonutils.logger.b.m1027a("drop a duplicate message, key=" + str3);
                                eo a10 = eo.a(this.f774a);
                                String packageName3 = this.f774a.getPackageName();
                                String m1247a3 = en.m1247a(i);
                                a10.c(packageName3, m1247a3, str, "2:" + str3);
                                miPushMessage = null;
                            }
                            if (cif.m1403a() == null && !z) {
                                a(imVar, cif);
                            }
                            return miPushMessage;
                        }
                    case 2:
                        ik ikVar = (ik) a4;
                        String str6 = b.m1069a(this.f774a).f790a;
                        if (TextUtils.isEmpty(str6) || !TextUtils.equals(str6, ikVar.m1432a())) {
                            com.xiaomi.channel.commonutils.logger.b.m1027a("bad Registration result:");
                            eo.a(this.f774a).b(this.f774a.getPackageName(), en.m1247a(i), str, "21");
                            return null;
                        }
                        b.m1069a(this.f774a).f790a = null;
                        int i3 = (ikVar.f1408a > 0L ? 1 : (ikVar.f1408a == 0L ? 0 : -1));
                        Context context2 = this.f774a;
                        if (i3 == 0) {
                            b.m1069a(context2).b(ikVar.f1420e, ikVar.f1421f, ikVar.f1427l);
                            FCMPushHelper.persistIfXmsfSupDecrypt(this.f774a);
                            a3 = eo.a(this.f774a);
                            packageName2 = this.f774a.getPackageName();
                            m1247a2 = en.m1247a(i);
                            i2 = 6006;
                            str5 = "1";
                        } else {
                            a3 = eo.a(context2);
                            packageName2 = this.f774a.getPackageName();
                            m1247a2 = en.m1247a(i);
                            i2 = 6006;
                            str5 = "2";
                        }
                        a3.a(packageName2, m1247a2, str, i2, str5);
                        if (!TextUtils.isEmpty(ikVar.f1420e)) {
                            arrayList = new ArrayList();
                            arrayList.add(ikVar.f1420e);
                        }
                        MiPushCommandMessage generateCommandMessage = PushMessageHelper.generateCommandMessage(ey.a.f1053a, arrayList, ikVar.f1408a, ikVar.f1419d, null, ikVar.m1433a());
                        ao.a(this.f774a).m1067d();
                        return generateCommandMessage;
                    case 3:
                        if (!cif.m1411b()) {
                            com.xiaomi.channel.commonutils.logger.b.d("receiving an un-encrypt message(UnRegistration).");
                            return null;
                        }
                        if (((iq) a4).f1486a == 0) {
                            b.m1069a(this.f774a).m1071a();
                            MiPushClient.clearExtras(this.f774a);
                        }
                        PushMessageHandler.a();
                        break;
                    case 4:
                        io ioVar = (io) a4;
                        if (ioVar.f1461a == 0) {
                            MiPushClient.addTopic(this.f774a, ioVar.b());
                        }
                        if (!TextUtils.isEmpty(ioVar.b())) {
                            arrayList = new ArrayList();
                            arrayList.add(ioVar.b());
                        }
                        com.xiaomi.channel.commonutils.logger.b.e("resp-cmd:" + ey.g + StringUtil.ARRAY_ELEMENT_SEPARATOR + ioVar.a());
                        return PushMessageHelper.generateCommandMessage(ey.g.f1053a, arrayList, ioVar.f1461a, ioVar.f1467d, ioVar.c(), null);
                    case 5:
                        is isVar = (is) a4;
                        if (isVar.f1506a == 0) {
                            MiPushClient.removeTopic(this.f774a, isVar.b());
                        }
                        if (!TextUtils.isEmpty(isVar.b())) {
                            arrayList = new ArrayList();
                            arrayList.add(isVar.b());
                        }
                        com.xiaomi.channel.commonutils.logger.b.e("resp-cmd:" + ey.h + StringUtil.ARRAY_ELEMENT_SEPARATOR + isVar.a());
                        return PushMessageHelper.generateCommandMessage(ey.h.f1053a, arrayList, isVar.f1506a, isVar.f1512d, isVar.c(), null);
                    case 6:
                        db.a(this.f774a.getPackageName(), this.f774a, a4, hj.j, bArr.length);
                        ie ieVar = (ie) a4;
                        String b = ieVar.b();
                        List<String> m1397a = ieVar.m1397a();
                        if (ieVar.f1333a == 0) {
                            if (TextUtils.equals(b, ey.i.f1053a) && m1397a != null && m1397a.size() > 1) {
                                MiPushClient.addAcceptTime(this.f774a, m1397a.get(0), m1397a.get(1));
                                if (BdPlayerProgressView.DEFAULT_TIME_TEXT.equals(m1397a.get(0)) && BdPlayerProgressView.DEFAULT_TIME_TEXT.equals(m1397a.get(1))) {
                                    b.m1069a(this.f774a).a(true);
                                } else {
                                    b.m1069a(this.f774a).a(false);
                                }
                                m1397a = a(TimeZone.getTimeZone("GMT+08"), TimeZone.getDefault(), m1397a);
                            } else if (TextUtils.equals(b, ey.c.f1053a) && m1397a != null && m1397a.size() > 0) {
                                MiPushClient.addAlias(this.f774a, m1397a.get(0));
                            } else if (TextUtils.equals(b, ey.d.f1053a) && m1397a != null && m1397a.size() > 0) {
                                MiPushClient.removeAlias(this.f774a, m1397a.get(0));
                            } else if (TextUtils.equals(b, ey.e.f1053a) && m1397a != null && m1397a.size() > 0) {
                                MiPushClient.addAccount(this.f774a, m1397a.get(0));
                            } else if (TextUtils.equals(b, ey.f.f1053a) && m1397a != null && m1397a.size() > 0) {
                                MiPushClient.removeAccount(this.f774a, m1397a.get(0));
                            } else if (TextUtils.equals(b, ey.j.f1053a)) {
                                return null;
                            }
                        }
                        List<String> list = m1397a;
                        com.xiaomi.channel.commonutils.logger.b.e("resp-cmd:" + b + StringUtil.ARRAY_ELEMENT_SEPARATOR + ieVar.a());
                        return PushMessageHelper.generateCommandMessage(b, list, ieVar.f1333a, ieVar.f1341d, ieVar.c(), null);
                    case 7:
                        db.a(this.f774a.getPackageName(), this.f774a, a4, hj.i, bArr.length);
                        if (a4 instanceof ia) {
                            ia iaVar = (ia) a4;
                            String a11 = iaVar.a();
                            com.xiaomi.channel.commonutils.logger.b.e("resp-type:" + iaVar.b() + ", code:" + iaVar.f1303a + StringUtil.ARRAY_ELEMENT_SEPARATOR + a11);
                            if (ht.E.f1225a.equalsIgnoreCase(iaVar.f1310d)) {
                                if (iaVar.f1303a == 0) {
                                    synchronized (af.class) {
                                        if (af.a(this.f774a).m1049a(a11)) {
                                            af.a(this.f774a).c(a11);
                                            if ("syncing".equals(af.a(this.f774a).a(au.a))) {
                                                af.a(this.f774a).a(au.a, "synced");
                                                MiPushClient.clearNotification(this.f774a);
                                                MiPushClient.clearLocalNotificationType(this.f774a);
                                                PushMessageHandler.a();
                                                ao.a(this.f774a).m1064b();
                                            }
                                        }
                                    }
                                    break;
                                } else if ("syncing".equals(af.a(this.f774a).a(au.a))) {
                                    synchronized (af.class) {
                                        if (af.a(this.f774a).m1049a(a11)) {
                                            if (af.a(this.f774a).a(a11) < 10) {
                                                af.a(this.f774a).b(a11);
                                                ao.a(this.f774a).a(true, a11);
                                            } else {
                                                af.a(this.f774a).c(a11);
                                            }
                                        }
                                    }
                                    break;
                                }
                            } else if (ht.F.f1225a.equalsIgnoreCase(iaVar.f1310d)) {
                                if (iaVar.f1303a == 0) {
                                    synchronized (af.class) {
                                        if (af.a(this.f774a).m1049a(a11)) {
                                            af.a(this.f774a).c(a11);
                                            if ("syncing".equals(af.a(this.f774a).a(au.b))) {
                                                af.a(this.f774a).a(au.b, "synced");
                                            }
                                        }
                                    }
                                    break;
                                } else if ("syncing".equals(af.a(this.f774a).a(au.b))) {
                                    synchronized (af.class) {
                                        if (af.a(this.f774a).m1049a(a11)) {
                                            if (af.a(this.f774a).a(a11) < 10) {
                                                af.a(this.f774a).b(a11);
                                                ao.a(this.f774a).a(false, a11);
                                            } else {
                                                af.a(this.f774a).c(a11);
                                            }
                                        }
                                    }
                                    break;
                                }
                            } else if (ht.N.f1225a.equalsIgnoreCase(iaVar.f1310d)) {
                                b(iaVar);
                                break;
                            } else if (ht.B.f1225a.equalsIgnoreCase(iaVar.f1310d)) {
                                a(iaVar);
                                break;
                            }
                            af.a(this.f774a).c(a11);
                            break;
                        } else if (a4 instanceof ii) {
                            ii iiVar = (ii) a4;
                            if ("registration id expired".equalsIgnoreCase(iiVar.f1369d)) {
                                List<String> allAlias = MiPushClient.getAllAlias(this.f774a);
                                List<String> allTopic = MiPushClient.getAllTopic(this.f774a);
                                List<String> allUserAccount = MiPushClient.getAllUserAccount(this.f774a);
                                String acceptTime = MiPushClient.getAcceptTime(this.f774a);
                                com.xiaomi.channel.commonutils.logger.b.e("resp-type:" + iiVar.f1369d + StringUtil.ARRAY_ELEMENT_SEPARATOR + iiVar.m1418a());
                                MiPushClient.reInitialize(this.f774a, hx.a);
                                for (String str7 : allAlias) {
                                    MiPushClient.removeAlias(this.f774a, str7);
                                    MiPushClient.setAlias(this.f774a, str7, null);
                                }
                                for (String str8 : allTopic) {
                                    MiPushClient.removeTopic(this.f774a, str8);
                                    MiPushClient.subscribe(this.f774a, str8, null);
                                }
                                for (String str9 : allUserAccount) {
                                    MiPushClient.removeAccount(this.f774a, str9);
                                    MiPushClient.setUserAccount(this.f774a, str9, null);
                                }
                                String[] split = acceptTime.split(",");
                                if (split.length == 2) {
                                    MiPushClient.removeAcceptTime(this.f774a);
                                    MiPushClient.addAcceptTime(this.f774a, split[0], split[1]);
                                    break;
                                }
                            } else if (ht.h.f1225a.equalsIgnoreCase(iiVar.f1369d)) {
                                if (iiVar.m1419a() != null && iiVar.m1419a().containsKey("app_version")) {
                                    b.m1069a(this.f774a).m1072a(iiVar.m1419a().get("app_version"));
                                    break;
                                }
                            } else if (ht.m.f1225a.equalsIgnoreCase(iiVar.f1369d)) {
                                if (cif.m1411b() && iiVar.m1419a() != null && iiVar.m1419a().containsKey("awake_info")) {
                                    Context context3 = this.f774a;
                                    o.a(context3, b.m1069a(context3).m1070a(), ba.a(this.f774a).a(ho.aF.a(), 0), iiVar.m1419a().get("awake_info"));
                                    break;
                                }
                            } else {
                                try {
                                    if (ht.n.f1225a.equalsIgnoreCase(iiVar.f1369d)) {
                                        ih ihVar = new ih();
                                        it.a(ihVar, iiVar.m1424a());
                                        bb.a(ba.a(this.f774a), ihVar);
                                    } else if (ht.o.f1225a.equalsIgnoreCase(iiVar.f1369d)) {
                                        ig igVar = new ig();
                                        it.a(igVar, iiVar.m1424a());
                                        bb.a(ba.a(this.f774a), igVar);
                                    } else if (ht.w.f1225a.equalsIgnoreCase(iiVar.f1369d)) {
                                        av.a(this.f774a, iiVar);
                                        break;
                                    } else if (ht.x.f1225a.equalsIgnoreCase(iiVar.f1369d)) {
                                        com.xiaomi.channel.commonutils.logger.b.m1027a("receive force sync notification");
                                        av.a(this.f774a, false);
                                        break;
                                    } else if (ht.C.f1225a.equals(iiVar.f1369d)) {
                                        com.xiaomi.channel.commonutils.logger.b.e("resp-type:" + iiVar.f1369d + StringUtil.ARRAY_ELEMENT_SEPARATOR + iiVar.m1418a());
                                        if (iiVar.m1419a() != null) {
                                            int i4 = -2;
                                            if (iiVar.m1419a().containsKey(bk.M)) {
                                                String str10 = iiVar.m1419a().get(bk.M);
                                                if (!TextUtils.isEmpty(str10)) {
                                                    try {
                                                        i4 = Integer.parseInt(str10);
                                                    } catch (NumberFormatException e) {
                                                        e.printStackTrace();
                                                    }
                                                }
                                            }
                                            if (i4 >= -1) {
                                                MiPushClient.clearNotification(this.f774a, i4);
                                            } else {
                                                MiPushClient.clearNotification(this.f774a, iiVar.m1419a().containsKey(bk.K) ? iiVar.m1419a().get(bk.K) : "", iiVar.m1419a().containsKey(bk.L) ? iiVar.m1419a().get(bk.L) : "");
                                            }
                                        }
                                        a(iiVar);
                                        break;
                                    } else {
                                        try {
                                            if (ht.K.f1225a.equals(iiVar.f1369d)) {
                                                ik ikVar2 = new ik();
                                                it.a(ikVar2, iiVar.m1424a());
                                                MiPushClient4Hybrid.onReceiveRegisterResult(this.f774a, ikVar2);
                                            } else if (ht.M.f1225a.equals(iiVar.f1369d)) {
                                                iq iqVar = new iq();
                                                it.a(iqVar, iiVar.m1424a());
                                                MiPushClient4Hybrid.onReceiveUnregisterResult(this.f774a, iqVar);
                                            } else if (!ht.P.f1225a.equals(iiVar.f1369d)) {
                                                if (ht.af.f1225a.equals(iiVar.f1369d)) {
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
                a2 = eo.a(this.f774a);
                packageName = this.f774a.getPackageName();
                m1247a = en.m1247a(i);
                str2 = "19";
                a2.b(packageName, m1247a, str, str2);
                s.c(this.f774a, cif, z);
                return null;
            } catch (iz e4) {
                com.xiaomi.channel.commonutils.logger.b.a(e4);
                com.xiaomi.channel.commonutils.logger.b.d("receive a message which action string is not valid. is the reg expired?");
                a2 = eo.a(this.f774a);
                packageName = this.f774a.getPackageName();
                m1247a = en.m1247a(i);
                str2 = UVEventType.PAY_WALLET_BANNER_SHOW;
                a2.b(packageName, m1247a, str, str2);
                s.c(this.f774a, cif, z);
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
                a2 = ai.a(this.f774a, cif);
            } catch (u e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
                str = "message arrived: receive a message but decrypt failed. report when click.";
            } catch (iz e2) {
                com.xiaomi.channel.commonutils.logger.b.a(e2);
                str = "message arrived: receive a message which action string is not valid. is the reg expired?";
            }
            if (a2 == null) {
                com.xiaomi.channel.commonutils.logger.b.d("message arrived: receiving an un-recognized message. " + cif.f1345a);
                return null;
            }
            hj a3 = cif.a();
            com.xiaomi.channel.commonutils.logger.b.m1027a("message arrived: processing an arrived message, action=" + a3);
            if (an.a[a3.ordinal()] != 1) {
                return null;
            }
            if (cif.m1411b()) {
                im imVar = (im) a2;
                hv a4 = imVar.a();
                if (a4 != null) {
                    hw hwVar = cif.f1346a;
                    if (hwVar != null && hwVar.m1370a() != null) {
                        str2 = cif.f1346a.f1260a.get("jobkey");
                    }
                    MiPushMessage generateMessage = PushMessageHelper.generateMessage(imVar, cif.m1403a(), false);
                    generateMessage.setArrivedMessage(true);
                    com.xiaomi.channel.commonutils.logger.b.m1027a("message arrived: receive a message, msgid=" + a4.m1361a() + ", jobkey=" + str2);
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
            SharedPreferences sharedPreferences = this.f774a.getSharedPreferences("mipush_extra", 0);
            long currentTimeMillis = System.currentTimeMillis();
            if (Math.abs(currentTimeMillis - sharedPreferences.getLong(Constants.SP_KEY_LAST_REINITIALIZE, 0L)) > FlushManager.ReportTimer.DEFAULT_INTERVAL) {
                MiPushClient.reInitialize(this.f774a, hx.b);
                sharedPreferences.edit().putLong(Constants.SP_KEY_LAST_REINITIALIZE, currentTimeMillis).commit();
            }
        }
    }

    public static void a(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, context, str) == null) {
            synchronized (f772a) {
                f773a.remove(str);
                b.m1069a(context);
                SharedPreferences a2 = b.a(context);
                String a3 = bp.a(f773a, ",");
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
            Map<String, String> m1384a = iaVar.m1384a();
            if (m1384a != null) {
                String str = m1384a.get("real_source");
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                com.xiaomi.channel.commonutils.logger.b.b("receive ack : messageId = " + a2 + "  realSource = " + str);
                bx.a(this.f774a).a(a2, str, Boolean.valueOf(iaVar.f1303a == 0));
            }
        }
    }

    private void a(Cif cif) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, this, cif) == null) {
            com.xiaomi.channel.commonutils.logger.b.m1027a("receive a message but decrypt failed. report now.");
            ii iiVar = new ii(cif.m1403a().f1258a, false);
            iiVar.c(ht.u.f1225a);
            iiVar.b(cif.m1404a());
            iiVar.d(cif.f1352b);
            HashMap hashMap = new HashMap();
            iiVar.f1364a = hashMap;
            hashMap.put("regid", MiPushClient.getRegId(this.f774a));
            ao.a(this.f774a).a((ao) iiVar, hj.i, false, (hw) null);
        }
    }

    private void a(ii iiVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, this, iiVar) == null) {
            ia iaVar = new ia();
            iaVar.c(ht.D.f1225a);
            iaVar.a(iiVar.m1418a());
            iaVar.a(iiVar.a());
            iaVar.b(iiVar.b());
            iaVar.e(iiVar.c());
            iaVar.a(0L);
            iaVar.d("success clear push message.");
            ao.a(this.f774a).a(iaVar, hj.i, false, true, null, false, this.f774a.getPackageName(), b.m1069a(this.f774a).m1070a(), false);
        }
    }

    private void a(im imVar, Cif cif) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65547, this, imVar, cif) == null) {
            hw m1403a = cif.m1403a();
            if (m1403a != null) {
                m1403a = br.a(m1403a.m1368a());
            }
            hz hzVar = new hz();
            hzVar.b(imVar.b());
            hzVar.a(imVar.m1441a());
            hzVar.a(imVar.a().a());
            if (!TextUtils.isEmpty(imVar.c())) {
                hzVar.c(imVar.c());
            }
            if (!TextUtils.isEmpty(imVar.d())) {
                hzVar.d(imVar.d());
            }
            hzVar.a(it.a(this.f774a, cif));
            ao.a(this.f774a).a((ao) hzVar, hj.f, m1403a);
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
                if (af.a(this.f774a).m1049a(str)) {
                    af.a(this.f774a).c(str);
                    if ("syncing".equals(af.a(this.f774a).a(a2))) {
                        af.a(this.f774a).a(a2, "synced");
                    }
                }
            }
        } else if (!"syncing".equals(af.a(this.f774a).a(a2))) {
            af.a(this.f774a).c(str);
        } else {
            synchronized (af.class) {
                if (af.a(this.f774a).m1049a(str)) {
                    if (af.a(this.f774a).a(str) < 10) {
                        af.a(this.f774a).b(str);
                        ao.a(this.f774a).a(str, a2, eVar);
                    } else {
                        af.a(this.f774a).c(str);
                    }
                }
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m1050a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65549, null, context, str)) == null) {
            synchronized (f772a) {
                b.m1069a(context);
                SharedPreferences a2 = b.a(context);
                if (f773a == null) {
                    String[] split = a2.getString("pref_msg_ids", "").split(",");
                    f773a = new LinkedList();
                    for (String str2 : split) {
                        f773a.add(str2);
                    }
                }
                if (f773a.contains(str)) {
                    return true;
                }
                f773a.add(str);
                if (f773a.size() > 25) {
                    f773a.poll();
                }
                String a3 = bp.a(f773a, ",");
                SharedPreferences.Editor edit = a2.edit();
                edit.putString("pref_msg_ids", a3);
                com.xiaomi.push.t.a(edit);
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    private boolean m1051a(Cif cif) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, this, cif)) == null) {
            Map<String, String> m1370a = cif.m1403a() == null ? null : cif.m1403a().m1370a();
            if (m1370a == null) {
                return false;
            }
            String str = m1370a.get(Constants.EXTRA_KEY_PUSH_SERVER_ACTION);
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
            Map<String, String> m1384a = iaVar.m1384a();
            if (m1384a != null) {
                String str = m1384a.get(Constants.ASSEMBLE_PUSH_REG_INFO);
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                if (str.contains("brand:" + ag.c.name())) {
                    com.xiaomi.channel.commonutils.logger.b.m1027a("ASSEMBLE_PUSH : receive fcm token sync ack");
                    i.b(this.f774a, e.b, str);
                    j = iaVar.f1303a;
                    eVar = e.b;
                } else {
                    if (str.contains("brand:" + ag.a.name())) {
                        com.xiaomi.channel.commonutils.logger.b.m1027a("ASSEMBLE_PUSH : receive hw token sync ack");
                        i.b(this.f774a, e.a, str);
                        j = iaVar.f1303a;
                        eVar = e.a;
                    } else {
                        if (str.contains("brand:" + ag.d.name())) {
                            com.xiaomi.channel.commonutils.logger.b.m1027a("ASSEMBLE_PUSH : receive COS token sync ack");
                            i.b(this.f774a, e.c, str);
                            j = iaVar.f1303a;
                            eVar = e.c;
                        } else {
                            if (!str.contains("brand:" + ag.e.name())) {
                                return;
                            }
                            com.xiaomi.channel.commonutils.logger.b.m1027a("ASSEMBLE_PUSH : receive FTOS token sync ack");
                            i.b(this.f774a, e.d, str);
                            j = iaVar.f1303a;
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
            hw m1403a = cif.m1403a();
            if (m1403a != null) {
                m1403a = br.a(m1403a.m1368a());
            }
            hz hzVar = new hz();
            hzVar.b(cif.m1404a());
            hzVar.a(m1403a.m1369a());
            hzVar.a(m1403a.m1367a());
            if (!TextUtils.isEmpty(m1403a.m1374b())) {
                hzVar.c(m1403a.m1374b());
            }
            hzVar.a(it.a(this.f774a, cif));
            ao.a(this.f774a).a((ao) hzVar, hj.f, false, m1403a);
        }
    }

    private void b(ii iiVar) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, this, iiVar) == null) {
            Map<String, String> m1419a = iiVar.m1419a();
            if (m1419a == null) {
                str = "detect failed because null";
            } else {
                String str2 = (String) ay.a(m1419a, "pkgList", (Object) null);
                if (!TextUtils.isEmpty(str2)) {
                    try {
                        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) this.f774a.getSystemService("activity")).getRunningAppProcesses();
                        if (com.xiaomi.push.w.a(runningAppProcesses)) {
                            com.xiaomi.channel.commonutils.logger.b.m1027a("detect failed because params illegal");
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
                        iiVar2.a(iiVar.m1418a());
                        iiVar2.b(iiVar.b());
                        iiVar2.d(iiVar.c());
                        iiVar2.c(ht.ag.f1225a);
                        HashMap hashMap2 = new HashMap();
                        iiVar2.f1364a = hashMap2;
                        hashMap2.put("alive", aVar.toString());
                        if (Boolean.parseBoolean((String) ay.a(m1419a, "reportNotAliveApp", "false")) && hashMap.size() > 0) {
                            w.a aVar2 = new w.a("", ",");
                            for (String str4 : hashMap.keySet()) {
                                aVar2.a((String) hashMap.get(str4), "");
                            }
                            iiVar2.f1364a.put("notAlive", aVar2.toString());
                        }
                        ao.a(this.f774a).a((ao) iiVar2, hj.i, false, (hw) null);
                        return;
                    } catch (Throwable th) {
                        com.xiaomi.channel.commonutils.logger.b.m1027a("detect failed " + th);
                        return;
                    }
                }
                str = "detect failed because empty";
            }
            com.xiaomi.channel.commonutils.logger.b.m1027a(str);
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
            com.xiaomi.channel.commonutils.logger.b.m1027a("receive an intent from server, action=" + action);
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
                    eo.a(this.f774a).a(this.f774a.getPackageName(), intent, "12");
                    return null;
                }
                Cif cif = new Cif();
                try {
                    it.a(cif, byteArrayExtra);
                    b m1069a = b.m1069a(this.f774a);
                    hw m1403a = cif.m1403a();
                    if (cif.a() == hj.e && m1403a != null && !m1069a.m1080e() && !booleanExtra) {
                        m1403a.a("mrt", stringExtra);
                        m1403a.a("mat", Long.toString(System.currentTimeMillis()));
                        if (m1051a(cif)) {
                            com.xiaomi.channel.commonutils.logger.b.b("this is a mina's message, ack later");
                            m1403a.a(Constants.EXTRA_KEY_HYBRID_MESSAGE_TS, String.valueOf(m1403a.m1367a()));
                            m1403a.a(Constants.EXTRA_KEY_HYBRID_DEVICE_STATUS, String.valueOf((int) it.a(this.f774a, cif)));
                        } else {
                            b(cif);
                        }
                    }
                    if (cif.a() == hj.e && !cif.m1411b()) {
                        if (com.xiaomi.push.service.al.m1547a(cif)) {
                            Object[] objArr = new Object[2];
                            objArr[0] = cif.b();
                            objArr[1] = m1403a != null ? m1403a.m1369a() : "";
                            com.xiaomi.channel.commonutils.logger.b.m1027a(String.format("drop an un-encrypted wake-up messages. %1$s, %2$s", objArr));
                            a3 = eo.a(this.f774a);
                            packageName2 = this.f774a.getPackageName();
                            format = String.format("13: %1$s", cif.b());
                        } else {
                            Object[] objArr2 = new Object[2];
                            objArr2[0] = cif.b();
                            objArr2[1] = m1403a != null ? m1403a.m1369a() : "";
                            com.xiaomi.channel.commonutils.logger.b.m1027a(String.format("drop an un-encrypted messages. %1$s, %2$s", objArr2));
                            a3 = eo.a(this.f774a);
                            packageName2 = this.f774a.getPackageName();
                            format = String.format("14: %1$s", cif.b());
                        }
                        a3.a(packageName2, intent, format);
                        s.a(this.f774a, cif, booleanExtra);
                        return null;
                    }
                    if (cif.a() == hj.e && cif.m1411b() && com.xiaomi.push.service.al.m1547a(cif) && (!booleanExtra || m1403a == null || m1403a.m1370a() == null || !m1403a.m1370a().containsKey("notify_effect"))) {
                        Object[] objArr3 = new Object[2];
                        objArr3[0] = cif.b();
                        objArr3[1] = m1403a != null ? m1403a.m1369a() : "";
                        com.xiaomi.channel.commonutils.logger.b.m1027a(String.format("drop a wake-up messages which not has 'notify_effect' attr. %1$s, %2$s", objArr3));
                        eo.a(this.f774a).a(this.f774a.getPackageName(), intent, String.format("25: %1$s", cif.b()));
                        s.b(this.f774a, cif, booleanExtra);
                        return null;
                    }
                    if (m1069a.m1078c() || cif.f1345a == hj.a) {
                        if (!m1069a.m1078c() || !m1069a.m1081f()) {
                            return a(cif, booleanExtra, byteArrayExtra, stringExtra2, intExtra, intent);
                        }
                        if (cif.f1345a != hj.b) {
                            s.e(this.f774a, cif, booleanExtra);
                            MiPushClient.unregisterPush(this.f774a);
                        } else if (cif.m1411b()) {
                            m1069a.m1071a();
                            MiPushClient.clearExtras(this.f774a);
                            PushMessageHandler.a();
                        } else {
                            com.xiaomi.channel.commonutils.logger.b.d("receiving an un-encrypt unregistration message");
                        }
                    } else if (com.xiaomi.push.service.al.m1547a(cif)) {
                        return a(cif, booleanExtra, byteArrayExtra, stringExtra2, intExtra, intent);
                    } else {
                        s.e(this.f774a, cif, booleanExtra);
                        boolean m1079d = m1069a.m1079d();
                        com.xiaomi.channel.commonutils.logger.b.d("receive message without registration. need re-register!registered?" + m1079d);
                        eo.a(this.f774a).a(this.f774a.getPackageName(), intent, "15");
                        if (m1079d) {
                            a();
                        }
                    }
                } catch (iz e) {
                    e = e;
                    a2 = eo.a(this.f774a);
                    packageName = this.f774a.getPackageName();
                    str2 = "16";
                    a2.a(packageName, intent, str2);
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                    return null;
                } catch (Exception e2) {
                    e = e2;
                    a2 = eo.a(this.f774a);
                    packageName = this.f774a.getPackageName();
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
                    b m1069a2 = b.m1069a(this.f774a);
                    if (com.xiaomi.push.service.al.m1547a(cif3)) {
                        str = "message arrived: receive ignore reg message, ignore!";
                    } else if (!m1069a2.m1078c()) {
                        str = "message arrived: receive message without registration. need unregister or re-register!";
                    } else if (!m1069a2.m1078c() || !m1069a2.m1081f()) {
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
