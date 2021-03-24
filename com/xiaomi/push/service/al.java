package com.xiaomi.push.service;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationChannel;
import android.content.Context;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import com.xiaomi.push.hk;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@TargetApi(24)
/* loaded from: classes7.dex */
public class al {

    /* renamed from: a  reason: collision with root package name */
    public static al f40944a = new al();

    /* loaded from: classes7.dex */
    public class a {

        /* renamed from: a  reason: collision with other field name */
        public List<b> f885a;

        /* renamed from: b  reason: collision with root package name */
        public List<b> f40946b;

        public a() {
            this.f885a = new ArrayList();
            this.f40946b = new ArrayList();
        }
    }

    /* loaded from: classes7.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public int f40947a;

        /* renamed from: a  reason: collision with other field name */
        public Notification f886a;

        public b(int i, Notification notification) {
            this.f40947a = i;
            this.f886a = notification;
        }

        public String toString() {
            return "id:" + this.f40947a;
        }
    }

    private int a(String str, String str2) {
        return ("GroupSummary" + str + str2).hashCode();
    }

    public static al a() {
        return f40944a;
    }

    private String a(Notification notification) {
        Bundle bundle;
        if (notification == null || (bundle = notification.extras) == null) {
            return null;
        }
        return bundle.getString("push_src_group_name");
    }

    private List<StatusBarNotification> a(ao aoVar) {
        List<StatusBarNotification> m578b = aoVar != null ? aoVar.m578b() : null;
        if (m578b == null || m578b.size() == 0) {
            return null;
        }
        return m578b;
    }

    private void a(Context context, int i, Notification notification, boolean z) {
        String str;
        String a2 = ap.a(notification);
        if (TextUtils.isEmpty(a2)) {
            str = "group auto not extract pkg from notification:" + i;
        } else {
            List<StatusBarNotification> a3 = a(ao.a(context, a2));
            if (a3 != null) {
                String b2 = b(notification);
                HashMap hashMap = new HashMap();
                for (StatusBarNotification statusBarNotification : a3) {
                    if (statusBarNotification.getNotification() != null && statusBarNotification.getId() != i) {
                        a(hashMap, statusBarNotification);
                    }
                }
                for (Map.Entry<String, a> entry : hashMap.entrySet()) {
                    String key = entry.getKey();
                    if (!TextUtils.isEmpty(key)) {
                        a value = entry.getValue();
                        if (z && key.equals(b2) && !m568b(notification)) {
                            (m567a(notification) ? value.f40946b : value.f885a).add(new b(i, notification));
                        }
                        int size = value.f885a.size();
                        if (value.f40946b.size() <= 0) {
                            if (z && size >= 2) {
                                a(context, a2, key, value.f885a.get(0).f886a);
                            }
                        } else if (size <= 0) {
                            a(context, a2, key);
                        }
                    }
                }
                return;
            }
            str = "group auto not get notifications";
        }
        com.xiaomi.channel.commonutils.logger.b.m51a(str);
    }

    private void a(Context context, String str, String str2) {
        com.xiaomi.channel.commonutils.logger.b.b("group cancel summary:" + str2);
        ao.a(context, str).a(a(str, str2));
    }

    private void a(Context context, String str, String str2, Notification notification) {
        Notification.Builder defaults;
        try {
            if (TextUtils.isEmpty(str2)) {
                com.xiaomi.channel.commonutils.logger.b.m51a("group show summary group is null");
                return;
            }
            int a2 = ap.a(context, str);
            if (a2 == 0) {
                com.xiaomi.channel.commonutils.logger.b.m51a("group show summary not get icon from " + str);
                return;
            }
            ao a3 = ao.a(context, str);
            if (Build.VERSION.SDK_INT >= 26) {
                String b2 = a3.b(notification.getChannelId(), "groupSummary");
                NotificationChannel m572a = a3.m572a(b2);
                if ("groupSummary".equals(b2) && m572a == null) {
                    a3.a(new NotificationChannel(b2, "group_summary", 3));
                }
                defaults = new Notification.Builder(context, b2);
            } else {
                defaults = new Notification.Builder(context).setPriority(0).setDefaults(-1);
            }
            ap.a(defaults, true);
            Notification build = defaults.setContentTitle("GroupSummary").setContentText("GroupSummary").setSmallIcon(Icon.createWithResource(str, a2)).setAutoCancel(true).setGroup(str2).setGroupSummary(true).build();
            if (!com.xiaomi.push.l.c() && "com.xiaomi.xmsf".equals(context.getPackageName())) {
                ap.a(build, str);
            }
            int a4 = a(str, str2);
            a3.a(a4, build);
            com.xiaomi.channel.commonutils.logger.b.b("group show summary notify:" + a4);
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.m51a("group show summary error " + e2);
        }
    }

    private void a(Map<String, a> map, StatusBarNotification statusBarNotification) {
        String b2 = b(statusBarNotification.getNotification());
        a aVar = map.get(b2);
        if (aVar == null) {
            aVar = new a();
            map.put(b2, aVar);
        }
        (m567a(statusBarNotification.getNotification()) ? aVar.f40946b : aVar.f885a).add(new b(statusBarNotification.getId(), statusBarNotification.getNotification()));
    }

    /* renamed from: a  reason: collision with other method in class */
    private boolean m566a() {
        return Build.VERSION.SDK_INT >= 24;
    }

    /* renamed from: a  reason: collision with other method in class */
    private boolean m567a(Notification notification) {
        if (notification != null) {
            Object a2 = com.xiaomi.push.bh.a((Object) notification, "isGroupSummary", (Object[]) null);
            if (a2 instanceof Boolean) {
                return ((Boolean) a2).booleanValue();
            }
            return false;
        }
        return false;
    }

    private boolean a(Context context) {
        if (b(context) && ao.m571a(context)) {
            return aq.a(context).a(hk.LatestNotificationNotIntoGroupSwitch.a(), false);
        }
        return false;
    }

    private String b(Notification notification) {
        if (notification == null) {
            return null;
        }
        return m568b(notification) ? a(notification) : notification.getGroup();
    }

    private void b(Context context, int i, Notification notification) {
        String str;
        String a2 = ap.a(notification);
        if (TextUtils.isEmpty(a2)) {
            str = "group restore not extract pkg from notification:" + i;
        } else {
            ao a3 = ao.a(context, a2);
            List<StatusBarNotification> a4 = a(a3);
            if (a4 != null) {
                for (StatusBarNotification statusBarNotification : a4) {
                    Notification notification2 = statusBarNotification.getNotification();
                    if (notification2 != null && m568b(notification2) && statusBarNotification.getId() != i) {
                        Notification.Builder recoverBuilder = Notification.Builder.recoverBuilder(context, statusBarNotification.getNotification());
                        recoverBuilder.setGroup(a(notification2));
                        ap.a(recoverBuilder, m567a(notification2));
                        a3.a(statusBarNotification.getId(), recoverBuilder.build());
                        com.xiaomi.channel.commonutils.logger.b.b("group restore notification:" + statusBarNotification.getId());
                    }
                }
                return;
            }
            str = "group restore not get notifications";
        }
        com.xiaomi.channel.commonutils.logger.b.m51a(str);
    }

    /* renamed from: b  reason: collision with other method in class */
    private boolean m568b(Notification notification) {
        Bundle bundle;
        if (notification == null || notification.getGroup() == null || (bundle = notification.extras) == null) {
            return false;
        }
        return notification.getGroup().equals(String.format("pushmask_%s_%s", Long.valueOf(bundle.getLong("push_src_group_time")), a(notification)));
    }

    private boolean b(Context context) {
        return aq.a(context).a(hk.NotificationAutoGroupSwitch.a(), true);
    }

    public String a(Context context, Notification.Builder builder, String str) {
        if (m566a() && a(context)) {
            long currentTimeMillis = System.currentTimeMillis();
            Bundle extras = builder.getExtras();
            extras.putString("push_src_group_name", str);
            extras.putLong("push_src_group_time", currentTimeMillis);
            return String.format("pushmask_%s_%s", Long.valueOf(currentTimeMillis), str);
        }
        return str;
    }

    public void a(Context context, int i, Notification notification) {
        if (m566a()) {
            if (a(context)) {
                try {
                    b(context, i, notification);
                } catch (Exception e2) {
                    com.xiaomi.channel.commonutils.logger.b.m51a("group notify handle restore error " + e2);
                }
            }
            if (b(context)) {
                try {
                    a(context, i, notification, true);
                } catch (Exception e3) {
                    com.xiaomi.channel.commonutils.logger.b.m51a("group notify handle auto error " + e3);
                }
            }
        }
    }
}
