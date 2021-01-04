package com.xiaomi.push.service;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class bb {

    /* renamed from: a  reason: collision with root package name */
    private static bb f14564a;

    /* renamed from: a  reason: collision with other field name */
    private static String f956a = null;

    /* renamed from: a  reason: collision with other field name */
    private Context f957a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f960a;

    /* renamed from: b  reason: collision with root package name */
    private Messenger f14565b;

    /* renamed from: a  reason: collision with other field name */
    private List<Message> f959a = new ArrayList();

    /* renamed from: b  reason: collision with other field name */
    private boolean f961b = false;

    /* renamed from: a  reason: collision with other field name */
    private Messenger f958a = new Messenger(new bc(this, Looper.getMainLooper()));

    private bb(Context context) {
        this.f960a = false;
        this.f957a = context.getApplicationContext();
        if (a()) {
            com.xiaomi.channel.commonutils.logger.b.c("use miui push service");
            this.f960a = true;
        }
    }

    private Message a(Intent intent) {
        Message obtain = Message.obtain();
        obtain.what = 17;
        obtain.obj = intent;
        return obtain;
    }

    public static bb a(Context context) {
        if (f14564a == null) {
            f14564a = new bb(context);
        }
        return f14564a;
    }

    /* renamed from: a  reason: collision with other method in class */
    private synchronized void m576a(Intent intent) {
        if (this.f961b) {
            Message a2 = a(intent);
            if (this.f959a.size() >= 50) {
                this.f959a.remove(0);
            }
            this.f959a.add(a2);
        } else if (this.f14565b == null) {
            Context context = this.f957a;
            bd bdVar = new bd(this);
            Context context2 = this.f957a;
            context.bindService(intent, bdVar, 1);
            this.f961b = true;
            this.f959a.clear();
            this.f959a.add(a(intent));
        } else {
            try {
                this.f14565b.send(a(intent));
            } catch (RemoteException e) {
                this.f14565b = null;
                this.f961b = false;
            }
        }
    }

    private boolean a() {
        if (com.xiaomi.push.ab.e) {
            return false;
        }
        try {
            PackageInfo packageInfo = this.f957a.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4);
            if (packageInfo != null) {
                return packageInfo.versionCode >= 104;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m577a(Intent intent) {
        try {
            if (com.xiaomi.push.l.m519a() || Build.VERSION.SDK_INT < 26) {
                this.f957a.startService(intent);
            } else {
                m576a(intent);
            }
            return true;
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            return false;
        }
    }
}
