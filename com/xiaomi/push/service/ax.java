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
/* loaded from: classes5.dex */
public class ax {
    private static ax a;

    /* renamed from: a  reason: collision with other field name */
    private static String f881a = null;

    /* renamed from: a  reason: collision with other field name */
    private Context f882a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f885a;
    private Messenger b;

    /* renamed from: a  reason: collision with other field name */
    private List<Message> f884a = new ArrayList();

    /* renamed from: b  reason: collision with other field name */
    private boolean f886b = false;

    /* renamed from: a  reason: collision with other field name */
    private Messenger f883a = new Messenger(new ay(this, Looper.getMainLooper()));

    private ax(Context context) {
        this.f885a = false;
        this.f882a = context.getApplicationContext();
        if (a()) {
            com.xiaomi.channel.commonutils.logger.b.c("use miui push service");
            this.f885a = true;
        }
    }

    private Message a(Intent intent) {
        Message obtain = Message.obtain();
        obtain.what = 17;
        obtain.obj = intent;
        return obtain;
    }

    public static ax a(Context context) {
        if (a == null) {
            a = new ax(context);
        }
        return a;
    }

    /* renamed from: a  reason: collision with other method in class */
    private synchronized void m510a(Intent intent) {
        if (this.f886b) {
            Message a2 = a(intent);
            if (this.f884a.size() >= 50) {
                this.f884a.remove(0);
            }
            this.f884a.add(a2);
        } else if (this.b == null) {
            Context context = this.f882a;
            az azVar = new az(this);
            Context context2 = this.f882a;
            context.bindService(intent, azVar, 1);
            this.f886b = true;
            this.f884a.clear();
            this.f884a.add(a(intent));
        } else {
            try {
                this.b.send(a(intent));
            } catch (RemoteException e) {
                this.b = null;
                this.f886b = false;
            }
        }
    }

    private boolean a() {
        if (com.xiaomi.push.ab.e) {
            return false;
        }
        try {
            PackageInfo packageInfo = this.f882a.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4);
            if (packageInfo != null) {
                return packageInfo.versionCode >= 104;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m511a(Intent intent) {
        try {
            if (com.xiaomi.push.l.m469a() || Build.VERSION.SDK_INT < 26) {
                this.f882a.startService(intent);
            } else {
                m510a(intent);
            }
            return true;
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            return false;
        }
    }
}
