package com.xiaomi.push.service;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import com.baidu.android.util.io.ActionJsonData;
import com.xiaomi.push.hr;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
@TargetApi(24)
/* loaded from: classes8.dex */
public class ag {
    private static ag a = new ag();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a {

        /* renamed from: a  reason: collision with other field name */
        List<b> f839a;
        List<b> b;

        private a() {
            this.f839a = new ArrayList();
            this.b = new ArrayList();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class b {
        int a;

        /* renamed from: a  reason: collision with other field name */
        Notification f840a;

        public b(int i, Notification notification) {
            this.a = i;
            this.f840a = notification;
        }

        public String toString() {
            return "id:" + this.a;
        }
    }

    private ag() {
    }

    private int a(String str, String str2) {
        return ("GroupSummary" + str + str2).hashCode();
    }

    private NotificationManager a(Context context) {
        return (NotificationManager) context.getSystemService(ActionJsonData.TAG_NOTIFICATION);
    }

    public static ag a() {
        return a;
    }

    private String a(Notification notification) {
        if (notification == null || notification.extras == null) {
            return null;
        }
        return notification.extras.getString("push_src_group_name");
    }

    private void a(NotificationManager notificationManager, String str, String str2) {
        com.xiaomi.channel.commonutils.logger.b.b("group cancel summary:" + str2);
        notificationManager.cancel(a(str, str2));
    }

    private void a(Context context, int i, Notification notification, boolean z) {
        NotificationManager a2 = a(context);
        StatusBarNotification[] a3 = a(a2);
        if (a3 == null) {
            com.xiaomi.channel.commonutils.logger.b.m50a("group auto not get notifications");
            return;
        }
        String a4 = aj.a(notification);
        if (TextUtils.isEmpty(a4)) {
            com.xiaomi.channel.commonutils.logger.b.m50a("group auto not extract pkg from notification:" + i);
            return;
        }
        String b2 = b(notification);
        HashMap hashMap = new HashMap();
        for (StatusBarNotification statusBarNotification : a3) {
            Notification notification2 = statusBarNotification.getNotification();
            if (notification2 != null && a4.equals(aj.a(notification2)) && statusBarNotification.getId() != i) {
                a(hashMap, statusBarNotification);
            }
        }
        for (Map.Entry<String, a> entry : hashMap.entrySet()) {
            String key = entry.getKey();
            if (!TextUtils.isEmpty(key)) {
                a value = entry.getValue();
                if (z && key.equals(b2) && !m538b(notification)) {
                    b bVar = new b(i, notification);
                    if (m536a(notification)) {
                        value.b.add(bVar);
                    } else {
                        value.f839a.add(bVar);
                    }
                }
                int size = value.f839a.size();
                if (value.b.size() <= 0) {
                    if (size >= 2) {
                        a(context, a2, a4, key);
                    }
                } else if (size <= 0) {
                    a(a2, a4, key);
                } else if (size >= 2 && !m537a(context)) {
                    b bVar2 = value.b.get(0);
                    com.xiaomi.channel.commonutils.logger.b.b("group refresh:" + bVar2);
                    bVar2.f840a.when = System.currentTimeMillis();
                    a2.notify(bVar2.a, bVar2.f840a);
                }
            }
        }
    }

    private void a(Context context, NotificationManager notificationManager, String str, String str2) {
        Notification.Builder defaults;
        try {
            if (TextUtils.isEmpty(str2)) {
                com.xiaomi.channel.commonutils.logger.b.m50a("group show summary group is null");
                return;
            }
            int a2 = aj.a(context, str);
            if (a2 == 0) {
                com.xiaomi.channel.commonutils.logger.b.m50a("group show summary not get icon from " + str);
                return;
            }
            if (Build.VERSION.SDK_INT >= 26) {
                if (notificationManager.getNotificationChannel("groupSummary") == null) {
                    notificationManager.createNotificationChannel(new NotificationChannel("groupSummary", "group_summary", 3));
                }
                defaults = new Notification.Builder(context, "groupSummary");
            } else {
                defaults = new Notification.Builder(context).setPriority(0).setDefaults(-1);
            }
            Notification build = defaults.setContentTitle("GroupSummary").setContentText("GroupSummary").setSmallIcon(Icon.createWithResource(str, a2)).setAutoCancel(true).setGroup(str2).setGroupSummary(true).build();
            if (!com.xiaomi.push.l.c() && "com.xiaomi.xmsf".equals(context.getPackageName())) {
                aj.a(build, str);
            }
            int a3 = a(str, str2);
            notificationManager.notify(a3, build);
            com.xiaomi.channel.commonutils.logger.b.b("group show summary notify:" + a3);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m50a("group show summary error " + e);
        }
    }

    private void a(Map<String, a> map, StatusBarNotification statusBarNotification) {
        String b2 = b(statusBarNotification.getNotification());
        a aVar = map.get(b2);
        if (aVar == null) {
            aVar = new a();
            map.put(b2, aVar);
        }
        b bVar = new b(statusBarNotification.getId(), statusBarNotification.getNotification());
        if (m536a(statusBarNotification.getNotification())) {
            aVar.b.add(bVar);
        } else {
            aVar.f839a.add(bVar);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    private boolean m535a() {
        return Build.VERSION.SDK_INT >= 24;
    }

    /* renamed from: a  reason: collision with other method in class */
    private boolean m536a(Notification notification) {
        if (notification != null) {
            Object a2 = com.xiaomi.push.ba.a(notification, "isGroupSummary", (Object[]) null);
            if (a2 instanceof Boolean) {
                return ((Boolean) a2).booleanValue();
            }
        }
        return false;
    }

    /* renamed from: a  reason: collision with other method in class */
    private boolean m537a(Context context) {
        if (!b(context)) {
        }
        return false;
    }

    private StatusBarNotification[] a(NotificationManager notificationManager) {
        StatusBarNotification[] activeNotifications = notificationManager != null ? notificationManager.getActiveNotifications() : null;
        if (activeNotifications == null || activeNotifications.length == 0) {
            return null;
        }
        return activeNotifications;
    }

    private String b(Notification notification) {
        if (notification == null) {
            return null;
        }
        return m538b(notification) ? a(notification) : notification.getGroup();
    }

    private void b(Context context, int i, Notification notification) {
        NotificationManager a2 = a(context);
        StatusBarNotification[] a3 = a(a2);
        if (a3 == null) {
            com.xiaomi.channel.commonutils.logger.b.m50a("group restore not get notifications");
            return;
        }
        String a4 = aj.a(notification);
        if (TextUtils.isEmpty(a4)) {
            com.xiaomi.channel.commonutils.logger.b.m50a("group restore not extract pkg from notification:" + i);
            return;
        }
        String b2 = b(notification);
        for (StatusBarNotification statusBarNotification : a3) {
            Notification notification2 = statusBarNotification.getNotification();
            if (notification2 != null && a4.equals(aj.a(notification2)) && m538b(notification2) && statusBarNotification.getId() != i) {
                Notification.Builder recoverBuilder = Notification.Builder.recoverBuilder(context, statusBarNotification.getNotification());
                recoverBuilder.setGroup(b2);
                a2.notify(statusBarNotification.getId(), recoverBuilder.build());
                com.xiaomi.channel.commonutils.logger.b.b("group restore notification:" + statusBarNotification.getId());
            }
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    private boolean m538b(Notification notification) {
        if (notification == null || notification.getGroup() == null || notification.extras == null) {
            return false;
        }
        long j = notification.extras.getLong("push_src_group_time");
        return notification.getGroup().equals(String.format("pushmask_%s_%s", Long.valueOf(j), a(notification)));
    }

    private boolean b(Context context) {
        return ak.a(context).a(hr.NotificationAutoGroupSwitch.a(), true);
    }

    public String a(Context context, Notification.Builder builder, String str) {
        if (m535a() && m537a(context)) {
            long currentTimeMillis = System.currentTimeMillis();
            Bundle extras = builder.getExtras();
            extras.putString("push_src_group_name", str);
            extras.putLong("push_src_group_time", currentTimeMillis);
            return String.format("pushmask_%s_%s", Long.valueOf(currentTimeMillis), str);
        }
        return str;
    }

    public void a(Context context, int i, Notification notification) {
        if (m535a()) {
            if (m537a(context)) {
                try {
                    b(context, i, notification);
                } catch (Exception e) {
                    com.xiaomi.channel.commonutils.logger.b.m50a("group notify handle restore error " + e);
                }
            }
            if (b(context)) {
                try {
                    a(context, i, notification, true);
                } catch (Exception e2) {
                    com.xiaomi.channel.commonutils.logger.b.m50a("group notify handle auto error " + e2);
                }
            }
        }
    }
}
