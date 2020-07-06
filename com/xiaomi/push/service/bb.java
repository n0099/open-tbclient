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
/* loaded from: classes8.dex */
public class bb {
    private static bb a;

    /* renamed from: a  reason: collision with other field name */
    private static String f883a = null;

    /* renamed from: a  reason: collision with other field name */
    private Context f884a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f887a;
    private Messenger b;

    /* renamed from: a  reason: collision with other field name */
    private List<Message> f886a = new ArrayList();

    /* renamed from: b  reason: collision with other field name */
    private boolean f888b = false;

    /* renamed from: a  reason: collision with other field name */
    private Messenger f885a = new Messenger(new bc(this, Looper.getMainLooper()));

    private bb(Context context) {
        this.f887a = false;
        this.f884a = context.getApplicationContext();
        if (a()) {
            com.xiaomi.channel.commonutils.logger.b.c("use miui push service");
            this.f887a = true;
        }
    }

    private Message a(Intent intent) {
        Message obtain = Message.obtain();
        obtain.what = 17;
        obtain.obj = intent;
        return obtain;
    }

    public static bb a(Context context) {
        if (a == null) {
            a = new bb(context);
        }
        return a;
    }

    /* renamed from: a  reason: collision with other method in class */
    private synchronized void m551a(Intent intent) {
        if (this.f888b) {
            Message a2 = a(intent);
            if (this.f886a.size() >= 50) {
                this.f886a.remove(0);
            }
            this.f886a.add(a2);
        } else if (this.b == null) {
            Context context = this.f884a;
            bd bdVar = new bd(this);
            Context context2 = this.f884a;
            context.bindService(intent, bdVar, 1);
            this.f888b = true;
            this.f886a.clear();
            this.f886a.add(a(intent));
        } else {
            try {
                this.b.send(a(intent));
            } catch (RemoteException e) {
                this.b = null;
                this.f888b = false;
            }
        }
    }

    private boolean a() {
        if (com.xiaomi.push.ab.e) {
            return false;
        }
        try {
            PackageInfo packageInfo = this.f884a.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4);
            if (packageInfo != null) {
                return packageInfo.versionCode >= 104;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m552a(Intent intent) {
        try {
            if (com.xiaomi.push.l.m494a() || Build.VERSION.SDK_INT < 26) {
                this.f884a.startService(intent);
            } else {
                m551a(intent);
            }
            return true;
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            return false;
        }
    }
}
