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
import com.xiaomi.push.hm;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@TargetApi(24)
/* loaded from: classes8.dex */
public class au {
    public static au a = new au();

    /* loaded from: classes8.dex */
    public class a {

        /* renamed from: a  reason: collision with other field name */
        public List<b> f909a;
        public List<b> b;

        public a() {
            this.f909a = new ArrayList();
            this.b = new ArrayList();
        }
    }

    /* loaded from: classes8.dex */
    public class b {
        public int a;

        /* renamed from: a  reason: collision with other field name */
        public Notification f910a;

        public b(int i, Notification notification) {
            this.a = i;
            this.f910a = notification;
        }

        public String toString() {
            return "id:" + this.a;
        }
    }

    private int a(String str, String str2) {
        return ("GroupSummary" + str + str2).hashCode();
    }

    public static au a() {
        return a;
    }

    private String a(Notification notification) {
        Bundle bundle;
        if (notification == null || (bundle = notification.extras) == null) {
            return null;
        }
        return bundle.getString("push_src_group_name");
    }

    private List<StatusBarNotification> a(ax axVar) {
        List<StatusBarNotification> m706b = axVar != null ? axVar.m706b() : null;
        if (m706b == null || m706b.size() == 0) {
            return null;
        }
        return m706b;
    }

    private void a(Context context, int i, Notification notification, boolean z) {
        String str;
        String c = ay.c(notification);
        if (TextUtils.isEmpty(c)) {
            str = "group auto not extract pkg from notification:" + i;
        } else {
            List<StatusBarNotification> a2 = a(ax.a(context, c));
            if (a2 != null) {
                String b2 = b(notification);
                HashMap hashMap = new HashMap();
                for (StatusBarNotification statusBarNotification : a2) {
                    if (statusBarNotification.getNotification() != null && statusBarNotification.getId() != i) {
                        a(hashMap, statusBarNotification);
                    }
                }
                for (Map.Entry<String, a> entry : hashMap.entrySet()) {
                    String key = entry.getKey();
                    if (!TextUtils.isEmpty(key)) {
                        a value = entry.getValue();
                        if (z && key.equals(b2) && !m695b(notification)) {
                            (m694a(notification) ? value.b : value.f909a).add(new b(i, notification));
                        }
                        int size = value.f909a.size();
                        if (value.b.size() <= 0) {
                            if (z && size >= 2) {
                                a(context, c, key, value.f909a.get(0).f910a);
                            }
                        } else if (size <= 0) {
                            a(context, c, key);
                        }
                    }
                }
                return;
            }
            str = "group auto not get notifications";
        }
        com.xiaomi.channel.commonutils.logger.b.m99a(str);
    }

    private void a(Context context, String str, String str2) {
        com.xiaomi.channel.commonutils.logger.b.b("group cancel summary:" + str2);
        ax.a(context, str).a(a(str, str2));
    }

    private void a(Context context, String str, String str2, Notification notification) {
        Notification.Builder defaults;
        try {
            if (TextUtils.isEmpty(str2)) {
                com.xiaomi.channel.commonutils.logger.b.m99a("group show summary group is null");
                return;
            }
            int a2 = ay.a(context, str);
            if (a2 == 0) {
                com.xiaomi.channel.commonutils.logger.b.m99a("group show summary not get icon from " + str);
                return;
            }
            ax a3 = ax.a(context, str);
            if (Build.VERSION.SDK_INT >= 26) {
                String b2 = a3.b(notification.getChannelId(), "groupSummary");
                NotificationChannel m700a = a3.m700a(b2);
                if ("groupSummary".equals(b2) && m700a == null) {
                    a3.a(new NotificationChannel(b2, "group_summary", 3));
                }
                defaults = new Notification.Builder(context, b2);
            } else {
                defaults = new Notification.Builder(context).setPriority(0).setDefaults(-1);
            }
            ay.a(defaults, true);
            Notification build = defaults.setContentTitle("GroupSummary").setContentText("GroupSummary").setSmallIcon(Icon.createWithResource(str, a2)).setAutoCancel(true).setGroup(str2).setGroupSummary(true).build();
            if (!com.xiaomi.push.j.m634c() && "com.xiaomi.xmsf".equals(context.getPackageName())) {
                ay.m707a(build, str);
            }
            int a4 = a(str, str2);
            a3.a(a4, build);
            com.xiaomi.channel.commonutils.logger.b.b("group show summary notify:" + a4);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m99a("group show summary error " + e);
        }
    }

