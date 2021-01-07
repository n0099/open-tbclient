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
    private static bb f14565a;

    /* renamed from: a  reason: collision with other field name */
    private static String f957a = null;

    /* renamed from: a  reason: collision with other field name */
    private Context f958a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f961a;

    /* renamed from: b  reason: collision with root package name */
    private Messenger f14566b;

    /* renamed from: a  reason: collision with other field name */
    private List<Message> f960a = new ArrayList();

    /* renamed from: b  reason: collision with other field name */
    private boolean f962b = false;

    /* renamed from: a  reason: collision with other field name */
    private Messenger f959a = new Messenger(new bc(this, Looper.getMainLooper()));

    private bb(Context context) {
        this.f961a = false;
        this.f958a = context.getApplicationContext();
        if (a()) {
            com.xiaomi.channel.commonutils.logger.b.c("use miui push service");
            this.f961a = true;
        }
    }

    private Message a(Intent intent) {
        Message obtain = Message.obtain();
        obtain.what = 17;
        obtain.obj = intent;
        return obtain;
    }

    public static bb a(Context context) {
        if (f14565a == null) {
            f14565a = new bb(context);
        }
        return f14565a;
    }

    /* renamed from: a  reason: collision with other method in class */
    private synchronized void m587a(Intent intent) {
        if (this.f962b) {
            Message a2 = a(intent);
            if (this.f960a.size() >= 50) {
                this.f960a.remove(0);
            }
            this.f960a.add(a2);
        } else if (this.f14566b == null) {
            Context context = this.f958a;
            bd bdVar = new bd(this);
            Context context2 = this.f958a;
            context.bindService(intent, bdVar, 1);
            this.f962b = true;
            this.f960a.clear();
            this.f960a.add(a(intent));
        } else {
            try {
                this.f14566b.send(a(intent));
            } catch (RemoteException e) {
                this.f14566b = null;
                this.f962b = false;
            }
        }
    }

    private boolean a() {
        if (com.xiaomi.push.ab.e) {
            return false;
        }
        try {
            PackageInfo packageInfo = this.f958a.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4);
            if (packageInfo != null) {
                return packageInfo.versionCode >= 104;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m588a(Intent intent) {
        try {
            if (com.xiaomi.push.l.m530a() || Build.VERSION.SDK_INT < 26) {
                this.f958a.startService(intent);
            } else {
                m587a(intent);
            }
            return true;
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            return false;
        }
    }
}
