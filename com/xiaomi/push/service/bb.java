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
/* loaded from: classes12.dex */
public class bb {

    /* renamed from: a  reason: collision with root package name */
    private static bb f5074a;

    /* renamed from: a  reason: collision with other field name */
    private static String f877a = null;

    /* renamed from: a  reason: collision with other field name */
    private Context f878a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f881a;
    private Messenger b;

    /* renamed from: a  reason: collision with other field name */
    private List<Message> f880a = new ArrayList();

    /* renamed from: b  reason: collision with other field name */
    private boolean f882b = false;

    /* renamed from: a  reason: collision with other field name */
    private Messenger f879a = new Messenger(new bc(this, Looper.getMainLooper()));

    private bb(Context context) {
        this.f881a = false;
        this.f878a = context.getApplicationContext();
        if (a()) {
            com.xiaomi.channel.commonutils.logger.b.c("use miui push service");
            this.f881a = true;
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
    private synchronized void m557a(Intent intent) {
        if (this.f882b) {
            Message a2 = a(intent);
            if (this.f880a.size() >= 50) {
                this.f880a.remove(0);
            }
            this.f880a.add(a2);
        } else if (this.b == null) {
            Context context = this.f878a;
            bd bdVar = new bd(this);
            Context context2 = this.f878a;
            context.bindService(intent, bdVar, 1);
            this.f882b = true;
            this.f880a.clear();
            this.f880a.add(a(intent));
        } else {
            try {
                this.b.send(a(intent));
            } catch (RemoteException e) {
                this.b = null;
                this.f882b = false;
            }
        }
    }

    private boolean a() {
        if (com.xiaomi.push.ab.e) {
            return false;
        }
        try {
            PackageInfo packageInfo = this.f878a.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4);
            if (packageInfo != null) {
                return packageInfo.versionCode >= 104;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m558a(Intent intent) {
        try {
            if (com.xiaomi.push.l.m500a() || Build.VERSION.SDK_INT < 26) {
                this.f878a.startService(intent);
            } else {
                m557a(intent);
            }
            return true;
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            return false;
        }
    }
}
