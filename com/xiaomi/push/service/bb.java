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
/* loaded from: classes18.dex */
public class bb {

    /* renamed from: a  reason: collision with root package name */
    private static bb f5074a;

    /* renamed from: a  reason: collision with other field name */
    private static String f880a = null;

    /* renamed from: a  reason: collision with other field name */
    private Context f881a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f884a;
    private Messenger b;

    /* renamed from: a  reason: collision with other field name */
    private List<Message> f883a = new ArrayList();

    /* renamed from: b  reason: collision with other field name */
    private boolean f885b = false;

    /* renamed from: a  reason: collision with other field name */
    private Messenger f882a = new Messenger(new bc(this, Looper.getMainLooper()));

    private bb(Context context) {
        this.f884a = false;
        this.f881a = context.getApplicationContext();
        if (a()) {
            com.xiaomi.channel.commonutils.logger.b.c("use miui push service");
            this.f884a = true;
        }
    }

    private Message a(Intent intent) {
        Message obtain = Message.obtain();
        obtain.what = 17;
        obtain.obj = intent;
        return obtain;
    }

    public static bb a(Context context) {
        if (f5074a == null) {
            f5074a = new bb(context);
        }
        return f5074a;
    }

    /* renamed from: a  reason: collision with other method in class */
    private synchronized void m560a(Intent intent) {
        if (this.f885b) {
            Message a2 = a(intent);
            if (this.f883a.size() >= 50) {
                this.f883a.remove(0);
            }
            this.f883a.add(a2);
        } else if (this.b == null) {
            Context context = this.f881a;
            bd bdVar = new bd(this);
            Context context2 = this.f881a;
            context.bindService(intent, bdVar, 1);
            this.f885b = true;
            this.f883a.clear();
            this.f883a.add(a(intent));
        } else {
            try {
                this.b.send(a(intent));
            } catch (RemoteException e) {
                this.b = null;
                this.f885b = false;
            }
        }
    }

    private boolean a() {
        if (com.xiaomi.push.ab.e) {
            return false;
        }
        try {
            PackageInfo packageInfo = this.f881a.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4);
            if (packageInfo != null) {
                return packageInfo.versionCode >= 104;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m561a(Intent intent) {
        try {
            if (com.xiaomi.push.l.m503a() || Build.VERSION.SDK_INT < 26) {
                this.f881a.startService(intent);
            } else {
                m560a(intent);
            }
            return true;
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            return false;
        }
    }
}
