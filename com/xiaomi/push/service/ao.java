package com.xiaomi.push.service;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import com.baidu.android.util.io.ActionJsonData;
import com.xiaomi.push.hk;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.WeakHashMap;
/* loaded from: classes7.dex */
public class ao {

    /* renamed from: a  reason: collision with root package name */
    public static Context f40951a;

    /* renamed from: a  reason: collision with other field name */
    public static Object f890a;

    /* renamed from: a  reason: collision with other field name */
    public static WeakHashMap<Integer, ao> f891a = new WeakHashMap<>();

    /* renamed from: a  reason: collision with other field name */
    public static boolean f892a;

    /* renamed from: a  reason: collision with other field name */
    public String f893a;

    /* renamed from: b  reason: collision with root package name */
    public String f40952b;

    public ao(String str) {
        this.f893a = str;
    }

    public static int a(String str) {
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                return f40951a.getPackageManager().getPackageUid(str, 0);
            } catch (Exception unused) {
                return -1;
            }
        }
        return -1;
    }

    public static NotificationManager a() {
        return (NotificationManager) f40951a.getSystemService(ActionJsonData.TAG_NOTIFICATION);
    }

    public static ao a(Context context, String str) {
        a(context);
        int hashCode = str.hashCode();
        ao aoVar = f891a.get(Integer.valueOf(hashCode));
        if (aoVar == null) {
            ao aoVar2 = new ao(str);
            f891a.put(Integer.valueOf(hashCode), aoVar2);
            return aoVar2;
        }
        return aoVar;
    }

    public static <T> T a(Object obj) {
        if (obj != null) {
            try {
                return (T) obj.getClass().getMethod("getList", new Class[0]).invoke(obj, new Object[0]);
            } catch (Exception unused) {
                return null;
            }
        }
        return null;
    }

    public static Object a(List list) {
        return Class.forName("android.content.pm.ParceledListSlice").getConstructor(List.class).newInstance(list);
    }

    public static String a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String a2 = a("mipush|%s|%s", str2, "");
        return str.startsWith(a2) ? a("mipush_%s_%s", str2, str.replace(a2, "")) : str;
    }

    public static String a(String str, String str2, String str3) {
        return TextUtils.isEmpty(str) ? "" : String.format(str, str2, str3);
    }

    public static void a(Context context) {
        if (f40951a == null) {
            f40951a = context.getApplicationContext();
            NotificationManager a2 = a();
            Boolean bool = (Boolean) com.xiaomi.push.bh.a((Object) a2, "isSystemConditionProviderEnabled", "xmsf_fake_condition_provider_path");
            m569a("fwk is support.init:" + bool);
            boolean booleanValue = bool != null ? bool.booleanValue() : false;
            f892a = booleanValue;
            if (booleanValue) {
                f890a = com.xiaomi.push.bh.a((Object) a2, "getService", new Object[0]);
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m569a(String str) {
        com.xiaomi.channel.commonutils.logger.b.m51a("NMHelper:" + str);
    }

    @TargetApi(26)
    /* renamed from: a  reason: collision with other method in class */
    public static boolean m570a() {
        if (com.xiaomi.push.l.m516a() && aq.a(f40951a).a(hk.NotificationBelongToAppSwitch.a(), true)) {
            return f892a;
        }
        return false;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m571a(Context context) {
        a(context);
        return m570a();
    }

    private String b(String str) {
        return a(m570a() ? "mipush|%s|%s" : "mipush_%s_%s", this.f893a, str);
    }

    @TargetApi(26)
    /* renamed from: a  reason: collision with other method in class */
    public NotificationChannel m572a(String str) {
        NotificationChannel notificationChannel = null;
        try {
            if (m570a()) {
                List<NotificationChannel> m576a = m576a();
                if (m576a != null) {
                    for (NotificationChannel notificationChannel2 : m576a) {
                        if (str.equals(notificationChannel2.getId())) {
                            notificationChannel = notificationChannel2;
                            break;
                        }
                    }
                }
            } else {
                notificationChannel = a().getNotificationChannel(str);
            }
        } catch (Exception e2) {
            m569a("getNotificationChannel error" + e2);
        }
        return notificationChannel;
    }

    /* renamed from: a  reason: collision with other method in class */
    public Context m573a() {
        return f40951a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m574a() {
        return this.f893a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m575a(String str) {
        return TextUtils.isEmpty(str) ? b() : com.xiaomi.push.l.m516a() ? b(str) : str;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:10:0x0036
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    @android.annotation.TargetApi(26)
    /* renamed from: a  reason: collision with other method in class */
    public java.util.List<android.app.NotificationChannel> m576a() {
        /*
            r8 = this;
            java.lang.String r0 = r8.f893a
            r1 = 0
            boolean r2 = m570a()     // Catch: java.lang.Exception -> L78
            if (r2 == 0) goto L3b
            int r2 = a(r0)     // Catch: java.lang.Exception -> L78
            r3 = -1
            if (r2 == r3) goto L39
            java.lang.Object r3 = com.xiaomi.push.service.ao.f890a     // Catch: java.lang.Exception -> L78
            java.lang.String r4 = "getNotificationChannelsForPackage"
            r5 = 3
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch: java.lang.Exception -> L78
            r6 = 0
            r5[r6] = r0     // Catch: java.lang.Exception -> L78
            r6 = 1
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch: java.lang.Exception -> L78
            r5[r6] = r2     // Catch: java.lang.Exception -> L78
            r2 = 2
            java.lang.Boolean r6 = java.lang.Boolean.FALSE     // Catch: java.lang.Exception -> L78
            r5[r2] = r6     // Catch: java.lang.Exception -> L78
            java.lang.Object r2 = com.xiaomi.push.bh.a(r3, r4, r5)     // Catch: java.lang.Exception -> L78
            java.lang.Object r2 = a(r2)     // Catch: java.lang.Exception -> L78
            java.util.List r2 = (java.util.List) r2     // Catch: java.lang.Exception -> L78
            java.lang.String r1 = "mipush|%s|%s"
            r7 = r2
            r2 = r1
            r1 = r7
            goto L45
        L36:
            r0 = move-exception
            r1 = r2
            goto L79
        L39:
            r2 = r1
            goto L45
        L3b:
            android.app.NotificationManager r2 = a()     // Catch: java.lang.Exception -> L78
            java.util.List r1 = r2.getNotificationChannels()     // Catch: java.lang.Exception -> L78
            java.lang.String r2 = "mipush_%s_%s"
        L45:
            boolean r3 = com.xiaomi.push.l.m516a()     // Catch: java.lang.Exception -> L78
            if (r3 == 0) goto L8d
            if (r1 == 0) goto L8d
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch: java.lang.Exception -> L78
            r3.<init>()     // Catch: java.lang.Exception -> L78
            java.lang.String r4 = ""
            java.lang.String r0 = a(r2, r0, r4)     // Catch: java.lang.Exception -> L78
            java.util.Iterator r2 = r1.iterator()     // Catch: java.lang.Exception -> L78
        L5c:
            boolean r4 = r2.hasNext()     // Catch: java.lang.Exception -> L78
            if (r4 == 0) goto L76
            java.lang.Object r4 = r2.next()     // Catch: java.lang.Exception -> L78
            android.app.NotificationChannel r4 = (android.app.NotificationChannel) r4     // Catch: java.lang.Exception -> L78
            java.lang.String r5 = r4.getId()     // Catch: java.lang.Exception -> L78
            boolean r5 = r5.startsWith(r0)     // Catch: java.lang.Exception -> L78
            if (r5 == 0) goto L5c
            r3.add(r4)     // Catch: java.lang.Exception -> L78
            goto L5c
        L76:
            r1 = r3
            goto L8d
        L78:
            r0 = move-exception
        L79:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "getNotificationChannels error "
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            m569a(r0)
        L8d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.ao.m576a():java.util.List");
    }

    public void a(int i) {
        String str = this.f893a;
        try {
            if (!m570a()) {
                a().cancel(i);
                return;
            }
            int a2 = com.xiaomi.push.i.a();
            String packageName = m573a().getPackageName();
            if (Build.VERSION.SDK_INT >= 30) {
                com.xiaomi.push.bh.b(f890a, "cancelNotificationWithTag", str, packageName, null, Integer.valueOf(i), Integer.valueOf(a2));
            } else {
                com.xiaomi.push.bh.b(f890a, "cancelNotificationWithTag", str, null, Integer.valueOf(i), Integer.valueOf(a2));
            }
            m569a("cancel succ:" + i);
        } catch (Exception e2) {
            m569a("cancel error" + e2);
        }
    }

    public void a(int i, Notification notification) {
        String str = this.f893a;
        NotificationManager a2 = a();
        try {
            int i2 = Build.VERSION.SDK_INT;
            if (m570a()) {
                if (i2 >= 19) {
                    notification.extras.putString("xmsf_target_package", str);
                }
                if (i2 >= 29) {
                    a2.notifyAsPackage(str, null, i, notification);
                    return;
                }
            }
            a2.notify(i, notification);
        } catch (Exception unused) {
        }
    }

    @TargetApi(26)
    public void a(NotificationChannel notificationChannel) {
        String str = this.f893a;
        try {
            if (m570a()) {
                int a2 = a(str);
                if (a2 != -1) {
                    com.xiaomi.push.bh.b(f890a, "createNotificationChannelsForPackage", str, Integer.valueOf(a2), a(Arrays.asList(notificationChannel)));
                }
            } else {
                a().createNotificationChannel(notificationChannel);
            }
        } catch (Exception e2) {
            m569a("createNotificationChannel error" + e2);
        }
    }

    public void a(NotificationChannel notificationChannel, boolean z) {
        String str = this.f893a;
        try {
            if (z) {
                int a2 = a(str);
                if (a2 != -1) {
                    com.xiaomi.push.bh.b(f890a, "updateNotificationChannelForPackage", str, Integer.valueOf(a2), notificationChannel);
                }
            } else {
                a(notificationChannel);
            }
        } catch (Exception e2) {
            m569a("updateNotificationChannel error " + e2);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m577a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith(b(""));
    }

    public String b() {
        if (TextUtils.isEmpty(this.f40952b)) {
            this.f40952b = b("default");
        }
        return this.f40952b;
    }

    public String b(String str, String str2) {
        return m570a() ? str : str2;
    }

    @TargetApi(23)
    /* renamed from: b  reason: collision with other method in class */
    public List<StatusBarNotification> m578b() {
        String str = this.f893a;
        NotificationManager a2 = a();
        ArrayList arrayList = null;
        try {
            if (m570a()) {
                int a3 = com.xiaomi.push.i.a();
                if (a3 != -1) {
                    arrayList = (List) a(com.xiaomi.push.bh.a(f890a, "getAppActiveNotifications", str, Integer.valueOf(a3)));
                }
            } else {
                StatusBarNotification[] activeNotifications = a2.getActiveNotifications();
                boolean m516a = com.xiaomi.push.l.m516a();
                if (activeNotifications != null && activeNotifications.length > 0) {
                    ArrayList arrayList2 = new ArrayList();
                    try {
                        for (StatusBarNotification statusBarNotification : activeNotifications) {
                            if (!m516a || str.equals(ap.a(statusBarNotification.getNotification()))) {
                                arrayList2.add(statusBarNotification);
                            }
                        }
                        arrayList = arrayList2;
                    } catch (Exception e2) {
                        e = e2;
                        arrayList = arrayList2;
                        m569a("getActiveNotifications error " + e);
                        return arrayList;
                    }
                }
            }
        } catch (Exception e3) {
            e = e3;
        }
        return arrayList;
    }

    public String toString() {
        return "NotificationManagerHelper{" + this.f893a + "}";
    }
}