    private void a(Map<String, a> map, StatusBarNotification statusBarNotification) {
        String b2 = b(statusBarNotification.getNotification());
        a aVar = map.get(b2);
        if (aVar == null) {
            aVar = new a();
            map.put(b2, aVar);
        }
        (m694a(statusBarNotification.getNotification()) ? aVar.b : aVar.f909a).add(new b(statusBarNotification.getId(), statusBarNotification.getNotification()));
    }

    /* renamed from: a  reason: collision with other method in class */
    private boolean m693a() {
        return Build.VERSION.SDK_INT >= 24;
    }

    /* renamed from: a  reason: collision with other method in class */
    private boolean m694a(Notification notification) {
        if (notification != null) {
            Object a2 = com.xiaomi.push.bj.a((Object) notification, "isGroupSummary", (Object[]) null);
            if (a2 instanceof Boolean) {
                return ((Boolean) a2).booleanValue();
            }
            return false;
        }
        return false;
    }

    private boolean a(Context context) {
        if (b(context) && ax.m698a(context)) {
            return ba.a(context).a(hm.LatestNotificationNotIntoGroupSwitch.a(), false);
        }
        return false;
    }

    private String b(Notification notification) {
        if (notification == null) {
            return null;
        }
        return m695b(notification) ? a(notification) : notification.getGroup();
    }

    private void b(Context context, int i, Notification notification) {
        String str;
        String c = ay.c(notification);
        if (TextUtils.isEmpty(c)) {
            str = "group restore not extract pkg from notification:" + i;
        } else {
            ax a2 = ax.a(context, c);
            List<StatusBarNotification> a3 = a(a2);
            if (a3 != null) {
                for (StatusBarNotification statusBarNotification : a3) {
                    Notification notification2 = statusBarNotification.getNotification();
                    if (notification2 != null && m695b(notification2) && statusBarNotification.getId() != i) {
                        Notification.Builder recoverBuilder = Notification.Builder.recoverBuilder(context, statusBarNotification.getNotification());
                        recoverBuilder.setGroup(a(notification2));
                        ay.a(recoverBuilder, m694a(notification2));
                        a2.a(statusBarNotification.getId(), recoverBuilder.build());
                        com.xiaomi.channel.commonutils.logger.b.b("group restore notification:" + statusBarNotification.getId());
                    }
                }
                return;
            }
            str = "group restore not get notifications";
        }
        com.xiaomi.channel.commonutils.logger.b.m99a(str);
    }

    /* renamed from: b  reason: collision with other method in class */
    private boolean m695b(Notification notification) {
        Bundle bundle;
        if (notification == null || notification.getGroup() == null || (bundle = notification.extras) == null) {
            return false;
        }
        return notification.getGroup().equals(String.format("pushmask_%s_%s", Long.valueOf(bundle.getLong("push_src_group_time")), a(notification)));
    }

    private boolean b(Context context) {
        return ba.a(context).a(hm.NotificationAutoGroupSwitch.a(), true);
    }

    public String a(Context context, Notification.Builder builder, String str) {
        if (m693a() && a(context)) {
            long currentTimeMillis = System.currentTimeMillis();
            Bundle extras = builder.getExtras();
            extras.putString("push_src_group_name", str);
            extras.putLong("push_src_group_time", currentTimeMillis);
            return String.format("pushmask_%s_%s", Long.valueOf(currentTimeMillis), str);
        }
        return str;
    }

    public void a(Context context, int i, Notification notification) {
        if (m693a()) {
            if (a(context)) {
                try {
                    b(context, i, notification);
                } catch (Exception e) {
                    com.xiaomi.channel.commonutils.logger.b.m99a("group notify handle restore error " + e);
                }
            }
            if (b(context)) {
                try {
                    a(context, i, notification, true);
                } catch (Exception e2) {
                    com.xiaomi.channel.commonutils.logger.b.m99a("group notify handle auto error " + e2);
                }
            }
        }
    }
}
