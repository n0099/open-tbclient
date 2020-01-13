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
public class ax {
    private static ax a;

    /* renamed from: a  reason: collision with other field name */
    private static String f879a = null;

    /* renamed from: a  reason: collision with other field name */
    private Context f880a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f883a;
    private Messenger b;

    /* renamed from: a  reason: collision with other field name */
    private List<Message> f882a = new ArrayList();

    /* renamed from: b  reason: collision with other field name */
    private boolean f884b = false;

    /* renamed from: a  reason: collision with other field name */
    private Messenger f881a = new Messenger(new ay(this, Looper.getMainLooper()));

    private ax(Context context) {
        this.f883a = false;
        this.f880a = context.getApplicationContext();
        if (a()) {
            com.xiaomi.channel.commonutils.logger.b.c("use miui push service");
            this.f883a = true;
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
    private synchronized void m519a(Intent intent) {
        if (this.f884b) {
            Message a2 = a(intent);
            if (this.f882a.size() >= 50) {
                this.f882a.remove(0);
            }
            this.f882a.add(a2);
        } else if (this.b == null) {
            Context context = this.f880a;
            az azVar = new az(this);
            Context context2 = this.f880a;
            context.bindService(intent, azVar, 1);
            this.f884b = true;
            this.f882a.clear();
            this.f882a.add(a(intent));
        } else {
            try {
                this.b.send(a(intent));
            } catch (RemoteException e) {
                this.b = null;
                this.f884b = false;
            }
        }
    }

    private boolean a() {
        if (com.xiaomi.push.ab.e) {
            return false;
        }
        try {
            PackageInfo packageInfo = this.f880a.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4);
            if (packageInfo != null) {
                return packageInfo.versionCode >= 104;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m520a(Intent intent) {
        try {
            if (com.xiaomi.push.l.m478a() || Build.VERSION.SDK_INT < 26) {
                this.f880a.startService(intent);
            } else {
                m519a(intent);
            }
            return true;
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            return false;
        }
    }
}
