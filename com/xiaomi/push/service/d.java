package com.xiaomi.push.service;

import android.app.Notification;
import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.service.notification.StatusBarNotification;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes10.dex */
public class d {
    public static List<a> a = new CopyOnWriteArrayList();

    /* loaded from: classes10.dex */
    public static class a {
        public final int a;

        /* renamed from: a  reason: collision with other field name */
        public final long f977a;

        /* renamed from: a  reason: collision with other field name */
        public final String f978a;

        /* renamed from: a  reason: collision with other field name */
        public final Notification.Action[] f979a;

        public a(String str, long j, int i, Notification.Action[] actionArr) {
            this.f978a = str;
            this.f977a = j;
            this.a = i;
            this.f979a = actionArr;
        }
    }

    public static void a() {
        for (int size = a.size() - 1; size >= 0; size--) {
            a aVar = a.get(size);
            if (SystemClock.elapsedRealtime() - aVar.f977a > 5000) {
                a.remove(aVar);
            }
        }
        if (a.size() > 10) {
            a.remove(0);
        }
    }

    public static void a(Context context, StatusBarNotification statusBarNotification, int i) {
        if (!com.xiaomi.push.j.m714a(context) || i <= 0 || statusBarNotification == null || Build.VERSION.SDK_INT < 20) {
            return;
        }
        a(new a(statusBarNotification.getKey(), SystemClock.elapsedRealtime(), i, ay.m793a(statusBarNotification.getNotification())));
    }

    public static void a(a aVar) {
        a.add(aVar);
        a();
    }
}
